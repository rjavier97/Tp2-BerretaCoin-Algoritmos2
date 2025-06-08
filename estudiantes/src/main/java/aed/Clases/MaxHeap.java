package aed.Clases;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T> >{
    // private Monto[] MontosOrdenados ;
    private int[] heapUsuarios;
    private int tamaño ;
    private int elementosUsados;

    public MaxHeap(int n_usuarios) {
        this.heapUsuarios = new int[n_usuarios];
        this.tamaño = n_usuarios;
        this.elementosUsados = 0;
    }

    public int cardinal() {
        return this.elementosUsados;
    }

    public void insertar (int elem){
        if (elementosUsados == 0){
            heapUsuarios[0] = elem ;
            elementosUsados ++ ;
        } else {
            heapUsuarios[elementosUsados]=elem;
            int indice = elementosUsados;
            if (elementosUsados % 2 == 0){
                while (elem != heapUsuarios[0] && elem>heapUsuarios[(indice-2)/2]) {
                    int padre = heapUsuarios[indice];
                    heapUsuarios[(indice-2)/2] = elem ;
                    heapUsuarios[indice] = padre ;
                    
                    indice = (indice-2)/2 ;


                }
            }


        }
    } 

}




    // private class Nodo {
    //     T valor ;
    //     Nodo izq ;
    //     Nodo der ;
    //     Nodo padre ;
    //     int posicion ;

    //     Nodo (T v) {
    //         valor = v ;
    //         izq = null ;
    //         der = null ;
    //         padre = null ;
    //         posicion = 0 ;
    //     }
    // }
