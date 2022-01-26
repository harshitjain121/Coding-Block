package binarySearch;

public class TotalOccurrencesOfElement {
    //here we r refering FirstAndLastOccurrence class

    public static void main(String[] args){
        int ar[] = {1,2,3,3,3,3,4,5};
        int key = 3;
        TotalOccurrencesOfElement count = new TotalOccurrencesOfElement();
        System.out.println(count.totalElement(ar, ar.length, key));
    }

    private int firstOccurrence(int[] arr, int size, int key){
        int s = 0;
        int e = size-1;
        int mid = s + (e-s)/2;
        int ans = -1;
        while (s<=e) {
            if (arr[mid] == key) {
                ans = mid;
                // for first occurrence - go to left part
                e = mid - 1;
            } else if (key > arr[mid]) {
                // go to right part
                s = mid + 1;
            } else {
                // go to left part - key < arr[mid]
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    private int lastOccurrence(int[] arr, int size, int key){
        int s = 0;
        int e = size-1;
        int mid = s + (e-s)/2;
        int ans = -1;
        while (s<=e) {
            if (arr[mid] == key) {
                ans = mid;
                // for last occurrence - go to right part
                s = mid + 1;
            } else if (key > arr[mid]) {
                // go to right part
                s = mid + 1;
            } else {
                // go to left part - key < arr[mid]
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    private int totalElement(int[] arr, int size, int key){
        return (lastOccurrence(arr, size, key)-firstOccurrence(arr, size, key) + 1);
    }

}
