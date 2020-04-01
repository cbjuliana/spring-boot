package furb.br.devnapratica.marketplacews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import furb.br.devnapratica.marketplacews.entity.PedidoEntity;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
	
	

}
