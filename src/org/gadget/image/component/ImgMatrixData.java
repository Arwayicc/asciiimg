package org.gadget.image.component;

/**
 * A, R, G, B
 */
public class ImgMatrixData {
    public int width, height;
    public int[][] alpha, red, green, blue;

    private ImgMatrixData() {
    }

    public ImgMatrixData(int width, int height) {
        this.width = width;
        this.height = height;
        alpha = new int[height][width];
        red = new int[height][width];
        green = new int[height][width];
        blue = new int[height][width];
    }
}
