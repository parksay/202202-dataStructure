package stack;

import java.util.Map;

public class StackLinkedList implements StackInterface {

    private class Node {
        int data;
        Node below;

    }

    Node head;
    int count;

//                     H
//                H    B3
//            H   B2   B2
//        H   B1  B1   B1

    public void stackInit() {
        Node node = new Node();
        node.data = 0;
        node.below = null;

        this.head = node;
        this.count = 0;
    }

    public boolean stackIsEmpty() {

        if(this.count < 1 || this.head.below == null) {
            return true;
        } else {
            return false;
        }
    }

    public int stackPush(int data) {
        Node node = new Node();
        node.data = data;
        node.below = this.head.below;
        this.head.below = node;
        this.count++;
        return this.head.below.data;
    }

    public int stackPop() {
        if(this.count < 1 || this.head.below == null) {
            return 0;
        } else {
            int data = this.head.below.data;
            this.head.below = this.head.below.below;
            this.count--;
            return data;
        }
    }

    public int stackPeek() {

        return this.head.below.data;
    }

    public int stackCount() {

        return this.count;
    }

}
