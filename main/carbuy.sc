MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ****************************** Car Showroom Buy Script **********************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

// FIXMIAMI: START - SSU fix
GOSUB mission_start_carbuy

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB carbuy_set_as_owned
ENDIF

GOSUB mission_cleanup_carbuy

MISSION_END
// FIXMIAMI: END


// Variables for mission
{ // FIXMIAMI: add scope
//CARS PEDS OBJECTS PICKUPS
LVAR_INT csbj csplay // FIXMIAMI: make LVAR
//FLAGS COUNTERS TIMERS
LVAR_INT flag_carbuy_set_as_owned // FIXMIAMI
//BLIPS
//COORDS MATHS
//VAR_FLOAT

// ******************************* Mission Start *******************************************

mission_start_carbuy:

flag_player_on_mission = 1

flag_carbuy_set_as_owned = 0 // FIXMIAMI

SCRIPT_NAME carbuy1

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

LOAD_MISSION_TEXT CARBUY

//////////////////////////
//////////////////////////
LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 csbj
LOAD_SPECIAL_MODEL CUTOBJ01 hlrycar
REQUEST_MODEL SENTINEL

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED SENTINEL
	WAIT 0
ENDWHILE

LVAR_INT showroom_car1 // FIXMIAMI: make LVAR
CREATE_CAR SENTINEL -1033.2114 -856.8564 12.0452 showroom_car1
SET_CAR_HEADING showroom_car1 210.2780
MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL

LOAD_CUTSCENE CAR_1
SET_CUTSCENE_OFFSET -1018.647 -877.935 12.045
				
CREATE_CUTSCENE_OBJECT SPECIAL01 csplay
SET_CUTSCENE_ANIM csplay csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 csbj
SET_CUTSCENE_ANIM csbj csbj

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_htable
SET_CUTSCENE_ANIM cs_htable hlrycar

CLEAR_AREA -1007.3034 -869.9353 11.8668 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1007.3034 -869.9353 11.8668
SET_PLAYER_HEADING player1 30.0

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 976
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_1 10000 1//B.J. Smith. And you must be Mr. Vercetti. 
 
WHILE cs_time < 4506
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_2 10000 1//Would you like the tour?
 
WHILE cs_time < 6299
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_3 10000 1//Might as well.
 
WHILE cs_time < 7695
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_4 10000 1//Well, I'm very sad to be selling the car to y'all. 
 
WHILE cs_time < 10390
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_5 10000 1//This was my first investment after I turned pro. 
 
WHILE cs_time < 13170
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_6 10000 1//But now it's time for me to move on.
 
WHILE cs_time < 14855
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_7 10000 1//You're leaving town? 
 
WHILE cs_time < 16114
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_8 10000 1//Not in too much of a hurry, I hope?
 
WHILE cs_time < 18118
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_9 10000 1//No. I'm just coming out of retirement, and preparing my future comeback. 
 
WHILE cs_time < 22505
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_10 10000 1//The business wasn't too strong, 
 
WHILE cs_time < 23989
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_11 10000 1//and my staff took it upon themselves to get a little bit more
 
WHILE cs_time < 26958
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_12 10000 1//creative with the generation of wealth.
 
WHILE cs_time < 35538
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_13 10000 1//Obviously, I could wind down the business before I hand it over. 
 
WHILE cs_time < 39241
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_14 10000 1//Hell, I could burn the place down if you wanted to.
 
WHILE cs_time < 43374
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_15 10000 1//This is prime development land.
 
WHILE cs_time < 45142
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_16 10000 1//Oh, I wouldn't worry about any of that. 
 
WHILE cs_time < 48422
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_17 10000 1//This place seems prefect.
 
WHILE cs_time < 50000//51525
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAR1_18 10000 1//Yeh it does, So I take it we have a deal?
 
WHILE cs_time < 53504//51959
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
CLEAR_PRINTS
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: moved up before WAIT

//////////////////////////
//////////////////////////
WAIT 0
WAIT 0

SWITCH_WIDESCREEN ON
SET_ALL_CARS_CAN_BE_DAMAGED	FALSE

SET_FIXED_CAMERA_POSITION -1017.0237 -922.2878 19.0987 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1017.0441 -921.3013 18.9361 JUMP_CUT
SET_GENERATE_CARS_AROUND_CAMERA TRUE
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG CARBUY carbuy_price 7000 6 //
GOSUB carbuy_set_as_owned // FIXMIAMI: moved stuff into a subroutine

WAIT 5000

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF // FIXMIAMI
SET_PLAYER_CONTROL player1 ON // FIXMIAMI

RETURN // FIXMIAMI

mission_cleanup_carbuy: // FIXMIAMI

LVAR_INT races_blip // FIXMIAMI: make LVAR
ADD_BLIP_FOR_CONTACT_POINT -967.7050 -827.3005 5.7702 races_blip
CHANGE_BLIP_DISPLAY races_blip MARKER_ONLY

//flag_carbuy_passed = 1
PLAYER_MADE_PROGRESS 1
//CLEAR_WANTED_LEVEL player1
//PRINT_WITH_NUMBER_BIG M_PASS 1000 5000 1 //"Mission Passed!"
//ADD_SCORE player1 1000
GET_GAME_TIMER timer_mobile_start

REMOVE_BLIP carbuy_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_SUNYARD carbuy_blip
CHANGE_BLIP_DISPLAY carbuy_blip BLIP_ONLY
CREATE_OBJECT_NO_OFFSET lh_imp_exp01 -981.754 -841.278 8.586 import_export_sign1
DONT_REMOVE_OBJECT import_export_sign1
SET_ZONE_PED_INFO CARYRD DAY   (13) 0 0 0 0 0 0 1000 0 0 0 
SET_ZONE_PED_INFO CARYRD NIGHT (5 ) 0 0 0 0 0 0 1000 0 0 0
SWITCH_PED_ROADS_ON -1031.494 -902.312 0.0 -949.479 -821.592 30.0//CAR YARD
START_NEW_SCRIPT races_loop
START_NEW_SCRIPT carshow_save_loop
START_NEW_SCRIPT import1_loop
CHANGE_GARAGE_TYPE collect_all_cars1 GARAGE_COLLECTCARS_1
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN
SET_GENERATE_CARS_AROUND_CAMERA FALSE
RESTORE_CAMERA_JUMPCUT
flag_player_on_mission = 0
MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up
RETURN

// FIXMIAMI: START - stuff moved from above
carbuy_set_as_owned:
IF flag_carbuy_set_as_owned = 0
	ADD_MONEY_SPENT_ON_PROPERTY carbuy_price
	SET_PROPERTY_AS_OWNED PROP_CARSHOWROOM
	CHANGE_GARAGE_TYPE carbuy_save_garage1 GARAGE_HIDEOUT_SEVEN 
	CHANGE_GARAGE_TYPE carbuy_save_garage2 GARAGE_HIDEOUT_EIGHT 
	CHANGE_GARAGE_TYPE carbuy_save_garage3 GARAGE_HIDEOUT_NINE 
	CHANGE_GARAGE_TYPE carbuy_save_garage4 GARAGE_HIDEOUT_TEN 
	flag_carbuy_set_as_owned = 1
ENDIF
RETURN
// FIXMIAMI: END

} // FIXMIAMI: add scope
