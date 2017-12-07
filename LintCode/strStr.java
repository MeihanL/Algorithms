public class strStr {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null)
            return -1;
        int j;
        for (int i = 0; i < source.length() - target.length()+1; i++) {
            for (j = 0; j < target.length(); j++) 
                if (source.charAt(i+j) != target.charAt(j)) break;
            if (j == target.length()) return i;
        }
        return -1;
    }
}

public class strStr {
    // This solution did consider the case of [null, null], and in case of empty string ["", ""], report error, since i<0
   
    public int strStr(String source, String target) {
        // write your code here
        int i, j;
        for (i = 0; i < source.length(); i++) {
            for (j = 0; j < target.length(); j++) 
                if (source.charAt(i+j) != target.charAt(j)) break;
            if (j == target.length()) return i;
        }
        return -1;
    }
}

