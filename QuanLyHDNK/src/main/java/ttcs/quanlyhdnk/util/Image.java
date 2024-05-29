/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttcs.quanlyhdnk.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class Image {
    //    public void scaleImage(javax.swing.JButton button,int width,int heigth, String link){
//        javax.swing.ImageIcon icon=new javax.swing.ImageIcon(link);
//        java.awt.Image tmp = icon.getImage();
//        tmp=tmp.getScaledInstance(width, heigth,java.awt.Image.SCALE_REPLICATE  );
//        icon= new javax.swing.ImageIcon(tmp);
//        
//    }
    public static ImageIcon resizeImage( ImageIcon imageIcon,int width,int height ){
        java.awt.Image scaleImage = imageIcon.getImage();
        scaleImage=scaleImage.getScaledInstance(width, height, java.awt.Image.SCALE_REPLICATE );
        return new ImageIcon(scaleImage);
    }
    public static byte[] ImageIconToByte(ImageIcon imageIcon) throws IOException{
        BufferedImage bufferedImage = new BufferedImage(
            imageIcon.getIconWidth(),
            imageIcon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB
        );

        // Vẽ ImageIcon vào BufferedImage
        bufferedImage.getGraphics().drawImage(imageIcon.getImage(), 0, 0, null);

        // Chuyển đổi BufferedImage sang byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        byte[] imageData = baos.toByteArray();
//        for(int i=0;i<imageData.length;i++) System.out.print(imageData[i]);
//        System.out.println("");
        return imageData;

    }
    public static ImageIcon ByteToImageIcon(byte[] byteImage) throws IOException{
        
        // Chuyển đổi byte[] thành BufferedImage
        ByteArrayInputStream bais = new ByteArrayInputStream(byteImage);
        BufferedImage bufferedImage = ImageIO.read(bais);

        // Chuyển đổi BufferedImage thành ImageIcon
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        return imageIcon;
    }

}
