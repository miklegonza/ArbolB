/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JTextArea;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexa
 */
public class ImpresionArbolTest {

    public ImpresionArbolTest() {
    }

    @Test
    public void testGetTableroImpresion() {
        System.out.println("getTableroImpresion");
        ImpresionArbol instance = new ImpresionArbol();
        JTextArea expResult = instance.getTableroImpresion();
        JTextArea result = instance.getTableroImpresion();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
}
