package com.home.common.web.validate.code.image;

import com.home.common.web.validate.code.config.ValidateCodeProperties;
import com.home.common.web.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 图形验证码
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2017-11-30 15:09
 **/
@org.springframework.stereotype.Component("imageValidateCodeGenerator")
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private ValidateCodeProperties validateCodeProperties;

    /**
     * 创建验证码图片
     * @param request HttpServletRequest
     * @return ImageCode
     */
    @Override
    public ImageValidateCode generate(ServletWebRequest request) {
        // 图片长
        int width = ServletRequestUtils.getIntParameter(request.getRequest(),"width",validateCodeProperties.getImage().getWidth());
        // 图片高
        int height = ServletRequestUtils.getIntParameter(request.getRequest(),"height",validateCodeProperties.getImage().getHeight());
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String sRand = "";
        for (int i = 0; i < validateCodeProperties.getImage().getLength(); i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageValidateCode(image, sRand);
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
