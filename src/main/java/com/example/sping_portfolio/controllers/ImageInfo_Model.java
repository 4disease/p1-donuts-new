package com.example.sping_portfolio.controllers;
import lombok.Getter;

import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument;
import javax.validation.constraints.DecimalMax;
import java.io.IOException;


@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class ImageInfo_Model {
    public String file, url;
    public int height;
    public int width;
    public int[][][] rgbbinary;
    public int[][][] rgbdecimal;
    public int[][][] rbghex;

    public String imagefileurl;
    public List<ImageInfo_Model> imginfo_modelList;

    public ImageInfo_Model(String imagefileurl) {
        try {
            this.imagefileurl = imagefileurl;
            this.imginfo_modelList = new ArrayList<>();
        } catch (Exception ignore) {}
}


public ImageInfo_Model(BufferedImage img) {
    }


public byte[] Grayscale() {
    try {
        BufferedImage img = ImageIO.read(new URL(this.imagefileurl));for (int x = 0; x < img.getWidth(); ++x){
            for (int thisx = 0; x < img.getWidth(); ++x){
                for (int y = 0; y < img.getHeight(); ++y)
                {
                    int rgb = img.getRGB(x, y);
                    int r = (rgb >> 16) & 0xFF;
                    int g = (rgb >> 8) & 0xFF;
                    int b = (rgb & 0xFF);

                    // Normalize and gamma correct:
                    float rr = (float) Math.pow(r / 255.0, 2.2);
                    float gg = (float) Math.pow(g / 255.0, 2.2);
                    float bb = (float) Math.pow(b / 255.0, 2.2);

                    // Calculate luminance:
                    float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                    // Gamma compand and rescale to byte range:
                    int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                    int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                    img.setRGB(x, y, gray);
                }
            }

            imginfo_modelList.add(new ImageInfo_Model(img));}}
         catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }

    byte[] pixelgrayscale(byte[] pixelsIn){
        byte[] newPixelByte = new byte[pixelsIn.length];
        for(int i=0;i<pixelsIn.length;i+=4) {
            float val = 0;
            for(int y=1;y<4;y++) {
                val += (pixelsIn[i+y] & 0xFF)/3.0;
            }
            newPixelByte[i] = pixelsIn[i];
            newPixelByte[i+1] = (byte)val;
            newPixelByte[i+2] = (byte)val;
            newPixelByte[i+3] = (byte)val;
        }
        return newPixelByte;
    }

    //public List<ImageInfo_Model>;
    }




