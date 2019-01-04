package org.gadget.image;

import org.gadget.image.component.ImgCharBuilder;
import org.gadget.image.component.ImgMatrixData;

import java.io.File;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            for (String arg : args) {
                System.out.println("arg = " + arg);
            }
            System.out.println("===================\n\n\n");
            ImgCharBuilder builder = new ImgCharBuilder(args[0]);
            try {
//                ImgMatrixData imgData = builder.getImgData();
                String imgChar = builder.getImgChar();
                System.out.println("imgChar = \n" + imgChar);
//                File newImg = new File("E:\\newImg.jpg");
//                if (newImg.exists()) {
//                    newImg.delete();
//                    newImg = new File("E:\\newImg.jpg");
//                } else {
//                    newImg.createNewFile();
//                }
//                FileOutputStream fops = new FileOutputStream(newImg);
//                int n = 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
