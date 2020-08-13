package main.java.com.yaroslavshchur.executor;

import main.java.com.yaroslavshchur.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Executor {

    public static class UserListMethods {
        private final static String firstCity = "Dnipro";
        private final static String secondCity = "Lviv";
        private final static String thirdCity = "Kyiv";
        private final static int midAge = 40;
        private final static int highAge = 50;


        {
            List<User> list = new ArrayList<>();
            list.add(new User("Vasia", 16, "Dnipro"));
            list.add(new User("Petya", 23, "Dnipro"));
            list.add(new User("Elena", 42, "Lutsk"));
            list.add(new User("Elena", 92, "Chernihiv"));
            list.add(new User("Sergiy", 5, "Kyiv"));
            list.add(new User("Marina", 32, "Kyiv"));
            list.add(new User("Ivan Ivanovich", 69, "Lviv"));
            System.out.println("This is a list of User older than " + midAge);
            getUserOlderAge(list);

            System.out.println("This is a list of User from " + firstCity + " older than " + highAge);
            getUserYoungerAgeFromCity(list, firstCity);

            System.out.println("This is the average age of User from " + secondCity);
            getUserAverageAgeFromCity(list, secondCity);

            System.out.println("This is a list of User not from Kyiv " + thirdCity);
            getUserNotFromCity(list, thirdCity);
        }

        private  List<User> getUserOlderAge(List<User> users) {
            return users.stream()
                    .filter(user -> user.getAge() > midAge)
                    .collect(Collectors.toList());

        }

        private  List<User> getUserYoungerAgeFromCity(List<User> users, String firstCity) {
            return users.stream()
                    .filter(user -> user.getAge() < highAge)
                    .filter(user -> user.getCity().equals(firstCity))
                    .collect(Collectors.toList());
        }

        private  List<User> getUserAverageAgeFromCity(List<User> users, String secondCity) {


            return users.stream()
                    .filter(user -> user.getCity().equals(secondCity))
                    .collect(Collectors.toList());
        }


        private List<User>getUserNotFromCity(List<User> users, String thirdCity) {
                    return users.stream()
                            .filter(user -> !user.getCity().equals(thirdCity))
                            .collect(Collectors.toList());
        }

        private  List<User> getSortedByAge(List<User> users, int count) {

            return users.stream()
                    .sorted(Comparator.comparingInt(User::getAge))
                    .limit(count)
                   .collect(Collectors.toList());

        }
    }
    public void start() {
        List<User> userList = new ArrayList<>();
        List<User> usersOlderForty = getUserOlderAge(userList, 40);
        System.out.println("User older 40:");
        usersOlderForty.forEach(System.out::println);
    }

    private List<User> getUserOlderAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());

    }
}
