package dev.friday.com.twofactorauth.repository.settingdefinition;

import dev.friday.com.twofactorauth.entity.settingdefinition.SettingDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingDefinitionRepository extends JpaRepository<SettingDefinition, Long> {
    SettingDefinition findByDiscriminator(String discriminator);
}
