MISSION_START
// *****************************************************************************************
// ************************************   The Intro    ************************************* 
// *****************************************************************************************

SCRIPT_NAME intro

// FIXMIAMI: START
GOSUB mission_start_intro

IF HAS_DEATHARREST_BEEN_EXECUTED
	PRINT_BIG ( RATNG54 ) 5000 1 //"Embarrassment"
ENDIF

GOSUB mission_cleanup_intro

MISSION_END
// FIXMIAMI: END
 
// ****************************************Mission Start************************************

mission_start_intro:

flag_player_on_mission = 1
skip_flag = 0

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before WAIT

WAIT 0

{

DO_FADE 0 FADE_OUT

SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_PLAYER_CONTROL player1 OFF				  
SWITCH_STREAMING OFF

SWITCH_RUBBISH OFF

LOAD_MISSION_TEXT INTRO

// ************************************START**********************************

MAKE_PLAYER_SAFE_FOR_CUTSCENE player1

LOAD_SPLASH_SCREEN intro1

SET_FADING_COLOUR 2 2 2

WAIT 250

LOAD_SPECIAL_CHARACTER 1 sfrenda
LOAD_SPECIAL_CHARACTER 2 sfrendb
LOAD_SPECIAL_CHARACTER 3 CSsonny
LOAD_SPECIAL_CHARACTER 4 sgoona
LOAD_SPECIAL_CHARACTER 5 sgoonb
 
LOAD_SPECIAL_MODEL CUTOBJ01 svntray
LOAD_SPECIAL_MODEL CUTOBJ02 drink
LOAD_SPECIAL_MODEL CUTOBJ03 mbtbemp
LOAD_SPECIAL_MODEL CUTOBJ04 schair

SWITCH_STREAMING OFF

SWITCH_RUBBISH OFF

SET_AREA_VISIBLE VIS_HOTEL 

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_mobroom2 TRUE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_detailsb TRUE

LOAD_SCENE 231.4 -1277.7 19.0

SET_EXTRA_COLOURS 16 FALSE
 
LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED	2
OR NOT HAS_SPECIAL_CHARACTER_LOADED	3
OR NOT HAS_SPECIAL_CHARACTER_LOADED	4
OR NOT HAS_SPECIAL_CHARACTER_LOADED	5

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
	  	GOTO skip_intro_here
	ENDIF

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF

ENDWHILE

LOAD_CUTSCENE int_a

SET_CUTSCENE_OFFSET 231.411 -1277.707 19.069
SET_NEAR_CLIP 0.1
					
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_sfrenda
SET_CUTSCENE_ANIM cs_sfrenda sfrenda

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_sfrendb
SET_CUTSCENE_ANIM cs_sfrendb sfrendb

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_sonny
SET_CUTSCENE_ANIM cs_sonny CSsonny

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona sgoona

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_sgoonb
SET_CUTSCENE_ANIM cs_sgoonb sgoonb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_svntray
SET_CUTSCENE_ANIM cs_svntray svntray

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drinka
SET_CUTSCENE_ANIM cs_drinka drink01

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drinkb
SET_CUTSCENE_ANIM cs_drinkb drink02

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drinkc
SET_CUTSCENE_ANIM cs_drinkc drink03

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_mobtable
SET_CUTSCENE_ANIM cs_mobtable mbtbemp

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_schair
SET_CUTSCENE_ANIM cs_schair schair

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1246
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT1_A ) 10000 1 //"Tommy Vercetti

WHILE cs_time < 2708
 
	WAIT 0

	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
		
ENDWHILE

PRINT_NOW ( INT1_B ) 10000 1 // Mission brief

WHILE cs_time < 4796 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT1_C ) 10000 1 // Mission brief

WHILE cs_time < 7086 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT1_D ) 10000 1 // Mission brief

WHILE cs_time < 8404 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT1_E ) 10000 1 //"Mission Brief"

WHILE cs_time < 10756 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT1_F ) 10000 1 // Mission brief

WHILE cs_time < 12614 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT1_G ) 10000 1 // Mission brief

WHILE cs_time < 14813 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT1_H ) 10000 1 // Mission brief

WHILE cs_time < 18741
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_I ) 10000 1 // Mission brief

WHILE cs_time < 21294 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_J ) 10000 1 // Mission brief

WHILE cs_time < 24399 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_K ) 10000 1 // Mission brief

WHILE cs_time < 26496 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	   	GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_L ) 10000 1 // Mission brief

WHILE cs_time < 31264 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_M ) 10000 1 // Mission brief

WHILE cs_time < 32904 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  	GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_N ) 10000 1 // Mission brief

WHILE cs_time < 35200 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  	GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_O ) 10000 1 // Mission brief

WHILE cs_time < 36522 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  	GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_P ) 10000 1 // Mission brief

WHILE cs_time < 41196 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_Q ) 10000 1 // Mission brief

WHILE cs_time < 45232 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_R ) 10000 1 // Mission brief

WHILE cs_time < 48992 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_S ) 10000 1 // Mission brief

WHILE cs_time < 50206 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_T ) 10000 1 // Mission brief

WHILE cs_time < 52509 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_U ) 10000 1 // Mission brief

WHILE cs_time < 54340 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_V ) 10000 1 // Mission brief

WHILE cs_time < 56291 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_W ) 10000 1 // Mission brief

WHILE cs_time < 57900 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_X ) 10000 1 // Mission brief

WHILE cs_time < 61168 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	
	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_Y ) 10000 1 // Mission brief

WHILE cs_time < 62518 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_Z ) 10000 1 // Mission brief

WHILE cs_time < 64169  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW (INT1_A1 ) 10000 1 // Mission brief

WHILE cs_time < 65706 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT1_A2 ) 10000 1 // Mission brief

WHILE cs_time < 66784 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	 GOTO skip_intro_here
	ENDIF
	
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 68240
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

CLEAR_PRINTS

SET_FADING_COLOUR 1 1 1

DO_FADE 2000 FADE_OUT 

WHILE GET_FADING_STATUS
	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
	  GOTO skip_intro_here
	ENDIF
	
ENDWHILE

CLEAR_CUTSCENE
CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_mobroom2 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_detailsb FALSE

SET_AREA_VISIBLE VIS_MAIN_MAP

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before WAIT

WAIT 0

// ************************************************THE AIRPORT******************************

DISABLE_CUTSCENE_SHADOWS

LOAD_SPLASH_SCREEN intro2

SET_FADING_COLOUR 2 2 2

WAIT 250

FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
SET_TIME_OF_DAY 12 00

LOAD_SPECIAL_CHARACTER 1 CSken
LOAD_SPECIAL_CHARACTER 2 CSplay
LOAD_SPECIAL_CHARACTER 3 sgoona
LOAD_SPECIAL_CHARACTER 4 sgoonb
LOAD_SPECIAL_MODEL CUTOBJ01 airplan
LOAD_SPECIAL_MODEL CUTOBJ02 merced
LOAD_SPECIAL_MODEL CUTOBJ03 brfcase

REQUEST_MODEL ap_radar1_01
REQUEST_MODEL veg_palm04

LOAD_SCENE -1592.0 -545.0 15.0
REQUEST_COLLISION -1654.0 -1388.0
 
LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED	2
OR NOT HAS_SPECIAL_CHARACTER_LOADED	3
OR NOT HAS_SPECIAL_CHARACTER_LOADED	4
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
 	
	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
	   GOTO skip_intro_here
	ENDIF

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED ap_radar1_01
OR NOT HAS_MODEL_LOADED veg_palm04

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

SET_PLAYER_COORDINATES player1 -1654.0 -1388.0 -100.0

LOAD_UNCOMPRESSED_ANIM airplan  

LOAD_CUTSCENE int_m

SET_CUTSCENE_OFFSET -1601.536 -548.298 13.679 // 13.673
//SET_NEAR_CLIP 0.1

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_ken
SET_CUTSCENE_ANIM cs_ken csken
					
CREATE_CUTSCENE_OBJECT SPECIAL02 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona sgoona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sgoonb
SET_CUTSCENE_ANIM cs_sgoonb sgoonb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_plane
SET_CUTSCENE_ANIM cs_plane airplan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_introcar
SET_CUTSCENE_ANIM cs_introcar merced
SET_OBJECT_DRAW_LAST cs_introcar TRUE

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_case1
SET_CUTSCENE_ANIM cs_case1 brfcase

ATTACH_CUTSCENE_OBJECT_TO_COMPONENT cs_ken cs_introcar mercbod
ATTACH_CUTSCENE_OBJECT_TO_COMPONENT cs_player cs_introcar mercbod
ATTACH_CUTSCENE_OBJECT_TO_COMPONENT cs_sgoona cs_introcar mercbod
ATTACH_CUTSCENE_OBJECT_TO_COMPONENT cs_sgoonb cs_introcar mercbod

//ATTACH_CUTSCENE_OBJECT_TO_COMPONENT ObjectID ParentObjectID Mercbod

DO_FADE 3000 FADE_IN

SWITCH_STREAMING ON

START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4860 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT2_A ) 10000 1 //"Tommy Vercetti

WHILE cs_time < 6400
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

SET_NEAR_CLIP 0.15 // 0.1 Aaron test

WHILE cs_time < 9600
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT2_B ) 10000 1 // Mission brief

WHILE cs_time < 12342  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT2_C ) 10000 1 // Mission brief

WHILE cs_time < 15840  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT2_D ) 10000 1 // Mission brief

WHILE cs_time < 17556  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT2_E ) 10000 1 //"Mission Brief"

WHILE cs_time < 20640  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT2_F ) 10000 1 // Mission brief

WHILE cs_time < 23018  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW ( INT2_G ) 10000 1 // Mission brief

WHILE cs_time < 25863  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

PRINT_NOW ( INT2_H ) 10000 1 // Mission brief

WHILE cs_time < 26000 

	WAIT 0

	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

WHILE cs_time < 27624 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT2_I ) 10000 1 // Mission brief

WHILE cs_time < 29348  
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

PRINT_NOW (INT2_J ) 10000 1 // Mission brief

WHILE cs_time < 30300  //31975  
  	WAIT 0
  	GET_CUTSCENE_TIME cs_time

  	GOSUB skip_intro_button

  	IF skip_flag = 2
  		GOTO skip_intro_here
  ENDIF

ENDWHILE

CLEAR_PRINTS

//PRINT_NOW (INT2_K ) 10000 1 // Mission brief

/*
WHILE cs_time <  //32004 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

*/

SET_FADING_COLOUR 1 1 1

DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS
  	WAIT 0

	GET_CUTSCENE_TIME cs_time

	IF cs_time >= 33300
		CLEAR_PRINTS
	ENDIF
  
  	GOSUB skip_intro_button

  	IF skip_flag = 2
  		GOTO skip_intro_here
  	ENDIF
	
ENDWHILE

CLEAR_PRINTS

CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03

MARK_MODEL_AS_NO_LONGER_NEEDED ap_radar1_01
MARK_MODEL_AS_NO_LONGER_NEEDED veg_palm04

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before WAIT

WAIT 0								 

// **********************************************THE DEAL***********************************

LOAD_SPLASH_SCREEN intro3

SET_FADING_COLOUR 2 2 2

WAIT 250

FORCE_WEATHER_NOW WEATHER_SUNNY
SET_TIME_OF_DAY 20 00

LOAD_SPECIAL_CHARACTER 1 CSken
LOAD_SPECIAL_CHARACTER 2 CSdeal
LOAD_SPECIAL_CHARACTER 3 sgoona
LOAD_SPECIAL_CHARACTER 4 sgoonb
LOAD_SPECIAL_CHARACTER 5 CSassa
LOAD_SPECIAL_CHARACTER 6 CSassb
LOAD_SPECIAL_CHARACTER 7 CSassc
LOAD_SPECIAL_CHARACTER 8 CSplay

LOAD_SPECIAL_MODEL CUTOBJ01 cs_chop
LOAD_SPECIAL_MODEL CUTOBJ02 brfcase 
LOAD_SPECIAL_MODEL CUTOBJ03	delcase
LOAD_SPECIAL_MODEL CUTOBJ04	merced

REQUEST_MODEL doc_craneeggs04
REQUEST_MODEL doc_crane_cab04
REQUEST_MODEL dockfuel07

REQUEST_COLLISION -692.0 -1559.0
SET_PLAYER_COORDINATES player1 -683.145 -1581.747 11.530

LOAD_SCENE -692.0 -1559.0 12.0

SET_EXTRA_COLOURS 14 FALSE
 
LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED	2
OR NOT HAS_SPECIAL_CHARACTER_LOADED	3
OR NOT HAS_SPECIAL_CHARACTER_LOADED	4
OR NOT HAS_SPECIAL_CHARACTER_LOADED	5
OR NOT HAS_SPECIAL_CHARACTER_LOADED 6

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED	7  
OR NOT HAS_SPECIAL_CHARACTER_LOADED	8
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

WHILE NOT HAS_MODEL_LOADED doc_craneeggs04
OR NOT HAS_MODEL_LOADED doc_crane_cab04
OR NOT HAS_MODEL_LOADED dockfuel07

	WAIT 0

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

LOAD_UNCOMPRESSED_ANIM cs_chop   

LOAD_CUTSCENE int_d
SET_CUTSCENE_OFFSET -690.0 -1568.0 11.44 // 11.4

//SET_NEAR_CLIP 0.2 // Les asked for this
		
CREATE_CUTSCENE_OBJECT SPECIAL08 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_dealer
SET_CUTSCENE_ANIM cs_dealer CSdeal

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona sgoona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sgoonb
SET_CUTSCENE_ANIM cs_sgoonb sgoonb

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_assas1
SET_CUTSCENE_ANIM cs_assas1 CSassa

CREATE_CUTSCENE_OBJECT SPECIAL06 cs_assas2
SET_CUTSCENE_ANIM cs_assas2 CSassb

CREATE_CUTSCENE_OBJECT SPECIAL07 cs_assas3
SET_CUTSCENE_ANIM cs_assas3 CSassc

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_chopper
SET_CUTSCENE_ANIM cs_chopper cs_chop
SET_OBJECT_DRAW_LAST cs_chopper TRUE

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_case1 
SET_CUTSCENE_ANIM cs_case1 brfcase

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_case2 
SET_CUTSCENE_ANIM cs_case2 delcase

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_introcar
SET_CUTSCENE_ANIM cs_introcar merced
SET_OBJECT_DRAW_LAST cs_introcar TRUE

ATTACH_CUTSCENE_OBJECT_TO_COMPONENT cs_ken cs_introcar Mercbod

DO_FADE 2000 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6500
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 8743

	WAIT 0

	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

PRINT_NOW ( INT3_A ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 10784
 
	WAIT 0
	
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

PRINT_NOW ( INT3_B ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 12040 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
	
	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

ENDWHILE

PRINT_NOW ( INT3_C ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 14488
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

PRINT_NOW ( INT3_D ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 17072 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

CLEAR_THIS_PRINT ( INT3_D )

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 20384 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

//PRINT_NOW ( INT3_E ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 23200 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

//PRINT_NOW ( INT3_F ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 35596 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_G ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 36430
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_H ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 39824
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_M ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 40896 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_I ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 42518 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_J ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 46872 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

PRINT_NOW ( INT3_K ) 10000 1 // Mission brief

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51100 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51233
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51366
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51500
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
	ADD_BIG_GUN_FLASH -696.522 -1577.432 12.826 -696.492 -1577.354 12.815
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51633
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51733
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.442 -1577.358 12.765 -696.402 -1577.286 12.749
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51766
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51900
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 51966
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.448 -1577.274 12.666 -696.405 -1577.206 12.643
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 52033
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
	ADD_BIG_GUN_FLASH -696.354 -1578.122 13.060 -695.836 -1577.301 13.020
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4

WHILE cs_time < 52166
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 4
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 6

WHILE cs_time < 52200
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 6
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.437 -1577.235 12.658 -696.391 -1577.170 12.635
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 6

WHILE cs_time < 52256

	WAIT 0

	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

PRINT_NOW ( INT3_N ) 2000 1 //Oh shit!

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52300
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52433
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
	ADD_BIG_GUN_FLASH -696.439 -1577.222 12.653 -696.391 -1577.158 12.630
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52566
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52666
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.465 -1577.189 12.648 -696.419 -1577.213 12.625
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52700
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52833
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52900
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.576 -1577.111 12.686 -696.538 -1577.040 12.667
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 52966
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 53100
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8	
			
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 53133
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -696.692 -1577.050 12.703 -696.665 -1576.973 12.686
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 53233
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 53366
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
	ADD_BIG_GUN_FLASH -696.354 -1578.122 13.060 -695.836 -1577.301 13.020
	ADD_BIG_GUN_FLASH -696.781 -1576.899 12.688 -696.676 -1576.918 12.670
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 53500
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -684.222 -1577.189 12.384 -695.416 -1576.626 12.415
ENDIF

CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8

WHILE cs_time < 57000 // TEST TIME FOR EXPLOSION

	WAIT 0

	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

	CREATE_DUST_EFFECT_FOR_CUTSCENE_HELI cs_chopper 10.0 8
	
ENDWHILE

WHILE cs_time < 58736 
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
		
ENDWHILE

PRINT_NOW ( INT3_L ) 10000 1 // Mission brief

WHILE cs_time < 60800
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 63212    //65212
	WAIT 0
	GET_CUTSCENE_TIME cs_time

	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF
	
ENDWHILE

SET_FADING_COLOUR 1 1 1

DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0
	
	GOSUB skip_intro_button

	IF skip_flag = 2
		GOTO skip_intro_here
	ENDIF

ENDWHILE

CLEAR_EXTRA_COLOURS FALSE

CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
UNLOAD_SPECIAL_CHARACTER 6
UNLOAD_SPECIAL_CHARACTER 7
UNLOAD_SPECIAL_CHARACTER 8

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

MARK_MODEL_AS_NO_LONGER_NEEDED doc_craneeggs04
MARK_MODEL_AS_NO_LONGER_NEEDED doc_crane_cab04
MARK_MODEL_AS_NO_LONGER_NEEDED dockfuel07

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before WAIT

WAIT 0

// Player has pressed to skip entire intro

skip_intro_here:

LOAD_SPLASH_SCREEN intro4

SET_FADING_COLOUR 2 2 2

IF skip_flag = 2 

	DO_FADE 1000 FADE_OUT

	CLEAR_PRINTS

	WHILE GET_FADING_STATUS

		WAIT 0

	ENDWHILE

ENDIF

RELEASE_WEATHER
SET_TIME_OF_DAY 21 00

CLEAR_CUTSCENE

CLEAR_EXTRA_COLOURS FALSE

SET_AREA_VISIBLE VIS_MAIN_MAP

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
UNLOAD_SPECIAL_CHARACTER 6
UNLOAD_SPECIAL_CHARACTER 7
UNLOAD_SPECIAL_CHARACTER 8
UNLOAD_SPECIAL_CHARACTER 9
UNLOAD_SPECIAL_CHARACTER 10
UNLOAD_SPECIAL_CHARACTER 11
UNLOAD_SPECIAL_CHARACTER 12
UNLOAD_SPECIAL_CHARACTER 13
UNLOAD_SPECIAL_CHARACTER 14
UNLOAD_SPECIAL_CHARACTER 15
UNLOAD_SPECIAL_CHARACTER 16
UNLOAD_SPECIAL_CHARACTER 17
UNLOAD_SPECIAL_CHARACTER 18
UNLOAD_SPECIAL_CHARACTER 19
UNLOAD_SPECIAL_CHARACTER 20
UNLOAD_SPECIAL_CHARACTER 21

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ05

MARK_MODEL_AS_NO_LONGER_NEEDED doc_craneeggs04
MARK_MODEL_AS_NO_LONGER_NEEDED doc_crane_cab04
MARK_MODEL_AS_NO_LONGER_NEEDED dockfuel07

MARK_MODEL_AS_NO_LONGER_NEEDED ap_radar1_01
MARK_MODEL_AS_NO_LONGER_NEEDED veg_palm04

SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_mobroom2 FALSE
SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE 231.4 -1277.7 19.0 50.0 mob_detailsb FALSE

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: paranoid set before WAIT

WAIT 0

RELEASE_WEATHER
SET_TIME_OF_DAY 21 00

LVAR_INT intro_car
LVAR_INT intro_bike
LVAR_INT lawyer_intro
LVAR_INT play_audio_intro
LVAR_INT car_in_position_intro
LVAR_INT lawyer_running_intro
LVAR_INT flag_moved_camera_intro
play_audio_intro = 0
car_in_position_intro = 0
lawyer_running_intro = 0
flag_moved_camera_intro = 0

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

LOAD_MISSION_AUDIO 1 ( INTRO1 )
LOAD_MISSION_AUDIO 2 ( INTRO2 )

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0

ENDWHILE

REQUEST_MODEL admiral
REQUEST_MODEL faggio
LOAD_SPECIAL_CHARACTER 10 IGKEN
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED admiral
OR NOT HAS_MODEL_LOADED faggio
OR NOT HAS_SPECIAL_CHARACTER_LOADED 10

	WAIT 0
	
ENDWHILE  

CLEAR_AREA 114.2 -823.3 9.7 1.0 FALSE
REQUEST_COLLISION 86.428 -852.238
LOAD_SCENE 114.2 -823.3 9.7 //New lawyer start
CLEAR_AREA 86.428 -852.238 9.325 50.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PLAYER_COORDINATES player1 110.637 -798.590 9.325 // FIXMIAMI: was 86.428 -852.238 9.325 
CLEAR_AREA 110.637 -798.590 10.0 10.0 TRUE
CLEAR_AREA 86.485 -851.933 10.0 10.0 TRUE
CREATE_CAR admiral 83.540 -851.669 10.0 intro_car
SET_CAR_PROOFS intro_car TRUE TRUE TRUE TRUE TRUE
SET_CAR_HEADING intro_car 330.0
//SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER scplayer intro_car // FIXMIAMI: removed
CREATE_CHAR_INSIDE_CAR intro_car PEDTYPE_CIVMALE SPECIAL10 lawyer_intro
CLEAR_CHAR_THREAT_SEARCH lawyer_intro
// FIXMIAMI: START
LVAR_INT intro_double
CREATE_CHAR_AS_PASSENGER intro_car PEDTYPE_CIVMALE null 1 intro_double
CLEAR_CHAR_THREAT_SEARCH intro_double
// FIXMIAMI: END
SET_CHAR_PROOFS lawyer_intro TRUE TRUE TRUE TRUE TRUE
CAR_SET_IDLE intro_car 
CHANGE_CAR_COLOUR intro_car 84 84
CREATE_CAR faggio 127.4 -818.5 9.5 intro_bike  
SET_CAR_HEADING intro_bike 250.6
SET_RADIO_CHANNEL 9 -1 
MARK_MODEL_AS_NO_LONGER_NEEDED admiral
MARK_MODEL_AS_NO_LONGER_NEEDED faggio

//SET_PLAYER_COORDINATES player1 86.428 -852.238 9.325 // FIXMIAMI: test  
//SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER scplayer intro_car // FIXMIAMI: test
/* FIXMIAMI: removed
WHILE NOT IS_CHAR_IN_ANY_CAR scplayer

	WAIT 0

	IF IS_CAR_DEAD intro_car
	ENDIF

ENDWHILE
*/

WAIT 700 // FIXMIAMI: wait till the car lands

DO_FADE 1000 FADE_IN

CLEAR_AREA 116.583 -796.821 11.423 1.0 TRUE 
SET_FIXED_CAMERA_POSITION 116.583 -796.821 11.423 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 116.573 -797.821 11.414 JUMP_CUT

IF NOT IS_CAR_DEAD intro_car
	SET_CAR_FORWARD_SPEED intro_car 20.0
	CAR_GOTO_COORDINATES intro_car 103.1 -832.3 9.317 //-833.3
	SET_CAR_CRUISE_SPEED intro_car 30.0
	SET_CAR_DRIVING_STYLE intro_car 2
	car_in_position_intro = 1
ENDIF

timera = 0
timerb = 0
 
WHILE NOT play_audio_intro = 8
OR NOT car_in_position_intro = 4 
	
	WAIT 0

	// FIXMIAMI: START
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO skip_lawyer_intro
	ENDIF
	// FIXMIAMI: END
			
	IF IS_CAR_DEAD intro_car
		GOTO skip_lawyer_intro // FIXMIAMI
	ELSE
		 
		IF car_in_position_intro = 1
			
			IF timerb >= 30000

				IF NOT IS_CAR_DEAD intro_car

					IF NOT LOCATE_CAR_3D intro_car 132.600 -818.278 9.446 3.0 3.0 4.0 FALSE
						car_in_position_intro = 3
						SET_CAR_COORDINATES intro_car 132.600 -818.278 9.446
						SET_CAR_HEADING intro_car 206.0214
					ENDIF

				ENDIF

			ENDIF

		ENDIF
				
		IF car_in_position_intro = 1
				
			IF LOCATE_CAR_3D intro_car 103.1 -832.3 9.317 4.0 4.0 4.0 FALSE
				CAR_GOTO_COORDINATES intro_car 113.371 -819.078 9.317
				car_in_position_intro = 2
			ENDIF

		ENDIF

		IF car_in_position_intro = 2 
			
			IF LOCATE_CAR_3D intro_car 113.371 -819.078 9.317 4.0 4.0 4.0 FALSE 
				CAR_GOTO_COORDINATES intro_car 132.600 -818.278 9.446
				car_in_position_intro = 3
			ENDIF

		ENDIF

		IF car_in_position_intro = 3

			IF LOCATE_CAR_3D intro_car 132.600 -818.278 9.446 3.0 3.0 4.0 FALSE
			 
		 		IF NOT IS_CAR_DEAD intro_car
					//SET_CAR_TEMP_ACTION intro_car TEMPACT_HANDBRAKESTRAIGHT 30
					SET_CAR_CRUISE_SPEED intro_car 0.0
					CAR_SET_IDLE intro_car
					car_in_position_intro = 4
				ENDIF

			ENDIF

		ENDIF
				  
	ENDIF

	IF IS_CHAR_DEAD lawyer_intro
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF
	
	IF play_audio_intro = 0
		PLAY_MISSION_AUDIO 1
		PRINT_NOW ( INTRO1 ) 10000 1 //"
		timera = 0
		timerb = 0
		play_audio_intro = 1
	ENDIF

	IF flag_moved_camera_intro = 0

		IF timerb >= 2000
			CLEAR_AREA 104.880 -808.433 12.108 1.0 FALSE
			SET_FIXED_CAMERA_POSITION 104.880 -808.433 12.108 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 105.771 -808.888 12.091 JUMP_CUT
			timerb = 0
			flag_moved_camera_intro = 1
		ENDIF

	ENDIF

	IF play_audio_intro = 1

		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT ( INTRO1 )
			
			IF timera >= 1000
				PLAY_MISSION_AUDIO 2
				PRINT_NOW ( INTRO2 ) 10000 1 //""
				play_audio_intro = 2
			ENDIF
						
		ENDIF

	ENDIF

	IF play_audio_intro = 2
		LOAD_MISSION_AUDIO 1 ( INTRO3 )
		play_audio_intro = 3
	ENDIF
	
	IF play_audio_intro = 3
	
		IF HAS_MISSION_AUDIO_FINISHED 2
			CLEAR_THIS_PRINT ( INTRO2 )
			play_audio_intro = 4
		ENDIF
		
   	ENDIF
	
   	IF play_audio_intro = 4
	
   		IF HAS_MISSION_AUDIO_LOADED 1
   			LOAD_MISSION_AUDIO 2 ( INTRO4 )
			timera = 0
   			play_audio_intro = 5
   		ENDIF
		
   	ENDIF
	
   	IF play_audio_intro = 5

		IF timera >= 900
   			PLAY_MISSION_AUDIO 1
   			PRINT_NOW ( INTRO3 ) 10000 1 //" "
   			play_audio_intro = 6
   		ENDIF

	ENDIF

   	IF play_audio_intro = 6

   		IF HAS_MISSION_AUDIO_FINISHED 1
   			CLEAR_THIS_PRINT ( INTRO3 )
   			play_audio_intro = 7
   		ENDIF
   		
	ENDIF
	
   	IF play_audio_intro = 7
	
		IF HAS_MISSION_AUDIO_LOADED 2
			timera = 0
			play_audio_intro = 8
		ENDIF
		
	ENDIF
	   				
ENDWHILE

WHILE timera < 300
	
	WAIT 0

	// FIXMIAMI: START
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO skip_lawyer_intro
	ENDIF
	// FIXMIAMI: END

	IF IS_CAR_DEAD intro_car
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF

	IF IS_CHAR_DEAD lawyer_intro
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( INTRO4 ) 10000 1 //" "

WAIT 400

// FIXMIAMI: START
IF IS_BUTTON_PRESSED PAD1 CROSS
	GOTO skip_lawyer_intro
ENDIF
// FIXMIAMI: END

IF IS_CAR_DEAD intro_car
	GOTO skip_lawyer_intro // FIXMIAMI
ENDIF

IF IS_CHAR_DEAD lawyer_intro
	GOTO skip_lawyer_intro // FIXMIAMI
ENDIF

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

	// FIXMIAMI: START
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO skip_lawyer_intro
	ENDIF
	// FIXMIAMI: END

	IF IS_CAR_DEAD intro_car
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF

	IF IS_CHAR_DEAD lawyer_intro
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( INTRO4 )

IF NOT IS_CAR_DEAD intro_car

	IF NOT IS_CHAR_DEAD lawyer_intro
		SET_CHAR_OBJ_LEAVE_CAR lawyer_intro intro_car
	ENDIF
	
ENDIF

IF NOT IS_CHAR_DEAD lawyer_intro

	WHILE IS_CHAR_IN_ANY_CAR lawyer_intro

		WAIT 0

		// FIXMIAMI: START
		IF IS_BUTTON_PRESSED PAD1 CROSS
			GOTO skip_lawyer_intro
		ENDIF
		// FIXMIAMI: END

		IF IS_CAR_DEAD intro_car
			GOTO skip_lawyer_intro // FIXMIAMI
		ENDIF

		IF IS_CHAR_DEAD lawyer_intro
			GOTO skip_lawyer_intro // FIXMIAMI
		ENDIF
		
	ENDWHILE

ENDIF

IF NOT IS_CHAR_DEAD lawyer_intro
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lawyer_intro 125.809 -815.263
	SET_CHAR_RUNNING lawyer_intro TRUE
ENDIF

timera = 0

WHILE timera < 1500

	WAIT 0

	// FIXMIAMI: START
	IF IS_BUTTON_PRESSED PAD1 CROSS
		GOTO skip_lawyer_intro
	ENDIF
	// FIXMIAMI: END

	IF NOT IS_CHAR_DEAD lawyer_intro
	ELSE // FIXMIAMI
		GOTO skip_lawyer_intro // FIXMIAMI
	ENDIF
	
ENDWHILE

CLEAR_AREA 113.655 -815.814 11.029 1.0 FALSE
SET_FIXED_CAMERA_POSITION 113.655 -815.814 11.029 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 114.307 -816.570 11.083 JUMP_CUT

IF NOT IS_CHAR_DEAD lawyer_intro
	CHAR_SET_IDLE lawyer_intro
	SET_CHAR_OBJ_NO_OBJ lawyer_intro
	SET_CHAR_COORDINATES lawyer_intro 125.809 -815.263 9.444
ENDIF

IF NOT IS_CHAR_DEAD lawyer_intro
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lawyer_intro 116.269 -825.438
	SET_CHAR_RUNNING lawyer_intro TRUE
	lawyer_running_intro = 1
ENDIF

IF NOT IS_CHAR_IN_ANY_CAR scplayer
   SET_CHAR_COORDINATES scplayer 136.457 -817.37 9.44
   SET_CHAR_HEADING scplayer 225.495
ELSE
	WARP_CHAR_FROM_CAR_TO_COORD scplayer 136.457 -817.37 9.44
ENDIF

IF NOT IS_CHAR_IN_ANY_CAR scplayer 
	SET_CHAR_HEADING scplayer 225.495
ENDIF

// FIXMIAMI: START
DELETE_CHAR intro_double
SET_CHAR_OBJ_NO_OBJ scplayer
// FIXMIAMI: END

timerb = 0

WHILE timerb < 1350

	WAIT 0

	IF NOT IS_CHAR_DEAD lawyer_intro

	  //	IF lawyer_running_intro = 1

		  //	IF LOCATE_CHAR_ON_FOOT_3D lawyer_intro 116.269 -825.438 9.45 0.5 0.5 2.0 FALSE
		  /////		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lawyer_intro 123.189 -829.854
		  //		SET_CHAR_RUNNING lawyer_intro TRUE
		  //		lawyer_running_intro = 2
		  //	ENDIF
			
	   //	ENDIF  
			   	
	ENDIF

ENDWHILE

RETURN // FIXMIAMI

mission_cleanup_intro: // FIXMIAMI
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

CLEAR_AREA 136.457 -817.37 9.44 10.0 TRUE // FIXMIAMI

CLEAR_MISSION_AUDIO 1 // FIXMIAMI
CLEAR_MISSION_AUDIO 2 // FIXMIAMI

CLEAR_THIS_PRINT ( INTRO1 ) // FIXMIAMI
CLEAR_THIS_PRINT ( INTRO2 ) // FIXMIAMI
CLEAR_THIS_PRINT ( INTRO3 ) // FIXMIAMI
CLEAR_THIS_PRINT ( INTRO4 )

SET_RADIO_CHANNEL FLASH_FM -1

SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
SWITCH_RUBBISH ON
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
MARK_CAR_AS_NO_LONGER_NEEDED intro_car
MARK_CAR_AS_NO_LONGER_NEEDED intro_bike
SWITCH_CAR_GENERATOR gen_car83 101

DELETE_CHAR intro_double // FIXMIAMI
DELETE_CHAR lawyer_intro

flag_intro_passed = 1
flag_player_on_mission = 0

IF NOT IS_CAR_DEAD intro_car
	SET_CAR_PROOFS intro_car FALSE FALSE FALSE FALSE FALSE
ENDIF

UNLOAD_SPECIAL_CHARACTER 10
MARK_MODEL_AS_NO_LONGER_NEEDED admiral
MARK_MODEL_AS_NO_LONGER_NEEDED faggio

SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0

LOAD_SPLASH_SCREEN splash1

SET_FADING_COLOUR 0 0 0

MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up

RETURN

// Skip intro button check

skip_intro_button:
IF skip_flag = 0
	IF NOT IS_BUTTON_PRESSED PAD1 CROSS
	AND NOT IS_BUTTON_PRESSED PAD1 START
		skip_flag = 1
	ENDIF
ENDIF

IF skip_flag = 1
	IF WAS_CUTSCENE_SKIPPED
		skip_flag = 2
	ENDIF
ENDIF

RETURN

// FIXMIAMI: START
skip_lawyer_intro:
SET_FADING_COLOUR 0 0 0

WAIT 0
DO_FADE 0 FADE_OUT

CLEAR_THIS_PRINT ( INTRO1 )
CLEAR_THIS_PRINT ( INTRO2 )
CLEAR_THIS_PRINT ( INTRO3 )
CLEAR_THIS_PRINT ( INTRO4 )

CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2

CLEAR_AREA 136.457 -817.37 9.44 10.0 TRUE
LOAD_SCENE 136.457 -817.37 9.44

IF NOT IS_CHAR_IN_ANY_CAR scplayer
   SET_CHAR_COORDINATES scplayer 136.457 -817.37 9.44
   SET_CHAR_HEADING scplayer 225.495
ELSE
	WARP_CHAR_FROM_CAR_TO_COORD scplayer 136.457 -817.37 9.44
ENDIF

IF NOT IS_CHAR_IN_ANY_CAR scplayer 
	SET_CHAR_HEADING scplayer 225.495
ENDIF

DELETE_CHAR intro_double
SET_CHAR_OBJ_NO_OBJ scplayer

DELETE_CAR intro_car
CREATE_CAR admiral 135.855 -819.419 10.0 intro_car
SET_CAR_HEADING intro_car 206.686
CHANGE_CAR_COLOUR intro_car 84 84

WAIT 700

DO_FADE 1000 FADE_IN
RETURN
// FIXMIAMI: END

}

