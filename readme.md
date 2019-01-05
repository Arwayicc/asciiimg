# demo
image/picture convert to ASCII-image

****

#### create at 18-12-29 02:54
init

#### update at 19-01-04 02:11
- add
    - ImageReader.java
    - PixelHandler.java
    - ImgMatrixData.java
    - CharMatrixData.java
    - ImgCharBuilder.java
    - ImgCharHandler.java

#### update at 19-01-04 10:55
- update
    - PixelHandler.java
        - 简化灰度计算
    - ImgMatrixData.java
        - 新增灰度矩阵
    - ImgCharHandler.java
        - 简化字符矩阵算法
        - 优化灰度矩阵流转

#### update at 19-01-04 22:09
- update
    - ImgMatrixData.java
        - 移除Alpha矩阵，暂不考虑Alpha通道
    - PixelHandler.java
    - ImgCharBuilder.java
    - ImgCharHandler.java

#### update at 19-01-04 23:47
- update
    - ImageReader.java
    - CharMatrixData.java
    - ImgCharBuilder.java
        - 读入时高度、宽度设置
    - ImgCharHandler.java
        - 按指定px算输出比例，读取等比灰度矩阵
        
#### update at 19-01-05 20:20
- add
    - PicUtil.java
    - PictureI.java
- update
    - PixelHandler.java
        - 简化灰度计算
    - ImageReader.java
        - 可按比例缩放读取的图像
        - 可按指定宽高缩放读取的图像
