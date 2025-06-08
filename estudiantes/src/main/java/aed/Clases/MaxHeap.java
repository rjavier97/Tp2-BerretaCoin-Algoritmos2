package aed.Clases;

import java.util.ArrayList;

// public class MaxHeap<T extends Comparable<T> >{
public class MaxHeap{
    // private Monto[] MontosOrdenados ;
    private Usuario[] heapUsuarios;
    private int tamaño ;
    private int elementosUsados;

    public MaxHeap(int n_usuarios) {
        // this.heapUsuarios = new Usuario[n_usuarios];
        Usuario[] array = new Usuario[n_usuarios];
        for (int i=1 ; i <= n_usuarios ; i++){
            array[i] = new Usuario(i,0);
        }
        this.heapUsuarios = array;
        this.tamaño = n_usuarios;
        this.elementosUsados = 0;
    }

    public int cardinal() {
        return this.elementosUsados;
    }

    public void insertarUsuario (Usuario usuario){
        int indice = elementosUsados;
        int padre = 0;
        Usuario otro;
        if (elementosUsados == 0){
            heapUsuarios[0] = usuario;
        } else {
            padre = (indice-1) /2 ;
            while (usuario != heapUsuarios[0] && usuario.compareTo(heapUsuarios[padre])==1 ) {
                otro = heapUsuarios[padre];
                heapUsuarios[padre] = usuario ; 
                heapUsuarios[indice] = otro ;
                padre = (padre-1) /2 ;
                indice = (indice-1) /2 ;

            }
        }
        elementosUsados ++ ;
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
