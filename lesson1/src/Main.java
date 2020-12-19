import creations.*;
import creations.Runnable;
import emums.DayOfWeek;
import obstacles.*;

public class Main {
    public static void main(String[] args) {
        Object[] creations = new Object[3];
        creations[0] = new Cat(2, 20);
        creations[1] = new Human(4, 15);
        creations[2] = new Robot(3, 10);

        Object[] obstacles = new Object[4];
        obstacles[0] = new Wall(2);
        obstacles[1] = new RunningWay(10);
        obstacles[2] = new Wall(3);
        obstacles[3] = new RunningWay(15);

        for (Object creation : creations) {
            for (Object obstacle : obstacles) {
                if (obstacle instanceof Wall && !(((Wall) obstacle).obstaclePass((Jumpable) creation))) {
                    break;
                } else if (obstacle instanceof RunningWay && !(((RunningWay) obstacle).obstaclePass((Runnable) creation))) {
                    break;
                }
            }
        }

        System.out.println();
        System.out.println(getWorkingHours(DayOfWeek.Monday));
        System.out.println(getWorkingHours(DayOfWeek.Tuesday));
        System.out.println(getWorkingHours(DayOfWeek.Wednesday));
        System.out.println(getWorkingHours(DayOfWeek.Thursday));
        System.out.println(getWorkingHours(DayOfWeek.Friday));
        System.out.println(getWorkingHours(DayOfWeek.Saturday));
        System.out.println(getWorkingHours(DayOfWeek.Sunday));
    }

    public static String getWorkingHours(DayOfWeek day) {
        return day.ordinal() > 4 ? "Сегодня выходной" : String.valueOf((5 - day.ordinal()) * 8).concat(" рабочих часов до конца недели");

    }
}
