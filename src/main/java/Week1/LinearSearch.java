package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

    // Phương thức static thực hiện tìm kiếm tuyến tính
    public static int linearSearch(int[] array, int searchValue) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return i; // Trả về chỉ số nếu tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        Scanner sc = new Scanner(System.in);
        int arrayLength, findElements;
        try {
            System.out.println("Enter array length: ");
            arrayLength = sc.nextInt(); // Nhập giá trị cho arrayLength
            System.out.println("Enter find elements: ");
            findElements = sc.nextInt(); // Nhập giá trị cho findElements

            // Validate cả hai biến
            if (arrayLength <= 0 || findElements <= 0) {
                throw new IllegalArgumentException("Both inputs must be positive integers!");
            }
        } catch (Exception e) {
            // Bắt lỗi cả IllegalArgumentException lẫn lỗi nhập sai kiểu dữ liệu
            System.out.println("Invalid input: " + e.getMessage());
            return; // Thoát nếu có lỗi
        }


        int arr[] = new int[arrayLength];
        //Random array value
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = (int) Math.floor(Math.random() * arrayLength);
        }
        System.out.println("Sorted array: " + Arrays.toString(bs.bubbleSort(arr)));
        System.out.println("Result index: " + linearSearch(arr, findElements));
    }
}
