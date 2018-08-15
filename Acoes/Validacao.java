package Acoes;

import java.util.regex.*;

public class Validacao {

	public static boolean email_Validation(String email) {
		boolean status = false;

		String email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9]{2,})$";

		Pattern pattern = Pattern.compile(email_Pattern);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches()) {

			status = true;


		}else {
			status = false;
		}

		return status;

	}
}
