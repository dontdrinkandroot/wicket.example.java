package net.dontdrinkandroot.wicket.test.page;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.test.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.AlertPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.ButtonPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.DropDownPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.FontAwesomeIconPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.FormPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.IconPage;
import net.dontdrinkandroot.wicket.test.page.bootstrap.PanelPage;
import net.dontdrinkandroot.wicket.test.page.component.CalendarPage;
import net.dontdrinkandroot.wicket.test.page.component.FragmentBorderPage;
import net.dontdrinkandroot.wicket.test.page.component.LifecyclePage;
import net.dontdrinkandroot.wicket.test.page.component.PageHeightScalingPage;
import net.dontdrinkandroot.wicket.test.page.cookie.CookiePage;
import net.dontdrinkandroot.wicket.test.page.event.EventPage;
import net.dontdrinkandroot.wicket.test.page.javascript.AbstractJavascriptPage;
import net.dontdrinkandroot.wicket.test.page.javascript.CallbackPage;
import net.dontdrinkandroot.wicket.test.page.resources.ResourcesPage;


public abstract class DecoratorPage<T> extends net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage<T>
{

	private FeedbackPanel feedbackPanel;


	public DecoratorPage(PageParameters parameters)
	{
		super(parameters);
	}

	public DecoratorPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.feedbackPanel = new FencedFeedbackPanel("feedbackPanel");
		this.feedbackPanel.setOutputMarkupId(true);
		this.add(this.feedbackPanel);

		this.add(new Label("pageHeading", this.pageHeadingModel));

		final RepeatingView navItemView = new RepeatingView("navItem");
		this.createNavItems(navItemView);
		this.add(navItemView);

		// BookmarkablePageLink<?> signInLink = new BookmarkablePageLink<Void>("signInLink",
		// SignInPage.class);
		// this.add(signInLink);
		//
		// BookmarkablePageLink<?> signOutLink = new BookmarkablePageLink<Void>("signOutLink",
		// SignOutPage.class);
		// this.add(signOutLink);
		//
		// this.add(new BookmarkablePageLink<T>("buttonsLink", ButtonPage.class));
		// this.add(new BookmarkablePageLink<T>("progressLink", ProgressPage.class));
	}

	private void createNavItems(RepeatingView navItemView)
	{
		navItemView.add(new DropDownItem(navItemView.newChildId(), "Bootstrap") {

			@Override
			protected boolean isActive()
			{
				return AbstractBootstrapPage.class.isAssignableFrom(this.getPage().getClass());
			}

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Buttons", ButtonPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Forms", FormPage.class));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								"Font Awesome Icons",
								FontAwesomeIconPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Icons", IconPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Alerts", AlertPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Drop Downs", DropDownPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Panels", PanelPage.class));

			}
		});
		navItemView.add(
				new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Calendar"), CalendarPage.class));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "Resources", ResourcesPage.class));
		navItemView.add(
				new BookmarkablePageLinkItem(
						navItemView.newChildId(),
						"Forms",
						net.dontdrinkandroot.wicket.test.page.form.FormPage.class));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "JavaScript", CallbackPage.class) {

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
								"PageHeight Scaling",
								PageHeightScalingPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), "Lifecycle", LifecyclePage.class));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Border and Fragment"),
								FragmentBorderPage.class));
			}
		});

		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "Cookies", CookiePage.class));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "Events", EventPage.class));
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);

		response.render(CssHeaderItem.forCSS("body {padding-top: 60px}", "bodyPadding"));
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return new Model<String>(this.getClass().getSimpleName());
	}

	protected FeedbackPanel getFeedbackPanel()
	{
		return this.feedbackPanel;
	}

}