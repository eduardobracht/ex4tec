package madeinbrazil;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */

public class main {

    public static void main(String[] args) {  
        
        try{
        StartDBDataSource.criarBd();
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
        
        InstrumentoDAODTOderby dao = new InstrumentoDAODTOderby();
        
        try{
        dao.inserir(null);
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
        
        try{
        System.out.println("pid tipo modelo cor marca preco");
        System.out.println(dao.buscarTodos().get(0).toString());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
          
    }
    
}
