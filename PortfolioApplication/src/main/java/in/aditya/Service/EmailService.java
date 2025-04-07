package in.aditya.Service;

import in.aditya.Entity.Contact;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// This Java class is using for sending the mail through our personal email id with design also
@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(Contact contact) throws MessagingException {

        String subject = "New Contact Message from " + contact.getFullName();

        String content = """
                <html>
                <body>
                    <div style='font-family: Arial, sans-serif; padding: 20px; border: 1px solid #ddd;'>
                        <h2 style='color:#007bff;'>New Contact Message</h2>
                        <p><strong>Full Name:</strong> %s</p>
                        <p><strong>Email:</strong> %s</p>
                        <p><strong>Phone:</strong> %s</p>
                        <p><strong>Message:</strong></p>
                        <p>%s</p>
                    </div>
                </body>
                </html>
                """.formatted(
                contact.getFullName(),
                contact.getEmail(),
                contact.getPhone(),
                contact.getMessage()

        );
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("adityarana1140@gmail.com");
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }


}
