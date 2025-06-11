package aed.Clases;

public class Usuario implements Comparable<Usuario> {
    private int id;
    private int monto;
    private Handle handle;

    public Usuario(int id, int monto, Handle handle) {
        this.id = id;
        this.monto = monto;
        this.handle = handle;
    }

    @Override
    public int compareTo(Usuario otro) {
        int res = 0 ;

        if (this.monto - otro.monto >0){
            res = 1;
        } 
        if (this.monto - otro.monto <0){
            res = -1 ;
        } 
        if (this.monto - otro.monto == 0){
            if (this.id < otro.id){
                res = 1;
            } else {
                res = -1;
            }
        }
        return res ;
    }

    public int monto(){
        return monto;
    }

    public int id(){
        return id;
    }

    public Handle handle(){
        return handle;
    }

    public void modificarMonto(int nuevoMonto) {
        this.monto = nuevoMonto;
    }

}