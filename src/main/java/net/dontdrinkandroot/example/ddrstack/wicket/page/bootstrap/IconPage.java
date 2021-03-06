package net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.GlyphIconClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class IconPage extends AbstractBootstrapPage<Void>
{

    public IconPage(PageParameters parameters)
    {

        super(parameters);

        RepeatingView iconItemView = new RepeatingView("iconItem");
        this.add(iconItemView);

        for (CssClass icon : GlyphIconClass.values()) {

            WebMarkupContainer iconItemContainer = new WebMarkupContainer(iconItemView.newChildId());
            iconItemView.add(iconItemContainer);

            WebMarkupContainer iconContainer = new WebMarkupContainer("icon");
            iconContainer.add(new CssClassAppender(icon));
            iconItemContainer.add(iconContainer);

            Label iconLabel = new Label("label", icon.getClassString());
            iconItemContainer.add(iconLabel);
        }
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {

        return new Model<String>("Icon Demo");
    }
}
