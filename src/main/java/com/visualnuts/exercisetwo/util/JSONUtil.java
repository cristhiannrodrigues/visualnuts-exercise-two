package com.visualnuts.exercisetwo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visualnuts.exercisetwo.entity.CountryEntity;

import java.util.Arrays;
import java.util.List;

public class JSONUtil {

    public static List<CountryEntity> convertJsonToObj(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return Arrays.asList(mapper.readValue(json, CountryEntity[].class));
    }

}
