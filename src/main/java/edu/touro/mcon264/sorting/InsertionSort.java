package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // TODO: implement insertion sort
        for(int i =1; i<a.length; i++){
            int j = i-1;
            T currElement = a[i];
            while(j!=-1 && comp.compare(a[j], currElement)>0){//left elem is bigger
                a[j+1] =a[j];
                j--;
            }
            a[j+1]=currElement;//insert into empy spot
        }
    }

    }

