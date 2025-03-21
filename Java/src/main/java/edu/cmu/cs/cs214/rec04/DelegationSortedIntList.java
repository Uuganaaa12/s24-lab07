package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
public class DelegationSortedIntList implements IntegerList {

    private final SortedIntList delegateList;

    private int totalAdded;

    public DelegationSortedIntList() {
        delegateList = new SortedIntList();
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        totalAdded++;
        return delegateList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return delegateList.addAll(list);
    }

    @Override
    public int get(int index) {
        return delegateList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return delegateList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return delegateList.removeAll(list);
    }

    @Override
    public int size() {
        return delegateList.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}