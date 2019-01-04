package org.gadget.image.component;

import org.gadget.image.component.util.ImageReader;
import org.gadget.image.component.util.ImgCharHandler;

import java.util.Optional;

public class ImgCharBuilder {

    private String path;
    private ImgMatrixData imd;
    private CharMatrixData cmd;

    private void read() throws Exception {
        if (path != null && path.length() > 0) {
            this.imd = ImageReader.getData(path);
        } else {
            throw new Exception("无效的路径！");
        }
    }

    public void read(String path) throws Exception {
        if (path != null && path.length() > 0) {
            this.path = path;
            read();
        } else {
            throw new Exception("无效的路径！");
        }
    }

    public ImgMatrixData getImgData() {
        return this.imd;
    }

    public String getImgChar() throws Exception {
        Optional<ImgMatrixData> imdOpt = Optional.ofNullable(this.imd);
        ImgCharHandler ich = new ImgCharHandler();
        String imgChar = "憨鸠！出错啦，乜都冇啊！";
        Optional<CharMatrixData> cmdOpt;
        if (!imdOpt.isPresent()) {
            read();
        }
        cmdOpt = Optional.ofNullable(this.cmd = ich.toChatMatrix(this.imd));
        if (cmdOpt.isPresent()) {
            imgChar = this.cmd.toString();
        }
        return imgChar;
    }

    private ImgCharBuilder() {
    }

    public ImgCharBuilder(String path) {
        this.path = path;
    }
}
