package IteratorPattern;

public class CatCollectionIterator implements CatIterator {
    private CatCollection collection;  // коллекция, по которой ходим
    private int index = 0;

    public CatCollectionIterator(CatCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.getSize();
    }

    @Override
    public Cat next() {
        if (!hasNext()) {
            return null;  // или можно бросить исключение
        }
        return collection.getCat(index++);
    }
}
