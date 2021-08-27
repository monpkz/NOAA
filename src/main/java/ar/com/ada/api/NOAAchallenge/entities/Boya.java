package ar.com.ada.api.NOAAchallenge.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boya_id")
    private Integer boyaId;

    @ManyToOne // join columns van donde esta FK
    @JoinColumn(name = "muestra_id", referencedColumnName = "muestra_id")
    private Muestra muestra;

    @Column(name = "estado_color_luz_id")
    private Integer estadoColorLuz;

    @Column(name = "longitud_instalacion")
    private Double longitudInstalacion;

    @Column(name = "latitud_instalacion")
    private Double latitudInstalacion;

    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra Muestra) {
        this.muestra = muestra;
        this.muestra.agregarMuestras(this);
    }

    public Integer getBoyaId() {
        return boyaId;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
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
    

    /*ROJO: Marea peligrosa
    AMARILLO: Advertencia de marea peligrosa
    VERDE: todo Ok
    AZUL: indefinido*/

    public ColorBoyaEnum getEstadoColorLuz() {

        return ColorBoyaEnum.parse(this.estadoColorLuz);
    }

    public void setEstadoColorLuz(ColorBoyaEnum estadoColorLuz) {
        this.estadoColorLuz = estadoColorLuz.getValue();
    }

    public enum ColorBoyaEnum {

        APAGADA(1), ROJO(2), AMARILLO(3), VERDE(4), AZUL(5);

        private final int value;

        private ColorBoyaEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static ColorBoyaEnum parse(int id) {
            ColorBoyaEnum status = null; // Default
            for (ColorBoyaEnum item : ColorBoyaEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;

        }
    }

}
