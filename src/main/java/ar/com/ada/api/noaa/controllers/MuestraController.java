package ar.com.ada.api.noaa.controllers;









//@RestController
//public class MuestraController {
/*
@PostMapping("/muestra") // que registre una muestra
public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
    //TODO: process POST request
    
    return entity;
}

@GetMapping("/muestras/boyas/{idBoya}") //devuelva la lista de muestras de una boya por ID
public SomeData getMethodName(@RequestParam String param) {
    return new SomeData();
}

@DeleteMapping("/muestras/{id}") //Reseteara el color de la boya a “AZUL” a partir de una muestra

//BONUS1/2
/*ue devuelva la lista de muestras de un color en el siguiente 
formato JSON Array")*/
////@GetMapping("/muestras/colores/{color}")

/*: que devuelva la muestra donde la altura nivel del mar sea la 
minima para una boya en particular particular en este formato JSON(informar el horario en que 
ocurrió)*/
//@GetMapping("/muestras/minima/{idBoya}")

//EPICBONUS
/*se ha comenzado a hacer un plan de contingencia para los casos que seamos atacados por 
Monstruos Gigantes o Naves Alienígenas marítimas. Lo que NOAA está pidiendo es armar un 
sistema de alerta que nos avise si una anomalía ha sucedido con las boyas. Este sistema deberá 
devolver un resultado diferente dependiendo de las siguientes consignas:
A) Para una boya en particular, si se mantuvo en un lapso de 10 minutos a niveles de 
200metros absolutos(o sea -200 o +200) por 10 minutos, ALERTA DE KAIJU (Monstruo 
Gigante como GODZILLA)
B) Para una boya en particular, si se tuvo 2 muestras seguidas donde la diferencia de altura 
entre ambas es de +500 : ALERTA DE IMPACTO (Posible meteorito o Nave Alienígena que 
da brincos en el agua)*/
// @GetMapping("api/muestras/anomalias/{idBoya}")


