package net.dontdrinkandroot.example.ddrstack.page.component;

import net.dontdrinkandroot.example.ddrstack.component.ExampleBorder;
import net.dontdrinkandroot.example.ddrstack.page.bootstrap.AbstractBootstrapPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

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
