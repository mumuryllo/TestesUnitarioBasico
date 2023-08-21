package vendas;

public class Venda {
    private double valor;
    private Cliente cliente;

    private boolean pagamentoVista;
    private ICredito creditoService;

    public Venda(double valor, Cliente cliente, ICredito creditoService) {
        this.valor = valor;
        this.cliente = cliente;
        this.creditoService = creditoService;
    }

    public double getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean checkout(){
        double limite;

        if (pagamentoVista){
            return true;
        }

        try {
            limite = creditoService.getLimite(cliente.getCpf());
            if (valor>limite){
                return  false;
            }
        }catch (RuntimeException r){
            return false;
        }

        return true;
    }

    public void setPagamentoAPrazo(){
        pagamentoVista=false;
    }


}
