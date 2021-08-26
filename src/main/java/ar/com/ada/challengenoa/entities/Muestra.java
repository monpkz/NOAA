package ar.com.ada.challengenoa.entities;
//Esta posee la información que transmite la boya

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "muestra")
public class Muestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muestra_id")
    private Integer muestraId;

    @OneToOne
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    private Boya boya;

    @Column(name = "horario_muestra")
    @Temporal(TemporalType.DATE)
    private Date horarioMuestra;

    @Column(name = "matricula_embarcacion")
    private String matriculaEmbarcacion;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "altura_nivel_mar")
    private Double alturaNivelMar;

    @OneToMany(mappedBy = "muestra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Boya> boyas = new ArrayList<>();

    public List<Boya> getBoyas() {
        return boyas;
    }

    public void setBoyas(List<Boya> boyas) {
        this.boyas = boyas;
    }

    public Integer getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(Integer muestraId) {
        this.muestraId = muestraId;
    }

    public Boya getBoya() {
        return boya;
    }

    public void setBoya(Boya boyaId) {
        this.boya = boyaId;
    }

    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(Double alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public void agregarMuestras(Boya boya) {
        this.boyas.add(boya);
    }
   
    //Nota 1: una boya genera varias muestras, y una muestra corresponde solo a una boya.
}
