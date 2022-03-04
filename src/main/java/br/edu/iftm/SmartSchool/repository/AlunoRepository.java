package br.edu.iftm.SmartSchool.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.edu.iftm.SmartSchool.model.Aluno;
import br.edu.iftm.SmartSchool.model.Usuario;

@Repository
public class AlunoRepository {

        @Autowired
        JdbcTemplate jdbc;

        public AlunoRepository() {

        }

        public List<Aluno> buscaTodosAlunos() {
                String consulta = "SELECT * FROM aluno, usuario where usuario.login = aluno.usuario_login;";
                return jdbc.query(consulta,
                                (res, linha) -> new Aluno(
                                                new Usuario(
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
                                                                res.getString("cep")),
                                                res.getString("matricula"),
                                                res.getString("nomeMae"),
                                                res.getString("nomePai"),
                                                res.getString("telefoneMae"),
                                                res.getString("telefonePai"),
                                                res.getString("emailMae"),
                                                res.getString("emailPai"),
                                                res.getDate("data_matricula")));
        }

        public Integer gravaAluno(Aluno aluno) {
                Usuario us = aluno.getUsuario();
                String sqlUsuario = "insert into usuario(login, senha, rg, telefone, dataNasc, email, nome, cpf, papel, logradouro, numero, estado, cidade, country, cep) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                String sqlAluno = "insert into aluno(matricula, nomeMae, nomePai, telefoneMae, telefonePai, emailMae, emailPai, dataMatricula, usuario_login) values(?,?,?,?,?,?,?,?,?)";

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

                String encodedPassword = passwordEncoder.encode(us.getSenha());

                us.setSenha(encodedPassword);
                us.setPapel("aluno");
                jdbc.update(
                                sqlUsuario,
                                us.getLogin(),
                                us.getSenha(),
                                us.getRg(),
                                us.getTelefone(),
                                us.getDataNasc(),
                                us.getEmail(),
                                us.getNome(),
                                us.getCpf(),
                                us.getPapel(),
                                us.getLogradouro(),
                                us.getNumero(),
                                us.getEstado(),
                                us.getCidade(),
                                us.getCountry(),
                                us.getCep());
                return jdbc.update(
                                sqlAluno,
                                aluno.getMatricula(),
                                aluno.getNomeMae(),
                                aluno.getNomePai(),
                                aluno.getTelefoneMae(),
                                aluno.getTelefonePai(),
                                aluno.getEmailMae(),
                                aluno.getEmailPai(),
                                aluno.getDataMatricula(),
                                aluno.getUsuario().getLogin());
        }

        public Integer excluirAluno(String id) {
                String sqlAluno = "delete from aluno where usuario_login = ?";
                String sqlUsuario = "delete from usuario where login= ?";
                jdbc.update(sqlAluno, id);
                return jdbc.update(sqlUsuario, id);
        }

        public Integer atualizarAluno(String cpf, Aluno aluno) {
                Usuario us = aluno.getUsuario();
                String sqlAluno = "update aluno set matricula = ?,nomeMae = ?,nomePai = ?, telefoneMae = ?, telefonePai = ?, emailMae = ?, emailPai = ?, dataMatricula = ? where usuario_login = ?";
                String sqlUsuario = "update usuario set rg = ?, telefone = ?, dataNasc = ?, email = ?, nome = ?, cpf = ?, logradouro = ? numero = ?, estado = ?, cidade = ?, country = ?, cep = ? where login = ?";
                jdbc.update(
                                sqlAluno,
                                aluno.getMatricula(),
                                aluno.getNomeMae(),
                                aluno.getNomePai(),
                                aluno.getTelefoneMae(),
                                aluno.getTelefonePai(),
                                aluno.getEmailMae(),
                                aluno.getEmailPai(),
                                aluno.getDataMatricula(),
                                aluno.getUsuario().getLogin());
                return jdbc.update(
                                sqlUsuario,
                                us.getLogin(),
                                us.getSenha(),
                                us.getRg(),
                                us.getTelefone(),
                                us.getDataNasc(),
                                us.getEmail(),
                                us.getNome(),
                                us.getCpf(),
                                us.getPapel(),
                                us.getLogradouro(),
                                us.getNumero(),
                                us.getEstado(),
                                us.getCidade(),
                                us.getCountry(),
                                us.getCep());
        }

        public Aluno buscaPorLogin(String login) {
                return jdbc.queryForObject(
                                "SELECT * FROM aluno, usuario where usuario.login = aluno.usuario_login and usuario.login = ? ;",
                                (res, linha) -> new Aluno(
                                                new Usuario(
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
                                                                res.getString("cep")),
                                                res.getString("matricula"),
                                                res.getString("nomeMae"),
                                                res.getString("nomePai"),
                                                res.getString("telefoneMae"),
                                                res.getString("telefonePai"),
                                                res.getString("emailMae"),
                                                res.getString("emailPai"),
                                                res.getDate("dataMatricula")),
                                login);
        }

        public Aluno buscaPorCpf(String cpf) {
                return jdbc.queryForObject(
                                "select * from aluno, usuario where usuario.login = aluno.usuario_login and usuario.cpf = ? ;",
                                (res, rowNum) -> {
                                        return new Aluno(
                                                        new Usuario(
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
                                                                        res.getString("cep")),
                                                        res.getString("matricula"),
                                                        res.getString("nomeMae"),
                                                        res.getString("nomePai"),
                                                        res.getString("telefoneMae"),
                                                        res.getString("telefonePai"),
                                                        res.getString("emailMae"),
                                                        res.getString("emailPai"),
                                                        res.getDate("dataMatricula"));
                                }, new Object[] { cpf });
        }
}
