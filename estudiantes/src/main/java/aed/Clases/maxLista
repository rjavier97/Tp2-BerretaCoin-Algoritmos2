package aed;

import java.util.*;


public class maxLista<T extends Comparable<T>> {
 // Agregar atributos privados del Conjunto
    private int maximo;
    private int tamaño;
    private Integer[] arreglo;


    

    public maxLista() {
        this.maximo = 0;
        this.tamaño = 0;
        this. arreglo = new Integer[0];
    }

    public void insertar (Integer n){
        this.tamaño += 1;
        Integer nuevo = n;
        Integer[] nuevoArreglo = new Integer[tamaño+1];
        for (int i = 0; i < tamaño; i++){
            nuevoArreglo[i] = this.arreglo[i];
        }
        nuevoArreglo[tamaño - 1] = nuevo;
        this.arreglo = constructormaxLista(nuevoArreglo);
        this.maximo = this.arreglo[0];
    }

    public maxLista (maxLista<T> lista){
        this.maximo = lista.maximo;
        this.tamaño = lista.tamaño;
        this.arreglo = lista.arreglo;
    }


    public Integer[] constructormaxLista(Integer[] arr) {
        this.tamaño = arr.length;
        Integer[] orden = arr;
        // Build heap (rearrange array)
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            heapify(orden, tamaño, i);
        }
        return orden;
    }


    


    public  void heapify(Integer[] arr, int n, int i) {
        int indiceMax = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2; 

        
        if (left < n && arr[left] > arr[indiceMax]) {
            maximo = left;
        }

       
        if (right < n && arr[right] > arr[indiceMax]) {
            indiceMax = right;
        }

        
        if (indiceMax != i) {
            int swap = arr[i];
            arr[i] = arr[indiceMax];
            arr[indiceMax] = swap;

           
            heapify(arr, n, indiceMax);
        }

    }




    public int cardinal() {
        return this.tamaño;
    }


    public boolean pertenece(T elem){
            if(tamaño == 0){
                return false;
            }
            for (int i = 0; i > tamaño-1;i++){
                if(arreglo[i] == elem){
                    return true;
                }
            }
            return false;
        }
    

}


