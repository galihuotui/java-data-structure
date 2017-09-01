package Stack;

/**
 * Created by cuikangyuan on 2017/9/1.
 */
public class StackApp {

    public static void main(String[] args) {
        StackX stackX = new StackX(10);

        stackX.push(1);
        stackX.push(2);
        stackX.push(3);
        stackX.push(4);
        stackX.push(5);
        stackX.push(6);
        stackX.push(7);
        stackX.push(8);
        stackX.push(9);
        stackX.push(10);
        stackX.push(11);

        while (!stackX.isEmpty()){
            long pop = stackX.pop();
            System.out.print(pop + " ");
        }

    }



}
