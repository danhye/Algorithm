import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;

    static boolean nextNum(int[] arr) {
        int standard = n - 1; //끝값 idx
        while (standard > 0 && (arr[standard - 1] >= arr[standard])) {
            standard--;
        }

        if (standard == 0) return false;

        // 1 3 5 4 2
        //   3 5
        //   현재 5가 standard

        // 다음 순열 : 1 5 3 4 2
        standard--;

        int standard2 = n - 1;
        // arr[standard] < arr[standard2]
        while(arr[standard] >= arr[standard2]){
            standard2--;
        }

        // 값 바꾸기
        int tmp = arr[standard];
        arr[standard] = arr[standard2];
        arr[standard2] = tmp;

        // 값 바꾼 이후부터 뒤집기
        int left = standard + 1;
        int right = n - 1;

        while(left < right){
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (!nextNum(arr)) {
            System.out.println("-1");
        } else {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}