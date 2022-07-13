class Solution {
    public boolean isAnagram(String s, String t) {
        Integer[] arr = new Integer[26];
        for(int i = 0;i < 26;i++)
            arr[i]=0;
        for(int itr = 0; itr<s.length(); itr++){
            int val = (int) s.charAt(itr) - 'a';
            arr[val]++;
        }
        for(int itr = 0; itr<t.length(); itr++){
            int val = (int) t.charAt(itr) - 'a';
            arr[val]--;
        }
        
         for(int i = 0;i < 26;i++){
             if(arr[i]!=0)
                 return false;
         }
        
        return true;
    }
}
