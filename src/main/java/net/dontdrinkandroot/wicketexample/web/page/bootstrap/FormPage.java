package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import java.util.Arrays;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.DisablingSubmitButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.form.FormHorizontal;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupSelect;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextArea;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupUrlTextField;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;
import net.dontdrinkandroot.wicket.bootstrap.css.CombinedColumnSize;


public class FormPage extends AbstractBootstrapPage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> getPageTitleModel()
	{
		return new Model<String>("Form Demo");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(this.createValidationForm());
		this.add(this.createFormComponentsForm());
		this.add(this.createFormComponentsHorizontalForm());
	}

	private Form<Void> createValidationForm()
	{
		Form<Void> validationForm = new Form<Void>("validationForm");
		validationForm.setOutputMarkupId(true);

		RepeatingView formGroupsView = new RepeatingView("formGroup");
		validationForm.add(formGroupsView);

		final FormGroupTextField<String> eMailField = new FormGroupTextField<String>(
				formGroupsView.newChildId(),
				new Model<String>(),
				new Model<String>("EMail with onBlur"));
		eMailField.getFormComponent().add(EmailAddressValidator.getInstance());
		eMailField.getFormComponent().setRequired(true);
		eMailField.addOnlineValidation("blur");
		formGroupsView.add(eMailField);

		final FormGroupTextField<String> onInputValidationField = new FormGroupTextField<String>(
				formGroupsView.newChildId(),
				new Model<String>("Type.."),
				new Model<String>("On Input Validation"));
		onInputValidationField.getFormComponent().add(new IValidator<String>() {

			@Override
			public void validate(IValidatable<String> validatable)
			{
				if (!"your mother".equals(validatable.getValue())) {
					validatable.error(new ValidationError("I only accept 'your mother'"));
				}
			}
		});
		onInputValidationField.addOnlineValidation("input", new ThrottlingSettings(Duration.milliseconds(250), true));
		formGroupsView.add(onInputValidationField);

		final FormGroupTextField<String> requiredField = new FormGroupTextField<String>(
				formGroupsView.newChildId(),
				new Model<String>(),
				new Model<String>("required"));
		requiredField.getFormComponent().setRequired(true);
		formGroupsView.add(requiredField);

		DisablingSubmitButtonLink submitLink = new DisablingSubmitButtonLink("submitLink") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form)
			{
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.success(
						String.format(
								"Form validated successfully with eMail: %s and required: %s",
								eMailField.getModelObject(),
								requiredField.getModelObject()));
				target.add(FormPage.this.getFeedbackPanel());
				eMailField.setModelObject(null);
				requiredField.setModelObject(null);
				target.add(form);
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form)
			{
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				target.add(form);
			}
		};
		submitLink.setBody(new Model<String>("Submit"));
		validationForm.add(submitLink);

		return validationForm;
	}

	private Form<Void> createFormComponentsForm()
	{
		Form<Void> form = new Form<Void>("formComponentsForm");
		this.createFormComponents(form);

		form.add(new SubmitLink("submitButton").setBody(Model.of("Submit")).add(new ButtonBehavior()));

		return form;
	}

	private Form<Void> createFormComponentsHorizontalForm()
	{
		CombinedColumnSize labelSize = new CombinedColumnSize(ColumnSize.MD_3);
		CombinedColumnSize formComponentSize = new CombinedColumnSize(ColumnSize.MD_9);

		Form<Void> form = new FormHorizontal<Void>("formComponentsHorizontalForm", labelSize, formComponentSize);
		this.createFormComponents(form);

		form.add(new SubmitLink("submitButton").setBody(Model.of("Submit")).add(new ButtonBehavior()));

		return form;
	}

	private void createFormComponents(Form<Void> form)
	{
		RepeatingView formGroupView = new RepeatingView("formGroup");
		form.add(formGroupView);

		FormGroupTextField<String> textFieldFormGroup =
				new FormGroupTextField<String>(formGroupView.newChildId(), new Model<String>(), Model.of("Text Field"));
		formGroupView.add(textFieldFormGroup);

		formGroupView.add(new FormGroupUrlTextField(formGroupView.newChildId(), new Model<String>(), Model.of("URL")));

		FormGroupTextArea<String> textAreaFormGroup =
				new FormGroupTextArea<String>(formGroupView.newChildId(), new Model<String>(), Model.of("Text Area"));
		formGroupView.add(textAreaFormGroup);

		FormGroupCheckBox checkBoxFormGroup =
				new FormGroupCheckBox(formGroupView.newChildId(), new Model<Boolean>(), Model.of("Check Box"));
		formGroupView.add(checkBoxFormGroup);

		FormGroupSelect<Integer> selectFormGroup = new FormGroupSelect<Integer>(
				formGroupView.newChildId(),
				new Model<Integer>(2),
				Model.of("Select"),
				Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		formGroupView.add(selectFormGroup);
	}
}
