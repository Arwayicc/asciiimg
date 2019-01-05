package org.gadget.image;

import org.gadget.image.imgchar.component.ImgCharBuilder;

public class Main {

    public static void main(String[] args) {
        imgChar();
    }

    private static void imgChar() {
        ImgCharBuilder builder = new ImgCharBuilder("/home/dong/data/d/files/pictures/头像/PriaseTheSun.jpg");
        builder.setImgCharSize(180, 180);
        try {
            String imgChar = builder.getImgChar();
            System.out.println("imgChar = \n" + imgChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
