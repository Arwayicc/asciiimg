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
        ColorModel cm = buff.getColorModel();
        WritableRaster raster = buff.getRaster();
        ImgMatrixData data = new ImgMatrixData(buff.getWidth(), buff.getHeight());
        // 扫描像素点，取A、R、G、B 值
        for (int y = 0; y < data.height; y++) {
            for (int x = 0; x < data.width; x++) {
                Object inData = raster.getDataElements(x, y, null);
                data.alpha[y][x] = cm.getAlpha(inData) << 24;
                data.red[y][x] = cm.getRed(inData) << 16;
                data.green[y][x] = cm.getGreen(inData) << 8;
                data.blue[y][x] = cm.getBlue(inData);
            }
        }
        return data;
    }

    /**
     * version 1    <br>
     * 初略计算灰度   <br>
     * 算法参考：<a href="https://www.cnblogs.com/zhangjiansheng/p/6925722.html">RGB 转灰度的几种算法</a>
     *
     * @param red   R 值
     * @param green G 值
     * @param blue  B 值
     * @param type  精度
     * @return 灰度
     */
    private static int grayScale(int red, int green, int blue, int type) {
        // Gray = R*0.299 + G*0.587 + B*0.114
        int gray, rrr, ggg, bbb;
        switch (type) {
            // region 精度因数
            case 2:
                rrr = bbb = 1;
                ggg = 2;
                break;
            case 3:
            case 4:
                rrr = 2;
                ggg = 5;
                bbb = 1;
                type = 3;
                break;
            case 5:
                rrr = 9;
                ggg = 19;
                bbb = 4;
                break;
            case 6:
                rrr = 19;
                ggg = 37;
                bbb = 8;
                break;
            case 7:
            case 8:
                rrr = 38;
                ggg = 75;
                bbb = 15;
                type = 7;
                break;
            case 9:
                rrr = 153;
                ggg = 300;
                bbb = 59;
                break;
            case 10:
            case 11:
                rrr = 306;
                ggg = 601;
                bbb = 117;
                type = 10;
                break;
            case 12:
                rrr = 1224;
                ggg = 2405;
                bbb = 467;
                break;
            case 13:
            case 14:
                rrr = 2449;
                ggg = 4809;
                bbb = 934;
                type = 13;
                break;
            case 15:
                rrr = 9797;
                ggg = 19235;
                bbb = 3736;
                break;
            case 16:
                rrr = 19595;
                ggg = 38469;
                bbb = 7472;
                break;
            case 17:
                rrr = 39190;
                ggg = 76939;
                bbb = 14943;
                break;
            case 18:
                rrr = 78381;
                ggg = 153878;
                bbb = 29885;
                break;
            case 19:
            case 20:
                rrr = 156762;
                ggg = 307757;
                bbb = 59769;
                type = 19;
                break;
            // endregion
            default:
                // 异常值
                return -1;
        }
        gray = (red * rrr + green * ggg + blue * bbb) >> type;
        return gray;
    }

    /**
     * 获取灰度矩阵
     *
     * @param type 灰度精度
     * @param img  图像数据
     * @return 灰度矩阵
     */
    static int[][] getGSMatrix(int type, ImgMatrixData img) throws Exception {
        int[][] gsm = new int[img.height][img.width];
        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {
                int red = img.red[y][x];
                int green = img.green[y][x];
                int blue = img.blue[y][x];
                int gs = grayScale(red, green, blue, type);
                if (gs >= 0) {
                    gsm[y][x] = gs;
//                } else {
//                    throw new Exception("图像异常！");
                }
            }
        }
        return gsm;
    }
}
