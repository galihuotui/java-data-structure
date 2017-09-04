package stack.reverseApp;

import stack.CharStackX;

/**
 * Created by cuikangyuan on 2017/9/1.
 */
public class Reverser {

    private String input = "";

    private String output = "";

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        int stackSize = input.length();

        CharStackX stackX = new CharStackX(stackSize);

        for (int j = 0; j < stackSize; j++) {
            char ch = input.charAt(j);
            stackX.push(ch);
        }

        output = "";

        while (!stackX.isEmpty()) {
            char pop = stackX.pop();
            output = output + pop;
        }

        return output;
    }
}
