package ar.com.ada.challengenoa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.challengenoa.models.request.InfoMuestraNueva;
import ar.com.ada.challengenoa.models.request.response.GenericResponse;
import ar.com.ada.challengenoa.services.BoyaService;
import ar.com.ada.challengenoa.services.MuestraService;

@RestController
public class MuestraController {

    @Autowired
    private BoyaService boyaservice;
    
   private MuestraService muestraService;

    @PostMapping("/empleados")
    public ResponseEntity<?> crearEmpleada(@RequestBody InfoMuestraNueva muestraInfo) {
        GenericResponse respuesta = new GenericResponse();

        

    }


}
