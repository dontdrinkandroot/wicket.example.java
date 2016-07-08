package net.dontdrinkandroot.wicketexample.web.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicketexample.web.component.ExampleBorder;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.AbstractBootstrapPage;


public class FragmentBorderPage extends AbstractBootstrapPage<Void>
{

	public FragmentBorderPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new ExampleBorder("inputGroup"));
	}
}
