package vendas;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class VendaTest {

    @Test
    public void checkoutClienteComLimite() {
        ICredito creditoService = mock(ICredito.class);

        Cliente cliente = new Cliente("Muryllo","123456");
        Venda venda = new Venda(2000,cliente,creditoService);
        venda.setPagamentoAPrazo();


        when(creditoService.getLimite(cliente.getCpf())).thenReturn(2500d);

        boolean resultado= venda.checkout();
        assertTrue(resultado);
    }
    @Test
    public void checkoutClienteSemLimite() {
        ICredito creditoService = mock(ICredito.class);

        Cliente cliente = new Cliente("Muryllo","123456");
        Venda venda = new Venda(2000,cliente,creditoService);
        venda.setPagamentoAPrazo();

        when(creditoService.getLimite(cliente.getCpf())).thenReturn(1000d);

        boolean resultado= venda.checkout();
        assertFalse(resultado);
    }

    @Test
    public void checkoutAVistaNaoVerificaLimiteCredito() {
        ICredito creditoService = mock(ICredito.class);

        Cliente cliente = new Cliente("Muryllo","123456");
        Venda venda = new Venda(2000,cliente,creditoService);

        when(creditoService.getLimite(cliente.getCpf())).thenReturn(1000d);

        verify(creditoService, never()).getLimite(cliente.getCpf());
    }

    @Test
    public void checkoutNaoFazVendaSeCreditoServiceFalhar() {
        ICredito creditoService = mock(ICredito.class);

        Cliente cliente = new Cliente("Muryllo","123456");
        Venda venda = new Venda(2000,cliente,creditoService);
        venda.setPagamentoAPrazo();


        when(creditoService.getLimite(anyString())).thenThrow(new RuntimeException());

        boolean resultado= venda.checkout();
        assertFalse(resultado);
    }
}