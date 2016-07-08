package net.dontdrinkandroot.wicket.test.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.test.component.ExampleBorder;
import net.dontdrinkandroot.wicket.test.page.bootstrap.AbstractBootstrapPage;


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
