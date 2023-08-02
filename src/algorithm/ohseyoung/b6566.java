package algorithm.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b6566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> anagramGroups = new HashMap<>();

        String input;
        while ((input = br.readLine()) != null) {
            char[] charArray = input.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(input);
        }

        List<List<String>> sortedGroups = new ArrayList<>(anagramGroups.values());
        sortedGroups.sort((g1, g2) -> {
            if (g1.size() == g2.size()) {
                return g1.get(0).compareTo(g2.get(0));
            }
            return Integer.compare(g2.size(), g1.size());
        });

        int numGroupsToPrint = Math.min(sortedGroups.size(), 5);
        for (int i = 0; i < numGroupsToPrint; i++) {
            List<String> group = sortedGroups.get(i);
            Collections.sort(group);
            StringBuilder sb = new StringBuilder();
            List<String> check = new ArrayList<>();
            for (String word : group) {
            	if(!check.contains(word)) {
            		check.add(word);
            		sb.append(word).append(" ");
            	}
            }
            sb.append(".");
            System.out.println("Group of size " + group.size() + ": " + sb);
        }
    }
}
