package net.dontdrinkandroot.wicketexample.web.component.bootstrap.button;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBlockLevelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.component.basic.Heading;

import org.apache.wicket.model.Model;


public class ButtonStylePanel extends SimplePanel<Void> {

	public ButtonStylePanel(String id) {

		super(id, Model.of("Styles"), Heading.Level.H2);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonLink<Void>("defaultButton", null, new Model<String>("defaultButton")) {

			@Override
			public void onClick() {

				this.debug("defaultButton Clicked");
			}
		}.add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("primaryButton", null, new Model<String>("primaryButton")) {

			@Override
			public void onClick() {

				this.debug("primaryButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.PRIMARY).add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("infoButton", null, new Model<String>("infoButton")) {

			@Override
			public void onClick() {

				this.info("infoButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.INFO).add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("successButton", null, new Model<String>("successButton")) {

			@Override
			public void onClick() {

				this.success("successButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.SUCCESS).add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("warningButton", null, new Model<String>("warningButton")) {

			@Override
			public void onClick() {

				this.success("warningButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.WARNING).add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("dangerButton", null, new Model<String>("dangerButton")) {

			@Override
			public void onClick() {

				this.debug("dangerButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.DANGER).add(new ButtonBlockLevelBehavior()));
		this.add(new ButtonLink<Void>("linkButton", null, new Model<String>("linkButton")) {

			@Override
			public void onClick() {

				this.debug("linkButton Clicked");
			}
		}.setButtonStyle(ButtonStyle.LINK).add(new ButtonBlockLevelBehavior()));
	}

}
