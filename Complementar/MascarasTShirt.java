package Complementar;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

	public class MascarasTShirt extends MaskFormatter{
		
		private static final long serialVersionUID = 1L;
		MaskFormatter maskcpf,maskrg,masknas,maskadm,masktel,maskcel;
		
		public MascarasTShirt()  {
			
			try {

				maskcpf = new  MaskFormatter("###.###.###-##");
				maskrg = new  MaskFormatter("##.###.###-#");
				masknas = new  MaskFormatter("##/##/####");
				maskadm = new  MaskFormatter("##/##/####");
				masktel = new  MaskFormatter("(##) ####-####");
				maskcel = new  MaskFormatter("(##) #####-####");

			} catch (Exception e) {
			}
		}
		
		public void Maskcpf() {
			try {
				maskcpf = new  MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
			}
		}
	}

			
			