-- Generated by Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   at:        2023-09-27 03:40:27 BRT
--   site:      Oracle Database 21c
--   type:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_acessorio (
    cd_acessorio          INTEGER NOT NULL,
    ds_acessorio          VARCHAR2(255 CHAR) NOT NULL,
    vl_acessorio_hora     NUMBER NOT NULL,
    vl_acessorio_diaria   NUMBER(10, 2) NOT NULL,
    vl_acessorio_mes      NUMBER(10, 2) NOT NULL,
    dt_hr_cadastro        DATE NOT NULL,
    dt_hr_atualizacao     DATE,
    t_usuario_cd_usuario2 INTEGER NOT NULL,
    t_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE t_acessorio ADD CONSTRAINT t_acessorio_pk PRIMARY KEY ( cd_acessorio );

CREATE TABLE t_arquivo (
    cd_arquivo                INTEGER NOT NULL,
    ds_arquivo                VARCHAR2(100 CHAR) NOT NULL,
    ds_tamanho_arquivo_imagem VARCHAR2(255) NOT NULL,
    tp_arquivo                VARCHAR2(255 CHAR) NOT NULL,
    bin_arquivo               BLOB NOT NULL,
    dt_hr_cadastro            DATE NOT NULL,
    dt_hr_atualizacao         DATE,
    t_usuario_cd_usuario2     INTEGER NOT NULL,
    t_usuario_cd_usuario      INTEGER NOT NULL
);

ALTER TABLE t_arquivo ADD CONSTRAINT t_arquivo_pk PRIMARY KEY ( cd_arquivo );

CREATE TABLE t_documento (
    cd_documento          INTEGER NOT NULL,
    ds_documento          VARCHAR2(100 CHAR) NOT NULL,
    nr_documento          VARCHAR2(50 CHAR) NOT NULL,
    dt_data_expedicao     DATE NOT NULL,
    ds_orgao_expedidor    VARCHAR2(255 CHAR) NOT NULL,
    t_pessoa_cd_pessoa    INTEGER NOT NULL,
    t_arquivo_cd_arquivo  INTEGER,
    dt_hr_criacao         DATE NOT NULL,
    dt_hr_atualizacao     DATE,
    t_usuario_cd_usuario2 INTEGER NOT NULL,
    t_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE t_documento ADD CONSTRAINT t_documento_pk PRIMARY KEY ( cd_documento );

CREATE TABLE t_endereco (
    cd_endereco        INTEGER NOT NULL,
    ds_tipo_logradouro VARCHAR2(50 CHAR) NOT NULL,
    nm_logradouro      VARCHAR2(150 CHAR) NOT NULL,
    nr_logradouro      INTEGER,
    ds_complemento     VARCHAR2(255 CHAR),
    nr_cep             CHAR(9 CHAR) NOT NULL,
    nm_bairro          VARCHAR2(100 CHAR) NOT NULL,
    nm_municipio       VARCHAR2(100 CHAR) NOT NULL,
    nm_uf              CHAR(2 CHAR) NOT NULL,
    t_pessoa_cd_pessoa INTEGER NOT NULL
);

ALTER TABLE t_endereco ADD CONSTRAINT t_endereco_pk PRIMARY KEY ( cd_endereco );

CREATE TABLE t_locacao (
    cd_locacao         INTEGER NOT NULL,
    dt_hr_locacao      DATE NOT NULL,
    dt_hr_retirada     DATE NOT NULL,
    dt_hr_devolucao    DATE NOT NULL,
    vl_locacao         NUMBER(10, 2) NOT NULL,
    vl_desconto        NUMBER(10, 2),
    ds_tipo_pagamento  VARCHAR2(15 CHAR) NOT NULL,
    nr_cartao          CHAR(16),
    nm_bandeira_cartao VARCHAR2(50 CHAR),
    ds_tipo_cartao     VARCHAR2(10 CHAR),
    t_modelo_cd_modelo INTEGER NOT NULL,
    t_pessoa_cd_pessoa INTEGER NOT NULL
);

ALTER TABLE t_locacao ADD CONSTRAINT t_locacao_pk PRIMARY KEY ( cd_locacao );

CREATE TABLE t_locacao_acessorio (
    t_locacao_cd_locacao     INTEGER NOT NULL,
    t_acessorio_cd_acessorio INTEGER NOT NULL
);

ALTER TABLE t_locacao_acessorio ADD CONSTRAINT t_locacao_acessorio_pk PRIMARY KEY ( t_locacao_cd_locacao,
                                                                                    t_acessorio_cd_acessorio );

CREATE TABLE t_marca (
    cd_marca              INTEGER NOT NULL,
    nm_marca              VARCHAR2(150 CHAR) NOT NULL,
    dt_hr_criacao         DATE,
    dt_hr_atualizacao     DATE,
    t_usuario_cd_usuario2 INTEGER NOT NULL,
    t_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE t_marca ADD CONSTRAINT t_marca_pk PRIMARY KEY ( cd_marca );

CREATE TABLE t_modelo (
    cd_modelo             INTEGER NOT NULL,
    nm_modelo             VARCHAR2(150 CHAR) NOT NULL,
    nm_cor                VARCHAR2(50 CHAR) NOT NULL,
    nr_portas             INTEGER NOT NULL,
    ds_placa              CHAR(7 CHAR) NOT NULL,
    ds_renavam            CHAR(11) NOT NULL,
    ds_chassi             CHAR(17 CHAR) NOT NULL,
    nm_pais_origem        VARCHAR2(100 CHAR) NOT NULL,
    t_marca_cd_marca      INTEGER NOT NULL,
    ds_categoria          VARCHAR2(50 CHAR) NOT NULL,
    ds_combustivel        VARCHAR2(50 CHAR) NOT NULL,
    vl_aluguel_hora       NUMBER(10, 2) NOT NULL,
    vl_aluguel_diaria     NUMBER(10, 2) NOT NULL,
    vl_aluguel_mes        NUMBER(10, 2),
    t_usuario_cd_usuario2 INTEGER NOT NULL,
    t_usuario_cd_usuario  INTEGER NOT NULL
);

ALTER TABLE t_modelo ADD CONSTRAINT t_modelo_pk PRIMARY KEY ( cd_modelo );

CREATE TABLE t_pessoa (
    cd_pessoa INTEGER NOT NULL,
    nm_pessoa VARCHAR2(150 CHAR) NOT NULL
);

ALTER TABLE t_pessoa ADD CONSTRAINT t_pessoa_pk PRIMARY KEY ( cd_pessoa );

CREATE TABLE t_telefone (
    cd_telefone        INTEGER NOT NULL,
    nr_ddd             CHAR(2 CHAR) NOT NULL,
    nr_telefone        VARCHAR2(9 CHAR) NOT NULL,
    t_pessoa_cd_pessoa INTEGER NOT NULL,
    ds_tipo_telefone   VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE t_telefone ADD CONSTRAINT t_telefone_pk PRIMARY KEY ( cd_telefone );

CREATE TABLE t_usuario (
    cd_usuario               INTEGER NOT NULL,
    ds_email                 VARCHAR2(150 CHAR) NOT NULL,
    ds_senha                 VARCHAR2(128 CHAR) NOT NULL,
    ck_ativado               NUMBER DEFAULT 1 NOT NULL,
    t_pessoa_cd_pessoa       INTEGER NOT NULL,
    dt_hr_cadastro           DATE NOT NULL,
    dt_hr_ultima_atualizacao DATE,
    dt_hr_ultimo_login       DATE
);

CREATE UNIQUE INDEX t_usuario__idx ON
    t_usuario (
        t_pessoa_cd_pessoa
    ASC );

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( cd_usuario );

ALTER TABLE t_acessorio
    ADD CONSTRAINT t_acessorio_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_acessorio
    ADD CONSTRAINT t_acessorio_t_usuario_fkv2 FOREIGN KEY ( t_usuario_cd_usuario2 )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_arquivo
    ADD CONSTRAINT t_arquivo_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_arquivo
    ADD CONSTRAINT t_arquivo_t_usuario_fkv2 FOREIGN KEY ( t_usuario_cd_usuario2 )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_documento
    ADD CONSTRAINT t_documento_t_arquivo_fk FOREIGN KEY ( t_arquivo_cd_arquivo )
        REFERENCES t_arquivo ( cd_arquivo );

ALTER TABLE t_documento
    ADD CONSTRAINT t_documento_t_pessoa_fk FOREIGN KEY ( t_pessoa_cd_pessoa )
        REFERENCES t_pessoa ( cd_pessoa );

ALTER TABLE t_documento
    ADD CONSTRAINT t_documento_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_documento
    ADD CONSTRAINT t_documento_t_usuario_fkv2 FOREIGN KEY ( t_usuario_cd_usuario2 )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_endereco
    ADD CONSTRAINT t_endereco_t_pessoa_fk FOREIGN KEY ( t_pessoa_cd_pessoa )
        REFERENCES t_pessoa ( cd_pessoa );

ALTER TABLE t_locacao_acessorio
    ADD CONSTRAINT t_loc_acess_t_acess_fk FOREIGN KEY ( t_acessorio_cd_acessorio )
        REFERENCES t_acessorio ( cd_acessorio );

ALTER TABLE t_locacao_acessorio
    ADD CONSTRAINT t_loc_acess_t_loc_fk FOREIGN KEY ( t_locacao_cd_locacao )
        REFERENCES t_locacao ( cd_locacao );

ALTER TABLE t_locacao
    ADD CONSTRAINT t_locacao_t_modelo_fk FOREIGN KEY ( t_modelo_cd_modelo )
        REFERENCES t_modelo ( cd_modelo );

ALTER TABLE t_locacao
    ADD CONSTRAINT t_locacao_t_pessoa_fk FOREIGN KEY ( t_pessoa_cd_pessoa )
        REFERENCES t_pessoa ( cd_pessoa );

ALTER TABLE t_marca
    ADD CONSTRAINT t_marca_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_marca
    ADD CONSTRAINT t_marca_t_usuario_fkv2 FOREIGN KEY ( t_usuario_cd_usuario2 )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_modelo
    ADD CONSTRAINT t_modelo_t_marca_fk FOREIGN KEY ( t_marca_cd_marca )
        REFERENCES t_marca ( cd_marca );

ALTER TABLE t_modelo
    ADD CONSTRAINT t_modelo_t_usuario_fk FOREIGN KEY ( t_usuario_cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_modelo
    ADD CONSTRAINT t_modelo_t_usuario_fkv2 FOREIGN KEY ( t_usuario_cd_usuario2 )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_telefone
    ADD CONSTRAINT t_telefone_t_pessoa_fk FOREIGN KEY ( t_pessoa_cd_pessoa )
        REFERENCES t_pessoa ( cd_pessoa );

ALTER TABLE t_usuario
    ADD CONSTRAINT t_usuario_t_pessoa_fk FOREIGN KEY ( t_pessoa_cd_pessoa )
        REFERENCES t_pessoa ( cd_pessoa );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             1
-- ALTER TABLE                             31
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
