package monotonicQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Client {



    interface IMonotonicQueue {
        void push(int i);
        void pop(int i);
        int max();
    }

    class MonotonicQueue implements IMonotonicQueue {

        LinkedList<Integer> linkedList = new LinkedList();

        @Override
        public void push(int i) {
            while (!linkedList.isEmpty()
                    && linkedList.getLast() < i) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
        }

        @Override
        public void pop(int i) {
            if (i == linkedList.getFirst()) {
                linkedList.pollFirst();
            }
        }

        @Override
        public int max() {
            if (linkedList.getFirst() != null) {
                return linkedList.getFirst();
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = new Client().maxNumberInCurrentWindow(array, 3);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] maxNumberInCurrentWindow(int[] array, int k) {
        //time: O(n)
        //space: O(k)
        List<Integer> res = new ArrayList<>();
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        int size = array.length;
        for (int i = 0; i < size; i++) {
            if (i < k-1) {
                //fill window
                monotonicQueue.push(array[i]);
            } else {
                //move window
                monotonicQueue.push(array[i]);
                res.add(monotonicQueue.max());
                monotonicQueue.pop(i);
            }
        }

        //return result array
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
