package org.example;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.beans.Customizer;
import java.util.Properties;

public class MailHandlerBase {

    public static void sendMail(String emailBody){
        //Properties

        //Something like a map
        Properties sysPropertiesMap = System.getProperties();

        System.out.println(sysPropertiesMap);

        //In this map I want to add 4 more key value pairs : mailing

        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl - secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth


        //Authentication

        Authenticator mailAuthenticator = new CustomizedMailAuthenticator();

        //Session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);



        //Build the Mail
        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setSubject("Geekster Mailing class");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("syed.waseem0002@gmail.com"));
            mailMessage.setText(emailBody);

            Transport.send(mailMessage);
        }
        catch(Exception ex){
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }



    }
}
