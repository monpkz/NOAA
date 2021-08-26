package ar.com.ada.challengenoa.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.challengenoa.entities.Boya;

@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer> {

    Boya findByBoyaId(Integer id);

    
}
