package dev.friday.com.twofactorauth.entity.setting;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TSETTING_DEFINITION")
public class SettingDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DISCRIMINATOR", nullable = false)
    private String discriminator;

    @Column(name = "VALUE", nullable = false)
    private String value;

}
