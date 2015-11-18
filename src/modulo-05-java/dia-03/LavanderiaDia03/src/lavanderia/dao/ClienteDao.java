package lavanderia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.jdbc.ConnectionFactory;
import lavanderia.model.Cliente;

public class ClienteDao {

    public List<Cliente> find(Cliente filter) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idcliente, nmCliente, nrCpf from cliente where 1=1");
            List<Object> parameters = new ArrayList<>();
            List<Cliente> lista = new ArrayList<>();

            if (filter.getNrCpf() != null) {
                sql.append(" and nrCpf ");
                parameters.add(filter.getNrCpf());
            }

            if (filter.getNmCliente() != null) {
                sql.append(" and nmCliente ");
                parameters.add(filter.getNmCliente());
            }

            if ((Long) filter.getIdCliente() != null) {
                sql.append(" and idCliente ");
                parameters.add(filter.getIdCliente());
            }

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            for (int i = 0; i < parameters.size(); i++) {
                statement.setObject(i + 1, parameters.indexOf(i));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nmCliente = ?, set nrCpf = ? where idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from cliente where idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente load(Long idCliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("select idcliente, nmcliente, nrcpf ");
            sql.append(" from cliente where idcliente = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente = new Cliente();
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
            } else {
                throw new RuntimeException("Registro não encontrado!");
            }
            return cliente;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            /*
             * Statement statement = conexao.createStatement();
             * statement.execute("inser into cliente(idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ", '" + cliente.getNmCliente() + "', '" +
             * cliente
             * .getNrCpf() + "' ");
             * statement.close();
             */

            PreparedStatement ps = conexao.prepareStatement("insert into cliente(idCliente, nmCliente, nrCpf) values (cliente_seq.nextval, ?, ?)");
            ps.setString(1, cliente.getNmCliente());
            ps.setString(2, cliente.getNrCpf());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listAll() throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("select idCliente, nmCliente, nrCpf from Cliente");
            PreparedStatement statement = conexao.prepareStatement(query.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong(1));
                cliente.setNmCliente(resultSet.getString(2));
                cliente.setNrCpf(resultSet.getString(3));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
}
