namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 300),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    Preco = c.Decimal(nullable: false, precision: 19, scale: 2),
                    Descricao = c.String(nullable: false, maxLength: 100),
                    IdSelo = c.Int(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    IdCategoria = c.Int(nullable: false),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdCategoria)
                .Index(t => t.IdSelo);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 100)
                })
                .PrimaryKey(t => t.Id);

        }

        private void CriarCategoria()
        {
            Sql("INSERT INTO Categoria VALUES(1, 'RPG')");
            Sql("INSERT INTO Categoria VALUES(2, 'Corrida')");
            Sql("INSERT INTO Categoria VALUES(3, 'Aventura')");
            Sql("INSERT INTO Categoria VALUES(4, 'Luta')");
            Sql("INSERT INTO Categoria VALUES(5, 'Esporte')");
        }

        private void CriarSelo()
        {
            Sql("INSERT INTO Selo VALUES (1, 'Ouro')");
            Sql("INSERT INTO Selo VALUES (2, 'Prata')");
            Sql("INSERT INTO Selo VALUES (3, 'Bronze')");
        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao", "IdCategoria", "IdSelo" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
        }
    }
}
