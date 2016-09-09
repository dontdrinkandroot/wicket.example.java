package net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.form;

import net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.DecoratorPage;
import net.dontdrinkandroot.extension.wicket.component.form.formgroup.FormGroupDateTimePicker;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes.EventPropagation;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;

import java.util.Date;


public class FormPage extends DecoratorPage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		Form<Void> dateTimePickerForm = new Form<Void>("dateTimePickerForm");
		this.add(dateTimePickerForm);

		RepeatingView formGroupDateTimeView = new RepeatingView("formGroupDateTime");
		dateTimePickerForm.add(formGroupDateTimeView);

		for (FormGroupDateTimePicker.Precision precision : FormGroupDateTimePicker.Precision.values()) {
			FormGroupDateTimePicker formGroupDateTimePicker = new FormGroupDateTimePicker(
					formGroupDateTimeView.newChildId(),
					Model.of(precision.getConverterFormat()),
					Model.of(new Date()),
					precision);
			formGroupDateTimeView.add(formGroupDateTimePicker);
		}

		Form<?> typeAwareTextFieldForm = new Form<Void>("typeAwareTextFieldForm");
		this.add(typeAwareTextFieldForm);

		final FencedFeedbackPanel typeAwareTextFieldFeedbackPanel =
				new FencedFeedbackPanel("typeAwareTextFieldFeedbackPanel");
		typeAwareTextFieldFeedbackPanel.setOutputMarkupId(true);
		typeAwareTextFieldForm.add(typeAwareTextFieldFeedbackPanel);

		IModel<String> typeAwareTextFieldModel = Model.of("");
		final FormGroupInputText typeAwareTextField =
				new FormGroupInputText("typeAwareTextField", Model.of("TypeAwareTextField"), typeAwareTextFieldModel);
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
