﻿using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.SqlClient;
using System.Data;

namespace Locadora.Repositorio.ADO
{
    public class JogoRepositorio : RepositorioBase,  IJogoRepositorio
    {
        private const string BASE_SELECT = "SELECT Id, Nome, Preco, Descricao, IdSelo, Imagem, Video, IdCategoria, IdClienteLocacao FROM Jogo ";

        public int Atualizar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {                
                var sql = new StringBuilder();
                sql.Append(" UPDATE Jogo set ");
                sql.Append(" Nome = @paramNome, ");
                sql.Append(" Preco = @paramPreco, ");
                sql.Append(" Descricao = @paramDescricao, ");
                sql.Append(" IdSelo = @paramIdSelo, ");
                sql.Append(" Imagem = @paramImagem, ");
                sql.Append(" Video = @paramVideo, ");
                sql.Append(" IdCategoria = @paramIdCategoria, ");
                sql.Append(" IdClienteLocacao = @paramIdClienteLocacao ");
                sql.Append(" WHERE Id = @paramId ");

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramImagem", entidade.Imagem);
                comando.AddParam("paramVideo", entidade.Video);
                comando.AddParam("paramIdCategoria", (int)entidade.Categoria);
                comando.AddParam("paramIdClienteLocacao", entidade.Cliente.Id);
                comando.AddParam("paramId", entidade.Id);

                conexao.Open();

                return comando.ExecuteNonQuery();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader).FirstOrDefault();
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Nome like @paramNome";
                comando.AddParam("paramNome", String.Format("%{0}%", nome));

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT;

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public int Criar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                var sql = new StringBuilder();
                sql.Append(" INSERT INTO Jogo (Nome, Preco, Descricao, IdSelo, Imagem, Video, IdCategoria, IdClienteLocacao) ");
                sql.Append(" VALUES (@paramNome, @paramPreco, @paramDescricao, @paramIdSelo, @paramImagem, @paramVideo, @paramCategoria, @paramIdClienteLocacao) ");

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramImagem", entidade.Imagem);
                comando.AddParam("paramVideo", entidade.Video);
                comando.AddParam("paramCategoria", (int)entidade.Categoria);
                comando.AddParam("paramIdClienteLocacao", entidade.Cliente.Id);

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        public int Excluir(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = "DELETE FROM Jogos WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        private IList<Jogo> LerJogosDoDataReader(IDataReader reader)
        {
            IList<Jogo> jogosLidos = new List<Jogo>();

            while (reader.Read())
            {
                jogosLidos.Add(ConverterDataReaderEmJogo(reader));
            }

            return jogosLidos;
        }

        private Jogo ConverterDataReaderEmJogo(IDataReader reader)
        {
            var cliente = new Cliente(Convert.ToInt32(reader["IdClienteLocacao"]));
            var jogo = new Jogo(
                id: Convert.ToInt32(reader["Id"]),
                clienteLocacao: cliente
                );

            jogo.Nome = reader["Nome"].ToString();
            jogo.Descricao = reader["Descricao"].ToString();
            jogo.Selo = (Selo)Convert.ToInt32(reader["IdSelo"]);
            jogo.Categoria = (Categoria)Convert.ToInt32(reader["IdCategoria"]);
            jogo.Imagem = reader["Imagem"].ToString();
            jogo.Video = reader["Video"].ToString();

            return jogo;
        }

    }
}
