package net.dontdrinkandroot.wicketexample.web.component;

import org.apache.wicket.markup.html.border.Border;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;


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
