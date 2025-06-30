package aed.Clases;

import aed.*;

public class HandleTr {
    private Transaccion elemento ;
    private int posicion;
    
    // Constructor HandleTr() tiene complejidad O(1) pues son asignaciones
    public HandleTr(Transaccion elemento, int posicion) {
        this.elemento = elemento;    // O(1)
        this.posicion = posicion;    // O(1)
    }

    // Metodo posicion() tiene complejidad O(1) pues solo hace un return en el que devuelve el valor del atributo
    public int posicion(){    // O(1)
        return posicion;    // O(1)
    }

    // Metodo elemento() tiene complejidad O(1) pues solo hace un return en el que devuelve el valor del atributo
    public Transaccion elemento(){    // O(1)
        return elemento;    // O(1)
    }

    // Metodo modificar() tiene complejidad O(1) pues solo hace una asignacion
    public void modificar(Transaccion transaccion){    // O(1)
        this.elemento = transaccion;    // O(1)

    }
}
