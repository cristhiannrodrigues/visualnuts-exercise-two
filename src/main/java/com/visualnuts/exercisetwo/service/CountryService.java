package com.visualnuts.exercisetwo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.visualnuts.exercisetwo.entity.CountryEntity;
import com.visualnuts.exercisetwo.util.JSONUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {

    final static Map<String, Integer> languageMap = new HashMap<>();

    public static List<String> findTheMostCommonOfficialLanguages(List<CountryEntity> countries) {

        countries
                .forEach(
                        i -> i.getLanguages()
                                .forEach(CountryService::verifyLanguageMap)
                );
        return selectMostCommon();
    }

    private static List<String> selectMostCommon() {
       List<String> listReturn = new ArrayList<>();
        Integer biggest = 0;
        for(Map.Entry<String,Integer> map : languageMap.entrySet()) {
            if(map.getValue() >= biggest) {
                biggest = map.getValue();
                listReturn.add(map.getKey());
            }
        }
        return listReturn;
    }

    private static void verifyLanguageMap(String language) {
        if (languageMap.containsKey(language)) {
            languageMap.put(language, languageMap.get(language) + 1);
        } else {
            languageMap.put(language, 1);
        }
    }

    public static Integer countAllLanguages(List<CountryEntity> countries) {
        countries
                .forEach(
                        i -> i.getLanguages()
                                .forEach(CountryService::verifyLanguageMap)
                );

        return languageMap.size();
    }

    public static Integer countriesInTheWorld(List<CountryEntity> countries) throws JsonProcessingException {
        return countries.size();
    }

    public static CountryEntity findCountryWithTheMostOfficialLanguagesWhereTheyOfficiallySpeakGe(List<CountryEntity> countries) throws JsonProcessingException {
        List<CountryEntity> countriesHaveGe = countries
                .stream()
                .filter(i -> i.getLanguages().contains("de")).collect(Collectors.toList());
        return getCountryWithMoreLanguages(countriesHaveGe);
    }

    public static CountryEntity findCountryWithTheBighestNumberOfOfficialLanguages(List<CountryEntity> countries) {
        return getCountryWithMoreLanguages(countries);
    }

    public static CountryEntity getCountryWithMoreLanguages(List<CountryEntity> countries) {
        CountryEntity countryReturn = countries.stream().findFirst().get();
        for(CountryEntity country : countries) {
            if(country.getLanguages().size() > countryReturn.getLanguages().size()) {
                countryReturn = country;
            }
        }
        return countryReturn;
    }

    public static List<CountryEntity> getCountries(String json) throws JsonProcessingException {
        return JSONUtil.convertJsonToObj(json);
    }

}
