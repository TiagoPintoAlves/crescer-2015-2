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

select Nome
from Associado
where len(Nome) = select(max(len Nome))

--

