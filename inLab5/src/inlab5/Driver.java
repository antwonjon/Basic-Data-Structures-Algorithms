package inlab5;

public class Driver {
    public static void main(String[] args) {
        Search<String> string = new Search();
        Search<Integer> integer = new Search();

        Integer[] intArray = {1, 3, 4, 6};
        String[] strArray = {"Apples", "Bananas", "Cherries", "Cherry", "Donuts", "Egg", "Eggs", "Fries", "Grapes"};

        System.out.println("" + integer.Search(intArray, 1) );
        System.out.println("" + string.Search(strArray, "Eggs"));
    }
}
