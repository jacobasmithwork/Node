package node;

public class Node<E> {
    E value;
    Node<E> next;
    Node<E> prev;

    /**
     * Empty constructor for a new Node, returns a node with all null values.
     */
    public Node(){
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Constructor for a new Node, returns a node with value E.
     * 
     * @param value The value assigned to the new Node.
     */
    public Node(E value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Inserts a given node after the current node.
     * 
     * @param node The node that needs to be inserted after the current node.
     */
    public void insertNext(Node<E> node){
        if(node == this || node == null){
            return;
        }
        if(this.next == null){
            this.next = node;
            node.prev = this;
        }
        else{
            node.next = this.next;
            node.next.prev = this;
            this.next = node;
            node.prev = this;
        }
    }

    /**
     * Inserts a given node before the current node.
     * 
     * @param node The node that needs to be inserted before the current node.
     */
    public void insertPrev(Node<E> node){
        if(node == this || node == null){
            return;
        }
        if(this.prev == null){
            this.prev = node;
            node.next = this;
        }
        else{
            node.next = this;
            this.prev.next = node;
            node.prev = this.prev;
            this.prev = node;
        }
    }

    /**
     * The function prints the values of each node in a linked list, followed by "End".
     * 
     * @return Returns  a string representation of the linked list, where each node's
     * value is concatenated with "->" and the word "End" is appended at the end.
     */
    public String printNodes(){
        String out = "";
        Node<E> cur = this;
        while(cur != null){
            out+=(cur.value + "->");
            cur = cur.next;
        }
        out+=("End");
        return out;
    }

    /**
     * The toString() function returns a string representation of the value, or "null" if null.
     * If value is of type Node, it returns <Node: (node's value)> to prevent recursivity.
     * 
     * @return The value of the object as a string.
     */
    @Override
    public String toString(){
        if(this.value == null){
            return "null";
        }
        if(this.value instanceof Node){
            return "<Node: " + this.value.toString() + ">";
        }
        return this.value.toString();
    }
}
