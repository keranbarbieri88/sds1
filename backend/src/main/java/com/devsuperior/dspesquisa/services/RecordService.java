package com.devsuperior.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

/*
 * Para que seja injetado em outras classes
 */
@Service
public class RecordService {
	
	/*
	 * Anotation utilizada para entregar uma instância do GameRepository
	 * automaticamente (dependência)
	 */
	@Autowired
	private RecordRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		
		Record entity = new Record();
		
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		/*
		 * o getOne instancia um objeto monitorado do tipo Game para podermos associar
		 * porém não acessa o bando de dados, mas quando mardarmos salvar o Record entiy
		 * aí sim ele salva o Record com o Id que passamos
		 * 
		 */
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);

		/*
		 * Salva
		 */

		entity = repository.save(entity);
		return new RecordDTO(entity);
	
	}
	/*
	 * Operação de busca
	 * lambda para converter as entidades em DTO
	 */
	@Transactional(readOnly = true )
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}

}
