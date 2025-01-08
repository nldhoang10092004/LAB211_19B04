/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Week1;

/**
 * @author LOQ
 */

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class bubbleSort {

    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
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
            //If no swap done than break loop
            if (swapped == false)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = sc.nextInt();
        //handle input <0 /  char
        int arr[] = new int[arrayLength];
        //Random array value
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = (int) Math.floor(Math.random() * arrayLength);
        }
        System.out.println("Input array: " + Arrays.toString(arr));
        //Display Result
        System.out.println("Result array: " + Arrays.toString(bubbleSort(arr)));
    }
}
