package structure;

import java.util.Comparator;

import structure.Node;

public class SimpleList<T> {

	private Node<T> head;
	private Comparator<T> comparator;

	public SimpleList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public SimpleList() {
	}

	public void add(T node){
		if (head != null) {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(new Node<T>(node));
		}else{
			head = new Node<T>(node);
		}
	}

	public Node<T> search(T id){
		Node<T> actual = head;
		if (head.getInformation() != id) {
			while (actual.getNext() != null) {
				if (actual.getInformation() != id) {
					actual = actual.getNext();
				}else{
					return actual;
				}
			}
		}
		return actual;
		
	}
	public Node<T> getMaxElement(){
		Node<T> actual = head;
		Node<T> max = head;
		while (actual.getNext() != null) {
			if (comparator.compare(max.getInformation(), actual.getInformation()) < 0) {
				max = actual;
			}
			actual = actual.getNext();
		}
		return max;
	}

	public Node<T> getHead() {
		return head;
	}

	public void print() {
		Node<T> current = head;
		while (current != null) {
			System.out.println(current.getInformation());
			current = current.getNext();
		}
	}

	public void delete(T info) {		
		Node<T> node = search(info);
		Node<T> actual = head;
		if (head.getInformation() != node.getInformation()) {
			while (actual.getNext() != null) {
				if (actual.getNext().getInformation() != node.getInformation()) {
					actual = actual.getNext();
				}else{
					actual.setNext(node.getNext());
					node = null;
				}
			}
		}else{
			head = null;
		}
	}
	
}
