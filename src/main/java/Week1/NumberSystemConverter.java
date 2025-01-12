package Week1;

import java.util.Scanner;

public class NumberSystemConverter {

    // Phương thức chọn hệ cơ số (2, 10, 16)
    public static int chooseBase(String prompt) {
        Scanner sc = new Scanner(System.in);
        int base;
        do {
            System.out.println(prompt);
            System.out.println("1: Binary (2)");
            System.out.println("2: Decimal (10)");
            System.out.println("3: Hexadecimal (16)");
            base = sc.nextInt();
        } while (base < 1 || base > 3);

        // Sử dụng switch-case để trả về giá trị hệ cơ số
        switch (base) {
            case 1:
                return 2;  // Binary
            case 2:
                return 10; // Decimal
            case 3:
                return 16; // Hexadecimal
            default:
                throw new IllegalStateException("Unexpected value: " + base);
        }
    }


    // Phương thức nhập giá trị đầu vào
    public static String getInputValue(int inputBase) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value in base " + inputBase + ": ");
        return sc.next();
    }

    // Phương thức chuyển đổi giữa các hệ cơ số
    public static String convertBase(String inputValue, int inputBase, int outputBase) {
        // Chuyển inputValue từ hệ cơ số nhập về hệ cơ số 10
        int decimalValue = Integer.parseInt(inputValue, inputBase);

        // Chuyển từ hệ cơ số 10 sang hệ cơ số xuất
        if (outputBase == 2) {
            return Integer.toBinaryString(decimalValue);
        } else if (outputBase == 16) {
            return Integer.toHexString(decimalValue).toUpperCase();
        } else {
            return String.valueOf(decimalValue);
        }
    }

    // Phương thức hiển thị kết quả
    public static void displayResult(String inputValue, int inputBase, int outputBase, String outputValue) {
        System.out.println("Value " + inputValue + " in base " + inputBase +
                " is equivalent to " + outputValue + " in base " + outputBase);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;

        do {
            System.out.println("=== Number System Converter ===");
            int inputBase = chooseBase("Choose the input base system:");
            int outputBase = chooseBase("Choose the output base system:");
            String inputValue = getInputValue(inputBase);

            try {
                String outputValue = convertBase(inputValue, inputBase, outputBase);
                displayResult(inputValue, inputBase, outputBase, outputValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for the selected base system. Please try again.");
            }

            System.out.println("Do you want to continue? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("yes")) {
                continueProgram = true;
            } else {
                continueProgram = false;
            }
        } while (continueProgram);

        System.out.println("Program terminated.");
    }
}
