package aed.Clases;

public class Handle {
    private int posicion;

    // Metodo handle() tiene complejidad O(1) pues solo hace una asigncacion
    public Handle(int posicion) {    // O(1)
        this.posicion = posicion;    // O(1)
    }
    // Metodo posicion() tiene complejidad O(1) pues solo tiene el return que devuelve el valor del atributo
    public int posicion(){    // O(1)
        return posicion;    // O(1)
    }

    // Metodo modificarPosicion() tiene complejidad O(1) pues solo hace una asignacion
    public void modificarPosicion(int _posicion){    // O(1)
        posicion = _posicion;    // O(1)
    }
}
