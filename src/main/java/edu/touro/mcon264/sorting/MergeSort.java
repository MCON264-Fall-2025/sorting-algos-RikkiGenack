package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement merge sort
        if(a ==null|| a.length < 2){
            return;
        }
        mergeSort(a, 0, a.length - 1,comp);
    }

    private <T> void mergeSort(T[] a, int i, int i1,Comparator<? super T> comp) {
    if(i>=i1){
        return;
    }
    int midIndex = (i + i1) / 2;
    mergeSort(a, i, midIndex,comp);
    mergeSort(a, midIndex + 1, i1,comp);


    Object[] temp = new Object[(i1 - i + 1)];


    int leftPtr = i;
    int rightPtr = midIndex + 1;
    int tempPtr = 0;
    while(leftPtr <= midIndex && rightPtr <= i1){
            if (comp.compare(a[leftPtr], a[rightPtr])<0) {
                temp[tempPtr] = a[leftPtr];
                leftPtr++;
                tempPtr++;
            }
            else if(comp.compare(a[leftPtr], a[rightPtr])>0){
                temp[tempPtr] = a[rightPtr];
                rightPtr++;
                tempPtr++;
        }
            else {
                temp[tempPtr] = a[leftPtr];
                leftPtr++;
                tempPtr++;
            }
    }
    while(leftPtr <= midIndex){//if left still has elements
     //copy into temp
        temp[tempPtr] = a[leftPtr];
        leftPtr++;
        tempPtr++;
    }
    while (rightPtr<=i1){//if right still has elements
        temp[tempPtr] = a[rightPtr];
        rightPtr++;
        tempPtr++;
    }
    for(int j = 0; j < temp.length; j++){
        a[i+j]= (T) temp[j];
    }

    }
}
