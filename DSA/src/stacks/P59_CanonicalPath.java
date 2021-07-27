package stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class P59_CanonicalPath {
	
	/* Given a string path, which is an absolute path (starting with a slash '/') to a file or
	  directory in a Unix-style file system, convert it to the simplified canonical path.
		In a Unix-style file system, a period '.' refers to the current directory,
	 a double period '..' refers to the directory up a level, and any multiple consecutive slashes
	  (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods 
	  such as '...' are treated as file/directory names.
	The canonical path should have the following format:
	The path starts with a single slash '/'.
	Any two directories are separated by a single slash '/'.
	The path does not end with a trailing '/'.
	The path only contains the directories on the path from the root directory to the 
	target file or directory (i.e., no period '.' or double period '..')
	Return the simplified canonical path.
	 
	Example 1:
	Input: path = "/home/"
	Output: "/home"
	Explanation: Note that there is no trailing slash after the last directory

	 */
	
	/* 1. 
    Input(s)?  String 
    Output ?  String
    Constraints ?   Time Optimized

	2. Test data set
	
	        Positive : "/home/./"
	        Negative : "/home/src/bin"
	        Edge     : "//src/services//..//../files/"
	
	3. Known Approaches
	        Approach 1 : Using Stacks 
	
	4. O-Notations
	
	5. Pseudocode
	 *  1. Split the string to array by /
	 *  2. Create  a stack
	 *  3. Iterate the array
	 *  	If current value is . or "", move to next value
	 *      if current value is .. then pop 
	 *      else push
	 *  4. Iterate stack and return the output as string 
	 * 
	 */
	
	@Test
	public void testData01(){            // Positive
		String input = "/home/./"; 
		Assert.assertTrue(findCanonicalPath(input).equals("/home"));
	}


	@Test
	public void testData02(){			 // Negative
		String input = "/home/src/bin"; 
		Assert.assertTrue(findCanonicalPath(input).equals("/home/src/bin"));
	}

	@Test
	public void testData03(){			 // Edge
		String input = "//src/services//..//../files/"; 
		Assert.assertTrue(findCanonicalPath(input).equals("/files"));
	}

	 /* 1. Split the string to array by /
	 *  2. Create  a stack
	 *  3. Iterate the array
	 *  	If current value is . or "" or /, move to next value
	 *      if current value is .. then pop 
	 *      else push to stack
	 *  4. Iterate stack and append to String builder 
	 *  5. return stringbuilder as string.
	 *  Time : O(2n) -> O(n)
	 *	Space : O(2n) -> O(n) 
	 */
	private String findCanonicalPath(String input) {
		String[] inputArr = input.split("/");
		Stack<String> inputStack = new Stack<>();
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[i].equals("") || inputArr[i].equals("/")|| inputArr[i].equals(".")) continue;
			else if(inputArr[i].equals("..")) inputStack.pop();
			else inputStack.push(inputArr[i]);
		}
		StringBuilder sb = new StringBuilder();
		if(inputStack.empty()) return "/";
		int stackSize = inputStack.size();
		for (int i = 0; i < stackSize; i++) {
			sb.insert(0,inputStack.pop());
			sb.insert(0, "/");
		}
		return sb.toString();
	}

}
