MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Biker Gang Mission One *****************************
// **************************************** The Bike Race **********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME bike1

// Mission start stuff

GOSUB mission_start_bike1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bike1_failed
ENDIF

GOSUB mission_cleanup_bike1

MISSION_END


// Variables for mission

// ******************************** Variables for mission **********************************

// Player stuff

VAR_FLOAT player1_distance_from_cp_bike1

VAR_FLOAT player1_cp_x_bike1

VAR_FLOAT player1_cp_y_bike1

VAR_FLOAT player1_cp_z_bike1

VAR_FLOAT blip_2nd_x_bike1

VAR_FLOAT blip_2nd_y_bike1

VAR_FLOAT blip_2nd_z_bike1

VAR_FLOAT player1_x_bike1

VAR_FLOAT player1_y_bike1

VAR_FLOAT player1_z_bike1

VAR_INT player1_cpcounter_bike1


VAR_INT driver_bike1_bike1

VAR_INT driver_bike1_health_bike1

//VAR_FLOAT driver1_x_bike1

//VAR_FLOAT driver1_y_bike1

//VAR_FLOAT driver1_z_bike1

VAR_FLOAT bike1_locate_size_bike1

VAR_FLOAT bike1_stuck_x_bike1

VAR_FLOAT bike1_stuck_y_bike1

VAR_FLOAT bike1_stuck_z_bike1

VAR_FLOAT bike1_cp_x_bike1

VAR_FLOAT bike1_cp_y_bike1

VAR_FLOAT bike1_cp_z_bike1

VAR_INT race_bike1

VAR_INT bike1_cpcounter_bike1

VAR_INT bike1_blip

// Bike2

VAR_INT driver_bike2_bike1

VAR_INT driver_bike2_health_bike1

VAR_FLOAT bike2_locate_size_bike1

VAR_FLOAT bike2_stuck_x_bike1

VAR_FLOAT bike2_stuck_y_bike1

VAR_FLOAT bike2_stuck_z_bike1

VAR_FLOAT bike2_cp_x_bike1

VAR_FLOAT bike2_cp_y_bike1

VAR_FLOAT bike2_cp_z_bike1

VAR_INT race_bike2_bike1

VAR_INT bike2_cpcounter_bike1

VAR_INT bike2_blip

VAR_INT bike2_health_bike1

// Bike3 Stuff

VAR_INT driver_bike3_bike1

VAR_INT driver_bike3_health_bike1

VAR_FLOAT bike3_locate_size_bike1

VAR_FLOAT bike3_stuck_x_bike1

VAR_FLOAT bike3_stuck_y_bike1

VAR_FLOAT bike3_stuck_z_bike1

VAR_FLOAT bike3_cp_x_bike1

VAR_FLOAT bike3_cp_y_bike1

VAR_FLOAT bike3_cp_z_bike1

VAR_INT race_bike3_bike1

VAR_INT bike3_cpcounter_bike1

VAR_INT bike3_blip

VAR_INT bike3_health_bike1

// General stuff

VAR_FLOAT bike_x_bike1

VAR_FLOAT bike_y_bike1

VAR_FLOAT bike_z_bike1

VAR_FLOAT bike_headings_bike1

VAR_FLOAT difference_x_float_d_bike1

VAR_FLOAT difference_y_float_d_bike1

VAR_FLOAT sum_difference_d_xy_bike1	

VAR_FLOAT bike_distance_from_cp_bike1

// Used for switching off any roads I cant have cars on

VAR_FLOAT road1_x_bike1

VAR_FLOAT road1_y_bike1

VAR_FLOAT road1_z_bike1

VAR_FLOAT road2_x_bike1

VAR_FLOAT road2_y_bike1

VAR_FLOAT road2_z_bike1

// Check point stuff

VAR_FLOAT cp1_x_bike1 cp1_y_bike1 cp1_z_bike1

VAR_FLOAT cp2_x_bike1 cp2_y_bike1 cp2_z_bike1

VAR_FLOAT cp3_x_bike1 cp3_y_bike1 cp3_z_bike1

VAR_FLOAT cp4_x_bike1 cp4_y_bike1 cp4_z_bike1

VAR_FLOAT cp5_x_bike1 cp5_y_bike1 cp5_z_bike1

VAR_FLOAT cp6_x_bike1 cp6_y_bike1 cp6_z_bike1

VAR_FLOAT cp7_x_bike1 cp7_y_bike1 cp7_z_bike1

VAR_FLOAT cp8_x_bike1 cp8_y_bike1 cp8_z_bike1

VAR_FLOAT cp9_x_bike1 cp9_y_bike1 cp9_z_bike1

VAR_FLOAT cp10_x_bike1 cp10_y_bike1 cp10_z_bike1

VAR_FLOAT cp11_x_bike1 cp11_y_bike1 cp11_z_bike1

VAR_FLOAT cp12_x_bike1 cp12_y_bike1 cp12_z_bike1

VAR_FLOAT cp13_x_bike1 cp13_y_bike1 cp13_z_bike1

VAR_FLOAT cp14_x_bike1 cp14_y_bike1 cp14_z_bike1

VAR_FLOAT cp15_x_bike1 cp15_y_bike1 cp15_z_bike1

VAR_FLOAT cp16_x_bike1 cp16_y_bike1 cp16_z_bike1

VAR_FLOAT cp17_x_bike1 cp17_y_bike1 cp17_z_bike1

VAR_FLOAT cp18_x_bike1 cp18_y_bike1 cp18_z_bike1

VAR_FLOAT gosub_cp_x_bike1

VAR_FLOAT gosub_cp_y_bike1

VAR_FLOAT gosub_cp_z_bike1

VAR_FLOAT gosub_cp_2nd_x_bike1

VAR_FLOAT gosub_cp_2nd_y_bike1

VAR_FLOAT gosub_cp_2nd_z_bike1

// General stuff

VAR_INT blip_chase_bike1

VAR_INT second_blip_bike1_bike1 

VAR_INT bike_health_bike1

VAR_INT gosub_race_bike_bike1

VAR_INT gosub_cpcounter_bike1

VAR_INT position_bike1

VAR_INT race_timer_bike1

VAR_INT total_checkpoints_bike1

VAR_INT timer_reset_flag

// Guys fallen off of bike checks

VAR_INT gosub_rider_bike1  // Sets this to the rider of any bike I set it too

VAR_FLOAT gosub_rider_x_bike1

VAR_FLOAT gosub_rider_y_bike1

VAR_FLOAT gosub_rider_z_bike1

VAR_FLOAT gosub_rider_x1_bike1  // Used for an area check is guy is on screen and off bike

VAR_FLOAT gosub_rider_y1_bike1 // Used for an area check is guy is on screen and off bike

VAR_INT flag_player1_cheated_bike1 // Player has hit a rider or bike before the race starts

VAR_INT gosub_rider_health_bike1  // Checks the riders health and increases it if they are under 50% health

VAR_INT gosub_driver_bike_bike1 // Tells me if the bike has anybody on it or not

VAR_INT player1_had_bike_message_bike1 // Tells the player1 he needs a FREEWAY if he is not on one.

// Timer Stuff

VAR_INT race_timer_mins_bike1

VAR_INT race_timer_seconds_bike1

VAR_INT race_timer_seconds2_bike1

VAR_INT player_is_on_correct_bike_bike1

VAR_INT temp_int_bike1

// New flag to check if guy has fallen off of bike

VAR_INT flag_gosub_rider_off_bike1

flag_gosub_rider_off_bike1 = 0

VAR_INT driver_bike1_off_bike1

driver_bike1_off_bike1 = 0

VAR_INT driver_bike2_off_bike1

driver_bike2_off_bike1 = 0

VAR_INT driver_bike3_off_bike1

driver_bike3_off_bike1 = 0

// ****************************************Mission Start************************************

mission_start_bike1:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

// player1 stuff

player1_cpcounter_bike1 = 0

// Bike1 stuff

bike1_cpcounter_bike1 = 0

bike1_locate_size_bike1 = 7.0

driver_bike1_health_bike1 = 100

// Bike2 stuff

bike2_cpcounter_bike1 = 0

bike2_locate_size_bike1 = 7.0

driver_bike2_health_bike1 = 100

// bike3 stuff

bike3_cpcounter_bike1 = 0

bike3_locate_size_bike1 = 7.0

driver_bike3_health_bike1 = 100

// General stuff

gosub_cpcounter_bike1 = 0

timer_reset_flag = 0

gosub_rider_health_bike1 = 100

// Guy fallen off of bike stuff

gosub_rider_x1_bike1 = 0.0  // Used for an area check is guy is on screen and off bike

gosub_rider_y1_bike1 = 0.0

gosub_rider_x_bike1 = 0.0

gosub_rider_y_bike1 = 0.0

gosub_rider_z_bike1 = 0.0

flag_player1_cheated_bike1 = 0

gosub_driver_bike_bike1 = 0

player1_had_bike_message_bike1 = 0

// timer stuff

race_timer_mins_bike1 = 0

race_timer_seconds_bike1 = 0

race_timer_seconds2_bike1 = 0

race_timer_bike1 = 0

// Heading stuff

temp_int_bike1 = 0

WAIT 0

LOAD_MISSION_TEXT BIKE1

// FIXMIAMI: START - remove cop uniform from the player
IF NOT IS_CHAR_DEAD scplayer
	IF IS_PLAYER_WEARING player1 player6
		UNDRESS_CHAR scplayer player
		LOAD_ALL_MODELS_NOW
		IF NOT IS_CHAR_DEAD scplayer
			DRESS_CHAR scplayer
		ENDIF
	ENDIF
ENDIF
// FIXMIAMI: END

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -609.723 658.861 9.908 279.440

{

// **************************************** Cut Scene **************************************

LOAD_SPECIAL_CHARACTER 1 CSbigm

LOAD_SPECIAL_CHARACTER 2 CSplay

LOAD_SPECIAL_CHARACTER 3 mgoona

REQUEST_MODEL bka

REQUEST_MODEL bkb

LOAD_SPECIAL_MODEL CUTOBJ01 poolq

LOAD_SPECIAL_MODEL CUTOBJ02 polbals

SET_AREA_VISIBLE VIS_BIKER_BAR

LOAD_SCENE -597.02 642.46 11.0

SET_EXTRA_COLOURS 15 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED bka
OR NOT HAS_MODEL_LOADED bkb

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bike_1

SET_CUTSCENE_OFFSET -602.052 636.289 10.636
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_bigm
SET_CUTSCENE_ANIM cs_bigm CSbigm

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_mgoona
SET_CUTSCENE_ANIM cs_mgoona mgoona

CREATE_CUTSCENE_OBJECT bka cs_cougr
SET_CUTSCENE_ANIM cs_cougr bka

CREATE_CUTSCENE_OBJECT bkb cs_zepp
SET_CUTSCENE_ANIM cs_zepp bkb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_bmchcue
SET_CUTSCENE_ANIM cs_bmchcue poolq01

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_cougcue
SET_CUTSCENE_ANIM cs_cougcue poolq02

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_poolballs
SET_CUTSCENE_ANIM cs_poolballs polbals

CLEAR_AREA -597.25 655.87 10.06 1.0 TRUE
SET_PLAYER_COORDINATES player1 -597.25 655.87 10.06
SET_PLAYER_HEADING player1 0.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5467 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_A ) 10000 1 //"Where's Baker?"

WHILE cs_time < 11136 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_B ) 10000 1 //"I'm looking for a Big Mitch Baker..."

WHILE cs_time < 13361 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_C ) 10000 1 //"Who's looking?"

WHILE cs_time < 14457 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_D ) 10000 1 //"Tommy Vercetti.

WHILE cs_time < 16423 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_E ) 10000 1 //"Vercetti.

WHILE cs_time < 18634 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_F ) 10000 1 //"You don't look like the law, so that's bought you a minute.

WHILE cs_time < 21688 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_G ) 10000 1 //"You better talk fast.

WHILE cs_time < 22905
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_H ) 10000 1 //"Kent Paul said you might be interested in pulling security for a gig he's got set up."

WHILE cs_time < 26588 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_I ) 10000 1 //"Kent Paul? Sheesh! No wonder he sent ya.

WHILE cs_time < 30208 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_J ) 10000 1 //"The last time he was here he left through the window in nothing but his limey birthday suit"

WHILE cs_time < 34442 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_K ) 10000 1 //"Are you interested or not?"

WHILE cs_time < 36593 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_L ) 10000 1 //"We only do favours for our own."

WHILE cs_time < 39183 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_M ) 10000 1 //"How do I join?"

WHILE cs_time < 41838 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_N ) 10000 1 //"This ain't no country club, boy. Can you handle a bike?"

WHILE cs_time < 45261 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_O ) 10000 1 //"Can you sit on a stool and drink?"

WHILE cs_time < 47270 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM1_P ) 10000 1 //"Cougar, Zeppelin; go see how this guy handles a bike..."

WHILE cs_time < 51712
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 55482
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

MARK_MODEL_AS_NO_LONGER_NEEDED bka
MARK_MODEL_AS_NO_LONGER_NEEDED bkb

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

CLEAR_EXTRA_COLOURS FALSE

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE -597.25 655.87 10.06

// *************************************** END OF CUT SCENE ********************************
	    		
// **************************************** Race Coordinates *******************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

SET_ENTER_CAR_RANGE_MULTIPLIER 6.0

SET_RADIO_CHANNEL V_ROCK -1

total_checkpoints_bike1 = 18 

// Player start point

player1_x_bike1 = -592.65   
player1_y_bike1 = 667.08    
player1_z_bike1 = 9.91

// Check point 1

cp1_x_bike1  = -537.77
cp1_y_bike1  = 674.27  
cp1_z_bike1  = 9.90 

// Check point 2

cp2_x_bike1  = -478.51
cp2_y_bike1  = 803.08 
cp2_z_bike1  = 9.91

// Check point 3

cp3_x_bike1  = -387.36 
cp3_y_bike1  = 1017.69 
cp3_z_bike1  = 8.46

// Check point 4

cp4_x_bike1  = -300.36 
cp4_y_bike1  = 1285.44
cp4_z_bike1  = 10.59

// Check point 5

cp5_x_bike1  = -487.11 
cp5_y_bike1  = 1337.11 
cp5_z_bike1  = 10.59

// Check point 6

cp6_x_bike1  = -735.62 
cp6_y_bike1  = 1314.60
cp6_z_bike1  = 10.59

// Check point 7

cp7_x_bike1  = -817.54 
cp7_y_bike1  = 1374.86
cp7_z_bike1  = 10.41

// Check point 8

cp8_x_bike1  = -880.23  
cp8_y_bike1  = 1441.79
cp8_z_bike1  = 10.74

// Check point 9

cp9_x_bike1  = -683.27 
cp9_y_bike1  = 1465.76 
cp9_z_bike1  = 10.92 

// Check point 10

cp10_x_bike1 = -776.75  
cp10_y_bike1 = 1383.71
cp10_z_bike1 = 10.86

// Check point 11

cp11_x_bike1 = -873.98 
cp11_y_bike1 = 1328.55
cp11_z_bike1 = 10.29 

// Check point 12

cp12_x_bike1 = -869.53 
cp12_y_bike1 = 1107.01
cp12_z_bike1 = 9.90

// Check point 13

cp13_x_bike1 = -873.40
cp13_y_bike1 = 953.70
cp13_z_bike1 = 9.90

// Check point 14

cp14_x_bike1 = -871.27 
cp14_y_bike1 = 775.91 
cp14_z_bike1 = 9.90  

// Check point 15

cp15_x_bike1 = -726.25
cp15_y_bike1 = 749.28  
cp15_z_bike1 = 9.92   

// Check point 16

cp16_x_bike1 = -623.68   
cp16_y_bike1 = 743.44  
cp16_z_bike1 = 9.42 

// Check point 17

cp17_x_bike1 = -516.60   
cp17_y_bike1 = 733.58  
cp17_z_bike1 = 9.65  

// Check point 18

cp18_x_bike1 = -596.92 
cp18_y_bike1 = 666.82
cp18_z_bike1 = 9.91

// starting position of racer1

bike1_stuck_x_bike1 = -592.65 
bike1_stuck_y_bike1 = 665.35 
bike1_stuck_z_bike1 = 9.91

bike2_stuck_x_bike1 = -592.65 
bike2_stuck_y_bike1 = 663.15 
bike2_stuck_z_bike1 = 9.91

bike3_stuck_x_bike1 = -592.65 
bike3_stuck_y_bike1 = 661.26 
bike3_stuck_z_bike1 = 9.91

// sets all the cars to face the correct way

bike_headings_bike1 = 270.0
 
// Sets up coords of any roads I need to switch off

road1_x_bike1 = -648.52 
road1_y_bike1 = 629.85
road1_z_bike1 = 8.0
road2_x_bike1 = -499.21 
road2_y_bike1 = 702.38 
road2_z_bike1 = 15.0

// bike flag

player_is_on_correct_bike_bike1 = 0
							   
// Waiting for models to load

REQUEST_MODEL BKa // biker model a

REQUEST_MODEL BKb // biker model b

REQUEST_MODEL ANGEL

REQUEST_MODEL UZI

LOAD_MISSION_AUDIO 1 ( BIKEREV )  // BIKE rev

LOAD_MISSION_AUDIO 2 ( BIKE1_1 ) // How good are you 

WHILE NOT HAS_MODEL_LOADED BKa
OR NOT HAS_MODEL_LOADED BKb
OR NOT HAS_MODEL_LOADED ANGEL
OR NOT HAS_MODEL_LOADED UZI
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0

ENDWHILE

SET_CAR_DENSITY_MULTIPLIER 0.5 // half of normal

// ***************************************** Bike Creation **********************************

CLEAR_AREA_OF_CARS road1_x_bike1 road1_y_bike1 road1_z_bike1 road2_x_bike1 road2_y_bike1 road2_z_bike1

SWITCH_ROADS_OFF road1_x_bike1 road1_y_bike1 road1_z_bike1 road2_x_bike1 road2_y_bike1 road2_z_bike1

// Creates bike1

CREATE_CAR ANGEL bike1_stuck_x_bike1 bike1_stuck_y_bike1 bike1_stuck_z_bike1 race_bike1

SET_CAR_TRACTION race_bike1 2.0

SET_CAR_HEADING race_bike1 bike_headings_bike1

SET_CAR_DRIVING_STYLE race_bike1 2

SET_CAR_CRUISE_SPEED race_bike1 63.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER race_bike1 TRUE

// Biker1

CREATE_CHAR_INSIDE_CAR race_bike1 PEDTYPE_CIVMALE BKa driver_bike1_bike1

SHUT_CHAR_UP driver_bike1_bike1 TRUE

SET_CHAR_DROWNS_IN_WATER driver_bike1_bike1 FALSE

CLEAR_CHAR_THREAT_SEARCH driver_bike1_bike1

SET_CHAR_OBJ_NO_OBJ driver_bike1_bike1

SET_CHAR_ONLY_DAMAGED_BY_PLAYER driver_bike1_bike1 TRUE

CAR_SET_IDLE race_bike1

// Creates bike 2

CREATE_CAR ANGEL bike2_stuck_x_bike1 bike2_stuck_y_bike1 bike2_stuck_z_bike1 race_bike2_bike1

SET_CAR_TRACTION race_bike2_bike1 2.0

SET_CAR_HEADING race_bike2_bike1 bike_headings_bike1

SET_CAR_DRIVING_STYLE race_bike2_bike1 2

SET_CAR_CRUISE_SPEED race_bike2_bike1 63.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER race_bike2_bike1 TRUE

// Biker2

CREATE_CHAR_INSIDE_CAR race_bike2_bike1 PEDTYPE_CIVMALE BKb driver_bike2_bike1

SHUT_CHAR_UP driver_bike2_bike1 TRUE

SET_CHAR_DROWNS_IN_WATER driver_bike2_bike1 FALSE

CLEAR_CHAR_THREAT_SEARCH driver_bike2_bike1

SET_CHAR_OBJ_NO_OBJ driver_bike2_bike1

SET_CHAR_ONLY_DAMAGED_BY_PLAYER driver_bike2_bike1 TRUE

CAR_SET_IDLE race_bike2_bike1

// Creates bike 3

CREATE_CAR ANGEL bike3_stuck_x_bike1 bike3_stuck_y_bike1 bike3_stuck_z_bike1 race_bike3_bike1

SET_CAR_TRACTION race_bike3_bike1 2.0

SET_CAR_HEADING race_bike3_bike1 bike_headings_bike1

SET_CAR_DRIVING_STYLE race_bike3_bike1 2

SET_CAR_CRUISE_SPEED race_bike3_bike1 63.0

SET_CAR_ONLY_DAMAGED_BY_PLAYER race_bike3_bike1 TRUE

// Biker3

CREATE_CHAR_INSIDE_CAR race_bike3_bike1 PEDTYPE_CIVMALE BKa driver_bike3_bike1

SHUT_CHAR_UP driver_bike3_bike1 TRUE

SET_CHAR_DROWNS_IN_WATER driver_bike3_bike1 FALSE

CLEAR_CHAR_THREAT_SEARCH driver_bike3_bike1

SET_CHAR_OBJ_NO_OBJ driver_bike3_bike1

SET_CHAR_ONLY_DAMAGED_BY_PLAYER driver_bike3_bike1 TRUE

CAR_SET_IDLE race_bike3_bike1

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
SET_PLAYER_VISIBLE player1 TRUE
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

ADD_BLIP_FOR_COORD player1_x_bike1 player1_y_bike1 player1_z_bike1 blip_chase_bike1

PRINT_NOW ( BM1_1 ) 5000 1 //"~g~Get a Hog and get to the starting grid."

// waiting for the player1 to get to the starting grid					

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 player1_x_bike1 player1_y_bike1 player1_z_bike1 2.0 2.0 2.0 1
OR player_is_on_correct_bike_bike1 = 0
	 				   
	WAIT 0

	IF IS_PLAYER_IN_MODEL player1 FREEWAY
	OR IS_PLAYER_IN_MODEL player1 ANGEL
		player_is_on_correct_bike_bike1 = 1
	ELSE
		player_is_on_correct_bike_bike1 = 0
	ENDIF	

	IF LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 player1_x_bike1 player1_y_bike1 player1_z_bike1 2.0 2.0 2.0 1

		IF NOT IS_PLAYER_IN_MODEL player1 FREEWAY
		AND NOT IS_PLAYER_IN_MODEL player1 ANGEL
			
			IF player1_had_bike_message_bike1 = 0
	 			PRINT_NOW ( BM1_2 ) 5000 1 //"You need to be on a Hog to take part!"
				player1_had_bike_message_bike1 = 1
			ENDIF

		ENDIF

	ELSE
		player1_had_bike_message_bike1 = 0
	ENDIF
	
	IF IS_CAR_DEAD race_bike1
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ELSE
	   	   
	    IF IS_PLAYER_TOUCHING_VEHICLE player1 race_bike1
			flag_player1_cheated_bike1 = 1
	   		GOTO race_start_bike1 
		ENDIF
		
	ENDIF

   	IF IS_CAR_DEAD race_bike2_bike1
   		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
   		GOTO mission_bike1_failed
   	ELSE
	   
		IF IS_PLAYER_TOUCHING_VEHICLE player1 race_bike2_bike1
			flag_player1_cheated_bike1 = 1
	   		GOTO race_start_bike1 
		ENDIF

	ENDIF

   	IF IS_CAR_DEAD race_bike3_bike1
  		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
  		GOTO mission_bike1_failed
   	ELSE
			 	 
		IF IS_PLAYER_TOUCHING_VEHICLE player1 race_bike3_bike1
			flag_player1_cheated_bike1 = 1
	   		GOTO race_start_bike1 
		ENDIF

	ENDIF
	   	
// Checks the health of bike 1 and rider1
	
	GET_CAR_HEALTH race_bike1 bike_health_bike1

	IF bike_health_bike1 <= 999
	OR IS_CAR_TYRE_BURST race_bike1 ANY_WHEEL // no 4
		bike_health_bike1 = 9
		GOTO race_start_bike1
	ENDIF

	IF NOT IS_CHAR_DEAD driver_bike1_bike1

		GET_CHAR_HEALTH driver_bike1_bike1 driver_bike1_health_bike1

		IF driver_bike1_health_bike1 <= 99
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF

		IF NOT IS_CHAR_IN_CAR driver_bike1_bike1 race_bike1
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF	 

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF

// Checks for bike2 and rider2

	GET_CAR_HEALTH race_bike2_bike1 bike2_health_bike1

	IF bike2_health_bike1 <= 999
	OR IS_CAR_TYRE_BURST race_bike2_bike1 ANY_WHEEL // no 4
		bike2_health_bike1 = 9
		GOTO race_start_bike1
	ENDIF

	IF NOT IS_CHAR_DEAD driver_bike2_bike1

		GET_CHAR_HEALTH driver_bike2_bike1 driver_bike2_health_bike1

		IF driver_bike2_health_bike1 <= 99
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF

		IF NOT IS_CHAR_IN_CAR driver_bike2_bike1 race_bike2_bike1
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF	 

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF

// Checks for bike3 and rider3

	GET_CAR_HEALTH race_bike3_bike1 bike3_health_bike1

	IF bike3_health_bike1 <= 999
	OR IS_CAR_TYRE_BURST race_bike3_bike1 ANY_WHEEL // no 4
		bike3_health_bike1 = 9
		GOTO race_start_bike1
	ENDIF

	IF NOT IS_CHAR_DEAD driver_bike3_bike1

		GET_CHAR_HEALTH driver_bike3_bike1 driver_bike3_health_bike1

		IF driver_bike3_health_bike1 <= 99
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF

		IF NOT IS_CHAR_IN_CAR driver_bike3_bike1 race_bike3_bike1
			flag_player1_cheated_bike1 = 1
			GOTO race_start_bike1
		ENDIF	 

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF
	
ENDWHILE

// *********************************** Starts The Bike Race ********************************

race_start_bike1:

PLAY_MISSION_AUDIO 1 // Bike Rev
PLAY_MISSION_AUDIO 2 // How good are you
PRINT_NOW ( BIKE1_1 ) 5000 1 //"How good are you!"

IF bike_health_bike1 = 9
OR flag_player1_cheated_bike1 = 1
OR bike2_health_bike1 = 9
OR bike3_health_bike1 = 9 
	PRINT_BIG ( RACE1 ) 1200 4 // "3..2..1.. GO GO GO!"
ELSE
  	SET_PLAYER_CONTROL player1 OFF
  	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
  	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
  	PRINT_BIG ( RACE2 ) 1100 4 //"THREE"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
  	WAIT 1000
  	PRINT_BIG ( RACE3 ) 1100 4 //"TWO"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2

	IF HAS_MISSION_AUDIO_FINISHED 2
		CLEAR_THIS_PRINT ( BIKE1_1 )
	ENDIF

  	WAIT 1000
   	PRINT_BIG ( RACE4 ) 1100 4 //"ONE"
   	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1

	IF HAS_MISSION_AUDIO_FINISHED 2
		CLEAR_THIS_PRINT ( BIKE1_1 )
	ENDIF

  	WAIT 1000
  	PRINT_BIG ( RACE5 ) 800 4  //"GO!"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO

	IF HAS_MISSION_AUDIO_FINISHED 2
		CLEAR_THIS_PRINT ( BIKE1_1 )
	ENDIF

  	SET_PLAYER_CONTROL player1 ON
  	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
  	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
ENDIF

IF HAS_MISSION_AUDIO_FINISHED 2
	CLEAR_THIS_PRINT ( BIKE1_1 )
ENDIF

IF IS_CAR_DEAD race_bike1
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ELSE
	ADD_STUCK_CAR_CHECK race_bike1 1.0 2000
ENDIF

IF NOT IS_CHAR_DEAD driver_bike1_bike1
	SHUT_CHAR_UP driver_bike1_bike1 FALSE
ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

IF IS_CAR_DEAD race_bike2_bike1
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ELSE
	ADD_STUCK_CAR_CHECK race_bike2_bike1 1.0 2000
ENDIF

IF NOT IS_CHAR_DEAD driver_bike2_bike1
	SHUT_CHAR_UP driver_bike2_bike1 FALSE
ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

IF IS_CAR_DEAD race_bike3_bike1
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ELSE
	ADD_STUCK_CAR_CHECK race_bike3_bike1 1.0 2000
ENDIF

IF NOT IS_CHAR_DEAD driver_bike3_bike1
	SHUT_CHAR_UP driver_bike3_bike1 FALSE
ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

REMOVE_BLIP blip_chase_bike1

ADD_BLIP_FOR_CHAR_OLD driver_bike1_bike1 GREEN MARKER_ONLY bike1_blip

ADD_BLIP_FOR_CHAR_OLD driver_bike2_bike1 GREEN MARKER_ONLY bike2_blip

ADD_BLIP_FOR_CHAR_OLD driver_bike3_bike1 GREEN MARKER_ONLY bike3_blip

GOSUB get_next_checkpoint_bike1

player1_cp_x_bike1 = gosub_cp_x_bike1
player1_cp_y_bike1 = gosub_cp_y_bike1
player1_cp_z_bike1 = gosub_cp_z_bike1
blip_2nd_x_bike1 = gosub_cp_2nd_x_bike1
blip_2nd_y_bike1 = gosub_cp_2nd_y_bike1
blip_2nd_z_bike1 = gosub_cp_2nd_z_bike1

bike1_cp_x_bike1 = gosub_cp_x_bike1
bike1_cp_y_bike1 = gosub_cp_y_bike1
bike1_cp_z_bike1 = gosub_cp_z_bike1

bike2_cp_x_bike1 = gosub_cp_x_bike1
bike2_cp_y_bike1 = gosub_cp_y_bike1
bike2_cp_z_bike1 = gosub_cp_z_bike1

bike3_cp_x_bike1 = gosub_cp_x_bike1
bike3_cp_y_bike1 = gosub_cp_y_bike1
bike3_cp_z_bike1 = gosub_cp_z_bike1

ADD_BLIP_FOR_COORD player1_cp_x_bike1 player1_cp_y_bike1 player1_cp_z_bike1 blip_chase_bike1

ADD_BLIP_FOR_COORD_OLD blip_2nd_x_bike1 blip_2nd_y_bike1 blip_2nd_z_bike1 PURPLE BLIP_ONLY second_blip_bike1_bike1
CHANGE_BLIP_SCALE second_blip_bike1_bike1 2
DIM_BLIP second_blip_bike1_bike1 TRUE

// Checks for bike 1

IF NOT IS_CHAR_DEAD driver_bike1_bike1

	IF NOT IS_CAR_DEAD race_bike1

		IF IS_CHAR_IN_CAR driver_bike1_bike1 race_bike1 
			CAR_GOTO_COORDINATES race_bike1 bike1_cp_x_bike1 bike1_cp_y_bike1 bike1_cp_z_bike1
		ENDIF

	ENDIF

ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

WAIT 70

// checks for bike2

IF NOT IS_CHAR_DEAD driver_bike2_bike1

	IF NOT IS_CAR_DEAD race_bike2_bike1

		IF IS_CHAR_IN_CAR driver_bike2_bike1 race_bike2_bike1 
			CAR_GOTO_COORDINATES race_bike2_bike1 bike2_cp_x_bike1 bike2_cp_y_bike1 bike2_cp_z_bike1
		ENDIF

	ENDIF

ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

WAIT 90

// checks for bike3

IF NOT IS_CHAR_DEAD driver_bike3_bike1

	IF NOT IS_CAR_DEAD race_bike3_bike1

		IF IS_CHAR_IN_CAR driver_bike3_bike1 race_bike3_bike1 
			CAR_GOTO_COORDINATES race_bike3_bike1 bike3_cp_x_bike1 bike3_cp_y_bike1 bike3_cp_z_bike1
		ENDIF

	ENDIF

ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

//timer_started_bike1 = game_time_bike1

// Starts the game timer

DISPLAY_ONSCREEN_TIMER_WITH_STRING race_timer_bike1 TIMER_UP ( R_TIME )  

// The race code

WHILE player1_cpcounter_bike1 < total_checkpoints_bike1

	WAIT 0
     	 	
	position_bike1 = 0

// Player checks

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 player1_cp_x_bike1 player1_cp_y_bike1 player1_cp_z_bike1 6.0 6.0 6.0 0

		IF IS_PLAYER_IN_MODEL player1 FREEWAY
		OR IS_PLAYER_IN_MODEL player1 ANGEL
	
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		
			++ player1_cpcounter_bike1
		
			REMOVE_BLIP blip_chase_bike1
			REMOVE_BLIP second_blip_bike1_bike1
		
			gosub_cpcounter_bike1 = player1_cpcounter_bike1
	   		GOSUB get_next_checkpoint_bike1
			player1_cp_x_bike1 = gosub_cp_x_bike1
			player1_cp_y_bike1 = gosub_cp_y_bike1
			player1_cp_z_bike1 = gosub_cp_z_bike1
			blip_2nd_x_bike1 = gosub_cp_2nd_x_bike1
			blip_2nd_y_bike1 = gosub_cp_2nd_y_bike1
			blip_2nd_z_bike1 = gosub_cp_2nd_z_bike1
		
			IF player1_cpcounter_bike1 = total_checkpoints_bike1
				GOTO mission_bike1_passed		
			ENDIF

			ADD_BLIP_FOR_COORD player1_cp_x_bike1 player1_cp_y_bike1 player1_cp_z_bike1 blip_chase_bike1

			IF player1_cpcounter_bike1 < 17
				ADD_BLIP_FOR_COORD_OLD blip_2nd_x_bike1 blip_2nd_y_bike1 blip_2nd_z_bike1 PURPLE BLIP_ONLY second_blip_bike1_bike1
				DIM_BLIP second_blip_bike1_bike1 ON
				CHANGE_BLIP_SCALE second_blip_bike1_bike1 2
			ENDIF

		ENDIF

	ENDIF

// Checks for bike1

	IF NOT IS_CHAR_DEAD driver_bike1_bike1
			   									
		IF NOT IS_CAR_DEAD race_bike1
		
			gosub_race_bike_bike1 = race_bike1
			gosub_cpcounter_bike1 = bike1_cpcounter_bike1
			gosub_rider_bike1 = driver_bike1_bike1
			gosub_cp_x_bike1 = bike1_cp_x_bike1 
			gosub_cp_y_bike1 = bike1_cp_y_bike1
			gosub_cp_z_bike1 = bike1_cp_z_bike1
			flag_gosub_rider_off_bike1 = driver_bike1_off_bike1 
						
			GOSUB player1_position_bike1
			GOSUB bike_stuck_checks_bike1
			GOSUB water_checks_bike1
			GOSUB rider_fallen_off_bike_bike1
						
			driver_bike1_bike1 = gosub_rider_bike1
			race_bike1 = gosub_race_bike_bike1
			driver_bike1_off_bike1 = flag_gosub_rider_off_bike1
										
	 		IF LOCATE_CHAR_ANY_MEANS_3D driver_bike1_bike1 bike1_cp_x_bike1 bike1_cp_y_bike1 bike1_cp_z_bike1 bike1_locate_size_bike1 bike1_locate_size_bike1 bike1_locate_size_bike1 0
			AND IS_CHAR_IN_MODEL driver_bike1_bike1 ANGEL
			 
				++ bike1_cpcounter_bike1
				gosub_cpcounter_bike1 = bike1_cpcounter_bike1
				GOSUB get_next_checkpoint_bike1
				bike1_cp_x_bike1 = gosub_cp_x_bike1
				bike1_cp_y_bike1 = gosub_cp_y_bike1
				bike1_cp_z_bike1 = gosub_cp_z_bike1
			
				IF bike1_cpcounter_bike1 = 17
					bike1_locate_size_bike1 = 6.0
				ENDIF

				IF bike1_cpcounter_bike1 = total_checkpoints_bike1
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_bike1_failed		
				ENDIF

				IF IS_CHAR_IN_CAR driver_bike1_bike1 race_bike1
					   			
					IF bike1_locate_size_bike1 = 7.0
						CAR_GOTO_COORDINATES race_bike1 bike1_cp_x_bike1 bike1_cp_y_bike1 bike1_cp_z_bike1
					ELSE
						CAR_GOTO_COORDINATES_ACCURATE race_bike1 bike1_cp_x_bike1 bike1_cp_y_bike1 bike1_cp_z_bike1
					ENDIF
										
				ENDIF

			ENDIF
			
		ENDIF

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF

// checks for bike2

	IF NOT IS_CHAR_DEAD driver_bike2_bike1
			   							
		IF NOT IS_CAR_DEAD race_bike2_bike1
		
			gosub_race_bike_bike1 = race_bike2_bike1
			gosub_cpcounter_bike1 = bike2_cpcounter_bike1
			gosub_rider_bike1 = driver_bike2_bike1
			gosub_cp_x_bike1 = bike2_cp_x_bike1 
			gosub_cp_y_bike1 = bike2_cp_y_bike1
			gosub_cp_z_bike1 = bike2_cp_z_bike1
			flag_gosub_rider_off_bike1 = driver_bike2_off_bike1 
			GOSUB player1_position_bike1
			GOSUB bike_stuck_checks_bike1
			GOSUB water_checks_bike1
			GOSUB rider_fallen_off_bike_bike1
						 
			driver_bike2_bike1 = gosub_rider_bike1
			race_bike2_bike1 = gosub_race_bike_bike1
			driver_bike2_off_bike1 = flag_gosub_rider_off_bike1
				
	 		IF LOCATE_CHAR_ANY_MEANS_3D driver_bike2_bike1 bike2_cp_x_bike1 bike2_cp_y_bike1 bike2_cp_z_bike1 bike2_locate_size_bike1 bike2_locate_size_bike1 bike2_locate_size_bike1 0
			AND IS_CHAR_IN_MODEL driver_bike2_bike1 ANGEL

				++ bike2_cpcounter_bike1
				gosub_cpcounter_bike1 = bike2_cpcounter_bike1

				GOSUB get_next_checkpoint_bike1
				bike2_cp_x_bike1 = gosub_cp_x_bike1
				bike2_cp_y_bike1 = gosub_cp_y_bike1
				bike2_cp_z_bike1 = gosub_cp_z_bike1
			
				IF bike2_cpcounter_bike1 = 17
					bike2_locate_size_bike1 = 6.0
				ENDIF

				IF bike2_cpcounter_bike1 = total_checkpoints_bike1
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_bike1_failed		
				ENDIF

				IF IS_CHAR_IN_CAR driver_bike2_bike1 race_bike2_bike1
					   			
					IF bike2_locate_size_bike1 = 7.0
						CAR_GOTO_COORDINATES race_bike2_bike1 bike2_cp_x_bike1 bike2_cp_y_bike1 bike2_cp_z_bike1
					ELSE
						CAR_GOTO_COORDINATES_ACCURATE race_bike2_bike1 bike2_cp_x_bike1 bike2_cp_y_bike1 bike2_cp_z_bike1
					ENDIF
					
				ENDIF

			ENDIF
						   			
   		ENDIF

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF
	
// checks for bike 3

	IF NOT IS_CHAR_DEAD driver_bike3_bike1
			   				   						
		IF NOT IS_CAR_DEAD race_bike3_bike1
		
			gosub_race_bike_bike1 = race_bike3_bike1
			gosub_cpcounter_bike1 = bike3_cpcounter_bike1
			gosub_rider_bike1 = driver_bike3_bike1
			gosub_cp_x_bike1 = bike3_cp_x_bike1 
			gosub_cp_y_bike1 = bike3_cp_y_bike1
			gosub_cp_z_bike1 = bike3_cp_z_bike1
			flag_gosub_rider_off_bike1 = driver_bike3_off_bike1 
			GOSUB player1_position_bike1
			GOSUB bike_stuck_checks_bike1
			GOSUB water_checks_bike1
			GOSUB rider_fallen_off_bike_bike1
						
			driver_bike3_bike1 = gosub_rider_bike1
			race_bike3_bike1 = gosub_race_bike_bike1
			driver_bike3_off_bike1 = flag_gosub_rider_off_bike1
				
	 		IF LOCATE_CHAR_ANY_MEANS_3D driver_bike3_bike1 bike3_cp_x_bike1 bike3_cp_y_bike1 bike3_cp_z_bike1 bike3_locate_size_bike1 bike3_locate_size_bike1 bike3_locate_size_bike1 0
			AND IS_CHAR_IN_MODEL driver_bike3_bike1 ANGEL

				++ bike3_cpcounter_bike1
				gosub_cpcounter_bike1 = bike3_cpcounter_bike1

				GOSUB get_next_checkpoint_bike1
				bike3_cp_x_bike1 = gosub_cp_x_bike1
				bike3_cp_y_bike1 = gosub_cp_y_bike1
				bike3_cp_z_bike1 = gosub_cp_z_bike1
			
				IF bike3_cpcounter_bike1 = 17
					bike3_locate_size_bike1 = 6.0
				ENDIF

				IF bike3_cpcounter_bike1 = total_checkpoints_bike1
					PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!"
					GOTO mission_bike1_failed		
				ENDIF

				IF IS_CHAR_IN_CAR driver_bike3_bike1 race_bike3_bike1 
					  					
					IF bike3_locate_size_bike1 = 7.0
						CAR_GOTO_COORDINATES race_bike3_bike1 bike3_cp_x_bike1 bike3_cp_y_bike1 bike3_cp_z_bike1
					ELSE
						CAR_GOTO_COORDINATES_ACCURATE race_bike3_bike1 bike3_cp_x_bike1 bike3_cp_y_bike1 bike3_cp_z_bike1
					ENDIF
					
				ENDIF

			ENDIF
						   
   		ENDIF

	ELSE
		PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
		GOTO mission_bike1_failed
	ENDIF
	
// checks player1s position in the race
	  
	IF position_bike1 = 0
		PRINT_NOW ( FIRST ) 100 1 //"1st"
	ENDIF

	IF position_bike1 = 1
		PRINT_NOW ( SECOND ) 100 1 //"2nd"
	ENDIF

	IF position_bike1 = 2
		PRINT_NOW ( THIRD ) 100 1 //"3rd"
	ENDIF

	IF position_bike1 = 3
		PRINT_NOW ( FOURTH ) 100 1 //"4th"
	ENDIF

	IF player1_cpcounter_bike1 = 17
		DRAW_CORONA player1_cp_x_bike1 player1_cp_y_bike1 player1_cp_z_bike1 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
	ELSE
		DRAW_CORONA player1_cp_x_bike1 player1_cp_y_bike1 player1_cp_z_bike1 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

ENDWHILE

CLEAR_ONSCREEN_TIMER race_timer_bike1

REMOVE_STUCK_CAR_CHECK race_bike1 
REMOVE_STUCK_CAR_CHECK race_bike2_bike1
REMOVE_STUCK_CAR_CHECK race_bike3_bike1

GOTO mission_bike1_passed
 

// ****************************************** Mission Failed *******************************

mission_bike1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_bike1_passed:

flag_bikers_mission1_passed = 1
REGISTER_MISSION_PASSED ( BIKE_1 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1

IF biker_bar_sound1_added = 1
	REMOVE_SOUND bike_bar_loop1
	biker_bar_sound1_added = 0
ENDIF

IF biker_bar_sound2_added = 1
	REMOVE_SOUND bike_bar_loop2
	biker_bar_sound2_added = 0
ENDIF

IF biker_bar_sound3_added = 1
	REMOVE_SOUND bike_bar_loop3
	biker_bar_sound3_added = 0
ENDIF

IF biker_bar_sound2_added = 0
	ADD_CONTINUOUS_SOUND -596.018 640.916 12.0 SOUND_NEW_BUILDING_BAR_2 bike_bar_loop2	//Biker bar
	biker_bar_sound2_added = 1
ENDIF

race_timer_seconds_bike1 = race_timer_bike1 / 1000 //seconds

REGISTER_FASTEST_TIME 0 race_timer_seconds_bike1

/// Works out race time in mins and seconds

race_timer_mins_bike1 = race_timer_seconds_bike1 / 60 // mins
race_timer_seconds2_bike1 = race_timer_mins_bike1 * 60 
race_timer_seconds_bike1 = race_timer_seconds_bike1 - race_timer_seconds2_bike1 

PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 // "Mission Passed!"
ADD_SCORE player1 1000

IF race_timer_seconds_bike1 >= 10
	PRINT_WITH_2_NUMBERS_NOW ( RACETM ) race_timer_mins_bike1 race_timer_seconds_bike1 5000 1 
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( RACETM2 ) race_timer_mins_bike1 race_timer_seconds_bike1 5000 1
ENDIF

//IF IS_GERMAN_GAME // FIXMIAMI: remove german censorshit
//	START_NEW_SCRIPT bikers_mission3_loop // FIXMIAMI: remove german censorshit 
//ELSE // FIXMIAMI: remove german censorshit 
	START_NEW_SCRIPT bikers_mission2_loop
//ENDIF/ / FIXMIAMI: remove german censorshit 

RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_bike1:

flag_player_on_mission = 0
SET_CAR_DENSITY_MULTIPLIER 1.0 // Sets this back to normal
SWITCH_ROADS_ON road1_x_bike1 road1_y_bike1 road1_z_bike1 road2_x_bike1 road2_y_bike1 road2_z_bike1
REMOVE_BLIP blip_chase_bike1
REMOVE_BLIP second_blip_bike1_bike1
REMOVE_BLIP bike1_blip
REMOVE_BLIP bike2_blip
REMOVE_BLIP bike3_blip
MARK_MODEL_AS_NO_LONGER_NEEDED BKa
MARK_MODEL_AS_NO_LONGER_NEEDED BKb
MARK_MODEL_AS_NO_LONGER_NEEDED ANGEL
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
CLEAR_ONSCREEN_TIMER race_timer_bike1
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

// Next check point

get_next_checkpoint_bike1:
	
	IF gosub_cpcounter_bike1 = 0
		gosub_cp_x_bike1 = cp1_x_bike1
		gosub_cp_y_bike1 = cp1_y_bike1
		gosub_cp_z_bike1 = cp1_z_bike1
		gosub_cp_2nd_x_bike1 = cp2_x_bike1
		gosub_cp_2nd_y_bike1 = cp2_y_bike1
		gosub_cp_2nd_z_bike1 = cp2_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 1
		gosub_cp_x_bike1 = cp2_x_bike1
		gosub_cp_y_bike1 = cp2_y_bike1
		gosub_cp_z_bike1 = cp2_z_bike1
		gosub_cp_2nd_x_bike1 = cp3_x_bike1
		gosub_cp_2nd_y_bike1 = cp3_y_bike1
		gosub_cp_2nd_z_bike1 = cp3_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 2
		gosub_cp_x_bike1 = cp3_x_bike1
		gosub_cp_y_bike1 = cp3_y_bike1
		gosub_cp_z_bike1 = cp3_z_bike1
		gosub_cp_2nd_x_bike1 = cp4_x_bike1
		gosub_cp_2nd_y_bike1 = cp4_y_bike1
		gosub_cp_2nd_z_bike1 = cp4_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 3
		gosub_cp_x_bike1 = cp4_x_bike1
		gosub_cp_y_bike1 = cp4_y_bike1
		gosub_cp_z_bike1 = cp4_z_bike1
		gosub_cp_2nd_x_bike1 = cp5_x_bike1
		gosub_cp_2nd_y_bike1 = cp5_y_bike1
		gosub_cp_2nd_z_bike1 = cp5_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 4
		gosub_cp_x_bike1 = cp5_x_bike1
		gosub_cp_y_bike1 = cp5_y_bike1
		gosub_cp_z_bike1 = cp5_z_bike1
		gosub_cp_2nd_x_bike1 = cp6_x_bike1
		gosub_cp_2nd_y_bike1 = cp6_y_bike1
		gosub_cp_2nd_z_bike1 = cp6_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 5
		gosub_cp_x_bike1 = cp6_x_bike1
		gosub_cp_y_bike1 = cp6_y_bike1
		gosub_cp_z_bike1 = cp6_z_bike1
		gosub_cp_2nd_x_bike1 = cp7_x_bike1
		gosub_cp_2nd_y_bike1 = cp7_y_bike1
		gosub_cp_2nd_z_bike1 = cp7_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 6
		gosub_cp_x_bike1 = cp7_x_bike1
		gosub_cp_y_bike1 = cp7_y_bike1
		gosub_cp_z_bike1 = cp7_z_bike1
		gosub_cp_2nd_x_bike1 = cp8_x_bike1
		gosub_cp_2nd_y_bike1 = cp8_y_bike1
		gosub_cp_2nd_z_bike1 = cp8_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 7
		gosub_cp_x_bike1 = cp8_x_bike1
		gosub_cp_y_bike1 = cp8_y_bike1
		gosub_cp_z_bike1 = cp8_z_bike1
		gosub_cp_2nd_x_bike1 = cp9_x_bike1
		gosub_cp_2nd_y_bike1 = cp9_y_bike1
		gosub_cp_2nd_z_bike1 = cp9_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 8
		gosub_cp_x_bike1 = cp9_x_bike1
		gosub_cp_y_bike1 = cp9_y_bike1
		gosub_cp_z_bike1 = cp9_z_bike1
		gosub_cp_2nd_x_bike1 = cp10_x_bike1
		gosub_cp_2nd_y_bike1 = cp10_y_bike1
		gosub_cp_2nd_z_bike1 = cp10_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 9
		gosub_cp_x_bike1 = cp10_x_bike1
		gosub_cp_y_bike1 = cp10_y_bike1
		gosub_cp_z_bike1 = cp10_z_bike1
		gosub_cp_2nd_x_bike1 = cp11_x_bike1
		gosub_cp_2nd_y_bike1 = cp11_y_bike1
		gosub_cp_2nd_z_bike1 = cp11_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 10
		gosub_cp_x_bike1 = cp11_x_bike1
		gosub_cp_y_bike1 = cp11_y_bike1
		gosub_cp_z_bike1 = cp11_z_bike1
		gosub_cp_2nd_x_bike1 = cp12_x_bike1
		gosub_cp_2nd_y_bike1 = cp12_y_bike1
		gosub_cp_2nd_z_bike1 = cp12_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 11
		gosub_cp_x_bike1 = cp12_x_bike1
		gosub_cp_y_bike1 = cp12_y_bike1
		gosub_cp_z_bike1 = cp12_z_bike1
		gosub_cp_2nd_x_bike1 = cp13_x_bike1
		gosub_cp_2nd_y_bike1 = cp13_y_bike1
		gosub_cp_2nd_z_bike1 = cp13_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 12
		gosub_cp_x_bike1 = cp13_x_bike1
		gosub_cp_y_bike1 = cp13_y_bike1
		gosub_cp_z_bike1 = cp13_z_bike1
		gosub_cp_2nd_x_bike1 = cp14_x_bike1
		gosub_cp_2nd_y_bike1 = cp14_y_bike1
		gosub_cp_2nd_z_bike1 = cp14_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 13
		gosub_cp_x_bike1 = cp14_x_bike1
		gosub_cp_y_bike1 = cp14_y_bike1
		gosub_cp_z_bike1 = cp14_z_bike1
		gosub_cp_2nd_x_bike1 = cp15_x_bike1
		gosub_cp_2nd_y_bike1 = cp15_y_bike1
		gosub_cp_2nd_z_bike1 = cp15_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 14
		gosub_cp_x_bike1 = cp15_x_bike1
		gosub_cp_y_bike1 = cp15_y_bike1
		gosub_cp_z_bike1 = cp15_z_bike1
		gosub_cp_2nd_x_bike1 = cp16_x_bike1
		gosub_cp_2nd_y_bike1 = cp16_y_bike1
		gosub_cp_2nd_z_bike1 = cp16_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 15
		gosub_cp_x_bike1 = cp16_x_bike1
		gosub_cp_y_bike1 = cp16_y_bike1
		gosub_cp_z_bike1 = cp16_z_bike1
		gosub_cp_2nd_x_bike1 = cp17_x_bike1
		gosub_cp_2nd_y_bike1 = cp17_y_bike1
		gosub_cp_2nd_z_bike1 = cp17_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 16
		gosub_cp_x_bike1 = cp17_x_bike1
		gosub_cp_y_bike1 = cp17_y_bike1
		gosub_cp_z_bike1 = cp17_z_bike1
		gosub_cp_2nd_x_bike1 = cp18_x_bike1
		gosub_cp_2nd_y_bike1 = cp18_y_bike1
		gosub_cp_2nd_z_bike1 = cp18_z_bike1
	ENDIF

	IF gosub_cpcounter_bike1 = 17
		gosub_cp_x_bike1 = cp18_x_bike1
		gosub_cp_y_bike1 = cp18_y_bike1
		gosub_cp_z_bike1 = cp18_z_bike1
		gosub_cp_2nd_x_bike1 = cp18_x_bike1
		gosub_cp_2nd_y_bike1 = cp18_y_bike1
		gosub_cp_2nd_z_bike1 = cp18_z_bike1
	ENDIF

RETURN

// Bike stuck checks

bike_stuck_checks_bike1:

GET_CAR_HEALTH gosub_race_bike_bike1 bike_health_bike1

IF bike_health_bike1 < 500
	SET_CAR_HEALTH gosub_race_bike_bike1 1000
ENDIF

IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1 

	IF NOT IS_CHAR_DEAD gosub_rider_bike1
	 
		IF IS_CAR_STUCK gosub_race_bike_bike1 

			IF NOT IS_CAR_ON_SCREEN gosub_race_bike_bike1
			AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gosub_rider_bike1 30.0 30.0 30.0 FALSE

				GET_CAR_COORDINATES gosub_race_bike_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1
				GET_CLOSEST_CAR_NODE bike_x_bike1 bike_y_bike1 bike_z_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

					IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
						SET_CAR_COORDINATES gosub_race_bike_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1
						TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1

						IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

							IF bike1_locate_size_bike1 = 7.0
							OR bike2_locate_size_bike1 = 7.0
							OR bike3_locate_size_bike1 = 7.0
								SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
								SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
								CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
							ELSE
								SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
								SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
								CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
							ENDIF

						ENDIF
						
						timer_reset_flag = 0
					ENDIF

				ELSE
					GET_NTH_CLOSEST_CAR_NODE bike_x_bike1 bike_y_bike1 bike_z_bike1 2 bike_x_bike1 bike_y_bike1 bike_z_bike1

					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

						IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
							SET_CAR_COORDINATES gosub_race_bike_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1
							TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1
														
							IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

								IF bike1_locate_size_bike1 = 7.0
								OR bike2_locate_size_bike1 = 7.0
								OR bike3_locate_size_bike1 = 7.0
									SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
									SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
									CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
								ELSE
									SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
									SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
									CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
								ENDIF

							ENDIF

							timer_reset_flag = 0
						ENDIF

					ENDIF

				ENDIF
								
			ENDIF
						
		ENDIF
		 		 		
	ENDIF

ENDIF

temp_int_bike1 = player1_cpcounter_bike1 - 2

IF gosub_cpcounter_bike1 < temp_int_bike1

	IF NOT IS_CAR_DEAD gosub_race_bike_bike1
	
		IF NOT IS_CHAR_DEAD gosub_rider_bike1
		
			IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1  
	
				IF NOT IS_CAR_ON_SCREEN gosub_race_bike_bike1

					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1 4.0 4.0 3.0

						IF NOT IS_POINT_ON_SCREEN gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1 4.0
							SET_CAR_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
							TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 player1_cp_x_bike1 player1_cp_y_bike1
							SET_CAR_FORWARD_SPEED gosub_race_bike_bike1 30.0
						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

// Rider fallen off bike checks

rider_fallen_off_bike_bike1:

IF NOT IS_CHAR_DEAD gosub_rider_bike1

	GET_CHAR_HEALTH gosub_rider_bike1 gosub_rider_health_bike1
		
	IF NOT IS_CHAR_IN_ANY_CAR gosub_rider_bike1

	     flag_gosub_rider_off_bike1 = 1
			   	
		IF NOT IS_CHAR_ON_SCREEN gosub_rider_bike1

			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gosub_rider_bike1 20.0 20.0 10.0 FALSE  
				  			
				GET_CHAR_COORDINATES gosub_rider_bike1 gosub_rider_x_bike1 gosub_rider_y_bike1 gosub_rider_z_bike1
				GET_CLOSEST_CAR_NODE gosub_rider_x_bike1 gosub_rider_y_bike1 gosub_rider_z_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

					IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
						REMOVE_STUCK_CAR_CHECK gosub_race_bike_bike1 
						MARK_CAR_AS_NO_LONGER_NEEDED gosub_race_bike_bike1 
						CREATE_CAR ANGEL bike_x_bike1 bike_y_bike1 bike_z_bike1 gosub_race_bike_bike1
						ADD_STUCK_CAR_CHECK gosub_race_bike_bike1 1.0 2000 
						SET_CHAR_OBJ_NO_OBJ gosub_rider_bike1
						WARP_CHAR_INTO_CAR gosub_rider_bike1 gosub_race_bike_bike1
						TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1

						IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

							IF bike1_locate_size_bike1 = 7.0
							OR bike2_locate_size_bike1 = 7.0
							OR bike3_locate_size_bike1 = 7.0
								SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
								SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
								CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
							ELSE
								SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
								SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
								CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
							ENDIF

						ENDIF

					ELSE
										
						GET_NTH_CLOSEST_CAR_NODE bike_x_bike1 bike_y_bike1 bike_z_bike1 2 bike_x_bike1 bike_y_bike1 bike_z_bike1

						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

							IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
								REMOVE_STUCK_CAR_CHECK gosub_race_bike_bike1 
								MARK_CAR_AS_NO_LONGER_NEEDED gosub_race_bike_bike1 
								CREATE_CAR ANGEL bike_x_bike1 bike_y_bike1 bike_z_bike1 gosub_race_bike_bike1
								ADD_STUCK_CAR_CHECK gosub_race_bike_bike1 1.0 2000 
								SET_CHAR_OBJ_NO_OBJ gosub_rider_bike1
								WARP_CHAR_INTO_CAR gosub_rider_bike1 gosub_race_bike_bike1
								TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1

								IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

									IF bike1_locate_size_bike1 = 7.0
									OR bike2_locate_size_bike1 = 7.0
									OR bike3_locate_size_bike1 = 7.0
										SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
										SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
										CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
									ELSE
										SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
										SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
										CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
									ENDIF

								ENDIF
							
							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF
										
		ELSE

			IF NOT IS_CAR_DEAD gosub_race_bike_bike1
				
				SET_CHAR_RUNNING gosub_rider_bike1 TRUE  
				SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_rider_bike1 gosub_race_bike_bike1
				
				IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

					IF bike1_locate_size_bike1 = 7.0
					OR bike2_locate_size_bike1 = 7.0
					OR bike3_locate_size_bike1 = 7.0
						SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
						SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
						CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
					ELSE
						SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
						SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
						CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
					ENDIF

				ENDIF	
					 
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_rider_bike1 player1
				GIVE_WEAPON_TO_CHAR gosub_rider_bike1 WEAPONTYPE_UZI 300000 // set to infinate ammo 
			ENDIF

		ENDIF
	
	ELSE

		IF flag_gosub_rider_off_bike1 = 1

			IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

				IF bike1_locate_size_bike1 = 7.0
				OR bike2_locate_size_bike1 = 7.0
				OR bike3_locate_size_bike1 = 7.0
					SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
					SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
					CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
					flag_gosub_rider_off_bike1 = 0
				ELSE
					SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
					SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
					CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
					flag_gosub_rider_off_bike1 = 0
				ENDIF

			ENDIF

		ENDIF
		   		
	ENDIF
	 	 
ENDIF
		   
RETURN


// Player position checks

player1_position_bike1:

IF player1_cpcounter_bike1 = gosub_cpcounter_bike1	
	GET_CHAR_COORDINATES gosub_rider_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1
	difference_x_float_d_bike1 = bike_x_bike1 - player1_cp_x_bike1
	difference_y_float_d_bike1 = bike_y_bike1 - player1_cp_y_bike1
	difference_x_float_d_bike1 = difference_x_float_d_bike1 * difference_x_float_d_bike1
	difference_y_float_d_bike1 = difference_y_float_d_bike1 * difference_y_float_d_bike1
	sum_difference_d_xy_bike1 = difference_x_float_d_bike1 + difference_y_float_d_bike1
	SQRT sum_difference_d_xy_bike1 bike_distance_from_cp_bike1

	GET_PLAYER_COORDINATES player1 bike_x_bike1 bike_y_bike1 bike_z_bike1
	difference_x_float_d_bike1 = bike_x_bike1 - player1_cp_x_bike1
	difference_y_float_d_bike1 = bike_y_bike1 - player1_cp_y_bike1
	difference_x_float_d_bike1 = difference_x_float_d_bike1 * difference_x_float_d_bike1
	difference_y_float_d_bike1 = difference_y_float_d_bike1 * difference_y_float_d_bike1
	sum_difference_d_xy_bike1 = difference_x_float_d_bike1 + difference_y_float_d_bike1
	SQRT sum_difference_d_xy_bike1 player1_distance_from_cp_bike1

	IF player1_distance_from_cp_bike1 > bike_distance_from_cp_bike1
		++ position_bike1
	ENDIF
ELSE
	IF player1_cpcounter_bike1 < gosub_cpcounter_bike1
		++ position_bike1
	ENDIF
ENDIF

RETURN

// water checks

water_checks_bike1:

IF NOT IS_CHAR_DEAD gosub_rider_bike1

	IF IS_CHAR_IN_WATER gosub_rider_bike1

		IF NOT IS_CHAR_ON_SCREEN gosub_rider_bike1

			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 gosub_rider_bike1 10.0 10.0 10.0 FALSE

				GET_CHAR_COORDINATES gosub_rider_bike1 gosub_rider_x_bike1 gosub_rider_y_bike1 gosub_rider_z_bike1
				GET_CLOSEST_CAR_NODE gosub_rider_x_bike1 gosub_rider_y_bike1 gosub_rider_z_bike1 bike_x_bike1 bike_y_bike1 bike_z_bike1

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

					IF NOT IS_CHAR_DEAD gosub_rider_bike1 

						IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
							REMOVE_STUCK_CAR_CHECK gosub_race_bike_bike1 
							MARK_CAR_AS_NO_LONGER_NEEDED gosub_race_bike_bike1 
							CREATE_CAR ANGEL bike_x_bike1 bike_y_bike1 bike_z_bike1 gosub_race_bike_bike1
							ADD_STUCK_CAR_CHECK gosub_race_bike_bike1 1.0 2000 
							SET_CHAR_OBJ_NO_OBJ gosub_rider_bike1
							WARP_CHAR_INTO_CAR gosub_rider_bike1 gosub_race_bike_bike1
							TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1
						
							IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

								IF bike1_locate_size_bike1 = 7.0
								OR bike2_locate_size_bike1 = 7.0
								OR bike3_locate_size_bike1 = 7.0
									SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
									SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
									CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
								ELSE
									SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
									SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
									CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
								ENDIF

							ENDIF

						ENDIF

					ELSE
						PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
						GOTO mission_bike1_failed
					ENDIF

				ELSE

					GET_NTH_CLOSEST_CAR_NODE bike_x_bike1 bike_y_bike1 bike_z_bike1 2 bike_x_bike1 bike_y_bike1 bike_z_bike1

					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0 4.0 3.0

				  		IF NOT IS_CHAR_DEAD gosub_rider_bike1 

							IF NOT IS_POINT_ON_SCREEN bike_x_bike1 bike_y_bike1 bike_z_bike1 4.0
								REMOVE_STUCK_CAR_CHECK gosub_race_bike_bike1 
								MARK_CAR_AS_NO_LONGER_NEEDED gosub_race_bike_bike1 
								CREATE_CAR ANGEL bike_x_bike1 bike_y_bike1 bike_z_bike1 gosub_race_bike_bike1
								ADD_STUCK_CAR_CHECK gosub_race_bike_bike1 1.0 2000 
								SET_CHAR_OBJ_NO_OBJ gosub_rider_bike1
								WARP_CHAR_INTO_CAR gosub_rider_bike1 gosub_race_bike_bike1
								TURN_CAR_TO_FACE_COORD gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1

								IF IS_CHAR_IN_CAR gosub_rider_bike1 gosub_race_bike_bike1

									IF bike1_locate_size_bike1 = 7.0
									OR bike2_locate_size_bike1 = 7.0
									OR bike3_locate_size_bike1 = 7.0
										SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
										SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
										CAR_GOTO_COORDINATES gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
									ELSE
										SET_CAR_DRIVING_STYLE gosub_race_bike_bike1 2
										SET_CAR_CRUISE_SPEED gosub_race_bike_bike1 63.0
										CAR_GOTO_COORDINATES_ACCURATE gosub_race_bike_bike1 gosub_cp_x_bike1 gosub_cp_y_bike1 gosub_cp_z_bike1
									ENDIF

								ENDIF

							ENDIF

						ELSE
							PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
							GOTO mission_bike1_failed
						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ENDIF
		
ELSE
	PRINT_NOW ( BM1_3 ) 5000 1 //"The racers have been attacked!"
	GOTO mission_bike1_failed
ENDIF

RETURN

}


