package br.com.cwi.crescer.lavanderia.dao;

public interface BaseDadosDAO<T> {

	T findById(Long id);
}
