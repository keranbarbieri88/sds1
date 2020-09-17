package com.devsuperior.dspesquisa.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction){
		
		
		/*
		 * Lógica de paginação e tratamento método vazio
		 * parse - Converte o String para o Instant do Java
		 * Se o minDate vier vazio colocamos o valor como null, caso contratário cai no parse
		 */
		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);
		
		/*
		 * linesPerpage - controla o número de registro por página
		 * MAX_VALUE - caso não informe a quantidade de registros por página 
		 * o programa deverá mostrar todos
		 */
		if(linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}
		
		/*
		 * Objeto de paginação que considera os parãmetros de paginação
		 */
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
		return ResponseEntity.ok().body(list);
	}

}
