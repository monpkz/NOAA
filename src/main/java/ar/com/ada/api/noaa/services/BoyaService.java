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

    public boolean actualizarBoyaColor(Integer id, String colorLuz) {

        Boya boya = buscarBoyaId(id);
        if(boya!=null){
        boya.setColorLuz(colorLuz);
        guardarBoya(boya);
        return true;
        }
        return false;
    }

}
