package makaza.common;

/**
 * CodeDef
 * 
 * @author Minh
 */
public enum CodeDef {
	DELETE("1"), NON_DELETE("0"), SUCCESS("1"), FAIL("0");

	private String code;

	private CodeDef(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
