package main;

import java.util.ArrayList;

/**
 *
 * @author Michael Gonzalez
 * @author Michael Betancourt
 * @author Rober Alexander Martinez 
 */
public class Raiz {
    
    public static int orden;
    public Nodo primero;
    public boolean raiz;
    public int nivel;
    public int imprimir;
    public String arbol;
    public ArrayList<Integer> listaClaves;
    
    public Raiz(int orden) {
        this.nivel = 1;
        this.imprimir = 1;
        this.arbol = "";
        Raiz.orden = orden;
        this.primero = new Nodo();
        this.raiz = true;
        this.listaClaves = new ArrayList<>();
    }
    
    public boolean nodoVacio(Nodo nodo) {
        return nodo == null;
    }
    
    public void insertarNodo(int clave) {
        if (!primero.hoja) {
            int j = 0;
            for (int i = 0; i < primero.claves.length; i++) {
                if (primero.claves[i] == 0) {
                    primero.claves[i] = clave;
                    listaClaves.add(clave);
                    j = i;
                    ordenarClaves(primero.claves);
                    break;
                }
            }
            if (j == 2 * orden)
                split(primero);
        } else {
            setHoja(primero);
            insertarHijo(primero, clave);
        }
    }
    
    public void insertarHijo(Nodo padre, int clave) {
        boolean logrado = false;
        if (!nodoVacio(padre) && !padre.hoja) {
            for (int i = 0; i <= 2 * orden; i++) {
                if (padre.claves[i] == 0) {
                    padre.claves[i] = clave;
                    ordenarClaves(padre.claves);
                    listaClaves.add(clave);
                    if (i == 2 * orden)
                        split(padre);
                    break;
                }
            }
            logrado = true;
        }
        for (int i = 0; i < 2 * orden + 1 && !nodoVacio(padre) && !logrado; i++) {
            if (clave < padre.claves[i] || padre.claves[i] == 0) {
                logrado = true;
                insertarHijo(padre.hijos[i], clave);
                i = 2 * orden;
            }
        }
    }
    
    public void ordenarClaves(int[] claves) {
        int counter = 0;
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != 0)
                counter++;
            else
                break;
        }
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter - 1; j++) {
                if (claves[j] > claves[j + 1]) {
                    int temp = claves[j];
                    claves[j] = claves[j + 1];
                    claves[j + 1] = temp;
                }
            }
        }
    }
    
    public void setHoja(Nodo nodo) {
        if (nodo == primero) {
            if (primero.hijos[0] != null) {
                primero.hoja = true;
            }
        }
        for (Nodo hijo : nodo.hijos) {
            if (hijo != null) {
                nodo.hoja = true;
                setHoja(hijo);
            }
        }
    }
    
    
    
}
