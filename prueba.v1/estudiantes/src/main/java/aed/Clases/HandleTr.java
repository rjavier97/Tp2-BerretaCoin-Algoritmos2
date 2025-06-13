package aed.Clases;

import aed.Transaccion;

public class HandleTr {
    private Transaccion elemento ;
    private int posicion;

    public HandleTr(Transaccion elemento, int posicion) {
        this.elemento = elemento;
        this.posicion = posicion;
    }

    public int posicion(){
        return posicion;
    }

    public Transaccion elemento(){
        return elemento;
    }

    public void modificar(Transaccion transaccion){
        this.elemento = transaccion;

    }
}
