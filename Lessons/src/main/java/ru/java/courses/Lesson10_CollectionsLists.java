package ru.java.courses;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson10_CollectionsLists {

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем список чисел
     * 2. Удаляем все дубли
     * 3. Сортируем список по возрастанию
     * 4. Преобразуем числа в строки
     * <p>
     * Подсказки:
     * Collections.sort() - сортировка
     * Удалять элементы из итерируемого списка нельзя - выпадет исключение
     */
    public static List<String> task1(List<Integer> source) {
        return source.stream().distinct().sorted().map( i -> i.toString()).collect(Collectors.toList());
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. Получаем на входе массив чисел
     * 2. Преобразовываем его к списку
     * 4. Все четные числа увеличиваем на единицу
     * 5. Возвращаем кусок списка с 3-го по 7-й элемент
     * <p>
     * Подсказка: на входе может быть любое количество чисел
     */
    public static List<Integer> task2(Integer... array) {
        List<Integer> list = Arrays.asList(array);
        for(int i=0; i < list.size(); i++){
            int current = list.get(i);
            if (current%2 == 0) {
                list.set(i, current+1);
            }
        }

        int size=list.size();
        if (size < 4){
            return null;
        }
        else if (size < 8){
            return list.subList(3,size);//3<=x<size
        }
        else {
            return list.subList(3,8);// 3<=x<8
        }
    }
}