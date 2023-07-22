package week5.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

/**
 * 최적해 + 탐욕적
 * 오름차순 생각못함.;
 * 람다식 compare 적용
 */
public class P_회의실배정_1931 {
    static int n;
    static class Meet{
        int start;
        int end;
        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meet{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    static Meet[] meets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        meets = new Meet[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meets[i] = new Meet(start,end);
        }


        Comparator<Meet> comparator = Comparator.comparing(Meet::getEnd,Comparator.naturalOrder()).thenComparing(Meet::getStart);
        Meet[] array = Arrays.stream(meets).sorted(comparator).toArray(Meet[]::new);

        int end = array[0].end;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(end <= array[i].start){
                end = array[i].end;
                count++;
            }
        }
        System.out.println(count);


    }

}
