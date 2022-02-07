package com.example.springbootExample.model;

public class CountryModel {
	 private String countryCode;
	    private String countryName;
		/**
		 * @return the countryCode
		 */
		public String getCountryCode() {
			return countryCode;
		}
		/**
		 * @param countryCode the countryCode to set
		 */
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		/**
		 * @param countryCode
		 * @param countryName
		 */
		public CountryModel(String countryCode, String countryName) {
			super();
			this.countryCode = countryCode;
			this.countryName = countryName;
		}
		/**
		 * @return the countryName
		 */
		public String getCountryName() {
			return countryName;
		}
		/**
		 * @param countryName the countryName to set
		 */
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
}
