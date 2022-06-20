package lesson5.l5_easy.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Homework3 {
    public static void main(String[] args) {
        //Задача №3
        //Необходимо:
        // 1. Создать класс Financial record, с двумя атрибутами: incomes, outcomes (доходы, расходы)
        // 2. Создать в этом классе геттеры, сеттеры и конструктор на все атрибуты
        // 3. Создать объект этого класса прямо здесь (class Homework3, метод main), с доходами 500, расходами 300
        // 4. Записать в файл "report.txt" данные из объекта класса.
        // Ожидаемый результат: в файле report.txt - одна строка: доходы = 500, расходы 300

        FinancialRecord financialRecord = new FinancialRecord(500f, 300f);
        try {
            createReports(financialRecord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createReports(FinancialRecord financialRecord) throws IOException {
        Path resource = Paths.get("resource");
        String fileName = "report.txt";
        if (!Files.exists(resource)) {
            Files.createDirectory(resource);
        }

        String filePath = Paths.get(resource.toString(), fileName).toString();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(String.join("",financialRecord.toString(), "\n"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
