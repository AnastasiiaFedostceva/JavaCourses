package ru.java.courses;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson11to12_SetMap {

    public static class User implements Comparable<User> {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public int compareTo(User o) {
            if (name.equals(o.name)) {
                return Integer.compare(age,o.age);
            }
            return name.compareTo(o.name);
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {
        TreeSet<User> users = new TreeSet<User>(source);
        return users.last();
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {
        Map<String,User> map = new HashMap<String, User>();
        for(User user : source) {
            map.put(user.getPhone(), user);
        }
        return map.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {
        final int maxShellCount=5;
        List<String> orderedBooks = source.stream().sorted().collect(Collectors.toList());
        Map<Integer,List<String>> result = new HashMap<Integer,List<String>>();
        int shellSize=orderedBooks.size()/maxShellCount;
        for(int shellNumber=1;shellNumber<maxShellCount;shellNumber++){
            result.put(shellNumber,orderedBooks.subList((shellNumber-1)*shellSize,shellNumber*shellSize));
        }
        result.put(maxShellCount,orderedBooks.subList((maxShellCount-1)*shellSize,orderedBooks.size()));
        return result;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        Map<String,Integer>  result = new HashMap<String,Integer>();
        for(Map.Entry<Integer,String> entry : source.entrySet()){
            result.put(entry.getValue(),entry.getKey());
        }
        return result;
    }
}