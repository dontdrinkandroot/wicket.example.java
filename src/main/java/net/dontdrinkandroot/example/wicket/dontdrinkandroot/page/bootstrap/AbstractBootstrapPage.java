package net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.bootstrap;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.DecoratorPage;


public class AbstractBootstrapPage<T> extends DecoratorPage<T>
{

	public AbstractBootstrapPage(PageParameters parameters)
	{

		super(parameters);
	}

}
