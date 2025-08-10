public class SinglyLinkedList {
//    Single Linked List
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
// Nodes Linking
        first.next = second;
        second.next = third;
        third.next = fourth;
// Head Pointer
        Node head = first;

//      Traversing
        System.out.print("Linked List Elements: ");
        Node current = head;

        while (current != null){
            System.out.print(current.data + " -> "); // 10->20->30->40->null
            current = current.next;
        }
        System.out.println("null");
    }
}
