class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> map=new HashMap<>();
    for(String word:strs){
        char[] ch=word.toLowerCase().toCharArray();
        Arrays.sort(ch);
        String key=new String(ch);
        map.computeIfAbsent(key,k-> new ArrayList<>()).add(word);
    }
    return new ArrayList<>(map.values());
    }
}