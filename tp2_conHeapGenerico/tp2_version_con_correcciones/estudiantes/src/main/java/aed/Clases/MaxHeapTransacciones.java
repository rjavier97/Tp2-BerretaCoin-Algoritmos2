package aed.Clases;

import aed.*;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque

public class MaxHeapTransacciones {

    private Heap<Tupla> heap;
    private Transaccion[] transaccionesOriginal;
    private int tamaño;
    private int montoTotalSinCreacion;
    private int tamañoSinCreacion;

    private class Tupla implements Comparable<Tupla> {
        private Transaccion elemento;
        private Handle posicion;
        private Tupla (Transaccion e, int pos){ // O(1)
            this.elemento = e;  // O(1)
            this.posicion = new Handle(pos);  // O(1)
        }

        public int posicion(){ // O(1)
            return posicion.posicion(); // O(1)
        }

        @Override
        public int compareTo(Tupla otro) {  // O(1)
            if(otro == null){  //O(1)
                String mensajeDeError = "No puede compararse con null";  //O(1)
                throw new IllegalArgumentException(mensajeDeError);  //O(1)
            }
            return elemento.compareTo(otro.elemento); // O(1)
        }
    } // Aca termina la clase Tupla


    // Constructor MaxHeapTransacciones() tiene complejidad O(T)
    public MaxHeapTransacciones(Transaccion[] transacciones) {
        this.tamaño = transacciones.length; // O(1)
        this.transaccionesOriginal = new Transaccion[tamaño]; // O(1)
        Tupla[] copia = new Tupla[tamaño];   // O(1)

        for (int i = 0; i < tamaño; i++) {  // O(T)
            Tupla nuevaTupla = new Tupla(transacciones[i], i);
            copia[i] = nuevaTupla;   // O(1)
            transaccionesOriginal[i] = transacciones[i];  // O(1)

            if (transacciones[i].id_comprador() != 0) {   // O(1)
                montoTotalSinCreacion = montoTotalSinCreacion + transacciones[i].monto();   // O(1)
                tamañoSinCreacion++;   // O(1)
            }
        }

        this.heap = new Heap<>(copia); // O(T)  (por heapify)
    }
    
    // El metodo desencolar() tiene complejidad O(log(T))
    public void desencolar() {  //O(log(T))
        if (heap.tamaño() == 0) {  // O(1)
            return;
        }
        int posicion = heap.maximo().posicion(); // O(1)
        if (posicion != -1) {  // O(1)
            transaccionesOriginal[posicion] = null;  // O(1)
        }

        heap.desencolar(); // O(log T)    // aca el desencolar es el del metodo del Heap generico
        tamaño--;  // O(1)
    }

    // Metodo transaccionMayorValor() tiene complejidad O(1) pues hace un retorno que usa un metodo en O(1)
    public Transaccion transaccionMayorValor(){  //O(1)
        return heap.maximo().elemento;  //O(1)
    }

    // Aclaracion: la idea es mantener el mismo tamaño del arreglo heap
    // Luego cuando usemos el metodo copiar() recorreremos uno x uno ( O(T) ), y copiaremos todo menos los elementos que sean null.
    // Metodo copiaDeTransacciones() tiene complejidad O(T) ya que recorre todo el arreglo de transacciones
    public Transaccion[] copiaDeTransacciones (){  // O(T)
       Transaccion[] copia = new Transaccion[tamaño];  // O(1)
        int j = 0;  // O(1)

        for (Transaccion t : transaccionesOriginal) { // O(T)
            if (t != null) {  // O(1)
                copia[j] = t;  // O(1)
                j ++;  // O(1)
            }
        }
        return copia;
    }
    
    // Metodo tamaño() tiene complejidad O(1) pues es un solo return
    public int tamaño(){  //O(1)
        return tamaño;  //O(1)
    }

    // Metodo montoPromedio() tiene complejidad O(1) pues solo es un condicional con return en O(1)
    public int montoPromedio(){  // O(1)
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

    // public MaxHeapTransacciones() {  //O(1)
    //     this.tamaño = 0;  //O(1)
    //     this.montoTotalSinCreacion = 0;  //O(1)
    //     this.tamañoSinCreacion = 0;  //O(1)
    //     this.heap = new Heap[0];  //O(1)
    //     this.transaccionesOriginal = new Transaccion[0];  //O(1)
    // }


    // public MaxHeapTransacciones testear(Transaccion[] transacciones) {
    //     MaxHeapTransacciones test = new MaxHeapTransacciones();
    //     this.tamaño = transacciones.length;  //O(1)
    //     Transaccion[] copiaTransacciones = new Transaccion[this.tamaño];  //O(1)
    //     int varMonto = 0;
    //     int varTamaño = 0;
    //     for(int i =0 ; i<this.tamaño ; i++){ // O(T)
    //     copiaTransacciones[i] = transacciones[i] ;  //O(1)
    //     if (transacciones[i].id_comprador() != 0){  //O(1)
    //         varMonto = varMonto + transacciones[i].monto() ;  //O(1)
    //         varTamaño ++ ;  //O(1)
    //     }
    //     }
    //     this.montoTotalSinCreacion = varMonto;
    //     this.tamañoSinCreacion = varTamaño;
    //     this.heap = new Heap[tamaño];  //O(1)
    //     for (int i = 0; i < tamaño; i++) { //O(T)
    //         heap[i] = new Heap(transacciones[i]);  //O(1)
    //         heap[i].nodo.modificarPosicion(i);
    //     }
    //     for (int i = tamaño / 2 - 1; i >= 0; i--) { // O(log(T))
    //         bajar(i);   // O(log(T))
    //     }
    //     this.transaccionesOriginal = copiaTransacciones;  //O(1)
    //     test = this;
    //     return test;
    // }
}    



