class Solution{
    public static Map<Integer, Integer> map;
    public static Map<Integer, Integer> depthMap;


    public static void dfs(Node root, int level, int depth) {
        if (root == null)
            return;

        if (depthMap.getOrDefault(level, Integer.MAX_VALUE) > depth) {
            map.put(level, root.data);
            depthMap.put(level, depth);
        }

        dfs(root.left, level - 1, depth + 1);
        dfs(root.right, level + 1, depth + 1);
    }

    public static void topView(Node root) {
        map = new TreeMap<>();
        depthMap = new HashMap<>();

        dfs(root, 0, 0);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

}