package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import java.util.Arrays;

import net.dontdrinkandroot.wicket.bootstrap.component.button.DisablingSubmitButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.component.form.CheckBoxFormGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.FormHorizontal;
import net.dontdrinkandroot.wicket.bootstrap.component.form.SelectFormGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.TextAreaFormGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.TextFieldFormGroup;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;
import net.dontdrinkandroot.wicket.bootstrap.css.CombinedColumnSize;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;


public class FormPage extends AbstractBootstrapPage<Void> {

	public FormPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Form Demo");
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Form<Void> validationForm = new Form<Void>("validationForm");
		validationForm.setOutputMarkupId(true);
		this.add(validationForm);

		final TextFieldFormGroup<String> eMailField =
				new TextFieldFormGroup<String>("eMailField", new Model<String>(), new Model<String>("eMail"));
		eMailField.getFormComponent().add(EmailAddressValidator.getInstance());
		eMailField.getFormComponent().setRequired(true);
		validationForm.add(eMailField);

		final TextFieldFormGroup<String> requiredField =
				new TextFieldFormGroup<String>("requiredField", new Model<String>(), new Model<String>("required"));
		requiredField.getFormComponent().setRequired(true);
		validationForm.add(requiredField);

		DisablingSubmitButtonLink<Void> submitLink =
				new DisablingSubmitButtonLink<Void>("submitLink", null, new Model<String>("Submit")) {

					@Override
					protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

						try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						this.success(String.format(
								"Form validated successfully with eMail: %s and required: %s",
								eMailField.getModelObject(),
								requiredField.getModelObject()));
						target.add(FormPage.this.getFeedbackPanel());
						eMailField.setModelObject(null);
						requiredField.setModelObject(null);
						target.add(form);
					}


					@Override
					protected void onError(AjaxRequestTarget target, Form<?> form) {

						try {
							Thread.sleep(1000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						target.add(form);
					}
				};
		validationForm.add(submitLink);

		CombinedColumnSize labelSize = new CombinedColumnSize(ColumnSize.MD_3);
		CombinedColumnSize formComponentSize = new CombinedColumnSize(ColumnSize.MD_9);

		Form<Void> horizontalForm = new FormHorizontal<Void>("horizontalForm", labelSize, formComponentSize);
		this.add(horizontalForm);
		this.createFormComponents(horizontalForm);
	}


	private void createFormComponents(Form<Void> form) {

		TextFieldFormGroup<String> textFieldFormGroup =
				new TextFieldFormGroup<String>("textFieldFormGroup", new Model<String>(), Model.of("Text Field"));
		form.add(textFieldFormGroup);

		TextAreaFormGroup<String> textAreaFormGroup =
				new TextAreaFormGroup<String>("textAreaFormGroup", new Model<String>(), Model.of("Text Area"));
		form.add(textAreaFormGroup);

		CheckBoxFormGroup checkBoxFormGroup =
				new CheckBoxFormGroup("checkBoxFormGroup", new Model<Boolean>(), Model.of("Check Box"));
		form.add(checkBoxFormGroup);

		SelectFormGroup<Integer> selectFormGroup =
				new SelectFormGroup<Integer>(
						"selectFormGroup",
						new Model<Integer>(2),
						Model.of("Select"),
						Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		form.add(selectFormGroup);

	}
}
