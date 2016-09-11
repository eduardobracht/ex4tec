package madeinbrazil;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */

public class StartDBDataSource {
    
    public static String DB_CONN_STRING_CREATE = "jdbc:derby:madeinbrazil;create=true";
    public static String DB_NAME = "madeinbrazil";
    public static String USER_NAME = "madeinbrazil";
    public static String PASSWORD = "123456";
    private static DataSource dataSource;
    
    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }
    
    public static void criarBd() throws Exception {
        try (Connection conexao = criarDataSource().getConnection()) {
            //Criando tabela
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
        }
    }
    
    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
}
