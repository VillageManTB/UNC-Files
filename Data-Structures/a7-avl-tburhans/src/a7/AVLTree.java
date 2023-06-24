package a7;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    private T _element;
    private SelfBalancingBST<T> _left;
    private SelfBalancingBST<T> _right;
    
    public AVLTree() {
        _left = null;
        _right = null;
        _element = null;
    }

    public AVLTree(T value) {
        _left = new AVLTree<>();
        _right = new AVLTree<>();
        _element = value;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private AVLTree<T> rotateLeft() {
         AVLTree<T> root = (AVLTree<T>) _right;
         this._right = root.getLeft();
         root._left = this;
         return root;
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight() {
         AVLTree<T> root = (AVLTree<T>) _left;
         this._left = root.getRight();
         root._right = this;
         return root;
     }

    @Override
    public boolean isEmpty() {
        if (_element == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int height() {
         if (this.isEmpty()) {
             return -1;
         }
         return Math.max(_left.height(), _right.height())+1;
    }

    @Override
    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return 1 + _left.size() + _right.size();
        }
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
         if (this.isEmpty()) {
             _element = element;
             _left = new AVLTree<T>();
             _right = new AVLTree<>();
         }
         if (element.compareTo(_element) < 0) {
             _left = _left.insert(element);
         }
         if (element.compareTo(_element) > 0) {
             _right = _right.insert(element);
         }
         int thisHeight = Math.abs(_left.height() - _right.height());
         if ((thisHeight > 1) && (_left.height() > _right.height())) {
             if (_left.getLeft().height() > _left.getRight().height()) {
                 return this.rotateRight();
             } else {
                 _left = ((AVLTree<T>) _left).rotateLeft();
                 return this.rotateRight();
             }
         }
        if ((thisHeight > 1) && (_left.height() < _right.height())) {
            if (_right.getLeft().height() > _right.getRight().height()) {
                _right = ((AVLTree<T>) _right).rotateRight();
                return this.rotateLeft();
            } else {
                return this.rotateLeft();
            }
        }
        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
         if (this.isEmpty()) {
             return this;
         }
        if (!this.contains(element)) {
            return this;
        }
        if (element.compareTo(_element) == 0) {
            if (_left.isEmpty() && _right.isEmpty()) {
                _element = null;
            } else if (_left.isEmpty()) {
                _element = _right.getValue();
                _right = new AVLTree<>();
            } else if (_right.isEmpty()) {
                _element = _left.getValue();
                _left = new AVLTree<>();
            } else {
                _element = _right.findMin();
                _right = _right.remove(_right.findMin());
            }
        } else {
            if (element.compareTo(_element) < 0) {
                _left = _left.remove(element);
            } else if (element.compareTo(_element) > 0) {
                _right = _right.remove(element);
            }
        }
        int thisHeight = Math.abs(_left.height() - _right.height());
            if ((thisHeight > 1) && (_left.height() > _right.height())) {
                if (_left.getLeft().height() > _left.getRight().height()) {
                    return this.rotateRight();
                } else {
                    _left = ((AVLTree<T>) _left).rotateLeft();
                    return this.rotateRight();
                }
            }
        if ((thisHeight > 1) && (_left.height() < _right.height())) {
            if (_right.getLeft().height() > _right.getRight().height()) {
                _right = ((AVLTree<T>) _right).rotateRight();
                return this.rotateLeft();
            } else {
                return this.rotateLeft();
            }
        }
        return this;
    }

    @Override
    public T findMin() {
         if (_left.isEmpty()) {
            return _element;
         }
         return _left.findMin();
    }

    @Override
    public T findMax() {
        if (_right.isEmpty()) {
            return _element;
        }
        return _right.findMax();
    }

    @Override
    public boolean contains(T element) {
        int dist = (element.compareTo(_element));
        if (dist == 0) {
            return true;
        }
        if ((dist < 0) && (!_left.isEmpty())) {
            return _left.contains(element);
        }
        if ((dist > 0) && (!_right.isEmpty())) {
            return _right.contains(element);
        }
        return false;
    }

    @Override
    public T getValue() {
         return _element;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
         return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
         return _right;
    }
}
