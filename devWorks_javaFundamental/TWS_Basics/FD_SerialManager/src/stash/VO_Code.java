package stash;

import java.io.Serializable;

public class VO_Code implements Serializable{
	String codeA;
	String codeB;

	public VO_Code(String codeA, String codeB) {
		super();
		this.codeA = codeA;
		this.codeB = codeB;
	}

	public String getCodeA() {
		return codeA;
	}

	public void setCodeA(String codeA) {
		this.codeA = codeA;
	}

	public String getCodeB() {
		return codeB;
	}

	public void setCodeB(String codeB) {
		this.codeB = codeB;
	}

	@Override
	public String toString() {
		return "VO_CodeStructure [codeA=" + codeA + ", codeB=" + codeB + "]";
	}

}
