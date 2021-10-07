package com.ringside.dto;

import java.util.Objects;

public class RecordDTO {

	private Long id;
	private String contender1;
	private String contender2;
	private String winner;

	public RecordDTO() {
		super();

	}

	public RecordDTO(String contender1, String contender2, String winner) {
		super();
		this.contender1 = contender1;
		this.contender2 = contender2;
		this.winner = winner;
	}

	public RecordDTO(Long id, String contender1, String contender2, String winner) {
		super();
		this.id = id;
		this.contender1 = contender1;
		this.contender2 = contender2;
		this.winner = winner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContender1() {
		return contender1;
	}

	public void setContender1(String contender1) {
		this.contender1 = contender1;
	}

	public String getContender2() {
		return contender2;
	}

	public void setContender2(String contender2) {
		this.contender2 = contender2;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contender1, contender2, id, winner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordDTO other = (RecordDTO) obj;
		return Objects.equals(contender1, other.contender1) && Objects.equals(contender2, other.contender2)
				&& Objects.equals(id, other.id) && Objects.equals(winner, other.winner);
	}

	@Override
	public String toString() {
		return "RecordDTO [id=" + id + ", contender1=" + contender1 + ", contender2=" + contender2 + ", winner="
				+ winner + "]";
	}

}
