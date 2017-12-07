/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

public class FirstBadVersion {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 1)
            return 1;
        if (SVNRepo.isBadVersion(1) == true)
            return 1;
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid) == false)
                start = mid;
            else if (SVNRepo.isBadVersion(mid) == true)
                end = mid;
        }
        if (SVNRepo.isBadVersion(start + 1) == false)
            return end;
        else
            return start + 1;
    }
}



/* The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, 
 * so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

You can call isBadVersion to help you determine which version is the first bad one. 
The details interface can be found in the code's annotation part.
Notice: Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
For example, Java is SVNRepo.isBadVersion(v)

Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true

Here we are 100% sure that the 4th version is the first bad version.
*/
