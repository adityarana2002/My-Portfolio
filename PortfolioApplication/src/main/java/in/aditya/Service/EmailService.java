package in.aditya.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name,String email,String phone ,String message){

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("aditya812611@gmail.com");
        mailMessage.setSubject("New Contact from Submission ");
        mailMessage.setText("Name : " + name +"\nEmail: "+email+"\nPhone : "+phone +"\nMessage :"+message);
        mailSender.send(mailMessage);



    }


}
