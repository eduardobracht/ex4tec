package madeinbrazil;

/**
 *
 * @author Daniel Machado
 * @author Eduardo Mallmann
 */
public class InstrumentoDTO {

    private String pid, tipo, modelo, cor, marca;
    private double preco;

    public InstrumentoDTO(String pid, String tipo, String modelo, String cor, String marca, double preco) {
        this.pid = pid;
        this.tipo = tipo;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return pid + " " + tipo + " " + modelo + " " + cor + " " + marca + " " + preco;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
