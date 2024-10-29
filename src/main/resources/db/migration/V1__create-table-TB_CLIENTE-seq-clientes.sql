CREATE SEQUENCE SEQ_CLIENTES
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TB_CLIENTE (
    CLIENTE_ID         INTEGER DEFAULT SEQ_CLIENTES.NEXTVAL      NOT NULL,
    NOME               VARCHAR2(100)                             NOT NULL,
    CPF                VARCHAR2(11)                              NOT NULL,
    EMAIL              VARCHAR2(100)                             NOT NULL,
    SENHA              VARCHAR2(20)                              NOT NULL,
    TELEFONE           VARCHAR2(11)                              NOT NULL,
    DATA_DE_CADASTRO   DATE                                      NOT NULL,
    STATUS_CLIENTE     VARCHAR2(20)                              NOT NULL,
    TIPO_CLIENTE       VARCHAR2(20)                              NOT NULL
)