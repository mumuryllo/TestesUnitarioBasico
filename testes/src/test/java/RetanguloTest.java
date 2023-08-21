import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RetanguloTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parametros(){
        return Arrays.asList(new Object[][]{
                                {10,20,200},
                                {10,30,300},
                {10,40,400},
                {10,50,500},
                {10,60,600},
                {10,70,700},
                {10,80,800}
                        });
    }

    private  int base,altura,area;

    public RetanguloTest(int base,int altura,int area){
        this.base=base;
        this.altura=altura;
        this.area=area;
    }

    @Test
    public void testeCalcularArea(){
       Retangulo retangulo = new Retangulo(base,altura);
       int resultado= retangulo.calcularArea();
        Assert.assertEquals(area,resultado);
    }


}