package com.rateme.search;

import java.util.HashMap;


public class SymbolTable {
    private String[] indexToGusId;
    private HashMap<String, Integer> gusIdToIndex;

    public SymbolTable(int size) {
        indexToGusId = new String[size];
        gusIdToIndex = new HashMap<String, Integer>(size);
    }

    public void add(Integer index, String gusId) {
        indexToGusId[index] = gusId;
        gusIdToIndex.put(gusId, index);
    }

    public Integer getIndex(String gusId) {
        Integer index = gusIdToIndex.get(gusId);
        if(index == null) {
            index = -1;
        }
        return index;
    }

    public String getGusId(Integer index) {
        return indexToGusId[index];
    }

}
