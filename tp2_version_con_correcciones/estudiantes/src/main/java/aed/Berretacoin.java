package aed;

import aed.Clases.*;

// Referencias: P = cantidad de usuarios, T = cantidad de transacciones en el bloque

public class Berretacoin {
    private MaxHeapUsuarios heapUsuarios;
    private MaxHeapTransacciones bloqueActual;

    // Metodo Berretacoin tiene complejidad O(P) pues usa un metodo en O(P) 
    public Berretacoin(int cantidadUsuarios) {  // O(P)
        heapUsuarios = new MaxHeapUsuarios(cantidadUsuarios); // O(P)
        bloqueActual = null; // O(1)
    }

    // Metodo agregarBloque() tiene complejidad O(T) * O(log(P)) pues itera T veces y cada vez en el peor caso entra al if
    public void agregarBloque(Transaccion[] transacciones) {
        bloqueActual = new MaxHeapTransacciones(transacciones); // O(T) // nuevo bloque reemplaza el anterior
        Transaccion[] lista = bloqueActual.copiaDeTransacciones(); // O(1)
        for (int i = 0; i < lista.length; i++) { // O(T)*(2*O(log(P))) pues itera T veces y cada vez en el peor caso entra al if 
            Transaccion t = lista[i];   // O(1)
            int comprador = t.id_comprador();   // O(1)
            int vendedor = t.id_vendedor(); // O(1)
            int monto = t.monto();  // O(1)

            if (comprador != 0) {
                int montoAnterior = heapUsuarios.obtenerMonto(comprador); // O(1)
                heapUsuarios.actualizarMonto(comprador, montoAnterior - monto); // O(log(P))
            }
            int montoAnteriorV = heapUsuarios.obtenerMonto(vendedor); // O(1)
            heapUsuarios.actualizarMonto(vendedor, montoAnteriorV + monto); // O(log(P))
        }
    }

    // Metodo txMayorValorUltimoBloque() tiene complejidad O(1) pues es un solo return de un metodo en O(1) 
    public Transaccion txMayorValorUltimoBloque(){
        return bloqueActual.transaccionMayorValor(); // O(1)
    }

    // Metodo txUltimoBloque() tiene complejidad O(T)
    public Transaccion[] txUltimoBloque(){   // O(T)  
        return bloqueActual.copiaDeTransacciones();    // O(T)
    }

    // Metodo maximoTenedor() tiene complejidad O(1)
    public int maximoTenedor(){    // O(1)
        return heapUsuarios.usuarioMayorMonto(); // O(1)

    }

    // Metodo montoMedioUltimoBloque() tiene complejidad O(1) pues es solo un return que se evalua en O(1)
    public int montoMedioUltimoBloque(){    // O(1)
        return bloqueActual.montoPromedio();    // O(1)
    }

    // Metodo hachearTx() tiene complejidad O(log(T)+log(P)) pues son asignaciones anidadas con condicionales,
    // de los cuales los mayores valores quedan en O(log(T)+O(log(P))) => O(log(T)+log(P)) 
    public void hackearTx(){    // O(log(T)+log(P))
        Transaccion max = bloqueActual.transaccionMayorValor();  // O(1)
        bloqueActual.desencolar();  // O(log(T))
        actualizarLuegoDelHackeo(max.id_comprador(), max.id_vendedor(), max.monto() ); // O(log(P))
    }

    public void actualizarLuegoDelHackeo(int comprador, int vendedor, int monto){
        if (comprador != 0){  // Es O(log(P)) por la suma de los 2 log(P) de abajo
            heapUsuarios.actualizarMonto(comprador, heapUsuarios.obtenerMonto(comprador) +monto);  // O(log(P))
            heapUsuarios.actualizarMonto(vendedor, heapUsuarios.obtenerMonto(vendedor) -monto);  // O(log(P))
            bloqueActual.modificarMontoMedio(monto,bloqueActual.tamañoSinCreacion()-1 );  // O(1)
        } else {
            heapUsuarios.actualizarMonto(vendedor, heapUsuarios.obtenerMonto(vendedor) -monto);  // O(log(P))
            bloqueActual.modificarMontoMedio(monto, bloqueActual.tamañoSinCreacion() ) ;  // O(1)
        }
    }

}