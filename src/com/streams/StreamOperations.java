/**
 * 
 */
package com.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		Transaction maxTransaction1 = getMaxGroceryTransaction(transactions);
		System.out.println(maxTransaction1.getValue());
		
		Transaction maxTransaction2 = getMaxGroceryTransactionJava8(transactions);
		System.out.println(maxTransaction2.getValue());

	}
	
	public static Transaction getMaxGroceryTransaction(List<Transaction> transactions)
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
		return groceryTransactions.get(0);
	}
	
	public static Transaction getMaxGroceryTransactionJava8(List<Transaction> transactions)
	{
		return (Transaction) transactions.stream().filter(t -> t.getType()==Transaction.TYPE_GROCERY)
		.sorted((t1, t2)-> 
		Integer.compare(t2.getValue(), t1.getValue())).toArray()[0];
	    
	}
	
	
	
	
	
	public static List<Transaction> createTransactions()
 {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(Transaction.TYPE_GROCERY, 1000));
		transactions.add(new Transaction(Transaction.TYPE_GROCERY, 500));
		transactions.add(new Transaction(Transaction.TYPE_GROCERY, 200));
		transactions.add(new Transaction(Transaction.TYPE_GROCERY, 4500));
		transactions.add(new Transaction(Transaction.TYPE_GROCERY, 9500));
		transactions.add(new Transaction(Transaction.TYPE_ELECTRONICS, 10500));
		transactions.add(new Transaction(Transaction.TYPE_ELECTRONICS, 12500));
		transactions.add(new Transaction(Transaction.TYPE_ELECTRONICS, 14500));
		transactions.add(new Transaction(Transaction.TYPE_ELECTRONICS, 24500));
		transactions.add(new Transaction(Transaction.TYPE_BOOKS, 500));
		transactions.add(new Transaction(Transaction.TYPE_BOOKS, 100));
		transactions.add(new Transaction(Transaction.TYPE_BOOKS, 3100));
		transactions.add(new Transaction(Transaction.TYPE_BOOKS, 1200));
		return transactions;
	}

}


class Transaction
{
	public static final int TYPE_GROCERY = 1;
	public static final int TYPE_ELECTRONICS = 2;
	public static final int TYPE_BOOKS = 3;
	private int type;
	private int value;
	
	
	
	public Transaction(int type, int value) {
		this.type = type;
		this.value = value;
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