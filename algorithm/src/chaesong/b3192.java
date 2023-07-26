import java.util.Scanner;

public class b3192 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Arr[] = new int[9];
        for(int i = 0; i < 9; i++){
            Arr[i] = sc.nextInt();
        }
        int first = Arr[7] + Arr[0] + Arr[5];
        int second = Arr[2] + Arr[4] + Arr[6];
        int third = Arr[3] + Arr[8] + Arr[1];
        //first대각선이 0일 때
        if(first == 0){
            Arr[0] = second - Arr[1] - Arr[2];
            Arr[5] = second - Arr[3] - Arr[4];
            Arr[7] = second - Arr[6] - Arr[8];
        }
        //second대각선이 0일 때
        if(second == 0){
            int cha = Arr[7] - Arr[0];
            Arr[4] = (Arr[0] + Arr[8]) / 2;
            Arr[2] = Arr[4] + cha;
            Arr[6] = Arr[4] - cha;
        }
        //third대각선이 0일 때
        if(third == 0){
             Arr[3] = second - Arr[4] - Arr[5];
             Arr[8] = second - Arr[6] - Arr[7];
             Arr[1] = second - Arr[0] - Arr[2];
         }
        //우하향 대각선이 0일 때
        if(Arr[0] + Arr[4] + Arr[8] == 0){
        	Arr[4] = (Arr[2] + Arr[6]) / 2;
        	int hap = Arr[2] + Arr[4] + Arr[6];
        	Arr[0] = hap - Arr[1] - Arr[2];
        	Arr[6] = hap - Arr[6] - Arr[7];
        }
        //공차구하기
        int cha;
        while(true){
            //Arr[5] 구함
            if(Arr[0] != 0 & Arr[7] != 0){
                cha = Arr[7] - Arr[0];
                Arr[5] = Arr[0] - cha;
                break;
            }
            //Arr[7] 구함
            if(Arr[0] != 0 & Arr[5] != 0){
                cha = Arr[0] - Arr[5];
                Arr[7] = Arr[0] + cha;
                break;
            }
            //Arr[6] 구함
            if(Arr[2] != 0 & Arr[4] != 0){
                cha = Arr[2] - Arr[4];
                Arr[6] = Arr[4] - cha;
                break;
            }
            //Arr[2] 구함
            if(Arr[4] != 0 & Arr[6] != 0){
                cha = Arr[4] - Arr[6];
                Arr[2] = Arr[4] + cha;
                break;
            }
         }
        if(Arr[0] == 0){
            if(Arr[7] != 0){
                Arr[0] = Arr[7] - cha;
                Arr[5] = Arr[0] - cha;
            }
            else{
                Arr[0] = Arr[5] + cha;
                Arr[7] = Arr[0] + cha;
            }
        }
        else{
            Arr[5] = Arr[0] - cha;
            Arr[7] = Arr[0] + cha;
        }
        if(Arr[4] == 0){
            if(Arr[2] == 0){
                Arr[4] = Arr[6] + cha;
                Arr[2] = Arr[4] + cha;
            }
            else{
                Arr[4] = Arr[2] - cha;
                Arr[6] = Arr[4] - cha;
            }
        }
        else{
            Arr[6] = Arr[4] - cha;
            Arr[2] = Arr[4] + cha;
        }
        if(Arr[8] == 0){
            if(Arr[3] == 0){
                Arr[8] = Arr[1] + cha;
                Arr[3] = Arr[8] + cha;
            }
            else{
                Arr[8] = Arr[3] - cha;
                Arr[1] = Arr[8] - cha;
            }
        }
        else{
            Arr[1] = Arr[8] - cha;
            Arr[3] = Arr[8] + cha;
        }
        System.out.println(Arr[0] + " " + Arr[1] + " " + Arr[2]);
        System.out.println(Arr[3] + " " + Arr[4] + " " + Arr[5]);
        System.out.println(Arr[6] + " " + Arr[7] + " " + Arr[8]);
    }
}