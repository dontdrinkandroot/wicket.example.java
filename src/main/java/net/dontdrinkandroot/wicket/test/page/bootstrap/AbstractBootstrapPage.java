package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.test.page.DecoratorWidePage;


public class AbstractBootstrapPage<T> extends DecoratorWidePage<T> {

	public AbstractBootstrapPage(PageParameters parameters) {

		super(parameters);
	}

}
