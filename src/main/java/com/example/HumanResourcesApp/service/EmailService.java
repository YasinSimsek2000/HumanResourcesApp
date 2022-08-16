package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.EmailDetails;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Optional;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private IManagerRepository managerRepository;
    @Value("${spring.mail.username}") private String sender;

    public EmailService() {
    }

    public String sendSimpleMail(EmailDetails details) throws Exception {

        Optional<Manager> manager = managerRepository.findManagerByEmail(details.getRecipient());
        if(manager.isPresent()) {
            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();

                mailMessage.setFrom(sender);
                mailMessage.setTo(details.getRecipient());
                mailMessage.setText(details.getMessageBody());
                mailMessage.setSubject(details.getSubject());

                javaMailSender.send(mailMessage);
                return "Mail Sent Successfully...";
            } catch (Exception e) {
                return "Error while Sending Mail";
            }
        } else {
            throw new Exception("Manager not exist");
        }
    }

    public String sendMailWithAttachment(EmailDetails details) {
        // Creating a mime message
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMessageBody());
            mimeMessageHelper.setSubject(details.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource( new File(details.getAttachment()) );

            mimeMessageHelper.addAttachment( file.getFilename(), file );
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        catch (MessagingException e) { return "Error while sending mail!!!"; }
    }
}

