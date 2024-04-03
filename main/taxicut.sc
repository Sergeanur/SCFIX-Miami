MISSION_START
// *****************************************************************************************
// *******************************   taxi_cut phone call cut scene    ************************* 
// *****************************************************************************************

// ****************************************Mission Start************************************

{
	
// FIXMIAMI: START - SSU fix

GOSUB mission_start_taxi_cut

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB taxicut_set1
ENDIF

GOSUB mission_cleanup_taxi_cut

MISSION_END

// FIXMIAMI: END

LVAR_INT cs_disp cs_cdrivra cs_cdrivrb kaufman_cab
LVAR_INT flag_taxicut_set1 // FIXMIAMI

mission_start_taxi_cut:

flag_player_on_mission = 1
//skip_flag = 0

flag_taxicut_set1 = 0 // FIXMIAMI

DELETE_OBJECT taxi_closed

SCRIPT_NAME TAXCUT

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before wait

WAIT 0

LOAD_MISSION_TEXT TAXICUT

GOTO taxicut_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT taxibuyX taxibuyY taxibuyZ RADAR_SPRITE_PROPERTY taxibuy_blip
taxicut_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_PLAYER_CONTROL player1 OFF
//SET_PLAYER_VISIBLE player1 FALSE
SWITCH_STREAMING OFF
//SET_INTRO_IS_PLAYING TRUE

//SET_DEATHARREST_STATE OFF

SWITCH_RUBBISH OFF


DISABLE_CUTSCENE_SHADOWS

//SET_AREA_VISIBLE VIS_taxi_cut
REQUEST_MODEL kaufman

WHILE NOT HAS_MODEL_LOADED kaufman
	WAIT 0

ENDWHILE

CLEAR_AREA -1001.7 198.8 11.4 4.0 TRUE

CREATE_CAR kaufman -1001.7 198.8 11.3 kaufman_cab
SET_CAR_HEADING kaufman_cab 180.0

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdoris
LOAD_SPECIAL_CHARACTER 3 cdrivra
LOAD_SPECIAL_CHARACTER 4 cdrivrb

LOAD_ALL_MODELS_NOW

//LOAD_SCENE -1001.1 202.1 11.4
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0

ENDWHILE

LOAD_CUTSCENE tax_1
SET_CUTSCENE_OFFSET -1002.4 202.0 10.4
SET_NEAR_CLIP 0.1

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_disp
SET_CUTSCENE_ANIM cs_disp CSdoris

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_cdrivra
SET_CUTSCENE_ANIM cs_cdrivra cdrivra 

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_cdrivrb
SET_CUTSCENE_ANIM cs_cdrivrb cdrivrb

CLEAR_AREA -999.1 193.0 10.4 1.0 TRUE
SET_PLAYER_COORDINATES player1 -999.1 193.0 10.4
SET_PLAYER_HEADING player1 80.0

WAIT 700

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time


WHILE cs_time < 10228
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_A ) 10000 1 // Mission brief

WHILE cs_time < 11538
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_B ) 10000 1 // Mission brief

WHILE cs_time < 15232
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_C ) 10000 1 // Mission brief

WHILE cs_time < 19887
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_D ) 10000 1 // Mission brief

WHILE cs_time < 22198
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_E ) 10000 1 // Mission brief

WHILE cs_time < 27570
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_F ) 10000 1 // Mission brief

WHILE cs_time < 30477
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_G ) 10000 1 // Mission brief

WHILE cs_time < 33933
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_H ) 10000 1 // Mission brief

WHILE cs_time < 36327
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_I ) 10000 1 // Mission brief

WHILE cs_time < 38262
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_J ) 10000 1 // Mission brief

WHILE cs_time < 43042
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_K ) 10000 1 // Mission brief

WHILE cs_time < 45254
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_L ) 10000 1 // Mission brief

WHILE cs_time < 46583
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_M ) 10000 1 // Mission brief

WHILE cs_time < 48993
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_N ) 10000 1 // Mission brief

WHILE cs_time < 51083
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_O ) 10000 1 // Mission brief

WHILE cs_time < 52858
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_P ) 10000 1 // Mission brief

WHILE cs_time < 55674
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_Q ) 10000 1 // Mission brief

WHILE cs_time < 57991
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_R ) 10000 1 // Mission brief

WHILE cs_time < 59837
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_S ) 10000 1 // Mission brief

WHILE cs_time < 62496
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_T ) 10000 1 // Mission brief

WHILE cs_time < 64179
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_U ) 10000 1 // Mission brief

WHILE cs_time < 65671
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_V ) 10000 1 // Mission brief

WHILE cs_time < 68752
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_W ) 10000 1 // Mission brief

WHILE cs_time < 70262
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_X ) 10000 1 // Mission brief

WHILE cs_time < 71555
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_Y ) 10000 1 // Mission brief

WHILE cs_time < 73865
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_Z ) 10000 1 // Mission brief

	WHILE cs_time < 76173
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TAXC_A1 ) 10000 1 // Mission brief

WHILE cs_time < 77173
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

WHILE cs_time < 81852
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
//SET_CAMERA_IN_FRONT_OF_PLAYER
//SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -999.1 193.0 10.4

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED kaufman

DELETE_CAR kaufman_cab // FIXMIAMI: delete cutscene car after the cutscene

flag_taxicut_mission1_passed = 1


WAIT 1000

SWITCH_WIDESCREEN ON

DO_FADE 1500 FADE_IN

SET_PLAYER_CONTROL player1 OFF
LOAD_SCENE -1017.904 207.165 15.090
SET_FIXED_CAMERA_POSITION -1018.540 207.931 15.185 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1017.904 207.165 15.090 JUMP_CUT
PLAY_MISSION_PASSED_TUNE 1

PRINT_WITH_NUMBER_BIG TAXIBUY taxibuy_price 7000 6 //
GOSUB taxicut_set1 // FIXMIAMI: moved stuff into a subroutine

WAIT 7000
// FIXMIAMI: START
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
RETURN

taxicut_set1:
IF flag_taxicut_set1 = 0
	ADD_MONEY_SPENT_ON_PROPERTY taxibuy_price
	SET_PROPERTY_AS_OWNED PROP_TAXICO
	flag_taxicut_set1 = 1
ENDIF
RETURN

// FIXMIAMI: END

mission_cleanup_taxi_cut: // FIXMIAMI
flag_player_on_mission = 0

GET_GAME_TIMER timer_mobile_start

REMOVE_BLIP taxibuy_blip
REMOVE_BLIP taxiwar_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip

START_NEW_SCRIPT taxiwar_save_loop
START_NEW_SCRIPT taxiwar_mission1_loop // FIXMIAMI: moved here from main.sc
PLAYER_MADE_PROGRESS 1
RESTORE_CAMERA_JUMPCUT

SET_ZONE_PED_INFO KAUFCAB DAY   (13) 0 0 0 0 0 0 1000 0 0 0
SET_ZONE_PED_INFO KAUFCAB NIGHT (10) 0 0 0 0 0 0 1000 0 0 0 
SWITCH_PED_ROADS_ON -1012.06 181.561 0.0 -982.06 216.561 30.0//TAXIFIRM

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up
RETURN // FIXMIAMI


}
RETURN