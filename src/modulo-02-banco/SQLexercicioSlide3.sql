select * from Associado
--Questao 1)
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
select Nome
from Associado
where len(Nome) = select(max(len Nome))

-- Questao 6)
select Nome,
	   DataNascimento,
	   DateDiff(year, DataNascimento, getdate()) as IdadeAtual,
	   DateDiff(year, DataNascimento, getdate()) - 50 as IdadeFaltando,
	   case when DateDiff(year, DataNascimento, getdate()) - 50 < 0 then DateDiff(year, DataNascimento, getdate()) - 50 + 65
			when DateDiff(year, DataNascimento, getdate()) - 50 > 0 then DateDiff(year, DataNascimento, getdate()) - (DateDiff(year, DataNascimento, getdate()) - 50)
	   else null
	end IdadeFuturo
from Associado

-- Questao 7)
select * from Cidade

select	UF,
		count(1) as TotalDeCidades
from Cidade
group by UF

-- Questao 8) 
select	Nome,
		count(1) as NomeRepetido,
		UF,
		count(1) as UFRepetido,
		case when count(1) > 1 then Nome
		else ''
		end CidadesRepetidas
from Cidade
group by Nome, UF
having count(1) > 1

-- Questao 9)
select max(IDAssociado) + 1 as ProximoID
from Associado

-- Questao 10)
Select	UF,
		distinct,
		Nome,
		distinct
into CidadeAux
from Cidade

-- Questao 11)