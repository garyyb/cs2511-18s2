package ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListBag<E> implements Bag<E> {
	private final ArrayList<E> items;

	public ArrayListBag() {
		items = new ArrayList<>();
	}

	@Override
	public boolean add(E e) {
		return items.add(e);
	}

	@Override
	public boolean contains(Object o) {
		return items.contains(o);
	}

	@Override
	public boolean remove(Object o) {
		return items.remove(o);
	}

	@Override
	public long size() {
		return items.size();
	}

	@Override
	public Bag<E> union(Bag<E> other) {
		Bag<E> unioned = new ArrayListBag<>();
		for (E e : other) {
			unioned.add(e);
		}
		return unioned;
	}

	@Override
	public Bag<E> intersection(Bag<E> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return items.iterator();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null) return false;
		if (!(obj instanceof ArrayListBag<?>)) return false;
		ArrayListBag<?> other = (ArrayListBag<?>) obj;
		
		this.items.sort(null);
		other.items.sort(null);
		
		return this.items.equals(other.items);
	}
}
