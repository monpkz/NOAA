package ar.com.ada.challengenoa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.challengenoa.entities.*;
import ar.com.ada.challengenoa.models.request.ColorBoyaRequest;
import ar.com.ada.challengenoa.models.request.InfoBoyaNueva;
import ar.com.ada.challengenoa.models.request.response.GenericResponse;
import ar.com.ada.challengenoa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    private BoyaService service;
    
    @PostMapping("/boyas") //permite la creación boyas
    public ResponseEntity<?> crearMuestra(@RequestBody InfoBoyaNueva InfoBoyaNueva, Boya boya) {

        GenericResponse respuesta = new GenericResponse();

        service.crearBoya(boya);

        respuesta.isOk = true;
        respuesta.id = boya.getBoyaId();
        respuesta.message = "La boya fue creada con exito.";

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/boyas") // que devuelva las boyas SIN las muestras.
    public ResponseEntity<List<Boya>> traerTodas() {
        return ResponseEntity.ok(service.traerTodas()); 

    }

    @GetMapping("/boyas/{id}") //que devuelva la info de una boya en particular(SIN las muestras)
    public ResponseEntity<Boya> getBoyaId(@PathVariable Integer id) {
        Boya boya = service.buscarBoyaId(id);

        return ResponseEntity.ok(boya);
    }

    @PutMapping("/boya/{id}") // que actualice SOLO el color de luz de la boya. El request esperado será:
    public ResponseEntity<GenericResponse> actualizar (@PathVariable Integer id, @RequestBody ColorBoyaRequest ColorBoya){
    
        service.actualizar(id, ColorBoya);
        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.message = "Color de boya actualizado.";

        return ResponseEntity.ok(respuesta);

    }

    
}
