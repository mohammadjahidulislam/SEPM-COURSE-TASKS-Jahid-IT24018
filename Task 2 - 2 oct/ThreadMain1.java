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