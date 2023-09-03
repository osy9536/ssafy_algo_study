package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class b12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        Stack<Integer> goSpace = new Stack<>();
        Stack<Integer> snack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            q1.add(Integer.parseInt(st.nextToken()));
        }

        while(!q1.isEmpty()) {
            int current = q1.poll();

            if(snack.isEmpty() && goSpace.isEmpty()) {
                if(current == 1) snack.add(current);
                else goSpace.add(current);
            }

            else if(goSpace.isEmpty() && !snack.isEmpty()) {
                if(snack.peek()+1 == current) {
                    snack.add(current);
                }
                else {
                    goSpace.add(current);
                }
            }

            else {
                if(current < goSpace.peek()) {
                    if(snack.isEmpty()) {
                        if(current == 1) snack.add(current);
                        else {
                            goSpace.add(current);
                        }
                    }
                    else {
                        if(current-1 == snack.peek()) {
                            snack.add(current);
                        }
                        else {
                            goSpace.add(current);
                        }
                    }
                }
                else {
                    if(snack.isEmpty()) {
                        System.out.println("Sad");
                        return;
                    }
                    else {
                        if(goSpace.peek() -1 == snack.peek()) {
                            int current2 = goSpace.pop();
                            snack.add(current2);
                            q1.addFirst(current);
                        }
                        else {
                            System.out.println("Sad");
                            return;
                        }
                    }

                }
            }
        }

        System.out.println("Nice");



    }
}
