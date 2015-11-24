package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ProdutoDAO;

@Service
public class ProdutoService {

    private ProdutoDAO ProdutoDAO;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDAO) {
        super();
        this.ProdutoDAO = produtoDAO;
    }

    public BigDecimal buscarValor(Long id) {

        BigDecimal valor = ProdutoDAO.findById(id).getValor();

        return valor;
    }
}
