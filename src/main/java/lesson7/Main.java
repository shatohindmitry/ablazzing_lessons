package lesson7;

public class Main {

    public static void main(String[] args) {

        NumberList<Number> numberList = new NumberList<>();

        //Add
        numberList.add(-1);
        numberList.add(0);
        numberList.add(10);
        numberList.add(0.1);
        numberList.add(-0.1);
        numberList.add(-0.2);
        numberList.add(-0.3);
        numberList.add(null);
        System.out.println(numberList);

        //Contains > 2
        System.out.println(numberList.contains(1));
        System.out.println(numberList.contains(null));
        System.out.println(numberList.contains(-0.1));

        //GetDouble
        System.out.println(numberList.getDouble(1));

        //sumIntegers()
        System.out.println(numberList.sumIntegers());

        //Remove silent ALL
        numberList.remove((Integer) 1); //Object
        System.out.println(numberList);
        numberList.remove(1);       //Primitive
        System.out.println(numberList);

    }
}
