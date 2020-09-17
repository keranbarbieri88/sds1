package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

/*
 * Para que seja injetado em outras classes
 */
@Service
public class GameService {
	
	/*
	 * Anotation utilizada para entregar uma instância do GameRepository
	 * automaticamente (dependência)
	 */
	@Autowired
	private GameRepository repository;
	
	/*
	 * Anotation utilizada para busca, operação de leitura
	 * Lamba - tranforma a lista em uma stream
	 */
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> list = repository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
		
		
	}

}
