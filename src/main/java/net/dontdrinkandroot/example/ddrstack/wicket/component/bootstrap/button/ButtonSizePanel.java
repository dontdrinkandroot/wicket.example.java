package net.dontdrinkandroot.example.ddrstack.wicket.component.bootstrap.button;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;


public class ButtonSizePanel extends SimplePanel<Void>
{

	public ButtonSizePanel(String id)
	{
		super(id, Model.of("Sizes"), Heading.Level.H2);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new Link<Void>("extraSmallButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}
		}.setBody(new Model<String>("extraSmallButton")).add(
				new ButtonBehavior().setButtonSize(ButtonSize.EXTRA_SMALL)));

		this.add(new Link<Void>("smallButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}
		}.setBody(new Model<String>("smallButton")).add(new ButtonBehavior().setButtonSize(ButtonSize.SMALL)));

		this.add(new Link<Void>("normalButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}
		}.setBody(new Model<String>("normalButton")).add(new ButtonBehavior()));

		this.add(new Link<Void>("largeButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}
		}.setBody(new Model<String>("largeButton")).add(new ButtonBehavior().setButtonSize(ButtonSize.LARGE)));
	}

}
