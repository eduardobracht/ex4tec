package ex4tec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

public class main {

    
    public static String DB_CONN_STRING_CREATE = "jdbc:derby:madeinbrazil;create=true";
    public static String DB_NAME = "madeinbrazil";
    public static String USER_NAME = "madeinbrazil";
    public static String PASSWORD = "123456";
    private static DataSource dataSource;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Passo1: criar base de dados
        //Obter e usar conexão via try-with-resources
        //Conexão será fechada automaticamente ao final do bloco
        /*
        try (Connection conexao = getConexaoViaDataSource()) {
            //Criar uma tabela
            String sql = 
                    "create table INSTRUMENTOS("+
                    "PID varchar(3) not null,"+
                    "TIPO varchar(25) not null,"+
                    "MODELO varchar(50) not null,"+
                    "COR varchar(50),"+
                    "MARCA varchar(25) not null,"+
                    "PRECO decimal(6,2) not null,"+
                    "primary key(PID))";

            try (Statement comando = conexao.createStatement()) {
                comando.executeUpdate(sql);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        

        //Passo2: inserir dados
        try (Connection conexao = getConexaoViaDriverManager()) {
            //Inserir dados na tabela
            String sql2 = "insert into INSTRUMENTOS(PID,TIPO,MODELO,COR,MARCA,PRECO) values (?,?,?,?,?,?)";
            try (PreparedStatement comando = conexao.prepareStatement(sql2)) {
                comando.setString(1,"001");
                comando.setString(2,"GUITARRA");
                comando.setString(3,"SG SPECIAL FADED WORN CHERRY");
                comando.setString(4,"VINHO (WORN CHERRY) (WC)");
                comando.setString(5,"GIBSON");
                comando.setDouble(6,5599.00);
                if (comando.executeUpdate() > 0) {
                    System.out.println("Inserção efetuada com sucesso");
                } else {
                    System.out.println("Falha na inserção");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        */

        //Passo3: consultar dados
        try (Connection conexao = getConexaoViaDriverManager()) {
            //Consultar dados da tabela
            String sql3 = "select * from INSTRUMENTOS";
            try (PreparedStatement comando = conexao.prepareStatement(sql3)) {
                try (ResultSet resultados = comando.executeQuery()) {
                    while (resultados.next()) {
                        System.out.println(resultados.getString("MODELO")+" - "+resultados.getString("PRECO"));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static Connection getConexaoViaDriverManager() throws Exception {
        return DriverManager.getConnection(DB_CONN_STRING_CREATE, USER_NAME, PASSWORD);
    }

    private static Connection getConexaoViaDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource.getConnection();
    }
}
