package org.gadget.image;

import org.gadget.image.component.ImgCharBuilder;

public class Main {

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            for (String arg : args) {
                System.out.println("arg = " + arg);
            }
            System.out.println("===================\n\n\n");
            ImgCharBuilder builder = new ImgCharBuilder(args[0]);
            try {
                String imgChar = builder.getImgChar();
                System.out.println("imgChar = \n" + imgChar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
