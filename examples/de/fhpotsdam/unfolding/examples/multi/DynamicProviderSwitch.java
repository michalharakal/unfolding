package de.fhpotsdam.unfolding.examples.multi;

import processing.core.PApplet;
import codeanticode.glgraphics.GLConstants;
import de.fhpotsdam.unfolding.Map;
import de.fhpotsdam.unfolding.mapdisplay.MapDisplayFactory;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Enables switching between different tile providers for the same map.
 * 
 * After switching the tile cache will be cleared and visible tiles loaded from new provider.
 * Compare with {@link DynamicMapSwitch}.
 * 
 * All map settings are persistent. Current transformations, markers, interactions, etc will stay
 * the same.
 */

public class DynamicProviderSwitch extends PApplet {

	Map map;
	AbstractMapProvider provider1;
	AbstractMapProvider provider2;
	AbstractMapProvider provider3;

	public void setup() {
		size(800, 600, GLConstants.GLGRAPHICS);

		provider1 = new Google.GoogleMapProvider();
		provider2 = new Microsoft.AerialProvider();
		provider3 = new OpenStreetMap.CloudmadeProvider(MapDisplayFactory.OSM_API_KEY, 23058);

		map = new Map(this, provider1);
		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		background(0);

		map.draw();
	}

	public void keyPressed() {
		if (key == '1') {
			map.mapDisplay.setProvider(provider1);
		} else if (key == '2') {
			map.mapDisplay.setProvider(provider2);
		} else if (key == '3') {
			map.mapDisplay.setProvider(provider3);
		}
	}

}
