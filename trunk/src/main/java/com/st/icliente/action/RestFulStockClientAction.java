package com.st.icliente.action;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.st.icliente.dto.LookUpResultListWrapper;
import com.st.icliente.dto.LookupResult;
import com.st.icliente.dto.Quote;
import com.st.icliente.enums.SpringScope;
import com.st.icliente.service.ISStock;

@Component("restFulStockClientAction")
@Scope(SpringScope.VIEW)
public class RestFulStockClientAction {

	private Logger LOG = LoggerFactory
			.getLogger(RestFulStockClientAction.class);
	private String stockName;
	private LookupResult chosenStock;
	private LookUpResultListWrapper stockSymbolList;
	private Quote stockQuote;
	@Autowired
	@Qualifier("stockService")
	private ISStock stockService;

	public void lookUpStockInformationListener() {
		LOG.debug("Sending rest message for stock name : " + stockName);
		stockSymbolList = stockService.lookupStock(stockName);
		LOG.debug("Recovered symbols : "
				+ (CollectionUtils.isEmpty(stockSymbolList) ? null
						: stockSymbolList.size()));
	}

	public void onRowSelect(SelectEvent event) {
		try {
			chosenStock = (LookupResult) event.getObject();
		} catch (Exception e) {
			LOG.error("Cannot cast to LookupResult...");
		}
		if (chosenStock == null) {
			LOG.debug("No stock selected ");
		} else {
			LOG.debug("Selected : " + chosenStock.getName());
			stockQuote = stockService.quote(chosenStock.getSymbol());
		}

	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public LookUpResultListWrapper getStockSymbolList() {
		return stockSymbolList;
	}

	public void setStockSymbolList(LookUpResultListWrapper stockSymbolList) {
		this.stockSymbolList = stockSymbolList;
	}

	public LookupResult getChosenStock() {
		return chosenStock;
	}

	public void setChosenStock(LookupResult chosenStock) {
		this.chosenStock = chosenStock;
	}

	public Quote getStockQuote() {
		return stockQuote;
	}

	public void setStockQuote(Quote stockQuote) {
		this.stockQuote = stockQuote;
	}

}
