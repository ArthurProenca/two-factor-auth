package dev.friday.com.twofactorauth.entity.settingdefinition.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SettingDefinitionDTO {
    private String name;
    private String discriminator;
    private String value;
}
