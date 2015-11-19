package lavanderia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.jdbc.ConnectionFactory;
import lavanderia.model.BaseDeDados;
import lavanderia.model.Cliente;
import lavanderia.model.Servico;

public class ServicoDao implements BaseDeDados<Servico> {
	
	@Override
	public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("insert into servico(idServico, dsServico) values (servico_seq.nextval, ?)");
            statement.setString(1, servico.getDsServico());
            statement.execute();
            
        } catch (SQLException e) {
            throw e;
        }
    }

	@Override
    public List<Servico> listAll() throws SQLException {
        List<Servico> lista = new ArrayList<Servico>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idServico, dsServico from servico");
            
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	Servico servico = new Servico();
            	servico.setIdServico(resultSet.getLong(1));;
            	servico.setDsServico(resultSet.getString(2));
                lista.add(servico);
            }

        } catch (SQLException e) {
        	throw e;
        }
        return lista;
    }

	@Override
	public void update(Servico servico) throws SQLException {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("update servico set dsServico = ? where idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, servico.getDsServico());
            statement.setLong(2, servico.getIdServico());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
	}

	@Override
	public void delete(Long idServico) throws SQLException {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from servico where idServico = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idServico);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
	}

	@Override
	public Servico load(Long idServico) throws SQLException {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idServico, dsServico ");
            sql.append(" from servico where idServico = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idServico);
            
            ResultSet resultSet = statement.executeQuery();
            Servico servico = new Servico();
            if (resultSet.next()) {
                servico.setIdServico(resultSet.getLong(1));
                servico.setDsServico(resultSet.getString(2));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }
            return servico;
        } catch (SQLException e) {
            throw e;
        }
	}

	@Override
	public List<Servico> find(Servico filter) throws Exception {
		List<Servico> lista = new ArrayList<Servico>();
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append(" select idServico, dsServico from Servico where 1=1 ");
            List<Object> parameters = new ArrayList<Object>();
            if ((Long) filter.getIdServico() != null) {
                sql.append(" and idServico = ? ");
                parameters.add(filter.getIdServico());
            }

            if (filter.getDsServico() != null) {
                sql.append(" and dsServico = ? ");
                parameters.add(filter.getDsServico());
            }

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Servico servico = new Servico();
                servico.setIdServico(resultSet.getLong(1));
                servico.setDsServico(resultSet.getString(2));
                lista.add(servico);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
	}
}
