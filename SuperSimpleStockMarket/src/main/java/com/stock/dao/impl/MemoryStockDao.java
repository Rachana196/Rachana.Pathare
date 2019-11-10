package main.java.com.stock.dao.impl;

import java.util.HashMap;
import java.util.Map;



/**
 * In memory implementation of {@code StockDao}
 * @author nd@nathandeamer.com
 */
public class MemoryStockDao implements main.java.com.stock.dao.StockDao {

  private Map<String, main.java.com.stock.model.Stock> stockMap = new HashMap<String, main.java.com.stock.model.Stock>();

  /**
   * @inheritDoc
   */
  public void addStock(main.java.com.stock.model.Stock stock) {
    stockMap.put(stock.getSymbol(), stock);
  }

  /**
   * @inheritDoc
   */
  public main.java.com.stock.model.Stock getStock(String symbol) {
    return stockMap.get(symbol);
  }

}