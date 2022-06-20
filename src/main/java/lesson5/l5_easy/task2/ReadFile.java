package lesson5.l5_easy.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

public class ReadFile {
    public static void main(String[] args) {
        //Задача №2
        //Необходимо:
        // 1. Создать папку resource, пометить ее как папку Resourсe root.
        // 2. Создать в ней файл "my_first_file.txt". На первой строке написать: "Моя бабушка", на второй: "читает газету жизнь"
        // 3. Прочитать файл, и вывести на экран все слова файла в одну строку
        // Ожидаемый результат: "Моя бабушка читает газету жизнь"

        try {
            URL urlResource = ReadFile.class.getClassLoader().getResource("my_first_file.txt");
            FileReader fileReader = new FileReader(urlResource.getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().forEach(string -> System.out.print(string + " "));

        } catch (Exception e) {
            System.out.printf("Error " + e.getMessage());
        }
    }
}
