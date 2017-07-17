package gwt.material.starter.client.autoComplete;

import com.google.gwt.user.client.ui.SuggestOracle;

/**
 * <h1>UserSuggestion</h1>
 * <p>
 * The UserSuggestion is a view class<br/>
 * which can use for client <br/>
 * side material seSuggestion view.
 * </p>
 */
public class UserSuggestion implements SuggestOracle.Suggestion {

    private AutoCompleteData data;

    public UserSuggestion(AutoCompleteData data) {
        this.data = data;
    }

    public String getDisplayString() {
        return data.getDisplayValue();
    }

    public String getReplacementString() {
        return null;
    }

    public AutoCompleteData getUser() {
        return data;
    }
}

