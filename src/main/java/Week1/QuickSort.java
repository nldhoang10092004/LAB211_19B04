package Week1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {

    /**
     * Hàm sắp xếp QuickSort
     *
     * @param arr Mảng cần sắp xếp
     * @param low Chỉ số bắt đầu
     * @param high Chỉ số kết thúc
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Tìm chỉ số phân vùng (partition index)
            int partitionIndex = partition(arr, low, high);

            // Đệ quy sắp xếp hai mảng con
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Hàm phân vùng (Partition)
     *
     * @param arr Mảng cần phân vùng
     * @param low Chỉ số bắt đầu
     * @param high Chỉ số kết thúc
     * @return Vị trí của phần tử pivot
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Chọn phần tử cuối làm pivot
        int i = low - 1; // Vị trí của phần tử nhỏ hơn pivot

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Hoán đổi arr[i+1] và pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Trả về vị trí của pivot
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
            System.out.println("Invalid input: " + e.getMessage());
            return; // Thoát nếu có lỗi
        }

        // Tạo mảng ngẫu nhiên với độ dài đã nhập
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = (int) (Math.random() * 100); // Giá trị ngẫu nhiên từ 0 đến 99
        }

        // Hiển thị mảng trước khi sắp xếp
        System.out.println("Input array: " + Arrays.toString(arr));

        // Thực hiện QuickSort
        quickSort(arr, 0, arr.length - 1);

        // Hiển thị mảng sau khi sắp xếp
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Đóng Scanner
        sc.close();
    }
}

