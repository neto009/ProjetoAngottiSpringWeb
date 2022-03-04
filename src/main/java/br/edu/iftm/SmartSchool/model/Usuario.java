package br.edu.iftm.SmartSchool.model;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class Usuario implements java.io.Serializable {
	// @Pattern(regexp = "/\\S+@", message="A palavra de login deve terminar com @")
	@Size(max = 10, message = "A palavra de login deve possuir no máximo 10 caracteres")
	private String login;
	private String senha;
	private String rg;
	@NotNull(message = "O telefone não pode ser vazio!")
	private String telefone;
	private Date dataNasc;
	private String email;
	private String nome;
	@Size(min = 11, message = "O CPF deve possuir exatamente 11 digitos, apenas números!")
	private String cpf;
	private String papel;
	private String logradouro;
	private String numero;
	private String estado;
	private String cidade;
	private String country;
	private String cep;

	public Usuario() {
	}

	public Usuario(
			String login,
			String senha,
			String rg,
			String telefone,
			Date dataNasc,
			String email,
			String nome,
			String cpf,
			String papel,
			String logradouro,
			String numero,
			String estado,
			String cidade,
			String country,
			String cep) {
		this.login = login;
		this.senha = senha;
		this.rg = rg;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.papel = papel;
		this.logradouro = logradouro;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.country = country;
		this.cep = cep;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPapel() {
		return this.papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
