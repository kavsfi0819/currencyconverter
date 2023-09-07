package com.MicroserviceCS;

	import java.math.BigDecimal;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.core.env.Environment;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class Controller {

	    @Autowired
	    private Environment environment;

	    @GetMapping("/currency-exchange-sample/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")
	    public Value retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
	        BigDecimal conversionMultiple = null;
	        Value exchangeValue= new Value();
	        
	        if (fromCurrency != null && toCurrency != null) {
	            if (fromCurrency.equalsIgnoreCase("USD") && toCurrency.equalsIgnoreCase("INR")) {
	                conversionMultiple = BigDecimal.valueOf(83);
	            } else if (fromCurrency.equalsIgnoreCase("INR") && toCurrency.equalsIgnoreCase("USD")) {
	                conversionMultiple = BigDecimal.valueOf(0.012);
	            } else if (fromCurrency.equalsIgnoreCase("EUR") && toCurrency.equalsIgnoreCase("INR")) {
	                conversionMultiple = BigDecimal.valueOf(90);
	            } else if (fromCurrency.equalsIgnoreCase("INR") && toCurrency.equalsIgnoreCase("EUR")) {
	                conversionMultiple = BigDecimal.valueOf(0.01);
	            } else if (fromCurrency.equalsIgnoreCase("AUD") && toCurrency.equalsIgnoreCase("INR")) {
	                conversionMultiple = BigDecimal.valueOf(53);
	            } else if (fromCurrency.equalsIgnoreCase("INR") && toCurrency.equalsIgnoreCase("AUD")) {
	                conversionMultiple = BigDecimal.valueOf(0.01);
	            }
	        }

	        exchangeValue = new Value();
	        
	        // Set the port directly instead of using environment property
	     //   exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	        
	        return exchangeValue;
	    }
	}
