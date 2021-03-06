class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sorted = sortString(str);
            if (map.containsKey(sorted)) {
                List<String> list = (List<String>) map.get(sorted);
                list.add(str);
                map.put(sorted, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
    public String sortString(String s) {
        char[] res = s.toCharArray();
        Arrays.sort(res);
        return new String(res);
    }
}