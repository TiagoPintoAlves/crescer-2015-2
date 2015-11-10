namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial : DbMigration
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
                        IdClienteLocacao = c.Int(nullable: false),
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
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 100)
                })
                .PrimaryKey(t => t.Id);

        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
        }
    }
}
