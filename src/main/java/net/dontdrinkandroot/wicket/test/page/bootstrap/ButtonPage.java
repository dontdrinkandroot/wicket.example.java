package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroup;
import net.dontdrinkandroot.wicket.bootstrap.css.GlyphIconClass;
import net.dontdrinkandroot.wicket.test.component.bootstrap.button.ButtonSizePanel;
import net.dontdrinkandroot.wicket.test.component.bootstrap.button.ButtonStylePanel;


public class ButtonPage extends AbstractBootstrapPage<Void>
{

	public ButtonPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new ButtonStylePanel("styles"));
		this.add(new ButtonSizePanel("sizes"));

		this.add(new Link<Void>("disabledInputButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}

		}.setBody(new Model<String>("disabledInputButton")).add(new ButtonBehavior()).setEnabled(false));

		this.add(new Link<Void>("disabledAButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}

		}.setBody(new Model<String>("disabledAButton")).add(new ButtonBehavior()).setEnabled(false));

		this.add(new AjaxLink<Void>("disabledSubmitButton", null) {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				/* Noop */
			}

		}.setBody(new Model<String>("disabledSubmitButton")).add(new ButtonBehavior()).setEnabled(false));

		this.add(new AjaxLink<Void>("disabledButtonButton", null) {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				/* Noop */
			}

		}.setBody(new Model<String>("disabledButtonButton")).add(new ButtonBehavior()).setEnabled(false));

		this.addButtonGroupDemo();
	}

	private void addButtonGroupDemo()
	{

		ButtonGroup<Void> singleButtonGroup = new ButtonGroup<Void>("singleButtonGroup") {

			@Override
			protected void createButtons(RepeatingView buttonView)
			{

				buttonView.add(new AjaxLink<Void>(buttonView.newChildId(), null) {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						this.info("Left clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				}.setBody(new Model<String>("Left")).add(new ButtonBehavior()));

				buttonView.add(new AjaxLink<Void>(buttonView.newChildId(), null) {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						this.info("Middle clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				}.setBody(new Model<String>("Middle")).add(new ButtonBehavior()));

				buttonView.add(new AjaxLink<Void>(buttonView.newChildId(), null) {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						this.info("Right clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				}.setBody(new Model<String>("Right")).add(new ButtonBehavior()));
			}

		};
		this.add(singleButtonGroup);

		Link<Void> iconButton = new Link<Void>("iconButton", null) {

			@Override
			public void onClick()
			{
				/* Noop */
			}
		};
		iconButton.setBody(Model.of("Icon Button"));
		iconButton.add(new ButtonBehavior());
		iconButton.add(new IconBehavior().setPrependIcon(GlyphIconClass.USER).setAppendIcon(GlyphIconClass.ASTERISK));
		this.add(iconButton);

	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return new Model<String>("Button Demo");
	}

}
