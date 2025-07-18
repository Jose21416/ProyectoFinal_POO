
package Lógica;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class LServicioEmail {
    private final String remitente = "universidadsideralcarrion.usc@gmail.com";
    private final String claveRemitente = "rrci mbjz ozhu xoar";
    
    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, claveRemitente);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport.send(message);
            System.out.println("Correo enviado exitosamente a " + destinatario);
            return true;

        } catch (MessagingException e) {
            System.err.println("Error al enviar correo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    } 
}
