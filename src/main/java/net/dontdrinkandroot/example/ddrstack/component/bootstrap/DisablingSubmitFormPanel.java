package net.dontdrinkandroot.example.ddrstack.component.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.button.DisablingSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;

public class DisablingSubmitFormPanel extends GenericPanel<Void>
{
    public DisablingSubmitFormPanel(String id)
    {
        super(id);

        Form<Void> disablingSubmitForm = new Form<>("disablingSubmitForm");
        disablingSubmitForm.setOutputMarkupId(true);
        this.add(disablingSubmitForm);

        DisablingSubmitButton submitLink = new DisablingSubmitButton("submitLink")
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        submitLink.getButtonBehavior().setButtonStyle(ButtonStyle.PRIMARY);
        disablingSubmitForm.add(submitLink);
    }
}
