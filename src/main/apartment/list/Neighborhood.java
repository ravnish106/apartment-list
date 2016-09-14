package main.apartment.list;

import java.util.Arrays;

/**
 * This is the Neighborhood {@link Feature}. It holds {@link KeyWords} specific
 * to the Neighborhood Feature.
 * 
 * @author RNarula
 *
 */
public class Neighborhood extends Feature {

	/**
	 * Constructor to create this Feature with new names.
	 * 
	 * @param names
	 *            new names of feature.
	 */
	public Neighborhood(String names) {
		super(names);
		getKeyWords().addAll(Arrays.asList(new KeyWords[] { KeyWords.SCHOOLS, KeyWords.Business, KeyWords.Fitness,
				KeyWords.Lounge, KeyWords.Parking, KeyWords.Amenities }));
		name = "Neighborhood";
	}

	/**
	 * Default constructor.
	 */
	public Neighborhood() {
		this("neighborhood, society, surrounding, common, hoa");
	}
}
