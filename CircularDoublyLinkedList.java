public class CircularDoublyLinkedList {
    static class Node {
        int data;
        Node prev, next;

        Node(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }
    Node head = null;
    public void insert(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;
    }
    public void traverseForward(){
        if (head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while(temp!= head);
        System.out.println();
    }
    public void traverseBackward(){
        if (head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head.prev;
        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while(temp!= head.prev);
        System.out.println();
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList cdl = new CircularDoublyLinkedList();

        cdl.insert(10);
        cdl.insert(20);
        cdl.insert(30);
        cdl.insert(40);

        System.out.print("Traverse Forward: ");
        cdl.traverseForward();

        System.out.print("Traverse Backward: ");
        cdl.traverseBackward();
    }
}
