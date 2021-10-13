import java.io.IOException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_Sort {

    public static Scanner sc = new Scanner(System.in);
    public static int n;
    public static Algorithm algorithm = new Algorithm();
    public static float[] a;

    public static void main(String[] args) throws IOException {
        //Vòng lặp điều khiển trương trình
        while (true) {
            System.out.println("+-------------------Menu--------------------+");
            System.out.println("|      1.Input                              |");
            System.out.println("|      2.Out                                |");
            System.out.println("|      3.Bubble sort                        |");
            System.out.println("|      4.Selection sort                     |");
            System.out.println("|      5 Insertion sort t                   |");
            System.out.println("|      6.Search > value                     |");
            System.out.println("|      7.Search = value                     |");
            System.out.println("|      8.Creater file of numbers            |");
            System.out.println("|      0.Exit                               |");
            System.out.println("+-------------------------------------------+");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Choice 0.");
                System.out.println("Exit. Have a good day!");
                break;
            }
            switch (choice) {
                case 1: input();
                    System.out.println();
                    break;
                case 2: output();
                    System.out.println();
                    break;
                case 3: bubbleSort();
                    System.out.println();
                    break;
                case 4: selectionSort();
                    System.out.println();
                    break;
                case 5: insertionSort();
                    System.out.println();
                    break;
                case 6: linearSearch();
                    System.out.println();
                    break;
                case 7: binarySearch();
                    System.out.println();
                    break;
                case 8: createrFileNumber();
                    break;
                default: System.out.println("**Invalid choice. Try again.**");

            }

        }

    }

    //Input -- choice one
    public static void input () throws IOException {
        System.out.println("Choice: 1");
        System.out.print("Input number of elements: ");
        n = sc.nextInt();
        float arrayInput[] = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input element: " + i + " is ");
            float value = sc.nextFloat();
            arrayInput[i] = value;
        }
        algorithm.writeFile(arrayInput, "INPUT.TXT");
        System.out.println();
    }

    //Output - choice two
    public static void output() {
        System.out.println("Choice 2");
        System.out.println("Read from file");
        System.out.print("Array a:  ");
        a = algorithm.readFile(n);
    }

    //Bubble sort - choice three
    public static void bubbleSort() throws IOException {
        System.out.println("Choice 3.");
        System.out.println("Bubble sort");
        long start = System.nanoTime();
        algorithm.bubbleSort(a);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println(time);
    }

    //Select sort - choice four
    public static void selectionSort() throws IOException {
        System.out.println("Choice four");
        System.out.println("Select sort");
        long start = System.nanoTime();
        algorithm.selectionSort(a);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println(time);
    }

    //Insertion sort choice five
    public static void insertionSort() throws IOException {
        System.out.println("Choice five");
        System.out.println("Insertion sort");
        long start = System.nanoTime();
        algorithm.insertionSort(a);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println(time);
    }

    //Linear Search choice six
    public static void linearSearch() {
        System.out.println("Choice five");
        System.out.println("Insertion sort");
        System.out.print("input value : ");
        float value = sc.nextFloat();
        algorithm.search(a, value);
    }

    //Binary Search Choice seven
    public static void binarySearch() {
        System.out.println("Choice seven");
        System.out.println("Binary sort");
        System.out.print("input value : ");
        float value = sc.nextFloat();
        algorithm.binarySearch(a, 0, n - 1, value);
    }
    //Choice 8 Creater 50 000 number
    //ranrom 0 --> 50 000
    public static void createrFileNumber() throws IOException {
        float[] bigArray = new float[50000];
        float[] bigArraySort = new float[50000];
        float[] bigArrayReverseSort = new float[50000];
        for (int i = 0; i <  50000; i++){
            float value = (float) Math.random() * 50001;
            bigArray[i] = value;
            bigArraySort[i] = value;
            bigArrayReverseSort[i] =value;
        }
        Arrays.sort(bigArraySort);
        sortDESC(bigArrayReverseSort);
        algorithm.writeFile(bigArray, "BigArray.TXT");
        algorithm.writeFile(bigArraySort, "BigArraySort.TXT");
        algorithm.writeFile(bigArrayReverseSort, "BigArrayReverseSort.TXT");

        //Time run array no sort
        TimeRun timeRun = new TimeRun(bigArray);
        System.out.println("Time Array not sort");
        System.out.println("Time sort of selection Sort of BigArray is :" + timeRun.selectSort());
        System.out.println("Time sort of insertion Sort of BigArray is :" + timeRun.insertionSort());
        System.out.println("Time sort of bubble Sort of BigArray is :" + timeRun.bubbleSort());

        //time run array sort
        TimeRun timeRunSort = new TimeRun(bigArraySort);
        System.out.println("Time Array sort");
        System.out.println("Time sort of bubble Sort of BigArray is :" + timeRunSort.bubbleSort());
        System.out.println("Time sort of selection Sort of BigArray is :" + timeRunSort.selectSort());
        System.out.println("Time sort of insertion Sort of BigArray is :" + timeRunSort.insertionSort());

        TimeRun timeRunReverseSort = new TimeRun(bigArrayReverseSort);
        System.out.println("Time Array Reverse sort");
        System.out.println("Time sort of bubble Sort of BigArray is :" + timeRunReverseSort.bubbleSort());
        System.out.println("Time sort of selection Sort of BigArray is :" + timeRunReverseSort.selectSort());
        System.out.println("Time sort of insertion Sort of BigArray is :" + timeRunReverseSort.insertionSort());

        System.out.println("Nhận xét về hiệu năng của 3 thuật toán với 3 kiểu dữ liệu: ");
        System.out.println("- Thuật toán bubble sort có hiệu năng thấp nhất với thời gian chạy dài nhất. không nên đuợc sử dụng");
        System.out.println("- Thuật toán ínertion sort có hiệu năng tốt nhất với thời gian chạy ngắn nhát. Nên được sử dụng.");
        System.out.println("- Thật toán selection sort có hiệu năng tốt hơn bubble sort nhưng vẫn cao hơn rất nhiều so với ínertion sort");
        System.out.println("- Tuy nhiên các kiểu dữ liệu khác nhau có thời gian chạy khác nhau. dữ liệu đã được sáp xếp có \n" +
                "thời gian chạy thấp nhát, dũ liệu chưa được săp xếp sẽ có thời gian chạy lâu nhất");
    }

    // Sort Reverse
    public static void sortDESC(float [] arr) {
        float temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
