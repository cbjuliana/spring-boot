package furb.br.devnapratica.marketplacews.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furb.br.devnapratica.marketplacews.dto.ClienteDTO;
import furb.br.devnapratica.marketplacews.entity.ClienteEntity;
import furb.br.devnapratica.marketplacews.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> listarClientes() {
		
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		for (ClienteEntity entity : clienteRepository.findAll()) {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setId(entity.getId());
			cliente.setNome(entity.getNome());
			clientes.add(cliente);
		}
		
		return clientes;
		
	}

	public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
		
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNome(clienteDTO.getNome());
		
		ClienteEntity clienteCriado = clienteRepository.save(clienteEntity);
		
		ClienteDTO clienteDTOCriado = new ClienteDTO();
		clienteDTOCriado.setId(clienteCriado.getId());
		clienteDTOCriado.setNome(clienteCriado.getNome());
		
		return clienteDTOCriado;
	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);		
	}

}
