package models.asciiart;
import java.awt.Color;
//import java.awt.FileDialog;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.KeyStroke;
//import models.ImageInfo_Model;
import lombok.Getter;

@Getter 
public class ASCIIArt {
    // The lookup table for all of the chars that can be used
    public static final String GRAYSCALE_CHARS  = "@#BW8gMN6&9RQqE0d$DbpmOa5AH2GZeKPS3X4U%kwohFVyzIsCu{xfn}tJTi17c=jYL?l[]v<>+|)r(/\\*_!;^~\":,-'.`";
    // The lookup table of the brightness of each char, from 0 to 1
    public static final double[] GRAYSCALE_VALUES = {0, 0.07863, 0.08205, 0.1316, 0.1453, 0.147, 0.1504, 0.1641, 0.1761, 0.1761, 0.1778, 0.2017, 0.2154, 0.2274, 0.2274, 0.2291, 0.2427, 0.2598, 0.2615, 0.2684, 0.2752, 0.2769, 0.2889, 0.2923, 0.294, 0.2974, 0.3026, 0.3077, 0.3077, 0.3094, 0.3162, 0.3197, 0.3333, 0.3333, 0.3385, 0.3538, 0.3607, 0.3795, 0.3846, 0.4017, 0.4034, 0.4068, 0.4291, 0.4325, 0.4444, 0.4598, 0.4632, 0.4667, 0.4752, 0.4855, 0.5077, 0.5128, 0.5128, 0.5128, 0.5179, 0.5214, 0.5231, 0.535, 0.535, 0.5368, 0.5385, 0.5436, 0.5624, 0.5624, 0.5624, 0.5641, 0.5778, 0.5829, 0.5846, 0.5863, 0.5863, 0.5915, 0.6017, 0.6068, 0.641, 0.6581, 0.6889, 0.694, 0.6974, 0.7333, 0.7333, 0.7402, 0.7675, 0.7744, 0.7863, 0.8068, 0.8342, 0.8427, 0.8598, 0.894, 0.947, 0.959, 0.9675, 1};
    //corresponding array for characters 

    public static final String [] GRAYSCALE_LIST  = {"@", "#", "B", "W", "8", "g", "M", "N", "6", "&", "9", "R", "Q", "q", "E", "0", "d", "$", "D", "b", "p", "m", "O","a", "5", "A", "H","2", "G", "Z", "e", "K", "P", "S", "3", "X", "4", "U", "%", "k", "w", "o", "h", "F", "V", "y", "z", "I", "s", "C", "u", "{", "x", "f", "n", "}", "t", "J", "T", "i", "1", "7", "c", "=", "j", "Y", "L", "?", "l", "[", "]", "v", "<", ">", "+", "|", ")", "r", "(", "/", "/", "*", "_", "!", ";", "^", "~", "/", ":", ",", "-", "'", ".", "`"};
    /**
     * Convert a java.awt.Color object to a grayscale float
     * @param c A java.awt.Color object
     * @return A value between 0 and 1 representing grayscale
     */
    public static double getBrightness(Color c) {
        double br = 0.3*(c.getRed()/255.0) + 0.59*(c.getGreen()/255.0) + 0.11*(c.getBlue()/255.0);
        int idx = 0;
        double a =  Math.abs(GRAYSCALE_VALUES[0] - br);
        for(int i = 0; i < GRAYSCALE_VALUES.length-1; i++){
            double brval = Math.abs(GRAYSCALE_VALUES[i] - br);
            if(brval < a){
                idx = i;
                a = brval;
            }
        }
        String ascii = GRAYSCALE_LIST[idx];
        System.out.print(ascii);
        return br;
        
    }
    
    /**
     * Convert a picture object to a 2D array of grayscale floats
     * @param picture A picture object
     * @return A 2D array of grayscale values between 0 and 1
     */
    public static double[][] getGrayscaleArray(Picture picture) {
        int rows = picture.height();
        int cols = picture.width();
        double[][] img = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                img[i][j] = getBrightness(picture.get(j, i));
                
            }

        }
        return img;
    }

    public byte[]  Grayscale(){
        try {
            BufferedImage img = ImageIO.read(new URL("https://assets.epicurious.com/photos/54b0226d766062b20344580a/4:3/w_775,h_581,c_limit/51160200_glazed-doughnuts_1x1.jpg"));
                for (int x = 0; x < img.getWidth(); ++x){
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
                }}

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

    // define what image block is using a double for loop
    byte[] blockImg(byte[] imgBlock){
        byte[] newimgBlock = new byte[imgBlock.length];
        for(int i=0;i<imgBlock.length;i+=4) {
            float val = 0;
            for(int y=1;y<4;y++) {
                val += (imgBlock[i+y] & 0xFF)/3.0;
            }
            newimgBlock[i] = imgBlock[i];
            newimgBlock[i+1] = (byte)val;
            newimgBlock[i+2] = (byte)val;
            newimgBlock[i+3] = (byte)val;
        }
        return newimgBlock;
    }
    
    //first, it's a double for loop for blocks. then you need a for loop for the pixels in the block, so double for loop there as well. in that double forloop you will get the 
    // grayscale value of each pixel, and then get average. then convert the value to ascii. 
    
    

    public static void main(String[] args) {
        Picture picture = new Picture("https://assets.epicurious.com/photos/54b0226d766062b20344580a/4:3/w_775,h_581,c_limit/51160200_glazed-doughnuts_1x1.jpg");
        double[][] image = getGrayscaleArray(picture);
        System.out.println(image[10][4]);
        System.out.println(GRAYSCALE_LIST.length);
        // TODO: Make ASCII art.  You should define at least one method
        // that takes in the image array, as well as the number of 
        // rows and columns in each block
    }
}
//system.setout