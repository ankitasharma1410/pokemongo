package com.demo.pokemon.model;

public class Encounter {
	private String attackProbability;
	private String attackTimer;
	private String baseFleeRate;
	private String baseCaptureRate;
	private String cameraDistance;
	private String collisionRadius;
	private String dodgeDistance;
	private String dodgeProbability;
	private String jumpTime;
	private String maxPokemonActionFrequency;
	private String minPokemonActionFrequency;
	private MovementType movementType;
	private Gender gender;

	public String getAttackProbability() {
		return attackProbability;
	}

	public void setAttackProbability(String attackProbability) {
		this.attackProbability = attackProbability;
	}

	public String getAttackTimer() {
		return attackTimer;
	}

	public void setAttackTimer(String attackTimer) {
		this.attackTimer = attackTimer;
	}

	public String getBaseFleeRate() {
		return baseFleeRate;
	}

	public void setBaseFleeRate(String baseFleeRate) {
		this.baseFleeRate = baseFleeRate;
	}

	public String getBaseCaptureRate() {
		return baseCaptureRate;
	}

	public void setBaseCaptureRate(String baseCaptureRate) {
		this.baseCaptureRate = baseCaptureRate;
	}

	public String getCameraDistance() {
		return cameraDistance;
	}

	public void setCameraDistance(String cameraDistance) {
		this.cameraDistance = cameraDistance;
	}

	public String getCollisionRadius() {
		return collisionRadius;
	}

	public void setCollisionRadius(String collisionRadius) {
		this.collisionRadius = collisionRadius;
	}

	public String getDodgeDistance() {
		return dodgeDistance;
	}

	public void setDodgeDistance(String dodgeDistance) {
		this.dodgeDistance = dodgeDistance;
	}

	public String getDodgeProbability() {
		return dodgeProbability;
	}

	public void setDodgeProbability(String dodgeProbability) {
		this.dodgeProbability = dodgeProbability;
	}

	public String getJumpTime() {
		return jumpTime;
	}

	public void setJumpTime(String jumpTime) {
		this.jumpTime = jumpTime;
	}

	public String getMaxPokemonActionFrequency() {
		return maxPokemonActionFrequency;
	}

	public void setMaxPokemonActionFrequency(String maxPokemonActionFrequency) {
		this.maxPokemonActionFrequency = maxPokemonActionFrequency;
	}

	public String getMinPokemonActionFrequency() {
		return minPokemonActionFrequency;
	}

	public void setMinPokemonActionFrequency(String minPokemonActionFrequency) {
		this.minPokemonActionFrequency = minPokemonActionFrequency;
	}

	public MovementType getMovementType() {
		return movementType;
	}

	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
