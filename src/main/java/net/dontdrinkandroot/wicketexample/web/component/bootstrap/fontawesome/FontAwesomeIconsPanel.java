package net.dontdrinkandroot.wicketexample.web.component.bootstrap.fontawesome;

import java.util.HashSet;
import java.util.Set;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIcon;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIconClass;
import net.dontdrinkandroot.wicket.component.basic.Heading;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;


public class FontAwesomeIconsPanel extends SimplePanel<Void> {

	public FontAwesomeIconsPanel(String id) {

		super(id, Model.of("All Icons"), Heading.Level.H2);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		/* Exclude base only icons */
		Set<FontAwesomeIconClass> excludeIcons = new HashSet<FontAwesomeIconClass>();
		excludeIcons.add(FontAwesomeIconClass.ARROW);
		excludeIcons.add(FontAwesomeIconClass.ALIGN);
		excludeIcons.add(FontAwesomeIconClass.DOT);
		excludeIcons.add(FontAwesomeIconClass.FILES);
		excludeIcons.add(FontAwesomeIconClass.LEVEL);
		excludeIcons.add(FontAwesomeIconClass.ANGLE);
		excludeIcons.add(FontAwesomeIconClass.BAR_CHART);
		excludeIcons.add(FontAwesomeIconClass.HAND);
		excludeIcons.add(FontAwesomeIconClass.VOLUME);
		excludeIcons.add(FontAwesomeIconClass.BUILDING);
		excludeIcons.add(FontAwesomeIconClass.CARET);
		excludeIcons.add(FontAwesomeIconClass.ELLIPSIS);
		excludeIcons.add(FontAwesomeIconClass.TRASH);
		excludeIcons.add(FontAwesomeIconClass.HOSPITAL);
		excludeIcons.add(FontAwesomeIconClass.ARROW_CIRCLE);
		excludeIcons.add(FontAwesomeIconClass.LONG_ARROW);
		excludeIcons.add(FontAwesomeIconClass.QUOTE);
		excludeIcons.add(FontAwesomeIconClass.CHEVRON);
		excludeIcons.add(FontAwesomeIconClass.ANGLE_DOUBLE);

		RepeatingView iconItemView = new RepeatingView("iconItem");
		this.add(iconItemView);

		for (FontAwesomeIconClass iconClass : FontAwesomeIconClass.values()) {

			if (excludeIcons.contains(iconClass)) {
				continue;
			}

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
