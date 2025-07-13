package aed.Clases;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque
    
public class MaxHeapUsuarios {
    private Heap<Usuario> heapUsuarios;
    private Handle[] handles;
    
    // Este constructor MaxHeapUsuarios() tiene complejidad O(P) pues recorre y hace asignaciones O(1) P veces.
    public MaxHeapUsuarios(int cantidadUsuarios) {
        Usuario[] usuarios = new Usuario[cantidadUsuarios];  // O(1)
        this.handles = new Handle[cantidadUsuarios];  // O(1)

        for (int i = 0; i < cantidadUsuarios; i++) { // O(P)
            Handle h = new Handle(i);  // O(1)
            Usuario u = new Usuario(i + 1, 0, h);  // O(1)
            usuarios[i] = u;  // O(1)
            handles[i] = h;  // O(1)
        }

        heapUsuarios = new Heap<>(usuarios);   // O(P)
    }


    // Metodo actualizarMonto() tiene complejidad O(log(P)) pues usa metodos subir() o bajar() que son O(log(P))
    public void actualizarMonto(int idUsuario, int nuevoMonto) {   //O(log P)
        int pos = handles[idUsuario - 1].posicion();   //O(1)
        Usuario u = heapUsuarios.obtenerElementos()[pos];   //O(1)
        int anterior = u.monto();   //O(1)
        u.modificarMonto(nuevoMonto);   //O(1)

        if (nuevoMonto > anterior) {   //O(1)
            heapUsuarios.subir(pos);   //O(log P)
        } else {
            heapUsuarios.bajar(pos);   //O(log P)
        }
    }

    // El metodo usuarioMayorMonto() tiene complejidad O(1) ya que el maximo de un heap es O(1) y obtener su id es O(1)
    public int usuarioMayorMonto() {   //O(1)
        return heapUsuarios.maximo().id();   //O(1)
    }


    // Metodo obtenerMonto() tiene complejidad O(1) pues returna el monto
    // del usuario pasado por parametro (usa metodos que tambien estan en O(1) )
    public int obtenerMonto(int idUsuario) {  //O(1)
        int pos = handles[idUsuario - 1].posicion();  //O(1)
        return heapUsuarios.obtenerElementos()[pos].monto();  //O(1)
    }

    public interface HeapElement {
        void actualizarPosicion(int nuevaPos);
    }
}        