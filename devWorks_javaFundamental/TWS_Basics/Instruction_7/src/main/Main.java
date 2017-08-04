package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

	public static void main(String[] args) {
		String data = "helloworld";
		String dirPath = "C:\\Users\\kkhk7\\Desktop\\stash\\devBase\\devWorks_javaFundamental\\TWS_Basics\\Instruction_7\\testFileFolder";
		String fileName = "test.txt";
		int num = 0;

		// ------------------------------------------------------------
		// file Making Process.
		// ------------------------------------------------------------
		try {
			String fullPath = makeNewPath(dirPath, fileName, num);
			FileOutputStream output = new FileOutputStream(fullPath);

			output.write(data.getBytes());
			output.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// ------------------------------------------------------------
		// file reading process if there's the file exists.
		// ------------------------------------------------------------
		try {
			File dir = new File(dirPath);
			File path = new File(fullPathGenerator(dirPath, fileName));

			// Directory Checking Process
			if (dirChecker(dir) == true) {
				System.out.println("DIR OK");
			} else {
				System.out.println("DIR NG");
			}

			byte[] databuffer = new byte[(int) path.length()];
			FileInputStream output = new FileInputStream(path);
			output.read(databuffer);
			output.close();
			System.out.println(new String(databuffer));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// Directory Checking Method.
	public static boolean dirChecker(File _dir) {
		boolean isDirOK = true;
		isDirOK = _dir.isDirectory();
		return isDirOK;
	}

	// A method for making the new path of file.
	private static String makeNewPath(String _dirPath, String _fileName, int _num) {
		String result = null;
		System.out.println("_fileName : " + _fileName);
		if (isOverlayed(fullPathGenerator(_dirPath, _fileName)) == true) {
			_num++;
			_fileName = fileRenamer(_num);
			return makeNewPath(_dirPath, _fileName, _num);
		} else {
			result = fullPathGenerator(_dirPath, _fileName);
			System.out.println("result : " + result);
			return result;
		}
	}

	// Check File overlay
	private static boolean isOverlayed(String _fullPath) {
		boolean result = false;
		
		System.out.println("<>===== isOverlayed =====<>");
		
		File checkingFileName = new File(_fullPath);
		System.out.println("checkingFileName : " + checkingFileName);
		result = checkingFileName.exists();
		System.out.println("result : " + result);
		
		System.out.println("><===== isOverlayed =====><");
		
		return result;
	}

	// fullPathGenerator
	private static String fullPathGenerator(String _dirPath, String _fileName) {
		String fullPath = null;
		fullPath = _dirPath + "\\" + _fileName;
		return fullPath;
	}

	// fileRenamer
	private static String fileRenamer(int _num) {
		String renamedFileName = null;
		renamedFileName = "test" + "(" + _num + ").txt";
		return renamedFileName;
	}
}
