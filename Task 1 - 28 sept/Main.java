public class Main {

    static int count = 0;
    int nonStaticCount = 0;

    Main() {
        count++;
        nonStaticCount++;
    }

    static class CookingTask extends Thread {

        String taskName;

        CookingTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(taskName + " -> This is a cooking task");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main obj1 = new Main();
        Main obj2 = new Main();
        Main obj3 = new Main();

        System.out.println("Static Count = " + count);

        System.out.println("Obj1 Non-Static Count = " + obj1.nonStaticCount);
        System.out.println("Obj2 Non-Static Count = " + obj2.nonStaticCount);
        System.out.println("Obj3 Non-Static Count = " + obj3.nonStaticCount);

        Thread t1 = new CookingTask("Task 1");
        Thread t2 = new CookingTask("Task 2");
        Thread t3 = new CookingTask("Task 3");

        t1.start();
        t2.start();
        t3.start();
    }
}