package ar.com.ada.api.noaa.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.models.response.AnomaliaResponse;
import ar.com.ada.api.noaa.models.response.MuestraPorColor;
import ar.com.ada.api.noaa.models.response.AnomaliaResponse.TipoAlertaEnum;
import ar.com.ada.api.noaa.repos.MuestraRepository;

@Service
public class MuestraService {

    @Autowired
    MuestraRepository repo;

    @Autowired
    BoyaService boyaService;

    public Muestra crearMuestra(Integer boyaId, Date horarioMuestra, String matriculaEmbarcacion, Double latitud,
            Double longitud, Double alturaNivelMar) {
        Muestra muestra = new Muestra();
        Boya boya = boyaService.traerById(boyaId);
        muestra.setBoya(boya);
        muestra.setHorarioMuestra(horarioMuestra);
        muestra.setMatriculaEmbarcacion(matriculaEmbarcacion);
        muestra.setLatitud(latitud);
        muestra.setLongitud(longitud);
        muestra.setAlturaNivelMar(alturaNivelMar);

        repo.save(muestra);
        return muestra;

    }

    public List<Muestra> traerTodasMuestras(Integer boyaId){
        Boya boya = boyaService.traerById(boyaId);
        if (boya!=null){
            return boya.getMuestras();
        } else
        return null;
    }

    public String colorMuestra(Muestra muestra){
               
        if(muestra.getAlturaNivelMar()<-100 || muestra.getAlturaNivelMar()>100 ){
            return "ROJO";
        }
        else if (muestra.getAlturaNivelMar()<-50 || muestra.getAlturaNivelMar()>50) {
            return "AMARILLO";
        } 
        else {
            return "VERDE"; 
        }
    }

    public boolean resetearColorBoya(Integer id) {
        Muestra muestra = repo.findBymuestraId(id);
        if (muestra!=null) {
            Boya boya = muestra.getBoya();
            boya.setColorLuz("AZUL");
            boyaService.guardarBoya(boya);
            return true;
        } else
            return false;
    }

    public List<MuestraPorColor> traerMuestrasPorColor(String color) {
        List<MuestraPorColor> muestrasPorColor = new ArrayList<>();
        MuestraPorColor muestraPorColor= new MuestraPorColor();
        
        for (Muestra muestra : repo.findAll()) {            
            
            if (colorMuestra(muestra).equals(color)){ 
                muestraPorColor.boyaId = muestra.getBoya().getBoyaId();
                muestraPorColor.horario=muestra.getHorarioMuestra();
                muestraPorColor.alturaNivelDelMar=muestra.getAlturaNivelMar();                            
                
                muestrasPorColor.add(muestraPorColor);
            }            
        }
        return muestrasPorColor;
        
    }

    public Muestra MuestraAlturaMinima(Integer idBoya) {
        Boya boya = boyaService.traerById(idBoya);
             
        Muestra muestraMinima = boya.getMuestras().get(0);  

        for (Muestra muestra : boya.getMuestras()) {
            if(muestra.getAlturaNivelMar()<muestraMinima.getAlturaNivelMar()){
                muestraMinima=muestra;
            }
            
        }
        return muestraMinima;
    }

 /*   public AnomaliaResponse alertaImpacto(Integer idBoya){
        AnomaliaResponse anomaliaResponse= new AnomaliaResponse();
        Boya boya = boyaService.traerById(idBoya);
        List<Muestra> muestras = boya.getMuestras();
        Boolean flagKAIJU=false;
        Date inicioKAIJU=muestras.get(0).getHorarioMuestra();
        Date finKAIJU= new Date();//pongo cualquier cosa para inicializar

        Calendar calendar= Calendar.getInstance();
        
        
        for (int i=0; i< muestras.size()-1;i++){            
            
            if ((Math.abs(muestras.get(i).getAlturaNivelMar())>=200)&&(Math.abs(muestras.get(i+1).getAlturaNivelMar())>=200)){
                if(flagKAIJU==false){
                    inicioKAIJU=muestras.get(i).getHorarioMuestra();
                    calendar.setTime(inicioKAIJU);
                    calendar.roll(Calendar.MINUTE, 10);
                    finKAIJU=calendar.getTime();//fecha con 10 min mas
                }
                                
                flagKAIJU=true;
                if(muestras.get(i+1).getHorarioMuestra().compareTo(finKAIJU)>=0){
                    anomaliaResponse.alturaNivelDelMar= muestras.get(muestras.size()-1).getAlturaNivelMar();//altura de ultima muestra
                    anomaliaResponse.horarioInicioAnomalia=inicioKAIJU;
                    anomaliaResponse.horarioInicioFinAnomalia=finKAIJU;
                    anomaliaResponse.tipoAlerta=TipoAlertaEnum.KAIJU;
                    return anomaliaResponse;
                }

            }
            else
            flagKAIJU=false;

            if(Math.abs(muestras.get(i).getAlturaNivelMar()-muestras.get(i+1).getAlturaNivelMar())>500){
                anomaliaResponse.alturaNivelDelMar= muestras.get(muestras.size()-1).getAlturaNivelMar();//altura de ultima muestra
                anomaliaResponse.horarioInicioAnomalia=muestras.get(i).getHorarioMuestra();
                anomaliaResponse.horarioInicioFinAnomalia=muestras.get(i+1).getHorarioMuestra();
                anomaliaResponse.tipoAlerta=TipoAlertaEnum.IMPACTO;

                return anomaliaResponse;
            }
        }
        return anomaliaResponse;        
    }
    */
}
