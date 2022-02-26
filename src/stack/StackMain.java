package stack;

public class StackMain {

    public static void main(String args[]) {

//        StackBasic stack = new StackBasic();
        StackLinkedList stack = new StackLinkedList();

        stack.stackInit();
        int result = 0;

        int[] input = {3,5,7,9,11};
        for(int i = 0; i < input.length; i++) {
            result = stack.stackPush(input[i]);
            sPrint(1, result);
        }
        System.out.println("_________입력 끝___________");


        while(!stack.stackIsEmpty()){
            result = stack.stackPop();
            sPrint(2, result);
        }
        System.out.println("_________출력 끝___________");

    }

    private static boolean sPrint(int type, int data){
        // type = 1:추가 / 2:출력 / 3:삭제
        if(type == 1) {
            System.out.println(data + "를 추가하였습니다");
        } else if(type == 2) {
            System.out.println(data + "를 출력하였습니다");
        } else if(type == 3) {
            System.out.println(data + "를 삭제하였습니다");
        }
        return true;
    }

}
