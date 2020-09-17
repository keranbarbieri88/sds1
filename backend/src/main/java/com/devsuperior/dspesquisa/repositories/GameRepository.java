package com.devsuperior.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Game;

/*
 * Resgistro do @Autowired para que possa funcionar como 
 * componente gerenciado pelo Spring Boot
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	

}
