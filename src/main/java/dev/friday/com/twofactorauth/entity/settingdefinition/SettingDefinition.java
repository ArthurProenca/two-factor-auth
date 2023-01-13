package dev.friday.com.twofactorauth.entity.settingdefinition;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TSETTING_DEFINITION")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SettingDefinition {
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
