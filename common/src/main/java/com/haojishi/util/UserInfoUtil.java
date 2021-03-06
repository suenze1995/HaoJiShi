package com.haojishi.util;


public class UserInfoUtil {

    // 1.获取code的请求地址
    public static String Get_Code = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
    public static String getCode(String APPID, String REDIRECT_URI,String SCOPE) {
        return String.format(Get_Code,APPID,REDIRECT_URI,SCOPE);
    }

    // 2.获取Web_access_tokenhttps的请求地址
    public static String Web_access_tokenhttps = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    public static String getWebAccess(String APPID, String SECRET,String CODE) {
        return String.format(Web_access_tokenhttps, APPID, SECRET,CODE);
    }

    // 3.拉取用户信息的请求地址
    public static String User_Message = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
    public static String getUserMessage(String access_token, String openid) {
        return String.format(User_Message, access_token,openid);
    }


//    public static void main(String[] args) {
//        String REDIRECT_URI = "http://wechat.tmqyt.com/url";
//        String SCOPE = "snsapi_login"; // snsapi_userinfo // snsapi_login
//
//        String appId = "wx222e322a20897ea3";
//
//        String getCodeUrl = getCode(appId, REDIRECT_URI, SCOPE);
//        System.out.println("getCodeUrl:"+getCodeUrl);
//    }
}
