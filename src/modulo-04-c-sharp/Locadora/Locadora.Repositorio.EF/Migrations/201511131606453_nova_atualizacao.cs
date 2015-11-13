namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class nova_atualizacao : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Jogo", name: "IdClienteLocacao", newName: "IdCliente");
            RenameIndex(table: "dbo.Jogo", name: "IX_IdClienteLocacao", newName: "IX_IdCliente");
            AlterColumn("dbo.Jogo", "Descricao", c => c.String(nullable: false));
            AlterColumn("dbo.Jogo", "Imagem", c => c.String());
            AlterColumn("dbo.Jogo", "Video", c => c.String());
            DropColumn("dbo.Jogo", "DataLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Valor", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Jogo", "DataLocacao", c => c.DateTime(nullable: false));
            AlterColumn("dbo.Jogo", "Video", c => c.String(maxLength: 200));
            AlterColumn("dbo.Jogo", "Imagem", c => c.String(maxLength: 200));
            AlterColumn("dbo.Jogo", "Descricao", c => c.String(nullable: false, maxLength: 100));
            RenameIndex(table: "dbo.Jogo", name: "IX_IdCliente", newName: "IX_IdClienteLocacao");
            RenameColumn(table: "dbo.Jogo", name: "IdCliente", newName: "IdClienteLocacao");
        }
    }
}
