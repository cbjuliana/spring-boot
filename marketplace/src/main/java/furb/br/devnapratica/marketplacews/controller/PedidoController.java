package furb.br.devnapratica.marketplacews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import furb.br.devnapratica.marketplacews.dto.PedidoDTO;
import furb.br.devnapratica.marketplacews.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<PedidoDTO>> listarPedidos() {		
		return new ResponseEntity<List<PedidoDTO>>(pedidoService.listarPedidos(), HttpStatus.OK);		
	}
	
	@PostMapping("/pedido")
	public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
		PedidoDTO pedidoCriado = pedidoService.criarPedido(pedidoDTO);
		return new ResponseEntity<PedidoDTO>(pedidoCriado, HttpStatus.OK);
	}

}
