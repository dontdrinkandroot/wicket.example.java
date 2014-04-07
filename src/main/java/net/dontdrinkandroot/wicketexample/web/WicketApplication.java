package net.dontdrinkandroot.wicketexample.web;

import net.dontdrinkandroot.wicketexample.web.component.DateImageResource;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.ButtonPage;
import net.dontdrinkandroot.wicketexample.web.page.resources.ResourcesPage;

import org.apache.log4j.lf5.util.Resource;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.ResourceReference;


public class WicketApplication extends WebApplication {

	public WicketApplication() {

		super();
	}


	@Override
	public Class<? extends Page> getHomePage() {

		return ButtonPage.class;
	}


	@Override
	protected void init() {

		super.init();

		this.getMarkupSettings().setStripWicketTags(true);

		this.getSharedResources().add(Resource.class, "dateImage", null, null, null, new DateImageResource());
		ResourceReference dateImageResource =
				this.getSharedResources().get(Resource.class, "dateImage", null, null, null, true);
		this.mountResource("images/dateImage", dateImageResource);
		this.mountPage("resources", ResourcesPage.class);

		this.mountPage("bootstrap/button", ButtonPage.class);
	}

}
