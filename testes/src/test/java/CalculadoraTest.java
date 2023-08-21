import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    private Calculadora calculadora;

      @BeforeEach
      public void inicia(){
      calculadora = new Calculadora();
      }

    @Test
    public void deveSomarDoisNumeros(){
        int resultado =  calculadora.soma(5,10);
        Assertions.assertEquals(resultado,15);
    }

    @Test
    public void deveSomarDoisNumerosNegativo(){
        int resultado =  calculadora.soma(-5,-10);
        Assertions.assertEquals(resultado,-15);
    }

    @Test
    public void deveSubtrairDoisNumeros(){
        int resultado =  calculadora.subtracao(50,40);
        Assertions.assertEquals(resultado,10);
    }

    @Test
    public void deveMultiplicarDoisNumeros(){
        int resultado =  calculadora.multiplicacao(5,10);
        Assertions.assertEquals(resultado,50);
    }

    @Test
    public void deveDividirDoisNumeros(){
        int resultado =  calculadora.divisao(10,2);
        Assertions.assertEquals(resultado,5);
    }

    @Test
    public void naoDeveDividirPorZero(){
         Assertions.assertThrows(ArithmeticException.class, () -> {
             calculadora.divisao(20,0);
        });
    }

}