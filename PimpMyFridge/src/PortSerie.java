import java.util.Enumeration;

import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;

public class PortSerie {
	
	public void numeroPort() {
		
			//System.out.println("Program Started!!! ");
			String tableauCOM[] = new String[6];

			CommPortIdentifier serialPortId;

			Enumeration enumComm;
			JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
			

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
			System.out.println(nom);
			//System.out.println("Program Finished Sucessfully");
		}
}
