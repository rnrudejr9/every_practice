package week1.day1;

//배열 각각 -1 하기 와 answer 카운트
//0의 숫자가 한줄로 k 개 이상 나타나면 종료
// 0의 숫자를 탐색하는 방법


// 돌이 건너뛰는 범위 K
// 돌에 대한 값이 최대한 2억  -> 브루트 포스로 풀 수 없다.
//log n 투포인터, 세그먼트 트리, 이진탐색


import java.util.Arrays;

public class p_징검다리건너기 {
    static int count = 0;
    public static void main(String[] args) {
        p_징검다리건너기 p = new p_징검다리건너기();

        int[] arr = new int[]{2,4,5,3,2,1,4,2,5,1};
//        p.solution(arr,3);
        p.solution2(arr,3);
    }

    public static boolean count(int[] stones,int k,int index){
        for(int i =index;i<k;i++){
            if(i >= stones.length){
                return false;
            }else{
                if(stones[i] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        while(true) {
            for(int i=0;i<stones.length;i++){
                if(stones[i] != 0){
                    stones[i] = stones[i] - 1;
                }else{
                    if(count(stones,k+i,i)){
                        return count;
                    }
                }
            }
            count++;
        }
    }

//    제일 최소 숫자를 뺌

    public int solution2(int[] stones, int k) {
        int answer = 0;
        counting(stones,k);
        return answer;
    }
    public static boolean finding(int[] stones,int k){
        int counter = 0;
        for(int i =0;i<stones.length;i++){
            if(stones[i] == 0){
                for(int j =i ;j<i+k;j++){
                    if(counter == k){
                        return true;
                    }
                    if(stones[i] == 0 && j < stones.length){
                        counter = counter+1;
                    }else{
                        counter = 0;
                    }
                }
            }
        }
        return false;
    }
    public static int counting(int[] stones,int k){
        int min = Arrays.stream(stones).filter((item)->item > 0).min().getAsInt();
        System.out.println(min);
        count = count + min;
        for(int i =0;i<stones.length;i++){
            if(stones[i] != 0) {
                stones[i] = stones[i] - min;
            }
        }
        if(finding(stones,k)){
            return count;
        }else{
            System.out.println(Arrays.toString(stones));
            return counting(stones,k);
        }
    }
}
