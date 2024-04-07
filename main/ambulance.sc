MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *********************************** Ambulance missions ********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_ambulance

GOSUB ambulance_failed

MISSION_END
 
// Variables for mission

VAR_INT	ped_time_limit players_ambulance ped_time_limit_temp ped_counter	number_of_injured_peds brackets_var
VAR_INT ambulance_health_last ambulance_health_now time_drop max_peds_in_car peds_in_car score_am bonus_time_flag
VAR_INT saved_peds	hospital_blip time_chunk ambulance_level time_chunk_in_secs car_full_flag
VAR_INT drop_off_time_bonus	hospital_blip_flag mission_end_button_ambulance players_ambulance_health	saved_peds_this_go
VAR_INT injured_ped_6 injured_ped_6_blip injured_ped_6_flag
VAR_INT injured_ped_7 injured_ped_7_blip injured_ped_7_flag
VAR_INT injured_ped_8 injured_ped_8_blip injured_ped_8_flag
VAR_INT injured_ped_9 injured_ped_9_blip injured_ped_9_flag
VAR_INT injured_ped_10 injured_ped_10_blip injured_ped_10_flag
VAR_INT injured_ped_11 injured_ped_11_blip injured_ped_11_flag
VAR_INT injured_ped_12 injured_ped_12_blip injured_ped_12_flag
VAR_INT	ped_var_for_gosub ped_var_for_gosub_flag ped_var_for_gosub_blip	player_failed_mission

VAR_FLOAT random_x random_y	hospital_x hospital_y hospital_z
VAR_FLOAT player1_a_x	player1_a_y player1_a_z	hospital_door_x	hospital_door_y
VAR_FLOAT ped_coord_x ped_coord_y	ped_coord_z	sound_x sound_y sound_z
VAR_FLOAT difference_x_float_a difference_y_float_a	sum_difference_a_xy	
VAR_FLOAT players_distance_from_ped peds_distance_from_hospital ped_time_limit_float random_ped_heading	time_chunk_divider


// ****************************************Mission Start************************************

mission_start_ambulance:

flag_player_on_mission = 1
flag_player_on_ambulance_mission = 1
SCRIPT_NAME ambulan

IF done_ambulance_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

WAIT 0
{
LVAR_INT injured_ped_1 injured_ped_1_blip injured_ped_1_flag	
LVAR_INT injured_ped_2 injured_ped_2_blip injured_ped_2_flag
LVAR_INT injured_ped_3 injured_ped_3_blip injured_ped_3_flag
LVAR_INT injured_ped_4 injured_ped_4_blip injured_ped_4_flag
LVAR_INT injured_ped_5 injured_ped_5_blip injured_ped_5_flag

LOAD_MISSION_TEXT AMBULAE

ped_time_limit 			= 0
players_ambulance  		= 0
ambulance_health_last  	= 0
ambulance_health_now  	= 0
time_drop  				= 0
max_peds_in_car  		= 0
peds_in_car  			= 0
number_of_injured_peds	= 1
ped_counter 			= 0
injured_ped_1_flag		= 0
injured_ped_2_flag		= 0
injured_ped_3_flag		= 0
injured_ped_4_flag		= 0
injured_ped_5_flag		= 0
injured_ped_6_flag		= 0
injured_ped_7_flag		= 0
injured_ped_8_flag		= 0
injured_ped_9_flag		= 0
injured_ped_10_flag		= 0
injured_ped_11_flag		= 0
injured_ped_12_flag		= 0
saved_peds				= 0
time_chunk_divider		= 10.0
ambulance_level			= 1
time_chunk				= 0 
time_chunk_in_secs 		= 0
score_am				= 0
bonus_time_flag			= 0
drop_off_time_bonus		= 0
hospital_blip_flag		= 0
mission_end_button_ambulance = 0
car_full_flag = 0
saved_peds_this_go = 0
player_failed_mission = 0
ped_coord_x = 0.0
ped_coord_y = 0.0
ped_coord_z = 0.0

PRINT_NOW ATUTOR2 3000 1 // Take the injured people to the Hospital

//WAIT 3000

SET_WANTED_MULTIPLIER 0.5

mission_root:

PRINT_WITH_NUMBER ALEVEL ambulance_level 5000 4 // Ambulance Mission Level ~1~

CLEAR_ONSCREEN_TIMER ped_time_limit

ped_time_limit = 0

IF LOCATE_PLAYER_ANY_MEANS_2D player1 361.298 -958.797 750.0 850.0 0
	//BEACH SOUTH
	hospital_x = -133.0288 
	hospital_y = -981.1411 
	hospital_z = 9.4084
	hospital_door_x	= -134.3 
	hospital_door_y = -982.6
ELSE
	IF LOCATE_PLAYER_ANY_MEANS_2D player1 574.234 641.203 750.0 750.0 0
		//BEACH NORTH
		hospital_x = 479.1241 
		hospital_y = 710.7480 
		hospital_z = 10.3577
		hospital_door_x	= 496.5145
		hospital_door_y = 708.1912
	ELSE
		IF LOCATE_PLAYER_ANY_MEANS_2D player1 -1138.702 -902.039 750.0 900.0 0
			//MAINLAND SOUTH
			hospital_x = -871.6317
			hospital_y = -477.0081
			hospital_z = 10.0683
			hospital_door_x	= -887.1110
			hospital_door_y = -470.5340
		ELSE
			IF LOCATE_PLAYER_ANY_MEANS_2D player1 -1025.766 847.961 850.0 850.0 0
				//MAINLAND NORTH
				hospital_x = -823.1110
				hospital_y = 1167.6761
				hospital_z = 9.8744 
				hospital_door_x	= -823.2640
				hospital_door_y = 1140.0605
			ENDIF 
		ENDIF 
	ENDIF 
ENDIF 

WHILE number_of_injured_peds > ped_counter
	GOSUB generate_random_coord
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	GOSUB create_random_injured_ped
	GOSUB generate_timelimit
	++ ped_counter
ENDWHILE

IF number_of_injured_peds > 3
	bonus_time_flag = 1
ELSE
	bonus_time_flag = 0
ENDIF

time_chunk = ped_time_limit / number_of_injured_peds
time_chunk /= 2
brackets_var = number_of_injured_peds + 1
time_chunk *= brackets_var
ped_time_limit += time_chunk
ped_time_limit = ped_time_limit / number_of_injured_peds
time_chunk = ped_time_limit
time_chunk /= 2

DISPLAY_ONSCREEN_TIMER ped_time_limit TIMER_DOWN

GOTO ambulance_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD hospital_x hospital_y hospital_z hospital_blip
ambulance_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

GOTO ambulance_loop

////////////////

create_random_injured_ped:

IF number_of_injured_peds > 0
AND injured_ped_1_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_1
	injured_ped_1_flag = 1
	SET_CHAR_BLEEDING injured_ped_1 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_1 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_1 random_ped_heading
	SET_CHAR_RUNNING injured_ped_1 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_1
	ADD_BLIP_FOR_CHAR injured_ped_1 injured_ped_1_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_1
	//FREEZE_CHAR_POSITION_AND_DONT_LOAD_COLLISION injured_ped_1 TRUE
	RETURN
ENDIF

IF number_of_injured_peds > 1
AND injured_ped_2_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_2
	injured_ped_2_flag = 1
	SET_CHAR_BLEEDING injured_ped_2 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_2 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_2 random_ped_heading
	SET_CHAR_RUNNING injured_ped_2 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_2
	ADD_BLIP_FOR_CHAR injured_ped_2 injured_ped_2_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_2
	RETURN
ENDIF

IF number_of_injured_peds > 2
AND injured_ped_3_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_3
	injured_ped_3_flag = 1
	SET_CHAR_BLEEDING injured_ped_3 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_3 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_3 random_ped_heading
	SET_CHAR_RUNNING injured_ped_3 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_3
	ADD_BLIP_FOR_CHAR injured_ped_3 injured_ped_3_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_3
	RETURN
ENDIF

IF number_of_injured_peds > 3
AND injured_ped_4_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_4
	injured_ped_4_flag = 1
	SET_CHAR_BLEEDING injured_ped_4 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_4 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_4 random_ped_heading
	SET_CHAR_RUNNING injured_ped_4 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_4
	ADD_BLIP_FOR_CHAR injured_ped_4 injured_ped_4_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_4
	RETURN
ENDIF

IF number_of_injured_peds > 4
AND injured_ped_5_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_5
	injured_ped_5_flag = 1
	SET_CHAR_BLEEDING injured_ped_5 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_5 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_5 random_ped_heading
	SET_CHAR_RUNNING injured_ped_5 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_5
	ADD_BLIP_FOR_CHAR injured_ped_5 injured_ped_5_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_5
	RETURN
ENDIF

IF number_of_injured_peds > 5
AND injured_ped_6_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_6
	injured_ped_6_flag = 1
	SET_CHAR_BLEEDING injured_ped_6 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_6 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_6 random_ped_heading
	SET_CHAR_RUNNING injured_ped_6 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_6
	ADD_BLIP_FOR_CHAR injured_ped_6 injured_ped_6_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_6
	RETURN
ENDIF

IF number_of_injured_peds > 6
AND injured_ped_7_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_7
	injured_ped_7_flag = 1
	SET_CHAR_BLEEDING injured_ped_7 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_7 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_7 random_ped_heading
	SET_CHAR_RUNNING injured_ped_7 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_7
	ADD_BLIP_FOR_CHAR injured_ped_7 injured_ped_7_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_7
	RETURN
ENDIF

IF number_of_injured_peds > 7
AND injured_ped_8_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_8
	injured_ped_8_flag = 1
	SET_CHAR_BLEEDING injured_ped_8 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_8 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_8 random_ped_heading
	SET_CHAR_RUNNING injured_ped_8 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_8
	ADD_BLIP_FOR_CHAR injured_ped_8 injured_ped_8_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_8
	RETURN
ENDIF

IF number_of_injured_peds > 8
AND injured_ped_9_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_9
	injured_ped_9_flag = 1
	SET_CHAR_BLEEDING injured_ped_9 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_9 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_9 random_ped_heading
	SET_CHAR_RUNNING injured_ped_9 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_9
	ADD_BLIP_FOR_CHAR injured_ped_9 injured_ped_9_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_9
	RETURN
ENDIF

IF number_of_injured_peds > 9
AND injured_ped_10_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_10
	injured_ped_10_flag = 1
	SET_CHAR_BLEEDING injured_ped_10 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_10 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_10 random_ped_heading
	SET_CHAR_RUNNING injured_ped_10 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_10
	ADD_BLIP_FOR_CHAR injured_ped_10 injured_ped_10_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_10
	RETURN
ENDIF

IF number_of_injured_peds > 10
AND injured_ped_11_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_11
	injured_ped_11_flag = 1
	SET_CHAR_BLEEDING injured_ped_11 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_11 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_11 random_ped_heading
	SET_CHAR_RUNNING injured_ped_11 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_11
	ADD_BLIP_FOR_CHAR injured_ped_11 injured_ped_11_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_11
	RETURN
ENDIF

IF number_of_injured_peds > 11
AND injured_ped_12_flag = 0
	CREATE_RANDOM_CHAR ped_coord_x ped_coord_y ped_coord_z injured_ped_12
	injured_ped_12_flag = 1
	SET_CHAR_BLEEDING injured_ped_12 TRUE
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	injured_ped_12 TRUE
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_ped_heading
	SET_CHAR_HEADING injured_ped_12 random_ped_heading
	SET_CHAR_RUNNING injured_ped_12 TRUE
	CLEAR_CHAR_THREAT_SEARCH injured_ped_12
	ADD_BLIP_FOR_CHAR injured_ped_12 injured_ped_12_blip
	SET_CHAR_OBJ_WAIT_ON_FOOT injured_ped_12
	RETURN
ENDIF

RETURN

////////////////

generate_random_coord:

WAIT 0

GET_PLAYER_COORDINATES player1 player1_a_x player1_a_y player1_a_z

IF hospital_x = -133.0288 //BEACH SOUTH
	GENERATE_RANDOM_FLOAT_IN_RANGE -388.702 1111.298  random_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1808.797 -108.797 random_y
ENDIF

IF hospital_x = 479.1241 //BEACH NORTH
	GENERATE_RANDOM_FLOAT_IN_RANGE -175.766 1324.234 random_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -108.797 1391.203 random_y
ENDIF

IF hospital_x = -871.6317//MAINLAND SOUTH
	GENERATE_RANDOM_FLOAT_IN_RANGE -1888.702 -388.702 random_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1802.039 -2.039	random_y
ENDIF

IF hospital_x = -823.1110//MAINLAND NORTH
	GENERATE_RANDOM_FLOAT_IN_RANGE -1875.766 -175.766 random_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -2.039 1697.961 random_y
ENDIF

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ambulance = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ambulance = 1
	ENDIF
ENDIF

IF mission_end_button_ambulance = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			player_failed_mission = 1
			RETURN
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			player_failed_mission = 1
			RETURN
		ENDIF
	ENDIF
ENDIF

IF NOT IS_PLAYER_IN_MODEL player1 AMBULAN
	PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
	player_failed_mission = 1
	RETURN
ENDIF

GET_CLOSEST_CHAR_NODE random_x random_y player1_a_z ped_coord_x ped_coord_y ped_coord_z

IF flag_baron_mission2_passed = 0
	IF ped_coord_x > -2327.212 
	AND ped_coord_x < -261.402
	AND ped_coord_y	> -2027.821
	AND ped_coord_y	< 1894.426
		GOTO generate_random_coord
	ENDIF

	IF ped_coord_x >  -265.018
	AND ped_coord_x < 170.188
	AND ped_coord_y	> -275.942
	AND ped_coord_y	< 1689.059
		GOTO generate_random_coord
	ENDIF

	IF ped_coord_x >  -265.657
	AND ped_coord_x < 36.828
	AND ped_coord_y	> -729.217
	AND ped_coord_y	< -275.488
		GOTO generate_random_coord
	ENDIF

	IF ped_coord_x >  164.191
	AND ped_coord_x < 259.713
	AND ped_coord_y	> -187.926
	AND ped_coord_y	< 631.97
		GOTO generate_random_coord
	ENDIF
ENDIF
//POLICE STATION BEACH SOUTH
IF ped_coord_x > 333.358
AND ped_coord_x < 435.544
AND ped_coord_y	> -557.261
AND ped_coord_y	< -433.179
	GOTO generate_random_coord
ENDIF
//MALL BEACH SOUTH
IF ped_coord_x >  -64.434
AND ped_coord_x < 81.544
AND ped_coord_y	> -995.198
AND ped_coord_y	< -896.662
	GOTO generate_random_coord
ENDIF
//MALIBU
IF ped_coord_x >  446.491
AND ped_coord_x < 599.769
AND ped_coord_y	> -92.564
AND ped_coord_y	< 53.415
	GOTO generate_random_coord
ENDIF
//GOLF COURSE
IF ped_coord_x >  -192.361
AND ped_coord_x < 234.821
AND ped_coord_y	> -272.607
AND ped_coord_y	< 406.194
	GOTO generate_random_coord
ENDIF
//GOLF COURSE
IF ped_coord_x >  -290.702 
AND ped_coord_x < 282.265
AND ped_coord_y	> 398.714
AND ped_coord_y	< 661.476
	GOTO generate_random_coord
ENDIF
//BRIDGE
IF ped_coord_x >  -728.193
AND ped_coord_x < -67.639
AND ped_coord_y	> -20.866
AND ped_coord_y	< 99.566
	GOTO generate_random_coord
ENDIF
//MANSION
IF ped_coord_x >  -516.97
AND ped_coord_x < -188.518
AND ped_coord_y	> -667.97
AND ped_coord_y	< -507.393
	GOTO generate_random_coord
ENDIF
//TANKER
IF ped_coord_x >  -710.393
AND ped_coord_x < -579.012
AND ped_coord_y	> -1416.112
AND ped_coord_y	< -1211.742
	GOTO generate_random_coord
ENDIF
//BIG MALL
IF ped_coord_x >  333.358
AND ped_coord_x < 493.934
AND ped_coord_y	> 991.328
AND ped_coord_y	< 1261.389
	GOTO generate_random_coord
ENDIF
//BEHIND AMMUNATION DOWNTOWN
IF ped_coord_x >  -790.682
AND ped_coord_x < -626.456
AND ped_coord_y	> 1196.908
AND ped_coord_y	< 1306.392
	GOTO generate_random_coord
ENDIF
//PHILS YARD
IF ped_coord_x >  -1173.877
AND ped_coord_x < -1027.898
AND ped_coord_y	> 237.098
AND ped_coord_y	< 415.922
	GOTO generate_random_coord
ENDIF
//BUDDY YARD
IF ped_coord_x >  -1389.195
AND ped_coord_x < -1199.422
AND ped_coord_y	> -47.561
AND ped_coord_y	< 229.799
	GOTO generate_random_coord
ENDIF
//AIPORT TEMINAL
IF ped_coord_x >  -1571.667
AND ped_coord_x < -1290.658
AND ped_coord_y	> -1007.371
AND ped_coord_y	< -784.753
	GOTO generate_random_coord
ENDIF
//SOUTH BRIDGE
IF ped_coord_x >  -757.335
AND ped_coord_x < -219.313
AND ped_coord_y	> -979.568
AND ped_coord_y	< -878.689
	GOTO generate_random_coord
ENDIF
//STARISLAND BRIDGE
IF ped_coord_x >  -180.88
AND ped_coord_x < 64.112
AND ped_coord_y	> -499.183
AND ped_coord_y	< -417.519
	GOTO generate_random_coord
ENDIF
//LIGHTHOUSE JETTYS
IF ped_coord_x >  511.112
AND ped_coord_x < 638.214
AND ped_coord_y	> -1815.644
AND ped_coord_y	< -1679.04
	GOTO generate_random_coord
ENDIF
//BOAT YARD
IF ped_coord_x >  -691.673
AND ped_coord_x < -581.673
AND ped_coord_y	> -1519.748
AND ped_coord_y	< -1449.748
	GOTO generate_random_coord
ENDIF
//PRINT WORKS
IF ped_coord_x >  -1176.038
AND ped_coord_x < -1012.796
AND ped_coord_y	> -266.898
AND ped_coord_y	< -158.26
	GOTO generate_random_coord
ENDIF
//CAR YARD
IF ped_coord_x >  -1031.494
AND ped_coord_x < -949.479
AND ped_coord_y	> -902.312
AND ped_coord_y	< -821.592
	GOTO generate_random_coord
ENDIF
//ICECREAM
IF ped_coord_x >  -896.098
AND ped_coord_x < -855.09
AND ped_coord_y	> -593.101
AND ped_coord_y	< -548.64
	GOTO generate_random_coord
ENDIF
//TAXIFIRM
IF ped_coord_x >  -1012.06
AND ped_coord_x < -982.06
AND ped_coord_y	> 181.561
AND ped_coord_y	< 216.561
	GOTO generate_random_coord
ENDIF
//PORN STUDIO
IF ped_coord_x >  -112.495
AND ped_coord_x < 9.705
AND ped_coord_y	> 920.349
AND ped_coord_y	< 1025.694
	GOTO generate_random_coord
ENDIF
//HOTEL WITH GLASSHOUSE & SWIMMING POOL OUT BACK
IF ped_coord_x >  533.891
AND ped_coord_x < 673.891
AND ped_coord_y	> -343.116
AND ped_coord_y	< -183.116
	GOTO generate_random_coord
ENDIF
//ARMY BASE
IF ped_coord_x >  -1783.2216 
AND ped_coord_x < -1586.5990 
AND ped_coord_y	> -307.5092
AND ped_coord_y	< -84.3105 
	GOTO generate_random_coord
ENDIF
//PIZZA SHOP DOWNTOWN
IF ped_coord_x >  -903.6972 
AND ped_coord_x < -882.7946 
AND ped_coord_y	> 791.7817
AND ped_coord_y	< 808.3229
	GOTO generate_random_coord
ENDIF
//PIZZA SHOP HAITI
IF ped_coord_x >  -1059.2343 
AND ped_coord_x < -1040.1482 
AND ped_coord_y	> 73.3646 
AND ped_coord_y	< 89.7497
	GOTO generate_random_coord
ENDIF
//HAITIAN BASE
IF ped_coord_x >  -1235.7916
AND ped_coord_x < -1110.9315
AND ped_coord_y	> 32.1217 
AND ped_coord_y	< 126.1341
	GOTO generate_random_coord
ENDIF
// SCFIX: START
//G-SPOTLIGHT OFFICE
IF ped_coord_x >  -570.1256
AND ped_coord_x < -453.1256
AND ped_coord_y	> 888.7261 
AND ped_coord_y	< 1018.3261
	GOTO generate_random_coord
ENDIF
//STADUM STAIRS
IF ped_coord_x >  -1117.3256
AND ped_coord_x < -1047.1256
AND ped_coord_y	> 1250.5261 
AND ped_coord_y	< 1419.7261
	GOTO generate_random_coord
ENDIF
// SCFIX: END
 
 
  


IF ped_coord_z < 6.0
	GOTO generate_random_coord
ENDIF

difference_x_float_a = player1_a_x - ped_coord_x
difference_y_float_a = player1_a_y - ped_coord_y
difference_x_float_a = difference_x_float_a * difference_x_float_a
difference_y_float_a = difference_y_float_a * difference_y_float_a
sum_difference_a_xy = difference_x_float_a + difference_y_float_a
SQRT sum_difference_a_xy players_distance_from_ped

IF players_distance_from_ped < 120.0
	GOTO generate_random_coord
ENDIF

difference_x_float_a = hospital_x - ped_coord_x
difference_y_float_a = hospital_y - ped_coord_y
difference_x_float_a = difference_x_float_a * difference_x_float_a
difference_y_float_a = difference_y_float_a * difference_y_float_a
sum_difference_a_xy = difference_x_float_a + difference_y_float_a
SQRT sum_difference_a_xy peds_distance_from_hospital

IF peds_distance_from_hospital < 100.0
	GOTO generate_random_coord
ENDIF

IF injured_ped_1_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_1
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_1 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_2_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_2
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_2 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_3_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_3
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_3 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_4_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_4
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_4 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_5_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_5
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_5 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_6_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_6
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_6 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_7_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_7
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_7 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_8_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_8
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_8 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_9_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_9
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_9 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_10_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_10
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_10 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

IF injured_ped_11_flag > 0
	IF NOT IS_CHAR_DEAD injured_ped_11
		IF LOCATE_CHAR_ANY_MEANS_2D injured_ped_11 ped_coord_x ped_coord_y 25.0 25.0 0
			GOTO generate_random_coord
		ENDIF
	ENDIF
ENDIF

RETURN

////////////////

generate_timelimit:

ped_time_limit_float = peds_distance_from_hospital / time_chunk_divider
ped_time_limit_float = ped_time_limit_float * 1000.0
ped_time_limit_temp =# ped_time_limit_float
ped_time_limit += ped_time_limit_temp

RETURN

///////////////

ambulance_loop:

WAIT 0

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ambulance = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ambulance = 1
	ENDIF
ENDIF

IF mission_end_button_ambulance = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
			GOTO ambulance_failed
		ENDIF
	ENDIF
ENDIF

IF NOT IS_PLAYER_IN_MODEL player1 AMBULAN
	PRINT_NOW A_CANC 3000 1//"~r~Ambulance mission cancelled!"
	GOTO ambulance_failed
ELSE
	STORE_CAR_PLAYER_IS_IN player1 players_ambulance
ENDIF

IF number_of_injured_peds > 6
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 0
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

IF number_of_injured_peds > 9
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 1
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

IF number_of_injured_peds > 12
AND	bonus_time_flag = 2
AND drop_off_time_bonus = 2
	bonus_time_flag = 1
	++ drop_off_time_bonus
ENDIF

/////////////////

IF injured_ped_1_flag > 0
	
	ped_var_for_gosub = injured_ped_1
	ped_var_for_gosub_flag = injured_ped_1_flag
	ped_var_for_gosub_blip = injured_ped_1_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_1_flag = ped_var_for_gosub_flag

ENDIF

/////////////////

IF injured_ped_2_flag > 0
	ped_var_for_gosub = injured_ped_2
	ped_var_for_gosub_flag = injured_ped_2_flag
	ped_var_for_gosub_blip = injured_ped_2_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_2_flag = ped_var_for_gosub_flag
ENDIF

//////////////////

IF injured_ped_3_flag > 0
	ped_var_for_gosub = injured_ped_3
	ped_var_for_gosub_flag = injured_ped_3_flag
	ped_var_for_gosub_blip = injured_ped_3_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_3_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_4_flag > 0
	ped_var_for_gosub = injured_ped_4
	ped_var_for_gosub_flag = injured_ped_4_flag
	ped_var_for_gosub_blip = injured_ped_4_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_4_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_5_flag > 0
	ped_var_for_gosub = injured_ped_5
	ped_var_for_gosub_flag = injured_ped_5_flag
	ped_var_for_gosub_blip = injured_ped_5_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_5_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_6_flag > 0
	ped_var_for_gosub = injured_ped_6
	ped_var_for_gosub_flag = injured_ped_6_flag
	ped_var_for_gosub_blip = injured_ped_6_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_6_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_7_flag > 0
	ped_var_for_gosub = injured_ped_7
	ped_var_for_gosub_flag = injured_ped_7_flag
	ped_var_for_gosub_blip = injured_ped_7_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_7_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_8_flag > 0
	ped_var_for_gosub = injured_ped_8
	ped_var_for_gosub_flag = injured_ped_8_flag
	ped_var_for_gosub_blip = injured_ped_8_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_8_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_9_flag > 0
	ped_var_for_gosub = injured_ped_9
	ped_var_for_gosub_flag = injured_ped_9_flag
	ped_var_for_gosub_blip = injured_ped_9_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_9_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_10_flag > 0
	ped_var_for_gosub = injured_ped_10
	ped_var_for_gosub_flag = injured_ped_10_flag
	ped_var_for_gosub_blip = injured_ped_10_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_10_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_11_flag > 0
	ped_var_for_gosub = injured_ped_11
	ped_var_for_gosub_flag = injured_ped_11_flag
	ped_var_for_gosub_blip = injured_ped_11_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_11_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF injured_ped_12_flag > 0
	ped_var_for_gosub = injured_ped_12
	ped_var_for_gosub_flag = injured_ped_12_flag
	ped_var_for_gosub_blip = injured_ped_12_blip
	GOSUB injured_ped_checks
	IF player_failed_mission = 1
		GOTO ambulance_failed
	ENDIF
	injured_ped_12_flag = ped_var_for_gosub_flag
ENDIF

////////////////

IF saved_peds = number_of_injured_peds
	score_am = ambulance_level * ambulance_level
	score_am *= 50
	PRINT_WITH_NUMBER_BIG REWARD score_am 6000 6
	total_saved_peds += saved_peds
	saved_peds_this_go += saved_peds
	++ number_of_injured_peds
	saved_peds = 0
	ped_counter = 0
	ADD_SCORE player1 score_am
	hospital_blip_flag = 0
	REMOVE_BLIP hospital_blip
	REMOVE_BLIP injured_ped_1_blip
	REMOVE_BLIP injured_ped_2_blip
	REMOVE_BLIP injured_ped_3_blip
	REMOVE_BLIP injured_ped_4_blip
	REMOVE_BLIP injured_ped_5_blip
	REMOVE_BLIP injured_ped_6_blip
	REMOVE_BLIP injured_ped_7_blip
	REMOVE_BLIP injured_ped_8_blip
	REMOVE_BLIP injured_ped_9_blip
	REMOVE_BLIP injured_ped_10_blip
	REMOVE_BLIP injured_ped_11_blip
	REMOVE_BLIP injured_ped_12_blip
	REGISTER_AMBULANCE_LEVEL ambulance_level
	++ ambulance_level
	IF ambulance_level = 13
		PRINT_WITH_NUMBER_BIG A_COMP1 15000 5000 5 //"Ambulance missions complete: $ ~1~"
		ADD_SCORE player1 25000
		PLAY_MISSION_PASSED_TUNE 1
		SET_PLAYER_NEVER_GETS_TIRED player1 TRUE
		IF done_ambulance_progress = 0
			PLAYER_MADE_PROGRESS 1
			PRINT_HELP A_COMP2 //"You will never get tired!"
			SET_PLAYER_NEVER_GETS_TIRED player1 TRUE
			REGISTER_ODDJOB_MISSION_PASSED
			done_ambulance_progress = 1
		ENDIF
		RETURN
	ENDIF
	GOTO mission_root
ENDIF

GOTO ambulance_loop


ambulance_failed:

CLEAR_ONSCREEN_TIMER ped_time_limit
IF NOT ambulance_level = 13
	PRINT_BIG A_FAIL1 5000 5
	PRINT_WITH_NUMBER_BIG A_SAVES saved_peds_this_go 6000 6//PEOPLE SAVED: ~1~
ENDIF

hospital_blip_flag = 0
REMOVE_BLIP hospital_blip
REMOVE_BLIP injured_ped_1_blip
REMOVE_BLIP injured_ped_2_blip
REMOVE_BLIP injured_ped_3_blip
REMOVE_BLIP injured_ped_4_blip
REMOVE_BLIP injured_ped_5_blip
REMOVE_BLIP injured_ped_6_blip
REMOVE_BLIP injured_ped_7_blip
REMOVE_BLIP injured_ped_8_blip
REMOVE_BLIP injured_ped_9_blip
REMOVE_BLIP injured_ped_10_blip
REMOVE_BLIP injured_ped_11_blip
REMOVE_BLIP injured_ped_12_blip

SET_WANTED_MULTIPLIER 1.0

GET_GAME_TIMER timer_mobile_start

flag_player_on_mission = 0
flag_player_on_ambulance_mission = 0
MISSION_HAS_FINISHED
IF done_ambulance_progress = 1
	PRINT_HELP A_COMP2 //"You will never get tired!"
	done_ambulance_progress = 2
ENDIF
RETURN


//////////////////////////////////////////////////////////////////////
injured_ped_checks:
	IF IS_CHAR_DEAD ped_var_for_gosub
		PRINT_NOW A_FAIL3 3000 1//The patient is dead
		player_failed_mission = 1
		RETURN
	ENDIF
		
	IF ped_time_limit = 0
		EXPLODE_CHAR_HEAD ped_var_for_gosub
		REMOVE_CHAR_ELEGANTLY ped_var_for_gosub
		PRINT_NOW A_FAIL2 3000 1//"Your too late"
		player_failed_mission = 1
		RETURN
	ENDIF

	IF ped_var_for_gosub_flag = 3
		GET_CHAR_COORDINATES ped_var_for_gosub sound_x sound_y sound_z
		GET_CAR_HEALTH players_ambulance ambulance_health_now
		IF ambulance_health_now < ambulance_health_last
			time_drop = ambulance_health_last - ambulance_health_now
			time_drop = time_drop * 50
			ped_time_limit = ped_time_limit - time_drop
			IF IS_CHAR_MALE ped_var_for_gosub
				ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_MALE_AMBULANCE_OUCH
			ELSE
				ADD_ONE_OFF_SOUND sound_x sound_y sound_z SOUND_FEMALE_AMBULANCE_OUCH
			ENDIF
			IF ped_time_limit < 0
				ped_time_limit = 0
			ENDIF		
			ambulance_health_last = ambulance_health_now
		ENDIF
	ENDIF

	IF ped_var_for_gosub_flag = 1
		IF LOCATE_PLAYER_IN_CAR_CHAR_3D player1 ped_var_for_gosub 10.0 10.0 2.0 0
		AND IS_CAR_STOPPED players_ambulance // SCFIX
			GET_NUMBER_OF_PASSENGERS players_ambulance peds_in_car
			GET_MAXIMUM_NUMBER_OF_PASSENGERS players_ambulance max_peds_in_car

			IF peds_in_car = max_peds_in_car
				PRINT_NOW A_FULL 5000 1 //"Ambulance full!!!"
				car_full_flag = 1
			ELSE
				car_full_flag = 0
			ENDIF

			GET_CAR_HEALTH players_ambulance ambulance_health_last
			IF car_full_flag = 0
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER ped_var_for_gosub players_ambulance
				ped_var_for_gosub_flag = 2
			ENDIF
		ENDIF
	ENDIF

	IF ped_var_for_gosub_flag = 2
		IF NOT LOCATE_PLAYER_IN_CAR_CHAR_2D player1 ped_var_for_gosub 20.0 20.0 0
			ped_var_for_gosub_flag = 1
		ENDIF
		IF IS_CHAR_OBJ_NO_OBJ ped_var_for_gosub
			IF NOT IS_CHAR_IN_ANY_CAR ped_var_for_gosub
				ped_var_for_gosub_flag = 1
			ENDIF
		ENDIF
	ENDIF	

	IF ped_var_for_gosub_flag = 2
		IF IS_CHAR_IN_ANY_CAR ped_var_for_gosub 
			REMOVE_BLIP ped_var_for_gosub_blip
			
			IF hospital_blip_flag = 0
				ADD_BLIP_FOR_COORD hospital_x hospital_y hospital_z hospital_blip
				hospital_blip_flag = 1
			ENDIF
			
			time_chunk_in_secs = time_chunk / 1000
			PRINT_WITH_NUMBER_BIG A_TIME time_chunk_in_secs 6000 6	//+~1~ Seconds
			ped_time_limit += time_chunk
			ped_var_for_gosub_flag = 3
		ENDIF
	ENDIF

	IF ped_var_for_gosub_flag = 3
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 hospital_x hospital_y hospital_z 6.0 6.0 2.0 1
			SET_CHAR_OBJ_RUN_TO_COORD ped_var_for_gosub hospital_door_x hospital_door_y
			ped_var_for_gosub_flag = 4
		ENDIF	
	ENDIF

	IF ped_var_for_gosub_flag = 4
		SET_CHAR_OBJ_RUN_TO_COORD ped_var_for_gosub hospital_door_x hospital_door_y
		IF NOT IS_CHAR_IN_ANY_CAR ped_var_for_gosub	
			SET_CHAR_OBJ_RUN_TO_COORD ped_var_for_gosub hospital_door_x hospital_door_y
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_var_for_gosub
			PRINT_BIG A_PASS 3000 5
			IF bonus_time_flag = 1
				time_chunk_in_secs = time_chunk / 1000
				PRINT_WITH_NUMBER_BIG A_TIME time_chunk_in_secs 6000 6	//+~1~ Seconds
				STORE_CAR_PLAYER_IS_IN player1 players_ambulance
				GET_CAR_HEALTH players_ambulance players_ambulance_health
				players_ambulance_health += 110
				SET_CAR_HEALTH players_ambulance players_ambulance_health
				ped_time_limit += time_chunk
				++ bonus_time_flag
			ENDIF
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			++ saved_peds
			REGISTER_LIFE_SAVED
			ped_var_for_gosub_flag = 0
		ENDIF
	ENDIF
RETURN
//////////////////////////////////////////////////////////////////////
}