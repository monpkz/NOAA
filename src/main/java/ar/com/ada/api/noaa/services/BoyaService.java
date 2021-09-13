package ar.com.ada.api.noaa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.repos.BoyaRepository;



@Service
public class BoyaService {
    
    @Autowired
    BoyaRepository repo;

    public Boya crearBoya(double longitudInstalacion, double latitudInstacion) {
        Boya boya = new Boya(); 
        boya.setLatitudInstalacion(latitudInstacion);
        boya.setLongitudInstalacion(longitudInstalacion);

        guardarBoya(boya);
        return boya;

    }
    
    public void guardarBoya(Boya boya) {
        repo.save(boya);
    }

    public List<Boya> traerTodas(){
        return repo.findAll();
    }

    public Boya buscarBoyaId(Integer id){
        return repo.findByBoyaId(id);
    }

    public Boya actualizarBoyaColor(Integer id, String colorLuz) {

        Boya boya = buscarBoyaId(id);
        boya.setColorLuz(colorLuz);
        guardarBoya(boya);
        return boya;
    }


    /*public boya obtenerPorBoyaId(Integer id){
        return repo.findAllById(id);
    }


   /* ACTUALIZAR PUT DE BOYA CAMBIO DE LUZ // arreglando para agregarlo al codigo.
      public Boya actualizarBoyaLuz(Integer boyaId, ColorBoyaEnum estado) {

        Boya boya = new Boya();

        boya = boyaService.obtenerPorBoyaId(boyaId);

        switch (faroStatus) {

            case AZUL:

                boya.setFaroStatusId(faroStatus);
                boyaRepo.save(boya);
                break;

            case VERDE:

                boya.setFaroStatusId(faroStatus);
                boyaRepo.save(boya);
                break;

            case AMARILLO:

                boya.setFaroStatusId(faroStatus);
                boyaRepo.save(boya);
                break;

            case ROJO:

                boya.setFaroStatusId(faroStatus);
                boyaRepo.save(boya);
                break;

            default:
                break;
        }

        return boya;

    }*/

}
