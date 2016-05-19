package net.dontdrinkandroot.wicketexample.web.page.component;

import java.util.Calendar;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.component.calendar.DaySelectionTable;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.AbstractBootstrapPage;


public class CalendarPage extends AbstractBootstrapPage<Void>
{

	public CalendarPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		DaySelectionTable daySelectionTable = new DaySelectionTable(
				"daySelection",
				new Model<Integer>(),
				new Model<Integer>(2017),
				new Model<Integer>(Calendar.FEBRUARY));
		this.add(daySelectionTable);
	}

}
