package project.java;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 45_000);
        Date date3 = (Date) date2.clone();
        date3.setTime(date3.getTime() + 10_000);
        Date date4 = Date.from(date1.toInstant());

        System.out.println(date2.after(date1));
        System.out.println(date1.before(date2));
        System.out.println(date1.compareTo(date3));
        System.out.println(date1.compareTo(date4));
        System.out.println(date1.hashCode());
    }
}
