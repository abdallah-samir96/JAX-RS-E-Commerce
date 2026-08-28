package iti;

public class App {
public static void main(String[] args) {
    var envs = System.getenv();
    envs.forEach((k, v) -> {
        System.out.printf("%s = %s %n", k, v);
    });
    System.out.println();
}
}