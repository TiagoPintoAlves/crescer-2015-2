package lavanderia.model;

import java.sql.SQLException;
import java.util.List;

public interface BaseDeDados<T> {
	
    void insert(T object) throws SQLException;

    void update(T object) throws SQLException;

    void delete(Long id) throws SQLException;

    T load(Long id) throws SQLException;

    List<T> listAll() throws SQLException;

    List<T> find(T object) throws Exception;
}
