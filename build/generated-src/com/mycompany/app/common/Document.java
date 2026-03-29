package com.mycompany.app.common;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Document implements Serializable {

    private String entity;
    private Map<String, Object> map = new HashMap<>();

    public Document() {}

    public Document(String entity) {
        this.entity = entity;
    }

    public Document(String entity, Map<String, Object> map) {
        this.entity = entity;
        this.map = map;
    }

    @JsonIgnore
    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    @JsonAnySetter
    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getMap() {
        return this.map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void putAll(Map<String, Object> map) {
        this.map.putAll(map);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public Object remove(String key) {
        return this.map.remove(key);
    }

    public void clear() {
        this.map.clear();
    }


}
