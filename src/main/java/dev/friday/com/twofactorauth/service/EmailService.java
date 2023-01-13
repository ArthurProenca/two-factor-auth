package dev.friday.com.twofactorauth.service;

import dev.friday.com.twofactorauth.repository.settingdefinition.SettingDefinitionRepository;
import dev.friday.com.twofactorauth.utils.EnvironmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender emailSender;

    private final SettingDefinitionRepository settingDefinitionRepository;

    private final EnvironmentUtil environmentUtil;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(environmentUtil.getEnvironmentProperty("smpt_email") + " " + environmentUtil.getEnvironmentProperty("smpt_password"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);

    }

}
