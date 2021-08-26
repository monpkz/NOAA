package ar.com.ada.challengenoa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.challengenoa.entities.Muestra;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer>{

}
