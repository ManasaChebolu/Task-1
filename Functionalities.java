package training;
import java.util.*;
class AllPrograms   {
public void duplicate(String str) {
	char[] carray=str.toCharArray();
	System.out.print("Duplicate Elements: ");
	for(int i=0;i<str.length();i++) {
		int count=0;
		for(int j=i+1;j<str.length();j++) {
			if(carray[i]==carray[j]) {
				count++;
				carray[j]='0';
			}
		}
		if(count>=1 && carray[i] !='0') {
			System.out.print(carray[i]+ " ");
		}
	}
	System.out.println();
}
public void reverse(String str) {
	if(str==null || str.length()<=1) {
		System.out.println(str);
	}
	else {
		System.out.print(str.charAt(str.length()-1));
		reverse(str.substring(0,str.length()-1));
	}
}
public void occurance(String str) {
	char[] carray=str.toCharArray();
	System.out.println("Count of Element: ");
	for(int i=0;i<str.length();i++) {
		int count=1;
		for(int j=i+1;j<str.length();j++) {
			if(carray[i]==carray[j]) {
				count++;
				carray[j]='0';
			}
		}
		if(carray[i]!='0') 
		System.out.println(carray[i] +"-"+ count);
		}
	}
public String swapping(String str,int i,int j) {
	char[] carray=str.toCharArray();
	char b;
	b=carray[i];
	carray[i]=carray[j];
	carray[j]=b;
	return String.valueOf(carray);
}
public void permutation(String str,int start,int end) {
	if(start==end-1) {
		System.out.println(str);
	}
	else {
		for(int i=start;i<end;i++) {
			str=swapping(str,start,i);
			permutation(str,start+1,end);
			str=swapping(str,start,i);
		}
	}
}
public void longestSubstringLength(String str,int end) {
	int max=0;
	for(int i=0;i<end;i++) {
		boolean[] visitedArray=new boolean[256];
		for(int j=i;j<end;j++) {
			if(visitedArray[str.charAt(j)]==true) 
				break;
			else {
				max=Math.max(max, j-i+1);
				visitedArray[str.charAt(j)]=true;
			}
		}
	}
	System.out.println(max);
}
public void append(String str, String str1) {
	int s1=str.length();
	int s2=str1.length();
	if(s1>s2) {
		int len=s1-s2;
		System.out.println(str.substring(len,s1)+str1);
	}
	else if(s1<s2) {
		int len=s2-s1;
		System.out.println(str+str1.substring(len,s2));
	}
	else 
		System.out.println("String after appending when they are of equal length: "+(str+str1));
}
}
public class Functionalities extends AllPrograms {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	AllPrograms all=new AllPrograms();
	String str=sc.nextLine();
	all.duplicate(str);
	System.out.print("Reverse String:");
	all.reverse(str);
	all.occurance(str);
	System.out.println("All permutations are: ");
	int end=str.length();
	int start=0;
	all.permutation(str, start, end);
	System.out.print("Longest substring length: ");
	all.longestSubstringLength(str,end);
	System.out.print("Enter second string:");
	String str1=sc.nextLine();
	all.append(str, str1);
}
}

