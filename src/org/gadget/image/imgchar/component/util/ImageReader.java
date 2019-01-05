package org.gadget.image.imgchar.component.util;

import org.gadget.image.imgchar.component.ImgMatrixData;
import org.gadget.image.pic.PicUtil;

/**
 * 读取图像，并获得像素矩阵
 * v 1.0
 * 支持按百分比缩放（0.01～1.00）
 * 支持指定宽度、高度缩放（单位：px）
 * <p>
 * TODO 支持按指定字符长度（宽）、行数（高）缩放图像
 */
public class ImageReader {

    /**
     * 读取图片每一像素点的A,R,G,B 值
     *
     * @param scale 指定缩放百分比（0.01 ~ 1.00）
     * @param path  图片路径
     * @return RGB 矩阵
     */
    public static ImgMatrixData getData(double scale, String path) {
        return PixelHandler.getPixelMatrix(new PicUtil(path).zoomByScale(scale));
    }

    /**
     * 读取图片每一像素点的A,R,G,B 值
     *
     * @param width  指定宽度(px)
     * @param height 指定高度(px)
     * @param path   图片路径
     * @return RGB 矩阵
     */
    public static ImgMatrixData getData(int width, int height, String path) {
        return PixelHandler.getPixelMatrix(new PicUtil(path).zoomBySize(width, height));
    }
}
