package net.dontdrinkandroot.wicket.test.page.component;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.behavior.PageHeightScalingBehavior;
import net.dontdrinkandroot.wicket.test.page.DecoratorPage;


public class PageHeightScalingPage extends DecoratorPage<Void>
{

	public PageHeightScalingPage(PageParameters parameters)
	{

		super(parameters);

		WebMarkupContainer scaling = new WebMarkupContainer("scaling");
		scaling.add(new PageHeightScalingBehavior());
		scaling.setOutputMarkupId(true);
		this.add(scaling);
	}

}
