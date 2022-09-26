package VShoppe;

public class DataBaseTable {
	  protected int ValidateString(String dataField, int fieldLength){
		if (dataField.length()>=fieldLength )return -1;
		for (int j=0;j<dataField.length();j++) {
			if ( ! ((dataField.charAt(j)>=48 && dataField.charAt(j)<=59)|| 
			(dataField.charAt(j)>=65 && dataField.charAt(j)<=90)||
			(dataField.charAt(j)>=97 && dataField.charAt(j)<=122))||
					 (dataField.charAt(j)=='-')||
					 (dataField.charAt(j)=='@')||
					 (dataField.charAt(j)=='.')) {// Not a letter or part of a phone number or Email address give extra attention
				if (dataField.charAt(j)=='\"') return -1;// Double Quote
				if (dataField.charAt(j)=='('||dataField.charAt(j)==')') return -1;
				if (dataField.charAt(j)=='\'') return -1;
			}
		}
		return 0;
				
	}
	 protected int ValidateDate(String date) {
		return -1;
	}
}
