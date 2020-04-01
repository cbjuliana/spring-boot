package furb.br.devnapratica.marketplacews.dto;

import java.time.LocalDateTime;
import java.util.List;

import furb.br.devnapratica.marketplacews.entity.ItemEntity;

public class PedidoDTO {
	
	private Long id;
	
	
	private List<ItemDTO> itens;	
		
	
	private LocalDateTime dataPedido;
	

	public PedidoDTO() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ItemDTO> getItens() {
		return itens;
	}


	public void setItens(List<ItemDTO> itens) {
		this.itens = itens;
	}


	public LocalDateTime getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	

}
