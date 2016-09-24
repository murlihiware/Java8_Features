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
		
		System.out.println("Max Transaction(Grocery):"+maxTransaction+ " Before Java 8");
		
		/*
		 * SELECT MAX(value) from transactions where type='GROCERY';
		 * As you can see, we don’t need to implement how to calculate the maximum value 
		 * (for example, using loops and a variable to track the highest value). We only express what we expect
		 */
		
//		getSquareOfTwoEvenNumbers();
		
//		Integer maxTransaction2 = getMaxGroceryTransactionJava8(transactions);
//		System.out.println("Max Transaction(Grocery):"+maxTransaction2+ " Using Java 8");
		

		List<Trade> trades = createTrades();
		Integer minPrice = getMinPriceOfOptionTrade(trades);
		System.out.println("Min Price of Option Trade:"+minPrice);
		/*
		 * SELECT min(price) from trades where type='OPTION';
		 * As you can see, we don’t need to implement how to calculate the minimum value 
		 * (for example, using loops and a variable to track the lowest value). 
		 * We only express what we expect
		 */
		
		Integer minPrice2 = getMinPriceOfOptionTradeJava8(trades);
		System.out.println("Min Price of Option Trade:"+minPrice2 + " Using Java 8");
		

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
	
	public static void getSumOfIntegers()
	{
		
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		//Specialized stream for int type => IntStream
		int total = Arrays.stream(numbers).sum();
		System.out.println("Sum:"+total);
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

	public static Integer getMinPriceOfOptionTrade(List<Trade> trades)
	{
		List<Trade> optionTrades = new ArrayList<>();

		for (Trade trade : trades) {
			if (trade.getType() == Trade.TYPE_OPTION)
				optionTrades.add(trade);
		}
		Collections.sort(optionTrades, new Comparator<Trade>(){

			@Override
			public int compare(Trade t1, Trade t2) {
				return Integer.compare(t1.getPrice(), t2.getPrice());
			}
		});
		
		return optionTrades.get(0).getPrice();
	}
	
	public static Integer getMinPriceOfOptionTradeJava8(List<Trade> trades)
	{
		return trades.stream()
		.filter(t-> t.getType()==Trade.TYPE_OPTION)
		.map(t-> t.getPrice())
		.min((t1,t2)->Integer.compare(t1, t2)).get();
	}
	
	public static List<Trade> createTrades()
	{
		List<Trade> trade = new ArrayList<>();
		trade.add(new Trade(1, Trade.TYPE_FUTURE, 10000));
		trade.add(new Trade(2, Trade.TYPE_FUTURE, 12000));
		trade.add(new Trade(3, Trade.TYPE_SWAP, 990));
		trade.add(new Trade(4, Trade.TYPE_SWAP, 690));
		trade.add(new Trade(5, Trade.TYPE_OPTION, 790));
		trade.add(new Trade(6, Trade.TYPE_OPTION, 890));
		trade.add(new Trade(7, Trade.TYPE_FUTURE, 11890));
		trade.add(new Trade(8, Trade.TYPE_OPTION, 1890));
		trade.add(new Trade(9, Trade.TYPE_OPTION, 90));
		trade.add(new Trade(10, Trade.TYPE_OPTION, 290));
		return trade;
	}
}


class Trade

{
	public static final int TYPE_FUTURE=1;
	public static final int TYPE_OPTION=2;
	public static final int TYPE_SWAP=2;
	
	private int id;
	private int type;
	private int price;
	
	public Trade(int id, int type, int price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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