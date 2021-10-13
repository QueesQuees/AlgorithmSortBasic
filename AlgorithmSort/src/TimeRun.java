public class TimeRun {
    private float[] arr;
    private int size;
    public TimeRun(float[] bigArray) {
        this.size = bigArray.length;
        this.arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = bigArray[i];
        }
    }

// Trả lại thời gian chạy của các hàm bên dưới bubble, select and ínert sort

    public long bubbleSort() {
        long start = System.nanoTime();
        for (int i = 0; i< size - 1; i++) {
            for (int j = 0; j < size -1 - i; j++) {
                int k = j + 1;
                if (arr[j] > arr[k]){
                    swap(j, k);
                }
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    public long selectSort() {
        long start = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    public long insertionSort() {
        long start = System.nanoTime();
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            float current = this.arr[i];
            while (j >= 0 && this.arr[j] > current) {
                this.arr[j + 1] = this.arr[j];
                this.arr[j] = current;
                j--;
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    public void swap(int j, int k){
        float x = this.arr[j];
        this.arr[j] = this.arr[k];
        this.arr[k] = x;
    }
}
