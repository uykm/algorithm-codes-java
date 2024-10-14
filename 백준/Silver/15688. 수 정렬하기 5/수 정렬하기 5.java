import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        
        for (int i = 0; i < N; ++i) {
            array[i] = Integer.parseInt(br.readLine());
        }
        
        radixSort(array);
        
        StringBuilder sb = new StringBuilder();
        
        for (int a : array) {
            sb.append(a).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    // 계수 정렬을 이용한 자릿수별 정렬
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int k = 10; // 최댓값 + 1
        int[] result = new int[n]; // 정렬된 결과를 저장할 배열
        int[] count = new int[k]; // 자릿수 값 0~9까지의 카운트 배열

        // 현재 자리수(exp)에 대한 빈도 계산
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) / exp;  // 절댓값을 기준으로 자리수 계산
            count[(index % k)]++;
        }

        // 누적합 갱신
        for (int i = 1; i < k; i++) {
            count[i] += count[i - 1];
        }

        // 배열을 안정적으로 정렬 (뒤에서부터 처리)
        for (int i = n - 1; i >= 0; i--) {
            int index = Math.abs(arr[i]) / exp;
            count[index % k]--;
            result[ count[index % k] ] = arr[i];
        }

        // 결과를 원본 배열로 복사
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
    
    // 기수 정렬 메서드
    public static void radixSort(int[] arr) {
        // // 배열을 양수 그룹과 음수 그룹으로 나눈다.
        int negativeCount = 0;
        int positiveCount = 0;
        
        for (int num : arr) {
            if (num < 0) negativeCount++;
            else positiveCount++;
        }
        
        // 음수와 양수를 저장할 배열 생성
        int[] negatives = new int[negativeCount];
        int[] positives = new int[positiveCount];
        
        // 음수와 양수를 분리하여 각각 배열에 저장
        int negIndex = 0;
        int posIndex = 0;
        for (int num : arr) {
            if (num < 0) {
                negatives[negIndex++] = num;
            } else {
                positives[posIndex++] = num;
            }
        }
        
        // Stream 이용
        // int[] negatives = Arrays.stream(arr).filter(num -> num < 0).toArray();
        // int[] positives = Arrays.stream(arr).filter(num -> num >= 0).toArray();

        // 최대 절댓값 탐색
        int max = 0;
        for (int a : arr) {
            max = Math.max(max, Math.abs(a));
        }
        
        // 각 자리수를 기준으로 정렬 (양수와 음수 따로)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(positives, exp); // 양수에 대해 정렬
            countingSort(negatives, exp); // 음수에 대해 정렬
        }

        // 음수는 역순으로 정렬한 뒤 양수와 합침
        int negIdx = 0;
        for (int i = negatives.length - 1; i >= 0; i--) {
            arr[negIdx++] = negatives[i];
        }
        
        System.arraycopy(positives, 0, arr, negIdx, positives.length);
    }
}