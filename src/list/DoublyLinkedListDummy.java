package list;

public class DoublyLinkedListDummy implements ListInterface {

    private class Node {
        int data;
        Node next;
        Node before;
    }

    int count;
    Node head;
    Node tail;
    Node cur;


//    HEAD=(dummy)<==>(dummy)=tail    //both of head and tail are null
//    HEAD=(dummy)<==>(B1|D1|N1)<==>(dummy)=tail  //insert head
//    HEAD=(dummy)<==>(B2|D2|N2)<==>(B1|D1|N1)<==>(dummy)=tail    //insert head
//    HEAD=(dummy)<==>(B3|D3|N3)<==>(B2|D2|N2)<==>(B1|D1|N1)<==>(dummy)=tail  //insert haed
//    HEAD=(dummy)<==>(B3|D3|N3)<==>(B2|D2|N2)<==>(B1|D1|N1)<==>(B4|D4|N4)<==>(dummy)=tail    //insert tail
//    HEAD=(dummy)<==>(B3|D3|N3)<==>(B2|D2|N2)<==>(B1|D1|N1)<==>(B4|D4|N4)<==>(B5|D5|N5)<==>(dummy)=tail  //insert tail

    public boolean listInit(){

        this.count = 0;
        this.head = null;
        this.tail = null;

        Node dummyHead = new Node();
        dummyHead.data = 0;
        Node dummyTail = new Node();
        dummyTail.data = 0;

        dummyHead.before = null;
        dummyHead.next = dummyTail;
        dummyTail.next = null;
        dummyTail.before = dummyHead;

        this.head = dummyHead;
        this.tail = dummyTail;

        return true;
    }

    public int listInsert(int data){

//        return listInsertHead(data);
        return listInsertTail(data);
    }

    public int listInsertHead(int data) {
        Node node = new Node();
        node.data = data;

        node.next = this.head.next;
        this.head.next.before = node;
        node.before = this.head;
        this.head.next = node;

        this.count++;
        return node.data;
    }

    public int listInsertTail(int data) {
        Node node = new Node();
        node.data = data;

        node.before = this.tail.before;
        this.tail.before.next = node;
        node.next = this.tail;
        this.tail.before = node;

        this.count++;
        return node.data;
    }

    public int listReadFirst(){
        this.cur = this.head;
        if(this.count < 1) {
            return 0;
        } else {
            this.cur = this.cur.next;
            return this.cur.data;
        }
    }

    public int listRead(){

        return listReadNext();
    }

    public int listReadNext(){
        if(this.cur.next == this.tail) {
            return 0;
        } else {
            this.cur = this.cur.next;
            return this.cur.data;
        }
    }

    public int listReadBefore(){
        if(this.tail.before == this.head) {
            return 0;
        } else {
            this.cur = this.cur.before;
            return this.cur.data;
        }
    }


    public int listRemove(){
        if(this.count < 1 || this.cur == this.head || this.cur == this.tail) {
            return 0;
        } else {
            int data = this.cur.data;
            this.cur.before.next = this.cur.next;
            this.cur.next.before = this.cur.before;
            this.cur = this.cur.before;
            this.count--;
            return data;
        }
    }

    public boolean listIsNext(){
        if(this.cur.next == this.tail) {
            return false;
        } else {
            return true;
        }
    }

    public boolean listIsBefore(){
        if(this.cur.before == this.head) {
            return false;
        } else {
            return true;
        }
    }

    public int listCount(){

        return this.count;
    }

}
