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
import lavanderia.model.Pedido;
import lavanderia.model.Servico;

public class PedidoDao implements BaseDeDados<Pedido> {

    public void insert(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            String sql = "insert into Pedido(idPedido, idCliente, dsPedido) values (pedido_seq.nextval, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.execute();
            
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("update pedido set dsPedido = ? where idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, pedido.getDsPedido());
            statement.setLong(2, pedido.getIdPedido());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(Long idPedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from pedido where idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idPedido);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> listAll() throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, idCliente, dsPedido from Pedido");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

	@Override
	public Pedido load(Long idServico) throws SQLException {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, idcliente, dspedido ");
            sql.append(" from pedido where idpedido = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idServico);
            ResultSet resultSet = statement.executeQuery();
            Pedido pedido = new Pedido();
            if (resultSet.next()) {
            	pedido.setIdPedido(resultSet.getLong(1));
            	pedido.setIdCliente(resultSet.getLong(2));
            	pedido.setDsPedido(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }
            return pedido;
        } catch (SQLException e) {
            throw e;
        }
	}

	@Override
	public List<Pedido> find(Pedido filter) throws Exception {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, idCliente, dsPedido from Pedido where 1=1");
            List<Object> parameters = new ArrayList<Object>();
            List<Pedido> lista = new ArrayList<>();

            if (filter.getIdPedido() != null) {
                sql.append(" and idPedido = ?");
                parameters.add(filter.getIdPedido());
            }
            
            if (filter.getIdCliente() != null) {
                sql.append(" and idCliente = ?");
                parameters.add(filter.getIdCliente());
            }

            if (filter.getDsPedido() != null) {
                sql.append(" and dsPedido = ?");
                parameters.add(filter.getDsPedido());
            }

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.get(i));
            }
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultSet.getLong(1));
                pedido.setIdCliente(resultSet.getLong(2));
                pedido.setDsPedido(resultSet.getString(3));
                lista.add(pedido);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
	}
	
	public List<Pedido> findByCliente(Long idCliente) throws Exception {
		try (Connection conexao = new ConnectionFactory().getConnection()) {
			
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, idcliente, dspedido ");
            sql.append(" from pedido where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            
			ResultSet resultSet = statement.executeQuery();
			List<Pedido> lista = new ArrayList<>();
			while (resultSet.next()) {
				Pedido pedido = new Pedido();
				pedido.setIdPedido(resultSet.getLong("idCliente"));
				pedido.setIdCliente(resultSet.getLong("IdCliente"));
				pedido.setDsPedido(resultSet.getString("dsPedido"));
				lista.add(pedido);
			}

			return lista;
		} catch (SQLException e) {
            throw e;
        }
	}
}
