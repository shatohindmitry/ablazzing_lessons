package lesson3.l3_expert;

import java.util.*;

public class L2_expert {
    public static void main(String[] args) {

        Map<Integer, Map<String, String[]>> incomingData = GeneratorExpertHomework.getData();
        SortedMap<Integer, Integer> regionAndCountIncomingCar = regionAndCountIncomingCar(incomingData);
        SortedMap<Integer, String[]> regionAndNumbersIncomingCar = regionAndNumbersIncomingCar(incomingData);
        Map<Integer, Integer> resultMapTopSorted = resultMapTopSorted(regionAndCountIncomingCar);
        Map<Integer, List<Integer>> resultMapAnalitic = resultMapAnalitic(resultMapTopSorted, incomingData);
        Map<Integer, Map<Integer, Integer>> counter = counter(resultMapAnalitic);
        Map<Integer, Map<Integer, Integer>> maxCountRegion = maxCountRegion(counter);
        int specialCarsCount = findSpecialCars(regionAndNumbersIncomingCar);
        print(resultMapTopSorted, maxCountRegion, specialCarsCount);
    }

    private static int findSpecialCars(SortedMap<Integer, String[]> regionAndNumbersIncomingCar) {
        String REGEXP = "М...АВ...";
        Set<String> specialNumberSet = new HashSet<>();
        regionAndNumbersIncomingCar.forEach((iKey, stringArr) -> {
            for (String s : stringArr) {
                if (s.matches(REGEXP)) {
                    specialNumberSet.add(s);
                }
            }
        });
        return specialNumberSet.size();
    }

    public static void print(Map<Integer, Integer> resultMapTopSorted
            , Map<Integer, Map<Integer, Integer>> maxCountRegion
            , int specialCarsCount) {
        printTop(resultMapTopSorted);
        printAnalitic(maxCountRegion);
        printSpecialCar(specialCarsCount);
    }

    private static void printSpecialCar(int specialCarsCount) {
        System.out.println("Машин со спецномерами: " + specialCarsCount);
    }

    public static Map<Integer, Map<Integer, Integer>> maxCountRegion(Map<Integer, Map<Integer, Integer>> counter) {
        Map<Integer, Map<Integer, Integer>> returnCount = new LinkedHashMap<>();
        counter.entrySet().stream().forEach(p -> {
            int maxCount = Collections.max(p.getValue().entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
                    .getValue();
            int maxCountReg = Collections.max(p.getValue().entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
                    .getKey();
            Map<Integer, Integer> maxMap = new LinkedHashMap<>();
            maxMap.put(maxCountReg, maxCount);
            returnCount.put(p.getKey(), maxMap);
        });
        return returnCount;
    }

    public static void printAnalitic(Map<Integer, Map<Integer, Integer>> resultMapTopSorted) {
        StringBuilder resultText = new StringBuilder();
        resultMapTopSorted.entrySet().stream()
                .forEach(f -> {
                    resultText.append(f.getKey() + " - больше всего въехало с номерами ");
                    f.getValue().entrySet().stream().forEach(p -> {
                        resultText.append(p.getKey() + ": " + p.getValue() + "\n");
                    });
                });
        System.out.println(resultText);
    }

    public static void printTop(Map<Integer, Integer> resultMapTopSorted) {
        StringBuilder resultText = new StringBuilder();
        resultText.append("ТОП-5: ");
        resultMapTopSorted.entrySet().stream()
                .forEach(top -> {
                    resultText.append(top.getKey() + ", ");
                });
        resultText.deleteCharAt(resultText.length() - 2);
        System.out.println(resultText);
    }

    public static Map<Integer, Map<Integer, Integer>> counter(Map<Integer, List<Integer>> resultMapAnalitic) {
        Map<Integer, Map<Integer, Integer>> counter = new LinkedHashMap<>();
        resultMapAnalitic.entrySet().stream()
                .forEach((region) -> {
                    Map<Integer, Integer> numberRegionAndCount = new HashMap<>();
                    for (Object x : region.getValue()) {
                        int newValue = numberRegionAndCount.getOrDefault(x, 0) + 1;
                        numberRegionAndCount.put((int) x, newValue);
                        counter.put(region.getKey(), numberRegionAndCount);
                    }
                });
        return counter;
    }

    public static Map<Integer, List<Integer>> resultMapAnalitic(
            Map<Integer, Integer> resultMapTopSorted, Map<Integer, Map<String, String[]>> incomingData) {

        Map<Integer, List<Integer>> resultMapAnalitic = new LinkedHashMap<>();

        resultMapTopSorted.entrySet().stream()
                .forEach(region -> {
                    incomingData.entrySet().stream()
                            .filter((inRegion) -> inRegion.getKey().equals(region.getKey()))
                            .forEach((input) -> {
                                List<Integer> listCarNumbers = new ArrayList<>();
                                Map<String, String[]> inputArr = input.getValue();
                                inputArr.entrySet().stream()
                                        .filter((inputKey) -> inputKey.getKey() == ("input"))
                                        .forEach((carNumbers) -> {
                                            String[] carNumbersValue = carNumbers.getValue();
                                            Arrays.stream(carNumbersValue)
                                                    .forEach(q -> {
                                                        listCarNumbers.add(Integer.parseInt(q.substring(6)));
                                                    });
                                        });
                                resultMapAnalitic.put(input.getKey(), listCarNumbers);
                            });
                });

        return resultMapAnalitic;
    }

    //Получение Регион + Кол-во въехавших для всех регионов
    public static SortedMap<Integer, Integer> regionAndCountIncomingCar(Map<Integer, Map<String, String[]>> incomingData) {
        SortedMap<Integer, Integer> regionAndCountIncomingCar = new TreeMap<>();
        //Переписать через Stream
        for (Map.Entry region : incomingData.entrySet()) {
            Map<Integer, Integer> values = (Map<Integer, Integer>) region.getValue();
            for (Map.Entry carsArrays : values.entrySet()) {
                if (carsArrays.getKey() == "input") {
                    String[] inputValues = (String[]) carsArrays.getValue();
                    regionAndCountIncomingCar.put((Integer) region.getKey(), inputValues.length);
                }
            }
        }
        return regionAndCountIncomingCar;
    }

    public static SortedMap<Integer, String[]> regionAndNumbersIncomingCar(Map<Integer, Map<String, String[]>> incomingData) {
        SortedMap<Integer, String[]> regionAndNumbersIncomingCar = new TreeMap<>();
        //Переписать через Stream
        for (Map.Entry region : incomingData.entrySet()) {
            Map<Integer, Integer> values = (Map<Integer, Integer>) region.getValue();
            for (Map.Entry carsArrays : values.entrySet()) {
                if (carsArrays.getKey() == "input") {
                    String[] inputValues = (String[]) carsArrays.getValue();
                    regionAndNumbersIncomingCar.put((Integer) region.getKey(), inputValues);
                }
            }
        }
        return regionAndNumbersIncomingCar;
    }

    public static Map<Integer, Integer> resultMapTopSorted(SortedMap<Integer, Integer> regionAndCountIncomingCar) {
        Map<Integer, Integer> resultMapTopSorted = new LinkedHashMap<>();
        regionAndCountIncomingCar.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(f -> {
                    resultMapTopSorted.put(f.getKey(), f.getValue());
                });
        return resultMapTopSorted;
    }

}


