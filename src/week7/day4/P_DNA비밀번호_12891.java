package week7.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_DNA비밀번호_12891 {

    static int m;
    static int n;

    //    acgt
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] dna = br.readLine().split("");

        st = new StringTokenizer(br.readLine());
        int[] key = new int[4];
        for (int i = 0; i < 4; i++) {
            key[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = m-1;
        int count = 0;


        for (int i = 0; i < m; i++) {
            if(dna[i].equals("A")){
                key[0] -= 1;
            }else if(dna[i].equals("C")){
                key[1] -= 1;
            }else if(dna[i].equals("G")){
                key[2] -= 1;
            }else if(dna[i].equals("T")){
                key[3] -= 1;
            }
        }
        if(isZero(key)){
            count += 1;
        }
        start += 1;
        end += 1;

        while(end < n){

            String temp = dna[start-1];
            if(temp.equals("A")){
                key[0] += 1;
            }else if(temp.equals("C")){
                key[1] += 1;
            }else if(temp.equals("G")){
                key[2] += 1;
            }else if(temp.equals("T")){
                key[3] += 1;
            }
            temp = dna[end];
            if(temp.equals("A")){
                key[0] -= 1;
            }else if(temp.equals("C")){
                key[1] -= 1;
            }else if(temp.equals("G")){
                key[2] -= 1;
            }else if(temp.equals("T")){
                key[3] -= 1;
            }

            if(isZero(key)){
                count += 1;
            }
            start+= 1;
            end += 1;
        }

        System.out.println(count);
    }
    public static boolean isZero(int[] res){
        for (int i = 0; i < 4; i++) {
            if(res[i]>0){
                return false;
            }
        }
        return true;
    }

}
