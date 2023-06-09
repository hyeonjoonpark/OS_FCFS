import java.util.LinkedList;
import java.util.Queue;

public class FCFS {
    public static void main(String[] args) {
        int[] arriveTime = {0, 2, 1, 5}; // 도착시간 정의
        int[] executeTime = {4, 7, 9, 4}; // 실행시간 정의

        int n = arriveTime.length; // 도착시간 배열의 길이를 변수 n에 담음

        // 대기열을 표현하기 위해서 Queue 객체를 생성합니다
        Queue<Integer> queue = new LinkedList<>();

        // 첫번쨰 작업을 큐에 추가합니다
        queue.add(0);

        int[] waitTime = new int[n]; // 대기시간 저장하는 배열
        int[] completeTime = new int[n]; // 완료시간 저장하는 배열

        // 첫 번째 작업의 대기 시간은 0
        waitTime[0] = 0;

        // 대기시간은 이전 완료시간과 현재 도착시간의 차이로 구한다
        for (int i = 1; i < n; i++) {
            waitTime[i] = completeTime[i - 1] - arriveTime[i];
            if (waitTime[i] < 0) { // 대기시간이 음수인 경우
                waitTime[i] = 0; // 0으로 설정합니다
            }

            // 작업의 완료 시간은 대기 시간에 실행 시간을 더한 값
            completeTime[i] = waitTime[i] + executeTime[i];

            queue.add(i); // 다음 작업을 큐에 추가합니다
        }

        double avgTime = 0; // 평균 대기시간

        for(int i=1; i<n; i++) {
            avgTime += waitTime[i];
        }
        avgTime = avgTime / n;

        System.out.println("| 작업번호  |  도착시간\t | 실행시간\t | 대기시간\t | 완료시간\t |");
        System.out.println("+---------+----------+-----------+-----------+-----------+");

        for (int i = 0; i < n; i++) {
            System.out.println("| " + i + "\t\t  | " + arriveTime[i] + "\t\t | " + executeTime[i] + "\t\t | " + waitTime[i] + "\t\t | " + completeTime[i] + "\t\t | ");
            System.out.println("+---------+----------+-----------+-----------+-----------+");
        }

        System.out.println("평균 대기시간: " + avgTime + "초");
    }
}
