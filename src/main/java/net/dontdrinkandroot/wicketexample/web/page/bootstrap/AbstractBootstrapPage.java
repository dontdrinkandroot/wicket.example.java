package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AbstractBootstrapPage<T> extends DecoratorWidePage<T> {

	public AbstractBootstrapPage(PageParameters parameters) {

		super(parameters);
	}

}
