package a5;


import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}


	// TODO: size
	@Override
	public int size() {
		if ((_left == null) && (_right == null)) {
			return 0;
		} else {
			return 1 + _left.size() + _right.size();
		}
	}

	// TODO: findMin
	@Override
	public T findMin() {
		if (_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	// TODO: findMax
	@Override
	public T findMax() {
		if (_right.isEmpty()) {
			return _element;
		}
		return _right.findMax();
	}

	// TODO: contains
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

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if (element.compareTo(_element) < 0) {
			if (_left.isEmpty()) {
				_left = new NonEmptyBST<T>(element);
				 return this;
			}
			_left = _left.insert(element);
		}
		if (element.compareTo(_element) >= 0) {
			if (_right.isEmpty()) {
				_right = new NonEmptyBST<T>(element);
				 return this;
			}

			_right = _right.insert(element);
		}
		return this;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (!this.contains(element)) {
			return this;
		}
		if (element.compareTo(_element) < 0) {
			if (_left.isEmpty()) {
				return this;
			}
			_left = _left.remove(element);
		}
		else if (element.compareTo(_element) > 0) {
			if (_right.isEmpty()) {
				return this;
			}

			_right = _right.remove(element);
		}
		else if (element.compareTo(_element) == 0) {
			if (_left.isEmpty() && _right.isEmpty()) {
				return new EmptyBST<>();
			}
			if (_left.isEmpty()) {
				return _right;
			}
			if (_right.isEmpty()) {
				return _left;
			}
			_element = _right.findMin();
			_right = _right.remove(_right.findMin());
		}
		return this;
	}

	// TODO: printInOrderTraversal
	@Override
	public void printInOrderTraversal() {
		if (this.isEmpty()) {
			return;
		}
		_left.printInOrderTraversal();
		System.out.print(_element + " ");
		_right.printInOrderTraversal();
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if (this.isEmpty()) {
			return;
		}
		System.out.print(_element + " ");
		_left.printPreOrderTraversal();
		_right.printPreOrderTraversal();
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (this.isEmpty()) {
			return;
		}
		_left.printPostOrderTraversal();
		_right.printPostOrderTraversal();
		System.out.print(_element + " ");
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		Queue<BST<T>> queue = new LinkedList<>();
		if (_left.isEmpty() && _right.isEmpty()){
			return;
		}
		queue.add(this);
		while (!queue.isEmpty()) {
			BST T = queue.remove();
			System.out.print(T.getElement() + " ");
			if(!T.getLeft().isEmpty()) {
				queue.add(T.getLeft());
			}
			if(!T.getRight().isEmpty()) {
				queue.add(T.getRight());
			}
		}
		return;
	}

	@Override
	public int getHeight() {
		return Math.max(_left.getHeight(), _right.getHeight())+1;
	}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
