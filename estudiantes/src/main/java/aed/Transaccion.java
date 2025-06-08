package aed;

import java.util.ArrayList;

public class Transaccion implements Comparable<Transaccion> {
    private int id;
    private int id_comprador;
    private int id_vendedor;
    private int monto;

    public Transaccion(int id, int id_comprador, int id_vendedor, int monto) {
        this.id = id;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.monto = monto;
    }

    @Override
    public int compareTo(Transaccion otro) {    
        if(otro == null){
            String mensajeDeError = "No puede compararse con null";
            throw new IllegalArgumentException(mensajeDeError);
        }
            
        return this.monto - otro.monto;
    }

    @Override
    public boolean equals(Object otro){
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();

        if (otroEsNull || claseDistinta){
            return false;
        }

        Transaccion otraTransaccion = (Transaccion) otro ;

        return (id == otraTransaccion.id && id_comprador == otraTransaccion.id_comprador 
        && id_vendedor == otraTransaccion.id_vendedor && monto == otraTransaccion.monto);

    }

    public int monto() {
        return monto;
    }

    public int id_comprador() {
        return id_comprador;
    }
    
    public int id_vendedor() {
        return id_vendedor;
    }
}