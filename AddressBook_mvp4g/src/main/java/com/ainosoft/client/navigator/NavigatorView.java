package com.ainosoft.client.navigator;

import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NavigatorView extends Composite implements INavigatorView{

	private VerticalPanel vPanel ;
	
	Anchor addAddr ;	
	Anchor viewAddr ;
	Label language;
	ListBox languageList;
	
	
	public NavigatorView(){
		language = new Label();		
		languageList = new ListBox();
		
		addAddr = new Anchor();
		viewAddr = new Anchor();
		vPanel = new VerticalPanel();
		
		vPanel.clear();
		initWidget(vPanel);
	}
	
	public void createUI() {
		language.setText("Select Language:");
		language.setStylePrimaryName("anchorStyle");
		vPanel.add(language);
		
		createLanguageList();
		vPanel.add(languageList);
		
		addAddr.setText("Add Address");
		addAddr.setStylePrimaryName("anchorStyle");
		
		vPanel.add(addAddr);
		
		viewAddr.setText("View All Addresses");
		viewAddr.setStylePrimaryName("anchorStyle");
		
		vPanel.add(viewAddr);
		vPanel.setSpacing(11);
	}
	
	private void createLanguageList() {
		languageList.addItem("English");
		languageList.addItem("French");
	}

	public Anchor getAddAddr() {
		return addAddr;
	}

	public void setAddAddr(Anchor addAddr) {
		this.addAddr = addAddr;
	}

	public Anchor getViewAddr() {
		return viewAddr;
	}

	public void setViewAddr(Anchor viewAddr) {
		this.viewAddr = viewAddr;
	}
	
	public ListBox getLanguageList() {
		return languageList;
	}

	public void setLanguageList(ListBox languageList) {
		this.languageList = languageList;
	}

	public void changeLanguage(Dictionary dictionary) {
		addAddr.setText(dictionary.get("addAddress"));
		viewAddr.setText(dictionary.get("viewAddress"));
		language.setText(dictionary.get("selectLanguage"));
	}	
}
