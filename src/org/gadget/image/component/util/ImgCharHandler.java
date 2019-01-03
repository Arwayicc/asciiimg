package org.gadget.image.component.util;

import org.gadget.image.component.CharMatrixData;
import org.gadget.image.component.ImgMatrixData;

/**
 * 字符图像处理器
 */
public class ImgCharHandler {

//    private int[][] GrayScaleMatrix;
    private final static String index = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ";
    private final static double ratio = index.length() / 256;

    /**
     * 灰度矩阵 转换为 字符矩阵
     *
     * @param cmw 宽度
     * @param cmh 高度
     * @param gsm 灰度矩阵
     * @return 字符矩阵
     */
    private char[][] convGSM(int cmw, int cmh, boolean px, int[][] gsm) {
        // 等比灰度矩阵
        int[][] gsm2;
        // 字符矩阵
        char[][] charMatrix;
        // 宽高比例
        double wp, hp;
        // 字符矩阵长宽、灰度矩阵长宽
        int gsmw, gsmh;
        gsmh = gsm.length;
        gsmw = gsm[0].length;
        // 计算等比灰度矩阵
        if (px) {
            wp = (double) cmw / gsmw;
            hp = (double) cmh / gsmh;
        } else {
            wp = cmw / 100.0;
            hp = cmh / 100.0;
            // 已有宽高比例，计算字符矩阵最大长宽
            cmw = (int) (wp * gsmw);
            cmh = (int) (hp * gsmh);
        }
        // 初始化等比矩阵
        gsm2 = new int[cmh][cmw];
        // 初始化字符矩阵
        charMatrix = new char[cmh][cmw];
        // 计算等比灰度矩阵
        for (int cmy = 0; cmy < cmh; cmy++) {
            for (int cmx = 0; cmx < cmw; cmx++) {
                // 计算一个字符所覆盖的面积中左上与右下坐标
                double x1, y1, x2, y2, sum;
                x1 = cmx * wp;
                y1 = cmy * hp;
                x2 = x1 + wp;
                y2 = y1 + hp;
                sum = 0;
                // 遍历当前索引覆盖的像素
                for (int gsmy = (int) Math.round(y1); gsmy < y2; gsmy++) {
                    for (int gsmx = (int) Math.round(x1); gsmx < x2; gsmx++) {
                        sum += gsm[gsmy][gsmx];
                    }
                }
                // 计算灰度均值，补充等比矩阵
                gsm2[cmy][cmx] = (int) Math.round(sum / ((x2 - x1) * (y2 - y1)));
            }// x of char matrix
        }// y of char matrix
        // 灰度映射字符
        for (int y = 0; y < gsmh; y++) {
            for (int x = 0; x < gsmw; x++) {
                charMatrix[y][x] = index.charAt((int) Math.round(ratio * gsm2[y][x]));
            }
        }
        return charMatrix;
    }

    /**
     * 图像数据转换为字符矩阵
     *
     * @param img 图像信息
     * @return 字符信息
     * @throws Exception 图像信息异常；或精度指定异常
     */
    public CharMatrixData toChatMatrix(ImgMatrixData img) throws Exception {
        // get Gray Scale matrix
        int[][] gsm = PixelHandler.getGSMatrix(16, img);
        // init chat matrix
        CharMatrixData data = new CharMatrixData(img.width, img.height);
        // put data
        data.matrix = convGSM(50, 50, false, gsm);
        return data;
    }
}
