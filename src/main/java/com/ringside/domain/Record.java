package com.ringside.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Record")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String contender1;

	private String contender2;

	private String winner;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fightDate;

	public Record(Long id, String contender1, String contender2, String winner, LocalDate fightDate) {
		super();
		this.id = id;
		this.contender1 = contender1;
		this.contender2 = contender2;
		this.winner = winner;
		this.fightDate = fightDate;
	}

	public Record(String contender1, String contender2, String winner, LocalDate fightDate) {
		super();
		this.contender1 = contender1;
		this.contender2 = contender2;
		this.winner = winner;
		this.fightDate = fightDate;
	}

	public Record() {
		super();

	}

	public Record(Long id, String winner) {
		super();
		this.id = id;
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

	public LocalDate getFightDate() {
		return fightDate;
	}

	public void setFightDate(LocalDate fightDate) {
		this.fightDate = fightDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contender1, contender2, fightDate, id, winner);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Objects.equals(contender1, other.contender1) && Objects.equals(contender2, other.contender2)
				&& Objects.equals(fightDate, other.fightDate) && Objects.equals(id, other.id)
				&& Objects.equals(winner, other.winner);
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", contender1=" + contender1 + ", contender2=" + contender2 + ", winner=" + winner
				+ ", fightDate=" + fightDate + "]";
	}

}
