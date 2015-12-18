package com.ainosoft.client.base;

import com.ainosoft.localization.AddressBookConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddressBookBaseView extends Composite implements IAddressBookBaseView {

	private VerticalPanel basePanel ;
	private HorizontalPanel headerPanel ;
	private HorizontalPanel middlePanel ;
	private HorizontalPanel footerPanel ;
	private HorizontalPanel navigationPanel;
	private HorizontalPanel saveOrDisplayPanel;
	
	private Label header;
	private Label footer;
	
	public AddressBookBaseView() {
		basePanel = new VerticalPanel();
		headerPanel = new HorizontalPanel();
		middlePanel = new HorizontalPanel();
		footerPanel = new HorizontalPanel();
		
		navigationPanel =new HorizontalPanel();
		saveOrDisplayPanel = new HorizontalPanel();
		
		header = new Label();
		footer = new Label();
		
		basePanel.clear();
		headerPanel.clear();
		middlePanel.clear();
		footerPanel.clear();
	}
	
	public void createUI() {	
		
		header.setText("ADDRESS BOOK APPLICATION");
		header.setStylePrimaryName("title");		
		headerPanel.add(header);
		headerPanel.setStylePrimaryName("header");
		headerPanel.setCellHorizontalAlignment(header, HorizontalPanel.ALIGN_CENTER);
		
		navigationPanel.setStylePrimaryName("navigationPanel");	
		middlePanel.add(navigationPanel);
		
		saveOrDisplayPanel.setStylePrimaryName("saveOrDisplay");
		middlePanel.add(saveOrDisplayPanel);		
		middlePanel.setStylePrimaryName("middlePanel");	
		
		int	height = Window.getClientHeight();
		height = height-200;
		
		middlePanel.setHeight(height+"px");		
		
		footer.setText("Powered by: Aino Softwares Pvt. Ltd.");
		footer.setStylePrimaryName("footer_text");
		footerPanel.add(footer);		
		footerPanel.setStylePrimaryName("footerPanel");
		footerPanel.setCellHorizontalAlignment(footer, HorizontalPanel.ALIGN_RIGHT);
		
		basePanel.add(headerPanel);
		basePanel.add(middlePanel);
		basePanel.add(footerPanel);
		
		basePanel.setStylePrimaryName("center_basePanel");
		initWidget(basePanel);
	}
	
	public HorizontalPanel getSaveOrDisplayPanel() {
		return saveOrDisplayPanel;
	}

	public void setSaveOrDisplayPanel(HorizontalPanel saveOrDisplayPanel) {
		this.saveOrDisplayPanel = saveOrDisplayPanel;
	}

	public HorizontalPanel getNavigationPanel() {
		return navigationPanel;
	}

	public void setNavigationPanel(HorizontalPanel navigationPanel) {
		this.navigationPanel = navigationPanel;
	}

	@Override
	public void setBody(IsWidget body) {
		
	}

	public void addNavigator(IsWidget navigator) {
		getNavigationPanel().clear();
		getNavigationPanel().add(navigator);
		
	}

	public void addAddressForm(IsWidget addrForm) {
		getSaveOrDisplayPanel().clear();
		getSaveOrDisplayPanel().add(addrForm);
	}

	public void addListPanel(IsWidget listPanel) {
		getSaveOrDisplayPanel().clear();
		getSaveOrDisplayPanel().add(listPanel);
	}

	public void changeLanguage(Dictionary dictionary) {
		header.setText(dictionary.get("header"));
		footer.setText(dictionary.get("poweredBy")+": Aino Softwares Pvt. Ltd.");
	}
	
	
}
