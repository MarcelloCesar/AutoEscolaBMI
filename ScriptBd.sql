CREATE DATABASE AUTOESCOLABMI;
USE AUTOESCOLABMI;
CREATE TABLE ATOR(
	IDATOR INT AUTO_INCREMENT NOT NULL,
	NOME VARCHAR(300),
	CPF VARCHAR (11),
	RG VARCHAR(9),
	DATAINCLUSAO DATE,
	DATANASCIMENTO DATE,	
	
	CONSTRAINT PK_ATOR PRIMARY KEY (IDATOR)
);
CREATE UNIQUE INDEX IDX_ATOR_CPF ON ATOR(CPF);

CREATE TABLE ACESSO(
	IDATOR INT NOT NULL,
	LOGIN VARCHAR(20) NOT NULL,
	SENHA VARCHAR(20) NOT NULL,
	HORARIOINICIO TIME,
	HORARIOFIM TIME,
	DATAINICIO DATE,
	DATAFIM DATE,
	
	CONSTRAINT PK_ACESSO PRIMARY KEY (IDATOR),
	CONSTRAINT FK_ACESSO_ATOR FOREIGN KEY(IDATOR) 
		REFERENCES ATOR(IDATOR)
);
CREATE UNIQUE INDEX IDX_ACESSO_LOGIN ON ACESSO(LOGIN);

INSERT INTO ATOR(IDATOR, NOME) VALUES (0, 'ADMIN');
INSERT INTO ACESSO(IDATOR, LOGIN, SENHA) VALUES (0, 'ADMIN', 'ADMIN');
CREATE TABLE MUNICIPIO(
	IDMUNICIPIO INT NOT NULL,
	DESCRICAO VARCHAR(200),
	
	CONSTRAINT PK_MUNICIPIO PRIMARY KEY (IDMUNICIPIO)
);

CREATE TABLE LOGRADOURO(
	IDLOGRADOURO INT NOT NULL,
	DESCRICAO VARCHAR(200),
	
	CONSTRAINT PK_LOGRADOURO PRIMARY KEY (IDLOGRADOURO)
);

CREATE TABLE BAIRRO(
	IDBAIRRO INT NOT NULL,
	DESCRICAO VARCHAR(200),
	
	CONSTRAINT PK_BAIRRO PRIMARY KEY (IDBAIRRO)
);

CREATE TABLE ENDERECO(
	IDATOR INT NOT NULL,
	IDMUNICIPIO INT,
	IDLOGRADOURO INT,
	IDBAIRRO INT,
	NUMERO VARCHAR(10),
	
	CONSTRAINT PK_ENDERECO PRIMARY KEY (IDATOR),
	CONSTRAINT FK_ENDERECO_ATOR FOREIGN KEY (IDATOR)
		REFERENCES ATOR(IDATOR),
	CONSTRAINT FK_ENDERECO_MUNICIPIO FOREIGN KEY (IDMUNICIPIO)
		REFERENCES MUNICIPIO(IDMUNICIPIO),
	CONSTRAINT FK_ENDERECO_LOGRADOURO FOREIGN KEY (IDLOGRADOURO)
		REFERENCES LOGRADOURO(IDLOGRADOURO),
	CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (IDBAIRRO)
		REFERENCES BAIRRO(IDBAIRRO)	
);

CREATE TABLE EMAIL(
	IDATOR INT NOT NULL,
	PRIORIDADEEMAIL INT NOT NULL,
	EMAILATIVO VARCHAR(1) NOT NULL DEFAULT 'T',
	EMAIL VARCHAR(50),
	
	CONSTRAINT PK_EMAIL PRIMARY KEY (IDATOR, PRIORIDADEEMAIL),
	CONSTRAINT FK_EMAIL_ATOR FOREIGN KEY (IDATOR)
		REFERENCES ATOR(IDATOR),
	CONSTRAINT CHK_EMAIL_ATIVO CHECK (ENDERECOATIVO = 'T' OR ENDERECOATIVO = 'F')	
);

CREATE TABLE TELEFONE(
	IDATOR INT NOT NULL,
	PRIORIDADETELEFONE INT NOT NULL,
	TELEFONEATIVO VARCHAR(1) NOT NULL DEFAULT 'T',
	-- REGIAO VARCHAR(3),
	-- DDD VARCHAR(3),
	NUMERO VARCHAR(15),
	
	CONSTRAINT PK_TELEFONE PRIMARY KEY (IDATOR, PRIORIDADETELEFONE),
	CONSTRAINT FK_TELEFONE_ATOR FOREIGN KEY (IDATOR) 
		REFERENCES ATOR (IDATOR), 
	CONSTRAINT CHK_TELEFONE_ATIVO CHECK (TELEFONEATIVO = 'T' OR TELEFONEATIVO = 'F')	
);

CREATE TABLE CATEGORIA(
	CODCATEGORIA VARCHAR(3) NOT NULL,
	DESCRICAO VARCHAR(50),
	DESCRICAODETALHADA VARCHAR(500),
	IDADEMINIMA INT,
	CATEGORIAMINIMA VARCHAR(3),
	DESCRICAORESTRICAO VARCHAR(500),
	
	CONSTRAINT PK_CATEGORIA PRIMARY KEY (CODCATEGORIA),
	CONSTRAINT FK_CATEGORIA_CATEGORIA FOREIGN KEY (CATEGORIAMINIMA)
		REFERENCES CATEGORIA(CODCATEGORIA)
);

INSERT INTO CATEGORIA(CODCATEGORIA,
					  DESCRICAO,						
				      DESCRICAODETALHADA,
				      IDADEMINIMA,
				      CATEGORIAMINIMA,
				      DESCRICAORESTRICAO)
VALUES ('A',
		'Categoria A (Motos)',
        'Condutor de veículo motorizado de duas ou três rodas, com ou sem carro lateral (motos).',
        NULL,
        NULL,
        NULL);
        
INSERT INTO CATEGORIA(CODCATEGORIA,
			  DESCRICAO,						
			  DESCRICAODETALHADA,
			  IDADEMINIMA,
			  CATEGORIAMINIMA,
			  DESCRICAORESTRICAO)
VALUES ('B',
		'Categoria B (Carros)',
        'Condutor de veículo motorizado não abrangido pela categoria A, com peso bruto total inferior a 3.500 quilos e lotação máxima de oito lugares, além do motorista (automóveis).',
        NULL,
        NULL,
        NULL);
        
INSERT INTO CATEGORIA(CODCATEGORIA,
			  DESCRICAO,						
			  DESCRICAODETALHADA,
			  IDADEMINIMA,
			  CATEGORIAMINIMA,
			  DESCRICAORESTRICAO)
VALUES ('A/B',
		'Categoria A/B (Carros e Motos)',
        'Categoria A: 
        Condutor de veículo motorizado de duas ou três rodas, com ou sem carro lateral (motos).
        Categoria B: 
        Condutor de veículo motorizado não abrangido pela categoria A, com peso bruto total inferior a 3.500 quilos e lotação máxima de oito lugares, além do motorista (automóveis).',        
        NULL,
        NULL,
        NULL);
		
INSERT INTO CATEGORIA(CODCATEGORIA,
	  DESCRICAO,						
	  DESCRICAODETALHADA,
	  IDADEMINIMA,
	  CATEGORIAMINIMA,
	  DESCRICAORESTRICAO)
VALUES ('C',
		'Categoria C (Transporte de cargas)',
        'Condutor de veículo motorizado usado para transporte de carga, com peso bruto superior a 3.500 quilos (como caminhões).',
        NULL,
        'B',
        'Estar habilitado há pelo menos 1 ano na categoria B.
        Não ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrAções médias durante os últimos doze meses.');
        
INSERT INTO CATEGORIA(CODCATEGORIA,
			  DESCRICAO,						
			  DESCRICAODETALHADA,
			  IDADEMINIMA,
			  CATEGORIAMINIMA,
			  DESCRICAORESTRICAO)
VALUES ('D',
		'Categoria D (Ônibus)',
        'Condutor de veículo motorizado usado no transporte de passageiros, com lotação superior a oito lugares além do motorista (ônibus e vans, por exemplo).',
        21,
        'C',
        'Ser maior de 21 anos.
        Estar habilitado há pelo menos 1 ano na categoria C.
        Não ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrações médias durante os últimos doze meses.');
        
INSERT INTO CATEGORIA(CODCATEGORIA,
			  DESCRICAO,						
			  DESCRICAODETALHADA,
			  IDADEMINIMA,
			  CATEGORIAMINIMA,
			  DESCRICAORESTRICAO)
VALUES ('E',
		'Categoria E (Caminhões)',
        'Condutor de combinação de veículos em que a unidade conduzida se enquadre nas categorias B, C ou D e cuja unidade acoplada ou rebocada tenha peso bruto de 6 mil quilos ou mais; ou cuja lotação seja superior a oito lugares; ou, ainda, que seja enquadrado na categoria trailer.',
        21,
        'C',
        'Ser maior de 21 anos.
        Estar habilitado há pelo menos 1 ano na categoria C.
        Não ter cometido nenhuma infração grave ou gravíssima ou ser reincidente em infrções médias durante os últimos doze meses.');      

CREATE TABLE MATRICULA(
	IDATOR INT NOT NULL,
	CODIGOMATRICULA VARCHAR(10) NOT NULL,	
	CODCATEGORIA VARCHAR(3) NOT NULL,
	DATAMATRICULA TIMESTAMP,
	
	CONSTRAINT PK_MATRICULA PRIMARY KEY (IDATOR, CODIGOMATRICULA),
	CONSTRAINT FK_MATRICULA_ATOR FOREIGN KEY (IDATOR)
		REFERENCES ATOR(IDATOR),
	CONSTRAINT FK_MATRICULA_CATEGORIA FOREIGN KEY (CODCATEGORIA)
		REFERENCES CATEGORIA(CODCATEGORIA)
);

CREATE TABLE RESPONSAVEL(
	IDATOR INT NOT NULL, 
    RESPONSAVELPRIORIDADE INT NOT NULL,
	RESPONSAVELATIVO VARCHAR(1) NOT NULL DEFAULT 'T',
    ATORRESPONSAVEL INT NOT NULL,
    
    CONSTRAINT PK_RESPONSAVEL PRIMARY KEY (IDATOR, RESPONSAVELPRIORIDADE),
    CONSTRAINT FK_RESPONSAVEL_ATOR FOREIGN KEY (IDATOR)
		REFERENCES ATOR(IDATOR),
	CONSTRAINT FK_RESPONSAVEL_ATOR_RESPONSABILIDADE FOREIGN KEY (ATORRESPONSAVEL)
		REFERENCES ATOR (IDATOR),
	CONSTRAINT CHK_RESPONSAVEL_ATIVO CHECK (RESPONSAVELATIVO = 'T' OR RESPONSAVELATIVO = 'F')		
	
);

CREATE TABLE LOG(
	IDLOG INT AUTO_INCREMENT NOT NULL ,
	MENSAGEM VARCHAR(700),
	
	CONSTRAINT PK_LOG PRIMARY KEY (IDLOG)
);



	
	
