package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransaccionTests {
// tests con metodo compareTo
@Test
public void creacionUnaSolaTransaccion() {
    Transaccion tx = new Transaccion(1,1,2,100);
    assertEquals(new Transaccion(1, 1, 2, 100), tx);
}

@Test
public void compararTransaccionesDeMayorYMenorMonto() {
    Transaccion tx1 = new Transaccion(1, 1, 3, 100);
    Transaccion tx2 = new Transaccion(2, 2, 4, 50);
    Transaccion tx3 = new Transaccion(2, 5, 6, 150);
    assertTrue(tx1.compareTo(tx2) > 0); // mayor a 0 porque tx1 tiene mas monto
    assertTrue(tx1.compareTo(tx3) < 0); // menor a 0 porque tx3 tiene mas monto
}

@Test
public void compararTransaccionesIgualMonto() {
    Transaccion tx1 = new Transaccion(1, 1, 2, 100);
    Transaccion tx2 = new Transaccion(2, 3, 4, 100);
    assertTrue(tx1.compareTo(tx2) < 0); // igual monto, menor id gana
}

@Test
public void compararTransaccionesIgualMontoEId() {
    Transaccion tx1 = new Transaccion(1, 10, 20, 100);
    Transaccion tx2 = new Transaccion(1, 10, 20, 100);
    assertEquals(0, tx1.compareTo(tx2));
}
// tests con metodo equals
@Test
public void transaccionesIguales() {
    Transaccion tx1 = new Transaccion(1, 1, 2, 100);
    Transaccion tx2 = new Transaccion(1, 1, 2, 100);
    assertTrue(tx1.equals(tx2));
}

@Test
public void transaccionesDiferentes() {
    Transaccion tx1 = new Transaccion(1, 1, 2, 10);
    Transaccion tx2 = new Transaccion(2, 1, 2, 15);
    assertFalse(tx1.equals(tx2));
}

@Test
public void transaccionesNull() {
    Transaccion tx = new Transaccion(1, 1, 2, 10);
    assertFalse(tx.equals(null));
}

@Test
public void transaccionesClaseDistinta() {
    Transaccion tx = new Transaccion(1, 10, 20, 100);
    assertFalse(tx.equals("transacción"));
}
}