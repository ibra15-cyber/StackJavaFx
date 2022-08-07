package application;

import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StackController {
	@FXML
	private Button pushBtn, popBtn, peekBtn, emptyBtn, sizeBtn;
	@FXML
	private TextField myTextField;
	@FXML
	private TextArea myTextArea;
	@FXML
	private Label myTextLabel;
	@FXML 
	private String element;
	@FXML
	Stack<String> stack = new Stack<String>();
	
	public void push(ActionEvent ae) {
		//convert the text input value to lower case
		element = myTextField.getText().toLowerCase();
		//if nothing is entered, do nothing
		//else push what was typed to the stack
		if(element.contentEquals("")){
//			System.out.println("do nothing");
		} else {
		stack.push(element);
		//clear the text field after push to be ready for the next input
		myTextField.clear();
//		System.out.println(stack);
		
		//display the content of the stack
		myTextArea.setText(stack+ " "); 
		
		}
	};
	
	public void pop() {
		try {
		
			element = stack.pop(); //catch the pop item
			
			myTextArea.setText(stack + " "); //reset stack
			
			myTextLabel.setText("The popped item is : " + element); //show the element being removed
		
		} catch (java.util.EmptyStackException e) {
			myTextLabel.setText("Pop Error!!! Stack underflow...");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void isempty (){
		if (stack.isEmpty()) {
			myTextLabel.setText("Stack is empty");
		} else {
			myTextLabel.setText("No the stack is not empty");

		}
	}
	
	public void peek() {
		try {
			if (stack.isEmpty()) {
				myTextLabel.setText("Stack underflow, no element in stack");
			}
			else {
				element = stack.peek();
				myTextLabel.setText("The top element is : " + element);
			}
		} catch (java.util.EmptyStackException e) {
			myTextLabel.setText("There's is no element in the stack");
		}
	}
	
	public void size() {
		int size = stack.size();
		myTextLabel.setText("The size of the stack is : " + size);

	}
	
}
