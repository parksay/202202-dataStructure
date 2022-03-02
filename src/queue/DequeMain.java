package queue;

public class DequeMain {

    public static void main(String args[]) {
        //deque =  double-ended queue

        DequeDoublyLinkedList deque = new DequeDoublyLinkedList();
        deque.dequeInit();

        int result = 0;
        int[] input = {3, 5, 7, 11, 17, 13};

        //input and output head
        for(int i = 0; i < input.length; i++) {
            result = deque.dequeInputHead(input[i]);
            printResult(1, result);
        }
        while(!deque.dequeIsEmpty()){
            result = deque.dequePeekHead();
            printResult(3, result);
            result = deque.dequeOutputHead();
            printResult(2, result);
        }

        //input and output tail
        for(int i = 0; i < input.length; i++) {
            result = deque.dequeInputTail(input[i]);
            printResult(1, result);
        }
        while(!deque.dequeIsEmpty()){
            result = deque.dequePeekTail();
            printResult(3, result);
            result = deque.dequeOutputTail();
            printResult(2, result);
        }

        //head and tail
        for(int i = 0; i < input.length/2; i++) {
            result = deque.dequeInputHead(input[i]);
            printResult(1, result);
        }
        for(int i = input.length/2; i < input.length; i++) {
            result = deque.dequeInputTail(input[i]);
            printResult(1, result);
        }
        for(int i = 0; i < input.length/2; i++) {
            result = deque.dequeOutputHead();
            printResult(2, result);
        }
        for(int i = input.length/2; i < input.length; i++) {
            result = deque.dequeOutputTail();
            printResult(2, result);
        }
    }

    private static void printResult(int type, int data) {

//        //type
//        1 : input
//        2 : output
//        3 : peek

        switch(type) {
            case 1:
                System.out.println(data + "가 입력되었습니다.");
                break;
            case 2:
                System.out.println(data + "가 출력되었습니다.");
                break;
            case 3:
                System.out.println(data + "가 조회되었습니다.");
                break;

        }

    }

}
