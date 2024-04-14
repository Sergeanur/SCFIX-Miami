MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Porn 4******************************************
// *****************************************Sky at Night************************************
// *****************************************************************************************
// *****************************************************************************************
//	G - spotlight	G-spotlight
SCRIPT_NAME porno4
// Mission start stuff
GOSUB mission_start_porn4
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_porn4
ENDIF
GOSUB mission_cleanup_porn4
MISSION_END
{ 
// Variables for mission
//people
VAR_INT bottom_office1
VAR_INT bottom_office2
VAR_INT bottom_office3
VAR_INT bottom_office4
VAR_INT bottom_office5
VAR_INT bottom_office6
VAR_INT top_office1
VAR_INT top_office2
VAR_INT top_office3
VAR_INT top_office4
VAR_INT top_office5
VAR_INT top_office6
VAR_INT top_office7
VAR_INT top_office8
VAR_INT lift_office1
VAR_INT lift_office2
VAR_INT players_lift_vehicle
VAR_INT spotlight_shining_onto_wall 
VAR_INT prawn_bike
VAR_INT door_guard

//blips
VAR_INT lift_blip
VAR_INT searchlight_blip
VAR_INT bike_blip
VAR_INT gate_blip
VAR_INT window_blip
VAR_INT corona_blip

//flags
VAR_INT porn4_goals
VAR_INT create_bottom_office_workers
VAR_INT create_top_office_workers
VAR_INT setting_player_upstairs
VAR_INT time_to_fail
VAR_INT create_bike_on_prawn_island
VAR_INT watched_jump_cutscene
VAR_INT jump_flag
VAR_INT hours
VAR_INT minutes	
VAR_INT ladder_down  //not to be zero'd at start 
VAR_INT ladder2_down
VAR_FLOAT x_axis_ladder

// ****************************************Mission Start************************************
mission_start_porn4:

CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PORN4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 21.489 966.28 9.5 172.7
// *************************************Set Flags/variables*********************************
porn4_goals = 0
create_bottom_office_workers = 0
create_top_office_workers = 0
setting_player_upstairs = 0
time_to_fail = 0
create_bike_on_prawn_island = 1
watched_jump_cutscene = 0
button_pressed = 0
jump_flag = 0
collision_counter_usj = 0
// ****************************************START OF CUTSCENE********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSdirec
LOAD_SPECIAL_CHARACTER 3 CSCandy
LOAD_SPECIAL_CHARACTER 4 cmraman
LOAD_SPECIAL_CHARACTER 5 mporna

LOAD_SPECIAL_MODEL CUTOBJ01 cs_cam
LOAD_SPECIAL_MODEL CUTOBJ02 drchair

LOAD_SCENE -86.0 929.0 9.764

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE
		 
LOAD_CUTSCENE porn_4
SET_CUTSCENE_OFFSET -69.128 920.965 9.764
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_direc
SET_CUTSCENE_ANIM cs_direc CSdirec

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_candy
SET_CUTSCENE_ANIM cs_candy CSCandy

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_cmraman
SET_CUTSCENE_ANIM cs_cmraman cmraman

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_mporna
SET_CUTSCENE_ANIM cs_mporna mporna

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_camera
SET_CUTSCENE_ANIM cs_camera cs_cam 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drchair
SET_CUTSCENE_ANIM cs_drchair drchair 

CLEAR_AREA -66.0 933.04 10.2 1.0 TRUE
SET_PLAYER_COORDINATES player1 -66.0 933.04 10.2
SET_PLAYER_HEADING player1 275.6

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

IF NOT IS_AUSTRALIAN_GAME
AND NOT IS_JAPANESE_GAME
	WHILE cs_time < 47  //FIRST CUTSCENE TIME GOES HERE
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE
	 
	PRINT_NOW POR4_A 10000 1 // I'm sorry, but I just can't swallow this right now.

	WHILE cs_time < 1741
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_B 10000 1 // Oh COME ON darling!  

	WHILE cs_time < 3291
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_C 10000 1 // He's hung like a sperm whale for pity's sake,

	WHILE cs_time < 5700
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_D 10000 1 // how can you not feel the part?!

	WHILE cs_time < 7244
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_E 10000 1 // But Stevie... 

	WHILE cs_time < 9917
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_F 10000 1 // How's my star director?

	WHILE cs_time < 10414
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_G 10000 1 // Oh man. The struggle between artistic integrity and

	WHILE cs_time < 13409
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_H 10000 1 // humping, pumping action continues unabated.

	WHILE cs_time < 16161
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_I 10000 1 //And before you ask, yes, all four videos will be released by their...

	WHILE cs_time < 19667
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_J 10000 1 //Honey, can you PLEASE keep the anaconda in the shot,

	WHILE cs_time < 22706
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_K 10000 1 //he costs more per hour than you do!

	WHILE cs_time < 24572
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_L 10000 1 //Oh, sorry Steve.

	WHILE cs_time < 25843
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_M 10000 1 //I was thinking, we need some kind of big stunt to really promote the launch.

	WHILE cs_time < 29291
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_N 10000 1 //Something that will make a real impact on the City - any ideas?

	WHILE cs_time < 34272
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_O 10000 1 //In the old days a film launch used to have a gala events,

	WHILE cs_time < 37360
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_P 10000 1 //stars, limos, the night sky crisscrossed with search lights...

	WHILE cs_time < 42492
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_Q 10000 1 //Search lights?  I've got an idea...

	WHILE cs_time < 45162
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_R 10000 1 //...yeah, yeah, yeah. little sequined numbers, and limos, the premiers

	WHILE cs_time < 50224
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_S 10000 1 //Oh, yes ma'am, of course ma'am,

	WHILE cs_time < 53220
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	DO_FADE 3000 FADE_OUT

	PRINT_NOW POR4_T 10000 1 //and the press, and the barrage of lights...

	WHILE cs_time < 54220
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	CLEAR_PRINTS

	WHILE cs_time < 56064
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

ELSE

	WHILE cs_time < 194
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_F 10000 1 // How's my star director?

	WHILE cs_time < 1394
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_G 10000 1 // Oh man. The struggle between artistic integrity and

	WHILE cs_time < 4344
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_H 10000 1 // humping, pumping action continues unabated.

	WHILE cs_time < 7178
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_I 10000 1 //And before you ask, yes, all four videos will be released by their...

	WHILE cs_time < 10656
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_J 10000 1 //Honey, can you PLEASE keep the anaconda in the shot,

	WHILE cs_time < 13704
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_K 10000 1 //he costs more per hour than you do!

	WHILE cs_time < 15550
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_L 10000 1 //Oh, sorry Steve.

	WHILE cs_time < 16828
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_M 10000 1 //I was thinking, we need some kind of big stunt to really promote the launch.

	WHILE cs_time < 20256 
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_N 10000 1 //Something that will make a real impact on the City - any ideas?

	WHILE cs_time < 25295
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_O 10000 1 //In the old days a film launch used to have a gala events,

	WHILE cs_time < 28750
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_P 10000 1 //stars, limos, the night sky crisscrossed with search lights...

	WHILE cs_time < 33584
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	PRINT_NOW POR4_Q 10000 1 //Search lights?  I've got an idea...

	WHILE cs_time < 36184
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE

	DO_FADE 3000 FADE_OUT

ENDIF

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
LOAD_SCENE -67.000 939.297 10.940
SET_TIME_OF_DAY 17 0  
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000

REQUEST_MODEL HFYBU
REQUEST_MODEL WFYBU
REQUEST_MODEL WMYBU
REQUEST_MODEL WMOBU

REQUEST_MODEL pcj600
REQUEST_MODEL GDa

WHILE NOT HAS_MODEL_LOADED HFYBU 
OR NOT HAS_MODEL_LOADED WFYBU
OR NOT HAS_MODEL_LOADED WMYBU
OR NOT HAS_MODEL_LOADED WMOBU
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED pcj600 
OR NOT HAS_MODEL_LOADED GDa 
	WAIT 0
ENDWHILE

GOTO porn4_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD -483.5 853.0 9.9 gate_blip
	ADD_BLIP_FOR_COORD -526.2 886.2 70.0 corona_blip
porn4_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

CREATE_CAR pcj600 -6.4 957.1 9.4 prawn_bike
CREATE_CHAR PEDTYPE_CIVMALE GDa 0.3 958.3 9.9 door_guard

DO_FADE 1500 FADE_IN

PRINT_NOW ( POR4_01 ) 5000 1 //Go Downtown and adjust the spotlight on top of the building.
PRINT ( POR4_02 ) 5000 1 //A fast bike will be needed to jump from roof to roof.  The Security Guard usually drives a PCJ 600 to work...

ADD_BLIP_FOR_COORD 6.8 953.5 9.4 bike_blip  



porn4_main_loop:
WAIT 0



//blippage
IF porn4_goals = 0
OR porn4_goals = 2
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -487.9 837.7 10.0 5.0 5.0 5.0 TRUE
// ******************************************START OF CUTSCENE - Showing player initial complex**************************************************
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON
		STORE_CLOCK

		SET_FIXED_CAMERA_POSITION -456.4 851.2 25.9 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT -499.2 837.7 11.1 JUMP_CUT

		CLEAR_PRINTS
		
		timera = 0
		button_pressed = 0 // SCFIX: fix skips not working
		WHILE timera < 1000
			WAIT 0
			IF IS_BUTTON_PRESSED PAD1 CROSS
				IF button_pressed = 1
					button_pressed = 0
					GOTO end_cut_porn4_1
				ENDIF
			ELSE
				IF button_pressed = 0
					button_pressed = 1
				ENDIF
			ENDIF
		ENDWHILE 

		PRINT_NOW ( POR4_05 ) 5000 1 //These stairs will lead round to a lower office.

		timera = 0
		button_pressed = 0 // SCFIX: fix skips not working
		WHILE timera < 5000
			WAIT 0
			IF IS_BUTTON_PRESSED PAD1 CROSS
				IF button_pressed = 1
					button_pressed = 0
					GOTO end_cut_porn4_1
				ENDIF
			ELSE
				IF button_pressed = 0
					button_pressed = 1
				ENDIF
			ENDIF
		ENDWHILE 

		end_cut_porn4_1:
		CLEAR_PRINTS
		RESTORE_CAMERA_JUMPCUT
		SET_PLAYER_CONTROL player1 ON
		RESTORE_CLOCK
		SWITCH_WIDESCREEN OFF
// ******************************************END OF CUTSCENE - Showing player initial complex****************************************************
		REMOVE_BLIP bike_blip
		REMOVE_BLIP gate_blip
		porn4_goals = 3
	ENDIF
ENDIF

IF porn4_goals = 1
	REMOVE_BLIP bike_blip
	ADD_BLIP_FOR_COORD -487.9 837.7 10.0 gate_blip
	porn4_goals = 2
ENDIF

IF porn4_goals = 3	 
	ADD_BLIP_FOR_COORD -562.7 782.7 22.4 lift_blip
	porn4_goals = 4
ENDIF

IF porn4_goals = 5	 
	ADD_BLIP_FOR_COORD -528.2 774.5 98.0 window_blip
	porn4_goals = 6
ENDIF



//cutscene showing first jump
IF porn4_goals = 6
	IF watched_jump_cutscene = 0
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -528.2 774.5 98.0 5.0 5.0 5.0 TRUE
	// ******************************************START OF CUTSCENE - Showing first jump******************************************************
			REMOVE_BLIP window_blip
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			STORE_CLOCK

			SET_FIXED_CAMERA_POSITION -531.8 817.6 99.1 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -532.3 825.6 98.7 JUMP_CUT

			SET_PLAYER_COORDINATES player1 -537.3 897.3 67.4
			SET_PLAYER_HEADING player1 4.5  

			CLEAR_PRINTS

			WAIT 500
					
			PRINT_NOW ( POR4_08 ) 5000 1 //Smash through the window to start the course.  You have until 07:00 before it gets too light to get up there unseen.

			timera = 0
			button_pressed = 0 // SCFIX: fix skips not working
			WHILE timera < 5000
				WAIT 0
				IF IS_BUTTON_PRESSED PAD1 CROSS
					IF button_pressed = 1
						button_pressed = 0
						GOTO end_cut_porn4_2
					ENDIF
				ELSE
					IF button_pressed = 0
						button_pressed = 1
					ENDIF
				ENDIF
			ENDWHILE 

			SET_FIXED_CAMERA_POSITION -530.2 825.27 98.4 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -529.6 901.06 72.1 JUMP_CUT
			
			PRINT_NOW ( POR4_09 ) 5000 1 //The pickups will show you which building to jump to next.
			
			timera = 0
			button_pressed = 0 // SCFIX: fix skips not working
			WHILE timera < 5000
				WAIT 0
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 -526.2 886.2 70.0 10.0 10.0 10.0 TRUE
					//ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				ENDIF
				//DRAW_CORONA -526.2 886.2 70.0 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
				IF IS_BUTTON_PRESSED PAD1 CROSS
					IF button_pressed = 1
						button_pressed = 0
						GOTO end_cut_porn4_2
					ENDIF
				ELSE
					IF button_pressed = 0
						button_pressed = 1
					ENDIF
				ENDIF
			ENDWHILE 
			

			end_cut_porn4_2:
			CLEAR_PRINTS
			SET_PLAYER_COORDINATES player1 -528.2 774.5 96.5
			SET_PLAYER_HEADING player1 4.5
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CLOCK
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
	// ******************************************END OF CUTSCENE - Showing first jump********************************************************
			porn4_goals = 7
			watched_jump_cutscene = 1
		ENDIF
	ENDIF
	REMOVE_BLIP window_blip
	REMOVE_BLIP corona_blip
	ADD_BLIP_FOR_COORD -526.2 886.2 70.0 corona_blip
ENDIF

IF porn4_goals = 7 //jump through window (with slo-mo)

	//DRAW_CORONA -526.2 886.2 70.0 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -526.2 886.2 70.0 10.0 10.0 10.0 TRUE
		//ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -552.6 1074.7 52.4 corona_blip
		porn4_goals = 8
	ENDIF
ENDIF

IF porn4_goals = 8 //jump down onto 1st roof

	//DRAW_CORONA -552.6 1074.7 52.4 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -552.6 1074.7 52.4 15.0 15.0 15.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -645.7 1129.7 29.1 corona_blip
		porn4_goals = 9
	ENDIF
ENDIF

IF porn4_goals = 9 //jump down onto lower roof

	//DRAW_CORONA -645.7 1129.7 29.1 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -645.7 1129.7 29.1 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -695.5 1130.3 32.6 corona_blip
		porn4_goals = 10
	ENDIF
ENDIF

IF porn4_goals = 10 //steep ramp

	//DRAW_CORONA -695.5 1130.3 32.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -695.5 1130.3 32.6 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -800.6 1141.7 25.6 corona_blip
		porn4_goals = 11
	ENDIF
ENDIF

IF porn4_goals = 11 //double jump

	//DRAW_CORONA -800.6 1141.7 25.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -800.6 1141.7 25.6 20.0 20.0 20.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -840.1 1194.3 16.7 corona_blip
		porn4_goals = 12
	ENDIF
ENDIF

IF porn4_goals = 12 //long jump

	//DRAW_CORONA -840.1 1194.3 16.7 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -840.1 1194.3 16.7 10.0 10.0 10.0 TRUE
		//ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -792.4 1299.2 27.9 corona_blip
		porn4_goals = 13
	ENDIF
ENDIF

IF porn4_goals = 13 //small jump after double set of stairs 

	//DRAW_CORONA -792.4 1299.2 27.9 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -792.4 1299.2 27.9 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -710.1 1302.5 20.6 corona_blip
		porn4_goals = 14
	ENDIF
ENDIF

IF porn4_goals = 14 //jump onto wills roof 

	//DRAW_CORONA -710.1 1302.5 20.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -710.1 1302.5 20.6 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -681.8 1338.8 24.3 corona_blip
		porn4_goals = 15
	ENDIF
ENDIF

IF porn4_goals = 15 //jump from wills roof 

	//DRAW_CORONA -681.8 1338.8 24.3 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -681.8 1338.8 24.3 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -573.5 1365.4 16.6 corona_blip
		porn4_goals = 16
	ENDIF
ENDIF

IF porn4_goals = 16 //jump from ten-pin bowling building 

	//DRAW_CORONA -573.5 1365.4 16.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -573.5 1365.4 16.6 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -482.0 1355.7 24.7 corona_blip
		porn4_goals = 17
	ENDIF
ENDIF

IF porn4_goals > 16 //jump from ten-pin bowling building
	IF IS_PLAYER_STOPPED player1 
		IF ladder_down = 0 
// ******************************************START OF CUTSCENE - CREATING FLIP DOWN LADDER**************************************************
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			STORE_CLOCK

			SET_FIXED_CAMERA_POSITION -605.6 1371.6 23.1 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -562.94 1373.14 14.81 JUMP_CUT

			WAIT 1000

			WHILE x_axis_ladder >= -140.0 
				WAIT 0
				SET_OBJECT_ROTATION gspot_stairs x_axis_ladder 0.0 0.0  
				x_axis_ladder -=@ 1.0
			ENDWHILE

			WAIT 1000

			REMOVE_BLIP lift_blip
			PRINT_NOW ( POR4_11 ) 7000 1 //Return to the ladder if you need access to the rooftops again.  
			REMOVE_BLIP lift_blip 
			ADD_BLIP_FOR_COORD_OLD -574.2 1373.35 16.1 PURPLE BLIP_ONLY lift_blip
			DIM_BLIP lift_blip TRUE

			RESTORE_CAMERA_JUMPCUT
			RESTORE_CLOCK
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
// ******************************************END OF CUTSCENE - CREATING FLIP-DOWN LADDER****************************************************
			ladder_down = 1
		ENDIF
	ENDIF
ENDIF

IF porn4_goals = 17 //jump from midway building 

	//DRAW_CORONA -482.0 1355.7 24.7 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -482.0 1355.7 24.7 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -410.6 1364.8 29.7 corona_blip
		porn4_goals = 18
	ENDIF
ENDIF

IF porn4_goals = 18 //1st of 3 ickle jumps leading to corner building  

	//DRAW_CORONA -410.6 1364.8 29.7 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -410.6 1364.8 29.7 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -354.3 1385.0 27.0 corona_blip
		porn4_goals = 19
	ENDIF
ENDIF

IF porn4_goals = 19 //2nd of 3 ickle jumps leading to corner building   

	//DRAW_CORONA -354.3 1385.0 27.0 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -354.3 1385.0 27.0 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -283.3 1401.7 27.3 corona_blip
		porn4_goals = 20
	ENDIF
ENDIF

IF porn4_goals = 20 //3rd of 3 ickle jumps leading to corner building 

	//DRAW_CORONA -283.3 1401.7 27.3 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -283.3 1401.7 27.3 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -280.5 1335.0 27.1 corona_blip
		porn4_goals = 21
	ENDIF
ENDIF

IF porn4_goals = 21 //corner jump

	//DRAW_CORONA -280.5 1335.0 27.1 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -280.5 1335.0 27.1 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -277.1 1274.0 27.9 corona_blip
		porn4_goals = 22
	ENDIF
ENDIF

IF porn4_goals = 22 //jump after corner jump

	//DRAW_CORONA -277.1 1274.0 27.9 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -277.1 1274.0 27.9 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -277.3 1216.3 42.6 corona_blip
		porn4_goals = 23
	ENDIF
ENDIF

IF porn4_goals = 23 //penultimate jump

	//DRAW_CORONA -277.3 1216.3 42.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -277.3 1216.3 42.6 10.0 10.0 10.0 TRUE
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		ADD_BLIP_FOR_COORD -336.5 1047.8 38.7 corona_blip
		porn4_goals = 24
	ENDIF
ENDIF

IF porn4_goals = 24 //last jump

	//DRAW_CORONA -336.5 1047.8 38.7 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -336.5 1047.8 38.7 10.0 10.0 10.0 TRUE
		//ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		REMOVE_BLIP corona_blip 
		porn4_goals = 25
	ENDIF
ENDIF

IF porn4_goals > 24 //last jump
	IF IS_PLAYER_STOPPED player1 
		IF ladder2_down = 0 
// ******************************************START OF CUTSCENE - CREATING FLIP DOWN LADDER**************************************************
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			STORE_CLOCK
			x_axis_ladder = 0.0

			SET_FIXED_CAMERA_POSITION -303.3 858.4 21.0 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -356.3 919.0 23.0 JUMP_CUT

			WAIT 3000

			SET_FIXED_CAMERA_POSITION -345.3 914.7 17.6 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -368.9 909.8 16.8  JUMP_CUT
			
			WAIT 1000

			WHILE x_axis_ladder >= -150.0 
				WAIT 0
				SET_OBJECT_ROTATION gspot_stairs2 x_axis_ladder 0.0 157.0   
				x_axis_ladder -=@ 1.0
			ENDWHILE

			WAIT 1000

			RESTORE_CAMERA_JUMPCUT
			RESTORE_CLOCK
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF

			// SCFIX: START - bypass the widescreen bug
			WAIT 0
			WAIT 0
			// SCFIX: END
// ******************************************END OF CUTSCENE - CREATING FLIP-DOWN LADDER****************************************************
			ladder2_down = 1
		ENDIF	  
	ENDIF
ENDIF

IF porn4_goals = 25
	ADD_BLIP_FOR_COORD -358.0 992.2 46.3 searchlight_blip
	porn4_goals = 26
ENDIF

//waiting till player is in bike
IF IS_PLAYER_IN_MODEL player1 pcj600
	IF porn4_goals = 0
		CLEAR_PRINTS 
		PRINT_NOW ( POR4_03 ) 5000 1 //You will need to get onto the roofs of the buildings.   There should be a lift into one of the upper offices...
		porn4_goals = 1
	ENDIF
ENDIF

//Bike and guard on prawn island
IF LOCATE_PLAYER_ANY_MEANS_3D player1 6.8 953.5 10.0 80.0 80.0 80.0 FALSE   
	IF create_bike_on_prawn_island = 0
		CREATE_CAR pcj600 -6.4 957.1 9.4 prawn_bike
		CREATE_CHAR PEDTYPE_CIVMALE GDa 0.3 958.3 9.9 door_guard
		create_bike_on_prawn_island = 1
	ENDIF
ELSE
	IF create_bike_on_prawn_island = 1
		MARK_CHAR_AS_NO_LONGER_NEEDED door_guard 
		MARK_CAR_AS_NO_LONGER_NEEDED prawn_bike
	 	create_bike_on_prawn_island = 0
	ENDIF
ENDIF

IF porn4_goals = 0
	IF create_bike_on_prawn_island = 1 
		IF IS_CAR_DEAD prawn_bike 
			porn4_goals = 1
		ENDIF
	ENDIF
ENDIF

//player on lift
IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -562.5 782.3 21.8 2.0 2.0 2.0 TRUE
	IF NOT IS_PLAYER_ON_ANY_BIKE player1
		PRINT_NOW ( POR4_07 ) 5000 1 //You will need a bike so you can jump from building to building.
	ENDIF
	IF IS_PLAYER_ON_ANY_BIKE player1
		IF IS_PLAYER_SITTING_IN_ANY_CAR player1 
// ******************************************START OF CUTSCENE - PLAYER GOING UP IN LIFT**************************************************\
	
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			STORE_CLOCK

			SET_FIXED_CAMERA_POSITION -565.4 782.6 23.7 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -556.8 782.0 22.8 JUMP_CUT
			
			STORE_CAR_PLAYER_IS_IN player1 players_lift_vehicle
			SET_CAR_COORDINATES players_lift_vehicle -562.5 782.3 21.8
			SET_CAR_HEADING players_lift_vehicle 264.8 
			
			CREATE_CHAR PEDTYPE_CIVMALE WMOBU -556.2 783.0 21.8 lift_office1 //left when looking in // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING lift_office1 204.7

			CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -555.8 781.3 21.8 lift_office2  //right when looking in
			SET_CHAR_HEADING lift_office2 12.4
			
			SET_CHARS_CHATTING lift_office1 lift_office2 86400000 

			WAIT 1000

			//opening bottom doors

			LOAD_MISSION_AUDIO 1 LIFTOP
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 

			LOAD_MISSION_AUDIO 2 LIFTBEL
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 

			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2

			LOAD_MISSION_AUDIO 2 LIFTRUN
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 

			timera = 0
			lift_loop:
				WAIT 0
				
				PLAY_MISSION_AUDIO 1

				SLIDE_OBJECT left_bottom -559.476 784.807 23.279 0.0 0.1 0.0 FALSE
				SLIDE_OBJECT right_bottom -559.476 779.64 23.279 0.0 0.1 0.0 FALSE
				

				IF timera > 2000
					GOTO bottom_lift_doors_open
				ENDIF
			GOTO lift_loop 
			bottom_lift_doors_open: 

			IF NOT IS_CHAR_DEAD lift_office1
				IF NOT IS_CHAR_DEAD lift_office2 
					SET_CHARS_CHATTING lift_office1 lift_office2 10
					CHAR_LOOK_AT_PLAYER_ALWAYS lift_office1 player1 
				ENDIF
			ENDIF
			WAIT 80
			IF NOT IS_CHAR_DEAD lift_office2  
				CHAR_LOOK_AT_PLAYER_ALWAYS lift_office2 player1 
			ENDIF

			WAIT 100

			LOAD_MISSION_AUDIO 1 INLIFT
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			
			IF NOT IS_CAR_DEAD players_lift_vehicle 
				SET_CAR_STATUS players_lift_vehicle STATUS_PHYSICS
				SET_CAR_DRIVING_STYLE players_lift_vehicle DRIVINGMODE_PLOUGHTHROUGH 
				SET_CAR_TEMP_ACTION players_lift_vehicle TEMPACT_GOFORWARD 1100
				PLAY_MISSION_AUDIO 1
			ENDIF 
			
			timera = 0
			waiting_for_player_to_get_into_lift:
			WAIT 0
				IF NOT IS_CAR_DEAD players_lift_vehicle 
					IF LOCATE_CAR_2D players_lift_vehicle -557.9 782.3 1.3 1.3 FALSE
						GOTO player_in_lift
					ENDIF
				ENDIF
				IF timera > 900
					GOTO player_in_lift
				ENDIF
			GOTO waiting_for_player_to_get_into_lift    
			player_in_lift:
			SET_CAR_TEMP_ACTION players_lift_vehicle TEMPACT_HANDBRAKESTRAIGHT 1
			
			IF NOT IS_CHAR_DEAD lift_office1
				STOP_CHAR_LOOKING lift_office1  
				TURN_CHAR_TO_FACE_COORD lift_office1 -562.5 782.3 21.8
			ENDIF
			WAIT 80
			IF NOT IS_CHAR_DEAD lift_office2  
				STOP_CHAR_LOOKING lift_office2 
				TURN_CHAR_TO_FACE_COORD lift_office2 -562.5 782.3 21.8
			ENDIF
			
			WAIT 1000

			//closing bottom doors
			timera = 0
			LOAD_MISSION_AUDIO 1 LIFTCL
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
		
			lift_loop2:
				WAIT 0
				SLIDE_OBJECT left_bottom -559.476 783.107 23.279 0.0 0.1 0.0 FALSE
				SLIDE_OBJECT right_bottom -559.476 781.34 23.279 0.0 0.1 0.0 FALSE
				
				PLAY_MISSION_AUDIO 1
				
				IF timera > 1000
					IF setting_player_upstairs = 0
						DELETE_CHAR lift_office1	
						DELETE_CHAR lift_office2
						CREATE_CHAR PEDTYPE_CIVMALE WMOBU -550.0 788.7 96.5 lift_office1 //left when looking in // SCFIX: was PEDTYPE_CIVFEMALE
						SET_CHAR_HEADING lift_office1 90.6

						CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -550.0 787.2 96.5 lift_office2 //right when looking in
						SET_CHAR_HEADING lift_office2 90.6
						IF NOT IS_CAR_DEAD players_lift_vehicle 
							SET_CAR_COORDINATES players_lift_vehicle -551.5 787.9 96.5
							SET_CAR_HEADING players_lift_vehicle 269.4 
						ENDIF
						setting_player_upstairs = 1
					ENDIF
				ENDIF
				IF timera > 2000
					GOTO bottom_lift_doors_closed
				ENDIF
			GOTO lift_loop2 
			bottom_lift_doors_closed: 
			
			PLAY_MISSION_AUDIO 2
			SET_FIXED_CAMERA_POSITION -553.3 786.1 100.0 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -550.4 788.4 97.2 JUMP_CUT
			SWITCH_LIFT_CAMERA ON


			WAIT 5000
			
			CLEAR_MISSION_AUDIO 1
			LOAD_MISSION_AUDIO 2 LIFTBEL
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2


			//FLUFF IN TOP OFFICE
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -564.4 784.4 96.5 top_office1 //sitting behind reception desk
			SET_CHAR_HEADING top_office1 3.1

			CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -552.6 768.6 96.5 top_office2 //drinking spunk
			SET_CHAR_HEADING top_office2 179.0
		
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -537.9 787.6 96.5 top_office3 //sitting on chairs facing wall
			SET_CHAR_HEADING top_office3 92.5
		
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -524.0 811.6 96.5 top_office4 //standing at watercooler talknig to top_office5 (back to window)
			SET_CHAR_HEADING top_office4 108.6
		
			CREATE_CHAR PEDTYPE_CIVMALE WMOBU -524.0 810.0 96.5 top_office5 //standing at watercooler talknig to top_office4 (facing window) // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING top_office5 0.0
		
			SET_CHARS_CHATTING top_office4 top_office5 86400000 
		
			CREATE_CHAR PEDTYPE_CIVMALE WMYBU -529.5 826.9 96.5 top_office6 //standing looking out of smashable glass window // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING top_office6 358.0
		
			CREATE_CHAR PEDTYPE_CIVMALE WMYBU -539.2 768.6 96.5 top_office7 //sitting on chair talking to top_office7 // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING top_office7 6.5
		
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -540.2 769.3 96.5 top_office8 //standing talking to top_office8
			SET_CHAR_HEADING top_office8 214.6
		
			SET_CHARS_CHATTING top_office7 top_office8 86400000 
		
			create_top_office_workers = 1


			//switching security camera off
			SWITCH_LIFT_CAMERA OFF
			SET_FIXED_CAMERA_POSITION -557.0 787.7 99.0 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT -550.6 787.6 97.5 JUMP_CUT

			//opening top doors
			timera = 0
			LOAD_MISSION_AUDIO 1 LIFTOP
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
		
			lift_loop3:
				WAIT 0
				
				PLAY_MISSION_AUDIO 1

				SLIDE_OBJECT left_top -553.563 790.595 97.917 0.0 0.1 0.0 FALSE
				SLIDE_OBJECT right_top -553.563 785.427 97.917 0.0 0.1 0.0 FALSE
				
				IF timera > 2000
					GOTO top_lift_doors_open
				ENDIF
			GOTO lift_loop3 
			top_lift_doors_open:
			/*
			IF NOT IS_CHAR_DEAD lift_office1
		 		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lift_office1 -555.1 788.5 
		 	ENDIF 
			IF NOT IS_CHAR_DEAD lift_office2
		 		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT lift_office2 -590.8 790.1 
		 	ENDIF 
			*/
			IF NOT IS_CAR_DEAD players_lift_vehicle 
				SET_CAR_TEMP_ACTION players_lift_vehicle TEMPACT_REVERSE 10000
				timera = 0
			ENDIF 

			waiting_for_player_to_get_out_of_lift:
			WAIT 0
				IF NOT IS_CAR_DEAD players_lift_vehicle 
					IF LOCATE_CAR_2D players_lift_vehicle -560.5 788.0 1.0 1.0 FALSE
						GOTO player_out_lift
					ENDIF
				ENDIF
				IF timera > 2500
					GOTO player_out_lift
				ENDIF
			GOTO waiting_for_player_to_get_out_of_lift    
			player_out_lift:
			SET_CAR_TEMP_ACTION players_lift_vehicle TEMPACT_HANDBRAKESTRAIGHT 1
			IF NOT LOCATE_CAR_2D players_lift_vehicle -560.5 788.0 1.0 1.0 FALSE
				SET_CAR_COORDINATES players_lift_vehicle -560.5 788.0 96.0
				SET_CAR_HEADING players_lift_vehicle 186.0 
			ENDIF	  
			
			WAIT 1000

			//closing top doors
			timera = 0
		
			LOAD_MISSION_AUDIO 1 LIFTCL
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE 
			
			lift_loop4:
				WAIT 0
				SLIDE_OBJECT left_top -553.563 788.895 97.917 0.0 0.1 0.0 FALSE
				SLIDE_OBJECT right_top -553.563 787.127 97.917 0.0 0.1 0.0 FALSE
				
				PLAY_MISSION_AUDIO 1
				
				IF timera > 2000
					GOTO top_lift_doors_closed
				ENDIF
			GOTO lift_loop4 
			top_lift_doors_closed: 

			MARK_CHAR_AS_NO_LONGER_NEEDED lift_office1 
			MARK_CHAR_AS_NO_LONGER_NEEDED lift_office2 

			IF NOT IS_CAR_DEAD players_lift_vehicle 
				SET_CAR_STATUS players_lift_vehicle STATUS_PLAYER
			ENDIF
			//switching security camera off
			setting_player_upstairs = 0
			SWITCH_LIFT_CAMERA OFF
			RESTORE_CAMERA_JUMPCUT
			RESTORE_CLOCK
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			
	// ******************************************END OF CUTSCENE - PLAYER GOING UP IN LIFT****************************************************
			IF porn4_goals = 1
			OR porn4_goals = 2
				REMOVE_BLIP gate_blip
				porn4_goals = 4
			ENDIF
			IF porn4_goals = 4
				CLEAR_PRINTS
				PRINT_NOW ( POR4_06 ) 7000 1 //Return to the lower office if you need access to the rooftops again.
				REMOVE_BLIP lift_blip 
				ADD_BLIP_FOR_COORD_OLD -562.7 782.7 22.4 PURPLE BLIP_ONLY lift_blip
				DIM_BLIP lift_blip TRUE
				porn4_goals = 5
			ELSE
				REMOVE_BLIP searchlight_blip 
				porn4_goals = 7
			ENDIF
		ENDIF
	ENDIF
ENDIF


//FLUFF IN BOTTOM OFFICE
IF LOCATE_PLAYER_ANY_MEANS_3D player1 -568.0 793.2 22.0 40.0 40.0 40.0 FALSE   
	IF IS_PLAYER_IN_AREA_3D player1 -576.9 836.2 15.0 -583.0 821.6 25.0 FALSE
		IF create_bottom_office_workers = 0
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -571.5 776.5 21.8 bottom_office1 //standing behind desk
			SET_CHAR_HEADING bottom_office1 355.4

			CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -570.9 779.1 21.8 bottom_office2 //talking to chick behind desk
			SET_CHAR_HEADING bottom_office2 171.2

			SET_CHARS_CHATTING bottom_office1 bottom_office2 86400000 

			CREATE_CHAR PEDTYPE_CIVMALE WMYBU -574.1 788.0 21.8 bottom_office3 //sitting on chairs as player goes in // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING bottom_office3 278.0

			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -571.2 810.6 21.8 bottom_office4 //standing talking to guy sitting down (officeworker6)
			SET_CHAR_HEADING bottom_office4 272.9
			
			CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -560.8 787.5 21.8 bottom_office5 //standing browsing books
			SET_CHAR_HEADING bottom_office5 278.8

			CREATE_CHAR PEDTYPE_CIVMALE WMOBU -569.4 810.5 21.8 bottom_office6 //sitting on chairs at left hand side of the office FACING WINDOW // SCFIX: was PEDTYPE_CIVFEMALE
			SET_CHAR_HEADING bottom_office6 114.1
		
			SET_CHARS_CHATTING bottom_office4 bottom_office6 86400000 
		
			create_bottom_office_workers = 1
		ENDIF
	ENDIF
ELSE
	IF create_bottom_office_workers = 1
		DELETE_CHAR bottom_office1  
		DELETE_CHAR bottom_office2 
		DELETE_CHAR bottom_office3  
		DELETE_CHAR bottom_office4
		DELETE_CHAR bottom_office5
		DELETE_CHAR bottom_office6
		create_bottom_office_workers = 0
	ENDIF
ENDIF  

IF NOT IS_CHAR_DEAD bottom_office3 
	SET_CHAR_WAIT_STATE bottom_office3 WAITSTATE_SIT_IDLE 999999
ENDIF

IF NOT IS_CHAR_DEAD bottom_office5 
	SET_CHAR_WAIT_STATE bottom_office5 WAITSTATE_USE_ATM 999999
ENDIF

IF NOT IS_CHAR_DEAD bottom_office6 
	SET_CHAR_WAIT_STATE bottom_office6 WAITSTATE_SIT_IDLE 999999
ENDIF

IF NOT IS_CHAR_DEAD top_office1 
	SET_CHAR_WAIT_STATE top_office1 WAITSTATE_SIT_IDLE 999999
ENDIF

IF NOT IS_CHAR_DEAD top_office2 
	SET_CHAR_WAIT_STATE top_office2 WAITSTATE_USE_ATM 999999
ENDIF

IF NOT IS_CHAR_DEAD top_office3 
	SET_CHAR_WAIT_STATE top_office3 WAITSTATE_SIT_IDLE 999999
ENDIF

IF NOT IS_CHAR_DEAD top_office7 
	SET_CHAR_WAIT_STATE top_office7 WAITSTATE_SIT_IDLE 999999
ENDIF
	

//deleting upstairs office workers
IF NOT IS_PLAYER_IN_AREA_3D player1 -568.6 765.4 90.9 -479.8 846.2 111.0 FALSE 
	IF create_top_office_workers = 1
		DELETE_CHAR top_office1  
		DELETE_CHAR top_office2 
		DELETE_CHAR top_office3  
		DELETE_CHAR top_office4
		DELETE_CHAR top_office5
		DELETE_CHAR top_office6
		DELETE_CHAR top_office7
		DELETE_CHAR top_office8
		create_top_office_workers = 0
	ENDIF
ENDIF  



//player at spotlight
IF porn4_goals = 26
	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -355.6 990.8 44.4 1.0 1.0 2.0 TRUE
	// ******************************************START OF CUTSCENE - PLAYER TURNING TITS ON***************************************************
		SET_PLAYER_CONTROL player1 OFF
		
		SWITCH_WIDESCREEN ON

		GET_TIME_OF_DAY hours minutes 

		IF hours > 16
			IF hours < 23
				SET_TIME_OF_DAY 23 0
			ENDIF
		ENDIF 
		CLEAR_AREA -356.1 990.1 44.4 1.0 1  
		SET_PLAYER_COORDINATES player1 -356.1 990.1 44.4
		SET_PLAYER_HEADING player1 260.5 
		
		SET_FIXED_CAMERA_POSITION -358.1 991.5 46.8 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT -355.2 990.3 46.1 JUMP_CUT

		LOAD_CUTSCENE GSPOT
		START_CUTSCENE

		//switching off camera
		WAIT 1000
		SET_CHAR_WAIT_STATE scplayer WAITSTATE_USE_ATM 1000
		WAIT 2000
		CLEAR_CHAR_WAIT_STATE scplayer 
		DELETE_OBJECT spotlight_shining_to_sea 
		WAIT 500	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_a -324.797 991.184 71.708 spotlight_shining_to_sea
		WAIT 500	
		DELETE_OBJECT spotlight_shining_to_sea 
		WAIT 500	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_a -324.797 991.184 71.708 spotlight_shining_to_sea
		WAIT 300	
		DELETE_OBJECT spotlight_shining_to_sea 
		WAIT 200	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_a -324.797 991.184 71.708 spotlight_shining_to_sea
		WAIT 100	
		DELETE_OBJECT spotlight_shining_to_sea
		WAIT 50
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_a -324.797 991.184 71.708 spotlight_shining_to_sea
		WAIT 10	
		DELETE_OBJECT spotlight_shining_to_sea
		WAIT 10
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_a -324.797 991.184 71.708 spotlight_shining_to_sea
		WAIT 10	
		DELETE_OBJECT spotlight_shining_to_sea
		WAIT 500	

		//turning camera around
		SET_FIXED_CAMERA_POSITION -350.10 991.07 44.97 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT -478.2 969.8 137.3 JUMP_CUT

		WAIT 1000
		SET_PLAYER_COORDINATES player1 -342.9 984.7 44.8
		WHILE NOT ROTATE_OBJECT spotlight 360.0 1.0 FALSE
			WAIT 0
		ENDWHILE
		WAIT 500
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		WAIT 10	
		DELETE_OBJECT spotlight_shining_onto_wall
		WAIT 10
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		WAIT 10	
		DELETE_OBJECT spotlight_shining_onto_wall
		WAIT 50
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		WAIT 100	
		DELETE_OBJECT spotlight_shining_onto_wall
		WAIT 200	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		WAIT 300	
		DELETE_OBJECT spotlight_shining_onto_wall
		WAIT 500	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		WAIT 500	
		DELETE_OBJECT spotlight_shining_onto_wall
		WAIT 500	
		CREATE_OBJECT_NO_OFFSET dts_soapytitwank_b -419.28 952.886 140.66 spotlight_shining_onto_wall
		DONT_REMOVE_OBJECT spotlight_shining_onto_wall

		WAIT 5000
		//CLEAR_CUTSCENE // SCFIX: removed

		//RESTORE_CAMERA_JUMPCUT // SCFIX: removed
		//SET_PLAYER_CONTROL player1 ON // SCFIX: removed
		//SWITCH_WIDESCREEN OFF // SCFIX: removed
	// ******************************************END OF CUTSCENE - PLAYER TURNING TITS ON*****************************************************
	// ******************************************START OF ASSET AQUIRED CUTSCENE********************************
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					// SCFIX: START
					CLEAR_CUTSCENE
					SET_PLAYER_CONTROL player1 OFF
					WAIT 0
					WAIT 0
					SWITCH_WIDESCREEN ON
					// SCFIX: END

					SET_PLAYER_COORDINATES player1 -2.8 985.9 10.9
					CREATE_PROTECTION_PICKUP porncashX porncashY porncashZ porn_revenue porn_revenue porn_cash_pickup
					LOAD_SCENE 17.6 957.6 16.7
					SET_FIXED_CAMERA_POSITION 39.5 940.1 21.8 0.0 0.0 0.0 
					POINT_CAMERA_AT_POINT 17.6 957.6 16.7 JUMP_CUT

					DO_FADE 500 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
				
					PLAY_MISSION_PASSED_TUNE 1
					PRINT_BIG POR_AS1 5000 6 //FILM STUDIO ASSET COMPLETED
					
					WAIT 5000
					LOAD_SCENE -4.0 961.5 9.7
					SET_FIXED_CAMERA_POSITION 9.2 964.6 12.9 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -4.0 961.5 9.7 JUMP_CUT
					
					PRINT_WITH_NUMBER_NOW POR_AS2 porn_revenue 6000 1//Inter Global Films will now generate revenue up to a maximum of $~1~. Make sure you collect it regularly.

					WAIT 6000
					DO_FADE 500 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					SET_PLAYER_COORDINATES player1 -353.0 990.0 44.4
					SET_PLAYER_HEADING player1 102.5 
					GET_PLAYER_COORDINATES player1 player_x player_y player_z
					LOAD_SCENE player_x player_y player_z

					DO_FADE 500 FADE_IN
					
					RESTORE_CAMERA_JUMPCUT
					SET_PLAYER_CONTROL player1 ON
					SWITCH_WIDESCREEN OFF
	// ******************************************END OF ASSET AQUIRED CUTSCENE********************************
		GOTO mission_passed_porn4
	ENDIF
ENDIF

GET_MINUTES_TO_TIME_OF_DAY 7 0 time_to_fail
IF time_to_fail = 0
	PRINT_NOW ( POR4_10 ) 5000 1 //It's too light to get up there unseen.
	GOTO mission_failed_porn4
ENDIF  

GOTO porn4_main_loop 									  


// Mission failed
mission_failed_porn4:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

// mission passed
mission_passed_porn4:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 8000 5000 1 //"Mission Passed!"
//PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 8000
SWITCH_CAR_GENERATOR heli1_cargen 101 //switching chris' copter on! 
//opening bottom lift doors
SET_OBJECT_COORDINATES left_bottom -559.476 784.807 23.279 // SCFIX: remove SLIDE_OBJECT
SET_OBJECT_COORDINATES right_bottom -559.476 779.64 23.279 // SCFIX: remove SLIDE_OBJECT
SET_OBJECT_COORDINATES left_top -553.563 790.595 97.917 // SCFIX: remove SLIDE_OBJECT
SET_OBJECT_COORDINATES right_top -553.563 785.427 97.917 // SCFIX: remove SLIDE_OBJECT
PLAYER_MADE_PROGRESS 1 	    
REGISTER_MISSION_PASSED PORN_4
REMOVE_BLIP porn_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD porncashX porncashY porncashZ	the_porn_blip porn_contact_blip
++ counter_60_percent
porn_asset_acquired = 1
flag_first_asset_complete = 1 // SCFIX: fix Ken's phonecall
flag_porn_mission4_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_porn4:

flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
REMOVE_BLIP lift_blip
REMOVE_BLIP searchlight_blip
REMOVE_BLIP	bike_blip
REMOVE_BLIP	gate_blip
REMOVE_BLIP	window_blip
REMOVE_BLIP corona_blip
MARK_MODEL_AS_NO_LONGER_NEEDED HFYBU 
MARK_MODEL_AS_NO_LONGER_NEEDED WFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED WMYBU
MARK_MODEL_AS_NO_LONGER_NEEDED WMOBU
MARK_MODEL_AS_NO_LONGER_NEEDED pcj600
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}		

			


//code to make jump onto ladder point good
/*
	IF IS_PLAYER_IN_AREA_2D player1 -605.3 1372.3 -598.0 1365.5 FALSE
		IF IS_PLAYER_IN_ANY_CAR player1 
			STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car_usj
			GET_CAR_SPEED players_car_usj car_speed_usj
			IF car_speed_usj > 10.0
				jump_flag = 1
			ENDIF
			IF jump_flag = 1 
				SET_TIME_SCALE 0.3
				SET_FIXED_CAMERA_POSITION -603.6 1379.0 20.8 0.0 0.0 0.0
				POINT_CAMERA_AT_CAR players_car_usj FIXED JUMP_CUT
				WHILE IS_CAR_IN_AIR_PROPER players_car_usj
				OR collision_counter_usj < 10
					++ collision_counter_usj
					WAIT 0
					DRAW_CORONA -573.5 1365.4 16.6 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 0 0 255	
					IF IS_CAR_DEAD players_car_usj
						GOTO restore_if_fail3
					ENDIF
					IF NOT IS_PLAYER_PLAYING player1
						GOTO restore_if_fail3
					ENDIF
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						GOTO restore_if_fail3
					ENDIF
				ENDWHILE
				restore_if_fail3:
				SET_TIME_SCALE 1.0
				RESTORE_CAMERA_JUMPCUT
				jump_flag = 0
				collision_counter_usj = 0 
			ENDIF
		ENDIF
	ENDIF
*/
