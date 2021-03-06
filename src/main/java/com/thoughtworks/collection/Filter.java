package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return  array.stream().filter(x->x%2==0).collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return  array.stream().filter(x->x%3==0).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList=new ArrayList<>();
//        for(int i=0;i<firstList.size();i++){
//            secondList.stream().filter(secondL->firstList==secondL)
//        }
        for(int i=0;i<firstList.size();i++){
            if(secondList.contains(firstList.get(i))){
                resultList.add(firstList.get(i));
            }
        }
        return resultList;
    }

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}