package java_pgms.stringTests;

public class String_literals_comparison {

	public static void main(String[] args) {
		String str1 = "Sathya";
		String str2 = "Sathya";
		String str3 = "sathya";
		
		//Compare str1 and str2 using ==
		if(str1==str2) {
			System.out.println("String literals "+str1+" and "+str2+" are SAME using == operator");
		}
		else
			System.out.println("String literals "+str1+" and "+str2+" are NOT SAME == operator");
		
		//Compare str1 and str3 using ==
				if(str1==str3) {
					System.out.println("String literals "+str1+" and "+str3+" are SAME == operator");
				}
				else
					System.out.println("String literals "+str1+" and "+str3+" are NOT SAME == operator");
		
				//Compare str1 and str2 using equalsMethod
		if(str1.equals(str2)) {
			System.out.println("String literals "+str1+" and "+str2+" are SAME using Equals method");
			}
		else
			System.out.println("String literals "+str1+" and "+str2+" are NOT SAME using Equals method");
				
		//Compare str1 and str3 using equalsMethod
		if(str1.equals(str3)) {
			System.out.println("String literals "+str1+" and "+str3+" are SAME using Equals method");
				}
		else
			System.out.println("String literals "+str1+" and "+str3+" are NOT SAME using Equals method");
	}

}
