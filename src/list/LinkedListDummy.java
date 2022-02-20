package list;

public class LinkedListDummy implements ListInterface {

    private class Node {
        int data;
        Node next;
    }

    int count;
    Node head;
    Node cur;
    Node before;

    public boolean listInit(){
        Node dummy = new Node();
        dummy.data = 0;
        dummy.next = null;
        this.head = dummy;
        this.cur = null;
        this.before = null;
        this.count = 0;
        return true;
    }

    public int listInsert(int data){
        Node node = new Node();
        node.data = data;
        node.next = this.head.next;
        this.head.next = node;
        this.count++;
        return node.data;
    }

    public int listReadFirst(){
        if(this.count == 0 ) {
            return 0;
        } else {
            this.cur = this.head.next;
            this.before = this.head;
            return this.cur.data;
        }
    }

    public int listRead(){
        if(this.cur.next == null) {
            return 0;
        } else {
            this.before = this.cur;
            this.cur = this.cur.next;
            return this.cur.data;
        }
    }

    public int listRemove(){
        int del = this.cur.data;
        this.before.next = this.cur.next;
        this.cur = this.before;
        this.count--;
        return del;
    }

    public boolean listIsNext(){
        if (this.cur.next == null) {
            return false;
        } else if (this.cur.next != null) {
            return true;
        } else {
            return false;
        }
    }

    public int listCount(){
        return this.count;
    }

    public boolean listSetCompRule(){
//        if(this.compRule == null) {
//            FInsert();
//        } else {
//            LInsert();
//        }
        return true;
    }
}
