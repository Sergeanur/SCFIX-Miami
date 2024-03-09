MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************baron mission 2***************************************
// *************************************BUDDY HELICOPTER**************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_baron2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_baron2_failed
ENDIF

GOSUB mission_cleanup_baron2

MISSION_END

{
// Variables for mission
VAR_INT buddy_heli deathkills heli_health gang_drive stunt_double2 shit_to_shoot sgang_car5
VAR_INT sgang1 sgang2 sgang3 sgang4 sgang5 sgang6 sgang7 sgang8 sgang9 sgang10 sgangs_creation briefcase_baron2
VAR_INT sgang_car1 sgang_car2 sgang_car3 damage_timer1 CS_plant1 sgang_boss	kill_player_now
VAR_INT sgang1_is_dead sgang2_is_dead sgang3_is_dead sgang4_is_dead sgang5_is_dead sgang_car4
VAR_INT sgang6_is_dead sgang7_is_dead sgang8_is_dead sgang9_is_dead sgang10_is_dead 
VAR_INT gang_barrel1 gang_barrel2 gang_barrel3 gang_barrel4	gang_barrel5 gang_car_driven
LVAR_INT gang_barrel6 gang_barrel7 gang_barrel8 gang_barrel9 gang_barrel10 upped_to_ten_peds
LVAR_INT other_heli other_heli2 heli_pilot1 heli_pilot2 created_other_heli created_other_heli2 
LVAR_INT taking_damage_samp1 taking_damage_samp2 nearly_at_site_samp leaving_heli_samp

// ***************************************Mission Start***************************************

mission_start_baron2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME baron2
WAIT 0

LOAD_MISSION_TEXT BARON2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0

created_other_heli = 0
created_other_heli2 = 0
audio_is_loading = 0
audio_has_loaded = 0
first_two_samples = 0
second_two_samples = 0
third_two_samples = 0
forth_two_samples = 0
fifth_two_samples = 0
sixth_two_samples = 0
taking_damage_samp1 = 0
taking_damage_samp2 = 0
nearly_at_site_samp = 0
leaving_heli_samp = 0
gang_car_driven = 0
kill_player_now = 0
upped_to_ten_peds = 0
shit_to_shoot = 0

SET_PED_DENSITY_MULTIPLIER 0.0

SET_AREA_VISIBLE VIS_MANSION 
SET_EXTRA_COLOURS 8 FALSE

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdiaz
LOAD_SPECIAL_CHARACTER 3 CSbuddy
LOAD_SPECIAL_CHARACTER 4 igbuddy
REQUEST_MODEL maverick 

LOAD_SPECIAL_MODEL CUTOBJ01 dzplant
LOAD_SPECIAL_MODEL CUTOBJ02 colphon


LOAD_ALL_MODELS_NOW

LOAD_SCENE -378.3 -591.9 25.8						 

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED maverick 
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0

ENDWHILE

LOAD_CUTSCENE cok_2a
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1

				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_diaz
SET_CUTSCENE_ANIM cs_diaz csdiaz

CREATE_CUTSCENE_OBJECT SPECIAL03 CS_buddy
SET_CUTSCENE_ANIM CS_buddy CSbuddy

CREATE_CUTSCENE_OBJECT CUTOBJ01 CS_plant1
SET_CUTSCENE_ANIM CS_plant1 dzplant

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_phoncol 
SET_CUTSCENE_ANIM cs_phoncol colphon

CLEAR_AREA -379.2 -536.4 16.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -379.2 -536.4 16.2
SET_PLAYER_HEADING player1 0.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_A ) 10000 1 // Mission brief

WHILE cs_time < 6836
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_B ) 10000 1 // Mission brief

WHILE cs_time < 12564 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_C ) 10000 1 // Mission brief

WHILE cs_time < 13816 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_D ) 10000 1 // Mission brief

WHILE cs_time < 15862  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_E ) 10000 1 // Mission brief

WHILE cs_time < 17918 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_F ) 10000 1 // Mission brief

WHILE cs_time < 20021  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_G ) 10000 1 // Mission brief

WHILE cs_time < 24585
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_H ) 10000 1 // Mission brief

WHILE cs_time < 27367  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_I ) 10000 1 // Mission brief

WHILE cs_time < 32111 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_J ) 10000 1 // Mission brief

WHILE cs_time < 35328
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_K ) 10000 1 // Mission brief

WHILE cs_time < 39729 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_L ) 10000 1 // Mission brief

WHILE cs_time < 41796 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_M ) 10000 1 // Mission brief

WHILE cs_time < 44036
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_N ) 10000 1 // Mission brief

WHILE cs_time < 45599
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_O ) 10000 1 // Mission brief

WHILE cs_time < 48599
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 49960
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
CLEAR_EXTRA_COLOURS FALSE
DO_FADE 1500 FADE_OUT

PRINT_BIG ( COK_2 ) 15000 2 //"baron mission 2"

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE


SET_PED_DENSITY_MULTIPLIER 0.0

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy
LOAD_SPECIAL_MODEL CUTOBJ01 cschopb

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0

ENDWHILE

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -380.9 -565.7 40.0

LOAD_CUTSCENE cok_2b
SET_CUTSCENE_OFFSET -390.8 -573.877 40.1
SET_NEAR_CLIP 0.1				

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 CS_buddy
SET_CUTSCENE_ANIM CS_buddy CSbuddy

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_chopper
SET_CUTSCENE_ANIM cs_chopper cschopb


DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 130
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_P ) 10000 1 // Mission brief

WHILE cs_time < 1110
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_Q ) 10000 1 // Mission brief

WHILE cs_time < 3040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_R ) 10000 1 // Mission brief

WHILE cs_time < 5010
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_S ) 10000 1 // Mission brief

WHILE cs_time < 6070
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_T ) 10000 1 // Mission brief

WHILE cs_time < 7050
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_U ) 10000 1 // Mission brief

WHILE cs_time < 10040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK2_V ) 10000 1 // Mission brief

WHILE cs_time < 11500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

REQUEST_MODEL SGa
REQUEST_MODEL SGb 
REQUEST_MODEL M60
REQUEST_MODEL tec9
REQUEST_MODEL bobcat
REQUEST_MODEL barrel4
REQUEST_MODEL ruger
REQUEST_MODEL gangbur
REQUEST_MODEL sparrow
LOAD_SPECIAL_CHARACTER 5 SGc

LOAD_ALL_MODELS_NOW
 
WHILE NOT HAS_MODEL_LOADED SGa 
OR NOT HAS_MODEL_LOADED	SGb 
OR NOT HAS_MODEL_LOADED	M60 
OR NOT HAS_MODEL_LOADED tec9 
OR NOT HAS_MODEL_LOADED bobcat
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5 
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED barrel4
OR NOT HAS_MODEL_LOADED ruger
OR NOT HAS_MODEL_LOADED sparrow
OR NOT HAS_MODEL_LOADED gangbur
	WAIT 0

ENDWHILE

CREATE_CAR maverick -391.0 -573.0 -100.0 buddy_heli
CHANGE_CAR_COLOUR buddy_heli CARCOLOUR_CHERRYRED CARCOLOUR_WHITE
SET_CAR_HEALTH buddy_heli 3000

// START OF MISSION

LOAD_SPECIAL_CHARACTER 6 spandxa
REQUEST_MODEL marquis
REQUEST_MODEL rio
REQUEST_MODEL seaspar
REQUEST_MODEL WMYGO
REQUEST_MODEL caddy
 
SET_THREAT_REACTION_RANGE_MULTIPLIER 2.0

IF NOT IS_CAR_DEAD buddy_heli
	GET_CAR_HEALTH buddy_heli heli_health
	DISPLAY_ONSCREEN_COUNTER_WITH_STRING heli_health COUNTER_DISPLAY_BAR (COK2_24)
	GOSUB helicopters_health
	SHUT_PLAYER_UP player1 TRUE
	CREATE_CHAR_INSIDE_CAR buddy_heli PEDTYPE_CIVMALE SPECIAL04 buddy
	SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
	SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
	HELI_GOTO_COORDS buddy_heli -375.155 -548.155 48.266 20
	SET_FIXED_CAMERA_POSITION -386.772 -581.461 40.134 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -387.379 -580.692 40.335 JUMP_CUT
	SET_HELI_STABILISER buddy_heli TRUE
	SET_RADIO_CHANNEL FEVER -1
ENDIF

WAIT 500

DO_FADE 1000 FADE_IN

WAIT 6000

SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

	SET_FADING_COLOUR 1 1 1
	SET_MUSIC_DOES_FADE FALSE
	DO_FADE 500 FADE_OUT
	WAIT 500

	IF IS_PLAYER_IN_ANY_CAR player1
		WARP_PLAYER_FROM_CAR_TO_COORD Player1 -379.2 -536.4 16.2
	ENDIF 

	IF NOT IS_CAR_DEAD buddy_heli
		ATTACH_CHAR_TO_CAR scplayer buddy_heli -1.4 1.0 -0.1 FACING_LEFT 90.0 WEAPONTYPE_M60
	ENDIF	

	RESTORE_CAMERA_JUMPCUT
	DO_FADE 500 FADE_IN
	
IF HAS_MODEL_LOADED marquis
	CREATE_CAR marquis -363.6 -226.7 5.5 sgang_car1
ENDIF


WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 89.1 1084.0 39.0 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	IF LOCATE_PLAYER_ANY_MEANS_3D Player1 -375.0 -548.0 48.266 6.0 6.0 6.0 FALSE //Above mansion
		HELI_GOTO_COORDS buddy_heli -366.0 -346.0 50.0 50
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D Player1 -366.0 -346.0 50.0 6.0 6.0 6.0 FALSE //above north mansion
		HELI_GOTO_COORDS buddy_heli -264.0 46.2 15.0 70	
		SET_FADING_COLOUR 0 0 0

		IF created_other_heli = 0
			CREATE_CAR seaspar -110.0 692.4 70.0 other_heli
			SET_CAR_HEALTH other_heli 500
			CREATE_CHAR_INSIDE_CAR other_heli PEDTYPE_CIVMALE SGa heli_pilot1
			HELI_GOTO_COORDS other_heli -110.0 -48.2 38.0 2
			created_other_heli = 1
		ENDIF

		IF created_other_heli2 = 0
			CREATE_CAR sparrow -108.0 720.4 68.0 other_heli2
			CREATE_CHAR_INSIDE_CAR other_heli2 PEDTYPE_CIVMALE SGa heli_pilot2
			HELI_GOTO_COORDS other_heli2 -108.0 -48.2 40.0 7
			created_other_heli2 = 1
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D Player1 -264.0 46.2 15.0 6.0 6.0 6.0 FALSE //Under bridge
		HELI_GOTO_COORDS buddy_heli 17.9 1035.5 34.2 40	//Prawn Island (porn studio)
		IF shit_to_shoot = 0
			DELETE_CAR sgang_car1
			IF HAS_SPECIAL_CHARACTER_LOADED 6
				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL06 -261.6 62.4 26.2 sgang1
			ENDIF
			CREATE_CAR marquis -211.6 394.1 5.5 sgang_car1
			SET_CAR_HEALTH sgang_car1 500
			SET_CAR_HEADING sgang_car1 238.0
			CREATE_CAR rio -193.1 384.0 5.5 sgang_car2
			SET_CAR_HEALTH sgang_car2 500
			SET_CAR_HEADING sgang_car2 119.0
			CREATE_CAR marquis -222.9 363.8 5.5 sgang_car3
			SET_CAR_HEALTH sgang_car3 500
			//SET_CAR_HEADING sgang_car3 136.0
			
			CREATE_CHAR PEDTYPE_CIVMALE WMYGO -151.4 493.2 15.3 sgang2 //GOLFERS
			SET_CHAR_PERSONALITY sgang2 PEDSTAT_COWARD
			CREATE_CHAR PEDTYPE_CIVMALE WMYGO -150.5 496.3 15.4 sgang3 //GOLFERS
			SET_CHAR_PERSONALITY sgang3 PEDSTAT_COWARD

			SET_CHARS_CHATTING sgang2 sgang3 999999
			CREATE_CAR caddy -145.6 496.0 14.8 sgang_car4 //GOLF CADDY
			SET_CAR_HEALTH sgang_car4 500
			SET_CAR_HEADING sgang_car4 58.0
			CREATE_CAR caddy -148.8 490.1 14.8 sgang_car5 //GOLF CADDY
			SET_CAR_HEALTH sgang_car5 500
			SET_CAR_HEADING sgang_car5 90.0

			shit_to_shoot = 1
			
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D Player1 17.9 1035.5 34.2 6.0 6.0 6.0 FALSE //Prawn Island (porn studio)
		HELI_GOTO_COORDS buddy_heli 87.0 1087.6 38.0 50	//First building shootout (SWARM1)
	
		IF sgangs_creation = 0
			DELETE_CAR other_heli
			DELETE_CAR other_heli2
			DELETE_CHAR heli_pilot1
			DELETE_CHAR heli_pilot2
			DELETE_CHAR sgang2
			DELETE_CHAR sgang3
			DELETE_CAR sgang_car1
			DELETE_CAR sgang_car2
			DELETE_CAR sgang_car3
			DELETE_CAR sgang_car4
			DELETE_CAR sgang_car5
			MARK_MODEL_AS_NO_LONGER_NEEDED sparrow
			MARK_MODEL_AS_NO_LONGER_NEEDED marquis
			MARK_MODEL_AS_NO_LONGER_NEEDED rio
			MARK_MODEL_AS_NO_LONGER_NEEDED seaspar
			MARK_MODEL_AS_NO_LONGER_NEEDED caddy
			MARK_MODEL_AS_NO_LONGER_NEEDED WMYGO
			UNLOAD_SPECIAL_CHARACTER 6

			// ******************************SWARM 1********************************
			IF NOT IS_CAR_DEAD buddy_heli
				CREATE_CHAR PEDTYPE_CIVMALE SGa 70.9 1106.4 -100.0 sgang1
				SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
				SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
				SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
				GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH sgang1 50

				CREATE_CHAR PEDTYPE_CIVMALE SGb 75.0 1106.9 -100.0 sgang2
				SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
				SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
				SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
				GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH sgang2 50

				CREATE_CHAR PEDTYPE_CIVMALE SGa 71.5 1099.0 -100.0 sgang3
				SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
				SET_CHAR_OBJ_DESTROY_CAR sgang3 buddy_heli
				SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
				GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH sgang3 50

				CREATE_CHAR PEDTYPE_CIVMALE SGb 78.4 1101.6 -100.0 sgang4
				SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE
				SET_CHAR_OBJ_DESTROY_CAR sgang4 buddy_heli
				SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
				GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH sgang4 50

				CREATE_CHAR PEDTYPE_CIVMALE SGa 76.0 1095.6 -100.0 sgang5
				SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE
				SET_CHAR_OBJ_DESTROY_CAR sgang5 buddy_heli
				SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
				GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH sgang5 50
			ENDIF

			CREATE_OBJECT barrel4 65.6 1104.6 31.5 gang_barrel1
			CREATE_OBJECT barrel4 65.7 1107.5 31.5 gang_barrel2
			CREATE_OBJECT barrel4 86.7 1114.3 31.5 gang_barrel3
			sgangs_creation = 1
		ENDIF
	
	ENDIF

	IF first_two_samples = 0
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_1	
			LOAD_MISSION_AUDIO 2 COK2_2	
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded   = 1
			PLAY_MISSION_AUDIO 1 //One thing puzzling me, What's with 'Quentin!?
			PRINT_NOW ( COK2_1 ) 5000 2	

			IF HAS_MISSION_AUDIO_FINISHED 1
				WAIT 500
				PLAY_MISSION_AUDIO 2 //I dunno, I always kinda liked it...Quentin Vance...
				PRINT_NOW ( COK2_2 ) 5000 2
				first_two_samples = 1
				GOSUB reset_audio_flags		
			ENDIF
		ENDIF
	ENDIF

	IF first_two_samples = 1
	AND second_two_samples = 0
	AND TIMERB > 4000 // FIXMIAMI: change 3000 to 4000
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_3	
			LOAD_MISSION_AUDIO 2 COK2_4	
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //Vance? You're name's Lance Vance?!
			PRINT_NOW ( COK2_3 ) 5000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				WAIT 500
				PLAY_MISSION_AUDIO 2 //Hey! I got enough of that at school!
				PRINT_NOW ( COK2_4 ) 5000 2
				second_two_samples = 1
				GOSUB reset_audio_flags		
			ENDIF
		ENDIF
	ENDIF						   

	IF second_two_samples = 1
	AND third_two_samples = 0
	AND TIMERB > 3000 
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_8d
			LOAD_MISSION_AUDIO 2 COK2_7b
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded  = 1
			PLAY_MISSION_AUDIO 1 //Lance Vance. You poor bastard.
			PRINT_NOW ( COK2_13 ) 4000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				IF TIMERB > 6000
					PLAY_MISSION_AUDIO 2 //Where we headed anyway?
					PRINT_NOW ( COK2_8 ) 4000 2
					third_two_samples = 1
					GOSUB reset_audio_flags		
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF third_two_samples = 1
	AND forth_two_samples = 0
	AND TIMERB > 2000 
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_7c 
			LOAD_MISSION_AUDIO 2 COK2_5 
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded   = 1
			PLAY_MISSION_AUDIO 1 //Prawn Island. 
			PRINT_NOW ( COK2_9 ) 5000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				IF TIMERB > 4000
					PLAY_MISSION_AUDIO 2 //You ever fired one of those from a whirly? 
					PRINT_NOW ( COK2_5 ) 5000 2
					forth_two_samples = 1
					GOSUB reset_audio_flags
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	
	IF forth_two_samples = 1
	AND fifth_two_samples = 0
	AND TIMERB > 3000
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_6 	
			LOAD_MISSION_AUDIO 2 COK2_9  
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded  = 1
			PLAY_MISSION_AUDIO 1 //No. I'll get a bit of practice on the way 
			PRINT_NOW ( COK2_6 ) 3000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT COK2_6 // FIXMIAMI
				IF TIMERB > 12000
					PLAY_MISSION_AUDIO 2 //Ok, we're almost there 
					PRINT_NOW ( COK2_14 ) 5000 2
					fifth_two_samples = 1
					GOSUB reset_audio_flags
				ENDIF
			ENDIF
		ENDIF
	ENDIF


	IF fifth_two_samples = 1
	AND sixth_two_samples = 0
	AND TIMERB > 2000
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK210a 	
			LOAD_MISSION_AUDIO 2 COK210b  
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok2
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //We'll make a couple of passes.
			PRINT_NOW ( COK2_15 ) 5000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				WAIT 500
				PLAY_MISSION_AUDIO 2 //So take out as many guns as you can
				PRINT_NOW ( COK2_16 ) 5000 2
				sixth_two_samples = 1
				GOSUB reset_audio_flags
			ENDIF
		ENDIF
	ENDIF

	IF sixth_two_samples = 1
	AND nearly_at_site_samp = 0
	AND TIMERB > 2500
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK210c 	
			audio_is_loading = 1
		ELSE
			IF HAS_MISSION_AUDIO_LOADED	1
				audio_has_loaded  = 1
			ENDIF
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //Then I'll set you down and you're on your own.
			PRINT_NOW ( COK2_17 ) 4000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT COK2_17 // FIXMIAMI
				nearly_at_site_samp = 1
				GOSUB reset_audio_flags
			ENDIF
		ENDIF

	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 270.0
ENDIF

GOSUB zero_ints

WHILE NOT deathkills = 5 //First building (bottom right) (SWARM 1!!!)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	
	IF TIMERB > 50000
		GOTO move_on1
	ENDIF
	
	IF first_two_samples = 0
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_13
			audio_is_loading = 1
		ELSE
			IF HAS_MISSION_AUDIO_LOADED	1
				audio_has_loaded   = 1
			ENDIF
		ENDIF

		IF audio_has_loaded   = 1
			PLAY_MISSION_AUDIO 1 //Shit! This is a war zone! Take out some of those gunmen
			PRINT_NOW ( COK2_20 ) 4000 2
			// FIXMIAMI: START
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT COK2_20
			ENDIF
			// FIXMIAMI: END
		ENDIF
	ENDIF

	
ENDWHILE

move_on1:

// FIXMIAMI: START
IF audio_has_loaded = 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_THIS_PRINT COK2_20
ENDIF
// FIXMIAMI: END


IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 113.0 1106.9 30.0 40 //East of first building (SWARM 2!!!)
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 117.0 1106.9 30.0 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE


IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 1.0
ENDIF

DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5


// ******************************SWARM 2********************************
IF NOT IS_CAR_DEAD buddy_heli
	CREATE_CHAR PEDTYPE_CIVMALE SGa 59.0 1117.7 17.7 sgang1	//bottom north
	SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 64.7 1089.8 17.7 sgang2	//bottom south
	SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang2 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 61.0 1091.1 24.4 sgang3	//top south
	SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
	GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang3 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 58.2 1118.7 24.4 sgang4	//top north
	SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
	GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang4 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 64.9 1119.0 24.4 sgang5 //top north front
	SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
	GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50
ENDIF

GOSUB zero_ints

WHILE NOT deathkills = 5 //East of first building (SWARM 2!!!)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	 
	IF NOT IS_CHAR_DEAD	sgang1
		IF LOCATE_CHAR_ANY_MEANS_3D sgang1 59.0 1117.7 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang1 89.7 1118.1	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang1 89.7 1118.1 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang1 94.7 1107.1	 
		ENDIF
		
		IF LOCATE_CHAR_ANY_MEANS_3D sgang1 94.7 1107.1 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
			SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE		 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	sgang2
		IF LOCATE_CHAR_ANY_MEANS_3D sgang2 64.7 1089.8 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang2 90.1 1090.1	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang2 90.1 1090.1 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang2 91.1 1097.8	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang2 91.1 1097.8 17.7 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
			SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE	 	 
		ENDIF
	ENDIF
		
	IF NOT IS_CHAR_DEAD	sgang3
		IF LOCATE_CHAR_ANY_MEANS_3D sgang3 61.0 1091.1 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang3 89.4 1091.0	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang3 89.4 1091.0 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang3 94.5 1100.5	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang3 94.5 1100.5 24.4 1.0 1.0 5.0 FALSE
 			SET_CHAR_OBJ_DESTROY_CAR sgang3 buddy_heli
			SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	sgang4
		IF LOCATE_CHAR_ANY_MEANS_3D sgang4 58.2 1118.7 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang4 90.0 1118.8	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang4 90.0 1118.8 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang4 94.5 1099.9	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang4 94.5 1099.9 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR sgang4 buddy_heli
			SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE	 	 
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	sgang5
		IF LOCATE_CHAR_ANY_MEANS_3D sgang5 64.9 1119.0 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang5 89.1 1117.9	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang5 89.1 1117.9 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD sgang5 93.0 1110.0	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D sgang5 93.0 1110.0 24.4 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_DESTROY_CAR sgang5 buddy_heli 
			SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE   	 
		ENDIF
	ENDIF

	IF TIMERB > 40000
		GOTO move_on2
	ENDIF
		
ENDWHILE


move_on2:

IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 90.9 1196.0 40.0 40	//far away east of centre building
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 90.9 1196.0 40.0 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

CREATE_CAR bobcat 19.8 1213.4 -100.0 sgang_car1
SET_CAR_HEADING sgang_car1 233.7

CREATE_CAR bobcat -12.1 1207.3 -100.0 sgang_car2
SET_CAR_HEADING sgang_car2 159.6

CREATE_CAR gangbur -20.1 1198.4 -100.0 sgang_car3
SET_CAR_HEADING sgang_car3 34.6

CREATE_OBJECT barrel4 14.6 1177.9 22.5 gang_barrel7
CREATE_OBJECT barrel4 7.2 1193.1 17.8 gang_barrel8
CREATE_OBJECT barrel4 -13.2 1217.7 20.4 gang_barrel9
CREATE_OBJECT barrel4 -18.3 1217.5 20.4 gang_barrel10

DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5

// ******************************SWARM 3********************************
IF NOT IS_CAR_DEAD buddy_heli
	CREATE_CHAR PEDTYPE_CIVMALE SGa 17.8 1212.0 20.9 sgang1	//At the first bobcat
	SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CAR gangbur 43.8 1129.6 17.9 gang_drive
	SET_CAR_HEADING gang_drive 0.0
	CREATE_CHAR_INSIDE_CAR gang_drive PEDTYPE_CIVMALE SGb sgang2
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang2 50
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
	CAR_GOTO_COORDINATES gang_drive 38.8 1198.0 20.8
	SET_CAR_STRAIGHT_LINE_DISTANCE gang_drive 100
	SET_CAR_FORWARD_SPEED gang_drive 10.0
	SET_CAR_CRUISE_SPEED gang_drive 25.0

	CREATE_CHAR PEDTYPE_CIVMALE SGa 19.3 1196.2 19.0 sgang3	//Swiming pool
	SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang3 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
	GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang3 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb -11.8 1208.5 22.5 sgang4 //Back of bobcat2
	SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang4 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
	GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang4 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa -22.9 1198.6 22.1 sgang5 //next to bobcat3
	SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang5 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
	GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb -34.7 1202.3 20.4 sgang6 // basketball court front
	SET_CHAR_STAY_IN_SAME_PLACE sgang6 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang6 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang6 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang6 Player1
	GIVE_WEAPON_TO_CHAR sgang6 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang6 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb -40.5 1195.1 20.4 sgang7  // basketball court back
	SET_CHAR_STAY_IN_SAME_PLACE sgang7 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang7 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang7 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang7 Player1
	GIVE_WEAPON_TO_CHAR sgang7 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang7 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa -22.3 1218.0 20.4 sgang8	// behind guard house
	SET_CHAR_STAY_IN_SAME_PLACE sgang8 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang8 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang8 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang8 Player1
	GIVE_WEAPON_TO_CHAR sgang8 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang8 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 27.3 1196.4 19.6 sgang9 // Next to swimming pool
	SET_CHAR_STAY_IN_SAME_PLACE sgang9 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang9 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang9 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang9 Player1
	GIVE_WEAPON_TO_CHAR sgang9 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang9 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 0.8 1212.9 20.4 sgang10 // infront of bobcats
	SET_CHAR_STAY_IN_SAME_PLACE sgang10 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang10 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang10 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang10 Player1
	GIVE_WEAPON_TO_CHAR sgang10 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50

ENDIF



IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 28.1 1224.5 26.4 40	//North of centre building 
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 28.1 1224.5 27.4 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	IF gang_car_driven = 0
	    IF NOT IS_CHAR_DEAD sgang2
			IF NOT IS_CAR_DEAD gang_drive
			    IF LOCATE_CHAR_ANY_MEANS_3D sgang2 38.8 1198.0 20.8 4.0 4.0 4.0 FALSE
					SET_CAR_CRUISE_SPEED gang_drive 0.0
					SET_CHAR_OBJ_LEAVE_CAR sgang2 gang_drive
					gang_car_driven = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF kill_player_now = 0
			IF NOT IS_CHAR_DEAD sgang2
				IF NOT IS_CAR_DEAD gang_drive
					IF NOT IS_CHAR_IN_CAR sgang2 gang_drive	
						SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
						SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
						kill_player_now = 1		
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	GOSUB helicopters_health

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 90.0
ENDIF

GOSUB zero_ints

upped_to_ten_peds = 1

WHILE NOT deathkills > 9 //North of centre building (SWARM 3!!!)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	 
	IF gang_car_driven = 0
	    IF NOT IS_CHAR_DEAD sgang2
			IF NOT IS_CAR_DEAD gang_drive
			    IF LOCATE_CHAR_ANY_MEANS_3D sgang2 38.8 1198.0 20.8 4.0 4.0 4.0 FALSE
					SET_CAR_CRUISE_SPEED gang_drive 0.0
					SET_CHAR_OBJ_LEAVE_CAR sgang2 gang_drive
					gang_car_driven = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF kill_player_now = 0
			IF NOT IS_CHAR_DEAD sgang2
				IF NOT IS_CAR_DEAD gang_drive
					IF NOT IS_CHAR_IN_CAR sgang2 gang_drive	
						SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
						SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
						kill_player_now = 1		
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF TIMERB > 20000
		GOTO move_on3
	ENDIF
	
	IF NOT IS_CAR_DEAD buddy_heli
		IF taking_damage_samp1 = 0
			LOAD_MISSION_AUDIO 1 COK2_14
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE
			PLAY_MISSION_AUDIO 1 //We're taking hits here man
			PRINT_NOW ( COK2_21 ) 5000 2
			taking_damage_samp1 = 1
		ELSE // FIXMIAMI
			IF HAS_MISSION_AUDIO_FINISHED 1 // FIXMIAMI
				CLEAR_THIS_PRINT COK2_21 // FIXMIAMI
			ENDIF // FIXMIAMI
		ENDIF
	ENDIF
		
ENDWHILE

move_on3:

// FIXMIAMI: START
IF taking_damage_samp1 = 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_THIS_PRINT COK2_21
ENDIF
// FIXMIAMI: END

IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli -32.4 1222.5 30.6 40 //Next to basketball court
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 -32.4 1222.5 30.6 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 140.0
ENDIF	

TIMERB = 0

WHILE NOT deathkills > 9 //Next to basketball court (SWARM 3!!!)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	 
	IF TIMERB > 20000
		GOTO move_on4
	ENDIF
	
	IF NOT IS_CAR_DEAD buddy_heli
		IF taking_damage_samp1 = 0
			LOAD_MISSION_AUDIO 1 COK2_14
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE
			PLAY_MISSION_AUDIO 1 //We're taking hits here man 
			PRINT_NOW ( COK2_21 ) 5000 2
			taking_damage_samp1 = 1
		ELSE // FIXMIAMI
			IF HAS_MISSION_AUDIO_FINISHED 1 // FIXMIAMI
				CLEAR_THIS_PRINT COK2_21 // FIXMIAMI
			ENDIF // FIXMIAMI
		ENDIF
	ENDIF
		
ENDWHILE

move_on4:

// FIXMIAMI: START
IF taking_damage_samp1 = 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_THIS_PRINT COK2_21
ENDIF
// FIXMIAMI: END

upped_to_ten_peds = 0

WAIT 500

DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5

// ******************************SWARM 4********************************
IF NOT IS_CAR_DEAD buddy_heli
	CREATE_CHAR PEDTYPE_CIVMALE SGb -41.4 1114.4 -100.0 sgang1
	SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa -59.3 1113.0 -100.0 sgang2
	SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang2 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb -57.8 1121.4 -100.0 sgang3
	SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang3 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
	GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang3 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa -44.4 1119.6 -100.0 sgang4
	SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang4 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
	GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang4 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb -45.0 1123.6 -100.0 sgang5
	SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang5 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
	GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50
ENDIF

CREATE_OBJECT barrel4 -41.1 1106.3 29.9 gang_barrel4
CREATE_OBJECT barrel4 -60.8 1102.7 29.9 gang_barrel5
CREATE_OBJECT barrel4 -46.6 1118.5 29.9 gang_barrel6

IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli -49.8 1144.7 38.3 40
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 -49.8 1144.7 38.3 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 90.0
ENDIF

DELETE_CHAR	sgang6
DELETE_CHAR	sgang7
DELETE_CHAR	sgang8
DELETE_CHAR	sgang9
DELETE_CHAR	sgang10

GOSUB zero_ints

WHILE NOT deathkills = 5 //Second building (SWARM4)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	
	IF TIMERB > 40000
		GOTO move_on5
	ENDIF
	
	IF NOT IS_CAR_DEAD buddy_heli
		IF taking_damage_samp2 = 0
			LOAD_MISSION_AUDIO 1 COK2_15
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE
			PLAY_MISSION_AUDIO 1 //This thing ain't cheap to fix! Take 'em out
			PRINT_NOW ( COK2_22 ) 5000 2
			taking_damage_samp2 = 1
// FIXMIAMI: START
		ELSE
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT COK2_22
			ENDIF
// FIXMIAMI: END
		ENDIF
	ENDIF
		
ENDWHILE

move_on5:

// FIXMIAMI: START
IF taking_damage_samp2 = 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_THIS_PRINT COK2_22
ENDIF
// FIXMIAMI: END


WAIT 1500
DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5

// ******************************SWARM 5********************************
IF NOT IS_CAR_DEAD buddy_heli
	CREATE_CHAR PEDTYPE_CIVMALE SGb 14.6 1145.4 -100.0 sgang1 //Top balcony left
	SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 21.9 1146.7 -100.0 sgang2 //Top balcony right
	SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang2 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 11.3 1147.0 22.5 sgang3	//lower balcony left
	SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang3 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
	GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang3 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 28.9 1146.3 20.5 sgang4	//lower balcony right
	SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang4 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
	GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang4 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 15.9 1145.5 22.5 sgang5	//lower balcony centre
	SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE
	SET_CHAR_OBJ_DESTROY_CAR sgang5 buddy_heli
	SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
	GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50
ENDIF

IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 20.0 1125.0 36.0 20	// Centre building
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 20.0 1125.0 36.0 6.0 6.0 6.0 FALSE	
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 270.0
ENDIF


GOSUB zero_ints

WHILE NOT deathkills = 5 //Centre building (SWARM5)
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

	GOSUB check_dead_chars
	
	IF TIMERB > 40000
		GOTO move_on6
	ENDIF
		
ENDWHILE


move_on6:

IF NOT IS_CAR_DEAD buddy_heli
	CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 68.7 1098.2 31.7 sgang_boss
	SET_CHAR_STAY_IN_SAME_PLACE sgang_boss TRUE
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang_boss Player1
	GIVE_WEAPON_TO_CHAR sgang_boss WEAPONTYPE_RUGER 30000
	SET_CHAR_HEALTH sgang_boss 100
	SET_CHAR_HEADING sgang_boss 90.0

	CREATE_CHAR PEDTYPE_CIVMALE SGb 62.8 1098.2 31.7 sgang1 
	SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang1 Player1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_RUGER 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 66.6 1093.7 31.7 sgang2 
	SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang2 Player1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_RUGER 30000
	SET_CHAR_HEALTH sgang2 50

ENDIF


IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 37.0 1075.0 43.0 20	//Back to first building
 	SET_CAR_PROOFS buddy_heli TRUE TRUE TRUE TRUE TRUE
ENDIF


first_two_samples = 0
second_two_samples = 0
audio_is_loading = 0
audio_has_loaded = 0

LOAD_MISSION_AUDIO 1 COK2_20	
LOAD_MISSION_AUDIO 2 COK2_21	
audio_is_loading = 1

IF NOT IS_CHAR_DEAD sgang_boss //BOSS fight
	WAIT 3500

	IF NOT IS_CAR_DEAD buddy_heli
		SET_NEAR_CLIP 0.5
		SET_FIXED_CAMERA_POSITION 69.915 1098.858 33.058 0.0 0.0 0.0
		POINT_CAMERA_AT_CAR buddy_heli FIXED JUMP_CUT
	ENDIF

	WAIT 500

	IF NOT IS_CHAR_DEAD sgang_boss
		WHILE first_two_samples = 0
			WAIT 0

			IF audio_is_loading = 1
				IF HAS_MISSION_AUDIO_LOADED	1
				AND HAS_MISSION_AUDIO_LOADED 2
					audio_has_loaded = 1
				ENDIF
			ENDIF

			IF audio_has_loaded = 1
				PLAY_MISSION_AUDIO 1 //asshole
				PRINT_NOW ( COK2_27 ) 2000 2
				IF HAS_MISSION_AUDIO_FINISHED 1
					CLEAR_THIS_PRINT COK2_27 // FIXMIAMI
					IF NOT IS_CHAR_DEAD sgang_boss
						IF NOT IS_CAR_DEAD buddy_heli
							SET_CHAR_OBJ_DESTROY_CAR sgang_boss buddy_heli
							SET_CHAR_THREAT_SEARCH sgang_boss THREAT_PLAYER1
							SET_CHAR_ACCURACY sgang_boss 30
						ENDIF
					ENDIF

					IF NOT IS_CHAR_DEAD sgang1
						IF NOT IS_CAR_DEAD buddy_heli
							SET_CHAR_OBJ_DESTROY_CAR sgang1 buddy_heli
							SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
							SET_CHAR_ACCURACY sgang1 20
						ENDIF
					ENDIF

					IF NOT IS_CHAR_DEAD sgang2
						IF NOT IS_CAR_DEAD buddy_heli
							SET_CHAR_OBJ_DESTROY_CAR sgang2 buddy_heli
							SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
							SET_CHAR_ACCURACY sgang2 20
						ENDIF
					ENDIF

					PLAY_MISSION_AUDIO 2 //Your going down 
					PRINT_NOW ( COK2_28 ) 2000 2
					first_two_samples = 1
					GOSUB reset_audio_flags	
				ENDIF
			ENDIF

		ENDWHILE
	ENDIF

WAIT 1000

	// FIXMIAMI: START
	IF first_two_samples = 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			WAIT 0
		ENDWHILE

		CLEAR_THIS_PRINT COK2_28
	ENDIF
	// FIXMIAMI: END

	RESTORE_CAMERA_JUMPCUT
	IF NOT IS_CAR_DEAD buddy_heli
		SET_CAR_PROOFS buddy_heli FALSE FALSE FALSE FALSE FALSE
	ENDIF
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 37.0 1075.0 43.0 6.0 6.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 237.0
ENDIF

IF IS_CHAR_DEAD sgang1
   	
ENDIF

GOSUB zero_ints

WHILE NOT IS_CHAR_DEAD sgang_boss
OR NOT IS_CHAR_DEAD	sgang1
OR NOT IS_CHAR_DEAD	sgang2
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	GOSUB helicopters_health

ENDWHILE

CREATE_PICKUP briefcase PICKUP_ONCE 68.7 1098.2 32.5 briefcase_baron2

IF NOT IS_CAR_DEAD buddy_heli
	CLEAR_HELI_ORIENTATION buddy_heli
	HELI_GOTO_COORDS buddy_heli 33.7 1083.0 15.0 2	//Go to land
	SET_HELI_ORIENTATION buddy_heli 180.0
	CLEAR_ONSCREEN_COUNTER heli_health
	SET_CAR_HEALTH buddy_heli 1000
ENDIF


SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 33.7 1083.0 15.0 10.0 10.0 4.0 FALSE // FIXMIAMI: change X and Y radius from 6 to 10
	WAIT 0

	IF IS_CAR_DEAD buddy_heli		
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron2_failed	
	ENDIF

	IF leaving_heli_samp = 0
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK2_16
			audio_is_loading = 1
		ELSE
			IF HAS_MISSION_AUDIO_LOADED	1
				audio_has_loaded   = 1
			ENDIF
		ENDIF

		IF audio_has_loaded   = 1
			PLAY_MISSION_AUDIO 1 //Ok, you're on your own from here on in goodluck, brother!
			PRINT_NOW ( COK2_23 ) 5000 2
			leaving_heli_samp = 0
		ENDIF
	ENDIF

	// FIXMIAMI: START
	IF audio_has_loaded = 1
	AND leaving_heli_samp = 0
	AND HAS_MISSION_AUDIO_FINISHED 1
		CLEAR_THIS_PRINT COK2_23
	ENDIF
	// FIXMIAMI: END

ENDWHILE
	

IF NOT IS_CAR_DEAD buddy_heli
	SET_HELI_ORIENTATION buddy_heli 180.0
ENDIF

// FIXMIAMI: START
IF audio_has_loaded = 1
AND leaving_heli_samp = 0
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_THIS_PRINT COK2_23
ENDIF
// FIXMIAMI: END

WAIT 1000

DETACH_CHAR_FROM_CAR scplayer
GIVE_WEAPON_TO_PLAYER Player1 WEAPONTYPE_M60 100
SET_CURRENT_PLAYER_WEAPON Player1 WEAPONTYPE_M60
SET_MAX_WANTED_LEVEL 5
SHUT_PLAYER_UP player1 FALSE

IF NOT IS_CAR_DEAD buddy_heli
	SET_CAR_PROOFS buddy_heli FALSE FALSE FALSE FALSE FALSE
	HELI_GOTO_COORDS buddy_heli -19.9 878.0 45.0 20	// Heli go home
	SET_HELI_STABILISER buddy_heli FALSE
ENDIF

PRINT_NOW ( COK2_25 ) 8000 1	//Get the money

DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5

// ******************************SWARM 6********************************
	CREATE_CHAR PEDTYPE_CIVMALE SGb 79.6 1106.4 17.7 sgang1 //ground level right
	SET_CHAR_STAY_IN_SAME_PLACE sgang1 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang1 Player1
	SET_CHAR_THREAT_SEARCH sgang1 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang1 Player1
	GIVE_WEAPON_TO_CHAR sgang1 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang1 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 70.4 1103.9 17.7 sgang2 //Ground level left
	SET_CHAR_STAY_IN_SAME_PLACE sgang2 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang2 Player1
	SET_CHAR_THREAT_SEARCH sgang2 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang2 Player1
	GIVE_WEAPON_TO_CHAR sgang2 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang2 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 67.6 1107.2 24.4 sgang3	//1st floot left
	SET_CHAR_STAY_IN_SAME_PLACE sgang3 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang3 Player1
	SET_CHAR_THREAT_SEARCH sgang3 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang3 Player1
	GIVE_WEAPON_TO_CHAR sgang3 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang3 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 74.9 1112.9 22.2 sgang4	//middle landing centre
	SET_CHAR_STAY_IN_SAME_PLACE sgang4 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang4 Player1
	SET_CHAR_THREAT_SEARCH sgang4 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang4 Player1
	GIVE_WEAPON_TO_CHAR sgang4 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang4 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 79.0 1111.1 20.0 sgang5	//lower balcony centre
	SET_CHAR_STAY_IN_SAME_PLACE sgang5 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang5 Player1
	SET_CHAR_THREAT_SEARCH sgang5 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang5 Player1
	GIVE_WEAPON_TO_CHAR sgang5 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang5 50

	CREATE_CHAR PEDTYPE_CIVMALE SGa 81.6 1105.6 24.6 sgang6	//1st floor right
	SET_CHAR_STAY_IN_SAME_PLACE sgang6 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang6 Player1
	SET_CHAR_THREAT_SEARCH sgang6 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang6 Player1
	GIVE_WEAPON_TO_CHAR sgang6 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang6 50

	CREATE_CHAR PEDTYPE_CIVMALE SGb 62.9 1102.1 31.5 sgang7	//Stair well to roof
	SET_CHAR_STAY_IN_SAME_PLACE sgang7 TRUE
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sgang7 Player1
	SET_CHAR_THREAT_SEARCH sgang7 THREAT_PLAYER1
	CHAR_LOOK_AT_PLAYER_ALWAYS sgang7 Player1
	GIVE_WEAPON_TO_CHAR sgang7 WEAPONTYPE_TEC9 30000
	SET_CHAR_HEALTH sgang7 50

ADD_BLIP_FOR_PICKUP	briefcase_baron2 baron_blip1

WHILE NOT HAS_PICKUP_BEEN_COLLECTED briefcase_baron2
	WAIT 0

	IF IS_CAR_DEAD buddy_heli
		PRINT_NOW ( COK2_26 ) 5000 1 //You killed Lance
		GOTO mission_baron2_failed	
	ENDIF

ENDWHILE
WAIT 500

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

DELETE_CAR buddy_heli 
DELETE_CHAR	buddy 
CREATE_CAR maverick 31.5 884.7 60.0 buddy_heli
CREATE_CHAR_INSIDE_CAR buddy_heli PEDTYPE_CIVMALE SPECIAL04 buddy
CHANGE_CAR_COLOUR buddy_heli CARCOLOUR_CHERRYRED CARCOLOUR_WHITE
SET_CAR_FORWARD_SPEED buddy_heli 30.0
HELI_GOTO_COORDS buddy_heli 68.9 1101.6 35.0 50	//Pick up player
PLAYER_LOOK_AT_CHAR_ALWAYS Player1 buddy

SET_FIXED_CAMERA_POSITION 62.132 1093.546 33.835 0.0 0.0 0.0
POINT_CAMERA_AT_CAR buddy_heli FIXED JUMP_CUT
CLEAR_AREA 62.132 1093.546 33.835 1.0 TRUE

WAIT 9000

DO_FADE 600 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	SET_FIXED_CAMERA_POSITION 39.867 1057.500 42.034 0.0 0.0 0.0
	POINT_CAMERA_AT_CAR buddy_heli FIXED JUMP_CUT
	SET_CAR_HEADING buddy_heli 180.0 
ENDIF

SET_PLAYER_COORDINATES Player1 76.7 1119.8 25.4
STOP_PLAYER_LOOKING Player1

DO_FADE 600 FADE_IN

IF NOT IS_CAR_DEAD buddy_heli
	HELI_GOTO_COORDS buddy_heli -19.9 878.0 45.0 50	
	CREATE_CHAR_AS_PASSENGER buddy_heli PEDTYPE_CIVMALE null 0 stunt_double2 // FIXMIAMI: was PEDTYPE_CIVFEMALE
ENDIF

WAIT 6000

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD buddy_heli
	LOAD_SCENE -375.7 -543.5 16.6
	SET_PLAYER_COORDINATES Player1 -375.7 -543.5 16.2
	SET_PLAYER_HEADING player1 0.0
ENDIF

WAIT 300

DO_FADE 1000 FADE_IN

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF

//PRINT_HELP ( OPEN_B )


GOTO mission_baron2_passed


 // Mission baron2 failed

mission_baron2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"

RETURN

   

// mission baron2 passed

mission_baron2_passed:

flag_baron_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000 
REGISTER_MISSION_PASSED	COK_2
PLAYER_MADE_PROGRESS 1
sniper_in_stock = 1
SET_ALLOW_HURRICANES FALSE
// MAIN LAND RESTARTS
ADD_HOSPITAL_RESTART -822.7 1157.9 10.1.0 4.0 // (north)
ADD_POLICE_RESTART -659.5 760.4 10.5 133.0 // (north)

ADD_HOSPITAL_RESTART -885.2 -470.4 12.1 276.0 // (south)
ADD_POLICE_RESTART -871.9 -682.3 10.2 328.1 // (south)

SWITCH_PED_ROADS_ON 189.8 230.3 0.0 248.0 258.5 30.0 //  Golf course road block
SWITCH_PED_ROADS_ON -38.0 84.3 0.0 -102.3 95.1 30.0 //  Golf course road block
SWITCH_ROADS_ON 189.8 230.3 0.0 248.0 258.5 30.0 //  Golf course road block
SWITCH_ROADS_ON -38.0 84.3 0.0 -102.3 95.1 30.0 //  Golf course road block
SWITCH_ROADS_ON 175.0 236.1 0.0 161.0 242.4 30.0 //  Golf course road block
SWITCH_ROADS_ON 149.8 231.4 0.0 136.0 235.3 30.0 //  Golf course road block
SWITCH_ROADS_ON 63.4 188.6 0.0 49.4 189.7 30.0 //  Golf course road block
DELETE_OBJECT golf_roadblock
SWITCH_PED_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block
SWITCH_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block                                          
DELETE_OBJECT south_roadblock
SWITCH_PED_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
SWITCH_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
DELETE_OBJECT star_gate_1
CREATE_OBJECT_NO_OFFSET comgate1open -712.524 -489.428 12.549 star_gate_1
DONT_REMOVE_OBJECT star_gate_1
DELETE_OBJECT pier_closed
SWITCH_PED_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 //  porn island road block
SWITCH_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 // porn island road block
DELETE_OBJECT porn_roadblock
PLAY_ANNOUNCEMENT ANNOUNCEMENT_TRACK_BRIDGE_OPEN
SWITCH_CAR_GENERATOR gen_car15 101
SWITCH_CAR_GENERATOR gen_car38 101
SWITCH_CAR_GENERATOR gen_car13 101
SWITCH_CAR_GENERATOR gen_car14 101
START_NEW_SCRIPT baron_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_baron2:

flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
MARK_MODEL_AS_NO_LONGER_NEEDED sparrow
MARK_MODEL_AS_NO_LONGER_NEEDED M60
MARK_MODEL_AS_NO_LONGER_NEEDED tec9
MARK_MODEL_AS_NO_LONGER_NEEDED ruger
MARK_MODEL_AS_NO_LONGER_NEEDED bobcat
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_MODEL_AS_NO_LONGER_NEEDED SGa
MARK_MODEL_AS_NO_LONGER_NEEDED SGb
MARK_MODEL_AS_NO_LONGER_NEEDED maverick
MARK_MODEL_AS_NO_LONGER_NEEDED gangbur
MARK_MODEL_AS_NO_LONGER_NEEDED marquis
MARK_MODEL_AS_NO_LONGER_NEEDED rio
MARK_MODEL_AS_NO_LONGER_NEEDED seaspar
MARK_MODEL_AS_NO_LONGER_NEEDED caddy
MARK_MODEL_AS_NO_LONGER_NEEDED WMYGO
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel1
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel2
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel3
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel4
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel5
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel6
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel7
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel8
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel9
MARK_OBJECT_AS_NO_LONGER_NEEDED gang_barrel10
SET_THREAT_REACTION_RANGE_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
UNLOAD_SPECIAL_CHARACTER 6
SET_MUSIC_DOES_FADE TRUE
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
DELETE_CHAR	sgang1
DELETE_CHAR	sgang2
DELETE_CHAR	sgang3
DELETE_CHAR	sgang4
DELETE_CHAR	sgang5
DELETE_CHAR sgang6
DELETE_CHAR	sgang7
DELETE_CHAR	sgang8
DELETE_CHAR	sgang9
DELETE_CHAR	sgang10
DELETE_CHAR stunt_double2
DELETE_CAR sgang_car4
DELETE_CAR sgang_car5
DELETE_CAR other_heli
SHUT_PLAYER_UP player1 FALSE
REMOVE_BLIP baron_blip1
REMOVE_PICKUP briefcase_baron2
CLEAR_ONSCREEN_COUNTER heli_health
DELETE_CHAR buddy
DETACH_CHAR_FROM_CAR scplayer
MISSION_HAS_FINISHED
SET_MAX_WANTED_LEVEL 5
RETURN


helicopters_health:

	IF NOT IS_CAR_DEAD buddy_heli
		GET_CAR_HEALTH buddy_heli heli_health
		SET_MAX_WANTED_LEVEL 0
		heli_health = heli_health / 30
	ENDIF

RETURN


zero_ints:

	TIMERB = 0
	deathkills = 0
	sgang1_is_dead = 0
	sgang2_is_dead = 0
	sgang3_is_dead = 0
	sgang4_is_dead = 0
	sgang5_is_dead = 0
	sgang6_is_dead = 0
	sgang7_is_dead = 0
	sgang8_is_dead = 0
	sgang9_is_dead = 0
	sgang10_is_dead	= 0
	sgangs_creation = 0
	damage_timer1 = 0
	audio_is_loading = 0
	audio_has_loaded   = 0
	first_two_samples = 0
	second_two_samples = 0
	third_two_samples = 0
	forth_two_samples = 0

RETURN



audio_loaded_cok2:

	IF HAS_MISSION_AUDIO_LOADED	1
	AND HAS_MISSION_AUDIO_LOADED 2
		audio_has_loaded = 1
	ENDIF

RETURN


reset_audio_flags:

	audio_is_loading = 0
	audio_has_loaded = 0
	TIMERB = 0

RETURN


check_dead_chars:

	IF sgang1_is_dead = 0
		IF IS_CHAR_DEAD	sgang1
			deathkills ++
			sgang1_is_dead = 1
		ENDIF
	ENDIF

	IF sgang2_is_dead = 0
		IF IS_CHAR_DEAD	sgang2
			deathkills ++
			sgang2_is_dead = 1
		ENDIF
	ENDIF
	
	IF sgang3_is_dead = 0
		IF IS_CHAR_DEAD	sgang3
			deathkills ++
			sgang3_is_dead = 1
		ENDIF
	ENDIF
	
	IF sgang4_is_dead = 0
		IF IS_CHAR_DEAD	sgang4
			deathkills ++
			sgang4_is_dead = 1
		ENDIF
	ENDIF
	
	IF sgang5_is_dead = 0
		IF IS_CHAR_DEAD	sgang5
			deathkills ++
			sgang5_is_dead = 1
		ENDIF
	ENDIF

	IF upped_to_ten_peds = 1

		IF sgang6_is_dead = 0
			IF IS_CHAR_DEAD	sgang6
				deathkills ++
				sgang6_is_dead = 1
			ENDIF
		ENDIF

		IF sgang7_is_dead = 0
			IF IS_CHAR_DEAD	sgang7
				deathkills ++
				sgang7_is_dead = 1
			ENDIF
		ENDIF
		
		IF sgang8_is_dead = 0
			IF IS_CHAR_DEAD	sgang8
				deathkills ++
				sgang8_is_dead = 1
			ENDIF
		ENDIF
		
		IF sgang9_is_dead = 0
			IF IS_CHAR_DEAD	sgang9
				deathkills ++
				sgang9_is_dead = 1
			ENDIF
		ENDIF
		
		IF sgang10_is_dead = 0
			IF IS_CHAR_DEAD	sgang10
				deathkills ++
				sgang10_is_dead = 1
			ENDIF
		ENDIF

	ENDIF


RETURN


}