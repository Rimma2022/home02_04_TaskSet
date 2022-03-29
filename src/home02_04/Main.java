package home02_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static HashSet<User> userNamesPassword = new HashSet<>();

    public static void addNewLogin_1 () throws IOException {
        System.out.println("Введите имя");
        String userName = reader.readLine();
        System.out.println("Введите пароль");
        String password = reader.readLine();
        if (userNamesPassword.add(new User(userName, password))) {
            System.out.println("Пользователь успешо добавлен");
        } else {
            System.out.println("Имя пользователя существует");
        }
        System.out.println(userNamesPassword);
    }

    public static void removeName_2 () throws IOException {
        System.out.println("Введите имя пользователя, которого нужно удалить");
        String userName = reader.readLine();
        if (userNamesPassword.removeIf(y -> userName.equals(y.getName()))) {
            System.out.println("Пользователь успешо удален");
        } else {
            System.out.println("Данный пользователь не зарегистрирован");
        }
    }

    public static void findName_3 () throws IOException {
        System.out.println("Введите имя пользователя, которого нужно найти");
        String userName = reader.readLine();
        if (userNamesPassword.contains(userName)) {
            System.out.println("Пользователь cуществует");
        } else {
            System.out.println("Данный пользователь не зарегистрирован");
        }
    }

    public static void changeName_4 () throws IOException {
        System.out.println("Введите имя пользователя, которого нужно изменить");
        String userName = reader.readLine();
        System.out.println("Введите пароль");
        String password1 = reader.readLine();
        if (userNamesPassword.removeIf(y -> userName.equals(y.getName()) && password1.equals(y.getPassword()))  ) {
            System.out.println("Введите новое имя пользователя");
            String userName1 = reader.readLine();
            userNamesPassword.add(new User(userName1, password1));
            System.out.println("Имя успешно изменено");
            System.out.println(userNamesPassword);
        } else {
            System.out.println("Данный пользователь не зарегистрирован или введен неверный пароль");
        }
    }

    public static void changePassword_5 () throws IOException {
        System.out.println("Введите имя пользователя, у которого нужно изменить пароль");
        String userName = reader.readLine();
        System.out.println("Введите старый пароль");
        String password = reader.readLine();
        if (userNamesPassword.removeIf(y -> password.equals(y.getPassword()) && userName.equals(y.getName()))) {
            System.out.println("Введите новый пароль");
            String password1 = reader.readLine();
            userNamesPassword.add(new User(userName, password1));
            System.out.println("Пароль успешно изменен");
            System.out.println(userNamesPassword);
        } else {
            System.out.println("Неверные пароль или имя");
        }
    }

    public static void main(String[] args) throws IOException {
        Integer X;
        do {
            System.out.println("0.Выход;\n1.Добавить нового пользователя;\n2.Удалить существующего пользователя" +
                    "\n3.Проверить существует ли пользователь;\n4.Изменить логин существующего пользователя;\n5.Изменить пароль существующего пользователя");
            String x = reader.readLine();
            X = Integer.parseInt(x);
            switch (X) {
                case 1: {
                    addNewLogin_1 ();
                    break;
                }
                case 2: {
                    removeName_2 ();
                    break;
                }
                case 3: {
                    findName_3 ();
                    break;
                }
                case 4: {
                    changeName_4 ();
                    break;
                }
                case 5: {
                    changePassword_5 ();
                    break;
                }
                case 0: {
                    System.out.println("END.");
                    break;
                }
                default: {
                    System.out.println("Неверное значение: " + X);
                    X = 0;
                }
            }
        } while (X != 0);
    }

}




