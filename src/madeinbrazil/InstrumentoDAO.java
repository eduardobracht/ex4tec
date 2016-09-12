package madeinbrazil;

import java.util.List;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public interface InstrumentoDAO {

    List<InstrumentoDTO> buscarTodos() throws Exception;

    InstrumentoDTO buscarPorPID(int pid) throws Exception;

    void inserir(InstrumentoDTO instrumento) throws Exception;

    void alterar(InstrumentoDTO instrumento) throws Exception;
}
