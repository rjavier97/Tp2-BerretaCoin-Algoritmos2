// package aed;

// import static org.junit.jupiter.api.Assertions.*;

// import java.util.ArrayList;
// import java.util.Arrays;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import aed.Clases.MaxHeapUsuarios;

// public class MaxHeapUsuariosTests {
    
// @Test
// public void creacionNuevosUsuarios() {
//     MaxHeapUsuarios heap = new MaxHeapUsuarios(3);
//     assertEquals(0, heap.obtenerMonto(1));
//     assertEquals(0, heap.obtenerMonto(2));
//     assertEquals(0, heap.obtenerMonto(3));
// }

// @Test
// public void actualizarMonto() {
//     MaxHeapUsuarios heap = new MaxHeapUsuarios(3);
//     assertEquals(0, heap.obtenerMonto(1));
//     assertEquals(0, heap.obtenerMonto(2));
//     assertEquals(0, heap.obtenerMonto(3));

//     heap.actualizarMonto(2, 10);

//     assertEquals(0, heap.obtenerMonto(1));
//     assertEquals(10, heap.obtenerMonto(2));
//     assertEquals(0, heap.obtenerMonto(3));
// }

// @Test
// public void usuarioMayorMonto() {
//     MaxHeapUsuarios heap = new MaxHeapUsuarios(3);

//     assertEquals(1, heap.usuarioMayorMonto());
//     heap.actualizarMonto(3, 20);
//     heap.actualizarMonto(1, 15);
//     assertEquals(3, heap.usuarioMayorMonto());
//     heap.actualizarMonto(3, 10);
//     assertEquals(1, heap.usuarioMayorMonto());
//     // usuarios con mayor monto iguales
//     heap.actualizarMonto(2, 15);
//     int mayor = heap.usuarioMayorMonto();
//     assertTrue(mayor == 1 || mayor == 2);
// }

// }
