package org.gadget.image.component;

public class CharMatrixData {
    public int width, height;
    public char[][] matrix;

    public String toString() {
        StringBuffer tmp = new StringBuffer();
        for (char[] arr : matrix) {
            tmp.append(arr).append('\n');
        }
        return tmp.toString();
    }

    private CharMatrixData() {
    }

    public CharMatrixData(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }
}
