package sort;

import org.junit.jupiter.api.Test;
import sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSortTest {

    @Test
    public void sortArrayTest(){
        //givem
        int[] array = {1, 5, 2, 7, 4, 17, 84, 237, 52, 58, 89};
        int[] arrayShort = {21};
        //when
        BubbleSort.sortArray(array);
        BubbleSort.sortArray(arrayShort);

        //then
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
