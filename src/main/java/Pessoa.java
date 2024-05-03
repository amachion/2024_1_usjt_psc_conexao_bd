import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;
    public Pessoa() {
        //construtor padrão
    }
    public Pessoa(int codigo) {
        this.codigo = codigo;
    }
    public Pessoa(String nome, String fone, String email) {
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }
    public Pessoa(int codigo, String nome, String fone, String email) {
        this (nome, fone, email);
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void insereNoBanco () {
        //1 - definir a string sql;
        String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";
        //2 - abrindo a fábrica
        ConnectionFactory factory = new ConnectionFactory();
        //3 - pede a conexão e joga a responsabilidade para o try
        try (Connection c = factory.obtemConexao()){
            //4 - preparar (pré - compilar) o comando sql = statement
            PreparedStatement ps = c.prepareStatement(sql);
            //5 - preencher os dados
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //6 - exucutar o comando
            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void altera () {
        //1 - definir a string sql;
        String sql = "update tb_pessoas set fone = ? where codigo = ?";
        //2 - abrindo a fábrica
        ConnectionFactory factory = new ConnectionFactory();
        //3 - pede a conexão e joga a responsabilidade para o try
        try (Connection c = factory.obtemConexao()) {
            //4 - pede pra conexão pré compilar o sql e te devolver um comando 
            //pré compilado
            PreparedStatement ps = c.prepareStatement(sql);
            //5 - preenche os ? (place holders)
            ps.setString(1, fone);
            ps.setInt(2, codigo);
            //6 - executa o comando
            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void deleta () {
        String sql = "delete from tb_pessoa where codigo = ?";
        ConnectionFactory factory = new ConnectionFactory();
        Connection c = factory.obtemConexao();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void consultaPessoas () {
        String sql = "select * from tb_pessoa";
        ConnectionFactory factory = new ConnectionFactory();
        Connection c = factory.obtemConexao();
        try (PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
