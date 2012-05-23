/**
 *
 */
package projeto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projeto.erro.ConexaoException;

/**
 * @author DANIEL VALENÇA
 *
 * Gerencia a conexão com o banco de dados MySql
 *
 */
public class GerenciadorConexao implements IGerenciadorConexao {

    private static GerenciadorConexao instancia;
    String usuario;
    String senha;
    String url;
    String driver;

    /**
     * Método responsável pela autenticação da conexão
     */
    public GerenciadorConexao() {
        usuario = "root";
        senha = "";
        url = "jdbc:mysql://localhost:3306/estoque";
        driver = "com.mysql.jdbc.Driver";
    }

    /**
     * Método que faz a conexão
     */
    @Override
    public Connection conectar() throws ConexaoException {
        try {
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (ClassNotFoundException e) {
            throw new ConexaoException();
        } catch (SQLException e) {
            throw new ConexaoException();
        }
    }

    /**
     * Método que desconecta
     */
    @Override
    public void desconectar(Connection conexao) throws ConexaoException {
        try {
            conexao.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }

    public static IGerenciadorConexao getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorConexao();
        }
        return instancia;
    }
}