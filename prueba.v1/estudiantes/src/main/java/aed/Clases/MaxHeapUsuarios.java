package aed.Clases;

public class MaxHeapUsuarios {
    private Usuario[] heap;
    private int tamaño;
    private Handle[] handles;
    
    public MaxHeapUsuarios(int cantidadUsuarios) {
        this.heap = new Usuario[cantidadUsuarios];
        this.handles = new Handle[cantidadUsuarios];
        this.tamaño = cantidadUsuarios;

        for (int i = 0; i < cantidadUsuarios; i++) {
            Handle h = new Handle(i);
            Usuario u = new Usuario(i + 1, 0, h);
            heap[i] = u;
            handles[i] = h;
        }
    }

    public void actualizarMonto(int idUsuario, int nuevoMonto) {
        int i = handles[idUsuario - 1].posicion;
        Usuario u = heap[i];
        int anterior = u.monto();
        u.modificarMonto(nuevoMonto);
        if (nuevoMonto > anterior) {
            subir(i);
        } else {
            bajar(i);
        }
    }

    public int usuarioMayorMonto(){
        return heap[0].id();
    }

    public int obtenerMonto(int idUsuario) {
        return heap[handles[idUsuario - 1].posicion].monto();
    }

    private void subir(int i) {
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heap[i].compareTo(heap[padre])==1) {
                swap(i, padre);
                i = padre;
            } else break;
        }
    }

    private void bajar(int i) {
        while (true) {
            int izq = 2 * i + 1, der = 2 * i + 2, mayor = i;

            if (izq < tamaño && heap[izq].compareTo(heap[mayor])==1) {
                mayor = izq;
            }    
            if (der < tamaño && heap[der].compareTo(heap[mayor])==1) {
                mayor = der;
            }
            if (mayor != i) {
                swap(i, mayor);
                i = mayor;
            } else break;
        }
    }

    private void swap(int i, int j) {
        Usuario tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;

        heap[i].handle().posicion = i;
        heap[j].handle().posicion = j;
    }

    public Usuario usuarioEn(int i) {
        return heap[i];
    }

    public int cantidadUsuarios() {
        return tamaño;
    }
}




// package aed.Clases;

// import java.util.ArrayList;

// public class MaxHeap<T extends Comparable<T> >{
//     // private Monto[] MontosOrdenados ;
//     private int[] heapUsuarios;
//     private int tamaño ;
//     private int elementosUsados;

//     public MaxHeap(int n_usuarios) {
//         this.heapUsuarios = new int[n_usuarios];
//         this.tamaño = n_usuarios;
//         this.elementosUsados = 0;
//     }

//     public int cardinal() {
//         return this.elementosUsados;
//     }

//     public void insertar (int elem){
//         if (elementosUsados == 0){
//             heapUsuarios[0] = elem ;
//             elementosUsados ++ ;
//         } else {
//             heapUsuarios[elementosUsados]=elem;
//             int indice = elementosUsados;
//             if (elementosUsados % 2 == 0){
//                 while (elem != heapUsuarios[0] && elem>heapUsuarios[(indice-2)/2]) {
//                     int padre = heapUsuarios[indice];
//                     heapUsuarios[(indice-2)/2] = elem ;
//                     heapUsuarios[indice] = padre ;
                    
//                     indice = (indice-2)/2 ;


//                 }
//             }


//         }
//     } 

// }
