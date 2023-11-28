import java.util.*;

class Solution {
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] per = {10, 20, 30, 40};
        int[] arr = new int[emoticons.length];
        List<Service> serviceList = new ArrayList<>();
        dfs(per, emoticons, arr, users, serviceList, 0);
        serviceList.sort(Comparator.reverseOrder());
        Service service = serviceList.get(0);

        return new int[]{service.getNumber(),service.getPrice()};
    }

    static void dfs(int[] percent, int[] emoticons, int[] arr, int[][] users, List<Service> serviceList, int depth){
        if(depth == emoticons.length){
            int price = 0;
            int number = 0;
            for (int[] user : users) {
                int salePercent = user[0];
                int maxPrice = user[1];
                int money = 0;
                for (int q = 0; q < arr.length; q++) {
                    if (arr[q] >= salePercent) {
                        money += emoticons[q] * (1 - ((double) arr[q] / 100));
                    }
                }
                if (money >= maxPrice) {
                    number++;
                } else {
                    price += money;
                }
            }
            serviceList.add(new Service(number,price));
            return;
        }
        for (int p : percent) {
            arr[depth] = p;
            dfs(percent, emoticons, arr, users, serviceList,depth + 1);
        }
    }

    static class Service implements Comparable<Service>{
        int number, price;

        Service(int number,int price){
            this.number = number;
            this.price = price;
        }

        public int getNumber() {
            return number;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(Service o) {
            if(this.number==o.number){
                return this.price-o.price;
            }
            return this.number-o.number;
        }
    }
}
