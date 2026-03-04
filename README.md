# 🏦 Sistema Bancário — Spring Boot

Sistema bancário completo desenvolvido com Spring Boot, com autenticação JWT, operações financeiras, extrato de transações e arquitetura em camadas.

---

## 🎯 Objetivo

Construir um sistema bancário real com foco em segurança, boas práticas e arquitetura profissional.

---

## 🛠️ Tecnologias

- Java 25 LTS
- Spring Boot 4.1
- Spring Security + JWT
- PostgreSQL
- JPA / Hibernate
- Bean Validation
- Maven
- Visual Studio Code

---

## 🏗️ Arquitetura do Projeto

```
sistema-bancario/
└── src/main/java/br/com/banco/sistema_bancario/
    ├── controller/
    │   ├── ClienteController.java     # Endpoints de clientes
    │   ├── ContaController.java       # Endpoints de contas e operações
    │   └── AuthController.java        # Endpoints de autenticação
    ├── service/
    │   ├── ClienteService.java        # Lógica de clientes
    │   ├── ContaService.java          # Lógica bancária — depósito, saque, transferência
    │   └── AuthService.java           # Lógica de autenticação e geração de JWT
    ├── repository/
    │   ├── ClienteRepository.java     # Acesso ao banco — clientes
    │   ├── ContaRepository.java       # Acesso ao banco — contas
    │   └── TransacaoRepository.java   # Acesso ao banco — transações
    ├── model/
    │   ├── Cliente.java               # Entidade cliente
    │   ├── Conta.java                 # Entidade conta — relacionamento ManyToOne com Cliente
    │   └── Transacao.java             # Entidade transação — histórico de operações
    ├── dto/
    │   ├── ClienteDTO.java            # Dados de cadastro de cliente
    │   ├── ContaDTO.java              # Dados de criação de conta
    │   ├── OperacaoDTO.java           # Dados de depósito, saque e transferência
    │   └── LoginDTO.java              # Dados de autenticação
    ├── exception/
    │   └── GlobalExceptionHandler.java # Tratamento centralizado de erros
    └── security/
        ├── SecurityConfig.java        # Configuração do Spring Security
        ├── JwtUtil.java               # Geração e validação de tokens JWT
        └── JwtFilter.java             # Filtro de autenticação por token
```

---

## 📝 Funcionalidades

### Clientes
- Cadastro de cliente com senha criptografada (BCrypt)
- Listagem e busca por ID

### Contas
- Criação de conta vinculada a um cliente
- Número de conta gerado automaticamente
- Saldo inicial zero

### Operações Financeiras
- **Depósito** — adiciona valor ao saldo e registra transação
- **Saque** — subtrai valor do saldo com validação de saldo suficiente
- **Transferência** — saca de uma conta e deposita em outra atomicamente

### Extrato
- Listagem de todas as transações de uma conta
- Filtro por tipo (DEPOSITO, SAQUE, TRANSFERENCIA)
- Data e hora de cada operação

### Segurança
- Autenticação via JWT
- Rotas protegidas — apenas usuários autenticados acessam operações financeiras
- Senhas criptografadas com BCrypt

---

## 🔌 Endpoints

### Autenticação
| Método | URL | Descrição |
|--------|-----|-----------|
| POST | /auth/login | Autentica e retorna token JWT |

### Clientes
| Método | URL | Descrição | Auth |
|--------|-----|-----------|------|
| POST | /clientes | Cadastra novo cliente | ❌ |
| GET | /clientes | Lista todos os clientes | ✅ |
| GET | /clientes/{id} | Busca cliente por ID | ✅ |

### Contas
| Método | URL | Descrição | Auth |
|--------|-----|-----------|------|
| POST | /contas | Cria conta para um cliente | ✅ |
| GET | /contas/{id} | Busca conta por ID | ✅ |
| POST | /contas/{id}/depositar | Realiza depósito | ✅ |
| POST | /contas/{id}/sacar | Realiza saque | ✅ |
| POST | /contas/transferir | Realiza transferência | ✅ |
| GET | /contas/{id}/extrato | Lista transações da conta | ✅ |

---

## 📋 Exemplos de Requisição

**Cadastrar cliente — POST /clientes**
```json
{
    "nome": "Yuri Marvila",
    "cpf": "12345678901",
    "email": "yuri@email.com",
    "senha": "senha123"
}
```

**Login — POST /auth/login**
```json
{
    "email": "yuri@email.com",
    "senha": "senha123"
}
```

**Resposta do login**
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

**Depósito — POST /contas/1/depositar**
```json
{
    "valor": 1000.00
}
```

**Transferência — POST /contas/transferir**
```json
{
    "contaOrigemId": 1,
    "contaDestinoId": 2,
    "valor": 500.00
}
```

**Extrato — GET /contas/1/extrato**
```json
[
    {
        "tipo": "DEPOSITO",
        "valor": 1000.00,
        "dataHora": "2026-03-03T10:00:00"
    },
    {
        "tipo": "TRANSFERENCIA",
        "valor": 500.00,
        "dataHora": "2026-03-03T10:30:00"
    }
]
```

---

## 🚀 Como Executar

**Pré-requisitos:** Java 25, Maven, PostgreSQL

1. Clone o repositório
```bash
git clone https://github.com/yurimarvila/sistema-bancario.git
```

2. Crie o banco de dados no PostgreSQL
```sql
CREATE DATABASE sistema_bancario;
```

3. Configure as credenciais em `src/main/resources/application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sistema_bancario
spring.datasource.username=postgres
spring.datasource.password=sua_senha
jwt.secret=sua_chave_secreta
```

4. Execute a aplicação pelo VS Code ou pelo terminal
```bash
./mvnw spring-boot:run
```

5. Acesse `http://localhost:8080`

---

## 🔐 Como usar a autenticação

1. Cadastre um cliente em `POST /clientes`
2. Faça login em `POST /auth/login` e copie o token retornado
3. Em todas as requisições protegidas, adicione o header:
```
Authorization: Bearer seu_token_aqui
```

---

## 📈 Próximos Passos

- Testes unitários com JUnit + Mockito
- Docker + Docker Compose
- Deploy em produção
- Paginação no extrato

---

## 👨‍💻 Autor

**Yuri Fernandes Marvila** — estudante de Ciência da Computação, focado em desenvolvimento back-end com Java e Spring Boot.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Yuri_Fernandes-blue)](https://www.linkedin.com/in/yuri-fernandes-marvila)
[![GitHub](https://img.shields.io/badge/GitHub-yurimarvila-black)](https://github.com/yurimarvila)