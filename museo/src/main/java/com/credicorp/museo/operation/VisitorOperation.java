package com.credicorp.museo.operation;

import com.credicorp.museo.converter.GenderVisitorConverter;
import com.credicorp.museo.converter.VisitorTotalConverter;
import com.credicorp.museo.model.GenderModel;
import com.credicorp.museo.model.VisitorModel;
import com.credicorp.museo.repository.GenderRepository;
import com.credicorp.museo.repository.GenderVisitorJbc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitorOperation {
    private final Logger logger = LogManager.getLogger(VisitorOperation.class);

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GenderVisitorConverter genderVisitorConverter;

    @Autowired
    private GenderVisitorJbc genderVisitorJbc;

    @Autowired
    private VisitorTotalConverter visitorTotalConverter;

    @Transactional
    public boolean insertGenderVisitor(GenderModel genderModel){
        logger.info("Iniciando insersión de genero de visitante");
    genderRepository.save(genderVisitorConverter.dtoToEntity(genderModel));
        logger.info("Finalizando insersión de genero de visitante");
        return true;
    }

public VisitorModel obtenerDia(){
    logger.info("Iniciando consulta de genero de visitante");

return visitorTotalConverter.EntityToDto(genderVisitorJbc.getTotalVisitor());

}

}
