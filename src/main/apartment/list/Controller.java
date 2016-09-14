package main.apartment.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class and entry point. It has a list of {@link Feature}, these are all
 * the Features that are supported. User enters the documentation with the
 * search query and relevant snippet is generated.
 * 
 * @author RNarula
 *
 */
public class Controller {
	/**
	 * List of {@link Feature}.
	 */
	private List<Feature> allFeatures = null;

	public Controller() {
		allFeatures = getAllFeatures();
	}

	/**
	 * Generate the relevant snippet based on the query provided.
	 * 
	 * @param document
	 *            Entire apartment description.
	 * @param query
	 *            Search string
	 * @return relevant snippet.
	 */
	public String generateSnippet(String document, String query) {
		String[] documentChs = document.split(";");

		Feature feature = getFeatureRequested(query);

		if (feature != null) {
			return getDetailsSpecificToFeature(documentChs, feature);
		}

		return document;
	}

	/**
	 * Parse entire documentation to fetch the snippet only relevant to a
	 * particular {@link Feature}.
	 * 
	 * @param documentChs
	 *            Array of entire document(description).
	 * @param feature
	 *            Feature whose details are required by the customer.
	 * @return Relevant snippet.
	 */
	public String getDetailsSpecificToFeature(String[] documentChs, Feature feature) {
		StringBuffer result = new StringBuffer();
		Set<Integer> indexUsefulDetail = new HashSet<Integer>();
		for (int i = 0; i < documentChs.length; i++) {
			for (KeyWords keyWords : feature.getKeyWords()) {
				if (Pattern.matches(keyWords.getName(), documentChs[i])) {
					indexUsefulDetail.add(i);
				}
			}
		}

		for (int i = 0; i < documentChs.length; i++) {
			if (indexUsefulDetail.contains(i)) {
				result.append(documentChs[i]);
				result.append(";");
			}
		}

		return result.toString();
	}

	/**
	 * Get {@link Feature} whose description is needed by the customer, we get
	 * this by parsing the entered query.
	 * 
	 * @param query
	 *            Entered query
	 * @return Feature requested.
	 */
	 public Feature getFeatureRequested(String query) {
		Feature featureRequested = null;
		for (int j = 0; j < allFeatures.size() && featureRequested == null; j++) {
			List<String> differentNames = allFeatures.get(j).getFeatureCommonNames();
			for (int i = 0; i < differentNames.size() && featureRequested == null; i++) {
				Pattern pattern = Pattern.compile(differentNames.get(i), Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(query);
				if (matcher.matches()) {
					featureRequested = allFeatures.get(j);
				}
			}
		}

		return featureRequested;
	}

	/**
	 * Returns list of all the {@link Feature} supported. New Feature once
	 * created should be added to this list.
	 * 
	 * @return List of all the Feature.
	 */
	public List<Feature> getAllFeatures() {
		return new ArrayList<Feature>(
				Arrays.asList(new Feature[] { new BathRoom(), new BedRoom(), new Kitchen(), new Neighborhood() }));
	}
}
