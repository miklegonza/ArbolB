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
    public int nivel = 1;
    public int imprimir = 1;
    public static String arbol = "";
    public static ArrayList<Integer> listaClaves;

    public Raiz(int orden) {
        Raiz.orden = orden;
        primero = new Nodo();
        raiz = true;
        listaClaves = new ArrayList<>();
    }

    /**
     * Verifica si el nodo está vacío.
     *
     * @param nodo El nodo a validar
     * @return verdadero si el nodo es igual a null
     */
    public boolean nodoVacio(Nodo nodo) {
        return nodo == null;
    }

    /**
     * Crea un nodo nuevo con el valor ingresado o inserta el valor al primer
     * nodo. recorre todas las claves del nodo. Cuando encuentra un espacio
     * vacio, lo inserta ahí.
     *
     * @param clave El valor a insertar en el nodo
     */
    public void insertarNodo(int clave) {  // O(N)
        if (!primero.hoja) {
            int j = 0;
            for (int i = 0; i < primero.claves.length; i++) {
                if (primero.claves[i] == 0) {
                    primero.claves[i] = clave;
                    listaClaves.add(clave);
                    j = i;
                    ordenarClaves(primero.claves, 6);
                    break;
                }
            }
            if (j == 2 * orden) {
                dividir(primero);
            }
        } else {
            setHoja(primero);
            insertarHijo(primero, clave);
        }
    }

    /**
     * Crea un nuevo nodo hijo del nodo seleccionado. El nodo padre deja de ser
     * una hoja y en la posición correspondiente se agrega el nuevo nodo con la
     * clave especificada.
     *
     * @param padre El nodo al que pertenecerá el hijo
     * @param clave El valor que se le inserta al nuevo nodo
     */
    public void insertarHijo(Nodo padre, int clave) {
        boolean logrado = false;
        if (!nodoVacio(padre) && !padre.hoja) {
            for (int i = 0; i <= 2 * orden; i++) {
                if (padre.claves[i] == 0) {
                    padre.claves[i] = clave;
                    ordenarClaves(padre.claves, 6);
                    listaClaves.add(clave);
                    if (i == 2 * orden) {
                        dividir(padre);
                    }
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

    /**
     * Ordena las claves cuando se inserta una nueva al nodo, puesto que siempre
     * deben estar ordenadas.
     *
     * @param claves El arreglo a ordenar
     */
    public void ordenarClaves(int[] claves, int counter) {
        counter = 0;
        for (int i = 0; i < claves.length; i++) {
            if (claves[i] != 0) {
                counter++;
            } else {
                break;
            }
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

    /**
     * Los nodos, al igual que las claves, deben estar ordenados y ubicados de
     * modo que las claves insertadas no excedan el tamaño permitido y siempre
     * se cumpla con una jerarquía balanceada. Aquí, se determina la unicación
     * de los hijos en el nodo padre.
     *
     * @param nodo El nodo que se va a evaluar y ordenar
     */
    public void ordenarNodos(Nodo nodo) {
        int i = 0, j;
        Nodo temp;
        while (i < 2 * orden + 3 && !nodoVacio(nodo.hijos[i])) {
            j = 0;
            while (j < 2 * orden + 2 && !nodoVacio(nodo.hijos[j]) && !nodoVacio(nodo.hijos[j + 1])) {
                if (nodo.hijos[j].claves[0] > nodo.hijos[j + 1].claves[0]) {
                    temp = nodo.hijos[j];
                    nodo.hijos[j] = nodo.hijos[j + 1];
                    nodo.hijos[j + 1] = temp;
                }
                j++;
            }
            i++;
        }
    }

    /**
     * Asigna la propiedad de hoja al nodo. Si el nodo no tiene hijos, pasa a
     * ser una hoja. Si el nodo tiene hijos, se aplica recursividad para que
     * recorra progresivamente los hijos hasta que se encuentre con las hojas.
     *
     * @param nodo El nodo a evaluar
     */
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

    /**
     * Es uno de los métodos más importantes para la organización e inserción de
     * los elementos en el árbol, ya que el tamaño de las claves o los valores
     * de cada nodo, es decir, el orden, no se debe exceder. Cuando eso pasa, se
     * tiene que dividir el nodo se convierte en el padre de un sub-árbol en el
     * que los elementos mayores que la mitad pasan a ser el nodo hijo del lado
     * derecho y los menores terminan siendo un nodo hijo al lado izquierdo,
     * quedando como raíz el valor de la mitad.
     *
     * Para esto se verifica si el nodo tiene hijos antes de dividirlo. Si los
     * tiene, los separa en nodo izquierdo y derecho. Luego, guarda los
     * respectivos valores a cada lado.
     *
     * @param nodo
     */
    public void dividir(Nodo nodo) {
        Nodo izquierdo = new Nodo();
        Nodo derecho = new Nodo();

        //Primera división
        if (!nodoVacio(nodo.hijos[0])) {
            for (int i = 0; i < orden + 1; i++) {
                izquierdo.hijos[i] = nodo.hijos[i];
                izquierdo.hijos[i].padre = izquierdo;
                nodo.hijos[i] = null;

                derecho.hijos[i] = nodo.hijos[orden + 1 + i];
                derecho.hijos[i].padre = derecho;
                nodo.hijos[orden + 1 + i] = null;
            }
        }

        //Guardar los valores en izquierdo y derecho
        for (int i = 0; i < orden; i++) {
            izquierdo.claves[i] = nodo.claves[i];
            nodo.claves[i] = 0;
            derecho.claves[i] = nodo.claves[orden + 1 + i];
            nodo.claves[orden + 1 + i] = 0;
        }
        nodo.claves[0] = nodo.claves[orden];
        nodo.claves[orden] = 0;

        nodo.hijos[0] = izquierdo;
        nodo.hijos[0].padre = nodo;
        nodo.hijos[1] = derecho;
        nodo.hijos[1].padre = nodo;
        setHoja(primero);
        ordenarNodos(nodo);

        //Ahora se sube el valor del padre
        if (!nodoVacio(nodo.padre)) {
            boolean logrado = false;
            for (int i = 0; i < nodo.padre.claves.length && !logrado; i++) {
                if (nodo.padre.claves[i] == 0) {
                    nodo.padre.claves[i] = nodo.claves[0];
                    logrado = true;
                    nodo.claves[0] = 0;
                    ordenarClaves(nodo.padre.claves, 5);
                }
            }
            int posicion = 0;
            for (int i = 0; i < 2 * orden + 3; i++) {
                if (!nodoVacio(nodo.padre.hijos[i])) {
                    posicion++;
                } else {
                    break;
                }
            }
            nodo.padre.hijos[posicion] = nodo.hijos[0];
            nodo.padre.hijos[posicion].padre = nodo.padre;
            nodo.padre.hijos[posicion + 1] = nodo.hijos[1];
            nodo.padre.hijos[posicion + 1].padre = nodo.padre;

            int actual = 0;
            for (int i = 0; i < 2 * orden + 3 && !nodoVacio(nodo.padre.hijos[i]); i++) {
                if (nodo.padre.hijos[i].claves[0] == nodo.claves[0]) {
                    actual = i;
                    break;
                }
            }

            Nodo temp = nodo.padre;
            nodo = null;
            int j = actual;
            while (j < 2 * orden + 2 && !nodoVacio(temp.hijos[j]) && !nodoVacio(temp.hijos[j + 1])) {
                temp.hijos[j] = temp.hijos[j + 1];
                j++;
            }
            temp.hijos[j] = null;
            ordenarClaves(temp.claves, 5);
            ordenarNodos(temp);
            if (temp.claves[2 * orden] != 0) {
                dividir(temp);
            }
        }
    }

    /**
     * Elimina el nodo con la clave especificada. Recorre la estructura hasta
     * encontrar el nodo donde está alojado el valor.
     *
     * @param clave La clave del nodo a eliminar
     */
    public void eliminar(int clave) {
        boolean encontrado = false;
        int pos = 0;
        for (int i = 0; i < listaClaves.size() && !encontrado; i++) {
            if (listaClaves.get(i) == clave) {
                encontrado = true;
                pos = i;
            }
        }

        if (encontrado) {
            listaClaves.remove(pos);
        } else {
            System.out.println("No encontrado");
        }

        ArrayList<Integer> aux = listaClaves;
        listaClaves = new ArrayList<>();
        primero = new Nodo();
        primero.hoja = false;
        for (int i = 0; i < aux.size(); i++) {
            int claveNueva = aux.get(i);
            insertarNodo(claveNueva);
        }
    }

    /**
     * Busca el nodo con la clave especificada. Recorre la estructura hasta
     * encontrar el nodo donde está alojada la clave.
     *
     * @param clave La clave del nodo a buscar
     * @return Verdadero si encuentra el dato
     */
    public boolean buscar(int clave) {
        for (int i = 0; i < listaClaves.size(); i++) {
            if (listaClaves.get(i) == clave) {
                System.out.println("Elemento encontrado");
                return true;
            }
        }
        System.out.println("No encontrado");
        return false;
    }

    /**
     * Recorre los nodos y los sub-nodos de uno en uno para concatenarlos en un
     * String y retornarlos para su impresión. Una vez más se aplica el concepto
     * de recursividad cuando, una vez ha recorrido y almacenado todo el nodo,
     * baja hasta los hijos para recorrerlos también.
     *
     * @param nodo El nodo inicial a recorrer. Usualmente es la raiz
     * @return Una cadena de texto con todo el arbol
     */
    public String imprimirArbol(Nodo nodo) {
        arbol += "\n";
        for (int i = 0; i < 2 * orden + 1; i++) {
            if (nodo.hijos[i] != null) {
                if (i == 0) {
                    nivel++;
                    imprimir = 1;
                } else {
                    imprimir++;
                }
                imprimirArbol(nodo.hijos[i]);
            }
            arbol += "[ ";

            for (int j = 0; nodo.hijos[i] != null && j < nodo.hijos[i].claves.length; j++) {
                if (nodo.hijos[i].claves[j] != 0) {
                    arbol += nodo.hijos[i].claves[j] + ", ";
                }
            }

            arbol += " ]";
        }
        if (arbol.length() > (2 * orden + 3) * 4) {
            System.out.println(arbol);
            return arbol;
        }
        return arbol;
    }

    /**
     * Su función es la de llamar al método imprimirArbol y reiniar los
     * contadores de nivel e impresión. Ya que el método imprimirArbol maneja
     * recursividad, es más eficiente usar un método externo para su llamada.
     *
     * @return La impresión del arbol
     */
    public String impresion() {
        String a = imprimirArbol(primero);
        nivel = 1;
        imprimir = 1;
        return arbol;
    }

    /**
     * Es una función de manejo de errores, la cual valida que el elemento
     * ingresado sea un valor numérico.
     *
     * @param str
     * @return Verdadero si es un número. Falso de no ser así.
     */
    public boolean numero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
