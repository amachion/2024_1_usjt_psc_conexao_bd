import java.sql.Connection;

public class TesteUsuario {

    public static void main(String[] args) {
       /* ConnectionFactory factory = new ConnectionFactory();
        Connection c = factory.obtemConexao();
        if (c != null)
            System.out.println("foi");
        else 
            System.out.println("falhou");*/
       
       //Pessoa p = new Pessoa("Ze", "98765432", "ze@email.com");
       //p.insereNoBanco();
       //Pessoa p = new Pessoa("Gia", "45674567", "gia@email.com");
       //p.insereNoBanco();
       Pessoa p = new Pessoa (1);
       //p.setFone("12345678");
       //p.altera();
       p.deleta();
       System.out.println("deu certo");
    }
}
