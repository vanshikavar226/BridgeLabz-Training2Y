public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // Exception
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled!");
        }
    }

    public static void main(String[] args) {
        // generateException();  // Uncomment to see crash
        handleException();
    }
}