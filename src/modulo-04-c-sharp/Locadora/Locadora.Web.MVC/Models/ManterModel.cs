﻿using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterModel : JogoPropriedadeModel
    {
        public int? Id { get; set; }

        [Required(ErrorMessage = "Campo nome é obrigatório.")]
        [StringLength(250, ErrorMessage = "O nome não pode ter mais de 250 caracteres.")]
        public string Nome { get; set; }

        [Required]
        [EnumDataType(typeof(Categoria), ErrorMessage = "Selecione uma categoria.")]
        public Categoria Categoria { get; set; }

        [DisplayName("Preço")]
        [Required(ErrorMessage = "Campo preço é obrigatório.")]
        [RegularExpression(@"^[0-9]{0,19}([,][0-9]{0,2})?$", ErrorMessage = "O preço está em um formato inválido.")]
        public decimal Preco { get; set; }

        [DisplayName("Descrição")]
        [Required(ErrorMessage = "Campo descrição é obrigatório.")]
        [StringLength(400, ErrorMessage = "O limite de caracteres é 400.")]
        public string Descricao { get; set; }

        [Required]
        [EnumDataType(typeof(Selo), ErrorMessage = "Selecione um selo.")]
        public Selo Selo { get; set; }

        [StringLength(600, ErrorMessage = "O limite de caracteres é 600.")]
        public string Imagem { get; set; }

        [StringLength(600, ErrorMessage = "O limite de caracteres é 600.")]
        public string Video { get; set; }

        public ManterModel(Jogo jogo) : base(jogo)
        {
            
        }
    }
}