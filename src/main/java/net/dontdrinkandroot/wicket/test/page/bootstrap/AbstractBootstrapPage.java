package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.test.page.DecoratorPage;


public class AbstractBootstrapPage<T> extends DecoratorPage<T>
{

	public AbstractBootstrapPage(PageParameters parameters)
	{

		super(parameters);
	}

}
