package org.gadget.image.imgchar.component;

/**
 * R, G, B
 */
public class ImgMatrixData {
    public int width, height;
    public int[][] red, green, blue, gray;

    private ImgMatrixData() {
    }

    public ImgMatrixData(int width, int height) {
        this.width = width;
        this.height = height;
        red = new int[height][width];
        green = new int[height][width];
        blue = new int[height][width];
        gray = new int[height][width];
    }
}
