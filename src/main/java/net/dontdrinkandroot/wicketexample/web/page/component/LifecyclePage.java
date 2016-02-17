package net.dontdrinkandroot.wicketexample.web.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicketexample.web.component.LifecycleComponent;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;


public class LifecyclePage extends DecoratorWidePage<Void>
{

	public LifecyclePage(PageParameters parameters)
	{
		super(parameters);
		this.add(new LifecycleComponent("lifecycle"));
	}

}
