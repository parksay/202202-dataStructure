package queue;

public interface QueueInterface {

    abstract void queueInit();
    abstract boolean queueIsEmpty();
    abstract int enqueue(int data);
    abstract int dequeue();
    abstract int queuePeek();
}
