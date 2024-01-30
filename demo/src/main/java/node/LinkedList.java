package node;

public class LinkedList<E>{
    Node<E> head;
    Node<E> tail;

    /**
     * Empty constructor of a LinkedList with null head and tail
     */
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    /**
     * Constructor of a LinkedList with head and tail equalling one Node. 
     */
    public LinkedList(Node<E> node){
        node.next = null;
        node.prev = null;
        this.head = node;
        this.tail = node;
    }

    /**
     * The add() function adds a new node with the given value to the end of a doubly linked list. Time O(1).
     * 
     * @param value The value to be added to the linked list.
     */
    public void add(E value){
        Node<E> node = new Node<E>(value);
        if(tail == null){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    
    /**
     * The add function adds a Node instance to the end of a doubly linked list. Time O(1).
     * 
     * @param node The parameter "node" is of type Node<E>.
     */
    public void add(Node<E> node){
        if(tail == null){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    
    /**
     * Performs a linear search through the linked list. Average time O(N/2), Best time O(1), Worst time O(N).
     * 
     * @param value The value to search for in the linked list.
     * @return Returns the Node if present, or null if not.
     */
    public Node<E> search(E value){
        Node<E> cur = this.head;
        while(cur != null){
            if(cur.value.equals(value)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * The function inserts a new node with a given value at a specified index in a linked list.
     * 
     * @param value The value to be inserted into the list at the specified index.
     * @param index The index parameter represents the position at which the new value should be
     * inserted in the linked list.
     * @return Returns true on success, False on fail.
     */
    public boolean insert(E value, int index){
        Node<E> cur;
        Node<E> node = new Node<E>(value);
        //Dummy checks
        if(node == null || index < 0){
            return false;
        }
        //If head does not exist but wants to insert at 0, make new node into head
        if(index == 0){
            if(this.head == null){
                this.head = node;
                this.tail = node;
                node.prev = null;
                node.next = null;
                return true;
            }
            else{
                node.next = this.head;
                node.prev = null;
                this.head.prev = node;
                this.head = node;
                return true;
            }
        }
        //If head exists, cur = head
        if(this.head != null){
            cur = head;
        }
        //Else if head does not exist && index is not 0, fail.
        else{
            return false;
        }
        //Iterate through list index times if possible
        for(int i = 0; i < index; i++){
            if(cur != this.tail){
                cur = cur.next;
            }
            else if(cur == this.tail && i == index-1){
                this.tail.next = node;
                node.prev = this.tail;
                node.next = null;
                this.tail = node;
                return true;
            }
            else{
                return false;
            }
        }
        //If made it out of loop, insert is possible.
        //Insert before cur node to push cur node to the right
        cur.insertPrev(node);
        return true;
    }

    /**
     * The function inserts a node at a specified index in a linked list.
     * 
     * @param node The ndoe to be inserted into the list at the specified index.
     * @param index The index parameter represents the position at which the new value should be
     * inserted in the linked list.
     * @return Returns true on success, False on fail.
     */
    public boolean insert(Node<E> node, int index){
        Node<E> cur;
        //Dummy checks
        if(node == null || index < 0){
            return false;
        }
        //If head does not exist but wants to insert at 0, make new node into head
        if(index == 0){
            if(this.head == null){
                this.head = node;
                this.tail = node;
                node.prev = null;
                node.next = null;
                return true;
            }
            else{
                node.next = this.head;
                node.prev = null;
                this.head.prev = node;
                this.head = node;
                return true;
            }
        }
        //If head exists, cur = head
        if(this.head != null){
            cur = head;
        }
        //Else if head does not exist && index is not 0, fail.
        else{
            return false;
        }
        //Iterate through list index times if possible
        for(int i = 0; i < index; i++){
            if(cur != this.tail){
                cur = cur.next;
            }
            else{
                return false;
            }
        }
        //If made it out of loop, insert is possible.
        //Insert before cur node to push cur node to the right
        cur.insertPrev(node);
        return true;
    }

    /**
     * Removes and returns the first node in the list.
     * 
     * @return Returns the Node that was head, or Null on fail.
     */
    public Node<E> pop(){
        Node<E> out = head;
        if(this.head != null){
            //If only one Node in List, set all to null
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }
            //If more than one Node, adjust next
            else{
                this.head = this.head.next;
                this.head.prev = null;
            }
        }
        return out;
    }

    /**
     * Removes and returns a node at a specified index in the list.
     * 
     * @param index The position of the node that needs to be popped
     * from the linked list.
     * @return The Node that was popped, or Null on fail.
     */
    public Node<E> pop(int index){
        //Dummy check
        if(index < 0){
            return null;
        }
        if(index == 0){
            return this.pop();
        }
        //Get node at index
        Node<E> node = this.get(index);
        if(node == null){
            return null;
        }
        //If node is tail, handle here
        if(node == tail){
            this.tail = node.prev;
            this.tail.next = null;
            node.prev = null;
            return node;
        }
        //If control reaches here, node is neither head nor tail, treat normal
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }

    /**
     * Returns the node at the specified index in the list.
     * 
     * @param index The position of the node to pop, starting at head = 0.
     * @return Returns the Node at index, or Null on fail.
     */
    public Node<E> get(int index){
        if(index < 0 || this.head == null){
            return null;
        }
        Node<E> cur = this.head;
        for(int i = 0; i < index; i++){
            if(cur != null){
                cur = cur.next;
            }
        }
        return cur;
    }

    /**
     * Reverses the list in place.
     */
    public void reverse(){
        if(this.head != null || this.head == this.tail){
            Node<E> cur = this.head;
            LinkedList<E> newList = new LinkedList<>();
            while(cur != null){
                newList.insert(cur.value, 0);
                cur = cur.next;
            }
            this.head = newList.head;
            this.tail = newList.tail;
        }
    }
    

    /**
     * Returns a new LinkedList with the elements in reverse order.
     * 
     * @return Returns a new LinkedList object that contains the elements of the
     * original list in reverse order.
     */
    public LinkedList<E> reversed(){
        if(this.head != null || this.head == this.tail){
            Node<E> cur = this.head;
            LinkedList<E> newList = new LinkedList<>();
            while(cur != null){
                newList.insert(cur.value, 0);
                cur = cur.next;
            }
            return newList;
        }
        return this;
    }

    /**
     * Overridden toString method prints all Node values in the list.
     * 
     * @return Returns the String containing all Node values in the list.
     */
    @Override
    public String toString(){
        if(this.head == null){
            return "End";
        }
        return this.head.printNodes();
    }
}