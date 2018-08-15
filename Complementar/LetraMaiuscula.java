package Complementar;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
	
public class LetraMaiuscula extends PlainDocument {

	private static final long serialVersionUID = 1L;

	public void MaiusculoString(int offs, String str, AttributeSet a) throws BadLocationException {
		super.insertString( offs, str.toUpperCase() , a );
	}
}

