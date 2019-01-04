package org.gadget.image;

import org.gadget.image.component.ImgCharBuilder;

public class Main {

    public static void main(String[] args) {
        ImgCharBuilder builder = new ImgCharBuilder("E:\\tmp\\image\\PriaseTheSun.jpg");
        builder.setImgCharSize(200, 200);
        try {
            String imgChar = builder.getImgChar();
            System.out.println("imgChar = \n" + imgChar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
