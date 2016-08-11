package net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.component;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.example.wicket.dontdrinkandroot.component.LifecycleComponent;
import net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.DecoratorPage;


public class LifecyclePage extends DecoratorPage<Void>
{

	public LifecyclePage(PageParameters parameters)
	{
		super(parameters);
		this.add(new LifecycleComponent("lifecycle"));
	}

}
