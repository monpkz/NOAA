package ar.com.ada.challengenoa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.challengenoa.entities.Boya;
import ar.com.ada.challengenoa.models.request.ColorBoyaRequest;
import ar.com.ada.challengenoa.repos.BoyaRepository;

public class BoyaService {
    
    @Autowired
    BoyaRepository repo;

    

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

    public void crearBoya(Integer boyaId, Double latitudInstalacion, Double longitudInstalacion) {
        Boya boya = new Boya(); 
        boya.setBoyaId(boyaId);
        boya.setLatitudInstalacion(latitudInstalacion);
        boya.setLongitudInstalacion(longitudInstalacion);

        repo.save(boya);

    }


}
