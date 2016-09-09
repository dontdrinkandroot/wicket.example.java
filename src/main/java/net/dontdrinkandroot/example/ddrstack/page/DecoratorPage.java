package net.dontdrinkandroot.example.ddrstack.page;

import net.dontdrinkandroot.example.ddrstack.WicketApplication;
import net.dontdrinkandroot.example.ddrstack.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.example.ddrstack.page.bootstrap.FontAwesomeIconPage;
import net.dontdrinkandroot.example.ddrstack.page.bootstrap.IconPage;
import net.dontdrinkandroot.example.ddrstack.page.component.CalendarPage;
import net.dontdrinkandroot.example.ddrstack.page.component.FragmentBorderPage;
import net.dontdrinkandroot.example.ddrstack.page.component.LifecyclePage;
import net.dontdrinkandroot.example.ddrstack.page.component.PageHeightScalingPage;
import net.dontdrinkandroot.example.ddrstack.page.cookie.CookiePage;
import net.dontdrinkandroot.example.ddrstack.page.event.EventPage;
import net.dontdrinkandroot.example.ddrstack.page.form.FormPage;
import net.dontdrinkandroot.example.ddrstack.page.javascript.AbstractJavascriptPage;
import net.dontdrinkandroot.example.ddrstack.page.javascript.CallbackPage;
import net.dontdrinkandroot.example.ddrstack.page.resources.ResourcesPage;
import net.dontdrinkandroot.extension.wicket.bootstrap.headeritem.DontdrinkandrootBootstrap33JsHeaderItem;
import net.dontdrinkandroot.extension.wicket.bootstrap.headeritem.DontdrinkandrootBootstrapCssHeaderItem;
import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.page.StandardBootstrapPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class DecoratorPage<T> extends StandardBootstrapPage<T>
{

	public DecoratorPage(PageParameters parameters)
	{
		super(parameters);
	}

	public DecoratorPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected Component createNavBar(String id)
	{
		Component navBar = super.createNavBar(id);
		navBar.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FIXED_TOP));
		return navBar;
	}

	@Override
	protected void populateNavbarLeftItems(RepeatingView navItemView)
	{
		super.populateNavbarLeftItems(navItemView);
		navItemView.add(new DropDownItem(navItemView.newChildId(), "Bootstrap") {

			@Override
			protected boolean isActive()
			{
				return AbstractBootstrapPage.class.isAssignableFrom(this.getPage().getClass());
			}

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
                                Model.of("Font Awesome Icons"),
                                FontAwesomeIconPage.class));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Icons"), IconPage.class));

			}
		});
		navItemView.add(
				new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Calendar"), CalendarPage.class));
        navItemView.add(new BookmarkablePageLinkItem(
                navItemView.newChildId(),
                Model.of("Resources"),
                ResourcesPage.class
        ));
        navItemView.add(
				new BookmarkablePageLinkItem(
						navItemView.newChildId(),
                        Model.of("Forms"),
						FormPage.class
				));
		navItemView.add(new BookmarkablePageLinkItem(
                navItemView.newChildId(),
                Model.of("JavaScript"),
                CallbackPage.class
        )
        {

			@Override
			protected boolean isActive()
			{
				return AbstractJavascriptPage.class.isAssignableFrom(this.getPage().getClass());
			}
		});
		navItemView.add(new DropDownItem(navItemView.newChildId(), "Components") {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
                                Model.of("PageHeight Scaling"),
                                PageHeightScalingPage.class));
                itemView.add(new BookmarkablePageLinkItem(
                        itemView.newChildId(),
                        Model.of("Lifecycle"),
                        LifecyclePage.class
                ));
                itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Border and Fragment"),
								FragmentBorderPage.class));
			}
		});

        navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Cookies"), CookiePage.class));
        navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Events"), EventPage.class));
    }

	@Override
	protected Component createBrand(String id)
	{
		BookmarkablePageLink<Void> brand = new BookmarkablePageLink<Void>(id, WicketApplication.get().getHomePage());
		brand.setBody(Model.of("dontdrinkandroot"));

		return brand;
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		response.render(new DontdrinkandrootBootstrapCssHeaderItem());
		response.render(new DontdrinkandrootBootstrap33JsHeaderItem(true));
		response.render(CssHeaderItem.forCSS("body {padding-top: 60px}", "bodyPadding"));
	}

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("dontdrinkandroot");
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return new Model<String>(this.getClass().getSimpleName());
	}
}
