package com.visualnuts.exercisetwo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CountryServiceTest {

    private final String JSON = "[\n" +
            "{\n" +
            "country: \"US\",\n" +
            "languages: [ \"en\" ] },\n" +
            "{\n" +
            "country: \"BE\",\n" +
            "languages: [ \"nl\", \"fr\", \"de\" ]\n" +
            "}, {\n" +
            "country: \"NL\",\n" +
            "languages: [ \"nl\", \"fy\" ] },\n" +
            "{\n" +
            "country: \"DE\", languages: [ \"de\" ]\n" +
            "}, {\n" +
            "country: \"ES\",\n" +
            "languages: [ \"es\" ] }\n" +
            "]";

    @Test
    public void printTheMostCommonOfficialLanguagesTest() throws JsonProcessingException {
        List<String> mostCommon = CountryService.findTheMostCommonOfficialLanguages(CountryService.getCountries(JSON));
        for(String country : mostCommon) {
            System.out.print(country + ", ");
        }
        System.out.print(" are the most common.");
    }

    @Test
    public void printCountriesTest() throws JsonProcessingException {
        System.out.println(CountryService.countriesInTheWorld(CountryService.getCountries(JSON)) + " COUNTRIES IN THE WORLD.");
    }

    @Test
    public void printAllLanguages() throws JsonProcessingException {
        System.out.println(CountryService.countAllLanguages(CountryService.getCountries(JSON)) + " languages spoken in the listed countries.");
    }

    @Test
    public void printCountryWithTheMostOfficialLanguagesWhereTheyOfficiallySpeakGeTest() throws JsonProcessingException {
        System.out.println(CountryService.findCountryWithTheMostOfficialLanguagesWhereTheyOfficiallySpeakGe(CountryService.getCountries(JSON)).getCountry() + " is the country with the most official languages, where they officially speak German (de). - that counts all the official languages spoken in the listed countries.");
    }

    @Test
    public void printCountryWithTheBighestNumberOfOfficialLanguages() throws JsonProcessingException {
        System.out.println(CountryService.findCountryWithTheBighestNumberOfOfficialLanguages(CountryService.getCountries(JSON)).getCountry() + " is the country with the highest number of official languages.");
    }

}
