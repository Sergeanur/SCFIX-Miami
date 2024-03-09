MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************baron mission 3***************************************
// **********************************STEAL FASTEST BOAT EVER!*********************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_baron3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_baron3_failed
ENDIF

GOSUB mission_cleanup_baron3

MISSION_END

// Variables for mission
{
LVAR_INT boat_mech1 boat_mech2 boat_mech3 set_all_guards_ojectives
LVAR_INT boat_guard1 boat_guard2 boat_guard3 boat_guard4 boat_guard5 boat_guard6 boat_guard7 boat_button_pressed 
LVAR_INT player_spotted_by_mech1 coke3_weapon 
VAR_FLOAT boat_guard1X boat_guard1Y boat_guard1Z boat_guard2X boat_guard2Y boat_guard2Z boat_guard3X boat_guard3Y boat_guard3Z
VAR_FLOAT boat_guard4X boat_guard4Y boat_guard4Z boat_guard5X boat_guard5Y boat_guard5Z	boat_guard1_Heading boat_guard2_Heading
VAR_INT raise_the_alarm	this_guard boat_guard5_chat1 boat_guard5_chat2 guard_boat1 guard_boat2
VAR_INT boat_guard3_is_looking1 boat_guard3_is_looking2	boat_guard3_timer played_show_boat_cut
VAR_INT boat_guard4_is_looking1 boat_guard4_is_looking2	boat_guard4_timer cs_dshotgn
VAR_INT boat_guard5_is_looking1 boat_guard5_is_looking2	boat_guard5_timer Sphere_cok3
VAR_INT boat_guard8 boat_guard9 boat_guard10 boat_guard11 boat_guard12 boat_guard13

// ***************************************Mission Start*************************************

mission_start_baron3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME baron3
WAIT 0

LOAD_MISSION_TEXT BARON3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0

boat_guard3_is_looking1 = 0
boat_guard3_is_looking2 = 0
boat_guard4_is_looking1 = 0
boat_guard4_is_looking2	= 0
boat_guard5_is_looking1 = 0
boat_guard5_is_looking2	= 0
boat_guard5_chat1 = 0 
boat_guard5_chat2 = 0
boat_button_pressed = 0
raise_the_alarm = 0
boat_guard1_Heading = 270.0
boat_guard2_Heading = 270.0
played_show_boat_cut = 0
set_all_guards_ojectives = 0
player_spotted_by_mech1 = 0

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdiaz
LOAD_SPECIAL_MODEL CUTOBJ01 dshotgn

LOAD_ALL_MODELS_NOW

LOAD_SCENE -378.3 -591.9 25.8
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0

ENDWHILE

LOAD_UNCOMPRESSED_ANIM CSplay
LOAD_UNCOMPRESSED_ANIM csdiaz

LOAD_CUTSCENE cok_3
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534 
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_diaz
SET_CUTSCENE_ANIM cs_diaz csdiaz

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_dshotgn
ATTACH_CUTSCENE_OBJECT_TO_BONE cs_dshotgn cs_diaz BONE_R_HAND

CLEAR_AREA -379.2 -536.4 16.2 0.5 TRUE
SET_PLAYER_COORDINATES player1 -379.2 -536.4 16.2
SET_PLAYER_HEADING player1 0.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//gun shot
IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_BIG_GUN_FLASH -386.581 -614.139 17.96 -386.794 -614.627 18.155   
ENDIF

WHILE cs_time < 3599
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_A ) 10000 1 // Mission brief

WHILE cs_time < 5985
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_B ) 10000 1 // Mission brief

WHILE cs_time < 8050
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_C ) 10000 1 // Mission brief

WHILE cs_time < 9520
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_D ) 10000 1 // Mission brief

WHILE cs_time < 12144
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_E ) 10000 1 // Mission brief

WHILE cs_time < 13827
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_F ) 10000 1 // Mission brief

WHILE cs_time < 16253
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_G ) 10000 1 // Mission brief

WHILE cs_time < 18599
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_H ) 10000 1 // Mission brief

WHILE cs_time < 19835
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_I ) 10000 1 // Mission brief

WHILE cs_time < 23576
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_J ) 10000 1 // Mission brief

WHILE cs_time < 28644
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_K ) 10000 1 // Mission brief

WHILE cs_time < 32972
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_L ) 10000 1 // Mission brief

WHILE cs_time < 35549
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_M ) 10000 1 // Mission brief

WHILE cs_time < 40624 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_O ) 10000 1 // Mission brief

WHILE cs_time < 43796
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_P ) 10000 1 // Mission brief

WHILE cs_time < 43866
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
							
//gun shot 
IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_BIG_GUN_FLASH -386.404 -614.265 17.955 -386.639 -614.744 18.148
ENDIF

WHILE cs_time < 44500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//gun shot
IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_BIG_GUN_FLASH -386.466 -614.374 17.876 -386.739 -614.85 18.024  
ENDIF

WHILE cs_time < 46018
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK3_N ) 10000 1 // Mission brief

WHILE cs_time < 47040
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_PED_DENSITY_MULTIPLIER 1.0

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -379.2 -536.4 16.2


WAIT 500

DO_FADE 1500 FADE_IN

REQUEST_MODEL HMYAP
REQUEST_MODEL squalo
REQUEST_MODEL HMYST
REQUEST_MODEL tec9
REQUEST_MODEL hammer
REQUEST_MODEL screwdriver
REQUEST_MODEL speeder
REQUEST_MODEL dinghy
REQUEST_MODEL ruger

WHILE NOT HAS_MODEL_LOADED HMYAP 
OR NOT HAS_MODEL_LOADED squalo 
OR NOT HAS_MODEL_LOADED HMYST
OR NOT HAS_MODEL_LOADED	tec9
OR NOT HAS_MODEL_LOADED hammer
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED screwdriver
OR NOT HAS_MODEL_LOADED	speeder
OR NOT HAS_MODEL_LOADED	dinghy 
OR NOT HAS_MODEL_LOADED ruger
	WAIT 0

ENDWHILE

DELETE_OBJECT boat_closed

// START OF MISSION

ADD_SPHERE -665.4 -1484.7 12.8 1.0 Sphere_cok3	

CREATE_CAR squalo -597.6 -1507.7 5.4 fastest_boat
SET_CAR_HEADING fastest_boat 250.0
ADD_BLIP_FOR_CAR fastest_boat fastest_boat_blip  

PRINT_NOW ( COK3_8 ) 10000 1 // Go to the boat yard at the dock and steal the fastest boat!

WHILE NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 fastest_boat 120.0 120.0 FALSE
	WAIT 0
	
		IF IS_CAR_DEAD fastest_boat
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ENDIF

ENDWHILE

SET_ZONE_PED_INFO DOCKS DAY   (2) 0 0 0 0 0 0 0 0 0 20 
SET_ZONE_PED_INFO DOCKS NIGHT (2) 0 0 0 0 0 0 0 0 0 10

CREATE_CAR speeder -582.4 -1493.6 5.4 guard_boat1
SET_CAR_HEADING guard_boat1 250.0

CREATE_CAR dinghy -576.1 -1525.5 5.4 guard_boat2
SET_CAR_HEADING guard_boat2 250.0

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -640.9 -1491.3 -100.0 boat_guard1	//Guarding the front door
SET_CHAR_HEADING boat_guard1 270.0
CLEAR_CHAR_THREAT_SEARCH boat_guard1
SET_CHAR_THREAT_SEARCH boat_guard1 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard1 WEAPONTYPE_RUGER 500
SET_CHAR_STAY_IN_SAME_PLACE boat_guard1 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -636.8 -1480.0 -100.0 boat_guard2	//Guarding the front door
SET_CHAR_HEADING boat_guard2 270.0
CLEAR_CHAR_THREAT_SEARCH boat_guard2
SET_CHAR_THREAT_SEARCH boat_guard2 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard2 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard2 WEAPONTYPE_RUGER 500
SET_CHAR_STAY_IN_SAME_PLACE boat_guard2 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -623.9 -1477.7 -100.0 boat_guard3	//Starts close to the boat
SET_CHAR_HEADING boat_guard3 73.5
CLEAR_CHAR_THREAT_SEARCH boat_guard3
SET_CHAR_THREAT_SEARCH boat_guard3 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard3 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard3 WEAPONTYPE_RUGER 500

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -682.8 -1484.8 -100.0 boat_guard4	//Starts close to the entrance
SET_CHAR_HEADING boat_guard4 260.0
CLEAR_CHAR_THREAT_SEARCH boat_guard4
SET_CHAR_THREAT_SEARCH boat_guard4 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard4 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard4 WEAPONTYPE_RUGER 500

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -671.7 -1459.1 -100.0 boat_guard5
SET_CHAR_HEADING boat_guard5 160.5			   
CLEAR_CHAR_THREAT_SEARCH boat_guard5
SET_CHAR_THREAT_SEARCH boat_guard5 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard5 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard5 WEAPONTYPE_RUGER 500

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -573.7 -1522.5 6.9 boat_guard6 //On jetty near boat
SET_CHAR_HEADING boat_guard6 70.0			   
CLEAR_CHAR_THREAT_SEARCH boat_guard6
SET_CHAR_THREAT_SEARCH boat_guard6 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard6 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard6 WEAPONTYPE_RUGER 500
SET_CHAR_STAY_IN_SAME_PLACE boat_guard6 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -586.9 -1496.2 7.0 boat_guard7 //On jetty opposite side
SET_CHAR_HEADING boat_guard7 76.0			   						
CLEAR_CHAR_THREAT_SEARCH boat_guard7
SET_CHAR_THREAT_SEARCH boat_guard7 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_guard7 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_guard7 WEAPONTYPE_RUGER 500
SET_CHAR_STAY_IN_SAME_PLACE boat_guard7 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYAP -662.0 -1481.7 13.0 boat_mech1
SET_CHAR_HEADING boat_mech1 6.0
CLEAR_CHAR_THREAT_SEARCH boat_mech1
SET_CHAR_THREAT_SEARCH boat_mech1 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_mech1 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_mech1 WEAPONTYPE_HAMMER 0

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYAP -661.9 -1479.7 12.5 boat_mech2
SET_CHAR_HEADING boat_mech2 200.0
CLEAR_CHAR_THREAT_SEARCH boat_mech2
SET_CHAR_THREAT_SEARCH boat_mech2 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_mech2 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_mech2 WEAPONTYPE_SCREWDRIVER 0

CREATE_CHAR PEDTYPE_GANG_CUBAN HMYAP -662.4 -1481.6 13.0 boat_mech3
SET_CHAR_HEADING boat_mech3 280.0
CLEAR_CHAR_THREAT_SEARCH boat_mech3
SET_CHAR_THREAT_SEARCH boat_mech3 THREAT_PLAYER1
SET_CHAR_PERSONALITY boat_mech3 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR boat_mech3 WEAPONTYPE_HAMMER 0
SET_CHARS_CHATTING boat_mech3 boat_mech2 999999

TIMERB = 0
TIMERA = 0

steel_boat_loop:

	WAIT 0

	IF NOT IS_CAR_DEAD fastest_boat
		IF IS_PLAYER_IN_CAR player1 fastest_boat
			GOTO get_boat_to_mansion
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE

	ENDIF

	IF IS_CAR_DEAD fastest_boat
		IF IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
			REMOVE_SPHERE Sphere_cok3
			REMOVE_BLIP fastest_boat_blip
			WHILE IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
				WAIT 0

			ENDWHILE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ELSE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ENDIF
	ENDIF

	IF boat_button_pressed = 0
		GOSUB boat_cut_scenes
	ENDIF
	 
	IF NOT IS_CHAR_DEAD boat_mech1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_mech1 20.0 20.0 6.0 FALSE
		AND HAS_CHAR_SPOTTED_PLAYER boat_mech1 player1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech1 player1
			player_spotted_by_mech1 = 1
		ENDIF
		IF NOT IS_CHAR_HEALTH_GREATER boat_mech1 90
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech1 player1
			player_spotted_by_mech1 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD boat_mech2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_mech2 20.0 20.0 6.0 FALSE
		AND HAS_CHAR_SPOTTED_PLAYER boat_mech2 player1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech2 player1
			player_spotted_by_mech1 = 1
		ENDIF
		IF NOT IS_CHAR_HEALTH_GREATER boat_mech2 90
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech2 player1
			player_spotted_by_mech1 = 1
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD boat_mech3
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_mech3 20.0 20.0 6.0 FALSE
		AND HAS_CHAR_SPOTTED_PLAYER boat_mech3 player1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech3 player1
			player_spotted_by_mech1 = 1
		ENDIF
		IF NOT IS_CHAR_HEALTH_GREATER boat_mech3 90
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech3 player1
			player_spotted_by_mech1 = 1
		ENDIF
	ENDIF

	IF player_spotted_by_mech1 = 1
		IF NOT IS_CHAR_DEAD boat_mech1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD boat_mech2
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech2 player1
		ENDIF
		IF NOT IS_CHAR_DEAD boat_mech3
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_mech3 player1
		ENDIF
		player_spotted_by_mech1 = 2
	ENDIF

	IF NOT IS_CHAR_DEAD boat_guard1

		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard1 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard1 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard1 90
				raise_the_alarm = 1
			ENDIF

			IF TIMERB > 3000
			AND	TIMERB < 6000
				IF NOT boat_guard1_Heading = 160.0
					//GET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
					boat_guard1_Heading = boat_guard1_Heading - 5.0
					SET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
				ENDIF
			ENDIF

			IF TIMERB > 6000
			AND	TIMERB < 9000
				IF NOT boat_guard1_Heading = 270.0
					//GET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
					boat_guard1_Heading = boat_guard1_Heading + 5.0
					SET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
				ENDIF	
			ENDIF

			IF TIMERB > 9000
			AND	TIMERB < 12000
				IF NOT boat_guard1_Heading = 340.0
					//GET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
					boat_guard1_Heading = boat_guard1_Heading + 5.0
					SET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
				ENDIF
			ENDIF

			IF TIMERB > 12000
			AND	TIMERB < 15000
				IF NOT boat_guard1_Heading = 270.0
					//GET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
					boat_guard1_Heading = boat_guard1_Heading - 5.0
					SET_CHAR_HEADING boat_guard1 boat_guard1_Heading 
				ENDIF
			ENDIF

			IF TIMERB > 15000
				TIMERB = 0
			ENDIF

		ENDIF

		GET_CHAR_COORDINATES boat_guard1 boat_guard1X boat_guard1Y boat_guard1Z 
		this_guard = boat_guard1

		GOSUB check_for_dead_guards

	ENDIF

	IF NOT IS_CHAR_DEAD boat_guard2

		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard2 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard2 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard2 90
				raise_the_alarm = 1
			ENDIF

			IF TIMERA > 4000
			AND	TIMERA < 7000
				IF NOT boat_guard2_Heading = 160.0
					//GET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
					boat_guard2_Heading = boat_guard2_Heading - 5.0
					SET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
				ENDIF
			ENDIF

			IF TIMERA > 7000
			AND	TIMERA < 10000
				IF NOT boat_guard2_Heading = 270.0
					//GET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
					boat_guard2_Heading = boat_guard2_Heading + 5.0
					SET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
				ENDIF
			ENDIF

			IF TIMERA > 10000
			AND	TIMERA < 13000
				IF NOT boat_guard2_Heading = 340.0
					//GET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
					boat_guard2_Heading = boat_guard2_Heading + 5.0
					SET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
				ENDIF
			ENDIF

			IF TIMERA > 13000
			AND	TIMERA < 16000
				IF NOT boat_guard2_Heading = 270.0
					//GET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
					boat_guard2_Heading = boat_guard2_Heading - 5.0
					SET_CHAR_HEADING boat_guard2 boat_guard2_Heading 
				ENDIF
			ENDIF

			IF TIMERA > 16000
				TIMERA = 0
			ENDIF

		ENDIF

		GET_CHAR_COORDINATES boat_guard2 boat_guard2X boat_guard2Y boat_guard2Z
		this_guard = boat_guard2  

		GOSUB check_for_dead_guards

	ENDIF

	IF NOT IS_CHAR_DEAD boat_guard3
		
		IF raise_the_alarm = 0
		
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard3 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard3 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard3 90
				raise_the_alarm = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard3 -623.9 -1477.7 12.0 1.0 1.0 4.0 FALSE
				IF boat_guard3_is_looking1 = 0
					SET_CHAR_WAIT_STATE boat_guard3 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard3_timer = 0
					boat_guard3_is_looking1 = 1
				ENDIF

				IF boat_guard3_is_looking1 = 1
					boat_guard3_timer = boat_guard3_timer + 1
					IF boat_guard3_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard3 -671.7 -1459.1
						SET_CHAR_USE_PEDNODE_SEEK boat_guard3 FALSE
						boat_guard3_is_looking2 = 0					
					ENDIF
				ENDIF
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard3 -671.7 -1459.1 12.0 1.0 1.0 4.0 FALSE
				IF boat_guard3_is_looking2 = 0
					SET_CHAR_WAIT_STATE boat_guard3 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard3_timer = 0
					boat_guard3_is_looking2 = 1
				ENDIF

				IF boat_guard3_is_looking2 = 1
					boat_guard3_timer = boat_guard3_timer + 1
					IF boat_guard3_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard3 -623.9 -1477.7
						SET_CHAR_USE_PEDNODE_SEEK boat_guard3 FALSE
						boat_guard3_is_looking1 = 0
					ENDIF
				ENDIF
			ENDIF

		ENDIF

		GET_CHAR_COORDINATES boat_guard3 boat_guard3X boat_guard3Y boat_guard3Z
		this_guard = boat_guard3

		GOSUB check_for_dead_guards
	ENDIF


	IF NOT IS_CHAR_DEAD boat_guard4

		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard4 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard4 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard4 90
				raise_the_alarm = 1
			ENDIF
			  
			IF LOCATE_CHAR_ON_FOOT_3D boat_guard4 -682.8 -1484.8 14.5 1.0 1.0 4.0 FALSE
				IF boat_guard4_is_looking1 = 0
					SET_CHAR_WAIT_STATE boat_guard4 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard4_timer = 0
					boat_guard4_is_looking1 = 1
				ENDIF

				IF boat_guard4_is_looking1 = 1
					boat_guard4_timer = boat_guard4_timer + 1
					IF boat_guard4_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard4 -638.9 -1500.9
						SET_CHAR_USE_PEDNODE_SEEK boat_guard4 FALSE
						boat_guard4_is_looking2 = 0					
					ENDIF
				ENDIF
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard4 -638.9 -1500.9 12.0 1.0 1.0 4.0 FALSE
				IF boat_guard4_is_looking2 = 0
					SET_CHAR_WAIT_STATE boat_guard4 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard4_timer = 0
					boat_guard4_is_looking2 = 1
				ENDIF

				IF boat_guard4_is_looking2 = 1
					boat_guard4_timer = boat_guard4_timer + 1
					IF boat_guard4_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard4 -682.8 -1484.8
						SET_CHAR_USE_PEDNODE_SEEK boat_guard4 FALSE
						boat_guard4_is_looking1 = 0					
					ENDIF											
				ENDIF
			ENDIF

		ENDIF

		GET_CHAR_COORDINATES boat_guard4 boat_guard4X boat_guard4Y boat_guard4Z
		this_guard = boat_guard4

		GOSUB check_for_dead_guards

	ENDIF


	IF NOT IS_CHAR_DEAD boat_guard5

		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard5 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard5 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard5 90
				raise_the_alarm = 1
			ENDIF
		  
			IF LOCATE_CHAR_ON_FOOT_3D boat_guard5 -671.7 -1459.1 12.0 1.0 1.0 4.0 FALSE
				IF boat_guard5_is_looking1 = 0
					SET_CHAR_WAIT_STATE boat_guard5 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard5_timer = 0
					boat_guard5_chat1 = 0
					boat_guard5_is_looking1 = 1
				ENDIF

				IF boat_guard5_is_looking1 = 1
					boat_guard5_timer = boat_guard5_timer + 1
					IF boat_guard5_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard5 -682.8 -1484.8
						SET_CHAR_USE_PEDNODE_SEEK boat_guard5 FALSE
						boat_guard5_is_looking2 = 0					
					ENDIF
				ENDIF	
				
				IF NOT IS_CHAR_DEAD	boat_guard4
					IF LOCATE_CHAR_ON_FOOT_3D boat_guard4 -671.7 -1459.1 12.0 1.0 1.0 4.0 FALSE
						IF boat_guard5_chat1 = 0
							SET_CHAR_WAIT_STATE boat_guard4 WAITSTATE_CROSS_ROAD_LOOK 0
							SET_CHAR_OBJ_NO_OBJ boat_guard4
							SET_CHAR_WAIT_STATE boat_guard5 WAITSTATE_CROSS_ROAD_LOOK 0
							SET_CHAR_OBJ_NO_OBJ boat_guard5
							SET_CHARS_CHATTING boat_guard5 boat_guard4 10000	
							boat_guard5_chat1 = 1
						ENDIF
					ENDIF
				ENDIF										  
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard5 -682.8 -1484.8 12.0 1.0 1.0 4.0 FALSE
				IF boat_guard5_is_looking2 = 0
					SET_CHAR_WAIT_STATE boat_guard5 WAITSTATE_CROSS_ROAD_LOOK 5000
					boat_guard5_timer = 0
					boat_guard5_chat2 = 0
					boat_guard5_is_looking2 = 1
				ENDIF

				IF boat_guard5_is_looking2 = 1
					boat_guard5_timer = boat_guard5_timer + 1
					IF boat_guard5_timer > 90
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard5 -671.7 -1459.1
						SET_CHAR_USE_PEDNODE_SEEK boat_guard5 FALSE
						boat_guard5_is_looking1 = 0
					ENDIF
				ENDIF

				IF NOT IS_CHAR_DEAD	boat_guard3
					IF LOCATE_CHAR_ON_FOOT_3D boat_guard3 -682.8 -1484.8 12.0 1.0 1.0 4.0 FALSE
						IF boat_guard5_chat2 = 0
							SET_CHAR_WAIT_STATE boat_guard3 WAITSTATE_CROSS_ROAD_LOOK 0
							SET_CHAR_WAIT_STATE boat_guard5 WAITSTATE_CROSS_ROAD_LOOK 0
							SET_CHAR_OBJ_NO_OBJ boat_guard5
							SET_CHAR_OBJ_NO_OBJ boat_guard3
							SET_CHARS_CHATTING boat_guard5 boat_guard3 10000
							boat_guard5_chat2 = 1
						ENDIF	
					ENDIF
				ENDIF
			ENDIF

		ENDIF

		GET_CHAR_COORDINATES boat_guard5 boat_guard5X boat_guard5Y boat_guard5Z
		this_guard = boat_guard5

		GOSUB check_for_dead_guards

	ENDIF

	IF NOT IS_CHAR_DEAD boat_guard6

		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard6 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard6 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard6 90
				raise_the_alarm = 1
			ENDIF
							 
			IF LOCATE_CHAR_ON_FOOT_3D boat_guard6 -573.7 -1522.5 7.0 1.0 1.0 4.0 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard6 -598.6 -1513.0
				SET_CHAR_USE_PEDNODE_SEEK boat_guard6 FALSE
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard6 -598.6 -1513.0 7.0 1.0 1.0 4.0 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard6 -573.7 -1522.5 
				SET_CHAR_USE_PEDNODE_SEEK boat_guard6 FALSE
			ENDIF

		ENDIF

	ENDIF

	IF NOT IS_CHAR_DEAD boat_guard7
	
		IF raise_the_alarm = 0

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 boat_guard7 20.0 20.0 6.0 FALSE
			AND HAS_CHAR_SPOTTED_PLAYER boat_guard7 player1
				raise_the_alarm = 1
			ENDIF

			IF NOT IS_CHAR_HEALTH_GREATER boat_guard7 90
				raise_the_alarm = 1
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard7 -586.9 -1496.2 7.0 1.0 1.0 4.0 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard7 -569.0 -1503.1
				SET_CHAR_USE_PEDNODE_SEEK boat_guard7 FALSE
			ENDIF

			IF LOCATE_CHAR_ON_FOOT_3D boat_guard7 -569.0 -1503.1 7.0 1.0 1.0 4.0 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT boat_guard7 -586.9 -1496.2
				SET_CHAR_USE_PEDNODE_SEEK boat_guard7 FALSE 
			ENDIF

		ENDIF

	ENDIF

	GOSUB chars_attack_player
	
	IF IS_CAR_DEAD fastest_boat
		IF IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
			REMOVE_SPHERE Sphere_cok3
			REMOVE_BLIP fastest_boat_blip
			WHILE IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
				WAIT 0

			ENDWHILE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ELSE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ENDIF
	ENDIF

GOTO steel_boat_loop


get_boat_to_mansion:

REMOVE_BLIP fastest_boat_blip

ADD_BLIP_FOR_COORD -378.5 -660.0 5.6 fastest_boat_blip  

PRINT_NOW ( COK3_6 ) 5000 1 // Get the boat to the mansion.

ALTER_WANTED_LEVEL_NO_DROP Player1 3

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -378.5 -660.0 5.0 20.0 30.0 6.0 TRUE
OR NOT IS_PLAYER_IN_CAR player1 fastest_boat 
	WAIT 0

	IF IS_CAR_DEAD fastest_boat
		IF IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
			REMOVE_SPHERE Sphere_cok3
			REMOVE_BLIP fastest_boat_blip
			WHILE IS_PLAYER_IN_ANGLED_AREA_3D Player1 -643.2 -1495.3 12.0 -679.1 -1481.3 18.0 -19.5 FALSE
				WAIT 0

			ENDWHILE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ELSE
			PRINT_NOW ( COK3_7 ) 5000 1 // You destroyed the boat!
			GOTO mission_baron3_failed
		ENDIF
	ENDIF

	GOSUB chars_attack_player

ENDWHILE

IF NOT IS_CAR_DEAD fastest_boat
	BOAT_STOP fastest_boat	
	SET_BOAT_CRUISE_SPEED fastest_boat 0.0
ENDIF

DO_FADE 1000 FADE_OUT

WAIT 1000

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

CLEAR_AREA -366.1 -655.2 6.9 1.0 TRUE

IF NOT IS_CAR_DEAD fastest_boat
	/*
	SET_PLAYER_HEADING player1 0.0
	//SET_CAMERA_IN_FRONT_OF_PLAYER
	SET_CAR_COORDINATES fastest_boat -378.5 -660.0 5.6
	SET_CAR_HEADING fastest_boat 270.0
	*/
	SET_CAR_COORDINATES fastest_boat -393.8 -660.4 5.6
	SET_CAR_HEADING fastest_boat 270.0
	BOAT_GOTO_COORDS fastest_boat -378.5 -660.0 5.6
	SET_BOAT_CRUISE_SPEED fastest_boat 8.0

ENDIF

WAIT 0

SET_FIXED_CAMERA_POSITION -365.183 -654.170 8.057 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -366.024 -654.710 8.009 JUMP_CUT	

DO_FADE 1500 FADE_IN

TIMERB = 0

WHILE NOT TIMERB > 3500
	WAIT 0

	IF NOT IS_CAR_DEAD fastest_boat
		IF LOCATE_CAR_3D fastest_boat -378.5 -660.0 5.6 2.0 2.0 4.0 FALSE
			BOAT_STOP fastest_boat	
			SET_BOAT_CRUISE_SPEED fastest_boat 0.0
		ENDIF
	ENDIF
	 
ENDWHILE
 
skip_to_end_cok3:

DO_FADE 1000 FADE_OUT

WAIT 1000

CLEAR_AREA -372.7 -656.7 6.9 1.0 TRUE

IF NOT IS_CAR_DEAD fastest_boat

	IF IS_PLAYER_IN_CAR	player1 fastest_boat
		WARP_PLAYER_FROM_CAR_TO_COORD player1 -372.7 -656.7 6.9
	ELSE
		SET_PLAYER_COORDINATES player1 -372.7 -656.7 6.9
	ENDIF

ENDIF

IF NOT IS_CAR_DEAD fastest_boat
	SET_CAR_COORDINATES fastest_boat -378.5 -660.0 5.6
	SET_CAR_HEADING fastest_boat 270.0
ENDIF


SET_PLAYER_HEADING player1 90.0
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

WAIT 500
DO_FADE 1000 FADE_IN

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF

  
GOTO mission_baron3_passed


 // Mission baron3 failed

mission_baron3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission baron3 passed

mission_baron3_passed:

flag_baron_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000 
REGISTER_MISSION_PASSED	COK_3
PLAYER_MADE_PROGRESS 1

// FIXMIAMI: START - save boat colour for the next mission
IF NOT IS_CAR_DEAD fastest_boat
	GET_CAR_COLOURS fastest_boat fastest_boat_col1 fastest_boat_col2
ENDIF
// FIXMIAMI: END

START_NEW_SCRIPT baron_mission4_loop
RETURN
	

// mission cleanup

mission_cleanup_baron3:

flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
MARK_MODEL_AS_NO_LONGER_NEEDED HMYAP
MARK_MODEL_AS_NO_LONGER_NEEDED squalo
MARK_MODEL_AS_NO_LONGER_NEEDED HMYST
MARK_MODEL_AS_NO_LONGER_NEEDED tec9
MARK_MODEL_AS_NO_LONGER_NEEDED hammer
MARK_MODEL_AS_NO_LONGER_NEEDED screwdriver
MARK_MODEL_AS_NO_LONGER_NEEDED speeder
MARK_MODEL_AS_NO_LONGER_NEEDED dinghy
MARK_MODEL_AS_NO_LONGER_NEEDED ruger
IF NOT IS_CAR_DEAD fastest_boat
	MARK_CAR_AS_NO_LONGER_NEEDED fastest_boat
ENDIF
CREATE_OBJECT_NO_OFFSET b_hse_doors -640.012 -1485.941 15.457 boat_closed
DONT_REMOVE_OBJECT boat_closed
REMOVE_SPHERE Sphere_cok3
SET_ZONE_PED_INFO DOCKS DAY   (13) 0 0 0 0 0 0 0 0 0 20 
SET_ZONE_PED_INFO DOCKS NIGHT (10) 0 0 0 0 0 0 0 0 0 10
REMOVE_BLIP fastest_boat_blip
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
MISSION_HAS_FINISHED
RETURN


check_for_dead_guards:

	IF IS_CHAR_DEAD	boat_guard1
	AND LOCATE_CHAR_ON_FOOT_3D this_guard boat_guard1X boat_guard1Y boat_guard1Z 4.0 4.0 4.0 FALSE
		raise_the_alarm = 1	
	ENDIF
	IF IS_CHAR_DEAD	boat_guard2
	AND LOCATE_CHAR_ON_FOOT_3D this_guard boat_guard2X boat_guard2Y boat_guard2Z 4.0 4.0 4.0 FALSE
		raise_the_alarm = 1	
	ENDIF
	IF IS_CHAR_DEAD	boat_guard3
	AND LOCATE_CHAR_ON_FOOT_3D this_guard boat_guard3X boat_guard3Y boat_guard3Z 4.0 4.0 4.0 FALSE
		raise_the_alarm = 1	
	ENDIF
	IF IS_CHAR_DEAD	boat_guard4
	AND LOCATE_CHAR_ON_FOOT_3D this_guard boat_guard4X boat_guard4Y boat_guard4Z 4.0 4.0 4.0 FALSE
		raise_the_alarm = 1	
	ENDIF
	IF IS_CHAR_DEAD	boat_guard5
	AND LOCATE_CHAR_ON_FOOT_3D this_guard boat_guard5X boat_guard5Y boat_guard5Z 4.0 4.0 4.0 FALSE
		raise_the_alarm = 1	
	ENDIF


RETURN


boat_cut_scenes:

	IF NOT IS_CAR_DEAD fastest_boat
		SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
		SET_CAR_HEADING fastest_boat 256.0
	ENDIF

	IF played_show_boat_cut = 0
		IF NOT IS_CAR_DEAD fastest_boat
			IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 fastest_boat 40.0 40.0 20.0 FALSE
				SET_PLAYER_CONTROL player1 OFF
				SWITCH_WIDESCREEN ON
				PRINT_NOW ( COK3_5 ) 6000 1 // Find the switch to lower the boat.
				SET_FIXED_CAMERA_POSITION -598.588 -1496.503 16.717 0.0 0.0 0.0 
				POINT_CAMERA_AT_POINT -598.493 -1497.474 16.496 JUMP_CUT
				TIMERB = 0
				WHILE NOT TIMERB > 500
					WAIT 0

					IF NOT IS_CAR_DEAD fastest_boat
						SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
						SET_CAR_HEADING fastest_boat 256.0
					ENDIF
					
				ENDWHILE

				WHILE NOT TIMERB > 4000
					WAIT 0

					IF NOT IS_CAR_DEAD fastest_boat
						SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
						SET_CAR_HEADING fastest_boat 256.0
					ENDIF

					IF IS_BUTTON_PRESSED PAD1 cross
						WHILE IS_BUTTON_PRESSED	PAD1 cross
							WAIT 0
							IF NOT IS_CAR_DEAD fastest_boat
								SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
								SET_CAR_HEADING fastest_boat 256.0
							ENDIF

							IF TIMERB > 3500
								GOTO skip_boat_cut
							ENDIF
						ENDWHILE
						GOTO skip_boat_cut
					ENDIF 
					
				ENDWHILE

				skip_boat_cut:

				SET_PLAYER_CONTROL player1 ON
				SWITCH_WIDESCREEN OFF
				SET_CAMERA_BEHIND_PLAYER
				RESTORE_CAMERA_JUMPCUT
				played_show_boat_cut = 1
			ENDIF
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ON_FOOT_3D player1 -665.4 -1484.7 12.8 0.5 0.5 1.5 FALSE
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON
		SET_PLAYER_HEADING player1 150.0
		GET_CURRENT_PLAYER_WEAPON player1 coke3_weapon
		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
		SET_CHAR_WAIT_STATE scplayer WAITSTATE_USE_ATM 1000
		TIMERB = 0
		WHILE NOT TIMERB > 1000
			WAIT 0

			IF NOT IS_CAR_DEAD fastest_boat
				SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
				SET_CAR_HEADING fastest_boat 256.0
			ENDIF

		ENDWHILE
		
		CLEAR_CHAR_WAIT_STATE scplayer
		SET_CURRENT_PLAYER_WEAPON player1 coke3_weapon
		SET_FIXED_CAMERA_POSITION -600.685 -1498.843 25.889 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT -600.498 -1499.380 25.066 JUMP_CUT
		REMOVE_SPHERE Sphere_cok3

		WHILE NOT TIMERB > 2500
			WAIT 0

			IF NOT IS_CAR_DEAD fastest_boat
				SET_CAR_COORDINATES fastest_boat -597.6 -1507.7 11.5
				SET_CAR_HEADING fastest_boat 256.0
			ENDIF

		ENDWHILE

		WAIT 4000

		SET_PLAYER_COORDINATES player1 -665.4 -1484.7 12.8
		SET_PLAYER_HEADING player1 150.0
		SET_PLAYER_CONTROL player1 ON
		SWITCH_WIDESCREEN OFF
		RESTORE_CAMERA_JUMPCUT
		PRINT_NOW ( COK3_9 ) 8000 1 // Now get into the boat.
		
		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -640.6 -1500.3 -100.0 boat_guard8
		SET_CHAR_HEADING boat_guard8 335.0
		CLEAR_CHAR_THREAT_SEARCH boat_guard8
		SET_CHAR_THREAT_SEARCH boat_guard8 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard8 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard8 WEAPONTYPE_TEC9 500
		SET_CHAR_STAY_IN_SAME_PLACE boat_guard8 TRUE

		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -652.5 -1497.5 -100.0 boat_guard9	
		SET_CHAR_HEADING boat_guard9 245.0
		CLEAR_CHAR_THREAT_SEARCH boat_guard9
		SET_CHAR_THREAT_SEARCH boat_guard9 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard9 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard9 WEAPONTYPE_TEC9 500
		SET_CHAR_STAY_IN_SAME_PLACE boat_guard9 TRUE

		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -632.5 -1476.1 -100.0 boat_guard10	
		SET_CHAR_HEADING boat_guard10 165.9
		CLEAR_CHAR_THREAT_SEARCH boat_guard10
		SET_CHAR_THREAT_SEARCH boat_guard10 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard10 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard10 WEAPONTYPE_TEC9 500

		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -643.2 -1467.1 -100.0 boat_guard11	
		SET_CHAR_HEADING boat_guard11 252.0
		CLEAR_CHAR_THREAT_SEARCH boat_guard11
		SET_CHAR_THREAT_SEARCH boat_guard11 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard11 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard11 WEAPONTYPE_TEC9 500

		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -666.5 -1458.0 -100.0 boat_guard12	
		SET_CHAR_HEADING boat_guard12 245.0
		CLEAR_CHAR_THREAT_SEARCH boat_guard12
		SET_CHAR_THREAT_SEARCH boat_guard12 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard12 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard12 WEAPONTYPE_TEC9 500

		CREATE_CHAR PEDTYPE_GANG_CUBAN HMYST -678.8 -1486.3 -100.0 boat_guard13	
		SET_CHAR_HEADING boat_guard13 252.0
		CLEAR_CHAR_THREAT_SEARCH boat_guard13
		SET_CHAR_THREAT_SEARCH boat_guard13 THREAT_PLAYER1
		SET_CHAR_PERSONALITY boat_guard13 PEDSTAT_TOUGH_GUY
		GIVE_WEAPON_TO_CHAR boat_guard13 WEAPONTYPE_TEC9 500

		raise_the_alarm = 1

		boat_button_pressed = 1
	ENDIF

RETURN


chars_attack_player:

IF raise_the_alarm = 1

	IF set_all_guards_ojectives = 0
		IF NOT IS_CHAR_DEAD	boat_guard7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard7 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard6
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard6 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard5 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard4
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard4 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard3
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard3 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard2
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard2 player1
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_guard1 player1
		ENDIF
		set_all_guards_ojectives = 1
	ENDIF

	IF TIMERA > 1000
		GET_PLAYER_COORDINATES Player1 player_x player_y player_z

		IF NOT IS_CHAR_DEAD	boat_guard7
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard7 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard7 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard6
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard6 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard6 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard5
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard5 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard5 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard4
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard4 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard4 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard3
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard3 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard3 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard2
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard2 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard2 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	boat_guard1
			IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard1 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH boat_guard1 player_x player_y player_z 4.0 RUN
			ENDIF
		ENDIF

		IF boat_button_pressed = 1

			IF NOT IS_CHAR_DEAD boat_guard8
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard8 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard8 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD boat_guard9
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard9 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard9 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD boat_guard10
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard10 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard10 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD boat_guard11
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard11 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard11 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF
		
			IF NOT IS_CHAR_DEAD boat_guard12
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard12 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard12 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD boat_guard13
				IF NOT IS_CHAR_WANDER_PATH_CLEAR boat_guard13 player_x player_y player_z 4.0
					CHAR_FOLLOW_PATH boat_guard13 player_x player_y player_z 4.0 RUN
				ENDIF
			ENDIF

		ENDIF
		TIMERA = 0
	ENDIF
ENDIF

RETURN

}