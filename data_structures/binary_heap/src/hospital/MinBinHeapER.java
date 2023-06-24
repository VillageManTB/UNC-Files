package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */

    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        Prioritized patient = new Patient(value, priority);
        _heap.add(patient);
        int current = size()-1;
        while(current > 0) {
            int parent = (current-1) / 2;
            if(_heap.get(current).getPriority().compareTo(_heap.get(parent).getPriority()) < 0) {
                Prioritized<V, P> temp = _heap.get(current);
                _heap.set(current, _heap.get(parent));
                _heap.set(parent, temp);
                current = parent;
            } else {
                return;
            }
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        Prioritized patient = new Patient(value);
        _heap.add(patient);
        int current = size()-1;
        while(current > 0) {
            int parent = (current-1) / 2;
            if(_heap.get(current).getPriority().compareTo(_heap.get(parent).getPriority()) < 0) {
                Prioritized<V, P> temp = _heap.get(current);
                _heap.set(current, _heap.get(parent));
                _heap.set(parent, temp);
                current = parent;
            } else {
                return;
            }
        }
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (size() == 0) {
            return null;
        }
        else {
            V val2 = _heap.get(0).getValue();
            Collections.swap(_heap, 0, size()-1);
            _heap.remove(size()-1);
            int current = 0;
            while (((current*2)+1) <= size()-1) {
                int left = (current *2)+1;
                int right = (current*2)+2;
                if (right > size()-1 && left > size()-1) {
                    return val2;
                }
                if (right <= size()-1 && left <= size()-1) {
                    if (_heap.get(right).getPriority().compareTo(_heap.get(left).getPriority()) < 0) {
                        if (_heap.get(right).getPriority().compareTo(_heap.get(current).getPriority()) < 0) {
                            Collections.swap(_heap, right, current);
                            current = right;
                        }
                    } else if (_heap.get(right).getPriority().compareTo(_heap.get(left).getPriority()) >= 0) {
                            if (_heap.get(left).getPriority().compareTo(_heap.get(current).getPriority()) < 0) {
                                Collections.swap(_heap, left, current);
                                current = left;
                            }
                    }
                }
                if (right > size()-1 && left <= size()-1) {
                    if (_heap.get(left).getPriority().compareTo(_heap.get(current).getPriority()) < 0) {
                        Collections.swap(_heap, left, current);
                    } else {
                        break;
                    }
                }
            }
            return val2;
        }
    }

    // TODO: getMin
    @Override
    public V getMin() {
        if (size() == 0) {
            return null;
        }
        return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
