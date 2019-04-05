/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caimila.MariaInes
 */
public class VectorHeapTest {
    /**
     * Test of add method, of class VectorHeap.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        VectorHeap<Paciente> instance = new VectorHeap<>();
        Paciente paciente = new Paciente("Enrique","alergia","B");//Object value = null;
        //VectorHeap instance = new VectorHeap();
        instance.add(paciente);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of remove method, of class VectorHeap.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        VectorHeap<Paciente> instance = new VectorHeap<>();
        Paciente paciente = new Paciente("Enrique","alergia","B");//Object value = null;
        instance.add(paciente);
        instance.remove();
    }

        
}
