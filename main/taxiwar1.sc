MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Taxi mission 1****************************************
// ***************************************Taxi war1*****************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff			

GOSUB mission_start_taxiwar1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_taxiwar1_failed
ENDIF

GOSUB mission_cleanup_taxiwar1

MISSION_END

// Variables for mission
{
VAR_INT taxicab1 taxicab2 taxicab3 taxicab4 taxicab5 taxicab6 // Vehicle for mission
VAR_INT blip1_taxicab1 blip2_taxicab2 blip3_taxicab3 blip4_taxicab4 blip5_taxicab5 blip6_taxicab6 //Blips for vehicles
VAR_INT counter_taxiwar // Counts up number of evil taxis destroyed
VAR_INT taximan1 taximan2 taximan3 taximan4 taximan5 taximan6 countdown_taxiwar 
VAR_INT in_taxi1 in_taxi2 in_taxi3 in_taxi4 in_taxi5 in_taxi6   
VAR_INT dead_taxicab1 dead_taxicab2 dead_taxicab3 dead_taxicab4 dead_taxicab5 dead_taxicab6 
VAR_INT eviltaxi blip_eviltaxi  
VAR_INT cab1_obj_set cab2_obj_set cab3_obj_set cab4_obj_set cab5_obj_set cab6_obj_set

LVAR_INT theVIP	got_into_players_taxi dead_eviltaxi	played_taxiwar1_samp
LVAR_INT blip_eviltaxi_created // FIXMIAMI

// ***************************************Mission Start*************************************

mission_start_taxiwar1:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME taxwar1
WAIT 0

LOAD_MISSION_TEXT TAXIWA1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1020.8 191.1 10.5 350.0

counter_taxiwar = 0
dead_eviltaxi = 0
got_into_players_taxi = 0
played_taxiwar1_samp = 0
blip_eviltaxi_created = 0 // FIXMIAMI

//SET_PLAYER_CONTROL player1 OFF

LOAD_MISSION_AUDIO 1 TAX1_1
LOAD_MISSION_AUDIO 2 TAX1_2

WHILE NOT HAS_MISSION_AUDIO_LOADED	1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( TAX1_1 ) 4500 1 

WAIT 500

TIMERA = 0

WHILE NOT TIMERA > 4000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi1_cut
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( TAX1_2 ) 3000 1

TIMERA = 0

WHILE NOT TIMERA > 3000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_taxi1_cut
	ENDIF

ENDWHILE


skip_passed_taxi1_cut:


SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2

REQUEST_MODEL taxi
REQUEST_MODEL WMOCA
REQUEST_MODEL WMOBU
REQUEST_MODEL kaufman

	WHILE NOT HAS_MODEL_LOADED taxi
	OR NOT HAS_MODEL_LOADED WMOCA
	OR NOT HAS_MODEL_LOADED	WMOBU
	OR NOT HAS_MODEL_LOADED	kaufman
		WAIT 0

	ENDWHILE
	 
// START OF MISSION


ADD_BLIP_FOR_COORD -576.7 -480.1 10.8 blip1_taxicab1

PRINT_NOW ( TAXW1_1 ) 10000 1	//Pick up the VIP

countdown_taxiwar = 61000
DISPLAY_ONSCREEN_TIMER countdown_taxiwar TIMER_DOWN

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN player1 players_cab
ENDIF
 
IF IS_CAR_DEAD players_cab

ENDIF

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -576.7 -480.1 10.5 2.5 2.5 3.0 TRUE 
OR NOT IS_PLAYER_IN_MODEL player1 kaufman
OR NOT IS_PLAYER_PRESSING_HORN player1
	WAIT 0

		IF IS_CAR_DEAD players_cab

		ENDIF

		IF IS_PLAYER_IN_MODEL player1 kaufman 
			STORE_CAR_PLAYER_IS_IN player1 players_cab
		ELSE
			PRINT_NOW ( TAXW1_5 ) 1000 1 //You need to be in a Kaufman cab!
		ENDIF

		IF countdown_taxiwar = 0
			PRINT_NOW ( OUTTIME ) 5000 1
			GOTO mission_taxiwar1_failed
		ENDIF

		IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -576.7 -480.1 11.0 2.5 2.5 3.0 TRUE
		AND IS_PLAYER_IN_MODEL player1 kaufman
			PRINT_NOW ( HORN ) 1000 1
		ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD players_cab
	LOCK_CAR_DOORS players_cab CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

WAIT 500

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
CLEAR_ONSCREEN_TIMER countdown_taxiwar

CREATE_CHAR PEDTYPE_CIVMALE WMOBU -573.9 -448.1 14.1 theVIP
SET_CHAR_HEADING theVIP 270.0
CLEAR_CHAR_THREAT_SEARCH theVIP
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT theVIP -564.3 -447.9

SET_FIXED_CAMERA_POSITION -576.171 -461.122 11.516 0.0 0.0 0.0 //Watching VIP walk from mansion
POINT_CAMERA_AT_POINT -575.533 -460.370 11.682 JUMP_CUT

LOAD_MISSION_AUDIO 1 TAX1_3

WAIT 3000

SET_FIXED_CAMERA_POSITION -584.096 -471.163 12.693 0.0 0.0 0.0 //View of players car
POINT_CAMERA_AT_POINT -583.402 -471.861 12.514 JUMP_CUT


CREATE_CAR taxi -546.0 -474.3 10.0 eviltaxi
CLEAR_AREA_OF_CARS -600.8 -487.6 0.0 -463.6 -433.6 20.0
//CLEAR_AREA -546.0 -473.6 10.0 25.0 TRUE
//CHANGE_CAR_COLOUR eviltaxi CARCOLOUR_RED1 CARCOLOUR_ORANGE4  
CREATE_CHAR_INSIDE_CAR eviltaxi PEDTYPE_CIVMALE WMOCA taximan1


SET_CAR_HEADING eviltaxi 90.0  
SET_CAR_CRUISE_SPEED eviltaxi 30.0
SET_CAR_FORWARD_SPEED eviltaxi 10.0
SET_CAR_DRIVING_STYLE eviltaxi DRIVINGMODE_PLOUGHTHROUGH
SET_CAR_ONLY_DAMAGED_BY_PLAYER eviltaxi TRUE
SET_CHAR_PERSONALITY taximan1 PEDSTAT_TOUGH_GUY

//POINT_CAMERA_AT_CAR eviltaxi WHEELCAM JUMP_CUT 

	
REMOVE_BLIP blip1_taxicab1

//CLEAR_AREA -583.3 -479.0 10.8 25.0 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE eviltaxi 100
CAR_GOTO_COORDINATES eviltaxi -578.0 -474.3	10.8

TIMERB = 0


WHILE NOT LOCATE_CAR_2D eviltaxi -578.0 -474.3 6.0 4.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD eviltaxi
		GOTO mission_taxiwar1_failed
	ENDIF

	IF IS_CHAR_DEAD	taximan1
		PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
		GOTO mission_taxiwar1_failed  
	ENDIF

	IF IS_CHAR_DEAD	taximan1
		GOTO mission_taxiwar1_failed
	ENDIF

	IF TIMERB > 10000
		GOTO VIP_get_in_taxi
	ENDIF

ENDWHILE

VIP_get_in_taxi:

IF HAS_MISSION_AUDIO_LOADED	1
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( TAX1_3 ) 4000 1
ENDIF

IF NOT IS_CHAR_DEAD theVIP
	SET_CHAR_COORDINATES theVIP -576.2 -471.1 10.4
	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER theVIP eviltaxi
	ADD_BLIP_FOR_CHAR theVIP blip_eviltaxi
	blip_eviltaxi_created = 1 // FIXMIAMI
ENDIF

IF NOT IS_CAR_DEAD eviltaxi
	SET_CAR_CRUISE_SPEED eviltaxi 0.0	
ENDIF


WHILE NOT IS_CHAR_IN_CAR theVIP eviltaxi
	WAIT 0

	IF IS_CAR_DEAD eviltaxi
		PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
		GOTO mission_taxiwar1_failed
	ENDIF

	IF IS_CHAR_DEAD	taximan1
		PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
		GOTO mission_taxiwar1_failed  
	ENDIF

	IF IS_CHAR_DEAD	theVIP
		GOTO mission_taxiwar1_failed
	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD eviltaxi
	LOCK_CAR_DOORS eviltaxi CARLOCK_LOCKOUT_PLAYER_ONLY
ENDIF

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA

IF NOT IS_CAR_DEAD players_cab
	LOCK_CAR_DOORS players_cab CARLOCK_UNLOCKED
ENDIF

PRINT_NOW ( TAXW1_2 ) 5000 1 //Get the VIP back

CAR_GOTO_COORDINATES eviltaxi -683.0 -488.6 10.6
SET_CAR_CRUISE_SPEED eviltaxi 30.0
SET_CAR_DRIVING_STYLE eviltaxi DRIVINGMODE_AVOIDCARS
SET_CAR_ONLY_DAMAGED_BY_PLAYER eviltaxi FALSE

SET_CHAR_FRIGHTENED_IN_JACKED_CAR theVIP TRUE 

ADD_BLIP_FOR_COORD -1438.1 -833.6 11.3 blip1_taxicab1


LOAD_MISSION_AUDIO 1 TAX1_4


WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_3D theVIP -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE 
	WAIT 0

		IF IS_CHAR_DEAD theVIP
			PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
			GOTO mission_taxiwar1_failed
		ENDIF

		IF IS_CAR_DEAD players_cab
   
   		ENDIF

		IF IS_PLAYER_IN_ANY_CAR player1 
			STORE_CAR_PLAYER_IS_IN player1 players_cab
		ENDIF

		IF NOT IS_CAR_DEAD eviltaxi
			IF NOT IS_PLAYER_IN_CAR	player1 eviltaxi
				IF LOCATE_CAR_3D eviltaxi -683.0 -488.6 10.6 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -847.1 -516.6 10.6
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -847.1 -516.6 10.6 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -831.4 -639.5 10.6
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -831.4 -639.5 10.6 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -1131.7 -687.8 10.6
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -1131.7 -687.8 10.6 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -914.3 -1067.2 10.6
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -914.3 -1067.2 10.6 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -1197.3 -1070.9 11.3
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -1197.3 -1070.9 11.3 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -1407.5 -785.4 11.3
				ENDIF
				IF LOCATE_CAR_3D eviltaxi -1407.5 -785.4 11.3 5.0 5.0 5.0 FALSE
					CAR_GOTO_COORDINATES eviltaxi -1438.1 -833.6 11.3
				ENDIF							  
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD eviltaxi
			IF NOT IS_CAR_HEALTH_GREATER eviltaxi 500
			OR IS_CHAR_DEAD taximan1
			OR IS_CAR_ON_FIRE eviltaxi // FIXMIAMI: everyone gets out if car is on fire anyway
				IF got_into_players_taxi = 0 

					IF NOT IS_CAR_DEAD eviltaxi
						LOCK_CAR_DOORS eviltaxi CARLOCK_UNLOCKED
					ENDIF

					SET_CHAR_OBJ_LEAVE_CAR theVIP eviltaxi

					WHILE IS_CHAR_IN_CAR theVIP eviltaxi
						WAIT 0	
						
						IF IS_CAR_DEAD players_cab
   
   						ENDIF

						IF IS_PLAYER_IN_ANY_CAR player1 
							STORE_CAR_PLAYER_IS_IN player1 players_cab
						ENDIF
						 						  
						IF IS_CAR_DEAD eviltaxi
							
						ENDIF

						IF IS_CHAR_DEAD	theVIP
							PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
							GOTO mission_taxiwar1_failed
						ENDIF

						IF LOCATE_STOPPED_CHAR_ANY_MEANS_3D theVIP -1438.1 -833.6 11.3 4.0 4.0 5.0 TRUE
							GOTO the_end_of_taxiwar1
						ENDIF

					ENDWHILE
					
					IF NOT IS_CHAR_DEAD	theVIP
						SET_CHAR_FRIGHTENED_IN_JACKED_CAR theVIP FALSE
					ENDIF

					IF HAS_MISSION_AUDIO_LOADED	1
						PLAY_MISSION_AUDIO 1
						PRINT_NOW ( TAX1_4 ) 4000 1
					ENDIF

					TIMERB = 0

					IF NOT IS_CHAR_DEAD	theVIP
						LOAD_MISSION_AUDIO 2 TAX1_5
						SET_CHAR_OBJ_NO_OBJ theVIP
						SET_CHAR_RUNNING theVIP TRUE
						SET_CHAR_AS_LEADER theVIP scplayer
					ENDIF 

					got_into_players_taxi = 1

				ENDIF
			ENDIF
		ENDIF

		IF got_into_players_taxi = 1
			
			IF TIMERA > 500
				IF NOT IS_CAR_DEAD eviltaxi
				AND NOT IS_CHAR_DEAD taximan1
					SET_CAR_CRUISE_SPEED eviltaxi 50.0
					SET_CAR_DRIVING_STYLE eviltaxi DRIVINGMODE_PLOUGHTHROUGH
					SET_CAR_MISSION eviltaxi MISSION_RAMPLAYER_FARAWAY
					TIMERA = 0	
				ENDIF
			ENDIF

			IF NOT IS_CAR_DEAD players_cab
				IF IS_CHAR_IN_CAR theVIP players_cab
					IF blip_eviltaxi_created = 1 // FIXMIAMI
						REMOVE_BLIP blip_eviltaxi
						blip_eviltaxi_created = 0 // FIXMIAMI
					ENDIF // FIXMIAMI
				ELSE
					//REMOVE_BLIP blip_eviltaxi // FIXMIAMI: don't recreate the blip every frame
					IF blip_eviltaxi_created = 0 // FIXMIAMI
						ADD_BLIP_FOR_CHAR theVIP blip_eviltaxi
						blip_eviltaxi_created = 1 // FIXMIAMI
					ENDIF // FIXMIAMI
				ENDIF
			ENDIF

			IF played_taxiwar1_samp = 0
				IF NOT IS_CHAR_DEAD theVIP
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player1 theVIP 15.0 15.0 6.0 FALSE
						IF TIMERB > 2000
							IF HAS_MISSION_AUDIO_LOADED	2
								PLAY_MISSION_AUDIO 2
								PRINT_NOW ( TAX1_5 ) 4000 1
								WAIT 4000
								PRINT_NOW ( TAXW1_6 ) 8000 1 //Take to the airport.
								played_taxiwar1_samp = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF IS_CHAR_DEAD theVIP
				PRINT_NOW ( TAXW1_3 ) 5000 1  //The V.I.P. is dead!
				GOTO mission_taxiwar1_failed
			ENDIF

		ENDIF

ENDWHILE

the_end_of_taxiwar1:


IF NOT IS_CAR_DEAD eviltaxi
	IF NOT IS_CHAR_DEAD	theVIP
		IF IS_CHAR_IN_CAR theVIP eviltaxi
		AND got_into_players_taxi = 0 // FIXMIAMI 
		AND LOCATE_CAR_3D eviltaxi -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
			PRINT_NOW ( TAXW1_4 ) 5000 1  //The V.I.P. has been dropped off!
			GOTO mission_taxiwar1_failed
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD players_cab
	IF NOT IS_CHAR_DEAD	theVIP
		IF LOCATE_STOPPED_CHAR_ANY_MEANS_3D theVIP -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
		AND NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
			PRINT_NOW ( TAXW1_4 ) 5000 1  //The V.I.P. has been dropped off!
			GOTO mission_taxiwar1_failed
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD players_cab
	IF NOT IS_CHAR_DEAD	theVIP
		IF IS_CHAR_IN_CAR theVIP players_cab
		AND LOCATE_STOPPED_CAR_3D players_cab -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			SET_FIXED_CAMERA_POSITION -1462.635 -791.768 15.662 0.0 0.0 0.0 //Look at airport
			POINT_CAMERA_AT_POINT -1462.162 -792.641 15.783 JUMP_CUT

			WAIT 2000

			SET_FIXED_CAMERA_POSITION -1468.559 -834.603 16.360 0.0 0.0 0.0 //Watching VIP walk 
			POINT_CAMERA_AT_POINT -1467.827 -833.977 16.091 JUMP_CUT
			IF NOT IS_CHAR_DEAD	theVIP
				LEAVE_GROUP theVIP
				SET_CHAR_RUNNING theVIP FALSE
				WARP_CHAR_FROM_CAR_TO_COORD theVIP -1459.6 -825.3 13.9
				SET_CHAR_HEADING theVIP 146.0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT theVIP -1465.7 -832.2
			ENDIF
			WAIT 3500
			RESTORE_CAMERA_JUMPCUT
			GOTO mission_taxiwar1_passed
		ENDIF
	ENDIF
ENDIF
 
IF NOT IS_CHAR_DEAD	theVIP
	IF LOCATE_CHAR_ON_FOOT_3D theVIP -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
	AND LOCATE_PLAYER_ON_FOOT_3D player1 -1438.1 -833.6 11.3 5.0 5.0 5.0 TRUE
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON
		SET_FIXED_CAMERA_POSITION -1462.635 -791.768 15.662 0.0 0.0 0.0 //Look at airport
		POINT_CAMERA_AT_POINT -1462.162 -792.641 15.783 JUMP_CUT

		WAIT 2000

		SET_FIXED_CAMERA_POSITION -1468.559 -834.603 16.360 0.0 0.0 0.0 //Watching VIP walk 
		POINT_CAMERA_AT_POINT -1467.827 -833.977 16.091 JUMP_CUT
		IF NOT IS_CHAR_DEAD	theVIP
			LEAVE_GROUP theVIP
			SET_CHAR_RUNNING theVIP FALSE
			SET_CHAR_COORDINATES theVIP -1459.6 -825.3 13.9
			SET_CHAR_HEADING theVIP 146.0
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT theVIP -1465.7 -832.2
		ENDIF
		WAIT 3500
		RESTORE_CAMERA_JUMPCUT
		GOTO mission_taxiwar1_passed
	ENDIF
ENDIF


 // Mission taxi1 failed

mission_taxiwar1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission taxi1 passed

mission_taxiwar1_passed:
flag_taxiwar_mission1_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000
REGISTER_MISSION_PASSED	TAXI_1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT taxiwar_mission2_loop 
RETURN
		


// mission cleanup

mission_cleanup_taxiwar1:
flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP blip_eviltaxi
REMOVE_BLIP blip1_taxicab1
//REMOVE_BLIP blip3_taxicab3
MARK_MODEL_AS_NO_LONGER_NEEDED taxi
MARK_MODEL_AS_NO_LONGER_NEEDED WMOCA
MARK_MODEL_AS_NO_LONGER_NEEDED WMOBU
MARK_MODEL_AS_NO_LONGER_NEEDED kaufman
CLEAR_ONSCREEN_TIMER countdown_taxiwar
flag_taxi1_mission_launched = 0
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
MISSION_HAS_FINISHED
RETURN


}