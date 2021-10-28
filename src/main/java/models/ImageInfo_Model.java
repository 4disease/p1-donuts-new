package models;
import lombok.Getter;


import java.awt.*;
import java.io.*;
import java.awt.image.DataBufferByte;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

import java.io.IOException;


@Getter  // automatic getter, https://projectlombok.org/features/GetterSetter
public class ImageInfo_Model {
    public int height;
    public int width;
    public int[][][] rgbbinary;
    public int[][][] rgbdecimal;
    public int[][][] rgbhex;

    public ImageInfo_Model(BufferedImage img) {
        try {
            width = img.getWidth()/10;
            height = img.getHeight()/10;

            this.rgbbinary = new int[this.height][this.width][3];
            this.rgbdecimal = new int[this.height][this.width][3];
            // this.rgbhex = new String[this.height][this.width];

            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    int pixel = img.getRGB(x, y);
                    Color color = new Color(pixel, true);

                    this.rgbbinary[y][x][0] = this.rgbdecimal[y][x][0] = color.getRed();
                    this.rgbbinary[y][x][1] = this.rgbdecimal[y][x][1] = color.getGreen();
                    this.rgbbinary[y][x][2] = this.rgbdecimal[y][x][2] = color.getBlue();

                    // this.rgbhex[y][x] = Integer.toHexString(color.getRed()) + Integer.toHexString(color.getGreen()) + Integer.toHexString(color.getBlue()) ;
                }
            }

        } catch (Exception ignored) {
        }

    }

    class ImageProperty {
        public String base64Img;
        public BufferedImage img;
        public ImageInfo_Model rgbProperties;

        public int height, width;

        public ImageProperty(BufferedImage _img) {
            try {
                img = _img;
                rgbProperties = new ImageInfo_Model(img);
                width = img.getWidth();
                height = img.getHeight();
                base64Img = toBase64();
            } catch (Exception ignore) {
            }
        }

        public byte[] image_to_pixels() throws IOException {
            return ((DataBufferByte) this.img.getRaster().getDataBuffer()).getData();
        }

        public String toBase64() {
            try {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                OutputStream b64 = Base64.getEncoder().wrap(os);
                ImageIO.write(img, "png", b64);

                return os.toString("UTF-8");
            } catch (Exception ignored) {
            }
            return "";
        }
    }

    public class ImageInfo {
        public String imagefileurl;
        public List<ImageProperty> imginfo_modelList;

        public ImageInfo(String imagefileurl) {
            try {
                this.imagefileurl = imagefileurl;
                this.imginfo_modelList = new ArrayList<>();
            } catch (Exception ignore) {
            }
        }

        public void getOriginalImg() {
            try {
                imginfo_modelList.add(new ImageProperty(ImageIO.read(new URL(this.imagefileurl))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public byte[] Grayscale() {
            try {
                BufferedImage img = ImageIO.read(new URL(this.imagefileurl));
                for (int x = 0; x < img.getWidth(); ++x) {
                    for (int thisx = 0; x < img.getWidth(); ++x) {
                        for (int y = 0; y < img.getHeight(); ++y) {
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

                    imginfo_modelList.add(new ImageProperty(img));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        byte[] pixelgrayscale(byte[] pixelsIn) {
            byte[] newPixelByte = new byte[pixelsIn.length];
            for (int i = 0; i < pixelsIn.length; i += 4) {
                float val = 0;
                for (int y = 1; y < 4; y++) {
                    val += (pixelsIn[i + y] & 0xFF) / 3.0;
                }
                newPixelByte[i] = pixelsIn[i];
                newPixelByte[i + 1] = (byte) val;
                newPixelByte[i + 2] = (byte) val;
                newPixelByte[i + 3] = (byte) val;
            }
            return newPixelByte;
        }

        //public List<ImageInfo_Model>;
    }
}




