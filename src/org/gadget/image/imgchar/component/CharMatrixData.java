package org.gadget.image.imgchar.component;

public class CharMatrixData {
    public char[][] matrix;

    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (char[] arr : matrix) {
            tmp.append(arr).append('\n');
        }
        return tmp.toString();
    }

    private CharMatrixData() {
    }

    public CharMatrixData(int width, int height) {
        matrix = new char[height][width];
    }
}
