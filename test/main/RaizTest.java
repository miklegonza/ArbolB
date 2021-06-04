/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexa
 */
public class RaizTest {
    
    public RaizTest() {
    }

    @Test
    public void testNodoVacio() {
        System.out.println("nodoVacio");
        Nodo nodo = null;
        Raiz instance = null;
        boolean expResult = instance.nodoVacio(nodo);;
        boolean result = instance.nodoVacio(nodo);
        assertEquals(expResult, result);
       // fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarNodo() {
        System.out.println("insertarNodo");
        int clave = 0;
        Raiz instance = null;
        instance.insertarNodo(clave);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarHijo() {
        System.out.println("insertarHijo");
        Nodo padre = null;
        int clave = 0;
        Raiz instance = null;
        instance.insertarHijo(padre, clave);
       // fail("The test case is a prototype.");
    }

    @Test
    public void testDividirArreglo() {
        System.out.println("dividirArreglo");
        int[] arreglo = null;
        int izquierda = 0;
        int derecha = 0;
        Raiz instance = null;
        instance.dividirArreglo(arreglo, izquierda, derecha);
       // fail("The test case is a prototype.");
    }

    @Test
    public void testUnirArreglo() {
        System.out.println("unirArreglo");
        int[] arreglo = null;
        int izquierda = 0;
        int mitad = 0;
        int derecha = 0;
        Raiz instance = null;
        instance.unirArreglo(arreglo, izquierda, mitad, derecha);
       // fail("The test case is a prototype.");
    }

    @Test
    public void testOrdenarClaves() {
        System.out.println("ordenarClaves");
        int[] claves = null;
        Raiz instance = null;
        instance.ordenarClaves(claves);
       // fail("The test case is a prototype.");
    }

    @Test
    public void testOrdenarNodos() {
        System.out.println("ordenarNodos");
        Nodo nodo = null;
        Raiz instance = null;
        instance.ordenarNodos(nodo);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testSetHoja() {
        System.out.println("setHoja");
        Nodo nodo = null;
        Raiz instance = null;
        instance.setHoja(nodo);
     //   fail("The test case is a prototype.");
    }

    @Test
    public void testDividirNodos() {
        System.out.println("dividirNodos");
        Nodo nodo = null;
        Raiz instance = null;
        instance.dividirNodos(nodo);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        int clave = 0;
        Raiz instance = null;
        instance.eliminar(clave);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int clave = 0;
        Raiz instance = null;
        boolean expResult = instance.buscar(clave);
        boolean result = instance.buscar(clave);
        assertEquals(expResult, result);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testImprimirArbol() {
        System.out.println("imprimirArbol");
        Nodo nodo = null;
        Raiz instance = null;
        String expResult = instance.imprimirArbol(nodo);
        String result = instance.imprimirArbol(nodo);
        assertEquals(expResult, result);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testImpresion() {
        System.out.println("impresion");
        Raiz instance = null;
        String expResult = instance.impresion();
        String result = instance.impresion();
        assertEquals(expResult, result);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testValidarNumero() {
        System.out.println("validarNumero");
        String str = "";
        Raiz instance = null;
        boolean expResult =instance.validarNumero(str);
        boolean result = instance.validarNumero(str);
        assertEquals(expResult, result);
      //  fail("The test case is a prototype.");
    }
    
}
