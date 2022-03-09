package sort;

import org.junit.jupiter.api.Test;
import sorting.SelectionSort;

public class SelectionSortTest {

    @Test
    public void sortArrayTest() {
        //given
        int[] target = {1, 5, 2, 7, 4, 17, 84, 237, 52, 58, 89};
        int[] err = null;

        //when
        SelectionSort.sortArray(target);
        SelectionSort.sortArray(err);
//        SelectionSort.originalIdea(target);
//        SelectionSort.originalIdea(err);


        //then
        printArray(target);

    }

    private static void printArray(int[] target) {
        if(target == null) {
            return;
        }


        for(int i  = 0; i < target.length; i++) {
            System.out.println(target[i]);
        }
    }
}
