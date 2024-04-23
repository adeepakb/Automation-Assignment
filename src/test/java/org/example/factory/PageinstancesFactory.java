package org.example.factory;


import org.example.context.WebDriverContext;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

/**
 * A factory for creating Pageinstances objects.
 */
public class PageinstancesFactory {

	/**
	 * Gets the single instance of PageinstancesFactory.
	 *
	 * @return single instance of PageinstancesFactory
	 */
	public static <T extends BasePage> T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
