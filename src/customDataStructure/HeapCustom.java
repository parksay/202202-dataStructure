package customDataStructure;

public class HeapCustom<T> {

    private HeapComp comp;
    private int length;
    private T[] dataArr;
    private int lastIndex;

    public HeapCustom(HeapComp comp) {
        this.length = 10;
        this.dataArr = (T[]) new Object[this.length];
        this.lastIndex = 0;
        this.comp = comp;
    }

    public HeapCustom(HeapComp comp, int length) {
        this.length = length;
        this.dataArr = (T[]) new Object[this.length];
        this.lastIndex = 0;
        this.comp = comp;
    }

    public boolean setComp(HeapComp comp) {
        this.comp = comp;
        return true;
    }

    public boolean isSetComp() {
        if (this.comp == null) {
            return false;
        } else {
            return true;
        }
    }

    public T push(T data) {
        this.lastIndex++;
        this.dataArr[this.lastIndex] = data;
        int curIndex = this.lastIndex;
        int supIndex = this.getSupIndex(curIndex);

        while(supIndex > 0) {
            if(this.comp(data, this.dataArr[supIndex]) == 1) {
                this.dataArr[curIndex] = this.dataArr[supIndex];
                curIndex = supIndex;
                supIndex = this.getSupIndex(curIndex);
            } else {
                break;
            }
        }
        this.dataArr[curIndex] = data;
        return this.dataArr[curIndex];
    }

    public T pop() {
        T output = this.dataArr[1];
        T lastData = this.dataArr[this.lastIndex];
        this.dataArr[this.lastIndex] = null;
        this.lastIndex--;
        int curIndex = 1;
        int subIndex = this.getHigherSubIndex(curIndex);

        while(subIndex != 0) {
            if(this.comp(this.dataArr[subIndex], lastData) == -1) {
                break;
            } else {
                this.dataArr[curIndex] = this.dataArr[subIndex];
                curIndex = subIndex;
                subIndex = this.getHigherSubIndex(curIndex);
            }
        }
        this.dataArr[curIndex] = lastData;
        return output;
    }

    public T peek() {

        return this.dataArr[1];
    }

    public boolean isEmpty() {

        return this.lastIndex < 1 ? true : false;
    }

    private int getSupIndex(int curIndex) {
        return curIndex == 1 ? 0 : curIndex / 2;
    }

    private int getLeftSubIndex(int curIndex) {
        return curIndex * 2 > this.lastIndex ? 0 : curIndex * 2;
    }

    private int getRightSubIndex(int curIndex) {
        return curIndex * 2 + 1 > this.lastIndex ? 0 : curIndex * 2 + 1;
    }

    private int getHigherSubIndex(int curIndex) {
        int subIndex = 0;
        int left = this.getLeftSubIndex(curIndex);
        int right = this.getRightSubIndex(curIndex);
        if(left > this.lastIndex || left == 0) {
            return subIndex;
        } else if(left == this.lastIndex) {
            subIndex = left;
        } else if(left < this.lastIndex) {
            if(this.comp(this.dataArr[left], this.dataArr[right]) == -1) {
                subIndex = right;
            } else {
                subIndex = left;
            }
        }
        return subIndex;
    }

    private int comp(T data1, T data2) {
        // data1 > data2 : return 1
        // data1 < data2 : return -1
        // data1 = data2 : return 0

        return this.comp.comp(data1, data2);
    }

    public interface HeapComp<T> {
        // data1 > data2 : return 1
        // data1 < data2 : return -1
        // data1 = data2 : return 0

        abstract int comp(T data1, T data2);
    }

}
