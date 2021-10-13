

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm {
    private float b;
    private int size;

    public Algorithm() {}

//    public Algorithm(float[] a) {
//        size = a.length;
//        float[] b = new float[size];
//        for (int i = 0; i < size; i++){
//            b[i] = a[i];
//        }
//    }

    //1. Write data from array to file
    public static void writeFile(float a[], String nameFile) throws IOException {
        String linkFile = "D:\\Users\\Asus\\IdeaProjects\\AlgorithmSort\\FileTxt\\" + nameFile;
        FileWriter out = null;

        try {
            out = new FileWriter(linkFile);
            float valueArray;
            for (int i = 0; i < a.length; i++) {
                valueArray = a[i];
                out.write(valueArray + " ");
            }
            System.out.println("Successfully wrote to the file.");
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    public static void writeFile(float value , int indexSearch, String nameFile) {
        String linkFile = "D:\\Users\\Asus\\IdeaProjects\\AlgorithmSort\\FileTxt\\" + nameFile;
        FileWriter myWrite;
        try {
            myWrite = new FileWriter(linkFile);
            myWrite.write("The value " + value + " in Array has an index :" + indexSearch);
            myWrite.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2. Read data from file to array
    public static float[] readFile(int size) {
        float[] b = new float[size];
        String linkFile = "D:\\Users\\Asus\\IdeaProjects\\AlgorithmSort\\FileTxt\\INPUT.TXT";
        File file;
        try {
            file = new File(linkFile);
            Scanner myReader = new Scanner(file);
            int i = 0;
            while (myReader.hasNext()){
               b[i] = Float.parseFloat(myReader.next());
               i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        display(b);
        return b;
    }

    //3. Sort by Bubble Sort
    public static void bubbleSort(float a[]) throws IOException {
        int size = a.length;
        float[] b = new float[size];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }
        for(int i = 0; i < size - 1 ; i++){
            for (int j = 0; j < size - i -1; j ++){
                int k = j + 1;
                if (b[j] > b[k]) {
                    swap(j, k, b);
                    display(b);
                }
            }
            //On when review
            //display(b);
        }
        writeFile(b, "OUTPUT1.TXT");
    }

    //4. Sort by Selection Sort
    public static void selectionSort(float a[]) throws IOException {
        int size = a.length;
        float[] b = new float[size];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }

        for (int i = 0; i < size -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size ; j++) {
                if (b[minIndex] > b[j]) {
                    minIndex = j;
                }
            }
            swap(minIndex, i, b);
            //On when riview
            display(b);
        }
        writeFile(b, "OUTPUT2.TXT");
    }

    //5. Sort by Insertion Sort
    public static void insertionSort(float a[]) throws IOException {
        int size = a.length;
        float[] b = new float[size];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }

        for (int i = 1; i < size; i++) {
            int j = i - 1;
            float current = b[i];
            while (j >= 0 && b[j] > current) {
                b[j + 1] = b[j];
                b[j] = current;
                j--;
            }
            display(b);
        }
        writeFile(b, "OUTPUT3.TXT");
    }

    //6. Search by Linear Search algorith:
    public static void search(float a[], float value) {
        int index = -1;
        int size = a.length;
        float[] b = new float[size];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }
        for (int i = 0; i < size; i++){
            if (b[i] == value) {
                index = i;
                System.out.println("Index of value " + value + " is " + index);
                writeFile(value, index, "OUTPUT4.TXT");
            }
        }
        if (index == -1) {
            System.out.println(value + " not in Array");
        }

    }

    //7. Search by binary Search algorith
    public static void binarySearch(float a[], int low, int  high, float value) {
        int index = -1;
        int size = a.length;
        float[] b = new float[size];
        for (int i = 0; i < size; i++){
            b[i] = a[i];
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j ++) {
                int k = j + 1;
                if(b[j] > b[k]) {
                    swap(j, k, b);
                }
            }
        }
        display(b);

        while (index == -1 && high >= low) {
            int indexBettwen = low + (high - low) / 2;
            if (b[indexBettwen] == value) {
                index = indexBettwen;
                System.out.println("Index of value " + value + " is " + index);
                writeFile(value, index, "OUTPUT5.TXT");
            }else if ( value < b[indexBettwen]) {
                high = indexBettwen - 1;
            }else if (b[indexBettwen] < value) {
                low = indexBettwen + 1;
            }
        }
        if (index == -1) {
            System.out.println(value + " not in Array");
        }
    }

    //Display array
    public static void display(float[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }

    //sub bubble sort and select sort
    public static void swap(int i, int k, float[] b){
        float x = b[i];
        b[i] = b[k];
        b[k] = x;
    }
}

