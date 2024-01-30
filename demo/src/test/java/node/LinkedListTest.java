package node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for LinkedList Class made by Jacob Smith.
 */
public class LinkedListTest {
    /**
     * Tests if empty constructor gives null head and tail, and if constructor with node creates a Linked
     * List with a single node as both its head and tail.
     */
    @Test
    public void linkedListConstructorTest(){
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.head == null);
        assertTrue(list.tail == null);
        Node<Integer> node = new Node<>(1);
        LinkedList<Integer> list2 = new LinkedList<>(node);
        assertTrue(list2.head == node);
        assertTrue(list2.tail == node);
        
    }

    /**
     * Tests that using add() with a value of type E assigns a new node to the head of an empty linked list
     * and its value is accessible.
     */
    @Test
    public void linkedListAddTest1(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertEquals(list.head.value,1, 0);
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("1");
        assertEquals(list2.head.value,"1");
        LinkedList<Boolean> list3 = new LinkedList<>();
        list3.add(true);
        assertEquals(list3.head.value,true);
    }
    
    /**
     * Tests that using add() with a value assigns a new node to a linked list, and appends the
     * new node to the tail, and that each value is accessible.
     */
    @Test
    public void linkedListAddTest2(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.head.value,1, 0);
        assertEquals(list.head.next.value,2, 0);
        assertEquals(list.tail.value,3, 0);
    }
    /**
     * Tests that using add() with a Node assigns the parameter Node to the head of an empty linked list
     * and its value is accessible.
     */
    @Test
    public void linkedListAddTest3(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(1);
        list.add(node);
        assertEquals(list.head.value,1, 0);
        LinkedList<String> list2 = new LinkedList<>();
        Node<String> node2 = new Node<>("1");
        list2.add(node2);
        assertEquals(list2.head.value,"1");
        LinkedList<Boolean> list3 = new LinkedList<>();
        Node<Boolean> node3 = new Node<>(true);
        list3.add(node3);
        assertEquals(list3.head.value,true);
    }

    /**
     * Tests that using add() with a Node assigns the Node parameter to a linked list, and appends the
     * new node to the tail, and that each value is accessible.
     */
    @Test
    public void linkedListAddTest4(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        list.add(node);
        list.add(node2);
        list.add(node3);
        assertEquals(list.head.value,1, 0);
        assertEquals(list.head.next.value,2, 0);
        assertEquals(list.tail.value,3, 0);
    }

    /**
     * Tests that a search on an empty Linked List returns null.
     */
    @Test
    public void linkedListSearchTest1(){
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.search(1) == null);
    }

    /**
     * Tests that a search on a Linked List that does not contain the value returns null.
     */
    @Test
    public void linkedListSearchTest2(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertTrue(list.search(2) == null);
    }

    /**
     * Tests that a search on a Linked List that contains only the value returns the proper value.
     */
    @Test
    public void linkedListSearchTest3(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        assertTrue(list.search(1).value == 1);
    }
    
    /**
     * Tests that a search on a Linked List that contains only the value returns the proper Node Object.
     */
    @Test
    public void linkedListSearchTest4(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(1);
        list.add(node);
        assertTrue(list.search(1) == node);
        //Tests that LinkedList initiated with node inside can find node
        Node<String> node2 = new Node<>("Hello");
        LinkedList<String> list2 = new LinkedList<>(node2);
        assertTrue(list2.search("Hello") == node2);
    }
    
    /**
     * Tests that a search on a Linked List that contains 10 nodes returns the proper value.
     */
    @Test
    public void linkedListSearchTest5(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertTrue(list.search(5).value == 5);
    }
    
    /**
     * Tests that a search on a Linked List that contains 5 nodes returns the proper Node Object.
     */
    @Test
    public void linkedListSearchTest6(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        list.add(node);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        assertTrue(list.search(1) == node);
        assertTrue(list.search(3) == node3);
        assertTrue(list.search(5) == node5);
    }

    /**
     * Tests that an item inserted at index 0 to an empty LinkedList is properly inserted.
     */
    @Test
    public void linkedListInsertTest1(){
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1, 0);
        assertTrue(list.head.value == 1);
    }

    /**
     * Tests that a null item inserted at index 0 to an empty LinkedList fails,
     * but that a properly made Node with value null is inserted successfully.
     */
    @Test
    public void linkedListInsertTest2(){
        LinkedList<Object> list = new LinkedList<>();
        assertTrue(list.insert(null, 0) == false);
        Node<Object> node = new Node<>();
        assertTrue(list.insert(node, 0));
        assertTrue(list.head.value == null);
    }

    /**
     * Tests that a null item inserted at index 0 to an empty LinkedList fails,
     * but that a properly made Node with value null is inserted successfully.
     */
    @Test
    public void linkedListInsertTest3(){
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(12);
        for (int i = 0; i < 5; i++) {
            list.insert(i, i);
        }
        list.insert(node, 3);
        assertTrue(list.search(12) == node);
    }
}
