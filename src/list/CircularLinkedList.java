package list;

public class CircularLinkedList implements ListInterface {

    private class Node {
        int data;
        Node next;
    }
    int count;
    Node tail;
    Node cur;
    Node before;

    public boolean listInit(){

        this.count = 0;
        this.tail = null;

        return true;
    }

    public int listInsert(int data) {
        return listInsertHead(data);
    }

    public int listInsertHead(int data){
        Node node = new Node();
        node.data = data;

        if(this.tail == null) {
            this.tail = node;
            this.tail.next = node;
        } else {
            node.next = this.tail.next;
            this.tail.next = node;
        }

        this.count++;
        return this.tail.next.data;
    }

    public int listInsertTail(int data) {
        Node node = new Node();
        node.data = data;

        if(this.tail == null) {
            this.tail = node;
            this.tail.next = node;
        } else {
            node.next = this.tail.next;
            this.tail.next = node;
            this.tail = node;
        }

        this.count++;
        return this.tail.data;
    }

    public int listReadFirst(){

        if(this.count < 2) {
            this.before = this.tail;
            this.cur = this.tail;
            return 0;
        } else {
            this.before = this.tail;
            this.cur = this.tail.next;
            return this.cur.data;
        }

    }

    public int listRead(){

        if(this.tail == null) {
            return 0;
        }
        this.before = this.cur;
        this.cur = this.cur.next;

        return this.cur.data;
    }

    public int listRemove(){
        if(this.count < 2) {
            this.tail = null;
            this.before = null;
            this.cur = null;
            this.count = 0;
            return 0;
        } else {
            int del = this.cur.data;
            this.before.next = this.cur.next;
            this.cur = this.before;
            this.count--;
            return del;
        }
    }

    public boolean listIsNext(){
        if(this.tail.next != null) {
            return true;
        } else {
            return false;
        }
    }

    public int listCount(){

        return this.count;
    }
}
