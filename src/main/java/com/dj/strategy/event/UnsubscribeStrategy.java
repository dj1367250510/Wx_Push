package com.dj.strategy.event;

import com.dj.common.WxConstants;
import com.dj.dto.IdentityInfoKey;
import com.dj.observer.WxPublisher;
import com.dj.observer.WxSubscriber;
import com.dj.repository.IdentityInfoRepository;
import com.dj.strategy.WxEventStrategy;
import com.dj.util.WxOpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: dj
 * @Date: 2022/8/31 19:33
 * @Description: 取消订阅活动对应策略
 */
@Service("unsubscribe")
@Slf4j
public class UnsubscribeStrategy implements WxEventStrategy {
    @Resource
    private WxPublisher wxPublisher;

    @Resource
    private IdentityInfoRepository identityInfoRepository;

    @Override
    public void execute(Map<String, String> requestMap, HttpServletResponse response) throws Exception {
        log.info(">>> 事件类型：unsubscribe");
        // 获取取消订阅者信息
        WxSubscriber wxSubscriber = WxOpUtils.getWxSubscriber(requestMap);
        log.info(">>> 用户取消订阅！");
        wxPublisher.detach(wxSubscriber);
        // 数据库中状态修改
        String openId = requestMap.get("FromUserName");
        IdentityInfoKey identityInfoKey = new IdentityInfoKey(WxConstants.APP_ID, WxConstants.APP_SECRET, openId);
        // 修改status为1
        identityInfoRepository.findById(identityInfoKey).ifPresent(identityInfo -> {
            identityInfo.setStatus(1);
            identityInfoRepository.save(identityInfo);
        });
    }
}
