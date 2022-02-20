package list;

public class LinkedList implements ListInterface {

    private class Node {
        int data;
        Node next;
    }

    int count;
    Node head;
    Node tail;
    Node cur;
    Node before;

    public boolean listInit(){
        this.head = null;
        this.tail = null;
        this.cur = null;
        this.before = null;
        this.count = 0;

        return true;
    }

    public int listInsertFirst(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        this.head = node;
        this.tail = node;
        this.count++;

        return this.head.data;
    }

    public int listInsert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(this.head == null){
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
        this.count++;

        return this.tail.data;
    }

    public int listReadFirst(){
        this.cur = this.head;
        this.before = this.head;
        return this.cur.data;
    }

    public int listRead(){
        if(this.cur.next == null) {
            System.out.println("조회할 데이터가 더 이상 없습니다");
            return 0;
        } else if (this.cur.next != null) {
            this.before = this.cur;
            this.cur = this.cur.next;
            return this.cur.data;
        } else {
            System.out.println("입력 오류");
            return 0;
        }
    }


    public int listRemove(){
        int del =  this.cur.data;
        this.before.next = this.cur.next;

        this.cur = this.before;
        this.count--;
        return del;
    }

    public boolean listIsNext() {
        if(this.cur.next == null) {
            return false;
        } else if(this.cur.next != null) {
            return true;
        }
        return true;
    }

    public int listCount(){
        return this.count;
    }

}
