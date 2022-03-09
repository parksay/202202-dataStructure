package sorting;

import customDataStructure.HeapCustom;

public class HeapSort {


    public static boolean sortArray(int[] target) {

        int length;
        if(target == null) {
            return false;
        } else {
            length = target.length;
        }
        if (length < 2) {
            return false;
        }

        HeapCustom<Integer> after = new HeapCustom<>(new CompHeapSort());
        for(int i =0; i < length; i++) {
            after.push(Integer.valueOf(target[i]));     //wrapping data is optional here, it works normally without wrapping
        }
        for(int i =0; i < length; i++) {
            target[i] = after.pop().intValue();     //unwrapping data is required here, it doesn't work normally without unwrapping
        }

        return true;
    }


    private static class CompHeapSort implements HeapCustom.HeapComp {  //modifier 'static' can be used by class
        @Override
        public int comp(Object data1, Object data2){
            Integer d1 = (Integer) data1;       //data type doesn't matter here, 'Integer' or 'int'
            Integer d2 = (Integer) data2;
            if(d1.intValue() < d2.intValue()) {
                return 1;
            } else if (d1 > d2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
