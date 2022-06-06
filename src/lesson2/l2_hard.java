package lesson2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Экспертный уровень
//Задача №1
//Создать метод маскирования персональных данных, который:
//Телефон (до/после маскирования): 79991113344 / 7999***3344
//Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
//Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
//
//Входящие параметры: String text
//Возвращаемый результат: String
//
//Примеры возможного текста:
//<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client> - "<client>(Какие то данные)<data>7999***3344;tes*@******.ru;И****в Иван И.</data></client>"
//<client>(Какие то данные)<data></data></client> - вернет тоже (никаких ошибок)
//<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client> - "<client>(Какие то данные)<data>И****в Иван И.;7999***3344</data></client>"

//Используемые технологии: String.find, String.replaceAll, String.split, String.join, String.contains, String.substring
//Регулярные выражения, класс StringBuilder

public class l2_hard {

    private static String tagFirst = "<data>";
    private static String tagLast = "</data>";
    private static String regex = tagFirst+"(.+?)"+ tagLast;

    public static void main(String[] args) {

        //String incomingData = "<client>(Какие то данные)<data></data></client>";
        //String incomingData = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        //String incomingData = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        //String incomingData = "<client>(Какие то данные)<data>test@yandex.ru;79991113344;Иванов Иван Иванович</data></client>";
        String incomingData = "<client>(Какие то данные)<data>test@yandex.ru;79991113344;Иванов Иван Иванович Ибн-Аглы</data></client>";

        parserPersonalData(incomingData);
    }

    public static void parserPersonalData(String incomingData) {

        String[] incomingDataArr = incomingData.split(tagFirst+"|"+ tagLast);

        //Проверка на корректность входящих данных
        //Принимаем, как условие, что всегда есть блок <data></data>
        if (incomingDataArr.length != 3) {
            System.out.println("Не корректные входящие данные");
            System.exit(0);
        }

        //Если блок <data> пустой возвращаем входящие данные без изменений
        //Сплитим с условностью, что данные в блоке <data> всегда через ;
        //Отправляем на определение типа и на маскарад
        if (!incomingDataArr[1].equals("")) {
            String[] personalDataArray = incomingDataArr[1].split(";");
            StringBuilder sb = new StringBuilder(incomingDataArr[0] + tagFirst);
            for (int i = 0; i < personalDataArray.length; i++) {

                String mascaradedString = initializationOfPersonalDataType(personalDataArray[i]);
                sb.append(mascaradedString);
                if (i != personalDataArray.length - 1) {
                    sb.append(";");
                }
            }
            sb.append(tagLast + incomingDataArr[incomingDataArr.length - 1]);
            System.out.println(sb);
        } else {
            System.out.println(incomingData);
        }
    }

    //Определяем тип входящих данных (телефон, email, ИмяФамилия)
    //По типу отправляем на маскарад
    public static String initializationOfPersonalDataType(String personalData) {

        Pattern pattern = Pattern.compile(".*@.*", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(personalData);
        if (matcher.find()) {
            return mascarading(personalData, TypeOfPersonalData.EMAIL);
        } else {
            //Условность: Телефон всегда равен 11 знаков
            pattern = Pattern.compile("\\d{11}", Pattern.DOTALL);
            matcher = pattern.matcher(personalData);
            if (matcher.find()) {
                return mascarading(personalData, TypeOfPersonalData.PHONE);
            } else {
                return mascarading(personalData, TypeOfPersonalData.NAME);
            }
        }
    }

    public static String mascarading(String personalData, TypeOfPersonalData typeOfPersonalData) {
        //7999***3344;tes*@******.ru;И****в Иван И.

        if (typeOfPersonalData == TypeOfPersonalData.EMAIL) {
            String[] emailNameDomainArr = personalData.split("@");
            String emailNameRepalased = emailNameDomainArr[0].replaceAll(".$", "*");
            String[] emailDomainArr = emailNameDomainArr[1].split("\\.");
            String asteriks = "*".repeat(emailDomainArr[0].length());
            String emailDomainReplased = emailDomainArr[0].replaceAll(emailDomainArr[0], asteriks);
            return emailNameRepalased + "@" + emailDomainReplased + "." + emailDomainArr[1];
        } else if (typeOfPersonalData == TypeOfPersonalData.PHONE) {
            return personalData.substring(0, 4) + "***" + personalData.substring(8, personalData.length());
        } else if (typeOfPersonalData == TypeOfPersonalData.NAME) {
            String[] nameArray = personalData.split(" ");
            String[] returnArrayName = new String[nameArray.length];

            //Первое слово - всегда фамилия. Скрываю все символы, кроме первого и последнего
            for (int i = 0; i < nameArray.length; i++) {
                switch (i) {
                    case 0: {
                        //Фамилия
                        String lastName = nameArray[i].charAt(0) + "*".repeat(nameArray[i].length() - 2) + nameArray[i].substring(nameArray[i].length() - 1, nameArray[0].length());
                        returnArrayName[i] = lastName;
                        break;
                    }
                    case 1: {
                        //Имя
                        returnArrayName[i] = nameArray[i];
                        break;
                    }
                    default: {
                        //Условных отчеств может быть много.
                        returnArrayName[i] = nameArray[i].charAt(0) + ".";
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < returnArrayName.length; i++) {
                sb.append(returnArrayName[i]);

                if (i != returnArrayName.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        return "";
    }

    enum TypeOfPersonalData {
        EMAIL,
        NAME,
        PHONE
    }
}
