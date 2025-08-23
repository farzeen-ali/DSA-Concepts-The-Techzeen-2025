public class DoublyLinkedListDeletion {
    static class Node{
        int data;
        Node prev, next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

//    Deletion at Start
    public void deletionAtStart(){
        if(head == null){
            System.out.println("List is Empty! nothing to delete!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

//    Deletion at end
    public void deletionAtEnd(){
        if(head == null){
            System.out.println("List is Empty! nothing to delete!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
    }

//    Deletion at index
    public void deleteAtIndex(int index){
        if(head == null){
            System.out.println("List is Empty! nothing to delete!");
            return;
        }
        if(index == 0){
            deletionAtStart();
            return;
        }
        Node temp = head;
        int count = 0;

        while(temp != null && count < index){
            temp = temp.next;
            count++;
        }
        if(temp == null){
            System.out.println("Index out of bounds!");
            return;
        }
       if(temp.next != null){
           temp.next.prev = temp.prev;
       }
       if(temp.prev != null) {
           temp.prev.next = temp.next;
       }
    }

    public void display(){
        if(head == null){
            System.out.println("List is Empty!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedListDeletion dll = new DoublyLinkedListDeletion();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);

        System.out.println("Original List: ");
        dll.display();

        System.out.println("Delete Starting Node (10)");
        dll.deletionAtStart();
        dll.display();

        System.out.println("Delete Ending Node (50)");
        dll.deletionAtEnd();
        dll.display();

        System.out.println("Delete At Index (1)");
        dll.deleteAtIndex(1);
        dll.display();
    }
}
