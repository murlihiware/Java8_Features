import java.util.Arrays;
import java.util.Comparator;

public class LengthComparatorUsingLambda {

	public static void main(String[] args) {
		String[] strings = { "Prince", "Murli", "Gourav","Za" };
		
		//before java 8
		Arrays.sort(strings,new LengthComparisonComparator());
		
		//one line code
		Arrays.sort(strings, (String first, String second) -> Integer.compare(first.length(), second.length()));

		//type inference
		Arrays.sort(strings, (first,second) -> Integer.compare(first.length(), second.length()));

		//multiple line code
		Arrays.sort(strings, (String first, String second) -> {
			if (first.length() < second.length())
				return -1;
			else if (first.length() > second.length())
				return 1;
			else
				return 0;
		});
		
		Comparator<String> comparator = 
				(first,second) //same as (String first, String second)
				-> Integer.compare(first.length(), second.length());

		Arrays.sort(strings, comparator);
		
		Arrays.sort(strings, LengthComparatorUsingLambda::compareByLength);
		
		for(String s : strings)
			System.out.println(s);
	}
	
	public static int compareByLength(String l1,String l2)
	{
		return Integer.compare(l1.length(), l2.length());
	}
}

class LengthComparisonComparator implements Comparator<String>{

	@Override
	public int compare(String first, String second) {
		return Integer.compare(first.length(), second.length());
	}
	
}
