package main.apartment.list;

import java.util.Arrays;

/**
 * This is the BathRoom {@link Feature}. It holds {@link KeyWords} specific to
 * the BathRoom Feature.
 * 
 * @author RNarula
 *
 */
public class BathRoom extends Feature {

	/**
	 * Constructor to create this Feature with new names.
	 * 
	 * @param names
	 *            new names of feature.
	 */
	public BathRoom(String names) {
		super(names);
		getKeyWords().addAll(Arrays.asList(new KeyWords[] { KeyWords.BATH })); // KeyWords.FLOORS,KeyWords.WALLS,
	name = "BathRoom";
	}

	/**
	 * Default constructor.
	 */
	public BathRoom() {
		this("bath, shower");
	}
}
