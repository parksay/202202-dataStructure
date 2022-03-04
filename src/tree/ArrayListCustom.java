package tree;

public class ArrayListCustom<T> {

    private class Node {
        T data;
        Node before;
        Node next;
        int index;
    }

    private int count;
    private Node head;
    private Node tail;

    public ArrayListCustom() {
        Node dummyHead = new Node();
        dummyHead.data = null;
        dummyHead.index = -1;
        Node dummyTail = new Node();
        dummyTail.data = null;
        dummyTail.index = -1;
        this.head = dummyHead;
        this.tail = dummyTail;

        this.head.before = null;
        this.head.next = this.tail;
        this.tail.before = this.head;
        this.tail.next = null;
        this.count = 0;
    }

    public boolean add(T data) {
        Node node = new Node();
        node.data = data;
        node.index = this.count;
        this.count++;
        node.before = this.tail.before;
        this.tail.before.next = node;
        node.next = this.tail;
        this.tail.before = node;
        return true;
    }

    public T get(int idx) {

//        //before
//        T data = null;
//        Node node = this.listGetNodeByIndex(idx);
//        if(node != null) {
//            data = node.data;
//        }
//        return data;

        //after
        Node node = this.listGetNodeByIndex(idx);
        return node == null ? null : node.data;
    }

    public boolean remove(int idx) {
        Node target = listGetNodeByIndex(idx);
        if(target == null) {
            return false;
        }
        target.before.next = target.next;
        target.next.before = target.before;
        this.count--;

        Node cur = target;
        while(this.listIsNext(cur)) {
            cur = cur.next;
            cur.index--;
        }

        //free memory if it was C
        target.before = null;
        target.next = null;
        target.data = null;
        return true;
    }

    public int getCount() {
        return this.count;
    }

    public boolean isEmpty(){

//        //before
//        if(this.count == 0) {
//            return true;
//        }
//        return false;

        //after
        return this.count == 0 ? true : false;
    }

    private boolean listIsNext(Node node) {
        if(node.next == null || node.next.index == -1) {    //dummy node has index -1
            return false;
        }
        return true;
    }

    private Node listGetNodeByIndex(int idx) {
        Node node = null;
        Node result = null;
        if(this.count > 0) {
            node = this.head;
            while(this.listIsNext(node)) {
                node = node.next;
                if(node.index == idx) {
                    result = node;
                    break;
                }
            }
        }
        return result;
    }

}
