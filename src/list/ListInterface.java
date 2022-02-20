package list;

public interface ListInterface {


    abstract boolean listInit();
    abstract int listInsert(int data);
    abstract int listReadFirst();
    abstract int listRead();
    abstract int listRemove();
    abstract boolean listIsNext();
    abstract int listCount();

}
