package customDataStructure;

public class StackCustom<T> {

    private class Node {
        T data;
        Node below;
    }

    private Node head;
    private int count;

    public StackCustom() {
        Node dummyHead = new Node();
        dummyHead.data = null;
        dummyHead.below = null;

        this.head = dummyHead;
        this.count = 0;
    }

    public boolean empty() {

        if(this.count < 1 || this.head.below == null) {
            return true;
        } else {
            return false;
        }
    }

    public T push(T data) {
        Node node = new Node();
        node.data = data;
        node.below = this.head.below;
        this.head.below = node;
        this.count++;
        return this.head.below.data;
    }

    public T pop() {
        if(this.count < 1 || this.head.below == null) {
            return null;
        } else {
            T data = this.head.below.data;
            this.head.below = this.head.below.below;
            this.count--;
            return data;
        }
    }

    public T peek() {

        return this.head.below.data;
    }


}
