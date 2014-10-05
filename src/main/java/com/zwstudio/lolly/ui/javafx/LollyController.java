package com.zwstudio.lolly.ui.javafx;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.zwstudio.lolly.domain.DictAllId;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.LollyViewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.util.StringConverter;

public class LollyController extends LollyViewModel implements Initializable {
    @FXML
    private Node view;
    @FXML
    private TextField tfWord;
    @FXML
    private WebView wvDictOnline;
    @FXML
    private WebView wvDictOffline;
    @FXML
    private ComboBox<Language> cmbLang;
    @FXML
    private ComboBox<Dictionary> cmbDict;
    
    private ObservableList<Language> langList;
    private ObservableList<Dictionary> dictList = FXCollections.observableArrayList();
    private ObjectProperty<Language> selectedLang = new SimpleObjectProperty<Language>();
    private ObjectProperty<Dictionary> selectedDict = new SimpleObjectProperty<Dictionary>();
    private StringProperty word = new SimpleStringProperty();

    public Node getView() {
        return view;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void windowShowing() {
		tfWord.textProperty().bindBidirectional(word);

		cmbLang.valueProperty().bindBidirectional(selectedLang);
		cmbLang.valueProperty().addListener(new ChangeListener<Language>() {
			@Override
			public void changed(ObservableValue<? extends Language> observable,
					Language oldValue, Language newValue) {
				cmbLangValueChanged();
			}
		});
		cmbLang.setConverter(new StringConverter<Language>() {
            @Override
            public String toString(Language lang) {
            	return lang == null ? null : lang.getLangname();
            }

			@Override
			public Language fromString(String arg0) {
				return null;
			}
		});

		cmbDict.valueProperty().bindBidirectional(selectedDict);
		cmbDict.valueProperty().addListener(new ChangeListener<Dictionary>() {
			@Override
			public void changed(
					ObservableValue<? extends Dictionary> observable,
					Dictionary oldValue, Dictionary newValue) {
				cmbDictValueChanged();
			}
		});
		cmbDict.setConverter(new StringConverter<Dictionary>() {
            @Override
            public String toString(Dictionary dict) {
            	return dict == null ? null : dict.getId().getDictname();
            }

			@Override
			public Dictionary fromString(String arg0) {
				return null;
			}
		});

		dictAllList = dictallDao.getData();
		langList = FXCollections.observableArrayList(langDao.getData());
		selectedLang.set(langList.get(1));
		word.set("Ò»ÈË");
		
		cmbLang.setItems(langList);
		cmbDict.setItems(dictList);
	}
	
	private void cmbLangValueChanged() {
		if (selectedLang.get() == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(selectedLang.get().getLangid()));
		selectedDict.set(dictList.get(0));		
	}
	
	private void cmbDictValueChanged() {
		if (selectedDict.get() == null) return;
		DictionaryId id2 = selectedDict.get().getId();
		dict = dictAllList.stream()
			.filter(r -> {
				DictAllId id1 = r.getId();
				return id1.getLangid() == id2.getLangid() &&
						id1.getDictname().equals(id2.getDictname());
			})
			.findFirst().get();
	}
	
    @FXML
    public void btnSearchOnAction(ActionEvent event) {
    	wvDictOffline.setVisible(false);
		String url = dict.getUrl().replace("{0}", "%s");
		try {
			url = String.format(url, URLEncoder.encode(word.get(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(url);
    	wvDictOnline.getEngine().load(url);
    }

}
