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
public class InterfazArbolTest {
    
    public InterfazArbolTest() {
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        InterfazArbol.main(args);
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testBuscarDato() {
        System.out.println("buscarDato");
        InterfazArbol instance = new InterfazArbol();
        instance.buscarDato();
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testCrearArbol() {
        System.out.println("crearArbol");
        InterfazArbol instance = new InterfazArbol();
        instance.crearArbol();
       // fail("The test case is a prototype.");
    }

    @Test
    public void testInsertarDatos() {
        System.out.println("insertarDatos");
        InterfazArbol instance = new InterfazArbol();
        instance.insertarDatos();
      //  fail("The test case is a prototype.");
    }

    @Test
    public void testEliminarDatos() {
        System.out.println("eliminarDatos");
        InterfazArbol instance = new InterfazArbol();
        instance.eliminarDatos();
       // fail("The test case is a prototype.");
    }

    @Test
    public void testVerArbol() {
        System.out.println("verArbol");
        InterfazArbol instance = new InterfazArbol();
        instance.verArbol();
       // fail("The test case is a prototype.");
    }
    
}
