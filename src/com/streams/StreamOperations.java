/**
 * 
 */
package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Murlidhar.Hiware
 *
 */
public class StreamOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Transaction> transactions = createTransactions();
		
		Integer maxTransaction = getMaxGroceryTransaction(transactions);
		
		
		/*
		 * SELECT MAX(value) from transactions where type='GROCERY';
		 * As you can see, we don’t need to implement how to calculate the maximum value 
		 * (for example, using loops and a variable to track the highest value). We only express what we expect
		 */
		System.out.println("Max Transaction(Grocery):"+maxTransaction+ " Before Java 8");
		
//		getSquareOfTwoEvenNumbers();
		
//		Integer maxTransaction2 = getMaxGroceryTransactionJava8(transactions);
//		System.out.println("Max Transaction(Grocery):"+maxTransaction2+ " Using Java 8");
		

	}

	public static Integer getMaxGroceryTransaction(List<Transaction> transactions)
	{
		List<Transaction> groceryTransactions = new ArrayList<>();
		for(Transaction t: transactions){
		  if(t.getType() == Transaction.TYPE_GROCERY){
		    groceryTransactions.add(t);
		  }
		}
		
		Collections.sort(groceryTransactions, new Comparator<Transaction>(){
			
			@Override
			public int compare(Transaction t1, Transaction t2) {
				return Integer.compare(t2.getValue(), t1.getValue());
			}
			});
		return groceryTransactions.get(0).getValue();
	}
	
	public static Integer getMaxGroceryTransactionJava8(List<Transaction> transactions)
	{
		//definition of below operations you can find in java.util.stream.Stream Interface
		return transactions.stream()
				.filter(t -> t.getType() == Transaction.TYPE_GROCERY)
				.map(t -> t.getValue())
				.max((t1, t2) -> Integer.compare(t1, t2)).get(); // max Returns Optional Object => A container object which may or may not contain a non-null value.


	}
	
	public static void getSquareOfTwoEvenNumbers() {
		//Stream Operations Are Lazy
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = 
		    numbers.stream() // real use of default method, if there wouldn't have been default methods in Interfaces every collection has to implement this method
		           .filter(n -> n % 2 == 0)
		           .map(n -> n * n)
		           .limit(2)
		           .collect(Collectors.toList());
		
		
		/*List<Integer> twoEvenSquares = 
			    numbers.stream()
			           .filter(n -> {
			                    System.out.println("filtering " + n); 
			                    return n % 2 == 0;
			                  })
			           .map(n -> {
			                    System.out.println("mapping " + n);
			                    return n * n;
			                  })
			           .limit(2)
			           .collect(Collectors.toList());*/
	}
	
	
	
	
	
	
	
	
	
	public static List<Transaction> createTransactions()
 {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(1, Transaction.TYPE_GROCERY, 1000));
		transactions.add(new Transaction(2, Transaction.TYPE_GROCERY, 500));
		transactions.add(new Transaction(3, Transaction.TYPE_GROCERY, 200));
		transactions.add(new Transaction(4, Transaction.TYPE_GROCERY, 4500));
		transactions.add(new Transaction(5, Transaction.TYPE_GROCERY, 9500));
		transactions.add(new Transaction(6, Transaction.TYPE_ELECTRONICS, 10500));
		transactions.add(new Transaction(7, Transaction.TYPE_ELECTRONICS, 12500));
		transactions.add(new Transaction(8, Transaction.TYPE_ELECTRONICS, 14500));
		transactions.add(new Transaction(9, Transaction.TYPE_ELECTRONICS, 24500));
		transactions.add(new Transaction(10, Transaction.TYPE_BOOKS, 500));
		transactions.add(new Transaction(11, Transaction.TYPE_BOOKS, 100));
		transactions.add(new Transaction(12, Transaction.TYPE_BOOKS, 3100));
		transactions.add(new Transaction(13, Transaction.TYPE_BOOKS, 1200));
		return transactions;
	}

}


class Transaction
{
	public static final int TYPE_GROCERY = 1;
	public static final int TYPE_ELECTRONICS = 2;
	public static final int TYPE_BOOKS = 3;
	int id;
	private int type;
	private int value;
	
	
	
	public Transaction(int id, int type, int value) {
		this.id = id;
		this.type = type;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}