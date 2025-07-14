package aed;
import aed.Clases.Usuario;
import aed.Clases.Handle;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTests {

@Test
public void creacionUnSoloUsuario() {
    Handle handle = new Handle(0);
    Usuario u = new Usuario(5, 100, handle);

    assertEquals(5, u.id());
    assertEquals(100, u.monto());
}

// tests con metodo compareTo
@Test
public void compararUsuariosModificandoMontos(){
    Handle handle = new Handle(0);
    Handle handle_2 = new Handle(1);
    Usuario user = new Usuario(1, 0,handle);
    Usuario user_2 = new Usuario(2, 10, handle_2);

    assertTrue(user.compareTo(user_2)<0);
    user.modificarMonto(20);
    assertTrue(user.compareTo(user_2)>0);
}

@Test
public void compararUsuariosConMismoMonto(){
    Handle handle = new Handle(0);
    Handle handle_2 = new Handle(1);
    Usuario user = new Usuario(1, 10,handle);
    Usuario user_2 = new Usuario(2, 10, handle_2);

    assertTrue(user.compareTo(user_2)>0);
    user.modificarMonto(50);
    user_2.modificarMonto(50);
    assertTrue(user.compareTo(user_2)>0);
}

@Test
public void compararUsuariosIguales() {
    Handle h = new Handle(0);
    Usuario u1 = new Usuario(1, 100, h);
    Usuario u2 = new Usuario(1, 100, h);

    assertEquals(0, u1.compareTo(u2));
}

@Test
public void actualizarPosicionUsuario() {
    Handle h = new Handle(0);
    Usuario u = new Usuario(1, 100, h);

    u.actualizarPosicion(5);
    assertEquals(5, h.posicion()); 
}

}
