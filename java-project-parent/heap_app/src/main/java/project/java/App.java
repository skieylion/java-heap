package project.java;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static int totalSteps(int[] nums) {
        if (nums.length == 1)
            return 0;
        LinkedList<int[]> linkedList = new LinkedList<>();
        linkedList.add(new int[]{nums[0], 0});
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int[] current = new int[]{nums[i], 1};
            while (true) {
                int[] last = linkedList.getLast();
                if (current[0] < last[0]) {
                    if (last[1] == current[1])
                        linkedList.removeLast();
                    linkedList.add(current);
                    break;
                } else {
                    current[1] = Math.max(current[1], last[1]) + 1;
                    linkedList.removeLast();
                    if (linkedList.size() == 0) {
                        current[1] = 0;
                        linkedList.add(current);
                        break;
                    }
                }
            }
            for (var array : linkedList)
                max = Math.max(max, array[1]);
        }
        return max;
    }

    public static void main(String[] args) {
        var result = totalSteps(new int[]{7, 14, 4, 14, 13, 2, 6, 13});
        result = totalSteps(new int[]{4, 5, 7, 7, 13});
        result = totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11});
    }
}
