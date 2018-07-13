package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp=leftBorder;
            leftBorder=rightBorder;
            rightBorder=temp;
        }
        ArrayList<Integer> evenArr= new ArrayList<Integer>();
        for(int i=leftBorder;i<=rightBorder;i++){
            if(i%2==0){
                evenArr.add(i);
            }
        }
        //return evenArr.stream().reduce(0,Integer::sum);

        return evenArr.stream().reduce(Integer::sum).get();
//        int result=0;
//        for(int even : evenArr){
//            result+=even;
//        }
//        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp=leftBorder;
            leftBorder=rightBorder;
            rightBorder=temp;
        }
        ArrayList<Integer> evenArr= new ArrayList<Integer>();
        for(int i=leftBorder;i<=rightBorder;i++){
            if(i%2!=0){
                evenArr.add(i);
            }
        }
//        int result=0;
//        for(int even : evenArr){
//            result+=even;
//        }
//        return result;
        return evenArr.stream().reduce(Integer::sum).get();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(a,b)->a+(b*3+2));//        int result=0;
//        for(int n:arrayList ){
//           result+=n*3+2;
//        }
//        return result;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //return arrayList.stream().filter(n -> n%2!=0).reduce(0,(a,b)->a+(b*3+2));
        List<Integer> resultArr=new ArrayList<Integer>();
                for(int n:arrayList){
            if(n%2!=0){
                resultArr.add(n*3+2);
            }else {
                resultArr.add(n);
            }
        }
        return resultArr;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x->x%2!=0).reduce(0,(a,b)->a+(b*3+5));
        //        int result=0;
//        for(int n:arrayList ){
//            if(n%2!=0) {
//                result += n * 3 + 5;
//            }
//        }
//        return result;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenList= arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        int size=evenList.size();
        int median;
        if (size % 2 == 0) {
            median = (evenList.get(size / 2) + evenList.get(size / 2 - 1)) / 2;
        } else {
            median = evenList.get(size / 2);
        }

        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> evenList= arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        return evenList.stream().reduce(0,(a,b)->a+b)/evenList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> evenList= arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        return evenList.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evenList= arrayList.stream().filter(x->x%2==0).collect(Collectors.toList());
        return evenList.stream().distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
         List<Integer> evenList=arrayList.stream()
                                .filter(num->num%2==0)
                                .sorted()
                                .collect(Collectors.toList());
        List<Integer> oddList=arrayList.stream()
                .filter(num -> num % 2 != 0)
                .sorted((num1, num2) -> num2 - num1)
                .collect(Collectors.toList());
         evenList.addAll(oddList);
         return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            Integer resultElement = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            result.add(resultElement);
        }
        return result;
    }
}
