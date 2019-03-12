package ru.java.courses;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

class Lesson2 {

    /**
     * Нужно реализовать формулу y = √(13x + 13/x)
     * Подсказка: квадратный корень вычисляется функцией Math.sqrt()
     *
     * @param x на текущем этапе входное значение будет больше нуля
     * @return возвращаем только целую часть от полученного результата,
     * хвост отбрасываем без откругления
     */


    static int formula(int x) {
        Double y =(Math.sqrt (13*x + 13/x));
        return y.intValue();
    }

    /**
     * Нужно привести строку с полным именем к инициалам.
     * Например, "Иванов Петр Александрович" → "И.П.А."
     * Подсказка:
     * разделение строки на части: .split(" ");
     * получение символа на определенной позиции: .charAt();
     * приведение к верхнему регистру: .toUpperCase();
     *
     * @param fullName на текущем этапе имена будут состоять из имени, фамили и отчества, разделяться пробелами.
     *                 Регистр букв во входном параметре может быть любым.
     * @return возвращаем инициалы в верхнем регистре разделенные точкой, как в примере выше
     */
    static String initials(String fullName) {
        String[] shortName = fullName.split(" ");
        String initName = shortName[0].charAt(0) + ". " + shortName[1].charAt(0) + ". " + shortName[2].charAt(0) + ".";
        return initName;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter x");
        int y;
        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        System.out.println (formula (y));

        System.out.println("Enter full name");
        String fullName;
        Scanner name = new Scanner (System.in);
        fullName = name.nextLine();
        System.out.print(initials (initials(fullName.toUpperCase())));



    }
}

