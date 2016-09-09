package net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.bootstrap;

import net.dontdrinkandroot.example.wicket.dontdrinkandroot.component.bootstrap.fontawesome.AdvancedFontAwesomeIconsPanel;
import net.dontdrinkandroot.example.wicket.dontdrinkandroot.component.bootstrap.fontawesome.FontAwesomeIconsPanel;
import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FontAwesomeIconPage extends AbstractBootstrapPage<Void>
{
	public FontAwesomeIconPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new FontAwesomeIconsPanel("allIcons"));
		this.add(new AdvancedFontAwesomeIconsPanel("combinedIcons"));
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return new Model<String>("Font Awesome Icon Demo");
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.render(new FontAwesomeCssHeaderItem());
	}
}
