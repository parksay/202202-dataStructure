package queue;

public interface DequeInterface {

    //deque =  double-ended queue
    abstract void dequeInit();
    abstract boolean dequeIsEmpty();
    abstract int dequeInputHead(int data);
    abstract int dequeInputTail(int data);
    abstract int dequeOutputHead();
    abstract int dequeOutputTail();
    abstract int dequePeekHead();
    abstract int dequePeekTail();



}
