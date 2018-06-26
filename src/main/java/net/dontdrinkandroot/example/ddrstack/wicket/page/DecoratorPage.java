package net.dontdrinkandroot.example.ddrstack.wicket.page;

import net.dontdrinkandroot.example.ddrstack.WicketApplication;
import net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap.FontAwesomeIconPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap.IconPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.component.*;
import net.dontdrinkandroot.example.ddrstack.wicket.page.cookie.CookiePage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.event.EventPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.form.FormPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.javascript.AbstractJavascriptPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.javascript.CallbackPage;
import net.dontdrinkandroot.example.ddrstack.wicket.page.resources.ResourcesPage;
import net.dontdrinkandroot.extensions.wicket.bootstrap.headeritem.DontdrinkandrootBootstrap33JsHeaderItem;
import net.dontdrinkandroot.extensions.wicket.bootstrap.headeritem.DontdrinkandrootBootstrapCssHeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition;
import net.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage;
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
    protected Component createNavbar(String id)
    {
        Navbar navBar = new Navbar(id)
        {
            @Override
            protected Component createBrand(String id)
            {
                return DecoratorPage.this.createBrand(id);
            }

            @Override
            protected void populateCollapseItems(RepeatingView collapseItemView)
            {
                RepeatingNavbarNav navbarLeft = new RepeatingNavbarNav(collapseItemView.newChildId())
                {
                    @Override
                    protected void populateItems(RepeatingView itemView)
                    {
                        DecoratorPage.this.populateNavbarLeftItems(itemView);
                    }
                };
                collapseItemView.add(navbarLeft);

                RepeatingNavbarNav navbarRight = new RepeatingNavbarNav(collapseItemView.newChildId())
                {
                    @Override
                    protected void populateItems(RepeatingView itemView)
                    {
                        DecoratorPage.this.populateNavbarRightItems(itemView);
                    }
                };
                collapseItemView.add(navbarRight);
            }
        };
        navBar.setPosition(NavbarPosition.FIXED_TOP);
        return navBar;
    }

    protected void populateNavbarLeftItems(RepeatingView navItemView)
    {
        navItemView.add(new RepeatingDropdownItem<Void>(navItemView.newChildId(), Model.of("Bootstrap"))
        {
            @Override
            protected boolean isActive()
            {
                return AbstractBootstrapPage.class.isAssignableFrom(this.getPage().getClass());
            }

            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        Model.of("Font Awesome Icons"),
                        FontAwesomeIconPage.class
                ));
                itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Icons"), IconPage.class));
            }
        });
        navItemView.add(new BookmarkablePageLinkItem<Void>(
                navItemView.newChildId(),
                Model.of("Calendar"),
                CalendarPage.class
        ));
        navItemView.add(new BookmarkablePageLinkItem<Void>(
                navItemView.newChildId(),
                Model.of("Resources"),
                ResourcesPage.class
        ));
        navItemView.add(new BookmarkablePageLinkItem<Void>(
                navItemView.newChildId(),
                Model.of("Forms"),
                FormPage.class
        ));
        navItemView.add(new BookmarkablePageLinkItem<Void>(
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
        navItemView.add(new RepeatingDropdownItem<Void>(navItemView.newChildId(), Model.of("Components"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                itemView.add(new BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        Model.of("PageHeight Scaling"),
                        PageHeightScalingPage.class
                ));
                itemView.add(new BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        Model.of("Lifecycle"),
                        LifecyclePage.class
                ));
                itemView.add(new BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        Model.of("Border and Fragment"),
                        FragmentBorderPage.class
                ));
                itemView.add(new BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        Model.of("Data Table"),
                        DataTablePage.class
                ));
            }
        });

        navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Cookies"), CookiePage.class));
        navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), Model.of("Events"), EventPage.class));
    }

    protected void populateNavbarRightItems(RepeatingView navItemView)
    {
        /* Hook */
    }

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
