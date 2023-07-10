package Classes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CDB {
	
	public static void save() throws IOException {
		String text = "";
		for(CElement e : dataBase.values()) {
			if(e instanceof CBook) {
				text += CBook.writeOnFile((CBook) e);
			}else if(e instanceof CMagazine) {
				text += CMagazine.writeOnFile((CMagazine) e);
			}
		}
	}
	
	public static void load() throws IOException {
	    dataBase.clear();

	    File file = new File(FILE_PATH);
	    String fileString = FileUtils.readFileToString(file, "UTF-8");
	    List<String> splitElementiString = Arrays.asList(fileString.split("#"));

	    for (String curString : splitElementiString) {
	        CElement e = null;
	        if (curString.startsWith(CBook.class.getSimpleName())) {
	            e = CBook.fromStringFile(curString);
	        } else if (curString.startsWith(CMagazine.class.getSimpleName())) {
	            e = CMagazine.fromStringFile(curString);
	        }
	        dataBase.put(e.getIsbn(), e);
	    }
	    
	    log.info("Data From File: " + FILE_PATH);
	}
}
