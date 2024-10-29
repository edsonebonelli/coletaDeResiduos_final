CREATE SEQUENCE SEQ_ROTADECOLETA
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TBL_ROTA_DE_COLETA(
    ROTA_ID         INTEGER DEFAULT SEQ_ROTADECOLETA.NEXTVAL NOT NULL,
    NOME_ROTA       VARCHAR2(50)                             NOT NULL,
    DATA_COLETA     DATE                                     NOT NULL,
    HORA_INICIO     DATE                                     NOT NULL,
    HORA_TERMINO    DATE                                     NOT NULL,
    DISTANCIA_TOTAL VARCHAR2(50)                             NOT NULL,
    TIPO_ROTA       VARCHAR2(50)                             NOT NULL,
    FREQUENCIA      VARCHAR2(50)                             NOT NULL,
);