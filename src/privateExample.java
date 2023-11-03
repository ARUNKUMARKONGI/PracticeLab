public class privateExample {
    private int data;  // Private member

    public privateExample(int initialValue) {
        this.data = initialValue;
    }

    public void udf() {
        // Attempting to access privateData directly will result in a compilation error
       // data=47;  // This line will not compile
        int value=data;
        System.out.println("Value from userDefinedFunction: " + value);
    }

    public static void main(String[] args) {
        privateExample obj = new privateExample(42);
        obj.udf();  // This will result in a compilation error
    }
}
