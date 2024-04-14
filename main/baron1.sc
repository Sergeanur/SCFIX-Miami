MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************baron mission 1***************************************
// **************************************INSANE CHASE*****************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// The Chase

// Mission start stuff

GOSUB mission_start_baron1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_baron1_failed
ENDIF

GOSUB mission_cleanup_baron1

MISSION_END


// Variables for mission
{
LVAR_INT traitor traitors_objectives_complete roof_fires_created blow_up_crates_cut
LVAR_INT fake_player dumpster_cut cheating_biker player_too_close_to_traitor
LVAR_INT traitors_mate chase_moped cs_telly
LVAR_INT stunt_double roof_barrel1 roof_barrel2 roof_barrel1_fire roof_barrel2_fire
VAR_INT roof_barrel3_fire traitors_car abandon_upsidedown_car
VAR_FLOAT traitorX traitorY traitorZ

// ***************************************Mission Start***************************************

mission_start_baron1:

flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
SCRIPT_NAME baron1
WAIT 0

LOAD_MISSION_TEXT BARON1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0

WAIT 500

DO_FADE 1500 FADE_IN

traitors_objectives_complete = 0
traitorX = 391.6
traitorY = 251.2
traitorZ = 14.0
roof_fires_created = 0
blow_up_crates_cut = 0
dumpster_cut = 0
player_too_close_to_traitor = 0
abandon_upsidedown_car = 0

SET_EXTRA_COLOURS 8 FALSE

LOAD_MISSION_AUDIO 1 MONO10

SET_AREA_VISIBLE VIS_MANSION 

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdiaz
LOAD_SPECIAL_CHARACTER 3 dgoona
LOAD_SPECIAL_CHARACTER 4 dgoonc
LOAD_SPECIAL_MODEL CUTOBJ01 dcfan
LOAD_SPECIAL_MODEL CUTOBJ02 telly

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW

LOAD_SCENE -378.3 -591.9 25.8
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0

ENDWHILE

LOAD_UNCOMPRESSED_ANIM CSplay
LOAD_UNCOMPRESSED_ANIM csdiaz
LOAD_UNCOMPRESSED_ANIM dgoonc
LOAD_UNCOMPRESSED_ANIM dcfan
LOAD_UNCOMPRESSED_ANIM telly
LOAD_UNCOMPRESSED_ANIM dgoona

LOAD_CUTSCENE cok_1
CLEAR_AREA -378.6 -552.6 25.5 15.0 TRUE
CLEAR_AREA -379.0 -564.6 19.8 15.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_diaz
SET_CUTSCENE_ANIM cs_diaz csdiaz

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dgoona
SET_CUTSCENE_ANIM cs_dgoona dgoona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_dgoonc
SET_CUTSCENE_ANIM cs_dgoonc dgoonc

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_dcfan
SET_CUTSCENE_ANIM_TO_LOOP dcfan
SET_CUTSCENE_ANIM cs_dcfan dcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_telly
SET_CUTSCENE_ANIM cs_telly telly

CLEAR_AREA -379.2 -536.4 16.2 0.5 TRUE
SET_PLAYER_COORDINATES player1 -379.2 -536.4 16.2
SET_PLAYER_HEADING player1 0.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 13
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_A ) 10000 1 // Mission brief

WHILE cs_time < 5570
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_B ) 10000 1 // Mission brief

WHILE cs_time < 10037
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_C ) 10000 1 // Mission brief

WHILE cs_time < 11525
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_D ) 10000 1 // Mission brief

WHILE cs_time < 13845
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_E ) 10000 1 // Mission brief

WHILE cs_time < 19000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE -375.4 -595.8 25.75 0.05 0.05 0.05 0.2 0 0 0 30000
ENDIF

WHILE cs_time < 24070
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_F ) 10000 1 // Mission brief

WHILE cs_time < 27858
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_G ) 10000 1 // Mission brief

WHILE cs_time < 29027
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_H ) 10000 1 // Mission brief

WHILE cs_time < 34900
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_I ) 10000 1 // Mission brief

WHILE cs_time < 42260
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_J ) 10000 1 // Mission brief

WHILE cs_time < 45900
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( COK1_K ) 10000 1 // Mission brief

WHILE cs_time < 53576
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 54076
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
//SET_CAMERA_IN_FRONT_OF_PLAYER
SET_PED_DENSITY_MULTIPLIER 1.0
CLEAR_EXTRA_COLOURS FALSE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -379.2 -536.4 16.2

WAIT 500

DO_FADE 1500 FADE_IN

// START OF MISSION
 
PRINT_NOW ( COK1_10 ) 10000 1 //Go and find the traitor at his house
ADD_BLIP_FOR_COORD 380.3 247.4 10.0 baron_blip1

LOAD_SPECIAL_CHARACTER 5 SGc
REQUEST_MODEL bfinject
REQUEST_MODEL ruger
REQUEST_MODEL barrel4
REQUEST_MODEL faggio
REQUEST_MODEL faketarget
REQUEST_MODEL SGa

	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 5
	OR NOT HAS_MODEL_LOADED bfinject
	OR NOT HAS_MODEL_LOADED ruger
	OR NOT HAS_MODEL_LOADED barrel4
	OR NOT HAS_MODEL_LOADED faggio
	OR NOT HAS_MODEL_LOADED faketarget
		WAIT 0

	ENDWHILE

	WHILE NOT HAS_MODEL_LOADED SGa
		WAIT 0

	ENDWHILE

	
WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 380.3 247.4 10.0 3.0 3.0 3.0 TRUE
AND NOT LOCATE_PLAYER_ON_FOOT_3D player1 380.3 247.4 10.0 3.0 3.0 3.0 FALSE
	WAIT 0

ENDWHILE

REMOVE_BLIP baron_blip1

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 387.967 246.690 15.277 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 388.694 247.372 15.356 JUMP_CUT

PRINT_NOW ( COK1_11 ) 5000 1 //look through his window

WAIT 1600

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

ADD_BLIP_FOR_COORD traitorX traitorY traitorZ baron_blip1

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 traitorX traitorY traitorZ 1.0 1.0 2.0 TRUE
	WAIT 0

ENDWHILE

REMOVE_BLIP baron_blip1

CLEAR_AREA 370.99 256.28 18.4 3.0 TRUE

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 370.99 256.28 18.4 traitor
SHUT_CHAR_UP traitor TRUE
SET_CHAR_HEALTH traitor 600
CLEAR_CHAR_THREAT_SEARCH traitor
SET_CHAR_HEADING traitor 224.7
ADD_BLIP_FOR_CHAR traitor baron_blip1
SET_CHAR_OBJ_WAIT_ON_FOOT traitor
SET_CHAR_PERSONALITY traitor PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING traitor TRUE

SWITCH_CAR_GENERATOR gen_car55 0
CREATE_CAR faggio 376.9 477.0 11.2 chase_moped
SET_CAR_HEADING chase_moped	282.0

LOAD_MISSION_AUDIO 1 COK1_1
LOAD_MISSION_AUDIO 2 COK1_4

//CUT SCENE OF LOOKING IN TO BLOKES WINDOW***************************************************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_PLAYER_VISIBLE player1 FALSE
TURN_PLAYER_TO_FACE_CHAR player1 traitor



SET_FIXED_CAMERA_POSITION 391.533 250.984 16.481 0.0 0.0 0.0  //Look in window
POINT_CAMERA_AT_POINT 392.370 251.500 16.300 JUMP_CUT
TIMERB = 0

WHILE NOT TIMERB > 500
	WAIT 0
	 
ENDWHILE

SET_INTERPOLATION_PARAMETERS 5.0 1000
SET_FIXED_CAMERA_POSITION 391.533 250.984 16.481 0.0 0.0 0.0 //Turn right 
POINT_CAMERA_AT_POINT 392.496 250.785 16.300 INTERPOLATION

WHILE NOT TIMERB > 2000
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_bloke_at_window_cut
	ENDIF

ENDWHILE

SET_INTERPOLATION_PARAMETERS 5.0 1000
SET_FIXED_CAMERA_POSITION 391.533 250.984 16.481 0.0 0.0 0.0  //Turn left
POINT_CAMERA_AT_POINT 392.370 251.500 16.300 INTERPOLATION

WHILE NOT TIMERB > 3500
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_bloke_at_window_cut
	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD	traitor
	SET_INTERPOLATION_PARAMETERS 5.0 1000
	SET_FIXED_CAMERA_POSITION 391.533 250.984 16.481 0.0 0.0 0.0 //Look at traitor
	POINT_CAMERA_AT_POINT 390.645 251.287 16.578 INTERPOLATION
ENDIF

WHILE NOT TIMERB > 5500
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_bloke_at_window_cut
	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD traitor
	SET_CHAR_OBJ_RUN_TO_COORD traitor 373.0 257.4
	SET_CHAR_USE_PEDNODE_SEEK traitor FALSE 
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( COK1_1 ) 2000 1 //Oh shit 
ENDIF

WHILE NOT TIMERB > 6500
	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_bloke_at_window_cut
	ENDIF

ENDWHILE

skip_bloke_at_window_cut:

SET_PLAYER_COORDINATES player1 391.3 251.8 14.4 //Bottom of stairs
SET_PLAYER_HEADING player1 90.0
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_PLAYER_VISIBLE player1 TRUE

CREATE_OBJECT barrel4 347.5 417.4 20.6 roof_barrel1
CREATE_OBJECT barrel4 352.9 416.5 20.6 roof_barrel2

IF NOT IS_CHAR_DEAD traitor
	CLEAR_AREA 358.7 277.0 22.5 3.0 TRUE
	SET_CHAR_COORDINATES traitor 358.7 277.0 22.5
	SET_CHAR_HEADING traitor 247.0
	GIVE_WEAPON_TO_CHAR traitor WEAPONTYPE_RUGER 30000
	SET_CURRENT_CHAR_WEAPON traitor WEAPONTYPE_RUGER
ENDIF

PRINT_NOW ( COK1_7 ) 5000 2 //Don't let him get away!

TIMERB = 0

WHILE NOT LOCATE_CHAR_ANY_MEANS_3D scplayer 374.3 265.5 23.5 2.0 2.0 3.0 FALSE
	WAIT 0

		IF IS_CHAR_DEAD traitor
			PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
			GOTO mission_baron1_failed	
		ENDIF

		IF TIMERB > 60000
			PRINT_NOW ( TEX1_5 ) 5000 2 // He got away
			DELETE_CHAR	traitor
			GOTO mission_baron1_failed
		ENDIF

ENDWHILE			

FORCE_WEATHER WEATHER_SUNNY

//CUT SCENE OF BLOKE SHOOTING AT PLAYER********************************************************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 300000

IF NOT IS_CHAR_DEAD traitor
	SET_FIXED_CAMERA_POSITION 357.505 277.646 24.280 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT 358.296 277.044 24.171 JUMP_CUT
	SET_CHAR_STAY_IN_SAME_PLACE traitor TRUE
	CLEAR_CHAR_THREAT_SEARCH traitor
	SET_CHAR_OBJ_NO_OBJ scplayer
	SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0
		
	PLAY_MISSION_AUDIO 2
	PRINT_NOW ( COK1_4 ) 1000 1 //Loser! 	
	
	IF NOT IS_PLAYER_ON_ANY_BIKE Player1
		CLEAR_AREA 373.8 265.3 22.5 2.0 TRUE
		CREATE_CHAR PEDTYPE_CIVMALE null 373.8 265.3 22.5 stunt_double // SCFIX: was PEDTYPE_CIVFEMALE
		SET_CHAR_HEALTH stunt_double 1000
		SET_CHAR_SUFFERS_CRITICAL_HITS stunt_double FALSE
		CLEAR_CHAR_THREAT_SEARCH stunt_double
		SET_CHAR_PERSONALITY stunt_double PEDSTAT_TOUGH_GUY
		SET_CHAR_HEADING stunt_double 48.0
		SET_THREAT_REACTION_RANGE_MULTIPLIER 2.0
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT traitor stunt_double
		SET_PLAYER_COORDINATES Player1 349.4 278.0 18.6	//window ledge
	ELSE
		SET_PLAYER_COORDINATES Player1 373.7 265.5 22.5
		SET_PLAYER_HEADING Player1 50.0
		STORE_CAR_PLAYER_IS_IN Player1 cheating_biker
		SET_EVERYONE_IGNORE_PLAYER Player1 Off

		CREATE_OBJECT faketarget 371.6 267.7 22.0 fake_player
		SET_CHAR_ACCURACY traitor 100 
		SET_CHAR_OBJ_DESTROY_OBJECT traitor fake_player
	ENDIF
	
ENDIF

WAIT 500

IF NOT IS_PLAYER_ON_ANY_BIKE Player1
	IF NOT IS_CHAR_DEAD	stunt_double
		SET_CHAR_WAIT_STATE stunt_double WAITSTATE_PLAYANIM_DUCK 2000
		SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_DUCK 2000
   	ENDIF
ENDIF

IF IS_PLAYER_ON_ANY_BIKE Player1
	IF NOT IS_CAR_DEAD cheating_biker
		BURST_CAR_TYRE cheating_biker 0
		BURST_CAR_TYRE cheating_biker 1
		SET_CAR_HEALTH cheating_biker 350
	ENDIF
ENDIF

WAIT 1500

IF NOT IS_CHAR_DEAD traitor
	SET_CHAR_STAY_IN_SAME_PLACE traitor FALSE
	CLEAR_CHAR_THREAT_SEARCH traitor
	SET_THREAT_REACTION_RANGE_MULTIPLIER 1.0
	CLEAR_AREA 350.5 317.5 18.5 2.0 TRUE
	SET_CHAR_COORDINATES traitor 350.5 317.5 18.5
	SET_CHAR_OBJ_RUN_TO_COORD traitor 351.6 341.3
ENDIF

IF NOT IS_PLAYER_ON_ANY_BIKE Player1
	DELETE_CHAR stunt_double
	SET_PLAYER_COORDINATES Player1 373.8 265.3 22.4
	SET_PLAYER_HEADING Player1 48.0
ENDIF

SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

LOAD_MISSION_AUDIO 1 COK1_2
LOAD_MISSION_AUDIO 2 COK1_5

TIMERB = 0


WAIT 400

SET_PLAYER_CONTROL player1 ON

IF NOT IS_PLAYER_ON_ANY_BIKE Player1
	SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 0
	CLEAR_CHAR_WAIT_STATE scplayer
ENDIF

CLEAR_AREA 417.1 464.3 27.4 2.0 TRUE

IF NOT IS_CHAR_DEAD traitor
	CREATE_CAR bfinject 417.1 464.3 27.4 traitors_car
	SET_CAR_HEAVY traitors_car TRUE
ENDIF

CLEAR_AREA_OF_CARS 361.9 269.1 26.0 336.5 380.8 15.0
CLEAR_AREA_OF_CARS 334.4 381.4 26.0 383.9 478.7 15.0

// SCFIX: START
VAR_INT traitor_fell
traitor_fell = 0
// SCFIX: END

WHILE NOT IS_CHAR_IN_CAR traitor traitors_car
	WAIT 0

		IF IS_CAR_DEAD traitors_car
			PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
			GOTO mission_baron1_failed   
		ENDIF

		IF IS_CHAR_DEAD traitor
			PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
			GOTO mission_baron1_failed	
		ENDIF

		// SCFIX: START
		IF traitor_fell = 0
			IF dumpster_cut = 0
				GET_CHAR_COORDINATES traitor x y z
				IF z < 15.0
					traitor_fell = 1
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD traitor
				SET_CHAR_OBJ_SPRINT_TO_COORD traitor 368.4 478.6

				IF LOCATE_CHAR_ANY_MEANS_2D traitor 368.4 478.6 10.0 10.0 FALSE
					IF dumpster_cut = 0
						IF NOT IS_CAR_DEAD traitors_car
							SET_CAR_STRONG traitors_car TRUE
							SET_CAR_COORDINATES traitors_car 368.4 478.6 10.4
							CREATE_CHAR_INSIDE_CAR traitors_car PEDTYPE_GANG_STREET SGa traitors_mate
							GIVE_WEAPON_TO_CHAR traitors_mate WEAPONTYPE_RUGER 30000
							SET_CHAR_PERSONALITY traitors_mate PEDSTAT_TOUGH_GUY
							CLEAR_CHAR_THREAT_SEARCH traitors_mate
							SET_CAR_HEADING traitors_car 311.0
							SET_CAR_CRUISE_SPEED traitors_car 0.0
							//SET_CHAR_OBJ_RUN_TO_COORD traitor 375.5 471.4 //SKIP
							//SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
							SET_PLAYER_CONTROL player1 OFF
							SWITCH_WIDESCREEN ON
							SET_FIXED_CAMERA_POSITION 382.421 481.019 12.024 0.0 0.0 0.0 //JUMP ON TO DUMPSTER
							POINT_CAMERA_AT_POINT 381.675 480.371 12.177 JUMP_CUT
							dumpster_cut = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		// SCFIX: END

		IF NOT IS_CHAR_DEAD traitor
		AND traitor_fell = 0 // SCFIX

			IF traitors_objectives_complete = 0

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 351.6 341.3 18.0 1.0 1.0 5.0 FALSE //if at plank1a
					SET_CHAR_OBJ_RUN_TO_COORD traitor 351.6 347.0 // Goto plank1b
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 351.6 347.0 18.0 1.0 1.0 5.0 FALSE //if at plank1b
					SET_CHAR_OBJ_RUN_TO_COORD traitor 350.8 358.0
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 350.8 358.0 18.0 1.0 1.0 5.0 FALSE 
					SET_CHAR_OBJ_SPRINT_TO_COORD traitor 350.4 375.6 //Goto plank2a
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 350.4 375.6 18.0 1.0 1.0 5.0 FALSE //if at plank2a  
					SET_CHAR_OBJ_RUN_TO_COORD traitor 350.4 380.5 //Goto plank2b
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 350.4 380.5 19.5 1.0 1.0 5.0 FALSE //if at plank2b 
					SET_CHAR_OBJ_RUN_TO_COORD traitor 349.8 389.3 
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 349.8 389.3 18.0 1.0 1.0 5.0 FALSE
					SET_CHAR_OBJ_SPRINT_TO_COORD traitor 346.0 405.6
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 346.0 405.6 18.0 1.0 1.0 5.0 FALSE
					SET_CHAR_OBJ_SPRINT_TO_COORD traitor 349.9 415.8
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 349.9 415.8 18.0 1.0 1.0 5.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD traitor 355.1 423.7
					SET_CHAR_USE_PEDNODE_SEEK traitor FALSE	 
				ENDIF

				IF blow_up_crates_cut = 0
					IF TIMERB > 60000
						PRINT_NOW ( TEX1_5 ) 5000 2 // He got away
						DELETE_CHAR	traitor
						GOTO mission_baron1_failed
					ENDIF
				ENDIF

				IF LOCATE_CHAR_ANY_MEANS_3D traitor 355.1 423.7 20.6 1.0 1.0 5.0 FALSE
					IF LOCATE_PLAYER_ANY_MEANS_3D player1 355.1 423.7 20.6 10.0 11.0 7.0 FALSE
						IF HAS_MISSION_AUDIO_LOADED	2
							PLAY_MISSION_AUDIO 2
							PRINT_NOW ( COK1_5 ) 2000 1 //You better keep on running, asshole!
						ENDIF
						player_too_close_to_traitor = 1	
						blow_up_crates_cut = 1
					ENDIF

					IF blow_up_crates_cut = 0

					   	SET_CHAR_OBJ_WAIT_ON_FOOT traitor

						IF LOCATE_PLAYER_ANY_MEANS_3D player1 352.4 415.3 25.0 10.0 20.0 7.0 FALSE
							SET_PLAYER_CONTROL player1 OFF //BLOW UP BARRELS**************************************
							SWITCH_WIDESCREEN ON
							SET_FIXED_CAMERA_POSITION 357.699 429.507 19.518 0.0 0.0 0.0 
							POINT_CAMERA_AT_POINT 357.237 428.620 19.533 JUMP_CUT
							SET_CHAR_COORDINATES traitor 356.6 428.2 18.1
							SET_CHAR_HEADING traitor 158.0

							IF HAS_MISSION_AUDIO_LOADED	1 
								PLAY_MISSION_AUDIO 1
								PRINT_NOW ( COK1_2 ) 2000 1 //Too slow grandad
							ENDIF

							WAIT 600

							IF NOT IS_CHAR_DEAD	traitor
								SET_CHAR_ACCURACY traitor 100 
								SET_CHAR_OBJ_DESTROY_OBJECT traitor roof_barrel2
							ENDIF
							
							WAIT 500
							START_SCRIPT_FIRE 347.5 417.4 20.6 roof_barrel1_fire
							START_SCRIPT_FIRE 350.9 412.6 20.6 roof_barrel2_fire
							START_SCRIPT_FIRE 349.5 416.6 20.6 roof_barrel3_fire
							WAIT 900

							IF NOT IS_CHAR_DEAD	traitor
								SET_CHAR_OBJ_NO_OBJ traitor
								SET_CHAR_STAY_IN_SAME_PLACE traitor FALSE
								CLEAR_CHAR_THREAT_SEARCH traitor
								SET_CHAR_OBJ_SPRINT_TO_COORD traitor 366.0 444.6
								SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
							ENDIF
								SET_CHAR_HEADING scplayer 344.0
								SET_CAMERA_BEHIND_PLAYER
								RESTORE_CAMERA_JUMPCUT
								SET_PLAYER_CONTROL player1 ON
								SWITCH_WIDESCREEN OFF
								IF HAS_MISSION_AUDIO_LOADED	2
									PLAY_MISSION_AUDIO 2
									PRINT_NOW ( COK1_5 ) 2000 1 //You better keep on running, asshole!
								ENDIF
								blow_up_crates_cut = 1
								
						ENDIF
					ELSE
						IF NOT IS_CHAR_DEAD	traitor
							SET_CHAR_OBJ_SPRINT_TO_COORD traitor 360.4 432.9
							SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
						ENDIF	 
					ENDIF
				ENDIF

				IF NOT IS_CHAR_DEAD	traitor

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 366.0 444.6 19.7 1.0 1.0 5.0 FALSE
						SET_CHAR_OBJ_SPRINT_TO_COORD traitor 374.0 456.3 
						SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 374.0 456.3 19.7 1.0 1.0 5.0 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD traitor 374.2 465.8 
						SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 374.2 465.8 19.4 1.0 1.0 5.0 FALSE
						IF dumpster_cut = 0
							IF NOT IS_CAR_DEAD traitors_car
								SET_CAR_STRONG traitors_car TRUE
								SET_CAR_COORDINATES traitors_car 368.4 478.6 10.4
								CREATE_CHAR_INSIDE_CAR traitors_car PEDTYPE_GANG_STREET SGa traitors_mate
								GIVE_WEAPON_TO_CHAR traitors_mate WEAPONTYPE_RUGER 30000
								SET_CHAR_PERSONALITY traitors_mate PEDSTAT_TOUGH_GUY
								CLEAR_CHAR_THREAT_SEARCH traitors_mate
								SET_CAR_HEADING traitors_car 311.0
								SET_CAR_CRUISE_SPEED traitors_car 0.0
								SET_CHAR_OBJ_RUN_TO_COORD traitor 375.5 471.4 //SKIP
								SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
								SET_PLAYER_CONTROL player1 OFF
								SWITCH_WIDESCREEN ON
								SET_FIXED_CAMERA_POSITION 382.421 481.019 12.024 0.0 0.0 0.0 //JUMP ON TO DUMPSTER
								POINT_CAMERA_AT_POINT 381.675 480.371 12.177 JUMP_CUT
								dumpster_cut = 1
							ENDIF
						ENDIF
					ENDIF 

				ENDIF

			ENDIF

		ENDIF

		IF roof_fires_created = 1
		AND blow_up_crates_cut = 1
			IF NOT IS_CHAR_DEAD traitor
				IF LOCATE_CHAR_ANY_MEANS_3D traitor 355.1 423.7 20.6 1.0 1.0 5.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD traitor 366.0 444.6
				ENDIF
			ENDIF
		ENDIF

		IF player_too_close_to_traitor = 1
			IF NOT IS_CHAR_DEAD traitor
				IF LOCATE_CHAR_ANY_MEANS_3D traitor 355.1 423.7 20.6 1.0 1.0 5.0 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD traitor 366.0 444.6
				ENDIF
			ENDIF
		ENDIF

		IF HAS_OBJECT_BEEN_DAMAGED roof_barrel1
		OR HAS_OBJECT_BEEN_DAMAGED roof_barrel2
			IF roof_fires_created = 0
				IF blow_up_crates_cut = 0
					START_SCRIPT_FIRE 347.5 417.4 20.6 roof_barrel1_fire
					START_SCRIPT_FIRE 350.9 412.6 20.6 roof_barrel2_fire
					START_SCRIPT_FIRE 349.5 416.6 20.6 roof_barrel3_fire
					roof_fires_created = 1
					blow_up_crates_cut = 1
				ENDIF
			ENDIF				  
		ENDIF

		IF NOT IS_CHAR_DEAD	traitor 
			IF traitors_objectives_complete = 0		
				IF traitor_fell = 0 // SCFIX
					IF LOCATE_CHAR_ANY_MEANS_3D traitor 375.5 471.4 14.1 3.0 3.0 5.0 FALSE
						IF NOT IS_CAR_DEAD traitors_car
							SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER traitor traitors_car
							traitors_objectives_complete = 1
						ENDIF
					ENDIF
				// SCFIX: START
				ELSE
					IF LOCATE_CHAR_ANY_MEANS_3D traitor 368.4 478.6 10.4 3.0 3.0 5.0 FALSE
						IF NOT IS_CAR_DEAD traitors_car
							SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER traitor traitors_car
							traitors_objectives_complete = 1
						ENDIF
					ENDIF
				ENDIF
				// SCFIX: END
			ENDIF
		ENDIF

		IF IS_CAR_DEAD traitors_car
			PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
			GOTO mission_baron1_failed   
		ENDIF

ENDWHILE

SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
PRINT_NOW ( COK1_8 ) 15000 2 //Quick! Grab a car and follow him!

WAIT 2000

IF NOT IS_CHAR_DEAD	traitor
	IF NOT IS_CAR_DEAD traitors_car
		SHUT_CHAR_UP traitor FALSE
		SET_CHAR_OBJ_NO_OBJ traitor
		WARP_CHAR_FROM_CAR_TO_COORD traitor 349.4 278.0 18.6
		ATTACH_CHAR_TO_CAR traitor traitors_car 0.4 0.0 1.0 FACING_BACK 180.0 WEAPONTYPE_RUGER
		SET_CHAR_THREAT_SEARCH traitor THREAT_PLAYER1
		SET_CHAR_ACCURACY traitor 50
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT traitor player1
		SET_CHAR_RUNNING traitor TRUE

		IF NOT IS_CAR_DEAD traitors_car
			CAR_GOTO_COORDINATES traitors_car 541.1 482.6 10.8
			SET_CAR_CRUISE_SPEED traitors_car 18.0
			SET_CAR_DRIVING_STYLE traitors_car DRIVINGMODE_AVOIDCARS
		ENDIF

	ENDIF
ENDIF

TIMERA = 0

IF NOT IS_CHAR_DEAD	traitor
ENDIF

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 34.9 1086.8 14.5 20.0 20.0 10.0 FALSE
OR NOT LOCATE_CHAR_ANY_MEANS_3D traitor 34.9 1086.8 14.5 15.0 15.0 10.0 FALSE
	WAIT 0									 

		IF IS_CHAR_DEAD traitor
			PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
			GOTO mission_baron1_failed	
		ENDIF

		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 traitor 180.0 180.0 FALSE
			PRINT_NOW ( TEX1_5 ) 5000 2 // He got away
			GOTO mission_baron1_failed
		ENDIF

		IF NOT IS_CHAR_DEAD traitor

			IF NOT IS_CHAR_DEAD traitors_mate
				IF NOT IS_CAR_DEAD traitors_car
					IF NOT IS_CHAR_IN_CAR traitors_mate traitors_car
						DETACH_CHAR_FROM_CAR traitor
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT traitors_mate player1
					ENDIF
					IF IS_CAR_IN_WATER traitors_car
						DETACH_CHAR_FROM_CAR traitor
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD traitor
				IF NOT IS_CAR_DEAD traitors_car
					IF NOT IS_CHAR_IN_CAR traitor traitors_car
						IF NOT IS_CHAR_DEAD traitors_mate
							IF NOT IS_CHAR_IN_CAR traitors_mate traitors_car
								SET_CAR_CRUISE_SPEED traitors_car 0.0
							ENDIF
						ELSE
							SET_CAR_CRUISE_SPEED traitors_car 0.0
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CAR_DEAD traitors_car
				IF IS_PLAYER_IN_CAR player1 traitors_car
					IF NOT IS_CHAR_DEAD traitor
						DETACH_CHAR_FROM_CAR traitor
						IF NOT IS_CAR_DEAD traitors_car
							IF TIMERA > 1000
								SET_CHAR_RUNNING traitor TRUE
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER traitor traitors_car
								TIMERA = 0
							ENDIF
						ENDIF	
					ENDIF
				ENDIF
			ENDIF

			IF IS_CHAR_DEAD traitors_mate
				IF NOT IS_CAR_DEAD traitors_car
					DETACH_CHAR_FROM_CAR traitor
					IF IS_CAR_HEALTH_GREATER traitors_car 269
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER traitor traitors_car
						SET_CAR_CRUISE_SPEED traitors_car 0.0
					ELSE
						IF TIMERA > 1500
							SET_CHAR_RUNNING traitor TRUE
							SET_CHAR_OBJ_STEAL_ANY_CAR traitor
							TIMERA = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF
	
			IF abandon_upsidedown_car = 0
				IF NOT IS_CAR_DEAD traitors_car
					IF IS_CAR_UPSIDEDOWN traitors_car
						IF NOT IS_CHAR_IN_CAR traitor traitors_car
							DETACH_CHAR_FROM_CAR traitor
	  						SET_CHAR_OBJ_STEAL_ANY_CAR traitor
 						ELSE
							SET_CHAR_OBJ_LEAVE_CAR traitor traitors_car
						ENDIF
						abandon_upsidedown_car = 1
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CAR_DEAD traitors_car
				IF NOT IS_CAR_HEALTH_GREATER traitors_car 270

					SET_CAR_CRUISE_SPEED traitors_car 10.0
					DETACH_CHAR_FROM_CAR traitor
					IF IS_CHAR_IN_CAR traitor traitors_car
						SET_CHAR_OBJ_LEAVE_CAR traitor traitors_car
							
						WHILE IS_CHAR_IN_CAR traitor traitors_car
							WAIT 0

							IF IS_CHAR_DEAD traitor
								PRINT_NOW ( COK1_9 ) 5000 2 //Not supposed to kill him!
								GOTO mission_baron1_failed	
							ENDIF

							IF IS_CAR_DEAD traitors_car

							ENDIF
						ENDWHILE 
					ENDIF 
					
					IF IS_CHAR_IN_ANY_CAR traitor
						STORE_CAR_CHAR_IS_IN traitor traitors_car
						IF NOT IS_CAR_DEAD traitors_car
							CAR_GOTO_COORDINATES traitors_car 34.9 1086.8 14.5
							SET_CAR_DRIVING_STYLE traitors_car DRIVINGMODE_AVOIDCARS
						ENDIF
					ELSE
						IF TIMERA > 1500
							SET_CHAR_RUNNING traitor TRUE
							SET_CHAR_OBJ_STEAL_ANY_CAR traitor
							TIMERA = 0
						ENDIF
					ENDIF
				ENDIF
			ELSE

				IF IS_CHAR_IN_ANY_CAR traitor
					STORE_CAR_CHAR_IS_IN traitor traitors_car
					IF NOT IS_CAR_DEAD traitors_car
						CAR_GOTO_COORDINATES traitors_car 34.9 1086.8 14.5
						SET_CAR_DRIVING_STYLE traitors_car DRIVINGMODE_AVOIDCARS
					ENDIF
				ELSE
					IF TIMERA > 1500
						SET_CHAR_RUNNING traitor TRUE
						SET_CHAR_OBJ_STEAL_ANY_CAR traitor
						TIMERA = 0
					ENDIF
				ENDIF
	
			ENDIF

		ENDIF	

		IF NOT IS_CHAR_DEAD traitors_mate
			IF NOT IS_CAR_DEAD traitors_car
				IF IS_CHAR_IN_CAR traitors_mate	traitors_car
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 traitor 50.0 50.0 FALSE
						SET_CAR_CRUISE_SPEED traitors_car 34.0
						SET_CHAR_ACCURACY traitor 60
					ELSE
						SET_CAR_CRUISE_SPEED traitors_car 18.0
						SET_CHAR_ACCURACY traitor 50
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 541.1 482.6 10.8 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 527.9 974.9 17.6	 
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 527.9 974.9 17.6 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 455.1 1285.5 17.3	 
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 455.1 1285.5 17.3 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 266.2 1139.9 21.1	 
					ENDIF
				ENDIF
			ENDIF
   		ENDIF

		IF NOT IS_CHAR_DEAD traitor
			IF NOT IS_CAR_DEAD traitors_car
				IF IS_CHAR_IN_CAR traitor traitors_car
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 traitor 50.0 50.0 FALSE
						SET_CAR_CRUISE_SPEED traitors_car 34.0
					ELSE
						SET_CAR_CRUISE_SPEED traitors_car 20.0
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 541.1 482.6 10.8 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 527.9 974.9 17.6	 
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 527.9 974.9 17.6 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 455.1 1285.5 17.3	 
					ENDIF

					IF LOCATE_CHAR_ANY_MEANS_3D traitor 455.1 1285.5 17.3 8.0 8.0 6.0 FALSE
						CAR_GOTO_COORDINATES traitors_car 266.2 1139.9 21.1	 
					ENDIF
				ENDIF
			ENDIF
   		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D traitor 266.2 1139.9 21.1 8.0 8.0 6.0 FALSE
			IF NOT IS_CAR_DEAD traitors_car
				CAR_GOTO_COORDINATES traitors_car 34.9 1086.8 14.5
			ENDIF	 
		ENDIF

		IF HAS_OBJECT_BEEN_DAMAGED roof_barrel1
		OR HAS_OBJECT_BEEN_DAMAGED roof_barrel2
			IF roof_fires_created = 0
				START_SCRIPT_FIRE 347.5 417.4 20.6 roof_barrel1_fire
				START_SCRIPT_FIRE 350.9 412.6 20.6 roof_barrel2_fire
				START_SCRIPT_FIRE 349.5 416.6 20.6 roof_barrel3_fire
				roof_fires_created = 1
			ENDIF
		ENDIF

ENDWHILE

SET_PLAYER_CONTROL player1 OFF

WAIT 0

SWITCH_WIDESCREEN ON

IF NOT IS_CHAR_DEAD	traitor
	IF IS_CHAR_IN_ANY_CAR traitor
		WARP_CHAR_FROM_CAR_TO_COORD traitor 56.4 1081.1 15.0		
	ENDIF

	DETACH_CHAR_FROM_CAR traitor
	CLEAR_CHAR_THREAT_SEARCH traitor
	SET_CHAR_OBJ_NO_OBJ traitor
	SET_CHAR_COORDINATES traitor 56.4 1081.1 15.0 
	SET_CHAR_HEADING traitor 275.0  
	SET_CHAR_OBJ_RUN_TO_COORD traitor 72.4 1082.8
	SET_CHAR_USE_PEDNODE_SEEK traitor FALSE
ENDIF

SET_FIXED_CAMERA_POSITION 79.834 1069.695 14.212 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT 79.273 1070.427 14.597 JUMP_CUT

WAIT 3000

DELETE_CHAR traitor

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
 
GOTO mission_baron1_passed


 // Mission baron1 failed

mission_baron1_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission baron1 passed

mission_baron1_passed:

flag_baron_mission1_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000 
REGISTER_MISSION_PASSED	COK_1
PLAYER_MADE_PROGRESS 1
stubby_in_stock = 1
katana_in_stock = 1
START_NEW_SCRIPT baron_mission2_loop
RETURN
		


// mission cleanup

mission_cleanup_baron1:
GET_GAME_TIMER timer_mobile_start
REMOVE_BLIP baron_blip1
MARK_MODEL_AS_NO_LONGER_NEEDED bfinject
MARK_MODEL_AS_NO_LONGER_NEEDED ruger
MARK_MODEL_AS_NO_LONGER_NEEDED barrel4
MARK_MODEL_AS_NO_LONGER_NEEDED faggio
MARK_MODEL_AS_NO_LONGER_NEEDED faketarget
MARK_MODEL_AS_NO_LONGER_NEEDED sga
MARK_CAR_AS_NO_LONGER_NEEDED traitors_car
MARK_CHAR_AS_NO_LONGER_NEEDED traitor
MARK_CHAR_AS_NO_LONGER_NEEDED traitors_mate
UNLOAD_SPECIAL_CHARACTER 5
SET_THREAT_REACTION_RANGE_MULTIPLIER 0.0
SWITCH_CAR_GENERATOR gen_car55 101
IF NOT IS_CAR_DEAD traitors_car
	SET_CAR_STRONG traitors_car FALSE
ENDIF
flag_player_on_mission = 0
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
RELEASE_WEATHER
DELETE_CHAR stunt_double
MARK_OBJECT_AS_NO_LONGER_NEEDED roof_barrel1 
MARK_OBJECT_AS_NO_LONGER_NEEDED roof_barrel2 
REMOVE_ALL_SCRIPT_FIRES
MISSION_HAS_FINISHED
RETURN


}