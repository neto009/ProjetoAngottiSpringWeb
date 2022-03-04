package br.edu.iftm.SmartSchool.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.iftm.SmartSchool.model.Usuario;

@Repository
public class UsuarioRepository {
    @Autowired
    JdbcTemplate jdbc;

    public Usuario buscaPorLogin(String username) {
        return jdbc.queryForObject(
                "select * from usuario where login = ?",
                (res, linha) -> {
                    return new Usuario(
                            res.getString("login"),
                            res.getString("senha"),
                            res.getString("rg"),
                            res.getString("telefone"),
                            res.getDate("dataNasc"),
                            res.getString("email"),
                            res.getString("nome"),
                            res.getString("cpf"),
                            res.getString("papel"),
                            res.getString("logradouro"),
                            res.getString("numero"),
                            res.getString("estado"),
                            res.getString("cidade"),
                            res.getString("country"),
                            res.getString("cep"));
                },
                username);
    }

    public Usuario buscaPorEmail(String email) {
        return jdbc.queryForObject(
                "select * from usuario where email = ?",
                (res, linha) -> {
                    return new Usuario(
                        res.getString("login"),
                        res.getString("senha"),
                        res.getString("rg"),
                        res.getString("telefone"),
                        res.getDate("dataNasc"),
                        res.getString("email"),
                        res.getString("nome"),
                        res.getString("cpf"),
                        res.getString("papel"),
                        res.getString("logradouro"),
                        res.getString("numero"),
                        res.getString("estado"),
                        res.getString("cidade"),
                        res.getString("country"),
                        res.getString("cep"));
                },
                email);
    }
}
