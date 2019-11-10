package main.java.com.stock.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class MemoryTradeDao implements main.java.com.stock.dao.TradeDao {

  private Map<String, List<main.java.com.stock.model.Trade>> tradeMap = new HashMap<String, List<main.java.com.stock.model.Trade>>(); // Performance

  /**
   * @inheritDoc
   */
  public void addTrade(main.java.com.stock.model.Trade trade) {
    List<main.java.com.stock.model.Trade> trades = new ArrayList<main.java.com.stock.model.Trade>();
    if (tradeMap.containsKey(trade.getStock().getSymbol())) {
        trades = tradeMap.get(trade.getStock().getSymbol());
    }
    trades.add(trade);
    tradeMap.put(trade.getStock().getSymbol(), trades);
  }

  /**
   * @inheritDoc
   */
  public List<main.java.com.stock.model.Trade> getTrades(main.java.com.stock.model.Stock stock, int minutes) {
    List<main.java.com.stock.model.Trade> result = new ArrayList<main.java.com.stock.model.Trade>();
    Date afterDate = getDateXMinutesEarlier(minutes);
    List<main.java.com.stock.model.Trade> trades = tradeMap.get(stock.getSymbol());
    Collections.sort(trades); // Order by latest trade first.
    Iterator<main.java.com.stock.model.Trade> it = trades.iterator();
    while (it.hasNext()) {
    	main.java.com.stock.model.Trade trade = it.next();
      if (trade.getTimestamp().before(afterDate)) { // Trades are in order. Break for performance.
        break;
      }
      result.add(trade);
    }
    return result;
  }

  /**
   * @inheritDoc
   */
  public List<main.java.com.stock.model.Trade> getAllTrades() {
    List<main.java.com.stock.model.Trade> result = new ArrayList<main.java.com.stock.model.Trade>();
    for (String stockSymbol: tradeMap.keySet()) {
      result.addAll(tradeMap.get(stockSymbol));
    }
    return result;
  }

  private Date getDateXMinutesEarlier(int minutes){
    Calendar c = Calendar.getInstance();
    c.add(Calendar.MINUTE, -minutes);
    return c.getTime();
  }

}
