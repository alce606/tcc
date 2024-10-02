package com.itb.grupo4.tcc.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 1) // Modificado para 'M' ou 'F'
    private String sexo; // 'M' ou 'F'

    @Column(name = "data_nasci", nullable = false)
    private Date data_nasci;

    @Column(length = 11) // CPF com 11 dígitos
    private String cpf;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String senha;

    @Column(name = "cod_status", nullable = false)
    private boolean codStatus;

    // Atributos de apoio
    @Transient
    private String mensagemErro = "";

    @Transient
    private boolean isValid = true;

    // Construtor padrão
    public Cadastro() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if ("M".equalsIgnoreCase(sexo) || "F".equalsIgnoreCase(sexo)) {
            this.sexo = sexo;
        } else {
            this.sexo = "I"; // I para inválido, se necessário
        }
    }

    public Date getData_nasci() {
        return data_nasci;
    }

    public void setData_nasci(Date data_nasci) {
        this.data_nasci = data_nasci;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCodStatus() {
        return codStatus;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    // Método para validar o cadastro
    public boolean validar() {
        if (nome == null || nome.isEmpty()) {
            isValid = false;
            mensagemErro = "Nome é obrigatório.";
        }
        if (!"M".equalsIgnoreCase(sexo) && !"F".equalsIgnoreCase(sexo)) {
            isValid = false;
            mensagemErro = "Sexo deve ser 'M' ou 'F'.";
        }
        // Adicione outras validações conforme necessário
        return isValid;
    }
}
