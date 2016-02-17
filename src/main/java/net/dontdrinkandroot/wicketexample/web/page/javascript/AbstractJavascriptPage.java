package net.dontdrinkandroot.wicketexample.web.page.javascript;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorSidebarPage;


public class AbstractJavascriptPage<T> extends DecoratorSidebarPage<T>
{

	public AbstractJavascriptPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected void createNavItems(RepeatingView navItemView)
	{
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), CallbackPage.class, "Callback"));
		navItemView.add(
				new BookmarkablePageLinkItem(navItemView.newChildId(), ScrollToBottomPage.class, "ScrollToBottom"));
	}

}
