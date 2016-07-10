package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.label.DefaultLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.ImportantLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.InfoLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.InverseLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.SuccessLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.WarningLabel;


public class LabelPage extends AbstractBootstrapPage<Void>
{

	public LabelPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new DefaultLabel("defaultLabel", Model.of("Default")));
		this.add(new InfoLabel("infoLabel", Model.of("Info")));
		this.add(new SuccessLabel("successLabel", Model.of("Success")));
		this.add(new WarningLabel("warningLabel", Model.of("Warning")));
		this.add(new InverseLabel("inverseLabel", Model.of("Inverse")));
		this.add(new ImportantLabel("importantLabel", Model.of("Important")));
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{

		return new Model<String>("Label Demo");
	}

}
