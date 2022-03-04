CREATE TABLE IF NOT EXISTS `usuario`
(
  `login` varchar
(11) NOT NULL,
  `senha` varchar
(64) NOT NULL,
  `rg` varchar
(11) NOT NULL,
  `telefone` varchar
(11) DEFAULT NULL,
  `dataNasc` date NOT NULL,
  `email` varchar
(50) NOT NULL UNIQUE,
  `nome` varchar
(100) NOT NULL,
  `cpf` VARCHAR
(11) NOT NULL UNIQUE,
  `logradouro` varchar
(200) DEFAULT NULL,
  `numero` varchar
(200) DEFAULT NULL,
  `estado` varchar
(200) DEFAULT NULL,
  `cidade` varchar
(200) DEFAULT NULL,
  `country` varchar
(200) DEFAULT NULL,
  `cep` varchar
(8) DEFAULT NULL,
  `reset_password_token` varchar
(45) DEFAULT NULL,
`papel` SET ('admin', 'aluno', 'professor'),
  PRIMARY KEY
(`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `administrador`
(
  `cod_adm` varchar
(11) DEFAULT NULL,
  `usuario_login` varchar
(10) NOT NULL,
  PRIMARY KEY
(`usuario_login`),
  CONSTRAINT `fk_administrador_usuario1` FOREIGN KEY
(`usuario_login`) REFERENCES `usuario`
(`login`) ON
DELETE NO ACTION ON
UPDATE NO ACTION
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `aluno`
(
  `matricula` varchar
(14) DEFAULT NULL,
  `nomeMae` varchar
(100) DEFAULT NULL,
  `nomePai` varchar
(100) DEFAULT NULL,
  `emailMae` varchar
(100) DEFAULT NULL,
  `emailPai` varchar
(100) DEFAULT NULL,
  `telefoneMae` varchar
(11) DEFAULT NULL,
  `telefonePai` varchar
(11) DEFAULT NULL,
 `dataMatricula` date NOT NULL,
  `usuario_login` varchar
(10) NOT NULL,
  PRIMARY KEY
(`usuario_login`),
  CONSTRAINT `fk_aluno_usuario1` FOREIGN KEY
(`usuario_login`) REFERENCES `usuario`
(`login`) ON
DELETE NO ACTION ON
UPDATE NO ACTION
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `professor`
(
  `cod_professor` varchar
(11) DEFAULT NULL,
  `usuario_login` varchar
(10) NOT NULL,
  PRIMARY KEY
(`usuario_login`),
  CONSTRAINT `fk_professor_usuario1` FOREIGN KEY
(`usuario_login`) REFERENCES `usuario`
(`login`) ON
DELETE NO ACTION ON
UPDATE NO ACTION
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `sala`
(
  `cod_sala` varchar
(11) NOT NULL,
  `local_sala` varchar
(200) NOT NULL,
  `qtd_alunos` int
(200) NOT NULL,
  `turma` varchar
(10) DEFAULT NULL,
  PRIMARY KEY
(`cod_sala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
