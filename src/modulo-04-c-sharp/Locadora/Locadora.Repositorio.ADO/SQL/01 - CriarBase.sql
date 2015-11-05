CREATE TABLE dbo.Categoria
(    
    Id               INT             NOT NULL CONSTRAINT PK_IdCategoria PRIMARY KEY,
    Descricao        VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Cliente
(    
    Id              INT             NOT NULL CONSTRAINT PK_IdCliente PRIMARY KEY,
    Nome            VARCHAR(250)    NOT NULL
)

CREATE TABLE dbo.Jogo
(    
    Id               INT IDENTITY (1,1)		NOT NULL CONSTRAINT PK_IdJogo PRIMARY KEY,
    Nome             VARCHAR(250)			NOT NULL,
    Preco            DECIMAL(19,2)			NOT NULL,
	Descricao	     VARCHAR(100)			NOT NULL, 
	Selo			 VARCHAR(20)			NOT NULL, 
	Imagem		     VARCHAR(200),
	Video			 VARCHAR(200),
    IdCategoria      INT					NOT NULL CONSTRAINT FK_IdCategoria FOREIGN KEY REFERENCES Categoria(Id),
    IdClienteLocacao INT					NULL CONSTRAINT FK_IdClienteLocacao FOREIGN KEY REFERENCES Cliente(Id)    
)