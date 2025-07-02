package aed.Clases;

import java.util.ArrayList;
import aed.*;

public class Heap<T extends Comparable<T>>{
    private ArrayList<Tupla> heap;
    private int tamaño;
    
    public class Tupla {
        private T elemento;
        private Handle nodo;
        public Tupla (T i){ // O(1)
            this.elemento = i;  // O(1)
            this.nodo = new Handle(-1);  // O(1)
        }
        public Handle nodo(){
            return nodo;
        }
        public T elemento(){
            return elemento;
        }
    }

    public Heap(T[] _lista) {
        this.tamaño = _lista.length;  //O(1)
        // ArrayList<T> copiaElementos = new ArrayList<T>();  //O(1)
        ArrayList<Tupla> nuevoHeap = new ArrayList<Tupla>();
        for(int i =0 ; i<this.tamaño ; i++){ // O(T)
            // copiaElementos.add(_lista[i]) ;  //O(1)
            nuevoHeap.add(new Tupla(_lista[i]));
            nuevoHeap.get(i).nodo.modificarPosicion(i);
        }
        heap = nuevoHeap;
        for (int i = tamaño / 2 - 1; i >= 0; i--) { // O(log(T))
            bajar(i);   // O(log(T))
        }
    }   

    public void desencolar() {
        if (heap.size()==1){   //O(1)
            heap = new ArrayList<Tupla>(0);  //O(1)
            tamaño --;  //O(1)
            return ;  //O(1)
        }
        Tupla max = heap.get(0);  //O(1)
        heap.set(tamaño-1, max);  //O(1)
        bajar(0);   //O(log(T))

        tamaño -- ;  //O(1)
    }

    // Metodo bajar() tiene complejidad O(log(T))
    public void bajar(int i) {
        while (true) { //
            int izq = 2 * i + 1;  //O(1)
            int der = 2 * i + 2;  //O(1)
            int mayor = i;   //O(1)

            if (izq < tamaño && heap.get(izq).elemento.compareTo(heap.get(mayor).elemento)==1)  {   //O(1)
                mayor = izq;  //O(1)
            }    
            if (der < tamaño && heap.get(der).elemento.compareTo(heap.get(mayor).elemento)==1) {  //O(1)
                mayor = der;  //O(1)
            }
            if (mayor != i) {   //O(1)
                swap(i, mayor);  //O(1)
                i = mayor;  //O(1)
            } else break;
        }
    }

    public void subir(int i) {
        while (i > 0 ) { // log(P)
            int padre = (i - 1) / 2;    // O(1)
            if (heap.get(i).elemento.compareTo(heap.get(padre).elemento)==1)  {    //O(1)
                swap(i, padre);    // O(1)
                i = padre;    // O(1)
            } else break;    // O(1)
        }
    }

    public void swap(int i, int j) {  //O(1)
        Tupla tmp = heap.get(i);  //O(1)
        heap.set(i, heap.get(j));
        heap.set(j,tmp);  //O(1)
    }


    public ArrayList<Tupla> devolverHeap (){
        return heap ;
    }

    public int tamaño(){
        return tamaño;
    }

    public Tupla devolverMax(){
        return heap.get(0);
    }

}

