package com.home.common.web.validate.code.image;


import com.home.common.web.validate.code.ValidateCode;

import java.awt.image.BufferedImage;

/**
 * 图形验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-05-17 16:40
 **/
public class ImageValidateCode extends ValidateCode {

    /**
     * 图片
     */
    private BufferedImage image;

    /**
     *
     * @param image
     * @param code
     */
    public ImageValidateCode(BufferedImage image, String code) {
        super(code);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
