package com.example.vdem;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vdem")
public class VdemUI extends UI {
	String[] texte = {"Do not click me Again", "I said do not click me again", "Next timt I kill you", "Waaar attack!!"};
	int i = 0;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VdemUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Do not Click!");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				event.getButton().setCaption(texte[i]);
				i++;
				if(i==4)
					i=0;
			}
		});
		layout.addComponent(button);
	}

}