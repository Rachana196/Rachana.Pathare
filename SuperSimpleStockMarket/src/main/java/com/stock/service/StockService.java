package main.java.com.stock.service;

import java.util.List;

import main.java.com.stock.model.Stock;
import main.java.com.stock.model.Trade;

public interface StockService {

 
  public void addStock(Stock stock);

  public main.java.com.stock.model.Stock getStock(String symbol);

  public double calculateDividendYield(Stock stock, double price);

  public double calculatePERatio(Stock stock, double price);

  public double calculateVolumeWeightedStockPrice(List<Trade> trades);

  public double calculateGBCE(List<Trade> trades);


}
