package br.com.fiap.lanchonete.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ClientesDto;

@Service
public interface ClientesService {
    public List<ClientesDto> findAll();

    public ClientesDto incluir(ClientesDto clienteDtoRequest );

    public ClientesDto alterar(ClientesDto clienteDtoRequest);

    public void excluir(Long id);

	public ClientesDto findByCPF(String cpf);
}
