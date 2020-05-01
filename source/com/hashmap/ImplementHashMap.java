package com.hashmap;

public class ImplementHashMap {
    private static final int SIZE = 16;
    private Entry[] table = new Entry[SIZE];

    public void put(String key, String value) {
        int hash = key.hashCode()%SIZE;
        Entry curEntry = table[hash];

        if(curEntry != null) {
            boolean valueAssigned = false;
            Entry prevEntry = curEntry;
            do {
                if(curEntry.getKey().equals(key)) {
                    curEntry.setValue(value);
                    valueAssigned = true;
                    break;
                }
                prevEntry = curEntry;
                curEntry = curEntry.getNext();
            } while(curEntry != null);

            if(!valueAssigned) {
                prevEntry.setNext(new Entry(key, value));
            }
        } else {
            table[hash] = new Entry(key, value);
        }
    }

    public String get(String key) {
        int hash = key.hashCode()%SIZE;
        Entry curEntry = table[hash];

        while(curEntry != null) {
            if(curEntry.getKey().equals(key)) {
                return curEntry.getValue();
            }
            curEntry = curEntry.getNext();
        }
        return null;
    }

    public boolean remove(String key) {
        int hash = key.hashCode()%SIZE;
        Entry curEntry = table[hash];
        Entry prevEntry = curEntry;

        while(curEntry != null) {
            if(curEntry.getKey().equals(key)) {
                if((table[hash].hashCode() == curEntry.hashCode()) && table[hash].equals(curEntry)) {
                    table[hash] = curEntry.getNext();
                } else {
                    prevEntry.setNext(curEntry.getNext());
                }
                curEntry = null;
                return true;
            }
            prevEntry = curEntry;
            curEntry = curEntry.getNext();
        }
        return false;
    }
    
    public static void main(String[] args) {
        ImplementHashMap ih = new ImplementHashMap();
        ih.put("A", "1");
        ih.put("B", "2");
        ih.put("C", "3");
        ih.put("D", "4");
        ih.put("E", "5");
        
        System.out.println(ih.get("A"));
        System.out.println(ih.get("B"));
        System.out.println(ih.get("C"));
        System.out.println(ih.get("D"));
        System.out.println(ih.get("E"));

        ih.put("A", "6");
        ih.put("E", "7");

        System.out.println(ih.get("A"));
        System.out.println(ih.get("E"));

        System.out.println(ih.remove("A"));

        System.out.println(ih.get("A"));
        
        System.out.println(ih.remove("E"));

        System.out.println(ih.get("E"));

        System.out.println(ih.remove("E"));
    }
}