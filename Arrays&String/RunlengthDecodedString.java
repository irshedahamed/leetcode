/*
	Binary Search.com : Run-Length Decoded String Iterator
    Example 1
	Input
	methods = ["constructor", "next", "hasnext", "next", "next", "hasnext"]
	arguments = [["2a1b"], [], [], [], [], []]`
	Output
	[null, "a", true, "a", "b", false]
*/

class RunLengthDecodedIterator {
    String s;
    int indx = 0;
    Deque<String> list;

    private String getNum() {
        StringBuilder sb = new StringBuilder();
        for(;indx<s.length();indx++) {
            if(!Character.isDigit(s.charAt(indx))) return sb.toString();
            sb.append(s.charAt(indx));
        }
        return "";
    }
    public RunLengthDecodedIterator(String s) {
        this.s = s;
        list = new LinkedList<>();
        for(;indx<s.length();indx++) {
            if(Character.isDigit(s.charAt(indx))) {
                list.add(getNum());
            }
            list.add(String.valueOf(s.charAt(indx)));
        }
    }

    public String next() {
        String digit = list.removeFirst();

        int num = Integer.parseInt(digit);
        String res = list.getFirst();
        num -= 1;

        if(num == 0) list.removeFirst();
        else list.addFirst(String.valueOf(num));  

        return res;
    }

    public boolean hasnext() {
        return list.size() != 0;
    }
}