package net.dontdrinkandroot.example.ddrstack.wicket.component.bootstrap.button;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBlockLevelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;


public class ButtonStylePanel extends SimplePanel<Void>
{

	public ButtonStylePanel(String id)
	{
		super(id, Model.of("Styles"), Heading.Level.H2);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new Link<Void>("defaultButton", null) {

			@Override
			public void onClick()
			{
				this.debug("defaultButton Clicked");
			}
		}.setBody(new Model<String>("defaultButton")).add(new ButtonBehavior()).add(new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("primaryButton", null) {

			@Override
			public void onClick()
			{
				this.debug("primaryButton Clicked");
			}
		}.setBody(new Model<String>("primaryButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.PRIMARY)).add(
				new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("infoButton", null) {

			@Override
			public void onClick()
			{
				this.info("infoButton Clicked");
			}
		}.setBody(new Model<String>("infoButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.INFO)).add(
				new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("successButton", null) {

			@Override
			public void onClick()
			{
				this.success("successButton Clicked");
			}
		}.setBody(new Model<String>("successButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.SUCCESS)).add(
				new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("warningButton", null) {

			@Override
			public void onClick()
			{
				this.success("warningButton Clicked");
			}
		}.setBody(new Model<String>("warningButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.WARNING)).add(
				new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("dangerButton", null) {

			@Override
			public void onClick()
			{
				this.debug("dangerButton Clicked");
			}
		}.setBody(new Model<String>("dangerButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.DANGER)).add(
				new ButtonBlockLevelBehavior()));
		this.add(new Link<Void>("linkButton", null) {

			@Override
			public void onClick()
			{
				this.debug("linkButton Clicked");
			}
		}.setBody(new Model<String>("linkButton")).add(new ButtonBehavior().setButtonStyle(ButtonStyle.LINK)).add(
				new ButtonBlockLevelBehavior()));
	}

}
