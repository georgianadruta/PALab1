package compulsory;

public class Operations {

    public int sumDigits(int number) {
        // Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.

        int sum = 0;
        while (number > 0 || sum > 9) {
            if (number == 0) {
                number = sum;
                sum = 0;
            }
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public int operations() {
        int nr = (int) (Math.random() * 1_000_000); // Generate a random integer n
        nr *= 3; //  Multiply n by 3
        String binaryString = "10101";
        int decimal = Integer.parseInt(binaryString, 2);
        nr += decimal; //  Add the binary number 10101 to the result
        String hexString = "FF";
        int hexa = Integer.parseInt(hexString, 16);
        nr += hexa; // Add the hexadecimal number FF to the result
        nr *= 6; // Multiply the result by 6
        return nr;
    }
}
