package ar.com.ada.api.NOAAchallenge.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.NOAAchallenge.entities.Boya;



@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer> {

    Boya findByBoyaId(Integer id);

    
}
