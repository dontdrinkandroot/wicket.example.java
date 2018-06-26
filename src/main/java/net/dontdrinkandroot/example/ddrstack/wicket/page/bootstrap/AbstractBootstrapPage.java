package net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap;

import net.dontdrinkandroot.example.ddrstack.wicket.page.DecoratorPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AbstractBootstrapPage<T> extends DecoratorPage<T>
{
    public AbstractBootstrapPage(PageParameters parameters)
    {
        super(parameters);
    }
}
