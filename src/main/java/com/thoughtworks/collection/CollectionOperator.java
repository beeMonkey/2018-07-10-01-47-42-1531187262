package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> arr= new ArrayList<Integer>();
        if(left<right) {
            for (int i = left; i <= right; i++) {
                arr.add(i);
            }
        }
        else {
            for (int i = left; i >= right; i--) {
                arr.add(i);
            }
        }
        return arr;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        ArrayList<Integer> evenArr= new ArrayList<Integer>();
        if(left<right) {
            for (int i = left; i <= right; i++) {
                evenArr.add(i);
            }
            return evenArr.stream().filter(number->number%2==0).collect(Collectors.toList());
        }
        else {
            for (int i = left; i >= right; i--) {
                evenArr.add(i);
            }
            return evenArr.stream().filter(number->number%2==0).collect(Collectors.toList());
        }

    }

    public List<Integer> popEvenElments(int[] array) {
        //Stream.of(array).filter(number->number%2==0).collect(Collectors.toList());
        //IntStream stream=IntStream.of(array);
        //return stream.filter(number->number%2==0).collect(Collectors.toList())

        return Arrays.stream(array).boxed().filter(number->number%2==0).collect(Collectors.toList());
        //return （array转stream错误使用方法）array.stream().filter(number->number%2==0).collect(Collectors.toList());
        //System.out.print(Arrays.asList(array));
//        return  null;
        //return Arrays.asList(array).stream(int).filter(item-> item % 2 == 0).collect(Collectors.toList());//生成一个固定长度的List,对基本类型支持不友好
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
//        for(int firstarr : firstArray){
//            return Arrays.stream(secondArray).boxed().filter(secondArr->secondArr==firstarr).collect(Collectors.toList());
//        }
        List<Integer> commonElements=new ArrayList<>();
        for(int i=0;i<firstArray.length;i++){
            for(int j=0;j<secondArray.length;j++){
                if(firstArray[i]==secondArray[j]){
                    commonElements.add(firstArray[i]);
                }
            }
        }
        return commonElements;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
