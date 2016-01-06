package com.ainosoft.client.listpanel;





import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;


public class ListPanelView extends Composite implements IListPanelView {

	private FlexTable table = null;
	private Label name;
	private Label street;
	private Label city;
	private Label country;
	private Label zip;
	private Label action;
	private FlexTable headerFlex;
	
	
	
	public ListPanelView() {
		table = new FlexTable();
		headerFlex = new FlexTable();
		name = new Label("Name");
		street = new Label("Street");
		city = new Label("City");
		country = new Label("Country");
		zip = new Label("Zip");
		action = new Label("Action");
	
		table.clear();
		initWidget(table);
		
	}
	
	
	public void populateFlex() {
		name.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 0, name);
		
		street.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 1,street);
		
		city.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 2,city);
		
		country.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 3,country);
		
		zip.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 4,zip);
		
		action.setStylePrimaryName("actionTitle");
		headerFlex.setWidget(0, 5,action);
		
		table.setWidget(0, 0, headerFlex);
		
	}

	


	public FlexTable getTable() {
		return table;
	}


	public void setTable(FlexTable table) {
		this.table = table;
	}


	public void displayPopupPanel(String msg) {
		PopupPanel popUpPanel = new PopupPanel(true);
		Label dispLabel = new Label(msg);
		dispLabel.setStylePrimaryName("dispLabel");
		popUpPanel.setWidget(dispLabel);
		popUpPanel.setAnimationEnabled(true);
		popUpPanel.setPopupPosition((Window.getClientWidth() - getOffsetWidth())/2 + 50 , (Window.getClientHeight() - getOffsetHeight())/2 -100);
		popUpPanel.setStylePrimaryName("popUpPanel");
		popUpPanel.show();
	}


	public void addDisplayer(IsWidget aDisplayer, int rowIndex) {
		try{
			table.setWidget(rowIndex, 0, aDisplayer);
			
		}
		catch(Exception e){
			throw e;
		}
		
	}


	
	public void refreshFlexTable() {
		table.clear();
	}


	public void changeLanguage(Dictionary dictionary) {
		name.setText(dictionary.get("name"));
		street.setText(dictionary.get("street"));
		city.setText(dictionary.get("city"));
		country.setText(dictionary.get("country"));
		zip.setText(dictionary.get("zip"));
		action.setText(dictionary.get("action"));
	}
}
