package com.credicorp.museo.converter;

import com.credicorp.museo.entities.GenderEntity;
import com.credicorp.museo.model.GenderModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;

@Component
@Validated
public class GenderVisitorConverter {

    private final Logger logger = LogManager.getLogger(GenderVisitorConverter.class);

    @Valid
    public GenderEntity dtoToEntity(GenderModel genderModel){
        logger.info("Iniciando conversion de dto a entidad de visitante");
        GenderEntity genderEntity = new GenderEntity();

        genderEntity.setGender(genderModel.getGender().toString());

        genderEntity.setStorageDate(LocalDate.now());

        logger.info("Finalizando conversion de dto a entidad de visitante");
        return genderEntity;
    }

}
