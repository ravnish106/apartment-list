package test.apartment.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.apartment.list.BathRoom;
import main.apartment.list.BedRoom;
import main.apartment.list.Controller;
import main.apartment.list.Feature;
import main.apartment.list.Kitchen;
import main.apartment.list.Neighborhood;

/**
 * Tests {@link Controller} class.
 * 
 * @author RNarula
 *
 */
public class ControllerTest {
	private static final String DOCUMENT = "Our luxury loft-style apartments were constructed as condominiums, so your new residence will have: Solid floors and walls (this will be the quietest apartment you've EVER lived in); Premium stainless steel designer appliances; Distinctive accent walls and hardwood flooring; A kitchen that most chefs would drool over with easy to clean gas stove and countertops; Walk in closets with built in storage; Full size washer and dryer in each apartment home. In addition, all residents will enjoy use of our top-notch amenities, including reserved parking, cutting-edge fitness center, wireless internet cafe/business center, and rooftop lounge to soak up the sun!; Should have a bath.";
	private static final String KITCHEN_SNIPPET = "Premium stainless steel designer appliances; A kitchen that most chefs would drool over with easy to clean gas stove and countertops;";
	private static final String KITCHEN_QUERY = "designer kitchen";

	/**
	 * Tests {@link Controller#getAllFeatures} method.
	 */
	@Test
	public void testGetAllFeatures() {
		Controller controller = new Controller();

		List<Feature> expectedFeatures = new ArrayList<Feature>(
				Arrays.asList(new Feature[] { new BathRoom(), new BedRoom(), new Kitchen(), new Neighborhood() }));

		Assert.assertEquals(expectedFeatures.size(), controller.getAllFeatures().size());
		Assert.assertEquals(expectedFeatures, controller.getAllFeatures());
	}

	/**
	 * Tests {@link Controller#getFeatureRequested(String)} method.
	 */
	@Test
	public void testGetFeatureRequested() {
		Controller controller = new Controller();
		Feature kitchen = new Kitchen();
		String query = KITCHEN_QUERY;
		Assert.assertEquals(kitchen, controller.getFeatureRequested(query));
	}

	/**
	 * Tests {@link Controller#getDetailsSpecificToFeature(String[], Feature)}
	 * method.
	 */
	@Test
	public void testGetDetailsSpecificToFeature() {
		Controller controller = new Controller();
		Feature kitchen = new Kitchen();
		Assert.assertEquals(KITCHEN_SNIPPET.trim(),
				controller.getDetailsSpecificToFeature(getDocumentSplit(), kitchen).trim());

	}

	/**
	 * Tests {@link Controller#generateSnippet(String, String)} method.
	 */
	@Test
	public void testGenerateSnippet() {
		Controller controller = new Controller();
		Assert.assertEquals(KITCHEN_SNIPPET.trim(), controller.generateSnippet(DOCUMENT, KITCHEN_QUERY).trim());
	}

	/**
	 * Split document in array.
	 * 
	 * @return document array
	 */
	String[] getDocumentSplit() {
		return DOCUMENT.split(";");
	}
}
