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

