package furb.br.devnapratica.marketplacews.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furb.br.devnapratica.marketplacews.dto.ItemDTO;
import furb.br.devnapratica.marketplacews.dto.PedidoDTO;
import furb.br.devnapratica.marketplacews.entity.ItemEntity;
import furb.br.devnapratica.marketplacews.entity.PedidoEntity;
import furb.br.devnapratica.marketplacews.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<PedidoDTO> listarPedidos() {
		List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
		for (PedidoEntity pedidoEntity : pedidoRepository.findAll()) {
			PedidoDTO pedido = new PedidoDTO();
			pedido.setId(pedidoEntity.getId());
			pedido.setDataPedido(pedidoEntity.getDataPedido());
			
			List<ItemDTO> itensPedido = new ArrayList<ItemDTO>();
			
			for (ItemEntity itemEntity : pedidoEntity.getItens()) {
				ItemDTO itemDTO = new ItemDTO();
				itemDTO.setId(itemEntity.getId());
				itemDTO.setNome(itemEntity.getNome());
				itemDTO.setQuantidade(itemEntity.getQuantidade());
				
				itensPedido.add(itemDTO);
			}
			
			pedido.setItens(itensPedido);
			pedidos.add(pedido);
		}
		
		return pedidos;
	}

	public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setDataPedido(pedidoDTO.getDataPedido());
		
		List<ItemEntity> itensEntity = new ArrayList<ItemEntity>();
		
		for (ItemDTO itemDTO : pedidoDTO.getItens()) {
			ItemEntity itemEntity = new ItemEntity();
			itemEntity.setId(itemDTO.getId());
			itensEntity.add(itemEntity);
		}		
		
		pedidoEntity.setItens(itensEntity);
		
		PedidoEntity pedidoCriado = pedidoRepository.save(pedidoEntity);
		
		PedidoDTO pedidoDTOCriado = new PedidoDTO();
		pedidoDTOCriado.setId(pedidoCriado.getId());
		pedidoDTOCriado.setDataPedido(pedidoCriado.getDataPedido());
		
		List<ItemDTO> itensPedido = new ArrayList<ItemDTO>();
		
		for (ItemEntity itemEntity : pedidoCriado.getItens()) {
			ItemDTO itemDTO = new ItemDTO();
			itemDTO.setId(itemEntity.getId());
			itemDTO.setNome(itemEntity.getNome());
			itemDTO.setQuantidade(itemEntity.getQuantidade());
			
			itensPedido.add(itemDTO);
		}		
		
		pedidoDTOCriado.setItens(itensPedido);
		
		return pedidoDTOCriado;
	}


}
