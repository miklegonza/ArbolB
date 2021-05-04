package main;

/**
 *
 * @author Michael Gonzalez
 * @author Michael Betancourt
 * @author Rober Alexander Martinez 
 */
public class Nodo {
    public int[] claves;
    public Nodo[] hijos;
    public int numClaves;
    public boolean hoja = false;
    public int lleno = 0;
    public Nodo padre;
    
    public Nodo(){
        hijos = new Nodo [Raiz.orden *2+3];
        claves = new int [Raiz.orden *2+1];
    }
}
