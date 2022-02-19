package list;

public interface List_Inter {


    abstract boolean LInit();
    abstract int LInsert(int data);
    abstract int LReadFirst();
    abstract int LRead();
    abstract int LRemove();
    abstract boolean LNext();
    abstract int LCount();

}
