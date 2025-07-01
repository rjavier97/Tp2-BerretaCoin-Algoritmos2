package aed.Clases;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque
    
public class MaxHeapUsuarios {
    private Usuario[] heap;
    private int tamaño;
    private Handle[] handles;
    
    // Constructor MaxHeapUsuarios() tiene complejidad O(P) pues recorre y hace asignaciones O(1) P veces.
    public MaxHeapUsuarios(int cantidadUsuarios) {  //O(P)
        this.heap = new Usuario[cantidadUsuarios];  //O(1)
        this.handles = new Handle[cantidadUsuarios];  //O(1)
        this.tamaño = cantidadUsuarios;  //O(1)

        for (int i = 0; i < cantidadUsuarios; i++) {    // O(P)
            Handle h = new Handle(i);   // O(1)
            Usuario u = new Usuario(i + 1, 0, h);   // O(1)
            heap[i] = u;   // O(1)
            handles[i] = h;   // O(1)
        }
    }

    // Metodo actualizarMonto() tiene complejidad O(log(P)) pues usa metodos subir() o bajar() que son O(log(P))
    public void actualizarMonto(int idUsuario, int nuevoMonto) {   //O(log(P))
        int i = handles[idUsuario - 1].posicion();   //O(1)
        Usuario u = heap[i];   //O(1)
        int anterior = u.monto();   //O(1)
        u.modificarMonto(nuevoMonto);   //O(1)
        if (nuevoMonto > anterior) {
            subir(i);   // O(log(P))
        } else {
            bajar(i);  //O(log(P))
        }
    }
    
    // Metodo usuarioMayorMonto() tiene complejidad O(1) pues retorna el id del maximo del heap
    public int usuarioMayorMonto(){   //O(1)
        return heap[0].id();   //O(1)
    }

    // Metodo obtenerMonto() tiene complejidad O(1) pues returna el monto del usuario pasado por parametro (usa metodos que tambien estan en O(1)
    public int obtenerMonto(int idUsuario) {   //O(1)
        return heap[handles[idUsuario - 1].posicion()].monto();   //O(1)
    }

    // Metodo subir() tiene complejidad log(P) pues recibe la posicion del usuario en el handle, en el peor caso si esta en la ultima posicion (que es la cantidad de usuarios)     
    // recorrera como mucho la altura del heap, es decir log(P) veces el heap 
    private void subir(int i) {
        while (i > 0) { // log(P)
            int padre = (i - 1) / 2;    // O(1)
            if (heap[i].compareTo(heap[padre])==1) {    //O(1)
                swap(i, padre);    // O(1)
                i = padre;    // O(1)
            } else break;    // O(1)
        }
    }

    // Metodo bajar() tiene complejidad O(log(T))
    private void bajar(int i) {
        while (true) { //
            int izq = 2 * i + 1;  //O(1)
            int der = 2 * i + 2;  //O(1)
            int mayor = i;   //O(1)

            if (izq < tamaño && heap[izq].compareTo(heap[mayor])==1) {   //O(1)
                mayor = izq;  //O(1)
            }    
            if (der < tamaño && heap[der].compareTo(heap[mayor])==1) {  //O(1)
                mayor = der;  //O(1)
            }
            if (mayor != i) {   //O(1)
                swap(i, mayor);  //O(1)
                i = mayor;  //O(1)
            } else break;
        }
    }

    // Metodo swap() tiene complejidad O(1) pues solo hace asignaciones y usa metodos en O(1)
    private void swap(int i, int j) {  //O(1)
        Usuario tmp = heap[i];  //O(1)
        heap[i] = heap[j];  //O(1)
        heap[j] = tmp;  //O(1)

        heap[i].actualizarPosicionEnHeap(i);  //O(1)
        heap[j].actualizarPosicionEnHeap(j);  //O(1)
    }

    // Metodo usuarioEn() tiene complejidad O(1) pues solo retorna una posicion del atributo heap
    public Usuario usuarioEn(int i) {  //O(1)
        return heap[i];  //O(1)
    }

    // Metodo cantidadUsuarios() tiene complejidad O(1) pues solo es un return de un atributo
    public int cantidadUsuarios() {  //O(1)
        return tamaño;  //O(1)
    }
}




             