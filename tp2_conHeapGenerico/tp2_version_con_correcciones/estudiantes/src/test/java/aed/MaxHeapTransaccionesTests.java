package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import aed.Clases.MaxHeapTransacciones;

public class MaxHeapTransaccionesTests {
    
Transaccion tx_una = new Transaccion (0, 0, 2, 10);
Transaccion tx_dos = new Transaccion (1, 2, 3, 4);
Transaccion tx_tres = new Transaccion (2, 3, 4, 6);
Transaccion tx_cuatro = new Transaccion (3, 4, 5, 15);
Transaccion tx_cinco = new Transaccion (4, 7, 6, 64);

Transaccion[] transacciones = new Transaccion[] {tx_una, tx_dos, tx_tres, tx_cuatro, tx_cinco};           

    @Test
    public void constructorMaxHeapTransacciones(){
        MaxHeapTransacciones heaptx = new MaxHeapTransacciones(transacciones);
        assertEquals(5,heaptx.tamaño());
        assertEquals(4, heaptx.tamañoSinCreacion());
        assertEquals(tx_cinco, heaptx.transaccionMayorValor());
        assertEquals(89/4,heaptx.montoPromedio());
    }
  
    @Test
    public void desencolarMaximos(){
        MaxHeapTransacciones heaptx = new MaxHeapTransacciones(transacciones);

        Transaccion[] heap_transacciones = new Transaccion[] {tx_cinco, tx_cuatro, tx_una, tx_tres, tx_dos}; // Armo una lista con las transacciones en orden de acuerdo a la de mayor monto
        int tamaño = heap_transacciones.length;

        for(int i=0; i<5; i++){
            assertEquals(heap_transacciones[i], heaptx.transaccionMayorValor()); // Chequea que la transaccion sea la de mayor monto
            heaptx.desencolar(); // Desencolo la transaccion de mayor valor del heaptx
            tamaño --; 
            assertEquals(tamaño, heaptx.tamaño()); // Chequeo que se haya disminuido el tamaño
        
        }
        assertTrue(0 == heaptx.tamaño()); // El MaxHeapTransacciones quedo vacio
        
    }
    
    @Test
    public void copiaDeHeapTransaccionesAliasing(){
        MaxHeapTransacciones tx_original = new MaxHeapTransacciones(transacciones);

        // Hago una copia de las transacciones Originales
        Transaccion[] copia = tx_original.copiaDeTransacciones();

        // Modifico el primer elemento de la copia
        copia[0] = new Transaccion(99, 99, 99, 999);

        // Obtengo de nuevo la copia original
        Transaccion[] originalInterno = tx_original.copiaDeTransacciones();

        // Verifico que el original interno no e haya modificado
        assertEquals(0, originalInterno[0].id()); // El id es 0 y no 4 porque copiaDeTransacciones() copia las transacciones en su orden original; no copia el heap.
        assertEquals(10, originalInterno[0].monto());
    }
}
