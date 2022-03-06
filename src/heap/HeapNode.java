package heap;

public class HeapNode {

    private class Node {
        String data;
        int priority;
    }

    private int length = 10;
    private Node[] nodeArr;
    private int lastIndex;

    public HeapNode() {
        this.nodeArr = new Node[this.length];
        this.lastIndex = 0;
    }

//                        N1
//                N2              N3
//            N4      N5      N6      N7
//        N8

    public String push(String data, int priority) {
//        First, add node N9 below N4 (next to N8).
//        And compare N9 with the super node.
//        If the priority of the super node is higher than N9, place node N9 in where it is,
//        else if the priority of N9 is higher than that of the super node, switch the position each other

        Node node = new Node();
        node.data  = data;
        node.priority = priority;

        this.lastIndex++;
        this.nodeArr[this.lastIndex] = node;
        int curIndex = this.lastIndex;
        int supIndex = this.getSupIndex(curIndex);

        while(supIndex > 0) {
            if(this.nodeArr[this.lastIndex].priority < this.nodeArr[supIndex].priority) {
                this.nodeArr[curIndex] = this.nodeArr[supIndex];
                curIndex = supIndex;
                supIndex = this.getSupIndex(curIndex);
            } else {
                break;
            }
        }
        this.nodeArr[curIndex] = node;
        return this.nodeArr[curIndex].data;
    }

    public String pop() {
        Node output = this.nodeArr[1];
        Node lastNode = this.nodeArr[this.lastIndex];
        this.nodeArr[this.lastIndex] = null;
        this.lastIndex--;
        int curIndex = 1;
        int subIndex = this.getSmallerSubIndex(curIndex);

        while(subIndex != 0) {
            if(this.nodeArr[subIndex].priority > lastNode.priority) {
                break;
            } else {
                this.nodeArr[curIndex] = this.nodeArr[subIndex];
                curIndex = subIndex;
            }
            subIndex = this.getSmallerSubIndex(curIndex);
        }
        this.nodeArr[curIndex] = lastNode;
        return output.data;
    }

    public String peek() {

        return this.nodeArr[1].data;
    }

    public boolean isEmpty() {

        return this.lastIndex < 1 ? true : false;
    }

    private int getSupIndex(int curIndex) {
        return curIndex == 1 ? 0 : curIndex / 2;
    }

    private int getLeftSubIndex(int curIndex) {
        return curIndex * 2 > this.lastIndex ? 0 : curIndex * 2;
    }

    private int getRightSubIndex(int curIndex) {
        return curIndex * 2 + 1 > this.lastIndex ? 0 : curIndex * 2 + 1;

    }


    private int getSmallerSubIndex(int curIndex) {
        int subIndex = 0;
        int left = this.getLeftSubIndex(curIndex);
        int right = this.getRightSubIndex(curIndex);
        if(left > this.lastIndex || left == 0 || right == 0) {
            return subIndex;
        } else if(left == this.lastIndex) {     // curNode has only one sub node(left one)
            subIndex = this.getLeftSubIndex(curIndex);
        } else if(left < this.lastIndex) {  // curNode has two sub node
            if(this.nodeArr[left].priority < this.nodeArr[right].priority) {   //put the index of higher priority node in subIndex
                subIndex = left;
            } else {
                subIndex = right;
            }
        }
        return subIndex;
    }
}
