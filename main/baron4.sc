MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************baron mission 4***************************************
// ****************************************COKE RUN*******************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_baron4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_baron4_failed
ENDIF

GOSUB mission_cleanup_baron4

MISSION_END


// Variables for mission
{
LVAR_INT coke_boat1 coke_boat2 coke_boat3 coke_boat4 coke_boat_blip coke_boat vance_dance_samp_play
LVAR_INT boat_pilot1 boat_pilot2 boat_pilot3 boat_pilot4 boat_shooter1 boat_shooter3 boat_shooter4
VAR_INT Sphere_cok4	coke_boat_blip_arrow any_coke_boat
VAR_INT jetty_char1 jetty_char2 jetty_char3 jetty_char4	jetty_chars_created	fastboat_health	boat_goto_coords
VAR_INT you_want_some_samp eat_it_samp sleep_fish_samp heli_chopper	cs_shotvcr boat_pilot5 created_coke_boat
VAR_INT set_heli_chopper_off cok4_barrel1 cok4_barrel2

// ***************************************Mission Start*************************************

mission_start_baron4:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME baron4
WAIT 0

LOAD_MISSION_TEXT BARON4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0

FORCE_WEATHER WEATHER_SUNNY


audio_is_loading = 0
audio_has_loaded = 0
first_two_samples = 0
second_two_samples = 0
third_two_samples = 0
forth_two_samples = 0
fifth_two_samples = 0
sixth_two_samples = 0
vance_dance_samp_play = 0
jetty_chars_created = 0
boat_goto_coords = 0
you_want_some_samp = 0
eat_it_samp = 0
sleep_fish_samp = 0
created_coke_boat = 0
set_heli_chopper_off = 0

SET_AREA_VISIBLE VIS_MANSION 
SET_EXTRA_COLOURS 8 FALSE

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdiaz
LOAD_SPECIAL_MODEL CUTOBJ01 dcfan
LOAD_SPECIAL_MODEL CUTOBJ02 deagl
LOAD_SPECIAL_MODEL CUTOBJ03 shotvcr

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW

LOAD_SCENE -378.3 -591.9 25.8
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02 
OR NOT HAS_MODEL_LOADED CUTOBJ03 
	WAIT 0

ENDWHILE

LOAD_UNCOMPRESSED_ANIM CSplay
LOAD_UNCOMPRESSED_ANIM csdiaz
LOAD_UNCOMPRESSED_ANIM dcfan
LOAD_UNCOMPRESSED_ANIM deagl
LOAD_UNCOMPRESSED_ANIM shotvcr

LOAD_CUTSCENE cok_4a
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_diaz
SET_CUTSCENE_ANIM cs_diaz csdiaz

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_dcfan
SET_CUTSCENE_ANIM_TO_LOOP dcfan
SET_CUTSCENE_ANIM cs_dcfan dcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_deagl
SET_CUTSCENE_ANIM cs_deagl deagl

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_shotvcr
SET_CUTSCENE_ANIM cs_shotvcr shotvcr


CLEAR_AREA -412.3 -607.0 16.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -412.3 -607.0 16.2
SET_PLAYER_HEADING player1 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3123
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_A ) 10000 1 // Mission brief

WHILE cs_time < 5921
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_B ) 10000 1 // Mission brief

WHILE cs_time < 7616
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_C ) 10000 1 // Mission brief

WHILE cs_time < 14933
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//gunshot 
IF NOT WAS_CUTSCENE_SKIPPED  
	ADD_BIG_GUN_FLASH -407.737 -559.252 18.852 -404.218 -559.623 18.5   
ENDIF
  
WHILE cs_time < 14966
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//impact
IF NOT WAS_CUTSCENE_SKIPPED 
	ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE -408.2 -559.9 18.7 0.05 0.05 0.05 0.05 0 0 0 500
ENDIF

WHILE cs_time < 15433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//gunshot
IF NOT WAS_CUTSCENE_SKIPPED    
	ADD_BIG_GUN_FLASH -407.729 -559.322 18.842 -408.281 -559.653 18.5    
ENDIF

WHILE cs_time < 15466
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

//impact

WHILE cs_time < 15656
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_D ) 10000 1 // Mission brief

WHILE cs_time < 18764
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_E ) 10000 1 // Mission brief

WHILE cs_time < 21799
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_F ) 10000 1 // Mission brief

WHILE cs_time < 22980
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_G ) 10000 1 // Mission brief

WHILE cs_time < 24759
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_H ) 10000 1 // Mission brief

WHILE cs_time < 26995
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_I ) 10000 1 // Mission brief

WHILE cs_time < 31939
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_J ) 10000 1 // Mission brief

WHILE cs_time < 35149
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_K ) 10000 1 // Mission brief

WHILE cs_time < 40362
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_L ) 10000 1 // Mission brief

WHILE cs_time < 44300
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_M ) 10000 1 // Mission brief

WHILE cs_time < 47740
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_N ) 10000 1 // Mission brief

WHILE cs_time < 50131
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_O ) 10000 1 // Mission brief

WHILE cs_time < 52131
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 56064
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
SET_CAMERA_BEHIND_PLAYER
CLEAR_EXTRA_COLOURS FALSE
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
REMOVE_PARTICLE_EFFECTS_IN_AREA -406.8 -552.0 25.0 -437.9 -569.4 10.0

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE -412.3 -607.0 16.2

WAIT 500

DO_FADE 1500 FADE_IN

PRINT_NOW ( COK4_31 ) 5000 2 //Go to the fastest boat at the jetty! 

ADD_BLIP_FOR_COORD -378.6 -649.8 10.6 coke_boat_blip

ADD_SPHERE -378.6 -649.8 10.6 4.0 Sphere_cok4	

REQUEST_MODEL squalo
REQUEST_MODEL speeder 
REQUEST_MODEL marquis 
REQUEST_MODEL RUGER
REQUEST_MODEL CBa
LOAD_SPECIAL_CHARACTER 3 igbuddy // FIXMIAMI: moved up

LOAD_ALL_MODELS_NOW // FIXMIAMI

WHILE NOT HAS_MODEL_LOADED squalo
OR NOT HAS_MODEL_LOADED speeder
OR NOT HAS_MODEL_LOADED marquis
OR NOT HAS_MODEL_LOADED RUGER
OR NOT HAS_MODEL_LOADED CBa
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3// FIXMIAMI: moved up
	WAIT 0

ENDWHILE

CREATE_CAR squalo -378.5 -660.0 5.6 fastest_boat

// START OF MISSION 

SET_CAR_HEADING fastest_boat 270.0

// FIXMIAMI: START
IF NOT fastest_boat_col1 = -1
AND NOT fastest_boat_col2 = -1
	CHANGE_CAR_COLOUR fastest_boat fastest_boat_col1 fastest_boat_col2
ENDIF

CREATE_CHAR_INSIDE_CAR fastest_boat PEDTYPE_CIVMALE SPECIAL03 buddy
CLEAR_CHAR_THREAT_SEARCH buddy
SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
SET_CHAR_NEVER_TARGETTED buddy TRUE
// FIXMIAMI: END

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -378.5 -660.0 5.6 16.5 11.5 8.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD fastest_boat
		PRINT_NOW ( COK4_33 ) 5000 2 //You destoyed the boat!
		GOTO mission_baron4_failed
	ENDIF

	// FIXMIAMI: START
	IF IS_CHAR_DEAD buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_baron4_failed
	ENDIF
	// FIXMIAMI: END

ENDWHILE

REMOVE_SPHERE Sphere_cok4

// ******************************START MEET BUDDY AT BOAT*********************************************

GET_GAME_TIMER breakout_timer_start
breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player1
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1
 
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD fastest_boat
	SET_CAR_COORDINATES fastest_boat -378.5 -659.5 4.3 
	SET_CAR_HEADING fastest_boat 270.0
	FREEZE_CAR_POSITION fastest_boat TRUE
ENDIF

DELETE_CHAR buddy // FIXMIAMI

SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0

ENDWHILE

LOAD_CUTSCENE cok_4a2
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 CS_buddy
SET_CUTSCENE_ANIM CS_buddy CSbuddy

ATTACH_CUTSCENE_OBJECT_TO_VEHICLE cs_player fastest_boat
ATTACH_CUTSCENE_OBJECT_TO_VEHICLE CS_buddy fastest_boat

CLEAR_AREA -378.8 -656.8 6.9 2.0 TRUE

IF IS_PLAYER_IN_ANY_CAR player1 
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -378.8 -656.8 6.9
ELSE
	SET_PLAYER_COORDINATES player1 -378.8 -656.8 6.9
ENDIF

SET_PLAYER_HEADING player1 180.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4823
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_P ) 10000 1 // Mission brief

WHILE cs_time < 8992
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_Q ) 10000 1 // Mission brief

WHILE cs_time < 12753
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_R ) 10000 1 // Mission brief

WHILE cs_time < 16046
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_S ) 10000 1 // Mission brief

WHILE cs_time < 18611
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_T ) 10000 1 // Mission brief

WHILE cs_time < 20832
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_U ) 10000 1 // Mission brief

WHILE cs_time < 21443
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK4_V ) 10000 1 // Mission brief

WHILE cs_time < 22443
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 22984
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_SCENE -378.8 -656.8 6.9

IF NOT IS_CAR_DEAD fastest_boat
	FREEZE_CAR_POSITION fastest_boat FALSE
ENDIF

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

IF NOT IS_CAR_DEAD fastest_boat
	SET_CAR_COORDINATES fastest_boat -378.5 -661.0 4.3
	CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 -380.0 -655.0 6.9 buddy
	CLEAR_CHAR_THREAT_SEARCH buddy
	SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0	
	SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
	SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
	SET_CHAR_NEVER_TARGETTED buddy TRUE
	ATTACH_CHAR_TO_CAR buddy fastest_boat -0.7 0.5 1.4 FACING_FORWARD 180.0 WEAPONTYPE_RUGER
	SET_CHAR_HEADING buddy 270.0
ENDIF

LOAD_MISSION_AUDIO 1 COK4_8	// FIXMIAMI: moved up
LOAD_MISSION_AUDIO 2 COK4_9	// FIXMIAMI: restore unused line
// FIXMIAMI: START
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE
// FIXMIAMI: END

WAIT 500

// ******************************END MEET BUDDY AT BOAT*********************************************

//RACE TO THE COKEBOAT************************************************************************************
IF IS_CAR_DEAD fastest_boat
	GOTO mission_baron4_failed
ELSE
	ADD_BLIP_FOR_CAR fastest_boat fastest_boat_blip 
	REMOVE_BLIP coke_boat_blip 
	WARP_PLAYER_INTO_CAR player1 fastest_boat
ENDIF

WHILE NOT IS_PLAYER_IN_CAR player1 fastest_boat
	WAIT 0

	IF IS_CAR_DEAD fastest_boat
		PRINT_NOW ( COK4_33 ) 5000 2 //You destoyed the boat!
		GOTO mission_baron4_failed
	ENDIF
	
	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_baron4_failed
	ENDIF

ENDWHILE

SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

CLEAR_AREA -274.6 -696.6 9.1 40.0 TRUE // FIXMIAMI: some random boats might be in there


REMOVE_BLIP coke_boat_blip
ADD_BLIP_FOR_COORD 324.0 604.0 6.0 coke_boat_blip

REMOVE_BLIP fastest_boat_blip

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

LOAD_SCENE -274.6 -696.6 9.1 
		
SET_FIXED_CAMERA_POSITION -275.577 -697.145 9.220 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -274.699 -696.673 9.139 JUMP_CUT

CREATE_CAR speeder -295.5 -685.8 5.6 coke_boat1
CREATE_CHAR_INSIDE_CAR coke_boat1 PEDTYPE_CIVMALE CBa boat_pilot1
SET_CAR_HEADING coke_boat1 270.0
BOAT_GOTO_COORDS coke_boat1 90.0 -664.2 5.6
SET_BOAT_CRUISE_SPEED coke_boat1 40.0

CREATE_CAR speeder -281.1 -737.5 5.6 coke_boat2
CREATE_CHAR_INSIDE_CAR coke_boat2 PEDTYPE_CIVMALE CBa boat_pilot2
SET_CAR_HEADING coke_boat2 330.0
BOAT_GOTO_COORDS coke_boat2 -116.7 -458.3 5.6
SET_BOAT_CRUISE_SPEED coke_boat2 40.0

DO_FADE 1500 FADE_IN // FIXMIAMI: moved down post camera change, spawns, clears, etc etc

WAIT 1000

CREATE_CAR speeder -291.8 -750.9 5.6 coke_boat3
CREATE_CHAR_INSIDE_CAR coke_boat3 PEDTYPE_CIVMALE CBa boat_pilot3
SET_CAR_HEADING coke_boat3 330.0
BOAT_GOTO_COORDS coke_boat3 -116.7 -458.3 5.6
SET_BOAT_CRUISE_SPEED coke_boat3 40.0

CREATE_CAR speeder -309.5 -686.4 5.6 coke_boat4
CREATE_CHAR_INSIDE_CAR coke_boat4 PEDTYPE_CIVMALE CBa boat_pilot4
SET_CAR_HEADING coke_boat4 270.0
BOAT_GOTO_COORDS coke_boat4 90.0 -664.2 5.6
SET_BOAT_CRUISE_SPEED coke_boat4 40.0

//IF HAS_MISSION_AUDIO_LOADED	1 // FIXMIAMI: we know it's loaded
	PLAY_MISSION_AUDIO 1 //We got some competition!
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // FIXMIAMI
		PRINT_NOW ( COK4_8 ) 5000 2	
		WAIT 0
	ENDWHILE // FIXMIAMI
//ENDIF // FIXMIAMI: we know it's loaded

// FIXMIAMI: START
WAIT 1000

PLAY_MISSION_AUDIO 2 //Take 'em out!
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	PRINT_NOW ( COK4_9 ) 5000 2	
	WAIT 0
ENDWHILE
// FIXMIAMI: END

//WAIT 2000 // FIXMIAMI: we wait for audio to finish now instead

PRINT_NOW ( COK4_28 ) 5000 2 //Get to the yacht before the other boats do!

WAIT 3000

IF NOT IS_CAR_DEAD fastest_boat
	SET_CAR_HEADING fastest_boat 270.0
	SET_CAR_PROOFS fastest_boat TRUE TRUE TRUE FALSE FALSE
ENDIF

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

IF IS_CAR_DEAD fastest_boat
	GOTO mission_baron4_failed
ENDIF


WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D Player1 324.0 604.0 6.0 40.0 40.0 20.0 FALSE
OR NOT IS_PLAYER_IN_CAR player1 fastest_boat 
	WAIT 0

	IF IS_CAR_DEAD fastest_boat
		GOTO mission_baron4_failed
	ELSE
		IF IS_CAR_UPSIDEDOWN fastest_boat
			IF NOT IS_CHAR_DEAD	buddy
				DETACH_CHAR_FROM_CAR buddy
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_baron4_failed
	ENDIF

	IF NOT IS_CHAR_DEAD boat_pilot1
		IF LOCATE_CHAR_ANY_MEANS_3D boat_pilot1 324.0 604.0 6.0 30.0 30.0 20.0 FALSE
			PRINT_NOW ( COK4_32 ) 5000 2 //Too slow!
			GOTO mission_baron4_failed
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD boat_pilot2
		IF LOCATE_CHAR_ANY_MEANS_3D boat_pilot2 324.0 604.0 6.0 30.0 30.0 20.0 FALSE
			PRINT_NOW ( COK4_32 ) 5000 2 //Too slow!
			GOTO mission_baron4_failed
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD boat_pilot3
		IF LOCATE_CHAR_ANY_MEANS_3D boat_pilot3 324.0 604.0 6.0 30.0 30.0 20.0 FALSE
			PRINT_NOW ( COK4_32 ) 5000 2 //Too slow!
			GOTO mission_baron4_failed
		ENDIF
	ENDIF
	  
	IF NOT IS_CHAR_DEAD boat_pilot4
		IF LOCATE_CHAR_ANY_MEANS_3D boat_pilot4 324.0 604.0 6.0 30.0 30.0 20.0 FALSE
			PRINT_NOW ( COK4_32 ) 5000 2 //Too slow!
			GOTO mission_baron4_failed
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD buddy 
		IF NOT IS_CAR_DEAD coke_boat1
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D buddy coke_boat1 20.0 20.0 FALSE
				SET_CHAR_OBJ_DESTROY_CAR buddy coke_boat1
				GOSUB play_vance_dance_samp 
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD buddy 
		IF NOT IS_CAR_DEAD coke_boat2
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D buddy coke_boat2 20.0 20.0 FALSE
				SET_CHAR_OBJ_DESTROY_CAR buddy coke_boat2
				GOSUB play_vance_dance_samp
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD buddy 
		IF NOT IS_CAR_DEAD coke_boat3
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D buddy coke_boat3 20.0 20.0 FALSE
				SET_CHAR_OBJ_DESTROY_CAR buddy coke_boat3
				GOSUB play_vance_dance_samp
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD buddy 
		IF NOT IS_CAR_DEAD coke_boat4
			IF LOCATE_CHAR_ANY_MEANS_CAR_2D buddy coke_boat4 20.0 20.0 FALSE
				SET_CHAR_OBJ_DESTROY_CAR buddy coke_boat4
				GOSUB play_vance_dance_samp
			ENDIF
		ENDIF
	ENDIF

	IF TIMERA > 100

		IF NOT IS_CAR_DEAD coke_boat1
		AND NOT IS_CHAR_DEAD boat_pilot1 // FIXMIAMI
			any_coke_boat = coke_boat1 
			GOSUB race_to_coke_deal1
		ENDIF
			
		IF NOT IS_CAR_DEAD coke_boat2
		AND NOT IS_CHAR_DEAD boat_pilot2 // FIXMIAMI
			any_coke_boat = coke_boat2
			GOSUB race_to_coke_deal2
		ENDIF

		IF NOT IS_CAR_DEAD coke_boat3
		AND NOT IS_CHAR_DEAD boat_pilot3 // FIXMIAMI
			any_coke_boat = coke_boat3
			GOSUB race_to_coke_deal2	
		ENDIF

		IF NOT IS_CAR_DEAD coke_boat4
		AND NOT IS_CHAR_DEAD boat_pilot4 // FIXMIAMI
			any_coke_boat = coke_boat4 
			GOSUB race_to_coke_deal1
		ENDIF

		TIMERA = 0
	ENDIF

	// FIXMIAMI: START
	IF IS_CHAR_DEAD boat_pilot1
	AND NOT IS_CAR_DEAD coke_boat1
		CAR_SET_IDLE coke_boat1
		SET_BOAT_CRUISE_SPEED coke_boat1 0.0
	ENDIF

	IF IS_CHAR_DEAD boat_pilot2
	AND NOT IS_CAR_DEAD coke_boat2
		CAR_SET_IDLE coke_boat2
		SET_BOAT_CRUISE_SPEED coke_boat2 0.0
	ENDIF

	IF IS_CHAR_DEAD boat_pilot3
	AND NOT IS_CAR_DEAD coke_boat3
		CAR_SET_IDLE coke_boat3
		SET_BOAT_CRUISE_SPEED coke_boat3 0.0
	ENDIF

	IF IS_CHAR_DEAD boat_pilot4
	AND NOT IS_CAR_DEAD coke_boat4
		CAR_SET_IDLE coke_boat4
		SET_BOAT_CRUISE_SPEED coke_boat4 0.0
	ENDIF
	// FIXMIAMI: END

	IF first_two_samples = 0
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK4_1	
			LOAD_MISSION_AUDIO 2 COK4_3	
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok4	
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //So Tommy, we know it was Diaz busted our deal..
			PRINT_NOW ( COK4_1 ) 5000 2	

			IF HAS_MISSION_AUDIO_FINISHED 1
				//WAIT 500
				PLAY_MISSION_AUDIO 2 //So why the hell are we running errands for him?
				PRINT_NOW ( COK4_3 ) 5000 2
				first_two_samples = 1
				audio_is_loading = 0
				audio_has_loaded  = 0
				TIMERB = 0		
			ENDIF
		ENDIF
	ENDIF

	IF first_two_samples = 1
	AND second_two_samples = 0
	AND TIMERB > 2500 // FIXMIAMI: change 2000 to 2500
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK4_4	
			LOAD_MISSION_AUDIO 2 COK4_5	
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok4
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //The more we learn now, the less we have to learn when we take this town over!
			PRINT_NOW ( COK4_4 ) 5000 2
			IF HAS_MISSION_AUDIO_FINISHED 1
				WAIT 500
				PLAY_MISSION_AUDIO 2 //I like your style, man. Real fresh.
				PRINT_NOW ( COK4_5 ) 5000 2
				second_two_samples = 1
				audio_is_loading = 0
				audio_has_loaded  = 0
				TIMERB = 0		
			ENDIF
		ENDIF
	ENDIF						   	
	
	IF LOCATE_PLAYER_ANY_MEANS_3D Player1 324.0 604.0 6.0 200.0 200.0 20.0 FALSE
		IF created_coke_boat = 0
			CREATE_CAR marquis 324.0 604.0 6.0 coke_boat
			SET_CAR_HEADING coke_boat 60.0
			ADD_BLIP_FOR_CAR coke_boat coke_boat_blip_arrow
			CHANGE_BLIP_DISPLAY coke_boat_blip_arrow MARKER_ONLY
			created_coke_boat = 1
		ENDIF

		IF created_coke_boat = 1
			IF IS_CAR_DEAD coke_boat
				PRINT_NOW ( COK4_33 ) 5000 2 //You destoyed the boat!
				GOTO mission_baron4_failed
			ENDIF
		ENDIF

	ENDIF

	IF IS_CAR_DEAD fastest_boat
		GOTO mission_baron4_failed
	ENDIF

ENDWHILE

REMOVE_BLIP coke_boat_blip
ADD_BLIP_FOR_COORD -366.6 -660.1 5.6 mansion_blip  

// ******************************START COKE DEAL ON BOAT*********************************************

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

IF NOT IS_CAR_DEAD fastest_boat
	SET_CAR_FORWARD_SPEED fastest_boat 7.0 // FIXMIAMI
	BOAT_STOP fastest_boat	
	SET_BOAT_CRUISE_SPEED fastest_boat 0.0
ENDIF

SET_FIXED_CAMERA_POSITION 278.740 579.153 26.070 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 279.551 579.660 25.780 JUMP_CUT

//WAIT 500 // FIXMIAMI: removed, waiting for mission audio now

LOAD_MISSION_AUDIO 1 COK4_11
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE
PLAY_MISSION_AUDIO 1
PRINT_NOW ( COK4_11 ) 5000 2 // We made it! Those other boats ain't VIP class.
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_PRINTS

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// FIXMIAMI: START
IF IS_CAR_DEAD coke_boat1
	CREATE_CAR speeder 301.3 476.9 5.6 coke_boat1
ENDIF
IF IS_CHAR_DEAD boat_pilot1
	CREATE_CHAR_INSIDE_CAR coke_boat1 PEDTYPE_CIVMALE CBa boat_pilot1
ENDIF
SET_CAR_COORDINATES coke_boat1 301.3 476.9 5.6
TURN_CAR_TO_FACE_COORD coke_boat1 333.3 598.9
SET_CAR_HEADING coke_boat1 40.0
SET_BOAT_CRUISE_SPEED coke_boat1 0.0
CAR_SET_IDLE coke_boat1

DELETE_CAR coke_boat2
DELETE_CHAR	boat_pilot2

IF IS_CAR_DEAD coke_boat3
	CREATE_CAR speeder 287.0 489.4 5.6 coke_boat3
ENDIF
IF IS_CHAR_DEAD boat_pilot3
	CREATE_CHAR_INSIDE_CAR coke_boat3 PEDTYPE_CIVMALE CBa boat_pilot3
ENDIF
SET_CAR_COORDINATES coke_boat3 287.0 489.4 5.6
TURN_CAR_TO_FACE_COORD coke_boat3 333.3 598.9
SET_BOAT_CRUISE_SPEED coke_boat3 0.0
CAR_SET_IDLE coke_boat3

DELETE_CAR coke_boat4
DELETE_CHAR	boat_pilot4
// FIXMIAMI: END


// FIXMIAMI: START restore the cutscene
IF NOT IS_CAR_DEAD fastest_boat
	IF IS_PLAYER_IN_CAR	player1 fastest_boat
		WARP_PLAYER_FROM_CAR_TO_COORD player1 261.3 542.6 -100.0//260.4 -1292.5 -100.0
	ELSE // FIXMIAMI
		SET_PLAYER_COORDINATES player1 261.3 542.6 -100.0 // FIXMIAMI
	ENDIF // FIXMIAMI
	ANCHOR_BOAT fastest_boat TRUE
	SET_CAR_HEALTH fastest_boat 1500
	SET_CAR_COORDINATES fastest_boat 333.3 598.9 6.0
	SET_CAR_HEADING fastest_boat 330.0
ENDIF
DELETE_CHAR	buddy

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1

SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy
LOAD_SPECIAL_MODEL CUTOBJ01 mfour
LOAD_SPECIAL_MODEL CUTOBJ02 delcase

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE

LOAD_CUTSCENE cok_4b
SET_CUTSCENE_OFFSET 329.6 596.6 6.14
CLEAR_AREA 329.6 596.6 6.14 15.0 TRUE

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 CS_buddy
SET_CUTSCENE_ANIM CS_buddy CSbuddy

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_mfour
CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_case2

ATTACH_CUTSCENE_OBJECT_TO_VEHICLE cs_player fastest_boat
ATTACH_CUTSCENE_OBJECT_TO_VEHICLE CS_buddy fastest_boat
ATTACH_CUTSCENE_OBJECT_TO_VEHICLE cs_mfour fastest_boat
ATTACH_CUTSCENE_OBJECT_TO_BONE cs_case2 cs_player BONE_R_HAND

DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 7628
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE
ATTACH_CUTSCENE_OBJECT_TO_BONE cs_case2 cs_player BONE_R_FOOT
PRINT_NOW ( COK4_W ) 10000 1 // Mission brief

WHILE cs_time < 9366
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE
PRINT_NOW ( COK4_X ) 10000 1 // Mission brief

WHILE cs_time < 10755
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE
PRINT_NOW ( COK4_Y ) 10000 1 // Mission brief

IF NOT IS_CAR_DEAD coke_boat1
	BOAT_GOTO_COORDS coke_boat1 333.3 598.9 6.0
	SET_BOAT_CRUISE_SPEED coke_boat1 20.0
ENDIF

IF NOT IS_CAR_DEAD coke_boat3
	BOAT_GOTO_COORDS coke_boat3 333.3 598.9 6.0
	SET_BOAT_CRUISE_SPEED coke_boat3 20.0
ENDIF

WHILE cs_time < 11721 
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE
ATTACH_CUTSCENE_OBJECT_TO_BONE cs_mfour cs_player BONE_R_HAND

WHILE cs_time < 12808
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE
CLEAR_PRINTS

WHILE cs_time < 14808
	GET_CUTSCENE_TIME cs_time
	WAIT 0
ENDWHILE

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_CUTSCENE

SWITCH_RUBBISH ON

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

IF NOT IS_CAR_DEAD fastest_boat
	ANCHOR_BOAT fastest_boat TRUE
ENDIF

// FIXMIAMI: START - moved down
REQUEST_MODEL sparrow
REQUEST_MODEL ruger
REQUEST_MODEL barrel4
REQUEST_MODEL TEC9
REQUEST_MODEL UZI
// FIXMIAMI: END

WHILE NOT HAS_MODEL_LOADED sparrow
OR NOT HAS_MODEL_LOADED ruger
OR NOT HAS_MODEL_LOADED barrel4
OR NOT HAS_MODEL_LOADED TEC9
OR NOT HAS_MODEL_LOADED UZI
	WAIT 0

ENDWHILE

RESTORE_CAMERA_JUMPCUT

//DELETE_CHAR	buddy // FIXMIAMI: moved up
CREATE_CHAR_INSIDE_CAR fastest_boat PEDTYPE_CIVMALE SPECIAL03 buddy
SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
CLEAR_CHAR_THREAT_SEARCH buddy
SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
ATTACH_CHAR_TO_CAR scplayer fastest_boat -0.8 0.3 1.7 FACING_BACK 181.0 WEAPONTYPE_RUGER
DISPLAY_ONSCREEN_COUNTER_WITH_STRING fastboat_health COUNTER_DISPLAY_BAR (COK4_35)
GOSUB fastboat_health

// ******************************END COKE DEAL ON BOAT*********************************************

// ******************************CHASE BACK TO MASION 1ST PERSON*********************************************

IF IS_CAR_DEAD coke_boat1
	CREATE_CAR speeder 326.3 570.9 5.6 coke_boat1
ENDIF
IF IS_CHAR_DEAD boat_pilot1
	CREATE_CHAR_INSIDE_CAR coke_boat1 PEDTYPE_CIVMALE CBa boat_pilot1
ENDIF
SET_CAR_COORDINATES coke_boat1 326.3 570.9 5.6
SET_CAR_HEADING coke_boat1 140.0
BOAT_GOTO_COORDS coke_boat1 286.2 482.0 5.6
SET_BOAT_CRUISE_SPEED coke_boat1 24.0
CREATE_CHAR PEDTYPE_CIVMALE CBa 354.4 595.0 9.2 boat_shooter1
ATTACH_CHAR_TO_CAR boat_shooter1 coke_boat1 -0.8 0.3 1.5 FACING_FORWARD 181.0 WEAPONTYPE_UZI
SET_CHAR_OBJ_DESTROY_CAR boat_shooter1 fastest_boat
SET_CAR_HEALTH coke_boat1 1000 

DELETE_CAR coke_boat2
DELETE_CHAR	boat_pilot2

IF IS_CAR_DEAD coke_boat3
	CREATE_CAR speeder 333.0 560.4 5.6 coke_boat3
ENDIF
IF IS_CHAR_DEAD boat_pilot3
	CREATE_CHAR_INSIDE_CAR coke_boat3 PEDTYPE_CIVMALE CBa boat_pilot3
ENDIF
SET_CAR_COORDINATES coke_boat3 333.0 560.4 5.6
SET_CAR_HEADING coke_boat3 140.0
BOAT_GOTO_COORDS coke_boat3 286.2 482.0 5.6
SET_BOAT_CRUISE_SPEED coke_boat3 24.0
CREATE_CHAR PEDTYPE_CIVMALE CBa 354.4 597.0 9.2 boat_shooter3
ATTACH_CHAR_TO_CAR boat_shooter3 coke_boat3 -0.8 0.3 1.5 FACING_FORWARD 181.0 WEAPONTYPE_UZI
SET_CHAR_OBJ_DESTROY_CAR boat_shooter3 fastest_boat
SET_CAR_HEALTH coke_boat3 1000

IF IS_CAR_DEAD coke_boat4
	CREATE_CAR speeder 292.0 130.2 5.6 coke_boat4
ENDIF
IF IS_CHAR_DEAD boat_pilot4
	CREATE_CHAR_INSIDE_CAR coke_boat4 PEDTYPE_CIVMALE CBa boat_pilot4
ENDIF
SET_CAR_COORDINATES coke_boat4 292.0 130.2 5.6
SET_CAR_HEADING coke_boat4 180.0
SET_BOAT_CRUISE_SPEED coke_boat4 0.0
CREATE_CHAR PEDTYPE_CIVMALE CBa 354.4 598.0 9.2 boat_shooter4
ATTACH_CHAR_TO_CAR boat_shooter4 coke_boat4 -0.8 0.3 1.5 FACING_FORWARD 181.0 WEAPONTYPE_UZI
SET_CHAR_OBJ_DESTROY_CAR boat_shooter4 fastest_boat
SET_CAR_HEALTH coke_boat4 1000


CREATE_CAR sparrow 473.9 90.0 65.0 heli_chopper
SET_CAR_HEADING heli_chopper 180.0
FREEZE_CAR_POSITION heli_chopper TRUE
SET_HELI_STABILISER heli_chopper TRUE
CREATE_CHAR_INSIDE_CAR heli_chopper PEDTYPE_CIVMALE CBa boat_pilot2

CREATE_CHAR PEDTYPE_CIVMALE CBa -370.4 -655.0 9.2 boat_pilot5
ATTACH_CHAR_TO_CAR boat_pilot5 heli_chopper 0.8 0.0 0.5 FACING_RIGHT 180.0 WEAPONTYPE_RUGER
									
HELI_GOTO_COORDS heli_chopper -231.6 -672.1 50.0 100

IF IS_CAR_DEAD fastest_boat
	GOTO mission_baron4_failed
ENDIF

REMOVE_BLIP coke_boat_blip_arrow
DELETE_CAR coke_boat
MARK_MODEL_AS_NO_LONGER_NEEDED marquis

SET_BOAT_CRUISE_SPEED fastest_boat 26.0
SET_CAR_COORDINATES fastest_boat 336.2 540.9 5.6
SET_CAR_HEADING fastest_boat 140.0
SET_CAR_PROOFS fastest_boat FALSE TRUE TRUE TRUE FALSE
SET_CHAR_PROOFS buddy FALSE TRUE TRUE TRUE FALSE
BOAT_GOTO_COORDS fastest_boat 286.2 482.0 5.6

WAIT 1500

DO_FADE 1500 FADE_IN

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF

PRINT_NOW ( COK4_34 ) 5000 2 //Take those boats out!

audio_is_loading = 0
audio_has_loaded = 0
first_two_samples = 0
second_two_samples = 0	
third_two_samples = 0

TIMERB = 0
										  
WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -378.5 -660.0 5.6 16.0 16.0 6.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD fastest_boat
		DETACH_CHAR_FROM_CAR scplayer
		EXPLODE_PLAYER_HEAD Player1
		GOTO mission_baron4_failed
	ELSE
		IF IS_CAR_UPSIDEDOWN fastest_boat
			DETACH_CHAR_FROM_CAR scplayer
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD fastest_boat
		IF NOT IS_CAR_IN_WATER fastest_boat
			IF IS_CAR_STOPPED fastest_boat 
				GET_CAR_HEALTH fastest_boat fastboat_health
				fastboat_health = fastboat_health - 1
				IF fastboat_health < 1
					fastboat_health = 1
				ENDIF 
				SET_CAR_HEALTH fastest_boat fastboat_health	
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD fastest_boat
			IF NOT IS_CAR_HEALTH_GREATER fastest_boat 250
				GET_CAR_HEALTH fastest_boat fastboat_health
				fastboat_health = fastboat_health - 1
				IF fastboat_health < 1
					fastboat_health = 1
				ENDIF 
				SET_CAR_HEALTH fastest_boat fastboat_health
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_baron4_failed
	ENDIF

	GOSUB fastboat_health

	IF TIMERA > 300

		IF NOT IS_CHAR_DEAD boat_pilot1
			IF NOT IS_CAR_DEAD coke_boat1
				IF IS_CHAR_DEAD boat_pilot3
					IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 coke_boat1 20.0 20.0 FALSE 
						SET_BOAT_CRUISE_SPEED coke_boat1 26.0
					ELSE
					   	SET_BOAT_CRUISE_SPEED coke_boat1 32.0
					ENDIF
				ENDIF
				any_coke_boat = coke_boat1
				GOSUB return_to_masion
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD coke_boat1
				SET_BOAT_CRUISE_SPEED coke_boat1 0.0
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD	boat_shooter1
			DETACH_CHAR_FROM_CAR boat_shooter1
		ENDIF

		IF NOT IS_CHAR_DEAD boat_pilot3
			IF NOT IS_CAR_DEAD coke_boat3
				IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 coke_boat3 20.0 20.0 FALSE 
					SET_BOAT_CRUISE_SPEED coke_boat3 26.0
				ELSE
				   	SET_BOAT_CRUISE_SPEED coke_boat3 32.0
				ENDIF
				any_coke_boat = coke_boat3
				GOSUB return_to_masion
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD coke_boat3
				SET_BOAT_CRUISE_SPEED coke_boat3 0.0
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD	boat_shooter3
			DETACH_CHAR_FROM_CAR boat_shooter3
		ENDIF

		IF NOT IS_CHAR_DEAD boat_pilot4
			IF NOT IS_CAR_DEAD coke_boat4
				IF TIMERB > 8000
					IF boat_goto_coords = 0
						BOAT_GOTO_COORDS coke_boat4 419.5 -21.8 5.6
						boat_goto_coords = 1
					ENDIF
					any_coke_boat = coke_boat4
					IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 coke_boat4 20.0 20.0 FALSE 
						SET_BOAT_CRUISE_SPEED coke_boat4 30.0
					ELSE
					   	SET_BOAT_CRUISE_SPEED coke_boat4 19.0
					ENDIF
					GOSUB return_to_masion
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD coke_boat4
				SET_BOAT_CRUISE_SPEED coke_boat4 0.0
			ENDIF
		ENDIF

		IF IS_CHAR_DEAD	boat_shooter4
			DETACH_CHAR_FROM_CAR boat_shooter4
		ENDIF

		IF NOT IS_CAR_DEAD fastest_boat
			any_coke_boat = fastest_boat
			GOSUB return_to_masion
		ENDIF

		IF second_two_samples = 1  //CHOPPER ATTACKS
			IF NOT IS_CAR_DEAD heli_chopper	 
				IF set_heli_chopper_off = 0
					FREEZE_CAR_POSITION heli_chopper FALSE
					SET_CAR_FORWARD_SPEED heli_chopper 20.0
					IF NOT IS_CHAR_DEAD boat_pilot5
						//SET_CHAR_WAIT_STATE boat_pilot5 WAITSTATE_SIT_IDLE 9999999999
						SET_CHAR_OBJ_DESTROY_CAR boat_pilot5 fastest_boat
						SET_CHAR_ACCURACY boat_pilot5 40
					ELSE
						DETACH_CHAR_FROM_CAR boat_pilot5
					ENDIF
					set_heli_chopper_off = 1
				ENDIF
				GET_PLAYER_COORDINATES Player1 player_X player_Y player_Z
				player_z = player_z + 10.0
				player_y = player_y - 4.0
				IF NOT IS_CHAR_DEAD	boat_pilot2
					HELI_GOTO_COORDS heli_chopper player_X player_Y player_Z 75
				ELSE
					HELI_GOTO_COORDS heli_chopper player_X player_Y player_Z 0
				ENDIF
			ENDIF
		ENDIF

		TIMERA = 0
	ENDIF

	IF first_two_samples = 0
		IF audio_is_loading = 0
			LOAD_MISSION_AUDIO 1 COK4_12	
			LOAD_MISSION_AUDIO 2 COK4_13	
			audio_is_loading = 1
		ELSE
			GOSUB audio_loaded_cok4	
		ENDIF

		IF audio_has_loaded = 1
			PLAY_MISSION_AUDIO 1 //Watch yourself, they're coming from all over!
			PRINT_NOW ( COK4_12 ) 5000 2	

			IF HAS_MISSION_AUDIO_FINISHED 1
				WAIT 500
				PLAY_MISSION_AUDIO 2 //Got 'em. Head for Diaz's as fast as you can!
				PRINT_NOW ( COK4_13 ) 5000 2
				first_two_samples = 1
				audio_is_loading = 0
				audio_has_loaded  = 0
				//TIMERB = 0		
			ENDIF
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_2D player1 416.0 -76.1 40.0 40.0 FALSE

		IF jetty_chars_created = 0
			IF NOT IS_CAR_DEAD fastest_boat

				CREATE_OBJECT barrel4 396.3 -178.9 6.4 cok4_barrel1
				CREATE_OBJECT barrel4 395.3 -184.6 6.4 cok4_barrel2
				
				CREATE_CHAR PEDTYPE_CIVMALE CBa 401.4 -171.0 6.6 jetty_char1
				SET_CHAR_STAY_IN_SAME_PLACE jetty_char1 TRUE
				SET_CHAR_OBJ_DESTROY_CAR jetty_char1 fastest_boat	
				SET_CHAR_THREAT_SEARCH jetty_char1 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS jetty_char1 Player1
				GIVE_WEAPON_TO_CHAR jetty_char1 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH jetty_char1 50

				CREATE_CHAR PEDTYPE_CIVMALE CBa 400.7 -177.8 6.6 jetty_char2
				SET_CHAR_STAY_IN_SAME_PLACE jetty_char2 TRUE
				SET_CHAR_OBJ_DESTROY_CAR jetty_char2 fastest_boat	
				SET_CHAR_THREAT_SEARCH jetty_char2 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS jetty_char2 Player1
				GIVE_WEAPON_TO_CHAR jetty_char2 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH jetty_char2 50

				CREATE_CHAR PEDTYPE_CIVMALE CBa 398.8 -190.8 6.6 jetty_char3
				SET_CHAR_STAY_IN_SAME_PLACE jetty_char3 TRUE
				SET_CHAR_OBJ_DESTROY_CAR jetty_char3 fastest_boat	
				SET_CHAR_THREAT_SEARCH jetty_char3 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS jetty_char3 Player1
				GIVE_WEAPON_TO_CHAR jetty_char3 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH jetty_char3 50

				CREATE_CHAR PEDTYPE_CIVMALE CBa 399.6 -183.9 6.6 jetty_char4
				SET_CHAR_STAY_IN_SAME_PLACE jetty_char4 TRUE
				SET_CHAR_OBJ_DESTROY_CAR jetty_char4 fastest_boat	
				SET_CHAR_THREAT_SEARCH jetty_char4 THREAT_PLAYER1
				CHAR_LOOK_AT_PLAYER_ALWAYS jetty_char4 Player1
				GIVE_WEAPON_TO_CHAR jetty_char4 WEAPONTYPE_TEC9 30000
				SET_CHAR_HEALTH jetty_char4 50

				jetty_chars_created = 1
			ENDIF
		ENDIF

		IF first_two_samples = 1
		AND second_two_samples = 0
			 
			IF audio_is_loading = 0
				LOAD_MISSION_AUDIO 1 COK4_20	
				audio_is_loading = 1
			ELSE
				GOSUB audio_loaded_cok4	
			ENDIF

			IF audio_has_loaded = 1
				PLAY_MISSION_AUDIO 1 //There are gunmen on that jetty!
				PRINT_NOW ( COK4_20 ) 3000 2	

				IF HAS_MISSION_AUDIO_FINISHED 1
					second_two_samples = 1
					audio_is_loading = 0
					audio_has_loaded  = 0
				ENDIF
			ENDIF
		ENDIF

	ENDIF

	IF NOT IS_CAR_DEAD coke_boat4
		IF LOCATE_PLAYER_ANY_MEANS_CAR_2D Player1 coke_boat4 65.0 65.0 FALSE

			IF second_two_samples = 1
			AND third_two_samples = 0
			 
				IF audio_is_loading = 0
					LOAD_MISSION_AUDIO 1 COK4_19	
					audio_is_loading = 1
				ELSE
					GOSUB audio_loaded_cok4	
				ENDIF

				IF audio_has_loaded = 1
					PLAY_MISSION_AUDIO 1 //More trouble up ahead!
					PRINT_NOW ( COK4_19 ) 2000 2	
					IF HAS_MISSION_AUDIO_FINISHED 1
						third_two_samples = 1
						audio_is_loading = 0
						audio_has_loaded  = 0
					ENDIF
				ENDIF
			ENDIF

		ENDIF
	ENDIF

	IF TIMERB > 6000
		IF first_two_samples = 1
			IF IS_PLAYER_SHOOTING Player1
			AND HAS_CAR_BEEN_DAMAGED_BY_WEAPON coke_boat3 WEAPONTYPE_RUGER
			
				IF eat_it_samp = 0		 
					IF audio_is_loading = 0
						LOAD_MISSION_AUDIO 2 COK4_16	
						audio_is_loading = 1
					ELSE
						GOSUB audio_loaded_cok4	
					ENDIF

					IF audio_has_loaded = 1
						PLAY_MISSION_AUDIO 2 //Eat it! EAT IT!
						PRINT_NOW ( COK4_16 ) 3000 2	

						IF HAS_MISSION_AUDIO_FINISHED 2
							eat_it_samp = 1
							audio_is_loading = 0
							audio_has_loaded  = 0
						ENDIF
					ENDIF
				ENDIF

			ENDIF
			
			IF IS_PLAYER_SHOOTING Player1
			AND HAS_CAR_BEEN_DAMAGED_BY_WEAPON coke_boat1 WEAPONTYPE_RUGER

				IF eat_it_samp = 1
					IF sleep_fish_samp = 0		 
						IF audio_is_loading = 0
							LOAD_MISSION_AUDIO 2 COK4_15	
							audio_is_loading = 1
						ELSE
							GOSUB audio_loaded_cok4	
						ENDIF

						IF audio_has_loaded = 1
							PLAY_MISSION_AUDIO 2 //Sleep with the fishes!
							PRINT_NOW ( COK4_15 ) 3000 2	

							IF HAS_MISSION_AUDIO_FINISHED 2
								sleep_fish_samp = 1
								audio_is_loading = 0
								audio_has_loaded  = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF

			ENDIF

			IF third_two_samples = 1
				IF IS_PLAYER_SHOOTING Player1
				AND HAS_CAR_BEEN_DAMAGED_BY_WEAPON coke_boat4 WEAPONTYPE_RUGER
					IF you_want_some_samp = 0		 
						IF audio_is_loading = 0
							LOAD_MISSION_AUDIO 2 COK4_14	
							audio_is_loading = 1
						ELSE
							GOSUB audio_loaded_cok4	
						ENDIF

						IF audio_has_loaded = 1
							PLAY_MISSION_AUDIO 2 //You want some of this?!
							PRINT_NOW ( COK4_14 ) 3000 2	
							DELETE_CHAR jetty_char1
							DELETE_CHAR jetty_char2
							DELETE_CHAR jetty_char3
							DELETE_CHAR jetty_char4
							DELETE_OBJECT cok4_barrel1
							DELETE_OBJECT cok4_barrel2
							IF HAS_MISSION_AUDIO_FINISHED 2
								you_want_some_samp = 1
								audio_is_loading = 0
								audio_has_loaded  = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF

			ENDIF
		ENDIF
	ENDIF

ENDWHILE

IF NOT IS_CAR_DEAD fastest_boat
	BOAT_STOP fastest_boat	
	SET_BOAT_CRUISE_SPEED fastest_boat 0.0
ENDIF

DO_FADE 1000 FADE_OUT

LOAD_MISSION_AUDIO 1 COK4_24
LOAD_MISSION_AUDIO 2 COK4_25

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_SCENE -372.7 -656.7 6.9

DELETE_CAR coke_boat1
DELETE_CAR coke_boat2
DELETE_CAR coke_boat3
DELETE_CAR coke_boat4
DELETE_CAR heli_chopper
DELETE_CHAR	boat_pilot1 
DELETE_CHAR boat_pilot3 
DELETE_CHAR boat_pilot4	
DELETE_CHAR	boat_pilot5
DELETE_CHAR boat_shooter1 
DELETE_CHAR boat_shooter3 
DELETE_CHAR boat_shooter4
DELETE_CHAR jetty_char1
DELETE_CHAR jetty_char2
DELETE_CHAR jetty_char3
DELETE_CHAR jetty_char4

CLEAR_AREA -366.1 -655.2 6.9 1.0 TRUE


//LANCE AND PLAYER SCRIPTED CUT***************************************************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

IF NOT IS_CAR_DEAD fastest_boat
	DETACH_CHAR_FROM_CAR scplayer
	SET_CAR_HEALTH fastest_boat 1000
	WAIT 0

	CLEAR_AREA -372.7 -656.7 6.9 1.0 TRUE
	SET_PLAYER_COORDINATES player1 -372.7 -656.7 6.9
	SET_PLAYER_HEADING player1 128.0
	SET_CAMERA_BEHIND_PLAYER
	
	IF NOT IS_CAR_DEAD fastest_boat								 
		SET_CAR_COORDINATES fastest_boat -378.5 -661.0 5.6
		SET_CAR_HEADING fastest_boat 90.0
	ENDIF
ENDIF

SET_FIXED_CAMERA_POSITION -367.062 -660.511 10.406 0.0 0.0 0.0 //Player on the pier
POINT_CAMERA_AT_POINT -368.000 -660.319 10.116 JUMP_CUT

WAIT 500

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_MISSION_AUDIO_LOADED	1
	WAIT 0
		
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( COK4_24 ) 5000 1 // Good shooting, my friend. You're a real, proper, grade A lunatic.

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
		
ENDWHILE

LOAD_MISSION_AUDIO 1 COK4_26

WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
		
ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( COK4_25 ) 5000 1 // Well, thank you

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	WAIT 0
		
ENDWHILE

LOAD_MISSION_AUDIO 2 COK4_27

WHILE NOT HAS_MISSION_AUDIO_LOADED	1
	WAIT 0
		
ENDWHILE

PLAY_MISSION_AUDIO 1
PRINT_NOW ( COK4_26 ) 5000 1 // See you around, Tommy.

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
		
ENDWHILE
	
WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
		
ENDWHILE

PLAY_MISSION_AUDIO 2
PRINT_NOW ( COK4_27 ) 5000 1 // Okay, Mr. Lance Vance Dance.
SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	WAIT 0
		
ENDWHILE

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

CLEAR_PRINTS

IF NOT IS_CAR_DEAD fastest_boat
	SET_BOAT_CRUISE_SPEED fastest_boat 50.0
	BOAT_GOTO_COORDS fastest_boat -354.3 -836.5 5.6
ENDIF

WAIT 3000

RESTORE_CAMERA_JUMPCUT

DELETE_CAR fastest_boat

GOTO mission_baron4_passed


 // Mission baron4 failed

mission_baron4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   
// mission baron4 passed

mission_baron4_passed:

flag_baron_mission4_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 10000 
REGISTER_MISSION_PASSED	COK_4
PLAYER_MADE_PROGRESS 1
CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup9
clothes9_created = 1
START_NEW_SCRIPT cloth8
REMOVE_BLIP baron_contact_blip
RETURN
		

// mission cleanup

mission_cleanup_baron4:

// FIXMIAMI: START
IF NOT IS_CAR_DEAD coke_boat1
	CAR_WANDER_RANDOMLY coke_boat1
ENDIF

IF NOT IS_CAR_DEAD coke_boat2
	CAR_WANDER_RANDOMLY coke_boat2
ENDIF

IF NOT IS_CAR_DEAD coke_boat3
	CAR_WANDER_RANDOMLY coke_boat3
ENDIF

IF NOT IS_CAR_DEAD coke_boat4
	CAR_WANDER_RANDOMLY coke_boat4
ENDIF
// FIXMIAMI: END

flag_player_on_mission = 0
GET_GAME_TIMER timer_mobile_start
MARK_MODEL_AS_NO_LONGER_NEEDED squalo
MARK_MODEL_AS_NO_LONGER_NEEDED speeder
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
MARK_MODEL_AS_NO_LONGER_NEEDED marquis
MARK_MODEL_AS_NO_LONGER_NEEDED CBa
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9
MARK_MODEL_AS_NO_LONGER_NEEDED sparrow
MARK_MODEL_AS_NO_LONGER_NEEDED ruger
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_CAR_AS_NO_LONGER_NEEDED heli_chopper
RELEASE_WEATHER
DETACH_CHAR_FROM_CAR scplayer
REMOVE_CHAR_ELEGANTLY buddy
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
UNLOAD_SPECIAL_CHARACTER 3
REMOVE_BLIP fastest_boat_blip
REMOVE_BLIP coke_boat_blip
REMOVE_BLIP mansion_blip
REMOVE_BLIP coke_boat_blip_arrow
CLEAR_ONSCREEN_COUNTER fastboat_health
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0
SET_THREAT_REACTION_RANGE_MULTIPLIER 0.0
REMOVE_SPHERE Sphere_cok4
MISSION_HAS_FINISHED
RETURN


play_vance_dance_samp:

	IF vance_dance_samp_play = 0
		IF second_two_samples = 1
		AND HAS_MISSION_AUDIO_FINISHED 2 // FIXMIAMI: fix audio overlap
			
			IF audio_is_loading = 0
				LOAD_MISSION_AUDIO 1 COK4_9a	
				audio_is_loading = 1
			ELSE
				IF HAS_MISSION_AUDIO_LOADED	1
					audio_has_loaded = 1
				ENDIF
			ENDIF

			IF audio_has_loaded = 1
				PLAY_MISSION_AUDIO 1 //It's time for the Lance Vance Dance!
				PRINT_NOW ( COK4_9a ) 5000 2	
				vance_dance_samp_play = 1
			ENDIF
			
		ENDIF
	ENDIF

RETURN


race_to_coke_deal1:	//constuction site route

	IF LOCATE_CAR_3D any_coke_boat 90.0 -664.2 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 160.1 -639.0 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 160.1 -639.0 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 221.3 -567.0 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 221.3 -567.0 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 405.1 -286.6 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 405.1 -286.6 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 410.1 -1.9 5.6  
	ENDIF
		
	IF LOCATE_CAR_3D any_coke_boat 410.1 -1.9 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 191.9 236.0 5.6  
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 191.9 236.0 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 238.1 324.6 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 238.1 324.6 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 244.9 434.8 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 244.9 434.8 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 319.1 520.7 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 319.1 520.7 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 323.5 596.6 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 323.5 596.6 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 323.5 596.6 5.6	
		SET_BOAT_CRUISE_SPEED any_coke_boat 1.0	 
	ENDIF

RETURN


race_to_coke_deal2:	//Golf club route

	IF LOCATE_CAR_3D any_coke_boat -116.7 -458.3 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 25.6 -275.0 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 25.6 -275.0 5.6 10.0 10.0 6.0 FALSE
		SET_BOAT_CRUISE_SPEED any_coke_boat 35.0
		BOAT_GOTO_COORDS any_coke_boat 130.2 -228.8 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 130.2 -228.8 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 221.3 -130.2 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 221.3 -130.2 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 221.0 56.5 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 221.0 56.5 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 248.0 183.5 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 248.0 183.5 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 192.6 242.7 5.6  
	ENDIF
		
	IF LOCATE_CAR_3D any_coke_boat 192.6 242.7 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 234.8 329.3 5.6  
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 234.8 329.3 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 245.7 436.0 5.6  
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 245.7 436.0 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 314.0 516.4 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 314.0 516.4 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 323.5 596.6 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 323.5 596.6 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 323.5 596.6 5.6	
		SET_BOAT_CRUISE_SPEED any_coke_boat 1.0	 
	ENDIF

RETURN


return_to_masion:

	IF LOCATE_CAR_3D any_coke_boat 286.2 482.0 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 237.4 427.9 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 237.4 427.9 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 230.3 315.9 5.6
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 230.3 315.9 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 192.3 233.3 5.6  
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 192.3 233.3 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 419.5 -21.8 5.6  
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 419.5 -21.8 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 396.8 -304.7 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 396.8 -304.7 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 212.3 -588.7 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 212.3 -588.7 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 197.1 -617.8 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 197.1 -617.8 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 154.5 -638.7 5.6 
	ENDIF

	IF LOCATE_CAR_3D any_coke_boat 154.5 -638.7 5.6 10.0 10.0 6.0 FALSE
		BOAT_GOTO_COORDS any_coke_boat 90.0 -664.2 5.6  
	ENDIF							

	IF LOCATE_CAR_3D any_coke_boat 90.0 -664.2 5.6 10.0 10.0 6.0 FALSE
		SET_BOAT_CRUISE_SPEED any_coke_boat 35.0
		BOAT_GOTO_COORDS any_coke_boat -378.5 -660.0 5.6  
	ENDIF

RETURN

audio_loaded_cok4:

IF HAS_MISSION_AUDIO_LOADED	1
AND HAS_MISSION_AUDIO_LOADED 2
	audio_has_loaded = 1
ENDIF

RETURN

fastboat_health:

	IF NOT IS_CAR_DEAD fastest_boat
		GET_CAR_HEALTH fastest_boat fastboat_health
		//SET_MAX_WANTED_LEVEL 0
		fastboat_health = fastboat_health / 15
	ENDIF

RETURN


}