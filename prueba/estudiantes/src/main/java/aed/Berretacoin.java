package aed;

import aed.Clases.*;

public class Berretacoin {
    private MaxHeapUsuarios heapUsuarios;
    private MaxHeapTransacciones bloqueActual;

    public Berretacoin(int cantidadUsuarios) {
        heapUsuarios = new MaxHeapUsuarios(cantidadUsuarios);
        bloqueActual = null; 
    }

    public void agregarBloque(Transaccion[] transacciones) {
        bloqueActual = new MaxHeapTransacciones(transacciones); // nuevo bloque reemplaza el anterior
        Transaccion[] lista = bloqueActual.devolverHeap();
        for (int i = 0; i < lista.length; i++) {
            Transaccion t = lista[i];
            int comprador = t.id_comprador();
            int vendedor = t.id_vendedor();
            int monto = t.monto();

            if (comprador != 0) {
                int montoAnterior = heapUsuarios.obtenerMonto(comprador);
                heapUsuarios.actualizarMonto(comprador, montoAnterior - monto);
            }

            int montoAnteriorV = heapUsuarios.obtenerMonto(vendedor);
            heapUsuarios.actualizarMonto(vendedor, montoAnteriorV + monto);
        }
    }

    public Transaccion txMayorValorUltimoBloque(){
        return bloqueActual.transaccionMayorValor();
    }

    public Transaccion[] txUltimoBloque(){
        return bloqueActual.copia();
    }

    public int maximoTenedor(){
        return heapUsuarios.usuarioMayorMonto();

    }

    public int montoMedioUltimoBloque(){
        return bloqueActual.montoPromedio();
    }

    public MaxHeapTransacciones bloqueActual(){
        return bloqueActual;
    }

    public void hackearTx(){
        bloqueActual.desencolar();
    }


    // public int montoUsuario(int idUsuario) {
    //     return heapUsuarios.obtenerMonto(idUsuario);
    // }

    // public MaxHeapTransacciones verBloqueActual() {
    //     return bloqueActual;
    // }

    // public MaxHeapUsuarios verUsuarios() {
    //     return heapUsuarios;
    // }
}



// package aed;

// import aed.Clases.*;

// import java.lang.reflect.Array;

// public class Berretacoin {
//     private Bloque bloque;
//     private Usuarios prioridadUsuarios ;

//     // MaxHeap n_usuarios combinando con arreglos (HAnddles)
//     // aca vamos almacenando la informacion de los demas bloques junto con el ultimobloque
//     // tomando el monto de las transacciones, y ordenados por monto

//     // Bloque ultimobloque 
//     // Bloque tiene 4 atributos
//     // uoo es un MaxHeap de transacciones que van a estar ordenados por monto
//     // el 2do es un arreglo de transacciones tal cual nos lo dan (seria el original)
//     // el 3ero es la cantidad de transacciones (tamaño)
//     // el 4to es el montoTotal de todas las transacciones del bloque 


//     public Berretacoin(int n_usuarios){
//         ;
//     }

//     public void agregarBloque(Transaccion[] transacciones){
//         throw new UnsupportedOperationException("Implementar!");
//     }

//     public Transaccion txMayorValorUltimoBloque(){
//         throw new UnsupportedOperationException("Implementar!");
//     }

//     public Transaccion[] txUltimoBloque(){
//         throw new UnsupportedOperationException("Implementar!");
//     }

//     public int maximoTenedor(){
//         throw new UnsupportedOperationException("Implementar!");
//     }

//     public int montoMedioUltimoBloque(){
//         throw new UnsupportedOperationException("Implementar!");
//     }

//     public void hackearTx(){
//         throw new UnsupportedOperationException("Implementar!");
//     }
// }




//-----------------------------------------------------------------

    // public void agregarBloque(Transaccion[] transacciones) {
    //     bloqueActual = new MaxHeapTransacciones(transacciones); // nuevo bloque reemplaza el anterior

    //     MaxHeapTransacciones bloqueActualCopia = new MaxHeapTransacciones(transacciones); 

    //     while (bloqueActualCopia.tamaño() != 0) {
    //         Transaccion t = bloqueActualCopia.desencolar();
    //         int comprador = t.id_comprador();
    //         int vendedor = t.id_vendedor();
    //         int monto = t.monto();

    //         if (comprador != 0) {
    //             int montoAnterior = heapUsuarios.obtenerMonto(comprador);
    //             heapUsuarios.actualizarMonto(comprador, montoAnterior - monto);
    //         }

    //         int montoAnteriorV = heapUsuarios.obtenerMonto(vendedor);
    //         heapUsuarios.actualizarMonto(vendedor, montoAnteriorV + monto);
    //     }
    // }

