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
                        Descricao = c.String(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(),
                        Video = c.String(),
                        IdCategoria = c.Int(nullable: false),
                        DataLocacao = c.DateTime(),
                        IdCliente = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .Index(t => t.IdCliente)
                .Index(t => t.IdSelo)
                .Index(t => t.IdCategoria);


            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 200),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 200),
                        Email = c.String(nullable: false, maxLength: 200),
                        Senha = c.String(nullable: false, maxLength: 200),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    IdSelo = c.Int(nullable: false),
                    Nome = c.String(nullable: false)
                })
                .PrimaryKey(f => f.IdSelo);
            
            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    IdCategoria = c.Int(nullable: false),
                    Nome = c.String(nullable: false)
                })
                .PrimaryKey(f => f.IdCategoria);

            Sql("INSERT INTO dbo.Categoria VALUES (1,'RPG')");
            Sql("INSERT INTO dbo.Categoria VALUES (2,'Corrida')");
            Sql("INSERT INTO dbo.Categoria VALUES (3,'Aventura')");
            Sql("INSERT INTO dbo.Categoria VALUES (4,'Luta')");
            Sql("INSERT INTO dbo.Categoria VALUES (5,'Esporte')");

            Sql("INSERT INTO dbo.Selo VALUES (1,'Ouro')");
            Sql("INSERT INTO dbo.Selo VALUES (2,'Prata')");
            Sql("INSERT INTO dbo.Selo VALUES (3,'Bronze')");

        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario_Permissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.Usuario_Permissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Jogo", "IdCliente", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropIndex("dbo.Usuario_Permissao", new[] { "IdPermissao" });
            DropIndex("dbo.Usuario_Permissao", new[] { "IdUsuario" });
            DropIndex("dbo.Jogo", new[] { "IdCliente" });
            DropIndex("dbo.Jogo", new[] { "IdSelo" });
            DropIndex("dbo.Jogo", new[] { "IdCategoria" });
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
        }
    }
}
