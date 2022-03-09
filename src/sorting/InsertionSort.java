package sorting;

public class InsertionSort {

    public static boolean sortArray(int[] target) {
        //divide the array into two area : sorted area and non-sorted area
        //find the place for the next element from sorted area
        //insert the next element into sorted area

//            sorted area || non-sorted area
//            O
//        ||  2   1   5   4   3
//                O
//        2   ||  1   5   4   3
//                    O
//        1   2   ||  5   4   3
//                        O
//        1   2   5   ||  4   3
//                            O
//        1   2   4   5   ||  3
//        1   2   3   4   5   ||



        int length;
        if(target == null) {
            return false;
        } else {
            length = target.length;
        }
        if (length < 2) {
            return false;
        }

        for(int i = 1; i < length; i++) {
            for(int j = i; j > 0; j--) {
                if(target[j] > target[j-1]) {
                    break;
                } else {
                    int temp = target[j];
                    target[j] = target[j-1];
                    target[j-1] = temp;
                    continue;
                }
            }
        }

        //original idea above, modified process below

//        for(int i = 1; i < length; i++) {
//            int cur = target[i];
//            int index = i;
//            for(int j = i; j > 0; j--) {
//                if(cur > target[j-1]) {
//                    target[index] = cur;
//                    break;
//                } else if(cur < target[j-1]) {
//                    target[j] = target[j-1];
//                    index = j-1;
//                    continue;
//                }
//            }
//            target[index] = cur;
//
//        }

        return true;
    }
}
