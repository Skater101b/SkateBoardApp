package com.sk8.skateboardsetup;

import java.lang.reflect.Array;

public class board {

	private int contactID;
	private String boardCo;
	private String modelCo;
	int boardsValue;
	int modelValue;
	private String WheelsCo;
	private String WheelsMO;
	int WheelsVal;
	int WheelsMVal;
	private String TruckCo;
	private String TruckMo;
	int TruckVal;
	int TruckMoVal;
	private String Gripest;
	
	
	
	
	
	public void boardID() {
		contactID = -1;
	}
	public int getboardid() {
		return contactID;
	}
	public void setContactID(int i) {
		contactID = i;
	}
	
	
	
	private String[] boardChosen = { 
		    "Zero", "Baker", "Alien",
		    "Habitat", "Flip"
		};
	
	
    
public void setboardChosen(String boardCompany) {
	//String boards = boardChosen[0];
	
		
		if (boardCompany.equalsIgnoreCase(boardChosen[0])) {
			boardCo = boardChosen[0];
			boardsValue = 0;
		}
	
		if (boardCompany.equalsIgnoreCase(boardChosen[1])) {
			boardCo = boardChosen[1];
			boardsValue = 1;
		}
		if (boardCompany.equalsIgnoreCase(boardChosen[2])) {
			boardCo = boardChosen[2];
			boardsValue = 1;
		}
		if (boardCompany.equalsIgnoreCase(boardChosen[3])) {
			boardCo = boardChosen[3];
			boardsValue = 0;
		}
		if (boardCompany.equalsIgnoreCase(boardChosen[4])) {
			boardCo = boardChosen[4];
			boardsValue = 1;
	}
	}
		


private String[] modelChosen = { 
		"Appleyard", "Arto", "Penny", "sex"
		};
	
public void setModelChosen(String modeltype) {
	
	if (modeltype.equalsIgnoreCase(modelChosen[0])) {
		modelCo = modelChosen[0];
		modelValue = 1;
		
	}
	
	if (modeltype.equalsIgnoreCase(modelChosen[1])) {
		modelCo = modelChosen[1];
		modelValue = 2;
		
	}
	
	if (modeltype.equalsIgnoreCase(modelChosen[2])) {
		modelCo = modelChosen[2];
		modelValue = 3;
		
	}
	if (modeltype.equalsIgnoreCase(modelChosen[3])) {
		modelCo = modelChosen[3];
		modelValue = 4;
		
	}
}

public String getboardName(){
	return boardCo;
}

public String getModelName() {
	return modelCo;
}

public void setBoardName(String bt) {
    boardCo = bt;
}

public void setModelName(String mn) {
	modelCo = mn;
}

public void setwheelscom(String WM) {
	WheelsCo = WM;
}

public String getWheelscom() {
	return WheelsCo;
}

public void setwheelsmod(String WM) {
	WheelsMO = WM;
}

public String getWheelsmod() {
	return WheelsMO;
}

public void setTruckCompany(String TC) {
	TruckCo = TC;
	
}

public void setTruckModel(String TM) {
   TruckMo = TM;
}

public String getTruckCompany() {
	return TruckCo;
}

public String getTruckModel() {
	return TruckMo;
}

public String getGripest() {
	return Gripest;
}

public void setGripest(String GST) {
	Gripest = GST;
	
}



}









//Object matrix = Array.newInstance(int.class, 2);
//Object row0 = Array.newInstance(int.class, 2);

//private String boardChosen2;
//private String wheelsChosen;
//private String bearingChosen;
//private String gripChosen;
//private String truckChosen;
//private String modelChosen;




/**
public void setboardgo(String o) {
	boardgo = o;
}

public void setmodelgo(String t) {
	boardgo = t;
}

public String getboardgo() {
	return boardgo;
}

public String getmodelgo() {
	return modelgo;
}


//int Rubber;
//int wheelValue;
//int bearingValue;
//int truckValue;

**/




/**

public int getboardModel() {
	return modelValue;
}
public String getboardString() {
	//int foo = getboardName();
	//int foo2 = Integer.parseInt("1234");
	String x = String.valueOf(getboardName());
	return x;
}

public String getmodelString(){
	String y = String.valueOf(getboardModel());
	return y;
	**/


	

	
	

		



