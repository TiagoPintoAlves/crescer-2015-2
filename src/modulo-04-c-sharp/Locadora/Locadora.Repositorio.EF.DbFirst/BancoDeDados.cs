using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.DbFirst
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA")
        {

        }

        public DbSet<Jogo> Jogo { get; private set; }
        public DbSet<Cliente> Cliente { get; private set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            base.OnModelCreating(modelBuilder);
        }

    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired();
            Property(p => p.Preco).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();

            HasOptional(p => p.Cliente).WithRequired().Map(m => m.MapKey("IdClienteLocacao"));
            HasRequired(p => p.Categoria.ToString()).WithOptional().Map(m => m.MapKey("IdCategoria"));
            HasRequired(p => p.Selo.ToString()).WithOptional().Map(m => m.MapKey("IdSelo"));
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(p => p.Id);
            Property(p => p.Nome).IsRequired();
        }
    }
}
