public class RotateString {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     * Given a string and an offset, rotate string by offset. (rotate from left to right)
     * Example
     * Given "abcdefg".
     * offset=0 => "abcdefg"
     * offset=1 => "gabcdef"
     * offset=2 => "fgabcde"
     * offset=3 => "efgabcd"
     */
    
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0 || offset < 0) {
            return;
        }
        int n = str.length;
        offset = offset % n;  // in case of offset > str.length
        reverse(str, 0, n - offset - 1);
        reverse(str, n - offset, n - 1);
        reverse(str, 0, n - 1);
    }
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}