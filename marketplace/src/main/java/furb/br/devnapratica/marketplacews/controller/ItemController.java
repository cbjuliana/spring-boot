package furb.br.devnapratica.marketplacews.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import furb.br.devnapratica.marketplacews.dto.ClienteDTO;
import furb.br.devnapratica.marketplacews.dto.ItemDTO;
import furb.br.devnapratica.marketplacews.service.ClienteService;
import furb.br.devnapratica.marketplacews.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/itens")
	public ResponseEntity<List<ItemDTO>> listarItens() {		
		return new ResponseEntity<List<ItemDTO>>(itemService.listarItens(), HttpStatus.OK);		
	}
	
	@PostMapping("/item")
	public ResponseEntity<ItemDTO> criarItem(@RequestBody ItemDTO itemDTO) {
		ItemDTO itemCriado = itemService.criarItem(itemDTO);
		return new ResponseEntity<ItemDTO>(itemCriado, HttpStatus.OK);
	}

}
