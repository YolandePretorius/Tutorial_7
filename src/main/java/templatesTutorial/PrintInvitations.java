package templatesTutorial;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintInvitations {

	public static void main(String[] args) {
		
		readFromXMLFile();
		createVelocityfile();
	
	}
	
	
	private static void createVelocityfile() {
		
		
	}

	static void readFromXMLFile() {

		// Read from xmlfile into a list:
		try {
		
		FileInputStream fileInput = new FileInputStream(new File("friends.xml"));
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileInput));

		List<Person> friendsList = (List<Person>) decoder.readObject(); // cast object read from file into person
		decoder.close();
		fileInput.close();
		
		for(Person friend: friendsList) {
			System.out.println(friend);
		}

		} catch (IOException ex) {
		ex.printStackTrace();

	}

}
		
	}


