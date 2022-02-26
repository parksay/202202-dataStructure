package stack;

public class StackLinkedListGeneric<T> {


    private class Node {
        T data;
        Node below;
    }

    Node head;
    int count;

//                     H
//                H    N3
//            H   N2   N2
//        H   N1  N1   N1

    public void stackInit() {
        Node node = new Node();
        node.data = null;
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

    public T stackPush(T data) {
        Node node = new Node();
        node.data = data;
        node.below = this.head.below;
        this.head.below = node;
        this.count++;
        return this.head.below.data;
    }

    public T stackPop() {
        if(this.count < 1 || this.head.below == null) {
            return null;
        } else {
            T data = this.head.below.data;
            this.head.below = this.head.below.below;
            this.count--;
            return data;
        }
    }

    public T stackPeek() {

        return this.head.below.data;
    }

    public int stackCount() {

        return this.count;
    }



}
