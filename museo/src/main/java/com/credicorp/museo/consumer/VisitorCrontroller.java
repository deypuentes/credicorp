package com.credicorp.museo.consumer;

import com.credicorp.museo.model.GenderModel;
import com.credicorp.museo.model.VisitorModel;
import com.credicorp.museo.operation.VisitorOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/credicorp/visitor")
@CrossOrigin
public class VisitorCrontroller {

	private final Logger logger = LogManager.getLogger(VisitorCrontroller.class);
	
	@Autowired
	private VisitorOperation visitorOperation;
	

	@GetMapping(value = "/day")
    public VisitorModel obtenerPorId() {
        logger.info("Iniciando consumo del API Visitor consulta por dia");

        try {
            return visitorOperation.obtenerDia();
        } finally {
            logger.info("Finalizando consumo del API Visitor consulta por dia");
        }
    }
	 
	@PostMapping
    public boolean insertar(@RequestBody GenderModel model) {
        logger.info("Iniciando consumo del API Visitor insertando registro");

        try {
            return visitorOperation.insertGenderVisitor(model);
        } finally {
            logger.info("Finalizando consumo del API Visitor insertando registro");
        }
    }

}
