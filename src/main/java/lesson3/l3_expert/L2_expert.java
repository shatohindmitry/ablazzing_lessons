package lesson3.l3_expert;

import java.util.*;
import java.util.stream.Collectors;

public class L2_expert {
    public static void main(String[] args) {

        //Входные данные
        Map<Integer, Map<String, String[]>> incomingData = GeneratorExpertHomework.getData();

        SortedMap<Integer, Integer> regionAndCountIncomingCar = new TreeMap<>();

        //Получение Регион + Колво въехавших для всех регионов
        //Переписать через Stream. Вынести в отдельный метод
        for (Map.Entry region : incomingData.entrySet()) {
            Map<Integer, Integer> values = (Map<Integer, Integer>) region.getValue();
            for (Map.Entry carsArrays : values.entrySet()) {
                if (carsArrays.getKey() == "input") {
                    String[] inputValues = (String[]) carsArrays.getValue();
                    regionAndCountIncomingCar.put((Integer) region.getKey(), inputValues.length);
                }
            }
        }
        System.out.println("Тест regionAndCountIncomingCar " + regionAndCountIncomingCar);

        //Тестовая
        Map<Integer, Integer> resultMapTopSorted = resultMapTopSorted(regionAndCountIncomingCar);
        System.out.println("Тест resultMapTopSorted " + resultMapTopSorted);

        StringBuilder resultTextTOP = new StringBuilder("ТОП-5: ");
        Map<Integer, List<Integer>> resultMapAnalitic = new HashMap<>();

        regionAndCountIncomingCar.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(5).forEach((region) -> {

                    resultTextTOP.append(region.getKey() + ", ");

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

                    resultTextTOP.deleteCharAt(resultTextTOP.length() - 2);
                });

        resultMapAnalitic.entrySet().stream()
                .forEach((region) -> {
                    List numbers = region.getValue();
                    //System.out.println(region.getKey());
                    //System.out.println(numbers.size());
                });

        //System.out.println("resultMapAnalitic " +resultMapAnalitic);
        //System.out.println(resultTextTOP);
    }

    //Тестовый кусок кода для проверки сортировки
    public static Map<Integer, Integer> resultMapTopSorted(SortedMap<Integer, Integer> regionAndCountIncomingCar){
        Map<Integer, Integer> resultMapTop = regionAndCountIncomingCar.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(k->k.getKey(), v->v.getValue()));
        return resultMapTop;
    }

}


