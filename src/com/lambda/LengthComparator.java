package com.lambda;
import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	public int compare(String first, String second) {
		return Integer.compare(first.length(), second.length());
	}
}

// Arrays.sort(strings, new LengthComparator());


//swing GUI example 
/*
	button.setOnAction(new EventHandlet<ActionEvent>()){
	public void handle(ActionEvent event) {
		System.out.println("Thanks for clicking");
	}
}

*/




