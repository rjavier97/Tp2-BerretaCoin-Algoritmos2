package aed.Clases;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque
    
public class MaxHeapUsuarios {
    // private Usuario[] heap;
    // private int tamaño;
    private Heap<Usuario> heapUsuarios;
    private Handle[] handles;
    
    // Constructor MaxHeapUsuarios() tiene complejidad O(P) pues recorre y hace asignaciones O(1) P veces.
    public MaxHeapUsuarios(int cantidadUsuarios) {
        Usuario[] usuarios = new Usuario[cantidadUsuarios];
        this.handles = new Handle[cantidadUsuarios];

        for (int i = 0; i < cantidadUsuarios; i++) {
            Handle h = new Handle(i);
            Usuario u = new Usuario(i + 1, 0, h);
            usuarios[i] = u;
            handles[i] = h;
        }

        heapUsuarios = new Heap<>(usuarios);
    }

    public void actualizarMonto(int idUsuario, int nuevoMonto) {
        int pos = handles[idUsuario - 1].posicion();
        Usuario u = heapUsuarios.obtenerElementos()[pos];
        int anterior = u.monto();
        u.modificarMonto(nuevoMonto);

        if (nuevoMonto > anterior) {
            heapUsuarios.subir(pos);
        } else {
            heapUsuarios.bajar(pos);
        }
    }

    public int usuarioMayorMonto() {
        return heapUsuarios.maximo().id();
    }

    public int obtenerMonto(int idUsuario) {
        int pos = handles[idUsuario - 1].posicion();
        return heapUsuarios.obtenerElementos()[pos].monto();
    }

        // // Metodo obtenerMonto() tiene complejidad O(1) pues returna el monto del usuario pasado por parametro (usa metodos que tambien estan en O(1)
    // public int obtenerMonto(int idUsuario) {   //O(1)
    //     return heapUsuarios[handles[idUsuario - 1].posicion()].monto();   //O(1)
    // }

    // // Constructor MaxHeapUsuarios() tiene complejidad O(P) pues recorre y hace asignaciones O(1) P veces.
    // public MaxHeapUsuarios(int cantidadUsuarios) {  //O(P)
    //     this.heap = new Usuario[cantidadUsuarios];  //O(1)
    //     this.handles = new Handle[cantidadUsuarios];  //O(1)
    //     this.tamaño = cantidadUsuarios;  //O(1)

    //     for (int i = 0; i < cantidadUsuarios; i++) {    // O(P)
    //         Handle h = new Handle(i);   // O(1)
    //         Usuario u = new Usuario(i + 1, 0, h);   // O(1)
    //         heap[i] = u;   // O(1)
    //         handles[i] = h;   // O(1)
    //     }
    // }

    // // Metodo actualizarMonto() tiene complejidad O(log(P)) pues usa metodos subir() o bajar() que son O(log(P))
    // public void actualizarMonto(int idUsuario, int nuevoMonto) {   //O(log(P))
    //     int i = handles[idUsuario - 1].posicion();   //O(1)
    //     Usuario u = heap[i];   //O(1)
    //     int anterior = u.monto();   //O(1)
    //     u.modificarMonto(nuevoMonto);   //O(1)
    //     if (nuevoMonto > anterior) {
    //         subir(i);   // O(log(P))
    //     } else {
    //         bajar(i);  //O(log(P))
    //     }
    // }
    
    // // Metodo usuarioMayorMonto() tiene complejidad O(1) pues retorna el id del maximo del heap
    // public int usuarioMayorMonto(){   //O(1)
    //     return heap[0].id();   //O(1)
    // }



    // // Metodo swap() tiene complejidad O(1) pues solo hace asignaciones y usa metodos en O(1)
    // private void swap(int i, int j) {  //O(1)
    //     Usuario tmp = heap[i];  //O(1)
    //     heap[i] = heap[j];  //O(1)
    //     heap[j] = tmp;  //O(1)

    //     heap[i].actualizarPosicionEnHeap(i);  //O(1)
    //     heap[j].actualizarPosicionEnHeap(j);  //O(1)
    // }


    public interface HeapElement {
        void actualizarPosicion(int nuevaPos);
    }
}




             