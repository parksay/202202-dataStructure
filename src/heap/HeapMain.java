package heap;

public class HeapMain {

    public static void main(String args[]) {


        HeapNode heap = new HeapNode();
        String result = "";
        result = heap.push("A", 1);
        printHeap(1, result);
        result = heap.push("B", 2);
        printHeap(1, result);
        result = heap.push("C", 3);
        printHeap(1, result);
        result = heap.pop();
        printHeap(2, result);

        result = heap.push("D", 4);
        printHeap(1, result);
        result = heap.push("E", 5);
        printHeap(1, result);
        result = heap.push("F", 6);
        printHeap(1, result);
        result = heap.pop();
        printHeap(2, result);

        result = heap.push("A", 1);
        printHeap(1, result);
        result = heap.push("H", 8);
        printHeap(1, result);
        result = heap.push("G", 7);
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
}
