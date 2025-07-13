package aed.Clases;

public class Heap<T extends Comparable<T> > {
    private T[] elementos;
    private int tamaño;

    public Heap(T[] elementosIniciales) { // O(n)
        this.elementos = elementosIniciales.clone(); // O(n)
        this.tamaño = elementos.length;   // O(1)

        for (int i = tamaño / 2 - 1; i >= 0; i--) { // O(n) pasar un arreglo a heap vimos que era O(n) por heapify
            bajar(i);
        }
    }

    public void desencolar() { // O(log n)
        if (tamaño == 0) { // O(1)
            return;
        }    
        swap(0, tamaño - 1); // O(1)
        tamaño--; // O(1)
        bajar(0); // O(log n)
    }

    public T maximo() { // O(1)
        return elementos[0]; // O(1)
    }

    public int tamaño() {   // O(1)
        return tamaño; // O(1)
    }

    public T[] obtenerElementos() { // O(1)
       return elementos; // O(1)
    }

    // El Metodo subir() tiene complejidad log(n) pues recibe la posicion del usuario en el handle,
    // que en el peor caso si esta en la ultima posicion (que es la cantidad de usuarios)     
    // recorrera como mucho la altura del heap, es decir log(n) 
    public void subir(int i) {
        while (i > 0) { // O(log n)
            int padre = (i - 1) / 2; // O(1)
            if (elementos[i].compareTo(elementos[padre]) > 0) { // O(1)
                swap(i, padre);  // O(1)
                i = padre;  // O(1)
            } else {
                break;
            }
        }
    }

    // El Metodo bajar() tiene complejidad O(log(n))
    // ya que el siguiente ciclo siempre va a estar comparando una cantidad de veces como mucho igual a la altura del heap,
    // que podemos pensarlo como altura = log(n)
    public void bajar(int i) {  // O(log n)
        while (true) {  // O(log n)
            int izq = 2 * i + 1; // O(1)
            int der = 2 * i + 2; // O(1)
            int mayor = i; // O(1)

            if (izq < tamaño && elementos[izq].compareTo(elementos[mayor]) > 0) // O(1)
                mayor = izq; // O(1)
            if (der < tamaño && elementos[der].compareTo(elementos[mayor]) > 0) // O(1)
                mayor = der; // O(1)

            if (mayor != i) { // O(1)
                swap(i, mayor);
                i = mayor; // O(1)
            } else break;
        }
    }

    // Metodo swap() tiene complejidad O(1) pues solo hace asignaciones y usa metodos en O(1)
    //Aclaraciones: las primeras 3 lineas de este metodo se aplican tanto en MaxHeapTransacciones como en MaxHeapUsuarios
    // Luego de eso, si T=Usuario vamos a querer hacer algo más, que en este caso será actualizar 
    // las posiciones del Usuario en el Handle cuando hagamos swap. Solo hacemos esto ultimo si T=Usuario
    private void swap(int i, int j) {
        T temp = elementos[i];  // O(1)
        elementos[i] = elementos[j];  // O(1)
        elementos[j] = temp;  // O(1)

        if (elementos[i] instanceof MaxHeapUsuarios.HeapElement) {  // O(1)
            MaxHeapUsuarios.HeapElement elem1 = (MaxHeapUsuarios.HeapElement) elementos[i];  // O(1)
            elem1.actualizarPosicion(i);  // O(1)
        }
        if (elementos[j] instanceof MaxHeapUsuarios.HeapElement) {  // O(1)
            MaxHeapUsuarios.HeapElement elem2 = (MaxHeapUsuarios.HeapElement) elementos[j];  // O(1)
            elem2.actualizarPosicion(j);  // O(1)
        }
    }


}

