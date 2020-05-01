package com.hashmap;

public class Entry {
    private final String key;
    private String value;
    private Entry next;

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}