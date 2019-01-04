package org.gadget.image.component.util;

import org.gadget.image.component.ImgMatrixData;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

class PixelHandler {

    /**
     * 遍历像素，获取A、R、G、B 的值
     *
     * @param buff 图像数据
     * @return ARGB 矩阵
     */
    static ImgMatrixData getPixelMatrix(BufferedImage buff) {
//        ColorModel cm = buff.getColorModel();
//        WritableRaster raster = buff.getRaster();
        ImgMatrixData data = new ImgMatrixData(buff.getWidth(), buff.getHeight());
        // 扫描像素点，取A、R、G、B 值
        for (int y = 0; y < data.height; y++) {
            for (int x = 0; x < data.width; x++) {
//                Object inData = raster.getDataElements(x, y, null);
//                data.alpha[y][x] = cm.getAlpha(inData) << 24;
//                data.red[y][x] = cm.getRed(inData) << 16;
//                data.green[y][x] = cm.getGreen(inData) << 8;
//                data.blue[y][x] = cm.getBlue(inData);
                int rgb = buff.getRGB(x, y);
                data.alpha[y][x] = (rgb >> 24) & 0xff;
                data.red[y][x] = (rgb >> 16) & 0xff;
                data.green[y][x] = (rgb >> 8) & 0xff;
                data.blue[y][x] = rgb & 0xff;
            }
        }
        return data;
    }

    /**
     * 获取灰度矩阵
     *
     * @param img  图像数据
     * @return 灰度矩阵
     */
    static int[][] getGSMatrix(ImgMatrixData img) throws Exception {
        int[][] gsm = new int[img.height][img.width];
        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                int alpha = img.alpha[y][x];
                int red = (int) Math.round(alpha / 255.0 * img.red[y][x]);
                int blue = (int) Math.round(alpha / 255.0 * img.blue[y][x]);
                int green = (int) Math.round(alpha / 255.0 * img.green[y][x]);
                // Gray = R*0.299 + G*0.587 + B*0.114
                int gs = alpha == 0 ? 0 : (red * 299 + green * 587 + blue * 114 + 500) / 1000;
                if (gs >= 0) {
                    gsm[y][x] = gs;
                } else {
                    throw new Exception("图像异常！");
                }
            }
        }
        return gsm;
    }
}
