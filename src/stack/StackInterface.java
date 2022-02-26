package stack;

public interface StackInterface {

    abstract void stackInit();
    abstract boolean stackIsEmpty();
    abstract int stackPush(int data);
    abstract int stackPop();
    abstract int stackPeek();
    abstract int stackCount();


}
