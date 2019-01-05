package org.gadget.image;

import org.gadget.image.imgchar.component.ImgCharBuilder;

public class Main {

    public static void main(String[] args) {
        imgChar();
    }

    private static void imgChar() {
        String path = "source/PriaseTheSun.jpg";
        ImgCharBuilder builder = new ImgCharBuilder(path);
        builder.setImgCharSize(50, 50);
        try {
            String imgChar = builder.getImgChar();
            System.out.println("imgChar = \n" + imgChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
