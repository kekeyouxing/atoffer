package atoffer.string;

import atoffer.array.Vector;

public class StringUtil {
	
	public String replaceSpaces(StringBuffer str) {
		
		if(str == null || str.length() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ' ') {
				sb.append("%20");
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
		
	}
	
	
	public int longestSubStringWithoutDuplication(String s) {
		
		if(s == null||s.length()==0) {
			return 0;
		}
		Vector<Character> temp = new Vector<Character>();
		int max = 0;
		for(int i=0; i<s.length(); i++) {
			
			char ch = s.charAt(i);
			if(temp.contains(ch)) {
				temp.clear();
			}
			temp.addElement(ch);
			if(temp.size()>max) {
				max = temp.size();
			}
			
		}
		return max;
		
	}
    
    /**
     * <p>
     * Given an input string, reverse the string word by word.
     * <p>
     * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/">reverse-words-in-a-string</a>
     */
    public String reverseWords(String s) {
    	
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].length() > 0) {
                sb.append(strings[i]);
                if (i > 0) sb.append(" ");
            }
        }
        return sb.toString();
        
    }

	/**
     * <p>
     * Write a function that reverses a string. The input string is given as an array of characters char[].
	 * Do not allocate extra space for another array, 
	 * you must do this by modifying the input array in-place with O(1) extra memory.
	 * You may assume all the characters consist of printable ascii characters.
     * <p>
     * @see <a href="https://leetcode.com/problems/reverse-string/">reverse-string</a>
     */
    public void reverseString(char[] s) {
    	
    	reverse(s, 0, s.length-1);
    	
    }
    
    
	
    /**
     * @param s
     * @param k
     * @return
     */
    public String leftRotateString(String s,int k) {
        if(k<0 || k>=s.length()) {
        	return s;
        }
        char[] ch = s.toCharArray();
        reverse(ch, 0, k-1);
        reverse(ch, k, s.length()-1);
        reverse(ch, 0, s.length()-1);
        return new String(ch);
    }
    
	private void reverse(char[] ch, int start, int end) {
		while(start<end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
	}
	
	private int StrToInt(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		boolean isNegative = false;
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(i==0) {
				if(ch=='-') {
					isNegative = true;
				}
				continue;
			}
			if(ch<'0' || ch>'9') {
				return 0;
			}
			result = result * 10 + (ch - '0');
		}
		return isNegative ? -result : result;
	}
}
