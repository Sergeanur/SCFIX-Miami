MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// ****************************************Taxi WAR 3*****************************************
// *************************************Destruction Derby*************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_taxiwar3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_taxiwar3_failed
ENDIF

GOSUB mission_cleanup_taxiwar3

MISSION_END

// Variables for mission
{ 
LVAR_INT kingcab_man king_cab_obj_set taxiwar_cash_pickup Close_cab_gate kingcab_man_goes_radge

// ***************************************Mission Start*************************************

mission_start_taxiwar3:


REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME taxwar3

WAIT 0

LOAD_MISSION_TEXT TAXIWA3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1020.8 191.1 10.5 350.0

counter_taxiwar = 0
dead_taxicab1 = 0
dead_taxicab2 = 0
dead_taxicab3 = 0
dead_taxicab4 = 0
dead_taxicab5 = 0
dead_taxicab6 = 0

cab1_obj_set = 0
cab2_obj_set = 0
cab3_obj_set = 0
cab4_obj_set = 0
cab5_obj_set = 0
cab6_obj_set = 0
king_cab_obj_set = 0
Close_cab_gate = 0
kingcab_man_goes_radge = 0

LOAD_MISSION_AUDIO 1 TAX3_1
LOAD_MISSION_AUDIO 2 TAX3_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( TAX3_1 ) 4500 1 

WAIT 500

TIMERA = 0

WHILE NOT TIMERA > 4000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi3_cut
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( TAX3_2 ) 3000 1

TIMERA = 0

WHILE NOT TIMERA > 3000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi3_cut
	ENDIF

ENDWHILE

skip_passed_taxi3_cut:

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2

REQUEST_MODEL taxi
REQUEST_MODEL WMOCA
REQUEST_MODEL zebra
REQUEST_MODEL kaufman
REQUEST_MODEL katana

	WHILE NOT HAS_MODEL_LOADED taxi
	OR NOT HAS_MODEL_LOADED WMOCA
	OR NOT HAS_MODEL_LOADED zebra
	OR NOT HAS_MODEL_LOADED	kaufman
	OR NOT HAS_MODEL_LOADED katana
		WAIT 0

	ENDWHILE
	 
// START OF MISSION

LOAD_MISSION_AUDIO 1 TAX3_3
LOAD_MISSION_AUDIO 2 TAX3_4

PRINT_NOW ( TAXW3_1 ) 10000 1  //KILL THE CABS

ADD_BLIP_FOR_COORD -1094.0 -1292.0 10.5 blip1_taxicab1

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -1094.0 -1292.0 10.5 3.0 4.0 4.0 TRUE
OR NOT IS_PLAYER_IN_MODEL player1 kaufman
OR NOT IS_PLAYER_PRESSING_HORN player1	
	WAIT 0

	IF IS_PLAYER_IN_MODEL player1 kaufman 
		STORE_CAR_PLAYER_IS_IN player1 players_cab
	ELSE
		PRINT_NOW ( TAXW1_5 ) 1000 1 //You need to be in a Kaufman cab!
	ENDIF

	IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -1094.0 -1292.0 10.5 3.0 4.0 4.0 TRUE
	AND IS_PLAYER_IN_MODEL player1 kaufman
		PRINT_NOW ( HORN ) 1000 1
	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD players_cab
	LOCK_CAR_DOORS players_cab CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

REMOVE_BLIP blip1_taxicab1

CLEAR_AREA -989.9 -1252.2 10.4 50.0 TRUE

CREATE_CAR taxi -983.5 -1248.9 10.5 taxicab1
CREATE_CHAR_INSIDE_CAR taxicab1 PEDTYPE_CIVMALE WMOCA taximan1
ADD_BLIP_FOR_CAR taxicab1 blip1_taxicab1
SET_CAR_HEADING taxicab1 70.0 
SET_CAR_CRUISE_SPEED taxicab1 0.0
SET_CAR_DRIVING_STYLE taxicab1 0
SET_CHAR_PERSONALITY taximan1 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab1 255

CREATE_CAR taxi -976.1 -1251.7 10.5 taxicab2
CREATE_CHAR_INSIDE_CAR taxicab2 PEDTYPE_CIVMALE WMOCA taximan2
ADD_BLIP_FOR_CAR taxicab2 blip2_taxicab2
SET_CAR_HEADING taxicab2 70.0
SET_CAR_CRUISE_SPEED taxicab2 0.0
SET_CAR_DRIVING_STYLE taxicab2 0
SET_CHAR_PERSONALITY taximan2 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab2 255

CREATE_CAR taxi -970.5 -1253.6 10.5 taxicab3
CREATE_CHAR_INSIDE_CAR taxicab3 PEDTYPE_CIVMALE WMOCA taximan3
ADD_BLIP_FOR_CAR taxicab3 blip3_taxicab3
SET_CAR_HEADING taxicab3 70.0 
SET_CAR_CRUISE_SPEED taxicab3 0.0
SET_CAR_DRIVING_STYLE taxicab3 0
SET_CHAR_PERSONALITY taximan3 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab3 255

CREATE_CAR taxi -964.9 -1255.8 10.5 taxicab4
CREATE_CHAR_INSIDE_CAR taxicab4 PEDTYPE_CIVMALE WMOCA taximan4
ADD_BLIP_FOR_CAR taxicab4 blip4_taxicab4
SET_CAR_HEADING taxicab4 70.0
SET_CAR_CRUISE_SPEED taxicab4 0.0
SET_CAR_DRIVING_STYLE taxicab4 0
SET_CHAR_PERSONALITY taximan4 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab4 255

CREATE_CAR taxi -959.0 -1257.9 10.5 taxicab5
CREATE_CHAR_INSIDE_CAR taxicab5 PEDTYPE_CIVMALE WMOCA taximan5
ADD_BLIP_FOR_CAR taxicab5 blip5_taxicab5
SET_CAR_HEADING taxicab5 70.0
SET_CAR_CRUISE_SPEED taxicab5 0.0
SET_CAR_DRIVING_STYLE taxicab5 0
SET_CHAR_PERSONALITY taximan5 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab5 255

CREATE_CAR taxi -951.6 -1261.1 10.5 taxicab6
CREATE_CHAR_INSIDE_CAR taxicab6 PEDTYPE_CIVMALE WMOCA taximan6
ADD_BLIP_FOR_CAR taxicab6 blip6_taxicab6
SET_CAR_HEADING taxicab6 70.0
SET_CAR_CRUISE_SPEED taxicab6 0.0
SET_CAR_DRIVING_STYLE taxicab6 0
SET_CHAR_PERSONALITY taximan6 PEDSTAT_TOUGH_GUY
SET_CAR_STRAIGHT_LINE_DISTANCE taxicab6 255

WAIT 500

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -1089.808 -1286.083 13.512 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1090.248 -1286.970 13.374 JUMP_CUT

WAIT 2000

SET_FIXED_CAMERA_POSITION -1098.031 -1296.028 14.583 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1097.359 -1295.294 14.484 JUMP_CUT

IF HAS_MISSION_AUDIO_LOADED	1
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( TAX3_3 ) 4000 1
ENDIF

WAIT 2000

SET_FIXED_CAMERA_POSITION -989.263 -1239.276 10.429 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -989.007 -1240.218 10.646 JUMP_CUT

TIMERB = 0

IF NOT IS_CAR_DEAD taxicab1
	SET_CAR_CRUISE_SPEED taxicab1 30.0
	CAR_GOTO_COORDINATES taxicab1 -1065.6 -1224.2 10.5
ENDIF

IF NOT IS_CAR_DEAD taxicab2
	SET_CAR_CRUISE_SPEED taxicab2 28.0
	CAR_GOTO_COORDINATES taxicab2 -1065.6 -1224.2 10.5
ENDIF

IF NOT IS_CAR_DEAD taxicab3
	SET_CAR_CRUISE_SPEED taxicab3 26.0
	CAR_GOTO_COORDINATES taxicab3 -1065.6 -1224.2 10.5
ENDIF

IF NOT IS_CAR_DEAD taxicab4
	SET_CAR_CRUISE_SPEED taxicab4 24.0
	CAR_GOTO_COORDINATES taxicab4 -1065.6 -1224.2 10.5
ENDIF

IF NOT IS_CAR_DEAD taxicab5
	SET_CAR_CRUISE_SPEED taxicab5 22.0
	CAR_GOTO_COORDINATES taxicab5 -1065.6 -1224.2 10.5
ENDIF

IF NOT IS_CAR_DEAD taxicab6
	SET_CAR_CRUISE_SPEED taxicab6 19.0
	CAR_GOTO_COORDINATES taxicab6 -1065.6 -1224.2 10.5
ENDIF

WHILE NOT TIMERB > 10000
	WAIT 0

	IF NOT IS_CAR_DEAD taxicab1
		IF LOCATE_CAR_3D taxicab1 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab1 -1096.0 -1253.0 10.5  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD taxicab2
		IF LOCATE_CAR_3D taxicab2 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab2 -1090.1 -1257.2 10.5  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD taxicab3
		IF LOCATE_CAR_3D taxicab3 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab3 -1083.4 -1258.8 10.5  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD taxicab4
		IF LOCATE_CAR_3D taxicab4 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab4 -1075.7 -1261.5 10.5  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD taxicab5
		IF LOCATE_CAR_3D taxicab5 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab5 -1067.4 -1264.3 10.5  
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD taxicab6
		IF LOCATE_CAR_3D taxicab6 -1065.6 -1224.2 10.5 6.0 6.0 5.0 FALSE
			CAR_GOTO_COORDINATES taxicab6 -1060.7 -1266.1 10.5  
		ENDIF
	ENDIF
	
	IF TIMERB > 2500

		SET_FIXED_CAMERA_POSITION -1107.913 -1266.256 12.023 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -1107.038 -1265.790 11.892 JUMP_CUT
	ENDIF
	 
ENDWHILE
 


SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

countdown_taxiwar = 61000
DISPLAY_ONSCREEN_TIMER countdown_taxiwar TIMER_DOWN

PRINT_NOW ( TAXW3_2 ) 8000 1  //KILL THE CABS

IF NOT IS_CAR_DEAD players_cab
	LOCK_CAR_DOORS players_cab CARLOCK_UNLOCKED
ENDIF

WAIT 1000

WHILE NOT countdown_taxiwar < 1
AND NOT counter_taxiwar = 6 
	WAIT 0
		
		IF IS_CAR_DEAD taxicab1 
		AND dead_taxicab1 = 0
			REMOVE_BLIP blip1_taxicab1
			dead_taxicab1 = 1
			++ counter_taxiwar	
		ENDIF
		

		IF NOT IS_CAR_DEAD taxicab1 
			//IF NOT IS_CAR_HEALTH_GREATER taxicab1 999
				IF cab1_obj_set = 0
					IF NOT IS_CHAR_DEAD taximan1
						IF IS_CHAR_IN_CAR taximan1 taxicab1
							SET_CAR_CRUISE_SPEED taxicab1 40.0
							SET_CAR_DRIVING_STYLE taxicab1 DRIVINGMODE_PLOUGHTHROUGH
							SET_CAR_MISSION taxicab1 MISSION_RAMPLAYER_FARAWAY
							cab1_obj_set = 1
						ENDIF
					ENDIF
				ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip1_taxicab1
		ENDIF
 
		
		IF IS_CAR_DEAD taxicab2
		AND dead_taxicab2 = 0 
			REMOVE_BLIP blip2_taxicab2
			dead_taxicab2 = 1
			++ counter_taxiwar
		ENDIF
	   	

		IF NOT IS_CAR_DEAD taxicab2
			//IF NOT IS_CAR_HEALTH_GREATER taxicab2 999
			IF cab2_obj_set = 0
				IF NOT IS_CHAR_DEAD taximan2
					IF IS_CHAR_IN_CAR taximan2 taxicab2
						SET_CAR_CRUISE_SPEED taxicab2 40.0
						SET_CAR_DRIVING_STYLE taxicab2 DRIVINGMODE_PLOUGHTHROUGH
						SET_CAR_MISSION taxicab2 MISSION_RAMPLAYER_FARAWAY
						cab2_obj_set = 1
					ENDIF
				ENDIF
			ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip2_taxicab2
		ENDIF

		
	   	IF IS_CAR_DEAD taxicab3
		AND dead_taxicab3 = 0 
			REMOVE_BLIP blip3_taxicab3
			dead_taxicab3 = 1
			++ counter_taxiwar
		ENDIF
		

		IF NOT IS_CAR_DEAD taxicab3
			//IF NOT IS_CAR_HEALTH_GREATER taxicab3 999
				IF cab3_obj_set = 0
					IF NOT IS_CHAR_DEAD taximan3
						IF IS_CHAR_IN_CAR taximan3 taxicab3
							SET_CAR_CRUISE_SPEED taxicab3 40.0
							SET_CAR_DRIVING_STYLE taxicab3 DRIVINGMODE_PLOUGHTHROUGH
							SET_CAR_MISSION taxicab3 MISSION_RAMPLAYER_FARAWAY
							cab3_obj_set = 1
						ENDIF
					ENDIF
				ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip3_taxicab3
		ENDIF

		
	   	IF IS_CAR_DEAD taxicab4
		AND dead_taxicab4 = 0 
			REMOVE_BLIP blip4_taxicab4
			dead_taxicab4 = 1
			++ counter_taxiwar
		ENDIF
		

		IF NOT IS_CAR_DEAD taxicab4
			//IF NOT IS_CAR_HEALTH_GREATER taxicab4 999
			IF cab4_obj_set = 0
				IF NOT IS_CHAR_DEAD taximan4
					IF IS_CHAR_IN_CAR taximan4 taxicab4
						SET_CAR_CRUISE_SPEED taxicab4 40.0
						SET_CAR_DRIVING_STYLE taxicab4 DRIVINGMODE_PLOUGHTHROUGH
						SET_CAR_MISSION taxicab4 MISSION_RAMPLAYER_FARAWAY
						cab4_obj_set = 1
					ENDIF
				ENDIF
			ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip4_taxicab4
		ENDIF

		
	   	IF IS_CAR_DEAD taxicab5
		AND dead_taxicab5 = 0 
			REMOVE_BLIP blip5_taxicab5
			dead_taxicab5 = 1
			++ counter_taxiwar
		ENDIF
		

		IF NOT IS_CAR_DEAD taxicab5
			//IF NOT IS_CAR_HEALTH_GREATER taxicab5 999
			IF cab5_obj_set = 0
				IF NOT IS_CHAR_DEAD taximan5
					IF IS_CHAR_IN_CAR taximan5 taxicab5
						SET_CAR_CRUISE_SPEED taxicab5 40.0
						SET_CAR_DRIVING_STYLE taxicab5 DRIVINGMODE_PLOUGHTHROUGH
						SET_CAR_MISSION taxicab5 MISSION_RAMPLAYER_FARAWAY
						cab5_obj_set = 1
					ENDIF
				ENDIF
			ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip5_taxicab5
		ENDIF
		
		
	   	IF IS_CAR_DEAD taxicab6
		AND dead_taxicab6 = 0 
			REMOVE_BLIP blip6_taxicab6
			dead_taxicab6 = 1
			++ counter_taxiwar
		ENDIF
		
		IF NOT IS_CAR_DEAD taxicab6
			//IF NOT IS_CAR_HEALTH_GREATER taxicab5 999
			IF cab6_obj_set = 0
				IF NOT IS_CHAR_DEAD taximan6
					IF IS_CHAR_IN_CAR taximan6 taxicab6
						SET_CAR_CRUISE_SPEED taxicab6 30.0
						SET_CAR_DRIVING_STYLE taxicab6 DRIVINGMODE_PLOUGHTHROUGH
						SET_CAR_MISSION taxicab6 MISSION_RAMPLAYER_FARAWAY
						cab6_obj_set = 1
					ENDIF
				ENDIF
			ENDIF
			//ENDIF
		ELSE
			REMOVE_BLIP blip6_taxicab6
		ENDIF	
	
		IF Close_cab_gate = 0
		
			ADD_ONE_OFF_SOUND -989.9 -1252.2 10.4 SOUND_POLICE_CELL_DOOR_CLUNK
			ADD_CONTINUOUS_SOUND -989.9 -1252.2 10.4 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop

			WHILE NOT SLIDE_OBJECT cabmagedon_gate -986.272 -1243.532 10.4 0.05 0.12 0.0 FALSE
				WAIT 0							   	 
			ENDWHILE

			REMOVE_SOUND gate_slide_loop
			ADD_ONE_OFF_SOUND -986.272 -1243.532 10.4 SOUND_POLICE_CELL_DOOR_CLUNK
			Close_cab_gate = 1

		ENDIF

ENDWHILE

	IF NOT IS_CAR_DEAD taxicab1 
		SET_CAR_CRUISE_SPEED taxicab1 0.0		
	ENDIF

	IF NOT IS_CAR_DEAD taxicab2 
		SET_CAR_CRUISE_SPEED taxicab2 0.0		
	ENDIF

	IF NOT IS_CAR_DEAD taxicab3 
		SET_CAR_CRUISE_SPEED taxicab3 0.0		
	ENDIF

	IF NOT IS_CAR_DEAD taxicab4 
		SET_CAR_CRUISE_SPEED taxicab4 0.0		
	ENDIF

	IF NOT IS_CAR_DEAD taxicab5 
		SET_CAR_CRUISE_SPEED taxicab5 0.0		
	ENDIF

	IF NOT IS_CAR_DEAD taxicab6 
		SET_CAR_CRUISE_SPEED taxicab6 0.0		
	ENDIF

REMOVE_BLIP blip1_taxicab1
REMOVE_BLIP blip2_taxicab2
REMOVE_BLIP blip3_taxicab3
REMOVE_BLIP blip4_taxicab4
REMOVE_BLIP blip5_taxicab5
REMOVE_BLIP blip6_taxicab6

MARK_CAR_AS_NO_LONGER_NEEDED taxicab1
MARK_CAR_AS_NO_LONGER_NEEDED taxicab2
MARK_CAR_AS_NO_LONGER_NEEDED taxicab3
MARK_CAR_AS_NO_LONGER_NEEDED taxicab4
MARK_CAR_AS_NO_LONGER_NEEDED taxicab5
MARK_CAR_AS_NO_LONGER_NEEDED taxicab6
MARK_CHAR_AS_NO_LONGER_NEEDED taximan1
MARK_CHAR_AS_NO_LONGER_NEEDED taximan2
MARK_CHAR_AS_NO_LONGER_NEEDED taximan3
MARK_CHAR_AS_NO_LONGER_NEEDED taximan4
MARK_CHAR_AS_NO_LONGER_NEEDED taximan5
MARK_CHAR_AS_NO_LONGER_NEEDED taximan6
MARK_MODEL_AS_NO_LONGER_NEEDED taxi

CLEAR_ONSCREEN_TIMER countdown_taxiwar

CREATE_CAR zebra -983.5 -1248.9 10.4 eviltaxi
CREATE_CHAR_INSIDE_CAR eviltaxi PEDTYPE_CIVMALE WMOCA kingcab_man

SET_CAR_HEALTH eviltaxi 2000
LOCK_CAR_DOORS eviltaxi CARLOCK_LOCKOUT_PLAYER_ONLY
SET_CHAR_HEALTH kingcab_man 300
SET_CAR_HEADING eviltaxi 66.0
SET_CAR_CRUISE_SPEED eviltaxi 0.0
SET_CAR_DRIVING_STYLE eviltaxi 0
SET_CHAR_PERSONALITY kingcab_man PEDSTAT_TOUGH_GUY
//SET_CAR_HEALTH eviltaxi 600
SET_CAR_STRAIGHT_LINE_DISTANCE eviltaxi 255

WAIT 500

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON


IF LOCATE_PLAYER_ANY_MEANS_3D player1 -998.5 -1243.2 10.5 10.0 10.0 4.0 FALSE
	SET_PLAYER_COORDINATES player1 -1028.3 -1237.6 10.5
ENDIF

SET_FIXED_CAMERA_POSITION -988.010 -1242.028 10.362 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -987.595 -1242.919 10.541 JUMP_CUT

CLEAR_AREA -983.5 -1248.9 10.4 30.0 TRUE

WAIT 1000

	ADD_ONE_OFF_SOUND -986.272 -1243.532 10.4 SOUND_POLICE_CELL_DOOR_CLUNK
	ADD_CONTINUOUS_SOUND -986.272 -1243.532 10.4 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop

	WHILE NOT SLIDE_OBJECT cabmagedon_gate -989.9 -1252.2 10.4 0.05 0.12 0.0 FALSE
		WAIT 0							   	 
	ENDWHILE

	REMOVE_SOUND gate_slide_loop
	ADD_ONE_OFF_SOUND -989.9 -1252.2 10.4 SOUND_POLICE_CELL_DOOR_CLUNK


IF HAS_MISSION_AUDIO_LOADED	2
	PLAY_MISSION_AUDIO 2
	PRINT_NOW ( TAX3_4 ) 4000 1
ENDIF

WAIT 3500

IF NOT IS_CAR_DEAD eviltaxi
	SET_CAR_CRUISE_SPEED eviltaxi 30.0
	CAR_GOTO_COORDINATES eviltaxi -1017.4 -1235.7 10.5
ENDIF

WAIT 1000

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

PRINT_NOW ( TAXW3_3 ) 8000 1  //KILL THE CAB

IF NOT IS_CHAR_DEAD kingcab_man 
	ADD_BLIP_FOR_CHAR kingcab_man blip_eviltaxi
ENDIF

Close_cab_gate = 0

WHILE NOT IS_CHAR_DEAD kingcab_man
	WAIT 0

		IF NOT IS_CAR_DEAD eviltaxi
			IF NOT IS_CHAR_DEAD kingcab_man
				IF IS_CHAR_IN_CAR kingcab_man eviltaxi
					IF king_cab_obj_set = 0
						SET_CAR_CRUISE_SPEED eviltaxi 40.0
						SET_CAR_DRIVING_STYLE eviltaxi DRIVINGMODE_PLOUGHTHROUGH
						SET_CAR_MISSION eviltaxi MISSION_RAMPLAYER_FARAWAY
						king_cab_obj_set = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_PLAYER_IN_ANY_CAR Player1
			IF TIMERA > 6000
				IF NOT IS_CAR_DEAD eviltaxi  
					SET_CAR_TEMP_ACTION eviltaxi TEMPACT_REVERSE 2000
					IF TIMERA > 8000
						TIMERA = 0
					ENDIF
				ENDIF
			ENDIF
		ELSE
			TIMERA = 0
		ENDIF

		IF Close_cab_gate = 0
		
			ADD_ONE_OFF_SOUND -989.9 -1252.2 10.4 SOUND_POLICE_CELL_DOOR_CLUNK
			ADD_CONTINUOUS_SOUND -989.9 -1252.2 10.4 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop

			WHILE NOT SLIDE_OBJECT cabmagedon_gate -986.272 -1243.532 10.4 0.05 0.12 0.0 FALSE
				WAIT 0							   	 
			ENDWHILE

			REMOVE_SOUND gate_slide_loop
			ADD_ONE_OFF_SOUND -986.272 -1243.532 10.4 SOUND_POLICE_CELL_DOOR_CLUNK
			Close_cab_gate = 1

		ENDIF

		IF NOT IS_CAR_DEAD eviltaxi
			IF kingcab_man_goes_radge = 0
				IF NOT IS_CAR_HEALTH_GREATER eviltaxi 250
					IF NOT IS_CHAR_DEAD kingcab_man
						SET_CHAR_OBJ_LEAVE_CAR kingcab_man eviltaxi
						SET_CHAR_PERSONALITY kingcab_man PEDSTAT_PSYCHO
						GIVE_WEAPON_TO_CHAR kingcab_man WEAPONTYPE_KATANA 0
						SET_CURRENT_CHAR_WEAPON kingcab_man WEAPONTYPE_KATANA
						LOCK_CAR_DOORS eviltaxi CARLOCK_UNLOCKED
	
						WHILE IS_CHAR_IN_CAR kingcab_man eviltaxi
							WAIT 0

							IF IS_CHAR_DEAD kingcab_man
								GOTO kingcab_man_dead
							ENDIF

							IF IS_CAR_DEAD eviltaxi
								GOTO kingcab_man_dead
							ENDIF

						ENDWHILE
						IF NOT IS_CHAR_DEAD kingcab_man
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT kingcab_man scplayer
						ENDIF
					ENDIF
					kingcab_man_goes_radge = 1		
				ENDIF
			ENDIF
		ENDIF


ENDWHILE

kingcab_man_dead:

WAIT 2000

CREATE_PROTECTION_PICKUP taxicashX taxicashY taxicashZ taxifirm_revenue taxifirm_revenue taxifirm_cash_pickup

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_SCENE -1017.904 207.165 15.090
SET_FIXED_CAMERA_POSITION -1018.540 207.931 15.185 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1017.904 207.165 15.090 JUMP_CUT
DO_FADE 500 FADE_IN
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PLAY_MISSION_PASSED_TUNE 1
PRINT_BIG TAX_AS1 5000 6 //CAR ASSET ACQUIRED

WAIT 5000
LOAD_SCENE -1002.412 192.715 13.452
SET_FIXED_CAMERA_POSITION -1003.200 193.281 13.694 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1002.412 192.715 13.452 JUMP_CUT
PRINT_WITH_NUMBER_NOW TAX_AS2 taxifirm_revenue 6000 1//CAR will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.

WAIT 6000
DO_FADE 500 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_SCENE -1119.7 -1381.3 11.5

DO_FADE 500 FADE_IN


SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT



GOTO mission_taxiwar3_passed 

 // Mission taxi3 failed

mission_taxiwar3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission taxi3 passed				   

mission_taxiwar3_passed:

flag_taxiwar_mission3_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 5000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 5000
REMOVE_BLIP taxiwar_contact_blip
REMOVE_BLIP taxibuy_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
SWITCH_CAR_GENERATOR gen_car1 0
SWITCH_CAR_GENERATOR gen_car110 101
taxifirm_asset_acquired = 1
flag_first_asset_complete = 1 // SCFIX: fix Ken's phonecall
++ counter_60_percent
REGISTER_MISSION_PASSED	TAXI_3
SET_PLAYER_HAS_MET_DEBBIE_HARRY TRUE
PLAYER_MADE_PROGRESS 1
RETURN
		


// mission cleanup

mission_cleanup_taxiwar3:

flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP blip1_taxicab1
REMOVE_BLIP blip2_taxicab2
REMOVE_BLIP blip3_taxicab3
REMOVE_BLIP blip4_taxicab4
REMOVE_BLIP blip5_taxicab5
REMOVE_BLIP blip6_taxicab6
REMOVE_BLIP blip_eviltaxi
MARK_MODEL_AS_NO_LONGER_NEEDED taxi
MARK_MODEL_AS_NO_LONGER_NEEDED WMOCA
MARK_MODEL_AS_NO_LONGER_NEEDED kaufman
MARK_MODEL_AS_NO_LONGER_NEEDED zebra
MARK_MODEL_AS_NO_LONGER_NEEDED katana
CLEAR_ONSCREEN_TIMER countdown_taxiwar
flag_taxi1_mission_launched = 0
DELETE_OBJECT cabmagedon_gate
IF NOT IS_CAR_DEAD eviltaxi
	LOCK_CAR_DOORS eviltaxi CARLOCK_UNLOCKED
ENDIF
CREATE_OBJECT_NO_OFFSET electricgate -989.9 -1252.2 10.4 cabmagedon_gate
SET_OBJECT_HEADING cabmagedon_gate 249.0
DONT_REMOVE_OBJECT cabmagedon_gate
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
MISSION_HAS_FINISHED
RETURN


}