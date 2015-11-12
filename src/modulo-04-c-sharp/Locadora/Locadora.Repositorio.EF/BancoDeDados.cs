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
        public DbSet<Usuario> Usuario { get; private set; }
        public DbSet<Permissao> Permissao { get; private set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
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
            Property(j => j.Descricao).IsRequired().HasMaxLength(100);
            Property(j => j.Selo).IsRequired().HasColumnName("IdSelo");
            Property(j => j.Imagem).IsOptional().HasMaxLength(200);
            Property(j => j.Video).IsOptional().HasMaxLength(200);
            Property(j => j.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(j => j.DataLocacao).IsRequired();
            Property(j => j.DataEntrega).IsOptional();

            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));

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

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");

            HasKey(p => p.Id);
            Property(p => p.Nome).IsRequired().HasMaxLength(200);
            
        }
    }

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(u => u.Id);

            Property(u => u.Nome).IsRequired().HasMaxLength(200);
            Property(u => u.Email).IsRequired().HasMaxLength(200);
            Property(u => u.Senha).IsRequired().HasMaxLength(200);
            
            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                              .Map(m =>
                                              {
                                                  m.ToTable("Usuario_Permissao");
                                                  m.MapLeftKey("IdUsuario");
                                                  m.MapRightKey("IdPermissao");
                                              });
        }
    }
}
