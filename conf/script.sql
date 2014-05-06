--  Criando SCHEMA
DROP SCHEMA IF EXISTS cardb;
CREATE SCHEMA IF NOT EXISTS cardb;

-- criando base de dados
CREATE DATABASE CarDB;

--  Usando o SCHEMA
USE CarDB;

SET FOREIGN_KEY_CHECKS=0;

-- Drop table Ministrante
DROP TABLE IF EXISTS `Ministrante`;

CREATE TABLE `Ministrante` (
  `codigoMinistrante` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY(`codigoMinistrante`)
)
ENGINE=INNODB;

-- Drop table Professor
DROP TABLE IF EXISTS `Professor`;

CREATE TABLE `Professor` (
  `codigoProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `ramal` int(5) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY(`codigoProfessor`)
)
ENGINE=INNODB;

-- Drop table Curso
DROP TABLE IF EXISTS `Curso`;

CREATE TABLE `Curso` (
  `codigoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCurso` varchar(50) NOT NULL,
  `numeroAlunos` varchar(50) NOT NULL,
  `cursoPertence` varchar(200) NOT NULL,
  `duracaoCurso` varchar(50) NOT NULL,
  `softwareNecessario` varchar(200),
  `cursoPago` varchar(4),
  `publicoAlvo` varchar(1000),
  `finalidade` varchar(10000),
  PRIMARY KEY(`codigoCurso`)
)
ENGINE=INNODB;

-- Drop table Usuario
DROP TABLE IF EXISTS `Usuario`;

CREATE TABLE `Usuario` (
  `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ramal` varchar(5),
  PRIMARY KEY(`codigoUsuario`)
)
ENGINE=INNODB;

-- Drop table HorarioSemanal
DROP TABLE IF EXISTS `HorarioSemanal`;

CREATE TABLE `HorarioSemanal` (
  `codigoHorario` int(20) NOT NULL AUTO_INCREMENT,
  `dia` varchar(4),
  `inicio` varchar(4),
  `fim` varchar(4),
  PRIMARY KEY(`codigoHorario`)
)
ENGINE=INNODB;

-- Drop table Disciplina
DROP TABLE IF EXISTS `Disciplina`;

CREATE TABLE `Disciplina` (
  `codigoDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `disciplina` varchar(50) NOT NULL,
  `totalAlunos` varchar(50) NOT NULL,
  `curso` varchar(200) NOT NULL,
  `periodicidade` varchar(20) NOT NULL,
  `periodo` varchar(10) NOT NULL,
  `salaAtual` varchar(10) NOT NULL,
  `linkMaterial` varchar(100),
  `material` longblob,
  PRIMARY KEY(`codigoDisciplina`)
)
ENGINE=INNODB;

-- Drop table Auto_Atendimento
DROP TABLE IF EXISTS `Auto_Atendimento`;

CREATE TABLE `Auto_Atendimento` (
  `numeroDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `dataSemanal` varchar(100),
  `codigoUsuario_FK` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY(`numeroDocumento`),
  CONSTRAINT `tem_usuario` FOREIGN KEY (`codigoUsuario_FK`)
    REFERENCES `Usuario`(`codigoUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
ENGINE=INNODB;

-- Drop table Sugestao
DROP TABLE IF EXISTS `Sugestao`;

CREATE TABLE `Sugestao` (
  `sugestao` varchar(10000),
  `numeroDocumento_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_04` FOREIGN KEY (`numeroDocumento_FK`)
    REFERENCES `Auto_Atendimento`(`numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table Outro
DROP TABLE IF EXISTS `Outro`;

CREATE TABLE `Outro` (
  `comentario` varchar(10000),
  `numeroDocumento_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_05` FOREIGN KEY (`numeroDocumento_FK`)
    REFERENCES `Auto_Atendimento`(`numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table FormularioLaboratorio
DROP TABLE IF EXISTS `FormularioLaboratorio`;

CREATE TABLE `FormularioLaboratorio` (
  `codigoSolab` int(11) NOT NULL AUTO_INCREMENT,
  `numeroMaquinas` int(11),
  `cursoPodeSerNoturno` varchar(10),
  `justificativaNoturno` varchar(5200),
  `cursoPodeSerNoSabado` varchar(10),
  `justificativaSabado` varchar(5200),
  `turnoSabado` varchar(10),
  `contribuicao` varchar(10000),
  `dataDeCriacao` varchar(100) NOT NULL,
  `codigoCurso_FK` int(11) DEFAULT '0',
  `codigoMinistrante_FK` int(11) DEFAULT '0',
  `codigoHorario1_FK` int(20) NOT NULL DEFAULT '0',
  `codigoHorario2_FK` int(20) NOT NULL DEFAULT '0',
  `codigoHorario3_FK` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY(`codigoSolab`),
  CONSTRAINT `Ref_14` FOREIGN KEY (`codigoCurso_FK`)
    REFERENCES `Curso`(`codigoCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ref_13` FOREIGN KEY (`codigoMinistrante_FK`)
    REFERENCES `Ministrante`(`codigoMinistrante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `Ref_17` FOREIGN KEY (`codigoHorario1_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `Ref_28` FOREIGN KEY (`codigoHorario2_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `Ref_29` FOREIGN KEY (`codigoHorario3_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table FormularioSala
DROP TABLE IF EXISTS `FormularioSala`;

CREATE TABLE `FormularioSala` (
  `codigoSoAula` int(11) NOT NULL AUTO_INCREMENT,
  `disciplinaPodeSerNoturno` varchar(4),
  `justificativaNoturna` text,
  `disciplinaPodeSerNoSabado` varchar(4),
  `justificativaSabado` text,
  `turnoParaSerSabado` varchar(10),
  `contribuicao` text,
  `dataDeCriacao` varchar(100) NOT NULL,
  `equipamentosFrequentes` text,
  `equipamentosIndispensaveis` text,
  `equipamentosNaoDisponiveis` text,
  `equipamentosNaoUtilizados` text,
  `codigoDisciplina_FK` int(11) NOT NULL DEFAULT '0',
  `codigoProfessor_FK` int(11) NOT NULL DEFAULT '0',
  `codigoHorario1_FK` int(20) NOT NULL DEFAULT '0',
  `codigoHorario2_FK` int(20) NOT NULL DEFAULT '0',
  `codigoHorario3_FK` int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY(`codigoSoAula`),
  CONSTRAINT `Ref_12` FOREIGN KEY (`codigoDisciplina_FK`)
    REFERENCES `Disciplina`(`codigoDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ref_16` FOREIGN KEY (`codigoProfessor_FK`)
    REFERENCES `Professor`(`codigoProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ref_30` FOREIGN KEY (`codigoHorario1_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `Ref_31` FOREIGN KEY (`codigoHorario2_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `Ref_32` FOREIGN KEY (`codigoHorario3_FK`)
    REFERENCES `HorarioSemanal`(`codigoHorario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table Servico
DROP TABLE IF EXISTS `Servico`;

CREATE TABLE `Servico` (
  `numeroDocumento_FK` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY(`numeroDocumento_FK`),
  CONSTRAINT `Ref_03` FOREIGN KEY (`numeroDocumento_FK`)
    REFERENCES `Auto_Atendimento`(`numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table Reclamacao
DROP TABLE IF EXISTS `Reclamacao`;

CREATE TABLE `Reclamacao` (
  `tipo` varchar(11) NOT NULL,
  `descricao` varchar(10000),
  `numeroDocumento_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_18` FOREIGN KEY (`numeroDocumento_FK`)
    REFERENCES `Auto_Atendimento`(`numeroDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table InstalacaoSoftware
DROP TABLE IF EXISTS `InstalacaoSoftware`;

CREATE TABLE `InstalacaoSoftware` (
  `nomeSoftware` varchar(50) NOT NULL,
  `link` varchar(100) NOT NULL,
  `localInstalacao` varchar(500) NOT NULL,
  `numeroDocumento_FK_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_19` FOREIGN KEY (`numeroDocumento_FK_FK`)
    REFERENCES `Servico`(`numeroDocumento_FK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table Manutencao
DROP TABLE IF EXISTS `Manutencao`;

CREATE TABLE `Manutencao` (
  `tipo` varchar(20) NOT NULL,
  `descricao` varchar(10000) NOT NULL,
  `numeroDocumento_FK_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_22` FOREIGN KEY (`numeroDocumento_FK_FK`)
    REFERENCES `Servico`(`numeroDocumento_FK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table ServicoConta
DROP TABLE IF EXISTS `ServicoConta`;

CREATE TABLE `ServicoConta` (
  `tipo` varchar(20) NOT NULL,
  `justificativa` varchar(10000) NOT NULL,
  `conta` varchar(50) NOT NULL,
  `numeroDocumento_FK_FK` int(11) NOT NULL DEFAULT '0',
  CONSTRAINT `Ref_20` FOREIGN KEY (`numeroDocumento_FK_FK`)
    REFERENCES `Servico`(`numeroDocumento_FK`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

SET FOREIGN_KEY_CHECKS=1;