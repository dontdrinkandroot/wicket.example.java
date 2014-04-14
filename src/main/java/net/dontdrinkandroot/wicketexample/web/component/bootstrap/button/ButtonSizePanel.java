package net.dontdrinkandroot.wicketexample.web.component.bootstrap.button;

import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.component.basic.Heading;

import org.apache.wicket.model.Model;


public class ButtonSizePanel extends SimplePanel<Void> {

	public ButtonSizePanel(String id) {

		super(id, Model.of("Sizes"), Heading.Level.H2);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonLink<Void>("extraSmallButton", null, new Model<String>("extraSmallButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.EXTRA_SMALL));
		this.add(new ButtonLink<Void>("smallButton", null, new Model<String>("smallButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.SMALL));
		this.add(new ButtonLink<Void>("normalButton", null, new Model<String>("normalButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		});
		this.add(new ButtonLink<Void>("largeButton", null, new Model<String>("largeButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}
		}.setButtonSize(ButtonSize.LARGE));
	}

}
