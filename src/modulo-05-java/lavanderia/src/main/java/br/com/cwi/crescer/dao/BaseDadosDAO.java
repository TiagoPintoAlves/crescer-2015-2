package br.com.cwi.crescer.dao;

public interface BaseDadosDAO<T> {

	T findById(Long id);
}
