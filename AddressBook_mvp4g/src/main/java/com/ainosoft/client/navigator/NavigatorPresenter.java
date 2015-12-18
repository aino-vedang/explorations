package com.ainosoft.client.navigator;


import com.ainosoft.client.event.AddressBookEventBus;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = NavigatorView.class)
public class NavigatorPresenter extends BasePresenter<NavigatorView, AddressBookEventBus> implements INavigatorPresenter {

	
	private String language;
	private Dictionary dictionary;
	
	public void bind(){
		view.getAddAddr().addClickHandler(new ClickHandler() {			
			
			public void onClick(ClickEvent event) {
				eventBus.getAddressForm();
			}
		});
		
		view.getViewAddr().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.getListPanel();
			}
		});
		
		view.getLanguageList().addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent arg0) {
				language = view.getLanguageList().getSelectedValue()+"Encoding";
				dictionary = Dictionary.getDictionary(language);				
				eventBus.updateBasePanel(dictionary);
				view.changeLanguage(dictionary);
				eventBus.updateAddressForm(dictionary);
				eventBus.updateListPanel(dictionary);
				eventBus.updateAddressDisplayer(dictionary);
			}
		});
	}
	
	public void onGetNavigator() {
		view.createUI();
		eventBus.setNavigator(view);
	}
	
	
	
}
