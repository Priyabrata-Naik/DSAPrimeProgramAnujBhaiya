package hashingAndHashMaps.liveSession_1;

import java.util.*;

public class AnagramStrings {
    public static void main(String[] args) {

        String s[] = {"cat", "dog", "god", "act"};
        List<List<Integer>> ans = anagramStrings(s);

        System.out.println(ans);

    }
    static class Anagram{
        int freq[];
        public Anagram(String s){
            freq = new int[26];
            for(int i = 0; i < s.length(); i++){
                freq[s.charAt(i)-'a']++;
            }
        }
        @Override
        public int hashCode(){
            return Arrays.hashCode(freq);
        }
        @Override
        public boolean equals(Object o){
            Anagram that = (Anagram) o;
            return Arrays.equals(this.freq, that.freq);
        }
    }
    static List<List<Integer>> anagramStrings(String strings[]){
        Map<Anagram, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < strings.length; i++){
            String s = strings[i];
            Anagram anagram = new Anagram(s);
            if(!map.containsKey(anagram)){
                map.put(anagram, new ArrayList<>());
            }
            map.get(anagram).add(i+1);
        }
        return new ArrayList<>(map.values());
    }
}
