package com.devsuperior.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.services.GameService;

/* 
 * Resouse Controlador REST não tem acesso às entidades, apenas DTO.
 * Controlador REST que vai ser um WebService que responderá
 * às requisições através da rota RequestMapping
 */
@RestController
@RequestMapping(value = "/games")
public class GameResource {
	
	/*
	 * Anotation utilizada para entregar uma instância do GameService
	 * automaticamente (dependência)
	 */
	@Autowired
	private GameService service;
	
	
	
	/*
	 *Requisição GET no POSTMAN
	 * Método findAll retorna um ResposeEntity com o ok para construir
	 * um objeto com a resposta que casou com a requisição e no body 
	 * retorna um lista a partir do gameRepository que busca todos os 
	 * games do banco de dados
	 */
	@GetMapping
	public ResponseEntity<List<GameDTO>> findAll(){
		List<GameDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
