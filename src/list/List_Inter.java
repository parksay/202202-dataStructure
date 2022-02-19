package list;

public interface List_Inter {


    abstract boolean LInsertFirst(int data);
    abstract boolean LInsert(int data);
    abstract int LReadFirst(int data);
    abstract int LRead(int data);
    abstract int LRemove(int data);
}
