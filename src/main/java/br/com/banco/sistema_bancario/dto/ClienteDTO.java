package br.com.banco.sistema_bancario.dto;

// O que é o ClienteDTO:
// O cliente vai enviar nome, cpf, email e senha — sem id. Igual ao ProdutoDTO do projeto anterior.
// Antes de criar o service, cria o ClienteDTO.java na pasta dto com esses 4 campos: nome, cpf, email, senha. Sem validações por enquanto — só os atributos com getters e setters.
// Tenta e me manda.

public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    // nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
