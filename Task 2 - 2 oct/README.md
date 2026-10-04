Task 1.......


class Student {
    static int count = 0;

    Student() {
        count++;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println(Student.count);
    }
}
<img width="1187" height="157" alt="task 1 ss" src="https://github.com/user-attachments/assets/fb17f397-6218-417d-a032-c37f68c0dcaf" />

Task 2 .......


public class ThreadMain {

    public static void main(String[] args) {

        CookingTask task1 = new CookingTask("Cooking");
        CookingTask task2 = new CookingTask("Washing");
        CookingTask task3 = new CookingTask("Cleaning");

        task1.start();
        task2.start();
        task3.start();
    }
}


class CookingTask extends Thread {

    private String taskName;

    // ONE copy shared by ALL CookingTask objects
    static int staticCount = 0;

    // ONE copy for EACH CookingTask object
    int nonStaticCount = 0;


    public CookingTask(String taskName) {
        this.taskName = taskName;
    }


    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        for (;;) {

            // Increase both counters
            staticCount++;
            nonStaticCount++;

            System.out.println(
                    Thread.currentThread().getName()
                    + " | " + taskName
                    + " | Static Count = " + staticCount
                    + " | Non-Static Count = " + nonStaticCount
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            // Stop after approximately 10 seconds
            if (System.currentTimeMillis() - startTime >= 10_000) {
                break;
            }
        }

        System.out.println(
                taskName + " finished. "
                + "Final Non-Static Count = " + nonStaticCount
        );
    }
}
<img width="1220" height="845" alt="Screenshot 2026-10-04 222933" src="https://github.com/user-attachments/assets/c93b01fb-59f4-4ac8-abd2-48d04bfbe7ce" />




task2 using run().....

public class ThreadMain1 {

    public static void main(String[] args) {

        CookingTask task1 = new CookingTask("Cooking");
        CookingTask task2 = new CookingTask("Washing");
        CookingTask task3 = new CookingTask("Cleaning");

        task1.run();
        task2.run();
        task3.run();
    }
}

class CookingTask extends Thread {

    private String taskName;

    static int staticCount = 0;
    int nonStaticCount = 0;

    public CookingTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        long startTime = System.currentTimeMillis();

        for (;;) {

            staticCount++;
            nonStaticCount++;

            System.out.println(
                Thread.currentThread().getName()
                + " | " + taskName
                + " | Static Count = " + staticCount
                + " | Non-Static Count = " + nonStaticCount
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

            if (System.currentTimeMillis() - startTime >= 10_000) {
                break;
            }
        }

        System.out.println(
            taskName + " finished. "
            + "Final Non-Static Count = " + nonStaticCount
        );
    }
}
<img width="1211" height="841" alt="task 2 using run ()" src="https://github.com/user-attachments/assets/50343c18-f09f-4129-b15a-3d3b3106e9da" />




