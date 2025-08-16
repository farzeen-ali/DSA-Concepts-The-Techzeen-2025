public class DoublyLinkedListCreation {
    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    Node head;

    public void createList(){
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head = first;
        first.next = second;

        second.prev = first;
        second.next = third;

        third.prev = second;

    }

    public void traverseForward(){
        Node current = head;
        System.out.print("Forward Traversal: ");
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void traverseBackward(){
        Node current = head;

        while(current.next != null ){
            current = current.next;
        }
        System.out.print("Backward Traversal: ");
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedListCreation dll = new DoublyLinkedListCreation();

        dll.createList();

        dll.traverseForward(); // 10 -> 20 -> 30 -> null
        dll.traverseBackward(); // 30 -> 20 -> 10 -> null
    }
}
