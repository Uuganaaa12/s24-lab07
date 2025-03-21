package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntList extends SortedIntList {

    private int totalAdded;

    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
        return list.size() > 0;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}