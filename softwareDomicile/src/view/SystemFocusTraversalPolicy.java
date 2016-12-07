package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

public class SystemFocusTraversalPolicy extends FocusTraversalPolicy{

	private ArrayList<Component> order;

	public SystemFocusTraversalPolicy(ArrayList<Component> order)
	{
		this.order = order;
	}

	@Override
	public Component getComponentAfter(Container aContainer, Component aComponent)
	{
		int index = (order.indexOf(aComponent) + 1) % order.size();
		Component after = order.get(index);
		while (index < order.size() && !(after.isEnabled() && after.isVisible()))
		{
			index++;
			after = order.get(index);
		}
		return after;
	}

	@Override
	public Component getComponentBefore(Container aContainer, Component aComponent)
	{
		int index = order.indexOf(aComponent) - 1;
		if (index < 0)
		{
			index = order.size() - 1;
		}
		Component before = order.get(index);
		while (index >= 0 && !(before.isEnabled() && before.isVisible()))
		{
			index--;
			before = order.get(index);
		}
		return before;
	}

	@Override
	public Component getFirstComponent(Container aContainer)
	{
		int index = 0;
		Component first = order.get(index);
		while (index < order.size() && !(first.isEnabled() && first.isVisible()))
		{
			index++;
			first = order.get(index);
		}
		return first;
	}

	@Override
	public Component getLastComponent(Container aContainer)
	{
		int index = order.size() - 1;
		Component last = order.get(index);
		while (index >= 0 && !(last.isEnabled() && last.isVisible()))
		{
			index--;
			last = order.get(index);
		}
		return last;
	}

	@Override
	public Component getDefaultComponent(Container aContainer)
	{
		return getFirstComponent(aContainer);
	}
}