package list.linkedListDummy;

import list.List_Inter;

public class Linked_List_Dummy implements List_Inter {

    private class Node {
        int data;
        Node next;
    }

    int count;
    Node head;
    Node cur;
    Node before;

    public boolean LInit(){
        Node dummy = new Node();
        dummy.data = 0;
        dummy.next = null;
        this.head = dummy;
        this.cur = null;
        this.before = null;
        this.count = 0;
        return true;
    }

    public int LInsert(int data){
        Node node = new Node();
        node.data = data;
        node.next = this.head.next;
        this.head.next = node;
        this.count++;
        return node.data;
    }

    public int LReadFirst(){
        if(this.count == 0 ) {
            return 0;
        } else {
            this.cur = this.head.next;
            this.before = this.head;
            return this.cur.data;
        }
    }

    public int LRead(){
        if(this.cur.next == null) {
            return 0;
        } else {
            this.before = this.cur;
            this.cur = this.cur.next;
            return this.cur.data;
        }
    }

    public int LRemove(){
        int del = this.cur.data;
        this.before.next = this.cur.next;
        this.cur = this.before;
        this.count--;
        return del;
    }

    public boolean LNext(){
        if (this.cur.next == null) {
            return false;
        } else if (this.cur.next != null) {
            return true;
        } else {
            return false;
        }
    }

    public int LCount(){
        return this.count;
    }

    public boolean setCompRule(){
//        if(setCompRule() == null) {
//            FInsert();
//        } else {
//            LInsert();
//        }
        return true;
    }
}
