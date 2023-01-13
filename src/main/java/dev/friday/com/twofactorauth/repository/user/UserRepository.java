package dev.friday.com.twofactorauth.repository.user;

import dev.friday.com.twofactorauth.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByIsVerifiedAndSendedConfirmation(boolean isVerified, boolean sendedConfirmation);

    User findByUsername(String email);
}
