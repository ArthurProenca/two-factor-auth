package dev.friday.com.twofactorauth.entity.settingdefinition.impl;

import dev.friday.com.twofactorauth.entity.settingdefinition.SettingDefinition;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TSETTING_DEFINITION")
public class SettingDefinitionImpl implements SettingDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "SETTING_NAME", nullable = false)
    private String name;
    @Column(name = "SETTING_DISCRIMINATOR", nullable = false)
    private String discriminator;
    @Column(name = "SETTING_VALUE", nullable = false)
    private String value;
    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;
    @Column(name = "LAST_MODIFIED", nullable = false)
    private Date lastModified;
}
