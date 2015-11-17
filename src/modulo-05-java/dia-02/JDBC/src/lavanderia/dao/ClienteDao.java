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

    public void insert(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            /*
             * Statement statement = conexao.createStatement();
             * statement.execute("inser into cliente(idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ", '" + cliente.getNmCliente() + "', '" +
             * cliente
             * .getNrCpf() + "' ");
             * statement.close();
             */

            PreparedStatement ps = conexao.prepareStatement("insert into cliente(idCliente, nmCliente, nrCpf) values (?,?,?)");
            ps.setLong(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNmCliente());
            ps.setString(3, cliente.getNrCpf());

            ps.execute();
        } catch (SQLException e) {
            throw e;
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
