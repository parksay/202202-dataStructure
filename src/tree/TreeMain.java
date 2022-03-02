package tree;

import java.util.ArrayList;

public class TreeMain {

    public static void main(String args[]) {
        BinaryTree rootTree = new BinaryTree();
        int[] input = {3, 6, 7, 11, 13, 19, 7};

        //TODO : create doubly linked list dummy generic
        //TODO : create method traversal

        String result = "";
        ArrayList<BinaryTree> treeList = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            BinaryTree node = new BinaryTree();
            node.treeInit();
            result = node.setData(input[i]+"");
            treeList.add(node);
            printResult(1, result);
        }

        rootTree = treeList.get(0);
        treeList.get(0).setLeftSubTree(treeList.get(1));
        treeList.get(0).setRightSubTree(treeList.get(2));
        treeList.get(1).setLeftSubTree(treeList.get(3));
        treeList.get(1).setRightSubTree(treeList.get(4));
        treeList.get(3).setLeftSubTree(treeList.get(5));
        treeList.get(3).setRightSubTree(treeList.get(6));

        result = rootTree.getLeftSubTree().getData();
        printResult(2, result);
        result = rootTree.getLeftSubTree().getLeftSubTree().getData();
        printResult(2, result);

    }
    
    
    
    private static void printResult(int type, String data) {
        
//        //type
//        1 : 입력
//        2 : 출력
        
        switch(type) {
            case 1 : 
                System.out.println(data + "를 입력했습니다.");
                break;
            case 2 : 
                System.out.println(data + "를 출력했습니다.");
                break;
            case 3 : 
                System.out.println(data + "를 결과했습니다.");
                break;
            
        }
        
    }
}
