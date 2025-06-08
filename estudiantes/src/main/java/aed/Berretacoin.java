package aed;

import aed.Clases.*;

import java.lang.reflect.Array;

public class Berretacoin {
    private Bloque bloque;
    private Usuarios prioridadUsuarios ;

    // MaxHeap n_usuarios combinando con arreglos (HAnddles)
    // aca vamos almacenando la informacion de los demas bloques junto con el ultimobloque
    // tomando el monto de las transacciones, y ordenados por monto

    // Bloque ultimobloque 
    // Bloque tiene 4 atributos
    // uoo es un MaxHeap de transacciones que van a estar ordenados por monto
    // el 2do es un arreglo de transacciones tal cual nos lo dan (seria el original)
    // el 3ero es la cantidad de transacciones (tamaño)
    // el 4to es el montoTotal de todas las transacciones del bloque 


    public Berretacoin(int n_usuarios){
        ;
    }

    public void agregarBloque(Transaccion[] transacciones){
        throw new UnsupportedOperationException("Implementar!");
    }

    public Transaccion txMayorValorUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public Transaccion[] txUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public int maximoTenedor(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public int montoMedioUltimoBloque(){
        throw new UnsupportedOperationException("Implementar!");
    }

    public void hackearTx(){
        throw new UnsupportedOperationException("Implementar!");
    }
}
