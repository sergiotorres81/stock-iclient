package com.st.icliente.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class Quote implements Serializable {
	private static final long serialVersionUID = -6311138169138871601L;

	/** Status String Status of quote request */
	@JsonProperty("Status")
	private String status;

	/** Name String Name of the company */
	@JsonProperty("Name")
	private String name;

	/** Symbol String The company's ticker symbol */
	@JsonProperty("Symbol")
	private String symbol;

	/** LastPrice Double The last price of the company's stock */
	@JsonProperty("LastPrice")
	private Double lastPrice;

	/**
	 * Change Double The change in price of the company's stock since the
	 * previous trading day's close
	 */
	@JsonProperty("Change")
	private Double change;

	/**
	 * ChangePercent Double The change percent in price of the company's stock
	 * since the previous trading day's close
	 */
	@JsonProperty("ChangePercent")
	private Double changePercent;

	/**
	 * Timestamp String The last time the company's stock was traded.
	 * Represented as a JavaScript date
	 */
	@JsonProperty("Timestamp")
	private String timeStamp;

	/** MarketCap Double The company's market cap */
	@JsonProperty("MarketCap")
	private Double marketCap;

	/** Volume Int32 The trade volume of the company's stock */
	@JsonProperty("Volume")
	private Integer volume;

	/**
	 * ChangeYTD Double The change in price of the company's stock since the
	 * start of the year
	 */
	@JsonProperty("ChangeYTD")
	private Double changeYTD;

	/**
	 * ChangePercentYTD Double The change percent in price of the company's
	 * stock since the start of the year
	 */
	@JsonProperty("ChangePercentYTD")
	private Double changePercentYTD;

	/** High Double The high price of the company's stock in the trading session */
	@JsonProperty("High")
	private Double high;

	/** Low Double The low price of the company's stock in the trading session */
	@JsonProperty("Low")
	private Double low;

	/**
	 * Open Double The opening price of the company's stock at the start of the
	 * trading session
	 */
	@JsonProperty("Open")
	private Double open;

	public Quote() {
		super();
	}

	public Quote(String status, String name, String symbol,
			Double lastPrice, Double change, Double changePercent,
			String timeStamp, Double marketCap, Integer volume,
			Double changeYTD, Double changePercentYTD, Double high, Double low,
			Double open) {
		super();
		this.status = status;
		this.name = name;
		this.symbol = symbol;
		this.lastPrice = lastPrice;
		this.change = change;
		this.changePercent = changePercent;
		this.timeStamp = timeStamp;
		this.marketCap = marketCap;
		this.volume = volume;
		this.changeYTD = changeYTD;
		this.changePercentYTD = changePercentYTD;
		this.high = high;
		this.low = low;
		this.open = open;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public Double getChangePercent() {
		return changePercent;
	}

	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getChangeYTD() {
		return changeYTD;
	}

	public void setChangeYTD(Double changeYTD) {
		this.changeYTD = changeYTD;
	}

	public Double getChangePercentYTD() {
		return changePercentYTD;
	}

	public void setChangePercentYTD(Double changePercentYTD) {
		this.changePercentYTD = changePercentYTD;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

}
