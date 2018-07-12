package com.home.common.web.validate.code.config;

/**
 * 图片验证码相关配置
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-07-12 14:19
 **/
public class ImageCodeProperties extends SmsCodeProperties{

    /**
     * 验证码图片的宽度
     */
    private int width = 67;
    /**
     * 验证码图片的高度
     */
    private int height = 23;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
