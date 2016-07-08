package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.panel.Panel;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;
import net.dontdrinkandroot.wicket.component.basic.Heading;


public class PanelPage extends AbstractBootstrapPage<Void>
{

	public PanelPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		final Panel<Void> defaultPanel =
				new SimplePanel<Void>("panelDefault", Model.of("Default Panel"), Heading.Level.H2);
		this.add(defaultPanel);

		final Panel<Void> primaryPanel =
				new SimplePanel<Void>("panelPrimary", Model.of("Primary Panel"), Heading.Level.H2);
		primaryPanel.setPanelStyle(PanelStyle.PRIMARY);
		this.add(primaryPanel);

		final Panel<Void> successPanel =
				new SimplePanel<Void>("panelSuccess", Model.of("Success Panel"), Heading.Level.H2);
		successPanel.setPanelStyle(PanelStyle.SUCCESS);
		this.add(successPanel);

		final Panel<Void> infoPanel = new SimplePanel<Void>("panelInfo", Model.of("Info Panel"), Heading.Level.H2);
		infoPanel.setPanelStyle(PanelStyle.INFO);
		this.add(infoPanel);

		final Panel<Void> warningPanel =
				new SimplePanel<Void>("panelWarning", Model.of("Warning Panel"), Heading.Level.H2);
		warningPanel.setPanelStyle(PanelStyle.WARNING);
		this.add(warningPanel);

		final Panel<Void> dangerPanel =
				new SimplePanel<Void>("panelDanger", Model.of("Danger Panel"), Heading.Level.H2);
		dangerPanel.setPanelStyle(PanelStyle.DANGER);
		this.add(dangerPanel);
	}

}
