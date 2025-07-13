package aed;

public class Transaccion implements Comparable<Transaccion> {
    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;

    // Metodo Transaccion tiene complejidad O(1) pues solo tiene asignaciones
    public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {  //O(1)
        this.id = id;   //O(1)
        this.id_comprador = id_comprador;  //O(1)
        this.id_vendedor = id_vendedor;  //O(1)
        this.monto = monto;  //O(1)
    }

    // Metodo compareTo() tiene complejidad O(1) pues son condicionales anidados con asignaciones O(1) 
    @Override
    public int compareTo(Transaccion otro) {    
        if(otro == null){  //O(1)
            String mensajeDeError = "No puede compararse con null";  //O(1)
            throw new IllegalArgumentException(mensajeDeError);  //O(1)
        }
        int res = 0 ;  //O(1)
        int resta = this.monto - otro.monto;
        if (resta>0 || (resta==0 && this.id>otro.id) ){  //O(1)
            res = 1;  //O(1)
        } 
        if (resta<0 || (resta==0 && this.id < otro.id) ){  //O(1)
            res = -1 ;  //O(1)
        } 
        return res ;  //O(1)
    }

    // Metodo equals() tiene complejidad O(1) pues son asignaciones + condicional + return
    @Override
    public boolean equals(Object otro){  // O(1)

        if(otro == null || otro.getClass() != this.getClass()) {  // O(1)
            return false ;  // O(1)
        }
        Transaccion otraTransaccion = (Transaccion) otro ; //O(1)
        return (id == otraTransaccion.id && id_comprador == otraTransaccion.id_comprador   //O(1)
        && id_vendedor == otraTransaccion.id_vendedor && monto == otraTransaccion.monto);  //O(1)

    }

    // Metodo monto() tiene complejidad O(1) pues es solo un return
    public int monto() {  //O(1)
        return monto;  //O(1)
    }

    // Metodo id_comprador tiene complejidad O(1) pues es solo un return
    public int id_comprador() {  //O(1)
        return id_comprador;  //O(1)
    }
    
    // Metodo id_vendedor tiene complejidad O(1) pues es solo un return
    public int id_vendedor() {  //O(1)
        return id_vendedor;  //O(1)
    }
}