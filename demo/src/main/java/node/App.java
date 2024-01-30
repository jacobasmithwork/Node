package node;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(2);
        for (int i = 0; i < 5; i++) {
            list.insert(i, i+1);
        }

        // node.insertNext(null);
        System.out.println(list);
        
    }
}
