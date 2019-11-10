package main.java.com.stock.service.impl;

import java.util.List;

import main.java.com.stock.dao.TradeDao;
import main.java.com.stock.dao.impl.MemoryTradeDao;
import main.java.com.stock.model.Stock;
import main.java.com.stock.model.Trade;
import main.java.com.stock.service.TradeService;

public class TradeServiceImpl implements TradeService {

	  private static TradeServiceImpl instance = null;

	  public static TradeService getInstance() {
	    if (instance == null) {
	      instance = new TradeServiceImpl();
	    }
	    return instance;
	  }

	  private TradeDao tradeDao = new MemoryTradeDao();

	  /**
	   * @inheritDoc
	   */
	  public void recordTrade(Trade trade) {
	    if (trade != null && trade.getStock() != null) {
	      tradeDao.addTrade(trade);
	    }
	  }

	  /**
	   * @inheritDoc
	   */
	  public List<Trade> getTrades(Stock stock, int minutes) {
	    return tradeDao.getTrades(stock, minutes);
	  }

	  /**
	   * @inheritDoc
	   */
	  public List<Trade> getAllTrades() {
	    return tradeDao.getAllTrades();
	  }

}