package gwt.material.starter.client.autoComplete;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;

/**
 * <h1>AutoCompleteView</h1>
 * <p>
 * The AutoCompleteView is a view class<br/>
 * which can use for client <br/>
 * side auto-complete view using Material design.
 * </p>
 */
public class AutoCompleteView extends Composite {
    private static AutoCompleteViewUiBinder uiBinder = GWT.create(AutoCompleteViewUiBinder.class);

    @UiTemplate("AutoCompleteView.ui.xml")
    interface AutoCompleteViewUiBinder extends UiBinder<Widget, AutoCompleteView> {
    }

    @UiField
    MaterialAutoComplete acList;
    private UserOracle oracle;
    private List<AutoCompleteData> data;

    public AutoCompleteView() {
        data = new ArrayList<AutoCompleteData>();
        data.add(new AutoCompleteData("Arulkumar"));
        data.add(new AutoCompleteData("Kumar"));
        data.add(new AutoCompleteData("Divya"));
        data.add(new AutoCompleteData("Arul"));
        data.add(new AutoCompleteData("AK"));
        
        initWidget(uiBinder.createAndBindUi(this));
        acList.setLimit(1);
    }

    public AutoCompleteView(List<AutoCompleteData> data,String label) {
        this.data = data;
        initWidget(uiBinder.createAndBindUi(this));
        acList.setPlaceholder(label);
        acList.setLimit(1);
    }

    @Override
    protected void onLoad() {
        super.onLoad();
        oracle = new UserOracle();

        if (data != null) {
            oracle.addUsers(data);
        }
        acList.setSuggestions(oracle);
    }
    
    


    public MaterialAutoComplete getAcList() {
        return acList;
    }

    public UserOracle getOracle() {
        return oracle;
    }

}

