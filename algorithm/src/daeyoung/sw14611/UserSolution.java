package algorithm.src.daeyoung.sw14611;

import java.util.*;

/**
 * sw 14611
 * 계산 게임
 */
public class UserSolution {

    private static final int MAX_CARD = 50000;
    private int joker;
    private int begin;
    private int end;
    private int[] cards;
    private LinkedList<Integer>[][] idxList;

    void updateIdx(int idx, int mDir) {
        int sum = 0;
        int jokerCnt = 0;

        for(int i = 0; i < 4; i++) {
            if(cards[idx + i] == -1)
                jokerCnt++;
            else
                sum += cards[idx + i];
        }

        for(int i = 0; i < 20; i++) {
            int num = (sum + (jokerCnt * i)) % 20;
            if(mDir == 0)
                idxList[i][num].addFirst(idx);
            else if(mDir == 1)
                idxList[i][num].addLast(idx);
        }
    }

    void init(int mJoker, int mNumbers[]) {
        joker = mJoker % 20;
        begin = MAX_CARD;
        end = MAX_CARD;

        cards = new int[MAX_CARD * 2 + 5];

        idxList = new LinkedList[20][20];
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                idxList[i][j] = new LinkedList<>();
            }
        }

        for(int i = 0; i < 5; i++)
            cards[end + i] = mNumbers[i];

        end += 5;

        for(int i = 0; i < 2; i++) {
            updateIdx(MAX_CARD + i, 1);
        }
    }

    void addFirst(int mNumbers[]) {
        begin -= 5;

        for(int i = 0; i < 5; i++) {
            cards[begin + i] = mNumbers[i];
        }

        int target = begin;
        for(int i = 4; i >= 0; i--) {
            updateIdx(target + i, 0);
        }
    }

    void addLast(int mNumbers[]) {
        for(int i = 0; i < 5; i++) {
            cards[end + i] = mNumbers[i];
        }

        int target = end - 3;
        end += 5;

        for(int i = 0; i < 5; i++) {
            updateIdx(target + i, 1);
        }
    }

    void putCards(int mDir, int mNumbers[]) {

        if(mDir == 0)
            this.addFirst(mNumbers);
        else if(mDir == 1)
            this.addLast(mNumbers);
    }

    int findNumber(int mNum, int mNth, int ret[]) {

        LinkedList<Integer> list = idxList[joker][mNum];
        if (mNth > list.size())
            return 0;
        int idx = list.get(mNth - 1);
        for (int i = 0; i < 4; i++) {
            ret[i] = cards[idx + i];
        }
        return 1;
    }

    void changeJoker(int mValue) {
        this.joker = mValue % 20;
    }
}