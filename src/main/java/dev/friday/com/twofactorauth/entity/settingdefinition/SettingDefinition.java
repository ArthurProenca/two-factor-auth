package dev.friday.com.twofactorauth.entity.settingdefinition;

public interface SettingDefinition {

    Long getId();
    String getName();
    String getDiscriminator();
    String getValue();
    java.util.Date getCreatedDate();
    java.util.Date getLastModified();
    void setId(Long id);
    void setName(String name);
    void setDiscriminator(String discriminator);
    void setValue(String value);
    void setCreatedDate(java.util.Date createdDate);
    void setLastModified(java.util.Date lastModified);
}
