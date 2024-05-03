import java.sql.DriverManager;
import java.sql.Connection;
public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "1234";
    private String host = "localhost";
    private String porta = "3306";
    private String db = "db_pessoas";
    public Connection obtemConexao() {
        try {
            //1. montar a string de conexão
            String url = String.format(
            "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
            host, porta, db
            );
            //2. estabelecer o canal de comunicação (conexão) com o SGBD (MySQL)
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}