package lesson5.l5_expert.variantWithClasses;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VariantFinalProfitReport {
    private static Path resource = Paths.get("resource");
    private static final String REPORT_HEADER_CUT = "магазин;доход;расход;дата";
    private static final String SHOP = "pyterochka";
    private static final String REPORT_HEADER = "Прибыль по магазину " + SHOP + " по месяцам";

    public static void main(String[] args) throws IOException {

        Utils utils = new Utils(REPORT_HEADER_CUT, resource);
        List filesPaths = utils.getFilesPath();
        List dataFromFiles = utils.getDataFromFiles(filesPaths);
        List<Row> collectData = collectData(dataFromFiles);
        printReport(SHOP, collectData);
        System.out.println();
        printReport(collectData);
    }

    private static void printReport(List<Row> collectData) {
        List<Row> collectOnlyOneShop = null;
        Set shops = collectData.stream()
                .map(element -> element.shop)
                .collect(Collectors.toSet());

        for (Object shop : shops) {
            StringBuilder stringForReport = new StringBuilder("Расходы ");
            collectOnlyOneShop = collectData.stream()
                    .filter((record) -> (record.shop.equals(shop)))
                    .collect(Collectors.toList());

            if (!collectData.isEmpty()) {
                double expenses = 0;
                Row oneRecord = collectOnlyOneShop.get(0);
                stringForReport.append(oneRecord.shop);
                stringForReport.append(" за весь период: ");

                for (Row record : collectOnlyOneShop) {
                    expenses = expenses + record.getOutcomes();
                }
                stringForReport.append(String.format("%.2f", expenses));
            }
            System.out.println(stringForReport.toString());
        }
    }

    private static void printReport(String shop, List<Row> collectData) {
        List<Row> collectOnlyOneMonth = null;
        System.out.println(REPORT_HEADER);
        Set months = collectData.stream()
                .filter(record -> record.shop.equals(SHOP))
                .map(element -> element.month)
                .collect(Collectors.toSet());

        for (Object month : months) {
            StringBuilder stringForReport = new StringBuilder("");
            collectOnlyOneMonth = collectData.stream()
                    .filter((record) -> (record.shop.equals(SHOP) && record.month == (int) month))
                    .collect(Collectors.toList());

            if (!collectData.isEmpty()) {
                double margin = 0;
                Row oneRecord = collectOnlyOneMonth.get(0);
                stringForReport.append(oneRecord.date);
                stringForReport.append(": ");

                for (Row record : collectOnlyOneMonth) {
                    margin = margin + record.getMargin();
                }
                stringForReport.append(String.format("%.2f", margin));
            }
            System.out.println(stringForReport.toString());
        }
    }

    private static List<Row> collectData(List dataFromFiles) {
        List<Row> report = new ArrayList<>();
        int month;
        double incomes, outcomes;
        String shop, date;
        String[] dateArr;

        for (Object row : dataFromFiles) {
            String[] dataString = row.toString().split(";");
            shop = dataString[0];
            dateArr = dataString[3].split("/");
            month = Integer.parseInt(dateArr[1]);
            incomes = Double.parseDouble(dataString[1]);
            outcomes = Double.parseDouble(dataString[2]);
            String monthString = new DecimalFormat("00").format(Integer.parseInt(dateArr[1]));
            String monthAndYaer = monthString + "." + dateArr[2];
            date = monthAndYaer;
            Row record = new Row(month, incomes, outcomes, shop, date);
            report.add(record);
        }
        return report;
    }
}

//    Прибыль по магазину pyterochka по месяцам
//        01.2012:-34075,20
//        02.2012:-101400,01
//        03.2012:-196646,11
//        04.2012:166021,31
//        05.2012:97219,82
//        06.2012:43280,02
//        07.2012:-84599,53
//        08.2012:89920,32
//        09.2012:16178,95
//        10.2012:101142,46
//        11.2012:-34525,80
//        12.2012:-107203,39
//
//        Расходы ydoma за весь период:4635784,95
//        Расходы perekrestok за весь период:4447015,21
//        Расходы okey за весь период:4304725,94
//        Расходы pyterochka за весь период:4564607,59