public class ValidPalindrome {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null)
            return false;
        //  if (s.length() == 0)
        //      return true;
        // first change all to lower case, then use regular expression to exclude all non alphanumeric characters 
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");  
        int n = s.length();
        for (int i = 0, j = n - 1; i < n && j > -1; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                    return false;
        }
        return true;
    }
}    
/* 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
Example
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Challenge: O(n) time without extra memory.
*/