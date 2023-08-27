package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        ArrayList<User> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new User(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
        }
        System.out.println(sb);
    }
}

class User implements Comparable<User>{
    String name;
    int age;
    int joinSequence;

    public User(int age, String name, int joinSequence) {
        this.name = name;
        this.age = age;
        this.joinSequence = joinSequence;
    }


    @Override
    public int compareTo(User o) {

        if(this.age == o.age){
            return this.joinSequence - o.joinSequence;
        }

        return this.age -o.age;
    }
}
