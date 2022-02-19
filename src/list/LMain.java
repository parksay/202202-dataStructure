package list;

import list.arrayList.Array_List;
import list.linkedList.Linked_List;
import list.linkedListDummy.Linked_List_Dummy;

public class LMain {


    public static void main(String args[]) {
        Array_List aList = new Array_List();
//        Linked_List aList = new Linked_List();
//        Linked_List_Dummy aList = new Linked_List_Dummy();

        //리스트 초기화
        aList.LInit();

        //데이터 입력
        int input = 0;
        input = aList.LInsert(2);
        LPrint(1, input);
        input = aList.LInsert(9);
        LPrint(1, input);
        input = aList.LInsert(5);
        LPrint(1, input);
        input = aList.LInsert(5);
        LPrint(1, input);
        input = aList.LInsert(7);
        LPrint(1, input);
        input = aList.LInsert(7);
        LPrint(1, input);
        input = aList.LInsert(6);
        LPrint(1, input);
        System.out.println("______________________________");

        //데이터 조회
        int read = 0;
        read = aList.LReadFirst();
        LPrint(2, read);
        while(aList.LNext()){
            read = aList.LRead();
            LPrint(2, read);
        }
        System.out.println("______________________________");


        //데이터 삭제
        int del = 0;
        int target = 5;
        if(aList.LReadFirst() == target) {
            del = aList.LRemove();
            LPrint(3, del);
        } else {
            while(aList.LNext()){
                if(aList.LRead() == target) {
                    del = aList.LRemove();
                    LPrint(3, del);
                }
            }
            System.out.println("데이터 삭제 끝");
        }
        System.out.println("______________________________");

        //데이터 조회
        read = aList.LReadFirst();
        LPrint(2, read);
        while(aList.LNext()){
            read = aList.LRead();
            LPrint(2, read);
        }
        System.out.println("______________________________");


    }


    private static boolean LPrint(int type, int data){
        if(type == 1) {
            System.out.println(data + "가 입력되었습니다");
        } else if (type == 2) {
            System.out.println(data + "가 조회되었습니다");
        } else if (type == 3) {
            System.out.println(data + "가 삭제되었습니다");
        } else {
            System.out.println("type 입력 오류");
        }
        return true;
    }
}
