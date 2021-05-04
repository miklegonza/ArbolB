package main;

/**
 *
 * @author Michael Gonzalez
 * @author Michael Betancourt
 * @author Rober Alexander Martinez 
 */
public class Nodo {
    int []datos;
    Nodo []nodo;
    static int ndatos;
    boolean hayHijos = false;
    int lleno = 0;
    Nodo padre;
    public Nodo(){
        nodo = new Nodo [Raiz.orden *2+3];
        datos = new int [Raiz.orden *2+1];
    }
}
