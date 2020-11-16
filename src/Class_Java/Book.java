package Class_Java;



public class Book {
	
	 private int IdBk,IdB ;
	 private String Date_edition,NomBk, AuteurBk,path;
	 private Double PrixBx;
	 
	 //constructeur
	 public Book() {}
	 
	 public Book(int IdBk,String NomBk,String AuteurBk,String Date_edition,Double PrixBk,String path,int IdB) {
		 
		 this.IdBk=IdBk;
		 this.NomBk=NomBk;
		 this.AuteurBk=AuteurBk;
		 this.Date_edition=Date_edition;
		 this.PrixBx=PrixBk;
		 this.path=path;
		 this.IdB=IdB;
		 
		 
	 }
	 
	 
	 public int getIdBk() {
		return IdBk;
	}

	public void setIdBk(int idBk) {
		IdBk = idBk;
	}

	
     
	 public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	


	public int getIdB() {
		return IdB;
	}

	public void setIdB(int idB) {
		IdB = idB;
	}

	public String getNomBk() {
		return NomBk;
	}

	public void setNomBk(String nomBk) {
		NomBk = nomBk;
	}

	public String getAuteurBk() {
		return AuteurBk;
	}

	public void setAuteurBk(String auteurBk) {
		AuteurBk = auteurBk;
	}

	public String getDate_edition() {
		return Date_edition;
	}

	public void setDate_edition(String date_edition) {
		Date_edition = date_edition;
	}

	public Double getPrixBx() {
		return PrixBx;
	}

	public void setPrixBx(Double prixBx) {
		PrixBx = prixBx;
	}
}
