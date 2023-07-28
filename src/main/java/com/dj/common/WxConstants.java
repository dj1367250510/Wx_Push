package com.dj.common;

/**
 * @Author: dj
 * @Date: 2022/8/23 18:46
 * @Description: 常量类
 */
public final class WxConstants {
    private WxConstants() {
    }

    /**
     * appId
     */
    public static final String APP_ID = "wx990bf43068d603f3";

    /**
     * appSecret
     */
    public static final String APP_SECRET = "acc66059b98a0e064d5b307cffadca60";

    /**
     * 公众号
     */
    public static final String PUBLIC_ID = "gh_eb82ace7cc02";

    /**
     * token
     */
    public static final String TOKEN = "dj";

    /**
     * 请求api需要的token，开启定时任务，每一个小时获取一次
     */
    public static String accessToken = "";

    /**
     * 请求百度地图相关服务的AK
     */
    public static final String BAI_DU_AK = "iHIiCMKtlM7j1I57CID5HB1sMbdiykyN";

    /**
     * 天行API AK
     */
    public static final String TX_AK = "83dc197c6889fb91d240ac9089c3a98c";

    /**
     * 相识日期
     */
    public static final String MEET_DATE = "2015-03-25";

    /**
     * 客服
     */
    public static String CUSTOMER_SERVICE = "ChatGPT@ChatGPT";
}
