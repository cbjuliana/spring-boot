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
import furb.br.devnapratica.marketplacews.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> listarClientes() {
		
		/*
		List<ClienteDTO> list = new ArrayList<ClienteDTO>();
		
		ClienteDTO clienteDTO1 = new ClienteDTO();
		clienteDTO1.setNome("João");
		
		ClienteDTO clienteDTO2 = new ClienteDTO();
		clienteDTO2.setNome("Maria");
		
		list.add(clienteDTO1);
		list.add(clienteDTO2);
		
		return new ResponseEntity<List<ClienteDTO>>(list, HttpStatus.OK);
		*/
		
		return new ResponseEntity<List<ClienteDTO>>(clienteService.listarClientes(), HttpStatus.OK);
		
		
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO clienteDTO) {
		ClienteDTO clienteCriado = clienteService.criarCliente(clienteDTO);
		return new ResponseEntity<ClienteDTO>(clienteCriado, HttpStatus.OK);
	}
	
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}

}
