package org.file.foto.file;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.file.foto.utils.BaseEntity;

@Entity
@Table(name = "tb_Fotos")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class File extends BaseEntity<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Lob
	@Column(name = "tb_file",  nullable = true)
	//@Transient
	byte[]file;
	@Column(name = "tb_mymeType", length = 80, nullable = true)
	//@Transient
	String mymeType;

	@Column(name = "tb_nome_Image", length = 80, nullable = true)
	String nomeImage;
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(byte[] file, String mymeType, String nomeImage) {
		super();
		this.file = file;
		this.mymeType = mymeType;
		this.nomeImage = nomeImage;
	}

	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String getMymeType() {
		return mymeType;
	}
	public void setMymeType(String mymeType) {
		this.mymeType = mymeType;
	}
	public String getNomeImage() {
		return nomeImage;
	}
	public void setNomeImage(String nomeImage) {
		this.nomeImage = nomeImage;
	}





}
