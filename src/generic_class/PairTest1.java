package generic_class;

public class PairTest1 {


    public static void main(String[] args) {


        String[] words = {"a", "b", "c", "d", "e"};

        Pair<String> mm = ArrayAlg.minmax(words);

        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());


        String middle = ArrayAlg.<String>getMiddle("a", "b", "c");

    }

}
