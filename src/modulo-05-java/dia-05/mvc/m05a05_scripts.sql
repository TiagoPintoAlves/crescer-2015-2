CREATE USER mvc IDENTIFIED BY oracle;

GRANT CONNECT, RESOURCE, CREATE VIEW TO mvc;

CREATE SEQUENCE endereco_seq
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE pessoa_seq
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE email_seq
  START WITH 1
  INCREMENT BY 1;

CREATE TABLE endereco
  (
     idendereco       NUMBER(10) PRIMARY KEY,
     enderecocompleto VARCHAR2(50) NOT NULL
  );

CREATE TABLE pessoa
  (
     idpessoa   NUMBER(10) PRIMARY KEY,
     nome       VARCHAR2(50) NOT NULL,
     idendereco NUMBER(10),
     CONSTRAINT endereco_fk FOREIGN KEY (idendereco) REFERENCES endereco(
     idendereco)
  );

CREATE TABLE email
  (
     idemail  NUMBER(10) PRIMARY KEY,
     idpessoa NUMBER(10) NOT NULL,
     email    VARCHAR2(50),
     CONSTRAINT pessoa_fk FOREIGN KEY (idpessoa) REFERENCES pessoa(idpessoa)
  );

INSERT INTO endereco
VALUES      (endereco_seq.NEXTVAL,
             'Rua xyz, 345' );

INSERT INTO pessoa
VALUES      (pessoa_seq.NEXTVAL,
             'João da Silva',
             1 );

INSERT INTO email
VALUES      (email_seq.NEXTVAL,
             1,
             'joao@gmail.com' );

commit;
