package main.apartment.list;

import java.util.Arrays;

/**
 * This is the kitchen {@link Feature}. It holds {@link KeyWords} specific to
 * the Kitchen Feature.
 * 
 * @author RNarula
 *
 */
public class Kitchen extends Feature {

	/**
	 * Constructor to create this Feature with new names.
	 * 
	 * @param names
	 *            new names of feature.
	 */
	public Kitchen(String names) {
		super(names);
		getKeyWords()
				.addAll(Arrays.asList(new KeyWords[] { KeyWords.APPLIANCES, KeyWords.Countertops, KeyWords.Kitchen }));
		name = "Kitchen";
	}

	/**
	 * Default constructor.
	 */
	public Kitchen() {
		this("kitchen");
	}

}
