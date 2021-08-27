package ar.com.ada.api.NOAAchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.NOAAchallenge.entities.Boya;
import ar.com.ada.api.NOAAchallenge.models.request.ColorBoyaRequest;
import ar.com.ada.api.NOAAchallenge.repos.BoyaRepository;



@Service
public class BoyaService {
    
    @Autowired
    BoyaRepository repo;

    public Boya crearBoya(double longitudInstalacion, double latitudInstacion) {
        Boya boya = new Boya(); 
        boya.setLatitudInstalacion(latitudInstacion);
        boya.setLongitudInstalacion(longitudInstalacion);

        repo.save(boya);
        return boya;

    }
    

    public List<Boya> traerTodas(){
        return repo.findAll();
    }

    public Boya buscarBoyaId(Integer id){
        return repo.findByBoyaId(id);
    }

    public void actualizar(Integer Id, ColorBoyaRequest colorBoyaRequest) {

        Boya boya = this.buscarBoyaId(Id);
        boya.setEstadoColorLuz(colorBoyaRequest.estado);
        repo.save(boya);

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
