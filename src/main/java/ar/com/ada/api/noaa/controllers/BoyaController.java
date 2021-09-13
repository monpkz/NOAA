package ar.com.ada.api.noaa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.api.noaa.entities.*;
import ar.com.ada.api.noaa.models.request.ActualizarBoyaColor;
import ar.com.ada.api.noaa.models.request.InfoBoyaNueva;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.BoyaService;


@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/boyas") // permite la creación boyas
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody InfoBoyaNueva InfoBoyaNueva) {
        Boya boya = service.crearBoya(InfoBoyaNueva.longitudInstalacion, InfoBoyaNueva.latitudInstalacion);

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.message = "La boya fue creada con exito.";
        respuesta.id = boya.getBoyaId();

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/boyas") // que devuelva las boyas SIN las muestras.
    public ResponseEntity<List<Boya>> traerTodas() {
        return ResponseEntity.ok(service.traerTodas());

    }

    @GetMapping("/boyas/{id}") // que devuelva la info de una boya en particular(SIN las muestras)
    public ResponseEntity<Boya> getBoyaId(@PathVariable Integer id) {
        Boya boya = service.buscarBoyaId(id);

        return ResponseEntity.ok(boya);
    }

    @PutMapping("/boyas/{id}") // que actualice SOLO el color de luz de la boya. El request esperado será:
    public ResponseEntity<GenericResponse> actualizarBoyaColor(@PathVariable Integer id, @RequestBody ActualizarBoyaColor colorLuz){
        
        
        Boya boyaActualizada = service.actualizarBoyaColor(id, colorLuz.color);
        
        if (boyaActualizada == null){
            return ResponseEntity.notFound().build();
        }   
        
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.message = "Color de boya actualizado.";
        respuesta.id = boyaActualizada.getBoyaId();

        return ResponseEntity.ok(respuesta);
        }

}
