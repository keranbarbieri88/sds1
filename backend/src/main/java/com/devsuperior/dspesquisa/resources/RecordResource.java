package com.devsuperior.dspesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

/* 
 * Resouse Controlador REST não tem acesso às entidades, apenas DTO.
 * Controlador REST que vai ser um WebService que responderá
 * às requisições através da rota RequestMapping
 */
@RestController
@RequestMapping(value = "/records")
public class RecordResource {
	
	/*
	 * Anotation utilizada para entregar uma instância do GameService
	 * automaticamente (dependência)
	 */
	@Autowired
	private RecordService service;

	/*
	 *Requisição POST (EndPoint) no POSTMAN , salva.
	 * Método findAll retorna um ResposeEntity com o ok para construir um objeto com a resposta 
	 * que casou com a requisição e no body retorna um lista a partir do gameRepository que 
	 * busca todos os games do banco de dados.
	 */
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
		RecordDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);
		
		
	}

}
