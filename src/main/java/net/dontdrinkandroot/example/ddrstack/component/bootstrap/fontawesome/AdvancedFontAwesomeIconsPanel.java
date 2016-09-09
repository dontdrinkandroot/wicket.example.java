package net.dontdrinkandroot.example.ddrstack.component.bootstrap.fontawesome;

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIcon;
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesomeIconClass;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;


public class AdvancedFontAwesomeIconsPanel extends SimplePanel<Void> {

	public AdvancedFontAwesomeIconsPanel(String id) {

		super(id, Model.of("Advanced Icons"), Heading.Level.H2);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new WebMarkupContainer("arrowUp").add(new IconBehavior(
				new FontAwesomeIcon(FontAwesomeIconClass.ARROW).setDirection("up"))));
		this.add(new WebMarkupContainer("arrowDown").add(new IconBehavior(new FontAwesomeIcon(
				FontAwesomeIconClass.ARROW).setDirection("down"))));
		this.add(new WebMarkupContainer("arrowLeft").add(new IconBehavior(new FontAwesomeIcon(
				FontAwesomeIconClass.ARROW).setDirection("left"))));
		this.add(new WebMarkupContainer("arrowRight").add(new IconBehavior(new FontAwesomeIcon(
				FontAwesomeIconClass.ARROW).setDirection("right"))));

		this.add(new WebMarkupContainer("spinning").add(new IconBehavior(
				new FontAwesomeIcon(FontAwesomeIconClass.COG).setSpinning(true))));

		this.add(new WebMarkupContainer("outline").add(new IconBehavior(
				new FontAwesomeIcon(FontAwesomeIconClass.BELL).setOutline(true))));
	}

}
