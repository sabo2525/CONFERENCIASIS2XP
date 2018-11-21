
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabo
 */
public class CodigoControl {
    private static final int qrTamAncho = 400;
    private static final int qrTamAlto = 400;
    private static final String formato = "png";
  
    public boolean generarQr(String nombre ,int ci,int grupoConferencia){
        boolean respuesta = false;
        File miDir = new File (".");
       String codigo=nombre+"-"+ci+"-"+grupoConferencia;
        BitMatrix matriz = null;
        Writer writer = new QRCodeWriter();
        try {
            matriz = writer.encode(codigo, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
        
        BufferedImage imagen = new BufferedImage(qrTamAncho,
                qrTamAlto, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < qrTamAlto; y++) {
            for (int x = 0; x < qrTamAncho; x++) {
                int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
            }
        }
        FileOutputStream qrCode = null;
      
            qrCode = new FileOutputStream(miDir+"/ImagenQR/qr.png");
            ImageIO.write(imagen, formato, qrCode);
            respuesta=true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }     
     public static void main(String args[]) throws Exception {
    new CodigoControl().generarQr("Josiie",123,10);
     }
    }
