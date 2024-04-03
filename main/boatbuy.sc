MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ****************************** boat yard Buy Script *************************************
// *****************************************************************************************
// *****************************************************************************************

// FIXMIAMI: START - fix SSU

GOSUB mission_start_boaybuy

GOSUB mission_cleanup_boaybuy

MISSION_END

mission_start_boaybuy:
// FIXMIAMI: END
{
LVAR_INT cutscene_boat csdwayn csjetro boatbuy_boat1 boatbuy_boat2  //csplay

flag_player_on_mission = 1

// FIXMIAMI: START
LVAR_INT flag_boatbuy_set1
flag_boatbuy_set1 = 0
SET_PLAYER_CONTROL player1 OFF
// FIXMIAMI: END

SCRIPT_NAME BOATBY					  

WAIT 0

DELETE_OBJECT boat_closed

LOAD_MISSION_TEXT BOATBUY

// FIXMIAMI: START
REQUEST_MODEL dk_reef
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED dk_reef
	WAIT 0
ENDWHILE
// FIXMIAMI: END

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 csdwayn
LOAD_SPECIAL_CHARACTER 3 csjetro

CREATE_OBJECT_NO_OFFSET dk_reef -651.0 -1481.21 16.647 cutscene_boat
DONT_REMOVE_OBJECT cutscene_boat

MARK_MODEL_AS_NO_LONGER_NEEDED dk_reef // FIXMIAMI

GOTO boatbuy_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -664.1 -1476.3 13.8 RADAR_SPRITE_LAWYER boatbuy_blip 
boatbuy_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check
WAIT 0

LOAD_SCENE -649.7202 -1482.0997 14.9076//-640.3344 -1488.8250 14.2185

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0

ENDWHILE

LOAD_UNCOMPRESSED_ANIM csplay
LOAD_UNCOMPRESSED_ANIM csdwayn
LOAD_UNCOMPRESSED_ANIM csjetro
LOAD_CUTSCENE drug_1
SET_CUTSCENE_OFFSET -690.0 -1568.0 11.4
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 csdwayn
SET_CUTSCENE_ANIM csdwayn csdwayn

CREATE_CUTSCENE_OBJECT SPECIAL03 csjetro
SET_CUTSCENE_ANIM csjetro csjetro

CLEAR_AREA -633.2 -1488.8 12.7 1.0 TRUE
SET_PLAYER_COORDINATES player1 -633.2 -1488.8 12.7
SET_PLAYER_HEADING player1 250.0

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 142
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW DRUG_1 10000 1//Hello? Hel-lo?!

WHILE cs_time <  9838
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_2 10000 1//Put it out. There's a dude here.

WHILE cs_time < 12335
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_3 10000 1//Hey suit dude! I guess you're the new owner?
 
WHILE cs_time < 14831
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_4 10000 1//Yeah. Which one of the boats is the fastest?
 
WHILE cs_time < 17624
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_5 10000 1//It's already in the water, dude,
 
WHILE cs_time < 19626
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_6 10000 1//I though you might want to try her out.
 
WHILE cs_time < 21916
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_7 10000 1//Dude, she's already running with a 300 horse power engine...
 
WHILE cs_time < 24845
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_8 10000 1//...and the fiberglass hull, she just shoots through the waves.!
 
WHILE cs_time < 29051
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_9 10000 1//She can do like zero to sixty in four seconds...
 
WHILE cs_time < 33053
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_10 10000 1//She can hold like twenty bails of the best Jamaican smoke right in the hull!
 
WHILE cs_time < 37627
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_11 10000 1//So go ahead dude, she's ready to fly!
 
WHILE cs_time < 40309
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_12 10000 1//Yo, suit dude, you gotta light?
 
WHILE cs_time < 44071
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW DRUG_13 10000 1//Dude? Dude!
 
WHILE cs_time < 45000//45848
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS // FIXMIAMI
 
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

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

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: moved up here from below

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

REQUEST_MODEL JETMAX
REQUEST_MODEL SQUALO

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED JETMAX
OR NOT HAS_MODEL_LOADED	SQUALO
	WAIT 0
ENDWHILE

CREATE_CAR JETMAX -586.6 -1512.2 5.0 boatbuy_boat1
SET_CAR_HEADING boatbuy_boat1 253.0

CREATE_CAR SQUALO -581.2 -1503.2 5.0 boatbuy_boat2
SET_CAR_HEADING	boatbuy_boat2 250.0

WAIT 0
WAIT 0
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN
SWITCH_WIDESCREEN ON
//SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: moved up
LOAD_SCENE -565.647 -1506.333 8.906
SET_FIXED_CAMERA_POSITION -564.650 -1506.310 8.990 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -565.647 -1506.333 8.906 JUMP_CUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PLAY_MISSION_PASSED_TUNE 1

PRINT_WITH_NUMBER_BIG BOATBUY boatbuy_price 7000 6 //
GOSUB boatbuy_set1 // FIXMIAMI: moved stuff into a subroutine

WAIT 7000

SET_PLAYER_CONTROL player1 ON // FIXMIAMI


RETURN // FIXMIAMI

// FIXMIAMI: START
boatbuy_set1:
IF flag_boatbuy_set1 = 0
	ADD_MONEY_SPENT_ON_PROPERTY boatbuy_price
	SET_PROPERTY_AS_OWNED PROP_BOATYARD
	flag_boatbuy_set1 = 1
ENDIF
RETURN
// FIXMIAMI: END

// FIXMIAMI: START - moved stuff down here
mission_cleanup_boaybuy:

GET_GAME_TIMER timer_mobile_start

PLAYER_MADE_PROGRESS 1

SWITCH_CAR_GENERATOR gen_car153 101
SWITCH_CAR_GENERATOR gen_car154 101

REMOVE_BLIP boatbuy_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -664.1 -1476.3 13.8 RADAR_SPRITE_BOATYARD boatbuy_blip
CHANGE_BLIP_DISPLAY boatbuy_blip BLIP_ONLY
//ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -664.1 -1476.3 13.8 RADAR_SPRITE_HOUSEG boatbuy_blip 
SET_ZONE_PED_INFO BOATYRD DAY   (13) 0 0 0 0 0 0 1000 0 0 0 
SET_ZONE_PED_INFO BOATYRD NIGHT (10) 0 0 0 0 0 0 1000 0 0 0
SWITCH_PED_ROADS_ON -692.193 -1522.901 0.0 -575.311 -1453.378 30.0//BOAT YARD
START_NEW_SCRIPT boatbuy_save_loop
START_NEW_SCRIPT boatyard_oddjob_loop

SET_CAMERA_BEHIND_PLAYER // FIXMIAMI: moved before jumpcut
RESTORE_CAMERA_JUMPCUT

//WAIT 0 // FIXMIAMI: removed

MARK_MODEL_AS_NO_LONGER_NEEDED jetmax
MARK_MODEL_AS_NO_LONGER_NEEDED squalo
flag_player_on_mission = 0
MISSION_HAS_FINISHED
//MISSION_END // FIXMIAMI: moved up
RETURN
// FIXMIAMI: END



}