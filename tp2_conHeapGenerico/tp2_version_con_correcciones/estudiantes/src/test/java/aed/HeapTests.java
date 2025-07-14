package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import aed.Clases.Heap;
import org.junit.jupiter.api.BeforeEach;


public class HeapTests{
    @Test
    public void heapDeEnterosYMaximosCorrectos() {
        Integer[] datos = {10, 20, 15, 8, 30};
        Heap<Integer> heap = new Heap<>(datos);

        Integer[] esperado = {30, 20, 15, 10, 8};

        int tamaño = esperado.length;

        for(int i=0; i<5;i++){
            assertEquals(esperado[i], heap.maximo());
            assertTrue(tamaño == heap.tamaño());
            heap.desencolar();
            tamaño --;
        }
        assertTrue(0 == heap.tamaño()); // Desencole todos los maximos, el heap quedo vacio
    }    

    @Test
    public void maximoEnHeapDeStrings() {
        String[] datos = {"a","d","c","z","b"};
        Heap<String> heap = new Heap<>(datos);
        assertEquals(5, heap.tamaño());
        assertEquals("z", heap.maximo());
    }

    @Test
    public void subirPosicionEnHeap() {
        Integer[] datos = {10, 20, 15, 8, 30};
        Heap<Integer> heap = new Heap<>(datos);

        heap.obtenerElementos()[4] = 35; // meto en la posicion 4 un valor mayor
        heap.subir(4);
        assertEquals(5, heap.tamaño());
        assertEquals(35, heap.maximo());
    }

    @Test
    public void bajarPosicionEnHeap() {
        Integer[] datos = {30, 20, 15, 8, 10};
        Heap<Integer> heap = new Heap<>(datos);

        heap.obtenerElementos()[0] = 5; // hago al maximo el minimo
        heap.bajar(0);
        assertEquals(5, heap.tamaño());
        assertEquals(20, heap.maximo());
    }

    @Test
    public void heapUnElemento() {
        Integer[] datos = {42};
        Heap<Integer> heap = new Heap<>(datos);

        assertEquals(1, heap.tamaño());
        assertEquals(42, heap.maximo());
        heap.desencolar();
        assertEquals(0, heap.tamaño());
    }
}