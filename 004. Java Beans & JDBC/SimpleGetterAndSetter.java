public class SimpleGetterAndSetter {
    private int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int num) {
        this.number = num;
    }

    public static void main(String args[]) {
        SimpleGetterAndSetter obj = new SimpleGetterAndSetter();
        obj.setNumber(10);
        System.out.println(obj.getNumber());
    }
}
