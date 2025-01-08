package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {


    public static int binarySearch(int[] array, int key, int nleft, int nright) {
        if (nleft > nright) return -1;
        int nmid = (nleft + nright) / 2;
        if (array[nmid] == key) {
            return nmid;
        } else if (array[nmid] < key) {
            return binarySearch(array, key, nmid + 1, nright);
        } else {
            return binarySearch(array, key, nleft, nmid - 1);
        }
    }

    public static int binarySearchRecursion(int[] array, int key) {
        int n = array.length;
        return binarySearch(array, key, 0, n - 1);
    }

    public static int binarySearch(int[] array, int key) {
        int n = array.length;
        int nleft = 0;
        int nright = n - 1;
        while (nleft <= nright) {
            int nmid = (nleft + nright) / 2;
            if (array[nmid] == key) {
                return nmid;
            } else if (array[nmid] < key) {
                nleft = nmid + 1;
            } else {
                nright = nmid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        bubbleSort bs = new bubbleSort();
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
        System.out.println("Result index: " + binarySearchRecursion(arr, findElements));
    }
}
