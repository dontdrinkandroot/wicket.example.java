package net.dontdrinkandroot.example.ddrstack;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import net.dontdrinkandroot.example.ddrstack.component.DateImageResource;
import net.dontdrinkandroot.example.ddrstack.page.component.CalendarPage;
import net.dontdrinkandroot.example.ddrstack.page.resources.ResourcesPage;
import org.apache.wicket.Page;
import org.apache.wicket.request.resource.ResourceReference;
import org.springframework.stereotype.Component;

@Component
public class WicketApplication extends WicketBootStandardWebApplication
{
    public WicketApplication()
    {
        super();
    }

    @Override
    public Class<? extends Page> getHomePage()
    {
        return CalendarPage.class;
    }

    @Override
    protected void init()
    {
        super.init();

        this.getMarkupSettings().setStripWicketTags(true);

        this.getSharedResources().add(DateImageResource.class, "dateImage", null, null, null, new DateImageResource());
        ResourceReference dateImageResource =
                this.getSharedResources().get(DateImageResource.class, "dateImage", null, null, null, true);
        this.mountResource("images/dateImage", dateImageResource);
        this.mountPage("resources", ResourcesPage.class);
    }
}
