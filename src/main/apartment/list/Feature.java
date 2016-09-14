package main.apartment.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parent class of all the {@link Feature}. Feature can be any significant
 * property(area) or the apartment. In this version we have supported Feature
 * like {@link BathRoom}, {@link BedRoom}, {@link Kitchen}, {@link Neighborhood}
 * . Each Feature has a list of {@link KeyWords} which define properties which
 * can be used to define this particular feature. Example Feature Kitchen would
 * have a KeyWord APPLIANCES. Each Feature also has a list of other names with
 * which this Feature could be called upon by the customer. Example Feature
 * BedRoom has a name 'bed'.
 * 
 * @author RNarula
 *
 */
public abstract class Feature {
	/**
	 * List of other names used to call this particular Feature. This is useful in the search query.
	 */
	private List<String> featureCommonNames = new ArrayList<String>();
	
	protected String name;
	
	/**
	 * List of {@link KeyWords} which describe this feature.
	 */
	private List<KeyWords> keyWords = new ArrayList<KeyWords>();

	/**
	 * Constructor where we can pass new names to this Feature.
	 * @param names Names to call this Feature.
	 */
	public Feature(String names) {
		String[] namesSplit = names.split(",");
		String[] regexNames = new String[namesSplit.length];
		for (int i = 0; i < namesSplit.length; i++) {
			regexNames[i] = ".*" + namesSplit[i].trim() + ".*";
		}

		featureCommonNames.addAll(Arrays.asList(regexNames));
	}

	/**
	 * Returns common names of Feature.
	 * @return common names.
	 */
	List<String> getFeatureCommonNames() {
		return this.featureCommonNames;
	}

	/**
	 * Returns {@link KeyWords} describing this Feature.
	 * @return KeyWords.
	 */
	public List<KeyWords> getKeyWords() {
		return keyWords;
	}
	
	@Override
	public boolean equals(Object obj) {
		Feature f = (Feature) obj;
		return f.name.equals(this.name);
	}
}
