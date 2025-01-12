/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Week1;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class BubbleSort {

    /**
     * Hàm thực hiện sắp xếp nổi bọt (Bubble Sort) trên mảng.
     *
     * @param arr Mảng đầu vào
     * @return Mảng sau khi sắp xếp
     */
    public static int[] bubbleSort(int[] arr) {
        int temp;
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Nếu không có hoán đổi nào, thoát vòng lặp
            if (!swapped)
                break;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;

        try {
            // Hỏi người dùng nhập độ dài mảng
            System.out.print("Enter array length: ");
            arrayLength = sc.nextInt();

            // Kiểm tra giá trị nhập vào
            if (arrayLength <= 0) {
                throw new IllegalArgumentException("Array length must be a positive integer!");
            }

        } catch (Exception e) {
            // Bắt lỗi cả khi nhập sai kiểu dữ liệu hoặc giá trị không hợp lệ
            System.out.println("Invalid input: " + e.getMessage());
            return; // Thoát chương trình nếu lỗi xảy ra
        }

        // Tạo mảng ngẫu nhiên với độ dài đã nhập
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = (int) Math.floor(Math.random() * arrayLength); // Giá trị ngẫu nhiên từ 0 đến arrayLength - 1
        }

        // Hiển thị mảng trước khi sắp xếp
        System.out.println("Input array: " + Arrays.toString(arr));

        // Sắp xếp mảng và hiển thị kết quả
        int[] sortedArray = bubbleSort(arr);
        System.out.println("Result array: " + Arrays.toString(sortedArray));

        // Đóng Scanner
        sc.close();
    }
}
