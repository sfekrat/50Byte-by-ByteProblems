public class Heap<E> {
	int lastPos;
	int size = 15;
	@SuppressWarnings("unchecked")
	E[] heap = (E[]) new Object[size];

	public void add(E obj) {
		heap[lastPos] = obj;
		trickleUp(lastPos);
		lastPos++;
	}

	public void swap(int from, int to) {
		E temp = heap[from];
		heap[from] = heap[to];
		heap[to] = temp;
	}

	@SuppressWarnings("unchecked")
	public void trickleUp(int position) {
		if (position == 0) {
			return;
		}
		int parent = (int) Math.floor((position - 1) / 2);
		if (((Comparable<E>) heap[position]).compareTo(heap[parent]) > 0) {
			swap(position, parent);
			trickleUp(parent);
		}
	}

	public E remove() {
		E temp = heap[0];
		swap(0, --lastPos);
		trickleDown(0);
		return temp;
	}

	@SuppressWarnings("unchecked")
	public void trickleDown(int parent) {
		
		int leftChild = 2 * parent + 1;
		int rightChild = 2 * parent + 2;
		
		if (leftChild >= lastPos || rightChild >= lastPos) {
			return;
		}

		if (leftChild == lastPos && (((Comparable<E>) heap[parent]).compareTo(heap[leftChild]) < 0)) {
			swap(parent, leftChild);
			return;
		}
		if (rightChild == lastPos && (((Comparable<E>) heap[parent]).compareTo(heap[rightChild]) < 0)) {
			swap(parent, rightChild);
			return;
		}
		if ((((Comparable<E>) heap[leftChild]).compareTo(heap[rightChild]) > 0) &&
				(((Comparable<E>) heap[parent]).compareTo(heap[leftChild]) < 0)) {
			swap(parent, leftChild);
			trickleDown(leftChild);
		} else if ((((Comparable<E>) heap[rightChild]).compareTo(heap[leftChild]) > 0) &&
				(((Comparable<E>) heap[parent]).compareTo(heap[rightChild]) < 0)){
			swap(parent, rightChild);
			trickleDown(rightChild);
		}
	}
	public static void main(String[] args) {
		Heap<Integer> myHeap = new Heap<Integer>();
		myHeap.add(17);
		myHeap.add(19);
		myHeap.add(7);
		myHeap.add(12);
		myHeap.add(22);
		myHeap.add(10);
		myHeap.add(15);
		myHeap.add(11);
		myHeap.add(5);
		myHeap.add(6);
		myHeap.add(9);
		
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		myHeap.remove();
		
        for (Object element : myHeap.heap){
        	if(element == null) {
        		break;
        	}
            System.out.print(element + " ");
        }
	}
}
