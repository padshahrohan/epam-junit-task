package com.maventask.epam_junit_task;

public class DeleteAInString {

	public String deleteA(String string) {
		// TODO Auto-generated method stub
		
		char charsOfString[] = string.toCharArray();
		
		int stringLength = charsOfString.length;
		switch(stringLength)
		{
		case 0: 
			break;
		case 1:
			if(charsOfString[0] == 'A')
				charsOfString[0] = ' ';
			break;
		default:
			if(charsOfString[0] == 'A')
				charsOfString[0] = ' ';
			if(charsOfString[0] != 'A' && charsOfString[1] == 'A')
			{
				charsOfString[1] = charsOfString[0];
				charsOfString[0] = ' ';
			}
			break;
	
		}
		return new String(charsOfString).trim();
	}

}
