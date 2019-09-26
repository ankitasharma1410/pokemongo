package com.demo.pokemon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

	@JsonProperty("dex")
	private int dex;
	@JsonProperty("name")
	private String name;
	@JsonProperty("animationTime")
	private double animationTime[];
	@JsonProperty("height")
	private double height;
	@JsonProperty("modelHeight")
	private double modelHeight;
	@JsonProperty("kmBuddyDistance")
	private double kmBuddyDistance;
	@JsonProperty("weight")
	private double weight;
	@JsonProperty("modelScale")
	private double modelScale;
	@JsonProperty("maxCP")
	private double maxCP;
	private BuddySize buddySize;
	private List<CinematicMoves> cinematicMoves;
	private List<QuickMoves> quickMoves;
	private Family family;
	private Stats stats;
	private List<Types> types;
	private Encounter encounter;
	private Rarity rarity;
	@JsonIgnore
	private Camera camera;
	@JsonIgnore
	private Evolution evolution;
	@JsonProperty("id")
	private String id;
	@JsonIgnore
	private String forms;

	public int getDex() {
		return dex;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getAnimationTime() {
		return animationTime;
	}

	public void setAnimationTime(double[] animationTime) {
		this.animationTime = animationTime;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getModelHeight() {
		return modelHeight;
	}

	public void setModelHeight(double modelHeight) {
		this.modelHeight = modelHeight;
	}

	public double getKmBuddyDistance() {
		return kmBuddyDistance;
	}

	public void setKmBuddyDistance(double kmBuddyDistance) {
		this.kmBuddyDistance = kmBuddyDistance;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getModelScale() {
		return modelScale;
	}

	public void setModelScale(double modelScale) {
		this.modelScale = modelScale;
	}

	public double getMaxCP() {
		return maxCP;
	}

	public void setMaxCP(double maxCP) {
		this.maxCP = maxCP;
	}

	public BuddySize getBuddySize() {
		return buddySize;
	}

	public void setBuddySize(BuddySize buddySize) {
		this.buddySize = buddySize;
	}

	public List<CinematicMoves> getCinematicMoves() {
		return cinematicMoves;
	}

	public void setCinematicMoves(List<CinematicMoves> cinematicMoves) {
		this.cinematicMoves = cinematicMoves;
	}

	public List<QuickMoves> getQuickMoves() {
		return quickMoves;
	}

	public void setQuickMoves(List<QuickMoves> quickMoves) {
		this.quickMoves = quickMoves;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public List<Types> getTypes() {
		return types;
	}

	public void setTypes(List<Types> types) {
		this.types = types;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Evolution getEvolution() {
		return evolution;
	}

	public void setEvolution(Evolution evolution) {
		this.evolution = evolution;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getForms() {
		return forms;
	}

	public void setForms(String forms) {
		this.forms = forms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
