MISSION_START
// *****************************************************************************************
// *********************************** Road Races ******************************************
// *****************************************************************************************
// *** A selection of 6  races would be selectable from a notice board that the player1  ***
// *** can start at any time.															 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_races_start

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_races_failed
ENDIF

GOSUB mission_races_cleanup

MISSION_END

// ******************************** Variables for mission **********************************

//CARS PEDS OBJECTS ETC
VAR_INT race_car1 race_car2 race_car3 gosub_race_car
VAR_INT driver_car1 driver_car2 driver_car3
VAR_INT race_route_1 race_route_2 race_route_3 race_route_4 race_route_5 race_route_6
//BLIPS
VAR_INT blip_chase second_blip blip_car1 blip_car2 blip_car3
//FLAGS TIMERS COUNTERS ETC
VAR_INT player_cpcounter car1_cpcounter car2_cpcounter car3_cpcounter gosub_cpcounter
VAR_INT position race_timer car1_stuck_timer car2_stuck_timer car3_stuck_timer
VAR_INT timer_started stuck_timer position_to_store
VAR_INT total_checkpoints total_checkpoints_minus1 temp_int
VAR_INT	triangle_pressed_flag cross_pressed_flag race_choice dpadleft_pressed_flag 
VAR_INT	dpadright_pressed_flag mins seconds
VAR_INT car1_cpcounter_minus4 car2_cpcounter_minus4 car3_cpcounter_minus4
//COORD MATHS
VAR_FLOAT car_stuck_x car_stuck_y car_stuck_z
VAR_FLOAT car_x car_y car_z car_headings
VAR_FLOAT difference_x_float_d difference_y_float_d	sum_difference_d_xy	
VAR_FLOAT car1_locate_size car2_locate_size car3_locate_size
VAR_FLOAT car_distance_from_cp player1_distance_from_cp
VAR_FLOAT road1_x road1_y road1_z road2_x road2_y road2_z
VAR_FLOAT player1_cp_x player1_cp_y player1_cp_z
VAR_FLOAT blip_2nd_x blip_2nd_y blip_2nd_z
VAR_FLOAT car1_cp_x car1_cp_y car1_cp_z
VAR_FLOAT car2_cp_x car2_cp_y car2_cp_z
VAR_FLOAT car3_cp_x car3_cp_y car3_cp_z
VAR_FLOAT gosub_cp_x gosub_cp_y	gosub_cp_z gosub_cp_2nd_x gosub_cp_2nd_y gosub_cp_2nd_z

VAR_FLOAT cp0_x cp0_y cp0_z
VAR_FLOAT cp1_x cp1_y cp1_z
VAR_FLOAT cp2_x cp2_y cp2_z
VAR_FLOAT cp3_x cp3_y cp3_z
VAR_FLOAT cp4_x cp4_y cp4_z
VAR_FLOAT cp5_x cp5_y cp5_z
VAR_FLOAT cp6_x cp6_y cp6_z
VAR_FLOAT cp7_x cp7_y cp7_z
VAR_FLOAT cp8_x cp8_y cp8_z
VAR_FLOAT cp9_x cp9_y cp9_z

VAR_FLOAT cp10_x cp10_y cp10_z
VAR_FLOAT cp11_x cp11_y cp11_z
VAR_FLOAT cp12_x cp12_y cp12_z
VAR_FLOAT cp13_x cp13_y cp13_z
VAR_FLOAT cp14_x cp14_y cp14_z
VAR_FLOAT cp15_x cp15_y cp15_z
VAR_FLOAT cp16_x cp16_y cp16_z
VAR_FLOAT cp17_x cp17_y cp17_z
VAR_FLOAT cp18_x cp18_y cp18_z
VAR_FLOAT cp19_x cp19_y cp19_z

VAR_FLOAT cp20_x cp20_y cp20_z
VAR_FLOAT cp21_x cp21_y cp21_z
VAR_FLOAT cp22_x cp22_y cp22_z
VAR_FLOAT cp23_x cp23_y cp23_z
VAR_FLOAT cp24_x cp24_y cp24_z
VAR_FLOAT cp25_x cp25_y cp25_z
VAR_FLOAT cp26_x cp26_y cp26_z
VAR_FLOAT cp27_x cp27_y cp27_z
VAR_FLOAT cp28_x cp28_y cp28_z
VAR_FLOAT cp29_x cp29_y cp29_z

VAR_FLOAT cp30_x cp30_y cp30_z
VAR_FLOAT cp31_x cp31_y cp31_z
VAR_FLOAT cp32_x cp32_y cp32_z
VAR_FLOAT cp33_x cp33_y cp33_z
VAR_FLOAT cp34_x cp34_y cp34_z
VAR_FLOAT cp35_x cp35_y cp35_z
VAR_FLOAT cp36_x cp36_y cp36_z
VAR_FLOAT cp37_x cp37_y cp37_z
VAR_FLOAT cp38_x cp38_y cp38_z
VAR_FLOAT cp39_x cp39_y cp39_z

VAR_FLOAT cp40_x cp40_y cp40_z
VAR_FLOAT cp41_x cp41_y cp41_z
VAR_FLOAT cp42_x cp42_y cp42_z
VAR_FLOAT cp43_x cp43_y cp43_z
VAR_FLOAT cp44_x cp44_y cp44_z
VAR_FLOAT cp45_x cp45_y cp45_z
VAR_FLOAT cp46_x cp46_y cp46_z
VAR_FLOAT cp47_x cp47_y cp47_z
VAR_FLOAT cp48_x cp48_y cp48_z
VAR_FLOAT cp49_x cp49_y cp49_z

VAR_FLOAT cp50_x cp50_y cp50_z
VAR_FLOAT cp51_x cp51_y cp51_z
VAR_FLOAT cp52_x cp52_y cp52_z
VAR_FLOAT cp53_x cp53_y cp53_z
VAR_FLOAT cp54_x cp54_y cp54_z
VAR_FLOAT cp55_x cp55_y cp55_z
VAR_FLOAT cp56_x cp56_y cp56_z
VAR_FLOAT cp57_x cp57_y cp57_z
VAR_FLOAT cp58_x cp58_y cp58_z
VAR_FLOAT cp59_x cp59_y cp59_z

VAR_FLOAT cp60_x cp60_y cp60_z
VAR_FLOAT cp61_x cp61_y cp61_z
VAR_FLOAT cp62_x cp62_y cp62_z
VAR_FLOAT cp63_x cp63_y cp63_z
VAR_FLOAT cp64_x cp64_y cp64_z
VAR_FLOAT cp65_x cp65_y cp65_z
VAR_FLOAT cp66_x cp66_y cp66_z
VAR_FLOAT cp67_x cp67_y cp67_z
VAR_FLOAT cp68_x cp68_y cp68_z
VAR_FLOAT cp69_x cp69_y cp69_z

VAR_FLOAT cp70_x cp70_y cp70_z
VAR_FLOAT cp71_x cp71_y cp71_z
VAR_FLOAT cp72_x cp72_y cp72_z
VAR_FLOAT cp73_x cp73_y cp73_z
VAR_FLOAT cp74_x cp74_y cp74_z
VAR_FLOAT cp75_x cp75_y cp75_z
VAR_FLOAT cp76_x cp76_y cp76_z
VAR_FLOAT cp77_x cp77_y cp77_z
VAR_FLOAT cp78_x cp78_y cp78_z
VAR_FLOAT cp79_x cp79_y cp79_z

VAR_FLOAT cp80_x cp80_y cp80_z
VAR_FLOAT cp81_x cp81_y cp81_z
VAR_FLOAT cp82_x cp82_y cp82_z
VAR_FLOAT cp83_x cp83_y cp83_z
VAR_FLOAT cp84_x cp84_y cp84_z
VAR_FLOAT cp85_x cp85_y cp85_z
VAR_FLOAT cp86_x cp86_y cp86_z
VAR_FLOAT cp87_x cp87_y cp87_z
VAR_FLOAT cp88_x cp88_y cp88_z
VAR_FLOAT cp89_x cp89_y cp89_z

VAR_FLOAT cp90_x cp90_y cp90_z
VAR_FLOAT cp91_x cp91_y cp91_z
VAR_FLOAT cp92_x cp92_y cp92_z
VAR_FLOAT cp93_x cp93_y cp93_z
VAR_FLOAT cp94_x cp94_y cp94_z
VAR_FLOAT cp95_x cp95_y cp95_z
VAR_FLOAT cp96_x cp96_y cp96_z
VAR_FLOAT cp97_x cp97_y cp97_z
VAR_FLOAT cp98_x cp98_y cp98_z
VAR_FLOAT cp99_x cp99_y cp99_z

VAR_FLOAT cp100_x cp100_y cp100_z
VAR_FLOAT cp101_x cp101_y cp101_z
VAR_FLOAT cp102_x cp102_y cp102_z
VAR_FLOAT cp103_x cp103_y cp103_z
VAR_FLOAT cp104_x cp104_y cp104_z
VAR_FLOAT cp105_x cp105_y cp105_z
VAR_FLOAT cp106_x cp106_y cp106_z
VAR_FLOAT cp107_x cp107_y cp107_z
VAR_FLOAT cp108_x cp108_y cp108_z

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE var_ints
//VAR_INT car_health game_timer
//VAR_FLOAT car1_stuck_x car1_stuck_y car1_stuck_z
//VAR_FLOAT car2_stuck_x car2_stuck_y car2_stuck_z
//VAR_FLOAT car3_stuck_x car3_stuck_y car3_stuck_z

// ************************************ Mission Start **************************************

//GET_POSITION_OF_ANALOGUE_STICKS PadNumber LeftStickX LeftStickY RightStickX RightStickY

mission_races_start:

flag_player_on_mission = 1

SCRIPT_NAME race

WAIT 0
{

LVAR_FLOAT cp109_x cp109_y cp109_z
LVAR_FLOAT cp110_x cp110_y cp110_z
LVAR_FLOAT cp111_x cp111_y cp111_z
LVAR_FLOAT cp112_x cp112_y cp112_z
LVAR_FLOAT cp113_x cp113_y cp113_z

LOAD_MISSION_TEXT RACES

gosub_cpcounter   = 0
player_cpcounter  = 0
car1_cpcounter 	  = 0
car2_cpcounter 	  = 0
car3_cpcounter 	  = 0
car1_locate_size  = 7.0
car2_locate_size  = 7.0
car3_locate_size  = 7.0
race_choice = 1

position = 0
race_timer = 0
car1_stuck_timer = 0
car2_stuck_timer = 0
car3_stuck_timer = 0
timer_started = 0
stuck_timer = 0
total_checkpoints = 0
total_checkpoints_minus1 = 0
position_to_store = 0

triangle_pressed_flag = 0
cross_pressed_flag  = 0
dpadleft_pressed_flag  = 0
dpadright_pressed_flag  = 0

car1_cpcounter_minus4 = 0
car2_cpcounter_minus4 = 0
car3_cpcounter_minus4 = 0

gosub_cp_x = 0.0
gosub_cp_y = 0.0
gosub_cp_z = 0.0
gosub_cp_2nd_x = 0.0
gosub_cp_2nd_y = 0.0
gosub_cp_2nd_z = 0.0

// **************** Race Selection Message Board *****************

REQUEST_MODEL lh_race01
REQUEST_MODEL lh_race02
REQUEST_MODEL lh_race03
REQUEST_MODEL lh_race04
REQUEST_MODEL lh_race05
REQUEST_MODEL lh_race06

LOAD_ALL_MODELS_NOW

USE_TEXT_COMMANDS TRUE

WHILE NOT HAS_MODEL_LOADED lh_race01
OR NOT HAS_MODEL_LOADED	lh_race02
OR NOT HAS_MODEL_LOADED	lh_race03
OR NOT HAS_MODEL_LOADED	lh_race04
OR NOT HAS_MODEL_LOADED	lh_race05
OR NOT HAS_MODEL_LOADED	lh_race06
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SWITCH_WIDESCREEN ON

CLEAR_AREA -967.7050 -827.3005 2.0 2.0 FALSE
CLEAR_AREA -970.2131 -828.7170 1.0 1.0 FALSE
SET_PLAYER_COORDINATES player1 -970.2131 -828.7170 5.7702
SET_PLAYER_HEADING player1 90.0
SET_CAMERA_BEHIND_PLAYER

SET_FIXED_CAMERA_POSITION -971.9697 -825.7239 8.5712 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -970.9708 -825.7308 8.6162 JUMP_CUT

PRINT_HELP_FOREVER RACEHLP

GOTO races_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	CREATE_OBJECT_NO_OFFSET lh_race02 -965.584 -827.217 8.631 race_route_2
	CREATE_OBJECT_NO_OFFSET lh_race03 -965.584 -827.217 8.631 race_route_3
	CREATE_OBJECT_NO_OFFSET lh_race04 -965.584 -827.217 8.631 race_route_4
	CREATE_OBJECT_NO_OFFSET lh_race05 -965.584 -827.217 8.631 race_route_5
	CREATE_OBJECT_NO_OFFSET lh_race06 -965.584 -827.217 8.631 race_route_6
races_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

CREATE_OBJECT_NO_OFFSET lh_race01 -965.584 -827.217 8.631 race_route_1

race_selection_loop:
	
WAIT 0

GET_POSITION_OF_ANALOGUE_STICKS PAD1 LStickX LStickY RStickX RStickY

IF IS_BUTTON_PRESSED PAD1 PAD_BTN_CANCEL // FIXMIAMI: use button variables instead of copypasted code for JP version
	IF triangle_pressed_flag = 1
		triangle_pressed_flag = 0
		CLEAR_HELP
		USE_TEXT_COMMANDS FALSE
		GOTO mission_races_failed
	ENDIF
ELSE
	IF triangle_pressed_flag = 0
		triangle_pressed_flag = 1
	ENDIF
ENDIF

IF IS_BUTTON_PRESSED PAD1 DPADLEFT
OR LStickX < -100
	IF dpadleft_pressed_flag = 1
		dpadleft_pressed_flag = 0
		CLEAR_THIS_PRINT RACES19
		IF race_choice = 1
			DELETE_OBJECT race_route_1
			CREATE_OBJECT_NO_OFFSET lh_race06 -965.584 -827.217 8.631 race_route_6
			race_choice = 6
		ELSE
			IF race_choice = 2
				DELETE_OBJECT race_route_2
				CREATE_OBJECT_NO_OFFSET lh_race01 -965.584 -827.217 8.631 race_route_1
				race_choice = 1
			ELSE
				IF race_choice = 3
					DELETE_OBJECT race_route_3
					CREATE_OBJECT_NO_OFFSET lh_race02 -965.584 -827.217 8.631 race_route_2
					race_choice = 2
				ELSE
					IF race_choice = 4
						DELETE_OBJECT race_route_4
						CREATE_OBJECT_NO_OFFSET lh_race03 -965.584 -827.217 8.631 race_route_3
						race_choice = 3
					ELSE
						IF race_choice = 5
							DELETE_OBJECT race_route_5
							CREATE_OBJECT_NO_OFFSET lh_race04 -965.584 -827.217 8.631 race_route_4
							race_choice = 4
						ELSE
							DELETE_OBJECT race_route_6
							CREATE_OBJECT_NO_OFFSET lh_race05 -965.584 -827.217 8.631 race_route_5
							race_choice = 5
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF dpadleft_pressed_flag = 0
		dpadleft_pressed_flag = 1
	ENDIF
ENDIF

IF IS_BUTTON_PRESSED PAD1 DPADRIGHT
OR LStickX > 100
	IF dpadright_pressed_flag = 1
		dpadright_pressed_flag = 0
		CLEAR_THIS_PRINT RACES19
		IF race_choice = 1
			DELETE_OBJECT race_route_1
			CREATE_OBJECT_NO_OFFSET lh_race02 -965.584 -827.217 8.631 race_route_2
			race_choice = 2
		ELSE
			IF race_choice = 2
				DELETE_OBJECT race_route_2
				CREATE_OBJECT_NO_OFFSET lh_race03 -965.584 -827.217 8.631 race_route_3
				race_choice = 3
			ELSE
				IF race_choice = 3
					DELETE_OBJECT race_route_3
					CREATE_OBJECT_NO_OFFSET lh_race04 -965.584 -827.217 8.631 race_route_4
					race_choice = 4
				ELSE
					IF race_choice = 4
						DELETE_OBJECT race_route_4
						CREATE_OBJECT_NO_OFFSET lh_race05 -965.584 -827.217 8.631 race_route_5
						race_choice = 5
					ELSE
						IF race_choice = 5
							DELETE_OBJECT race_route_5
							CREATE_OBJECT_NO_OFFSET lh_race06 -965.584 -827.217 8.631 race_route_6
							race_choice = 6
						ELSE
							DELETE_OBJECT race_route_6
							CREATE_OBJECT_NO_OFFSET lh_race01 -965.584 -827.217 8.631 race_route_1
							race_choice = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF dpadright_pressed_flag = 0
		dpadright_pressed_flag = 1
	ENDIF
ENDIF

IF race_choice = 1
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES01//Terminal Velocity
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 1 748//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 1 1//Track Length: ~1~.~1~ miles
	ENDIF

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 100//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race1_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race1_best_time / 60
		temp_int = mins * 60
		seconds = race1_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race1_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race1_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race1_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race1_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race1_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF
ENDIF

IF race_choice = 2
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES02//OCEAN DRIVE
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 2 659//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 1 652//Track Length: ~1~.~1~ miles
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 500//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race2_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race2_best_time / 60
		temp_int = mins * 60
		seconds = race2_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race2_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race2_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race2_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race2_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race2_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF
ENDIF

IF race_choice = 3
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES03//BORDER RUN
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 3 1//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 1 926//Track Length: ~1~.~1~ miles
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 1000//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race3_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race3_best_time / 60
		temp_int = mins * 60
		seconds = race3_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race3_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race3_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race3_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race3_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race3_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF


ENDIF

IF race_choice = 4
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES04//CAPITAL CRUISE
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 3 924//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 2 438//Track Length: ~1~.~1~ miles
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 2000//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race4_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race4_best_time / 60
		temp_int = mins * 60
		seconds = race4_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race4_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race4_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race4_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race4_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race4_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF
ENDIF

IF race_choice = 5
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES05//TOUR!
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 4 603//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 2 86//Track Length: ~1~.~1~ miles
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 5000//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race5_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race5_best_time / 60
		temp_int = mins * 60
		seconds = race5_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race5_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race5_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race5_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race5_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race5_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF
ENDIF

IF race_choice = 6
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT_WITH_NUMBER 30.0 145.0 RACES00 race_choice//Race ~1~:

	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.8 2.0
	DISPLAY_TEXT 30.0 165.0 RACES06//ENDURANCE
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF ARE_MEASUREMENTS_IN_METRES
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES13 9 721//Track Length: ~1~.~1~ km
	ELSE
		DISPLAY_TEXT_WITH_2_NUMBERS 30.0 190.0 RACES23 6 1//Track Length: ~1~.~1~ miles
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.65 1.7
	DISPLAY_TEXT_WITH_NUMBER 30.0 220.0 RACES07 10000//Entrance Fee: $~1~
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race6_best_time = 99999999
		DISPLAY_TEXT 30.0 310.0 RACES15 //Best Time: N/A
	ELSE
		mins = race6_best_time / 60
		temp_int = mins * 60
		seconds = race6_best_time - temp_int
		IF seconds > 9
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES08 mins seconds //Best Time: ~1~:~1~
		ELSE
			DISPLAY_TEXT_WITH_2_NUMBERS 30.0 310.0 RACES22 mins seconds //Best Time: ~1~:0~1~
		ENDIF
	ENDIF
	
	GOSUB setup_text_shite
	SET_TEXT_SCALE 0.6 1.6
	IF race6_best_position = 99999999
		DISPLAY_TEXT 30.0 325.0 RACES16//Best Result: N/A
	ENDIF
	IF race6_best_position = 0
		DISPLAY_TEXT 30.0 325.0 RACES09//Best Result: 1ST
	ENDIF
	IF race6_best_position = 1
		DISPLAY_TEXT 30.0 325.0 RACES10//Best Result: 2ND
	ENDIF
	IF race6_best_position = 2
		DISPLAY_TEXT 30.0 325.0 RACES11//Best Result: 3RD
	ENDIF
	IF race6_best_position = 3
		DISPLAY_TEXT 30.0 325.0 RACES12//Best Result: 4TH
	ENDIF
ENDIF

IF IS_BUTTON_PRESSED PAD1 PAD_BTN_ACCEPT // FIXMIAMI: use button variables instead of copypasted code for JP version
	IF cross_pressed_flag = 1
		cross_pressed_flag = 0
		IF race_choice = 1
			IF IS_SCORE_GREATER player1 99
				ADD_SCORE player1 -100
				DELETE_OBJECT race_route_1
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race1_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You cannot afford to enter this race.
			ENDIF
		ENDIF
		IF race_choice = 2
			IF IS_SCORE_GREATER player1 499
				ADD_SCORE player1 -500
				DELETE_OBJECT race_route_2
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race2_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You do noy have enough money to enter this race.
			ENDIF
		ENDIF
		IF race_choice = 3
			IF IS_SCORE_GREATER player1 999
				ADD_SCORE player1 -1000
				DELETE_OBJECT race_route_3
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race3_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You do noy have enough money to enter this race.
			ENDIF
		ENDIF
		IF race_choice = 4
			IF IS_SCORE_GREATER player1 1999
				ADD_SCORE player1 -2000
				DELETE_OBJECT race_route_4
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race4_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You do noy have enough money to enter this race.
			ENDIF
		ENDIF
		IF race_choice = 5
			IF IS_SCORE_GREATER player1 4999
				ADD_SCORE player1 -5000
				DELETE_OBJECT race_route_5
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race5_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You do noy have enough money to enter this race.
			ENDIF
		ENDIF
		IF race_choice = 6
			IF IS_SCORE_GREATER player1 9999
				ADD_SCORE player1 -10000
				DELETE_OBJECT race_route_6
				CLEAR_HELP
				USE_TEXT_COMMANDS FALSE
				GOTO race6_route_checkpoints
			ELSE
				PRINT_NOW RACES19 3000 1//You do noy have enough money to enter this race.
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF cross_pressed_flag = 0
		cross_pressed_flag = 1
	ENDIF
ENDIF

GOTO race_selection_loop

setup_text_shite:
SET_TEXT_COLOUR 180 180 180 255
SET_TEXT_JUSTIFY ON
SET_TEXT_RIGHT_JUSTIFY OFF
SET_TEXT_WRAPX 500.0
SET_TEXT_PROPORTIONAL ON
SET_TEXT_CENTRE OFF
SET_TEXT_BACKGROUND OFF
RETURN



// ***************** Individual Race Coordinates *****************

//////////////////////////////////////////////////////////////////
race1_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race1_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 23

cp0_x =  -1381.9180
cp0_y =  -781.2508
cp0_z =  13.6582

cp1_x =  -1336.5432
cp1_y =  -783.2210 
cp1_z =  13.6582 

cp2_x =  -1278.3846
cp2_y =  -783.2156 
cp2_z =  13.6582 

cp3_x =  -1258.0490
cp3_y =  -762.8456 
cp3_z =  13.6582

cp4_x =  -1258.1036
cp4_y =  -695.6240 
cp4_z =  13.6582

cp5_x =  -1261.0485
cp5_y =  -569.8616 
cp5_z =  9.6582 

cp6_x =  -1320.2828
cp6_y =  -558.8130 
cp6_z =  7.4568 

cp7_x =  -1425.4246
cp7_y =  -558.7655 
cp7_z =  6.7282 

cp8_x =  -1514.0758
cp8_y =  -558.7275 
cp8_z =  6.7207 

cp9_x =  -1657.3508
cp9_y =  -558.9381 
cp9_z =  6.7207 

cp10_x = -1779.2383
cp10_y = -561.8121 
cp10_z = 6.7207 

cp11_x = -1791.5503
cp11_y = -638.3821 
cp11_z = 10.4712 

cp12_x = -1771.5676
cp12_y = -690.8166 
cp12_z = 13.6582 

cp13_x = -1748.3260
cp13_y = -664.5505 
cp13_z = 13.6509 

cp14_x = -1743.8920
cp14_y = -557.9755 
cp14_z = 13.6510 

cp15_x = -1650.8215
cp15_y = -548.6134 
cp15_z = 13.6510 

cp16_x = -1553.4575
cp16_y = -548.5882 
cp16_z = 13.6510 

cp17_x = -1530.3307
cp17_y = -620.5998 
cp17_z = 13.6510 

cp18_x = -1530.3943
cp18_y = -690.6783 
cp18_z = 13.6582 

cp19_x = -1527.1394
cp19_y = -772.0657 
cp19_z = 13.6582 

cp20_x = -1480.2424
cp20_y = -782.8588 
cp20_z = 13.6591 

cp21_x = -1437.3495
cp21_y = -830.7875 
cp21_z = 13.6000 

cp22_x = -1402.1941
cp22_y = -783.8462 
cp22_z = 13.6583

cp23_x = -1363.5989
cp23_y = -783.2463
cp23_z = 13.6728 

car1_stuck_x = -1376.6685 
car1_stuck_y = -785.4619 
car1_stuck_z = 13.6583

car2_stuck_x = -1381.9180 
car2_stuck_y = -785.4619 
car2_stuck_z = 13.6583

car3_stuck_x = -1376.6685 
car3_stuck_y = -781.2508  
car3_stuck_z = 13.6582

car_headings = 270.0

road1_x = -1400.4227 
road1_y	= -788.7123 
road1_z	= 12.2184
road2_x	= -1284.4299 
road2_y	= -778.7008 
road2_z	= 27.3309

GOTO start_the_race

//////////////////////////////////////////////////////////////////
race2_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race2_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 25

cp0_x  = 467.1591 
cp0_y  = -364.1488 
cp0_z  = 9.3083

cp1_x  = 501.4334
cp1_y  = -376.6612
cp1_z  = 9.8585 

cp2_x  = 499.6485
cp2_y  = -453.1830
cp2_z  = 9.8615

cp3_x  = 476.2756
cp3_y  = -575.4393
cp3_z  = 9.8615

cp4_x  = 427.9059
cp4_y  = -681.8521
cp4_z  = 9.8615 

cp5_x  = 362.8138
cp5_y  = -824.1959
cp5_z  = 9.8616 

cp6_x  = 307.6837
cp6_y  = -946.3491
cp6_z  = 9.8615 

cp7_x  = 278.2833
cp7_y  = -1126.9789
cp7_z  = 9.8615 

cp8_x  = 241.8716
cp8_y  = -1314.5076
cp8_z  = 9.8616
		  
cp9_x  = 219.7843
cp9_y  = -1418.3220
cp9_z  = 9.8615 

cp10_x = 189.6915
cp10_y = -1494.7349
cp10_z = 9.8616 

cp11_x = 147.4525
cp11_y = -1571.2441
cp11_z = 9.8616

cp12_x = 99.1483
cp12_y = -1588.3949
cp12_z = 9.2481 

cp13_x = 97.8935
cp13_y = -1519.7950
cp13_z = 9.2418 

cp14_x = 124.2335
cp14_y = -1445.5096
cp14_z = 9.2418

cp15_x = 162.9207
cp15_y = -1334.0569
cp15_z = 9.2418

cp16_x = 174.8059
cp16_y = -1231.0182
cp16_z = 9.2418 

cp17_x = 186.8894
cp17_y = -1129.8099
cp17_z = 9.2418

cp18_x = 211.3841
cp18_y = -1017.6858
cp18_z = 9.2418

cp19_x = 228.4807
cp19_y = -932.9751
cp19_z = 8.9034

cp20_x = 270.2189
cp20_y = -851.3670
cp20_z = 8.9777

cp21_x = 327.7973
cp21_y = -732.2568
cp21_z = 8.9778

cp22_x = 372.8638
cp22_y = -623.2525
cp22_z = 8.9778

cp23_x = 419.3767
cp23_y = -525.2839
cp23_z = 8.9778

cp24_x = 448.2071
cp24_y = -373.7212
cp24_z = 8.9777

cp25_x = 484.4896
cp25_y = -370.8366
cp25_z = 9.7451

car1_stuck_x = 473.6366 
car1_stuck_y = -372.6079 
car1_stuck_z = 9.4610 

car2_stuck_x = 467.1591 
car2_stuck_y = -370.8961 
car2_stuck_z = 9.2859

car3_stuck_x = 473.6366 
car3_stuck_y = -364.1488 
car3_stuck_z = 9.3083

car_headings = 255.0

road1_x = 461.5594 
road1_y	= -374.7564 
road1_z	= 9.0675
road2_x	= 512.8641 
road2_y	= -368.6559 
road2_z	= 27.1193

GOTO start_the_race

//////////////////////////////////////////////////////////////////
race3_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race3_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 28

cp0_x  = -1181.3199 
cp0_y  = -665.8813 
cp0_z  = 10.4318
 
cp1_x  = -1186.5488
cp1_y  = -614.5401
cp1_z  = 10.4318

cp2_x  = -1142.0183
cp2_y  = -592.1671
cp2_z  = 10.4322

cp3_x  = -1081.8369
cp3_y  = -570.2073
cp3_z  = 9.9434

cp4_x  = -1109.0149
cp4_y  = -492.9245
cp4_z  = 9.7679 

cp5_x  = -1167.6827
cp5_y  = -501.2699
cp5_z  = 9.7679

cp6_x  = -1199.6786
cp6_y  = -445.7290
cp6_z  = 9.7359 

cp7_x  = -1207.5594
cp7_y  = -373.1393
cp7_z  = 9.7359 

cp8_x  = -1175.8213
cp8_y  = -331.3841
cp8_z  = 9.6740 

cp9_x  = -1187.1481
cp9_y  = -225.0972
cp9_z  = 10.4116

cp10_x = -1167.1171
cp10_y = -94.6856
cp10_z = 10.4133 
		 
cp11_x = -1068.1528
cp11_y = -51.3555
cp11_z = 10.2300 
		 
cp12_x = -1070.6256
cp12_y = 46.5132
cp12_z = 10.2301

cp13_x = -1068.5068
cp13_y = 122.7926
cp13_z = 10.2288 

cp14_x = -1023.8616
cp14_y = 183.5805
cp14_z = 10.2292 
		 
cp15_x = -1005.5535
cp15_y = 303.4343
cp15_z = 10.2270 
		 
cp16_x = -932.2478
cp16_y = 321.5445
cp16_z = 10.2287
		 
cp17_x = -810.8220
cp17_y = 308.4724
cp17_z = 10.2199
		 
cp18_x = -722.9102
cp18_y = 266.2820
cp18_z = 9.8848
		 
cp19_x = -747.9127
cp19_y = 138.4190
cp19_z = 9.8853

cp20_x = -814.0344
cp20_y = 1.5536
cp20_z = 10.0634

cp21_x = -969.6165
cp21_y = 31.9538
cp21_z = 9.5014
		 
cp22_x = -983.0366
cp22_y = -94.5914
cp22_z = 9.5016
		 
cp23_x = -978.7145
cp23_y = -271.9747
cp23_z = 9.5334
		 
cp24_x = -862.6591
cp24_y = -306.7586
cp24_z = 9.8785

cp25_x = -865.6099
cp25_y = -410.9057
cp25_z = 9.8857

cp26_x = -845.0103
cp26_y = -553.1681
cp26_z = 9.8859

cp27_x = -852.1738
cp27_y = -650.9092
cp27_z = 10.0679
		 
cp28_x = -987.7121
cp28_y = -667.0910
cp28_z = 10.5813

cp29_x = -1165.8676
cp29_y = -688.9201
cp29_z = 10.4362

car1_stuck_x = -1178.1643 
car1_stuck_y = -659.4622 
car1_stuck_z = 10.4318

car2_stuck_x = -1177.3221 
car2_stuck_y = -665.8813 
car2_stuck_z = 10.4318

car3_stuck_x = -1182.1199 
car3_stuck_y = -659.4622 
car3_stuck_z = 10.4318

car_headings = 7.5

road1_x = -1182.2843 
road1_y	= -682.7609 
road1_z	= 8.6995
road2_x	= -1181.6384 
road2_y	= -612.6847 
road2_z	= 18.6580

GOTO start_the_race

//////////////////////////////////////////////////////////////////
race4_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race4_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 46

cp0_x =  199.3//rear right
cp0_y =  -349.2  
cp0_z =  9.4879

cp1_x =  185.792
cp1_y =  -435.777
cp1_z =  9.8329

cp2_x =  182.935
cp2_y =  -512.916
cp2_z =  10.0699

cp3_x =  178.174
cp3_y =  -595.769
cp3_z =  15.5328

cp4_x =  164.841
cp4_y =  -703.383
cp4_z =  9.4007

cp5_x =  125.795
cp5_y =  -797.664
cp5_z =  9.2780

cp6_x =  53.418
cp6_y =   -863.375
cp6_z =  9.2780 

cp7_x =  -41.8154
cp7_y =   -872.898
cp7_z =  9.2782 

cp8_x =   -103.717
cp8_y =   -920.515
cp8_z =  9.2839 

cp9_x =  -84.6704
cp9_y =  -1012.89
cp9_z =  9.2761 

cp10_x = -89.4321
cp10_y = -1080.51
cp10_z = 9.2859 

cp11_x = -170.38
cp11_y = -1099.55
cp11_z = 9.2781 

cp12_x = -196.093
cp12_y = -1126.22
cp12_z = 9.2858 

cp13_x = -201.807
cp13_y = -1206.21
cp13_z = 9.2780 

cp14_x = -200.855
cp14_y = -1281.45
cp14_z = 9.2780 

cp15_x = -186.57
cp15_y = -1360.49
cp15_z = 9.2858 

cp16_x = -153.238
cp16_y = -1454.77
cp16_z = 9.2858 

cp17_x = -102.765
cp17_y = -1546.2
cp17_z = 9.2858 

cp18_x = -44.6724
cp18_y = -1577.62
cp18_z = 9.2464 

cp19_x = -8.48371
cp19_y = -1550.96
cp19_z = 9.2780 

cp20_x = 0.0873
cp20_y = -1465.25
cp20_z = 9.2779 

cp21_x = 41.0376
cp21_y = -1381.44
cp21_z = 9.2780 
		
cp22_x = 68.6553
cp22_y = -1302.4
cp22_z = 9.2780 
		
cp23_x = 80.0833
cp23_y = -1209.07
cp23_z = 9.2780 
		
cp24_x = 83.8926
cp24_y = -1133.84
cp24_z = 9.2858 

cp25_x = 78.1786
cp25_y = -1047.17
cp25_z = 9.2780 

cp26_x = 82.9403
cp26_y =  -956.703
cp26_z = 9.2613 

cp27_x = 125.795
cp27_y =  -885.278
cp27_z = 9.2465 
		
cp28_x = 175.317
cp28_y =  -813.853
cp28_z = 9.2465 

cp29_x = 217.219
cp29_y =  -750.047
cp29_z = 9.2465 

cp30_x = 237.218
cp30_y =  -685.288
cp30_z = 9.2372 

cp31_x = 261.979
cp31_y =  -594.816
cp31_z = 8.8297 
		
cp32_x = 302.929
cp32_y =  -525.296
cp32_z = 8.8297 
		
cp33_x = 365.783
cp33_y = -448.157
cp33_z = 8.8482 
		
cp34_x = 418.162
cp34_y =  -403.397
cp34_z = 8.8482 

cp35_x = 454.35
cp35_y =  -352.924
cp35_z = 8.9641 

cp36_x = 478.159
cp36_y =  -243.405
cp36_z = 11.3418

cp37_x = 482.92
cp37_y =  -139.601
cp37_z = 9.1372 
		
cp38_x = 519.109
cp38_y = -68.1758
cp38_z = 9.5878 

cp39_x = 502.919
cp39_y = -1.51244
cp39_z = 10.0202

cp40_x = 483.873
cp40_y = 97.5303
cp40_z = 10.3040

cp41_x = 431.494
cp41_y = 56.5799
cp41_z = 10.1727
		
cp42_x = 370.545
cp42_y = 9.91558
cp42_z = 10.3602
		
cp43_x = 326.738
cp43_y = -26.2731
cp43_z = 9.9985 
		
cp44_x = 310.548
cp44_y = -109.126
cp44_z = 10.2687

cp45_x = 273.407
cp45_y =  -185.313
cp45_z = 9.8572 

cp46_x = 230.552
cp46_y = -266.261
cp46_z = 10.9620

cp47_x = 200.295
cp47_y = -367.055
cp47_z = 9.6223 

car1_stuck_x = 204.1//rear left 		  
car1_stuck_y = -349.2  
car1_stuck_z = 9.4879

car2_stuck_x = 197.8//front right 
car2_stuck_y = -356.3  		  
car2_stuck_z = 9.4879

car3_stuck_x = 202.6//front left 
car3_stuck_y = -356.3 
car3_stuck_z = 9.4879 		  

car_headings = 165.3

road1_x = 168.896 
road1_y	= -416.393 
road1_z	= 0.0
road2_x	= 221.475
road2_y	= -347.636
road2_z	= 30.0


GOTO start_the_race

//////////////////////////////////////////////////////////////////
race5_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race5_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 48

cp0_x =  192.0803 //back left
cp0_y =  -379.4206
cp0_z =  9.6766

cp1_x =  221.5820 
cp1_y =  -289.1870
cp1_z =  11.3610 

cp2_x =  253.7100 
cp2_y =  -223.9360
cp2_z =  9.8523 

cp3_x =  295.8990 
cp3_y =  -134.7660
cp3_z =  11.1339 

cp4_x =  329.4790 
cp4_y =  -17.6297 
cp4_z =  10.3388 

cp5_x =  388.7470 
cp5_y =  20.8195 
cp5_z =  14.1745 

cp6_x =  444.2090 
cp6_y =  89.5439 
cp6_z =  9.9166 

cp7_x =  399.5990 
cp7_y =  201.6730 
cp7_z =  9.8500 

cp8_x =  427.3290 
cp8_y =  305.3630 
cp8_z =  10.4397 

cp9_x =  444.6350 
cp9_y =  408.0290 
cp9_z =  10.4397 

cp10_x = 470.7340 
cp10_y = 504.3020 
cp10_z = 10.4830 

cp11_x = 496.0540 
cp11_y = 656.2190 
cp11_z = 9.8803 

cp12_x = 547.8990 
cp12_y = 751.4690 
cp12_z = 10.1808 

cp13_x = 556.3380 
cp13_y = 891.3290 
cp13_z = 13.5641 

cp14_x = 512.9340 
cp14_y = 1004.6600
cp14_z = 16.9283 

cp15_x = 500.8770 
cp15_y = 1121.6200
cp15_z = 15.2929 

cp16_x = 522.5790 
cp16_y = 1232.5400
cp16_z = 15.2502 

cp17_x = 432.1520 
cp17_y = 1281.9700
cp17_z = 16.0003 

cp18_x = 316.4060 
cp18_y = 1281.9700
cp18_z = 16.1761 

cp19_x = 219.9510 
cp19_y = 1243.3900
cp19_z = 16.1800 

cp20_x = 283.8520 
cp20_y = 1198.7800
cp20_z = 16.7968 

cp21_x = 270.5900 
cp21_y = 1121.6200
cp21_z = 18.3989 
		
cp22_x = 307.9660 
cp22_y = 1023.9500
cp22_z = 11.9725 
		
cp23_x = 320.0230 
cp23_y = 913.0310 
cp23_z = 9.8582 
		
cp24_x = 294.7030 
cp24_y = 800.9020 
cp24_z = 9.8490 

cp25_x = 219.9510 
cp25_y = 721.3260 
cp25_z = 9.8490 

cp26_x = 177.7510 
cp26_y = 671.8930 
cp26_z = 9.8490 

cp27_x = 246.4760 
cp27_y = 667.0700 
cp27_z = 9.8548 
		
cp28_x = 334.4910 
cp28_y = 670.6870 
cp28_z = 9.8524 

cp29_x = 380.3070 
cp29_y = 644.1620 
cp29_z = 10.0442 

cp30_x = 383.9250 
cp30_y = 557.3520 
cp30_z = 10.3795 

cp31_x = 380.3070 
cp31_y = 487.4220 
cp31_z = 10.6054 
		
cp32_x = 486.4080 
cp32_y = 480.1880 
cp32_z = 10.4553 
		
cp33_x = 534.6360 
cp33_y = 457.2800 
cp33_z = 9.8644 
		
cp34_x = 515.3450 
cp34_y = 352.3850 
cp34_z = 9.8673 

cp35_x = 500.8770 
cp35_y = 245.0780 
cp35_z = 9.9013 

cp36_x = 504.4940 
cp36_y = 138.9770 
cp36_z = 9.8660 

cp37_x = 477.9690 
cp37_y = 94.3666 
cp37_z = 10.1941 
		
cp38_x = 394.7760 
cp38_y = 25.6422 
cp38_z = 14.5354 

cp39_x = 328.4630 
cp39_y = -33.4368 
cp39_z = 9.8861 

cp40_x = 300.7320 
cp40_y = -127.4810
cp40_z = 10.7760 

cp41_x = 289.8810 
cp41_y = -182.9430
cp41_z = 10.4278 
		
cp42_x = 368.2510 
cp42_y = -222.7300
cp42_z = 10.7668 
		
cp43_x = 359.8110 
cp43_y = -303.5120
cp43_z = 10.8559 
		
cp44_x = 283.8520 
cp44_y = -363.7960
cp44_z = 10.7751 

cp45_x = 233.2130 
cp45_y = -425.2870
cp45_z = 10.7829 

cp46_x = 217.5390 
cp46_y = -518.1250
cp46_z = 10.7829 

cp47_x = 181.3680 
cp47_y = -526.5650
cp47_z = 10.5379 

cp48_x = 185.0610 
cp48_y = -443.3400
cp48_z = 9.8402 

cp49_x = 198.2480 
cp49_y = -371.0300
cp49_z = 9.5263 

car1_stuck_x = 198.2140 //front right
car1_stuck_y = -373.8071
car1_stuck_z = 9.5658

car2_stuck_x = 196.4444 //back right
car2_stuck_y = -380.2955
car2_stuck_z = 9.6676

car3_stuck_x = 193.9106 //front left
car3_stuck_y = -372.1646
car3_stuck_z = 9.5608

car_headings = 345.0

road1_x = 181.057 
road1_y	= -418.878
road1_z	= 0.0
road2_x	= 216.057 
road2_y	= -328.878
road2_z	= 30.0

GOTO start_the_race

//////////////////////////////////////////////////////////////////
race6_route_checkpoints://////////////////////////////////////////
//////////////////////////////////////////////////////////////////

IF done_race6_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

total_checkpoints = 112

cp0_x = -999.8854//back left
cp0_y = -945.6920
cp0_z = 13.6685

cp1_x =   -929.1530 
cp1_y =   -1029.4800
cp1_z =   13.6592 

cp2_x =   -887.9660 
cp2_y =   -1073.3500
cp2_z =   13.6478 

cp3_x =   -824.3960 
cp3_y =   -1040.2300
cp3_z =   9.8895 

cp4_x =   -823.5000 
cp4_y =   -946.2130 
cp4_z =   9.8871 

cp5_x =   -764.4070 
cp5_y =   -925.6200 
cp5_z =   9.4575 

cp6_x =   -677.5570 
cp6_y =   -930.9920 
cp6_z =   13.6473 

cp7_x =   -588.0220 
cp7_y =   -932.7820 
cp7_z =   20.4283 

cp8_x =   -492.2190 
cp8_y =   -932.7820 
cp8_z =   25.0643 

cp9_x =   -396.4150 
cp9_y =   -935.4680 
cp9_z =   22.5963 

cp10_x =  -295.2400 
cp10_y =  -939.0500 
cp10_z =  16.4214 

cp11_x =  -189.5880 
cp11_y =  -930.0960 
cp11_z =  11.0187 

cp12_x =  -104.5290 
cp12_y =  -895.1770 
cp12_z =  9.2782 

cp13_x =  -22.1561 
cp13_y =  -870.1070 
cp13_z =  9.2782 

cp14_x =  73.6471 
cp14_y =  -858.4680 
cp14_z =  9.2780 

cp15_x =  131.8450 
cp15_y =  -787.7340 
cp15_z =  9.2780 

cp16_x =  163.1830 
cp16_y =  -706.2570 
cp16_z =  9.2780 

cp17_x =  173.0320 
cp17_y =  -646.2680 
cp17_z =  15.1956 

cp18_x =  178.4040 
cp18_y =  -549.5700 
cp18_z =  10.6900 

cp19_x =  184.6710 
cp19_y =  -452.8710 
cp19_z =  9.8402 

cp20_x =  199.8920 
cp20_y =  -365.1260 
cp20_z =  9.4650 

cp21_x =  224.9620 
cp21_y =  -275.5900 
cp21_z =  10.9105 
		
cp22_x =  268.8350 
cp22_y =  -198.5900 
cp22_z =  9.8572 
		
cp23_x =  308.2310 
cp23_y =  -115.3220 
cp23_z =  9.8605 
		
cp24_x =  327.9280 
cp24_y =  -30.2626 
cp24_z =  9.9096 

cp25_x =  389.7080 
cp25_y =  20.7727 
cp25_z =  14.2094 

cp26_x =  447.0110 
cp26_y =  86.1337 
cp26_z =  9.8733 

cp27_x =  399.5570 
cp27_y =  172.9830 
cp27_z =  9.8470 
		
cp28_x =  391.4990 
cp28_y =  237.4490 
cp28_z =  9.3895 

cp29_x =  340.4630 
cp29_y =  253.5650 
cp29_z =  10.1255 

cp30_x =  334.1960 
cp30_y =  352.0550 
cp30_z =  10.4291 

cp31_x =  349.4170 
cp31_y =  444.2760 
cp31_z =  10.4235 
		
cp32_x =  378.0680 
cp32_y =  531.1260 
cp32_z =  10.4235 
		
cp33_x =  382.5450 
cp33_y =  607.2310 
cp33_z =  10.4235 
		
cp34_x =  362.8470 
cp34_y =  668.1160 
cp34_z =  9.8940 

cp35_x =  264.3580 
cp35_y =  669.9060 
cp35_z =  9.8524 

cp36_x =  207.0550 
cp36_y =  657.3710 
cp36_z =  9.8490 

cp37_x =  178.4040 
cp37_y =  670.8020 
cp37_z =  9.8490 
		
cp38_x =  196.3110 
cp38_y =  707.5110 
cp38_z =  9.8490 

cp39_x =  272.4160 
cp39_y =  765.7100 
cp39_z =  9.8514 

cp40_x =  311.8120 
cp40_y =  857.0360 
cp40_z =  9.8551 

cp41_x =  318.9750 
cp41_y =  974.3280 
cp41_z =  10.6569 
		
cp42_x =  293.9050 
cp42_y =  1067.4399 
cp42_z =  12.0802 
		
cp43_x =  273.3120 
cp43_y =  1139.0699 
cp43_z =  20.0402 
		
cp44_x =  283.1610 
cp44_y =  1200.8500 
cp44_z =  16.7887 

cp45_x =  222.2760 
cp45_y =  1234.8800 
cp45_z =  16.1800 

cp46_x =  283.1610 
cp46_y =  1281.4399 
cp46_z =  16.1801 

cp47_x =  383.4410 
cp47_y =  1281.4399 
cp47_z =  16.1761 

cp48_x =  472.9760 
cp48_y =  1278.7500 
cp48_z =  16.5197 

cp49_x =  518.6390 
cp49_y =  1258.1600 
cp49_z =  15.5517 

cp50_x =  508.7900 
cp50_y =  1164.1400 
cp50_z =  16.0812 

cp51_x =  499.8370 
cp51_y =  1074.6100 
cp51_z =  16.7323 
		
cp52_x =  519.5350 
cp52_y =  982.3860 
cp52_z =  16.9283 
		
cp53_x =  552.8780 
cp53_y =  901.8040 
cp53_z =  13.8502 
		
cp54_x =  559.8260 
cp54_y =  820.3260 
cp54_z =  11.2706 

cp55_x =  544.6050 
cp55_y =  726.3140 
cp55_z =  9.9648 

cp56_x =  522.2210 
cp56_y =  655.5810 
cp56_z =  9.9354 

cp57_x =  419.2550 
cp57_y =  680.6510 
cp57_z =  10.2006 

cp58_x =  421.0450 
cp58_y =  783.6170 
cp58_z =  10.2006 

cp59_x =  424.6270 
cp59_y =  871.3620 
cp59_z =  10.1785 

cp60_x =  404.9290 
cp60_y =  941.2000 
cp60_z =  11.4493 

cp61_x =  303.7540 
cp61_y =  950.1530 
cp61_z =  20.4129 
		
cp62_x =  190.9390 
cp62_y =  975.2230 
cp62_z =  23.2634 
		
cp63_x =  94.2402 
cp63_y =  987.7580 
cp63_z =  9.8228 
		
cp64_x =  96.268
cp64_y =  908.9670 
cp64_z =  9.7065 

cp65_x =  53.9491 
cp65_y =  863.3030 
cp65_z =  9.7037 

cp66_x =  10.9720 
cp66_y =  895.5360 
cp66_z =  9.7136 

cp67_x =  32.4606 
cp67_y =  986.8630 
cp67_z =  9.7345 

cp68_x =  33.3559 
cp68_y =  1057.6000 
cp68_z =  9.8576 

cp69_x =  15.4488 
cp69_y =  1107.7400 
cp69_z =  15.5335 

cp70_x =  -46.3308 
cp70_y =  1051.3300 
cp70_z =  9.8058 

cp71_x =  -138.5530 
cp71_y =  1075.5000 
cp71_z =  11.1801 
		
cp72_x =  -227.1930 
cp72_y =  1083.5601 
cp72_z =  19.3942 
		
cp73_x =  -314.9380 
cp73_y =  1084.4600 
cp73_z =  21.0711 
		
cp74_x =  -414.3220 
cp74_y =  1085.3500 
cp74_z =  10.4061 

cp75_x =  -505.6490 
cp75_y =  1099.6801 
cp75_z =  9.8647 

cp76_x =  -588.0220 
cp76_y =  1145.3400 
cp76_z =  9.8725 

cp77_x =  -671.2900 
cp77_y =  1181.1600 
cp77_z =  9.8725 

cp78_x =  -772.4650 
cp78_y =  1176.6801 
cp78_z =  9.8647 

cp79_x =  -856.6290 
cp79_y =  1153.4000 
cp79_z =  9.7009 

cp80_x =  -865.5820 
cp80_y =  1063.8600 
cp80_z =  9.8699 

cp81_x =  -868.2680 
cp81_y =  962.6880 
cp81_z =  9.8699 
		
cp82_x =  -870.0590 
cp82_y =  857.9310 
cp82_z =  9.8816 
		
cp83_x =  -859.3150 
cp83_y =  762.1280 
cp83_z =  9.8816 
		
cp84_x =  -755.4530 
cp84_y =  752.2790 
cp84_z =  9.8816 

cp85_x =  -672.1850 
cp85_y =  734.3720 
cp85_z =  9.9913 

cp86_x =  -676.6620 
cp86_y =  634.9870 
cp86_z =  9.8813 

cp87_x =  -685.6160 
cp87_y =  539.1840 
cp87_z =  9.8847 

cp88_x =  -695.4650 
cp88_y =  448.7530 
cp88_z =  9.8925 

cp89_x =  -704.4180 
cp89_y =  356.5310 
cp89_z =  9.8679 

cp90_x =  -728.5930 
cp90_y =  291.1700 
cp90_z =  9.9507 

cp91_x =  -798.4310 
cp91_y =  306.3910 
cp91_z =  10.2203 
		
cp92_x =  -891.5480 
cp92_y =  317.1360 
cp92_z =  10.2165 
		
cp93_x =  -976.6070 
cp93_y =  323.4030 
cp93_z =  10.1999 
		
cp94_x =  -1014.2100
cp94_y =  243.7160 
cp94_z =  10.1766 

cp95_x =  -1053.6100
cp95_y =  150.5990 
cp95_z =  10.2094 

cp96_x =  -1069.7200
cp96_y =  48.5286 
cp96_z =  10.2116 

cp97_x =  -1067.9301
cp97_y =  -15.9371 
cp97_z =  10.2118 

cp98_x =  -1080.4700
cp98_y =  -69.6585 
cp98_z =  10.3946 

cp99_x =  -1149.4100
cp99_y =  -77.7167 
cp99_z =  10.3912 

cp100_x = -1182.5400
cp100_y = -149.3450 
cp100_z = 10.3799 

cp101_x = -1183.4301
cp101_y = -251.4160 
cp101_z = 10.3807 
		
cp102_x = -1181.6400
cp102_y = -352.5910 
cp102_z = 9.7105 
		
cp103_x = -1196.8600
cp103_y = -449.2900 
cp103_z = 9.7421 
		
cp104_x = -1171.7900
cp104_y = -503.0110 
cp104_z = 9.7692 

cp105_x = -1089.4200
cp105_y = -504.8020 
cp105_z = 10.1038 

cp106_x = -1065.2500
cp106_y = -583.5930 
cp106_z = 9.9241 

cp107_x = -984.6650 
cp107_y = -583.5930 
cp107_z = 10.2854 

cp108_x = -982.8740 
cp108_y = -668.6520 
cp108_z = 10.5705 

cp109_x = -1058.9800
cp109_y = -679.3960 
cp109_z = 10.5966 

cp110_x = -1135.9800
cp110_y = -699.0940 
cp110_z = 10.5742 

cp111_x = -1111.8101
cp111_y = -789.5250 
cp111_z = 10.6719
		
cp112_x = -1071.5100
cp112_y = -865.6310 
cp112_z = 11.3928 
		
cp113_x = -995.4090 
cp113_y = -946.2130 
cp113_z = 13.6582 

car1_stuck_x = -996.9311//back right 
car1_stuck_y = -942.3224 
car1_stuck_z = 13.6511

car2_stuck_x = -991.6809//front right 
car2_stuck_y = -947.7771 
car2_stuck_z = 13.6504

car3_stuck_x = -995.0892//front left 
car3_stuck_y = -950.5623 
car3_stuck_z = 13.6674

car_headings = 223.0

road1_x = -1041.856 
road1_y	= -1004.363 
road1_z	= 0.0
road2_x	= -941.856 
road2_y	= -904.363
road2_z	= 30.0

GOTO start_the_race



// ***************************************************************

start_the_race:


/////DEBUG TO GET GROUND Z OF EACH RACE COORD
//WAIT 0
//
//GOSUB get_next_checkpoint
//player1_cp_x = gosub_cp_x
//player1_cp_y = gosub_cp_y
//player1_cp_z = gosub_cp_z
//blip_2nd_x = gosub_cp_2nd_x
//blip_2nd_y = gosub_cp_2nd_y
//blip_2nd_z = gosub_cp_2nd_z
//
//REQUEST_COLLISION player1_cp_x player1_cp_y
//LOAD_ALL_MODELS_NOW
//GET_GROUND_Z_FOR_3D_COORD player1_cp_x player1_cp_y 30.0 ground_z
//IF NOT ground_z = 0.0
//	SAVE_NEWLINE_TO_DEBUG_FILE
//	SAVE_FLOAT_TO_DEBUG_FILE player1_cp_x
//	SAVE_NEWLINE_TO_DEBUG_FILE
//	SAVE_FLOAT_TO_DEBUG_FILE player1_cp_y
//	SAVE_NEWLINE_TO_DEBUG_FILE
//	SAVE_FLOAT_TO_DEBUG_FILE ground_z
//	SAVE_NEWLINE_TO_DEBUG_FILE
//	++ gosub_cpcounter
//	ground_z = 0.0
//ENDIF
//
//IF gosub_cpcounter < 120
//	GOTO start_the_race
//ENDIF
//
//GOTO mission_races_failed
/////DEBUG TO GET GROUND Z OF EACH RACE COORD

/////DEBUG TO GET RACE DISTANCES
//WAIT 0
//GOSUB get_next_checkpoint
//GET_DISTANCE_BETWEEN_COORDS_3D gosub_cp_x gosub_cp_y gosub_cp_z gosub_cp_2nd_x gosub_cp_2nd_y gosub_cp_2nd_z distance
//distance_acrue += distance
//SAVE_NEWLINE_TO_DEBUG_FILE
//SAVE_FLOAT_TO_DEBUG_FILE gosub_cp_x
//SAVE_FLOAT_TO_DEBUG_FILE gosub_cp_y
//SAVE_FLOAT_TO_DEBUG_FILE gosub_cp_z
//SAVE_NEWLINE_TO_DEBUG_FILE
//SAVE_FLOAT_TO_DEBUG_FILE distance
//SAVE_NEWLINE_TO_DEBUG_FILE
//SAVE_FLOAT_TO_DEBUG_FILE distance_acrue
//SAVE_NEWLINE_TO_DEBUG_FILE
//++ gosub_cpcounter
//IF gosub_cpcounter < 120
//	GOTO start_the_race
//ENDIF
//GOTO mission_races_failed
/////DEBUG TO GET RACE DISTANCES

total_checkpoints_minus1 = total_checkpoints - 1

REQUEST_MODEL WMYCR
REQUEST_MODEL WFYPR
REQUEST_MODEL BMYPI
REQUEST_MODEL CHEETAH
REQUEST_MODEL INFERNUS
REQUEST_MODEL BANSHEE

ADD_BLIP_FOR_COORD cp0_x cp0_y cp0_z blip_chase

WHILE NOT HAS_MODEL_LOADED WMYCR
OR NOT HAS_MODEL_LOADED WFYPR
OR NOT HAS_MODEL_LOADED BMYPI
OR NOT HAS_MODEL_LOADED	CHEETAH
OR NOT HAS_MODEL_LOADED	INFERNUS
OR NOT HAS_MODEL_LOADED	BANSHEE
	WAIT 0
ENDWHILE

SWITCH_ROADS_OFF road1_x road1_y road1_z road2_x road2_y road2_z

CREATE_CAR CHEETAH car1_stuck_x car1_stuck_y car1_stuck_z race_car1
LOCK_CAR_DOORS race_car1 CARLOCK_LOCKED
SET_CAR_PROOFS race_car1 FALSE TRUE FALSE FALSE FALSE
SET_CAR_WATERTIGHT race_car1 TRUE
SET_CAR_STRONG race_car1 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED race_car1 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE race_car1 5
SET_CAN_BURST_CAR_TYRES race_car1 FALSE
SET_CAR_HEADING race_car1 car_headings

CREATE_CAR INFERNUS car2_stuck_x car2_stuck_y car2_stuck_z race_car2
LOCK_CAR_DOORS race_car2 CARLOCK_LOCKED
SET_CAR_PROOFS race_car2 FALSE TRUE FALSE FALSE FALSE
SET_CAR_WATERTIGHT race_car2 TRUE
SET_CAR_STRONG race_car2 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED race_car2 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE race_car2 5
SET_CAN_BURST_CAR_TYRES race_car2 FALSE
SET_CAR_HEADING race_car2 car_headings

CREATE_CAR BANSHEE car3_stuck_x car3_stuck_y car3_stuck_z race_car3
LOCK_CAR_DOORS race_car3 CARLOCK_LOCKED
SET_CAR_PROOFS race_car3 FALSE TRUE FALSE FALSE FALSE
SET_CAR_WATERTIGHT race_car3 TRUE
SET_CAR_STRONG race_car3 TRUE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED race_car3 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE race_car3 5
SET_CAN_BURST_CAR_TYRES race_car3 FALSE
SET_CAR_HEADING race_car3 car_headings

CREATE_CHAR_INSIDE_CAR race_car1 PEDTYPE_CIVMALE BMYPI driver_car1	
SET_CHAR_CANT_BE_DRAGGED_OUT driver_car1 TRUE
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE driver_car1 FALSE

CREATE_CHAR_INSIDE_CAR race_car2 PEDTYPE_CIVMALE WFYPR driver_car2	
SET_CHAR_CANT_BE_DRAGGED_OUT driver_car2 TRUE
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE driver_car2 FALSE

CREATE_CHAR_INSIDE_CAR race_car3 PEDTYPE_CIVMALE WMYCR driver_car3
SET_CHAR_CANT_BE_DRAGGED_OUT driver_car3 TRUE	
SET_CHAR_CAN_BE_SHOT_IN_VEHICLE driver_car3 FALSE

CAR_SET_IDLE race_car1
CAR_SET_IDLE race_car2
CAR_SET_IDLE race_car3

SET_CAR_DRIVING_STYLE race_car1 2
SET_CAR_CRUISE_SPEED race_car1 50.0

SET_CAR_DRIVING_STYLE race_car2 2
SET_CAR_CRUISE_SPEED race_car2 50.0

SET_CAR_DRIVING_STYLE race_car3 2
SET_CAR_CRUISE_SPEED race_car3 50.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car1 TRUE
SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car2 TRUE
SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car3 TRUE

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
SET_PLAYER_VISIBLE player1 TRUE
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

WAIT 0
WAIT 0

PRINT_NOW RACES_1 5000 1 //"~g~Get a fast car and get to the starting grid."					

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 cp0_x cp0_y cp0_z 2.0 2.0 2.0 1
							   
	WAIT 0

	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 cp0_x cp0_y cp0_z 2.0 2.0 2.0 1
		PRINT_NOW RACES_2 5000 1
	ENDIF

	IF IS_CAR_DEAD race_car1
		GOTO mission_races_failed
	ENDIF

	IF IS_CAR_DEAD race_car2
		GOTO mission_races_failed
	ENDIF

	IF IS_CAR_DEAD race_car3
		GOTO mission_races_failed
	ENDIF

	GET_CAR_HEALTH race_car1 car_health

	IF car_health < 1000
		car_health = 9
		GOTO race_start
	ENDIF

	GET_CAR_HEALTH race_car2 car_health

	IF car_health < 1000
		car_health = 9
		GOTO race_start
	ENDIF

	GET_CAR_HEALTH race_car3 car_health

	IF car_health < 1000
		car_health = 9
		GOTO race_start
	ENDIF
ENDWHILE

race_start:
SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car1 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car2 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER race_car3 FALSE

IF car_health = 9
	PRINT_BIG RACES_3 1200 4 // "3..2..1.. GO GO GO!"
ELSE
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	PRINT_BIG RACES_4 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
	WAIT 1000
	PRINT_BIG RACES_5 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
	WAIT 1000
	PRINT_BIG RACES_6 1100 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
	WAIT 1000
	PRINT_BIG RACES_7 800 4
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
ENDIF

IF IS_CAR_DEAD race_car1
	GOTO mission_races_failed
ENDIF

IF IS_CAR_DEAD race_car2
	GOTO mission_races_failed
ENDIF

IF IS_CAR_DEAD race_car3
	GOTO mission_races_failed
ENDIF

REMOVE_BLIP blip_chase

ADD_BLIP_FOR_CAR race_car1 blip_car1
CHANGE_BLIP_DISPLAY	blip_car1 MARKER_ONLY
ADD_BLIP_FOR_CAR race_car2 blip_car2
CHANGE_BLIP_DISPLAY	blip_car2 MARKER_ONLY
ADD_BLIP_FOR_CAR race_car3 blip_car3
CHANGE_BLIP_DISPLAY	blip_car3 MARKER_ONLY

GOSUB get_next_checkpoint
player1_cp_x = gosub_cp_x
player1_cp_y = gosub_cp_y
player1_cp_z = gosub_cp_z
blip_2nd_x = gosub_cp_2nd_x
blip_2nd_y = gosub_cp_2nd_y
blip_2nd_z = gosub_cp_2nd_z

car1_cp_x = gosub_cp_x
car1_cp_y = gosub_cp_y
car1_cp_z = gosub_cp_z

car2_cp_x = gosub_cp_x
car2_cp_y = gosub_cp_y
car2_cp_z = gosub_cp_z

car3_cp_x = gosub_cp_x
car3_cp_y = gosub_cp_y
car3_cp_z = gosub_cp_z

ADD_BLIP_FOR_COORD player1_cp_x player1_cp_y player1_cp_z blip_chase
CHANGE_BLIP_COLOUR blip_chase YELLOW
CHANGE_BLIP_SCALE blip_chase 3
ADD_BLIP_FOR_COORD blip_2nd_x blip_2nd_y blip_2nd_z second_blip
CHANGE_BLIP_COLOUR second_blip YELLOW
CHANGE_BLIP_SCALE second_blip 2
CAR_GOTO_COORDINATES race_car1 car1_cp_x car1_cp_y car1_cp_z
CAR_GOTO_COORDINATES race_car2 car2_cp_x car2_cp_y car2_cp_z
CAR_GOTO_COORDINATES race_car3 car3_cp_x car3_cp_y car3_cp_z

race_timer = 0
DISPLAY_ONSCREEN_TIMER_WITH_STRING race_timer TIMER_UP RACES

WHILE player_cpcounter < total_checkpoints

	WAIT 0

	GET_GAME_TIMER game_timer
	 	
	position = 0

	IF LOCATE_PLAYER_IN_CAR_3D player1 player1_cp_x player1_cp_y player1_cp_z 6.0 6.0 6.0 0
		
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		++ player_cpcounter
		
		REMOVE_BLIP blip_chase
		REMOVE_BLIP second_blip
		
		gosub_cpcounter = player_cpcounter
		GOSUB get_next_checkpoint
		player1_cp_x = gosub_cp_x
		player1_cp_y = gosub_cp_y
		player1_cp_z = gosub_cp_z
		blip_2nd_x = gosub_cp_2nd_x
		blip_2nd_y = gosub_cp_2nd_y
		blip_2nd_z = gosub_cp_2nd_z
		
		IF player_cpcounter = total_checkpoints
			GOTO mission_races_passed		
		ENDIF

		IF player_cpcounter < total_checkpoints_minus1
			ADD_BLIP_FOR_COORD player1_cp_x player1_cp_y player1_cp_z blip_chase
			CHANGE_BLIP_COLOUR blip_chase YELLOW
			CHANGE_BLIP_SCALE blip_chase 3
			ADD_BLIP_FOR_COORD blip_2nd_x blip_2nd_y blip_2nd_z second_blip
			CHANGE_BLIP_COLOUR second_blip YELLOW
			CHANGE_BLIP_SCALE second_blip 2
		ELSE
			ADD_BLIP_FOR_COORD player1_cp_x player1_cp_y player1_cp_z blip_chase
			CHANGE_BLIP_COLOUR blip_chase RED
			CHANGE_BLIP_SCALE blip_chase 3
		ENDIF
	ENDIF
			
	IF NOT IS_CAR_DEAD race_car1

		SET_CAR_HEALTH race_car1 1000
		
		gosub_race_car = race_car1
		gosub_cpcounter = car1_cpcounter
		car_stuck_x = car1_stuck_x
		car_stuck_y = car1_stuck_y
		car_stuck_z = car1_stuck_z
		timer_started = car1_stuck_timer
		GOSUB race_car_stuck_checks
		car1_stuck_x = car_stuck_x
		car1_stuck_y = car_stuck_y
		car1_stuck_z = car_stuck_z
		car1_stuck_timer = timer_started
		
		IF race_choice > 4
			car3_cpcounter_minus4 = car3_cpcounter - 4
			car2_cpcounter_minus4 = car2_cpcounter - 4
			IF car1_cpcounter < car3_cpcounter_minus4
			OR car1_cpcounter < car2_cpcounter_minus4
				IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 race_car1 200.0 200.0 0
					IF NOT IS_CAR_ON_SCREEN race_car1
						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_cp_x car1_cp_y car1_cp_z 4.0 4.0 3.0
							IF NOT IS_POINT_ON_SCREEN car1_cp_x car1_cp_y car1_cp_z 4.0
								SET_CAR_COORDINATES race_car1 car1_cp_x car1_cp_y car1_cp_z
								TURN_CAR_TO_FACE_COORD race_car1 player1_cp_x player1_cp_y
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF LOCATE_CAR_3D race_car1 car1_cp_x car1_cp_y car1_cp_z car1_locate_size car1_locate_size car1_locate_size 0
			
			++ car1_cpcounter
			gosub_cpcounter = car1_cpcounter
			GOSUB get_next_checkpoint
			car1_cp_x = gosub_cp_x
			car1_cp_y = gosub_cp_y
			car1_cp_z = gosub_cp_z
			
			IF car1_cpcounter = 17
				car1_locate_size = 6.0
			ENDIF

			IF car1_cpcounter = total_checkpoints
				PRINT_NOW RACES_8 5000 1 //"~r~You failed to win the race!"
				IF race_choice = 1
					IF race1_best_position > position_to_store
						race1_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 2
					IF race2_best_position > position_to_store
						race2_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 3
					IF race3_best_position > position_to_store
						race3_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 4
					IF race4_best_position > position_to_store
						race4_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 5
					IF race5_best_position > position_to_store
						race5_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 6
					IF race6_best_position > position_to_store
						race6_best_position = position_to_store
					ENDIF
				ENDIF
				GOTO mission_races_failed		
			ENDIF
			
			IF car1_locate_size = 7.0
				CAR_GOTO_COORDINATES race_car1 car1_cp_x car1_cp_y car1_cp_z
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE race_car1 car1_cp_x car1_cp_y car1_cp_z
			ENDIF

		ENDIF
	ELSE
		IF NOT IS_CAR_IN_WATER race_car1
			car1_cpcounter	= 0
		ENDIF

		IF IS_CAR_IN_WATER race_car1
			IF NOT IS_CAR_ON_SCREEN race_car1
				GET_CAR_COORDINATES race_car1 car_x car_y car_z
				GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 3.0
						SET_CAR_COORDINATES race_car1 car_x car_y car_z
						TURN_CAR_TO_FACE_COORD race_car1 car1_cp_x car1_cp_y
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD race_car2

		SET_CAR_HEALTH race_car2 1000
		
		gosub_race_car = race_car2
		gosub_cpcounter = car2_cpcounter
		car_stuck_x = car2_stuck_x
		car_stuck_y = car2_stuck_y
		car_stuck_z = car2_stuck_z
		timer_started = car2_stuck_timer
		GOSUB race_car_stuck_checks
		car2_stuck_x = car_stuck_x
		car2_stuck_y = car_stuck_y
		car2_stuck_z = car_stuck_z
		car2_stuck_timer = timer_started

		IF race_choice > 4
			car1_cpcounter_minus4 = car1_cpcounter - 4
			car3_cpcounter_minus4 = car3_cpcounter - 4
			IF car2_cpcounter < car1_cpcounter_minus4
			OR car2_cpcounter < car3_cpcounter_minus4
				IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 race_car2 200.0 200.0 0
					IF NOT IS_CAR_ON_SCREEN race_car2
						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_cp_x car2_cp_y car2_cp_z 4.0 4.0 3.0
							IF NOT IS_POINT_ON_SCREEN car2_cp_x car2_cp_y car2_cp_z 4.0
								SET_CAR_COORDINATES race_car2 car2_cp_x car2_cp_y car2_cp_z
								TURN_CAR_TO_FACE_COORD race_car2 player1_cp_x player1_cp_y
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF LOCATE_CAR_3D race_car2 car2_cp_x car2_cp_y car2_cp_z car2_locate_size car2_locate_size car2_locate_size 0

			++ car2_cpcounter
			gosub_cpcounter = car2_cpcounter
			GOSUB get_next_checkpoint
			car2_cp_x = gosub_cp_x
			car2_cp_y = gosub_cp_y
			car2_cp_z = gosub_cp_z

			IF car2_cpcounter = 17
				car2_locate_size = 6.0
			ENDIF

			IF car2_cpcounter = total_checkpoints
				PRINT_NOW RACES_8 5000 1 //"~r~You failed to win the race!"
				IF race_choice = 1
					IF race1_best_position > position_to_store
						race1_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 2
					IF race2_best_position > position_to_store
						race2_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 3
					IF race3_best_position > position_to_store
						race3_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 4
					IF race4_best_position > position_to_store
						race4_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 5
					IF race5_best_position > position_to_store
						race5_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 6
					IF race6_best_position > position_to_store
						race6_best_position = position_to_store
					ENDIF
				ENDIF
				GOTO mission_races_failed		
			ENDIF
			
			IF car2_locate_size = 7.0
				CAR_GOTO_COORDINATES race_car2 car2_cp_x car2_cp_y car2_cp_z
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE race_car2 car2_cp_x car2_cp_y car2_cp_z
			ENDIF

		ENDIF
	ELSE
		IF NOT IS_CAR_IN_WATER race_car2
			car2_cpcounter = 0
		ENDIF

		IF IS_CAR_IN_WATER race_car2
			IF NOT IS_CAR_ON_SCREEN race_car2
				GET_CAR_COORDINATES race_car2 car_x car_y car_z
				GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 3.0
						SET_CAR_COORDINATES race_car2 car_x car_y car_z
						TURN_CAR_TO_FACE_COORD race_car2 car2_cp_x car2_cp_y
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD race_car3
		
		SET_CAR_HEALTH race_car3 1000
		
		gosub_race_car = race_car3
		gosub_cpcounter = car3_cpcounter
		car_stuck_x = car3_stuck_x
		car_stuck_y = car3_stuck_y
		car_stuck_z = car3_stuck_z
		timer_started = car3_stuck_timer
		GOSUB race_car_stuck_checks
		car3_stuck_x = car_stuck_x
		car3_stuck_y = car_stuck_y
		car3_stuck_z = car_stuck_z
		car3_stuck_timer = timer_started
		
		IF race_choice > 4
			car1_cpcounter_minus4 = car1_cpcounter - 4
			car2_cpcounter_minus4 = car2_cpcounter - 4
			IF car3_cpcounter < car1_cpcounter_minus4
			OR car3_cpcounter < car2_cpcounter_minus4
				IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 race_car3 200.0 200.0 0
					IF NOT IS_CAR_ON_SCREEN race_car3
						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_cp_x car3_cp_y car3_cp_z 4.0 4.0 3.0
							IF NOT IS_POINT_ON_SCREEN car3_cp_x car3_cp_y car3_cp_z 4.0
								SET_CAR_COORDINATES race_car3 car3_cp_x car3_cp_y car3_cp_z
								TURN_CAR_TO_FACE_COORD race_car3 player1_cp_x player1_cp_y
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF LOCATE_CAR_3D race_car3 car3_cp_x car3_cp_y car3_cp_z car3_locate_size car3_locate_size car3_locate_size 0

			++ car3_cpcounter
			gosub_cpcounter = car3_cpcounter
			GOSUB get_next_checkpoint
			car3_cp_x = gosub_cp_x
			car3_cp_y = gosub_cp_y
			car3_cp_z = gosub_cp_z
			
			IF car3_cpcounter = 17
				car3_locate_size = 6.0
			ENDIF
			
			IF car3_cpcounter = total_checkpoints
				PRINT_NOW RACES_8 5000 1 //"~r~You failed to win the race!"
				IF race_choice = 1
					IF race1_best_position > position_to_store
						race1_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 2
					IF race2_best_position > position_to_store
						race2_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 3
					IF race3_best_position > position_to_store
						race3_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 4
					IF race4_best_position > position_to_store
						race4_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 5
					IF race5_best_position > position_to_store
						race5_best_position = position_to_store
					ENDIF
				ENDIF
				IF race_choice = 6
					IF race6_best_position > position_to_store
						race6_best_position = position_to_store
					ENDIF
				ENDIF
				GOTO mission_races_failed		
			ENDIF

			IF car3_locate_size = 7.0
				CAR_GOTO_COORDINATES race_car3 car3_cp_x car3_cp_y car3_cp_z 
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE race_car3 car3_cp_x car3_cp_y car3_cp_z 
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CAR_IN_WATER race_car3
			car3_cpcounter = 0
		ENDIF

		IF IS_CAR_IN_WATER race_car3
			IF NOT IS_CAR_ON_SCREEN race_car3
				GET_CAR_COORDINATES race_car3 car_x car_y car_z
				GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 4.0
					IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 3.0
						SET_CAR_COORDINATES race_car3 car_x car_y car_z
						TURN_CAR_TO_FACE_COORD race_car3 car3_cp_x car3_cp_y
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF position = 0
		PRINT_NOW FIRST 100 1 //"1st"
	ENDIF

	IF position = 1
		PRINT_NOW SECOND 100 1 //"2nd"
	ENDIF

	IF position = 2
		PRINT_NOW THIRD 100 1 //"3rd"
	ENDIF

	IF position = 3
		PRINT_NOW FOURTH 100 1 //"4th"
	ENDIF

	position_to_store = position

	IF player_cpcounter = total_checkpoints_minus1
		DRAW_WEAPONSHOP_CORONA player1_cp_x player1_cp_y player1_cp_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 150 0 0
	ELSE
		DRAW_WEAPONSHOP_CORONA player1_cp_x player1_cp_y player1_cp_z 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
	ENDIF

ENDWHILE

GOTO mission_races_passed	   		

	
// Mission races failed

mission_races_failed:

//PRINT_BIG M_FAIL 2000 1
RETURN

   

// mission races passed

mission_races_passed:

race_timer = race_timer / 1000
IF race_choice = 1
	REGISTER_FASTEST_TIME 6 race_timer
	IF done_race1_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race1_progress = 1
	ENDIF
ENDIF
IF race_choice = 2
	REGISTER_FASTEST_TIME 7 race_timer
	IF done_race2_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race2_progress = 1
	ENDIF
ENDIF
IF race_choice = 3
	REGISTER_FASTEST_TIME 8 race_timer
	IF done_race3_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race3_progress = 1
	ENDIF
ENDIF
IF race_choice = 4
	REGISTER_FASTEST_TIME 9 race_timer
	IF done_race4_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race4_progress = 1
	ENDIF
ENDIF
IF race_choice = 5
	REGISTER_FASTEST_TIME 10 race_timer
	IF done_race5_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race5_progress = 1
	ENDIF
ENDIF
IF race_choice = 6
	REGISTER_FASTEST_TIME 11 race_timer
	IF done_race6_progress = 0
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_race6_progress = 1
	ENDIF
ENDIF
mins = race_timer / 60
temp_int = mins * 60
seconds = race_timer - temp_int
IF race_choice = 1
	IF race1_best_time > race_timer
		race1_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race1_best_position = 0
	ADD_SCORE player1 400
	PRINT_WITH_NUMBER_BIG RACES18 400 5000 1//YOU HAVE WON: $~1~
ENDIF
IF race_choice = 2
	IF race2_best_time > race_timer
		race2_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race2_best_position = 0
	ADD_SCORE player1 2000
	PRINT_WITH_NUMBER_BIG RACES18 2000 5000 1//YOU HAVE WON: $~1~
ENDIF
IF race_choice = 3
	IF race3_best_time > race_timer
		race3_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race3_best_position = 0
	ADD_SCORE player1 4000
	PRINT_WITH_NUMBER_BIG RACES18 4000 5000 1//YOU HAVE WON: $~1~
ENDIF
IF race_choice = 4
	IF race4_best_time > race_timer
		race4_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race4_best_position = 0
	ADD_SCORE player1 8000
	PRINT_WITH_NUMBER_BIG RACES18 8000 5000 1//YOU HAVE WON: $~1~
ENDIF
IF race_choice = 5
	IF race5_best_time > race_timer
		race5_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race5_best_position = 0
	ADD_SCORE player1 20000
	PRINT_WITH_NUMBER_BIG RACES18 20000 5000 1//YOU HAVE WON: $~1~
ENDIF
IF race_choice = 6
	IF race6_best_time > race_timer
		race6_best_time = race_timer
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES17 mins seconds 10000 1 //"New best time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES20 mins seconds 10000 1 //"New best time: ~1~:0~1~"
		ENDIF
	ELSE
		IF seconds > 9
			PRINT_WITH_2_NUMBERS_NOW RACES_9 mins seconds 10000 1 //"Time: ~1~:~1~"
		ELSE
			PRINT_WITH_2_NUMBERS_NOW RACES21 mins seconds 10000 1 //"Time: ~1~:0~1~"
		ENDIF
	ENDIF
	race6_best_position = 0
	ADD_SCORE player1 40000
	PRINT_WITH_NUMBER_BIG RACES18 40000 5000 1//YOU HAVE WON: $~1~
ENDIF
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
 
RETURN
		

// mission cleanup

mission_races_cleanup:

SWITCH_ROADS_ON road1_x road1_y road1_z road2_x road2_y road2_z
REMOVE_BLIP blip_car1
REMOVE_BLIP blip_car2
REMOVE_BLIP blip_car3
REMOVE_BLIP blip_chase
REMOVE_BLIP second_blip

DELETE_OBJECT race_route_1
DELETE_OBJECT race_route_2
DELETE_OBJECT race_route_3
DELETE_OBJECT race_route_4
DELETE_OBJECT race_route_5
DELETE_OBJECT race_route_6

MARK_MODEL_AS_NO_LONGER_NEEDED WMYCR
MARK_MODEL_AS_NO_LONGER_NEEDED WFYPR
MARK_MODEL_AS_NO_LONGER_NEEDED BMYPI
MARK_MODEL_AS_NO_LONGER_NEEDED CHEETAH
MARK_MODEL_AS_NO_LONGER_NEEDED INFERNUS
MARK_MODEL_AS_NO_LONGER_NEEDED BANSHEE
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race01
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race02
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race03
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race04
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race05
MARK_MODEL_AS_NO_LONGER_NEEDED lh_race06

CLEAR_ONSCREEN_TIMER race_timer

GET_GAME_TIMER timer_mobile_start

USE_TEXT_COMMANDS FALSE
CLEAR_HELP

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN
		


///////////////////////////////////////////////
get_next_checkpoint:///////////////////////////
///////////////////////////////////////////////

	IF gosub_cpcounter = -1
		gosub_cp_x = cp0_x
		gosub_cp_y = cp0_y
		gosub_cp_z = cp0_z
		gosub_cp_2nd_x = cp1_x
		gosub_cp_2nd_y = cp1_y
		gosub_cp_2nd_z = cp1_z
	ENDIF

	IF gosub_cpcounter = 0
		gosub_cp_x = cp1_x
		gosub_cp_y = cp1_y
		gosub_cp_z = cp1_z
		gosub_cp_2nd_x = cp2_x
		gosub_cp_2nd_y = cp2_y
		gosub_cp_2nd_z = cp2_z
	ENDIF

	IF gosub_cpcounter = 1
		gosub_cp_x = cp2_x
		gosub_cp_y = cp2_y
		gosub_cp_z = cp2_z
		gosub_cp_2nd_x = cp3_x
		gosub_cp_2nd_y = cp3_y
		gosub_cp_2nd_z = cp3_z
	ENDIF

	IF gosub_cpcounter = 2
		gosub_cp_x = cp3_x
		gosub_cp_y = cp3_y
		gosub_cp_z = cp3_z
		gosub_cp_2nd_x = cp4_x
		gosub_cp_2nd_y = cp4_y
		gosub_cp_2nd_z = cp4_z
	ENDIF

	IF gosub_cpcounter = 3
		gosub_cp_x = cp4_x
		gosub_cp_y = cp4_y
		gosub_cp_z = cp4_z
		gosub_cp_2nd_x = cp5_x
		gosub_cp_2nd_y = cp5_y
		gosub_cp_2nd_z = cp5_z
	ENDIF

	IF gosub_cpcounter = 4
		gosub_cp_x = cp5_x
		gosub_cp_y = cp5_y
		gosub_cp_z = cp5_z
		gosub_cp_2nd_x = cp6_x
		gosub_cp_2nd_y = cp6_y
		gosub_cp_2nd_z = cp6_z
	ENDIF

	IF gosub_cpcounter = 5
		gosub_cp_x = cp6_x
		gosub_cp_y = cp6_y
		gosub_cp_z = cp6_z
		gosub_cp_2nd_x = cp7_x
		gosub_cp_2nd_y = cp7_y
		gosub_cp_2nd_z = cp7_z
	ENDIF

	IF gosub_cpcounter = 6
		gosub_cp_x = cp7_x
		gosub_cp_y = cp7_y
		gosub_cp_z = cp7_z
		gosub_cp_2nd_x = cp8_x
		gosub_cp_2nd_y = cp8_y
		gosub_cp_2nd_z = cp8_z
	ENDIF

	IF gosub_cpcounter = 7
		gosub_cp_x = cp8_x
		gosub_cp_y = cp8_y
		gosub_cp_z = cp8_z
		gosub_cp_2nd_x = cp9_x
		gosub_cp_2nd_y = cp9_y
		gosub_cp_2nd_z = cp9_z
	ENDIF
//
	IF gosub_cpcounter = 8
		gosub_cp_x = cp9_x
		gosub_cp_y = cp9_y
		gosub_cp_z = cp9_z
		gosub_cp_2nd_x = cp10_x
		gosub_cp_2nd_y = cp10_y
		gosub_cp_2nd_z = cp10_z
	ENDIF

	IF gosub_cpcounter = 9
		gosub_cp_x = cp10_x
		gosub_cp_y = cp10_y
		gosub_cp_z = cp10_z
		gosub_cp_2nd_x = cp11_x
		gosub_cp_2nd_y = cp11_y
		gosub_cp_2nd_z = cp11_z
	ENDIF

	IF gosub_cpcounter = 10
		gosub_cp_x = cp11_x
		gosub_cp_y = cp11_y
		gosub_cp_z = cp11_z
		gosub_cp_2nd_x = cp12_x
		gosub_cp_2nd_y = cp12_y
		gosub_cp_2nd_z = cp12_z
	ENDIF

	IF gosub_cpcounter = 11
		gosub_cp_x = cp12_x
		gosub_cp_y = cp12_y
		gosub_cp_z = cp12_z
		gosub_cp_2nd_x = cp13_x
		gosub_cp_2nd_y = cp13_y
		gosub_cp_2nd_z = cp13_z
	ENDIF

	IF gosub_cpcounter = 12
		gosub_cp_x = cp13_x
		gosub_cp_y = cp13_y
		gosub_cp_z = cp13_z
		gosub_cp_2nd_x = cp14_x
		gosub_cp_2nd_y = cp14_y
		gosub_cp_2nd_z = cp14_z
	ENDIF

	IF gosub_cpcounter = 13
		gosub_cp_x = cp14_x
		gosub_cp_y = cp14_y
		gosub_cp_z = cp14_z
		gosub_cp_2nd_x = cp15_x
		gosub_cp_2nd_y = cp15_y
		gosub_cp_2nd_z = cp15_z
	ENDIF

	IF gosub_cpcounter = 14
		gosub_cp_x = cp15_x
		gosub_cp_y = cp15_y
		gosub_cp_z = cp15_z
		gosub_cp_2nd_x = cp16_x
		gosub_cp_2nd_y = cp16_y
		gosub_cp_2nd_z = cp16_z
	ENDIF

	IF gosub_cpcounter = 15
		gosub_cp_x = cp16_x
		gosub_cp_y = cp16_y
		gosub_cp_z = cp16_z
		gosub_cp_2nd_x = cp17_x
		gosub_cp_2nd_y = cp17_y
		gosub_cp_2nd_z = cp17_z
	ENDIF

	IF gosub_cpcounter = 16
		gosub_cp_x = cp17_x
		gosub_cp_y = cp17_y
		gosub_cp_z = cp17_z
		gosub_cp_2nd_x = cp18_x
		gosub_cp_2nd_y = cp18_y
		gosub_cp_2nd_z = cp18_z
	ENDIF

	IF gosub_cpcounter = 17
		gosub_cp_x = cp18_x
		gosub_cp_y = cp18_y
		gosub_cp_z = cp18_z
		gosub_cp_2nd_x = cp19_x
		gosub_cp_2nd_y = cp19_y
		gosub_cp_2nd_z = cp19_z
	ENDIF
//
	IF gosub_cpcounter = 18
		gosub_cp_x = cp19_x
		gosub_cp_y = cp19_y
		gosub_cp_z = cp19_z
		gosub_cp_2nd_x = cp20_x
		gosub_cp_2nd_y = cp20_y
		gosub_cp_2nd_z = cp20_z
	ENDIF

	IF gosub_cpcounter = 19
		gosub_cp_x = cp20_x
		gosub_cp_y = cp20_y
		gosub_cp_z = cp20_z
		gosub_cp_2nd_x = cp21_x
		gosub_cp_2nd_y = cp21_y
		gosub_cp_2nd_z = cp21_z
	ENDIF

	IF gosub_cpcounter = 20
		gosub_cp_x = cp21_x
		gosub_cp_y = cp21_y
		gosub_cp_z = cp21_z
		gosub_cp_2nd_x = cp22_x
		gosub_cp_2nd_y = cp22_y
		gosub_cp_2nd_z = cp22_z
	ENDIF

	IF gosub_cpcounter = 21
		gosub_cp_x = cp22_x
		gosub_cp_y = cp22_y
		gosub_cp_z = cp22_z
		gosub_cp_2nd_x = cp23_x
		gosub_cp_2nd_y = cp23_y
		gosub_cp_2nd_z = cp23_z
	ENDIF

	IF gosub_cpcounter = 22
		gosub_cp_x = cp23_x
		gosub_cp_y = cp23_y
		gosub_cp_z = cp23_z
		gosub_cp_2nd_x = cp24_x
		gosub_cp_2nd_y = cp24_y
		gosub_cp_2nd_z = cp24_z
	ENDIF

	IF gosub_cpcounter = 23
		gosub_cp_x = cp24_x
		gosub_cp_y = cp24_y
		gosub_cp_z = cp24_z
		gosub_cp_2nd_x = cp25_x
		gosub_cp_2nd_y = cp25_y
		gosub_cp_2nd_z = cp25_z
	ENDIF

	IF gosub_cpcounter = 24
		gosub_cp_x = cp25_x
		gosub_cp_y = cp25_y
		gosub_cp_z = cp25_z
		gosub_cp_2nd_x = cp26_x
		gosub_cp_2nd_y = cp26_y
		gosub_cp_2nd_z = cp26_z
	ENDIF

	IF gosub_cpcounter = 25
		gosub_cp_x = cp26_x
		gosub_cp_y = cp26_y
		gosub_cp_z = cp26_z
		gosub_cp_2nd_x = cp27_x
		gosub_cp_2nd_y = cp27_y
		gosub_cp_2nd_z = cp27_z
	ENDIF

	IF gosub_cpcounter = 26
		gosub_cp_x = cp27_x
		gosub_cp_y = cp27_y
		gosub_cp_z = cp27_z
		gosub_cp_2nd_x = cp28_x
		gosub_cp_2nd_y = cp28_y
		gosub_cp_2nd_z = cp28_z
	ENDIF

	IF gosub_cpcounter = 27
		gosub_cp_x = cp28_x
		gosub_cp_y = cp28_y
		gosub_cp_z = cp28_z
		gosub_cp_2nd_x = cp29_x
		gosub_cp_2nd_y = cp29_y
		gosub_cp_2nd_z = cp29_z
	ENDIF
//
	IF gosub_cpcounter = 28
		gosub_cp_x = cp29_x
		gosub_cp_y = cp29_y
		gosub_cp_z = cp29_z
		gosub_cp_2nd_x = cp30_x
		gosub_cp_2nd_y = cp30_y
		gosub_cp_2nd_z = cp30_z
	ENDIF

	IF gosub_cpcounter = 29
		gosub_cp_x = cp30_x
		gosub_cp_y = cp30_y
		gosub_cp_z = cp30_z
		gosub_cp_2nd_x = cp31_x
		gosub_cp_2nd_y = cp31_y
		gosub_cp_2nd_z = cp31_z
	ENDIF

	IF gosub_cpcounter = 30
		gosub_cp_x = cp31_x
		gosub_cp_y = cp31_y
		gosub_cp_z = cp31_z
		gosub_cp_2nd_x = cp32_x
		gosub_cp_2nd_y = cp32_y
		gosub_cp_2nd_z = cp32_z
	ENDIF

	IF gosub_cpcounter = 31
		gosub_cp_x = cp32_x
		gosub_cp_y = cp32_y
		gosub_cp_z = cp32_z
		gosub_cp_2nd_x = cp33_x
		gosub_cp_2nd_y = cp33_y
		gosub_cp_2nd_z = cp33_z
	ENDIF

	IF gosub_cpcounter = 32
		gosub_cp_x = cp33_x
		gosub_cp_y = cp33_y
		gosub_cp_z = cp33_z
		gosub_cp_2nd_x = cp34_x
		gosub_cp_2nd_y = cp34_y
		gosub_cp_2nd_z = cp34_z
	ENDIF

	IF gosub_cpcounter = 33
		gosub_cp_x = cp34_x
		gosub_cp_y = cp34_y
		gosub_cp_z = cp34_z
		gosub_cp_2nd_x = cp35_x
		gosub_cp_2nd_y = cp35_y
		gosub_cp_2nd_z = cp35_z
	ENDIF

	IF gosub_cpcounter = 34
		gosub_cp_x = cp35_x
		gosub_cp_y = cp35_y
		gosub_cp_z = cp35_z
		gosub_cp_2nd_x = cp36_x
		gosub_cp_2nd_y = cp36_y
		gosub_cp_2nd_z = cp36_z
	ENDIF

	IF gosub_cpcounter = 35
		gosub_cp_x = cp36_x
		gosub_cp_y = cp36_y
		gosub_cp_z = cp36_z
		gosub_cp_2nd_x = cp37_x
		gosub_cp_2nd_y = cp37_y
		gosub_cp_2nd_z = cp37_z
	ENDIF

	IF gosub_cpcounter = 36
		gosub_cp_x = cp37_x
		gosub_cp_y = cp37_y
		gosub_cp_z = cp37_z
		gosub_cp_2nd_x = cp38_x
		gosub_cp_2nd_y = cp38_y
		gosub_cp_2nd_z = cp38_z
	ENDIF

	IF gosub_cpcounter = 37
		gosub_cp_x = cp38_x
		gosub_cp_y = cp38_y
		gosub_cp_z = cp38_z
		gosub_cp_2nd_x = cp39_x
		gosub_cp_2nd_y = cp39_y
		gosub_cp_2nd_z = cp39_z
	ENDIF
//
	IF gosub_cpcounter = 38
		gosub_cp_x = cp39_x
		gosub_cp_y = cp39_y
		gosub_cp_z = cp39_z
		gosub_cp_2nd_x = cp40_x
		gosub_cp_2nd_y = cp40_y
		gosub_cp_2nd_z = cp40_z
	ENDIF

	IF gosub_cpcounter = 39
		gosub_cp_x = cp40_x
		gosub_cp_y = cp40_y
		gosub_cp_z = cp40_z
		gosub_cp_2nd_x = cp41_x
		gosub_cp_2nd_y = cp41_y
		gosub_cp_2nd_z = cp41_z
	ENDIF

	IF gosub_cpcounter = 40
		gosub_cp_x = cp41_x
		gosub_cp_y = cp41_y
		gosub_cp_z = cp41_z
		gosub_cp_2nd_x = cp42_x
		gosub_cp_2nd_y = cp42_y
		gosub_cp_2nd_z = cp42_z
	ENDIF

	IF gosub_cpcounter = 41
		gosub_cp_x = cp42_x
		gosub_cp_y = cp42_y
		gosub_cp_z = cp42_z
		gosub_cp_2nd_x = cp43_x
		gosub_cp_2nd_y = cp43_y
		gosub_cp_2nd_z = cp43_z
	ENDIF

	IF gosub_cpcounter = 42
		gosub_cp_x = cp43_x
		gosub_cp_y = cp43_y
		gosub_cp_z = cp43_z
		gosub_cp_2nd_x = cp44_x
		gosub_cp_2nd_y = cp44_y
		gosub_cp_2nd_z = cp44_z
	ENDIF

	IF gosub_cpcounter = 43
		gosub_cp_x = cp44_x
		gosub_cp_y = cp44_y
		gosub_cp_z = cp44_z
		gosub_cp_2nd_x = cp45_x
		gosub_cp_2nd_y = cp45_y
		gosub_cp_2nd_z = cp45_z
	ENDIF

	IF gosub_cpcounter = 44
		gosub_cp_x = cp45_x
		gosub_cp_y = cp45_y
		gosub_cp_z = cp45_z
		gosub_cp_2nd_x = cp46_x
		gosub_cp_2nd_y = cp46_y
		gosub_cp_2nd_z = cp46_z
	ENDIF

	IF gosub_cpcounter = 45
		gosub_cp_x = cp46_x
		gosub_cp_y = cp46_y
		gosub_cp_z = cp46_z
		gosub_cp_2nd_x = cp47_x
		gosub_cp_2nd_y = cp47_y
		gosub_cp_2nd_z = cp47_z
	ENDIF

	IF gosub_cpcounter = 46
		gosub_cp_x = cp47_x
		gosub_cp_y = cp47_y
		gosub_cp_z = cp47_z
		gosub_cp_2nd_x = cp48_x
		gosub_cp_2nd_y = cp48_y
		gosub_cp_2nd_z = cp48_z
	ENDIF

	IF gosub_cpcounter = 47
		gosub_cp_x = cp48_x
		gosub_cp_y = cp48_y
		gosub_cp_z = cp48_z
		gosub_cp_2nd_x = cp49_x
		gosub_cp_2nd_y = cp49_y
		gosub_cp_2nd_z = cp49_z
	ENDIF
//
	IF gosub_cpcounter = 48
		gosub_cp_x = cp49_x
		gosub_cp_y = cp49_y
		gosub_cp_z = cp49_z
		gosub_cp_2nd_x = cp50_x
		gosub_cp_2nd_y = cp50_y
		gosub_cp_2nd_z = cp50_z
	ENDIF

	IF gosub_cpcounter = 49
		gosub_cp_x = cp50_x
		gosub_cp_y = cp50_y
		gosub_cp_z = cp50_z
		gosub_cp_2nd_x = cp51_x
		gosub_cp_2nd_y = cp51_y
		gosub_cp_2nd_z = cp51_z
	ENDIF

	IF gosub_cpcounter = 50
		gosub_cp_x = cp51_x
		gosub_cp_y = cp51_y
		gosub_cp_z = cp51_z
		gosub_cp_2nd_x = cp52_x
		gosub_cp_2nd_y = cp52_y
		gosub_cp_2nd_z = cp52_z
	ENDIF

	IF gosub_cpcounter = 51
		gosub_cp_x = cp52_x
		gosub_cp_y = cp52_y
		gosub_cp_z = cp52_z
		gosub_cp_2nd_x = cp53_x
		gosub_cp_2nd_y = cp53_y
		gosub_cp_2nd_z = cp53_z
	ENDIF

	IF gosub_cpcounter = 52
		gosub_cp_x = cp53_x
		gosub_cp_y = cp53_y
		gosub_cp_z = cp53_z
		gosub_cp_2nd_x = cp54_x
		gosub_cp_2nd_y = cp54_y
		gosub_cp_2nd_z = cp54_z
	ENDIF

	IF gosub_cpcounter = 53
		gosub_cp_x = cp54_x
		gosub_cp_y = cp54_y
		gosub_cp_z = cp54_z
		gosub_cp_2nd_x = cp55_x
		gosub_cp_2nd_y = cp55_y
		gosub_cp_2nd_z = cp55_z
	ENDIF

	IF gosub_cpcounter = 54
		gosub_cp_x = cp55_x
		gosub_cp_y = cp55_y
		gosub_cp_z = cp55_z
		gosub_cp_2nd_x = cp56_x
		gosub_cp_2nd_y = cp56_y
		gosub_cp_2nd_z = cp56_z
	ENDIF

	IF gosub_cpcounter = 55
		gosub_cp_x = cp56_x
		gosub_cp_y = cp56_y
		gosub_cp_z = cp56_z
		gosub_cp_2nd_x = cp57_x
		gosub_cp_2nd_y = cp57_y
		gosub_cp_2nd_z = cp57_z
	ENDIF

	IF gosub_cpcounter = 56
		gosub_cp_x = cp57_x
		gosub_cp_y = cp57_y
		gosub_cp_z = cp57_z
		gosub_cp_2nd_x = cp58_x
		gosub_cp_2nd_y = cp58_y
		gosub_cp_2nd_z = cp58_z
	ENDIF

	IF gosub_cpcounter = 57
		gosub_cp_x = cp58_x
		gosub_cp_y = cp58_y
		gosub_cp_z = cp58_z
		gosub_cp_2nd_x = cp59_x
		gosub_cp_2nd_y = cp59_y
		gosub_cp_2nd_z = cp59_z
	ENDIF
//
	IF gosub_cpcounter = 58
		gosub_cp_x = cp59_x
		gosub_cp_y = cp59_y
		gosub_cp_z = cp59_z
		gosub_cp_2nd_x = cp60_x
		gosub_cp_2nd_y = cp60_y
		gosub_cp_2nd_z = cp60_z
	ENDIF

	IF gosub_cpcounter = 59
		gosub_cp_x = cp60_x
		gosub_cp_y = cp60_y
		gosub_cp_z = cp60_z
		gosub_cp_2nd_x = cp61_x
		gosub_cp_2nd_y = cp61_y
		gosub_cp_2nd_z = cp61_z
	ENDIF

	IF gosub_cpcounter = 60
		gosub_cp_x = cp61_x
		gosub_cp_y = cp61_y
		gosub_cp_z = cp61_z
		gosub_cp_2nd_x = cp62_x
		gosub_cp_2nd_y = cp62_y
		gosub_cp_2nd_z = cp62_z
	ENDIF

	IF gosub_cpcounter = 61
		gosub_cp_x = cp62_x
		gosub_cp_y = cp62_y
		gosub_cp_z = cp62_z
		gosub_cp_2nd_x = cp63_x
		gosub_cp_2nd_y = cp63_y
		gosub_cp_2nd_z = cp63_z
	ENDIF

	IF gosub_cpcounter = 62
		gosub_cp_x = cp63_x
		gosub_cp_y = cp63_y
		gosub_cp_z = cp63_z
		gosub_cp_2nd_x = cp64_x
		gosub_cp_2nd_y = cp64_y
		gosub_cp_2nd_z = cp64_z
	ENDIF

	IF gosub_cpcounter = 63
		gosub_cp_x = cp64_x
		gosub_cp_y = cp64_y
		gosub_cp_z = cp64_z
		gosub_cp_2nd_x = cp65_x
		gosub_cp_2nd_y = cp65_y
		gosub_cp_2nd_z = cp65_z
	ENDIF

	IF gosub_cpcounter = 64
		gosub_cp_x = cp65_x
		gosub_cp_y = cp65_y
		gosub_cp_z = cp65_z
		gosub_cp_2nd_x = cp66_x
		gosub_cp_2nd_y = cp66_y
		gosub_cp_2nd_z = cp66_z
	ENDIF

	IF gosub_cpcounter = 65
		gosub_cp_x = cp66_x
		gosub_cp_y = cp66_y
		gosub_cp_z = cp66_z
		gosub_cp_2nd_x = cp67_x
		gosub_cp_2nd_y = cp67_y
		gosub_cp_2nd_z = cp67_z
	ENDIF

	IF gosub_cpcounter = 66
		gosub_cp_x = cp67_x
		gosub_cp_y = cp67_y
		gosub_cp_z = cp67_z
		gosub_cp_2nd_x = cp68_x
		gosub_cp_2nd_y = cp68_y
		gosub_cp_2nd_z = cp68_z
	ENDIF

	IF gosub_cpcounter = 67
		gosub_cp_x = cp68_x
		gosub_cp_y = cp68_y
		gosub_cp_z = cp68_z
		gosub_cp_2nd_x = cp69_x
		gosub_cp_2nd_y = cp69_y
		gosub_cp_2nd_z = cp69_z
	ENDIF
//
	IF gosub_cpcounter = 68
		gosub_cp_x = cp69_x
		gosub_cp_y = cp69_y
		gosub_cp_z = cp69_z
		gosub_cp_2nd_x = cp70_x
		gosub_cp_2nd_y = cp70_y
		gosub_cp_2nd_z = cp70_z
	ENDIF

	IF gosub_cpcounter = 69
		gosub_cp_x = cp70_x
		gosub_cp_y = cp70_y
		gosub_cp_z = cp70_z
		gosub_cp_2nd_x = cp71_x
		gosub_cp_2nd_y = cp71_y
		gosub_cp_2nd_z = cp71_z
	ENDIF

	IF gosub_cpcounter = 70
		gosub_cp_x = cp71_x
		gosub_cp_y = cp71_y
		gosub_cp_z = cp71_z
		gosub_cp_2nd_x = cp72_x
		gosub_cp_2nd_y = cp72_y
		gosub_cp_2nd_z = cp72_z
	ENDIF

	IF gosub_cpcounter = 71
		gosub_cp_x = cp72_x
		gosub_cp_y = cp72_y
		gosub_cp_z = cp72_z
		gosub_cp_2nd_x = cp73_x
		gosub_cp_2nd_y = cp73_y
		gosub_cp_2nd_z = cp73_z
	ENDIF

	IF gosub_cpcounter = 72
		gosub_cp_x = cp73_x
		gosub_cp_y = cp73_y
		gosub_cp_z = cp73_z
		gosub_cp_2nd_x = cp74_x
		gosub_cp_2nd_y = cp74_y
		gosub_cp_2nd_z = cp74_z
	ENDIF

	IF gosub_cpcounter = 73
		gosub_cp_x = cp74_x
		gosub_cp_y = cp74_y
		gosub_cp_z = cp74_z
		gosub_cp_2nd_x = cp75_x
		gosub_cp_2nd_y = cp75_y
		gosub_cp_2nd_z = cp75_z
	ENDIF

	IF gosub_cpcounter = 74
		gosub_cp_x = cp75_x
		gosub_cp_y = cp75_y
		gosub_cp_z = cp75_z
		gosub_cp_2nd_x = cp76_x
		gosub_cp_2nd_y = cp76_y
		gosub_cp_2nd_z = cp76_z
	ENDIF

	IF gosub_cpcounter = 75
		gosub_cp_x = cp76_x
		gosub_cp_y = cp76_y
		gosub_cp_z = cp76_z
		gosub_cp_2nd_x = cp77_x
		gosub_cp_2nd_y = cp77_y
		gosub_cp_2nd_z = cp77_z
	ENDIF

	IF gosub_cpcounter = 76
		gosub_cp_x = cp77_x
		gosub_cp_y = cp77_y
		gosub_cp_z = cp77_z
		gosub_cp_2nd_x = cp78_x
		gosub_cp_2nd_y = cp78_y
		gosub_cp_2nd_z = cp78_z
	ENDIF

	IF gosub_cpcounter = 77
		gosub_cp_x = cp78_x
		gosub_cp_y = cp78_y
		gosub_cp_z = cp78_z
		gosub_cp_2nd_x = cp79_x
		gosub_cp_2nd_y = cp79_y
		gosub_cp_2nd_z = cp79_z
	ENDIF
//
	IF gosub_cpcounter = 78
		gosub_cp_x = cp79_x
		gosub_cp_y = cp79_y
		gosub_cp_z = cp79_z
		gosub_cp_2nd_x = cp80_x
		gosub_cp_2nd_y = cp80_y
		gosub_cp_2nd_z = cp80_z
	ENDIF

	IF gosub_cpcounter = 79
		gosub_cp_x = cp80_x
		gosub_cp_y = cp80_y
		gosub_cp_z = cp80_z
		gosub_cp_2nd_x = cp81_x
		gosub_cp_2nd_y = cp81_y
		gosub_cp_2nd_z = cp81_z
	ENDIF

	IF gosub_cpcounter = 80
		gosub_cp_x = cp81_x
		gosub_cp_y = cp81_y
		gosub_cp_z = cp81_z
		gosub_cp_2nd_x = cp82_x
		gosub_cp_2nd_y = cp82_y
		gosub_cp_2nd_z = cp82_z
	ENDIF

	IF gosub_cpcounter = 81
		gosub_cp_x = cp82_x
		gosub_cp_y = cp82_y
		gosub_cp_z = cp82_z
		gosub_cp_2nd_x = cp83_x
		gosub_cp_2nd_y = cp83_y
		gosub_cp_2nd_z = cp83_z
	ENDIF

	IF gosub_cpcounter = 82
		gosub_cp_x = cp83_x
		gosub_cp_y = cp83_y
		gosub_cp_z = cp83_z
		gosub_cp_2nd_x = cp84_x
		gosub_cp_2nd_y = cp84_y
		gosub_cp_2nd_z = cp84_z
	ENDIF

	IF gosub_cpcounter = 83
		gosub_cp_x = cp84_x
		gosub_cp_y = cp84_y
		gosub_cp_z = cp84_z
		gosub_cp_2nd_x = cp85_x
		gosub_cp_2nd_y = cp85_y
		gosub_cp_2nd_z = cp85_z
	ENDIF

	IF gosub_cpcounter = 84
		gosub_cp_x = cp85_x
		gosub_cp_y = cp85_y
		gosub_cp_z = cp85_z
		gosub_cp_2nd_x = cp86_x
		gosub_cp_2nd_y = cp86_y
		gosub_cp_2nd_z = cp86_z
	ENDIF

	IF gosub_cpcounter = 85
		gosub_cp_x = cp86_x
		gosub_cp_y = cp86_y
		gosub_cp_z = cp86_z
		gosub_cp_2nd_x = cp87_x
		gosub_cp_2nd_y = cp87_y
		gosub_cp_2nd_z = cp87_z
	ENDIF

	IF gosub_cpcounter = 86
		gosub_cp_x = cp87_x
		gosub_cp_y = cp87_y
		gosub_cp_z = cp87_z
		gosub_cp_2nd_x = cp88_x
		gosub_cp_2nd_y = cp88_y
		gosub_cp_2nd_z = cp88_z
	ENDIF

	IF gosub_cpcounter = 87
		gosub_cp_x = cp88_x
		gosub_cp_y = cp88_y
		gosub_cp_z = cp88_z
		gosub_cp_2nd_x = cp89_x
		gosub_cp_2nd_y = cp89_y
		gosub_cp_2nd_z = cp89_z
	ENDIF
//
	IF gosub_cpcounter = 88
		gosub_cp_x = cp89_x
		gosub_cp_y = cp89_y
		gosub_cp_z = cp89_z
		gosub_cp_2nd_x = cp90_x
		gosub_cp_2nd_y = cp90_y
		gosub_cp_2nd_z = cp90_z
	ENDIF

	IF gosub_cpcounter = 89
		gosub_cp_x = cp90_x
		gosub_cp_y = cp90_y
		gosub_cp_z = cp90_z
		gosub_cp_2nd_x = cp91_x
		gosub_cp_2nd_y = cp91_y
		gosub_cp_2nd_z = cp91_z
	ENDIF

	IF gosub_cpcounter = 90
		gosub_cp_x = cp91_x
		gosub_cp_y = cp91_y
		gosub_cp_z = cp91_z
		gosub_cp_2nd_x = cp92_x
		gosub_cp_2nd_y = cp92_y
		gosub_cp_2nd_z = cp92_z
	ENDIF

	IF gosub_cpcounter = 91
		gosub_cp_x = cp92_x
		gosub_cp_y = cp92_y
		gosub_cp_z = cp92_z
		gosub_cp_2nd_x = cp93_x
		gosub_cp_2nd_y = cp93_y
		gosub_cp_2nd_z = cp93_z
	ENDIF

	IF gosub_cpcounter = 92
		gosub_cp_x = cp93_x
		gosub_cp_y = cp93_y
		gosub_cp_z = cp93_z
		gosub_cp_2nd_x = cp94_x
		gosub_cp_2nd_y = cp94_y
		gosub_cp_2nd_z = cp94_z
	ENDIF

	IF gosub_cpcounter = 93
		gosub_cp_x = cp94_x
		gosub_cp_y = cp94_y
		gosub_cp_z = cp94_z
		gosub_cp_2nd_x = cp95_x
		gosub_cp_2nd_y = cp95_y
		gosub_cp_2nd_z = cp95_z
	ENDIF

	IF gosub_cpcounter = 94
		gosub_cp_x = cp95_x
		gosub_cp_y = cp95_y
		gosub_cp_z = cp95_z
		gosub_cp_2nd_x = cp96_x
		gosub_cp_2nd_y = cp96_y
		gosub_cp_2nd_z = cp96_z
	ENDIF

	IF gosub_cpcounter = 95
		gosub_cp_x = cp96_x
		gosub_cp_y = cp96_y
		gosub_cp_z = cp96_z
		gosub_cp_2nd_x = cp97_x
		gosub_cp_2nd_y = cp97_y
		gosub_cp_2nd_z = cp97_z
	ENDIF

	IF gosub_cpcounter = 96
		gosub_cp_x = cp97_x
		gosub_cp_y = cp97_y
		gosub_cp_z = cp97_z
		gosub_cp_2nd_x = cp98_x
		gosub_cp_2nd_y = cp98_y
		gosub_cp_2nd_z = cp98_z
	ENDIF

	IF gosub_cpcounter = 97
		gosub_cp_x = cp98_x
		gosub_cp_y = cp98_y
		gosub_cp_z = cp98_z
		gosub_cp_2nd_x = cp99_x
		gosub_cp_2nd_y = cp99_y
		gosub_cp_2nd_z = cp99_z
	ENDIF
//
	IF gosub_cpcounter = 98
		gosub_cp_x = cp99_x
		gosub_cp_y = cp99_y
		gosub_cp_z = cp99_z
		gosub_cp_2nd_x = cp100_x
		gosub_cp_2nd_y = cp100_y
		gosub_cp_2nd_z = cp100_z
	ENDIF

	IF gosub_cpcounter = 99
		gosub_cp_x = cp100_x
		gosub_cp_y = cp100_y
		gosub_cp_z = cp100_z
		gosub_cp_2nd_x = cp101_x
		gosub_cp_2nd_y = cp101_y
		gosub_cp_2nd_z = cp101_z
	ENDIF

	IF gosub_cpcounter = 100
		gosub_cp_x = cp101_x
		gosub_cp_y = cp101_y
		gosub_cp_z = cp101_z
		gosub_cp_2nd_x = cp102_x
		gosub_cp_2nd_y = cp102_y
		gosub_cp_2nd_z = cp102_z
	ENDIF

	IF gosub_cpcounter = 101
		gosub_cp_x = cp102_x
		gosub_cp_y = cp102_y
		gosub_cp_z = cp102_z
		gosub_cp_2nd_x = cp103_x
		gosub_cp_2nd_y = cp103_y
		gosub_cp_2nd_z = cp103_z
	ENDIF

	IF gosub_cpcounter = 102
		gosub_cp_x = cp103_x
		gosub_cp_y = cp103_y
		gosub_cp_z = cp103_z
		gosub_cp_2nd_x = cp104_x
		gosub_cp_2nd_y = cp104_y
		gosub_cp_2nd_z = cp104_z
	ENDIF

	IF gosub_cpcounter = 103
		gosub_cp_x = cp104_x
		gosub_cp_y = cp104_y
		gosub_cp_z = cp104_z
		gosub_cp_2nd_x = cp105_x
		gosub_cp_2nd_y = cp105_y
		gosub_cp_2nd_z = cp105_z
	ENDIF

	IF gosub_cpcounter = 104
		gosub_cp_x = cp105_x
		gosub_cp_y = cp105_y
		gosub_cp_z = cp105_z
		gosub_cp_2nd_x = cp106_x
		gosub_cp_2nd_y = cp106_y
		gosub_cp_2nd_z = cp106_z
	ENDIF

	IF gosub_cpcounter = 105
		gosub_cp_x = cp106_x
		gosub_cp_y = cp106_y
		gosub_cp_z = cp106_z
		gosub_cp_2nd_x = cp107_x
		gosub_cp_2nd_y = cp107_y
		gosub_cp_2nd_z = cp107_z
	ENDIF

	IF gosub_cpcounter = 106
		gosub_cp_x = cp107_x
		gosub_cp_y = cp107_y
		gosub_cp_z = cp107_z
		gosub_cp_2nd_x = cp108_x
		gosub_cp_2nd_y = cp108_y
		gosub_cp_2nd_z = cp108_z
	ENDIF

	IF gosub_cpcounter = 107
		gosub_cp_x = cp108_x
		gosub_cp_y = cp108_y
		gosub_cp_z = cp108_z
		gosub_cp_2nd_x = cp109_x
		gosub_cp_2nd_y = cp109_y
		gosub_cp_2nd_z = cp109_z
	ENDIF
//
	IF gosub_cpcounter = 108
		gosub_cp_x = cp109_x
		gosub_cp_y = cp109_y
		gosub_cp_z = cp109_z
		gosub_cp_2nd_x = cp110_x
		gosub_cp_2nd_y = cp110_y
		gosub_cp_2nd_z = cp110_z
	ENDIF

	IF gosub_cpcounter = 109
		gosub_cp_x = cp110_x
		gosub_cp_y = cp110_y
		gosub_cp_z = cp110_z
		gosub_cp_2nd_x = cp111_x
		gosub_cp_2nd_y = cp111_y
		gosub_cp_2nd_z = cp111_z
	ENDIF

	IF gosub_cpcounter = 110
		gosub_cp_x = cp111_x
		gosub_cp_y = cp111_y
		gosub_cp_z = cp111_z
		gosub_cp_2nd_x = cp112_x
		gosub_cp_2nd_y = cp112_y
		gosub_cp_2nd_z = cp112_z
	ENDIF

	IF gosub_cpcounter = 111
		gosub_cp_x = cp112_x
		gosub_cp_y = cp112_y
		gosub_cp_z = cp112_z
		gosub_cp_2nd_x = cp113_x
		gosub_cp_2nd_y = cp113_y
		gosub_cp_2nd_z = cp113_z
	ENDIF

	IF gosub_cpcounter = 112
		gosub_cp_x = cp113_x
		gosub_cp_y = cp113_y
		gosub_cp_z = cp113_z
		gosub_cp_2nd_x = cp113_x
		gosub_cp_2nd_y = cp113_y
		gosub_cp_2nd_z = cp113_z
	ENDIF

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////


///////////////////////////////////////////////
race_car_stuck_checks://///////////////////////
///////////////////////////////////////////////

GET_CAR_HEALTH gosub_race_car car_health
IF car_health < 500
	SET_CAR_HEALTH gosub_race_car 1000
ENDIF

IF player_cpcounter	= gosub_cpcounter	
	GET_CAR_COORDINATES	gosub_race_car car_x car_y car_z
	difference_x_float_d = car_x - player1_cp_x
	difference_y_float_d = car_y - player1_cp_y
	difference_x_float_d = difference_x_float_d * difference_x_float_d
	difference_y_float_d = difference_y_float_d * difference_y_float_d
	sum_difference_d_xy = difference_x_float_d + difference_y_float_d
	SQRT sum_difference_d_xy car_distance_from_cp

	GET_PLAYER_COORDINATES player1 car_x car_y car_z
	difference_x_float_d = car_x - player1_cp_x
	difference_y_float_d = car_y - player1_cp_y
	difference_x_float_d = difference_x_float_d * difference_x_float_d
	difference_y_float_d = difference_y_float_d * difference_y_float_d
	sum_difference_d_xy = difference_x_float_d + difference_y_float_d
	SQRT sum_difference_d_xy player1_distance_from_cp

	IF player1_distance_from_cp > car_distance_from_cp
		++ position
	ENDIF
ELSE
	IF player_cpcounter < gosub_cpcounter
		++ position
	ENDIF
ENDIF

IF NOT LOCATE_CAR_3D gosub_race_car car_stuck_x car_stuck_y car_stuck_z 3.0 3.0 2.0 0
	GET_CAR_COORDINATES gosub_race_car car_stuck_x car_stuck_y car_stuck_z
	timer_started = game_timer
ENDIF

IF LOCATE_CAR_3D gosub_race_car car_stuck_x car_stuck_y car_stuck_z 3.0 3.0 2.0 0
	stuck_timer = game_timer - timer_started
	IF stuck_timer > 4000
		IF NOT IS_CAR_ON_SCREEN gosub_race_car
			GET_CAR_COORDINATES gosub_race_car car_x car_y car_z
			GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 3.0
				IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 4.0
					SET_CAR_COORDINATES gosub_race_car car_x car_y car_z
					TURN_CAR_TO_FACE_COORD gosub_race_car car3_cp_x car3_cp_y
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

temp_int = player_cpcounter - 4
IF gosub_cpcounter < temp_int
	IF gosub_race_car = race_car1
		IF NOT IS_CAR_ON_SCREEN race_car1
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car1_cp_x car1_cp_y car1_cp_z 4.0 4.0 3.0
				IF NOT IS_POINT_ON_SCREEN car1_cp_x car1_cp_y car1_cp_z 4.0
					SET_CAR_COORDINATES gosub_race_car car1_cp_x car1_cp_y car1_cp_z
					TURN_CAR_TO_FACE_COORD gosub_race_car player1_cp_x player1_cp_y
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF gosub_race_car = race_car2
		IF NOT IS_CAR_ON_SCREEN race_car2
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car2_cp_x car2_cp_y car2_cp_z 4.0 4.0 3.0
				IF NOT IS_POINT_ON_SCREEN car2_cp_x car2_cp_y car2_cp_z 4.0
					SET_CAR_COORDINATES gosub_race_car car2_cp_x car2_cp_y car2_cp_z
					TURN_CAR_TO_FACE_COORD gosub_race_car player1_cp_x player1_cp_y
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF gosub_race_car = race_car3
		IF NOT IS_CAR_ON_SCREEN race_car3
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_cp_x car3_cp_y car3_cp_z 4.0 4.0 3.0
				IF NOT IS_POINT_ON_SCREEN car3_cp_x car3_cp_y car3_cp_z 4.0
					SET_CAR_COORDINATES gosub_race_car car3_cp_x car3_cp_y car3_cp_z
					TURN_CAR_TO_FACE_COORD gosub_race_car player1_cp_x player1_cp_y
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

temp_int = player_cpcounter + 5
IF gosub_cpcounter > temp_int
	SET_CAR_CRUISE_SPEED gosub_race_car 25.0
ELSE
	SET_CAR_CRUISE_SPEED gosub_race_car 50.0
ENDIF

///////////////////////////////////////////////
RETURN/////////////////////////////////////////
///////////////////////////////////////////////
}
