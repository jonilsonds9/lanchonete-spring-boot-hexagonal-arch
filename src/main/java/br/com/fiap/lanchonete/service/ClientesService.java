package br.com.fiap.lanchonete.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ClientesDto;

@Service
public interface ClientesService {
    
	public ResponseEntity<Object> findAll();

    public ResponseEntity<Object> incluir(ClientesDto clienteDtoRequest );

    public ResponseEntity<Object> alterar(ClientesDto clienteDtoRequest);

    public ResponseEntity<Object> excluir(Long id);

	public ResponseEntity<Object> findByCPF(String cpf);
}
