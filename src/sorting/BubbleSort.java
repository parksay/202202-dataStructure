package sorting;

public class BubbleSort {


    public static boolean sortArray(int[] target) {

        //target[n] <=> target[n+1]     / bubble1
        //target[n+1] <=> target[n+2]   / bubble2
        //target[n+2] <=> target[n+3]   / bubble3
        // bubble to bubble, chain reaction

        int length;
        if(target == null) {
            return false;
        } else {
            length = target.length;
        }
        if (length < 2) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            int lastIndex = length - i - 1;
            for(int j = 0; j < lastIndex; j++) {
                if (target[j] > target[j+1]) {
                    int temp = target[j+1];
                    target[j+1] = target[j];
                    target[j] = temp;
                }
            }
        }
        return true;
    }

}
