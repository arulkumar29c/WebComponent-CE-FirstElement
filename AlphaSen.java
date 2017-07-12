package search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AlphaSen {
	JSONObject h = null;
	JSONObject w = null;
	JSONObject alphaSentence = new JSONObject();

	public AlphaSen() throws JSONException {
		JSONArray letterHArray = new JSONArray();
		h = new JSONObject();
		letterHArray.put("how to build app");
		letterHArray.put("heat the iron");
		letterHArray.put("home for students");
		h.put("low", letterHArray);
		JSONArray letterWArray = new JSONArray();
		w = new JSONObject();
		letterWArray.put("where is ur");
		letterWArray.put("what happen");
		letterWArray.put("when is ur bd");
		w.put("low", letterWArray);

		alphaSentence.put("h", letterHArray);
		alphaSentence.put("w", letterWArray);
	}

	public void run() throws JSONException {
		String txt = "how to ag";
		String[] result = getSentence(txt);
		if (result != null && result[0] != null) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] == null) {
					break;
				}
				System.out.println(result[i]);
			}
		} else {
			run();
		}
	}

	public JSONArray getSentencesArray(String key) throws JSONException {
		JSONArray sentence = null;
		char[] chr = key.toLowerCase().toCharArray();
		if (alphaSentence.has(String.valueOf(chr[0]))) {
			sentence = alphaSentence.getJSONArray(String.valueOf(chr[0]));
		}
		return sentence;
	}

	public void addNewSentence(String newSentence) throws JSONException {
		char[] chr = newSentence.toLowerCase().toCharArray();
		if (alphaSentence.has(String.valueOf(chr[0]))) {
			alphaSentence.getJSONArray(String.valueOf(chr[0])).put(newSentence);

		} else {
			JSONArray addNew = new JSONArray();
			addNew.put(newSentence);
			alphaSentence.put(String.valueOf(chr[0]), addNew);
		}
		System.out.println(alphaSentence.toString());
	}

	public String[] getSentence(String txt) throws JSONException {
		JSONArray sentences = getSentencesArray(txt);
		String[] result = null;
		if (sentences != null) {
			result = new String[10];
			int count = 0;
			for (int i = 0; i < sentences.length(); i++) {
				if (sentences.get(i).toString().toLowerCase().startsWith(txt.toLowerCase())) {
					result[count] = sentences.get(i).toString();
					count++;
				}

				if (count > 9) {
					break;
				}
			}
		} else {
			addNewSentence(txt);
		}

		if (result[0] == null) {
			addNewSentence(txt);
		}

		return result;

	}

	// public String[] getTxt(String txt) throws JSONException {
	// JSONObject v = getJson(txt);
	// String[] result = new String[10];
	// JSONArray top = v.getJSONArray("top");
	// JSONArray low = v.getJSONArray("low");
	// int count = 0;
	// for (int i = 0; i < top.length(); i++) {
	// if (top.get(i).toString().toLowerCase().startsWith(txt.toLowerCase())) {
	// result[count] = top.get(i).toString();
	// count++;
	// }
	//
	// if (count > 9) {
	// break;
	// }
	// }
	//
	// if (count < 9) {
	// for (int i = 0; i < low.length(); i++) {
	// if (low.get(i).toString().toLowerCase().startsWith(txt.toLowerCase())) {
	// result[count] = low.get(i).toString();
	// count++;
	// }
	//
	// if (count > 9) {
	// break;
	// }
	// }
	// }
	//
	// if (result[0] == null) {
	// v.getJSONArray("top").put(txt);
	// }
	//
	// return result;
	//
	// }
	//
	// public JSONObject getJson(String txt) {
	// char[] chr = txt.toLowerCase().toCharArray();
	// if (chr[0] == 'h') {
	// return h;
	// } else {
	// return w;
	// }
	//
	// }

}
