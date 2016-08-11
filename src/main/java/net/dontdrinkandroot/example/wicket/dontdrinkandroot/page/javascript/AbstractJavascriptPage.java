package net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.javascript;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.example.wicket.dontdrinkandroot.page.DecoratorPage;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;


public class AbstractJavascriptPage<T> extends DecoratorPage<T>
{

	public AbstractJavascriptPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void populateNavbarRightItems(RepeatingView navItemView)
	{
		super.populateNavbarRightItems(navItemView);
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "Callback", CallbackPage.class));
		navItemView.add(
				new BookmarkablePageLinkItem(navItemView.newChildId(), "ScrollToBottom", ScrollToBottomPage.class));
	}
}
