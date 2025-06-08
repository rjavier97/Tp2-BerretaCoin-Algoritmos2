package aed.Clases;

public class Usuario {

    private int id_usuario;
    private int monto_usuario;

    public Usuario (int id, int monto){
        this.id_usuario = id;
        this.monto_usuario = monto ;
    }
    
    public int obtenerId (){
        return id_usuario;
    }

    public int obtenerMonto(){
        return monto_usuario;
    }

    public void setearMonto(int monto){
        this.monto_usuario = monto;
    }

}
