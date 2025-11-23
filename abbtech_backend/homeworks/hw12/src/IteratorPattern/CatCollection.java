package IteratorPattern;

import java.util.ArrayList;
import java.util.List;

public class CatCollection {
    private List<Cat> cats = new ArrayList<>();

    public void addCat(Cat cat){
        cats.add(cat);
    }
    public Cat getCat(int index) {
        return cats.get(index);
    }

    public CatIterator iterator() {
        return new CatCollectionIterator(this);
    }
    public int getSize(){
        return cats.size();
    }

}