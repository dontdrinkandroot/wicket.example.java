package net.dontdrinkandroot.example.ddrstack.wicket.page.component;

import net.dontdrinkandroot.example.ddrstack.entity.ExampleEntity;
import net.dontdrinkandroot.example.ddrstack.entity.ExampleEntity_;
import net.dontdrinkandroot.example.ddrstack.service.ExampleEntityService;
import net.dontdrinkandroot.example.ddrstack.wicket.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.extensions.wicket.bootstrap.table.EntityTable;
import net.dontdrinkandroot.extensions.wicket.bootstrap.table.SingularAttributeColumn;
import net.dontdrinkandroot.extensions.wicket.dataprovider.SortableEntityServiceDataProvider;
import net.dontdrinkandroot.wicket.bootstrap.component.pagination.AjaxBookmarkablePaginationPanel;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DataTablePage extends AbstractBootstrapPage<Void>
{
    @SpringBean
    private ExampleEntityService defaultExampleEntityService;

    public DataTablePage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        List<IColumn<ExampleEntity, SingularAttribute<? super ExampleEntity, ?>>> columns = new ArrayList<>();
        columns.add(new SingularAttributeColumn<>(Model.of("id"), ExampleEntity_.id));
        columns.add(new SingularAttributeColumn<>(Model.of("stringField"), ExampleEntity_.stringField));
        columns.add(new SingularAttributeColumn<>(Model.of("integerField"), ExampleEntity_.integerField));
        columns.add(new SingularAttributeColumn<>(Model.of("dateField"), ExampleEntity_.dateField));

        ISortableDataProvider<ExampleEntity, SingularAttribute<? super ExampleEntity, ?>> dataProvider =
                new SortableEntityServiceDataProvider<>(this.defaultExampleEntityService, ExampleEntity.class);

        EntityTable<ExampleEntity> table = new EntityTable<>("table", columns, dataProvider);
        this.add(table);

        AjaxBookmarkablePaginationPanel paginationPanel = new AjaxBookmarkablePaginationPanel("pagination", table);
        this.add(paginationPanel);
    }
}
