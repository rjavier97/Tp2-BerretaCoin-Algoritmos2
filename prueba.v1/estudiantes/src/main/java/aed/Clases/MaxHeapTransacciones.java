package aed.Clases;

import aed.*;

public class MaxHeapTransacciones {
    private HandleTr[] heap;  // Cada handle va a ser (Transaccion, posicion)
    private Transaccion[] transaccionesOriginal;
    private int tamaño;
    private int montoTotalSinCreacion;
    private int tamañoSinCreacion;

    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length;
        this.heap = new HandleTr[tamaño];
        for (int i = 0; i < tamaño; i++) {
            heap[i] = new HandleTr(transacciones[i], i);
        }
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            bajar(i);
        }

        Transaccion[] copiaTransacciones = new Transaccion[tamaño];
        for(int i =0 ; i<tamaño ; i++){
        copiaTransacciones[i] = transacciones[i] ;

        if (transacciones[i].id_comprador() != 0){
            montoTotalSinCreacion = montoTotalSinCreacion + transacciones[i].monto() ;
            tamañoSinCreacion ++ ;
        }
        }
        this.transaccionesOriginal = copiaTransacciones;

        // this.heap = new Transaccion[tamaño];
        // for (int i = 0; i < transacciones.length; i++) {
        //     heap[i] = transacciones[i];
        // }

        // Heapify
        // for (int i = tamaño / 2 - 1; i >= 0; i--) {
        //     bajar(i);
        // }
    }

    public void desencolar() {
        // Desde aca hasta la parte de bajar(0) modificamos el heap
        if (heap.length==1){ 
            heap = new HandleTr[0];
            transaccionesOriginal = new Transaccion[0];
            return ;
        }
        HandleTr max = heap[0];   // transaccion (id , id_comprador, id_vendedor, monto)   y  posicion 
        heap[0] = heap[--tamaño];
        bajar(0); 
        
        // Ahora vamos a modificar transaccionesOriginal
        transaccionesOriginal[max.posicion()] = null ;
        tamaño -- ;
    }

    private void bajar(int i) {
        while (true) {
            int izq = 2 * i + 1;
            int der = 2 * i + 2;
            int mayor = i;

            if (izq < tamaño && heap[izq].elemento().compareTo(heap[mayor].elemento()) > 0) mayor = izq;
            if (der < tamaño && heap[der].elemento().compareTo(heap[mayor].elemento()) > 0) mayor = der;

            if (mayor != i) {
                // Transaccion tmp = heap[i].elemento();
                // heap[i] = heap[mayor];
                // heap[mayor].modificar(tmp); 
                // i = mayor;
                HandleTr tmp = heap[i] ;  //
                heap[i] = heap[mayor];
                heap[mayor] = tmp;   //
                i = mayor;
            } else break;
        }
    }

    public Transaccion transaccionMayorValor(){
        return heap[0].elemento();
    }


    public Transaccion[] copia (){
        Transaccion[] copiaTransacciones = new Transaccion[tamaño];
        int i = 0 ;
        int j = 0 ;
        if (heap.length == 0){
            return new Transaccion[0];
        }
        while (i<tamaño && j<transaccionesOriginal.length){
            if (transaccionesOriginal[j] != null){
                copiaTransacciones[i] = transaccionesOriginal[j] ;
                i ++;
                j ++;
            } else {
                j ++;
            }
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
        return transaccionesOriginal;
    }
}
