package uniandes.lym.robot.view;
import javax.swing.*;




public class Images {
		
	static private final ImageIcon iconFiles [] = new ImageIcon[21]; 
	
	static private final String fileNames[] = {
			"0000.gif", //0
			"f000.gif", //1
			"0g00.gif", //2
			"fg00.gif", //3		
			"00rn.gif", //4
			"f0rn.gif", //5
			"0grn.gif", //6
			"fgrn.gif", //7
			"00re.gif", //8
			"f0re.gif", //9
			"0gre.gif", //10
			"fgre.gif", //11
			"00rs.gif", //12
			"f0rs.gif", //13
			"0grs.gif", //14
			"fgrs.gif", //15			
			"00ro.gif", //16
			"f0ro.gif", //17
			"0gro.gif", //18
			"fgro.gif", //19
			"1111.gif"  //20
	 };

 
 static public void inicializar(Object o)
 {		
	int i;
	
	try {
		for (i=0; i < 20; i++){
			iconFiles[i] =new ImageIcon(o.getClass().getResource("/imagenes/"+ fileNames[i]));
		}
	}
	catch (Exception fromEclipse) {
		for (i=0; i < 20; i++){
			iconFiles[i] = new ImageIcon("imagenes" + java.io.File.separator + fileNames[i]);
		}
	}
 } 
 
 public static ImageIcon get(int i)
 { 
		return iconFiles[i];
 }
 
 
}
	
		
	
