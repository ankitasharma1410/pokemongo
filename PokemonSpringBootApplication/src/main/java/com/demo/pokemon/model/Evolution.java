package com.demo.pokemon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Evolution {

	@JsonIgnore
	private PastBranch pastBranch;
	private CostToEvolve costToEvolve;

	public PastBranch getPastBranch() {
		return pastBranch;
	}

	public void setPastBranch(PastBranch pastBranch) {
		this.pastBranch = pastBranch;
	}

	public CostToEvolve getCostToEvolve() {
		return costToEvolve;
	}

	public void setCostToEvolve(CostToEvolve costToEvolve) {
		this.costToEvolve = costToEvolve;
	}

	@JsonIgnore
	private List<FutureBranches> futureBranches;

	public List<FutureBranches> getFutureBranches() {
		return futureBranches;
	}

	public void setFutureBranches(List<FutureBranches> futureBranches) {
		this.futureBranches = futureBranches;
	}

}
