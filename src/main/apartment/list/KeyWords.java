package main.apartment.list;

/**
 * Enum to hold all the significant properties in the apartment. These
 * properties are shared by different {@link Feature}. We can add new properties
 * in the below list and have some Feature use it.
 * 
 * @author RNarula
 *
 */
public enum KeyWords {
	FLOORS(".*bed.*"), WALLS(".*walls.*"), APPLIANCES(".*appliances.*"), Kitchen(".*kitchen.*"), Countertops(
			".*countertops.*"), CLOSETS(".*closet.*"), Storage(".*storage.*"), Amenities(".*amenities.*"), Washer(
					".*washer.*"), Dryer(".*dryer.*"), Parking(".*parking.*"), Fitness(".*fitness.*"), Business(
							".*business.*"), Lounge(".*lounge.*"), BATH(".*bath.*"), SCHOOLS(".*school.*");

	/**
	 * Inner name of the property, this is a regex used for parsing.
	 */
	private final String name;

	/**
	 * private constructor, this should not be called.
	 * 
	 * @param name
	 */
	private KeyWords(String name) {
		this.name = name;
	}

	/**
	 * Returns regex of the KeyWords for parsing.
	 * 
	 * @return regex
	 */
	public String getName() {
		return name;
	}
}
