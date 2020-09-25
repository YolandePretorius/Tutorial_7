package templatesTutorial;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class PrintInvitations {

	public static void main(String[] args) throws Exception {
		//List<Person> friendsList = new ArrayList<Person>();
		List<Person> list = readFromXMLFileFunction();
		
		createVelocityfile(list);
		createHTML(list);

	}

	private static void createHTML(List<Person> list) throws IOException {
		
			VelocityContext context = new VelocityContext();
			
			context.put("friendList",list);
			
			Template template = Velocity.getTemplate("letterHTML.vm");
			FileWriter out = new FileWriter("invitations.html");		
			
			template.merge(context, out);
			
			out.close();
		
	}

	private static void createVelocityfile(List<Person>list) throws IOException {
		
				VelocityContext context = new VelocityContext();
		
				context.put("friendList",list);
				
				Template template = Velocity.getTemplate("letter.vm");
				
				FileWriter out = new FileWriter("invitations.txt");
				
				template.merge(context, out);
				
				out.close();
		 
	}

	static  List<Person> readFromXMLFileFunction() {

		// Read from xmlfile into a list:
		try {

			FileInputStream fileInput = new FileInputStream(new File("friends.xml"));
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fileInput));

			List<Person> friendsList =  (List<Person>) decoder.readObject(); // cast object read from file into person
			decoder.close();
			fileInput.close();
			return friendsList;

		} catch (IOException ex) {
			ex.printStackTrace();

		}
		return null;

	}

}
