package de.db12.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Game {

	public enum WinCategory {
		cardgame, race, conflict, economy
	}

	public enum ThemeCategory {
		kingdom, conflict
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 1000)
	private String name;

	@Enumerated(EnumType.STRING)
	private Set<WinCategory> winTypes;

	@Enumerated(EnumType.STRING)
	private Set<ThemeCategory> themeType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", themeType=" + themeType
				+ ", winTypes=" + winTypes + "]";
	}

}
