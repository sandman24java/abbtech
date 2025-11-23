package IteratorPattern;

public class Practice {
    public static void main(String[] args) {
        CatCollection cats = new CatCollection();
        cats.addCat(new Cat("Sally"));
        cats.addCat(new Cat("Mona"));
        cats.addCat(new Cat("Lion"));
        cats.addCat(new Cat("Max"));
        cats.addCat(new Cat("Donny"));
        CatIterator iterator = cats.iterator();
        while (iterator.hasNext()) {
            Cat cat = iterator.next();
            System.out.println("We are seeing " + cat.getName());
        }



    }
}

