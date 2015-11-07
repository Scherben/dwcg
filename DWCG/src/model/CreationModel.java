
//	+++ PACKAGE +++

package model;


//	+++ IMPORT +++

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import attributes.Advance;
import attributes.Chapter;
import attributes.CharacterValue;
import attributes.Characteristic;
import attributes.Restriction;
import attributes.Skill;
import attributes.SoloModeAbility;
import attributes.SpecialAbility;
import attributes.Speciality;
import attributes.SquadModeAbility;
import attributes.Talent;
import attributes.Trait;

import resources.Functions;


//	+++ CLASS +++

public class CreationModel extends Observable {


	//	+++ CONSTANTS +++

	public static final String BLACKTEMPLARS			= "Black Templars";
	public static final String BLOODANGELS				= "Blood Angels";
	public static final String DARKANGELS 				= "Dark Angels";
	public static final String SPACEWOLVES 				= "Space Wolves";
	public static final String STORMWARDENS 			= "Storm Wardens";
	public static final String ULTRAMARINES 			= "Ultramarines";
	public static final String SPACEMARINE 				= "Spacemarine";
	public static final String DEATHWATCH 				= "Deathwatch";
	public static final String APOTHECARY 				= "Apothecary";
	public static final String ASSAULTMARINE 			= "Assault Marine";
	public static final String DEVASTATORMARINE 		= "Devastator Marine";
	public static final String LIBRARIAN 				= "Librarian";
	public static final String TACTICALMARINE 			= "Tactical Marine";
	public static final String TECHMARINE 				= "Techmarine";
	public static final String CHARACTERISTIC 			= "Characteristic";
	public static final String WEAPONSKILL 				= "Weapon Skill";
	public static final String BALLISTICSKILL 			= "Ballistic Skill";
	public static final String STRENGTH 				= "Strength";
	public static final String TOUGHNESS 				= "Toughness";
	public static final String AGILITY 					= "Agility";
	public static final String INTELLIGENCE 			= "Intelligence";
	public static final String PERCEPTION 				= "Perception";
	public static final String WILLPOWER 				= "Willpower";
	public static final String FELLOWSHIP 				= "Fellowship";
	public static final String WS_		 				= "WS";
	public static final String BS_		 				= "BS";
	public static final String S_		 				= "S";
	public static final String T_		 				= "T";
	public static final String AGI_		 				= "Agi";
	public static final String INT_		 				= "Int";
	public static final String PER_		 				= "Per";
	public static final String WP_		 				= "WP";
	public static final String FEL_		 				= "Fel";
	public static final String WOUNDS 					= "Wounds";
	public static final String INSANITY 				= "Insanity";
	public static final String MOVEMENT 				= "Movement";
	public static final String FATE 					= "Fate";
	public static final String CORRUPTION 				= "Corruption";
	public static final String RANK 					= "Rank";
	public static final String XPTOTAL 					= "Total Experience";
	public static final String XPREST 					= "Rest Experience";
	public static final String REKNOWN 					= "Reknown";
	public static final String PSYRATING 				= "Psy Rating";
	public static final String CHAPTER 					= "Chapter";
	public static final String SPECIALITY 				= "Speciality";
	public static final String DEMEANOUR 				= "Demeanour";
	public static final String PASTEVENT 				= "Past Event";
	public static final String DESCRIPTION 				= "Description";
	public static final String SKILL 					= "Skill";
	public static final String DESCRIPTOR 				= "Descriptor";
	public static final String TALENT 					= "Talent";
	public static final String PSYCHICTECHNIQUE 		= "Psychic Technique";
	public static final String TRAIT 					= "Trait";
	public static final String SPECIALABILITY 			= "Special Ability";
	public static final String SOLOMODEABILITY 			= "Solo Mode Ability";
	public static final String SQUADMODEABILITY 		= "Squad Mode Ability";
	public static final String GROUP 					= "Group";
	public static final String ATTACKPATTERN 			= "Attack Pattern";
	public static final String DEFENSIVESTANCE 			= "Defensive Stance";

	public static final String MARK						= "#";
	public static final String DEMARK					= "-";

	//all available Attributes for a Character
	private final ArrayList<Trait> available_traits = new ArrayList<Trait>();
	private final ArrayList<Skill> available_skills = new ArrayList<Skill>();
	private final ArrayList<Talent> available_talents = new ArrayList<Talent>();
	private final ArrayList<SoloModeAbility> available_solo_mode_abilities = new ArrayList<SoloModeAbility>();
	private final ArrayList<Chapter> available_chapters = new ArrayList<Chapter>();
	private final ArrayList<Speciality> available_specialities = new ArrayList<Speciality>();
	private final ArrayList<Advance> available_spacemarine_advances;
	private final ArrayList<Advance> available_deathwatch_advances;

	//all starting Attributes for a Character
	private final ArrayList<Trait> starting_traits = new ArrayList<Trait>();
	private final ArrayList<Talent> starting_talents = new ArrayList<Talent>();
	private final ArrayList<Skill> starting_skills = new ArrayList<Skill>();
	private final ArrayList<SoloModeAbility> starting_solo_mode_abilities = new ArrayList<SoloModeAbility>();
	private final ArrayList<Characteristic> starting_characteristics = new ArrayList<Characteristic>();
	private final ArrayList<CharacterValue> starting_charactervalues = new ArrayList<CharacterValue>();

	//all actual Attributes of a Character
	private ArrayList<Trait> traits = new ArrayList<Trait>();
	private ArrayList<Talent> talents = new ArrayList<Talent>();
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private ArrayList<SoloModeAbility> solo_mode_abilities = new ArrayList<SoloModeAbility>();
	private ArrayList<SpecialAbility> special_abilities = new ArrayList<SpecialAbility>();
	private ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
	private ArrayList<CharacterValue> charactervalues = new ArrayList<CharacterValue>();
	private ArrayList<Advance> advances = new ArrayList<Advance>();
	private Chapter chapter = null;
	private Speciality speciality = null;
	private Skill chosen_tactic = null;
	@SuppressWarnings("unused")
	//this var is used, but in an if-branch which resolves always only depending on which item it compares thus it is used but not for eclipse
	private SpecialAbility chosen_special_ability;
	private boolean has_chapter = false, has_speciality = false, has_chosen_special_ability = false, has_chosen_tactic = false;
	private String name = "";
	private String demeanour = "";
	private String description = "";
	private String past_event = "";

	//other Elements of the Model
	private String flag = "";


//	+++ CONSTRUCTOR +++

	public CreationModel() {

		//available/starting Attributes for a Character
		loadStartingCharacteristics();
		loadStartingCharacterValues();

		//available Resources necessary for creating a Deathwatch Spacemarine
		loadAvailableSkills();
		loadAvailableTalents();
		loadAvailableTraits();
		loadAvailableSoloModeAbilities();
		loadAvailableChapters();
		loadAvailableSpecialities();
		setChapterRestrictions();
		available_spacemarine_advances = listAdvances(Functions.mapList(Functions.loadCSV("res/spacemarine_advances.csv"),2), SPACEMARINE);
		available_deathwatch_advances = listAdvances(Functions.mapList(Functions.loadCSV("res/deathwatch_advances.csv"),2), DEATHWATCH);
		

		//starting Attributes of a Deathwatch Spacemarine
		loadStartingTraits();
		loadStartingTalents();
		loadStartingSkills();
		loadStartingSoloModeAbilities();
	}


//	+++ PREPARING VARIABLES +++

	private void loadAvailableTraits() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_traits.csv"),1);
		String name = "", group = "";

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case TRAIT: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					default: break;
				}
			}
			available_traits.add(new Trait(name, group, 0));
		}
	}

	private void loadAvailableSkills() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_skills.csv"),1);
		String name = "", group = "", descriptor = "", characteristic = "";
		boolean is_basic;

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			is_basic = false;
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case SKILL: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					case "Basic":
						if (e2.getValue().equals(MARK))
							is_basic = true;
						break;
					case CHARACTERISTIC: characteristic = e2.getValue(); break;
					case DESCRIPTOR : descriptor = e2.getValue(); break;
					default: break;
				}
			}
			available_skills.add(new Skill(name, group, characteristic, descriptor, 0, is_basic, false));
		}
	}

	private void loadAvailableTalents() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_talents.csv"),1);
		String name = "", group = "";

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case TALENT: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					default: break;
				}
			}
			available_talents.add(new Talent(name, group));
		}
	}

	private void loadAvailableSoloModeAbilities() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_solo_mode_abilities.csv"),2);
		String name = "";
		int rank = 1;
		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case SOLOMODEABILITY: name = e2.getValue(); break;
					case RANK: rank = Integer.parseInt(e2.getValue()); break;
					default: break;
				}
			}
			available_solo_mode_abilities.add(new SoloModeAbility(name, rank));
		}
	}

	private void loadAvailableChapters() {
		final HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_chapters.csv"),2);
		String name = "", demeanour = "", chapter_file_name = "";
		int ws_bonus = 0, bs_bonus = 0, s_bonus = 0, t_bonus = 0, agi_bonus = 0, int_bonus = 0, per_bonus = 0, wp_bonus = 0, fel_bonus = 0, wounds_bonus = 0;
		Talent talent = null;
		SoloModeAbility solo_mode_ability = null;
		SquadModeAbility attack_pattern = null;
		SquadModeAbility defensive_stance = null;

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case CHAPTER: name = e2.getValue(); break;
					case SOLOMODEABILITY: solo_mode_ability = new SoloModeAbility(e2.getValue(), 1); break;
					case ATTACKPATTERN: attack_pattern = new SquadModeAbility(e2.getValue(), 1); break;
					case DEFENSIVESTANCE: defensive_stance = new SquadModeAbility(e2.getValue(), 1); break;
					case DEMEANOUR: demeanour = e2.getValue(); break;
					case WS_: ws_bonus = Integer.parseInt(e2.getValue()); break;
					case BS_: bs_bonus =  Integer.parseInt(e2.getValue()); break;
					case S_: s_bonus =  Integer.parseInt(e2.getValue()); break;
					case T_: t_bonus =  Integer.parseInt(e2.getValue()); break;
					case AGI_: agi_bonus =  Integer.parseInt(e2.getValue()); break;
					case INT_: int_bonus =  Integer.parseInt(e2.getValue()); break;
					case PER_: per_bonus =  Integer.parseInt(e2.getValue()); break;
					case WP_: wp_bonus =  Integer.parseInt(e2.getValue()); break;
					case FEL_: fel_bonus =  Integer.parseInt(e2.getValue()); break;
					case WOUNDS: wounds_bonus =  Integer.parseInt(e2.getValue()); break;
					case TALENT: 
						if (!e2.getValue().equals("-")) {
							talent = (Talent) Functions.getSpecific(available_talents,e2.getValue());
						} else {
							talent = null;
						}
						break;
					default:break;
				}
			}
			if (name.indexOf(" ") > 0) {
				chapter_file_name = name.replaceAll(" ", "_").toLowerCase();
			} else {
				chapter_file_name = name.toLowerCase();
			}
			ArrayList<Advance> advances = listAdvances(Functions.mapList(Functions.loadCSV("res/" + chapter_file_name + "_advances.csv"),2), CHAPTER);
			available_chapters.add(new Chapter(name, solo_mode_ability, attack_pattern ,defensive_stance, demeanour, advances));
			Chapter c = (Chapter) Functions.getSpecific(available_chapters, name);
			if (talent != null)
				c.setTalent(talent);
			c.setBonus(ws_bonus, bs_bonus, s_bonus, t_bonus, agi_bonus, int_bonus, per_bonus, wp_bonus, fel_bonus, wounds_bonus);
		}
	}

	private void loadAvailableSpecialities() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/general_specialities.csv"),1);
		HashMap<String,HashMap<String,String>> h2 = Functions.mapList(Functions.loadCSV("res/general_special_abilities_traits.csv"),2);
		HashMap<String,HashMap<String,String>> h3 = Functions.mapList(Functions.loadCSV("res/general_special_abilities_talents.csv"),1);
		HashMap<String,HashMap<String,String>> h4 = Functions.mapList(Functions.loadCSV("res/general_specialities_skills.csv"),1);
		ArrayList<SpecialAbility> available_special_abilities = new ArrayList<SpecialAbility>();
		String name = "", special_ability_name = "", speciality_file_name = "";
		Talent talent = null;
		Trait trait = null;
		Skill skill = null;
		SpecialAbility sa = null;
		
		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			boolean choosable = false;
			HashMap<String,String> h = e1.getValue();
			for (Map.Entry<String,String> e2 : h.entrySet()) {
				switch (e2.getKey()) {
					case SPECIALITY: name = e2.getValue(); break;
					case SPECIALABILITY: special_ability_name = e2.getValue(); break;
					case "Choosable": 
						if (e2.getValue().equals(MARK))
						choosable = true;
						break;
					default:break;
				}
			}
			sa = new SpecialAbility(special_ability_name,choosable);
			available_special_abilities.add(sa);

			//does the speciality exist?
			if ((Speciality) Functions.getSpecific(available_specialities, name) == null) { //no
				if (name.indexOf(" ") > 0) {
					speciality_file_name = name.replaceAll(" ", "_").toLowerCase();
				} else {
					speciality_file_name = name.toLowerCase();
				}
				ArrayList<Advance> advances = listAdvances(Functions.mapList(Functions.loadCSV("res/" + speciality_file_name + "_advances.csv"),2), SPECIALITY);
				//add a new speciality
				available_specialities.add(new Speciality(name, advances));
			}
			Speciality s = (Speciality) Functions.getSpecific(available_specialities, name);

			//does the speciality have special abilities?
			if (s.hasSpecialAbilities()) { //yes
				//get the special abilities list from the speciality
				s.getSpecialAbilities().add(sa);
			}else{
				ArrayList<SpecialAbility> al = new ArrayList<SpecialAbility>();
				al.add(sa);
				s.setSpecialAbilities(al);
			}
		}

		for (Map.Entry<String, HashMap<String,String>> e1 : h2.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h = e1.getValue();
			for (Map.Entry<String,String> e2 : h.entrySet()) {
				switch (e2.getKey()) {
					case SPECIALABILITY: sa = (SpecialAbility) Functions.getSpecific(available_special_abilities, e2.getValue()); break;
					case TRAIT: trait = new Trait((Trait) Functions.getSpecific(available_traits, e2.getValue())); break;
					//case SPECIALITY: speciality = (Speciality) getSpecific(available_specialities, e2.getValue()); break;
					default:break;
				}
			}
			//because of the fact that there is only one Trait at the moment, further handling is not necessary
			sa.setTrait(trait);
		}

		for (Map.Entry<String, HashMap<String,String>> e1 : h3.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h = e1.getValue();
			ArrayList<Talent> special_ability_talents = new ArrayList<Talent>();

			for (Map.Entry<String,String> e2 : h.entrySet()) {
				switch (e2.getKey()) {
					case SPECIALABILITY: sa = (SpecialAbility) Functions.getSpecific(available_special_abilities, e2.getValue()); break;
					case TALENT: talent = (Talent) Functions.getSpecific(available_talents, e2.getValue()); break;
					//case SPECIALITY: speciality = (Speciality) getSpecific(available_specialities, e2.getValue()); break;
					default:break;
				}
			}
			if (sa.hasTalents())
				special_ability_talents = sa.getTalents();
			//does the talent for the special ability already exist in the talent list?
			if ((Talent) Functions.getSpecific(special_ability_talents, talent.getName()) == null) { //no
				//add this talent to the special ability talent list
				special_ability_talents.add(talent);
				//set the updated list for the current special ability
				sa.setTalents(special_ability_talents);
			}
		}

		for (Map.Entry<String, HashMap<String,String>> e1 : h4.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h = e1.getValue();
			ArrayList<Skill> speciality_skills = new ArrayList<Skill>();

			for (Map.Entry<String,String> e2 : h.entrySet()) {
				switch (e2.getKey()) {
					case SPECIALITY: name = e2.getValue(); break;
					case SKILL: 
						skill = new Skill((Skill) Functions.getSpecific(available_skills, e2.getValue()));
						skill.setTrained(true);
						break;
					default:break;
				}
			}
			Speciality s = (Speciality) Functions.getSpecific(available_specialities,name);
			//does the speciality have skills
			if (s.hasSkills()) { //yes
				//get the skill list from the speciality
				speciality_skills = s.getSkills();
			}
			//add the skill to the skill list
			speciality_skills.add(skill);
			//set the skill list for the speciality
			s.setSkills(speciality_skills);
		}
	}

	public void setChapterRestrictions() {
		for (Chapter c : available_chapters) {
			if (c.getName().equals(SPACEWOLVES)) {
				ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
				restrictions.add(new Restriction((Speciality) Functions.getSpecific(available_specialities, APOTHECARY)));
				c.setRestrictions(restrictions);
			} else if (c.getName().equals(BLACKTEMPLARS)) {
				ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
				restrictions.add(new Restriction((Speciality) Functions.getSpecific(available_specialities, LIBRARIAN)));
				restrictions.add(new Restriction((Speciality) Functions.getSpecific(available_specialities, DEVASTATORMARINE)));
				c.setRestrictions(restrictions);
			}
		}
	}

	private ArrayList<Advance> listAdvances(HashMap<String, HashMap<String,String>> map, String classification) {
		ArrayList<Advance> advances = new ArrayList<Advance>();
		for (Map.Entry<String, HashMap<String,String>> e1 : map.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h = e1.getValue();
			String name = null, skill_name = null, type = null;
			int cost = 0, bonus = 0;
			Skill skill;
			Talent talent;
			Characteristic characteristic;

			for (Map.Entry<String,String> e2 : h.entrySet()) {
				switch (e2.getKey()) {
					case "Advance": name = e2.getValue(); break;
					case "Type": type = e2.getValue(); break;
					case "Cost": cost = Integer.parseInt(e2.getValue()); break;
					default:break;
				}
			}
			Advance a = new Advance(classification, name, cost);
			if (type.equals(SKILL)) {
				if (name.indexOf("0") != -1) {
					bonus = Integer.parseInt(name.substring(name.indexOf("0")-1, name.indexOf("0")+1));
					skill_name = name.substring(0, name.lastIndexOf(")")-4);
					skill = new Skill((Skill) Functions.getSpecific(available_skills, skill_name));
				} else {
					skill = new Skill((Skill) Functions.getSpecific(available_skills, name));
				}
				skill.setTrained(true);
				skill.setBonus(bonus);
				a.setSkill(skill);
			} else if (type.equals(TALENT)) {
				talent = (Talent) Functions.getSpecific(available_talents, name);
				a.setTalent(talent);
			} else if (type.equals(CHARACTERISTIC)) {
				bonus = 5;
				characteristic = new Characteristic((Characteristic) Functions.getSpecific(starting_characteristics, name)); 
				characteristic.setAdvanceBonus(bonus);
				a.setCharacteristic(characteristic);
			}

			advances.add(a);
		}
		return advances;
	}

	private void loadStartingCharacteristics() {
		Characteristic ws_ = new Characteristic(WEAPONSKILL, false);
		Characteristic b_ = new Characteristic(BALLISTICSKILL, false);
		Characteristic s_ = new Characteristic(STRENGTH, true);
		Characteristic t_ = new Characteristic(TOUGHNESS, true);
		Characteristic a_ = new Characteristic(AGILITY, true);
		Characteristic i_ = new Characteristic(INTELLIGENCE, true);
		Characteristic p_ = new Characteristic(PERCEPTION, true);
		Characteristic wp_ = new Characteristic(WILLPOWER, true);
		Characteristic f_ = new Characteristic(FELLOWSHIP, true);
		Characteristic cws_ = new Characteristic(ws_);
		Characteristic cb_ = new Characteristic(b_);
		Characteristic cs_ = new Characteristic(s_);
		Characteristic ct_ = new Characteristic(t_);
		Characteristic ca_ = new Characteristic(a_);
		Characteristic ci_ = new Characteristic(i_);
		Characteristic cp_ = new Characteristic(p_);
		Characteristic cwp_ = new Characteristic(wp_);
		Characteristic cf_ = new Characteristic(f_);
		starting_characteristics.add(ws_);
		starting_characteristics.add(b_);
		starting_characteristics.add(s_);
		starting_characteristics.add(t_);
		starting_characteristics.add(a_);
		starting_characteristics.add(i_);
		starting_characteristics.add(p_);
		starting_characteristics.add(wp_);
		starting_characteristics.add(f_);
		characteristics.add(cws_);
		characteristics.add(cb_);
		characteristics.add(cs_);
		characteristics.add(ct_);
		characteristics.add(ca_);
		characteristics.add(ci_);
		characteristics.add(cp_);
		characteristics.add(cwp_);
		characteristics.add(cf_);
	}

	private void loadStartingCharacterValues() {
		CharacterValue w_ = new CharacterValue(WOUNDS, 18);
		CharacterValue i_ = new CharacterValue(INSANITY, 0);
		CharacterValue m_ = new CharacterValue(MOVEMENT, ((Characteristic) Functions.getSpecific(starting_characteristics, AGILITY)).getBonus());
		CharacterValue f_ = new CharacterValue(FATE, 0);
		CharacterValue c_ = new CharacterValue(CORRUPTION, 0);
		CharacterValue ra_ = new CharacterValue(RANK, 1);
		CharacterValue xr_ = new CharacterValue(XPREST, 1000);
		CharacterValue xt_ = new CharacterValue(XPTOTAL, 1000);
		CharacterValue re_ = new CharacterValue(REKNOWN, 0);
		CharacterValue p_ = new CharacterValue(PSYRATING, 0);
		CharacterValue cw_ = new CharacterValue(w_);
		CharacterValue ci_ = new CharacterValue(i_);
		CharacterValue cm_ = new CharacterValue(m_);
		CharacterValue cf_ = new CharacterValue(f_);
		CharacterValue cc_ = new CharacterValue(c_);
		CharacterValue cra_ = new CharacterValue(ra_);
		CharacterValue cxr_ = new CharacterValue(xr_);
		CharacterValue cxt_ = new CharacterValue(xt_);
		CharacterValue cre_ = new CharacterValue(re_);
		CharacterValue cp_ = new CharacterValue(p_);
		starting_charactervalues.add(w_);
		starting_charactervalues.add(i_);
		starting_charactervalues.add(m_);
		starting_charactervalues.add(f_);
		starting_charactervalues.add(c_);
		starting_charactervalues.add(ra_);
		starting_charactervalues.add(xr_);
		starting_charactervalues.add(xt_);
		starting_charactervalues.add(re_);
		starting_charactervalues.add(p_);
		charactervalues.add(cw_);
		charactervalues.add(ci_);
		charactervalues.add(cm_);
		charactervalues.add(cf_);
		charactervalues.add(cc_);
		charactervalues.add(cra_);
		charactervalues.add(cxr_);
		charactervalues.add(cxt_);
		charactervalues.add(cre_);
		charactervalues.add(cp_);
	}

	private void loadStartingTraits() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/starting_traits.csv"),1);
		String name = "", group = "";
		int multiplier = 0;

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case TRAIT: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					case "Multiplier": multiplier = Integer.parseInt(e2.getValue()); break;
					default:break;
				}
			}
			Trait t = new Trait(name, group, multiplier);
			Trait copy = new Trait(t);
			starting_traits.add(t);
			traits.add(copy);
		}
	}

	//erzeugt Talent-Objekte und fügt sie in eine Map ein
	private void loadStartingTalents() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/starting_talents.csv"),1);
		String name = "", group = "";

		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();

			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case TALENT: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					default: break;
				}
			}
			Talent t = new Talent(name, group);
			starting_talents.add(t);
			talents.add(t);
		}
	}

	//erzeugt Skill-Objekte und fügt sie in eine Map ein
	private void loadStartingSkills() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/starting_skills.csv"),1);
		//HashMap<String,HashMap<String,String>> general_skills = Functions.mapList(Functions.loadCSV("res/general_skills.csv"),1);
		String name = "", group = "";
		boolean trained;
		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			trained = false;
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();
			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				switch (e2.getKey()) {
					case SKILL: name = e2.getValue(); break;
					case GROUP: group = e2.getValue(); break;
					case "Trained":
						if (e2.getValue().equals(MARK))
							trained = true;
						break;
					default: break;
				}
			}
			Skill s = (Skill) Functions.getSpecific(available_skills, name + " (" + group + ")");
			if (trained)
				s.setTrained(trained);
			Skill copy = new Skill(s);
			starting_skills.add(s);
			skills.add(copy);
		}
	}

	private void loadStartingSoloModeAbilities() {
		HashMap<String,HashMap<String,String>> h1 = Functions.mapList(Functions.loadCSV("res/starting_solo_mode_abilities.csv"),2);
		String name = "";
		for (Map.Entry<String, HashMap<String,String>> e1 : h1.entrySet()) {
			//System.out.println("Key = " + e1.getKey() + ", Value = " + e1.getValue());
			HashMap<String,String> h2 = e1.getValue();
			for (Map.Entry<String,String> e2 : h2.entrySet()) {
				name = e2.getValue();
			}
			SoloModeAbility sma = new SoloModeAbility(name, 1);
			starting_solo_mode_abilities.add(sma);
			solo_mode_abilities.add(sma);
		}
	}


//	+++ GETTER +++

	public ArrayList<Advance> getAvailableSpacemarineAdvances() {
		return available_spacemarine_advances;
	}

	public ArrayList<Advance> getAvailableDeathwatchAdvances() {
		return available_deathwatch_advances;
	}

	public ArrayList<Speciality> getAvailableSpecialities() {
		return available_specialities;
	}

	//Getter for Character owndes Attributes

	public ArrayList<Trait> getTraits() {
		return traits;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public ArrayList<Talent> getTalents() {
		return talents;
	}

	public ArrayList<SoloModeAbility> getSoloModeAbilities() {
		return solo_mode_abilities;
	}

	public ArrayList<SpecialAbility> getSpecialAbilities() {
		return special_abilities;
	}
	
	public ArrayList<Advance> getAdvances() {
		return advances;
	}

	public int getCharacterValueValue(String name, int multiplier) {
		return ((CharacterValue) Functions.getSpecific(charactervalues, name)).getValue(multiplier);
	}
	
	public int getCharacteristicValue(String name) {
		//System.out.println(((Characteristic) Functions.getSpecific(characteristics, name)).getValue());
		return ((Characteristic) Functions.getSpecific(characteristics, name)).getValue();
	}
	
	public Chapter getChapter() {
		return chapter;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public String getName() {
		return name;
	}

	public String getDemeanour() {
		return demeanour;
	}

	public String getDescription() {
		return description;
	}

	public String getPastEvent() {
		return past_event;
	}

	//Getter for everything else

	public ArrayList<String> getChapterList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("");
		for (Chapter c : available_chapters) {
			l.add(c.getName());
		}
		return l;
	}

	public ArrayList<String> getSpecialityList() {
		ArrayList<Speciality> al = new ArrayList<Speciality>();
		ArrayList<String> l = new ArrayList<String>();
		l.add("");

		if(has_chapter)
			if(chapter.hasRestrictions()){
				for (Restriction r : chapter.getRestrictions())
					al.add(r.getSpeciality());
			}

		for (Speciality s : available_specialities)
			if(has_chapter){
				if(chapter.hasRestrictions()){
					if(((Speciality) Functions.getSpecific(al, s.getName())) == null){
						l.add(s.getName());
					}
				}else{
					l.add(s.getName());
				}
			}else{
				l.add(s.getName());
			}
		return l;
	}

	public ArrayList<String> getSpecialAbilityList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("");
		if(has_speciality)
			if(speciality.hasSpecialAbilities())
				for (SpecialAbility sa : speciality.getSpecialAbilities())
					if(sa.isChoosable())
						l.add(sa.getName());
		return l;
	}

	public ArrayList<String> getTacticsList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("");
		for (Skill s : available_skills) {
			if (s.getName().equals("Tactics")) {
				l.add(s.getKeyName());
			}
		}
		return l;
	}

	public String getFlag() {
		return flag;
	}


// 	+++ SETTER +++

	public void rollAllCharacteristics() {
		//roll the dice for all Characteristics once
		setCharacteristicRoll(WEAPONSKILL, Functions.randomCharacteristicValue());
		setCharacteristicRoll(WEAPONSKILL, Functions.randomCharacteristicValue());
		setCharacteristicRoll(BALLISTICSKILL, Functions.randomCharacteristicValue());
		setCharacteristicRoll(STRENGTH, Functions.randomCharacteristicValue());
		setCharacteristicRoll(TOUGHNESS, Functions.randomCharacteristicValue());
		setCharacteristicRoll(AGILITY, Functions.randomCharacteristicValue());
		setCharacteristicRoll(INTELLIGENCE, Functions.randomCharacteristicValue());
		setCharacteristicRoll(PERCEPTION, Functions.randomCharacteristicValue());
		setCharacteristicRoll(WILLPOWER, Functions.randomCharacteristicValue());
		setCharacteristicRoll(FELLOWSHIP, Functions.randomCharacteristicValue());
		flag = "All Characteristics Rolled";

		setChanged();
		notifyObservers();
	}

	public void rerollCharacteristic(String characteristic) {
		setCharacteristicRoll(characteristic, Functions.randomCharacteristicValue());
		flag = "One Characteristic Rerolled";

		setChanged();
		notifyObservers();
	}

	public void setCharacteristicRoll(String name, int roll) {
		((Characteristic) Functions.getSpecific(characteristics, name)).setRoll(roll);
	}

	public void setChapter(String name) {
		//is there a chapter set?
		if (has_chapter) { //yes
			removeChapterCharacteristicBonus();
			removeChapterSoloModeAbility();
			//does the chapter has a talent?
			if (chapter.hasTalent()) //yes
				removeChapterTalents();
			removeAdvances("", CHAPTER);
		}

		//set the Chapter for the Character
		chapter = new Chapter((Chapter) Functions.getSpecific(available_chapters, name));
		has_chapter = true;
		for (Characteristic c : characteristics) {
			c.setChapterBonus(chapter.getBonus(c.getName()));
		}

		//look for Restricted Specialities
		if (chapter.hasRestrictions()) {
			ArrayList<Restriction> l = chapter.getRestrictions();
			for (Restriction r : l) {
				if (r.isSpeciality()) {
					//remove resticted Specialities from the Character
					if (has_speciality) {
						if (speciality.getName().equals(r.getSpeciality().getName())) {
							removeSpeciality();
						}
					}
				}
			}
		}else{ //there is no Speciality Restriction
			
		}

		//does the Chapter has a talent?
		if (chapter.hasTalent()) { //yes
			//does the Chapter talent already exist in the talent list?
			if (((Talent) Functions.getSpecific(talents, chapter.getTalent().getKeyName())) == null) { //no
				//add the talent
				talents.add(chapter.getTalent());
			}
		}
		solo_mode_abilities.add(chapter.getSoloModeAbility());

		flag = CHAPTER;
		setChanged();
		notifyObservers();
	}

	private void removeChapterCharacteristicBonus() {
		for (Characteristic c : characteristics) {
			c.setChapterBonus(0);
		}
	}

	private void removeChapterSoloModeAbility() {
		solo_mode_abilities.remove(chapter.getSoloModeAbility());
	}

	private void removeChapterTalents() {
		talents.remove(chapter.getTalent());
	}

	public void setSpeciality(String name) {
		if (has_speciality) {
			removeSpeciality();
		}

		speciality = new Speciality((Speciality) Functions.getSpecific(available_specialities, name));
		has_speciality = true;

		//does the speciality has skills?
		if (speciality.hasSkills()) { //yes
			for (Skill skill : speciality.getSkills()) {
				//does the speciality skill already exist in the skill list?
				if (((Skill) Functions.getSpecific(skills, skill.getKeyName())) == null) { //no
					//add the skill
					skills.add(skill);
				} else { //yes
					Skill s = (Skill) Functions.getSpecific(skills, skill.getKeyName());
					//is the Speciality Skill trained and the existing not?
					if (skill.isTrained() && !s.isTrained()) { //yes
				 		//set the Skill trained
				 		s.setTrained(true);
				 	}
				}
			}
		}

		//does the speciality has special abilities?
		if (speciality.hasSpecialAbilities()) {
			for (SpecialAbility sa : speciality.getSpecialAbilities()) {
				if (!sa.isChoosable()) {
					special_abilities.add(sa);
					if (sa.hasTrait()) {
						traits.add(sa.getTrait());
					}
					if (sa.hasTalents()) {
						for (Talent talent : sa.getTalents()) {
							talents.add(talent);
						}
					}
				}
			}
		}

		flag = SPECIALITY;
		setChanged();
		notifyObservers();
	}

	public void setSpecialAbility(String special_ability) {

		if (has_chosen_special_ability)
			removeChosenSpecialAbility();

		for (SpecialAbility sa : speciality.getSpecialAbilities()) {
			if (sa.getName().equals(special_ability)) {
				special_abilities.add(sa);
				chosen_special_ability = sa;
				has_chosen_special_ability = true;
				if (sa.hasTalents()) {
					for (Talent talent : sa.getTalents()) {
						talents.add(talent);
					}
				}
				if (sa.hasTrait())
					traits.add(sa.getTrait());
			}
		}

		flag = SPECIALABILITY;
		setChanged();
		notifyObservers();
	}

	public void removeSpeciality() {
		removeSpecialAbilities();
		removeSpecialitySkills();
		removeAdvances("", SPECIALITY);
		removeChosenSpecialAbility();
		speciality = null;
		has_speciality = false;
	}

	private void removeSpecialitySkills() {
		//does the Speciality has Skills?
		if (speciality.hasSkills()) { //yes
			for (Skill s : speciality.getSkills()) {
				Skill s1 = (Skill) Functions.getSpecific(starting_skills, s.getKeyName());
				Skill s2 = (Skill) Functions.getSpecific(skills, s.getKeyName());
				//did the skill already existed before?
				if (s1 != null) { //yes
					//is the skill trained and wasn't before?
					if (s2.isTrained() && !s1.isTrained()) { //yes
						//unset trained
						s2.setTrained(false);
					}
				} else { //no
					skills.remove(s2);
				}
			}
		}
	}

	private void removeSpecialAbilities() {
		if (speciality.hasSpecialAbilities()) {
			for (SpecialAbility sa : speciality.getSpecialAbilities()) {
				//does the Special Ability has Talents?
				if (sa.hasTalents()) { //yes
					//remove all Talents from the Talent list
					for (Talent talent : sa.getTalents()) {
						talents.remove(talent);
					}
				}
				//does the Special Ability has Traits?
				if (sa.hasTrait()) {
					//remove all Traits from the Traits list
					traits.remove(sa.getTrait());
				}
			}
		}
		//remove all Special Abilities
		special_abilities.clear();
	}

	private void removeChosenSpecialAbility() {
		for (SpecialAbility sa : speciality.getSpecialAbilities()) {
			if (sa.isChoosable()) {
				if (sa.hasTalents()) {
					for (Talent talent : sa.getTalents()) {
						talents.remove(talent);
					}
				}
				if (sa.hasTrait()) {
					//remove all Traits from the Traits list
					traits.remove(sa.getTrait());
				}
				special_abilities.remove(sa);
			}
		}
		chosen_special_ability = null; 
		has_chosen_special_ability = false;
	}

	public void setTactic(String tactic) {
		if (has_chosen_tactic)
			skills.remove(chosen_tactic);
		chosen_tactic = new Skill((Skill) Functions.getSpecific(available_skills, tactic));
		chosen_tactic.setTrained(true);
		skills.add(chosen_tactic);
		has_chosen_tactic = true;

		flag = "Tactic";
		setChanged();
		notifyObservers();
	}
	
	public void addAdvance(String key_name) {
		boolean duplicate = false;
		boolean changes_made = true;
		String classification = key_name.substring(key_name.indexOf("|")+1);
		Advance a = null;

		switch (classification) {
			case DEATHWATCH: 
				a = (Advance) Functions.getSpecific(available_deathwatch_advances, key_name);
				break;
			case SPACEMARINE: 
				a = (Advance) Functions.getSpecific(available_spacemarine_advances, key_name);
				break;
			case CHAPTER: 
				a = (Advance) Functions.getSpecific(chapter.getAdvances(), key_name);
				break;
			case SPECIALITY: 
				a = (Advance) Functions.getSpecific(speciality.getAdvances(), key_name);
				break;
			default:break;
		}

		for (Advance ea : advances) {
			//could the chosen Advance be a "duplicate" (they can still be two different advances with the same Skill, Talent,..., from a different list)
			if (ea.getName() == a.getName()) { //yes
				duplicate = true;
			}
		}
		//was a duplicate found?
		if (!duplicate) { //no
			//is the advance a skill?
			if (a.isSkill()) { //yes
				Skill s = a.getSkill();
				Skill es = (Skill) Functions.getSpecific(skills, s.getKeyName());
				//does the advance skill already exist in the skill list?
				if (es == null) { //no
					//add the new advance
					advances.add(a);
					//reduce xp
					CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
					xpr.setValue(xpr.getValue() - a.getCost());
					//add the skill
					skills.add(s);
				} else { //yes
					//is the Advance Skill trained and the existing not?
					if (s.isTrained() && !es.isTrained()) { //yes
						//add the new advance
						advances.add(a);
						//reduce xp
						CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
						xpr.setValue(xpr.getValue() - a.getCost());
				 		//set the Skill trained
				 		es.setTrained(true);
				 		// set the Skill Bonus
				 		es.setBonus(s.getBonus());
				 	//no, but is the bonus lower than the one existing?
				 	} else if (es.getBonus() < s.getBonus()) { //yes
				 		//add the new advance
						advances.add(a);
						//reduce xp
						CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
						xpr.setValue(xpr.getValue() - a.getCost());
				 		// set the higher Skill Bonus
				 		es.setBonus(s.getBonus());
				 	} else {
				 		changes_made = false;
				 	}
				}
			//no, but is it a talent?
			} else if (a.isTalent()) { //yes
				Talent t = a.getTalent();
				Talent et = (Talent) Functions.getSpecific(talents, t.getKeyName());
				//does the chapter talent already exist in the talent list?
				if (et == null) { //no
					//add the new advance
					advances.add(a);
					//add the talent
					CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
					xpr.setValue(xpr.getValue() - a.getCost());
					talents.add(t);
				} else {
					changes_made = false;
				}
			//no, but is it a characteristic bonus?
			} else if (a.isCharacteristicBonus()) { //yes
				Characteristic c = a.getCharacteristic();
				Characteristic ec = (Characteristic) Functions.getSpecific(characteristics, c.getName());
				//add the new advance
				advances.add(a);
				//add the talent
				CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
				xpr.setValue(xpr.getValue() - a.getCost());
				//set the Advance Bonus
				ec.setAdvanceBonus(c.getAdvanceBonus());
			}
		}
		if(changes_made){
			flag = "Advance";
			setChanged();
			notifyObservers();
		} else {
			flag = "Advances unchanged";
			setChanged();
			notifyObservers();
		}
	}

	public void removeAdvance(Advance a) {
		//was the Advance added to the list?
		if(advances.indexOf(a) != -1){
			//remove the Advance
			advances.remove(a);
			CharacterValue xpr = (CharacterValue) Functions.getSpecific(charactervalues, XPREST);
			xpr.setValue(xpr.getValue() + a.getCost());
			//is the advance a skill?
			if (a.isSkill()) { //yes
				Skill s = a.getSkill();
				//look for this skill in the starting_skills list
				Skill ss = (Skill) Functions.getSpecific(starting_skills, s.getKeyName());
				//look for this skill in the speciality skills list
				Skill sps = null;
				if(hasSpeciality()){
					if(speciality.hasSkills()){
						for (Skill skill : speciality.getSkills()) {
							if (skill.getKeyName().equals(s.getKeyName())) { //yes
								sps = skill;
							}
						}
					}
				}
				//get the actual skill to handle
				Skill es = (Skill) Functions.getSpecific(skills, s.getKeyName());

				//the skill was neither in the starting skills list nor in the speciality skills list
				if (ss == null && sps == null) {
					for(Skill rs : skills){
						if(rs.getKeyName() == s.getKeyName())
							s = rs;
					}
					skills.remove(s);
				//the skill is a starting skill but not a speciality skill
				}else if(ss != null && sps == null){
					if(!ss.isTrained())
						es.setTrained(false);
					if(es.getBonus() > 0)
						es.setBonus(0);
				//the skill is a speciality skill but not a starting skill
				}else if(ss == null && sps != null){
					if(es.getBonus() > 0)
						es.setBonus(0);
				//the skill is a speciality skill and a starting skill
				}else if(ss != null && sps != null){
					if(es.getBonus() > 0)
						es.setBonus(0);
				}
			//no, but is it a talent?
			} else if (a.isTalent()) { //yes
				talents.remove(a.getTalent());
			//no, but is it a characteristic bonus?
			} else if (a.isCharacteristicBonus()) { //yes
				Characteristic c = a.getCharacteristic();
				Characteristic ec = (Characteristic) Functions.getSpecific(characteristics, c.getName());
				ec.setAdvanceBonus(0);
			}
		}

		flag = "Advance";
		setChanged();
		notifyObservers();
	}

	public void removeAdvances(String name, String classification) {
		ArrayList<Advance> l = null;
		//is it necessary to iterate through a complete advancelist?
		if (name.isEmpty()) { //yes
			switch (classification) {
				case SPACEMARINE: 
					l = available_spacemarine_advances;
					break;
				case DEATHWATCH: 
					l = available_deathwatch_advances;
					break;
				case CHAPTER: 
					l = chapter.getAdvances();
					break;
				case SPECIALITY: 
					l = speciality.getAdvances();
					break;
				default: break;
			}
			for(Advance a : l)
				removeAdvance(a);
		} else { //no
			Advance a = (Advance) Functions.getSpecific(advances, name);
			removeAdvance(a);
		}
	}


	//	+++ HAS +++

	public boolean hasChapter() {
		return has_chapter;
	}

	public boolean hasSpeciality() {
		return has_speciality;
	}

	public boolean hasChosenSpecialAbility() {
		return has_chosen_special_ability;
	}
}