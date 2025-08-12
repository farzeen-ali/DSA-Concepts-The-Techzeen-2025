public class SinglyLinkedListInsertion {
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insertAtStart(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;

    }

    public void insertAtIndex(int index, int value){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            insertAtStart(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        int count = 0;

        while(current != null && count < index - 1){
            current = current.next;
            count++;
        }
        if (current == null){
            System.out.println("Index out of bounds");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;

    }

    public void traverse(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
    SinglyLinkedListInsertion list = new SinglyLinkedListInsertion();

    list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.traverse(); // 10->20->30->null

        list.insertAtStart(5);
        list.traverse(); // 5->10->20->30->null

        list.insertAtIndex(2,15);
        list.traverse(); // 5->10->15->20->30->null

        list.insertAtIndex(8, 60);
        list.traverse();
    }
}
