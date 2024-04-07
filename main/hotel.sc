MISSION_START
// *****************************************************************************************
// *******************************   Hotel phone call cut scene    ************************* 
// *****************************************************************************************

// SCFIX: START - SSU fix
GOSUB mission_start_hotel

GOSUB mission_cleanup_hotel

MISSION_END
// SCFIX: END


// ****************************************Mission Start************************************

mission_start_hotel:

flag_player_on_mission = 1

SCRIPT_NAME hotel

SET_PLAYER_CONTROL player1 OFF // SCFIX: paranoid set before wait

WAIT 0

LOAD_MISSION_TEXT HOTEL

{

flag_player_in_hotel = 0 // SCFIX: so that extra colours would switch
SET_EXTRA_COLOURS 16 FALSE
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_PLAYER_CONTROL player1 OFF
SET_PLAYER_VISIBLE player1 FALSE
SWITCH_STREAMING OFF

SWITCH_RUBBISH OFF

SET_AREA_VISIBLE VIS_HOTEL
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_mobroom2 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_detailsb TRUE


LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSsonny
LOAD_SPECIAL_MODEL CUTOBJ01 plyphon
LOAD_SPECIAL_MODEL CUTOBJ02 colphon 
LOAD_SPECIAL_MODEL CUTOBJ03 mbtbful
LOAD_SPECIAL_MODEL CUTOBJ04 schair

LOAD_ALL_MODELS_NOW

LOAD_SCENE 231.4 -1277.7 19.0
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04
	WAIT 0

ENDWHILE

LOAD_CUTSCENE int_b
SET_CUTSCENE_OFFSET 231.411 -1277.707 19.069
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_sonny
SET_CUTSCENE_ANIM cs_sonny CSsonny

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_phnplay
SET_CUTSCENE_ANIM cs_phnplay plyphon 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_phoncol
SET_CUTSCENE_ANIM cs_phoncol colphon

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_mobtable
SET_CUTSCENE_ANIM cs_mobtable mbtbful

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_schair
SET_CUTSCENE_ANIM cs_schair schair

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6133
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_B  ) 10000 1 // Mission brief

WHILE cs_time < 7184
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_A ) 10000 1 // Mission brief

WHILE cs_time < 13174
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_C ) 10000 1 // Mission brief

WHILE cs_time < 15932
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_D ) 10000 1 // Mission brief

WHILE cs_time < 19096
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_E ) 10000 1 // Mission brief

WHILE cs_time < 20800
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_F ) 10000 1 // Mission brief

WHILE cs_time < 23076
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_G ) 10000 1 // Mission brief

WHILE cs_time < 25352
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_H ) 10000 1 // Mission brief

WHILE cs_time < 29045
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_I ) 10000 1 // Mission brief

WHILE cs_time < 32884 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_J ) 10000 1 // Mission brief

WHILE cs_time < 36816
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_K ) 10000 1 // Mission brief

WHILE cs_time < 39960
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_L ) 10000 1 // Mission brief

WHILE cs_time < 46333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_M ) 10000 1 // Mission brief

WHILE cs_time < 49904
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_N ) 10000 1 // Mission brief

WHILE cs_time < 51480
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_O ) 10000 1 // Mission brief

WHILE cs_time < 54960
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_P ) 10000 1 // Mission brief

WHILE cs_time < 56800
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_Q ) 10000 1 // Mission brief

WHILE cs_time < 61668
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_R ) 10000 1 // Mission brief

WHILE cs_time < 64584
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_S ) 10000 1 // Mission brief

WHILE cs_time < 69612
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_T ) 10000 1 // Mission brief

WHILE cs_time < 72104
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( INTB_U ) 10000 1 // Mission brief

WHILE cs_time < 75104
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 77104
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
LOAD_SCENE 237.8 -1279.9 10.0
PLAYER_MADE_PROGRESS 1

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_mobroom2 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_detailsb FALSE

REMOVE_BLIP goto_hotel_contact_blip
REMOVE_BLIP	lawyer_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT lawyerX lawyerY lawyerZ the_lawyer_blip lawyer_contact_blip

TERMINATE_ALL_SCRIPTS_WITH_THIS_NAME LAW1
START_NEW_SCRIPT lawyer_mission1_loop
SET_TIME_OF_DAY 08 00
FORCE_WEATHER_NOW WEATHER_SUNNY
SET_PLAYER_CONTROL player1 OFF

WAIT 1000

DO_FADE 1500 FADE_IN

SET_PLAYER_COORDINATES player1 223.1 -1276.7 11.0
SET_PLAYER_HEADING player1 258.0 
SET_CHAR_OBJ_NO_OBJ scplayer

//CLEAR_EXTRA_COLOURS FALSE // SCFIX: we are still in the hotel, so need extra colours

// SCFIX: START
flag_player_in_hotel = 1
SET_EXTRA_COLOURS 3 FALSE

SET_PLAYER_CONTROL player1 ON

RETURN
// SCFIX: END

// SCFIX: START - moved from above
mission_cleanup_hotel:
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

flag_player_on_mission = 0
flag_hotel_mission1_passed = 1
view_of_ocean_view = 1 // SCFIX: don't ever show how to enter Ocean View

RELEASE_WEATHER
MISSION_HAS_FINISHED
//MISSION_END // SCFIX: moved up
// SCFIX: END
}
RETURN