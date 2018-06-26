package net.dontdrinkandroot.example.ddrstack.component;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;

public class LifecycleComponent extends WebMarkupContainer
{
    public LifecycleComponent(String id)
    {
        super(id, Model.of("Test"));
    }

    @Override
    protected void onInitialize()
    {
        System.out.println("onInitialize");
        super.onInitialize();
    }

    @Override
    protected void onConfigure()
    {
        System.out.println("onConfigure");
        super.onConfigure();
    }

    @Override
    protected void onBeforeRender()
    {
        System.out.println("onBeforeRender");
        super.onBeforeRender();
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        System.out.println("renderHead");
        super.renderHead(response);
    }

    @Override
    protected void onRender()
    {
        System.out.println("onRender");
        super.onRender();
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        System.out.println("onComponentTag");
        super.onComponentTag(tag);
    }

    @Override
    public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag)
    {
        System.out.println("onComponentTagBody");
        super.onComponentTagBody(markupStream, openTag);
    }

    @Override
    protected void onAfterRender()
    {
        System.out.println("onAfterRender");
        super.onAfterRender();
    }

    @Override
    protected void onRemove()
    {
        System.out.println("onRemove");
        super.onRemove();
    }

    @Override
    protected void onDetach()
    {
        System.out.println("onDetach");
        super.onDetach();
    }

    @Override
    public void onEvent(IEvent<?> event)
    {
        System.out.println("onEvent");
        super.onEvent(event);
    }

    @Override
    protected void onModelChanged()
    {
        System.out.println("onModelChanged");
        super.onModelChanged();
    }

    @Override
    protected void onModelChanging()
    {
        System.out.println("onModelChanging");
        super.onModelChanging();
    }

    @Override
    protected void onReAdd()
    {
        System.out.println("onReAdd");
        super.onReAdd();
    }
}
