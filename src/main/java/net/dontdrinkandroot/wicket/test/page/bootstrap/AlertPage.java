package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.javascript.JQueryScript;


public class AlertPage extends AbstractBootstrapPage<Void>
{

	public AlertPage(PageParameters parameters)
	{

		super(parameters);

		this.debug("Debug Message");
		this.info("Info Message");
		this.warn("Warning Message");
		this.error("Error Message");

		this.add(new AjaxLink<Void>("debug") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{

				this.debug("Debug message");
				target.add(AlertPage.this.getFeedbackPanel());
				target.appendJavaScript(
						new JQueryScript(AlertPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}
		}.add(new ButtonBehavior()));

		this.add(new AjaxLink<Void>("info") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{

				this.info("Info message");
				target.add(AlertPage.this.getFeedbackPanel());
				target.appendJavaScript(
						new JQueryScript(AlertPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}
		}.add(new ButtonBehavior().setButtonStyle(ButtonStyle.INFO)));

		this.add(new AjaxLink<Void>("warn") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{

				this.warn("Warn message");
				target.add(AlertPage.this.getFeedbackPanel());
				target.appendJavaScript(
						new JQueryScript(AlertPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}
		}.add(new ButtonBehavior().setButtonStyle(ButtonStyle.WARNING)));

		this.add(new AjaxLink<Void>("error") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{

				this.error("Error message");
				target.add(AlertPage.this.getFeedbackPanel());
				target.appendJavaScript(
						new JQueryScript(AlertPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}
		}.add(new ButtonBehavior().setButtonStyle(ButtonStyle.DANGER)));
	}
}
