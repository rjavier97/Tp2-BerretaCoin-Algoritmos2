package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class maxHandleTests {

    @Test
    void nuevo_conjunto_vacio() {
        maxHandle<Integer> conjunto = new maxHandle<Integer>();

        assertFalse(conjunto.pertenece(42));
        assertEquals(0, conjunto.cardinal());
    }

    @Test
    void transformar() {
        maxHandle<Integer> conjunto = new maxHandle<Integer>();
        Integer[] conj = {1,2,3,4,5,6};
        conjunto.constructormaxHandle(conj);
        conjunto.modificarUno(3,7);
        conjunto.modificarUno(2,5);
        conjunto.modificarUno(3,-4);

        assertTrue(conjunto.pertenece(7));
        assertTrue(conjunto.pertenece(8));
        assertEquals(8, conjunto.maximo());

    }
}
