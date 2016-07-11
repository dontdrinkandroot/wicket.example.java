package net.dontdrinkandroot.wicket.test.page.bootstrap;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.HeaderItem;


public class DropDownPage extends AbstractBootstrapPage<Void>
{

	public DropDownPage(PageParameters parameters)
	{

		super(parameters);
	}

	@Override
	protected void onInitialize()
	{

		super.onInitialize();

		DropDownMenu allItemsMenu = new DropDownMenu("allItemsMenu") {

			@Override
			protected void populateItems(RepeatingView itemView)
			{

				itemView.add(new HeaderItem(itemView.newChildId(), Model.of("Header")));
				itemView.add(
						new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Link Item"), DropDownPage.class));
				itemView.add(new DividerItem(itemView.newChildId()));
			}
		};
		this.add(allItemsMenu);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{

		return new Model<String>("DropDown Demo");
	}

}
