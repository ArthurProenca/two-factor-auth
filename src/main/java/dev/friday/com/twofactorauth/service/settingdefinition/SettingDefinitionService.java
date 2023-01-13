package dev.friday.com.twofactorauth.service.settingdefinition;

import dev.friday.com.twofactorauth.entity.settingdefinition.SettingDefinition;
import dev.friday.com.twofactorauth.entity.settingdefinition.dto.SettingDefinitionDTO;
import dev.friday.com.twofactorauth.repository.settingdefinition.SettingDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class SettingDefinitionService {
    private final SettingDefinitionRepository settingDefinitionRepository;

    public SettingDefinition createSettingDefinition(SettingDefinitionDTO settingDefinitionDTO) {
        return settingDefinitionRepository.save(SettingDefinition.builder()
                .value(settingDefinitionDTO.getValue())
                .discriminator(settingDefinitionDTO.getDiscriminator())
                .name(settingDefinitionDTO.getName())
                .createdDate(Date.from(java.time.Instant.now()))
                .lastModified(Date.from(java.time.Instant.now()))
                .build());
    }
}
