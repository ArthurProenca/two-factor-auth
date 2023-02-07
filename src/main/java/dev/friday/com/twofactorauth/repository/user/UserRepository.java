package dev.friday.com.twofactorauth.repository.user;

import dev.friday.com.twofactorauth.entity.user.impl.UserImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserImpl, Long> {
    List<UserImpl> findAllByIsVerifiedAndSendedConfirmation(boolean isVerified, boolean sendedConfirmation);

    Optional<UserImpl> findByEmail(String email);

    Optional<UserImpl> findByEmailAndToken(String email, UUID token);
}
