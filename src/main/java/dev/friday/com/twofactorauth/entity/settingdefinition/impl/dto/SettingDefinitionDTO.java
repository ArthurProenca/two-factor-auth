package dev.friday.com.twofactorauth.entity.settingdefinition.impl.dto;

import dev.friday.com.twofactorauth.entity.settingdefinition.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SettingDefinitionDTO implements SettingDefinition {
    private Long id;
    private String name;
    private String discriminator;
    private String value;
    private Date createdDate;
    private Date lastModified;
}
