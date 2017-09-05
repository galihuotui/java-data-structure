package priorityQ;

import java.io.IOException;

/**
 * Created by cuikangyuan on 2017/9/5.
 */
public class PriorityQApp {
    public static void main(String[] args) throws IOException {
        PriorityQ priorityQ = new PriorityQ(5);

        priorityQ.insert(6);
        priorityQ.insert(5);
        priorityQ.insert(2);
        priorityQ.insert(3);
        priorityQ.insert(4);
        priorityQ.insert(1);

        while (!priorityQ.isEmpty()) {
            long item = priorityQ.remove();
            System.out.print(item + " ");
        }
    }
}
