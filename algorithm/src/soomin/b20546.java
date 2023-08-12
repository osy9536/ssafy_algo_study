package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;

public class b20546 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 성민이의 조건에 맞게 주가 변동 추이를 보기 위한 stack


        int money = Integer.parseInt(br.readLine());

        Person junHyun = new Person(money, 0);
        Person sungMin = new Person(money , 0);




        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int T = 1; T <= 13; T++) {
            int stockPrice = Integer.parseInt(st.nextToken());

            // 준현이부터 계산
            if(junHyun.seedMoney >= stockPrice){
                junHyun.stock += junHyun.seedMoney/stockPrice;
                junHyun.seedMoney %= stockPrice;
            }
            // 성민이 계산
            int result = calcul(stockPrice);

            // 3일 내내 상승장 주식이 있으면 팔아야 한다.
            if (result == 1){
                sungMin.seedMoney += sungMin.stock * stockPrice;
                sungMin.stock = 0;
                // 3일 내내 하락장 4일째에 살 수 있으면 사야 한다.
            } else if (result == -1 && stockPrice <= sungMin.seedMoney) {
                sungMin.stock += sungMin.seedMoney/stockPrice;
                sungMin.seedMoney %=stockPrice;
            }
//            System.out.print(T+"일째  junHyun 의 시드머니 = " + junHyun.seedMoney +"\t 현재 보유 주식: "+ junHyun.stock);
//            System.out.println("\n \t  sungMin 의 시드머니 = " + sungMin.seedMoney + "\t 현재 보유 주식: " + sungMin.stock);
//            System.out.println();
        }

        int lastdayPrice = Integer.parseInt(st.nextToken());

        junHyun.result = junHyun.seedMoney + junHyun.stock*lastdayPrice;
        sungMin.result = sungMin.seedMoney + sungMin.stock*lastdayPrice;

//        System.out.println("최종 결과: "+ junHyun.result);
//        System.out.println("최종 결과: "+ sungMin.result);

        if((junHyun.result) > (sungMin.result)){
            System.out.println("BNP");
        } else if ((junHyun.result) < (sungMin.result)) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    private static int calcul(int stockPrice){

        // 팔아라 -> 1, 사라 -> -1 그냥 다음 것 -> 0
        int check = 0;

        // list가 3이 될때까지 채우기
        if(list.size() <3){
            list.add(stockPrice);
            return 0;
        } else if (list.size() == 3) {
            if(list.get(0) < list.get(1) && list.get(1) < list.get(2)){
                check = 1;
            } else if (list.get(0)> list.get(1) && list.get(1) > list.get(2)) {
                check = -1;
            } else {
                check = 0;
            }
            list.add(stockPrice);
            list.remove(0);
        }

        return  check;
    }


}
class Person {
    int seedMoney;
    int stock;

    int result;

    Person (int seedMoney, int stock){
        this.seedMoney = seedMoney;
        this.stock = stock;
    }
}
