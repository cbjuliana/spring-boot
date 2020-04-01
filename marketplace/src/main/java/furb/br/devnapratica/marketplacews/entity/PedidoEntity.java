package furb.br.devnapratica.marketplacews.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pedido")
public class PedidoEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@NotNull
	private List<ItemEntity> itens;	
		
	@Column
	@NotNull
	private LocalDateTime dataPedido;
	

	public PedidoEntity() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ItemEntity> getItens() {
		return itens;
	}


	public void setItens(List<ItemEntity> itens) {
		this.itens = itens;
	}


	public LocalDateTime getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	
	
}
