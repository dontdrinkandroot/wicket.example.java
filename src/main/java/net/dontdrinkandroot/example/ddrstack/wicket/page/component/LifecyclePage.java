package net.dontdrinkandroot.example.ddrstack.wicket.page.component;

import net.dontdrinkandroot.example.ddrstack.wicket.component.LifecycleComponent;
import net.dontdrinkandroot.example.ddrstack.wicket.page.DecoratorPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LifecyclePage extends DecoratorPage<Void>
{

    public LifecyclePage(PageParameters parameters)
    {
        super(parameters);
        this.add(new LifecycleComponent("lifecycle"));
    }
}
