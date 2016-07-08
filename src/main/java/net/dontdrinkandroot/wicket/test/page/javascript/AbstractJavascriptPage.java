package net.dontdrinkandroot.wicket.test.page.javascript;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.test.page.DecoratorSidebarPage;


public class AbstractJavascriptPage<T> extends DecoratorSidebarPage<T>
{

	public AbstractJavascriptPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void createNavItems(RepeatingView navItemView)
	{
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), "Callback", CallbackPage.class));
		navItemView.add(
				new BookmarkablePageLinkItem(navItemView.newChildId(), "ScrollToBottom", ScrollToBottomPage.class));
	}

}
