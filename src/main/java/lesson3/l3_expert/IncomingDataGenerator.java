package lesson3.l3_expert;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IncomingDataGenerator {
    //
    //Формирует строку формата JSON, содержащую имя региона и массивы въехавших и выехавших машин.
    //
    //Генерирует случайные номера регионов. Генерирует случайные номера машин на основе регионов.
    //Должна быть хотя бы одна машина с кодом региона (carCountMin/Max).
    //Для каждого региона случайным образом выбирает машины, которые въехали и выехали.
    //Въехавших или выехавших машин может не оказаться. (Регион не посещался).
    //Рандомы могут не включать крайние позиции в диапазонах объектов к которым обращаются. Все на глаз.
    //Для второго задания "найти номера на М...АВ..." нет специальных алгоритмов. Можно "досолить" словарь букв.
    //
    //Пример возвращаемого результата под кодом внизу
    //
    //Используется Maven зависимость для JSONObject
    //        <!-- https://mvnrepository.com/artifact/org.json/json -->
    //        <dependency>
    //            <groupId>org.json</groupId>
    //            <artifactId>json</artifactId>
    //            <version>20220320</version>
    //        </dependency>

    public static void main(String[] args) {

        int regionCount = 10;           //колво регионов
        int regionCountMin = 1;
        int regionCountMax = 999;       //Номера регионов от Мин = 1 до Мах=999
        int carCountMin = 1;
        int carCountMax = 20;           //Колво машин в регионе
        String[] regionArray;           //Массив случайных номеров регионов
        List<String> carArray;          //Лист случайных номеров машин на основе существующих регионов
        String message;                 //Результирующий JSON, как строка

        regionArray = generatorRegions(regionCountMax, regionCountMin, regionCount);    //Генератор регионов.
        carArray = genaratorCars(regionArray, carCountMin, carCountMax);                //Генератор случайных номеров машин на основе существующих регионов
        message = makeJSON(carArray, regionArray, carCountMax, carCountMin);            //Форматтер JSON
        System.out.println(message);
    }

    //Формируем JSON
    private static String makeJSON(List<String> carArray, String[] regionArray, int carCountMax, int carCountMin) {

        JSONObject json = new JSONObject();
        String message;

        for (String region: regionArray){

            JSONObject item = new JSONObject();
            List<String> incomingCar = new ArrayList<>();
            List<String> outcomingCar = new ArrayList<>();
            int countCarINcomeRegion = (int) (Math.random() * ((carCountMax - carCountMin) + 1)) + carCountMin;     //Случайное колво вЪехавших машин
            int countCarOUTcomeRegion = (int) (Math.random() * ((carCountMax - carCountMin) + 1)) + carCountMin;    //Случайное колво вЫехавших машин
            int rnd;

            for (int i = 0; i < countCarINcomeRegion && carArray.size() >= countCarINcomeRegion; i++) {
                rnd = (int) (Math.random() * (carArray.size() - 1));
                incomingCar.add(carArray.get(rnd));
                carArray.remove(rnd);
            }

            for (int i = 0; i < countCarOUTcomeRegion && carArray.size() >= countCarOUTcomeRegion; i++) {
                rnd = (int) (Math.random() * (carArray.size() - 1));
                outcomingCar.add(carArray.get(rnd));
                carArray.remove(rnd);
            }
            item.put("out", outcomingCar);
            item.put("input", incomingCar);
            json.put(region, item);
        }
        message = json.toString();
        return message;
    }

    //Генерирует номера машин
    private static List<String> genaratorCars(String[] regionArray, int carCountMin, int carCountMax) {
        List<String> carArray = new ArrayList<>();

        for (String region : regionArray) {

            int countCarInRegion = (int) (Math.random() * ((carCountMax - carCountMin) + 1)) + carCountMin;

            for (int i = 0; i < countCarInRegion; i++) {
                String numberCar = "" + getRandomChar() + String.valueOf((int) (Math.random() * ((999 - 100) + 1)) + 100)
                        + getRandomChar() + getRandomChar() + region;
                carArray.add(numberCar);
            }
        }
        return carArray;
    }

    //Генерирует регионы
    private static String[] generatorRegions(int regionCountMax, int regionCountMin, int regionCount) {
        String[] regionArray = new String[regionCount];
        //A123AA123 или A123AA12 (Регион не меньше двух знаков)
        for (int i = 0; i < regionCount; i++) {
            int rnd = (int) (Math.random() * ((regionCountMax - regionCountMin) + 1)) + regionCountMin;
            regionArray[i] = (rnd < 10) ? "0" + rnd: "" + rnd;
        }
        return regionArray;
    }

    //Возвращает случайную букву из разрешенных
    public static char getRandomChar() {
        //Ограничения набора кирилитических букв для российских автомобильных номерных знаков
        char[] charsInNumberRUS = new char[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        int rnd = new Random().nextInt(charsInNumberRUS.length);
        return charsInNumberRUS[rnd];
    }
}


///Примерный выхлоп

//       {
//        "541": {
//        "input": ["У247МХ105", "Е963ЕР576", "С808УН160", "К337ЕА333", "О161ХР333", "У847ЕС300", "Р999ТВ804", "М108ЕА105", "Р924АХ160", "А979НХ202", "О962ТТ804", "Т743ТВ105"],
//        "out": ["Н946ВК576", "У146МР26", "Р503СМ160", "К428ХХ202", "А681АС160", "С716ТК541", "Н895ХХ333"]
//        },
//        "333": {
//        "input": ["Х671КТ202", "Е173ЕН576", "Р911УВ536", "Т192РХ576"],
//        "out": ["Х843КР160", "Н963НР26", "Х395ЕР26", "В768ЕК804", "Е703МА804", "Х606РО26", "Е524УО804", "С531НТ26", "У606АА105", "А598ТТ804", "Т650СВ26", "Х947ВО333", "Р978ЕА160", "О321КВ576", "У605ОО804", "В761ВА300", "Х183ТУ576", "Е835НС105", "Е394ТУ333"]
//        },
//        "300": {
//        "input": [],
//        "out": []
//        },
//        "202": {
//        "input": ["К861ОК804", "О641ОМ105", "В282АО333", "С895РВ300"],
//        "out": ["Р307СН536", "Т458ТР300"]
//        },
//        "26": {
//        "input": ["К241КВ105", "С994РЕ26", "Р972НУ105", "С115МХ300", "О814РА804", "А656НО26", "М762НЕ536", "М904ТХ333", "Т760АХ202", "Р156ХМ536", "Р585КХ105", "Т613ТУ300", "У456ЕТ26", "М281МС333", "А322ХМ576", "М910ТУ160", "У643АМ333", "М239ЕО804", "О134ЕК105"],
//        "out": ["А465УХ300", "К423ТУ804", "М142СУ333", "А663НВ333", "Н349СВ576", "Е736АВ26", "О256АС26", "О131ХМ576", "В119АО536"]
//        },
//        "576": {
//        "input": [],
//        "out": []
//        },
//        "105": {
//        "input": ["Р400ТУ105", "Н495СМ160", "Х885КО160", "О797ОВ804"],
//        "out": ["У914СУ202", "Т505МК804", "У891ХК333"]
//        },
//        "536": {
//        "input": ["К518ЕМ804", "С312НТ160", "О726АЕ300", "О785УР160", "М354НВ105", "Х672УМ576", "В198ЕВ202", "Р267СС300", "О709АО202", "Н827ТХ300", "К448ОУ26", "Х701ХК160", "А123ТТ105", "Р775РЕ105", "Н352ВО576", "В812КУ26", "Е330ТК160", "Е121ВК804"],
//        "out": ["Р950СМ804", "К266МК160", "Т251КН105"]
//        },
//        "160": {
//        "input": [],
//        "out": []
//        },
//        "804": {
//        "input": [],
//        "out": ["В741ЕС333", "В720СЕ26", "Е454КО26", "Е562ТО202"]
//        }
//        }