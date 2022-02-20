package list;

public class ArrayListBasic implements ListInterface {

    int len = 10;
    int[] list;
    int count;
    int pos;

    public boolean listInit(){
        this.list = new int[this.len];
        this.count = 0;

        return true;
    }

//        this.list = new int[10];
//        하는 순간 list 안에 int가 들어가는 방을 10개 만들고, 그 안을 모두 일단 0으로 채워 둠.
//        그니까 아래랑 같은 말임.
//        this.list = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        그래서 내가 안에 아직 아무것도 넣지 않았어도, 길이가 10이 됨.
//        int length = this.list.length; // length = 10

    public int listInsert(int data){
        if(this.count < this.len) {
            this.list[this.count] = data;
            this.count++;
            return this.list[this.count-1];
        } else {
            return 0;
        }
    }
    public int listReadFirst(){
        this.pos = 0;

        return this.list[this.pos];
    }
    public int listRead(){
        if(listIsNext()){
            this.pos++;
            return this.list[this.pos];
        } else {
            return 0;
        }
    }
    public int listRemove(){
        int del = this.list[pos];
        for(int i=this.pos; i < this.count-1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.pos--;
        this.count --;
        return del;


    }
    public boolean listIsNext(){
        if(this.pos < this.count-1 ){
            return true;
        } else {
            return false;
        }
    }

    public int listCount() {
        return this.count;
    }


}
