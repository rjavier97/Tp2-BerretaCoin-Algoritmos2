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
        Integer nuevo = n;
        if(pertenece(n) == false){
        this.tamaño += 1;
        Integer[] nuevoArreglo = new Integer[tamaño];
        if(tamaño == 1){
            nuevoArreglo[0] = nuevo;
            this.arreglo = nuevoArreglo;
        }else{
        for (int i = 0; i < tamaño - 1; i++){
            nuevoArreglo[i] = this.arreglo[i];
        }
        nuevoArreglo[tamaño - 1] = nuevo;
        this.arreglo = constructormaxLista(nuevoArreglo);
        }
        this.maximo = nuevo;
    }
        
    
    }

    public maxLista (maxLista<T> lista){
        this.maximo = lista.maximo;
        this.tamaño = lista.tamaño;
        this.arreglo = lista.arreglo;
    }


    public Integer[] constructormaxLista(Integer[] arr) {
        this.tamaño = arr.length;
        Integer[] orden = arr;
        if(this.tamaño == 1){
            return orden;
        }
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
            indiceMax = left;
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


    public boolean pertenece(Integer elem){
            if(tamaño == 0){
                return false;
            }
            for (int i = 0; i < tamaño;i++){
                if(this.arreglo[i] == elem){
                    return true;
                }
            }
            return false;
        }
    

}



