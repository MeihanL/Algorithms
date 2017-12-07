class HashFunction {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        int m = key.length;
        long code = 0L;
        for (int i = 0; i < m; i++) { 
            code = (code * 33 + key[i]) % HASH_SIZE; 
        }
        Integer hashcode = (int) (long) code;
        return hashcode;
    }
}

/* NOTE 
* code is long integer, I think one way to avoid overflow is to check if input HASH_SIZE * base, in this case 1000000007 * 33
* if larger than 2^31, use long integer
* in the case of input = "Wrong answer or accepted?", 1000000007, 
* i code
* 0: 87
* 1: 2985
* 2: 98616
* 3: 3254438
* 4: 107396557
* 5: -750880883
* when comes to blank space 107396557*33 is larger than 2^31, so I change code to long integer
*/