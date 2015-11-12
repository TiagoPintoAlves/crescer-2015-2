namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Adicionar_campos : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "DataLocacao", c => c.DateTime(nullable: false));
            AddColumn("dbo.Jogo", "DataEntrega", c => c.DateTime());
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Preco", c => c.Decimal(nullable: false, precision: 19, scale: 2));
            DropColumn("dbo.Jogo", "DataEntrega");
            DropColumn("dbo.Jogo", "DataLocacao");
        }
    }
}
