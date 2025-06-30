package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;








public class MaxHeapTransaccionesTests {
    


Transaccion una = new Transaccion (0, 0, 2, 10);
Transaccion dos = new Transaccion (1, 2, 3, 4);
Transaccion tres = new Transaccion (2, 3, 4, 6);
Transaccion cuatro = new Transaccion (3, 4, 5, 15);
Transaccion cinco = new Transaccion (4, 7, 6, 64);
Transaccion seis = new Transaccion (5, 8, 9, 2);
Transaccion siete = new Transaccion (6, 7, 1, 43);
Transaccion ocho = new Transaccion (7, 5, 2, 23);

Transaccion[] transacciones = new Transaccion[] {una, dos, tres, cuatro, cinco, seis, siete, ocho};
            

@Test
public void pruebasSimples(){
    MaxHeapTransacciones prueba = new MaxHeapTransacciones();
    prueba = prueba.testear(transacciones);

    assertEquals(22, prueba.montoPromedio());
    assertEquals(new Transaccion(4, 7, 6, 64), prueba.transaccionMayorValor());
}






}