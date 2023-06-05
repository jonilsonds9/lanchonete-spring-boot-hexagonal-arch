//package br.com.fiap.lanchonete.service.impl;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import br.com.fiap.lanchonete.dtos.ClienteDto;
//import br.com.fiap.lanchonete.entity.Cliente;
//import br.com.fiap.lanchonete.repository.ClienteRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//class ClienteServiceImplTest {
//
//    @Mock
//    Mock mock;
//
//    @Mock
//    private ClienteRepository clienteRepository;
//
//    @InjectMocks
//    private ClienteServiceImpl clienteServiceImpl;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    public ClienteDto clienteDtoMock() {
//        ClienteDto clienteDto = new ClienteDto();
//        clienteDto.setId(1L);
//        clienteDto.setNome("Cliente Teste");
//        clienteDto.setCpf("12345678901");
//        clienteDto.setDataNascimento(LocalDate.now());
//        clienteDto.setAtivo(true);
//        clienteDto.setDataCadastro(LocalDate.now());
//        return clienteDto;
//    }
//
//    public Cliente clienteMock() {
//        Cliente cliente = new Cliente();
//        cliente.setId(1L);
//        cliente.setNome("Cliente Teste");
//        cliente.setEmail("teste.teste@gmail.com ");
//        cliente.setTelefone("11999999999");
//        cliente.setCpf("12345678901");
//        cliente.setDataNascimento(LocalDate.now());
//        cliente.setEndereco("Rua Teste, 123");
//        cliente.setSenha("123456");
//        cliente.setDataNascimento(LocalDate.now());
//        cliente.setDataCadastro(LocalDate.now());
//        cliente.setDataAtualizacao(LocalDate.now());
//        cliente.setDataExclusao(LocalDate.now());
//        cliente.setAtivo(true);
//        return cliente;
//    }
//
//    @Test
//    @DisplayName("Listar todos os clientes - com sucesso")
//    public void testFindAll() {
//        List<Cliente> clientesMock = new ArrayList<>();
//        clientesMock.add(clienteMock());
//
//        List<ClienteDto> clientesDtoMock = new ArrayList<>();
//        clientesDtoMock.add(clienteDtoMock());
//
//        when(clienteRepository.findAll()).thenReturn(clientesMock);
//        when(clienteServiceImpl.findAll()).thenReturn(clientesDtoMock);
//        List<ClienteDto> clientes = clienteServiceImpl.findAll();
//        assertTrue(clientes.isEmpty());
//    }
//
//    @Test
//    @DisplayName("Listar todos os clientes - sem sucesso")
//    public void testFindAllSemSucesso() {
//        when(clienteRepository.findAll()).thenReturn(new ArrayList<>());
//        List<ClienteDto> clientes = clienteServiceImpl.findAll();
//        assertFalse(clientes.isEmpty());
//    }
//
//    @Test
//    @DisplayName("Incluir cliente - com sucesso")
//    public void testIncluir() {
//        ClienteDto clienteDto = clienteDtoMock();
//
//        when(clienteRepository.save(clienteDto.toEntity())).thenReturn(clienteDto.toEntity());
//        ClienteDto clienteIncluido = clienteServiceImpl.incluir(clienteDto);
//
//        assertTrue(clienteIncluido.getNome().equals(clienteDto.getNome()));
//    }
//
//    @Test
//    @DisplayName("Alterar cliente - com sucesso")
//    public void testAlterar() {
//        ClienteDto clienteDto = clienteDtoMock();
//        clienteDto.setNome("Cliente Teste Alterado");
//
//        when(clienteRepository.findById(clienteDto.getId())).thenReturn(Optional.of(clienteDto.toEntity()));
//        when(clienteRepository.save(clienteDto.toEntity())).thenReturn(clienteDto.toEntity());
//        ClienteDto clienteAlterado = clienteServiceImpl.alterar(clienteDto);
//
//        assertTrue(clienteAlterado.getNome().equals(clienteDto.getNome()));
//    }
//
//    @Test
//    @DisplayName("Excluir cliente - com sucesso")
//    public void testExcluir() {
//        ClienteDto clienteDto = clienteDtoMock();
//
//        when(clienteRepository.findById(clienteDto.getId())).thenReturn(Optional.of(clienteDto.toEntity()));
//        clienteServiceImpl.excluir(clienteDto.getId());
//
//        verify(clienteServiceImpl).excluir(clienteDto.getId());
//    }
//}