package templatesTutorial;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintInvitations {

	public static void main(String[] args) {
		
		List<Person> friendsList = new ArrayList<Person>();
	
		// Read from xmlfile into a list:
		try {
			FileInputStream fileInput = new FileInputStream(new File("friends.xml"));
			XMLDecoder decoder = new XMLDecoder(fileInput);
			
			Person friend = (Person)decoder.readObject(); // cast object read from file into person
			
			decoder.close();
			fileInput.close();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			
		}
	}

}
