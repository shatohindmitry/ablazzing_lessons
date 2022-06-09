package CoffeeMachine;

import java.util.*;

public class CoffeeMachine {

    int water, milk, coffee, cups, money;
    boolean hasEnoughIngredients;
    Map allRecipes;     //все рецепты
    String selectedRecipe;  //активный рецепт

    public CoffeeMachine(int water, int milk, int coffee, int cups, int money) {

        //Конструктор
        Recipe recipe = new Recipe();
        this.allRecipes = recipe.getAllRecipe();
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
        this.hasEnoughIngredients = false;
        this.selectedRecipe = "";
    }

    public static void main(String[] args) {

        //Загрузка первоначальных параметров кофемашины
        int water   = 1000,
                milk    = 1000,
                coffee  = 1000,
                cups    = 100,
                money   = 100;

        CoffeeMachine coffeeMachine = new CoffeeMachine(water, milk, coffee, cups, money);
        coffeeMachine.menu();

    }

    //Проверка ингредиенты
    public boolean checkIngredients(){

        if (!checkMoney()) return false;    //Проверка деньги

        int[] selectedRecipeArr = (int[]) allRecipes.get(selectedRecipe);
        int recipeWater = selectedRecipeArr[0];
        int recipeMilk = selectedRecipeArr[1];
        int recipeCoffee = selectedRecipeArr[2];

        if (water >= recipeWater && milk >= recipeMilk && coffee >= recipeCoffee && cups > 0){
            water  = water  - recipeWater;
            milk   = milk   - recipeMilk;
            coffee = coffee - recipeCoffee;
            cups = cups - 1;
            return true;
        }else {
            System.out.println("Нет ингредиентов.");
            return false;
        }

    }

    //Проверка деньги
    public boolean checkMoney(){

        int[] selectedRecipeArr = (int[]) allRecipes.get(selectedRecipe);
        int recipePrice = selectedRecipeArr[3];

        //Тут, вероятно, должна быть проверка на сдачу
        money  = money  + recipePrice;
        return true;
    }

    public void log(){
        //
    }

    //Текущие остатки
    public void warehouse() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    //Меню в цикле
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining):");
            action = scanner.next();
            switch (action) {
                case "buy":

                    int i = 0;
                    System.out.println("What do you want to buy?");
                    for (Object s:allRecipes.keySet()){                 //Обходим все рецепты. Вывожу ключи рецептов
                        System.out.println("" + ++i + " - " + s);
                    }

                    /////////////////////
                    String coffeeType = scanner.next();

                    int coffeeTypeInt = -1;

                    try {                                              //Проверка на корректный ввод
                        coffeeTypeInt = Integer.parseInt(coffeeType);}
                    catch (NumberFormatException e){
                        System.out.println("Press correct number");
                    }

                    if (coffeeTypeInt <= allRecipes.size()){            //Конвертирую введенное значение в ключ рецепта
                        selectedRecipe = (String) allRecipes.keySet().toArray()[coffeeTypeInt-1];
                        action = checkIngredients()? (""): ("exit");     //Проверяю на возможнось иначе выхожу
                    }
                    /////////////////////
                    break;
                case "fill":
                    System.out.println("fill()");
                    break;
                case "take":
                    System.out.println("take()");
                    break;
                case "remaining":
                    warehouse();
                    break;
            }
        } while (!action.equals("exit"));
    }


    //Рецепты.
    //Есть возможность расширить колво рецептов.
    public static class Recipe {

        int[] recipe;

        public Map getAllRecipe(){

            Map<String, int[]> recipeMap = new HashMap<>();
            recipeMap.put("Espresso", getEspresso());
            recipeMap.put("Latte", getLatte());
            recipeMap.put("Cappuccino", getCappuccino());

            return recipeMap;
        }

        public int[] getCappuccino(){
            int water = 200;
            int milk = 100;
            int coffee = 12;
            int price = 12;

            return recipe = new int[]{water, milk, coffee, price};
        }

        public int[] getEspresso(){
            int water = 250;
            int milk = 0;
            int coffee = 16;
            int price = 12;

            return recipe = new int[]{water, milk, coffee, price};
        }

        public int[] getLatte(){
            int water = 350;
            int milk = 75;
            int coffee = 20;
            int price = 550;;

            return recipe = new int[]{water, milk, coffee, price};
        }
    }

}