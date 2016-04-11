package net.dontdrinkandroot.wicketexample.web.page.form;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes.EventPropagation;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;


public class FormPage extends DecoratorWidePage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		Form<?> typeAwareTextFieldForm = new Form<Void>("typeAwareTextFieldForm");
		this.add(typeAwareTextFieldForm);

		final FencedFeedbackPanel typeAwareTextFieldFeedbackPanel =
				new FencedFeedbackPanel("typeAwareTextFieldFeedbackPanel");
		typeAwareTextFieldFeedbackPanel.setOutputMarkupId(true);
		typeAwareTextFieldForm.add(typeAwareTextFieldFeedbackPanel);

		IModel<String> typeAwareTextFieldModel = Model.of("");
		final FormGroupTextField<String> typeAwareTextField = new FormGroupTextField<String>(
				"typeAwareTextField",
				typeAwareTextFieldModel,
				Model.of("TypeAwareTextField"));
		typeAwareTextFieldForm.add(typeAwareTextField);

		AjaxEventBehavior typeAwareBehavior = new AjaxFormComponentUpdatingBehavior("input") {

			@Override
			protected void onUpdate(AjaxRequestTarget target)
			{
				if ((null != typeAwareTextField.getModelObject()) && !typeAwareTextField.getModelObject().isEmpty()) {
					typeAwareTextFieldFeedbackPanel.info(typeAwareTextField.getModelObject());
				}
				target.add(typeAwareTextFieldFeedbackPanel);
			}

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				attributes.setThrottlingSettings(
						new ThrottlingSettings("textfield.input", Duration.milliseconds(250), true));
			}
		};

		AjaxEventBehavior preventEnterBehavior = new AjaxFormComponentUpdatingBehavior("keypress") {

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				AjaxCallListener ajaxCallListener = new AjaxCallListener();
				ajaxCallListener.onPrecondition(
						"var keyCode = Wicket.Event.keyCode(attrs.event); if (keyCode === 13) {attrs.event.preventDefault(); return false;} else {return true;}");

				attributes.getAjaxCallListeners().add(ajaxCallListener);
				attributes.setEventPropagation(EventPropagation.STOP_IMMEDIATE);
			}

			@Override
			protected void onUpdate(AjaxRequestTarget target)
			{
				/* Noop */
			}
		};

		typeAwareTextField.getFormComponent().add(preventEnterBehavior);
		typeAwareTextField.getFormComponent().add(typeAwareBehavior);
	}

}
