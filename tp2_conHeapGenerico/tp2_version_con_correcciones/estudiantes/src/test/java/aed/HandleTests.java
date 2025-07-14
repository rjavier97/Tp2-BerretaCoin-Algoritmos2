package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aed.Clases.Handle;

public class HandleTests {

@Test
public void modificarPosicion() {
    Handle h = new Handle(0);
    assertEquals(0, h.posicion());
    int n = 0;
    while (n < 50) {
        h.modificarPosicion(n+2);
        assertEquals(n+2, h.posicion());
        n = n + 1;
    }
}
}
