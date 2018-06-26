package net.dontdrinkandroot.example.ddrstack.wicket.page.component;

import net.dontdrinkandroot.example.ddrstack.wicket.page.DecoratorPage;
import net.dontdrinkandroot.extensions.wicket.behavior.PageHeightScalingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
