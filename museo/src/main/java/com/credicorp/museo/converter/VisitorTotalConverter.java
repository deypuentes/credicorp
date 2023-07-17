package com.credicorp.museo.converter;

import com.credicorp.museo.entities.GenderEntity;
import com.credicorp.museo.entities.VisitorTotalEntity;
import com.credicorp.museo.model.VisitorModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Component
@Validated
public class VisitorTotalConverter {
    private final Logger logger = LogManager.getLogger(VisitorTotalConverter.class);

    @Valid
    public VisitorModel EntityToDto(List<VisitorTotalEntity> listGenderVisitorEntity){
        logger.info("Iniciando conversion de entidad a dtp de visitante");
        VisitorModel visitorModel = new VisitorModel();
        String total = "";

        for (int i= 0; i < listGenderVisitorEntity.size(); i++){

                total= total.concat(listGenderVisitorEntity.get(i).getGender());

        }
        visitorModel.setTotalVisitors(total);


        logger.info("Finalizando conversion de entidad a dtp de visitante");
        return visitorModel;
    }



}
