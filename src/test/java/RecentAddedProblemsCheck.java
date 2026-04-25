import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class RecentAddedProblemsCheck {

    public static void main(String[] args) {
        testNQueens();
        testRestoreIpAddresses();
        testEditDistance();
        testMinCostConnectPoints();
        testDijkstra();
        testMathConstants();
        testLargestRectangle();
        testCalculator();
        testKmp();
        testTrie();
        testThreeSum();
        testUnionFind();
        testCourseSchedule();
        testLcs();
        testMinWindow();
        testBuildTree();
        testMaxPathSum();
        testKthLargest();
        testMergeIntervals();
        System.out.println("All recent added problem checks passed.");
    }

    private static void testNQueens() {
        backtracking.Solution s = new backtracking.Solution();
        checkEquals(2, s.solveNQueens(4).size(), "N-Queens n=4");
    }

    private static void testRestoreIpAddresses() {
        backtracking.Solution2 s = new backtracking.Solution2();
        List<String> result = s.restoreIpAddresses("25525511135");
        check(result.contains("255.255.11.135"), "Restore IP contains first answer");
        check(result.contains("255.255.111.35"), "Restore IP contains second answer");
        checkEquals(2, result.size(), "Restore IP result size");
    }

    private static void testEditDistance() {
        dp.Solution8 s = new dp.Solution8();
        checkEquals(3, s.minDistance("horse", "ros"), "Edit distance horse->ros");
        checkEquals(5, s.minDistance("intention", "execution"), "Edit distance intention->execution");
    }

    private static void testMinCostConnectPoints() {
        graph.Solution s = new graph.Solution();
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        checkEquals(20, s.minCostConnectPoints(points), "Min cost connect points");
    }

    private static void testDijkstra() {
        graph.Solution2 s = new graph.Solution2();
        checkEquals(2, s.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2), "Network delay");
        checkEquals(-1, s.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2), "Network delay unreachable");
    }

    private static void testMathConstants() {
        math.Solution4 eSolver = new math.Solution4();
        math.Solution5 ln2Solver = new math.Solution5();
        check(eSolver.e(10).startsWith("2.718281828"), "e prefix");
        check(ln2Solver.ln2(10).startsWith("0.693147180"), "ln2 prefix");
    }

    private static void testLargestRectangle() {
        stackQueue.Solution4 s = new stackQueue.Solution4();
        checkEquals(10, s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}), "Largest rectangle sample 1");
        checkEquals(4, s.largestRectangleArea(new int[]{2, 4}), "Largest rectangle sample 2");
    }

    private static void testCalculator() {
        stackQueue.Solution5 s = new stackQueue.Solution5();
        checkEquals(7, s.calculate("1 + 2 * 3"), "Calculator precedence");
        checkEquals(23, s.calculate("(1 + (4 + 5 + 2) - 3) + (6 + 8)"), "Calculator parentheses");
        checkEquals(16, s.calculate("3 * (2 + 10 / 2) - 5"), "Calculator mixed");
    }

    private static void testKmp() {
        str.Solution5 s = new str.Solution5();
        checkEquals(2, s.strStr("hello", "ll"), "KMP hello/ll");
        checkEquals(4, s.strStr("aabaaabaaac", "aabaaac"), "KMP repeated pattern");
    }

    private static void testTrie() {
        trie.Solution trie = new trie.Solution();
        trie.insert("apple");
        check(trie.search("apple"), "Trie search apple");
        check(!trie.search("app"), "Trie app before insert");
        check(trie.startsWith("app"), "Trie startsWith app");
        trie.insert("app");
        check(trie.search("app"), "Trie app after insert");
    }

    private static void testThreeSum() {
        twoPointers.Solution7 s = new twoPointers.Solution7();
        List<List<Integer>> result = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        check(result.contains(Arrays.asList(-1, -1, 2)), "3Sum contains [-1,-1,2]");
        check(result.contains(Arrays.asList(-1, 0, 1)), "3Sum contains [-1,0,1]");
        checkEquals(2, result.size(), "3Sum result size");
    }

    private static void testUnionFind() {
        unionFind.Solution s = new unionFind.Solution();
        checkEquals(2, s.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }), "UnionFind provinces connected");
        checkEquals(3, s.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }), "UnionFind provinces isolated");
    }

    private static void testCourseSchedule() {
        graph.Solution3 s = new graph.Solution3();
        check(s.canFinish(2, new int[][]{{1, 0}}), "Course schedule acyclic");
        check(!s.canFinish(2, new int[][]{{1, 0}, {0, 1}}), "Course schedule cycle");
    }

    private static void testLcs() {
        dp.Solution9 s = new dp.Solution9();
        checkEquals(3, s.longestCommonSubsequence("abcde", "ace"), "LCS sample");
    }

    private static void testMinWindow() {
        str.Solution6 s = new str.Solution6();
        checkEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"), "Min window sample");
        checkEquals("", s.minWindow("a", "aa"), "Min window impossible");
    }

    private static void testBuildTree() {
        tree.Solution8 s = new tree.Solution8();
        tree.TreeNode root = s.buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
        checkEquals(Arrays.asList(3, 9, 20, 15, 7), levelOrder(root), "Build tree level order");
    }

    private static void testMaxPathSum() {
        tree.Solution9 s = new tree.Solution9();
        tree.TreeNode root1 = new tree.TreeNode(1);
        root1.left = new tree.TreeNode(2);
        root1.right = new tree.TreeNode(3);
        checkEquals(6, s.maxPathSum(root1), "Max path sum positive");

        tree.TreeNode root2 = new tree.TreeNode(-3);
        checkEquals(-3, s.maxPathSum(root2), "Max path sum repeated call");
    }

    private static void testKthLargest() {
        heap.Solution2 s = new heap.Solution2();
        checkEquals(5, s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), "Kth largest");
    }

    private static void testMergeIntervals() {
        sort.Solution5 s = new sort.Solution5();
        int[][] merged = s.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
        check(Arrays.deepEquals(new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        }, merged), "Merge intervals");
    }

    private static List<Integer> levelOrder(tree.TreeNode root) {
        java.util.ArrayList<Integer> result = new java.util.ArrayList<>();
        ArrayDeque<tree.TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            tree.TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + ": expected " + expected + " but was " + actual);
        }
    }

    private static void checkEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + " but was " + actual);
        }
    }

    private static void checkEquals(List<Integer> expected, List<Integer> actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + ": expected " + expected + " but was " + actual);
        }
    }
}
