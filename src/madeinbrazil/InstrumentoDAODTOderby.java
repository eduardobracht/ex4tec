package madeinbrazil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public class InstrumentoDAODTOderby implements InstrumentoDAO {

    @Override
    public List<InstrumentoDTO> buscarTodos() throws Exception {
        List<InstrumentoDTO> list = new ArrayList();
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "select * from INSTRUMENTOS";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultados = comando.executeQuery()) {
                    while (resultados.next()) {
                        list.add(new InstrumentoDTO(resultados.getString("PID"),
                                resultados.getString("TIPO"),
                                resultados.getString("MODELO"),
                                resultados.getString("COR"),
                                resultados.getString("MARCA"),
                                resultados.getDouble("PRECO")));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void inserir(InstrumentoDTO instrumento) throws Exception {
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "insert into INSTRUMENTOS(PID,TIPO,MODELO,COR,MARCA,PRECO) values (?,?,?,?,?,?)";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {

                comando.setString(1, instrumento.getPid());
                comando.setString(2, instrumento.getTipo());
                comando.setString(3, instrumento.getModelo());
                comando.setString(4, instrumento.getCor());
                comando.setString(5, instrumento.getMarca());
                comando.setDouble(6, instrumento.getPreco());

                if (comando.executeUpdate() > 0) {
                    System.out.println("Inserção efetuada com sucesso");
                } else {
                    System.out.println("Falha na inserção");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public InstrumentoDTO buscarPorPID(int pid) throws Exception {
        InstrumentoDTO instrumento = null;
        try (Connection conexao = StartDBDataSource.conectarBd()) {
            String sql = "select * from INSTRUMENTOS where PID = '001'";
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultados = comando.executeQuery()) {
                    resultados.next();
                    instrumento = new InstrumentoDTO(resultados.getString("PID"),
                            resultados.getString("TIPO"),
                            resultados.getString("MODELO"),
                            resultados.getString("COR"),
                            resultados.getString("MARCA"),
                            resultados.getDouble("PRECO"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instrumento;
    }

    //Não implementado
    @Override
    public void alterar(InstrumentoDTO instrumento) throws Exception {
    }

}
