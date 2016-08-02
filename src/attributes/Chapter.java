
//	+++ PACKAGE +++

package attributes;


//	+++ IMPORT +++

import java.util.ArrayList;

import resources.C;


//	+++ CLASS +++

public class Chapter {
	String name, demeanour;
	Talent talent;
	SquadModeAbility attack_pattern;
	SquadModeAbility defensive_stance;
	SoloModeAbility solo_mode_ability;
	ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
	ArrayList<Advance> advances = new ArrayList<Advance>();
	boolean has_restrictions = false;
	boolean has_talent = false;
	int ws_bonus = 0, bs_bonus = 0, s_bonus = 0, t_bonus = 0, agi_bonus = 0, int_bonus = 0, per_bonus = 0, wp_bonus = 0, fel_bonus = 0, wounds_bonus = 0;


//	+++ CONSTRUCTOR +++

	public Chapter(String name, SoloModeAbility solo_mode_ability, SquadModeAbility attack_pattern, SquadModeAbility defensive_stance, String demeanour, ArrayList<Advance> advances) {
		this.name = name;
		this.solo_mode_ability = solo_mode_ability;
		this.attack_pattern = attack_pattern;
		this.defensive_stance = defensive_stance;
		this.demeanour = demeanour;
		this.advances = advances;
	}


//	+++ COPY CONSTRUCTOR +++

	public Chapter(Chapter chapter) {
		this(chapter.getName(), chapter.getSoloModeAbility(), chapter.getAttackPattern(), chapter.getDefensiveStance(), chapter.getDemeanour(), chapter.getAdvances());
		ArrayList<Advance> _advances = new ArrayList<Advance>();
		for (Advance a : advances) {
			_advances.add(a);
		}
		advances = _advances;
		
		if (chapter.hasTalent()){
			setTalent(chapter.getTalent());
			has_talent = true;
		}
		if (chapter.hasRestrictions()){
			setRestrictions(chapter.getRestrictions());
			has_restrictions = true;
		}
		setBonus(chapter.getBonus(C.WEAPONSKILL), chapter.getBonus(C.BALLISTICSKILL), chapter.getBonus(C.STRENGTH), chapter.getBonus(C.TOUGHNESS), chapter.getBonus(C.AGILITY), chapter.getBonus(C.INTELLIGENCE), chapter.getBonus(C.PERCEPTION), chapter.getBonus(C.WILLPOWER), chapter.getBonus(C.FELLOWSHIP), chapter.getBonus(C.WOUNDS));
	}


//	+++ GETTER +++

	public String getName() {
		return name;
	}

	public String getDemeanour() {
		return demeanour;
	}
	
	public SoloModeAbility getSoloModeAbility() {
		return solo_mode_ability;
	}

	public SquadModeAbility getAttackPattern() {
		return attack_pattern;
	}

	public SquadModeAbility getDefensiveStance() {
		return defensive_stance;
	}

	public ArrayList<Restriction> getRestrictions() {
		return restrictions;
	}

	public Talent getTalent() {
		return talent;
	}
	
	public int getBonus(String bonus_name) {
		switch(bonus_name) {
			case C.WEAPONSKILL:
				return ws_bonus;
			case C.BALLISTICSKILL:
				return bs_bonus;
			case C.STRENGTH:
				return s_bonus;
			case C.TOUGHNESS:
				return t_bonus;
			case C.AGILITY:
				return agi_bonus;
			case C.INTELLIGENCE:
				return int_bonus;
			case C.PERCEPTION:
				return per_bonus;
			case C.WILLPOWER:
				return wp_bonus;
			case C.FELLOWSHIP:
				return fel_bonus;
			case C.WOUNDS:
				return wounds_bonus;
			default:return -1;
		}
	}

	public ArrayList<Advance> getAdvances() {
		return advances;
	}


//	+++ SETTER +++

	public void setRestrictions(ArrayList<Restriction> restrictions) {
		this.restrictions = restrictions;
		has_restrictions = true;
	}

	public void setBonus(int ws_bonus, int bs_bonus, int s_bonus, int t_bonus, int agi_bonus, int int_bonus, int per_bonus, int wp_bonus, int fel_bonus, int wounds_bonus) {
		this.ws_bonus = ws_bonus;
		this.bs_bonus = bs_bonus;
		this.s_bonus = s_bonus;
		this.t_bonus = t_bonus;
		this.agi_bonus = agi_bonus;
		this.int_bonus = int_bonus;
		this.per_bonus = per_bonus;
		this.wp_bonus = wp_bonus;
		this.fel_bonus = fel_bonus;
		this.wounds_bonus = wounds_bonus;
	}

	public void setTalent(Talent talent) {
		this.talent = talent;
		has_talent = true;
	}


//	+++ HAS +++

	public boolean hasRestrictions() {
		return has_restrictions;
	}

	public boolean hasTalent() {
		return has_talent;
	}
}
