using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LocadoraCodeFirst")
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
            HasKey(j => j.Id);

            Property(j => j.Nome).IsRequired().HasMaxLength(250);
            Property(j => j.Preco).IsRequired().HasPrecision(19,2);
            Property(j => j.Descricao).IsRequired().HasMaxLength(100);
            Property(j => j.Selo).IsRequired().HasColumnName("IdSelo");
            Property(j => j.Imagem).IsOptional();
            Property(j => j.Video).IsOptional();
            Property(j => j.Categoria).IsRequired().HasColumnName("IdCategoria");

            HasRequired(p => p.ClienteLocacao).WithOptional().Map(m => m.MapKey("IdClienteLocacao"));

        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(c => c.Id);
            Property(c => c.Nome).IsRequired().HasMaxLength(300);
        }
    }
}
