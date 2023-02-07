package dev.friday.com.twofactorauth.entity.user;

public interface User {
    Long getId();


    String getEmail();


    String getPassword();

    java.util.UUID getToken();


    Boolean getIsVerified();



    Boolean getSendedConfirmation();


    String getVerificationCode();



    java.util.Date getCreatedDate();


    java.util.Date getLastModified();


    java.util.Date getVerificationDate();

    void setId(Long id);

    void setEmail(String email);

    void setPassword(String password);

    void setToken(java.util.UUID token);

    void setIsVerified(Boolean isVerified);

    void setSendedConfirmation(Boolean sendedConfirmation);

    void setVerificationCode(String verificationCode);

    void setCreatedDate(java.util.Date createdDate);

    void setLastModified(java.util.Date lastModified);

    void setVerificationDate(java.util.Date verificationDate);
}
