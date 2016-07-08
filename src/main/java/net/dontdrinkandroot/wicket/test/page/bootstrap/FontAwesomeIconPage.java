package net.dontdrinkandroot.wicket.test.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem;
import net.dontdrinkandroot.wicket.test.component.bootstrap.fontawesome.AdvancedFontAwesomeIconsPanel;
import net.dontdrinkandroot.wicket.test.component.bootstrap.fontawesome.FontAwesomeIconsPanel;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class FontAwesomeIconPage extends AbstractBootstrapPage<Void> {

	public FontAwesomeIconPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new FontAwesomeIconsPanel("allIcons"));
		this.add(new AdvancedFontAwesomeIconsPanel("combinedIcons"));
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Font Awesome Icon Demo");
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);
		response.render(new FontAwesomeCssHeaderItem());
	}

}
