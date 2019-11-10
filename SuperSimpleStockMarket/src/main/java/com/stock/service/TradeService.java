package main.java.com.stock.service;

import java.util.List;

import main.java.com.stock.model.Stock;
import main.java.com.stock.model.Trade;

public interface TradeService {

  public void recordTrade(Trade trade);

  public List<Trade> getTrades(Stock stock, int numberOfMinutes);

  public List<Trade> getAllTrades();
}
