﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        // Lista Exercícios Linq e Lambda:

        public IList<Funcionario> OrdenadosPorCargo()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = from funcionario in funcionarios
                        where funcionario.Nome.Contains(nome)
                        select funcionario;

            return query.OrderBy(funcionario => funcionario.Nome).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            IEnumerable<dynamic> query = from funcionario in funcionarios
                                         select new
                                         {
                                             NomeFuncionario = funcionario.Nome,
                                             TituloCargo = funcionario.Cargo.Titulo
                                         };

            return query.ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            IEnumerable<Funcionario> query = from funcionario in funcionarios
                                             where turnos.Contains(funcionario.TurnoTrabalho)
                                             select funcionario;
            return query.ToList();
        }

        public IList<dynamic> QtdFuncionarioPorTurno()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            IEnumerable<dynamic> query = from funcionario in funcionarios
                                         group funcionario by funcionario.TurnoTrabalho into turnos
                                         select new
                                         {
                                             Turnos = turnos.Key,
                                             Quantidade = turnos.Count()
                                         };

            return query.ToList();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo);
            return query.ToList();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = funcionarios.Where(funcionario => ((funcionario.DataNascimento.AddYears(5).Year) >= (DateTime.Now.AddYears(-idade).Year)) && ((funcionario.DataNascimento.AddYears(-5).Year) <= (DateTime.Now.AddYears(-idade)).Year)).ToList();


            return query.ToList();
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var Aniver = funcionarios.Where(funcionario => (funcionario.DataNascimento.Month) == (DateTime.Now.Month));
            return Aniver.ToList();
        }

    }
}
