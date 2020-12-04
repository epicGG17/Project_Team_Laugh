import java.util.Iterator;
public class itemIterator implements Iterator<node>{
	private node point;

	public itemIterator(item a) {
		point = a.getFirst();
	}
	
	@Override
	public boolean hasNext() {
		return point != null;	
	}

	@Override
	public node next() {
		node curr = point;
		point = point.getLink();
		return curr;
	}

}
