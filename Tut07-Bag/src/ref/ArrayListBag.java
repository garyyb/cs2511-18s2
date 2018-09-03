package ref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	public boolean containsAll(Bag<?> other) {
		Map<Object, Long> frequencies = new HashMap<>();
		Map<Object, Long> otherFrequencies = new HashMap<>();
		
		for (Object o : other) {
			otherFrequencies.merge(o, new Long(1), Long::sum);
		}
		
		for (Object o : this) {
			frequencies.merge(o, new Long(1), Long::sum);
		}
		
		for (Entry<?, Long> entry : otherFrequencies.entrySet()) {
			Long frequency = frequencies.get(entry.getKey());
			if (frequency == null || frequency < entry.getValue()) {
				return false;
			}
		}
		
		return true;
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
		if (!(obj instanceof Bag<?>)) return false;
		Bag<?> other = (Bag<?>) obj;

		if (this.size() != other.size()) return false;
		return this.containsAll(other);
	}
}
