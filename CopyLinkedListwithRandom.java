import java.util.ArrayList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyLinkedListwithRandom {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        else{
            ArrayList<Node> origin = new ArrayList<>();
            ArrayList<Node> index = new ArrayList<>();
            Node p = head;
            while(p != null){
                origin.add(p);
                p=p.next;
            }
            p= head;
            Node newhead = new Node(p.val);
            index.add(newhead);
            Node q = newhead;
            while(p.next != null){
                p = p.next;
                Node tmp = new Node(p.val);
                q.next = tmp;
                q = tmp;
                index.add(q);
            }
            p = head;
            q = newhead;
            while(p != null){
                if(p.random == null){
                    q.random = null;
                }
                else{
                    q.random = index.get(origin.indexOf(p.random));
                }
                p=p.next;
                q = q.next;
            }
            return index.get(0);
        }
    }
}
