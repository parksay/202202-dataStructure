package list;

public class LMain {


    public static void main(String args[]) {    // non - CircularLinkedList only
//        ArrayListBasic aList = new ArrayListBasic();
//        LinkedList aList = new LinkedList();
//        LinkedListDummy aList = new LinkedListDummy();
        DoublyLinkedList aList = new DoublyLinkedList();

        //리스트 초기화
        aList.listInit();

        //데이터 입력
        int result = 0;
        int[] input = {2, 9, 5, 5, 7, 7, 6};
        for(int i = 0; i < input.length; i++) {
            result = aList.listInsert(input[i]);
            LPrint(1, result);
        }
        System.out.println("______________________________");

        //데이터 조회
        result = aList.listReadFirst();
        LPrint(2, result);
        while(aList.listIsNext()){
            result = aList.listRead();
            LPrint(2, result);
        }
        System.out.println("______________________________");


        //데이터 삭제
        int target = 5;
        if(aList.listReadFirst() == target) {
            result = aList.listRemove();
            LPrint(3, result);
        } else {
            while(aList.listIsNext()){
                if(aList.listRead() == target) {
                    result = aList.listRemove();
                    LPrint(3, result);
                }
            }
            System.out.println("데이터 삭제");
        }
        System.out.println("______________________________");

        //데이터 조회
        result = aList.listReadFirst();
        LPrint(2, result);
        while(aList.listIsNext()){
            result = aList.listRead();
            LPrint(2, result);
        }
        System.out.println("______________끝______________");


    }



    private static boolean LPrint(int type, int data){
        if(type == 1) {
            System.out.println(data + "을 입력했습니다");
        } else if (type == 2) {
            System.out.println(data + "을 조회했습니다");
        } else if (type == 3) {
            System.out.println(data + "을 삭제했습니다");
        } else {
            System.out.println("type 입력 오류");
        }
        return true;
    }



    public static void mainCircular(String args[]) {    //CircularLinkedList only
        CircularLinkedList aList = new CircularLinkedList();
        //리스트 초기화
        aList.listInit();

        //데이터 입력
        int result = 0;
        int[] input = {2, 9, 5, 5, 7, 7, 6};
        for(int i = 0; i < input.length; i++) {
            result = aList.listInsert(input[i]);
            LPrint(1, result);
        }
        System.out.println("______________________________");

        //데이터 조회
        result = aList.listReadFirst();
        LPrint(2, result);
        for(int i = 1; i < aList.listCount(); i++){  //CircularLinkedList only
            result = aList.listRead();
            LPrint(2, result);
        }
        System.out.println("______________________________");


        //데이터 삭제
        int target = 5;
        if(aList.listReadFirst() == target) {
            result = aList.listRemove();
            LPrint(3, result);
        } else {
            for(int i = 1; i < aList.listCount(); i++){  //CircularLinkedList only
                if(aList.listRead() == target) {
                    result = aList.listRemove();
                    LPrint(3, result);
                }
            }
            System.out.println("데이터 삭제");
        }
        System.out.println("______________________________");

        //데이터 조회
        result = aList.listReadFirst();
        LPrint(2, result);
        for(int i = 1; i < aList.listCount(); i++){  //CircularLinkedList only
            result = aList.listRead();
            LPrint(2, result);
        }
        System.out.println("______________끝______________");

    }
}
