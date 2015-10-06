/*
		Exercício 04 - SQL Server - Comandos SQL - parte 3 - DML
*/
use CursoSQL

--Questao 1)
select * from Associado

select  substring(Nome, 0, charindex(' ', Nome)) as PrimeiroNome,
		charindex(' ', Nome) primeiroEspaco,
		Nome
from Associado

-- Questao 2)
select Nome,
	   DataNascimento,
       DATEDIFF(YEAR, DataNascimento, GETDATE()) as Idade
from Associado

-- Questao 3)
select * from Empregado

select NomeEmpregado,
	   Datediff(month, DataAdmissao, convert (datetime, '31/12/2000',103)) as Total_meses
from Empregado 
where DataAdmissao >= convert(datetime, '01/05/1980',103) and DataAdmissao <= convert(datetime, '20/01/1982',103);

-- Questao 4)
select Top 1 with ties
       Cargo,
	   COUNT(1) as TotalEmpregados
from Empregado
Group By Cargo
Order by TotalEmpregados Desc;

-- Questao 5)
Select top 1
       LEN(Nome) as numero_caracteres, 
       nome
from   Associado
Order by numero_caracteres desc
------------------------------------------------------------
-- alternativa utilizando do MAX()
Select	top 1
		nome
from   Associado
where  LEN(Nome) = (select max(len(nome)) from associado);

-- Questao 6)
Set language portuguese

select Nome,
	   DataNascimento,
	   --DateDiff(year, DataNascimento, getdate()) as IdadeAtual,
	   --DateDiff(year, DataNascimento, getdate()) - 50 as IdadeFaltando,
	   DATEADD(year, 50, DataNascimento) as Cinquenta_anos,
	   DateName(weekday, DATEADD(year, 50, DataNascimento)) as Dia_Semana
from Associado;

-- Questao 7)
select * from Cidade

select	UF,
		count(1) as TotalDeCidades
from Cidade
group by UF

-- Questao 8)
select	Nome, UF, count(1) as TotalRepetições
from Cidade
group by Nome, UF
having count(1) > 1;

-- Questao 9)
select	ISNULL(max(IDAssociado), 0) + 1 as ProximoID
from Associado

-- Questao 10)
select * from CidadeAux

insert into CidadeAux
	(IDCidade, Nome, UF)
select min(IDCidade) as Menor_IDCidade, Nome, UF
from Cidade
group by Nome, UF

-- Questao 11)
select	count(1) as TotalRepetições,
		case when count(1) > 1 then '*'+Nome
		else Nome
		end cidadeRepitida
from Cidade
group by Nome, UF
