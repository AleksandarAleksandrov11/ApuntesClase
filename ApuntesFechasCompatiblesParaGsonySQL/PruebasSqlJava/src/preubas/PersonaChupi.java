package preubas;


public class PersonaChupi {
	private int codigo;
	private String likings;

	public PersonaChupi(int codigo, String likings) {
		super();
		this.codigo = codigo;
		this.likings = likings;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLikings() {
		return likings;
	}

	public void setLikings(String likings) {
		this.likings = likings;
	}

}
