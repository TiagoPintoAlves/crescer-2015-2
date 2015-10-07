use Crescer15_2
	
BEGIN
declare @vNome	Varchar(100),
		@vUF	Varchar(2),
		@vIDCidade int

		set @vNome = 'CWI5'
		set @vUF = 'RS'

Select	@vIDCidade = Min(IDCidade)
from	Cidade
where	Nome = @vNome and UF = @vUF

if @vIDCidade is null begin
	insert into Cidade(Nome, UF) values (@vNome, @vUF)
	print 'Cidade Criada com sucesso!'
	print scope_identity()
End 
END