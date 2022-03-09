package sorting;

public class SelectionSort {

    public static boolean sortArray(int[] target) {
        //select what? select next element to insert

        int length;
        if(target == null) {
            return false;
        } else {
            length = target.length;
        }
        if (length < 2) {
            return false;
        }

        for(int i = 0; i < length - 1; i++){
            int nextIndex = i;
            for(int j = i + 1; j < length; j++) {
                if(target[j] < target[nextIndex]) {
                    nextIndex = j;
                }
            }
            int temp = target[nextIndex];
            target[nextIndex] = target[i];
            target[i] = temp;
        }
        return true;

    }


    public static boolean originalIdea(int[] before) {
        int length;
        if(before == null) {
            return false;
        } else {
            length = before.length;
        }
        if (length < 2) {
            return false;
        }
        int[] after = new int[length];
        int count = 0;
        while(count < length) {
            int nextIndex = 0;
            for(int i = 0; i < length - count; i++) {   // select next element from before
                if(before[i] < before[nextIndex]) {     // condition statement for comparing
                    nextIndex = i;
                }
            }
            after[count] = before[nextIndex];       //copy next element from before and paste it into after
            for(int i = nextIndex; i < length - count-1; i++) {     //move one space for removed data from before
                before[i] = before[i+1];
            }
            count++;
        }

        for(int i = 0; i < length; i++) {   //paste after over before
            before[i] = after[i];
        }
        return true;

        //input array "before"
        //create array "after"
        //select the next element from "before"
        //copy and paste the element into the next place of "after"
        //repeat this process for all data of "before"
        //if you have done filling the array "after", then paste "after" over "before"
        //above description is the basic idea of "selection sort"
        //but you can skip some process by replacing data

//        after       ||      before
//        O  O  O  O  ||  3  2  1  4
//        1  O  O  O  ||  3  2  4
//        1  2  O  O  ||  3  4
//        1  2  3  O  ||  4
//        1  2  3  4  ||

        // original idea above, modified process below

//        before
//        ?   O
//        4 | 1   5   2   3       //select and find the next element for first place
//        1 | 4   5   2   3       //replace the first element and the selected element each other
//            ?       O
//        1   4 | 5   2   3       //select and find the next element for second place
//        1   2 | 5   4   3       //replace the second element and the selected element each other
//                ?        O
//        1   2   5 |  4   3      //select and find the next element for third place
//        1   2   3 |  4   5      //replace the third element and the selected element each other
//                    ? O
//        1   2   3   4 | 5       //select and find the next element for fourth place
//        1   2   3   4 | 5       //replace the fourth element and the selected element each other
//                        ? O
//        1   2   3   4   5 |     //select and find the next element for fifth place
//        1   2   3   4   5 |     //replace the fifth element and the selected element each other

    }

}
