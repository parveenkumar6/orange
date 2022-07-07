package BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromeSubStr {
    //Recursion
    public String longestPalindrome(String s) {
        /*
        List<String> strList = new ArrayList<>();
        for(int i = 0; i <= s.length(); i++){
            String check = s.substring(0, i);
            System.out.println(check);
            if (isPalindrome(check)){
                strList.add(check);
            }
        }
        for(int i = s.length()-1; i >=0; i--){
            String check = s.substring(i,0);
            System.out.println(check);
            if (isPalindrome(check)){
                strList.add(check);
            }
        }*/
        int right = s.length();
        int left = 0;
        List<String> strLists = new ArrayList<>();
        while(left < right){
            String st =  s.substring(left, right);
            if(isPalindrome(st)){
                strLists.add(st);
            }
            left++; right--;
        }
        //System.out.println(strList);
        System.out.println(strLists);
        System.out.println(Collections.max(strLists, Comparator.comparing(String::length)));
        return Collections.max(strLists, Comparator.comparing(String::length));
    }
    private boolean isPalindrome(String s){
        if(s.length() <= 1){
            return true;
        }else {
            return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
        }
    }
    public static void main(String[] args) {
        String input = "abbc";
        String ans = new LongestPalindromeSubStr().longestPalindrome(input);
        System.out.println(ans);
    }
}
