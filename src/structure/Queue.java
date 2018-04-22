package structure;

public class Queue <T>{

	private Node<T> head;
	private Node<T> last;

	public Queue() {
	}

	public void enqueue(T info){
		if (head != null) {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(new Node<T>(info));
		}else{
			head = new Node<T>(info);
		}
	}

	public Node<T> getLast() {
		return last;
	}
	
	public void strainBefore(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				node.setNext(head);
				head = node;
			}else {
				while (current.getNext().getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);

			}
		}else {
			head = node;
		}
	}

	public boolean isEmpty() {
		if(head != null) {
			return false;
		}else {
			return true;
		}
	}
	
	public void strainAfter(T info, Node<T> node) {
		Node<T> reference ;
		Node<T> current = head;
		if(head != null) {
			if(info.equals(head.getInformation())) {
				reference = head;
				node.setNext(head.getNext());
				reference.setNext(node);
				head = reference;
			}else {
				while (current.getInformation() != info) {
					current = current.getNext();
				}
				reference = current.getNext();
				current.setNext(node);
				node.setNext(reference);
			}
		}else {
			head = node;
		}
	}
	
	public Node<T> getHead() {
		return head;
	}

	public Node<T> dequeue() throws Exception{
		
		if(head != null) {
			Node<T> reference = head;
			head = reference.getNext();
			reference.setNext(null);
			return reference;
		}else {
			throw new Exception("No hay mas elementos en la cola");
		}
	}
	
}