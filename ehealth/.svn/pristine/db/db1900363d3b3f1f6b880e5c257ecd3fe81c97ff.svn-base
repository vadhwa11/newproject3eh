package jkt.hms.masters.business.base;

import java.io.Serializable;


public abstract class BaseSct2ConceptPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.Long id;
	private java.util.Date effectivetime;


	public BaseSct2ConceptPK () {}
	
	public BaseSct2ConceptPK (
		java.lang.Long id,
		java.util.Date effectivetime) {

		this.setId(id);
		this.setEffectivetime(effectivetime);
	}


	/**
	 * Return the value associated with the column: id
	 */
	public java.lang.Long getId () {
		return id;
	}

	/**
	 * Set the value related to the column: id
	 * @param id the id value
	 */
	public void setId (java.lang.Long id) {
		this.id = id;
	}



	/**
	 * Return the value associated with the column: effectivetime
	 */
	public java.util.Date getEffectivetime () {
		return effectivetime;
	}

	/**
	 * Set the value related to the column: effectivetime
	 * @param effectivetime the effectivetime value
	 */
	public void setEffectivetime (java.util.Date effectivetime) {
		this.effectivetime = effectivetime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.Sct2ConceptPK)) return false;
		else {
			jkt.hms.masters.business.Sct2ConceptPK mObj = (jkt.hms.masters.business.Sct2ConceptPK) obj;
			if (null != this.getId() && null != mObj.getId()) {
				if (!this.getId().equals(mObj.getId())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getEffectivetime() && null != mObj.getEffectivetime()) {
				if (!this.getEffectivetime().equals(mObj.getEffectivetime())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getId()) {
				sb.append(this.getId().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getEffectivetime()) {
				sb.append(this.getEffectivetime().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}