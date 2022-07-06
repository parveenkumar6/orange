package DPBottomup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);

        for (int stone : stones) {
            //System.out.println("stone : " + stone);
            for (int k : map.get(stone)) {
                //System.out.println("K " + k);
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }
        System.out.println(map);
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 5, 6, 8, 12, 17};
        boolean check = new FrogJump().canCross(arr);
        System.out.println(check);
    }
}
