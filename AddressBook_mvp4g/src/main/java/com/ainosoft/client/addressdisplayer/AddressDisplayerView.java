package com.ainosoft.client.addressdisplayer;



import com.ainosoft.shared.AddressSlim;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class AddressDisplayerView extends FlexTable implements IAddressDisplayerView{

	private Label name;
	private Label street;
	private Label city;
	private Label country;
	private Label zip;
	private Button edit;
	private Button delete;
	
	AddressSlim addrSlim;
	

	public AddressSlim getAddrSlim() {
		return addrSlim;
	}

	public void setAddrSlim(AddressSlim addrSlim) {
		this.addrSlim = addrSlim;
	}

	public AddressDisplayerView() {
		name = new Label();	
		street = new Label();	
		city = new Label();	
		country = new Label();	
		zip = new Label();
		
		edit = new Button("Edit Address");
		delete = new Button("Delete Address");
		
	}
	
	public void createUI(AddressSlim addressSlim) {
		addrSlim = addressSlim;
		
		name.setText(addressSlim.getName());
		name.setStylePrimaryName("border");
		setWidget(0, 0, name);
		
		street.setText(addressSlim.getStreet());
		street.setStylePrimaryName("border");
		setWidget(0, 1,street);
		
		city.setText(addressSlim.getCity());
		city.setStylePrimaryName("border");
		setWidget(0, 2,city);
		
		country.setText(addressSlim.getCountry());
		country.setStylePrimaryName("border");
		setWidget(0, 3,country);
		
		zip.setText(addressSlim.getZip());
		zip.setStylePrimaryName("border");
		setWidget(0, 4,zip);
		
		edit.setStylePrimaryName("editDeleteButton");
		setWidget(0, 5,edit);
		
		
		delete.setStylePrimaryName("editDeleteButton");
		setWidget(0, 6,delete);
		
	
	}

	public Button getEdit() {
		return edit;
	}

	public void setEdit(Button edit) {
		this.edit = edit;
	}

	public Button getDelete() {
		return delete;
	}

	public void setDelete(Button delete) {
		this.delete = delete;
	}

	public void displayPopupPanel(String message) {
		PopupPanel popUpPanel = new PopupPanel(true);
		Label dispLabel = new Label(message);
		dispLabel.setStylePrimaryName("dispLabel");
		popUpPanel.setWidget(dispLabel);
		popUpPanel.setAnimationEnabled(true);
		popUpPanel.setPopupPosition((Window.getClientWidth() - getOffsetWidth())/2 + 120 , (Window.getClientHeight() - getOffsetHeight())/2 -100);
		popUpPanel.setStylePrimaryName("popUpPanel");
		popUpPanel.show();
	}

	public void changeLanguage(Dictionary dictionary) {
		edit.setText(dictionary.get("edit"));
		delete.setText(dictionary.get("delete"));
	}

	
}
