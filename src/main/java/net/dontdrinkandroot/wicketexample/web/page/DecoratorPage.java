package net.dontdrinkandroot.wicketexample.web.page;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.CloseableFencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.ButtonPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.DropDownPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.FeedbackPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.FormPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.IconPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.LabelBadgePage;
import net.dontdrinkandroot.wicketexample.web.page.component.PageHeightScalingPage;
import net.dontdrinkandroot.wicketexample.web.page.cookie.CookiePage;
import net.dontdrinkandroot.wicketexample.web.page.event.EventPage;
import net.dontdrinkandroot.wicketexample.web.page.javascript.AbstractJavascriptPage;
import net.dontdrinkandroot.wicketexample.web.page.javascript.CallbackPage;
import net.dontdrinkandroot.wicketexample.web.page.resources.ResourcesPage;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class DecoratorPage<T> extends net.dontdrinkandroot.wicket.bootstrap.page.AbstractBootstrapPage<T> {

	private FeedbackPanel feedbackPanel;


	public DecoratorPage(PageParameters parameters) {

		super(parameters);
	}


	public DecoratorPage(IModel<T> model) {

		super(model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.feedbackPanel = new CloseableFencedFeedbackPanel("feedbackPanel");
		this.feedbackPanel.setOutputMarkupId(true);
		this.add(this.feedbackPanel);

		this.add(new Label("pageHeading", this.getPageHeadingModel()));

		RepeatingView navItemView = new RepeatingView("navItem");
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


	private void createNavItems(RepeatingView navItemView) {

		navItemView.add(new DropDownItem(navItemView.newChildId(), "Bootstrap") {

			@Override
			protected boolean isActive() {

				return AbstractBootstrapPage.class.isAssignableFrom(this.getPage().getClass());
			}


			@Override
			protected void createDropDownItems(RepeatingView itemView) {

				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), ButtonPage.class, "Buttons"));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), FormPage.class, "Forms"));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), IconPage.class, "Icons"));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), FeedbackPage.class, "Feedback"));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), DropDownPage.class, "Drop Down"));
				itemView.add(new BookmarkablePageLinkItem(
						itemView.newChildId(),
						LabelBadgePage.class,
						"Labels & Badges"));

			}
		});
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), ResourcesPage.class, "Resources"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), CallbackPage.class, "JavaScript") {

			@Override
			protected boolean isActive() {

				return AbstractJavascriptPage.class.isAssignableFrom(this.getPage().getClass());
			}
		});
		navItemView.add(new DropDownItem(navItemView.newChildId(), "Components") {

			@Override
			protected void createDropDownItems(RepeatingView itemView) {

				itemView.add(new BookmarkablePageLinkItem(
						itemView.newChildId(),
						PageHeightScalingPage.class,
						"PageHeight Scaling"));
			}
		});

		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), CookiePage.class, "Cookies"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), EventPage.class, "Events"));
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(CssHeaderItem.forCSS("body {padding-top: 60px}", "bodyPadding"));
	}


	protected IModel<String> getPageHeadingModel() {

		return this.getPageTitleModel();
	}


	protected FeedbackPanel getFeedbackPanel() {

		return this.feedbackPanel;
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>(this.getClass().getSimpleName());
	}

}
