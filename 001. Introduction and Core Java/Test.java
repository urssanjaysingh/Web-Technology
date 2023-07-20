public class Test {
    int x = 5;
    public static void welcome() {
        System.out.println("...................");
    }
    public static void main(String args[]) {
        welcome();
        System.out.println("Hi!!! This is my First program");
        Test myObj = new Test();
        System.out.println(myObj.x);
    }
}
