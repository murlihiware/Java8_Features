package com.lambda;

import java.util.Arrays;
import java.util.List;

public class TransformationFromImperativeTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Problem : given the values, double the even numbers and total.

		int result = 0;
		for (int e : numbers) {
			if (e % 2 == 0) {
				result += e * 2;
			}
		}

		System.out.println(result);
		
		System.out.println(numbers.stream()
		       .filter(e -> e%2==0)
		       .map(e -> e*2)
		       .reduce(0,Integer::sum));

	}

}
