package node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for Node class.
 */
public class NodeTest 
{
    //Test the creation of many kinds of Nodes

    /**
     * Asserts that Nodes keep their values on initialization, or null if empty.
     */
    @Test
    public void nodeConstructorTest(){
        Node<Integer> nullNode = new Node<>();
        Node<Integer> intNode = new Node<>(2);
        Node<String> stringNode = new Node<>("Hello");
        Node<Boolean> boolNode = new Node<>(true);
        assertEquals(null, nullNode.value);
        assertEquals(2, intNode.value, 0);
        assertEquals("Hello", stringNode.value);
        assertEquals(true, boolNode.value);
    }

    /**
     * Assert that the insertPrev() method works with 1 element
     * Expect order of values to be 2->1->End
     */
    @Test
    public void nodeInsertPrevTest1(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.insertPrev(node2);
        assertTrue(node1.prev == node2);
        assertTrue(node1.next == null);
        assertTrue(node2.prev == null);
        assertTrue(node2.next == node1);
    }

    /**
     * Assert that the insertPrev() method works with 1 element
     * Expect order of values to be 2->1->3->End
     */
    @Test
    public void nodeInsertPrevTest2(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node3.insertPrev(node1);
        node1.insertPrev(node2);
        assertTrue(node1.prev == node2);
        assertTrue(node1.next == node3);
        assertTrue(node2.prev == null);
        assertTrue(node2.next == node1);
        assertTrue(node3.prev == node1);
        assertTrue(node3.next == null);
    }
    /**
     * Assert that if a Node attempts to insertPrev() null, fails.
     */
    @Test
    public void nodeInsertPrevTest3(){
        Node<Integer> node1 = new Node<>(1);
        node1.insertPrev(node1);
        assertTrue(node1.prev == null);
        assertTrue(node1.next == null);
    }
    /**
     * Assert that if a Node attempts to insertPrev() null, fails.
     */
    @Test
    public void nodeInsertPrevTest4(){
        Node<Integer> node1 = new Node<>(1);
        node1.insertPrev(null);
        assertTrue(node1.prev == null);
        assertTrue(node1.next == null);
    }
    /**
     * Assert that the insertNext() method works with 1 element
     * Expect order of values to be 2->1->End
     */
    @Test
    public void nodeInsertNextTest1(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node2.insertNext(node1);
        assertTrue(node1.prev == node2);
        assertTrue(node1.next == null);
        assertTrue(node2.prev == null);
        assertTrue(node2.next == node1);
    }

    /**
     * Assert that the insertPrev() method works with 1 element
     * Expect order of values to be 2->1->3->End
     */
    @Test
    public void nodeInsertNextTest2(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node2.insertNext(node1);
        node1.insertNext(node3);
        assertTrue(node1.prev == node2);
        assertTrue(node1.next == node3);
        assertTrue(node2.prev == null);
        assertTrue(node2.next == node1);
        assertTrue(node3.prev == node1);
        assertTrue(node3.next == null);
    }
    /**
     * Assert that if a Node attempts to become a insertNext() itself, fails.
     */
    @Test
    public void nodeInsertNextTest3(){
        Node<Integer> node1 = new Node<>(1);
        node1.insertNext(node1);
        assertTrue(node1.prev == null);
        assertTrue(node1.next == null);
    }
    /**
     * Assert that if a Node attempts to insertNext() null, fails.
     */
    @Test
    public void nodeInsertNextTest4(){
        Node<Integer> node1 = new Node<>(1);
        node1.insertNext(null);
        assertTrue(node1.prev == null);
        assertTrue(node1.next == null);
    }
    /**
     * Checks the printNodes() method, that prints all nodes after the called object.
     */
    @Test
    public void printNodesTest1(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node1.insertNext(node2);
        node2.insertNext(node3);
        assertEquals("1->2->3->End", node1.printNodes());
        assertEquals("2->3->End", node2.printNodes());
    }
    /**
     * Checks the printNodes() method, with a single node list.
     */
    @Test
    public void printNodesTest2(){
        Node<Integer> node1 = new Node<>(1);
        assertEquals("1->End", node1.printNodes());
    }
    /**
     * Checks the printNodes() method including a null value element.
     */
    @Test
    public void printNodesTest3(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>();
        Node<Integer> node3 = new Node<>(3);
        node1.insertNext(node2);
        node2.insertNext(node3);
        assertEquals("1->null->3->End", node1.printNodes());
        assertEquals("null->3->End", node2.printNodes());
    }
    /**
     * Tests the toString method of Nodes, including nested nodes of nodes.
     */
    @Test
    public void nodeToStringTest(){
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>();
        Node<String> node3 = new Node<>("Hello");
        Node<Node<Integer>> node4 = new Node<>(node1);
        Node<Node<Node<Integer>>> node5 = new Node<>(node4);
        assertEquals("1",node1.toString());
        assertEquals("null",node2.toString());
        assertEquals("Hello",node3.toString());
        assertEquals("<Node: 1>",node4.toString());
        assertEquals("<Node: <Node: 1>>",node5.toString());
    }
}
