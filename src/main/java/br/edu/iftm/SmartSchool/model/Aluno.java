package br.edu.iftm.SmartSchool.model;

import java.sql.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Aluno implements java.io.Serializable {
    @Valid
    private Usuario usuario;
    private String matricula;
    private String nomeMae;
    @Size(min=3,message="O nome pai com 3 letras")
    private String nomePai;
    @NotNull(message = "O telefone não pode ser vazio!")
    private String telefoneMae;
    @NotNull(message = "O telefone não pode ser vazio!")
    private String telefonePai;
    private String emailMae;
    private String emailPai;
    private Date dataMatricula;

    public Aluno() {
    }

    public Aluno(Usuario usuario, String matricula, String nomeMae, String nomePai, String telefoneMae, String telefonePai, String emailMae, String emailPai, Date dataMatricula) {
        this.usuario = usuario;
        this.matricula = matricula;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.telefoneMae = telefoneMae;
        this.telefonePai = telefonePai;
        this.emailMae = emailMae;
        this.emailPai = emailPai;
        this.dataMatricula = dataMatricula;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return this.nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    
    public String getTelefoneMae() {
        return this.telefoneMae;
    }

    public void setTelefoneMae(String telefoneMae) {
        this.telefoneMae = telefoneMae;
    }

    public String getTelefonePai() {
        return this.telefonePai;
    }

    public void setTelefonePai(String telefonePai) {
        this.telefonePai = telefonePai;
    }

    public String getEmailMae() {
        return this.emailMae;
    }

    public void setEmailMae(String emailMae) {
        this.emailMae = emailMae;
    }

    public String getEmailPai() {
        return this.emailPai;
    }

    public void setEmailPai(String emailPai) {
        this.emailPai = emailPai;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

}
