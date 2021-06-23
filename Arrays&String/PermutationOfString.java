class Solution {
    public boolean checkInclusion(String s1, String s2) {
       Map<Character,Integer> map = new HashMap<>();
        
        for(int itr = 0;itr < s1.length();itr++){
            map.put(s1.charAt(itr),map.getOrDefault(s1.charAt(itr),0)+1);
        }
      
        
        Map<Character,Integer> map2 = new HashMap<>();
        int windowStart = 0;
        for(int windowEnd = 0 ;windowEnd < s2.length() ; windowEnd++){
            map2.put(s2.charAt(windowEnd) , map.getOrDefault(s2.charAt(windowEnd) , 0)+1);
            
            if(windowEnd - windowStart + 1 >= s1.length()){
                if(compare(map,map2))
                    return true;
                map2.put(s2.charAt(windowStart) , map2.get(s2.charAt(windowStart)) - 1 );
                windowStart++;
            }
        }
        return false;
    }
    
    public boolean compare(Map<Character,Integer> map1,Map<Character,Integer> map2){
        for(Map.Entry entry : map1.entrySet()){
            char key = (char) entry.getKey();
            int value = (int) entry.getValue();
            if(!map2.containsKey(key) || map2.get(key)!=value)
                return false;   
        }
        
        return true;
    }
}