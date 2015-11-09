﻿using Locadora.Dominio;
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
            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired();
            Property(p => p.Preco).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Selo).IsRequired().HasColumnName("IdSelo");
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();
            Property(p => p.Categoria).IsRequired().HasColumnName("IdCategoria");

            HasOptional(p => p.ClienteLocacao).WithRequired().Map(m => m.MapKey("IdClienteLocacao"));

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
