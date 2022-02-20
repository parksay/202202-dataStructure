package list;

public class DoublyLinkedList implements ListInterface {

    private class Node {
        int data;
        Node next;
        Node before;
    }
    int count;
    Node head;
    Node cur;


    public boolean listInit(){

        this.count = 0;
        this.head = null;

        return true;
    }

    public int listInsert(int data){

        Node node = new Node();
        node.data = data;

        if(this.count < 1) {    //no node
            node.next = this.head;  //now head is null
            node.before = null;
        } else {        //link node to head
            node.next = this.head;
            this.head.before = node;
        }

        this.count++;
        this.head = node;
        return this.head.data;
    }

    public int listReadFirst(){

        if(this.count < 1) {    //no node
            this.head = null;
            this.cur = null;
            this.count = 0;
            return 0;
        }

        this.cur = this.head;
        return this.cur.data;

    }

    public int listRead(){

        return listReadNext();
    }

    public int listReadNext(){

        if (this.cur.next == null ) {
            return 0;
        } else {
            this.cur = this.cur.next;
        }
        return this.cur.data;

    }

    public int listReadBefore(){

        if (this.cur.before == null) {
            return 0;
        } else {
            this.cur = this.cur.before;
        }
        return this.cur.data;
    }

    public int listRemove(){
        int del = this.cur.data;
        if(this.count < 2) {
            this.head = null;
            this.cur = null;
            this.count = 0;
        } else if (this.cur.before == null) {   //remove first node
            this.head = this.cur.next;
            this.cur.next = null;
            this.head.before = null;
            this.cur = this.head;
            this.count--;
        } else if (this.cur.next == null) { //remove last node
            this.cur.before.next = null;
            this.cur = this.cur.before;
            this.cur.next.before = null;
            this.count--;
        } else {
            this.cur.before.next = this.cur.next;
            this.cur.next.before = this.cur.before;
        }
        return del;
    }

    public boolean listIsNext(){
        if(this.cur == null || this.cur.next == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean listIsBefore() {
        if(this.cur == null || this.cur.before == null) {
            return false;
        } else {
            return true;
        }
    }
    public int listCount(){
        return this.count;
    }

}
