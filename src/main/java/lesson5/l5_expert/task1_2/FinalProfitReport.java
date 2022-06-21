package lesson5.l5_expert.task1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FinalProfitReport {
    private static Path resource = Paths.get("resource");
    private static final String REPORT_HEADER_CUT = "магазин;доход;расход;дата";
    private static final String SHOP = "pyterochka";
    private static final String REPORT_HEADER = "Прибыль по магазину " + SHOP + " по месяцам";

    public static void main(String[] args) throws IOException {
        List filesPaths = getFilesPath();
        List dataFromFiles = getDataFromFiles(filesPaths);
        Map<Integer, String> reportTask1 = makeReportTask1(dataFromFiles);
        Map<String, Double> reportTask2 = makeReportTask2(dataFromFiles);
        printReportTask1(reportTask1);
        System.out.println();
        printReportTask2(reportTask2);
    }

    private static void printReportTask2(Map<String, Double> report) {
        for (Map.Entry<String, Double> entry : report.entrySet()) {
            System.out.println("Расходы " + entry.getKey() + " за весь период: "
                    + String.format("%.2f", entry.getValue()));
        }
    }

    private static Map<String, Double> makeReportTask2(List dataFromFiles) {
        Map<String, Double> report = new HashMap<>();
        for (Object row : dataFromFiles) {
            String[] dataString = row.toString().split(";");
            String shop = dataString[0];

            if (report.get(shop) != null) {
                report.computeIfPresent(shop, (k, v) -> v + Double.parseDouble(dataString[2]));
            } else {
                report.put(shop, Double.parseDouble(dataString[2]));
            }
        }
        return report;
    }

    private static void printReportTask1(Map<Integer, String> report) {
        System.out.println(REPORT_HEADER);
        for (Map.Entry<Integer, String> entry : report.entrySet()) {
            String[] dateAndMarginArr = entry.getValue().split(";");
            System.out.println(dateAndMarginArr[0] + ": " + String.format("%.2f", Double.parseDouble(dateAndMarginArr[1])));
        }
    }

    public static Map<Integer, String> makeReportTask1(List dataFromFiles) {
        Map<Integer, String> report = new HashMap<>();
        for (Object row : dataFromFiles) {

            String[] dataString = row.toString().split(";");
            if (dataString[0].contains(SHOP)) {
                String[] dateArr = dataString[3].split("/");
                String month = new DecimalFormat("00").format(Integer.parseInt(dateArr[1]));
                String monthAndYaer = month + "." + dateArr[2];
                int index = Integer.parseInt(dateArr[1]);
                double margin = Double.parseDouble(dataString[1]) - Double.parseDouble(dataString[2]);

                if (report.get(index) != null) {
                    report.computeIfPresent(index, (k, v) -> "" + monthAndYaer + ";" + ((Double.parseDouble(v.substring(8))) + margin));
                } else {
                    report.put(index, "" + monthAndYaer + ";" + margin);
                }
            }
        }
        return report;
    }

    public static List getDataFromFiles(List filesPaths) {
        List dataFromFiles = new ArrayList();
        for (Object filePath : filesPaths) {
            try {
                FileReader fileReader = new FileReader(filePath.toString());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                dataFromFiles.addAll(bufferedReader.lines()
                        .filter(f -> !f.contains(REPORT_HEADER_CUT))
                        .collect(Collectors.toList()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataFromFiles;
    }

    public static List getFilesPath() throws IOException {
        List<Path> collectFilesPath = Files.walk(resource)
                .filter(Files::isRegularFile)
                .filter(files -> (files.getFileName().toString().contains("report_0") || files.getFileName().toString().contains("report_1")))
                .collect(Collectors.toList());
        return collectFilesPath;
    }
}