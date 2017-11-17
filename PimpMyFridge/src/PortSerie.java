import java.util.Enumeration;

import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;

public class PortSerie {
	
	public String numeroPort() {
		
			String tableauCOM[] = new String[6];

			CommPortIdentifier serialPortId;

			Enumeration enumComm;

			enumComm = CommPortIdentifier.getPortIdentifiers();
			int i=0;
			while(enumComm.hasMoreElements())
			{
				serialPortId = (CommPortIdentifier)enumComm.nextElement();
				if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				{
					System.out.println(serialPortId.getName());
					tableauCOM[i]= serialPortId.getName();
					i++;
				
				}
			}
			
			if(tableauCOM[1] != null){
				return choisirPort(tableauCOM);
			}
			else {
				return tableauCOM[0];
			}

		}
		
	public String choisirPort(String[] tableauCOM) {
		
		JOptionPane jop = new JOptionPane();
		String nom = "";
		if(tableauCOM[1] != null){

			nom = (String)jop.showInputDialog(null, 
	      "Veuillez choisir le port série de l'arduino!",
	      "ARDUINO !",
	      JOptionPane.QUESTION_MESSAGE,
	      null,
	      tableauCOM,
	      tableauCOM[2]);
		
		}
		return nom;
	}
}	
