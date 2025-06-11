package aed.Clases;

import aed.*;

public class MaxHeapTransacciones {
    private Transaccion[] heap;
    private Transaccion[] transaccionesOriginal;
    private int tamaño;
    private int montoTotalSinCreacion;
    private int tamañoSinCreacion;

    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length;
        Transaccion[] copiaTransacciones = new Transaccion[tamaño];
        for(int i =0 ; i<tamaño ; i++){
        copiaTransacciones[i] = transacciones[i] ;
        if (transacciones[i].id_comprador() != 0){
            montoTotalSinCreacion = montoTotalSinCreacion + transacciones[i].monto() ;
            tamañoSinCreacion ++ ;
        }
        }
        this.transaccionesOriginal = copiaTransacciones;

        this.heap = new Transaccion[tamaño];
        for (int i = 0; i < transacciones.length; i++) {
            heap[i] = transacciones[i];
        }

        // Heapify
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            bajar(i);
        }
    }

    public Transaccion desencolar() {
        if (tamaño==0){ 
        return null;
        }
        Transaccion max = heap[0];
        heap[0] = heap[--tamaño];
        bajar(0);
        return max;
    }

    private void bajar(int i) {
        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int mayor = i;

            if (izq < tamaño && heap[izq].compareTo(heap[mayor]) > 0) mayor = izq;
            if (der < tamaño && heap[der].compareTo(heap[mayor]) > 0) mayor = der;

            if (mayor != i) {
                Transaccion tmp = heap[i];
                heap[i] = heap[mayor];
                heap[mayor] = tmp;
                i = mayor;
            } else break;
        }
    }

    public Transaccion transaccionMayorValor(){
        return heap[0];
    }

    public Transaccion[] copia (){
        Transaccion[] copiaTransacciones = new Transaccion[transaccionesOriginal.length];
        for(int i =0 ; i<transaccionesOriginal.length ; i++){
            copiaTransacciones[i] = transaccionesOriginal[i] ;
        }
        return copiaTransacciones;
    }

    public int tamaño(){
        return tamaño;
    }

    public int montoPromedio(){
        if (tamañoSinCreacion == 0 ){
            return 0;
        }   
        return montoTotalSinCreacion/tamañoSinCreacion ;
    } 

    public Transaccion[] devolverHeap(){
        return heap;
    }
}
