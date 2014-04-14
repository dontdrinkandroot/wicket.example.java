package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.css.GlyphIconClass;
import net.dontdrinkandroot.wicketexample.web.component.bootstrap.button.ButtonSizePanel;
import net.dontdrinkandroot.wicketexample.web.component.bootstrap.button.ButtonStylePanel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ButtonPage extends AbstractBootstrapPage<Void> {

	public ButtonPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonStylePanel("styles"));
		this.add(new ButtonSizePanel("sizes"));

		this.add(new ButtonLink<Void>("disabledInputButton", null, new Model<String>("disabledInputButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}

		}.setEnabled(false));
		this.add(new ButtonLink<Void>("disabledAButton", null, new Model<String>("disabledAButton")) {

			@Override
			public void onClick() {

				/* Noop */
			}

		}.setEnabled(false));
		this.add(new AjaxButtonLink<Void>("disabledSubmitButton", null, new Model<String>("disabledSubmitButton")) {

			@Override
			public void onClick(AjaxRequestTarget target) {

				/* Noop */
			}

		}.setEnabled(false));

		this.addButtonGroupDemo();
	}


	private void addButtonGroupDemo() {

		ButtonGroup<Void> singleButtonGroup = new ButtonGroup<Void>("singleButtonGroup") {

			@Override
			protected void createButtons(RepeatingView buttonView) {

				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Left")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Left clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Middle")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Middle clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
				buttonView.add(new AjaxButtonLink<Void>(buttonView.newChildId(), null, new Model<String>("Right")) {

					@Override
					public void onClick(AjaxRequestTarget target) {

						this.info("Right clicked");
						target.add(ButtonPage.this.getFeedbackPanel());
					}

				});
			}

		};
		this.add(singleButtonGroup);

		ButtonLink<Void> iconButton = new ButtonLink<Void>("iconButton", null, Model.of("Icon Button")) {

			@Override
			public void onClick() {

				// TODO Auto-generated method stub

			}
		};
		iconButton.add(new IconBehavior().setPrependIcon(GlyphIconClass.USER).setAppendIcon(GlyphIconClass.ASTERISK));
		this.add(iconButton);

	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Button Demo");
	}

}
