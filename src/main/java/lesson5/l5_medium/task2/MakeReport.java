package lesson5.l5_medium.task2;

import lesson5.l5_easy.task2.ReadFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class MakeReport {
    private static Path resource = Paths.get("resource");
    private static String fileName = "report_for_task3_medium_l5.txt";
    private static String filePath = Paths.get(resource.toString(), fileName).toString();
    private static int maxReport = 10;

    public static void main(String[] args) throws InterruptedException, IOException {
        //Задача №2
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать 10 отчетов, с разными доходами и расходами (Смотри класс new Random(1).nextInt() )
        // 4. Записать в файл "report.txt" все данные из отчетов.
        // 5. Прочитать файл report.txt, просуммировать все доходы и вывести на экран, тоже самое с расходами
        // Ожидаемый результат: общие доходы - (какое то число), общие расходы - (какое то число)

        //Генератор отчетов
        reportGenerator(maxReport);

        //Вывод результатов
        printResult(readReportAndCalculateResult());
    }

    private static void printResult(int[] sum) {
        System.out.println("общие доходы - " + sum[0] + ", общие расходы - " + sum[1]);
    }

    private static int[] readReportAndCalculateResult() {
        int[] sum = {0, 0};
        //URL urlResource = ReadFile.class.getClassLoader().getResource(fileName);
        //try (BufferedReader bufferedReader = new BufferedReader(new FileReader(urlResource.getFile()))) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.lines().forEach(string -> {
                String[] parts = string.split(";");
                sum[0] = sum[0] + Integer.parseInt(parts[0]);
                sum[1] = sum[1] + Integer.parseInt(parts[1]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void reportGenerator(int maxReport) throws IOException {
        Random random = new Random();
        int randomMax = 100_000;

        if (!Files.exists(resource)) {
            Files.createDirectory(resource);
        }
        //String filePath = Paths.get(resource.toString(), fileName).toString();
        //try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);     //Данные файла не очищаю. Итоги с нарастанием
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i : new int[maxReport]) {
                bufferedWriter.write(String.join(""
                        , new FinancialRecord(random.nextInt(randomMax), random.nextInt(randomMax)).toString()
                        ,"\n"));
            }
            bufferedWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

