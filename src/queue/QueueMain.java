package queue;

public class QueueMain {


    public static void main(String args[]) {
//        QueueCircular queue = new QueueCircular();
        QueueDeque queue = new QueueDeque();
        queue.queueInit();

        int[] input = {3,7,9,13,5};
        for(int i = 0; i < input.length; i++) {
            queue.enqueue(input[i]);
        }

        while(!queue.queueIsEmpty()) {
            System.out.println(queue.dequeue());
        }

    }
}
