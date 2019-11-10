package main.java.com.stock.dao;

import java.util.List;

import main.java.com.stock.model.Trade;



public interface TradeDao {
	/**
	   * Add {@code Trade} to the db
	   * @param trade
	   */
	  void addTrade(main.java.com.stock.model.Trade trade);

	  /**
	   * Get all {@code Trade} for supplied stock in the last x minutes
	   * @param stock
	   * @param minutes
	   * @return
	   */
	  List<main.java.com.stock.model.Trade> getTrades(main.java.com.stock.model.Stock stock, int minutes);

	  /**
	   * Get all {@code Trade} for all stocks
	   * @return
	   */
	  List<Trade> getAllTrades();

}
