package sif3.hits.utils;

import sif.dd.au30.model.AUCodeSetsNameUsageTypeType;
import sif.dd.au30.model.ISO4217CurrencyNamesAndCodeElementsType;

public interface UsesConstants {

  public static final ISO4217CurrencyNamesAndCodeElementsType DEFAULT_CURRENCY_ENUM = ISO4217CurrencyNamesAndCodeElementsType.AUD;
  public static final String DEFAULT_CURRENCY = DEFAULT_CURRENCY_ENUM.name();
  public static final String DEFAULT_PHONE_TYPE = "0096";
  public static final String DEFAULT_EMAIL_TYPE = "06";
  public static final AUCodeSetsNameUsageTypeType DEFAULT_NAME_TYPE_ENUM = AUCodeSetsNameUsageTypeType.LGL;
  public static final String DEFAULT_NAME_TYPE = DEFAULT_NAME_TYPE_ENUM.name();

}
