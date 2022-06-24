class Solution {
    private Map<String, Boolean> tmp = new HashMap<>();
    
    public boolean wordBreak(String s, List<String> dict) {
        Map<String, List<String>> index = new HashMap<String, List<String>>();
        
        for(String word : dict) {
            String firstChar = word.substring(0,1);
            
            List<String> words;
            if (index.get(firstChar) == null) {
                words = new ArrayList<String>();
            } else {
                words = index.get(firstChar);
            }
            
            words.add(word);
            index.put(firstChar, words);
        }
        
        return subWordBreak(s, index);
    }
    
    private boolean subWordBreak(String s, Map<String, List<String>> index) {
        if (s == null || s.length() < 1) {
            return true;
        }

        if (tmp.containsKey(s) && tmp.get(s) == false) {
            return false;
        }
        
        String pivotChar = s.substring(0,1);
        List<String> words = index.get(pivotChar);
        
        if (words == null) {
            return false;
        }
        
        for(String word : words) {
            if (s.startsWith(word)) {
                System.out.println(s + " :: " + word + " >> " + s.substring(word.length(), s.length()));
                if (subWordBreak(s.substring(word.length(), s.length()), index)) return true;
            }
        }
        
        tmp.put(s, false);
        return false;
    }
}