package com.example.springbootExample.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.springbootExample.model.CountryModel;

@Component
public class CountryDAO {
 static Map<String,CountryModel> countryMap = new HashMap<String, CountryModel>();
 @Bean
 public static void initData() {
 countryMap.put("VTN", new CountryModel("VTN", "Vietnam"));
 countryMap.put("FRA", new CountryModel("FRA","France"));
 countryMap.put("ENG", new CountryModel("ENG","England"));
 countryMap.put("USA",new CountryModel("USA","America"));
 countryMap.put("RUS",new CountryModel("RUS","Russia"));
 }
 public CountryModel findCountryByCode(String  s) {
	 return countryMap.get(s);
 }
 public List findAllCountries() {
	 return new ArrayList(countryMap.values());
 }
}
