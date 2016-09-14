package main.apartment.list;

import java.util.Arrays;

/**
 * This is the BedRoom {@link Feature}. It holds {@link KeyWords} specific to
 * the BedRoom Feature.
 * 
 * @author RNarula
 *
 */
public class BedRoom extends Feature {

	/**
	 * Constructor to create this Feature with new names.
	 * 
	 * @param names
	 *            new names of feature.
	 */
	public BedRoom(String names) {
		super(names);
		getKeyWords().addAll(Arrays.asList(new KeyWords[] { KeyWords.CLOSETS }));
		name = "BedRoom";
	}

	/**
	 * Default constructor.
	 */
	public BedRoom() {
		this("bed");
	}
}
