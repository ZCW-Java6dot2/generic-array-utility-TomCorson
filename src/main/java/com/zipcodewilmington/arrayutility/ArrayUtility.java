package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    private T [] array;
    public ArrayUtility(T [] inputArray) {
        this.array = inputArray;
    }

    public  Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int mergedSize = arrayToMerge.length  + array.length;
        T [] merged = (T[]) new Object [mergedSize];
        int a = 0;

        for(int j = 0; j < arrayToMerge.length; j++){
            merged[j] = arrayToMerge[j];
        }

        for(int i = arrayToMerge.length;i < mergedSize; i++){
            merged[i] = array[a];
            a++;
        }

        Integer count = 0;
        for(T e: merged){
            if(valueToEvaluate == e){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int mergedSize = arrayToMerge.length  + array.length;
        T [] merged = (T[]) new Object [mergedSize];
        int a = 0;

        for(int j = 0; j < arrayToMerge.length; j++){
            merged[j] = arrayToMerge[j];
        }

        for(int i = arrayToMerge.length;i < mergedSize; i++){
            merged[i] = array[a];
            a++;
        }
        Arrays.sort(merged);

        Map<T,Integer> hm = new HashMap<>();
        for(int e = 0; e < merged.length; e++){
            T key = merged[e];
            if(hm.containsKey(key)){
                int frequency = hm.get(key);
                frequency++;
                hm.put(key,frequency);
            }
            else {
                hm.put(key,1);
            }
        }
        int maxCount = 0;
        T result = null;
        for(Map.Entry<T,Integer> val: hm.entrySet()){
            if(maxCount < val.getValue()){
                result = val.getKey();
                maxCount = val.getValue();
            }
        }

        return  result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for(T e: array){
            if(e == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] results = Arrays.copyOf(array, array.length - numberOfOccurrences);
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                results[j] = array[i];
                j++;
            }
        }
        return results;
    }

    
}
