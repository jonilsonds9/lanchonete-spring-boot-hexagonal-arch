# lanchonete

# Para acessar o documento swagger
	http://localhost:8081/fiap/swagger-ui.html

#Porta : 8081

## Exemplo de Json

- Listar todos os clientes...

```json
GET http://localhost:8081/fiap/api/clientes
```

- Incluir cliente

```json
POST http://localhost:8081/fiap/api/clientes
{
    "cpf": "123.456.789-01",
    "nome": "testefdg",
    "email": "teste.test@gmail.com",
    "telefone": "(99) 99999-9999",
    "endereco": {
        "logradouro": {
            "id": 33,
            "nome": "Rua"
        },
        "endereco": "Av. Paulista",
        "numero": "1012",
        "complemento": "bloco 01",
        "bairro": "bela vista",
        "cidade": "São Paulo",
        "estado": "São Paulo",
        "cep": "12345-678"
    },
    "dataNascimento": "2022-02-13"
}
```

- Alterar cliente

```json
PUT http://localhost:8081/fiap/api/clientes
{
    "cpf": "123.456.789-01",
    "nome": "testefdg",
    "email": "teste.test@gmail.com",
    "telefone": "(99) 99999-9999",
    "endereco": {
        "logradouro": {
            "id": 33,
            "nome": "Rua"
        },
        "endereco": "Av. Paulista",
        "numero": "1012",
        "complemento": "bloco 01",
        "bairro": "bela vista",
        "cidade": "São Paulo",
        "estado": "São Paulo",
        "cep": "12345-678"
    },
    "dataNascimento": "2022-02-13"
}
```

- Excluir cliente

```json
DELETE http://localhost:8081/fiap/api/clientes/1
```

- Pesquiar cliente por CPF

```json
GET http://localhost:8081/fiap/api/clientes/1
```