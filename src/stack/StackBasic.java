package stack;

public class StackBasic implements StackInterface {

    int[] stackArr;
    int topIndex;
    int length = 10;

    public void stackInit() {

        this.stackArr = new int[this.length];
        this.topIndex = -1;

    }

    public boolean stackIsEmpty() {
        if(this.topIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

    public int stackPush(int data) {
        if(this.topIndex+1 < this.length) {
            this.topIndex++;
            this.stackArr[this.topIndex] = data;
            return this.stackArr[this.topIndex];
        } else {
            return 0;
        }
    }

    public int stackPop() {
        if(this.topIndex < 0) {
            return 0;
        } else {
            int data = this.stackArr[this.topIndex];
            this.topIndex--;
            return data;
        }
    }

    public int stackPeek() {
        if(this.topIndex < 0) {
            return 0;
        } else {
            return this.stackArr[this.topIndex];
        }
    }

    public int stackCount() {
        if(this.topIndex<0) {
            return 0;
        } else {
            return this.topIndex;
        }
    }

}
