import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Step 1: store robot data
        int[][] robots = new int[n][4];
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i; // original index
        }

        // Step 2: sort by position
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (robots[i][2] == 'R') {
                stack.push(i);
            } else {
                // current robot is 'L'
                while (!stack.isEmpty() && robots[i][1] > 0) {
                    int top = stack.peek();

                    if (robots[top][1] < robots[i][1]) {
                        // R dies
                        stack.pop();
                        robots[i][1] -= 1;
                        robots[top][1] = 0;
                    } 
                    else if (robots[top][1] > robots[i][1]) {
                        // L dies
                        robots[top][1] -= 1;
                        robots[i][1] = 0;
                        break;
                    } 
                    else {
                        // both die
                        stack.pop();
                        robots[i][1] = 0;
                        robots[top][1] = 0;
                        break;
                    }
                }
            }
        }

        // Step 4: collect survivors
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            if (robots[i][1] > 0) {
                result[robots[i][3]] = robots[i][1];
            }
        }

        // Step 5: return in original order
        List<Integer> ans = new ArrayList<>();
        for (int x : result) {
            if (x != -1) ans.add(x);
        }

        return ans;
    }
}