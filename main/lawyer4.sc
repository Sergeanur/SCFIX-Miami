MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Lawyer mission 4**************************************
// *******************************************RIOT********************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_lawyer4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_lawyer4_failed
ENDIF

GOSUB mission_cleanup_lawyer4

MISSION_END


// Variables for mission
{
VAR_INT rioter1 rioter2 rioter3 rioter4 rioter5 rioter6 rioter7 rioter8 rioter9 rioter10
VAR_INT rioter11 rioter12 rioter13 rioter14 rioter15 rioter16 rioter17 rioter18 rioter19 rioter20
VAR_INT rioter21 player_killing_rioters	new_intensity law4_barrel2
VAR_INT company_van1 company_van2 company_van3 kill_off_riot_sound
VAR_INT riot_in_progress gate_finished_opening law4_barrel1
VAR_INT securi_guard1 securi_guard2 securi_guard3 company_blip_state
VAR_INT riot_building_up clothes_cut_scene2_played company_van_blip1 company_van_blip2 company_van_blip3
LVAR_INT noised_up_rioter1 noised_up_rioter2 noised_up_rioter3 noised_up_rioter4 noised_up_rioter5  
LVAR_INT noised_up_rioter6 noised_up_rioter7 noised_up_rioter8 noised_up_rioter9 noised_up_rioter10  
LVAR_INT noised_up_rioter11 noised_up_rioter12 noised_up_rioter13 noised_up_rioter14 noised_up_rioter15  
LVAR_INT noised_up_rioter16 
VAR_INT noised_up_rioter17 noised_up_rioter18 noised_up_rioter19 noised_up_rioter20  
VAR_INT noised_up_rioter21 help_for_biffs securi_guard1_gun securi_guard2_gun  
VAR_INT dead_rioter1 dead_rioter2 dead_rioter3 dead_rioter4 dead_rioter5  
VAR_INT dead_rioter6 dead_rioter7 dead_rioter8 dead_rioter9 dead_rioter10  
VAR_INT dead_rioter11 dead_rioter12 dead_rioter13 dead_rioter14 dead_rioter15  
VAR_INT dead_rioter16 dead_rioter17 dead_rioter18 dead_rioter19 dead_rioter20  
VAR_INT dead_rioter21 dead_securi_guard1_drop dead_securi_guard2_drop			
VAR_FLOAT guard_PickupX guard_PickupY guard_PickupZ
			
// ***************************************Mission Start*************************************

mission_start_lawyer4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME LAWYER4
WAIT 0

LOAD_MISSION_TEXT LAWYER4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 110.6 -824.2 9.6 327.9

clothes_shopX =	95.4
clothes_shopY =	-1135.5
clothes_shopZ =	9.4
audio_is_loading = 0
audio_has_loaded   = 0
first_two_samples = 0
second_two_samples = 0
third_two_samples = 0
forth_two_samples = 0
fifth_two_samples = 0
player_killing_rioters = 0
help_for_biffs = 0
riot_in_progress = 0
gate_finished_opening = 0
company_blip_state = 0
riot_building_up = 0
noised_up_rioter1 = 0
noised_up_rioter2 = 0 
noised_up_rioter3 = 0
noised_up_rioter4 = 0
noised_up_rioter5 = 0
noised_up_rioter6 = 0
noised_up_rioter7 = 0
noised_up_rioter8 = 0
noised_up_rioter9 = 0
noised_up_rioter10 = 0
noised_up_rioter11 = 0
noised_up_rioter12 = 0
noised_up_rioter13 = 0
noised_up_rioter14 = 0
noised_up_rioter15 = 0
noised_up_rioter16 = 0
noised_up_rioter17 = 0
noised_up_rioter18 = 0
noised_up_rioter19 = 0
noised_up_rioter20 = 0
noised_up_rioter21 = 0
skip_timer1_acive = 0
dead_rioter1 = 0
dead_rioter2 = 0
dead_rioter3 = 0
dead_rioter4 = 0
dead_rioter5 = 0
dead_rioter6 = 0
dead_rioter7 = 0
dead_rioter8 = 0
dead_rioter9 = 0
dead_rioter10 = 0
dead_rioter11 = 0
dead_rioter12 = 0
dead_rioter13 = 0
dead_rioter14 = 0
dead_rioter15 = 0
dead_rioter16 = 0
dead_rioter17 = 0
dead_rioter18 = 0
dead_rioter19 = 0
dead_rioter20 = 0
dead_rioter21 = 0
kill_off_riot_sound = 0
new_intensity = 127
dead_securi_guard1_drop	= 0
dead_securi_guard2_drop	= 0

CLEAR_HELP

clothes_cut_scene2_played = 0

IF NOT IS_CHAR_DEAD scplayer
AND IS_PLAYER_WEARING player1 player3 // SCFIX: add specific skin check

	UNDRESS_CHAR scplayer player

	LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF

SET_AREA_VISIBLE VIS_LAWYERS 

LOAD_MISSION_AUDIO 1 MONO_8

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_CHARACTER 3 CSavery
LOAD_SPECIAL_MODEL CUTOBJ01 lwchara
LOAD_SPECIAL_MODEL CUTOBJ02 lwcharb
LOAD_SPECIAL_MODEL CUTOBJ03 lcfan
LOAD_SPECIAL_MODEL CUTOBJ04 lawdoor

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ04
	WAIT 0

ENDWHILE

LOAD_SCENE 140.6 -1367.4 13.1

LOAD_CUTSCENE law_4
SET_CUTSCENE_OFFSET 141.441 -1366.722 12.163
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara lwchara

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lwcharb
SET_CUTSCENE_ANIM cs_lwcharb lwcharb

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_lcfan
SET_CUTSCENE_ANIM_TO_LOOP lcfan
SET_CUTSCENE_ANIM cs_lcfan lcfan

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_lawdoor
SET_CUTSCENE_ANIM cs_lawdoor lawdoor

CLEAR_AREA 119.0 -826.8 9.8 0.5 TRUE
SET_PLAYER_COORDINATES player1 119.0 -826.8 9.8
SET_PLAYER_HEADING player1 60.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 45
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_A ) 10000 1 // Mission brief

WHILE cs_time < 4210
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_B ) 10000 1 // Mission brief

WHILE cs_time < 7190
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_C ) 10000 1 // Mission brief

WHILE cs_time < 8052
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_D ) 10000 1 // Mission brief

WHILE cs_time < 9403
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_E ) 10000 1 // Mission brief

WHILE cs_time < 13088
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_F ) 10000 1 // Mission brief

WHILE cs_time < 15052
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_G ) 10000 1 // Mission brief

WHILE cs_time < 19432
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_H ) 10000 1 // Mission brief

WHILE cs_time < 23825
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_I ) 10000 1 // Mission brief

WHILE cs_time < 26892
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_J ) 10000 1 // Mission brief

WHILE cs_time < 32978
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_K ) 10000 1 // Mission brief

WHILE cs_time < 34995
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_L ) 10000 1 // Mission brief

WHILE cs_time < 40136
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_M ) 10000 1 // Mission brief

WHILE cs_time < 46049
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_N ) 10000 1 // Mission brief

WHILE cs_time < 48481
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_O ) 10000 1 // Mission brief

WHILE cs_time < 52177
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_P ) 10000 1 // Mission brief

WHILE cs_time < 56220
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_Q ) 10000 1 // Mission brief

WHILE cs_time < 57286
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW4_R ) 10000 1 // Mission brief

WHILE cs_time < 60052  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE cs_time < 61052  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER


UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE 117.1 -825.6 9.8

WAIT 500

DO_FADE 1500 FADE_IN

REMOVE_PICKUP clothes_pickup2

SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

PRINT_NOW ( LAW1_1 ) 10000 1  //GET A CHANGE OF CLOTHES

ADD_SPRITE_BLIP_FOR_COORD clothes_shopX clothes_shopY clothes_shopZ RADAR_SPRITE_TSHIRT colar_cuffs_blip

ADD_BLIP_FOR_COORD 299.0 -314.6 11.4 lawyer_blip1

REQUEST_MODEL spand
//REQUEST_MODEL HMYAP
LOAD_SPECIAL_CHARACTER 4 spandxa
LOAD_SPECIAL_CHARACTER 5 spandxb
REQUEST_MODEL nitestick
REQUEST_MODEL GDa
REQUEST_MODEL barrel4
REQUEST_MODEL colt45
REQUEST_ANIMATION riot


WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
OR NOT HAS_ANIMATION_LOADED riot
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED spand
OR NOT HAS_MODEL_LOADED nitestick
OR NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED barrel4
OR NOT HAS_MODEL_LOADED colt45
	WAIT 0

ENDWHILE


// START OF MISSION
 

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 299.0 -314.6 11.4 70.0 70.0 30.0 FALSE
	WAIT 0

	IF clothes_cut_scene2_played = 0
		IF LOCATE_PLAYER_ON_FOOT_3D player1 clothes_shopX clothes_shopY clothes_shopZ 1.2 1.2 3.0 TRUE
			GOSUB clothes_cut_scene2	
		ENDIF
	ENDIF

ENDWHILE

SET_RIOT_INTENSITY new_intensity

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 304.7 -316.8 10.9 rioter1
CLEAR_CHAR_THREAT_SEARCH rioter1
SET_CHAR_PERSONALITY rioter1 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter1 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter1 TRUE
SET_CHAR_WAIT_STATE rioter1 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 302.8 -318.8 10.9 rioter2
CLEAR_CHAR_THREAT_SEARCH rioter2
SET_CHAR_PERSONALITY rioter2 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter2 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter2 TRUE
SET_CHAR_WAIT_STATE rioter2 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 301.6 -316.7 10.9 rioter3
CLEAR_CHAR_THREAT_SEARCH rioter3
SET_CHAR_PERSONALITY rioter3 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter3 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter3 TRUE
SET_CHAR_WAIT_STATE rioter3 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 299.8 -318.2 10.9 rioter4
CLEAR_CHAR_THREAT_SEARCH rioter4
SET_CHAR_PERSONALITY rioter4 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter4 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter4 TRUE	  
SET_CHAR_WAIT_STATE rioter4 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 300.9 -321.6 10.9 rioter5
CLEAR_CHAR_THREAT_SEARCH rioter5
SET_CHAR_PERSONALITY rioter5 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter5 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter5 TRUE
SET_CHAR_WAIT_STATE rioter5 WAITSTATE_RIOT 99999999
												  
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 299.0 -322.1 10.9 rioter6
CLEAR_CHAR_THREAT_SEARCH rioter6
SET_CHAR_PERSONALITY rioter6 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter6 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter6 TRUE
SET_CHAR_WAIT_STATE rioter6 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 295.0 -320.7 10.9 rioter7
CLEAR_CHAR_THREAT_SEARCH rioter7
SET_CHAR_PERSONALITY rioter7 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter7 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter7 TRUE
SET_CHAR_WAIT_STATE rioter7 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 293.5 -317.8 10.9 rioter8
CLEAR_CHAR_THREAT_SEARCH rioter8
SET_CHAR_PERSONALITY rioter8 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter8 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter8 TRUE
SET_CHAR_WAIT_STATE rioter8 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 296.2 -325.3 10.9  rioter9
CLEAR_CHAR_THREAT_SEARCH rioter9
SET_CHAR_PERSONALITY rioter9 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter9 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter9 TRUE
SET_CHAR_WAIT_STATE rioter9 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 299.3 -329.3 10.9 rioter10
CLEAR_CHAR_THREAT_SEARCH rioter10
SET_CHAR_PERSONALITY rioter10 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter10 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter10 TRUE
SET_CHAR_WAIT_STATE rioter10 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 303.8 -329.7 10.9 rioter11
CLEAR_CHAR_THREAT_SEARCH rioter11
SET_CHAR_PERSONALITY rioter11 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter11 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter11 TRUE
SET_CHAR_WAIT_STATE rioter11 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 308.5 -328.4 10.9 rioter12
CLEAR_CHAR_THREAT_SEARCH rioter12
SET_CHAR_PERSONALITY rioter12 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter12 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter12 TRUE
SET_CHAR_WAIT_STATE rioter12 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 310.2 -324.2 10.9 rioter13
CLEAR_CHAR_THREAT_SEARCH rioter13
SET_CHAR_PERSONALITY rioter13 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter13 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter13 TRUE
SET_CHAR_WAIT_STATE rioter13 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 305.6 -322.2 10.9 rioter14
CLEAR_CHAR_THREAT_SEARCH rioter14
SET_CHAR_PERSONALITY rioter14 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter14 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter14 TRUE
SET_CHAR_WAIT_STATE rioter14 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 300.0 -317.5 10.9 rioter15
CLEAR_CHAR_THREAT_SEARCH rioter15
SET_CHAR_PERSONALITY rioter15 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter15 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter15 TRUE
SET_CHAR_WAIT_STATE rioter15 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 294.9 -317.6 10.9 rioter16
CLEAR_CHAR_THREAT_SEARCH rioter16
SET_CHAR_PERSONALITY rioter16 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter16 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter16 TRUE
SET_CHAR_WAIT_STATE rioter16 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 291.0 -320.0 10.9 rioter17
CLEAR_CHAR_THREAT_SEARCH rioter17
SET_CHAR_PERSONALITY rioter17 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter17 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter17 TRUE
SET_CHAR_WAIT_STATE rioter17 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 293.0 -324.8 10.9 rioter18
CLEAR_CHAR_THREAT_SEARCH rioter18
SET_CHAR_PERSONALITY rioter18 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter18 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter18 TRUE
SET_CHAR_WAIT_STATE rioter18 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 291.6 -317.2 10.9 rioter19
CLEAR_CHAR_THREAT_SEARCH rioter19
SET_CHAR_PERSONALITY rioter19 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter19 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter19 TRUE
SET_CHAR_WAIT_STATE rioter19 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 301.1 -324.0 10.9 rioter20
CLEAR_CHAR_THREAT_SEARCH rioter20
SET_CHAR_PERSONALITY rioter20 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter20 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter20 TRUE
SET_CHAR_WAIT_STATE rioter20 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 297.6 -327.649 10.9 rioter21
CLEAR_CHAR_THREAT_SEARCH rioter21
SET_CHAR_PERSONALITY rioter21 PEDSTAT_TOUGH_GUY
//SET_CHAR_HEADING rioter21 100.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter21 TRUE
SET_CHAR_WAIT_STATE rioter21 WAITSTATE_RIOT 99999999

CREATE_CHAR PEDTYPE_CIVMALE GDa 301.2 -311.5 10.9 securi_guard1 // SCFIX: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH securi_guard1
SET_CHAR_PERSONALITY securi_guard1 PEDSTAT_TOUGH_GUY
SET_CHAR_HEADING securi_guard1 180.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard1 TRUE
GIVE_WEAPON_TO_CHAR securi_guard1 WEAPONTYPE_NIGHTSTICK 0

CREATE_CHAR PEDTYPE_CIVMALE GDa 303.2 -311.5 10.9 securi_guard2 // SCFIX: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH securi_guard2
SET_CHAR_PERSONALITY securi_guard2 PEDSTAT_TOUGH_GUY
SET_CHAR_HEADING securi_guard2 180.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard2 TRUE
GIVE_WEAPON_TO_CHAR securi_guard2 WEAPONTYPE_NIGHTSTICK 0

CREATE_CHAR PEDTYPE_CIVMALE GDa 304.0 -298.7 10.9 securi_guard3 // SCFIX: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH securi_guard3
SET_CHAR_PERSONALITY securi_guard3 PEDSTAT_TOUGH_GUY
SET_CHAR_HEADING securi_guard3 180.0
SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard3 TRUE
SET_CHAR_HEALTH securi_guard3 70
GIVE_WEAPON_TO_CHAR securi_guard3 WEAPONTYPE_PISTOL 300
SET_CHAR_STAY_IN_SAME_PLACE securi_guard3 TRUE

CREATE_CAR spand 286.7 -302.1 11.9 company_van1
SET_CAR_HEADING company_van1 270.0

CREATE_CAR spand 312.2 -304.7 11.9 company_van2
SET_CAR_HEADING company_van2 90.0

CREATE_CAR spand 312.2 -300.7 11.9 company_van3
SET_CAR_HEADING company_van3 90.0

CREATE_OBJECT barrel4 309.3 -298.6 10.9 law4_barrel1
CREATE_OBJECT barrel4 284.3 -312.4 10.9 law4_barrel2

MAKE_OBJECT_TARGETTABLE	law4_barrel2
MAKE_OBJECT_TARGETTABLE law4_barrel1

TIMERB = 0

WHILE NOT IS_CAR_DEAD company_van1
OR NOT IS_CAR_DEAD company_van2
OR NOT IS_CAR_DEAD company_van3
	WAIT 0


	IF NOT IS_CHAR_DEAD	rioter1
		IF NOT IS_CHAR_HEALTH_GREATER rioter1 99
		AND noised_up_rioter1 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter1 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter1 player1
			noised_up_rioter1 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter1 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter1 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter2
		IF NOT IS_CHAR_HEALTH_GREATER rioter2 99
		AND noised_up_rioter2 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter2 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter2 player1
			noised_up_rioter2 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter2 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter2 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter3
		IF NOT IS_CHAR_HEALTH_GREATER rioter3 99
		AND noised_up_rioter3 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter3 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter3 player1
			noised_up_rioter3 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter3 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter3 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter4
		IF NOT IS_CHAR_HEALTH_GREATER rioter4 99
		AND noised_up_rioter4 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter4 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter4 player1
			noised_up_rioter4 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter4 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter4 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter5
		IF NOT IS_CHAR_HEALTH_GREATER rioter5 99
		AND noised_up_rioter5 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter5 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter5 player1
			noised_up_rioter5 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter5 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter5 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter6
		IF NOT IS_CHAR_HEALTH_GREATER rioter6 99
		AND noised_up_rioter6 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter6 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter6 player1
			noised_up_rioter6 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter6 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter6 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter7
		IF NOT IS_CHAR_HEALTH_GREATER rioter7 99
		AND noised_up_rioter7 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter7 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter7 player1
			noised_up_rioter7 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter7 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter7 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter8
		IF NOT IS_CHAR_HEALTH_GREATER rioter8 99
		AND noised_up_rioter8 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter8 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter8 player1
			noised_up_rioter8 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter8 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter8 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter9
		IF NOT IS_CHAR_HEALTH_GREATER rioter9 99
		AND noised_up_rioter9 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter9 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter9 player1
			noised_up_rioter9 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter9 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter9 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter10
		IF NOT IS_CHAR_HEALTH_GREATER rioter10 99
		AND noised_up_rioter10 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter10 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter10 player1
			noised_up_rioter10 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter10 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter10 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter11
		IF NOT IS_CHAR_HEALTH_GREATER rioter11 99
		AND noised_up_rioter11 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter11 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter11 player1
			noised_up_rioter11 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter11 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter11 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter12
		IF NOT IS_CHAR_HEALTH_GREATER rioter12 99
		AND noised_up_rioter12 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter12 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter12 player1
			noised_up_rioter12 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter12 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter12 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter13
		IF NOT IS_CHAR_HEALTH_GREATER rioter13 99
		AND noised_up_rioter13 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter13 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter13 player1
			noised_up_rioter13 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter13 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter13 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter14
		IF NOT IS_CHAR_HEALTH_GREATER rioter14 99
		AND noised_up_rioter14 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter14 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter14 player1
			noised_up_rioter14 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter14 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter14 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter15
		IF NOT IS_CHAR_HEALTH_GREATER rioter15 99
		AND noised_up_rioter15 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter15 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter15 player1
			noised_up_rioter15 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter15 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter15 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter16
		IF NOT IS_CHAR_HEALTH_GREATER rioter16 99
		AND noised_up_rioter16 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter16 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter16 player1
			noised_up_rioter16 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter16 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter16 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter17
		IF NOT IS_CHAR_HEALTH_GREATER rioter17 99
		AND noised_up_rioter17 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter17 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter17 player1
			noised_up_rioter17 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter17 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter17 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter18
		IF NOT IS_CHAR_HEALTH_GREATER rioter18 99
		AND noised_up_rioter18 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter18 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter18 player1
			noised_up_rioter18 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter18 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter18 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter19
		IF NOT IS_CHAR_HEALTH_GREATER rioter19 99
		AND noised_up_rioter19 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter19 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter19 player1
			noised_up_rioter19 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter19 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter19 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter20
		IF NOT IS_CHAR_HEALTH_GREATER rioter20 99
		AND noised_up_rioter20 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter20 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter20 player1
			noised_up_rioter20 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter20 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter20 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	rioter21
		IF NOT IS_CHAR_HEALTH_GREATER rioter21 99
		AND noised_up_rioter21 = 0
		AND riot_in_progress = 0
			riot_building_up ++
			CLEAR_CHAR_WAIT_STATE rioter21 
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter21 player1
			noised_up_rioter21 = 1		 
		ENDIF
	ELSE 
		IF dead_rioter21 = 0
			player_killing_rioters ++
			GOSUB new_intensity
			dead_rioter21 = 1
		ENDIF
	ENDIF

	IF riot_in_progress = 0
		IF riot_building_up	> 3
			GOSUB start_the_riot
		ENDIF

		IF player_killing_rioters > 2
			//clothes_cut_scene2_played = 0
			GOSUB start_the_riot
		ENDIF
	ENDIF

	IF player_killing_rioters >  14
		IF kill_off_riot_sound = 0
			SET_RIOT_INTENSITY 0
			kill_off_riot_sound = 1
		ENDIF
	ENDIF

	IF riot_in_progress = 0
		IF clothes_cut_scene2_played = 0
			IF LOCATE_PLAYER_ON_FOOT_3D player1 clothes_shopX clothes_shopY clothes_shopZ 1.2 1.2 3.0 TRUE
				GOSUB clothes_cut_scene2	
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	securi_guard1
		IF dead_securi_guard1_drop = 0
			IF DOES_CHAR_EXIST securi_guard1
				GET_DEAD_CHAR_PICKUP_COORDS securi_guard1 guard_PickupX guard_PickupY guard_PickupZ
				guard_PickupZ = guard_PickupZ + 0.5
				CREATE_PICKUP_WITH_AMMO colt45 PICKUP_ONCE 17 guard_PickupX guard_PickupY guard_PickupZ securi_guard1_gun
			ENDIF
			dead_securi_guard1_drop = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD securi_guard2
		IF dead_securi_guard2_drop = 0
			IF DOES_CHAR_EXIST securi_guard2
				GET_DEAD_CHAR_PICKUP_COORDS securi_guard2 guard_PickupX guard_PickupY guard_PickupZ
				guard_PickupZ = guard_PickupZ + 0.5
				CREATE_PICKUP_WITH_AMMO colt45 PICKUP_ONCE 17 guard_PickupX guard_PickupY guard_PickupZ securi_guard2_gun
			ENDIF
			dead_securi_guard2_drop = 1
		ENDIF
	ENDIF

	IF riot_in_progress = 1
		IF TIMERB > 2000
			IF gate_finished_opening = 0

                IF NOT IS_CHAR_DEAD	securi_guard1
				OR NOT IS_CHAR_DEAD securi_guard2

					SET_PLAYER_CONTROL player1 OFF
					SWITCH_WIDESCREEN ON

					LOAD_MISSION_AUDIO 1 LAW4_10  //Rich management suck!  ???

					SET_FIXED_CAMERA_POSITION 303.649 -309.100 13.430 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT 303.292 -309.982 13.122 JUMP_CUT

					WAIT 500

					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
						
					ENDWHILE
					

					
					IF HAS_MISSION_AUDIO_LOADED 1
						PLAY_MISSION_AUDIO 1
						PRINT_NOW ( LAW4_5 ) 2000 1	//Sticks out boys! Let's crack some commie skulls!
					ENDIF
				
				ENDIF

				REMOVE_BLIP	lawyer_blip1
				REMOVE_BLIP colar_cuffs_blip

				IF NOT IS_CAR_DEAD company_van1
					ADD_BLIP_FOR_CAR company_van1 company_van_blip1
				ENDIF
				IF NOT IS_CAR_DEAD company_van2
					ADD_BLIP_FOR_CAR company_van2 company_van_blip2
				ENDIF
				IF NOT IS_CAR_DEAD company_van3
					ADD_BLIP_FOR_CAR company_van3 company_van_blip3
				ENDIF
                
				ADD_ONE_OFF_SOUND 298.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_CLUNK
				ADD_CONTINUOUS_SOUND 298.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop

				WHILE NOT SLIDE_OBJECT strike_gate 304.0 -313.6 11.0 0.1 0.1 0.0 FALSE
					WAIT 0								 
				ENDWHILE

				REMOVE_SOUND gate_slide_loop
				ADD_ONE_OFF_SOUND 304.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_CLUNK
				
				IF NOT IS_CHAR_DEAD securi_guard1
					SET_CHAR_PERSONALITY securi_guard1 PEDSTAT_PSYCHO
					SET_CHAR_THREAT_SEARCH securi_guard1 THREAT_CIVMALE
					SET_CHAR_THREAT_SEARCH securi_guard1 THREAT_PLAYER1
				ENDIF

				IF NOT IS_CHAR_DEAD securi_guard2
					SET_CHAR_PERSONALITY securi_guard2 PEDSTAT_PSYCHO
					SET_CHAR_THREAT_SEARCH securi_guard2 THREAT_CIVMALE
					SET_CHAR_THREAT_SEARCH securi_guard2 THREAT_PLAYER1
				ENDIF

				IF NOT IS_CHAR_DEAD securi_guard3
					//SET_CHAR_PERSONALITY securi_guard3 PEDSTAT_PSYCHO
					SET_CHAR_THREAT_SEARCH securi_guard3 THREAT_PLAYER1
					SET_CHAR_ACCURACY securi_guard3 10
				ENDIF

				IF NOT IS_CHAR_DEAD	securi_guard1
				OR NOT IS_CHAR_DEAD securi_guard2
					SET_PLAYER_CONTROL player1 ON
					SWITCH_WIDESCREEN OFF
					RESTORE_CAMERA_JUMPCUT
					SET_CAMERA_BEHIND_PLAYER
				ENDIF

			PRINT_NOW ( LAW4_14 ) 8000 1 //Destory the vans

			gate_finished_opening = 1
				
			ENDIF
		ENDIF
	
	ELSE //riot_in_progress = 0

		IF LOCATE_PLAYER_ON_FOOT_3D player1 299.0 -314.6 11.4 20.0 20.0 10.0 FALSE
			IF first_two_samples = 0
			AND TIMERB > 6000
				IF audio_is_loading = 0
					LOAD_MISSION_AUDIO 1 LAW4_1a
					LOAD_MISSION_AUDIO 2 LAW4_1b
					audio_is_loading = 1
				ELSE
					IF HAS_MISSION_AUDIO_LOADED	1
					AND HAS_MISSION_AUDIO_LOADED 2
						audio_has_loaded = 1
					ENDIF
				ENDIF

				IF audio_has_loaded = 1
					PLAY_MISSION_AUDIO 1
					PRINT_NOW ( LAW4_1 ) 3000 1	//Please disperse. The management will discuss any grievances in the appropriate manner!
					IF HAS_MISSION_AUDIO_FINISHED 1
					AND TIMERB > 19000
						PLAY_MISSION_AUDIO 2 //Go back to your homes!
						PRINT_NOW ( LAW4_2 ) 3000 1
						first_two_samples = 1
						second_two_samples = 0
						audio_is_loading = 0
						audio_has_loaded = 0
						TIMERB = 0		
					ENDIF
				ENDIF
			ENDIF

			IF first_two_samples = 1
			AND second_two_samples = 0
			AND TIMERB > 10000 
				IF audio_is_loading = 0
					LOAD_MISSION_AUDIO 1 LAW4_1c
					LOAD_MISSION_AUDIO 2 LAW4_1d
					audio_is_loading = 1
				ELSE
					IF HAS_MISSION_AUDIO_LOADED	1
					AND HAS_MISSION_AUDIO_LOADED 2
						audio_has_loaded = 1
					ENDIF
				ENDIF

				IF audio_has_loaded = 1
					PLAY_MISSION_AUDIO 1
					PRINT_NOW ( LAW4_3 ) 2000 1	//This is inapropriate!
					IF HAS_MISSION_AUDIO_FINISHED 1
					AND TIMERB > 23000
						PLAY_MISSION_AUDIO 2
						PRINT_NOW ( LAW4_4 ) 2000 1	//You will all end up pawpers!
						second_two_samples = 1
						first_two_samples = 0
						audio_is_loading = 0
						audio_has_loaded = 0
						TIMERB = 0
					ENDIF
				ENDIF
			ENDIF

		ENDIF //LOCATE_PLAYER_ON_FOOT_3D player1 299.0 -314.6 11.4 20.0 20.0 10.0 FALSE
	ENDIF //riot_in_progress = 1

	IF help_for_biffs = 0
		
		IF IS_PLAYER_IN_AREA_3D Player1 315.9 -313.0 9.0 282.4 -297.7 15.0 FALSE
			IF NOT IS_CHAR_DEAD securi_guard3 
				SET_PLAYER_CONTROL player1 OFF
				SET_FIXED_CAMERA_POSITION 301.571 -303.655 15.242 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 302.286 -303.089 14.833 JUMP_CUT
			ENDIF

			PRINT_HELP ( HELP38 ) //If you take out someone who's holding a weapon, they will drop it
			
			WAIT 500

			TIMERA = 0

			WHILE NOT TIMERA > 2500
				WAIT 0

				IF IS_BUTTON_PRESSED PAD1 cross
					WHILE IS_BUTTON_PRESSED	PAD1 cross
						WAIT 0

						IF TIMERA > 2500
							GOTO skip_to_end_biff
						ENDIF

					ENDWHILE
					GOTO skip_to_end_biff
				ENDIF

			ENDWHILE

			TIMERA = 0
			PRINT_HELP ( HELP39 ) //You can target and shoot explosive barrels but keep your distance


			WHILE NOT TIMERA > 3500
				WAIT 0

				IF IS_BUTTON_PRESSED PAD1 cross
					WHILE IS_BUTTON_PRESSED	PAD1 cross
						WAIT 0

						IF TIMERA > 3500
							GOTO skip_to_end_biff
						ENDIF

					ENDWHILE
					GOTO skip_to_end_biff
				ENDIF
				 
			ENDWHILE
			
			skip_to_end_biff:
			
			SET_PLAYER_CONTROL player1 ON
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			IF NOT IS_CHAR_DEAD	securi_guard3
				SET_CHAR_STAY_IN_SAME_PLACE securi_guard3 FALSE
			ENDIF

			GET_CONTROLLER_MODE controlmode
			IF controlmode = 3
				PRINT_HELP ( HELP58 ) // While targeting you can press the ~h~L2 button or R2 ~w~button to cycle through targets.
			ELSE
				PRINT_HELP ( HELP59 ) // While targeting you can press the ~h~L1 button, L2 button or R2 ~w~button to cycle through targets.
			ENDIF

			IF gate_finished_opening = 0
				IF NOT IS_CHAR_DEAD securi_guard1
					SET_CHAR_PERSONALITY securi_guard1 PEDSTAT_PSYCHO
					SET_CHAR_THREAT_SEARCH securi_guard1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT securi_guard1 player1
				ENDIF

				IF NOT IS_CHAR_DEAD securi_guard2
					SET_CHAR_PERSONALITY securi_guard2 PEDSTAT_PSYCHO
					SET_CHAR_THREAT_SEARCH securi_guard2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT securi_guard2 player1
				ENDIF

				IF NOT IS_CHAR_DEAD securi_guard3
					SET_CHAR_THREAT_SEARCH securi_guard3 THREAT_PLAYER1
					SET_CHAR_ACCURACY securi_guard3 10
				ENDIF
			ENDIF
			help_for_biffs = 1	
		ENDIF //IF IS_PLAYER_IN_AREA_3D Player1 315.9 -313.0 9.0 282.4 -297.7 15.0 FALSE
	ENDIF //help_for_biffs = 0


	IF company_blip_state = 0
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 299.0 -314.6 11.4 20.0 20.0 10.0 FALSE
			PRINT_NOW ( LAW4_13 ) 8000 1 //Duff them up
			TIMERB = 0
			company_blip_state = 1
		ENDIF
	ENDIF		 

	GOSUB check_company_vans

ENDWHILE

IF gate_finished_opening = 0
	ADD_ONE_OFF_SOUND 298.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_CLUNK
	ADD_CONTINUOUS_SOUND 298.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop

	WHILE NOT SLIDE_OBJECT strike_gate 304.0 -313.6 11.0 0.15 0.15 0.0 FALSE
		WAIT 0								 
	ENDWHILE

	REMOVE_SOUND gate_slide_loop
	ADD_ONE_OFF_SOUND 304.0 -313.6 11.0 SOUND_POLICE_CELL_DOOR_CLUNK
ENDIF

GOTO mission_lawyer4_passed

}



 // Mission lawyer4 failed

mission_lawyer4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
SET_OBJECT_COORDINATES strike_gate 298.0 -313.6 11.0 
RETURN

   

// mission lawyer4 passed

mission_lawyer4_passed:

flag_lawyer_mission4_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000 
REGISTER_MISSION_PASSED	LAW_4
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP lawyer_contact_blip
REMOVE_BLIP	sergio_contact_blip
bbat_in_stock = 1
CREATE_CLOTHES_PICKUP 364.2 1086.1 19.0 3 clothes_pickup3
clothes3_created = 1
START_NEW_SCRIPT cloth2
ADD_SPRITE_BLIP_FOR_CONTACT_POINT sergioX sergioY sergioZ the_sergio_blip sergio_contact_blip
START_NEW_SCRIPT serg_mission1_loop
RETURN
		

// mission cleanup

mission_cleanup_lawyer4:			
			
flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP	lawyer_blip1
REMOVE_BLIP colar_cuffs_blip
REMOVE_BLIP company_van_blip1
REMOVE_BLIP company_van_blip2
REMOVE_BLIP company_van_blip3
MARK_MODEL_AS_NO_LONGER_NEEDED spand
MARK_MODEL_AS_NO_LONGER_NEEDED nitestick
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_MODEL_AS_NO_LONGER_NEEDED colt45

IF clothes2_created = 1
    CREATE_CLOTHES_PICKUP 97.5 -1133.6 10.4 2 clothes_pickup2
ENDIF

REMOVE_PICKUP securi_guard1_gun
REMOVE_PICKUP securi_guard2_gun
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
SET_RIOT_INTENSITY 0
IF NOT IS_CHAR_DEAD	rioter1
	CLEAR_CHAR_WAIT_STATE rioter1 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter1 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter2
	CLEAR_CHAR_WAIT_STATE rioter2 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter2 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter3
	CLEAR_CHAR_WAIT_STATE rioter3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter3 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter4
	CLEAR_CHAR_WAIT_STATE rioter4 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter4 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter5
	CLEAR_CHAR_WAIT_STATE rioter5 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter5 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter6
	CLEAR_CHAR_WAIT_STATE rioter6 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter6 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter7
	CLEAR_CHAR_WAIT_STATE rioter7 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter7 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter8
	CLEAR_CHAR_WAIT_STATE rioter8 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter8 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter9
	CLEAR_CHAR_WAIT_STATE rioter9 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter9 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter10
	CLEAR_CHAR_WAIT_STATE rioter10 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter10 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter11
	CLEAR_CHAR_WAIT_STATE rioter11 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter11 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter12
	CLEAR_CHAR_WAIT_STATE rioter12 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter12 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter13
	CLEAR_CHAR_WAIT_STATE rioter13 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter13 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter14
	CLEAR_CHAR_WAIT_STATE rioter14 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter14 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter15
	CLEAR_CHAR_WAIT_STATE rioter15 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter15 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter16
	CLEAR_CHAR_WAIT_STATE rioter16 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter16 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter17
	CLEAR_CHAR_WAIT_STATE rioter17 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter17 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter18
	CLEAR_CHAR_WAIT_STATE rioter18  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter18 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter19
	CLEAR_CHAR_WAIT_STATE rioter19 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter19 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter20
	CLEAR_CHAR_WAIT_STATE rioter20 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter20 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	rioter21
	CLEAR_CHAR_WAIT_STATE rioter21 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER rioter21 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	securi_guard1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard1 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	securi_guard2
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard2 FALSE
ENDIF
IF NOT IS_CHAR_DEAD	securi_guard3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER securi_guard3 FALSE
ENDIF

REMOVE_ANIMATION riot
MISSION_HAS_FINISHED
RETURN

{
start_the_riot:

WAIT 0

	IF NOT IS_CHAR_DEAD rioter1
		CLEAR_CHAR_WAIT_STATE rioter1
		SET_CHAR_PERSONALITY rioter1 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter1 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter1 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter2
		CLEAR_CHAR_WAIT_STATE rioter2
		SET_CHAR_PERSONALITY rioter2 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter2 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter2 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter3
		CLEAR_CHAR_WAIT_STATE rioter3
		SET_CHAR_PERSONALITY rioter3 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter3 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter3 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter4
		CLEAR_CHAR_WAIT_STATE rioter4
		SET_CHAR_PERSONALITY rioter4 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter4 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter4 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter5
		CLEAR_CHAR_WAIT_STATE rioter5
		SET_CHAR_PERSONALITY rioter5 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter5 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter5 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter6
		CLEAR_CHAR_WAIT_STATE rioter6
		SET_CHAR_PERSONALITY rioter6 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter6 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter6 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter7
		CLEAR_CHAR_WAIT_STATE rioter7
		SET_CHAR_PERSONALITY rioter7 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter7 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter7 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter8
		CLEAR_CHAR_WAIT_STATE rioter8
		SET_CHAR_PERSONALITY rioter8 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter8 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter8 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter9
		CLEAR_CHAR_WAIT_STATE rioter9
		SET_CHAR_PERSONALITY rioter9 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter9 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter9 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter10
		CLEAR_CHAR_WAIT_STATE rioter10
		SET_CHAR_PERSONALITY rioter10 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter10 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter10 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter11
		CLEAR_CHAR_WAIT_STATE rioter11
		SET_CHAR_PERSONALITY rioter11 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter11 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter11 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter12
		CLEAR_CHAR_WAIT_STATE rioter12
		SET_CHAR_PERSONALITY rioter12 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter12 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter12 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter13
		CLEAR_CHAR_WAIT_STATE rioter13
		SET_CHAR_PERSONALITY rioter13 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter13 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter13 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter14
		CLEAR_CHAR_WAIT_STATE rioter14
		SET_CHAR_PERSONALITY rioter14 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter14 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter14 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter15
		CLEAR_CHAR_WAIT_STATE rioter15
		SET_CHAR_PERSONALITY rioter15 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter15 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter15 THREAT_PLAYER1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter16
		CLEAR_CHAR_WAIT_STATE rioter16
		SET_CHAR_PERSONALITY rioter16 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter16 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter16 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD rioter17
		CLEAR_CHAR_WAIT_STATE rioter17
		SET_CHAR_PERSONALITY rioter17 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter17 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter17 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD rioter18
		CLEAR_CHAR_WAIT_STATE rioter18
		SET_CHAR_PERSONALITY rioter18 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter18 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter18 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD rioter19
		CLEAR_CHAR_WAIT_STATE rioter19
		SET_CHAR_PERSONALITY rioter19 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter19 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter19 THREAT_PLAYER1
	ENDIF

	IF NOT IS_CHAR_DEAD rioter20
		CLEAR_CHAR_WAIT_STATE rioter20
		SET_CHAR_PERSONALITY rioter20 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter20 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter20 THREAT_PLAYER1
	ENDIF
	
	IF NOT IS_CHAR_DEAD rioter21
		CLEAR_CHAR_WAIT_STATE rioter21
		SET_CHAR_PERSONALITY rioter21 PEDSTAT_PSYCHO
		SET_CHAR_THREAT_SEARCH rioter21 THREAT_CIVMALE
		SET_CHAR_THREAT_SEARCH rioter21 THREAT_PLAYER1
	ENDIF


IF clothes_cut_scene2_played = 0

	IF NOT IS_CHAR_DEAD rioter1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter1 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter3
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter3 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter5
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter5 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter7
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter7 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter9
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter9 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter11
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter11 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter13
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter13 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter15
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter15 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter17
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter17 player1
	ENDIF
	IF NOT IS_CHAR_DEAD rioter19
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT rioter19 player1
	ENDIF

ENDIF

riot_in_progress = 1
TIMERB = 0

RETURN



clothes_cut_scene2:

// **************************************(START) CHANGE OF CLOTHES CUT SCENE*********************************************


SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 91.813 -1131.116 17.251 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 92.390 -1131.740 16.724 JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 96.4 -1136.7

WAIT 1300

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF NOT IS_WANTED_LEVEL_GREATER player1 2
	CLEAR_WANTED_LEVEL player1
ENDIF

IF NOT IS_CHAR_DEAD scplayer

	UNDRESS_CHAR scplayer player3

	LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF

CLEAR_AREA 94.9 -1135.0 9.4 1.0 FALSE
SET_CHAR_OBJ_NO_OBJ scplayer
SET_PLAYER_COORDINATES player1 94.9 -1135.0 9.4
SET_PLAYER_HEADING player1 57.9
SET_CURRENT_PLAYER_WEAPON Player1 WEAPONTYPE_UNARMED

DO_FADE 1500 FADE_IN

SET_FIXED_CAMERA_POSITION 94.027 -1134.133 10.002 0.0 0.0 0.0 //ROTATE UP
POINT_CAMERA_AT_POINT 94.724 -1134.820 9.797 JUMP_CUT

WAIT 1000

SET_INTERPOLATION_PARAMETERS 5.0 3000
SET_FIXED_CAMERA_POSITION 94.027 -1134.133 10.002 0.0 0.0 0.0 //ROTATE UP
POINT_CAMERA_AT_POINT 94.656 -1134.754 10.469 INTERPOLATION

TIMERB = 0

WHILE NOT TIMERB > 5000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		skip_timer1_acive = 1
		GOTO skip_timer4
	ENDIF
	 
ENDWHILE


skip_timer4:


IF skip_timer1_acive = 1
	DO_FADE 1000 FADE_OUT

	WAIT 1000

	DO_FADE 1000 FADE_IN

ENDIF 

STOP_PLAYER_LOOKING Player1
SET_CAMERA_IN_FRONT_OF_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_CHAR_OBJ_NO_OBJ scplayer

REMOVE_BLIP colar_cuffs_blip 

clothes_cut_scene2_played = 1

// **************************************(END) CHANGE OF CLOTHES CUT SCENE*********************************************

RETURN



check_company_vans:
	IF IS_CAR_DEAD company_van1
		REMOVE_BLIP company_van_blip1
	ENDIF

	IF IS_CAR_DEAD company_van2
		REMOVE_BLIP company_van_blip2
	ENDIF

	IF IS_CAR_DEAD company_van3
		REMOVE_BLIP company_van_blip3
	ENDIF

RETURN


new_intensity:

IF kill_off_riot_sound = 0
	new_intensity = new_intensity - 6
	SET_RIOT_INTENSITY new_intensity
ENDIF

RETURN

}