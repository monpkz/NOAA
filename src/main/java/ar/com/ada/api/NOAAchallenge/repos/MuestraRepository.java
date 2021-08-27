package ar.com.ada.api.NOAAchallenge.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.NOAAchallenge.entities.Muestra;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer>{

}
