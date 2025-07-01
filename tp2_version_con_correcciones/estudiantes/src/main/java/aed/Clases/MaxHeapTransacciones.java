package aed.Clases;

import aed.*;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque

public class MaxHeapTransacciones {
    private Heap[] heap; // Cada handle va a ser (Transaccion, nodo) donde nodo significa la posicion
    private Transaccion[] transaccionesOriginal;
    private int tamaño; //mantiene el tamaño del heap(si no se hackea tiene el mismo valor q tamaño de transaccionesOriginal)
    private int montoTotalSinCreacion;
    private int tamañoSinCreacion;

    private class Heap {
        private Transaccion elemento;
        private Handle nodo;
        public Heap (Transaccion i){ // O(1)
            this.elemento = i;  // O(1)
            this.nodo = new Handle(-1);  // O(1)
        }
    }

    // Constructor MaxHeapTransacciones() tiene complejidad O(T) pues si bien hay 3 ciclos, son independientes uno de otro, por ende la complejidad se lo lleva el maximo entre O(T) y O(log(T)) que es O(T)
    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length;  //O(1)
        Transaccion[] copiaTransacciones = new Transaccion[this.tamaño];  //O(1)
        for(int i =0 ; i<this.tamaño ; i++){ // O(T)
        copiaTransacciones[i] = transacciones[i] ;  //O(1)
        if (transacciones[i].id_comprador() != 0){  //O(1)
            montoTotalSinCreacion = montoTotalSinCreacion + transacciones[i].monto() ;  //O(1)
            tamañoSinCreacion ++ ;  //O(1)
        }
        }
        this.heap = new Heap[tamaño];  //O(1)
        for (int i = 0; i < tamaño; i++) { //O(T)
            heap[i] = new Heap(transacciones[i]);  //O(1)
            heap[i].nodo.modificarPosicion(i);
        }
        for (int i = tamaño / 2 - 1; i >= 0; i--) { // O(log(T))
            bajar(i);   // O(log(T))
        }
        this.transaccionesOriginal = copiaTransacciones;  //O(1)
    }
    
    // Metodo desencolar() tiene complejidad O(log(T)) pues en el peor caso entra al if y queda O(1)+O(log(T)) => O(max{1,log(T)}) = O(log(T))
    public void desencolar() {
        if (heap.length==1){   //O(1)
            heap = new Heap[0];  //O(1)
            transaccionesOriginal = new Transaccion[0];  //O(1)
            tamaño --;  //O(1)
            return ;  //O(1)
        }
        Heap max = heap[0];  //O(1)
        heap[0] = heap[tamaño-1];  //O(1)
        bajar(0);   //O(log(T))
        
        // Ahora vamos a modificar transaccionesOriginal
        transaccionesOriginal[max.nodo.posicion()] = null ;  //O(1)   //esta parte es para cuando hacemos copiaTransacciones
        tamaño -- ;  //O(1)
    }

    // Metodo bajar() tiene complejidad O(log(T))
    private void bajar(int i) {
        while (true) {  // Este ciclo siempre va a estar comparando una cantidad de veces como mucho igual a la altura del heap, que podemos pensarlo como altura = log(T)
            int izq = 2 * i + 1;  //O(1)
            int der = 2 * i + 2;  //O(1)
            int mayor = i;  //O(1)

            if (izq < tamaño && heap[izq].elemento.compareTo(heap[mayor].elemento) > 0){  //O(1)
                mayor = izq;  //O(1)
            }
            if (der < tamaño && heap[der].elemento.compareTo(heap[mayor].elemento) > 0){  //O(1)
                mayor = der;  //O(1)
            }
            if (mayor != i) {  //O(1)
                Heap tmp = heap[i] ;  // O(1)
                heap[i] = heap[mayor];  //O(1)
                heap[mayor] = tmp;   //O(1)
                i = mayor;  //O(1)
            } else break;  //O(1)
        }
    }

    // Metodo transaccionMayorValor() tiene complejidad O(1) pues hace un retorno que usa un metodo en O(1)
    public Transaccion transaccionMayorValor(){  //O(1)
        return heap[0].elemento;  //O(1)
    }

    // Aclaracion: la idea es mantener el mismo tamaño del arreglo heap
    // Luego cuando usemos el metodo copiar() recorreremos uno x uno ( O(T) ), y copiaremos todo menos los elementos que sean null.
    // Lo hacemos de esta manera para no perder la referencia que tiene el atributo heap que es de clase Heap[]
    // que recordemos heap tiene la forma de una tupla:   (Transaccion,posicion)
    // esta posicion es exactamente el indice en el que se encontraba la transaccion cuando nos la dieron por parametro 
    // al agregar bloque, es decir, en forma ordenada. 
    // De esta manera cuando desencolemos, no vamos a estar cambiando los indices o cambiando el tamaño del atributo transaccionesOriginal
    // para no perder la referencia con posicion de la tupla (Transaccion, posicion) correspondiente al atributo heap.

    // Metodo copia() tiene complejidad O(T) pues en el peor caso recorre todo el arreglo de transacciones
    public Transaccion[] copiaDeTransacciones (){
        Transaccion[] copiaTransacciones = new Transaccion[tamaño];  //O(1)
        int i = 0 ;  //O(1)
        int j = 0 ;  //O(1)
        if (heap.length == 0){  //O(1)
            return new Transaccion[0];  //O(1)
        }
        while (i<tamaño){ // O(T)
            if (transaccionesOriginal[j] != null){  //O(1)
                copiaTransacciones[i] = transaccionesOriginal[j] ;  //O(1)
                i ++;  //O(1)
                j ++;  //O(1)
            } else {  //O(1)
                j ++;  //O(1)
            }
        }
        return copiaTransacciones;  //O(1)
    }
    
    // Metodo tamano() tiene complejidad O(1) pues es un solo return
    public int tamaño(){  //O(1)
        return tamaño;  //O(1)
    }

    // Metodo montoPromedio() tiene complejidad O(1) pues solo es un condicional con return en O(1)
    public int montoPromedio(){
        if (tamañoSinCreacion == 0 ){  //O(1)
            return 0;  //O(1)
        }   
        return montoTotalSinCreacion/tamañoSinCreacion ;  //O(1)
    } 

    // Metodo tamanoSinCreacion() tiene complejidad O(1) pues es solo un return
    public int tamañoSinCreacion(){  //O(1)
        return tamañoSinCreacion;  //O(1)
    }

    // Metodo modificarMontoMedio() tiene complejidad O(1) pues solo son asignaciones
    public void modificarMontoMedio(int monto, int _tamañoSinCreacion){  //O(1)
        montoTotalSinCreacion = montoTotalSinCreacion - monto ;  //O(1)
        tamañoSinCreacion = _tamañoSinCreacion ;  //O(1)
    }
    //--------------------------------------------------------------------------------------------------------------------

    public MaxHeapTransacciones() {  //O(1)
        this.tamaño = 0;  //O(1)
        this.montoTotalSinCreacion = 0;  //O(1)
        this.tamañoSinCreacion = 0;  //O(1)
        this.heap = new Heap[0];  //O(1)
        this.transaccionesOriginal = new Transaccion[0];  //O(1)
    }


    public MaxHeapTransacciones testear(Transaccion[] transacciones) {
        MaxHeapTransacciones test = new MaxHeapTransacciones();
        this.tamaño = transacciones.length;  //O(1)
        Transaccion[] copiaTransacciones = new Transaccion[this.tamaño];  //O(1)
        int varMonto = 0;
        int varTamaño = 0;
        for(int i =0 ; i<this.tamaño ; i++){ // O(T)
        copiaTransacciones[i] = transacciones[i] ;  //O(1)
        if (transacciones[i].id_comprador() != 0){  //O(1)
            varMonto = varMonto + transacciones[i].monto() ;  //O(1)
            varTamaño ++ ;  //O(1)
        }
        }
        this.montoTotalSinCreacion = varMonto;
        this.tamañoSinCreacion = varTamaño;
        this.heap = new Heap[tamaño];  //O(1)
        for (int i = 0; i < tamaño; i++) { //O(T)
            heap[i] = new Heap(transacciones[i]);  //O(1)
            heap[i].nodo.modificarPosicion(i);
        }
        for (int i = tamaño / 2 - 1; i >= 0; i--) { // O(log(T))
            bajar(i);   // O(log(T))
        }
        this.transaccionesOriginal = copiaTransacciones;  //O(1)
        test = this;
        return test;
    }
}    



