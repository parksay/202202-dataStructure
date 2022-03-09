package custom;

import customDataStructure.HeapCustom;
import org.junit.jupiter.api.Test;

public class HeapCustomTest {

    @Test
    public void runTest(){
        HeapCustom<String> heap = new HeapCustom<>(new HeapCompString());
        String result = "";
        result = heap.push("A");
        printHeap(1, result);
        result = heap.push("ABC");
        printHeap(1, result);
        result = heap.push("ABCDEF");
        printHeap(1, result);
        result = heap.pop();
        printHeap(2, result);

        result = heap.push("AB");
        printHeap(1, result);
        result = heap.push("ABCD");
        printHeap(1, result);
        result = heap.push("ABCDE");
        printHeap(1, result);
        result = heap.pop();
        printHeap(2, result);

        result = heap.push("A");
        printHeap(1, result);
        result = heap.push("ABCDEFG");
        printHeap(1, result);

        System.out.println("__________반복문___________");
        while(!heap.isEmpty()) {
            result = heap.pop();
            printHeap(2, result);
        }
    }


    private static void printHeap(int type, String data) {
        //type 1: input / 2: output
        switch (type) {
            case 1 :    //input
                System.out.println(data + "를 입력하였습니다.");
                break;
            case 2 :    //output
                System.out.println(data + "를 출력하였습니다.");
                break;
        }
    }


    private class HeapCompString implements HeapCustom.HeapComp {

        @Override
        public int comp(Object data1, Object data2) {
            String d1 = (String) data1;
            String d2 = (String) data2;
            if (d1.length() < d2.length()) {
                return 1;
            } else if (d1.length() > d2.length()) {
                return -1;
            }   else {
                return 0;
            }
        }
    }
}
