MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_ovalring_start

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_ovalring_failed
ENDIF

GOSUB mission_ovalring_cleanup

MISSION_END
 
// ******************************** Variables for mission **********************************

VAR_INT showcase showcase_timer	nascar_laps player_result gosub_result	
VAR_INT heading_done_flag gosub_nascar gosub_driver	true_false nascar_best_time_last
VAR_INT	nascar_lap_timer nascar_time nascar_lap_timer_start	do_winning_text_shite
VAR_INT players_nascar players_nascar_health skip_scut_button miliseconds
VAR_INT hot_audio_flag last_audio_played hotring_finished_timer

VAR_INT nascar1	car1_laps car1_result nascar1_timer
VAR_INT nascar2	car2_laps car2_result nascar2_timer
VAR_INT nascar3	car3_laps car3_result nascar3_timer
VAR_INT nascar4 driver_car4 car4_cpcounter car4_laps car4_result nascar4_timer
VAR_INT nascar5 driver_car5 car5_cpcounter car5_laps car5_result nascar5_timer
VAR_INT nascar6 driver_car6 car6_cpcounter car6_laps car6_result nascar6_timer
VAR_INT nascar7 driver_car7 car7_cpcounter car7_laps car7_result nascar7_timer
VAR_INT nascar8 driver_car8 car8_cpcounter car8_laps car8_result nascar8_timer
VAR_INT nascar9 driver_car9 car9_cpcounter car9_laps car9_result nascar9_timer
VAR_INT nascar10 driver_car10 car10_cpcounter car10_laps car10_result nascar10_timer
VAR_INT nascar11 driver_car11 car11_cpcounter car11_laps car11_result nascar11_timer
VAR_INT nascar12 driver_car12 car12_cpcounter car12_laps car12_result nascar12_timer
VAR_INT nascar13 driver_car13 car13_cpcounter car13_laps car13_result nascar13_timer
VAR_INT nascar14 driver_car14 car14_cpcounter car14_laps car14_result nascar14_timer
VAR_INT nascar15 driver_car15 car15_cpcounter car15_laps car15_result nascar15_timer

VAR_INT car4_stuck_timer car5_stuck_timer 
VAR_INT car6_stuck_timer car7_stuck_timer car8_stuck_timer car9_stuck_timer car10_stuck_timer
VAR_INT car11_stuck_timer car12_stuck_timer car13_stuck_timer car14_stuck_timer car15_stuck_timer

VAR_FLOAT car9_cp_x car9_cp_y car9_cp_z	
VAR_FLOAT car10_cp_x car10_cp_y car10_cp_z 
VAR_FLOAT car11_cp_x car11_cp_y car11_cp_z 
VAR_FLOAT car12_cp_x car12_cp_y car12_cp_z 
VAR_FLOAT car13_cp_x car13_cp_y car13_cp_z 
VAR_FLOAT car14_cp_x car14_cp_y car14_cp_z 
VAR_FLOAT car15_cp_x car15_cp_y car15_cp_z 

VAR_FLOAT car4_stuck_x car4_stuck_y car4_stuck_z	
VAR_FLOAT car5_stuck_x car5_stuck_y car5_stuck_z	
VAR_FLOAT car6_stuck_x car6_stuck_y car6_stuck_z	
VAR_FLOAT car7_stuck_x car7_stuck_y car7_stuck_z	
VAR_FLOAT car8_stuck_x car8_stuck_y car8_stuck_z	
VAR_FLOAT car9_stuck_x car9_stuck_y car9_stuck_z	
VAR_FLOAT car10_stuck_x car10_stuck_y car10_stuck_z 
VAR_FLOAT car11_stuck_x car11_stuck_y car11_stuck_z 
VAR_FLOAT car12_stuck_x car12_stuck_y car12_stuck_z 
VAR_FLOAT car13_stuck_x car13_stuck_y car13_stuck_z 
VAR_FLOAT car14_stuck_x car14_stuck_y car14_stuck_z 
VAR_FLOAT car15_stuck_x car15_stuck_y car15_stuck_z 


//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE var_ints
//VAR_INT driver_car1 driver_car2 driver_car3	
//VAR_INT player_cpcounter car1_cpcounter car2_cpcounter car3_cpcounter gosub_cpcounter
//VAR_INT position mins seconds temp_int
//VAR_INT players_car
//VAR_INT car1_stuck_timer car2_stuck_timer car3_stuck_timer game_timer
//VAR_FLOAT car_x car_y
//VAR_FLOAT car_distance_from_cp player1_distance_from_cp
//VAR_FLOAT player1_cp_x player1_cp_y player1_cp_z
//VAR_FLOAT car1_cp_x car1_cp_y car1_cp_z
//VAR_FLOAT car2_cp_x car2_cp_y car2_cp_z
//VAR_FLOAT car3_cp_x car3_cp_y car3_cp_z
//VAR_FLOAT car1_stuck_x car1_stuck_y car1_stuck_z
//VAR_FLOAT car2_stuck_x car2_stuck_y car2_stuck_z
//VAR_FLOAT car3_stuck_x car3_stuck_y car3_stuck_z
//VAR_FLOAT gosub_cp_x gosub_cp_y	gosub_cp_z
//VAR_FLOAT cp1_x cp1_y cp1_z
//VAR_FLOAT cp2_x cp2_y cp2_z
//VAR_FLOAT cp3_x cp3_y cp3_z
//VAR_FLOAT cp4_x cp4_y cp4_z
//VAR_FLOAT cp5_x cp5_y cp5_z
//VAR_FLOAT cp6_x cp6_y cp6_z
//VAR_FLOAT cp7_x cp7_y cp7_z
//VAR_FLOAT cp8_x cp8_y cp8_z
//VAR_FLOAT cp9_x cp9_y cp9_z
//VAR_FLOAT cp10_x cp10_y cp10_z


// ************************************ Mission Start **************************************


mission_ovalring_start:

flag_player_on_mission = 1

SCRIPT_NAME OVALRNG

WAIT 0

IF done_ovalring_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

LOAD_MISSION_TEXT OVALRIG

{
LVAR_FLOAT car4_cp_x car4_cp_y car4_cp_z	
LVAR_FLOAT car5_cp_x car5_cp_y car5_cp_z	
LVAR_FLOAT car6_cp_x car6_cp_y car6_cp_z	
LVAR_FLOAT car7_cp_x car7_cp_y car7_cp_z	
LVAR_FLOAT car8_cp_x car8_cp_y car8_cp_z	

gosub_cpcounter   = 0
player_cpcounter  = 0
car1_cpcounter 	  = 0
car2_cpcounter 	  = 0
car3_cpcounter 	  = 0
car4_cpcounter 	  = 0
car5_cpcounter 	  = 0
car6_cpcounter 	  = 0
car7_cpcounter 	  = 0
car8_cpcounter 	  = 0
car9_cpcounter 	  = 0
car10_cpcounter   = 0
car11_cpcounter   = 0
car12_cpcounter   = 0
car10_cpcounter   = 0
car14_cpcounter   = 0
car15_cpcounter   = 0

car1_laps  = 0
car2_laps  = 0
car3_laps  = 0
car4_laps  = 0
car5_laps  = 0
car6_laps  = 0
car7_laps  = 0
car8_laps  = 0
car9_laps  = 0
car10_laps = 0
car11_laps = 0
car12_laps = 0
car13_laps = 0
car14_laps = 0
car15_laps = 0

car1_stuck_timer  = 0
car2_stuck_timer  = 0
car3_stuck_timer  = 0
car4_stuck_timer  = 0
car5_stuck_timer  = 0
car6_stuck_timer  = 0
car7_stuck_timer  = 0
car8_stuck_timer  = 0
car9_stuck_timer  = 0
car10_stuck_timer = 0
car11_stuck_timer = 0
car12_stuck_timer = 0
car13_stuck_timer = 0
car14_stuck_timer = 0
car15_stuck_timer = 0

nascar1_timer = 0
nascar2_timer = 0
nascar3_timer = 0
nascar4_timer = 0
nascar5_timer = 0
nascar6_timer = 0
nascar7_timer = 0
nascar8_timer = 0
nascar9_timer = 0
nascar10_timer = 0
nascar11_timer = 0
nascar12_timer = 0
nascar13_timer = 0
nascar14_timer = 0
nascar15_timer = 0

do_winning_text_shite = 0
showcase = -1
showcase_timer = 0
nascar_laps = 0
player_result = 0
gosub_result = 0
heading_done_flag = 0
gosub_nascar = -1
gosub_driver = -1
nascar_best_time_last = 0
nascar_time = 0
hot_audio_flag = 0
position = 0
skip_scut_button = 0
last_audio_played = 0
nascar_lap_timer_start = 0
players_nascar_health = 100

gosub_cp_x = 0.0
gosub_cp_y = 0.0
gosub_cp_z = 0.0

cp1_x =  -1288.976
cp1_y =  1190.669
cp1_z =  264.291

cp2_x =  -1257.085
cp2_y =  1245.841
cp2_z =  264.296

cp3_x =  -1296.749
cp3_y =  1306.123
cp3_z =  264.296

cp4_x =  -1366.372
cp4_y =  1326.72
cp4_z =  264.296

cp5_x =  -1419.235
cp5_y =  1327.06
cp5_z =  264.296

cp6_x =  -1500.381
cp6_y =  1306.066
cp6_z =  264.296

cp7_x =  -1540.008
cp7_y =  1245.841
cp7_z =  264.296

cp8_x =  -1500.446
cp8_y =  1185.51
cp8_z =  264.296

cp9_x =  -1419.234
cp9_y =  1164.33
cp9_z =  264.296

cp10_x = -1355.087
cp10_y = 1165.782
cp10_z = 264.296

SET_AREA_VISIBLE VIS_OVALRING
SET_PLAYER_IS_IN_STADIUM TRUE
DISPLAY_RADAR FALSE
SET_EXTRA_COLOURS 11 FALSE

SET_PLAYER_COORDINATES player1 -1420.856 1245.843 251.379

REQUEST_MODEL WMYCR
REQUEST_MODEL HOTRINA
REQUEST_MODEL HOTRINB
REQUEST_MODEL HOTRING

LOAD_SCENE -1343.7432 1151.8137 275.7988
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED WMYCR
OR NOT HAS_MODEL_LOADED	HOTRINA
OR NOT HAS_MODEL_LOADED	HOTRINB
OR NOT HAS_MODEL_LOADED	HOTRING
	WAIT 0
ENDWHILE

SET_FIXED_CAMERA_POSITION -1318.2053 1163.3895 273.7596 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1319.1184 1163.7313 273.5374 JUMP_CUT
SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

GOTO ovalring_fool_compiler  // FIXMIAMI: remove flag_player_on_mission = 0 check
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 gosub_driver
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car1
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car2
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car3
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car4
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car5
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car6
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car7
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car8
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car9
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car10
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car11
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car12
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car13
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car14
	CREATE_CHAR PEDTYPE_CIVMALE MALE01 0.0 0.0 0.0 driver_car15
ovalring_fool_compiler:  // FIXMIAMI: remove flag_player_on_mission = 0 check

CREATE_CAR HOTRINA -1344.4868 1172.7334 263.8694 nascar1
SET_CAR_HEADING nascar1 284.8876
GET_CAR_COORDINATES nascar1	car1_cp_x car1_cp_y car1_cp_z
gosub_nascar = nascar1
GOSUB setup_nascar_stuff
driver_car1 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 0 -1
CREATE_CAR HOTRINA -1343.4382 1167.8365 264.6195 nascar2
SET_CAR_HEADING nascar2 281.5068
GET_CAR_COORDINATES nascar2	car2_cp_x car2_cp_y car2_cp_z
gosub_nascar = nascar2
GOSUB setup_nascar_stuff
driver_car2 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 1 -1
CREATE_CAR HOTRINA -1354.2965 1170.2894 263.9862 nascar3
SET_CAR_HEADING nascar3 282.7367
GET_CAR_COORDINATES nascar3	car3_cp_x car3_cp_y car3_cp_z
gosub_nascar = nascar3
GOSUB setup_nascar_stuff
driver_car3 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 2 -1
CREATE_CAR HOTRINA -1352.8469 1165.5270 264.7497 nascar4
SET_CAR_HEADING nascar4 284.2442
GET_CAR_COORDINATES nascar4	car4_cp_x car4_cp_y car4_cp_z
gosub_nascar = nascar4
GOSUB setup_nascar_stuff
driver_car4 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 3 -1
CREATE_CAR HOTRINA -1363.7577 1169.0784 264.0151 nascar5
SET_CAR_HEADING nascar5 276.4275
GET_CAR_COORDINATES nascar5	car5_cp_x car5_cp_y car5_cp_z
gosub_nascar = nascar5
GOSUB setup_nascar_stuff
driver_car5 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 4 -1
CREATE_CAR HOTRINA -1363.6703 1164.1503 264.7848 nascar6
SET_CAR_HEADING nascar6 277.8466
GET_CAR_COORDINATES nascar6	car6_cp_x car6_cp_y car6_cp_z
gosub_nascar = nascar6
GOSUB setup_nascar_stuff
driver_car6 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINA 5 -1
CREATE_CAR HOTRINA -1373.8792 1168.6543 264.0179 nascar7
SET_CAR_HEADING nascar7 273.3020
GET_CAR_COORDINATES nascar7	car7_cp_x car7_cp_y car7_cp_z
gosub_nascar = nascar7
GOSUB setup_nascar_stuff
driver_car7 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 0 -1
CREATE_CAR HOTRINB -1374.5608 1163.0554 264.9375 nascar8
SET_CAR_HEADING nascar8 272.9799
GET_CAR_COORDINATES nascar8	car8_cp_x car8_cp_y car8_cp_z
gosub_nascar = nascar8
GOSUB setup_nascar_stuff
driver_car8 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 1 -1
CREATE_CAR HOTRINB -1383.6681 1167.9469 264.1144 nascar9
SET_CAR_HEADING nascar9 273.0015
GET_CAR_COORDINATES nascar9	car9_cp_x car9_cp_y car9_cp_z
gosub_nascar = nascar9
GOSUB setup_nascar_stuff
driver_car9 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 2 -1
CREATE_CAR HOTRINB -1383.5819 1162.9030 264.9546 nascar10
SET_CAR_HEADING nascar10 269.9305
GET_CAR_COORDINATES nascar10 car10_cp_x car10_cp_y car10_cp_z
gosub_nascar = nascar10
GOSUB setup_nascar_stuff
driver_car10 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 3 -1
CREATE_CAR HOTRINB -1393.2231 1167.7117 264.1403 nascar11
SET_CAR_HEADING nascar11 270.1651
GET_CAR_COORDINATES nascar11 car11_cp_x car11_cp_y car11_cp_z
gosub_nascar = nascar11
GOSUB setup_nascar_stuff
driver_car11 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 4 -1
CREATE_CAR HOTRINB -1393.1036 1163.0526 264.9140 nascar12
SET_CAR_HEADING nascar12 270.3340
GET_CAR_COORDINATES nascar12 car12_cp_x car12_cp_y car12_cp_z
gosub_nascar = nascar12
GOSUB setup_nascar_stuff
driver_car12 = gosub_driver

SET_CAR_MODEL_COMPONENTS HOTRINB 5 -1
CREATE_CAR HOTRINB -1402.1838 1167.1935 264.2093 nascar13
SET_CAR_HEADING nascar13 271.0722
GET_CAR_COORDINATES nascar13 car13_cp_x car13_cp_y car13_cp_z
gosub_nascar = nascar13
GOSUB setup_nascar_stuff
driver_car13 = gosub_driver

CREATE_CAR HOTRINA -1402.3752 1163.0569 264.9016 nascar14
SET_CAR_HEADING nascar14 266.2549
GET_CAR_COORDINATES nascar14 car14_cp_x car14_cp_y car14_cp_z
gosub_nascar = nascar14
GOSUB setup_nascar_stuff
driver_car14 = gosub_driver

CREATE_CAR HOTRINB -1412.1112 1167.2113 264.2081 nascar15
SET_CAR_HEADING nascar15 273.8779
GET_CAR_COORDINATES nascar15 car15_cp_x car15_cp_y car15_cp_z
gosub_nascar = nascar15
GOSUB setup_nascar_stuff
driver_car15 = gosub_driver

CREATE_CAR HOTRING -1411.9487 1162.9200 264.9160 players_nascar
SET_CAR_HEADING players_nascar 271.2772
SET_CAR_HEALTH players_nascar 1250
SET_CAR_PROOFS players_nascar FALSE TRUE TRUE FALSE FALSE
GET_CAR_COORDINATES players_nascar player1_cp_x player1_cp_y player1_cp_z

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN
WAIT 250

true_false = 1
GOSUB freeze_all_cars

IF NOT IS_PLAYER_IN_ANY_CAR player1
	IF NOT IS_CAR_DEAD players_nascar
		WARP_PLAYER_INTO_CAR player1 players_nascar
	ENDIF
ELSE
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -1504.1985 1314.8457 265.2744
	WAIT 0
	IF NOT IS_CAR_DEAD players_nascar
		WARP_PLAYER_INTO_CAR player1 players_nascar
	ENDIF
ENDIF

PRINT_NOW HOTR_01 8000 1//~g~The Race lasts for 20 laps. Only 1st, 2nd and 3rd places qualify for winnings.
GET_GAME_TIMER game_timer

heading_done_flag = 1
USE_TEXT_COMMANDS TRUE

TIMERA = 0

ovalring_loop:

	WAIT 0

	GET_GAME_TIMER game_timer

	//LOCATE FOR LEAVING RING
	IF LOCATE_PLAYER_ON_FOOT_3D player1 -1414.7529 1155.4344 266.3521 1.5 2.0 1.5 1//-1414.8 1152.985 267.889
		PRINT_NOW HOTR_14 2500 1//~r~You have been disqualified!
		GOTO mission_ovalring_failed
	ENDIF

	//GARAGE FOR PITSTOP
	//(-1405.369 1350.573 264.936) (-1387.369 1350.573) (-1405.369 1358.573) (274.936)

	IF showcase < 5
		IF showcase > -1
			IF IS_BUTTON_PRESSED PAD1 CROSS
				IF skip_scut_button = 1
					CLEAR_SMALL_PRINTS
					showcase_timer = game_timer	- 100
					showcase = 5
				ENDIF
			ELSE
				IF skip_scut_button = 0
					skip_scut_button = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF showcase = -1
		do_winning_text_shite = 2
		IF NOT GET_FADING_STATUS
			showcase_timer = game_timer + 3000
			showcase = 0
		ENDIF
	ENDIF

	IF showcase = 0
		IF game_timer >	showcase_timer
			SET_FIXED_CAMERA_POSITION -1334.6658 1172.5107 266.2422 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1335.6278 1172.2643 266.1259 JUMP_CUT
			showcase_timer = game_timer + 3000
			showcase = 1
		ENDIF
	ENDIF

	IF showcase = 1
		IF game_timer >	showcase_timer
			SET_FIXED_CAMERA_POSITION -1323.0051 1328.0702 270.0141 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1323.9810 1328.2347 269.8705	JUMP_CUT
			PRINT_NOW HOTR_02 3500 1//~g~If your car is destroyed you will be disqualified.
			showcase_timer = game_timer + 3500
			showcase = 2
		ENDIF
	ENDIF

	IF showcase = 2
		IF game_timer >	showcase_timer
			SET_FIXED_CAMERA_POSITION -1378.5305 1355.8339 271.5822 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1379.4496 1355.7017 271.2112	JUMP_CUT
			PRINT HOTR_03 4500 1//~g~When your car is damaged you can get it repaired at the pitstop.
			showcase_timer = game_timer + 4500
			showcase = 3
		ENDIF
	ENDIF

	IF showcase = 3
		IF game_timer >	showcase_timer
			SET_FIXED_CAMERA_POSITION -1394.7645 1175.1836 269.2010 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1395.4738 1174.4955 269.0483	JUMP_CUT
			PRINT_NOW HOTR_04 4500 1//~g~This is the way to leave the stadium.
			showcase_timer = game_timer + 2500
			showcase = 4
		ENDIF
	ENDIF

	IF showcase = 4
		IF game_timer >	showcase_timer
			SET_FIXED_CAMERA_POSITION -1405.3292 1161.4934 270.4964 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -1406.1345 1160.9611 270.2356	INTERPOLATION
			showcase_timer = game_timer + 2000
			showcase = 5
		ENDIF
	ENDIF

	IF showcase = 5
		IF game_timer >	showcase_timer
			USE_TEXT_COMMANDS FALSE
			do_winning_text_shite = 0
			SET_CAMERA_BEHIND_PLAYER
			RESTORE_CAMERA_JUMPCUT
			SWITCH_WIDESCREEN OFF
			PRINT_BIG races_4 1100 4
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
			showcase_timer = game_timer + 1000
			showcase = 6
		ENDIF
	ENDIF

	IF showcase = 6
		IF game_timer >	showcase_timer
			PRINT_BIG races_5 1100 4
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
			showcase_timer = game_timer + 1000
			showcase = 7
		ENDIF
	ENDIF
	IF showcase = 7
		IF game_timer >	showcase_timer
			PRINT_BIG races_6 1100 4
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
			showcase_timer = game_timer + 1000
			showcase = 8
		ENDIF
	ENDIF
	IF showcase = 8
		IF game_timer >	showcase_timer
			IF NOT IS_CAR_DEAD players_nascar
				true_false = 0
				GOSUB freeze_all_cars
				PRINT_BIG races_7 800 4
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
				SET_PLAYER_CONTROL player1 ON
				SET_EVERYONE_IGNORE_PLAYER player1 FALSE
				SET_ALL_CARS_CAN_BE_DAMAGED TRUE
				DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING players_nascar_health COUNTER_DISPLAY_BAR 1 HOTR_05
				gosub_cpcounter = player_cpcounter
				GOSUB get_next_ovalring_checkpoint
				player1_cp_x = gosub_cp_x
				player1_cp_y = gosub_cp_y
				player1_cp_z = gosub_cp_z
				player_cpcounter = gosub_cpcounter

				DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING nascar_laps COUNTER_DISPLAY_NUMBER 2 HOTR_06
				DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING position COUNTER_DISPLAY_NUMBER 3 HOTR_09
				DISPLAY_ONSCREEN_TIMER_WITH_STRING nascar_time TIMER_UP HOTR_10
				nascar_lap_timer_start = game_timer
				showcase = 9
			ENDIF
		ENDIF
	ENDIF

	IF showcase = 9
		
		position = 1
	 	
		IF IS_CAR_DEAD players_nascar
			PRINT_NOW HOTR_12 2000 1 //~r~Your car has been destroyed!
			GOTO mission_ovalring_failed
		ELSE
			IF LOCATE_STOPPED_CAR_3D players_nascar -1396.369 1354.573 265.0766 9.0 4.0 5.0 1
				IF IS_PLAYER_SITTING_IN_CAR player1	players_nascar
					GET_CAR_HEALTH players_nascar	players_nascar_health
					players_nascar_health += 5
					IF players_nascar_health > 1250
						players_nascar_health = 1250
					ENDIF
					SET_CAR_HEALTH players_nascar players_nascar_health
				ENDIF
			ENDIF
			GET_CAR_HEALTH players_nascar players_nascar_health
			players_nascar_health -= 250
			players_nascar_health /= 10
			IF players_nascar_health < 0
				players_nascar_health = 0
			ENDIF
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 player1_cp_x player1_cp_y player1_cp_z 24.0 24.0 24.0 0
			gosub_cpcounter = player_cpcounter
			GOSUB get_next_ovalring_checkpoint
			player1_cp_x = gosub_cp_x
			player1_cp_y = gosub_cp_y
			player1_cp_z = gosub_cp_z
			player_cpcounter = gosub_cpcounter
			IF player_cpcounter = 0
				++ nascar_laps
				nascar_lap_timer = game_timer - nascar_lap_timer_start
				seconds = nascar_lap_timer / 1000
				miliseconds = seconds * 1000
				temp_int = nascar_lap_timer - miliseconds
				miliseconds = temp_int / 10
				IF nascar_best_lap_time > nascar_lap_timer
					nascar_best_lap_time = nascar_lap_timer
					REGISTER_FASTEST_TIME 21 nascar_best_lap_time //Hot Ring Best Lap Time: xx.xx seconds
					IF miliseconds > 9
						PRINT_WITH_2_NUMBERS_NOW HOTR_11 seconds miliseconds 5000 1 //~g~New best lap time: ~1~.~1~ seconds
					ELSE
						PRINT_WITH_2_NUMBERS_NOW HOTR_34 seconds miliseconds 5000 1 //~g~New best lap time: ~1~.0~1~ seconds
					ENDIF
				ENDIF
				nascar_lap_timer_start = game_timer
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ENDIF
		ENDIF
		player_result = nascar_laps * 100
		player_result += player_cpcounter
			
		IF IS_CAR_DEAD nascar1
			MARK_CAR_AS_NO_LONGER_NEEDED nascar1
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car1
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar1
				gosub_nascar = nascar1
				GOSUB setup_nascar_stuff
				driver_car1 = gosub_driver
				IF car1_laps < nascar_laps
					car1_laps = nascar_laps
				ENDIF
				car1_cpcounter =  0
				gosub_cpcounter = car1_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car1_cp_x = gosub_cp_x
				car1_cp_y = gosub_cp_y
				car1_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar1 car1_cp_x car1_cp_y car1_cp_z
				SET_CAR_FORWARD_SPEED nascar1 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar1 car1_cp_x car1_cp_y car1_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car1_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car1_cp_x = gosub_cp_x
				car1_cp_y = gosub_cp_y
				car1_cp_z = gosub_cp_z
				car1_cpcounter = gosub_cpcounter
				IF car1_cpcounter = 0
					++ car1_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar1 car1_cp_x car1_cp_y car1_cp_z
				car1_result = car1_laps * 100
				car1_result += car1_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar1 car1_stuck_x car1_stuck_y car1_stuck_z 3.0 3.0 3.0 0
				IF car1_stuck_timer < game_timer
					SET_CAR_HEALTH nascar1 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar1 car1_stuck_x car1_stuck_y car1_stuck_z
				car1_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar1 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar1_timer < game_timer
					SET_CAR_HEALTH nascar1 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar1
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car1
					nascar1 = -1
				ENDIF
			ELSE
				nascar1_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car1_result
		car = nascar1
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar2
			MARK_CAR_AS_NO_LONGER_NEEDED nascar2
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car2
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 0 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar2
				gosub_nascar = nascar2
				GOSUB setup_nascar_stuff
				driver_car2 = gosub_driver
				IF car2_laps < nascar_laps
					car2_laps = nascar_laps
				ENDIF
				car2_cpcounter =  0
				gosub_cpcounter = car2_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car2_cp_x = gosub_cp_x
				car2_cp_y = gosub_cp_y
				car2_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar2 car2_cp_x car2_cp_y car2_cp_z
				SET_CAR_FORWARD_SPEED nascar2 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar2 car2_cp_x car2_cp_y car2_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car2_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car2_cp_x = gosub_cp_x
				car2_cp_y = gosub_cp_y
				car2_cp_z = gosub_cp_z
				car2_cpcounter = gosub_cpcounter
				IF car2_cpcounter = 0
					++ car2_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar2 car2_cp_x car2_cp_y car2_cp_z
				car2_result = car2_laps * 100
				car2_result += car2_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar2 car2_stuck_x car2_stuck_y car2_stuck_z 3.0 3.0 3.0 0
				IF car2_stuck_timer < game_timer
					SET_CAR_HEALTH nascar2 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar2 car2_stuck_x car2_stuck_y car2_stuck_z
				car2_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar2 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar2_timer < game_timer
					SET_CAR_HEALTH nascar2 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar2
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car2
					nascar2 = -1
				ENDIF
			ELSE
				nascar2_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car2_result
		car = nascar2
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar3
			MARK_CAR_AS_NO_LONGER_NEEDED nascar3
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car3
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 1 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar3
				gosub_nascar = nascar3
				GOSUB setup_nascar_stuff
				driver_car3 = gosub_driver
				IF car3_laps < nascar_laps
					car3_laps = nascar_laps
				ENDIF
				car3_cpcounter =  0
				gosub_cpcounter = car3_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car3_cp_x = gosub_cp_x
				car3_cp_y = gosub_cp_y
				car3_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar3 car3_cp_x car3_cp_y car3_cp_z
				SET_CAR_FORWARD_SPEED nascar3 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar3 car3_cp_x car3_cp_y car3_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car3_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car3_cp_x = gosub_cp_x
				car3_cp_y = gosub_cp_y
				car3_cp_z = gosub_cp_z
				car3_cpcounter = gosub_cpcounter
				IF car3_cpcounter = 0
					++ car3_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar3 car3_cp_x car3_cp_y car3_cp_z
				car3_result = car3_laps * 100
				car3_result += car3_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar3 car3_stuck_x car3_stuck_y car3_stuck_z 3.0 3.0 3.0 0
				IF car3_stuck_timer < game_timer
					SET_CAR_HEALTH nascar3 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar3 car3_stuck_x car3_stuck_y car3_stuck_z
				car3_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar3 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar3_timer < game_timer
					SET_CAR_HEALTH nascar3 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar3
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car3
					nascar3 = -1
				ENDIF
			ELSE
				nascar3_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car3_result
		car = nascar3
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar4
			MARK_CAR_AS_NO_LONGER_NEEDED nascar4
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car4
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 2 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar4
				gosub_nascar = nascar4
				GOSUB setup_nascar_stuff
				driver_car4 = gosub_driver
				IF car4_laps < nascar_laps
					car4_laps = nascar_laps
				ENDIF
				car4_cpcounter =  0
				gosub_cpcounter = car4_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car4_cp_x = gosub_cp_x
				car4_cp_y = gosub_cp_y
				car4_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar4 car4_cp_x car4_cp_y car4_cp_z
				SET_CAR_FORWARD_SPEED nascar4 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar4 car4_cp_x car4_cp_y car4_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car4_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car4_cp_x = gosub_cp_x
				car4_cp_y = gosub_cp_y
				car4_cp_z = gosub_cp_z
				car4_cpcounter = gosub_cpcounter
				IF car4_cpcounter = 0
					++ car4_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar4 car4_cp_x car4_cp_y car4_cp_z
				car4_result = car4_laps * 100
				car4_result += car4_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar4 car4_stuck_x car4_stuck_y car4_stuck_z 3.0 3.0 3.0 0
				IF car4_stuck_timer < game_timer
					SET_CAR_HEALTH nascar4 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar4 car4_stuck_x car4_stuck_y car4_stuck_z
				car4_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar4 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar4_timer < game_timer
					SET_CAR_HEALTH nascar4 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar4
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car4
					nascar4 = -1
				ENDIF
			ELSE
				nascar4_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car4_result
		car = nascar4
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar5
			MARK_CAR_AS_NO_LONGER_NEEDED nascar5
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car5
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 3 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar5
				gosub_nascar = nascar5
				GOSUB setup_nascar_stuff
				driver_car5 = gosub_driver
				IF car5_laps < nascar_laps
					car5_laps = nascar_laps
				ENDIF
				car5_cpcounter =  0
				gosub_cpcounter = car5_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car5_cp_x = gosub_cp_x
				car5_cp_y = gosub_cp_y
				car5_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar5 car5_cp_x car5_cp_y car5_cp_z
				SET_CAR_FORWARD_SPEED nascar5 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar5 car5_cp_x car5_cp_y car5_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car5_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car5_cp_x = gosub_cp_x
				car5_cp_y = gosub_cp_y
				car5_cp_z = gosub_cp_z
				car5_cpcounter = gosub_cpcounter
				IF car5_cpcounter = 0
					++ car5_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar5 car5_cp_x car5_cp_y car5_cp_z
				car5_result = car5_laps * 100
				car5_result += car5_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar5 car5_stuck_x car5_stuck_y car5_stuck_z 3.0 3.0 3.0 0
				IF car5_stuck_timer < game_timer
					SET_CAR_HEALTH nascar5 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar5 car5_stuck_x car5_stuck_y car5_stuck_z
				car5_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar5 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar5_timer < game_timer
					SET_CAR_HEALTH nascar5 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar5
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car5
					nascar5 = -1
				ENDIF
			ELSE
				nascar5_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car5_result
		car = nascar5
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar6
			MARK_CAR_AS_NO_LONGER_NEEDED nascar6
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car6
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 4 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar6
				gosub_nascar = nascar6
				GOSUB setup_nascar_stuff
				driver_car6 = gosub_driver
				IF car6_laps < nascar_laps
					car6_laps = nascar_laps
				ENDIF
				car6_cpcounter =  0
				gosub_cpcounter = car6_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car6_cp_x = gosub_cp_x
				car6_cp_y = gosub_cp_y
				car6_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar6 car6_cp_x car6_cp_y car6_cp_z
				SET_CAR_FORWARD_SPEED nascar6 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar6 car6_cp_x car6_cp_y car6_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car6_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car6_cp_x = gosub_cp_x
				car6_cp_y = gosub_cp_y
				car6_cp_z = gosub_cp_z
				car6_cpcounter = gosub_cpcounter
				IF car6_cpcounter = 0
					++ car6_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar6 car6_cp_x car6_cp_y car6_cp_z
				car6_result = car6_laps * 100
				car6_result += car6_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar6 car6_stuck_x car6_stuck_y car6_stuck_z 3.0 3.0 3.0 0
				IF car6_stuck_timer < game_timer
					SET_CAR_HEALTH nascar6 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar6 car6_stuck_x car6_stuck_y car6_stuck_z
				car6_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar6 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar6_timer < game_timer
					SET_CAR_HEALTH nascar6 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar6
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car6
					nascar6 = -1
				ENDIF
			ELSE
				nascar6_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car6_result
		car = nascar6
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar7
			MARK_CAR_AS_NO_LONGER_NEEDED nascar7
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car7
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar7
				gosub_nascar = nascar7
				GOSUB setup_nascar_stuff
				driver_car7 = gosub_driver
				IF car7_laps < nascar_laps
					car7_laps = nascar_laps
				ENDIF
				car7_cpcounter =  0
				gosub_cpcounter = car7_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car7_cp_x = gosub_cp_x
				car7_cp_y = gosub_cp_y
				car7_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar7 car7_cp_x car7_cp_y car7_cp_z
				SET_CAR_FORWARD_SPEED nascar7 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar7 car7_cp_x car7_cp_y car7_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car7_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car7_cp_x = gosub_cp_x
				car7_cp_y = gosub_cp_y
				car7_cp_z = gosub_cp_z
				car7_cpcounter = gosub_cpcounter
				IF car7_cpcounter = 0
					++ car7_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar7 car7_cp_x car7_cp_y car7_cp_z
				car7_result = car7_laps * 100
				car7_result += car7_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar7 car7_stuck_x car7_stuck_y car7_stuck_z 3.0 3.0 3.0 0
				IF car7_stuck_timer < game_timer
					SET_CAR_HEALTH nascar7 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar7 car7_stuck_x car7_stuck_y car7_stuck_z
				car7_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar7 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar7_timer < game_timer
					SET_CAR_HEALTH nascar7 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar7
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car7
					nascar7 = -1
				ENDIF
			ELSE
				nascar7_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car7_result
		car = nascar7
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar8
			MARK_CAR_AS_NO_LONGER_NEEDED nascar8
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car8
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 0 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar8
				gosub_nascar = nascar8
				GOSUB setup_nascar_stuff
				driver_car8 = gosub_driver
				IF car8_laps < nascar_laps
					car8_laps = nascar_laps
				ENDIF
				car8_cpcounter =  0
				gosub_cpcounter = car8_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car8_cp_x = gosub_cp_x
				car8_cp_y = gosub_cp_y
				car8_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar8 car8_cp_x car8_cp_y car8_cp_z
				SET_CAR_FORWARD_SPEED nascar8 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar8 car8_cp_x car8_cp_y car8_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car8_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car8_cp_x = gosub_cp_x
				car8_cp_y = gosub_cp_y
				car8_cp_z = gosub_cp_z
				car8_cpcounter = gosub_cpcounter
				IF car8_cpcounter = 0
					++ car8_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar8 car8_cp_x car8_cp_y car8_cp_z
				car8_result = car8_laps * 100
				car8_result += car8_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar8 car8_stuck_x car8_stuck_y car8_stuck_z 3.0 3.0 3.0 0
				IF car8_stuck_timer < game_timer
					SET_CAR_HEALTH nascar8 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar8 car8_stuck_x car8_stuck_y car8_stuck_z
				car8_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar8 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar8_timer < game_timer
					SET_CAR_HEALTH nascar8 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar8
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car8
					nascar8 = -1
				ENDIF
			ELSE
				nascar8_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car8_result
		car = nascar8
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar9
			MARK_CAR_AS_NO_LONGER_NEEDED nascar9
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car9
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 1 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar9
				gosub_nascar = nascar9
				GOSUB setup_nascar_stuff
				driver_car9 = gosub_driver
				IF car9_laps < nascar_laps
					car9_laps = nascar_laps
				ENDIF
				car9_cpcounter =  0
				gosub_cpcounter = car9_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car9_cp_x = gosub_cp_x
				car9_cp_y = gosub_cp_y
				car9_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar9 car9_cp_x car9_cp_y car9_cp_z
				SET_CAR_FORWARD_SPEED nascar9 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar9 car9_cp_x car9_cp_y car9_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car9_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car9_cp_x = gosub_cp_x
				car9_cp_y = gosub_cp_y
				car9_cp_z = gosub_cp_z
				car9_cpcounter = gosub_cpcounter
				IF car9_cpcounter = 0
					++ car9_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar9 car9_cp_x car9_cp_y car9_cp_z
				car9_result = car9_laps * 100
				car9_result += car9_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar9 car9_stuck_x car9_stuck_y car9_stuck_z 3.0 3.0 3.0 0
				IF car9_stuck_timer < game_timer
					SET_CAR_HEALTH nascar9 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar9 car9_stuck_x car9_stuck_y car9_stuck_z
				car9_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar9 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar9_timer < game_timer
					SET_CAR_HEALTH nascar9 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar9
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car9
					nascar9 = -1
				ENDIF
			ELSE
				nascar9_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car9_result
		car = nascar9
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar10
			MARK_CAR_AS_NO_LONGER_NEEDED nascar10
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car10
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 2 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar10
				gosub_nascar = nascar10
				GOSUB setup_nascar_stuff
				driver_car10 = gosub_driver
				IF car10_laps < nascar_laps
					car10_laps = nascar_laps
				ENDIF
				car10_cpcounter =  0
				gosub_cpcounter = car10_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car10_cp_x = gosub_cp_x
				car10_cp_y = gosub_cp_y
				car10_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar10 car10_cp_x car10_cp_y car10_cp_z
				SET_CAR_FORWARD_SPEED nascar10 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar10 car10_cp_x car10_cp_y car10_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car10_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car10_cp_x = gosub_cp_x
				car10_cp_y = gosub_cp_y
				car10_cp_z = gosub_cp_z
				car10_cpcounter = gosub_cpcounter
				IF car10_cpcounter = 0
					++ car10_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar10 car10_cp_x car10_cp_y car10_cp_z
				car10_result = car10_laps * 100
				car10_result += car10_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar10 car10_stuck_x car10_stuck_y car10_stuck_z 3.0 3.0 3.0 0
				IF car10_stuck_timer < game_timer
					SET_CAR_HEALTH nascar10 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar10 car10_stuck_x car10_stuck_y car10_stuck_z
				car10_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar10 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar10_timer < game_timer
					SET_CAR_HEALTH nascar10 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar10
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car10
					nascar10 = -1
				ENDIF
			ELSE
				nascar10_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car10_result
		car = nascar10
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar11
			MARK_CAR_AS_NO_LONGER_NEEDED nascar11
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car11
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 3 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar11
				gosub_nascar = nascar11
				GOSUB setup_nascar_stuff
				driver_car11 = gosub_driver
				IF car11_laps < nascar_laps
					car11_laps = nascar_laps
				ENDIF
				car11_cpcounter =  0
				gosub_cpcounter = car11_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car11_cp_x = gosub_cp_x
				car11_cp_y = gosub_cp_y
				car11_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar11 car11_cp_x car11_cp_y car11_cp_z
				SET_CAR_FORWARD_SPEED nascar11 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar11 car11_cp_x car11_cp_y car11_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car11_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car11_cp_x = gosub_cp_x
				car11_cp_y = gosub_cp_y
				car11_cp_z = gosub_cp_z
				car11_cpcounter = gosub_cpcounter
				IF car11_cpcounter = 0
					++ car11_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar11 car11_cp_x car11_cp_y car11_cp_z
				car11_result = car11_laps * 100
				car11_result += car11_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar11 car11_stuck_x car11_stuck_y car11_stuck_z 3.0 3.0 3.0 0
				IF car11_stuck_timer < game_timer
					SET_CAR_HEALTH nascar11 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar11 car11_stuck_x car11_stuck_y car11_stuck_z
				car11_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar11 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar11_timer < game_timer
					SET_CAR_HEALTH nascar11 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar11
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car11
					nascar11 = -1
				ENDIF
			ELSE
				nascar11_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car11_result
		car = nascar11
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar12
			MARK_CAR_AS_NO_LONGER_NEEDED nascar12
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car12
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 4 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar12
				gosub_nascar = nascar12
				GOSUB setup_nascar_stuff
				driver_car12 = gosub_driver
				IF car12_laps < nascar_laps
					car12_laps = nascar_laps
				ENDIF
				car12_cpcounter =  0
				gosub_cpcounter = car12_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car12_cp_x = gosub_cp_x
				car12_cp_y = gosub_cp_y
				car12_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar12 car12_cp_x car12_cp_y car12_cp_z
				SET_CAR_FORWARD_SPEED nascar12 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar12 car12_cp_x car12_cp_y car12_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car12_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car12_cp_x = gosub_cp_x
				car12_cp_y = gosub_cp_y
				car12_cp_z = gosub_cp_z
				car12_cpcounter = gosub_cpcounter
				IF car12_cpcounter = 0
					++ car12_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar12 car12_cp_x car12_cp_y car12_cp_z
				car12_result = car12_laps * 100
				car12_result += car12_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar12 car12_stuck_x car12_stuck_y car12_stuck_z 3.0 3.0 3.0 0
				IF car12_stuck_timer < game_timer
					SET_CAR_HEALTH nascar12 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar12 car12_stuck_x car12_stuck_y car12_stuck_z
				car12_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar12 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar12_timer < game_timer
					SET_CAR_HEALTH nascar12 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar12
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car12
					nascar12 = -1
				ENDIF
			ELSE
				nascar12_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car12_result
		car = nascar12
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar13
			MARK_CAR_AS_NO_LONGER_NEEDED nascar13
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car13
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar13
				gosub_nascar = nascar13
				GOSUB setup_nascar_stuff
				driver_car13 = gosub_driver
				IF car13_laps < nascar_laps
					car13_laps = nascar_laps
				ENDIF
				car13_cpcounter =  0
				gosub_cpcounter = car13_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car13_cp_x = gosub_cp_x
				car13_cp_y = gosub_cp_y
				car13_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar13 car13_cp_x car13_cp_y car13_cp_z
				SET_CAR_FORWARD_SPEED nascar13 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar13 car13_cp_x car13_cp_y car13_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car13_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car13_cp_x = gosub_cp_x
				car13_cp_y = gosub_cp_y
				car13_cp_z = gosub_cp_z
				car13_cpcounter = gosub_cpcounter
				IF car13_cpcounter = 0
					++ car13_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar13 car13_cp_x car13_cp_y car13_cp_z
				car13_result = car13_laps * 100
				car13_result += car13_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar13 car13_stuck_x car13_stuck_y car13_stuck_z 3.0 3.0 3.0 0
				IF car13_stuck_timer < game_timer
					SET_CAR_HEALTH nascar13 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar13 car13_stuck_x car13_stuck_y car13_stuck_z
				car13_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar13 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar13_timer < game_timer
					SET_CAR_HEALTH nascar13 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar13
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car13
					nascar13 = -1
				ENDIF
			ELSE
				nascar13_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car13_result
		car = nascar13
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar14
			MARK_CAR_AS_NO_LONGER_NEEDED nascar14
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car14
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINA 0 -1
				CREATE_CAR HOTRINA -1409.7168 1144.9703 266.3857 nascar14
				gosub_nascar = nascar14
				GOSUB setup_nascar_stuff
				driver_car14 = gosub_driver
				IF car14_laps < nascar_laps
					car14_laps = nascar_laps
				ENDIF
				car14_cpcounter =  0
				gosub_cpcounter = car14_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car14_cp_x = gosub_cp_x
				car14_cp_y = gosub_cp_y
				car14_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar14 car14_cp_x car14_cp_y car14_cp_z
				SET_CAR_FORWARD_SPEED nascar14 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar14 car14_cp_x car14_cp_y car14_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car14_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car14_cp_x = gosub_cp_x
				car14_cp_y = gosub_cp_y
				car14_cp_z = gosub_cp_z
				car14_cpcounter = gosub_cpcounter
				IF car14_cpcounter = 0
					++ car14_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar14 car14_cp_x car14_cp_y car14_cp_z
				car14_result = car14_laps * 100
				car14_result += car14_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar14 car14_stuck_x car14_stuck_y car14_stuck_z 3.0 3.0 3.0 0
				IF car14_stuck_timer < game_timer
					SET_CAR_HEALTH nascar14 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar14 car14_stuck_x car14_stuck_y car14_stuck_z
				car14_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar14 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar14_timer < game_timer
					SET_CAR_HEALTH nascar14 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar14
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car14
					nascar14 = -1
				ENDIF
			ELSE
				nascar14_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car14_result
		car = nascar14
		GOSUB work_out_players_position

		IF IS_CAR_DEAD nascar15
			MARK_CAR_AS_NO_LONGER_NEEDED nascar15
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_car15
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1409.7168 1144.9703 266.3857 4.0 4.0 2.0
				SET_CAR_MODEL_COMPONENTS HOTRINB 0 -1
				CREATE_CAR HOTRINB -1409.7168 1144.9703 266.3857 nascar15
				gosub_nascar = nascar15
				GOSUB setup_nascar_stuff
				driver_car15 = gosub_driver
				IF car15_laps < nascar_laps
					car15_laps = nascar_laps
				ENDIF
				car15_cpcounter =  0
				gosub_cpcounter = car15_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car15_cp_x = gosub_cp_x
				car15_cp_y = gosub_cp_y
				car15_cp_z = gosub_cp_z
				CAR_GOTO_COORDINATES nascar15 car15_cp_x car15_cp_y car15_cp_z
				SET_CAR_FORWARD_SPEED nascar15 30.0

			ENDIF
		ELSE
			IF LOCATE_CAR_3D nascar15 car15_cp_x car15_cp_y car15_cp_z 24.0 24.0 24.0 0
				gosub_cpcounter = car15_cpcounter
				GOSUB get_next_ovalring_checkpoint
				car15_cp_x = gosub_cp_x
				car15_cp_y = gosub_cp_y
				car15_cp_z = gosub_cp_z
				car15_cpcounter = gosub_cpcounter
				IF car15_cpcounter = 0
					++ car15_laps
				ENDIF
				CAR_GOTO_COORDINATES nascar15 car15_cp_x car15_cp_y car15_cp_z
				car15_result = car15_laps * 100
				car15_result += car15_cpcounter
			ENDIF
			
			IF LOCATE_CAR_3D nascar15 car15_stuck_x car15_stuck_y car15_stuck_z 3.0 3.0 3.0 0
				IF car15_stuck_timer < game_timer
					SET_CAR_HEALTH nascar15 230
				ENDIF
			ELSE
				GET_CAR_COORDINATES	nascar15 car15_stuck_x car15_stuck_y car15_stuck_z
				car15_stuck_timer = game_timer + 5000
			ENDIF
			
			IF LOCATE_CAR_3D nascar15 -1409.7168 1144.9703 266.3857 5.0 5.0 3.0 0
				IF nascar15_timer < game_timer
					SET_CAR_HEALTH nascar15 100
					MARK_CAR_AS_NO_LONGER_NEEDED nascar15
					MARK_CHAR_AS_NO_LONGER_NEEDED driver_car15
					nascar15 = -1
				ENDIF
			ELSE
				nascar15_timer = game_timer + 3000
			ENDIF
		ENDIF
		gosub_result = car15_result
		car = nascar15
		GOSUB work_out_players_position
	ELSE
		IF NOT IS_CAR_DEAD nascar1
			SET_CAR_TEMP_ACTION nascar1 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar2
			SET_CAR_TEMP_ACTION nascar2 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar3
			SET_CAR_TEMP_ACTION nascar3 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar4
			SET_CAR_TEMP_ACTION nascar4 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar5
			SET_CAR_TEMP_ACTION nascar5 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar6
			SET_CAR_TEMP_ACTION nascar6 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar7
			SET_CAR_TEMP_ACTION nascar7 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar8
			SET_CAR_TEMP_ACTION nascar8 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar9
			SET_CAR_TEMP_ACTION nascar9 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar10
			SET_CAR_TEMP_ACTION nascar10 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar11
			SET_CAR_TEMP_ACTION nascar11 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar12
			SET_CAR_TEMP_ACTION nascar12 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar13
			SET_CAR_TEMP_ACTION nascar13 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar14
			SET_CAR_TEMP_ACTION nascar14 TEMPACT_WAIT 200
		ENDIF
		IF NOT IS_CAR_DEAD nascar15
			SET_CAR_TEMP_ACTION nascar15 TEMPACT_WAIT 200
		ENDIF
	ENDIF

	IF do_winning_text_shite = 1
		USE_TEXT_COMMANDS TRUE
		hotring_finished_timer = game_timer + 5000
		do_winning_text_shite = 3
	ENDIF
	
	IF do_winning_text_shite = 0
		IF nascar_laps = 12
			
			CLEAR_ONSCREEN_COUNTER players_nascar_health 
			CLEAR_ONSCREEN_COUNTER nascar_laps
			CLEAR_ONSCREEN_COUNTER position
			CLEAR_ONSCREEN_TIMER nascar_time
			
			IF best_nascar_result > position
				best_nascar_result = position
			ENDIF
			nascar_time /= 1000
			nascar_best_time_last = nascar_best_time
			IF nascar_best_time > nascar_time
				nascar_best_time = nascar_time
				REGISTER_FASTEST_TIME 20 nascar_best_time//Hot Ring Best Time: xx:xx
			ENDIF
			
			do_winning_text_shite = 1
			IF position = 1
				PRINT_BIG HOTR_30 6000 5//1ST PLACE
				PRINT_WITH_NUMBER_BIG HOTR_29 5000 6000 6//$~1~
				REGISTER_BEST_POSITION 0 position
				ADD_SCORE player1 5000
				IF done_ovalring_progress = 0
					PLAYER_MADE_PROGRESS 1
					REGISTER_ODDJOB_MISSION_PASSED
					done_ovalring_progress = 1
				ENDIF
			ENDIF
			IF position = 2
				PRINT_BIG HOTR_31 6000 5//2ND PLACE
				PRINT_WITH_NUMBER_BIG HOTR_29 1500 6000 6//$~1~
				REGISTER_BEST_POSITION 0 position
				ADD_SCORE player1 1500
			ENDIF
			IF position = 3
				PRINT_BIG HOTR_32 6000 5//3RD PLACE
				PRINT_WITH_NUMBER_BIG HOTR_29 500 6000 6//$~1~
				REGISTER_BEST_POSITION 0 position
				ADD_SCORE player1 500
			ENDIF
			IF position > 3
				REGISTER_BEST_POSITION 0 position
				do_winning_text_shite = 0
				PRINT_NOW HOTR_13 2000 1//~r~You didn't win the race!
				SET_FADING_COLOUR 0 0 1
				DO_FADE 1500 FADE_OUT
				WHILE GET_FADING_STATUS
					WAIT 0
				ENDWHILE
				GOTO mission_ovalring_passed
			ENDIF
		ENDIF
	ENDIF



//[HOTR_15:OVALRIG]
//Time: ~1~:~1~
//
//[HOTR_16:OVALRIG]
//Time: ~1~:0~1~
//
//[HOTR_17:OVALRIG]
//Best Time: ~1~:~1~
//
//[HOTR_18:OVALRIG]
//Best Time: ~1~:0~1~
//
//[HOTR_19:OVALRIG]
//Best Time: NA
//
//[HOTR_20:OVALRIG]
//New Best Time: ~1~:~1~
//
//[HOTR_21:OVALRIG]
//New Best Time: ~1~:0~1~
//
//[HOTR_22:OVALRIG]
//Best Result: NA
//
//[HOTR_23:OVALRIG]
//Best Result: 1st
//
//[HOTR_24:OVALRIG]
//Best Result: 2nd
//
//[HOTR_25:OVALRIG]
//Best Result: 3rd
//
//[HOTR_26:OVALRIG]
//Best Result: ~1~th
//
//[HOTR_27:OVALRIG]
//Best Lap Time: ~1~:~1~
//
//[HOTR_28:OVALRIG]
//Best Lap Time: ~1~:0~1~


IF do_winning_text_shite > 1
	
	IF do_winning_text_shite = 4
		IF NOT GET_FADING_STATUS
			GOTO mission_ovalring_passed
		ENDIF
	ENDIF
	
	IF do_winning_text_shite = 3
		IF hotring_finished_timer < game_timer
			DO_FADE 1500 FADE_OUT
			do_winning_text_shite = 4
		ENDIF
	ENDIF

	IF IS_PLAYER_IN_ANY_CAR player1
		STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
		GET_CAR_HEALTH players_car players_nascar_health
		SET_CAR_HEALTH players_car players_nascar_health
	ENDIF
	
	IF do_winning_text_shite > 2
		GOSUB setup_text_shite_hot
		SET_TEXT_SCALE 0.8 2.0
		mins = nascar_time / 60
		temp_int = mins * 60
		seconds = nascar_time - temp_int
		IF seconds > 9
			SET_TEXT_COLOUR	0 0 0 255
			DISPLAY_TEXT_WITH_2_NUMBERS 32.0 232.0 HOTR_15 mins seconds //Time: ~1~:~1~
			GOSUB setup_text_shite_hot
			SET_TEXT_SCALE 0.8 2.0
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 230.0 HOTR_15 mins seconds //Time: ~1~:~1~
		ELSE
			SET_TEXT_COLOUR	0 0 0 255
			DISPLAY_TEXT_WITH_2_NUMBERS 32.0 232.0 HOTR_16 mins seconds //Time: ~1~:0~1~
			GOSUB setup_text_shite_hot
			SET_TEXT_SCALE 0.8 2.0
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 230.0 HOTR_16 mins seconds //Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite_hot
	SET_TEXT_COLOUR	0 0 0 255
	IF nascar_best_time = 999999
		DISPLAY_TEXT 32.0 302.0 HOTR_19 //Best Time: N/A
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 300.0 HOTR_19 //Best Time: N/A
	ELSE
		mins = nascar_best_time / 60
		temp_int = mins * 60
		seconds = nascar_best_time - temp_int
		IF nascar_best_time	> nascar_best_time_last
			IF seconds > 9
				DISPLAY_TEXT_WITH_2_NUMBERS 32.0 302.0 HOTR_17 mins seconds //Best Time: ~1~:~1~
				GOSUB setup_text_shite_hot
				DISPLAY_TEXT_WITH_2_NUMBERS 30.0 300.0 HOTR_17 mins seconds //Best Time: ~1~:~1~
			ELSE
				DISPLAY_TEXT_WITH_2_NUMBERS 32.0 302.0 HOTR_18 mins seconds //Best Time: ~1~:0~1~
				GOSUB setup_text_shite_hot
				DISPLAY_TEXT_WITH_2_NUMBERS 30.0 300.0 HOTR_18 mins seconds //Best Time: ~1~:0~1~
			ENDIF
		ELSE
			IF seconds > 9
				DISPLAY_TEXT_WITH_2_NUMBERS 32.0 302.0 HOTR_20 mins seconds //NEW Best Time: ~1~:~1~
				GOSUB setup_text_shite_hot
				SET_TEXT_COLOUR 255 128 0 255
				DISPLAY_TEXT_WITH_2_NUMBERS 30.0 300.0 HOTR_20 mins seconds //NEW Best Time: ~1~:~1~
			ELSE
				DISPLAY_TEXT_WITH_2_NUMBERS 32.0 302.0 HOTR_21 mins seconds //NEW Best Time: ~1~:0~1~
				GOSUB setup_text_shite_hot
				SET_TEXT_COLOUR 255 128 0 255
				DISPLAY_TEXT_WITH_2_NUMBERS 30.0 300.0 HOTR_21 mins seconds //NEW Best Time: ~1~:0~1~
			ENDIF
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite_hot
	SET_TEXT_COLOUR	0 0 0 255
	IF best_nascar_result = 999999
		DISPLAY_TEXT 32.0 317.0 HOTR_22//Best Result: N/A
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 315.0 HOTR_22//Best Result: N/A
	ENDIF
	IF best_nascar_result = 1
		DISPLAY_TEXT 32.0 317.0 HOTR_23//Best Result: 1ST
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 315.0 HOTR_23//Best Result: 1ST
	ENDIF
	IF best_nascar_result = 2
		DISPLAY_TEXT 32.0 317.0 HOTR_24//Best Result: 2ND
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 315.0 HOTR_24//Best Result: 2ND
	ENDIF
	IF best_nascar_result = 3
		DISPLAY_TEXT 32.0 317.0 HOTR_25//Best Result: 3RD
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 315.0 HOTR_25//Best Result: 3RD
	ENDIF
	IF best_nascar_result > 3
	AND	best_nascar_result < 17
		DISPLAY_TEXT_WITH_NUMBER 32.0 317.0 HOTR_26 best_nascar_result//Best Result: ~1~TH
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT_WITH_NUMBER 30.0 315.0 HOTR_26 best_nascar_result//Best Result: ~1~TH
	ENDIF

	GOSUB setup_text_shite_hot
	SET_TEXT_COLOUR	0 0 0 255
	IF nascar_best_lap_time = 999999
		DISPLAY_TEXT 32.0 332.0 HOTR_33 //Best LAP Time: N/A
		GOSUB setup_text_shite_hot
		DISPLAY_TEXT 30.0 330.0 HOTR_33 //Best LAP Time: N/A
	ELSE
		seconds = nascar_best_lap_time / 1000
		miliseconds = seconds * 1000
		temp_int = nascar_best_lap_time - miliseconds
		miliseconds = temp_int / 10
		IF miliseconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 32.0 332.0 HOTR_27 seconds miliseconds //Best LAP Time: ~1~:~1~
			GOSUB setup_text_shite_hot
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 330.0 HOTR_27 seconds miliseconds //Best LAP Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 32.0 332.0 HOTR_28 seconds miliseconds //Best LAP Time: ~1~:0~1~
			GOSUB setup_text_shite_hot
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 330.0 HOTR_28 seconds miliseconds //Best LAP Time: ~1~:0~1~
		ENDIF
	ENDIF
ENDIF

IF TIMERA > 2500
	TIMERA = 0
	IF hot_audio_flag = 0
		hot_audio_flag = 1
	ENDIF
ENDIF

IF hot_audio_flag = 3
	IF HAS_MISSION_AUDIO_FINISHED 1
		hot_audio_flag = 0
	ENDIF
ENDIF	  

IF hot_audio_flag = 2
	IF HAS_MISSION_AUDIO_LOADED 1
		PLAY_MISSION_AUDIO 1
		hot_audio_flag = 3
	ENDIF
ENDIF

IF hot_audio_flag = 1
	GENERATE_RANDOM_INT_IN_RANGE 1 23 temp_int
	IF last_audio_played = temp_int
		++ temp_int
		IF temp_int > 22
		   	temp_int = 1
		ENDIF
	ENDIF
	IF temp_int = 1
		LOAD_MISSION_AUDIO 1 HOT1
	ENDIF
	IF temp_int = 2 
		LOAD_MISSION_AUDIO 1 HOT2
	ENDIF
	IF temp_int = 3 
		LOAD_MISSION_AUDIO 1 HOT3
	ENDIF
	IF temp_int = 4 
		LOAD_MISSION_AUDIO 1 HOT4
	ENDIF  
	IF temp_int = 5 
		LOAD_MISSION_AUDIO 1 HOT5
	ENDIF
	IF temp_int = 6 
		LOAD_MISSION_AUDIO 1 HOT6
	ENDIF
	IF temp_int = 7 
		LOAD_MISSION_AUDIO 1 HOT7
	ENDIF
	IF temp_int = 8 
		LOAD_MISSION_AUDIO 1 HOT8
	ENDIF
	IF temp_int = 9 
		LOAD_MISSION_AUDIO 1 HOT9
	ENDIF
	IF temp_int = 10 
		LOAD_MISSION_AUDIO 1 HOT10
	ENDIF
	IF temp_int = 11 
		LOAD_MISSION_AUDIO 1 HOT11
	ENDIF
	IF temp_int = 12 
		LOAD_MISSION_AUDIO 1 HOT12
	ENDIF
	IF temp_int = 13 
		LOAD_MISSION_AUDIO 1 HOT13
	ENDIF
	IF temp_int = 14 
		LOAD_MISSION_AUDIO 1 HOT14
	ENDIF
	IF temp_int = 15 
		LOAD_MISSION_AUDIO 1 HOT15
	ENDIF
	IF temp_int = 16 
	OR temp_int = 22 
		LOAD_MISSION_AUDIO 1 CHEER1
	ENDIF
	IF temp_int = 17 
		LOAD_MISSION_AUDIO 1 CHEER2
	ENDIF
	IF temp_int = 18 
		LOAD_MISSION_AUDIO 1 CHEER3
	ENDIF
	IF temp_int = 19 
		LOAD_MISSION_AUDIO 1 CHEER4
	ENDIF
	IF temp_int = 20 
		LOAD_MISSION_AUDIO 1 OOH1
	ENDIF
	IF temp_int = 21 
		LOAD_MISSION_AUDIO 1 OOH2
	ENDIF
	last_audio_played = temp_int
	hot_audio_flag = 2
ENDIF

GOTO ovalring_loop

setup_text_shite_hot:
SET_TEXT_COLOUR 180 180 180 255
SET_TEXT_JUSTIFY ON
SET_TEXT_RIGHT_JUSTIFY OFF
SET_TEXT_WRAPX 500.0
SET_TEXT_PROPORTIONAL ON
SET_TEXT_CENTRE OFF
SET_TEXT_BACKGROUND OFF
SET_TEXT_SCALE 0.6 1.6
RETURN



work_out_players_position:

IF player_result = gosub_result
	IF NOT IS_CAR_DEAD car	
		GET_CAR_COORDINATES	car car_x car_y z
		GET_DISTANCE_BETWEEN_COORDS_2D car_x car_y player1_cp_x player1_cp_y car_distance_from_cp

		GET_PLAYER_COORDINATES player1 car_x car_y z
		GET_DISTANCE_BETWEEN_COORDS_2D car_x car_y player1_cp_x player1_cp_y player1_distance_from_cp

		IF player1_distance_from_cp > car_distance_from_cp
			++ position
		ENDIF
	ENDIF
ENDIF

IF player_result < gosub_result
	++ position
ENDIF
RETURN


mission_ovalring_failed:
IF NOT HAS_DEATHARREST_BEEN_EXECUTED
	SET_FADING_COLOUR 0 0 1
	DO_FADE 1000 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
	SET_AREA_VISIBLE VIS_MAIN_MAP
	CLEAR_EXTRA_COLOURS FALSE
	SET_PLAYER_IS_IN_STADIUM FALSE
	DISPLAY_RADAR TRUE

	WHILE NOT IS_PLAYER_IN_ANY_CAR player1
	AND NOT IS_PLAYER_ON_FOOT player1
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_IN_ANY_CAR player1
		WARP_PLAYER_FROM_CAR_TO_COORD player1 -1102.7229 1330.9585 19.0290
	ELSE
		SET_PLAYER_COORDINATES player1 -1102.7229 1330.9585 19.0290
	ENDIF
	SET_PLAYER_HEADING player1 274.1051
	LOAD_SCENE -1102.7229 1330.9585 19.0290
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	SET_FADING_COLOUR 0 0 1
	DO_FADE 1000 FADE_IN
ENDIF
RETURN

   

// mission ovalring passed

mission_ovalring_passed:

IF NOT HAS_DEATHARREST_BEEN_EXECUTED
	SET_AREA_VISIBLE VIS_MAIN_MAP
	CLEAR_EXTRA_COLOURS FALSE
	SET_PLAYER_IS_IN_STADIUM FALSE
	DISPLAY_RADAR TRUE

	WHILE NOT IS_PLAYER_IN_ANY_CAR player1
	AND NOT IS_PLAYER_ON_FOOT player1
		WAIT 0
	ENDWHILE

	IF IS_PLAYER_IN_ANY_CAR player1
		WARP_PLAYER_FROM_CAR_TO_COORD player1 -1102.7229 1330.9585 19.0290
	ELSE
		SET_PLAYER_COORDINATES player1 -1102.7229 1330.9585 19.0290
	ENDIF
	SET_PLAYER_HEADING player1 274.1051
	LOAD_SCENE -1102.7229 1330.9585 19.0290
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	SET_FADING_COLOUR 0 0 1
	DO_FADE 1500 FADE_IN
ENDIF
 
RETURN
		

// mission cleanup

mission_ovalring_cleanup:

//REMOVE_BLIP blip_chase
//REMOVE_BLIP second_blip

MARK_MODEL_AS_NO_LONGER_NEEDED WMYCR
MARK_MODEL_AS_NO_LONGER_NEEDED HOTRINA
MARK_MODEL_AS_NO_LONGER_NEEDED HOTRINB
MARK_MODEL_AS_NO_LONGER_NEEDED HOTRING

CLEAR_ONSCREEN_COUNTER players_nascar_health 
CLEAR_ONSCREEN_COUNTER nascar_laps
CLEAR_ONSCREEN_COUNTER position
CLEAR_ONSCREEN_TIMER nascar_time

USE_TEXT_COMMANDS FALSE

SET_PLAYER_IS_IN_STADIUM FALSE
DISPLAY_RADAR TRUE

GET_GAME_TIMER timer_mobile_start

DISPLAY_RADAR TRUE

CLEAR_HELP

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN
		


///////////////////////////////////////////////
get_next_ovalring_checkpoint://////////////////
///////////////////////////////////////////////
	
	IF gosub_cpcounter = 0
		gosub_cp_x = cp1_x
		gosub_cp_y = cp1_y
		gosub_cp_z = cp1_z
	ENDIF

	IF gosub_cpcounter = 1
		gosub_cp_x = cp2_x
		gosub_cp_y = cp2_y
		gosub_cp_z = cp2_z
	ENDIF

	IF gosub_cpcounter = 2
		gosub_cp_x = cp3_x
		gosub_cp_y = cp3_y
		gosub_cp_z = cp3_z
	ENDIF

	IF gosub_cpcounter = 3
		gosub_cp_x = cp4_x
		gosub_cp_y = cp4_y
		gosub_cp_z = cp4_z
	ENDIF

	IF gosub_cpcounter = 4
		gosub_cp_x = cp5_x
		gosub_cp_y = cp5_y
		gosub_cp_z = cp5_z
	ENDIF

	IF gosub_cpcounter = 5
		gosub_cp_x = cp6_x
		gosub_cp_y = cp6_y
		gosub_cp_z = cp6_z
	ENDIF

	IF gosub_cpcounter = 6
		gosub_cp_x = cp7_x
		gosub_cp_y = cp7_y
		gosub_cp_z = cp7_z
	ENDIF

	IF gosub_cpcounter = 7
		gosub_cp_x = cp8_x
		gosub_cp_y = cp8_y
		gosub_cp_z = cp8_z
	ENDIF

	IF gosub_cpcounter = 8
		gosub_cp_x = cp9_x
		gosub_cp_y = cp9_y
		gosub_cp_z = cp9_z
	ENDIF

	IF gosub_cpcounter = 9
		gosub_cp_x = cp10_x
		gosub_cp_y = cp10_y
		gosub_cp_z = cp10_z
		gosub_cpcounter = -1
	ENDIF

	++ gosub_cpcounter

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////



setup_nascar_stuff:
IF heading_done_flag = 1
	SET_CAR_HEADING gosub_nascar 301.7480
ENDIF
LOCK_CAR_DOORS gosub_nascar CARLOCK_LOCKED
SET_CAR_PROOFS gosub_nascar FALSE TRUE TRUE FALSE FALSE
SET_CAR_STRAIGHT_LINE_DISTANCE gosub_nascar 5
CAR_SET_IDLE gosub_nascar
SET_CAR_DRIVING_STYLE gosub_nascar 2
SET_CAR_CRUISE_SPEED gosub_nascar 100.0
GET_DRIVER_OF_CAR gosub_nascar gosub_driver
IF gosub_driver = -1
	CREATE_CHAR_INSIDE_CAR gosub_nascar PEDTYPE_CIVMALE WMYCR gosub_driver	
	SET_CHAR_CANT_BE_DRAGGED_OUT gosub_driver TRUE
ENDIF
RETURN



freeze_all_cars:
IF NOT IS_CAR_DEAD nascar1
	FREEZE_CAR_POSITION	nascar1	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar2
	FREEZE_CAR_POSITION	nascar2	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar3
	FREEZE_CAR_POSITION	nascar3	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar4
	FREEZE_CAR_POSITION	nascar4	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar5
	FREEZE_CAR_POSITION	nascar5	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar6
	FREEZE_CAR_POSITION	nascar6	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar7
	FREEZE_CAR_POSITION	nascar7	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar8
	FREEZE_CAR_POSITION	nascar8	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar9
	FREEZE_CAR_POSITION	nascar9	true_false
ENDIF
IF NOT IS_CAR_DEAD nascar10
	FREEZE_CAR_POSITION	nascar10 true_false
ENDIF
IF NOT IS_CAR_DEAD nascar11
	FREEZE_CAR_POSITION	nascar11 true_false
ENDIF
IF NOT IS_CAR_DEAD nascar12
	FREEZE_CAR_POSITION	nascar12 true_false
ENDIF
IF NOT IS_CAR_DEAD nascar13
	FREEZE_CAR_POSITION	nascar13 true_false
ENDIF
IF NOT IS_CAR_DEAD nascar14
	FREEZE_CAR_POSITION	nascar14 true_false
ENDIF
IF NOT IS_CAR_DEAD nascar15
	FREEZE_CAR_POSITION	nascar15 true_false
ENDIF
IF NOT IS_CAR_DEAD players_nascar
	FREEZE_CAR_POSITION	players_nascar true_false
ENDIF
RETURN

}
//LOCATE FOR LEAVING RING
//IF LOCATE_PLAYER_ON_FOOT_3D player1 -1414.8 1152.985 267.889 1.5 2.0 1.5 0
//-1453.7202 1177.7979 264.5390 -1452.8524 1177.3014 264.5613 //FARAWAY LOW
//-1405.3292 1161.4934 270.4964 -1406.1345 1160.9611 270.2356 //CLOSE UP


//LOCATE FOR PIT STOP
//IF LOCATE_CAR_3D players_car -1396.369 1354.573 269.936 9.0 4.0 5.0 0
//-1323.0051 1328.0702 270.0141 -1323.9810 1328.2347 269.8705 //FAR AWAY
//-1378.5305 1355.8339 271.5822 -1379.4496 1355.7017 271.2112 //LOOKING STRAIGHT AT PITSTOP

//GARAGE FOR PITSTOP
//(-1405.369 1350.573 264.936) (-1387.369 1350.573) (-1405.369 1358.573) (274.936)

//INITIAL CAR CREATION COORDS
//-1344.17 1167.55 264.641 -85.0
//-1333.67 1169.97 264.644 -84.0
//-1323.62 1173.0 264.648  -83.0
//-1314.07 1176.62 264.651 -82.0
//-1305.08 1180.79 264.655 -81.0
//-1296.7 1185.48 264.658  -79.0
//-1288.97 1190.66 264.662 -74.0
//-1281.96 1196.29 264.665 -69.0
//-1275.69 1202.35 264.669 -64.0
//-1270.24 1208.81 264.673 -59.0
//-1265.66 1215.63 264.676 -46.0
//-1261.99 1222.77 264.68  -35.0
//-1259.3 1230.22 264.683  -25.0
//-1257.65 1237.92 264.687 -12.0
//-1257.09 1245.84 264.691 0.0
//-1257.65 1253.76 264.694 12.0
//-1259.3 1261.46 264.698  25.0


//Race for 20 laps and try to beat every competetor.
//If your car is destroyed you will be disqualified.
//When your car is damaged you can get it repaired at the pitstop.
//This is the way to leave the stadium.


//-1344.4868 1172.7334 263.8694 284.8876 
//-1343.4382 1167.8365 264.6195 281.5068 
//-1354.2965 1170.2894 263.9862 282.7367 
//-1352.8469 1165.5270 264.7497 284.2442 
//-1363.7577 1169.0784 264.0151 276.4275 
//-1363.6703 1164.1503 264.7848 277.8466 
//-1373.8792 1168.6543 264.0179 273.3020 
//-1374.5608 1163.0554 264.9375 272.9799 
//-1383.6681 1167.9469 264.1144 273.0015 
//-1383.5819 1162.9030 264.9546 269.9305 
//-1393.2231 1167.7117 264.1403 270.1651 
//-1393.1036 1163.0526 264.9140 270.3340 
//-1402.1838 1167.1935 264.2093 271.0722 
//-1402.3752 1163.0569 264.9016 266.2549 
//-1412.1112 1167.2113 264.2081 273.8779 
//-1411.9487 1162.9200 264.9160 271.2772 
//-1334.6658 1172.5107 266.2422 -1335.6278 1172.2643 266.1259 
//-1318.2053 1163.3895 273.7596 -1319.1184 1163.7313 273.5374 

