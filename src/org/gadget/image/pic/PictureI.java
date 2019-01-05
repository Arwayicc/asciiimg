package org.gadget.image.pic;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 处理图像
 * v 1.0
 *
 * <ul>
 *     <li>读取图像</li>
 *     <li>指定百分比缩放图像</li>
 *     <li>指定宽、高缩放图像</li>
 * </ul>
 */
public interface PictureI {

    /**
     * 读取图像
     * @param path 图像路径
     */
    void read(String path);

    /**
     * 按比例缩放图像
     * @param scale 比例（0.01 ~ 1.00）
     */
    BufferedImage zoomByScale(double scale);

    /**
     * 按指定宽度、高度缩放图像
     * @param width  宽度
     * @param height 高度
     */
    BufferedImage zoomBySize(int width, int height);
}
