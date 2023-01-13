package dev.friday.com.twofactorauth.controller.settingdefinition.impl;

import dev.friday.com.twofactorauth.controller.settingdefinition.SettingDefinitionRestController;
import dev.friday.com.twofactorauth.entity.settingdefinition.dto.SettingDefinitionDTO;
import dev.friday.com.twofactorauth.repository.settingdefinition.SettingDefinitionRepository;
import dev.friday.com.twofactorauth.service.settingdefinition.SettingDefinitionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SettingDefinitionRestControllerImpl implements SettingDefinitionRestController {

    private final SettingDefinitionService settingDefinitionService;

    @PostMapping("/v1/settingdefinition")
    public ResponseEntity<?> createSettingDefinition(@RequestBody SettingDefinitionDTO settingDefinitionDTO) {
        return ResponseEntity.ok(settingDefinitionService.createSettingDefinition(settingDefinitionDTO));
    }
}
