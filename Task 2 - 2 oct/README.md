\### Static Count Class



```



class Student {

&#x20;   static int count = 0;



&#x20;   Student() {

&#x20;       count++;

&#x20;   }

}



public class Main {

&#x20;   public static void main(String\[] args) {

&#x20;       Student s1 = new Student();

&#x20;       Student s2 = new Student();

&#x20;       Student s3 = new Student();



&#x20;       System.out.println(Student.count);

&#x20;   }

}



```






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

