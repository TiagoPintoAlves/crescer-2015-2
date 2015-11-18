package lavanderia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.jdbc.ConnectionFactory;
import lavanderia.model.Cliente;
import lavanderia.model.Pedido;

public class PedidoDao {

    public void insert(Pedido pedido, Cliente cliente) throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            String sql = "insert into Pedido(idPedido, idCliente, dsPedido) values (pedido_seq.nextval, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);

            if (clienteDao.find(cliente) != null) {
                statement.setLong(1, pedido.getIdCliente());
                statement.setString(2, pedido.getDsPedido());
                statement.execute();
            }
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

    public List<Pedido> listaPorCliente(Cliente cliente) throws SQLException {
        List<Pedido> lista = new ArrayList<>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idPedido, idCliente, dsPedido from Pedido");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = new Pedido(cliente);
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

}
