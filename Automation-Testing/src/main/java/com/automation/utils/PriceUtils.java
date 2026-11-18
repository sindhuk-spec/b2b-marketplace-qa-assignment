package com.automation.utils;
public final class PriceUtils {
 private PriceUtils(){}
 public static double parsePrice(String displayed){String v=displayed.replaceAll("[^0-9.]","");if(v.isBlank())throw new IllegalArgumentException("Invalid price: "+displayed);return Double.parseDouble(v);}
}
