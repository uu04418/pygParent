package com.pinyougou.datapojo;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

public class Specification implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5963544798517861298L;
	
	private TbSpecification specification;
	
	private List<TbSpecificationOption> specificationOptionList;

	public TbSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}

	public List<TbSpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}

	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
	
	

	
}