package com.devsuperior.dspesquisa.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dspesquisa.entities.Record;

/*
 * Repository não conhece DTO, Repository conhece entidade
 */
@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	/*
	 * Implementa a busca, consulta em JPQL adaptada para o JPA
	 * A consulta retornará apenas os objetos que é maior ou igual a min e menor ou 
	 * igual a max
	 */
	@Query("SELECT obj FROM Record obj WHERE "
			+ "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND "
			+ "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Record> findByMoments(Instant min, Instant max, Pageable pageable);
	

}
