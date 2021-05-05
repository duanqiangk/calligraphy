package com.dqit.calligraphy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil<T> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultObject toObject(String data , Class t){
        try {
            return new ResultObject(objectMapper.readValue(data, t));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static<T> List<T> toObjectList(String data , Class t){
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, t);
            return objectMapper.readValue(data , collectionType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> parseStringList(String data){
        try {
            return objectMapper.readValue(data, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    @AllArgsConstructor
    public static class ResultObject{
        private Object object;

        public Object toObject(){
            return object;
        }

        public List<String> toListString(){
            return (List<String>) object;
        }
    }
}
