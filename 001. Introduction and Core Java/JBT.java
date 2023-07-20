class JBT {

    JBT() {
        this("JBT");
        System.out.println("Inside Constructor without parameter");
    }

    JBT(String str) {
        System.out.println("Inside Constructor with String parameter as " + str);
    }
    
    public static void main(String[] args) {
        JBT obj = new JBT();
    }
}
