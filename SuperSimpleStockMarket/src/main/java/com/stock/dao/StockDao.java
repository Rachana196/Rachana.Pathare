package main.java.com.stock.dao;

import main.java.com.stock.model.Stock;

public interface StockDao {
	
	  void addStock(main.java.com.stock.model.Stock stock);

	  Stock getStock(String symbol);

}
