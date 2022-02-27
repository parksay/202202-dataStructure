package queue;

public class QueueCircular implements QueueInterface {


    private int head;
    private int tail;
    private int length;
    private int[] dataArr;

    public void queueInit() {
        this.head = 0;
        this.tail = 0;
        this.length = 10;
        this.dataArr = new int[this.length];

    }

    public boolean queueIsEmpty() {
        if(this.head == this.tail) {
            return true;
        } else {
            return false;
        }
    }

    public int enqueue(int data) {
        if(this.queueIsFull()) {
            return 0;
        }

        this.tail = getNextPosition(this.tail);
        this.dataArr[this.tail] = data;
        return this.dataArr[this.tail];
    }

    public int dequeue() {
        if(this.queueIsEmpty()) {
            return 0;
        }

        this.head = getNextPosition(this.head);
        return this.dataArr[this.head];
    }

    public int queuePeek() {
        if(this.queueIsEmpty()) {
            return 0;
        }

        return this.dataArr[this.head];
    }

    private int getNextPosition(int cur) {
        if(cur < this.length - 1) {
            return ++cur;   //return cur++; occurs malfunctioning because it returns cur and then plus 1 after that
        } else {
            return 0;
        }
    }

    private boolean queueIsFull() {
        if(this.head == getNextPosition(this.tail)) {
            return true;
        } else {
            return false;
        }
    }
}
