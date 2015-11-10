﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using(var db = new BancoDeDados())
            {
                var query = db.Jogo.Where(j => j.Nome == nome).ToList();

                return query;
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using(var db = new BancoDeDados())
            {
                var query = db.Jogo.Select(Jogo => Jogo).ToList();
                return query;
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }

        public int Atualizar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = new BancoDeDados())
            {
                var query = db.Jogo.Where(j => j.Id == id).ToList();
                db.Entry(query).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Jogo.Find(id);
            }
        }
    }
}
