
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabo
 */
public class Correo {
    private String usuario;
    private String pass;
    private String rutaArch;
    private String nomArch;
    private String asunto;
    private String mensaje;
    public Correo(){
        usuario="confsis2@gmail.com";
        pass="kzdgbbpwkqfbyomi";
        asunto="verificacion de inscripcion";
        mensaje="usted<br> esta inscrito para la conferencia UMSS 2018<br>este es su codigo de verificacion <b>para el dia del evento<b>";
        File ruta= new File (".");
        rutaArch=ruta+"/ImagenQR/qr.png";
        
    }
    public static boolean tieneConexionInternet(){
        boolean res=true;
    try {
        final URL url = new URL("http://www.google.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
    } catch (MalformedURLException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        res=false;
    }
    return res;
    }
    
    public boolean enviar(String correoDestino){
        boolean res;
        if(validarCorreo(correoDestino)&&tieneConexionInternet()){
        try {
                Properties pro= new Properties();
                pro.setProperty("mail.smtp.host","smtp.gmail.com");
                pro.setProperty("mail.smtp.starttls.enable", "true");
                pro.setProperty("mail.smtp.port", "587");
                pro.setProperty("mail.smtp.auth", "true");
                
                Session se=Session.getDefaultInstance(pro);
                BodyPart texto=new MimeBodyPart();
                texto.setContent(mensaje,"text/html");
                
                BodyPart adjunto=new MimeBodyPart();
                
                adjunto.setDataHandler(new DataHandler(new FileDataSource(rutaArch)));
                adjunto.setFileName("imagenQR.png");
                
                MimeMultipart multipart=new MimeMultipart();
                multipart.addBodyPart(adjunto);
                multipart.addBodyPart(texto);
               
                MimeMessage men=new MimeMessage(se);
                men.setFrom(new InternetAddress(usuario));
                
                men.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
                men.setSubject(asunto);
                men.setContent(multipart);
                
                Transport t=se.getTransport("smtp");
                t.connect(usuario, pass);
                t.sendMessage(men, men.getRecipients(Message.RecipientType.TO));
                t.close();
                res= true;
            } catch (MessagingException ex) {
                System.out.println("error"+ex);
                res= false;
            }
        }else{
            res=false;
        }
        return res;
    }
    public boolean validarCorreo(String correo){
        boolean res;
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
         // El email a validar
 
        Matcher mather = pattern.matcher(correo);
        if (mather.find()) {
            res=true;
        } else {
            res=false;
        }
        return res;
    }
    public static void main(String[] args) {
        Correo c= new Correo();
        System.out.println(c.enviar("cbrt113@gmail.com"));
    }

}
