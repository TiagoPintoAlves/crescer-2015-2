create table Governador(
        IDGovernador int IDENTITY not null,
        Nome varchar(40) not null,
        CidadeNatal varchar(40) ,
        DataNascimento datetime ,
        InicioMandato datetime not null,
        FimMandato datetime not null,
			constraint PK_IDGovernador Primary key(IDGovernador)
);


insert into Governador values (1, 'João Carlos de Saldanha Oliveira e Daun', 'Lisboa', convert(datetime, '17/11/1790', 103), convert(datetime, '22/02/1822', 103), convert(datetime, '29/08/1822', 103));
insert into Governador values (2, 'João de Deus Mena Barreto', 'Rio Pardo', convert(datetime, '02/07/1769' ,103), convert(datetime,'29/08/1822' ,103), convert(datetime, '29/11/1823',103));
insert into Governador values (3, 'José Inácio da Silva', null , null, convert(datetime, '29/11/1823',103), convert(datetime, '08/03/1824',103));
insert into Governador values (4, 'José Feliciano Fernandes Pinheiro', 'Santos', convert(datetime, '09/05/1774',103), convert(datetime, '08/03/1824',103), convert(datetime, '14/01/1826',103));
insert into Governador values (5, 'José Egídio Gordilho de Barbuda', 'Chamusca', convert(datetime, '01/08/1787',103), convert(datetime, '14/01/1826',103), convert(datetime, '04/11/1826',103));

select * from Governador

select
    Nome, 
    DATEDIFF(year, DataNascimento, InicioMandato) as Idade_Inicio_Mandato, 
    DATEDIFF(month, InicioMandato, FimMandato) as Tempo_Mandato
from Governador

ALTER TABLE Governador ADD PRIMARY KEY (IDGovernador);