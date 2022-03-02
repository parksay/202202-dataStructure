package queue;

public class DequeDoublyLinkedList implements DequeInterface {

    //deque =  double-ended queue

    private class Node {
        int data;
        Node before;
        Node next;
    }

    Node head;
    Node tail;

    public void dequeInit() {

        Node head = null;
        Node tail = null;
    }

    public boolean dequeIsEmpty() {

        if(this.head == null || this.tail == null) {
            return true;
        }
        return false;
    }

    public int dequeInputHead(int data) {
        Node node = new Node();
        node.data = data;
        node.before = null;
        node.next = head;
        if(this.dequeIsEmpty()) {
            this.tail = node;
        } else {
            this.head.before = node;
        }
        this.head = node;
        return this.head.data;
    }

    public int dequeInputTail(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.before = this.tail;
        if(this.dequeIsEmpty()) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;

        return this.tail.data;
    }

    public int dequeOutputHead() {

        if(this.dequeIsEmpty()) {
            return 0;
        } else {
            int data = this.head.data;
            this.head = this.head.next;
            if(this.head == null) {
                this.tail = null;
            } else {
                this.head.before.next = null;
                this.head.before = null;
            }
            return data;
        }
    }

    public int dequeOutputTail() {
        if(this.dequeIsEmpty()) {
            return 0;
        } else {
            int data = this.tail.data;
            this.tail = this.tail.before;
            if(this.tail == null) {
                this.head = null;
            } else {
                this.tail.next.before = null;
                this.tail.next = null;
            }
            return data;
        }

    }

    public int dequePeekHead() {
        if(this.dequeIsEmpty()) {
            return 0;
        } else {
            return this.head.data;
        }
    }

    public int dequePeekTail() {
        if(this.dequeIsEmpty()) {
            return 0;
        } else {
            return this.tail.data;
        }
    }


}
