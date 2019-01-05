package org.gadget.image.pic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图像工具
 * 代码参考：<a href="https://blog.csdn.net/hexiaodiao/article/details/80870896">Java进行图像缩放</a>
 */
public class PicUtil implements PictureI {

    private int width;
    private int height;

    public BufferedImage buff;

    @Override
    public void read(String path) {
        try {
            File image = new File(path);
            if (image.exists()) {
                this.buff = ImageIO.read(image);
                this.width = buff.getWidth();
                this.height = buff.getHeight();
            } else {
                System.err.println("file does'n exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入到画布
     *
     * @param width  画布宽度
     * @param height 画布高度
     * @return 充填后的画布
     */
    private BufferedImage drawImage(int width, int height) {
        // 缩放图像
        Image newImg = buff.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        // 新画布
        BufferedImage newBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取画笔
        Graphics2D gra = newBuff.createGraphics();
        // 将Image对象画在画布上,最后一个参数,ImageObserver:接收有关 Image 信息通知的异步更新接口,没用到直接传空
        gra.drawImage(newImg, 0, 0, null);
        // 释放资源
        gra.dispose();

        return newBuff;
    }

    @Override
    public BufferedImage zoomByScale(double scale) {
        int width = (int) Math.round(scale * this.width);
        int height = (int) Math.round(scale * this.height);
        return drawImage(width, height);
    }

    @Override
    public BufferedImage zoomBySize(int width, int height) {
        return drawImage(width, height);
    }

    /**
     * 封锁无参数实例化
     */
    private PicUtil() {
    }

    /**
     * 实例化的同时读取图像信息
     *
     * @param path 图像路径
     */
    public PicUtil(String path) {
        read(path);
    }
}
