package aed.Clases;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T> >{
    // private Monto[] MontosOrdenados ;
    private int[] heapUsuarios;
    private int tamaño;

    private class Nodo {
        T valor ;
        Nodo izq ;
        Nodo der ;
        Nodo padre ;
        int posicion ;

        Nodo (T v) {
            valor = v ;
            izq = null ;
            der = null ;
            padre = null ;
            posicion = 0 ;
        }
    }

    public MaxHeap(int n_usuarios) {
        this.heapUsuarios = new int[n_usuarios];
    }

    public int cardinal() {
        return cardinal ;
    }

    public Nodo primer_lugarVacio() {

    }

    public void insertar (T elem){
        Nodo nuevo = new Nodo(elem);
        if ()

    } 

    

    

}