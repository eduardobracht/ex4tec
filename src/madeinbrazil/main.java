package madeinbrazil;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */

public class main {

    public static void main(String[] args) {  
        
        //Criando DB
        try{
        StartDBDataSource.criarBd();
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
        
        //Criando DAO
        InstrumentoDAODTOderby dao = new InstrumentoDAODTOderby();
        
        //Inserindo elementos no DB
        try{
            dao.inserir(new InstrumentoDTO("001","GUITARRA","SG SPECIAL FADED WORN CHERRY","VINHO (WORN CHERRY) (WC)","GIBSON",5599.00));
            dao.inserir(new InstrumentoDTO("002","GUITARRA","SG FADED 2016 T","MARROM (WORN BROWN) (WB)","GIBSON",8989.00));
            dao.inserir(new InstrumentoDTO("003","GUITARRA","SG FADED 2016 T","VINHO (WORN CHERRY) (WC)","GIBSON",8989.00));
            dao.inserir(new InstrumentoDTO("004","GUITARRA","SG STANDARD 2014 MIN-ETUNE","MARROM (WALNUT) (592)","GIBSON",9229.00));
            dao.inserir(new InstrumentoDTO("005","GUITARRA","LES PAUL 50S TRIBUTE 2016 T","PRETO (SATIN EBONY) (SE)","GIBSON",9549.00));
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
        
        //Listando todos instrumentos
        try{
        System.out.println("pid tipo modelo cor marca preco");
        System.out.println(dao.buscarTodos().get(0).toString());
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        }
          
    }
    
}
