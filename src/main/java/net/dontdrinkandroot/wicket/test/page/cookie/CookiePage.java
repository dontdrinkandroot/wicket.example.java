package net.dontdrinkandroot.wicket.test.page.cookie;

import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.cookies.CookieUtils;

import net.dontdrinkandroot.wicket.test.page.DecoratorPage;


public class CookiePage extends DecoratorPage<Void>
{

	public CookiePage(PageParameters parameters)
	{

		super(parameters);

		CookieUtils cookieUtils = new CookieUtils();
		String lastVisitDate = cookieUtils.load("lastVisitDate");

		Label label = new Label("lastVisitDate", lastVisitDate);
		this.add(label);

		cookieUtils.save("lastVisitDate", new Date().toString());
	}

}
