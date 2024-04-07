MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************* Haitian Mission 1 ************************************* 
// *********************************** Ju Ju Scramble **************************************
// ************************************ Police Sting ***************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME hait1

// Mission start stuff

GOSUB mission_start_haitian1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_haitian1_failed
ENDIF

GOSUB mission_cleanup_haitian1

MISSION_END
 
// Variables for mission

// briefcase1

// case1

VAR_INT case1_hait1

VAR_INT radar_blip_case1_hait1

VAR_INT case1_created_hait1

VAR_INT case1_collected_hait1

VAR_FLOAT case1_x_hait1

VAR_FLOAT case1_y_hait1

VAR_FLOAT case1_z_hait1

VAR_INT flag_cutscene_case1_done_hait1

// cop1 low building right hand side

VAR_INT cop1_case1_hait1

VAR_FLOAT cop1_x_case1_hait1

VAR_FLOAT cop1_y_case1_hait1

VAR_FLOAT cop1_z_case1_hait1

VAR_FLOAT cop1_case1_heading_hait1

// cop2 low building left hand side

VAR_INT cop2_case1_hait1

VAR_FLOAT cop2_x_case1_hait1

VAR_FLOAT cop2_y_case1_hait1

VAR_FLOAT cop2_z_case1_hait1

VAR_FLOAT cop2_case1_heading_hait1

// cop3 high building right hand side

VAR_INT cop3_case1_hait1

VAR_FLOAT cop3_x_case1_hait1

VAR_FLOAT cop3_y_case1_hait1

VAR_FLOAT cop3_z_case1_hait1

VAR_FLOAT cop3_case1_heading_hait1

// cop4 high building left hand side

VAR_INT cop4_case1_hait1

VAR_FLOAT cop4_x_case1_hait1

VAR_FLOAT cop4_y_case1_hait1

VAR_FLOAT cop4_z_case1_hait1

VAR_FLOAT cop4_case1_heading_hait1

// briefcase2

VAR_INT case2_hait1

VAR_INT radar_blip_case2_hait1

VAR_INT case2_created_hait1

VAR_INT case2_collected_hait1

VAR_INT timer_case2_hait1

VAR_FLOAT case2_x_hait1

VAR_FLOAT case2_y_hait1

VAR_FLOAT case2_z_hait1

VAR_INT case2_collected_again_hait1

VAR_INT case2_created_again_hait1  // Used if teh cop carrying it is killed

VAR_INT flag_case2_destroyed_hait1  // If the cop has it and is killed in a car

VAR_INT radar_blip2_case2_hait1

// cop1 case2  // sniper on roof above the case

VAR_INT cop1_case2_hait1

VAR_INT flag_cop1_case2_dead_hait1

VAR_FLOAT cop1_x_case2_hait1

VAR_FLOAT cop1_y_case2_hait1

VAR_FLOAT cop1_z_case2_hait1

VAR_FLOAT cop1_case2_heading_hait1

VAR_INT cop1_case2_health_hait1

// cop 2 case2  // stands on ground left hand side

VAR_INT cop2_case2_hait1

VAR_INT flag_cop2_case2_dead_hait1

VAR_FLOAT cop2_x_case2_hait1

VAR_FLOAT cop2_y_case2_hait1

VAR_FLOAT cop2_z_case2_hait1

VAR_FLOAT cop2_case2_heading_hait1

VAR_INT cop2_case2_health_hait1

VAR_INT blip_chase_cop2_case2_hait1

VAR_INT flag_cop2_case2_got_stash_hait1

VAR_INT flag_cop2_case2_in_car_hait1

// cop3 case2  // stands on ground right hand side

VAR_INT cop3_case2_hait1

VAR_INT flag_cop3_case2_dead_hait1

VAR_FLOAT cop3_x_case2_hait1

VAR_FLOAT cop3_y_case2_hait1

VAR_FLOAT cop3_z_case2_hait1

VAR_FLOAT cop3_case2_heading_hait1

VAR_INT cop3_case2_health_hait1

VAR_INT flag_cop3_case2_in_car_hait1

VAR_INT blip_chase_cop3_case2_hait1

VAR_INT flag_cop3_case2_got_stash_hait1

// briefcase3

// case3

VAR_INT case3_hait1

VAR_INT radar_blip_case3_hait1

VAR_INT case3_created_hait1

VAR_INT case3_collected_hait1

VAR_INT timer_case3_hait1

VAR_FLOAT case3_x_hait1

VAR_FLOAT case3_y_hait1

VAR_FLOAT case3_z_hait1

VAR_INT flag_case3_destroyed_hait1

VAR_INT case3_created_again_hait1 
					
VAR_INT radar_blip2_case3_hait1

VAR_INT case3_collected_again_hait1

// cop1 case3 on roof

VAR_INT cop1_case3_hait1

VAR_INT flag_cop1_case3_dead_hait1

VAR_FLOAT cop1_x_case3_hait1

VAR_FLOAT cop1_y_case3_hait1

VAR_FLOAT cop1_z_case3_hait1

VAR_FLOAT cop1_case3_heading_hait1

VAR_INT cop1_case3_health_hait1

VAR_INT flag_cop1_case3_got_stash_hait1

VAR_INT flag_cop1_case3_in_car_hait1

VAR_INT blip_chase_cop1_case3_hait1

// cop2 case3 stands in alleyway behind player1

VAR_INT cop2_case3_hait1

VAR_INT flag_cop2_case3_in_car_hait1

VAR_INT flag_cop2_case3_dead_hait1

VAR_FLOAT cop2_x_case3_hait1

VAR_FLOAT cop2_y_case3_hait1

VAR_FLOAT cop2_z_case3_hait1

VAR_FLOAT cop2_case3_heading_hait1

VAR_FLOAT cop2_destin_x_case3_hait1  // area that the cop runs to 

VAR_FLOAT cop2_destin_y_case3_hait1 // area that the cop runs to

VAR_FLOAT cop2_destin_z_case3_hait1 // area that the cop runs to

VAR_INT cop2_case3_health_hait1 

VAR_INT flag_go_for_case3_hait1

VAR_INT flag_cops_got_case3_hait1

VAR_INT flag_guards_case3_act_hait1

VAR_INT flag_cop2_case3_got_stash_hait1

VAR_INT blip_chase_cop2_case3_hait1

// General stuff

VAR_INT counter_cases_collected_hait1

VAR_INT radar_blip_coord1_hait1  // destination that the player1 has to go to with the cases

VAR_INT all_cases_recoverd_hait1 // tells me all 4 cases have been collected and deliverd

VAR_FLOAT home_x_hait1  // where the player1 has to take the cases to

VAR_FLOAT home_y_hait1 // where the player1 has to take the cases to

VAR_FLOAT home_z_hait1 // where the player1 has to take the cases to

VAR_INT flag_home_blip_on_hait1

VAR_INT flag_go_for_case2_hait1 // Used to tell the cops to go for the case

VAR_INT flag_cops_got_case2_hait1

VAR_INT police_created_case3_hait1

VAR_INT flag_guards_case2_act_hait1  // Tells the guards to act as they have been hurt

VAR_INT flag_car1_do_stuff_hait1

VAR_INT flag_cops_got_away_hait1

VAR_INT car1_hait1

VAR_INT car2_hait1

// Player coords

VAR_FLOAT player_x_hait1

VAR_FLOAT player_y_hait1

VAR_FLOAT player_z_hait1

// New cop5

VAR_INT cop5_case1_hait1

VAR_INT flag_cop5_case1_dead_hait1

VAR_INT player_car_hait1

// car stuff

VAR_INT car3_hait1 // Used for checking if the cops have got teh drugs and got stuck

VAR_INT car4_hait1 // Used for checking if the cops have got teh drugs and got stuck

// case 2 stuff

VAR_FLOAT case2_x2_hait1

VAR_FLOAT case2_y2_hait1

VAR_FLOAT case2_z2_hait1							

VAR_INT flag_cop2_case2_location_hait1

VAR_INT flag_cop3_case2_location_hait1

// case 3

VAR_FLOAT case3_x2_hait1

VAR_FLOAT case3_y2_hait1

VAR_FLOAT case3_z2_hait1
							
VAR_INT flag_cop1_case3_location_hait1

VAR_INT flag_cop2_case3_location_hait1

// SET_CHAR_FOLLOW_PATH stuff only every 1 sec

VAR_INT cop2_case2_follow_1sttime_hait1

VAR_INT cop3_case2_follow_1sttime_hait1

VAR_INT cop2_case3_follow_1sttime_hait1

VAR_INT cop3_case3_follow_1sttime_hait1

VAR_INT timer_cops_case2_act_hait1

VAR_INT timer_cops_case3_act_hait1
												
// ****************************************Mission Start************************************

mission_start_haitian1:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

// Briefcase1

// case1

case1_created_hait1 = 0

case1_collected_hait1 = 0

case1_x_hait1 = -1162.82

case1_y_hait1 = -19.06

case1_z_hait1 = 16.14

flag_cutscene_case1_done_hait1 = 0

// cop1 case1

cop1_x_case1_hait1 = -1154.48

cop1_y_case1_hait1 = -30.59

cop1_z_case1_hait1 = 19.08

cop1_case1_heading_hait1 = 12.22

// cop2 case1

cop2_x_case1_hait1 = -1160.49

cop2_y_case1_hait1 = -30.37

cop2_z_case1_hait1 = 19.08

cop2_case1_heading_hait1 = 12.22

// cop3 case1

cop3_x_case1_hait1 = -1142.84

cop3_y_case1_hait1 = -6.34

cop3_z_case1_hait1 = 22.97

cop3_case1_heading_hait1 = 84.66

// cop4 case1

cop4_x_case1_hait1 = -1143.56

cop4_y_case1_hait1 = -16.69

cop4_z_case1_hait1 = 22.90

cop4_case1_heading_hait1 = 84.66

// Briefcase 2

// case2

case2_created_hait1 = 0

case2_collected_hait1 = 0

case2_x_hait1 = -995.87

case2_y_hait1 = -32.49

case2_z_hait1 = 10.89

timer_case2_hait1 = 61000

flag_car1_do_stuff_hait1 = 0

flag_cops_got_away_hait1 = 0

case2_collected_again_hait1 = 0

case2_created_again_hait1 = 0

flag_case2_destroyed_hait1 = 0

// cop1 case 2

flag_cop1_case2_dead_hait1 = 0

cop1_x_case2_hait1 = -966.67

cop1_y_case2_hait1 = -36.70

cop1_z_case2_hait1 = -100.0 //12.73	 // causing the gay to take damage

cop1_case2_heading_hait1 = 90.0

cop1_case2_health_hait1 = 100

flag_cop1_case3_got_stash_hait1 = 0

// cop2 case2

flag_cop2_case2_dead_hait1 = 0

cop2_x_case2_hait1 = -969.82

cop2_y_case2_hait1 = -46.22

cop2_z_case2_hait1 = 9.91

cop2_case2_heading_hait1 = 0.0

cop2_case2_health_hait1 = 100

flag_cop2_case2_got_stash_hait1 = 0

flag_cop2_case2_in_car_hait1 = 0

// cop3 case2

flag_cop3_case2_dead_hait1 = 0

cop3_x_case2_hait1 = -968.10

cop3_y_case2_hait1 = -28.41

cop3_z_case2_hait1 = 9.94

cop3_case2_heading_hait1 = 0.0

cop3_case2_health_hait1 = 100

flag_cop3_case2_in_car_hait1 = 0

flag_cop3_case2_got_stash_hait1 = 0

// Briefcase 3

// case3

case3_created_hait1 = 0

case3_collected_hait1 = 0

case3_x_hait1 = -914.55

case3_y_hait1 = 344.73

case3_z_hait1 = -100.0

timer_case3_hait1 = 61000  // ONE MIN

flag_cop2_case3_in_car_hait1 = 0

flag_case3_destroyed_hait1 = 0

case3_created_again_hait1 = 0

case3_created_again_hait1 = 0

case3_collected_again_hait1 = 0
 
// cop1 case3

flag_cop1_case3_dead_hait1 = 0

cop1_x_case3_hait1 = -904.85 

cop1_y_case3_hait1 = 299.418 

cop1_z_case3_hait1 = 10.26 

cop1_case3_heading_hait1 = 0.0

cop1_case3_health_hait1 = 100

flag_cop1_case3_in_car_hait1 = 0

// cop2 case3

flag_cop2_case3_dead_hait1 = 0

cop2_x_case3_hait1 = -903.07    

cop2_y_case3_hait1 = 299.196 

cop2_z_case3_hait1 = 10.26 

cop2_case3_heading_hait1 = 0.0

cop2_destin_x_case3_hait1 = -914.55 

cop2_destin_y_case3_hait1 = 344.73 

cop2_destin_z_case3_hait1 = 10.26

cop2_case3_health_hait1 = 100

// Gerneral stuff

counter_cases_collected_hait1 = 0

all_cases_recoverd_hait1 = 0

home_x_hait1 = -957.891

home_y_hait1 = 139.084

home_z_hait1 = 8.26

flag_home_blip_on_hait1 = 0

flag_go_for_case2_hait1 = 0

flag_cops_got_case2_hait1 = 0

police_created_case3_hait1 = 0

flag_guards_case2_act_hait1 = 0 // TELLS the guards to act as they have been hurt

flag_go_for_case3_hait1 = 0

flag_cops_got_case3_hait1 = 0

flag_guards_case3_act_hait1 = 0 // TELLS the guards to act as they have been hurt

// Player stuff

player_x_hait1 = 0.0

player_y_hait1 = 0.0

player_z_hait1 = 0.0

// Cop5 for arresting player case1

flag_cop5_case1_dead_hait1 = 0

// 2nd set of case2 stuff

case2_x2_hait1 = -990.11

case2_y2_hait1 = -34.50

case2_z2_hait1 = 9.72
							
flag_cop2_case2_location_hait1 = 0

flag_cop3_case2_location_hait1 = 0


// 2nd set of case3 stuff

case3_x2_hait1 = -913.827

case3_y2_hait1 = 325.343

case3_z2_hait1 = 10.249
							
flag_cop1_case3_location_hait1 = 0

flag_cop2_case3_location_hait1 = 0

// SET_CHAR_FOLLOW_PATH stuff only every 1 sec

cop2_case2_follow_1sttime_hait1 = 0

cop3_case2_follow_1sttime_hait1 = 0

cop2_case3_follow_1sttime_hait1 = 0

cop3_case3_follow_1sttime_hait1 = 0

timer_cops_case2_act_hait1 = 0

timer_cops_case3_act_hait1 = 0

WAIT 0

LOAD_MISSION_TEXT HAIT1

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -957.904 122.843 8.278 356.948

{

// ****************************************START OF CUTSCENE********************************
 
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 apoulet

LOAD_SPECIAL_MODEL CUTOBJ01 htable
LOAD_SPECIAL_MODEL CUTOBJ02 kettle

LOAD_SCENE -962.697 149.793 10.21

SET_AREA_VISIBLE VIS_POLICE_STATION // this is correct

SET_EXTRA_COLOURS 13 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02

	WAIT 0

ENDWHILE

LOAD_CUTSCENE hat_1

SET_CUTSCENE_OFFSET -962.799 148.391 8.355

SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_apoulet
SET_CUTSCENE_ANIM cs_apoulet apoulet

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_htable 
SET_CUTSCENE_ANIM cs_htable htable

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_kettle 
SET_CUTSCENE_ANIM cs_kettle kettle

CLEAR_AREA -962.53 141.69 8.25 2.0 TRUE
SET_PLAYER_COORDINATES player1 -962.53 141.69 8.25
SET_PLAYER_HEADING player1 183.42

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2089 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_A ) 10000 1 //"Hello? Hello?"

WHILE cs_time < 6844 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_B ) 10000 1 //"Come in and take de weight off your soles.

WHILE cs_time < 9955 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_C ) 10000 1 //"You must be the big bad man me grandaddy been chattin' about.

WHILE cs_time < 13943 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_D ) 10000 1 //"Tells me tings about you, when he visits,

WHILE cs_time < 16609 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_E ) 10000 1 //"and about the others who wait for you.

WHILE cs_time < 19208 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_F ) 10000 1 //"Now, we all a long time dead, but you.

WHILE cs_time < 21822 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_G ) 10000 1 //"I wouldn't want to be in your shoes, eh? heh heh heh!

WHILE cs_time < 24520 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_H ) 10000 1 //"I got a message. To come here.

WHILE cs_time < 26563 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_I ) 10000 1 //"Can you hear dem?

WHILE cs_time < 28200 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_J ) 10000 1 //"Dey whispering your name boy, must want you pretty bad, don't you tink?

WHILE cs_time < 32697 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_K ) 10000 1 //"Now you do old Auntie Poulet a turn and maybe she help you.

WHILE cs_time < 35049 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_L ) 10000 1 //"Maybe she give you juju for after all of dis.

WHILE cs_time < 39949 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_M ) 10000 1 //"Give you some magic to give law man the stink eye, hmmmmm?

WHILE cs_time < 43624 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_N ) 10000 1 //"Look, this is all very uh..Give me a what?

WHILE cs_time < 47531 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_O ) 10000 1 //"I,I, I think I've got the wrong address...

WHILE cs_time < 49412 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_P ) 10000 1 //"Do me these things Tommy......

WHILE cs_time < 53234 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_Q ) 10000 1 //"The Cubans, nasty proud foofoos, hmmm.

WHILE cs_time < 57817 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_R ) 10000 1 //"been making my lovely Haitian boys shake de heads.

WHILE cs_time < 61451 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_S ) 10000 1 //"Now they told the policemen where I been stashing my powders.

WHILE cs_time < 64655 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_T ) 10000 1 //"Dey tink it's drugs, dey stupid.

WHILE cs_time < 68336 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_U ) 10000 1 //Now be a good boy Tommy and go and get me powders for Auntie Poulet.

WHILE cs_time < 74373 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM1_V ) 10000 1 //"Yeah, sure

WHILE cs_time < 77824 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 80912 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_EXTRA_COLOURS FALSE

SET_AREA_VISIBLE VIS_MAIN_MAP

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

LOAD_SCENE -962.53 141.69 8.25

// ******************************************END OF CUTSCENE********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

// Requesting models

REQUEST_MODEL SWAT

REQUEST_MODEL MP5LNG

REQUEST_MODEL SNIPER

REQUEST_MODEL NITESTICK

LOAD_MISSION_AUDIO 1 ( HAT_1A ) //"Don't move a muscle, chump!"

WHILE NOT HAS_MODEL_LOADED SWAT
OR NOT HAS_MODEL_LOADED MP5LNG
OR NOT HAS_MODEL_LOADED SNIPER
OR NOT HAS_MODEL_LOADED NITESTICK

	WAIT 0

ENDWHILE

WHILE NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

ENDWHILE

// Need this to stop compiler complaining
GOTO hait1_fool_compiler // SCFIX

CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case2_hait1 cop2_y_case2_hait1 cop2_z_case2_hait1 cop2_case2_hait1

ADD_BLIP_FOR_CHAR cop2_case2_hait1 blip_chase_cop2_case2_hait1

REMOVE_BLIP blip_chase_cop2_case2_hait1

DELETE_CHAR cop2_case2_hait1

CREATE_CHAR PEDTYPE_CIVMALE SWAT cop3_x_case2_hait1 cop3_y_case2_hait1 cop3_z_case2_hait1 cop3_case2_hait1

ADD_BLIP_FOR_CHAR cop3_case2_hait1 blip_chase_cop3_case2_hait1

REMOVE_BLIP blip_chase_cop3_case2_hait1

DELETE_CHAR cop3_case2_hait1

CREATE_PICKUP briefcase PICKUP_ONCE case2_x_hait1 case2_y_hait1 case2_z_hait1 case2_hait1

ADD_BLIP_FOR_PICKUP case2_hait1 radar_blip2_case2_hait1  

REMOVE_BLIP radar_blip2_case2_hait1

REMOVE_PICKUP case2_hait1

CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case3_hait1 cop2_y_case3_hait1 cop2_z_case3_hait1 cop2_case3_hait1

ADD_BLIP_FOR_CHAR cop2_case3_hait1 blip_chase_cop2_case3_hait1

REMOVE_BLIP blip_chase_cop2_case3_hait1

DELETE_CHAR cop2_case3_hait1 

CREATE_CHAR PEDTYPE_CIVMALE SWAT cop1_x_case3_hait1 cop1_y_case3_hait1 cop1_z_case3_hait1 cop1_case3_hait1

ADD_BLIP_FOR_CHAR cop1_case3_hait1 blip_chase_cop1_case3_hait1

REMOVE_BLIP blip_chase_cop1_case3_hait1

DELETE_CHAR cop1_case3_hait1

CREATE_PICKUP briefcase PICKUP_ONCE case3_x_hait1 case3_y_hait1 case3_z_hait1 case3_hait1

ADD_BLIP_FOR_PICKUP case3_hait1 radar_blip2_case3_hait1  

REMOVE_BLIP radar_blip2_case3_hait1

REMOVE_PICKUP case3_hait1
 
CREATE_CHAR PEDTYPE_CIVMALE SWAT cop1_x_case1_hait1 cop1_y_case1_hait1 cop1_z_case1_hait1 cop1_case1_hait1

DELETE_CHAR cop1_case1_hait1  
		
CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case1_hait1 cop2_y_case1_hait1 cop2_z_case1_hait1 cop2_case1_hait1  
	
DELETE_CHAR cop2_case1_hait1 	

CREATE_CHAR PEDTYPE_CIVMALE SWAT cop3_x_case1_hait1 cop3_y_case1_hait1 cop3_z_case1_hait1 cop3_case1_hait1

DELETE_CHAR cop3_case1_hait1  
		
CREATE_CHAR PEDTYPE_CIVMALE SWAT cop4_x_case1_hait1 cop4_y_case1_hait1 cop4_z_case1_hait1 cop4_case1_hait1

DELETE_CHAR cop4_case1_hait1  
	
CREATE_CHAR PEDTYPE_COP SWAT -1168.36 -8.738 15.72 cop5_case1_hait1

DELETE_CHAR cop5_case1_hait1  

hait1_fool_compiler: // SCFIX

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

// creates briefcase1

CREATE_PICKUP briefcase PICKUP_ONCE case1_x_hait1 case1_y_hait1 case1_z_hait1 case1_hait1

ADD_BLIP_FOR_PICKUP case1_hait1 radar_blip_case1_hait1

case1_created_hait1 = 1


PRINT_NOW ( HAM1_1 ) 5000 1 //"The cops are getting close to finding our stashes go and get them before they find them."

blob_flag = 0

// ****************************** Main mission checking for the briefcases *****************

WHILE all_cases_recoverd_hait1 = 0

	WAIT 0

	IF flag_go_for_case2_hait1 = 1 

	   	IF timer_cops_case2_act_hait1 = 0 
	   		timera = 0
			timer_cops_case2_act_hait1 = 1
	   	ENDIF

		IF timer_cops_case2_act_hait1 = 1
		
			IF timera >= 1000
				timer_cops_case2_act_hait1 = 2
			ENDIF
			
		ENDIF	 

	ENDIF

	IF flag_go_for_case3_hait1 = 1 

	   	IF timer_cops_case3_act_hait1 = 0 
	   		timera = 0
			timer_cops_case3_act_hait1 = 1
	   	ENDIF

		IF timer_cops_case3_act_hait1 = 1
		
			IF timera >= 1000
				timer_cops_case3_act_hait1 = 2
			ENDIF
			
		ENDIF	 

	ENDIF

// case1

	IF case1_collected_hait1 = 0 

		IF case1_created_hait1 = 1
			GOSUB case1_collection_hait1
		ENDIF

	ENDIF
	
// cutscene case1

	IF case1_collected_hait1 = 1
	
		IF flag_cutscene_case1_done_hait1 = 0
			GOSUB cutscene_case1_hait1
		ENDIF
		
	ENDIF 

// case2

	IF case1_collected_hait1 = 1

		IF flag_cutscene_case1_done_hait1 = 1

			IF case2_created_hait1 = 0
				CLEAR_AREA case2_x_hait1 case2_y_hait1 case2_z_hait1 1.0 FALSE 
				CREATE_PICKUP briefcase PICKUP_ONCE case2_x_hait1 case2_y_hait1 case2_z_hait1 case2_hait1
				ADD_BLIP_FOR_PICKUP case2_hait1 radar_blip_case2_hait1
				DISPLAY_ONSCREEN_TIMER timer_case2_hait1 TIMER_DOWN
				
// creates cop1 case 2

				CLEAR_AREA cop1_x_case2_hait1 cop1_y_case2_hait1 cop1_z_case2_hait1 1.0 FALSE 
				CREATE_CHAR PEDTYPE_CIVMALE SWAT cop1_x_case2_hait1 cop1_y_case2_hait1 cop1_z_case2_hait1 cop1_case2_hait1 
				CLEAR_CHAR_THREAT_SEARCH cop1_case2_hait1
				SET_CHAR_PERSONALITY cop1_case2_hait1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH cop1_case2_hait1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR cop1_case2_hait1 WEAPONTYPE_SNIPERRIFLE 30000 // Set to infinate ammo
				SET_CHAR_STAY_IN_SAME_PLACE cop1_case2_hait1 TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_case2_hait1 player1
								
				CLEAR_AREA cop2_x_case2_hait1 cop2_y_case2_hait1 cop2_z_case2_hait1 1.0 FALSE 
				CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case2_hait1 cop2_y_case2_hait1 cop2_z_case2_hait1 cop2_case2_hait1 
				CLEAR_CHAR_THREAT_SEARCH cop2_case2_hait1
				SET_CHAR_PERSONALITY cop2_case2_hait1 PEDSTAT_TOUGH_GUY
				GIVE_WEAPON_TO_CHAR cop2_case2_hait1 WEAPONTYPE_MP5 30000 // Set to infinate ammo
				SET_CHAR_THREAT_SEARCH cop2_case2_hait1 THREAT_PLAYER1
				SET_CHAR_HEED_THREATS cop2_case2_hait1 TRUE
				SET_CHAR_HEADING cop2_case2_hait1 90.0
				
				CLEAR_AREA cop3_x_case2_hait1 cop3_y_case2_hait1 cop3_z_case2_hait1 1.0 FALSE 
				CREATE_CHAR PEDTYPE_CIVMALE SWAT cop3_x_case2_hait1 cop3_y_case2_hait1 cop3_z_case2_hait1 cop3_case2_hait1 
				CLEAR_CHAR_THREAT_SEARCH cop3_case2_hait1
				SET_CHAR_PERSONALITY cop3_case2_hait1 PEDSTAT_TOUGH_GUY
				GIVE_WEAPON_TO_CHAR cop3_case2_hait1 WEAPONTYPE_MP5 30000 // Set to infinate ammo
				SET_CHAR_THREAT_SEARCH cop3_case2_hait1 THREAT_PLAYER1
				SET_CHAR_HEED_THREATS cop3_case2_hait1 TRUE
				SET_CHAR_HEADING cop3_case2_hait1 90.0
			   									
				case2_created_hait1 = 1
			ENDIF
		 
		ENDIF
		
	ENDIF

	IF flag_cutscene_case1_done_hait1 = 1

		IF NOT LOCATE_PLAYER_ON_FOOT_2D player1 player_x_hait1 player_y_hait1 3.0 3.0 FALSE
		OR IS_PLAYER_SHOOTING player1
		OR IS_CHAR_DEAD cop5_case1_hait1 

			IF NOT IS_CHAR_DEAD cop1_case1_hait1
				SET_CHAR_STAY_IN_SAME_PLACE cop1_case1_hait1 TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_case1_hait1 player1
			ENDIF
	
			IF NOT IS_CHAR_DEAD cop2_case1_hait1
				SET_CHAR_STAY_IN_SAME_PLACE cop2_case1_hait1 TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_case1_hait1 player1
			ENDIF
	
			IF NOT IS_CHAR_DEAD cop3_case1_hait1
				SET_CHAR_STAY_IN_SAME_PLACE cop3_case1_hait1 TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_case1_hait1 player1
			ENDIF
	
			IF NOT IS_CHAR_DEAD cop4_case1_hait1
				SET_CHAR_STAY_IN_SAME_PLACE cop4_case1_hait1 TRUE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_case1_hait1 player1
			ENDIF
						
		ENDIF

	ENDIF
		
	IF case2_created_hait1 = 1
		GOSUB guards_case2_checks
	ENDIF
	
	IF case2_created_again_hait1 = 1
		GOSUB case2_collection2_hait1
	ENDIF	 

	IF case2_collected_hait1 = 0 

		IF case2_created_hait1 = 1
			GOSUB case2_collection_hait1
		ENDIF

	ENDIF

	IF case2_collected_hait1 = 0
	
		IF case2_created_hait1 = 1
		
			IF timer_case2_hait1 = 0
				flag_go_for_case2_hait1 = 1
			ENDIF
			
		ENDIF
		
	ENDIF

// Fail conditions for case2

	IF flag_cops_got_case2_hait1 = 1

		IF flag_cop2_case2_got_stash_hait1 = 1 
		
			IF NOT IS_CHAR_DEAD cop2_case2_hait1
				
				IF NOT IS_CHAR_ON_SCREEN cop2_case2_hait1
				
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cop2_case2_hait1 120.0 120.0 FALSE
						PRINT_NOW ( HAM1_2 ) 5000 1 //"The cops got to the stash first!
						GOTO mission_haitian1_failed	 
					ENDIF

				ENDIF

			ENDIF

		ENDIF

		IF flag_cop3_case2_got_stash_hait1 = 1 
		
			IF NOT IS_CHAR_DEAD cop3_case2_hait1
				
				IF NOT IS_CHAR_ON_SCREEN cop3_case2_hait1
				
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cop3_case2_hait1 120.0 120.0 FALSE
						PRINT_NOW ( HAM1_2 ) 5000 1 //"The cops got to the stash first!
						GOTO mission_haitian1_failed	 
					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
	ENDIF
	
	IF flag_case2_destroyed_hait1 = 1
		PRINT_NOW ( HAM1_6 ) 5000 1 //"The Stash was destroyed, you idiot!"
		GOTO mission_haitian1_failed
	ENDIF	 

// case3

	IF case2_collected_hait1 = 1
	OR case2_collected_again_hait1 = 1 

		IF case3_created_hait1 = 0
			CLEAR_AREA case3_x_hait1 case3_y_hait1 case3_z_hait1 1.0 FALSE 
			CREATE_PICKUP briefcase PICKUP_ONCE case3_x_hait1 case3_y_hait1 case3_z_hait1 case3_hait1
			ADD_BLIP_FOR_PICKUP case3_hait1 radar_blip_case3_hait1
		   	DISPLAY_ONSCREEN_TIMER timer_case3_hait1 TIMER_DOWN	
			case3_created_hait1 = 1
		ENDIF
						 
	ENDIF

	IF case3_collected_hait1 = 0 

		IF case3_created_hait1 = 1
			GOSUB case3_collection_hait1
		ENDIF

	ENDIF

// case 3 fail conditions

  	IF flag_cops_got_case3_hait1 = 1

		IF flag_cop1_case3_got_stash_hait1 = 1

			IF NOT IS_CHAR_DEAD cop1_case3_hait1
				
				IF NOT IS_CHAR_ON_SCREEN cop1_case3_hait1
				
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cop1_case3_hait1 120.0 120.0 FALSE
						PRINT_NOW ( HAM1_2 ) 5000 1 //"The cops got to the stash first!
						GOTO mission_haitian1_failed	 
					ENDIF

				ENDIF

			ENDIF

		ENDIF

		IF flag_cop2_case3_got_stash_hait1 = 1

			IF NOT IS_CHAR_DEAD cop2_case3_hait1
				
				IF NOT IS_CHAR_ON_SCREEN cop2_case3_hait1
				
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cop2_case3_hait1 120.0 120.0 FALSE
						PRINT_NOW ( HAM1_2 ) 5000 1 //"The cops got to the stash first!
						GOTO mission_haitian1_failed	 
					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
	ENDIF 
	
	IF flag_case3_destroyed_hait1 = 1
		PRINT_NOW ( HAM1_6 ) 5000 1 //"The Stash was destroyed, you idiot!"
		GOTO mission_haitian1_failed
	ENDIF

	IF case3_collected_hait1 = 0
	
		IF case3_created_hait1 = 1
		
			IF timer_case3_hait1 = 0
				flag_go_for_case3_hait1 = 1
			ENDIF
			
		ENDIF
		
	ENDIF

	IF case2_collected_hait1 = 1
	OR case2_collected_again_hait1 = 1

		IF police_created_case3_hait1 = 0
			GOSUB cop_creation_case3_hait1
		ENDIF

	ENDIF

	IF police_created_case3_hait1 = 1
		GOSUB cops_case3_death_hait1
	ENDIF

// adds blip for destination

	IF counter_cases_collected_hait1 = 3
	
		IF flag_home_blip_on_hait1 = 0
			PRINT_NOW ( HAM1_3 ) 5000 1 //"Get this stuff back to the hideout!"
			ADD_BLIP_FOR_COORD home_x_hait1 home_y_hait1 home_z_hait1 radar_blip_coord1_hait1
			blob_flag = 1
			flag_home_blip_on_hait1 = 1
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 home_x_hait1 home_y_hait1 home_z_hait1 2.0 2.0 2.0 blob_flag

			IF all_cases_recoverd_hait1 = 0
				all_cases_recoverd_hait1 = 1
			ENDIF

		ENDIF		 
		
	ENDIF 
	
ENDWHILE

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_CHAR_OBJ_NO_OBJ scplayer

MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case3_hait1							  
MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case3_hait1

CLEAR_AREA -964.776 145.189 9.52 1.0 FALSE 
SET_FIXED_CAMERA_POSITION -964.776 145.189 9.52 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -964.032 144.523 9.479 JUMP_CUT

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN player1 player_car_hait1

	SET_CHAR_OBJ_LEAVE_CAR scplayer player_car_hait1

	WHILE IS_PLAYER_IN_ANY_CAR player1
	
		WAIT 0

		IF IS_CAR_DEAD player_car_hait1
			GOTO mission_haitian1_failed 
		ENDIF
		
	ENDWHILE
	
ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -962.708 145.443

timera = 0

WHILE timera < 4500

	WAIT 0
		
ENDWHILE
   
SET_CHAR_OBJ_NO_OBJ scplayer
CLEAR_AREA -965.265 142.855 8.23 1.0 FALSE  
SET_PLAYER_COORDINATES player1 -965.265 142.855 8.23
SET_PLAYER_HEADING player1 190.53
SET_CAMERA_IN_FRONT_OF_PLAYER
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF	    

GOTO mission_haitian1_passed


// *************************************** MISSION FAILED **********************************	   		
	
// Mission haitian1 failed

mission_haitian1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"

RETURN

// *************************************** MISSION PASSED **********************************   

// mission haitian1 passed

mission_haitian1_passed:

flag_haitian_mission1_passed = 1
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED ( HAT_1 )  // Haitian Mission 1
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
ADD_SCORE player1 1000
CLEAR_WANTED_LEVEL player1
START_NEW_SCRIPT haitian_mission2_loop
RETURN
		
// ************************************** MISSION CLEANUP **********************************

// mission cleanup

mission_cleanup_haitian1:

flag_player_on_mission = 0
MARK_MODEL_AS_NO_LONGER_NEEDED SWAT
MARK_MODEL_AS_NO_LONGER_NEEDED MP5LNG
MARK_MODEL_AS_NO_LONGER_NEEDED SNIPER
MARK_MODEL_AS_NO_LONGER_NEEDED NITESTICK
REMOVE_BLIP radar_blip_case1_hait1
REMOVE_BLIP radar_blip_case2_hait1
REMOVE_BLIP radar_blip2_case2_hait1
REMOVE_BLIP radar_blip_case3_hait1
REMOVE_BLIP radar_blip2_case3_hait1
REMOVE_BLIP radar_blip_coord1_hait1
REMOVE_BLIP blip_chase_cop2_case2_hait1
REMOVE_BLIP blip_chase_cop3_case2_hait1
REMOVE_BLIP blip_chase_cop1_case3_hait1
REMOVE_BLIP blip_chase_cop2_case3_hait1
CLEAR_ONSCREEN_TIMER timer_case2_hait1
CLEAR_ONSCREEN_TIMER timer_case3_hait1

// case1

IF case1_created_hait1 = 1

	IF case1_collected_hait1 = 0
		REMOVE_PICKUP case1_hait1
	ENDIF

ENDIF

// case2

IF case2_created_hait1 = 1

	IF case2_collected_hait1 = 0
	OR flag_cops_got_case2_hait1 = 0 
		REMOVE_PICKUP case2_hait1
	ENDIF

ENDIF

IF case2_collected_again_hait1 = 0

	IF case2_created_again_hait1 = 1
		REMOVE_BLIP radar_blip2_case2_hait1 
		REMOVE_PICKUP case2_hait1
	ENDIF

ENDIF

// case3

IF case3_created_hait1 = 1

	IF case3_collected_hait1 = 0
		REMOVE_PICKUP case3_hait1
	ENDIF

ENDIF

IF case3_collected_again_hait1 = 0

	IF case3_created_again_hait1 = 1
		REMOVE_BLIP radar_blip2_case3_hait1 
		REMOVE_PICKUP case3_hait1
	ENDIF

ENDIF

GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED

RETURN


// Checks to see if the cases have been collected

// case1

case1_collection_hait1:

IF case1_collected_hait1 = 0 

	IF case1_created_hait1 = 1
			
		IF HAS_PICKUP_BEEN_COLLECTED case1_hait1
			REMOVE_BLIP radar_blip_case1_hait1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			++ counter_cases_collected_hait1 
			case1_collected_hait1 = 1
		ENDIF

	ENDIF

ENDIF

RETURN

// case2

case2_collection_hait1:

IF case2_collected_hait1 = 0 

	IF case2_created_hait1 = 1

		IF flag_cops_got_case2_hait1 = 0
			
			IF HAS_PICKUP_BEEN_COLLECTED case2_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case1_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case1_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop3_case1_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop4_case1_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop5_case1_hait1
				REMOVE_BLIP radar_blip_case2_hait1
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				CLEAR_ONSCREEN_TIMER timer_case2_hait1
				ALTER_WANTED_LEVEL_NO_DROP player1 4
				PRINT_NOW ( HAM1_4 ) 5000 1 //"Good now get the next one!"
				++ counter_cases_collected_hait1
				flag_guards_case2_act_hait1 = 1
				case2_collected_hait1 = 1
			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

// case2 created again

case2_collection2_hait1:

IF case2_collected_again_hait1 = 0 

	IF HAS_PICKUP_BEEN_COLLECTED case2_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case1_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case1_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_case1_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop4_case1_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop5_case1_hait1
		REMOVE_BLIP radar_blip2_case2_hait1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		PRINT_NOW ( HAM1_4 ) 5000 1 //"Good now on to the nest one!"
		ALTER_WANTED_LEVEL_NO_DROP player1 4
		++ counter_cases_collected_hait1
		flag_guards_case2_act_hait1 = 1
		case2_collected_again_hait1 = 1
	ENDIF

ENDIF

RETURN

// case3

case3_collection_hait1:

IF case3_collected_hait1 = 0 

	IF case3_created_hait1 = 1

		IF flag_cops_got_case3_hait1 = 0
			
			IF HAS_PICKUP_BEEN_COLLECTED case3_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case2_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case2_hait1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop3_case2_hait1
				REMOVE_BLIP radar_blip_case3_hait1
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				CLEAR_ONSCREEN_TIMER timer_case3_hait1
		   		ALTER_WANTED_LEVEL_NO_DROP player1 5
				++ counter_cases_collected_hait1
				flag_guards_case3_act_hait1 = 1 
				case3_collected_hait1 = 1
			ENDIF

		ENDIF

	ENDIF

ENDIF

// case 3 created again

case3_collection2_hait1:

IF case3_collected_again_hait1 = 0 

	IF HAS_PICKUP_BEEN_COLLECTED case3_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case2_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case2_hait1
		MARK_CHAR_AS_NO_LONGER_NEEDED cop3_case2_hait1
		REMOVE_BLIP radar_blip2_case3_hait1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ALTER_WANTED_LEVEL_NO_DROP player1 5
		++ counter_cases_collected_hait1
		flag_guards_case3_act_hait1 = 1
		case3_collected_again_hait1 = 1
	ENDIF

ENDIF

RETURN


// cutscene for case one

cutscene_case1_hait1:

IF flag_cutscene_case1_done_hait1 = 0
		
	SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL player1 OFF
	SET_POLICE_IGNORE_PLAYER player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 ON
	GET_PLAYER_CHAR player1 scplayer

	GET_PLAYER_COORDINATES player1 player_x_hait1 player_y_hait1 player_z_hait1 

// cop1 in front of player1

	CLEAR_AREA cop1_x_case1_hait1 cop1_y_case1_hait1 cop1_z_case1_hait1 1.0 FALSE 
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop1_x_case1_hait1 cop1_y_case1_hait1 cop1_z_case1_hait1 cop1_case1_hait1  
	CLEAR_CHAR_THREAT_SEARCH cop1_case1_hait1
	GIVE_WEAPON_TO_CHAR cop1_case1_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo
	TURN_CHAR_TO_FACE_PLAYER cop1_case1_hait1 player1
   	SET_CHAR_WAIT_STATE cop1_case1_hait1 WAITSTATE_PLAYANIM_DUCK 800
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR cop1_case1_hait1 scplayer
	SET_CHAR_VISIBLE cop1_case1_hait1 FALSE
	SET_CHAR_PROOFS cop1_case1_hait1 TRUE TRUE TRUE TRUE TRUE   
		
	WAIT 500
    
    LOAD_SCENE cop1_x_case1_hait1 cop1_y_case1_hait1 cop1_z_case1_hait1 	
	SET_FIXED_CAMERA_POSITION -1153.551 -32.372 21.675 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -1153.833 -31.475 21.334 JUMP_CUT

	// Cop5

	CREATE_CHAR PEDTYPE_COP SWAT -1176.80 -22.20 15.62 cop5_case1_hait1  
	CLEAR_CHAR_THREAT_SEARCH cop5_case1_hait1
	GIVE_WEAPON_TO_CHAR cop5_case1_hait1 WEAPONTYPE_NIGHTSTICK 1 // set to infinate ammo 
	TURN_CHAR_TO_FACE_PLAYER cop5_case1_hait1 player1

	IF NOT IS_CHAR_DEAD cop1_case1_hait1
		SET_CHAR_VISIBLE cop1_case1_hait1 TRUE
		SET_CHAR_PROOFS cop1_case1_hait1 FALSE FALSE FALSE FALSE FALSE
	ENDIF
		
	TURN_CHAR_TO_FACE_COORD scplayer -1159.61 -31.04 20.09 	
   	
   	PLAY_MISSION_AUDIO 1 
	PRINT_NOW ( HAT_1A ) 5000 1 //"Don't move a muscle, chump!"
	SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_HANDSUP 1000000

	timera = 0

	WHILE timera < 4000

		WAIT 0

		IF IS_BUTTON_PRESSED PAD1 CROSS
			GOTO end_cut_hait1
		ENDIF

		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT ( HAT_1A )
		ENDIF

	ENDWHILE
		
	end_cut_hait1:

	// cop2

	CLEAR_AREA cop2_x_case1_hait1 cop2_y_case1_hait1 cop2_z_case1_hait1 1.0 FALSE
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case1_hait1 cop2_y_case1_hait1 cop2_z_case1_hait1 cop2_case1_hait1  
	CLEAR_CHAR_THREAT_SEARCH cop2_case1_hait1
	GIVE_WEAPON_TO_CHAR cop2_case1_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo
	TURN_CHAR_TO_FACE_PLAYER cop2_case1_hait1 player1
	SET_CHAR_WAIT_STATE cop2_case1_hait1 WAITSTATE_PLAYANIM_DUCK 2200
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR cop2_case1_hait1 scplayer
	
// cop3 in front of player1

	CLEAR_AREA cop3_x_case1_hait1 cop3_y_case1_hait1 cop3_z_case1_hait1 1.0 FALSE
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop3_x_case1_hait1 cop3_y_case1_hait1 cop3_z_case1_hait1 cop3_case1_hait1  
	CLEAR_CHAR_THREAT_SEARCH cop3_case1_hait1
	GIVE_WEAPON_TO_CHAR cop3_case1_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo
	TURN_CHAR_TO_FACE_PLAYER cop3_case1_hait1 player1
	SET_CHAR_WAIT_STATE cop3_case1_hait1 WAITSTATE_PLAYANIM_DUCK 5000
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR cop3_case1_hait1 scplayer
	
// cop4

	CLEAR_AREA cop4_x_case1_hait1 cop4_y_case1_hait1 cop4_z_case1_hait1 1.0 FALSE
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop4_x_case1_hait1 cop4_y_case1_hait1 cop4_z_case1_hait1 cop4_case1_hait1  
	CLEAR_CHAR_THREAT_SEARCH cop4_case1_hait1
	GIVE_WEAPON_TO_CHAR cop4_case1_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo 
	TURN_CHAR_TO_FACE_PLAYER cop4_case1_hait1 player1
	SET_CHAR_WAIT_STATE cop4_case1_hait1 WAITSTATE_PLAYANIM_DUCK 5000
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR cop4_case1_hait1 scplayer
	
	IF HAS_MISSION_AUDIO_FINISHED 1
		CLEAR_THIS_PRINT ( HAT_1A )
	ENDIF
	STOP_PLAYER_LOOKING player1
	SWITCH_WIDESCREEN OFF
	SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
	SET_PLAYER_CONTROL player1 ON
	SET_POLICE_IGNORE_PLAYER player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	RESTORE_CAMERA_JUMPCUT
	ALTER_WANTED_LEVEL_NO_DROP player1 2
	PRINT_NOW ( HAM1_4 ) 5000 1 //"Good now get the next one!"
	flag_cutscene_case1_done_hait1 = 1
	
ENDIF 

RETURN

// Checks to see if any of the guards are dead and will tell them to run to the case

guards_case2_checks:

// cop1 sniper of roof across form case

IF flag_cop1_case2_dead_hait1 = 0

	IF IS_CHAR_DEAD cop1_case2_hait1
		flag_cop1_case2_dead_hait1 = 1
	ELSE
				
		GET_CHAR_HEALTH cop1_case2_hait1 cop1_case2_health_hait1 

		IF cop1_case2_health_hait1 <= 90 
			flag_guards_case2_act_hait1 = 1
			flag_go_for_case2_hait1 = 1
		ENDIF
	  	  		
	ENDIF 	

ENDIF

// cop2

IF flag_cop2_case2_dead_hait1 = 0

	IF IS_CHAR_DEAD cop2_case2_hait1
				
		IF flag_cops_got_case2_hait1 = 1

			IF flag_cop2_case2_got_stash_hait1 = 1
						
				IF flag_cop2_case2_in_car_hait1 = 1
					flag_case2_destroyed_hait1 = 1	
				ELSE 
					
					IF DOES_CHAR_EXIST cop2_case2_hait1
					 
						IF case2_created_again_hait1 = 0 
							REMOVE_BLIP blip_chase_cop2_case2_hait1
							GET_DEAD_CHAR_PICKUP_COORDS cop2_case2_hait1 case2_x_hait1 case2_y_hait1 case2_z_hait1
							CREATE_PICKUP briefcase PICKUP_ONCE case2_x_hait1 case2_y_hait1 case2_z_hait1 case2_hait1
							ADD_BLIP_FOR_PICKUP case2_hait1 radar_blip2_case2_hait1
							case2_created_again_hait1 = 1
						ENDIF

					ELSE
						flag_case2_destroyed_hait1 = 1
					ENDIF

				ENDIF

			ENDIF

		ENDIF

		flag_go_for_case2_hait1 = 1
		flag_guards_case2_act_hait1 = 1
		flag_cop2_case2_dead_hait1 = 1
	ELSE

	   	GET_CHAR_HEALTH cop2_case2_hait1 cop2_case2_health_hait1

		IF flag_cops_got_case2_hait1 = 1
			GOSUB case2_chase_stuff_hait1_hait1
		ENDIF

		IF cop2_case2_health_hait1 <= 90 
			flag_guards_case2_act_hait1 = 1
			flag_go_for_case2_hait1 = 1
		ENDIF
	
		IF case2_collected_hait1 = 1
		OR flag_guards_case2_act_hait1 = 1

			IF flag_cop3_case2_dead_hait1 = 0 
				SET_CHAR_THREAT_SEARCH cop2_case2_hait1 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_case2_hait1 player1
			ELSE

				IF case2_collected_hait1 = 0
												
					IF flag_cops_got_case2_hait1 = 0

						IF flag_go_for_case2_hait1 = 1
							
							IF flag_cop2_case2_location_hait1 = 0
								SET_CHAR_HEED_THREATS cop2_case2_hait1 FALSE
								CLEAR_CHAR_THREAT_SEARCH cop2_case2_hait1
								SET_CHAR_OBJ_NO_OBJ cop2_case2_hait1
								PRINT_NOW ( HAM1_8 ) 5000 1 //"The cops are on the way to pick up the stash, get a move on!"
								CLEAR_ONSCREEN_TIMER timer_case2_hait1
								flag_cop2_case2_location_hait1 = 1
							ENDIF
																					
							IF flag_cop2_case2_location_hait1 = 1

								IF NOT IS_CHAR_WANDER_PATH_CLEAR cop2_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 4.0 

									IF cop2_case2_follow_1sttime_hait1 = 0
										CHAR_FOLLOW_PATH cop2_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 0.1 RUN
										cop2_case2_follow_1sttime_hait1 = 1
									ENDIF

									IF timer_cops_case2_act_hait1 = 2 
										CHAR_FOLLOW_PATH cop2_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 0.1 RUN
									ENDIF
									
								ELSE
									SET_CHAR_RUNNING cop2_case2_hait1 TRUE 
									SET_CHAR_OBJ_RUN_TO_COORD cop2_case2_hait1 case2_x_hait1 case2_y_hait1
									flag_cop2_case2_location_hait1 = 3	
								ENDIF

							ENDIF

							IF flag_cop2_case2_location_hait1 = 1
							
								IF LOCATE_CHAR_ON_FOOT_3D cop2_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 2.5 2.5 2.5 FALSE   
									flag_cop2_case2_location_hait1 = 2
								ENDIF

								IF flag_cop2_case2_location_hait1 = 2 
									SET_CHAR_RUNNING cop2_case2_hait1 TRUE 
									SET_CHAR_OBJ_RUN_TO_COORD cop2_case2_hait1 case2_x_hait1 case2_y_hait1
									flag_cop2_case2_location_hait1 = 3
								ENDIF
							
							ENDIF	
														 
						ENDIF
						
						IF NOT IS_CHAR_DEAD cop2_case2_hait1
						
							IF flag_cop2_case2_location_hait1 = 3 
			
								IF LOCATE_CHAR_ON_FOOT_2D cop2_case2_hait1 case2_x_hait1 case2_y_hait1 1.5 1.5 FALSE
					    
									IF case2_collected_hait1 = 0
										REMOVE_BLIP radar_blip_case2_hait1
										CLEAR_ONSCREEN_TIMER timer_case2_hait1
										REMOVE_PICKUP case2_hait1
										ADD_BLIP_FOR_CHAR cop2_case2_hait1 blip_chase_cop2_case2_hait1 
										PRINT_NOW ( HAM1_7 ) 5000 1 //"Idiot! the cops have got our stash, retrieve it!
										flag_cop2_case2_got_stash_hait1 = 1
										flag_cops_got_case2_hait1 = 1
									ENDIF

								ENDIF

							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
	ENDIF 	

ENDIF

// cop3 runs for the case if the timer is out

IF flag_cop3_case2_dead_hait1 = 0

	IF IS_CHAR_DEAD cop3_case2_hait1

		IF flag_cops_got_case2_hait1 = 1

			IF flag_cop3_case2_got_stash_hait1 = 1
						
				IF flag_cop3_case2_in_car_hait1 = 1
					flag_case2_destroyed_hait1 = 1	
				ELSE
				
					IF DOES_CHAR_EXIST cop3_case2_hait1 
			
						IF case2_created_again_hait1 = 0 
							REMOVE_BLIP blip_chase_cop3_case2_hait1
							GET_DEAD_CHAR_PICKUP_COORDS cop3_case2_hait1 case2_x_hait1 case2_y_hait1 case2_z_hait1
							CREATE_PICKUP briefcase PICKUP_ONCE case2_x_hait1 case2_y_hait1 case2_z_hait1 case2_hait1
							ADD_BLIP_FOR_PICKUP case2_hait1 radar_blip2_case2_hait1
							case2_created_again_hait1 = 1
						ENDIF

					ELSE
						flag_case2_destroyed_hait1 = 1
					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
		flag_go_for_case2_hait1 = 1
		flag_guards_case2_act_hait1 = 1
		flag_cop3_case2_dead_hait1 = 1
	ELSE
				
		GET_CHAR_HEALTH cop3_case2_hait1 cop3_case2_health_hait1

		IF flag_cops_got_case2_hait1 = 1
			GOSUB case2_chase_stuff_hait1_hait1
		ENDIF

		IF cop3_case2_health_hait1 <= 90 
			flag_guards_case2_act_hait1 = 1
			flag_go_for_case2_hait1 = 1
		ENDIF
				
		IF flag_guards_case2_act_hait1 = 1
		OR flag_go_for_case2_hait1 = 1
		//OR case2_collected_hait1 = 1
											
			IF case2_collected_hait1 = 0
												
				IF flag_cops_got_case2_hait1 = 0
															
					IF flag_go_for_case2_hait1 = 1

						IF flag_cop3_case2_location_hait1 = 0
							SET_CHAR_HEED_THREATS cop3_case2_hait1 FALSE 
							CLEAR_CHAR_THREAT_SEARCH cop3_case2_hait1
							SET_CHAR_OBJ_NO_OBJ cop3_case2_hait1
							PRINT_NOW ( HAM1_8 ) 5000 1 //"The cops are on the way to pick up the stash, get a move on!"
							CLEAR_ONSCREEN_TIMER timer_case2_hait1
							flag_cop3_case2_location_hait1 = 1
						ENDIF
																					
						IF flag_cop3_case2_location_hait1 = 1

							IF NOT IS_CHAR_WANDER_PATH_CLEAR cop3_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 4.0 

								IF cop3_case2_follow_1sttime_hait1 = 0
									CHAR_FOLLOW_PATH cop3_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 0.1 RUN
									cop3_case2_follow_1sttime_hait1 = 1
								ENDIF 

								IF timer_cops_case2_act_hait1 = 2
									CHAR_FOLLOW_PATH cop3_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 0.1 RUN
								ENDIF

							ELSE
								SET_CHAR_RUNNING cop3_case2_hait1 TRUE 
								SET_CHAR_OBJ_RUN_TO_COORD cop3_case2_hait1 case2_x_hait1 case2_y_hait1
								flag_cop3_case2_location_hait1 = 3
							ENDIF

						ENDIF

						IF flag_cop3_case2_location_hait1 = 1

							IF LOCATE_CHAR_ON_FOOT_3D cop3_case2_hait1 case2_x2_hait1 case2_y2_hait1 case2_z2_hait1 2.5 2.5 2.5 FALSE
								flag_cop3_case2_location_hait1 = 2
							ENDIF

						ENDIF

						IF flag_cop3_case2_location_hait1 = 2
							SET_CHAR_RUNNING cop3_case2_hait1 TRUE 
							SET_CHAR_OBJ_RUN_TO_COORD cop3_case2_hait1 case2_x_hait1 case2_y_hait1
							flag_cop3_case2_location_hait1 = 3
						ENDIF
																				 
					ENDIF
					
					IF NOT IS_CHAR_DEAD cop3_case2_hait1
					
						IF flag_cop3_case2_location_hait1 = 3  
			
							IF LOCATE_CHAR_ON_FOOT_2D cop3_case2_hait1 case2_x_hait1 case2_y_hait1 1.5 1.5 FALSE
					    
								IF case2_collected_hait1 = 0
									REMOVE_BLIP radar_blip_case2_hait1
									CLEAR_ONSCREEN_TIMER timer_case2_hait1
									REMOVE_PICKUP case2_hait1
									ADD_BLIP_FOR_CHAR cop3_case2_hait1 blip_chase_cop3_case2_hait1 
									PRINT_NOW ( HAM1_7 ) 5000 1 //"Idiot! the cops have got our stash, retrieve it!
									flag_cop3_case2_got_stash_hait1 = 1
									flag_cops_got_case2_hait1 = 1
								ENDIF

							ENDIF

						ENDIF

					ENDIF

				ENDIF
								
			ELSE

				IF flag_cops_got_case2_hait1 = 0
					SET_CHAR_THREAT_SEARCH cop3_case2_hait1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_case2_hait1 player1
				ENDIF

			ENDIF

		ENDIF
								
	ENDIF 	

ENDIF

IF timer_cops_case2_act_hait1 = 2
	timer_cops_case2_act_hait1 = 0
ENDIF

RETURN

// creates the cops for case3

cop_creation_case3_hait1:

IF police_created_case3_hait1 = 0

	IF NOT IS_CHAR_DEAD cop1_case1_hait1 
		MARK_CHAR_AS_NO_LONGER_NEEDED cop1_case1_hait1
	ENDIF

	IF NOT IS_CHAR_DEAD cop2_case1_hait1 
		MARK_CHAR_AS_NO_LONGER_NEEDED cop2_case1_hait1
	ENDIF
			
// cop1 on roof
	
	CLEAR_AREA cop1_x_case3_hait1 cop1_y_case3_hait1 cop1_z_case3_hait1 2.0 FALSE 
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop1_x_case3_hait1 cop1_y_case3_hait1 cop1_z_case3_hait1 cop1_case3_hait1
	SET_CHAR_HEADING cop1_case3_hait1 cop1_case3_heading_hait1 
	CLEAR_CHAR_THREAT_SEARCH cop1_case3_hait1
	SET_CHAR_PERSONALITY cop1_case3_hait1 PEDSTAT_TOUGH_GUY 
	SET_CHAR_THREAT_SEARCH cop1_case3_hait1 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR cop1_case3_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo
	SET_CHAR_HEED_THREATS cop1_case3_hait1 TRUE
			
// cop2

	CLEAR_AREA cop2_x_case3_hait1 cop2_y_case3_hait1 cop2_z_case3_hait1 2.0 FALSE 
	CREATE_CHAR PEDTYPE_CIVMALE SWAT cop2_x_case3_hait1 cop2_y_case3_hait1 cop2_z_case3_hait1 cop2_case3_hait1
	CLEAR_CHAR_THREAT_SEARCH cop2_case3_hait1
	SET_CHAR_PERSONALITY cop2_case3_hait1 PEDSTAT_TOUGH_GUY
	SET_CHAR_THREAT_SEARCH cop2_case3_hait1 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR cop2_case3_hait1 WEAPONTYPE_MP5 30000 // set to infinate ammo
	SET_CHAR_HEED_THREATS cop2_case3_hait1 TRUE
	SET_THREAT_REACTION_RANGE_MULTIPLIER 8.0
					
	police_created_case3_hait1 = 1
	
ENDIF 

RETURN

// checks to see if any of the cops are dead case3

cops_case3_death_hait1:

IF flag_cop1_case3_dead_hait1 = 0

	IF IS_CHAR_DEAD cop1_case3_hait1

		IF flag_cops_got_case3_hait1 = 1

			IF flag_cop1_case3_got_stash_hait1 = 1
			
				IF flag_cop1_case3_in_car_hait1 = 1
					flag_case3_destroyed_hait1 = 1	
				ELSE
				
					IF DOES_CHAR_EXIST cop1_case3_hait1 
			
						IF case3_created_again_hait1 = 0 
							REMOVE_BLIP blip_chase_cop1_case3_hait1
							GET_DEAD_CHAR_PICKUP_COORDS cop1_case3_hait1 case3_x_hait1 case3_y_hait1 case3_z_hait1
							CREATE_PICKUP briefcase PICKUP_ONCE case3_x_hait1 case3_y_hait1 case3_z_hait1 case3_hait1
							ADD_BLIP_FOR_PICKUP case3_hait1 radar_blip2_case3_hait1
							case3_created_again_hait1 = 1
						ENDIF

					ELSE
						flag_case3_destroyed_hait1 = 1
					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
		flag_guards_case3_act_hait1 = 1
		flag_go_for_case3_hait1 = 1 
		flag_cop1_case3_dead_hait1 = 1
	ELSE

		GET_CHAR_HEALTH cop1_case3_hait1 cop1_case3_health_hait1

		IF flag_cops_got_case3_hait1 = 1
			GOSUB case3_chase_stuff_hait1
		ENDIF

		IF cop1_case3_health_hait1 <= 90 
			flag_guards_case3_act_hait1 = 1
			flag_go_for_case3_hait1 = 1
		ENDIF

		IF flag_guards_case3_act_hait1 = 1
		OR flag_go_for_case3_hait1 = 1

			IF flag_cop2_case3_dead_hait1 = 0
				IF NOT IS_CHAR_DEAD cop1_case3_hait1 
					SET_CHAR_THREAT_SEARCH cop1_case3_hait1 THREAT_PLAYER1 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_case3_hait1 player1
				ENDIF 
			ELSE

				IF case3_collected_hait1 = 0
												
					IF flag_cops_got_case3_hait1 = 0
												
						IF flag_go_for_case3_hait1 = 1

							IF flag_cop1_case3_location_hait1 = 0
								SET_CHAR_HEED_THREATS cop1_case3_hait1 FALSE
 								CLEAR_CHAR_THREAT_SEARCH cop1_case3_hait1
								SET_CHAR_OBJ_NO_OBJ cop1_case3_hait1
								PRINT_NOW ( HAM1_8 ) 5000 1 //"The cops are on the way to pick up the stash, get a move on!"
								CLEAR_ONSCREEN_TIMER timer_case3_hait1
								flag_cop1_case3_location_hait1 = 1
							ENDIF

							IF flag_cop1_case3_location_hait1 = 1

								IF NOT IS_CHAR_WANDER_PATH_CLEAR cop1_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 4.0  

									IF cop2_case3_follow_1sttime_hait1 = 0
										CHAR_FOLLOW_PATH cop1_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 0.1 RUN
										cop2_case3_follow_1sttime_hait1 = 1
									ENDIF 

									IF timer_cops_case3_act_hait1 = 2
										CHAR_FOLLOW_PATH cop1_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 0.1 RUN
									ENDIF

								ELSE
									SET_CHAR_RUNNING cop1_case3_hait1 TRUE 
									SET_CHAR_OBJ_RUN_TO_COORD cop1_case3_hait1 case3_x_hait1 case3_y_hait1
									flag_cop1_case3_location_hait1 = 3
								ENDIF

							ENDIF

							IF flag_cop1_case3_location_hait1 = 1 
								LOCATE_CHAR_ON_FOOT_3D cop1_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 1.0 1.0 1.0 FALSE
								flag_cop1_case3_location_hait1 = 2
							ENDIF	

							IF flag_cop1_case3_location_hait1 = 2
								SET_CHAR_RUNNING cop1_case3_hait1 TRUE 
								SET_CHAR_OBJ_RUN_TO_COORD cop1_case3_hait1 case3_x_hait1 case3_y_hait1
								flag_cop1_case3_location_hait1 = 3
							ENDIF
																					 
						ENDIF
						
						IF NOT IS_CHAR_DEAD cop1_case3_hait1
						
							IF flag_cop1_case3_location_hait1 = 3 
			
								IF LOCATE_CHAR_ON_FOOT_2D cop1_case3_hait1 case3_x_hait1 case3_y_hait1 1.5 1.5 FALSE
					    
									IF case3_collected_hait1 = 0
										REMOVE_BLIP radar_blip_case3_hait1
										CLEAR_ONSCREEN_TIMER timer_case3_hait1
										REMOVE_PICKUP case3_hait1
										ADD_BLIP_FOR_CHAR cop1_case3_hait1 blip_chase_cop1_case3_hait1 
										PRINT_NOW ( HAM1_7 ) 5000 1 //"Idiot! the cops have got our stash, retrieve it!
										flag_cop1_case3_got_stash_hait1 = 1
										flag_cops_got_case3_hait1 = 1
									ENDIF

								ENDIF

							ENDIF

						ENDIF

					ENDIF
								
				ELSE

					IF flag_cops_got_case3_hait1 = 0
						SET_CHAR_THREAT_SEARCH cop1_case3_hait1 THREAT_PLAYER1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_case3_hait1 player1
					ENDIF

				ENDIF

			ENDIF

		ENDIF
				
	ENDIF 

ENDIF

IF flag_cop2_case3_dead_hait1 = 0

	IF IS_CHAR_DEAD cop2_case3_hait1

		IF flag_cops_got_case3_hait1 = 1

			IF flag_cop2_case3_got_stash_hait1 = 1

				IF flag_cop2_case3_in_car_hait1 = 1
					flag_case3_destroyed_hait1 = 1	
				ELSE
				
					IF DOES_CHAR_EXIST cop2_case3_hait1 
			
						IF case3_created_again_hait1 = 0 
							REMOVE_BLIP blip_chase_cop2_case3_hait1
							GET_DEAD_CHAR_PICKUP_COORDS cop2_case3_hait1 case3_x_hait1 case3_y_hait1 case3_z_hait1
							CREATE_PICKUP briefcase PICKUP_ONCE case3_x_hait1 case3_y_hait1 case3_z_hait1 case3_hait1
							ADD_BLIP_FOR_PICKUP case3_hait1 radar_blip2_case3_hait1
							case3_created_again_hait1 = 1
						ENDIF

					ELSE
						flag_case3_destroyed_hait1 = 1
					ENDIF

				ENDIF

			ENDIF

		ENDIF
		
		flag_guards_case3_act_hait1 = 1
		flag_go_for_case3_hait1 = 1 
		flag_cop2_case3_dead_hait1 = 1
	ELSE
				
		GET_CHAR_HEALTH cop2_case3_hait1 cop2_case3_health_hait1

		IF flag_cops_got_case3_hait1 = 1
			GOSUB case3_chase_stuff_hait1
		ENDIF

		IF cop2_case3_health_hait1 <= 90 
			flag_guards_case3_act_hait1 = 1
			flag_go_for_case3_hait1 = 1
		ENDIF
				
		IF flag_guards_case3_act_hait1 = 1
		OR flag_go_for_case3_hait1 = 1
													
			IF case3_collected_hait1 = 0
												
				IF flag_cops_got_case3_hait1 = 0

					IF flag_go_for_case3_hait1 = 1

						IF flag_cop2_case3_location_hait1 = 0
							SET_CHAR_HEED_THREATS cop2_case3_hait1 FALSE
 							CLEAR_CHAR_THREAT_SEARCH cop2_case3_hait1
							SET_CHAR_OBJ_NO_OBJ cop2_case3_hait1
							PRINT_NOW ( HAM1_8 ) 5000 1 //"The cops are on the way to pick up the stash, get a move on!"
							CLEAR_ONSCREEN_TIMER timer_case3_hait1
							flag_cop2_case3_location_hait1 = 1
						ENDIF

						IF flag_cop2_case3_location_hait1 = 1

							IF NOT IS_CHAR_WANDER_PATH_CLEAR cop2_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 4.0 

								IF cop3_case3_follow_1sttime_hait1 = 0
									CHAR_FOLLOW_PATH cop2_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 0.1 RUN
									cop3_case3_follow_1sttime_hait1 = 1
								ENDIF	 
								
								IF timer_cops_case3_act_hait1 = 2
									CHAR_FOLLOW_PATH cop2_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 0.1 RUN
								ENDIF

							ELSE
								SET_CHAR_RUNNING cop2_case3_hait1 TRUE 
								SET_CHAR_OBJ_RUN_TO_COORD cop2_case3_hait1 case3_x_hait1 case3_y_hait1
								flag_cop2_case3_location_hait1 = 3
							ENDIF

						ENDIF

						IF flag_cop2_case3_location_hait1 = 1
							
							IF LOCATE_CHAR_ON_FOOT_3D cop2_case3_hait1 case3_x2_hait1 case3_y2_hait1 case3_z2_hait1 1.0 1.0 1.0 FALSE   
								flag_cop2_case3_location_hait1 = 2
							ENDIF

						ENDIF

						IF flag_cop2_case3_location_hait1 = 2 
							SET_CHAR_RUNNING cop2_case3_hait1 TRUE 
							SET_CHAR_OBJ_RUN_TO_COORD cop2_case3_hait1 case3_x_hait1 case3_y_hait1
							flag_cop2_case3_location_hait1 = 3
						ENDIF
																		
					ENDIF
					
					IF NOT IS_CHAR_DEAD cop2_case3_hait1

						IF flag_cop2_case3_location_hait1 = 3 
			
							IF LOCATE_CHAR_ON_FOOT_2D cop2_case3_hait1 case3_x_hait1 case3_y_hait1 1.5 1.5 FALSE
					    
								IF case3_collected_hait1 = 0
									REMOVE_BLIP radar_blip_case3_hait1
									CLEAR_ONSCREEN_TIMER timer_case3_hait1
									REMOVE_PICKUP case3_hait1
									ADD_BLIP_FOR_CHAR cop2_case3_hait1 blip_chase_cop2_case3_hait1 
									PRINT_NOW ( HAM1_7 ) 5000 1 //"Idiot! the cops have got our stash, retrieve it!
									flag_cop2_case3_got_stash_hait1 = 1
									flag_cops_got_case3_hait1 = 1
								ENDIF

							ENDIF

						ENDIF

					ENDIF

				ENDIF
								
			ELSE

				IF flag_cops_got_case3_hait1 = 0
					SET_CHAR_THREAT_SEARCH cop2_case3_hait1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_case3_hait1 player1
				ENDIF

			ENDIF

		ENDIF
								
	ENDIF 	

ENDIF

IF timer_cops_case3_act_hait1 = 2
	timer_cops_case3_act_hait1 = 0
ENDIF

RETURN

// If cops have got case bloke runs/drives away

case2_chase_stuff_hait1_hait1:

// cop2 case2

IF flag_cop2_case2_got_stash_hait1 = 1

	IF NOT IS_CHAR_DEAD cop2_case2_hait1
				
		IF flag_cop2_case2_in_car_hait1 = 0

			IF NOT IS_CHAR_IN_ANY_CAR cop2_case2_hait1

				IF IS_CHAR_ON_SCREEN cop2_case2_hait1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS cop2_case2_hait1 player1
				ELSE
					SET_CHAR_RUNNING cop2_case2_hait1 TRUE
					SET_CHAR_OBJ_STEAL_ANY_CAR cop2_case2_hait1
				ENDIF

			ENDIF
								
		ENDIF

		IF flag_cop2_case2_in_car_hait1 = 0
		
			IF IS_CHAR_IN_ANY_CAR cop2_case2_hait1	
			   	SET_CHAR_OBJ_NO_OBJ cop2_case2_hait1
				STORE_CAR_CHAR_IS_IN cop2_case2_hait1 car1_hait1
				ADD_STUCK_CAR_CHECK car1_hait1 0.5 1000
				ADD_UPSIDEDOWN_CAR_CHECK car1_hait1
				SET_CAR_CRUISE_SPEED car1_hait1 40.0
				SET_CAR_DRIVING_STYLE car1_hait1 2
				CAR_WANDER_RANDOMLY car1_hait1
				flag_cop2_case2_in_car_hait1 = 1
			ENDIF

		ENDIF

		IF flag_cop2_case2_in_car_hait1 = 1

			IF NOT IS_CAR_DEAD car1_hait1

				IF IS_CAR_STUCK_ON_ROOF car1_hait1
				OR IS_CAR_STUCK car1_hait1
					SET_CHAR_OBJ_LEAVE_CAR cop2_case2_hait1 car1_hait1
				ENDIF
		
			ENDIF

		ENDIF

		IF flag_cop2_case2_in_car_hait1 = 1
		
			IF NOT IS_CHAR_IN_ANY_CAR cop2_case2_hait1
				
				IF NOT IS_CAR_DEAD car1_hait1
					REMOVE_STUCK_CAR_CHECK car1_hait1
					REMOVE_UPSIDEDOWN_CAR_CHECK car1_hait1
					MARK_CAR_AS_NO_LONGER_NEEDED car1_hait1 
				ENDIF
				
		   		flag_cop2_case2_in_car_hait1 = 0
			ENDIF
			
		ENDIF	 

	ENDIF

ENDIF

// cop3 case2

IF flag_cop3_case2_got_stash_hait1 = 1

	IF NOT IS_CHAR_DEAD cop3_case2_hait1
				
		IF flag_cop3_case2_in_car_hait1 = 0

			IF NOT IS_CHAR_IN_ANY_CAR cop3_case2_hait1

				IF IS_CHAR_ON_SCREEN cop3_case2_hait1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS cop3_case2_hait1 player1
				ELSE
					SET_CHAR_RUNNING cop3_case2_hait1 TRUE
					SET_CHAR_OBJ_STEAL_ANY_CAR cop3_case2_hait1
				ENDIF

			ENDIF
								
		ENDIF

		IF flag_cop3_case2_in_car_hait1 = 0
		
			IF IS_CHAR_IN_ANY_CAR cop3_case2_hait1	
			   	SET_CHAR_OBJ_NO_OBJ cop3_case2_hait1
				STORE_CAR_CHAR_IS_IN cop3_case2_hait1 car2_hait1
				ADD_STUCK_CAR_CHECK car2_hait1 0.5 1000
				ADD_UPSIDEDOWN_CAR_CHECK car2_hait1
				SET_CAR_CRUISE_SPEED car2_hait1 40.0
				SET_CAR_DRIVING_STYLE car2_hait1 2
				CAR_WANDER_RANDOMLY car2_hait1
				flag_cop3_case2_in_car_hait1 = 1
			ENDIF

		ENDIF

		IF flag_cop3_case2_in_car_hait1 = 1

			IF NOT IS_CAR_DEAD car2_hait1

				IF IS_CAR_STUCK_ON_ROOF car2_hait1
				OR IS_CAR_STUCK car2_hait1
					SET_CHAR_OBJ_LEAVE_CAR cop3_case2_hait1 car2_hait1
				ENDIF
		
			ENDIF

		ENDIF

		IF flag_cop3_case2_in_car_hait1 = 1
		
			IF NOT IS_CHAR_IN_ANY_CAR cop3_case2_hait1

				IF NOT IS_CAR_DEAD car2_hait1
					REMOVE_STUCK_CAR_CHECK car2_hait1
					REMOVE_UPSIDEDOWN_CAR_CHECK car2_hait1
					MARK_CAR_AS_NO_LONGER_NEEDED car2_hait1 
				ENDIF

		   		flag_cop3_case2_in_car_hait1 = 0
			ENDIF
			
		ENDIF	 

	ENDIF

ENDIF

RETURN

// If cops have got case 3 

case3_chase_stuff_hait1:

// Cop1 case3

IF flag_cop1_case3_got_stash_hait1 = 1

	IF NOT IS_CHAR_DEAD cop1_case3_hait1
			
		IF flag_cop1_case3_in_car_hait1 = 0

			IF NOT IS_CHAR_IN_ANY_CAR cop1_case3_hait1

				IF IS_CHAR_ON_SCREEN cop1_case3_hait1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS cop1_case3_hait1 player1
				ELSE
					SET_CHAR_RUNNING cop1_case3_hait1 TRUE
					SET_CHAR_OBJ_STEAL_ANY_CAR cop1_case3_hait1
				ENDIF

			ENDIF
							
		ENDIF

		IF flag_cop1_case3_in_car_hait1 = 0
	
			IF IS_CHAR_IN_ANY_CAR cop1_case3_hait1	
		   		SET_CHAR_OBJ_NO_OBJ cop1_case3_hait1
				STORE_CAR_CHAR_IS_IN cop1_case3_hait1 car3_hait1
				ADD_STUCK_CAR_CHECK car3_hait1 0.5 1000
				ADD_UPSIDEDOWN_CAR_CHECK car3_hait1 
				SET_CAR_CRUISE_SPEED car3_hait1 40.0
				SET_CAR_DRIVING_STYLE car3_hait1 2
				CAR_WANDER_RANDOMLY car3_hait1
				flag_cop1_case3_in_car_hait1 = 1
			ENDIF

		ENDIF

		IF flag_cop1_case3_in_car_hait1 = 1

			IF NOT IS_CAR_DEAD car3_hait1

				IF IS_CAR_STUCK_ON_ROOF car3_hait1
				OR IS_CAR_STUCK car3_hait1
					SET_CHAR_OBJ_LEAVE_CAR cop1_case3_hait1 car3_hait1
				ENDIF
	
			ENDIF

		ENDIF

		IF flag_cop1_case3_in_car_hait1 = 1
		
			IF NOT IS_CHAR_IN_ANY_CAR cop1_case3_hait1

				IF NOT IS_CAR_DEAD car3_hait1
					REMOVE_STUCK_CAR_CHECK car3_hait1
					REMOVE_UPSIDEDOWN_CAR_CHECK car3_hait1
					MARK_CAR_AS_NO_LONGER_NEEDED car3_hait1 
				ENDIF
				 
				flag_cop1_case3_in_car_hait1 = 0
			ENDIF
			
		ENDIF	 

	ENDIF

ENDIF

// cop2 case 3

IF flag_cop2_case3_got_stash_hait1 = 1

	IF NOT IS_CHAR_DEAD cop2_case3_hait1
			
		IF flag_cop2_case3_in_car_hait1 = 0

			IF NOT IS_CHAR_IN_ANY_CAR cop2_case3_hait1

				IF IS_CHAR_ON_SCREEN cop2_case3_hait1
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS cop2_case3_hait1 player1
				ELSE
					SET_CHAR_RUNNING cop2_case3_hait1 TRUE
					SET_CHAR_OBJ_STEAL_ANY_CAR cop2_case3_hait1
				ENDIF

			ENDIF
							
		ENDIF

		IF flag_cop2_case3_in_car_hait1 = 0
	
			IF IS_CHAR_IN_ANY_CAR cop2_case3_hait1	
		   		SET_CHAR_OBJ_NO_OBJ cop2_case3_hait1
				STORE_CAR_CHAR_IS_IN cop2_case3_hait1 car4_hait1
				ADD_STUCK_CAR_CHECK car4_hait1 0.5 1000
				ADD_UPSIDEDOWN_CAR_CHECK car4_hait1
				SET_CAR_CRUISE_SPEED car4_hait1 40.0
				SET_CAR_DRIVING_STYLE car4_hait1 2
				CAR_WANDER_RANDOMLY car4_hait1
				flag_cop2_case3_in_car_hait1 = 1
			ENDIF

		ENDIF

		IF flag_cop2_case3_in_car_hait1 = 1

			IF NOT IS_CAR_DEAD car4_hait1

				IF IS_CAR_STUCK_ON_ROOF car4_hait1
				OR IS_CAR_STUCK car4_hait1
					SET_CHAR_OBJ_LEAVE_CAR cop2_case3_hait1 car4_hait1
				ENDIF
	
			ENDIF

		ENDIF

		IF flag_cop2_case3_in_car_hait1 = 1
		
			IF NOT IS_CHAR_IN_ANY_CAR cop2_case3_hait1

				IF NOT IS_CAR_DEAD car4_hait1
					REMOVE_STUCK_CAR_CHECK car4_hait1
					REMOVE_UPSIDEDOWN_CAR_CHECK car4_hait1
					MARK_CAR_AS_NO_LONGER_NEEDED car4_hait1
				ENDIF
				
				flag_cop2_case3_in_car_hait1 = 0
			ENDIF
			
		ENDIF	 

	ENDIF

ENDIF

RETURN

}

