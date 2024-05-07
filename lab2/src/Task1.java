import java.util.*;
/*
Пусть даны n заявок на проведение в одной и тоже аудитории.
Два различных занятия не могут перекрываться по времени.
В каждой заявке указаны начало и конец занятия.
Разные заявки могут пересекаться, и тогда можно удволетворить
только одну из них. Необходимо набрать максимальное количество
совместимых друг с другом заявок
n * log(n)
*/


public class Task1 {
    public static void main(String[] args) {
        boolean user = false;
        if (!user) {
            Random rand = new Random();
            for (int i = 10; i < 1000001; i += 100000) {
                int m = i;
                List<Activity> activities = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int l = rand.nextInt(i);
                    int r = rand.nextInt(i);
                    activities.add(new Activity(l, r));
                }
                long startTime = System.currentTimeMillis();
                solve(activities);
                System.out.println(i + ";" + (System.currentTimeMillis() - startTime));
            }
        } else {
            Scanner sc = new Scanner(System.in);
            List<Activity> activities = new ArrayList<>();

            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                activities.add(new Activity(l, r));
            }
            System.out.println(solve(activities));

        }


    }

    public static int solve(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.r)); // n log(n)
        int count = 0, last = 0;
        for (Activity activity : activities) {
            if (activity.l >= last) {
                last = activity.r;
                count++;
            }
        }
        return count;
    }

    private static class Activity {
        int l;
        int r;

        public Activity(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
