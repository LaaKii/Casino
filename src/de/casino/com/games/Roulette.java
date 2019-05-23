package de.casino.com.games;

import java.util.ArrayList;
import java.util.List;

public class Roulette {

	private List<RouletteField> allFields = new ArrayList<>();
	
	
	private void fillAllFields() {
	boolean colorRed = true;
	RouletteField rField = new RouletteField();
	allFields.add(new RouletteField(0, RouletteColor.GREEN));  
	for (int i = 1; i<36; i++) {
			rField.setNumber(i);
			if (colorRed) {
				rField.setRouletteColor(RouletteColor.RED);
				colorRed=false;
			}else {
				rField.setRouletteColor(RouletteColor.BLACK);
				colorRed=true;
			}
			allFields.add(rField);
			rField = new RouletteField();
		}
	}

	public List<RouletteField> getAllFields() {
		return allFields;
	}

	public void setAllFields(List<RouletteField> allFields) {
		this.allFields = allFields;
	}
	
	
	
}
