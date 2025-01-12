
package Week1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Scanner;

public class LetterAndWordCounter {

    public static void LetterAndWordCounter(String input) {
        // Đếm số lần xuất hiện của từng từ
        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Đếm số lần xuất hiện của từng ký tự
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }

        // Hiển thị kết quả
        System.out.println(wordCount);
        System.out.println(charCount);
    }

    public static void LetterAndWordCounterSplit(String input) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+"); // Tách chuỗi thành mảng từ dựa trên khoảng trắng
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1); // Nếu từ đã tồn tại, tăng giá trị
            } else {
                wordCount.put(word, 1); // Nếu từ chưa tồn tại, thêm từ mới với giá trị 1
            }
        }

        // Đếm ký tự
        Map<Character, Integer> charCount = new HashMap<>();
        char[] chars = input.toCharArray(); // Chuyển chuỗi thành mảng ký tự
        for (char c : chars) {
            if (Character.isLetter(c)) { // Chỉ xử lý ký tự là chữ cái
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) + 1); // Nếu ký tự đã tồn tại, tăng giá trị
                } else {
                    charCount.put(c, 1); // Nếu ký tự chưa tồn tại, thêm ký tự mới với giá trị 1
                }
            }
        }

        // In kết quả
        System.out.println("\nWord Count:");
        System.out.println(wordCount);

        System.out.println("\nCharacter Count:");
        System.out.println(charCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Nhập chuỗi từ người dùng
            System.out.println("Enter your content:");
            String input = scanner.nextLine();

            LetterAndWordCounterSplit(input);


        } catch (Exception e) {
            // Xử lý ngoại lệ
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
