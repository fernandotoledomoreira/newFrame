package br.com.elo.qa.test.automation.core.selenium.webdriver;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ElementLocatorFactoryCustom implements ElementLocatorFactory {
	private final SearchContext searchContext;
	private final Object instance;

	public ElementLocatorFactoryCustom(final SearchContext searchContext, final Object instance) {
		this.searchContext = searchContext;
		this.instance = instance;
	}

	@Override
	public ElementLocator createLocator(Field field) {
		return new ElementLocatorCustom(searchContext, field, instance);
	}
}
