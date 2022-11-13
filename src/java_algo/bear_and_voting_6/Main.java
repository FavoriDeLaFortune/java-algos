package java_algo.bear_and_voting_6;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    //O(MAX - CANDIDATE_COUNT) ~ O(CONST)
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int afterCandidateVotes = in.nextInt();
        int beforeCandidateVotes = afterCandidateVotes;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int maxVotes = afterCandidateVotes;
        for (int i = 1; i < n; ++i) {
            int num = in.nextInt();
            if (num > maxVotes) {
                maxVotes = num;
            }
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.replace(num, hashMap.get(num) + 1);
            }
        }
        if (maxVotes == beforeCandidateVotes && !hashMap.containsKey(maxVotes)) {
            System.out.println(0);
            return;
        }
        while (maxVotes >= afterCandidateVotes) {
            if (hashMap.get(maxVotes) == 1) {
                afterCandidateVotes += 1;
                hashMap.remove(maxVotes);
                maxVotes -= 1;
                if (hashMap.containsKey(maxVotes)) {
                    hashMap.replace(maxVotes, hashMap.get(maxVotes) + 1);
                } else {
                    hashMap.put(maxVotes, 1);
                }
            } else {
                int countMaxVotes = hashMap.get(maxVotes);
                if (afterCandidateVotes + countMaxVotes < maxVotes) {
                    afterCandidateVotes += countMaxVotes;
                    hashMap.remove(maxVotes);
                    maxVotes -= 1;
                    if (hashMap.containsKey(maxVotes)) {
                        hashMap.replace(maxVotes, hashMap.get(maxVotes) + countMaxVotes);
                    } else {
                        hashMap.put(maxVotes, countMaxVotes);
                    }
                } else {
                    if (afterCandidateVotes + countMaxVotes == maxVotes) {
                        afterCandidateVotes = maxVotes;
                        maxVotes -= 1;
                    } else {
                        afterCandidateVotes = maxVotes + 1;
                    }
                }
            }
        }
        System.out.println(afterCandidateVotes - beforeCandidateVotes);
    }
}
