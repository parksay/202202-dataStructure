package sort;

import org.junit.jupiter.api.Test;
import sorting.HeapSort;

public class HeapSortTest {

    @Test
    private void sortArrayTest() {

        //given
        int[] target = {1, 5, 2, 7, 4, 17, 84, 237, 52, 58, 89};
        int[] err = {3};

        //when
        HeapSort.sortArray(target);
        HeapSort.sortArray(err);


        //then
        printArray(target);
        printArray(err);

    }

    private void printArray(int[] target) {
        if(target == null) {
            return;
        }

        for(int i  = 0; i < target.length; i++) {
            System.out.println(target[i]);
        }
    }
}
