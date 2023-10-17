package ru.ecxeption.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилию Имя Отчество (через пробел): ");
        String[] fio = scanner.nextLine().split(" ");
        checkFio(fio);

        System.out.println("Введите пол (f/m): ");
        String male = scanner.nextLine();
        checkMale(male);

        System.out.println("Введите дату рождения (дд.мм.гггг): ");
        String dateStr = scanner.nextLine();
        checkDate(dateStr);

        System.out.println("Введите номер телефона (цифры без пробелов и знаков): ");

        String phone = scanner.nextLine();
        checkPhone(phone);
         Person person1 = createPerson(fio,dateStr,phone,male);

         file(person1);
    }

    static Person createPerson(String [] fio,String date,String phone, String male) {

        String surname = fio[0];
        String name = fio[1];
        String second_name = fio[2];


        return new Person(name,second_name,surname,male,phone,date);
    }
    static int checkFieldAmount(String[] parts){       // проверяем количество введенных полей
        if (parts.length < 6) {
            return -2;
        }
        if (parts.length > 6) {
            return -3;
        }
        return 1;
    }
    static void resultCheckFieldAmount(int num){    // обрабатываем коды ошибок
        switch (num) {
            case -2:
                System.out.println("Данные введены не полностью");
                return;
            case -3:
                System.out.println("Введены лишние данные");
                return;
            case 1:
                return;
        }
    }
    static void checkFio(String[] fio) {
        if (fio.length != 3) {
            throw new RuntimeException("Неверный ввод ФИО");
        }
        for (int i = 0; i < fio.length; i++) {
            char[] chars = fio[i].toCharArray();
            for (char character : chars) {
                if (Character.isDigit(character)) {
                    throw new RuntimeException("Вы ввели числа");
                }
            }
        }
    }
    static void checkMale(String male) {
        if (male.equalsIgnoreCase("f") || male.equalsIgnoreCase("m")) {
        } else {
            throw new RuntimeException("Неверный формат данных! Введите f или m");
        }
    }

    static void checkPhone(String phone) {
        try {
            long tel = Long.parseLong(phone);
        }  catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Неправильный ввод, введите только цифры");
        }
        int amount = String.valueOf(phone).length();
        if (amount < 10) {
            throw new RuntimeException("Слишком короткий номер телефона ");
        }
    }
    static void checkDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Неверный формат даты (дд.мм.гггг)");
        }
    }
    static void file(Person person) {
        String fileName = person.getSurname();
        File file = new File(fileName);
        try(FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write(person.getSurname() + " ");
            fileWriter.write(person.getName()+ " ");
            fileWriter.write(person.getSecond_name() + " ");
            fileWriter.write(person.getBirthDay() + " ");
            fileWriter.write(person.getPhoneNumber() + " ");
            fileWriter.write(person.getFemale() + " ");
            System.out.println();

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
