package com.fumei.bg.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author writeanewworld
 */
public class RandomValidateCode {

    private static final Logger LOG = LoggerFactory.getLogger(RandomValidateCode.class);
    private static final int MAX_COLOR_VALUE = 255;
    public static final String CAPTCHA_PREFIX = "captcha:";
    private RedisCache cache = SpringUtils.getBean(RedisCache.class);

    /**
     * 随机产生数字与字母组合的字符串
     */
    private final String randString = "0123456789abcdefghijklmnopqrstuvwxyz";

    /**
     * 图片宽
     */
    private int width = 95;

    /**
     * 图片高
     */
    private int height = 25;

    /**
     * 干扰线数量
     */
    private final int lineSize = 40;

    /**
     * 随机产生字符数量
     */
    private final int stringNum = 4;

    private final Random random = new Random();

    /**
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.BOLD, 18);
    }

    /**
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > MAX_COLOR_VALUE) {
            fc = 255;
        }
        if (bc > MAX_COLOR_VALUE) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public Map<String, String> getRandCode(int width, int height) {
        HashMap<String, String> map = new HashMap<>(2);
        this.height = height;
        this.width = width;
        String uuid = UUIDUtil.randomUUID(true);
        map.put("uuid",uuid);
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        //产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        Graphics g = image.getGraphics();
        //图片大小
        g.fillRect(0, 0, width, height);
        //字体大小
        g.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        //字体颜色
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
        LOG.info(randomString);
        //将生成的随机字符串保存到redis中
        cache.setCacheObject(CAPTCHA_PREFIX + uuid,randomString,1, TimeUnit.MINUTES);
        g.dispose();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", os);
            byte[] bytes = os.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(bytes);
            map.put("captcha", encode);
        } catch (Exception e) {
            LOG.error("将内存中的图片通过流动形式转换Base64失败>>>>   ", e);
        }
        return map;
    }

    /**
     * 绘制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
                .nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString
                .length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /**
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 获取随机的字符
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}