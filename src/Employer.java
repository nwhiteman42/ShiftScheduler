import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/*
 * @author: Dalton Aird
 * 
 * Class  that serves as the "Admin" class, or the boss of the employees. Can control shifts, 
 * manage employees and delete users. 
 */
public class Employer extends Employee {
	private ArrayList<Employee> employees = new ArrayList<>();
	
	
	/*
	 * Adds new employee to the list; returns true if it worked, false if it failed
	 *TODO: add a sorting function to help with finding employees
	 * @param: e - employee to add
	 * 
	 * @return: if the addition succeeded
	 */
	@SuppressWarnings("unused")
	public boolean addEmployee( Employee e ) {
		int len1 = employees.size();
		employees.add(e);
		int len2 = employees.size();
		if ( len1 >= len2 ) {
			return false;
		}
		mergeSort();
		return true;
	}

	/* Sets the seniority of a given Employee
	 * 
	 * @param seniority, integer representing seniority, the higher the value the greater the seniority
	 * @param e, and employee who's seniority will be set
	 */
	public void setSeniority(int seniority, Employee e) {
		e.setSeniority(seniority);
	}
	
	/*
	 * Removes an employee from the list; returns true if it worked, false if it failed
	 * 
	 * @param: e - employee to remove
	 * 
	 * @return: if the removal worked
	 */
	@SuppressWarnings("unused")
	public boolean removeEmployee( Employee e ) {
		int len1 = employees.size();
		employees.remove( e );
		int len2 = employees.size();
		if ( len1 <= len2 ) {
			return false;
		}
		return true;
	}
	
	/*
	 * Searches for an employee in the list using their name
	 * 
	 * @param: name - the employee's name you try to find
	 * 
	 * @return: the Employee object attached to that name
	 */
	@SuppressWarnings("unused")
	public Employee getEmployee( String name ) {
		Employee find = new Employee();
		for ( Employee e : employees ) {
			if ( e.getName().equals(name) ) {
				find = e;
				break;
			}
		}
		return find;
	}
	/*
	 * Merges 2 arrays to main array
	 * 
	 * @param: array - array to be sorted into
	 * 
	 * @param: temp1 - left side of array
	 * 
	 * @param: temp2 - right side of array
	 */
	public void merge(Employee array[], Employee temp1[], Employee temp2[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < temp1.length && j < temp2.length) {
			if (temp1[i].getSeniority() < temp2[j].getSeniority()) {
				array[k] = temp1[i];
				i++;
				k++;
			} else {
				array[k] = temp2[j];
				j++;
				k++;
			}
		}
		while (i < temp1.length) {
			array[k] = temp1[i];
			i++;
			k++;
		}
		while (j < temp2.length) {
			array[k] = temp2[j];
			j++;
			k++;
		}
	}
	/*
	 * Sort Method based on Merge Sort
	 * 
	 * @param: array - array to be sorted
	 */
	public void sort(Employee[] array) {
		Employee[] array1;
		Employee[] array2;
		
		if( array.length == 1) { return; }
		
		int mid = array.length / 2;
		
		array1 = Arrays.copyOfRange( array, 0, mid);
		
		array2 = Arrays.copyOfRange( array, mid, array.length);
		
		sort(array1);
		sort(array2);
		merge(array, array1, array2);
	}
	/*
	 * Caller Method for Sort - Convert employee list to array and back
	 */
	public void mergeSort() {
		Object temp[] = employees.toArray();
		Employee arr[] = new Employee[temp.length];
		System.arraycopy(temp, 0, arr, 0, temp.length);
		sort(arr);
		List<Employee> list = Arrays.asList(arr);
		this.employees = new ArrayList<>(list);
	}

	/*This method will send a mass email out to all emails contained in an array.
	 * @param attachment, a file to attach
	 * @param subject, what will be in the subject line of the email
	 * @param body, text that will be in the body of the email 
	 * @return, the number of email that were sent out
	 */
	public int massEmail(String[] emails, String attachment, String subject, String body) throws InterruptedException {
		
		//setup
		String from = "possiblefortsp";
		String password = "343Guiltyspark";
		int count = 0; //Counter for number of emails sent out
		
		//set properties this set of properties uses gmail as a host to send the emails from
		Properties p = System.getProperties();
		String host = "smtp.gmail.com";
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.password", password);
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.auth","true");
		
		Session s = Session.getDefaultInstance(p); //Create session
		
		try {
			//If there is an attachment send emails with attachment if not send with just body text
			if(attachment != null) {
			MimeBodyPart mBP = new MimeBodyPart(); //Message body part
			//attach file to email
			String file = attachment;
			DataSource source = new FileDataSource(file);
			mBP.setDataHandler(new DataHandler(source));
			mBP.setFileName(file);
		
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mBP);
			//Email message and details
			MimeMessage m = new MimeMessage(s);
			m.setFrom(new InternetAddress(from));
			m.setSubject(subject);
			m.setText(body);
			m.setContent(multipart);
			
			Transport t = s.getTransport("smtp");
			t.connect(host, from, password);
			
			for(int i = 0; i < emails.length; i++) {
			Thread.sleep(5000);
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(emails[i]));
			t.sendMessage(m, m.getAllRecipients());
			System.out.println("Message sent");
			count++;
				}
			t.close();
			}
			else {
			MimeMessage m = new MimeMessage(s);
			m.setFrom(new InternetAddress(from));
			m.setSubject(subject);
			m.setText(body);
	
			Transport t = s.getTransport("smtp");
			t.connect(host, from, password);
			
			for(int i = 0; i < emails.length; i++) {
			Thread.sleep(5000);
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(emails[i]));
			t.sendMessage(m, m.getAllRecipients());
			System.out.println("Message sent");
			count++;
				}
			t.close();
			}
			
		} catch (MessagingException x) {
			x.printStackTrace();
		}
		return count;
	}	
}
