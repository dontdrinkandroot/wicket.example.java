package net.dontdrinkandroot.example.ddrstack.component;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import org.apache.wicket.markup.html.border.Border;


public class ExampleBorder extends Border
{

	public ExampleBorder(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new CssClassAppender("input-group"));
	}

}
