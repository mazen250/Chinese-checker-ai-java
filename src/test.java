import java.util.Scanner;


class student{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;


    public void great(){
        System.out.println("welcome back "+ name +" your age is "+age);
    }

}


public class test {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

//        long startTime = System.currentTimeMillis();
//
//        System.out.print("enter a number ");
//        int number = scanner.nextInt();
//        for(int i=0;i<=number ;i++){
//            System.out.println(i);
//        }
//
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("That took " + ((endTime - startTime)/1000000 ) + " milliseconds");

        student s = new student();
        System.out.println("enter your name ");
        s.setName(scanner.nextLine());
        System.out.println("enter your age");
        s.setAge(scanner.nextInt());
        s.great();
    }
}
