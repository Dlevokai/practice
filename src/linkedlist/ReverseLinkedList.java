package linkedlist;

public class ReverseLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node reverse(Node node){
        Node previous = null;
        Node current = node;

        while (current.next != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        current.next = previous;
        return current;
    }

    public static void main(String[] args){
        Node tail = new Node(4, null);
        Node tailMinusOne = new Node(3, tail);
        Node tailMinusTwo = new Node(2, tailMinusOne);
        Node head = new Node(1, tailMinusTwo);

        Node reversedHead = reverse(head);

        while(reversedHead.next != null){
            System.out.println(reversedHead.data);
            reversedHead = reversedHead.next;
        }
        System.out.println(reversedHead.data);
    }
}
