package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
       return arrayList.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(n->n).summaryStatistics().getAverage();//.average().getAsInt();
    }

    public double getOrderedMedian() {
        throw new NotImplementedException();
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num->num%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEven=arrayList.stream().filter(num->num%2==0).findFirst().get();
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean isequal=true;
        for(int i=0;i<this.arrayList.size();i++){
            for(int j=0;j<arrayList.size();j++){
                if(this.arrayList.get(i)!=arrayList.get(j)){
                    isequal=false;
                }
            }
        }
        return isequal;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        return arrayList.stream().filter(num->num%2!=0).reduce((first,second)->second).get();
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(getLastOdd());
    }
}
