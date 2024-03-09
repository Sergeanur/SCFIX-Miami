MISSION_START
// *****************************************************************************************
// *******************************   icecut phone call cut scene    ************************* 
// *****************************************************************************************

// ****************************************Mission Start************************************

mission_start_icecut:

SCRIPT_NAME ICECUT

flag_player_on_mission = 1

//skip_flag = 0

WAIT 0

LOAD_MISSION_TEXT icecut

{

SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_PLAYER_CONTROL player1 OFF
//SET_PLAYER_VISIBLE player1 FALSE
SWITCH_STREAMING OFF
SWITCH_RUBBISH OFF

VAR_INT cs_maude
VAR_INT mcane
VAR_INT icecut_van1
//VAR_INT icecut_van2



//SET_AREA_VISIBLE VIS_icecut

LOAD_MISSION_AUDIO 1 MONO_5

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSMaude
LOAD_SPECIAL_MODEL CUTOBJ01 mcane


LOAD_ALL_MODELS_NOW

LOAD_SCENE -873.5121 -574.0815 10.1528
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01 
	WAIT 0
ENDWHILE

REQUEST_MODEL mrwhoop

WHILE NOT HAS_MODEL_LOADED mrwhoop
	WAIT 0
ENDWHILE

CREATE_CAR mrwhoop -877.8974 -562.5469 10.2353 icecut_van1
SET_CAR_HEADING icecut_van1 184.4191
//CREATE_CAR mrwhoop -873.898438 -562.5469 10.2353 icecut_van2
//SET_CAR_HEADING icecut_van2 184.4191

LOAD_CUTSCENE ice_1
SET_CUTSCENE_OFFSET -873.5121 -574.0815 10.1528
//SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_maude
SET_CUTSCENE_ANIM cs_maude CSMaude

CREATE_CUTSCENE_OBJECT CUTOBJ01 mcane
ATTACH_CUTSCENE_OBJECT_TO_BONE mcane cs_maude BONE_L_HAND

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 6929
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_A ) 10000 1 // Who are you?


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 8306
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_B ) 10000 1 // Your new owner.


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 10381
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_C ) 10000 1 // Were you, now, or at any time, a child?


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 13633
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_D ) 10000 1 // What are you talking about?


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 14189
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_E ) 10000 1 // Were you a child?

 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 15441
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_F ) 10000 1 // Yes! Calm down, what's wrong with you?


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 16881
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_G ) 10000 1 // I knew it. A child.   
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 20281
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_H ) 10000 1 //  A dirty, stinking, sniveling, snotting, vile, puking, crying little baby! 
  

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 25045
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_I ) 10000 1 //  A baby.. an awful, horrible, disgusting little baby! Boo hoo. 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 29698
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_J ) 10000 1 //  Mumma doesn't love you.You little shit!
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 32513
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_K ) 10000 1 //  Ow! Calm down.
 
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 35215
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_L ) 10000 1 //  Argh, I HATE babies, and I hate children. 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 38544

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_M ) 10000 1 //  They're dirty, sniveling, snotting, puking little..


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 40042

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_N ) 10000 1 //  Enough! Alreadyt? 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 41685

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_O ) 10000 1 //  What is wrong with you?? 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 43879

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_P ) 10000 1 //  You make soft ice cream, okay? It's purely for kids. 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 48927

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_Q ) 10000 1 //  What kind of psycho are you? 
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 51501

	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_R 10000 1 //  Just so I understand this, why make children happy if you hate them?
 

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 55814
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_S ) 10000 1 //  Oh, you stupid, snivelling, snotty 


GET_CUTSCENE_TIME cs_time

WHILE cs_time < 59535
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_T ) 10000 1 //  Shut up!

  
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 60379
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_U ) 10000 1 //  -Brat! 

 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 62496
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_V ) 10000 1 //  The ice cream is a front. 

  
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 64801
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_W ) 10000 1 //  We distribute other, non-dairy products  
 
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 68699
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_X ) 10000 1 //  And if I see a kid, I put him to good use. 
 
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 72778
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_Y ) 10000 1 //  Don't I kiddies? Yes, yes I do. Mummy doesn't love you.
 
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 78390
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( ICC1_Z ) 10000 1 //  She HATES you! 

WHILE cs_time < 81000// number greater than last line of text  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SWITCH_RUBBISH ON

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
	ENDIF
ENDIF


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE // FIXMIAMI: moved up here to fix cutscene still seen after skip


SWITCH_RUBBISH ON

LOAD_SCENE -839.512 -582.021 24.777

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

MARK_CAR_AS_NO_LONGER_NEEDED icecut_van1
//MARK_CAR_AS_NO_LONGER_NEEDED icecut_van2
DELETE_CAR icecut_van1
//DELETE_CAR icecut_van2

flag_icecut_mission1_passed = 1



//REGISTER_MISSION_PASSED ICEBUY

ADD_MONEY_SPENT_ON_PROPERTY icebuy_price
SWITCH_CAR_GENERATOR gen_car12 101

REMOVE_BLIP icebuy_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -878.5 -575.1 11.2 RADAR_SPRITE_ICE icebuy_blip
CHANGE_BLIP_DISPLAY icebuy_blip BLIP_ONLY
SET_ZONE_PED_INFO ICCREAM DAY   (13) 0 0 0 0 0 0 1000 0 0 0
SET_ZONE_PED_INFO ICCREAM NIGHT (10) 0 0 0 0 0 0 1000 0 0 0 
SWITCH_PED_ROADS_ON -896.098 -593.101 0.0 -855.09 -548.64 30.0//ICECREAM

SET_PROPERTY_AS_OWNED PROP_ICECREAM



START_NEW_SCRIPT icecream_save_loop



WAIT 1000
DO_FADE 1500 FADE_IN

SET_OBJECT_COORDINATES ice_door -866.689 -572.095 15.573 // FIXMIAMI: remove SLIDE_OBJECT

CLEAR_AREA -874.324 -565.683 11.194 1.0 TRUE
SET_PLAYER_COORDINATES player1 -874.324 -565.683 11.194
SET_PLAYER_HEADING player1 183.398


MARK_OBJECT_AS_NO_LONGER_NEEDED ice_door
SET_FIXED_CAMERA_POSITION -839.512 -582.021 24.777 0.0 0.0 0.0 //ROTATE UP
POINT_CAMERA_AT_POINT -840.451 -581.759 24.553 JUMP_CUT
PLAY_MISSION_PASSED_TUNE 1

PRINT_WITH_NUMBER_BIG ICEBUY icebuy_price 7000 6 //purchased text
WAIT 7000


flag_player_on_mission = 0

PLAYER_MADE_PROGRESS 1
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

MISSION_HAS_FINISHED
MISSION_END
 
}
RETURN



