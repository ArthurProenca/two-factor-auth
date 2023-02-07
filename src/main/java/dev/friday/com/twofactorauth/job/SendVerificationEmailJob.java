package dev.friday.com.twofactorauth.job;

import dev.friday.com.twofactorauth.repository.user.UserRepository;
import dev.friday.com.twofactorauth.service.EmailService;
import dev.friday.com.twofactorauth.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendVerificationEmailJob {
    private final EmailService emailService;
    private final UserRepository userRepository;

    @Scheduled(cron = "*/10 * * * * *")
    public void checkUsersThatAreNotVerified() {
        log.info("Verifying users that are not verified");
        String generatedCode = UserUtil.generateCode();
        userRepository.findAllByIsVerifiedAndSendedConfirmation(false, false).forEach(user -> {
            log.info("Sending verification email to {}", user.getEmail());
            //emailService.sendEmail(user.getEmail(), "Verification email", "Use " + generatedCode + " to verify your account");
            user.setSendedConfirmation(true);
            user.setVerificationCode(generatedCode);
            userRepository.save(user);
        });
    }
}
