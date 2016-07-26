package net.dontdrinkandroot.wicket.test.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.test.component.LifecycleComponent;
import net.dontdrinkandroot.wicket.test.page.DecoratorPage;


public class LifecyclePage extends DecoratorPage<Void>
{

	public LifecyclePage(PageParameters parameters)
	{
		super(parameters);
		this.add(new LifecycleComponent("lifecycle"));
	}

}
