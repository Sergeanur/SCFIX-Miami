MISSION_START
// *****************************************************************************************
// ********************************* Finale mission 2  ************************************* 
// ************************************ Mob Attack *****************************************
// *****************************************************************************************
// *** The Mob decide to pay the player1 a personal visit.  The player1 has had enough of***
// *** the Mob's bullshit so decides to insult them by paying them off with the first 	 ***
// *** test run of the obviously counterfeit money.  This affront triggers the final 	 ***
// *** showdown! Before the player manages to kill the Mob at the meeting they call in   ***
// *** the backup.  The player1 will have to survive and suppress the Mob's attack, to 	 ***
// *** become the unchallenged ruler of the Miami crime scene.                           ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_finale2

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_finale2_failed
ENDIF

GOSUB mission_cleanup_finale2

MISSION_END

// Variables for mission
VAR_INT mafia_limo_1 mafia_limo_2 mafia_limo_3 player_score failed_finale_flag player_in_scripted_cutscene
VAR_INT armour_pickup python_pickup health_blip_added python_pickup2 dummy_player health_blip2
VAR_INT health_message at_safe_message stored_player_score health_blip safe_blip health_pickup2
VAR_INT stealing_from_safe_a stealing_from_safe_b audio_bit_flag player_at_mansion health_pickup_on_roof
VAR_INT barrel01 barrel02 barrel03 barrel04 barrel05 barrel06 barrel07 barrel08 barrel09 barrel10
VAR_INT barrel11 barrel12 barrel13 barrel14 barrel15 barrel16 barrel17 barrel18	barrel19 barrel20
VAR_FLOAT the_safe_x the_safe_y the_safe_z

VAR_INT vance vance_timer vance_flag avoid_a_nasty_crash_flag someone_taxing_safe crouch_timer
VAR_INT sonni sonni_timer sonni_flag hold_off_shooting_timer////flag_faded_out

VAR_INT	random_mafia random_mafia_flag random_mafia_timer random_mafia_cash	random_mafia_counter mafia_stuck_timer
VAR_FLOAT random_mafia_x random_mafia_y random_mafia_z mafia_stuck_x mafia_stuck_y mafia_stuck_z

VAR_INT credits_shot_counter credits_shot_timer
VAR_INT boss_guard1 boss_guard2 boss_guard3 boss_guard4 boss_guard5
VAR_INT boss_guard6 boss_guard7 boss_guard8 boss_guard9	boss_guard10 boss_guard11
VAR_INT boss_guard1_flag boss_guard1_timer
VAR_INT boss_guard2_flag boss_guard2_timer
VAR_INT boss_guard3_flag 
VAR_INT boss_guard4_flag 
VAR_INT boss_guard5_flag 
VAR_INT boss_guard6_flag 
VAR_INT boss_guard7_flag boss_guard7_timer
VAR_INT boss_guard8_flag 
VAR_INT boss_guard9_flag 
VAR_INT boss_guard10_flag 
VAR_INT boss_guard11_flag boss_guard11_timer
VAR_INT	mafia_1 mafia_1_timer mafia_1_cash mafia_1_flag mafia_1_stuck_timer
VAR_INT	mafia_2 mafia_2_timer mafia_2_cash mafia_2_flag mafia_2_stuck_timer
VAR_INT	mafia_3 mafia_3_timer mafia_3_cash mafia_3_flag mafia_3_stuck_timer
VAR_INT	mafia_4 mafia_4_timer mafia_4_cash mafia_4_flag mafia_4_stuck_timer
VAR_INT	mafia_5 mafia_5_timer mafia_5_cash mafia_5_flag mafia_5_stuck_timer
VAR_INT	mafia_6 mafia_6_timer mafia_6_cash mafia_6_flag mafia_6_stuck_timer
VAR_INT	mafia_7 mafia_7_timer mafia_7_cash mafia_7_flag mafia_7_stuck_timer
VAR_INT	mafia_8 mafia_8_timer mafia_8_cash mafia_8_flag mafia_8_stuck_timer
VAR_INT	mafia_9 mafia_9_timer mafia_9_cash mafia_9_flag mafia_9_stuck_timer
VAR_FLOAT mafia_6_stuck_x mafia_6_stuck_y mafia_6_stuck_z
VAR_FLOAT mafia_7_stuck_x mafia_7_stuck_y mafia_7_stuck_z
VAR_FLOAT mafia_8_stuck_x mafia_8_stuck_y mafia_8_stuck_z
VAR_FLOAT mafia_9_stuck_x mafia_9_stuck_y mafia_9_stuck_z

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_INT game_timer temp_int
//VAR_FLOAT heading

// ****************************************Mission Start************************************

mission_start_finale2:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME FIN_1

WAIT 0
{
LVAR_FLOAT mafia_1_stuck_x mafia_1_stuck_y mafia_1_stuck_z
LVAR_FLOAT mafia_2_stuck_x mafia_2_stuck_y mafia_2_stuck_z
LVAR_FLOAT mafia_3_stuck_x mafia_3_stuck_y mafia_3_stuck_z
LVAR_FLOAT mafia_4_stuck_x mafia_4_stuck_y mafia_4_stuck_z
LVAR_FLOAT mafia_5_stuck_x mafia_5_stuck_y mafia_5_stuck_z

IF NOT flag_baron_mission5_passed = 1 // SCFIX: this object doesn't exist normally, might delete something else
	DELETE_OBJECT mansion_closed//DEBUG!!!!!!!!!!
ENDIF // SCFIX

LOAD_MISSION_TEXT FINALE
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0

the_safe_x = -373.2288 
the_safe_y = -597.0028
the_safe_z = 24.7818

vance_timer = 0
vance_flag = -1
sonni_timer = 0
sonni_flag = 0

random_mafia = -1
random_mafia_flag = 0
random_mafia_timer = 0
random_mafia_cash = 0
random_mafia_counter = 0

random_mafia_x = 0.0
random_mafia_y = 0.0
random_mafia_z = 0.0

mafia_1 = -1
mafia_1_timer = 0
mafia_1_cash = 0
mafia_1_flag = 0

mafia_2 = -1
mafia_2_timer = 0
mafia_2_cash = 0
mafia_2_flag = 0

mafia_3 = -1
mafia_3_timer = 0
mafia_3_cash = 0
mafia_3_flag = 0

mafia_4 = -1
mafia_4_timer = 0
mafia_4_cash = 0
mafia_4_flag = 0

mafia_5 = -1
mafia_5_timer = 0
mafia_5_cash = 0
mafia_5_flag = 0

mafia_6 = -1
mafia_6_timer = 0
mafia_6_cash = 0
mafia_6_flag = 0

mafia_7 = -1
mafia_7_timer = 0
mafia_7_cash = 0
mafia_7_flag = 0

mafia_8 = -1
mafia_8_timer = 0
mafia_8_cash = 0
mafia_8_flag = 0

mafia_9 = -1
mafia_9_timer = 0
mafia_9_cash = 0
mafia_9_flag = 0

player_score = 0
health_message = 0
at_safe_message = 0
health_blip_added = 0
failed_finale_flag = 0

stealing_from_safe_a = 0
stealing_from_safe_b = 0

audio_bit_flag = 0
player_at_mansion = 0

boss_guard1_flag = 0
boss_guard2_flag = 0
boss_guard3_flag = 0
boss_guard4_flag = 0
boss_guard5_flag = 0
boss_guard6_flag = 0
boss_guard7_flag = 0
boss_guard8_flag = 0
boss_guard9_flag = 0
boss_guard10_flag = 0
boss_guard11_flag = 0

mafia_1_stuck_timer = 0
mafia_2_stuck_timer = 0
mafia_3_stuck_timer = 0
mafia_4_stuck_timer = 0
mafia_5_stuck_timer = 0
mafia_6_stuck_timer = 0
mafia_7_stuck_timer = 0
mafia_8_stuck_timer = 0
mafia_9_stuck_timer = 0

mafia_1_stuck_x	= 0.0
mafia_1_stuck_y = 0.0
mafia_1_stuck_z = 0.0

mafia_2_stuck_x	= 0.0
mafia_2_stuck_y = 0.0
mafia_2_stuck_z = 0.0

mafia_3_stuck_x	= 0.0
mafia_3_stuck_y = 0.0
mafia_3_stuck_z = 0.0

mafia_4_stuck_x	= 0.0
mafia_4_stuck_y = 0.0
mafia_4_stuck_z = 0.0

mafia_5_stuck_x	= 0.0
mafia_5_stuck_y = 0.0
mafia_5_stuck_z = 0.0

mafia_6_stuck_x	= 0.0
mafia_6_stuck_y = 0.0
mafia_6_stuck_z = 0.0

mafia_7_stuck_x	= 0.0
mafia_7_stuck_y = 0.0
mafia_7_stuck_z = 0.0

mafia_8_stuck_x	= 0.0
mafia_8_stuck_y = 0.0
mafia_8_stuck_z = 0.0

mafia_9_stuck_x	= 0.0
mafia_9_stuck_y = 0.0
mafia_9_stuck_z = 0.0

avoid_a_nasty_crash_flag = 0

player_in_scripted_cutscene = 0
credits_shot_counter = 0
credits_shot_timer = 0
hold_off_shooting_timer = 0
someone_taxing_safe = 0
crouch_timer = 0
//flag_faded_out = 0

STORE_SCORE player1 stored_player_score

SET_AREA_VISIBLE VIS_MANSION
flag_player_in_mansion = 1
SWITCH_PED_ROADS_OFF -522.414 -662.451 -9.357 -222.414 -502.451 90.643 // ENTIRE MANSION AREA

flag_player_on_finale = 1 // SCFIX


SWITCH_RUBBISH OFF
SET_EXTRA_COLOURS 7 FALSE
SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA -354.419 -569.529 30.0 200.0 0 

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 csken
LOAD_SPECIAL_CHARACTER 3 csbuddy

LOAD_SCENE -378.4660 -596.1799 24.7818

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE

LOAD_UNCOMPRESSED_ANIM csplay
LOAD_UNCOMPRESSED_ANIM csken
LOAD_UNCOMPRESSED_ANIM csbuddy
LOAD_CUTSCENE FIN

SET_NEAR_CLIP 0.1
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken csken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy csbuddy

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1085
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_01 10000 1 //What's going on?
 
WHILE cs_time < 1924
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_02 10000 1 //Tommy! Oh  Good, listen. Uh, listen,
 
WHILE cs_time < 5027
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_03 10000 1 //I like fish. I love fish.
 
WHILE cs_time < 7525
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_04 10000 1 //I love them as a pet in the bowls, or as food on the plate, 
 
WHILE cs_time < 10739
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_05 10000 1 //but as much as I love em, I don't want to sleep with them. 
 
WHILE cs_time < 13469
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_06 10000 1 //Okay, but right now your Italian brothers are coming from up there to fit me with these cement shoes, and I...
 
WHILE cs_time < 19005
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_07 10000 1 //Shut up Ken. Sit down. 
 
WHILE cs_time < 24137
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_08 10000 1 //Lance, what the hell's going on?
 
WHILE cs_time < 26080
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_09 10000 1 //It's your friends up north Tommy. They ain't too happy you capped their man. 
 
WHILE cs_time < 30104
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_10 10000 1 //They're coming down to see the business today.
 
WHILE cs_time < 32108
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_11 10000 1 //They took longer than I thought... 
 
WHILE cs_time < 34187
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_12 10000 1 //Guys, we gotta make this final, we gotta leave no doubt that this is my operation. 
 
WHILE cs_time < 39927
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_13 10000 1 //Ken, get the first run of counterfeit cash and put about 3 mil in brief cases. 
 
WHILE cs_time < 45104
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN1_14 10000 1 //Lance, you get the guys together...
 
WHILE cs_time < 52998//47936
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 csken
LOAD_SPECIAL_CHARACTER 3 csbuddy
LOAD_SPECIAL_CHARACTER 4 cssonny
LOAD_SPECIAL_CHARACTER 5 sfrenda
LOAD_SPECIAL_CHARACTER 6 sgoona
LOAD_SPECIAL_CHARACTER 7 sgoonb
LOAD_SPECIAL_MODEL CUTOBJ01 delcase

LOAD_SCENE -378.4660 -596.1799 24.7818

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
OR NOT HAS_SPECIAL_CHARACTER_LOADED 6
	WAIT 0
ENDWHILE

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 7
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0
ENDWHILE

LOAD_CUTSCENE FIN_2

SET_NEAR_CLIP 0.1
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken csken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy csbuddy

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sonny
SET_CUTSCENE_ANIM cs_sonny cssonny

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_sfrenda
SET_CUTSCENE_ANIM cs_sfrenda sfrenda

CREATE_CUTSCENE_OBJECT SPECIAL06 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona sgoona

CREATE_CUTSCENE_OBJECT SPECIAL07 cs_sgoonb
SET_CUTSCENE_ANIM cs_sgoonb sgoonb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara delcase

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3853
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_01 10000 1 //Tommy! 
 
WHILE cs_time < 6297
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_02 10000 1 //What? No big hugs for your old buddy?
 
WHILE cs_time < 8417
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_03 10000 1 //I've had fifteen years out of the loop; 
 
WHILE cs_time < 10472
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_04 10000 1 //I'm a bit rusty on family etiquette.
 
WHILE cs_time < 12387
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_05 10000 1 //Always angry, eh Tommy. 
 
WHILE cs_time < 13627
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_06 10000 1 //Didn't I say your temper would get you into trouble, huh?
 
WHILE cs_time < 16943
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_07 10000 1 //There's twenty mil in the cases.......
 
WHILE cs_time < 18730
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_08 10000 1 //How many was it? Ten? No, eleven men.

WHILE cs_time < 22330
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_09 10000 1 //That's how you get to be called the Harwood Butcher! Heh-heh-heh!
 
WHILE cs_time < 25267
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_10 10000 1 //You sent me to kill one man, ONE MAN. They knew I was coming Sonny....
 
WHILE cs_time < 30987
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_11 10000 1 //Watch your tone.
 
WHILE cs_time < 32780
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_12 10000 1 //Anyone would think you blame me for that unfortunate set of circumstances.
 
WHILE cs_time < 36617
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_13 10000 1 //just take the money....
 
WHILE cs_time < 37728
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_14 10000 1 //Get the damn cash?
 
WHILE cs_time < 40994
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_15 10000 1 //You know, Tommy? I did what I could for you, I pulled strings, called in favors.
 
WHILE cs_time < 45718
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_16 10000 1 //I was your friend, Tommy. I hoped you'd see sense, see what's good for business. 
 
WHILE cs_time < 49615
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_17 10000 1 //I trusted you, Tommy, and you disappointed me.
 
WHILE cs_time < 53574
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_18 10000 1 //But at least someone in your chicken shit organization knows how to do business,
 
WHILE cs_time < 58188
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_19 10000 1 //Isn't that right, Lance?
 
WHILE cs_time < 60272
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_20 10000 1 //I'm sorry Tommy. This is Vice City. This is business.
 
WHILE cs_time < 66249
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_21 10000 1 //You sold us out...
 
WHILE cs_time < 68133
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_22 10000 1 //No. I sold YOU out, Tommy, I sold YOU out.
 
WHILE cs_time < 73431
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_23 10000 1 //The real cash is upstairs in the safe.
 
WHILE cs_time < 76741
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_24 10000 1 //So Tommy, what was the big plan?
 
WHILE cs_time < 78116
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_25 10000 1 //Did you think I'd just take the fake cash? 
 
WHILE cs_time < 80094
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_26 10000 1 //Save face and run away with my little tail between my legs?!
 
WHILE cs_time < 83916
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_27 10000 1 //No.
 
WHILE cs_time < 84910
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN2_28 10000 1 //I just wanted to piss you off before I kill you.

WHILE cs_time < 86980//87568
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
UNLOAD_SPECIAL_CHARACTER 6
UNLOAD_SPECIAL_CHARACTER 7
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

SET_PED_DENSITY_MULTIPLIER 1.0
CLEAR_AREA -354.419 -569.529 30.0 200.0 0 

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

//IF IS_BUTTON_PRESSED PAD2 DPADUP//DEBUG!!!!!!!!!!
//	GOTO final_cutscene			//DEBUG!!!!!!!!!!
//ENDIF							//DEBUG!!!!!!!!!!

REQUEST_MODEL STRETCH
REQUEST_MODEL RUGER
//REQUEST_MODEL KNIFECUR
REQUEST_MODEL TEC9
REQUEST_MODEL COLT45
LOAD_SPECIAL_CHARACTER 1 IGBUDDY
LOAD_SPECIAL_CHARACTER 2 IGSONNY
LOAD_SPECIAL_CHARACTER 3 MBA
LOAD_SPECIAL_CHARACTER 4 MBB

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED STRETCH
OR NOT HAS_MODEL_LOADED TEC9
OR NOT HAS_MODEL_LOADED RUGER
OR NOT HAS_MODEL_LOADED COLT45
//OR NOT HAS_MODEL_LOADED KNIFECUR
	WAIT 0
ENDWHILE

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0
ENDWHILE

//dirty commands
SET_ZONE_PED_INFO GANG1 DAY   (14) 0 0 300 0 0 0 700 0 0 0  // Mansion
SET_ZONE_PED_INFO GANG1 NIGHT (14) 0 0 300 0 0 0 700 0 0 0
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_PLAYER THREAT_GANG_STREET
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_GANG_PLAYER
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_PLAYER1
SET_GANG_WEAPONS GANG_PLAYER WEAPONTYPE_PISTOL WEAPONTYPE_PISTOL
SET_GANG_WEAPONS GANG_STREET WEAPONTYPE_PISTOL WEAPONTYPE_PISTOL
SET_GANG_PED_MODELS GANG_STREET SPECIAL03 SPECIAL04
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG scplayer GANG_PLAYER FALSE
//dirty commands

SET_AREA_VISIBLE VIS_MANSION
flag_player_in_mansion = 1
SWITCH_RUBBISH OFF
SET_EXTRA_COLOURS 7 FALSE
LOAD_SCENE -378.4660 -596.1799 24.7818

SET_THREAT_REACTION_RANGE_MULTIPLIER 2.0

CLEAR_AREA -378.4660 -596.1799 24.7818 1.0 TRUE
SET_PLAYER_COORDINATES player1 -378.4660 -596.1799 24.7818
SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER
GET_PLAYER_HEALTH player1 temp_int
IF NOT temp_int > 100
	SET_PLAYER_HEALTH player1 100
ENDIF
ADD_ARMOUR_TO_PLAYER player1 200

CREATE_CAR STRETCH -386.1734 -515.6445 11.7682 mafia_limo_1//west limo (1st)
SET_CAR_HEADING mafia_limo_1 123.5502
SET_CAR_ONLY_DAMAGED_BY_PLAYER mafia_limo_1 TRUE

CREATE_CAR STRETCH -375.7929 -514.4023 11.7776 mafia_limo_2//centre limo (2nd)
SET_CAR_HEADING mafia_limo_2 75.6302 
SET_CAR_ONLY_DAMAGED_BY_PLAYER mafia_limo_2 TRUE

CREATE_CAR STRETCH -366.1754 -517.2399 11.7561  mafia_limo_3//east limo	(3rd)
SET_CAR_HEADING mafia_limo_3 60.5286
SET_CAR_ONLY_DAMAGED_BY_PLAYER mafia_limo_3 TRUE

CAR_SET_IDLE mafia_limo_1
CAR_SET_IDLE mafia_limo_2
CAR_SET_IDLE mafia_limo_3
SET_CAR_MISSION	mafia_limo_1 MISSION_STOP_FOREVER
SET_CAR_MISSION	mafia_limo_2 MISSION_STOP_FOREVER
SET_CAR_MISSION	mafia_limo_3 MISSION_STOP_FOREVER

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

GOTO finale_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 random_mafia
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_1
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_2
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_3
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_4
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_5
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_6
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_7
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_8
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 mafia_9
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard1
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard2
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard3
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard4
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard5
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard6
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard7
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard8
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard9
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard10
	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 boss_guard11
	CREATE_PICKUP HEALTH PICKUP_ON_STREET -336.6208 -568.9940 11.6022 health_pickup
	CREATE_PICKUP BODYARMOUR PICKUP_ON_STREET -336.6208 -570.9940 11.6022 armour_pickup
	CREATE_PICKUP_WITH_AMMO TEC9 PICKUP_ON_STREET 120 -336.6208 -572.9940 11.6022 python_pickup
	CREATE_PICKUP_WITH_AMMO TEC9 PICKUP_ON_STREET 120 -336.6208 -572.9940 11.6022 python_pickup2
	CREATE_PICKUP HEALTH PICKUP_ON_STREET -336.6208 -568.9940 11.6022 health_pickup2
	CREATE_PICKUP HEALTH PICKUP_ON_STREET -336.6208 -568.9940 11.6022 health_pickup_on_roof
finale_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

REMOVE_PICKUP health_pickup
REMOVE_PICKUP armour_pickup
REMOVE_PICKUP python_pickup
REMOVE_PICKUP python_pickup2
CREATE_PICKUP HEALTH PICKUP_ON_STREET            -406.2503 -566.4947 19.5804 health_pickup
CREATE_PICKUP BODYARMOUR PICKUP_ON_STREET        -406.2992 -564.5820 19.5804 armour_pickup
CREATE_PICKUP_WITH_AMMO PYTHON PICKUP_ON_STREET 120 -401.7512 -566.0168 19.5804 python_pickup
CREATE_PICKUP_WITH_AMMO PYTHON PICKUP_ONCE 120 -374.4366 -587.5957 25.3355 python_pickup2

GET_GAME_TIMER game_timer
vance_timer	= game_timer + 60000
sonni_timer	= game_timer + 120000

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW FIN_B3 5000 1//~g~The Mafia are trying to steal your money. Defend the safe.

STORE_SCORE player1 stored_player_score

SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000

//SCARFACE ROOM AREA
//-386.507 -600.089 24.286 -370.542 -583.413 31.667
//-378.671 -591.947 28.17 8.5 8.5 4.0
//LOCATE TO CREATE BUDDY & SONNI
//IF LOCATE_PLAYER_ANY_MEANS_3D player1 -378.671 -588.595 28.17 8.5 13.0 4.0 0



//SECURITY CAMERA COORDINATES
//-361.3727 -582.8584 32.6401 -361.9797 -582.1804 32.2257 
//-382.2143 -554.8763 22.9362 -381.9367 -554.0642 22.4229 
//-371.1070 -598.7102 31.8273 -371.7275 -598.1949 31.2361 
//-398.9712 -567.0131 21.9549 -399.7347 -566.4696 21.6064 
//-315.8591 -583.2792 22.6796 -316.4446 -582.8118 22.0173 


//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
mission_finale2_loop://///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

WAIT 0

GET_GAME_TIMER game_timer
//SET_PLAYER_HEALTH player1 100

IF LOCATE_PLAYER_ANY_MEANS_3D PLAYER1 -354.419 -569.529 30.0 200.0 120.0 30.0 0	//HUGE MANSION LOCATE
	ALTER_WANTED_LEVEL player1 0
	IF player_at_mansion = 0
		player_at_mansion =	1
	ENDIF
ELSE
	IF player_at_mansion = 1
		player_at_mansion = 0
	ENDIF
ENDIF

IF NOT IS_PLAYER_HEALTH_GREATER player1 70
	IF health_message = 1
		PRINT_NOW FIN_B4 6000 1//"~g~You are close to death, get some ~w~health~g~ from downstairs."
		IF health_blip_added = 0
			ADD_BLIP_FOR_COORD -406.2503 -566.4947 19.5804 health_blip
			CHANGE_BLIP_COLOUR health_blip WHITE
			ADD_BLIP_FOR_COORD -335.6250 -571.7700 11.0 health_blip2
			CHANGE_BLIP_COLOUR health_blip2 WHITE
			health_blip_added = 1
		ENDIF
		health_message = 0
	ENDIF
ELSE
	IF health_message = 0
		health_message = 1
	ENDIF
ENDIF

IF mafia_1_flag = 2
OR mafia_2_flag = 2
OR mafia_3_flag = 2
OR mafia_4_flag = 2
OR mafia_5_flag = 2
	stealing_from_safe_a = 1
ELSE
	stealing_from_safe_a = 0
ENDIF

IF mafia_6_flag = 2
OR mafia_7_flag = 2
OR mafia_8_flag = 2
OR mafia_9_flag = 2
	stealing_from_safe_b = 1
ELSE
	stealing_from_safe_b = 0
ENDIF

IF stealing_from_safe_a = 1
OR stealing_from_safe_b = 1
	IF at_safe_message = 1
		PRINT_NOW FIN_B5 5000 1//~g~Someone is taxing your money, protect the ~c~safe
		ADD_BLIP_FOR_COORD the_safe_x the_safe_y the_safe_z safe_blip
		CHANGE_BLIP_COLOUR safe_blip CYAN
		at_safe_message = 0
	ENDIF
ELSE
	IF at_safe_message = 0
		REMOVE_BLIP	safe_blip
		at_safe_message = 1
	ENDIF
ENDIF

IF vance_flag = -1
	IF game_timer >	vance_timer
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -378.523 -579.67 27.284 6.0 4.0 3.0 0//OUTSIDE SCARFACE ROOM LOCATE
			vance_flag = 0
		ELSE
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -378.551 -591.784 28.232 8.114 8.0 3.44 0//INSIDE SCARFACE ROOM LOCATE
				PRINT_NOW FIN_B1 200 1//Kill the backstabber ~y~Lance Vance~g~.
			ELSE
				PRINT_NOW DEFSAFE 200 1//Get back to the safe and defend it.
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF vance_flag = 0
	//IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -357.6711 -559.5632 26.5411 1.0 1.0 2.0
	//OR NOT IS_POINT_ON_SCREEN -357.6711 -559.5632 26.5411 3.0
		DELETE_CHAR mafia_1
		DELETE_CHAR mafia_2
		DELETE_CHAR mafia_3
		DELETE_CHAR mafia_4
		DELETE_CHAR mafia_5
		DELETE_CHAR mafia_6
		DELETE_CHAR mafia_7
		DELETE_CHAR mafia_8
		DELETE_CHAR mafia_9
		
		DELETE_CHAR boss_guard1
		DELETE_CHAR boss_guard2
		DELETE_CHAR boss_guard3
		DELETE_CHAR boss_guard4
		DELETE_CHAR boss_guard5
		DELETE_CHAR boss_guard6											
		DELETE_CHAR boss_guard7
		DELETE_CHAR boss_guard8
		DELETE_CHAR boss_guard9
		DELETE_CHAR boss_guard10
		DELETE_CHAR boss_guard11
	
		CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 -357.6711 -559.5632 26.5411 vance
		GOSUB set_up_vance_shite
		//ADD_BLIP_FOR_CHAR vance vance_blip
		//CHANGE_BLIP_COLOUR vance_blip YELLOW
		LOAD_MISSION_AUDIO 1 FIN_3//Lance:  No one to cover your ass now, eh Tommy?
		LOAD_MISSION_AUDIO 2 FIN_1B//Player: Youre going down, you back stabbing prick!
		SET_CHAR_OBJ_RUN_TO_COORD vance	-362.1062 -559.4869
		SET_CHAR_USE_PEDNODE_SEEK vance FALSE
	
		SET_PLAYER_CONTROL player1 OFF
		SET_EVERYONE_IGNORE_PLAYER player1 TRUE
		SWITCH_WIDESCREEN ON
		SET_ALL_CARS_CAN_BE_DAMAGED FALSE

		player_in_scripted_cutscene = 1
		
		CLEAR_AREA -378.0434 -579.1422 18.5385 2.0 1
		SET_PLAYER_COORDINATES player1 -378.0434 -579.1422 18.5385
		
		CREATE_CHAR	PEDTYPE_CIVMALE NULL -378.4288 -582.1033 24.2735 dummy_player
		GIVE_WEAPON_TO_CHAR	dummy_player WEAPONTYPE_PYTHON 9
//		SET_CHAR_HEADING dummy_player 168.0084
		TURN_CHAR_TO_FACE_CHAR dummy_player	vance
		CLEAR_CHAR_THREAT_SEARCH dummy_player
		SHUT_CHAR_UP dummy_player TRUE
		SET_FIXED_CAMERA_POSITION -379.2380 -583.7946 26.1261 0.0 0.0 0.0//FROM SCARFACE ROOM AT PLAYER & BUDDY
		POINT_CAMERA_AT_POINT -378.7026 -582.9524 26.0619 JUMP_CUT

		vance_flag = 1
	//ENDIF
ENDIF

IF vance_flag > 0
	IF NOT IS_CHAR_DEAD	vance
		IF vance_flag < 12
		AND vance_flag > 4
			IF vance_timer < game_timer
				PRINT_NOW FIN_B1 5000 1//Kill the backstabber ~y~Lance Vance~g~.
				vance_timer = game_timer + 10000
			ENDIF
		ENDIF
		IF vance_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D vance	-362.1062 -559.4869	1.0 1.0 0
				IF HAS_MISSION_AUDIO_LOADED 1
					IF NOT IS_CHAR_DEAD dummy_player
						SET_CHAR_OBJ_AIM_GUN_AT_CHAR vance dummy_player
					ENDIF
					PLAY_MISSION_AUDIO 1
					PRINT_NOW FIN_3 5000 1//Lance:  No one to cover your ass now, eh Tommy?
					//SET_CHAR_WAIT_STATE scplayer WAITSTATE_CROSS_ROAD_LOOK 900
					vance_timer	= game_timer + 500//1000
					vance_flag = 2
				ENDIF
			ENDIF
		ENDIF
		
		IF vance_flag = 2
			IF vance_timer < game_timer
				IF NOT IS_CHAR_DEAD dummy_player
					GET_CHAR_HEADING dummy_player player_heading
				ENDIF
				player_heading += 12.0
				IF player_heading > 325.2151
					player_heading = 325.2151
					IF HAS_MISSION_AUDIO_FINISHED 1
					AND HAS_MISSION_AUDIO_LOADED 2
						PLAY_MISSION_AUDIO 2
						PRINT_NOW FIN_1b 5000 1//Player: Youre going down, you back stabbing prick!
						IF NOT IS_CHAR_DEAD dummy_player
							SET_CHAR_OBJ_AIM_GUN_AT_CHAR dummy_player vance
						ENDIF
						LOAD_MISSION_AUDIO 1 FIN_2b	//Lance:  Oh you think so!
						vance_flag = 3
					ENDIF
				ENDIF
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_HEADING dummy_player player_heading
					STOP_CHAR_LOOKING dummy_player
					CHAR_LOOK_AT_CHAR_ALWAYS dummy_player vance
				ENDIF
			ENDIF
		ENDIF

		IF vance_flag = 3
			IF HAS_MISSION_AUDIO_FINISHED 2
			AND	HAS_MISSION_AUDIO_LOADED 1
				//SET_FIXED_CAMERA_POSITION -363.5046 -557.9782 27.5867 0.0 0.0 0.0
				//POINT_CAMERA_AT_POINT -363.4895 -558.9763 27.6460 JUMP_CUT
				SET_FIXED_CAMERA_POSITION -362.8571 -557.6577 28.1980 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -362.9028 -558.6328 27.9812 JUMP_CUT
				PLAY_MISSION_AUDIO 1
				PRINT_NOW FIN_2b 5000 1//Lance:  Oh you think so!
				LOAD_MISSION_AUDIO 2 FIN_1a	//Player: Come here you double-crossing piece of shit!
				IF NOT IS_CHAR_DEAD dummy_player
					STOP_CHAR_LOOKING dummy_player
				ENDIF
				vance_timer	= game_timer + 1100
				vance_flag = 4
			ENDIF
		ENDIF
		IF vance_flag = 4
			IF HAS_MISSION_AUDIO_FINISHED 1
				IF vance_timer < game_timer
					SET_CHAR_OBJ_NO_OBJ scplayer
					LOAD_MISSION_AUDIO 1 FIN_4 //Lance:  Youre history, Tommy, history
					vance_flag = 5
				ENDIF
			ENDIF
		ENDIF
		IF vance_flag = 5
			IF avoid_a_nasty_crash_flag = 2
				DELETE_CHAR dummy_player
				CLEAR_AREA -378.4288 -582.1033 24.2735 2.0 1
				SET_PLAYER_COORDINATES player1 -378.4288 -582.1033 24.2735//TOP OF STAIRS
				SET_PLAYER_HEADING player1 player_heading
				
				SET_PLAYER_CONTROL player1 ON
				SET_PLAYER_HEALTH player1 200
				ADD_ARMOUR_TO_PLAYER player1 200
				SET_EVERYONE_IGNORE_PLAYER player1 FALSE
				SWITCH_WIDESCREEN OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SET_CAMERA_BEHIND_PLAYER
				RESTORE_CAMERA_JUMPCUT
				hold_off_shooting_timer = game_timer + 400				
				player_in_scripted_cutscene = 0

				PRINT_NOW FIN_B1 10000 1//Kill the backstabber ~y~Lance Vance~g~.
			ENDIF
			avoid_a_nasty_crash_flag ++
			IF avoid_a_nasty_crash_flag > 2
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				OR LOCATE_PLAYER_ANY_MEANS_3D player1 -378.523 -561.41 29.034 18.0 6.0 2.5 0
					SET_CHAR_OBJ_SPRINT_TO_COORD vance -335.4508 -560.4796
					SET_CHAR_USE_PEDNODE_SEEK vance FALSE
					vance_flag = 6
				ELSE
					IF hold_off_shooting_timer < game_timer
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT vance player1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF vance_flag = 6
			IF LOCATE_CHAR_ON_FOOT_2D vance -347.6153 -559.3744 2.0 2.0 0
				DELETE_CHAR	vance
				CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 -335.4508 -560.4796 26.5380 vance
				GOSUB set_up_vance_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT vance player1
				vance_flag = 7
			ENDIF
		ENDIF
		IF vance_flag = 7
			IF IS_CHAR_SHOOTING	vance
				//vance_timer	= game_timer + 1000
				vance_flag = 8
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -347.4754 -559.3594 27.5816 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				//vance_timer	= game_timer - 1000
				vance_flag = 8
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				vance_timer	= -9999
				vance_flag = 12
			ENDIF
		ENDIF
		IF vance_flag = 8
			//IF vance_timer < game_timer
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -347.4754 -559.3594 27.5816 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				SET_CHAR_OBJ_SPRINT_TO_COORD vance -334.3681 -579.2608
				SET_CHAR_USE_PEDNODE_SEEK vance FALSE
				vance_flag = 9
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				vance_timer	= -9999
				vance_flag = 12
			ENDIF
		ENDIF
		IF vance_flag = 9
			IF LOCATE_CHAR_ON_FOOT_2D vance -336.1350 -567.6742 2.0 2.0 0
				DELETE_CHAR	vance
				CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 -334.3681 -579.2608 26.5109 vance
				GOSUB set_up_vance_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT vance player1
				vance_flag = 10
			ENDIF
		ENDIF
		IF vance_flag = 10
			IF IS_CHAR_SHOOTING	vance
				//vance_timer	= game_timer + 1000
				vance_flag = 11
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -336.1548 -565.9336 27.5698 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				//vance_timer	= game_timer - 1000
				vance_flag = 11
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				vance_timer	= -9999
				vance_flag = 12
			ENDIF
		ENDIF
		IF vance_flag = 11
			//IF vance_timer < game_timer
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -336.1548 -565.9336 27.5698 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				SET_CHAR_OBJ_SPRINT_TO_COORD vance -325.5564 -578.9694
				SET_CHAR_USE_PEDNODE_SEEK vance FALSE
				vance_flag = 12
			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				vance_timer	= -9999
				vance_flag = 12
			ENDIF
		ENDIF
		IF vance_flag = 12
			IF LOCATE_CHAR_ON_FOOT_2D vance -330.0031 -578.9820 2.0 2.0 0
			OR vance_timer = -9999
				DELETE_CHAR	vance
				CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 -317.6072 -580.8336 32.5255 vance
				SET_CHAR_HEADING vance 80.6458
				SET_CHAR_CROUCH	vance TRUE 999999
				GOSUB set_up_vance_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT vance player1
				vance_flag = 13
			ENDIF
		ENDIF
		IF vance_flag = 13
//			IF IS_CHAR_SHOOTING	vance
//				vance_timer	= game_timer + 1000
//				vance_flag = 14
//				SET_CHAR_CROUCH	vance FALSE 200
//				IF audio_bit_flag = 0
//					audio_bit_flag = 1
//				ENDIF
//			ENDIF
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -323.0355 -573.3547 28.5367 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				SET_CHAR_CROUCH	vance FALSE 200
				vance_timer	= game_timer - 1000
				vance_flag = 14
				IF audio_bit_flag = 0
					audio_bit_flag = 1
				ENDIF
			ENDIF
		ENDIF
		IF vance_flag = 14
			//IF vance_timer < game_timer
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -323.0355 -573.3547 28.5367 2.0 2.0 2.0 0//END OF CORRIDOR UPSTAIRS
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.993 -578.541 20.332 3.134 1.732 1.81 0//OTHER END OF CORRIDOR DOWNSTAIRS
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
			OR LOCATE_PLAYER_ANY_MEANS_3D player1 -330.8983 -578.8625 11.6069 2.0 2.0 2.0 0
				SET_CHAR_CROUCH	vance FALSE 200
				SET_CHAR_OBJ_SPRINT_TO_COORD vance -318.4535 -583.2459//BACK OF STAIRS
				SET_CHAR_USE_PEDNODE_SEEK vance FALSE
				IF audio_bit_flag = 0
					audio_bit_flag = 1
				ENDIF
				vance_flag = 15
			ENDIF
		ENDIF

		IF vance_flag = 15
			IF LOCATE_CHAR_ON_FOOT_2D vance -318.4535 -583.2459	1.0 1.0 0
				SET_CHAR_OBJ_SPRINT_TO_COORD vance -330.3770 -582.4593//TOP OF STAIRS ON CORNER
				SET_CHAR_USE_PEDNODE_SEEK vance FALSE
				vance_flag = 16
			ENDIF
		ENDIF
		
		IF vance_flag = 16
			IF LOCATE_CHAR_ON_FOOT_2D vance -330.3770 -582.4593	1.0 1.0 0
				SET_CHAR_OBJ_SPRINT_TO_COORD vance -330.2176 -576.3726//END OF CORRIDOR LEADING TO ROOF
				SET_CHAR_USE_PEDNODE_SEEK vance FALSE
				vance_flag = 17
			ENDIF
		ENDIF

		IF vance_flag > 4
		AND vance_flag < 18
			GET_PLAYER_COORDINATES player1 player_x player_y player_z
			IF player_z > 35.9013
				vance_timer = -9999
				vance_flag = 17
			ENDIF
		ENDIF
		
		IF vance_flag = 17
			IF LOCATE_CHAR_ON_FOOT_2D vance -330.2176 -576.3726 2.0 2.0 0
			OR vance_timer = -9999
				DELETE_CHAR boss_guard1
				DELETE_CHAR boss_guard2
				DELETE_CHAR boss_guard3
				DELETE_CHAR boss_guard4
				DELETE_CHAR boss_guard5
				DELETE_CHAR boss_guard6
				DELETE_CHAR boss_guard7
				DELETE_CHAR boss_guard8
				DELETE_CHAR boss_guard9
				DELETE_CHAR boss_guard10
				DELETE_CHAR boss_guard11
			
				DELETE_CHAR	vance
				CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 -361.9369 -571.6255 35.9036 vance
				GOSUB set_up_vance_shite
				SET_CHAR_HEALTH	vance 500
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT vance player1
				
				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -358.9860 -573.5510 35.9023 boss_guard1//kill player
				random_mafia = boss_guard1
				GOSUB setup_goon_shite
				SET_CHAR_STAY_IN_SAME_PLACE	boss_guard1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard1 player1

				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -360.4153 -581.7871 35.9036 boss_guard2//crouching
				random_mafia = boss_guard2
				GOSUB setup_goon_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard2 player1

				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -358.8662 -572.5509 35.9024 boss_guard4//crouch
				random_mafia = boss_guard4
				GOSUB setup_goon_shite
				SET_CHAR_CROUCH boss_guard4 TRUE 99999999
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard4 player1

				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -360.1348 -576.5894 35.9036 boss_guard5//kill player
				random_mafia = boss_guard5
				GOSUB setup_goon_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard5 player1

				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -359.1239 -578.4683 35.9022 boss_guard6//kill player
				random_mafia = boss_guard6
				GOSUB setup_goon_shite
				SET_CHAR_STAY_IN_SAME_PLACE	boss_guard6 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard6 player1

				CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -357.0746 -575.2473 35.9037 boss_guard7//kill player
				random_mafia = boss_guard7
				GOSUB setup_goon_shite
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard7 player1
                
				CREATE_OBJECT_NO_OFFSET barrel2 -359.73 -580.773 36.291	barrel01
				SET_OBJECT_DYNAMIC barrel01 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -358.514 -581.288 36.291 barrel02
				SET_OBJECT_DYNAMIC barrel02 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -358.991 -582.344 36.291 barrel03
				SET_OBJECT_DYNAMIC barrel03 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -360.921 -573.17 37.412	barrel04
				SET_OBJECT_DYNAMIC barrel04 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -361.612 -573.052 36.291 barrel05
				SET_OBJECT_DYNAMIC barrel05 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -360.718 -573.451 36.291 barrel06
				SET_OBJECT_DYNAMIC barrel06 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -361.612 -573.947 36.291 barrel07
				SET_OBJECT_DYNAMIC barrel07 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -360.917 -572.457 36.291 barrel08
				SET_OBJECT_DYNAMIC barrel08 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -360.024 -571.964 36.291 barrel09
				SET_OBJECT_DYNAMIC barrel09 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -360.917 -571.564 36.291 barrel10
				SET_OBJECT_DYNAMIC barrel10 FALSE
				CREATE_OBJECT_NO_OFFSET barrel4 -365.268 -581.761 36.281 barrel11
				SET_OBJECT_DYNAMIC barrel11 FALSE
				
				MAKE_OBJECT_TARGETTABLE barrel11
				
				//CREATE_OBJECT_NO_OFFSET barrel4 -360.862 -558.764 36.291 barrel11
				//SET_OBJECT_DYNAMIC barrel11 FALSE
				//CREATE_OBJECT_NO_OFFSET barrel2 -360.798 -557.664 36.291 barrel12
				//SET_OBJECT_DYNAMIC barrel12 FALSE
				//CREATE_OBJECT_NO_OFFSET barrel2 -359.451 -558.796 36.291 barrel13
				//SET_OBJECT_DYNAMIC barrel13 FALSE
				
				CREATE_OBJECT_NO_OFFSET barrel2 -344.03 -574.41 36.291 barrel14
				SET_OBJECT_DYNAMIC barrel14 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -344.646 -575.077 36.291 barrel15
				SET_OBJECT_DYNAMIC barrel15 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -344.081 -575.753 36.291 barrel16
				SET_OBJECT_DYNAMIC barrel16 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -343.878 -576.62 36.291 barrel17
				SET_OBJECT_DYNAMIC barrel17 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -344.491 -577.278 36.291 barrel18
				SET_OBJECT_DYNAMIC barrel18 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -344.317 -576.168 37.412 barrel19
				SET_OBJECT_DYNAMIC barrel19 FALSE
				CREATE_OBJECT_NO_OFFSET barrel2 -344.691 -576.371 36.291 barrel20
				SET_OBJECT_DYNAMIC barrel20 FALSE

				REMOVE_PICKUP health_pickup_on_roof
				CREATE_PICKUP HEALTH PICKUP_ON_STREET -408.2314 -586.6186 38.5 health_pickup_on_roof

				vance_flag = 18
			ENDIF
		ENDIF

		IF vance_flag = 18
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON vance WEAPONTYPE_ANYWEAPON
				IF audio_bit_flag = 3
					audio_bit_flag = 4
				ENDIF
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard1
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard1
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard2
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard2
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard3
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard3
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard4
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard4
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard5
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard5
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard6
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard6
			ENDIF
		ENDIF

		IF vance_flag > 17
			IF IS_CHAR_DEAD	boss_guard7
				MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard7
			ENDIF
		ENDIF

		IF audio_bit_flag = 1
			IF HAS_MISSION_AUDIO_LOADED 2
				PLAY_MISSION_AUDIO 2
				PRINT_NOW FIN_1a 5000 1//Player: Come here you double-crossing piece of shit!
				audio_bit_flag = 2
			ENDIF
		ENDIF

		IF audio_bit_flag = 2
			IF HAS_MISSION_AUDIO_FINISHED 2
			AND	HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				PRINT_NOW FIN_4 5000 1//Lance:  Youre history, Tommy, history
				LOAD_MISSION_AUDIO 2 FIN_1c//Player: This is the last dance for lance vance!
				audio_bit_flag = 3
			ENDIF
		ENDIF

		IF audio_bit_flag = 4
			IF HAS_MISSION_AUDIO_FINISHED 1
			AND HAS_MISSION_AUDIO_LOADED 2
				PLAY_MISSION_AUDIO 2
				PRINT_NOW FIN_1c 5000 1//Player: This is the last dance for lance vance!
				LOAD_MISSION_AUDIO 1 FIN_2c//Lance:  I said I had enough of that at school!
				audio_bit_flag = 5
			ENDIF
		ENDIF

		IF audio_bit_flag = 5
			IF HAS_MISSION_AUDIO_FINISHED 2
			AND HAS_MISSION_AUDIO_LOADED 1
				PLAY_MISSION_AUDIO 1
				PRINT_NOW FIN_2c 5000 1//Lance:  I said I had enough of that at school!
				LOAD_MISSION_AUDIO 2 FIN_5//You picked the wrong side, Lance...
				audio_bit_flag = 6
			ENDIF
		ENDIF

		CLEAR_CHAR_LAST_WEAPON_DAMAGE vance
	ELSE
		IF NOT vance_flag = -11
			//REMOVE_BLIP vance_blip
			IF audio_bit_flag = 6
				IF HAS_MISSION_AUDIO_LOADED	2
					PLAY_MISSION_AUDIO 2
					PRINT_NOW FIN_5 5000 1//You picked the wrong side, Lance...
					audio_bit_flag = 7
				ENDIF
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED vance
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard1
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard2
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard3
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard4
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard5
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard6
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard7
			vance_timer = game_timer + 3000
			vance_flag = -11
		ENDIF
	ENDIF
ENDIF


//IN TIME ORDER
//LANCE FIGHT
//player coordinates: -378.4288 -582.1033 24.2735 168.0084 
//first shot: -379.2380 -583.7946 26.1261 -378.7026 -582.9524 26.0619 
//FIN_3		//Lance:  No one to cover your ass now, eh Tommy?
//FIN_1b	//Player: Youre going down, you back stabbing prick!
//-360.5664 -558.0118 28.8631 -361.1595 -558.7521 28.5465
//ALTERNATE1: -363.5046 -557.9782 27.5867 -363.4895 -558.9763 27.6460
//FIN_2b	//Lance:  Oh you think so!

//FIN_1a	//Player: Come here you double-crossing piece of shit!
//FIN_4		//Lance:  Youre history, Tommy, history

//FIN_1c	//Player: This is the last dance for lance vance!
//FIN_2c	//Lance:  I said I had enough of that at school!

//FIN_5		//Player: You picked the wrong side, Lance... (When Lance is killed)

//IF vance_flag = 1
//	IF NOT IS_CHAR_DEAD	vance
//		IF game_timer > vance_timer
//			GET_PLAYER_COORDINATES player1 player_x player_y player_z
//			CHAR_FOLLOW_PATH vance player_x player_y player_z 3.0 0
//			vance_timer = game_timer + 500
//		ENDIF
//	ELSE
//		MARK_CHA
//		REMOVE_BLIP	vance_blip
//		vance_timer = game_timer + 3000
//		vance_flag = -11
//	ENDIF
//ENDIF





IF boss_guard7_flag > 1
OR boss_guard7_flag = -1
	IF boss_guard8_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL03 -357.9117 -560.4049 18.5529 boss_guard8//GOONS BOTTOM CORRIDOR
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard8 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard8 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard8 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard8
		SET_CHAR_THREAT_SEARCH boss_guard8 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard8 TRUE
		SET_CHAR_PERSONALITY boss_guard8 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard8 -365.2909 -557.8369 //BEHIND FAR RIGHT PILLAR
		SET_CHAR_USE_PEDNODE_SEEK boss_guard8 FALSE
		boss_guard8_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard8
		IF boss_guard8_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard8 -365.2909 -557.8369 1.0 1.0 0//BEHIND FAR RIGHT PILLAR
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard8 dummy_player
				ENDIF
				boss_guard8_flag = 2
			ENDIF
		ENDIF
		IF boss_guard8_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard8 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard8
		boss_guard8_flag = -1
	ENDIF
ENDIF

IF boss_guard7_flag > 1
OR boss_guard7_flag = -1
	IF boss_guard9_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -358.5610 -560.1335 26.5396 boss_guard9//GOONS UPPER CORRIDOR
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard9 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard9 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard9 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard9
		SET_CHAR_THREAT_SEARCH boss_guard9 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard9 TRUE
		SET_CHAR_PERSONALITY boss_guard9 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard9 -380.1727 -560.6678//FURTHEST FROM CORRIDOR
		SET_CHAR_USE_PEDNODE_SEEK boss_guard9 FALSE
		boss_guard9_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard9
		IF boss_guard9_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard9 -380.1727 -560.6678 1.0 1.0 0//FURTHEST FROM CORRIDOR
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard9 dummy_player
				ENDIF
				boss_guard9_flag = 2
			ENDIF
		ENDIF
		IF boss_guard9_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard9 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard9
		boss_guard9_flag = -1
	ENDIF
ENDIF

IF boss_guard9_flag > 0
OR boss_guard9_flag = -1
	IF boss_guard10_flag = 0
		IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -358.5610 -560.1335 26.5396 1.0 1.0 2.0
			CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL03 -358.5610 -560.1335 26.5396 boss_guard10//GOONS UPPER CORRIDOR
			SET_CHAR_STAY_IN_SAME_PLACE	boss_guard10 TRUE
			GIVE_WEAPON_TO_CHAR	boss_guard10 WEAPONTYPE_TEC9 9999
			SET_CHAR_ACCURACY boss_guard10 75
			CLEAR_CHAR_THREAT_SEARCH boss_guard10
			SET_CHAR_THREAT_SEARCH boss_guard10 THREAT_PLAYER1
			SET_CHAR_HEED_THREATS boss_guard10 TRUE
			SET_CHAR_PERSONALITY boss_guard10 PEDSTAT_TOUGH_GUY
			SET_CHAR_OBJ_RUN_TO_COORD boss_guard10 -375.5527 -560.7495//MEDIUM FROM CORRIDOR
			SET_CHAR_USE_PEDNODE_SEEK boss_guard10 FALSE
			boss_guard10_flag = 1
		ENDIF
	ENDIF
	IF boss_guard10_flag > 0
		IF NOT IS_CHAR_DEAD	boss_guard10
			IF boss_guard10_flag = 1
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard10 -375.5527 -560.7495 1.0 1.0 0//MEDIUM FROM CORRIDOR
					IF NOT IS_CHAR_DEAD dummy_player
						SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard10 dummy_player
					ENDIF
					boss_guard10_flag = 2
				ENDIF
			ENDIF
			IF boss_guard10_flag = 10
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard10 player1
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard10
			boss_guard10_flag = -1
		ENDIF
	ENDIF
ENDIF

IF boss_guard10_flag > 1
OR boss_guard10_flag = -1
	IF boss_guard11_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -358.5610 -560.1335 26.5396 boss_guard11//GOONS UPPER CORRIDOR
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard11 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard11 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard11 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard11
		SET_CHAR_THREAT_SEARCH boss_guard11 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard11 TRUE
		SET_CHAR_PERSONALITY boss_guard11 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard11 -365.4941 -560.3325//CLOSEST TO CORRIDOR CROUCHED
		SET_CHAR_USE_PEDNODE_SEEK boss_guard11 FALSE
		boss_guard11_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard11
		IF boss_guard11_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard11 -365.4941 -560.3325 1.0 1.0 0//CLOSEST TO CORRIDOR CROUCHED
				SET_CHAR_CROUCH	boss_guard11 TRUE 15000
				boss_guard11_timer = game_timer + 800
				boss_guard11_flag = 2
			ENDIF
		ENDIF
		IF boss_guard11_flag = 2
			IF boss_guard11_timer < game_timer
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard11 dummy_player
				ENDIF
				boss_guard11_flag = 3
			ENDIF
		ENDIF
		IF boss_guard11_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard11 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard11
		boss_guard11_flag = -1
	ENDIF
ENDIF


///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//-378.4445 -556.8553 18.5385 182.3547 //SONNI
//-378.4255 -558.4648 //GOTO FOR EFFECT
IF sonni_flag = 0
AND vance_flag = -11
	IF game_timer >	sonni_timer
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -378.671 -588.595 28.17 8.5 13.0 4.0 0
			
			//SHUT_CHAR_UP scplayer TRUE
			
			DELETE_CHAR mafia_1
			DELETE_CHAR mafia_2
			DELETE_CHAR mafia_3
			DELETE_CHAR mafia_4
			DELETE_CHAR mafia_5
			DELETE_CHAR mafia_6
			DELETE_CHAR mafia_7
			DELETE_CHAR mafia_8
			DELETE_CHAR mafia_9
			
			DELETE_CHAR boss_guard1
			DELETE_CHAR boss_guard2
			DELETE_CHAR boss_guard3
			DELETE_CHAR boss_guard4
			DELETE_CHAR boss_guard5
			DELETE_CHAR boss_guard6
			DELETE_CHAR boss_guard7
			DELETE_CHAR boss_guard8
			DELETE_CHAR boss_guard9
			DELETE_CHAR boss_guard10
			DELETE_CHAR boss_guard11
			
			player_in_scripted_cutscene = 1
			
			CREATE_CHAR PEDTYPE_SPECIAL SPECIAL02 -378.4445 -556.8553 18.5385 sonni
			SET_CHAR_HEADING sonni 180.0
			CLEAR_CHAR_THREAT_SEARCH sonni
			SET_CHAR_PERSONALITY sonni PEDSTAT_TOUGH_GUY
		   	//SET_CHAR_THREAT_SEARCH sonni THREAT_PLAYER1
			//SET_CHAR_THREAT_SEARCH sonni THREAT_GANG_PLAYER
			GIVE_WEAPON_TO_CHAR	sonni WEAPONTYPE_RUGER 9999
			SET_CHAR_STAY_IN_SAME_PLACE	sonni TRUE
			SET_CHAR_HEALTH sonni 1000
			SET_CHAR_ACCURACY sonni 100
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER	sonni TRUE
			SET_CHAR_HEED_THREATS sonni TRUE
			SET_CHAR_AS_PLAYER_FRIEND sonni player1 TRUE
			SET_CHAR_SUFFERS_CRITICAL_HITS sonni FALSE
			SET_CHAR_CAN_BE_SHOT_IN_VEHICLE sonni FALSE
			SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG sonni GANG_PLAYER FALSE
			SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG sonni GANG_STREET FALSE
			LOAD_MISSION_AUDIO 1 FIN_11a//Player: You took fifteen years from me Sonny...
			LOAD_MISSION_AUDIO 2 FIN_11b//Player: And now Im gonna make you pay!
		
			SET_PLAYER_CONTROL player1 OFF
			SET_EVERYONE_IGNORE_PLAYER player1 TRUE
			SWITCH_WIDESCREEN ON
			SET_ALL_CARS_CAN_BE_DAMAGED FALSE
			SET_PED_DENSITY_MULTIPLIER 0.0
			CLEAR_AREA -354.419 -569.529 30.0 200.0 0 
			
			CLEAR_AREA -378.0434 -579.1422 18.5385 2.0 1
			SET_PLAYER_COORDINATES player1 -378.0434 -579.1422 18.5385
			
			CREATE_CHAR	PEDTYPE_CIVMALE NULL -378.7225 -581.9664 24.2737 dummy_player
			GIVE_WEAPON_TO_CHAR	dummy_player WEAPONTYPE_PYTHON 9
			CLEAR_CHAR_THREAT_SEARCH dummy_player
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	dummy_player -378.7615 -578.0532
			SET_CHAR_USE_PEDNODE_SEEK dummy_player FALSE
			SHUT_CHAR_UP dummy_player TRUE
			
			CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL03 -377.4021 -556.0059 18.6338 boss_guard1//RHS DOORWAY GOTO 2
			
			SET_CHAR_STAY_IN_SAME_PLACE	boss_guard1 TRUE
			GIVE_WEAPON_TO_CHAR	boss_guard1 WEAPONTYPE_TEC9 9999
			SET_CHAR_ACCURACY boss_guard1 75
			CLEAR_CHAR_THREAT_SEARCH boss_guard1
			SET_CHAR_THREAT_SEARCH boss_guard1 THREAT_PLAYER1
			SET_CHAR_HEED_THREATS boss_guard1 TRUE
			SET_CHAR_PERSONALITY boss_guard1 PEDSTAT_TOUGH_GUY
			
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard1 dummy_player
			
			
			CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -379.5223 -556.0323 18.6338 boss_guard2//LHS DOORWAY GOTO 2
			
			SET_CHAR_STAY_IN_SAME_PLACE	boss_guard2 TRUE
			GIVE_WEAPON_TO_CHAR	boss_guard2 WEAPONTYPE_TEC9 9999
			SET_CHAR_ACCURACY boss_guard2 75
			CLEAR_CHAR_THREAT_SEARCH boss_guard2
			SET_CHAR_THREAT_SEARCH boss_guard2 THREAT_PLAYER1
			SET_CHAR_HEED_THREATS boss_guard2 TRUE
			SET_CHAR_PERSONALITY boss_guard2 PEDSTAT_TOUGH_GUY
			
			LOAD_MISSION_AUDIO 1 FIN_11a //Player: You took fifteen years from me Sonny...
			LOAD_MISSION_AUDIO 2 FIN_11b //Player: And now Im gonna make you pay!
			
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard2 dummy_player
			
			SET_FIXED_CAMERA_POSITION -380.8234 -580.5767 26.8352 0.0 0.0 0.0//FROM SCARFACE ROOM BEHIND PLAYER
			POINT_CAMERA_AT_POINT -380.5664 -579.6381 26.6052 JUMP_CUT
			
			boss_guard1_flag = 1
			boss_guard1_timer = game_timer + 1500
			boss_guard2_flag = 1
			boss_guard2_timer = game_timer + 2000
			boss_guard3_flag = 0
			boss_guard4_flag = 0
			boss_guard5_flag = 0
			boss_guard6_flag = 0
			boss_guard7_flag = 0
			boss_guard8_flag = 0
			boss_guard9_flag = 0
			boss_guard10_flag = 0
			boss_guard11_flag = 0

			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sonni player1
			sonni_flag = 1
		ENDIF
	ENDIF
ENDIF
IF sonni_flag > 0
	IF NOT IS_CHAR_DEAD	sonni
		IF sonni_flag = 1
			IF NOT IS_CHAR_DEAD	dummy_player
				IF LOCATE_CHAR_ON_FOOT_2D dummy_player -378.7615 -578.0532 1.0 1.0 0
					sonni_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF sonni_flag = 2
			IF HAS_MISSION_AUDIO_LOADED	1
				PLAY_MISSION_AUDIO 1
				PRINT_NOW FIN_11a 5000 1//Player: You took fifteen years from me Sonny...
				sonni_flag = 3
			ENDIF
		ENDIF
		IF sonni_flag = 3
			IF HAS_MISSION_AUDIO_LOADED	2
			AND HAS_MISSION_AUDIO_FINISHED 1
				PLAY_MISSION_AUDIO 2
				PRINT_NOW FIN_11b 5000 1//Player: And now Im gonna make you pay!
				IF NOT IS_CHAR_DEAD	dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR dummy_player sonni
				ENDIF
				LOAD_MISSION_AUDIO 1 FIN_12a//Sonny:  You still dont get it do you!
				sonni_flag = 4
			ENDIF
		ENDIF
		IF sonni_flag = 4
			IF HAS_MISSION_AUDIO_LOADED	1
			AND HAS_MISSION_AUDIO_FINISHED 2
				SET_FIXED_CAMERA_POSITION -382.2642 -559.3823 20.6255 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -381.3100 -559.3243 20.3318 JUMP_CUT
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sonni -378.5504 -558.9965
				PLAY_MISSION_AUDIO 1
				PRINT_NOW FIN_12a 5000 1//Sonny:  You still dont get it do you!
				LOAD_MISSION_AUDIO 2 FIN_12b //Sonny:  I OWN you, Tommy.
				sonni_flag = 5
			ENDIF
		ENDIF
		IF sonni_flag = 5
			IF HAS_MISSION_AUDIO_LOADED	2
			AND HAS_MISSION_AUDIO_FINISHED 1
				PLAY_MISSION_AUDIO 2
				PRINT_NOW FIN_12b 5000 1//Sonny:  I OWN you, Tommy.
				LOAD_MISSION_AUDIO 1 FIN_12c//Sonny:  Those fifteen years were mine to spend!
				sonni_flag = 6
			ENDIF
		ENDIF
		IF sonni_flag = 6
			IF HAS_MISSION_AUDIO_LOADED	1
			AND HAS_MISSION_AUDIO_FINISHED 2
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sonni -378.5504 -558.9965
				PLAY_MISSION_AUDIO 1
				SET_FIXED_CAMERA_POSITION -381.7876 -555.2700 20.6022 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -381.1512 -556.0339 20.4956 JUMP_CUT
				PRINT_NOW FIN_12c 5000 1//Sonny:  Those fifteen years were mine to spend!
				LOAD_MISSION_AUDIO 2 FIN_13 //Sonny:  Get him boys, he never understood a thing.
				sonni_flag = 7
			ENDIF
		ENDIF
		IF sonni_flag = 7
			IF HAS_MISSION_AUDIO_LOADED	2
			AND HAS_MISSION_AUDIO_FINISHED 1
				sonni_timer = game_timer + 2000
				SET_CHAR_WAIT_STATE sonni WAITSTATE_CROSS_ROAD_LOOK 2000
				sonni_flag = 8
			ENDIF
		ENDIF
		IF sonni_flag = 8
			IF sonni_timer < game_timer
				PLAY_MISSION_AUDIO 2
				PRINT_NOW FIN_13 5000 1//Sonny:  Get him boys, he never understood a thing.
				LOAD_MISSION_AUDIO 1 FINKILL//Sonny:  Ok boys, kill him!
				
				hold_off_shooting_timer = game_timer + 500				
					
				DELETE_CHAR dummy_player
				CLEAR_AREA -378.7374 -578.8705 24.2774 2.0 1
				SET_PLAYER_COORDINATES player1 -378.7374 -578.8705 24.2774//TOP OF STAIRS
				SET_PLAYER_HEADING player1 0.0
				SET_PLAYER_HEALTH player1 200
				ADD_ARMOUR_TO_PLAYER player1 200
				SET_EVERYONE_IGNORE_PLAYER player1 FALSE
				SET_PLAYER_CONTROL player1 ON
				SET_EVERYONE_IGNORE_PLAYER player1 FALSE
				SWITCH_WIDESCREEN OFF
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				SET_CAMERA_BEHIND_PLAYER
				RESTORE_CAMERA_JUMPCUT

				IF NOT IS_CHAR_DEAD	boss_guard1
					SET_CHAR_OBJ_NO_OBJ	boss_guard1
					//boss_guard1_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard2
					SET_CHAR_OBJ_NO_OBJ	boss_guard2
					//boss_guard2_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard3
					SET_CHAR_OBJ_NO_OBJ	boss_guard3
					//boss_guard3_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard4
					SET_CHAR_OBJ_NO_OBJ	boss_guard4
					//boss_guard4_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard5
					SET_CHAR_OBJ_NO_OBJ	boss_guard5
					//boss_guard5_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard6
					SET_CHAR_OBJ_NO_OBJ	boss_guard6
					//boss_guard6_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard7
					SET_CHAR_OBJ_NO_OBJ	boss_guard7
					//boss_guard7_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard8
					SET_CHAR_OBJ_NO_OBJ	boss_guard8
					//boss_guard8_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard9
					SET_CHAR_OBJ_NO_OBJ	boss_guard9
					//boss_guard9_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard10
					SET_CHAR_OBJ_NO_OBJ	boss_guard10
					//boss_guard10_flag = 10
				ENDIF
				IF NOT IS_CHAR_DEAD	boss_guard11
					SET_CHAR_OBJ_NO_OBJ	boss_guard11
					//boss_guard11_flag = 10
				ENDIF
				
				//SHUT_CHAR_UP scplayer FALSE
				
				player_in_scripted_cutscene = 0

				REMOVE_PICKUP health_pickup2
				CREATE_PICKUP HEALTH PICKUP_ON_STREET -378.5680 -598.7501 25.4 health_pickup2 //SCARFACE ROOM
				REMOVE_PICKUP python_pickup2
				CREATE_PICKUP_WITH_AMMO SHOTGSPA PICKUP_ONCE 400 -374.4366 -587.5957 25.3355 python_pickup2
								
				PRINT FIN_B2 5000 1//~p~Sonni~g~ is coming to kill you.
				sonni_flag = 9
			ENDIF
		ENDIF
		IF sonni_flag = 9
			IF hold_off_shooting_timer < game_timer
				boss_guard1_flag = 10
				boss_guard2_flag = 10
				boss_guard3_flag = 10
				boss_guard4_flag = 10
				boss_guard5_flag = 10
				boss_guard6_flag = 10
				boss_guard7_flag = 10
				boss_guard8_flag = 10
				boss_guard9_flag = 10
				boss_guard10_flag = 10
				boss_guard11_flag = 10
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sonni player1
				sonni_flag = 10
			ENDIF
		ENDIF
	ELSE
		IF NOT sonni_flag = -11
			MARK_CHAR_AS_NO_LONGER_NEEDED sonni
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard1
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard2
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard3
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard4
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard5
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard6
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard7
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard8
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard9
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard10
			MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard11
			sonni_timer = game_timer + 3000
			sonni_flag = -11
		ENDIF
	ENDIF
ENDIF

//SONNI FIGHT
//FIN_11a   //Player: You took fifteen years from me Sonny...
//FIN_11b	//Player: And now Im gonna make you pay!
//FIN_12a	//Sonny:  You still dont get it do you!
//FIN_12b	//Sonny:  I OWN you, Tommy.
//FIN_12c	//Sonny:  Those fifteen years were mine to spend!
//FIN_13	//Sonny:  Get him boys, he never understood a thing.

//FINKILL	//Sonny:  Ok boys, kill him!
//FIN_10	//Player: Sonny? SONNY! Im coming for ya! (When player gets close to Sonni)

IF NOT IS_CHAR_DEAD	boss_guard1
	IF boss_guard1_flag = 1
		IF boss_guard1_timer < game_timer
			SET_CHAR_OBJ_RUN_TO_COORD boss_guard1 -376.9825 -559.1848//CROUCH BY SONNI
			SET_CHAR_USE_PEDNODE_SEEK boss_guard1 FALSE
			boss_guard1_flag = 2
		ENDIF
	ENDIF
	IF boss_guard1_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard1 -376.9825 -559.1848 1.0 1.0 0//CROUCH BY SONNI
			SET_CHAR_CROUCH	boss_guard1 TRUE 15000
			boss_guard1_timer = game_timer + 800
			boss_guard1_flag = 3
		ENDIF
	ENDIF
	IF boss_guard1_flag = 3
		IF boss_guard1_timer < game_timer
			IF NOT IS_CHAR_DEAD dummy_player
				SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard1 dummy_player
			ENDIF
			boss_guard1_flag = 4
		ENDIF
	ENDIF
	IF boss_guard1_flag = 10
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard1 player1
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard1
	boss_guard1_flag = -1
ENDIF

IF NOT IS_CHAR_DEAD	boss_guard2
	IF boss_guard2_flag = 1
		IF boss_guard2_timer < game_timer
			SET_CHAR_OBJ_RUN_TO_COORD boss_guard2 -382.3959 -563.7010//AT BOTTOM OF STEPS
			SET_CHAR_USE_PEDNODE_SEEK boss_guard2 FALSE
			boss_guard2_flag = 2
		ENDIF
	ENDIF
	IF boss_guard2_flag = 2
		IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard2 -382.3959 -563.7010 1.0 1.0 0//AT BOTTOM OF STEPS
			IF NOT IS_CHAR_DEAD dummy_player
				SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard2 dummy_player
			ENDIF
			boss_guard2_flag = 3
		ENDIF
	ENDIF
	IF boss_guard2_flag = 10
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard2 player1
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard2
	boss_guard2_flag = -1
ENDIF

IF boss_guard2_flag > 1
OR boss_guard2_flag = -1
	IF boss_guard3_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -384.1820 -551.5216 18.5431 boss_guard3 //LHS DOORWAY GOON // SCFIX: change Y
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard3 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard3 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard3 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard3
		SET_CHAR_THREAT_SEARCH boss_guard3 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard3 TRUE
		SET_CHAR_PERSONALITY boss_guard3 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard3 -379.5186 -553.2346 //LHS DOORWAY GOTO 1
		SET_CHAR_USE_PEDNODE_SEEK boss_guard3 FALSE
		boss_guard3_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard3
		IF boss_guard3_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard3 -379.5186 -553.2346 1.0 1.0 0//LHS DOORWAY GOTO 1
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard3 -379.5223 -556.0323 //LHS DOORWAY GOTO 2
				SET_CHAR_USE_PEDNODE_SEEK boss_guard3 FALSE
				boss_guard3_flag = 2
			ENDIF
		ENDIF
		IF boss_guard3_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard3 -379.5223 -556.0323 1.0 1.0 0//LHS DOORWAY GOTO 2
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard3 -383.4772 -558.1151 //BEHIND LEFT PILLAR
				SET_CHAR_USE_PEDNODE_SEEK boss_guard3 FALSE
				boss_guard3_flag = 3
			ENDIF
		ENDIF
		IF boss_guard3_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard3 -383.4772 -558.1151 1.0 1.0 0//BEHIND LEFT PILLAR
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard3 dummy_player
				ENDIF
				boss_guard3_flag = 4
			ENDIF
		ENDIF
		IF boss_guard3_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard3 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard3
		boss_guard3_flag = -1
	ENDIF
ENDIF

IF boss_guard1_flag > 1
OR boss_guard1_flag = -1
	IF boss_guard4_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL03 -373.9800 -551.4843 18.5448 boss_guard4 //RHS DOORWAY GOON // SCFIX: change Y
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard4 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard4 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard4 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard4
		SET_CHAR_THREAT_SEARCH boss_guard4 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard4 TRUE
		SET_CHAR_PERSONALITY boss_guard4 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard4 -377.2835 -553.6105 //RHS DOORWAY GOTO 1
		SET_CHAR_USE_PEDNODE_SEEK boss_guard4 FALSE
		boss_guard4_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard4
		IF boss_guard4_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard4 -377.2835 -553.6105 1.0 1.0 0//RHS DOORWAY GOTO 1
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard4 -377.4021 -556.0059 //RHS DOORWAY GOTO 2
				SET_CHAR_USE_PEDNODE_SEEK boss_guard4 FALSE
				boss_guard4_flag = 2
			ENDIF
		ENDIF
		IF boss_guard4_flag = 2
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard4 -377.4021 -556.0059 1.0 1.0 0//RHS DOORWAY GOTO 2
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard4 -373.7734 -558.1152 //BEHIND RIGHT PILLAR
				SET_CHAR_USE_PEDNODE_SEEK boss_guard4 FALSE
				boss_guard4_flag = 3
			ENDIF
		ENDIF
		IF boss_guard4_flag = 3
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard4 -373.7734 -558.1152 1.0 1.0 0//BEHIND RIGHT PILLAR
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard4 dummy_player
				ENDIF
				boss_guard4_flag = 4
			ENDIF
		ENDIF
		IF boss_guard4_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard4 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard4
		boss_guard4_flag = -1
	ENDIF
ENDIF

IF boss_guard4_flag > 1
OR boss_guard4_flag = -1
	IF boss_guard5_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -373.9800 -551.4843 18.5448 boss_guard5 //RHS DOORWAY GOON // SCFIX: change Y
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard5 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard5 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard5 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard5
		SET_CHAR_THREAT_SEARCH boss_guard5 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard5 TRUE
		SET_CHAR_PERSONALITY boss_guard5 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard5 -377.2835 -553.6105 //RHS DOORWAY GOTO 1
		SET_CHAR_USE_PEDNODE_SEEK boss_guard5 FALSE
		boss_guard5_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard5
		IF boss_guard5_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard5 -377.2835 -553.6105 1.0 1.0 0//RHS DOORWAY GOTO 1
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard5 -377.4021 -556.0059 //RHS DOORWAY GOTO 2
				SET_CHAR_USE_PEDNODE_SEEK boss_guard5 FALSE
				boss_guard5_flag = 2
			ENDIF
		ENDIF
		IF boss_guard5_flag = 2
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard5 -377.4021 -556.0059 1.0 1.0 0//RHS DOORWAY GOTO 2
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard5 dummy_player
				ENDIF
				boss_guard5_flag = 3
			ENDIF
		ENDIF
		IF boss_guard5_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard5 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard5
		boss_guard5_flag = -1
	ENDIF
ENDIF

IF boss_guard3_flag > 1
OR boss_guard3_flag = -1
	IF boss_guard6_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL04 -384.1820 -551.5216 18.5431 boss_guard6 //LHS DOORWAY GOON // SCFIX: change Y
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard6 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard6 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard6 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard6
		SET_CHAR_THREAT_SEARCH boss_guard6 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard6 TRUE
		SET_CHAR_PERSONALITY boss_guard6 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard6 -379.5186 -553.2346 //LHS DOORWAY GOTO 1
		SET_CHAR_USE_PEDNODE_SEEK boss_guard6 FALSE
		boss_guard6_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard6
		IF boss_guard6_flag = 1
			IF LOCATE_CHAR_ON_FOOT_2D boss_guard6 -379.5186 -553.2346 1.0 1.0 0//LHS DOORWAY GOTO 1
				SET_CHAR_OBJ_RUN_TO_COORD boss_guard6 -379.5223 -556.0323 //LHS DOORWAY GOTO 2
				SET_CHAR_USE_PEDNODE_SEEK boss_guard6 FALSE
				boss_guard6_flag = 2
			ENDIF
		ENDIF
		IF boss_guard6_flag = 2
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard6 -379.5223 -556.0323 1.0 1.0 0//LHS DOORWAY GOTO 2
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard6 dummy_player
				ENDIF
				boss_guard6_flag = 3
			ENDIF
		ENDIF
		IF boss_guard6_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard6 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard6
		boss_guard6_flag = -1
	ENDIF
ENDIF

IF boss_guard4_flag > 2
OR boss_guard4_flag = -1
	IF boss_guard7_flag = 0
		CREATE_CHAR	PEDTYPE_GANG_STREET SPECIAL03 -357.9117 -560.4049 18.5529 boss_guard7//GOONS BOTTOM CORRIDOR
		SET_CHAR_STAY_IN_SAME_PLACE	boss_guard7 TRUE
		GIVE_WEAPON_TO_CHAR	boss_guard7 WEAPONTYPE_TEC9 9999
		SET_CHAR_ACCURACY boss_guard7 75
		CLEAR_CHAR_THREAT_SEARCH boss_guard7
		SET_CHAR_THREAT_SEARCH boss_guard7 THREAT_PLAYER1
		SET_CHAR_HEED_THREATS boss_guard7 TRUE
		SET_CHAR_PERSONALITY boss_guard7 PEDSTAT_TOUGH_GUY
		SET_CHAR_OBJ_RUN_TO_COORD boss_guard7 -370.8983 -561.2952 //MIDDLE OF RHS FLOOR AREA CROUCHED
		SET_CHAR_USE_PEDNODE_SEEK boss_guard7 FALSE
		boss_guard7_flag = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	boss_guard7
		IF boss_guard7_flag = 1
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D boss_guard7 -370.8983 -561.2952 1.0 1.0 0//MIDDLE OF RHS FLOOR AREA CROUCHED
				SET_CHAR_CROUCH	boss_guard7 TRUE 15000
				boss_guard7_timer = game_timer + 800
				boss_guard7_flag = 2
			ENDIF
		ENDIF
		IF boss_guard7_flag = 2
			IF boss_guard7_timer < game_timer
				IF NOT IS_CHAR_DEAD dummy_player
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR boss_guard7 dummy_player
				ENDIF
				boss_guard7_flag = 3
			ENDIF
		ENDIF
		IF boss_guard7_flag = 10
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boss_guard7 player1
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED boss_guard7
		boss_guard7_flag = -1
	ENDIF
ENDIF



///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//-384.1820 -553.5216 18.5431 //LHS DOORWAY GOON		 //
//-379.5186 -553.2346 //LHS DOORWAY GOTO 1				 //
//-379.5223 -556.0323 //LHS DOORWAY GOTO 2 //18.6338	 //
///////////////////////////////////////////////////////////
//-373.9800 -553.4843 18.5448 //RHS DOORWAY GOON		 //
//-377.2835 -553.6105 //RHS DOORWAY GOTO 1				 //
//-377.4021 -556.0059 //RHS DOORWAY GOTO 2 //18.6338	 //
///////////////////////////////////////////////////////////
//-384.4772 -558.1151 //BEHIND LEFT PILLAR				 //
//-372.7734 -558.1152 //BEHIND RIGHT PILLAR				 //
//-376.9825 -559.1848 //CROUCH BY SONNI	boss_guard1		 //
//-382.3959 -563.7010 //AT BOTTOM OF STEPS boss_guard2	 //
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//-357.9117 -560.4049 18.5529 //GOONS BOTTOM CORRIDOR	 //
//-365.2909 -557.8369 //BEHIND FAR RIGHT PILLAR			 //
//-370.8983 -561.2952 //MIDDLE OF RHS FLOOR AREA CROUCHED//
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//-358.5610 -560.1335 26.5396 //GOONS UPPER CORRIDOR	 //
//-380.1727 -560.6678//FURTHEST FROM CORRIDOR			 //
//-375.5527 -560.7495//MEDIUM FROM CORRIDOR				 //
//-365.4941 -560.3325//CLOSEST TO CORRIDOR CROUCHED		 //
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
//-378.5680 -598.7501 25.4//HEALTH PICKUP SCARFACE ROOM	 //
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////

//IF sonni_flag = 1
//	IF NOT IS_CHAR_DEAD	sonni
//		IF game_timer > sonni_timer
//			GET_PLAYER_COORDINATES player1 player_x player_y player_z
//			//CHAR_FOLLOW_PATH sonni player_x player_y player_z 3.0 0
//			sonni_timer = game_timer + 500
//		ENDIF
//	ELSE
////		REMOVE_BLIP	sonni_blip
//		sonni_timer = game_timer + 3000
//		sonni_flag = -11
//	ENDIF
//ENDIF

IF sonni_flag = -11
AND vance_flag = -11
	IF game_timer > sonni_timer
	AND game_timer > vance_timer
		GOTO final_cutscene
	ENDIF
ENDIF

IF player_in_scripted_cutscene = 0
	IF NOT IS_CHAR_DEAD	mafia_1
		random_mafia = mafia_1
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_1
		mafia_1 = -1
		mafia_1_timer = 0
		mafia_1_cash = 0
		mafia_1_flag = 0
		random_mafia = mafia_1
		GOSUB generate_new_ped
		mafia_1 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_2
		random_mafia = mafia_2
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_2
		mafia_2 = -1
		mafia_2_timer = 0
		mafia_2_cash = 0
		mafia_2_flag = 0
		random_mafia = mafia_2
		GOSUB generate_new_ped
		mafia_2 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_3
		random_mafia = mafia_3
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_3
		mafia_3 = -1
		mafia_3_timer = 0
		mafia_3_cash = 0
		mafia_3_flag = 0
		random_mafia = mafia_3
		GOSUB generate_new_ped
		mafia_3 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_4
		random_mafia = mafia_4
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_4
		mafia_4 = -1
		mafia_4_timer = 0
		mafia_4_cash = 0
		mafia_4_flag = 0
		random_mafia = mafia_4
		GOSUB generate_new_ped
		mafia_4 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_5
		random_mafia = mafia_5
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_5
		mafia_5 = -1
		mafia_5_timer = 0
		mafia_5_cash = 0
		mafia_5_flag = 0
		random_mafia = mafia_5
		GOSUB generate_new_ped
		mafia_5 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_6
		random_mafia = mafia_6
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_6
		mafia_6 = -1
		mafia_6_timer = 0
		mafia_6_cash = 0
		mafia_6_flag = 0
		random_mafia = mafia_6
		GOSUB generate_new_ped
		mafia_6 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_7
		random_mafia = mafia_7
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_7
		mafia_7 = -1
		mafia_7_timer = 0
		mafia_7_cash = 0
		mafia_7_flag = 0
		random_mafia = mafia_7
		GOSUB generate_new_ped
		mafia_7 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_8
		random_mafia = mafia_8
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_8
		mafia_8 = -1
		mafia_8_timer = 0
		mafia_8_cash = 0
		mafia_8_flag = 0
		random_mafia = mafia_8
		GOSUB generate_new_ped
		mafia_8 = random_mafia
	ENDIF

	IF NOT IS_CHAR_DEAD	mafia_9
		random_mafia = mafia_9
		GOSUB run_to_the_safe
		IF failed_finale_flag = 1
			GOTO mission_finale2_failed
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED mafia_9
		mafia_9 = -1
		mafia_9_timer = 0
		mafia_9_cash = 0
		mafia_9_flag = 0
		random_mafia = mafia_9
		GOSUB generate_new_ped
		mafia_9 = random_mafia
	ENDIF
ENDIF

GOTO mission_finale2_loop



//////////////////////////////////////////////////////////////////////////////////////////
set_up_vance_shite:///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
SHUT_CHAR_UP vance TRUE
CLEAR_CHAR_THREAT_SEARCH vance
SET_CHAR_PERSONALITY vance PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH vance THREAT_PLAYER1
GIVE_WEAPON_TO_CHAR	vance WEAPONTYPE_RUGER 9999
SET_CHAR_HEALTH vance 1000
SET_CHAR_ACCURACY vance 85
SET_CHAR_STAY_IN_SAME_PLACE	vance TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER	vance TRUE
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG vance GANG_PLAYER FALSE
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG vance GANG_STREET FALSE
SET_CHAR_SUFFERS_CRITICAL_HITS vance FALSE
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE vance FALSE
RETURN


//////////////////////////////////////////////////////////////////////////////////////////
setup_goon_shite://///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
SET_CHAR_STAY_IN_SAME_PLACE	random_mafia TRUE
GIVE_WEAPON_TO_CHAR	random_mafia WEAPONTYPE_PISTOL 9999
CLEAR_CHAR_THREAT_SEARCH random_mafia
SET_CHAR_THREAT_SEARCH random_mafia THREAT_PLAYER1
SET_CHAR_HEED_THREATS random_mafia TRUE
SET_CHAR_PERSONALITY random_mafia PEDSTAT_TOUGH_GUY
TURN_CHAR_TO_FACE_CHAR random_mafia scplayer
RETURN


//////////////////////////////////////////////////////////////////////////////////////////
generate_new_ped://///////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
GENERATE_RANDOM_INT_IN_RANGE 0 11 random_mafia_counter
IF random_mafia_counter	= 0
    IF NOT IS_CAR_DEAD mafia_limo_1
		IF IS_CAR_PASSENGER_SEAT_FREE mafia_limo_1 1
			GET_CAR_COORDINATES	mafia_limo_1 x y z
			IF NOT IS_POINT_ON_SCREEN x y z 4.0
		    	CREATE_CHAR_AS_PASSENGER mafia_limo_1 PEDTYPE_GANG_STREET SPECIAL03 1 random_mafia
				random_mafia_counter = -1
			ELSE
				RETURN
			ENDIF
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 1
    IF NOT IS_CAR_DEAD mafia_limo_2
		IF IS_CAR_PASSENGER_SEAT_FREE mafia_limo_2 1
			GET_CAR_COORDINATES	mafia_limo_2 x y z
			IF NOT IS_POINT_ON_SCREEN x y z 4.0
		    	CREATE_CHAR_AS_PASSENGER mafia_limo_2 PEDTYPE_GANG_STREET SPECIAL04 1 random_mafia
				random_mafia_counter = -1
			ELSE
				RETURN
			ENDIF
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 2
    IF NOT IS_CAR_DEAD mafia_limo_3
		IF IS_CAR_PASSENGER_SEAT_FREE mafia_limo_3 1
			GET_CAR_COORDINATES	mafia_limo_3 x y z
			IF NOT IS_POINT_ON_SCREEN x y z 4.0
		    	CREATE_CHAR_AS_PASSENGER mafia_limo_3 PEDTYPE_GANG_STREET SPECIAL03 1 random_mafia
				random_mafia_counter = -1
			ELSE
				RETURN
			ENDIF
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 3
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -354.0382 -527.9669 11.7155 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -354.0382 -527.9669 11.7155 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -354.0382 -527.9669 11.7155 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 4
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -390.1438 -541.0243 16.2431 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -390.1438 -541.0243 16.2431 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -390.1438 -541.0243 16.2431 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 5
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -458.3071 -606.5378 11.7988 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -458.3071 -606.5378 11.7988 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -458.3071 -606.5378 11.7988 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 6
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -455.4113 -561.6190 11.7620 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -455.4113 -561.6190 11.7620 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -455.4113 -561.6190 11.7620 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 7
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -412.1893 -605.7213 16.2433 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -412.1893 -605.7213 16.2433 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -412.1893 -605.7213 16.2433 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 8
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -370.0882 -615.1937 9.3386 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -370.0882 -615.1937 9.3386 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -370.0882 -615.1937 9.3386 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
//IF random_mafia_counter	= 9
//	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -402.7597 -561.5503 17.9388 1.0 1.0 2.0
//		IF NOT IS_POINT_ON_SCREEN -402.7597 -561.5503 17.9388 2.0
//	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -402.7597 -561.5503 17.9388 random_mafia
//			random_mafia_counter = -1
//		ELSE
//			RETURN		 -403.0056 -560.2985 17.9388
//		ENDIF
//	ELSE
//		RETURN
//	ENDIF
//ENDIF
IF random_mafia_counter	= 9
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -335.9248 -579.0020 18.5231 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -335.9248 -579.0020 18.5231 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL03 -335.9248 -579.0020 18.5231 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter	= 10
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -329.9831 -582.3398 34.5103 1.0 1.0 2.0
		IF NOT IS_POINT_ON_SCREEN -329.9831 -582.3398 34.5103 2.0
	    	CREATE_CHAR PEDTYPE_GANG_STREET SPECIAL04 -329.9831 -582.3398 34.5103 random_mafia
			random_mafia_counter = -1
		ELSE
			RETURN
		ENDIF
	ELSE
		RETURN
	ENDIF
ENDIF
IF random_mafia_counter = -1
	SET_CHAR_STAY_IN_SAME_PLACE	random_mafia TRUE
	GIVE_WEAPON_TO_CHAR	random_mafia WEAPONTYPE_TEC9 9999
	CLEAR_CHAR_THREAT_SEARCH random_mafia
	SET_CHAR_THREAT_SEARCH random_mafia THREAT_PLAYER1
	SET_CHAR_CEASE_ATTACK_TIMER random_mafia 1500
	SET_CHAR_HEED_THREATS random_mafia TRUE
	SET_CHAR_PERSONALITY random_mafia PEDSTAT_TOUGH_GUY
	SET_CHAR_ACCURACY random_mafia 75
ENDIF

RETURN


//////////////////////////////////////////////////////////////////////////////////////////
run_to_the_safe://////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
IF random_mafia	= mafia_1
	random_mafia_timer = mafia_1_timer
	random_mafia_cash =	mafia_1_cash
	random_mafia_flag =	mafia_1_flag
	random_mafia_x = -373.7542
	random_mafia_y = -590.6248
	random_mafia_z = 24.2896
	mafia_stuck_timer = mafia_1_stuck_timer	
	mafia_stuck_x = mafia_1_stuck_x
	mafia_stuck_y = mafia_1_stuck_y
	mafia_stuck_z = mafia_1_stuck_z
ENDIF

IF random_mafia	= mafia_2
	random_mafia_timer = mafia_2_timer
	random_mafia_cash =	mafia_2_cash
	random_mafia_flag =	mafia_2_flag
	random_mafia_x = -381.0802
	random_mafia_y = -595.4677
	random_mafia_z = 24.7818
	mafia_stuck_timer = mafia_2_stuck_timer	
	mafia_stuck_x = mafia_2_stuck_x
	mafia_stuck_y = mafia_2_stuck_y
	mafia_stuck_z = mafia_2_stuck_z
ENDIF

IF random_mafia	= mafia_3
	random_mafia_timer = mafia_3_timer
	random_mafia_cash =	mafia_3_cash
	random_mafia_flag =	mafia_3_flag
	random_mafia_x = -378.6870
	random_mafia_y = -597.9142
	random_mafia_z = 24.7818
	mafia_stuck_timer = mafia_3_stuck_timer	
	mafia_stuck_x = mafia_3_stuck_x
	mafia_stuck_y = mafia_3_stuck_y
	mafia_stuck_z = mafia_3_stuck_z
ENDIF

IF random_mafia	= mafia_4
	random_mafia_timer = mafia_4_timer
	random_mafia_cash =	mafia_4_cash
	random_mafia_flag =	mafia_4_flag
	random_mafia_x = -382.3163
	random_mafia_y = -589.9626
	random_mafia_z = 24.2934
	mafia_stuck_timer = mafia_4_stuck_timer	
	mafia_stuck_x = mafia_4_stuck_x
	mafia_stuck_y = mafia_4_stuck_y
	mafia_stuck_z = mafia_4_stuck_z
ENDIF

IF random_mafia	= mafia_5
	random_mafia_timer = mafia_5_timer
	random_mafia_cash =	mafia_5_cash
	random_mafia_flag =	mafia_5_flag
	random_mafia_x = -379.9821
	random_mafia_y = -591.7104
	random_mafia_z = 24.5318
	mafia_stuck_timer = mafia_5_stuck_timer	
	mafia_stuck_x = mafia_5_stuck_x
	mafia_stuck_y = mafia_5_stuck_y
	mafia_stuck_z = mafia_5_stuck_z
ENDIF

IF random_mafia	= mafia_6
	random_mafia_timer = mafia_6_timer
	random_mafia_cash =	mafia_6_cash
	random_mafia_flag =	mafia_6_flag
	random_mafia_x = -380.1006
	random_mafia_y = -586.4345
	random_mafia_z = 24.2804
	mafia_stuck_timer = mafia_6_stuck_timer	
	mafia_stuck_x = mafia_6_stuck_x
	mafia_stuck_y = mafia_6_stuck_y
	mafia_stuck_z = mafia_6_stuck_z
ENDIF

IF random_mafia	= mafia_7
	random_mafia_timer = mafia_7_timer
	random_mafia_cash =	mafia_7_cash
	random_mafia_flag =	mafia_7_flag
	random_mafia_x = -374.6616
	random_mafia_y = -586.1156
	random_mafia_z = 24.2952
	mafia_stuck_timer = mafia_7_stuck_timer	
	mafia_stuck_x = mafia_7_stuck_x
	mafia_stuck_y = mafia_7_stuck_y
	mafia_stuck_z = mafia_7_stuck_z
ENDIF

IF random_mafia	= mafia_8
	random_mafia_timer = mafia_8_timer
	random_mafia_cash =	mafia_8_cash
	random_mafia_flag =	mafia_8_flag
	random_mafia_x = -376.7446
	random_mafia_y = -586.6362
	random_mafia_z = 24.2921
	mafia_stuck_timer = mafia_8_stuck_timer	
	mafia_stuck_x = mafia_8_stuck_x
	mafia_stuck_y = mafia_8_stuck_y
	mafia_stuck_z = mafia_8_stuck_z
ENDIF

IF random_mafia	= mafia_9
	random_mafia_timer = mafia_9_timer
	random_mafia_cash =	mafia_9_cash
	random_mafia_flag =	mafia_9_flag
	random_mafia_x = -378.8374 
	random_mafia_y = -591.7079 
	random_mafia_z = 24.5318
	mafia_stuck_timer = mafia_9_stuck_timer	
	mafia_stuck_x = mafia_9_stuck_x
	mafia_stuck_y = mafia_9_stuck_y
	mafia_stuck_z = mafia_9_stuck_z
ENDIF

IF random_mafia_flag = 0
	IF LOCATE_CHAR_ON_FOOT_3D random_mafia the_safe_x the_safe_y the_safe_z 1.0 1.0 2.0 0
		IF IS_CHAR_OBJ_NO_OBJ random_mafia
			//IF NOT IS_CHAR_SHOOTING	random_mafia
				SET_CHAR_HEADING random_mafia 226.1973
				SET_CHAR_MONEY random_mafia random_mafia_cash
				CLEAR_CHAR_FOLLOW_PATH random_mafia
				CHAR_SET_IDLE random_mafia
				SET_CHAR_OBJ_NO_OBJ	random_mafia
				SET_CHAR_CROUCH	random_mafia TRUE 999999999
				crouch_timer = game_timer + 1000
				random_mafia_flag = 2
			//ENDIF
		ENDIF
	ENDIF
ENDIF

IF random_mafia_flag = 0
	IF game_timer > random_mafia_timer
		IF NOT IS_CHAR_IN_ANY_CAR random_mafia
			someone_taxing_safe = 0
			IF mafia_1_flag = 2
			OR mafia_2_flag = 2
			OR mafia_3_flag = 2
			OR mafia_4_flag = 2
			OR mafia_5_flag = 2
				someone_taxing_safe = 1
			ENDIF
			IF mafia_6_flag = 2
			OR mafia_7_flag = 2
			OR mafia_8_flag = 2
			OR mafia_9_flag = 2
				someone_taxing_safe = 1
			ENDIF
			
			IF someone_taxing_safe = 0
				CHAR_FOLLOW_PATH random_mafia the_safe_x the_safe_y the_safe_z 4.0 1
			ELSE
				CHAR_FOLLOW_PATH random_mafia random_mafia_x random_mafia_y random_mafia_z 3.0 1
			ENDIF
//			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY the_safe_x the_safe_y the_safe_z 1.0 1.0 2.0
//				CHAR_FOLLOW_PATH random_mafia the_safe_x the_safe_y the_safe_z 4.0 1
//			ELSE
//				CHAR_FOLLOW_PATH random_mafia random_mafia_x random_mafia_y random_mafia_z 3.0 1
//			ENDIF
			random_mafia_timer = game_timer + 1000
		ELSE
			SET_CHAR_OBJ_LEAVE_ANY_CAR random_mafia
		ENDIF
	ENDIF

	IF NOT random_mafia_x = 0.0
		IF LOCATE_CHAR_ON_FOOT_3D random_mafia random_mafia_x random_mafia_y random_mafia_z 1.0 1.0 2.0 0
			SET_CHAR_OBJ_NO_OBJ	random_mafia
			CLEAR_CHAR_FOLLOW_PATH random_mafia
			CHAR_SET_IDLE random_mafia
			IF NOT IS_PLAYER_IN_AREA_3D player1 -386.123 -599.355 24.786 -370.926 -584.437 31.667 0
				TURN_CHAR_TO_FACE_COORD	random_mafia -378.4397 -582.1611 24.2722
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT random_mafia player1
			ENDIF
			random_mafia_timer = game_timer + 3000
			random_mafia_flag = 3
		ENDIF
	ENDIF
ENDIF

IF random_mafia_flag = 2
	IF LOCATE_CHAR_ON_FOOT_3D random_mafia the_safe_x the_safe_y the_safe_z 1.0 1.0 2.0 0
	//	CLEAR_CHAR_FOLLOW_PATH random_mafia
		IF IS_CHAR_OBJ_NO_OBJ random_mafia
	//		CHAR_SET_IDLE random_mafia
	//		SET_CHAR_OBJ_NO_OBJ	random_mafia
			//IF NOT IS_CHAR_SHOOTING	random_mafia
				//GET_CHAR_HEADING random_mafia heading
	//			SET_CHAR_HEED_THREATS random_mafia FALSE
	//			CLEAR_CHAR_THREAT_SEARCH random_mafia
				//IF NOT heading = 226.1973
					//SET_CHAR_HEADING random_mafia 226.1973
					//SET_CHAR_CROUCH	random_mafia TRUE 99999999
				//ENDIF
				IF crouch_timer < game_timer
					SET_CHAR_CROUCH	random_mafia TRUE 999999999
				ENDIF
				
				STORE_SCORE player1 player_score
				IF player_score < 1
					PRINT_NOW FIN_B7 5000 1//~r~The mafia has stolen all your money.
					failed_finale_flag = 1
					RETURN
				ENDIF
				ADD_SCORE player1 -1
				++ random_mafia_cash
				SET_CHAR_MONEY random_mafia random_mafia_cash
			//ENDIF
		ENDIF
	//ELSE
	//SET_CHAR_OBJ_RUN_TO_COORD random_mafia the_safe_x the_safe_y
	// 	SET_CHAR_USE_PEDNODE_SEEK random_mafia FALSE
	ENDIF
ELSE
	IF NOT IS_CHAR_IN_AREA_3D random_mafia -386.507 -600.089 24.286 -370.542 -583.413 31.667 0
		IF LOCATE_CHAR_ON_FOOT_3D random_mafia mafia_stuck_x mafia_stuck_y mafia_stuck_z 2.0 2.0 2.0 0
			IF mafia_stuck_timer > game_timer
				MARK_CHAR_AS_NO_LONGER_NEEDED random_mafia
			ENDIF
		ELSE
			mafia_stuck_timer = game_timer + 5000
			GET_CHAR_COORDINATES random_mafia mafia_stuck_x mafia_stuck_y mafia_stuck_z
		ENDIF
	ENDIF
ENDIF

//IF random_mafia_flag = 3
//	IF game_timer > random_mafia_timer
//		IF IS_POINT_OBSCURED_BY_A_MISSION_ENTITY the_safe_x the_safe_y the_safe_z 1.0 1.0 2.0
//			MARK_CHAR_AS_NO_LONGER_NEEDED random_mafia
//		ENDIF
//		random_mafia_timer = 0
//		random_mafia_flag = 0
//	ENDIF
//ENDIF

IF random_mafia	= mafia_1
	mafia_1_timer = random_mafia_timer
	mafia_1_cash = random_mafia_cash	
	mafia_1_flag = random_mafia_flag
	mafia_1_stuck_timer = mafia_stuck_timer	
	mafia_1_stuck_x = mafia_stuck_x
	mafia_1_stuck_y = mafia_stuck_y
	mafia_1_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_2
	mafia_2_timer = random_mafia_timer
	mafia_2_cash = random_mafia_cash	
	mafia_2_flag = random_mafia_flag	
	mafia_2_stuck_timer = mafia_stuck_timer	
	mafia_2_stuck_x = mafia_stuck_x
	mafia_2_stuck_y = mafia_stuck_y
	mafia_2_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_3
	mafia_3_timer = random_mafia_timer
	mafia_3_cash = random_mafia_cash	
	mafia_3_flag = random_mafia_flag	
	mafia_3_stuck_timer = mafia_stuck_timer	
	mafia_3_stuck_x = mafia_stuck_x
	mafia_3_stuck_y = mafia_stuck_y
	mafia_3_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_4
	mafia_4_timer = random_mafia_timer
	mafia_4_cash = random_mafia_cash	
	mafia_4_flag = random_mafia_flag	
	mafia_4_stuck_timer = mafia_stuck_timer	
	mafia_4_stuck_x = mafia_stuck_x
	mafia_4_stuck_y = mafia_stuck_y
	mafia_4_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_5
	mafia_5_timer = random_mafia_timer
	mafia_5_cash = random_mafia_cash	
	mafia_5_flag = random_mafia_flag	
	mafia_5_stuck_timer = mafia_stuck_timer	
	mafia_5_stuck_x = mafia_stuck_x
	mafia_5_stuck_y = mafia_stuck_y
	mafia_5_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_6
	mafia_6_timer = random_mafia_timer
	mafia_6_cash = random_mafia_cash	
	mafia_6_flag = random_mafia_flag	
	mafia_6_stuck_timer = mafia_stuck_timer	
	mafia_6_stuck_x = mafia_stuck_x
	mafia_6_stuck_y = mafia_stuck_y
	mafia_6_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_7
	mafia_7_timer = random_mafia_timer
	mafia_7_cash = random_mafia_cash	
	mafia_7_flag = random_mafia_flag	
	mafia_7_stuck_timer = mafia_stuck_timer	
	mafia_7_stuck_x = mafia_stuck_x
	mafia_7_stuck_y = mafia_stuck_y
	mafia_7_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_8
	mafia_8_timer = random_mafia_timer
	mafia_8_cash = random_mafia_cash	
	mafia_8_flag = random_mafia_flag	
	mafia_8_stuck_timer = mafia_stuck_timer	
	mafia_8_stuck_x = mafia_stuck_x
	mafia_8_stuck_y = mafia_stuck_y
	mafia_8_stuck_z = mafia_stuck_z
ENDIF

IF random_mafia	= mafia_9
	mafia_9_timer = random_mafia_timer
	mafia_9_cash = random_mafia_cash	
	mafia_9_flag = random_mafia_flag	
	mafia_9_stuck_timer = mafia_stuck_timer	
	mafia_9_stuck_x = mafia_stuck_x
	mafia_9_stuck_y = mafia_stuck_y
	mafia_9_stuck_z = mafia_stuck_z
ENDIF

RETURN


final_cutscene:

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT
SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PED_DENSITY_MULTIPLIER 0.0
CLEAR_AREA -354.419 -569.529 30.0 200.0 0 

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

DELETE_CHAR mafia_1
DELETE_CHAR mafia_2
DELETE_CHAR mafia_3
DELETE_CHAR mafia_4
DELETE_CHAR mafia_5
DELETE_CHAR mafia_6
DELETE_CHAR mafia_7
DELETE_CHAR mafia_8
DELETE_CHAR mafia_9
DELETE_CHAR sonni
DELETE_CHAR vance
DELETE_CHAR boss_guard1
DELETE_CHAR boss_guard2
DELETE_CHAR boss_guard3
DELETE_CHAR boss_guard4
DELETE_CHAR boss_guard5
DELETE_CHAR boss_guard6
DELETE_CHAR boss_guard7
DELETE_CHAR boss_guard8
DELETE_CHAR boss_guard9
DELETE_CHAR boss_guard10
DELETE_CHAR boss_guard11

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 csken

LOAD_SPECIAL_MODEL CUTOBJ01 mfour

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0
ENDWHILE

LOAD_CUTSCENE FINALE
LOAD_END_OF_GAME_TUNE

SET_NEAR_CLIP 0.1
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534

SET_AREA_VISIBLE VIS_MANSION
flag_player_in_mansion = 1
SWITCH_RUBBISH OFF
SET_EXTRA_COLOURS 7 FALSE
LOAD_SCENE -378.4660 -596.1799 24.7818
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken csken

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara mfour01

SET_PLAYER_HEADING player1 270.0

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE
PLAY_END_OF_GAME_TUNE
SET_MUSIC_DOES_FADE FALSE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 12797
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_01 10000 1 //Tommy? 
 
WHILE cs_time < 14715
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_02 10000 1 //Oh my god, Tommy! What happened?
 
WHILE cs_time < 17875
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_03 10000 1 //What does it look like?
 
WHILE cs_time < 19401
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_04 10000 1 //It looks like you ruined your suit! 
 
WHILE cs_time < 21176
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_05 10000 1 //and Tommy, that was a beautiful suit! Tommy, what happened?
 
WHILE cs_time < 26212
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_06 10000 1 //I had a disagreement with a business associate, you know how it is.
 
WHILE cs_time < 29463
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_07 10000 1 //Tommy, I have a disagreement with a business associate, I send them an angry letter. 
 
WHILE cs_time < 32477
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_08 10000 1 //Maybe I pee in their mailbox. I don't start world war three. 
 
WHILE cs_time < 36719
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_09 10000 1 //You know, maybe you should speak to my shrink...
 
WHILE cs_time < 39025
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_10 10000 1 //That stupid prick, Lance...
 
WHILE cs_time < 41031
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_11 10000 1 //Tommy. I never liked that guy, okay?
 
WHILE cs_time < 43337
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_12 10000 1 //He's neurotic, he's insecure, he's self-centered- that guy's an asshole! 
 
WHILE cs_time < 47738
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_13 10000 1 //I'm glad that you took him out!
 
WHILE cs_time < 49016
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_14 10000 1 //I don't think we're gonna be getting any more heat from up north either...
 
WHILE cs_time < 54048
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_15 10000 1 //...'cause there ain't no 'up north', anymore. 
 
WHILE cs_time < 57610
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_16 10000 1 //It's all down south now.
 
WHILE cs_time < 59960
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_17 10000 1 //Wait, does that mean what I think it means, Tommy baby?
 
WHILE cs_time < 62722
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_18 10000 1 //What do you think it means? 
 
WHILE cs_time < 64406
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_19 10000 1 //That we're in charge...  I mean, that you're in charge. Oh, Tommy...
 
WHILE cs_time < 69535
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_20 10000 1 //You know, Ken, this could be the beginning of a beautiful business relationship....
 
WHILE cs_time < 74550
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_21 10000 1 //After all, you're a conniving, backstabbing, two-bit thief 
 
WHILE cs_time < 77761
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_22 10000 1 //and I'm a convicted psychotic killer and drug dealer.
 
WHILE cs_time < 81486
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW FIN3_23 10000 1 //I know. Ain't it beautiful?

WHILE cs_time < 86784//83552
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_mansion = 0
SWITCH_RUBBISH ON
CLEAR_EXTRA_COLOURS FALSE
SET_PLAYER_COORDINATES player1 198.4252 -434.6284 9.5332

START_CREDITS
button_pressed = 0

SET_GENERATE_CARS_AROUND_CAMERA TRUE
GET_GAME_TIMER game_timer
WAIT 0
WAIT 0
SWITCH_WIDESCREEN ON
GET_GAME_TIMER game_timer
credits_shot_timer = game_timer
FORCE_WEATHER_NOW WEATHER_SUNNY

WHILE NOT ARE_CREDITS_FINISHED
	WAIT 0

	GET_GAME_TIMER game_timer

	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			STOP_CREDITS
		ENDIF
	ELSE
		button_pressed = 1
	ENDIF

	IF credits_shot_counter = 0
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION 315.4413 -606.3295 10.9994 0.0 0.0 0.0//BASKETBALL COURTS
			POINT_CAMERA_AT_POINT 315.8044 -605.4032 11.1004 JUMP_CUT
			SET_TIME_OF_DAY 18 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 315.4413 -606.3295 10.9994 random_mafia
//			GET_GROUND_Z_FOR_3D_COORD 315.4413 -606.3295 10.9994 ground_z
//			SET_PLAYER_COORDINATES player1 315.4413 -606.3295 10.9994
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 1
		ENDIF
	ENDIF

	IF credits_shot_counter = 1
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 0
		ENDIF
	ENDIF

	IF credits_shot_counter = 2
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 3
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION -57.0090 -1579.4728 11.6604 0.0 0.0 0.0//washington south daytime
			POINT_CAMERA_AT_POINT -57.1214 -1578.4846 11.7650 JUMP_CUT
			SET_TIME_OF_DAY 14 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 -57.0090 -1579.4728 11.6604 random_mafia
//			SET_PLAYER_COORDINATES player1 -57.0090 -1579.4728 11.6604
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 1
		ENDIF
	ENDIF

	IF credits_shot_counter = 4
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 0
		ENDIF
	ENDIF

	IF credits_shot_counter = 5
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 6
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION -31.4477 -942.5128 11.2897 0.0 0.0 0.0//small mall
			POINT_CAMERA_AT_POINT -30.4814 -942.2845 11.4088 JUMP_CUT
			SET_TIME_OF_DAY 15 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 -31.4477 -942.5128 11.2897 random_mafia
//			SET_PLAYER_COORDINATES player1 -31.4477 -942.5128 11.2897
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 1
		ENDIF
	ENDIF

	IF credits_shot_counter = 7
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
			//flag_faded_out = 0
		ENDIF
	ENDIF

	IF credits_shot_counter = 8
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 9
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION 527.1948 -1101.6581 12.3979 0.0 0.0 0.0//BEACH DAYTIME
			POINT_CAMERA_AT_POINT 526.1959 -1101.6124 12.4088 JUMP_CUT
			SET_TIME_OF_DAY 12 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 527.1948 -1101.6581 12.3979 random_mafia
//			SET_PLAYER_COORDINATES player1 527.1948 -1101.6581 12.3979
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 10
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 11
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 12
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION 329.8244 -1123.4187 29.4180 0.0 0.0 0.0//ocean drive nighttime
			POINT_CAMERA_AT_POINT 329.5483 -1122.4576 29.4027 JUMP_CUT
			SET_TIME_OF_DAY 02 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 329.8244 -1123.4187 29.4180 random_mafia
//			SET_PLAYER_COORDINATES player1 329.8244 -1123.4187 29.4180
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 13
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 14
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 15
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION 420.3749 -179.7319 12.2077 0.0 0.0 0.0//RIVER MIDDAY
			POINT_CAMERA_AT_POINT 420.3214 -178.7335 12.1930 JUMP_CUT
			SET_TIME_OF_DAY 11 00
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 420.3749 -179.7319 12.2077 random_mafia
//			SET_PLAYER_COORDINATES player1 420.3749 -179.7319 12.2077
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 16
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 17
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 18
		IF credits_shot_timer < game_timer
			SET_FIXED_CAMERA_POSITION -397.3825 22.9746 47.9553 0.0 0.0 0.0//RIVER MIDDAY
			POINT_CAMERA_AT_POINT -396.5451 23.4814 47.7505 JUMP_CUT
			SET_TIME_OF_DAY 05 45
			DELETE_CHAR	random_mafia
			CREATE_CHAR PEDTYPE_CIVMALE MALE01 -391.2471 26.5135 25.2721 random_mafia
//			SET_PLAYER_COORDINATES player1 420.3749 -179.7319 12.2077
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 19
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_IN
			credits_shot_timer = game_timer + 20000
			++ credits_shot_counter
		ENDIF
	ENDIF

	IF credits_shot_counter = 20
		IF credits_shot_timer < game_timer
			SET_FADING_COLOUR 0 0 1
			DO_FADE 3000 FADE_OUT
			credits_shot_timer = game_timer + 3500
			credits_shot_counter = 21
		ENDIF
	ENDIF


ENDWHILE

SET_MUSIC_DOES_FADE TRUE
//DO_FADE 1500 FADE_OUT
//WAIT 1500
//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

STOP_END_OF_GAME_TUNE
DELETE_CHAR	random_mafia
SWITCH_WIDESCREEN OFF
SET_GENERATE_CARS_AROUND_CAMERA FALSE
RELEASE_WEATHER

CLEAR_AREA -379.2 -536.4 16.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -379.2 -536.4 16.2
SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_mansion = 0
SWITCH_RUBBISH ON
CLEAR_EXTRA_COLOURS FALSE
LOAD_SCENE -379.2 -536.4 16.2
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_EVERYONE_IGNORE_PLAYER player1 FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PED_DENSITY_MULTIPLIER 1.0
CLEAR_AREA -354.419 -569.529 30.0 200.0 0 

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000


/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

GOTO mission_finale2_passed
	
//////////////////////////////////////////////////////////////////////////////////////////
mission_finale2_failed:///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
PRINT_BIG M_FAIL 5000 1

// handle when the player dies and he has killed sonny
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_PLAYER THREAT_GANG_STREET
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_GANG_PLAYER
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_PLAYER1
SET_GANG_WEAPONS GANG_PLAYER WEAPONTYPE_PISTOL WEAPONTYPE_PISTOL // SCFIX: fix giving tec9 on mission fail
SET_GANG_WEAPONS GANG_STREET WEAPONTYPE_PISTOL WEAPONTYPE_UNARMED
SET_GANG_PED_MODELS GANG_STREET SGA SGB
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG scplayer GANG_PLAYER TRUE
STORE_SCORE player1 player_score
player_score *= -1
ADD_SCORE player1 player_score
ADD_SCORE player1 stored_player_score
RETURN

   

//////////////////////////////////////////////////////////////////////////////////////////
mission_finale2_passed:///////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

flag_finale_mission2_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 30000 5000 1
ADD_SCORE player1 30000
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED FIN_1
PLAYER_MADE_PROGRESS 1
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_PLAYER THREAT_GANG_STREET
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_GANG_PLAYER
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_STREET THREAT_PLAYER1
SET_GANG_WEAPONS GANG_PLAYER WEAPONTYPE_UZI WEAPONTYPE_UZI // SCFIX: always give uzi
SET_GANG_WEAPONS GANG_STREET WEAPONTYPE_PISTOL WEAPONTYPE_UNARMED
SET_GANG_PED_MODELS GANG_STREET SGA SGB
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG scplayer GANG_PLAYER TRUE
START_NEW_SCRIPT gang_member_loop
SET_ALLOW_HURRICANES TRUE

REMOVE_BLIP baron_contact_blip
REMOVE_BLIP protect_contact_blip
//ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -378.3 -579.8 24.5 RADAR_SPRITE_TOMMY protect_contact_blip // SCFIX: remove doubled blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -378.4 -536.9 17.2 RADAR_SPRITE_TOMMY baron_contact_blip // SCFIX: use pickup coords

SET_PED_DENSITY_MULTIPLIER 1.0

IF hunter_created = 0
    PRINT_HELP ( PICK10 ) //Hunter now available from the Army Barracks!
    //CREATE_CAR_GENERATOR -1681.2 -103.7 14.7 180.0 hunter -1 -1 0 0 0 0 10000 gen_car150 //at army barracks
    SWITCH_CAR_GENERATOR gen_car150 101
    hunter_created = 1
ELSE
    PRINT_HELP ( APACHE )
    //CREATE_CAR_GENERATOR -72.4 -1607.9 12.7 0.0 hunter -1 -1 0 0 0 0 10000 south_beach_hunter //at army barracks
    SWITCH_CAR_GENERATOR south_beach_hunter 101
ENDIF

RETURN
		


//////////////////////////////////////////////////////////////////////////////////////////
mission_cleanup_finale2://////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
// handle when the player dies and he has killed sonny
REMOVE_BLIP health_blip
REMOVE_BLIP safe_blip
REMOVE_BLIP health_blip2

//SET_ZONE_PED_INFO ZONE DAY RATIO 0 1 2 3 4 5 6    7 8 Police
SET_ZONE_PED_INFO GANG1 DAY   (12) 0 0 0 0 0 0 1000 0 0 0 // Mansion 
SET_ZONE_PED_INFO GANG1 NIGHT (12) 0 0 0 0 0 0 1000 0 0 0

SWITCH_PED_ROADS_ON -522.414 -662.451 -9.357 -222.414 -502.451 90.643 // ENTIRE MANSION AREA

flag_player_on_finale = 0 // SCFIX

MARK_MODEL_AS_NO_LONGER_NEEDED STRETCH
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
//MARK_MODEL_AS_NO_LONGER_NEEDED KNIFECUR
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9

REMOVE_CHAR_ELEGANTLY mafia_1
REMOVE_CHAR_ELEGANTLY mafia_2
REMOVE_CHAR_ELEGANTLY mafia_3
REMOVE_CHAR_ELEGANTLY mafia_4
REMOVE_CHAR_ELEGANTLY mafia_5
REMOVE_CHAR_ELEGANTLY mafia_6
REMOVE_CHAR_ELEGANTLY mafia_7
REMOVE_CHAR_ELEGANTLY mafia_8
REMOVE_CHAR_ELEGANTLY mafia_9
REMOVE_CHAR_ELEGANTLY sonni
REMOVE_CHAR_ELEGANTLY vance
REMOVE_CHAR_ELEGANTLY boss_guard1
REMOVE_CHAR_ELEGANTLY boss_guard2
REMOVE_CHAR_ELEGANTLY boss_guard3
REMOVE_CHAR_ELEGANTLY boss_guard4
REMOVE_CHAR_ELEGANTLY boss_guard5
REMOVE_CHAR_ELEGANTLY boss_guard6
REMOVE_CHAR_ELEGANTLY boss_guard7
REMOVE_CHAR_ELEGANTLY boss_guard8
REMOVE_CHAR_ELEGANTLY boss_guard9
REMOVE_CHAR_ELEGANTLY boss_guard10
REMOVE_CHAR_ELEGANTLY boss_guard11
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

REMOVE_PICKUP health_pickup_on_roof
REMOVE_PICKUP health_pickup2
REMOVE_PICKUP python_pickup2

GET_GAME_TIMER timer_mobile_start

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN
		


}