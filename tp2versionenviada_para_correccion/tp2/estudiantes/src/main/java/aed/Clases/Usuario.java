package aed.Clases;

public class Usuario implements Comparable<Usuario >{
    private int id;
    private int monto;
    private Handle handle;

    // Metodo Usuario() tiene complejidad O(1) pues solo hace asignaciones
    public Usuario(int id, int monto, Handle handle) {
        this.id = id;    // O(1 
        this.monto = monto;    // O(1)
        this.handle = handle;    // O(1)
    }

    // Metodo compareTo() tiene complejidad O(1) pues solo hay condicionales anidados con asignaciones O(1)
    @Override
    public int compareTo(Usuario otro) {    // O(1)
        int res = 0 ;    // O(1)

        if (this.monto - otro.monto >0){    // O(1)
            res = 1;    // O(1)
        } 
        if (this.monto - otro.monto <0){    // O(1)
            res = -1 ;    // O(1)
        } 
        if (this.monto - otro.monto == 0){    // O(1)
            if (this.id < otro.id){    // O(1)
                res = 1;    // O(1)
            } else {
                res = -1;    // O(1)
            }
        }
        return res ;    // O(1)
    }

    // Metodo monto() tiene complejidad O(1) pues solo es un return
    public int monto(){    // O(1)
        return monto;    // O(1)
    }

    // Metodo id() tiene complejidad O(1) pues solo es un return
    public int id(){    // O(1)
        return id;    // O(1)
    }

    // Metodo handle() tiene complejidad O(1) pues solo es un return
    public Handle handle(){    // O(1)
        return handle;    // O(1)
    }
     // Metodo modificarMonto() tiene complejidad O(1) pues solo es una asignacion
    public void modificarMonto(int nuevoMonto) {    // O(1)
        this.monto = nuevoMonto;    // O(1)
    }

}