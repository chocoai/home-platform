package com.home.common.web.validate.code.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 短信验证码相关配置
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:19
 **/
public class SmsCodeProperties {
    /**
     * 验证码长度
     */
    private int length = 6;
    /**
     * 验证码过期时间
     */
    private int expire = 60;
    /**
     * 需要校验验证码的URL
     */
    private List<String> anon = new ArrayList<>();

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
