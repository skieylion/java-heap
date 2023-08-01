package project.java;

import java.util.Date;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        String[] array = TimeZone.getAvailableIDs();
        System.out.println(array[0]);//Africa/Abidjan
        System.out.println(array[1]);//Africa/Accra
        String[] arrayOffset = TimeZone.getAvailableIDs(3 * 60 * 60 * 1000);
        System.out.println(arrayOffset[0]);//Europe/Moscow ...
        System.out.println(TimeZone.getDefault().getID());//Asia/Yekaterinburg
        System.out.println(TimeZone.getDefault().getDisplayName());//Екатеринбург, стандартное время
        System.out.println(TimeZone.getDefault().getDisplayName(true, TimeZone.SHORT));//YEKST
        //смещение в текущем часовом поясе
        System.out.println(TimeZone.getDefault().getRawOffset() / 1000 / 60 / 60);//5
        //какое количество мс используется для прибавки летнего времени
        System.out.println(TimeZone.getTimeZone("Europe/Paris").getDSTSavings());//1 hour
        //есть ли летнее время
        System.out.println(TimeZone.getTimeZone("Europe/Paris").observesDaylightTime());
        System.out.println(TimeZone.getDefault().getOffset(new Date().getTime()) / 1000 / 60 / 60);//5
        //действует ли летнее время в дате
        System.out.println(TimeZone.getTimeZone("Europe/Paris").inDaylightTime(new Date()));
        //используется ли летнее время в текущем году
        System.out.println(TimeZone.getTimeZone("Europe/Paris").useDaylightTime());
    }
}
