package org.gadget.image.component.util;

import org.gadget.image.component.ImgMatrixData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageReader {

    /**
     * 读取图片每一像素点的A,R,G,B 值
     *
     * @param wpx  指定宽度
     * @param hpx  指定高度
     * @param path 图片路径
     * @return ARGB 矩阵
     * @throws Exception 找不到图片、文件类型异常
     */
    public static ImgMatrixData getData(int wpx, int hpx, String path) throws Exception {
        ImgMatrixData data;
        File image = new File(path);
        if (image.exists()) {
            BufferedImage bfimg = ImageIO.read(image);
            data = PixelHandler.getPixelMatrix(wpx, hpx, bfimg);
        } else {
            throw new Exception("file does'n exist");
        }
        return data;
    }
}
