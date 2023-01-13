package dev.friday.com.twofactorauth.service;

import dev.friday.com.twofactorauth.repository.settingdefinition.SettingDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSenderImpl emailSender;

    private final SettingDefinitionRepository settingDefinitionRepository;

    public void sendEmail(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.setJavaMailProperties(getMailUsernameAndPasswordProperties());
        emailSender.send(message);
    }

    private Properties getMailUsernameAndPasswordProperties() {
        Properties properties = new Properties();
        String email = settingDefinitionRepository.findByDiscriminator("email").getValue();
        String password = settingDefinitionRepository.findByDiscriminator("password").getValue();

        if (email == null || password == null) {
            throw new RuntimeException("Email or password is not set by setting definition");
        }

        properties.setProperty("spring.mail.username", settingDefinitionRepository.findByDiscriminator("email").getValue());
        properties.setProperty("spring.mail.password", settingDefinitionRepository.findByDiscriminator("password").getValue());


        return properties;
    }

}
