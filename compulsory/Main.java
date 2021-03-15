package compulsory;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        Operations op=new Operations();
        int number=op.operations();
        int result = op.sumDigits(number);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + "."); // Display on the screen the message
    }
}
