package com.dj.strategy.template;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dj.common.WxConstants;
import com.dj.common.WxTemplateConstants;
import com.dj.dto.IdentityInfo;
import com.dj.strategy.WxTemplateStrategy;
import com.dj.util.WxOpUtils;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: dj
 * @Date: 2022-09-27 22:06
 * @Description: 特殊晚安策略
 */
@Service(WxTemplateConstants.SPECIAL_NIGHT)
public class SpecialNightStrategy implements WxTemplateStrategy {
    @Override
    public void execute(WxMpTemplateMessage wxMpTemplateMessage, IdentityInfo identityInfo) {
        //安慰语录
        String word = "快睡觉觉啦";
        //获得时间
        LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  ❤  HH:mm:ss");
        String time = dateTime.format(formatter);
        //
        String sayUrl = "http://api.tianapi.com/lzmy/index?key=" + WxConstants.TX_AK;
        String sayStr = HttpUtil.get(sayUrl);
        String sayList = JSONObject.parseObject(sayStr).get("newslist").toString();
        String saying = JSONArray.parseArray(sayList).getJSONObject(0).get("saying").toString();
        String title = JSONArray.parseArray(sayList).getJSONObject(0).get("source").toString();
        wxMpTemplateMessage.addData(new WxMpTemplateData("location", identityInfo.getAddress(), "#9370DB"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("saying", saying, "#6699FF"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("title", "《" + title + "》", "#CCFF99"));
        // 相识天数，可以修改为恋爱天数，或者其他纪念意义天数
        Long meetDays = WxOpUtils.countDays(WxConstants.MEET_DATE, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        wxMpTemplateMessage.addData(new WxMpTemplateData("meet_days", String.valueOf(meetDays), "#C000C0"));
        wxMpTemplateMessage.addData(new WxMpTemplateData("word",word));
        wxMpTemplateMessage.addData(new WxMpTemplateData("time",time));

    }
}
