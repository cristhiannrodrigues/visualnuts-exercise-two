package com.visualnuts.exercisetwo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

public class JSONUtilTest {

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
    public void testConvert() throws JsonProcessingException {
        JSONUtil.convertJsonToObj(JSON);
    }

}
