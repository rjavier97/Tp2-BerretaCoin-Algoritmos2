package aed;

import java.util.*;
import java.util.ArrayList;


public class maxHandle<T extends Comparable<T>> {
    private int tamaño;
    private ArrayList<Nodo> arreglo;
    private ArrayList<Nodo> base;


    private class Nodo {
        Integer elemento;
        Nodo alArbol;
        public Nodo (Integer e) {
            this.elemento = e;
        }
    }

    

    public maxHandle() {
        this.tamaño = 0;
        this.arreglo = new ArrayList<Nodo>(0);
        this.base = new ArrayList<Nodo>(0);
    }


    public Integer maximo(){
        return this.arreglo.get(0).elemento;
    }
    /*public void insertar (Integer n){
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
        this.arreglo = constructormaxHandle(nuevoArreglo);
        }
        this.maximo = this.arreglo[0];
    }
        
    
    }
    */
    public maxHandle (maxHandle<T> lista){
        this.tamaño = lista.tamaño;
        this.arreglo = lista.arreglo;
        this.base = lista.base;
    }


    public maxHandle<T> constructormaxHandle(Integer[] arr) {
        maxHandle<T> objeto = new maxHandle();
        this.tamaño = arr.length;
        ArrayList<Nodo> copia = new ArrayList<>(tamaño);
        for (int i = 0; i < tamaño; i++){
            Nodo nuevo = new Nodo(arr[i]);
            nuevo.alArbol = nuevo;
            copia.add(i, nuevo);
        }
        this.base = copia;
        ArrayList<Nodo> ordenar = new ArrayList<>(tamaño);
        for(int i = 0; i < tamaño; i++){
            ordenar.add(i,this.base.get(i));
            ordenar.get(i).alArbol = this.base.get(i);
            this.base.get(i).alArbol = ordenar.get(i);
        }
        if(this.tamaño == 1){
            //caso arreglo de tamaño 1;
        }
        // ordenar el heap;
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            heapify(ordenar, tamaño, i);
        }
        this.arreglo = ordenar;
        return objeto;
    }


    


    public  void heapify(ArrayList<Nodo> arr, int n, int i) {
        int indiceMax = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2; 

        
        if (left < n && arr.get(left).elemento > arr.get(indiceMax).elemento) {
            indiceMax = left;
        }

       
        if (right < n && arr.get(right).elemento > arr.get(indiceMax).elemento) {
            indiceMax = right;
        }

        
        if (indiceMax != i) {
            Nodo swap = arr.get(i);
            arr.set(i,arr.get(indiceMax));
            arr.set(indiceMax, swap);

           
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
                if(this.base.get(i).elemento == elem){
                    return true;
                }
            }
            return false;
    }
    
    public void modificarUno (int indice, Integer valor){
        Nodo cambiar = this.base.get(indice);
        cambiar.elemento = cambiar.elemento + valor;
        this.base.set(indice, cambiar);
        moverUno(indice);
    }

    public void moverUno (int indice){
        
        int indiceHeap = arreglo.indexOf(this.base.get(indice).alArbol);
        int indiceMovil = indiceHeap;
        int i = (indiceMovil - 1) / 2;
        for(; i > 0;){
            //si tiene una raiz menor;
            if(arreglo.get(indiceMovil).elemento > arreglo.get(i).elemento){
                Nodo swap = arreglo.get(i);
                arreglo.set(i, arreglo.get(indiceMovil));
                arreglo.set(indiceMovil, swap);
                indiceMovil = i;
                i = (indiceMovil - 1) / 2;
                if(i==0){
                swap = arreglo.get(i);
                arreglo.set(i, arreglo.get(indiceMovil));
                arreglo.set(indiceMovil, swap);
                break;
                }
                }else{
                    break;
            }
        }
        if(indiceMovil == indiceHeap){
            // si hubo desplazamiento hacia arriba del arbol no hace falta hacer hacia abajo
        //indiceMovil = indiceHeap;
        int left = 2 * indiceMovil + 1;
        int right = 2 * indiceMovil + 2;
        boolean relacionIzq = false;
        boolean relacionDer = false;
        if(left<tamaño){
        relacionIzq = arreglo.get(indiceMovil).elemento < arreglo.get(left).elemento;
        }
        if(right<tamaño){
        relacionDer = arreglo.get(indiceMovil).elemento < arreglo.get(right).elemento;
        }
        for(; relacionIzq == true || relacionDer == true;){
            //si tiene una ramas mayores;
            if((left < tamaño) & arreglo.get(indiceMovil).elemento < arreglo.get(left).elemento){
        
                Nodo swap = arreglo.get(left);
                arreglo.set(left, arreglo.get(indiceMovil));
                arreglo.set(indiceMovil, swap);
                indiceMovil = left;
                left = 2 * indiceMovil + 1;
                right = 2 * indiceMovil + 2;
                if(left<tamaño){
                relacionIzq = arreglo.get(indiceMovil).elemento < arreglo.get(left).elemento;
                }else{
                    relacionIzq = false;
                }
            }else if(right < tamaño){
                Nodo swap = arreglo.get(right);
                arreglo.set(right, arreglo.get(indiceMovil));
                arreglo.set(indiceMovil, swap);
                indiceMovil = right;
                left = 2 * indiceMovil + 1;
                right = 2 * indiceMovil + 2;
                if(right<tamaño){
                relacionDer = arreglo.get(indiceMovil).elemento < arreglo.get(right).elemento;
                }else{
                    relacionDer = false;
                }
            }else{
                break;
            }
        }
        }

        
    }






}









}


