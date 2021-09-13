package ar.com.ada.api.noaa.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boya_id")
    private Integer boyaId;

    @Column(name = "color_luz")
    private String colorLuz = "AZUL";

    @Column(name = "longitud_instalacion")
    private Double longitudInstalacion;

    @Column(name = "latitud_instalacion")
    private Double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Muestra> muestras = new ArrayList<>();
    
    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public String getColorLuz() {
        return colorLuz;
    }

    public void setColorLuz(String colorLuz) {
        this.colorLuz = colorLuz;
    }

    public Double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(Double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public Double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(Double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestras = muestras;
    }

    public void agregarMuestra(Muestra muestra) {
        this.muestras.add(muestra);
    }

    /*ROJO: Marea peligrosa
    AMARILLO: Advertencia de marea peligrosa
    VERDE: todo Ok
    AZUL: indefinido*/
    public String obtenerColor(Double nivelMar) {
        colorLuz = "VERDE";
        
        if (Math.abs(nivelMar) >= 50 || Math.abs(nivelMar) <= -50) {
            return colorLuz = "AMARILLO";
        } else if (Math.abs(nivelMar) >= 100 || Math.abs(nivelMar) <= -100) {
            return colorLuz = "ROJO";
        }

        return colorLuz;
        
    }

   

}
