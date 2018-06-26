package net.dontdrinkandroot.example.ddrstack.wicket.component.bootstrap.fontawesome;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIcon;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIconClass;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;


public class FontAwesomeIconsPanel extends SimplePanel<Void>
{

	public FontAwesomeIconsPanel(String id)
	{

		super(id, Model.of("All Icons"), Heading.Level.H2);
	}

	@Override
	protected void onInitialize()
	{

		super.onInitialize();

		RepeatingView iconItemView = new RepeatingView("iconItem");
		this.add(iconItemView);

		for (FontAwesomeIconClass iconClass : FontAwesomeIconClass.values()) {

			WebMarkupContainer iconItemContainer = new WebMarkupContainer(iconItemView.newChildId());
			iconItemView.add(iconItemContainer);

			WebMarkupContainer iconContainer = new WebMarkupContainer("icon");
			iconContainer.add(new CssClassAppender(new FontAwesomeIcon(iconClass).setFixedWidth(true)));
			iconItemContainer.add(iconContainer);

			Label iconLabel = new Label("label", iconClass.getClassString());
			iconItemContainer.add(iconLabel);
		}
	}

}
