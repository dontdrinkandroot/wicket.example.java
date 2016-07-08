package net.dontdrinkandroot.wicket.test.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.test.component.LifecycleComponent;
import net.dontdrinkandroot.wicket.test.page.DecoratorWidePage;


public class LifecyclePage extends DecoratorWidePage<Void>
{

	public LifecyclePage(PageParameters parameters)
	{
		super(parameters);
		this.add(new LifecycleComponent("lifecycle"));
	}

}
