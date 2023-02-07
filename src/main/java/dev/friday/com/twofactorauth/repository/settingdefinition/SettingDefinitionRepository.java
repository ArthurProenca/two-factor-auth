package dev.friday.com.twofactorauth.repository.settingdefinition;

import dev.friday.com.twofactorauth.entity.settingdefinition.impl.SettingDefinitionImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingDefinitionRepository extends JpaRepository<SettingDefinitionImpl, Long> {
    SettingDefinitionImpl findByDiscriminator(String discriminator);
}
