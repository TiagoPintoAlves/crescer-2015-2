package lavanderia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.jdbc.ConnectionFactory;
import lavanderia.model.Servico;

public class ServicoDao {
	
	public void insert(Servico servico) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            /*
             * Statement statement = conexao.createStatement();
             * statement.execute("inser into cliente(idCliente, nmCliente, nrCpf) values (" + cliente.getIdCliente() + ", '" + cliente.getNmCliente() + "', '" +
             * cliente
             * .getNrCpf() + "' ");
             * statement.close();
             */
            PreparedStatement ps = conexao.prepareStatement("insert into servico(idServico, dsServico) values (?,?)");
            ps.setLong(1, servico.getIdServico());
            ps.setString(2, servico.getDsServico());
            ps.execute();
            
        } catch (SQLException e) {
            throw e;
        }
    }

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
}
