package net.dontdrinkandroot.example.ddrstack.wicket.page.javascript;

import net.dontdrinkandroot.example.ddrstack.wicket.page.DecoratorPage;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AbstractJavascriptPage<T> extends DecoratorPage<T>
{
    public AbstractJavascriptPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void populateNavbarRightItems(RepeatingView navItemView)
    {
        navItemView.add(new BookmarkablePageLinkItem(
                navItemView.newChildId(),
                Model.of("Callback"),
                CallbackPage.class
        ));
        navItemView.add(
                new BookmarkablePageLinkItem(
                        navItemView.newChildId(),
                        Model.of("ScrollToBottom"),
                        ScrollToBottomPage.class
                ));
    }
}
