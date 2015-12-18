package com.ainosoft.client.addressform;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddressFormView extends Composite implements IAddressFormView {

	private VerticalPanel vPanel;
	
	

	private HorizontalPanel namePanel;
	private HorizontalPanel streetPanel ;
	private HorizontalPanel cityPanel ;
	private HorizontalPanel countryPanel ;
	private HorizontalPanel zipPanel;
	private HorizontalPanel savePanel ;
	
	TextBox nameText;	
	TextBox streetText ;
	TextBox cityText ;
	TextBox countryText ;
	TextBox zipText ;
	
	Label nameLabel;
	Label streetLabel;
	Label cityLabel;
	Label countryLabel;
	Label zipLabel;
	
	Button saveBtn;

	Button updateBtn;
	
	private AddressSlim addressSlim;
	
	

	public AddressFormView() {
		vPanel = new VerticalPanel();
		
		namePanel = new HorizontalPanel();
		streetPanel = new HorizontalPanel();
		cityPanel = new HorizontalPanel();
		countryPanel = new HorizontalPanel();
		zipPanel = new HorizontalPanel();
		savePanel = new HorizontalPanel();
		
		nameText = new TextBox();
		streetText = new TextBox();
		cityText = new TextBox();
		countryText = new TextBox();
		zipText = new TextBox();
		
		nameLabel = new Label("Name :");
		countryLabel = new Label("Country :");
		cityLabel = new Label("City :");
		streetLabel = new Label("Street :");
		zipLabel = new Label("Zip :");
		
		saveBtn = new Button("Save");
		updateBtn = new Button("Update");
		
		
		namePanel.clear();
		streetPanel.clear();
		countryPanel.clear();
		zipPanel.clear();
		cityPanel.clear();
		savePanel.clear();
		vPanel.clear();		
		
		vPanel.setStylePrimaryName("addrForm");
		vPanel.setSpacing(10);
		initWidget(vPanel);
	}
	
	public void createUI() {		
		vPanel.clear();
		
		nameText.setText("");
		streetText.setText("");
		cityText.setText("");
		countryText.setText("");
		zipText.setText("");
		
		nameLabel.setStylePrimaryName("label");
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		namePanel.setStylePrimaryName("labelTextPanel");
		vPanel.add(namePanel);
		vPanel.setCellVerticalAlignment(namePanel, HorizontalPanel.ALIGN_MIDDLE);
		
		streetLabel.setStylePrimaryName("label");
		streetPanel.add(streetLabel);
		streetPanel.add(streetText);
		streetPanel.setStylePrimaryName("labelTextPanel");
		vPanel.add(streetPanel);
		
		cityLabel.setStylePrimaryName("label");
		cityPanel.add(cityLabel);
		cityPanel.add(cityText);
		cityPanel.setStylePrimaryName("labelTextPanel");
		vPanel.add(cityPanel);
		
		countryLabel.setStylePrimaryName("label");
		countryPanel.add(countryLabel);
		countryPanel.add(countryText);
		countryPanel.setStylePrimaryName("labelTextPanel");
		vPanel.add(countryPanel);
		
		zipLabel.setStylePrimaryName("label");
		zipPanel.add(zipLabel);
		zipPanel.add(zipText);
		zipPanel.setStylePrimaryName("labelTextPanel");
		vPanel.add(zipPanel);
		
		saveBtn.setVisible(true);
		updateBtn.setVisible(false);
		
		savePanel.add(saveBtn);
		savePanel.setStylePrimaryName("labelTextPanel");
		saveBtn.setStylePrimaryName("saveButton");
		
		vPanel.add(savePanel);
		vPanel.setCellHorizontalAlignment(namePanel, HorizontalPanel.ALIGN_CENTER);
		
	}
	
	public void populateForm(final AddressSlim addrSlim){
		if(addrSlim.getId() == null){
			createUI();
		}
		else{
			vPanel.clear();
			setAddressSlim(addrSlim);
			
				
			nameText.setText(addrSlim.getName());
			streetText.setText(addrSlim.getStreet());
			cityText.setText(addrSlim.getCity());
			countryText.setText(addrSlim.getCountry());
			zipText.setText(addrSlim.getZip());
			
			nameLabel.setStylePrimaryName("label");
			namePanel.add(nameLabel);
			namePanel.add(nameText);
			namePanel.setStylePrimaryName("labelTextPanel");
			vPanel.add(namePanel);
			vPanel.setCellVerticalAlignment(namePanel, HorizontalPanel.ALIGN_MIDDLE);
			
			streetLabel.setStylePrimaryName("label");
			streetPanel.add(streetLabel);
			streetPanel.add(streetText);
			streetPanel.setStylePrimaryName("labelTextPanel");
			vPanel.add(streetPanel);
			
			cityLabel.setStylePrimaryName("label");
			cityPanel.add(cityLabel);
			cityPanel.add(cityText);
			cityPanel.setStylePrimaryName("labelTextPanel");
			vPanel.add(cityPanel);
			
			countryLabel.setStylePrimaryName("label");
			countryPanel.add(countryLabel);
			countryPanel.add(countryText);
			countryPanel.setStylePrimaryName("labelTextPanel");
			vPanel.add(countryPanel);
			
			zipLabel.setStylePrimaryName("label");
			zipPanel.add(zipLabel);
			zipPanel.add(zipText);
			zipPanel.setStylePrimaryName("labelTextPanel");
			vPanel.add(zipPanel);
			
			saveBtn.setVisible(false);
			updateBtn.setVisible(true);
			
			savePanel.add(updateBtn);
			savePanel.setStylePrimaryName("labelTextPanel");
			updateBtn.setStylePrimaryName("saveButton");
			
			vPanel.add(savePanel);
		}
		
	}
	
	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}
	
	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}
	
	public TextBox getNameText() {
		return nameText;
	}

	public void setNameText(TextBox nameText) {
		this.nameText = nameText;
	}

	public TextBox getStreetText() {
		return streetText;
	}

	public void setStreetText(TextBox streetText) {
		this.streetText = streetText;
	}

	public TextBox getCityText() {
		return cityText;
	}

	public void setCityText(TextBox cityText) {
		this.cityText = cityText;
	}

	public TextBox getCountryText() {
		return countryText;
	}

	public void setCountryText(TextBox countryText) {
		this.countryText = countryText;
	}

	public TextBox getZipText() {
		return zipText;
	}

	public void setZipText(TextBox zipText) {
		this.zipText = zipText;
	}

	public void displayPopupPanel(String message){
		PopupPanel popUpPanel = new PopupPanel(true);
		Label dispLabel = new Label(message);
		dispLabel.setStylePrimaryName("dispLabel");
		popUpPanel.setWidget(dispLabel);
		popUpPanel.setAnimationEnabled(true);
		popUpPanel.setPopupPosition((Window.getClientWidth() - getOffsetWidth())/2 + 120 , (Window.getClientHeight() - getOffsetHeight())/2 -100);
		popUpPanel.setStylePrimaryName("popUpPanel");
		popUpPanel.show();
	}

	public AddressSlim getAddressSlim() {
		return addressSlim;
	}

	public void setAddressSlim(AddressSlim addressSlim) {
		this.addressSlim = addressSlim;
	}
	
	public VerticalPanel getvPanel() {
		return vPanel;
	}

	public void setvPanel(VerticalPanel vPanel) {
		this.vPanel = vPanel;
	}

	public void changeLanguage(Dictionary dictionary) {
		nameLabel.setText(dictionary.get("name"));
		streetLabel.setText(dictionary.get("street"));
		cityLabel.setText(dictionary.get("city"));
		countryLabel.setText(dictionary.get("country"));
		zipLabel.setText(dictionary.get("zip"));
		saveBtn.setText(dictionary.get("save"));
		updateBtn.setText(dictionary.get("update"));
	}
}
