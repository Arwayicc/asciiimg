package org.gadget.image.component;

import org.gadget.image.component.util.ImageReader;
import org.gadget.image.component.util.ImgCharHandler;

import java.util.Optional;

public class ImgCharBuilder {

    private String path;
    private int wpx = 0;
    private int hpx = 0;
    private ImgMatrixData imd;
    private CharMatrixData cmd;

    private void read() throws Exception {
        if ((path != null && path.length() > 0) || (wpx > 0 && hpx > 0))
            this.imd = ImageReader.getData(wpx, hpx, path);
        else
            throw new Exception("无效的路径或尺寸");
    }

    public void setImgCharSize(int w, int h) {
        this.wpx = w;
        this.hpx = h;
    }

    public void read(String path) throws Exception {
        this.path = path;
        read();
    }

    public void read(int w, int h, String path) throws Exception {
        setImgCharSize(w, h);
        this.path = path;
        read();
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

    public ImgCharBuilder(int w, int h, String path) {
        setImgCharSize(w, h);
        this.path = path;
    }
}
