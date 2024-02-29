MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************KENT PAUL 1*************************************  
// ****************************************RESCUE BUDDY*************************************\
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// Death Row
SCRIPT_NAME kent1

// Mission start stuff

GOSUB mission_start_kent1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_kent1_failed
ENDIF

GOSUB mission_cleanup_kent1

MISSION_END

{
 
// Variables for mission

// buddy

LVAR_INT buddy_kent1

LVAR_INT buddys_health_kent1

LVAR_INT flag_buddy_home_kent1

LVAR_INT flag_buddy_dead_kent1

LVAR_INT flag_buddy_in_group_kent1  // used to tell me wheater the buddy is in the players group or not

VAR_INT buddy_life_guage_kent1

LVAR_INT radar_blip_buddy_kent1

LVAR_FLOAT buddy_x_kent1

LVAR_FLOAT buddy_y_kent1

LVAR_FLOAT buddy_z_kent1

LVAR_FLOAT buddy_heading_kent1

LVAR_INT flag_buddy_vulnerable_kent1

LVAR_INT flag_buddy_joined_player // used to tell me that the buddy has been added to the players group for the first time

LVAR_INT flag_had_buddy_message_kent1

VAR_INT flag_player_been_spotted_kent1

// executioner

VAR_INT executioner_kent1

VAR_FLOAT executioner_x_kent1

VAR_FLOAT executioner_y_kent1

VAR_FLOAT executioner_z_kent1

VAR_INT flag_executioner_dead_kent1

VAR_INT flag_executioner_chase_kent1 // Tells him to move and chase player

// Guard1

VAR_INT guard1_kent1

VAR_INT flag_guard1_dead_kent1

//VAR_INT flag_guard1_chase_kent1

VAR_FLOAT guard1_x_kent1

VAR_FLOAT guard1_y_kent1

VAR_FLOAT guard1_z_kent1

VAR_FLOAT route0_point1_x_kent1

VAR_FLOAT route0_point1_y_kent1

VAR_FLOAT route0_point1_z_kent1

VAR_FLOAT route0_point2_x_kent1

VAR_FLOAT route0_point2_y_kent1

VAR_FLOAT route0_point2_z_kent1

VAR_FLOAT route0_point3_x_kent1

VAR_FLOAT route0_point3_y_kent1

VAR_FLOAT route0_point3_z_kent1

VAR_FLOAT route0_point4_x_kent1

VAR_FLOAT route0_point4_y_kent1

VAR_FLOAT route0_point4_z_kent1

// Guard2

VAR_INT guard2_kent1

VAR_INT flag_guard2_dead_kent1

VAR_INT flag_guard2_chase_kent1

VAR_FLOAT guard2_x_kent1

VAR_FLOAT guard2_y_kent1

VAR_FLOAT guard2_z_kent1

VAR_FLOAT guard2_heading_kent1

// Guard3

VAR_INT guard3_kent1

VAR_INT flag_guard3_dead_kent1

VAR_INT flag_guard3_chase_kent1
			  
VAR_FLOAT guard3_x_kent1

VAR_FLOAT guard3_y_kent1

VAR_FLOAT guard3_z_kent1

VAR_FLOAT guard3_heading_kent1

// Guard4

VAR_INT guard4_kent1

VAR_INT flag_guard4_dead_kent1

VAR_INT flag_guard4_chase_kent1

VAR_FLOAT guard4_x_kent1

VAR_FLOAT guard4_y_kent1

VAR_FLOAT guard4_z_kent1

VAR_FLOAT route1_point1_x_kent1

VAR_FLOAT route1_point1_y_kent1

VAR_FLOAT route1_point1_z_kent1

VAR_FLOAT route1_point2_x_kent1

VAR_FLOAT route1_point2_y_kent1

VAR_FLOAT route1_point2_z_kent1

VAR_FLOAT route1_point3_x_kent1

VAR_FLOAT route1_point3_y_kent1

VAR_FLOAT route1_point3_z_kent1

VAR_FLOAT route1_point4_x_kent1

VAR_FLOAT route1_point4_y_kent1

VAR_FLOAT route1_point4_z_kent1

VAR_FLOAT route1_point5_x_kent1

VAR_FLOAT route1_point5_y_kent1

VAR_FLOAT route1_point5_z_kent1

VAR_FLOAT route1_point6_x_kent1

VAR_FLOAT route1_point6_y_kent1
					   
VAR_FLOAT route1_point6_z_kent1

VAR_FLOAT route1_point7_x_kent1

VAR_FLOAT route1_point7_y_kent1

VAR_FLOAT route1_point7_z_kent1

VAR_FLOAT route1_point8_x_kent1

VAR_FLOAT route1_point8_y_kent1

VAR_FLOAT route1_point8_z_kent1

// Guard6

VAR_INT guard6_kent1

VAR_INT flag_guard6_dead_kent1

VAR_INT flag_guard6_chase_kent1

VAR_FLOAT guard6_x_kent1

VAR_FLOAT guard6_y_kent1

VAR_FLOAT guard6_z_kent1

VAR_FLOAT route2_point1_x_kent1

VAR_FLOAT route2_point1_y_kent1

VAR_FLOAT route2_point1_z_kent1

VAR_FLOAT route2_point2_x_kent1

VAR_FLOAT route2_point2_y_kent1

VAR_FLOAT route2_point2_z_kent1

VAR_FLOAT route2_point3_x_kent1

VAR_FLOAT route2_point3_y_kent1

VAR_FLOAT route2_point3_z_kent1

// Guard7

VAR_INT guard7_kent1

VAR_INT flag_guard7_dead_kent1

// Guard8

VAR_INT guard8_kent1

VAR_INT flag_guard8_dead_kent1

VAR_INT flag_guard8_chase_kent1

// Guard9

VAR_INT guard9_kent1

VAR_INT flag_guard9_dead_kent1

VAR_INT flag_guard9_chase_kent1

// Guard10

VAR_INT guard10_kent1

VAR_INT flag_guard10_dead_kent1

VAR_INT flag_guard10_chase_kent1

// Guard11

VAR_INT guard11_kent1

VAR_INT flag_guard11_dead_kent1

VAR_INT flag_guard11_chase_kent1

// Guard12

VAR_INT guard12_kent1

VAR_INT flag_guard12_dead_kent1

VAR_INT flag_guard12_chase_kent1

// Second wave of guards

// Guard13

VAR_INT guard13_kent1

VAR_INT flag_guard13_dead_kent1

// Guard 14

VAR_INT guard14_kent1

VAR_INT flag_guard14_dead_kent1

// Guard 15

VAR_INT guard15_kent1

VAR_INT flag_guard15_dead_kent1

// guard16

VAR_INT guard16_kent1

VAR_INT flag_guard16_dead_kent1

// general

VAR_INT radar_blip_coord1_kent1

VAR_FLOAT home_x_kent1 // Location to take Lance to

VAR_FLOAT home_y_kent1 // Location to take Lance to

VAR_FLOAT home_z_kent1 // Location to take Lance to

// Ambush patrol stuff

VAR_INT flag_create_2nd_guards_kent1

VAR_INT flag_created_ambush_kent1


VAR_INT ambush_guard3_kent1

VAR_INT flag_ambush_guard3_dead_kent1

VAR_INT ambush_guard3_do_stuff_kent1

VAR_INT ambush_guard4_kent1

VAR_INT flag_ambush_guard4_dead_kent1

VAR_INT ambush_guard4_do_stuff_kent1

// Dummy stuff before I create teh characters

VAR_INT car2_kent1  // Car parked beside the shed

VAR_INT car3_kent1 // Car for ambush goons to drive

VAR_INT car4_kent1

VAR_INT car5_kent1

VAR_INT car6_kent1

VAR_INT ambush_guard5_kent1 

VAR_INT flag_ambush_guard5_dead_kent1

VAR_INT ambush_guard5_do_stuff_kent1

VAR_INT ambush_guard6_kent1

VAR_INT flag_ambush_guard6_dead_kent1

VAR_INT ambush_guard6_do_stuff_kent1

// World collision stuff

VAR_INT flag_executioner_got_AI_kent1

VAR_INT flag_buddy_got_AI_kent1

VAR_INT flag_guard1_got_AI_kent1

VAR_INT flag_guard2_got_AI_kent1

VAR_INT flag_guard3_got_AI_kent1

VAR_INT flag_guard4_got_AI_kent1

//VAR_INT flag_guard5_got_AI_kent1

VAR_INT flag_guard6_got_AI_kent1

VAR_INT flag_guard7_got_AI_kent1

VAR_INT flag_guard8_got_AI_kent1

VAR_INT flag_guard9_got_AI_kent1

VAR_INT flag_guard10_got_AI_kent1

VAR_INT flag_guard11_got_AI_kent1

VAR_INT flag_guard12_got_AI_kent1

VAR_INT counter_guards_got_AI_kent1

// mini cutscene stuff

VAR_INT flag_player_audio_kent1

VAR_INT flag_buddy_free_kent1

VAR_INT flag_mini_cut1_over_kent1

VAR_INT buddy_car_kent1 // If buddy is in a car at the end of the mission

VAR_INT car7_kent1

VAR_INT flag_ambush_guard3_in_car_kent1

VAR_INT flag_ambush_guard4_in_car_kent1

VAR_INT flag_ambush_guard5_in_car_kent1

VAR_INT flag_ambush_guard6_in_car_kent1

// Stores players weapons for scripted cutscene

VAR_INT stored_current_weapon_kent1

// Used to help game

VAR_INT guard3_car_mission_kent1

VAR_INT guard4_car_mission_kent1

VAR_INT guard5_car_mission_kent1

VAR_INT guard6_car_mission_kent1

// chase message stuff

VAR_INT chase_message_kent1

// Frame counter to make guards do stuff

VAR_INT frame_counter_kent1

// New blip stuff for leading the player into the scrap yeard

VAR_INT radar_blip_cheat_kent1

VAR_INT flag_cheat_blip_on_kent1

// Car warping stuff

VAR_FLOAT car3_x_kent1 car3_y_kent1 car3_z_kent1

VAR_FLOAT abguard3_x_kent1 abguard3_y_kent1 abguard3_z_kent1

VAR_FLOAT car4_x_kent1 car4_y_kent1 car4_z_kent1

VAR_FLOAT abguard4_x_kent1 abguard4_y_kent1 abguard4_z_kent1

VAR_FLOAT car5_x_kent1 car5_y_kent1	car5_z_kent1

VAR_FLOAT abguard5_x_kent1 abguard5_y_kent1 abguard5_z_kent1 

VAR_FLOAT car6_x_kent1 car6_y_kent1 car6_z_kent1

VAR_FLOAT abguard6_x_kent1 abguard6_y_kent1 abguard6_z_kent1

// second wave counter

VAR_INT counter_no_of_guys_dead_kent1

VAR_INT flag_second_wave_created_kent1

// ****************************************Mission Start************************************

mission_start_kent1:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

// player

player_x = 0.0

player_y = 0.0

player_z = 0.0

// buddy

flag_had_buddy_message_kent1 = 0

flag_player_been_spotted_kent1 = 0

flag_buddy_joined_player = 0

flag_buddy_vulnerable_kent1 = 0

flag_buddy_home_kent1 = 0

flag_buddy_dead_kent1 = 0

flag_buddy_in_group_kent1 = 0

//buddy_x_kent1 = -1310.294 

//buddy_y_kent1 = 165.730 

//buddy_z_kent1 = 10.59

buddy_x_kent1 = -1310.325 

buddy_y_kent1 = 165.808 

buddy_z_kent1 = 10.59

buddy_heading_kent1 = 280.723

buddy_life_guage_kent1 = 100

buddys_health_kent1 = 100

// executioner

executioner_x_kent1 = -1308.510

executioner_y_kent1 = 162.002

executioner_z_kent1 = 10.56

flag_executioner_dead_kent1 = 0

flag_executioner_chase_kent1 = 0
				
// Guard1

flag_guard1_dead_kent1 = 0

//flag_guard1_chase_kent1 = 0

guard1_x_kent1 = -1256.36

guard1_y_kent1 = 2.86

guard1_z_kent1 = 10.45

route0_point1_x_kent1 = -1255.89   

route0_point1_y_kent1 = 12.26

route0_point1_z_kent1 = 10.45

route0_point2_x_kent1 = -1255.72 

route0_point2_y_kent1 = 19.11

route0_point2_z_kent1 =	10.45

route0_point3_x_kent1 = -1255.89   

route0_point3_y_kent1 =	12.26

route0_point3_z_kent1 = 10.45

route0_point4_x_kent1 = -1256.36   

route0_point4_y_kent1 = 2.86

route0_point4_z_kent1 = 10.45

// Guard2

flag_guard2_dead_kent1 = 0

flag_guard2_chase_kent1 = 0

guard2_heading_kent1 = 180.0

guard2_x_kent1 = -1310.29

guard2_y_kent1 = 155.36

guard2_z_kent1 = 10.56

// Guard3

flag_guard3_dead_kent1 = 0

flag_guard3_chase_kent1 = 0

guard3_heading_kent1 = 180.0 

guard3_x_kent1 = -1303.69

guard3_y_kent1 = 155.36

guard3_z_kent1 = 10.56

// Guard4

flag_guard4_dead_kent1 = 0

flag_guard4_chase_kent1 = 0

guard4_x_kent1 = -1259.00

guard4_y_kent1 = 104.09

guard4_z_kent1 = 10.45

route1_point1_x_kent1 = -1260.03  

route1_point1_y_kent1 = 95.52

route1_point1_z_kent1 = 10.45

route1_point2_x_kent1 = -1260.07   

route1_point2_y_kent1 = 80.40

route1_point2_z_kent1 = 10.45

route1_point3_x_kent1 = -1259.79   

route1_point3_y_kent1 = 60.42

route1_point3_z_kent1 = 10.26

route1_point4_x_kent1 = -1259.66   

route1_point4_y_kent1 = 49.85

route1_point4_z_kent1 = 10.21

route1_point5_x_kent1 = -1259.79   

route1_point5_y_kent1 = 60.42

route1_point5_z_kent1 = 10.26

route1_point6_x_kent1 = -1260.07   

route1_point6_y_kent1 = 80.40

route1_point6_z_kent1 = 10.45

route1_point7_x_kent1 = -1260.03   

route1_point7_y_kent1 = 95.52
					    
route1_point7_z_kent1 = 10.45 

route1_point8_x_kent1 = -1259.00  

route1_point8_y_kent1 = 104.09 

route1_point8_z_kent1 = 10.45 

// guard 6

flag_guard6_dead_kent1 = 0

flag_guard6_chase_kent1 = 0

guard6_x_kent1 = -1302.17

guard6_y_kent1 = 82.09

guard6_z_kent1 = 10.46

route2_point1_x_kent1 = -1303.89

route2_point1_y_kent1 = 75.11

route2_point1_z_kent1 = 10.46

route2_point2_x_kent1 = -1306.49

route2_point2_y_kent1 = 61.84

route2_point2_z_kent1 = 10.46

route2_point3_x_kent1 = -1302.17 

route2_point3_y_kent1 = 82.09

route2_point3_z_kent1 = 10.46

// Guard 7

flag_guard7_dead_kent1 = 0 

// Guard 8

flag_guard8_dead_kent1 = 0

flag_guard8_chase_kent1 = 0 

// Guard 9

flag_guard9_dead_kent1 = 0

flag_guard9_chase_kent1 = 0

// guard10 

flag_guard10_dead_kent1 = 0

flag_guard10_chase_kent1 = 0

// guard11

flag_guard11_dead_kent1 = 0

flag_guard11_chase_kent1 = 0

// guard12

flag_guard12_dead_kent1 = 0

flag_guard12_chase_kent1 = 0

// guard13

flag_guard13_dead_kent1 = 0

// guard14

flag_guard14_dead_kent1 = 0

// guard15

flag_guard15_dead_kent1 = 0

// guard16

flag_guard16_dead_kent1 = 0

// general

home_x_kent1 = -823.450  // Location to take Lance to Hospital

home_y_kent1 = 1162.130 // Location to take Lance to Hospital

home_z_kent1 = 10.06 // Location to take Lance to Hospital

// Ambush patrol stuff

flag_create_2nd_guards_kent1 = 0

flag_created_ambush_kent1 = 0

flag_ambush_guard3_dead_kent1 = 0

ambush_guard3_do_stuff_kent1 = 0

flag_ambush_guard4_dead_kent1 = 0

ambush_guard4_do_stuff_kent1 = 0

flag_ambush_guard5_dead_kent1 = 0

ambush_guard5_do_stuff_kent1 = 0

flag_ambush_guard6_dead_kent1 = 0

ambush_guard6_do_stuff_kent1 = 0

// world collison stuff

flag_executioner_got_AI_kent1 = 0

flag_buddy_got_AI_kent1 = 0

flag_guard1_got_AI_kent1 = 0

flag_guard2_got_AI_kent1 = 0

flag_guard3_got_AI_kent1 = 0

flag_guard4_got_AI_kent1 = 0

flag_guard6_got_AI_kent1 = 0

flag_guard7_got_AI_kent1 = 0

flag_guard8_got_AI_kent1 = 0

flag_guard9_got_AI_kent1 = 0

flag_guard10_got_AI_kent1 = 0

flag_guard11_got_AI_kent1 = 0

flag_guard12_got_AI_kent1 = 0

counter_guards_got_AI_kent1 = 0

// mini cutscene stuff

flag_player_audio_kent1 = 0

flag_buddy_free_kent1 = 0

flag_mini_cut1_over_kent1 = 0

flag_ambush_guard3_in_car_kent1 = 0

flag_ambush_guard4_in_car_kent1 = 0

flag_ambush_guard5_in_car_kent1 = 0

flag_ambush_guard6_in_car_kent1 = 0

stored_current_weapon_kent1 = 0

// stuff to help compiler

guard3_car_mission_kent1 = 0

guard4_car_mission_kent1 = 0

guard5_car_mission_kent1 = 0

guard6_car_mission_kent1 = 0

// chase message stuff

chase_message_kent1 = 0

// Frame counter to make guards do stuff

frame_counter_kent1 = 0

flag_cheat_blip_on_kent1 = 0

// New warping car stuff

car3_x_kent1 = 0.0

car3_y_kent1 = 0.0

car3_z_kent1 = 0.0

abguard3_x_kent1 = 0.0

abguard3_y_kent1 = 0.0 

abguard3_z_kent1 = 0.0

car4_x_kent1 = 0.0

car4_y_kent1 = 0.0

car4_z_kent1 = 0.0

abguard4_x_kent1 = 0.0

abguard4_y_kent1 = 0.0 

abguard4_z_kent1 = 0.0

car5_x_kent1 = 0.0

car5_y_kent1 = 0.0

car5_z_kent1 = 0.0

abguard5_x_kent1 = 0.0

abguard5_y_kent1 = 0.0 

abguard5_z_kent1 = 0.0

car6_x_kent1 = 0.0

car6_y_kent1 = 0.0

car6_z_kent1 = 0.0

abguard6_x_kent1 = 0.0

abguard6_y_kent1 = 0.0 

abguard6_z_kent1 = 0.0

// second wave counter

counter_no_of_guys_dead_kent1 = 0

flag_second_wave_created_kent1 = 0

WAIT 0

LOAD_MISSION_TEXT KENT1

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 512.591 -74.900 9.573 189.24

// ****************************************START OF CUTSCENE********************************

flag_malibu_doors_closed = 1
 
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSkent

SET_EXTRA_COLOURS 1 FALSE

SET_AREA_VISIBLE VIS_MALIBU_CLUB

LOAD_SCENE 476.12 -63.377 10.0

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2

	WAIT 0

ENDWHILE

LOAD_CUTSCENE resc_1a

SET_CUTSCENE_OFFSET 477.687 -58.001 8.943
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kent
SET_CUTSCENE_ANIM cs_kent CSkent

CLEAR_AREA 495.74 -82.79 9.03 1.0 TRUE
SET_PLAYER_COORDINATES player1 495.74 -82.79 9.03
SET_PLAYER_HEADING player1 211.20

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 798
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_A ) 10000 1 //"Awright mush, I'm gonna save your Vera, mate."

WHILE cs_time < 3079 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_B ) 10000 1 //"What the hell are you on about?"

WHILE cs_time < 4603 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_C ) 10000 1 //"You know that wanker Diaz, the Bugle Master."

WHILE cs_time < 6776
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_D ) 10000 1 //"He's got your boy, Lance. Word is your mate tried to jump him.."

WHILE cs_time < 9460
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_E ) 10000 1 //"didn't jump high enough if you know what I mean.."

WHILE cs_time < 11736 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_F ) 10000 1 //"Where'd he take him? In plain English?"

WHILE cs_time < 14992 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_G ) 10000 1 //"Keep your barnet on! They got him across town at the junkyard."

WHILE cs_time < 20583 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( KPM1_H ) 10000 1 //"Bloody hell....Nutter"

WHILE cs_time < 22880
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 23352
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

CLEAR_EXTRA_COLOURS 0

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE 495.74 -82.79 9.03

flag_malibu_doors_closed = 0

flag_player_in_malibu = 0

SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000

// ******************************************END OF CUTSCENE********************************

// fades the screen in

ADD_BLIP_FOR_COORD_OLD -1219.969 8.543 10.44 GREEN BOTH radar_blip_cheat_kent1

CHANGE_BLIP_SCALE radar_blip_cheat_kent1 3 

flag_cheat_blip_on_kent1 = 1

// waiting for the player to get the buddy back home 

DISPLAY_ONSCREEN_COUNTER_WITH_STRING buddy_life_guage_kent1 COUNTER_DISPLAY_BAR ( KPM1_3 )

PRINT_NOW ( KPM1_1 ) 7000 1 //"Lance has been kidnapped and is being held at the junk yard, Go and rescue him!"

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

// Requests the models

REQUEST_MODEL CLa // Diaz guards
REQUEST_MODEL CLb // Diaz guards
REQUEST_MODEL UZI
REQUEST_MODEL SENTINEL
REQUEST_MODEL COMET
REQUEST_MODEL RUGER

REQUEST_ANIMATION LANCE

LOAD_SPECIAL_CHARACTER 3 IGBUDY3 // FIXMIAMI: replace normal model with beat up model
 
WHILE NOT HAS_MODEL_LOADED CLa
OR NOT HAS_MODEL_LOADED CLb
OR NOT HAS_MODEL_LOADED UZI
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED SENTINEL
OR NOT HAS_MODEL_LOADED COMET

	WAIT 0

ENDWHILE

WHILE NOT HAS_ANIMATION_LOADED LANCE
OR NOT HAS_MODEL_LOADED RUGER

	WAIT 0

ENDWHILE

CREATE_CAR COMET -1066.072 -55.111 10.262 car3_kent1
DELETE_CAR car3_kent1
CREATE_CAR COMET -1066.714 -28.923 10.246 car4_kent1
DELETE_CAR car4_kent1
CREATE_CAR COMET -1073.399 77.886 10.239 car5_kent1
DELETE_CAR car5_kent1
CREATE_CAR COMET -1072.822 41.816 10.270 car6_kent1
DELETE_CAR car6_kent1

// this should load the collision and map before they get there

// car by the shed

CREATE_CAR SENTINEL -1292.08 155.609 10.45 car7_kent1
SET_CAR_HEADING car7_kent1 176.706

// Creates the mission characters

CREATE_CAR SENTINEL -1240.28 7.5 10.46 car2_kent1

SET_CAR_HEADING car2_kent1 180.0 

// buddy

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 buddy_x_kent1 buddy_y_kent1 buddy_z_kent1 buddy_kent1

SET_CHAR_SUFFERS_CRITICAL_HITS buddy_kent1 FALSE

CLEAR_CHAR_THREAT_SEARCH buddy_kent1

SET_CHAR_AS_PLAYER_FRIEND buddy_kent1 player1 TRUE

SET_CHAR_NEVER_TARGETTED buddy_kent1 TRUE 

SET_CHAR_HEADING buddy_kent1 285.31
 
// creates the executioner

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa executioner_x_kent1 executioner_y_kent1 executioner_z_kent1 executioner_kent1

CLEAR_CHAR_THREAT_SEARCH executioner_kent1

SET_CHAR_MONEY executioner_kent1 200   

// creates guard one, follows route 0 walks at the front gate

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa guard1_x_kent1 guard1_y_kent1 guard1_z_kent1 guard1_kent1

CLEAR_CHAR_THREAT_SEARCH guard1_kent1

SET_CHAR_MONEY guard1_kent1 200

// Creates guard 2 does not patrol left hand side of shed that Lance is held in

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa guard2_x_kent1 guard2_y_kent1 guard2_z_kent1 guard2_kent1

CLEAR_CHAR_THREAT_SEARCH guard2_kent1

SET_CHAR_MONEY guard2_kent1 200

// Creates guard3 does not patrol right hand side of shed that Lance is held in

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa guard3_x_kent1 guard3_y_kent1 guard3_z_kent1 guard3_kent1

CLEAR_CHAR_THREAT_SEARCH guard3_kent1

SET_CHAR_MONEY guard3_kent1 200

// Creates guard4 follows partol route 1 walks beside the gate on left hand side

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa guard4_x_kent1 guard4_y_kent1 guard4_z_kent1 guard4_kent1

CLEAR_CHAR_THREAT_SEARCH guard4_kent1

SET_CHAR_MONEY guard4_kent1 200

// Guard 6 on right hand side patrols along by burnt out tanker follow route 2

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa guard6_x_kent1 guard6_y_kent1 guard6_z_kent1 guard6_kent1

CLEAR_CHAR_THREAT_SEARCH guard6_kent1

SET_CHAR_MONEY guard6_kent1 200

// Guard7 stands on top of digger

CREATE_CHAR PEDTYPE_CIVMALE CLa -1293.67 142.31 16.94 guard7_kent1

CLEAR_CHAR_THREAT_SEARCH guard7_kent1

SET_CHAR_MONEY guard7_kent1 200

// Guard8 stands by car at start

CREATE_CHAR PEDTYPE_CIVMALE CLa -1243.05 10.00 10.46 guard8_kent1

CLEAR_CHAR_THREAT_SEARCH guard8_kent1

SET_CHAR_MONEY guard8_kent1 200

// Guard9 stands by car at start

CREATE_CHAR PEDTYPE_CIVMALE CLa -1242.57 4.5 10.45 guard9_kent1

CLEAR_CHAR_THREAT_SEARCH guard9_kent1

SET_CHAR_MONEY guard9_kent1 200

// Guard10

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa -1252.871 42.226 12.313 guard10_kent1

CLEAR_CHAR_THREAT_SEARCH guard10_kent1

SET_CHAR_MONEY guard10_kent1 200

// guard11

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa -1257.927 79.620 10.45 guard11_kent1

CLEAR_CHAR_THREAT_SEARCH guard11_kent1

SET_CHAR_MONEY guard11_kent1 200

// guard12

CREATE_CHAR PEDTYPE_GANG_DIAZ CLa -1257.345 85.370 10.45 guard12_kent1

CLEAR_CHAR_THREAT_SEARCH guard12_kent1

SET_CHAR_MONEY guard12_kent1 200

blob_flag = 0

timera = 0

WHILE flag_buddy_home_kent1 = 0

	WAIT 0

	IF IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE

		IF flag_buddy_joined_player = 0 
	 		CLEAR_WANTED_LEVEL player1
		ENDIF

	ENDIF
	
	IF counter_no_of_guys_dead_kent1 >= 4

		IF flag_second_wave_created_kent1 = 0

			IF IS_PLAYER_IN_AREA_3D player1 -1236.888 15.474 8.0 -1288.145 122.990 20.0 FALSE
			OR IS_PLAYER_IN_AREA_3D player1 -1301.625 59.126 8.0 -1236.840 15.482 20.0 FALSE
			 
				CREATE_CHAR PEDTYPE_GANG_DIAZ CLa -1307.682 147.943 10.45 guard13_kent1
				CLEAR_CHAR_THREAT_SEARCH guard13_kent1
				SET_CHAR_PERSONALITY guard13_kent1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH guard13_kent1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR guard13_kent1 WEAPONTYPE_UZI 30000 // Infinate ammo
				//SET_CHAR_ACCURACY guard13_kent1 90
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard13_kent1 player1
				
				CREATE_CHAR PEDTYPE_GANG_DIAZ CLb -1305.706 149.732 10.44 guard14_kent1
				CLEAR_CHAR_THREAT_SEARCH guard14_kent1
				SET_CHAR_PERSONALITY guard14_kent1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH guard14_kent1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR guard14_kent1 WEAPONTYPE_UZI 30000 // Infinate ammo
				//SET_CHAR_ACCURACY guard14_kent1 90
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard14_kent1 player1

				CREATE_CHAR PEDTYPE_GANG_DIAZ CLa -1305.314 145.067 10.45 guard15_kent1
				CLEAR_CHAR_THREAT_SEARCH guard15_kent1
				SET_CHAR_PERSONALITY guard15_kent1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH guard15_kent1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR guard15_kent1 WEAPONTYPE_UZI 30000 // Infinate ammo
				//SET_CHAR_ACCURACY guard15_kent1 90
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard15_kent1 player1

				CREATE_CHAR PEDTYPE_GANG_DIAZ CLb -1302.267 146.640 10.45 guard16_kent1
				CLEAR_CHAR_THREAT_SEARCH guard16_kent1
				SET_CHAR_PERSONALITY guard16_kent1 PEDSTAT_TOUGH_GUY
				SET_CHAR_THREAT_SEARCH guard16_kent1 THREAT_PLAYER1
				GIVE_WEAPON_TO_CHAR guard16_kent1 WEAPONTYPE_UZI 30000 // Infinate ammo
				//SET_CHAR_ACCURACY guard16_kent1 90
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard16_kent1 player1
				 
				flag_second_wave_created_kent1 = 1
			ENDIF
			
		ENDIF

	ENDIF

	IF flag_cheat_blip_on_kent1 = 1

		//IF IS_PLAYER_IN_AREA_2D player1 -1236.843 -0.4 -1205.935 22.025 FALSE
		IF IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
		OR flag_player_been_spotted_kent1 = 1
						
			IF NOT IS_CHAR_DEAD buddy_kent1
				REMOVE_BLIP radar_blip_cheat_kent1
				ADD_BLIP_FOR_CHAR buddy_kent1 radar_blip_buddy_kent1 
				flag_cheat_blip_on_kent1 = 0
			ELSE
				REMOVE_BLIP radar_blip_buddy_kent1
				CLEAR_MISSION_AUDIO 1
				CLEAR_MISSION_AUDIO 2
				CLEAR_PRINTS
				PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
				GOTO mission_kent1_failed
				flag_buddy_dead_kent1 = 1
			ENDIF
			
		ENDIF
		
	ENDIF
	
	IF counter_guards_got_AI_kent1 < 13
		GOSUB guard_AI_kent1
	ELSE

		++ frame_counter_kent1

		IF flag_second_wave_created_kent1 = 1

			IF frame_counter_kent1 > 270
				frame_counter_kent1 = 0
			ENDIF

		ELSE
		
			IF frame_counter_kent1 > 150
				frame_counter_kent1 = 0
			ENDIF

		ENDIF

		GET_PLAYER_COORDINATES player1 player_x player_y player_z

		GOSUB guard_death_check_kent1

	ENDIF
			
	IF flag_buddy_dead_kent1 = 0

		IF IS_CHAR_DEAD buddy_kent1
	   
			REMOVE_BLIP radar_blip_buddy_kent1
			CLEAR_MISSION_AUDIO 1
			CLEAR_MISSION_AUDIO 2
			CLEAR_PRINTS
			PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
			GOTO mission_kent1_failed
			flag_buddy_dead_kent1 = 1
		ELSE

			IF flag_buddy_free_kent1 = 0
				//SET_CHAR_WAIT_STATE buddy_kent1 34 10000
				SET_CHAR_HEALTH buddy_kent1 buddy_life_guage_kent1
			ENDIF

			GET_CHAR_HEALTH buddy_kent1 buddys_health_kent1
				  
									
			IF flag_create_2nd_guards_kent1 = 0

				IF NOT IS_CHAR_IN_AREA_2D buddy_kent1 -1234.15 -1.0 -1367.51 250.33 FALSE
					MARK_CHAR_AS_NO_LONGER_NEEDED executioner_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard1_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard2_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard3_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard4_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard6_kent1 
					MARK_CHAR_AS_NO_LONGER_NEEDED guard7_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard8_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard9_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard10_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard11_kent1
					MARK_CHAR_AS_NO_LONGER_NEEDED guard12_kent1
					flag_create_2nd_guards_kent1 = 1
				ENDIF
				
			ENDIF	 
															
			IF flag_buddy_joined_player = 1

				GOSUB buddy_group_checks_kent1

				IF LOCATE_STOPPED_CHAR_ANY_MEANS_3D buddy_kent1 home_x_kent1 home_y_kent1 home_z_kent1 3.0 3.0 3.0 blob_flag
					flag_buddy_home_kent1 = 1
				ENDIF
				
			ENDIF 

			IF flag_buddy_vulnerable_kent1 = 0
			
				IF flag_buddy_joined_player = 1
					
					IF NOT IS_CHAR_DEAD buddy_kent1 
						SET_CHAR_ONLY_DAMAGED_BY_PLAYER buddy_kent1 FALSE 
				   		FREEZE_CHAR_POSITION buddy_kent1 FALSE
						SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_FALSE 1
				   		flag_buddy_vulnerable_kent1 = 1
					ELSE
						REMOVE_BLIP radar_blip_buddy_kent1
						CLEAR_MISSION_AUDIO 1
						CLEAR_MISSION_AUDIO 2
						CLEAR_PRINTS
						PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
						GOTO mission_kent1_failed
						flag_buddy_dead_kent1 = 1
					ENDIF

				ENDIF
				
			ENDIF

			IF flag_executioner_dead_kent1 = 1
					   
				IF flag_buddy_joined_player = 0
				
					IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 buddy_x_kent1 buddy_y_kent1 buddy_z_kent1 2.0 2.0 4.0 FALSE

						flag_buddy_free_kent1 = 1
							
						IF flag_mini_cut1_over_kent1 = 0
							
							REMOVE_BLIP radar_blip_cheat_kent1
							SWITCH_WIDESCREEN ON
							SET_PLAYER_CONTROL player1 OFF
							SET_EVERYONE_IGNORE_PLAYER player1 ON
							SET_POLICE_IGNORE_PLAYER player1 ON
							GET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_kent1
							SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED 

							CLEAR_AREA -1312.775 170.233 12.036 1.0 FALSE 
							SET_FIXED_CAMERA_POSITION -1312.775 170.233 12.036 0.0 0.0 0.0
							POINT_CAMERA_AT_POINT -1312.312 169.349 11.982 JUMP_CUT

							IF NOT IS_CHAR_DEAD buddy_kent1
								
							
								buddys_health_kent1 = buddy_life_guage_kent1 
													
								SET_CHAR_HEALTH buddy_kent1 buddys_health_kent1 
								
								SET_CHAR_STAY_IN_SAME_PLACE buddy_kent1 FALSE
								FREEZE_CHAR_POSITION buddy_kent1 FALSE
								SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_FALSE 1 
								TURN_CHAR_TO_FACE_CHAR scplayer buddy_kent1
								TURN_CHAR_TO_FACE_CHAR buddy_kent1 scplayer 
								flag_mini_cut1_over_kent1 = 1

							ENDIF
								
						ENDIF
							
						IF flag_mini_cut1_over_kent1 = 1 
							
							IF flag_player_audio_kent1 = 0
								LOAD_MISSION_AUDIO 1 ( RESC_4 ) //careful planning
								LOAD_MISSION_AUDIO 2 ( RESC_5 ) //killed my brother
								flag_player_audio_kent1 = 1
							ENDIF
															
							IF flag_player_audio_kent1 = 1

								IF HAS_MISSION_AUDIO_LOADED 1
								AND HAS_MISSION_AUDIO_LOADED 2
									flag_player_audio_kent1 = 2
								ENDIF

							ENDIF
														  
							IF flag_player_audio_kent1 = 2
								PLAY_MISSION_AUDIO 1 //"There goes my planning.."
								PRINT_NOW ( RESC_4 ) 5000 1 //"There goes all my carefull planning.."
								SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000 
								flag_player_audio_kent1 = 3
							ENDIF

							IF flag_player_audio_kent1 = 3

								IF HAS_MISSION_AUDIO_FINISHED 1
									CLEAR_THIS_PRINT ( RESC_4 )
									SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
									flag_player_audio_kent1 = 4
								ENDIF

							ENDIF

							IF flag_player_audio_kent1 = 4
								PLAY_MISSION_AUDIO 2
								PRINT_NOW ( RESC_5 ) 5000 1 //"He killed my brother"
								SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_PLAYANIM_CHAT 1000000
								flag_player_audio_kent1 = 5
							ENDIF
								
							IF flag_player_audio_kent1 = 5
																
								LOAD_MISSION_AUDIO 1 ( RESC_6 ) //"Were going to have to..."
									
								IF HAS_MISSION_AUDIO_FINISHED 2
									CLEAR_THIS_PRINT ( RESC_5 )
									SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_FALSE 1
									flag_player_audio_kent1 = 6
								ENDIF
									
							ENDIF
								
							IF flag_player_audio_kent1 = 6
								
								IF HAS_MISSION_AUDIO_LOADED 1
									flag_player_audio_kent1 = 7
								ENDIF
									
							ENDIF
							
							IF flag_player_audio_kent1 = 7
								
								LOAD_MISSION_AUDIO 2 ( RESC_1 ) //"you okay to use a gun!"
								 
								PLAY_MISSION_AUDIO 1
								PRINT_NOW ( RESC_6 ) 5000 1 //"Were going to have to take this guy out!"
								SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000
								flag_player_audio_kent1 = 8
							ENDIF
							
							IF flag_player_audio_kent1 = 8
								
								IF HAS_MISSION_AUDIO_FINISHED 1
									CLEAR_THIS_PRINT ( RESC_6 )
									SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
									flag_player_audio_kent1 = 9
								ENDIF
									
							ENDIF
								
							IF flag_player_audio_kent1 = 9
								
								IF HAS_MISSION_AUDIO_LOADED 2
									flag_player_audio_kent1 = 10
								ENDIF
									
							ENDIF
								
							IF flag_player_audio_kent1 = 10
								
								LOAD_MISSION_AUDIO 1 ( RESC_2 ) //" sure I guess
									
								PLAY_MISSION_AUDIO 2
								PRINT_NOW ( RESC_1 ) 5000 1 //" "
								SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000
								flag_player_audio_kent1 = 11
							ENDIF
								
							IF flag_player_audio_kent1 = 11
								
								IF HAS_MISSION_AUDIO_FINISHED 2
									CLEAR_THIS_PRINT ( RESC_1 )
									SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
									flag_player_audio_kent1 = 12
								ENDIF
									
							ENDIF
							
							IF flag_player_audio_kent1 = 12
								
								IF HAS_MISSION_AUDIO_LOADED 1
									flag_player_audio_kent1 = 13
								ENDIF
									
							ENDIF
							
							IF flag_player_audio_kent1 = 13

								LOAD_MISSION_AUDIO 2 ( RESC_3 )

								PLAY_MISSION_AUDIO 1
								PRINT_NOW ( RESC_2 ) 5000 1 //""
								SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_PLAYANIM_CHAT 1000000
								flag_player_audio_kent1 = 14 
							ENDIF
								
							IF flag_player_audio_kent1 = 14
									
								IF HAS_MISSION_AUDIO_FINISHED 1
									CLEAR_THIS_PRINT ( RESC_2 )
									SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_FALSE 1
									flag_player_audio_kent1 = 15
								ENDIF
									
							ENDIF
								
							IF flag_player_audio_kent1 = 15
								
								IF HAS_MISSION_AUDIO_LOADED 2
									flag_player_audio_kent1 = 16
								ENDIF
									
							ENDIF
								
							IF flag_player_audio_kent1 = 16
								PLAY_MISSION_AUDIO 2
								PRINT_NOW ( RESC_3 ) 5000 1 //""
								SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000
								flag_player_audio_kent1 = 17
							ENDIF

							IF flag_player_audio_kent1 = 17
								
								IF HAS_MISSION_AUDIO_FINISHED 2
									CLEAR_THIS_PRINT ( RESC_3 )
									SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1 
									flag_player_audio_kent1 = 18
								ENDIF
									  
							ENDIF
								
							IF flag_player_audio_kent1 = 18
								flag_mini_cut1_over_kent1 = 2
							ENDIF

						ENDIF
							     	    
						IF flag_mini_cut1_over_kent1 = 2 	
							SET_PLAYER_AS_LEADER buddy_kent1 player1
							SET_CHAR_RUNNING buddy_kent1 TRUE
							  //	PRINT_NOW ( KPM1_4 ) 5000 1 //"Get me outa here!"
							IF NOT IS_CHAR_DEAD buddy_kent1
								SET_CHAR_BLEEDING buddy_kent1 FALSE
								GIVE_WEAPON_TO_CHAR buddy_kent1 WEAPONTYPE_UZI 30000
							ELSE
								PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
								GOTO mission_kent1_failed
								flag_buddy_dead_kent1 = 1
							ENDIF
							REMOVE_BLIP radar_blip_buddy_kent1
							PRINT_NOW ( KPM1_4 ) 5000 1 //"Get Lance to the hospital!"
							ADD_BLIP_FOR_COORD home_x_kent1 home_y_kent1 home_z_kent1 radar_blip_coord1_kent1
							blob_flag = 1
							CLEAR_ONSCREEN_COUNTER buddy_life_guage_kent1
							SET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_kent1
							SWITCH_WIDESCREEN OFF
							SET_PLAYER_CONTROL player1 ON
							SET_EVERYONE_IGNORE_PLAYER player1 OFF
							SET_POLICE_IGNORE_PLAYER player1 OFF
							RESTORE_CAMERA_JUMPCUT
							flag_buddy_in_group_kent1 = 1
							flag_buddy_joined_player = 1
							flag_mini_cut1_over_kent1 = 3
						ENDIF

					ENDIF
											
				ENDIF

			ENDIF

		ENDIF	

	ENDIF

	IF flag_buddy_free_kent1 = 0
				  	   	
		IF flag_player_been_spotted_kent1 = 1  

			 IF timera >= 1500  

			  	IF buddy_life_guage_kent1 > 0 
			  		-- buddy_life_guage_kent1
			  		timera = 0
			  	ELSE
			  		buddy_life_guage_kent1 = 0
			   		timera = 0

			   		IF NOT IS_CHAR_DEAD buddy_kent1					
			   			EXPLODE_CHAR_HEAD buddy_kent1
			   		ENDIF
						
			   	ENDIF

			ENDIF

		ELSE

			IF timera >= 3000

				IF buddy_life_guage_kent1 > 0 
					-- buddy_life_guage_kent1
					timera = 0
				ELSE
					buddy_life_guage_kent1 = 0
					timera = 0

					IF NOT IS_CHAR_DEAD buddy_kent1					
						EXPLODE_CHAR_HEAD buddy_kent1
					ENDIF
							
				ENDIF	
					
			ENDIF

		ENDIF
					
		IF buddys_health_kent1 < buddy_life_guage_kent1
			buddy_life_guage_kent1 = buddys_health_kent1
		ELSE 
			buddys_health_kent1 = buddy_life_guage_kent1
		ENDIF

	ENDIF
			   		
	IF flag_create_2nd_guards_kent1 = 1
		
		IF flag_created_ambush_kent1 = 0
			GOSUB ambush_create_kent1
		ELSE
						
			GOSUB ambush_death_checks_kent1
		ENDIF
	
	ENDIF

ENDWHILE

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON

CLEAR_AREA -830.107 1157.09 12.98 1.0 FALSE 
SET_FIXED_CAMERA_POSITION -830.107 1157.09 12.98 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -829.292 1157.611 12.74 JUMP_CUT

LOAD_MISSION_AUDIO 1 ( RESC_7 ) //"Get patched up
LOAD_MISSION_AUDIO 2 ( RESC_8 ) //Okay I got you.."

IF NOT IS_CHAR_DEAD buddy_kent1
	LEAVE_GROUP buddy_kent1 
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0

	IF IS_CHAR_DEAD buddy_kent1
		REMOVE_BLIP radar_blip_buddy_kent1
		PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
		GOTO mission_kent1_failed
	ENDIF
	
ENDWHILE

IF NOT IS_CHAR_DEAD buddy_kent1 

	IF IS_CHAR_IN_ANY_CAR scplayer
		PLAY_MISSION_AUDIO 1
		PRINT_NOW ( RESC_7 ) 5000 1 //""
	ELSE
		TURN_CHAR_TO_FACE_CHAR scplayer buddy_kent1
		GET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_kent1
		SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED
		SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000 
		PLAY_MISSION_AUDIO 1
		PRINT_NOW ( RESC_7 ) 5000 1 //""	
	ENDIF
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	CLEAR_MISSION_AUDIO 1
	CLEAR_MISSION_AUDIO 2
	CLEAR_PRINTS
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF	 

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

	IF IS_CHAR_DEAD buddy_kent1
		REMOVE_BLIP radar_blip_buddy_kent1
		//CLEAR_MISSION_AUDIO 1
		//CLEAR_MISSION_AUDIO 2
		//CLEAR_PRINTS
		PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
		GOTO mission_kent1_failed
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( RESC_7 )
SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1

IF NOT IS_CHAR_DEAD buddy_kent1 

	IF IS_CHAR_IN_ANY_CAR buddy_kent1
		PLAY_MISSION_AUDIO 2
		PRINT_NOW ( RESC_8 ) 5000 1 //""
	ELSE
		SET_CURRENT_CHAR_WEAPON buddy_kent1 WEAPONTYPE_UNARMED
		SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_PLAYANIM_CHAT 1000000 
		PLAY_MISSION_AUDIO 2
		PRINT_NOW ( RESC_8 ) 5000 1 //""	
	ENDIF
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	CLEAR_MISSION_AUDIO 1
	CLEAR_MISSION_AUDIO 2
	CLEAR_PRINTS
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

	IF IS_CHAR_DEAD buddy_kent1
		REMOVE_BLIP radar_blip_buddy_kent1
		CLEAR_MISSION_AUDIO 2
		CLEAR_PRINTS
		PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
		GOTO mission_kent1_failed
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( RESC_8 )

IF NOT IS_CHAR_DEAD buddy_kent1
	SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_FALSE 1
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	CLEAR_MISSION_AUDIO 2
	CLEAR_PRINTS
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF

IF NOT IS_CHAR_DEAD buddy_kent1

	IF IS_CHAR_IN_ANY_CAR buddy_kent1
		STORE_CAR_CHAR_IS_IN buddy_kent1 buddy_car_kent1
	 	SET_CHAR_OBJ_LEAVE_CAR buddy_kent1 buddy_car_kent1
		
		WHILE IS_CHAR_IN_ANY_CAR buddy_kent1
		
			WAIT 0

			IF IS_CHAR_DEAD buddy_kent1
 				REMOVE_BLIP radar_blip_buddy_kent1
				PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
				GOTO mission_kent1_failed
			ENDIF

			IF IS_CAR_DEAD buddy_car_kent1

				IF IS_CHAR_DEAD buddy_kent1 
					REMOVE_BLIP radar_blip_buddy_kent1
					PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
					GOTO mission_kent1_failed
				ELSE
					GOTO mission_kent1_failed
				ENDIF

			ENDIF

		ENDWHILE  
		
	ENDIF 
		
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF

IF NOT IS_CHAR_DEAD buddy_kent1
	SET_CHAR_COORDINATES buddy_kent1 -822.71 1158.16 10.07
	SET_CHAR_HEADING buddy_kent1 202.594
ELSE
	REMOVE_BLIP radar_blip_buddy_kent1
	PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
	GOTO mission_kent1_failed
ENDIF

SET_FIXED_CAMERA_POSITION -826.493 1154.238 11.78 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -825.780 1154.921 11.62 JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT buddy_kent1 -822.856 1153.668

timera = 0

WHILE timera < 3000 

	WAIT 0

	IF IS_CHAR_DEAD buddy_kent1
 		REMOVE_BLIP radar_blip_buddy_kent1
		PRINT_NOW ( KPM1_2 ) 5000 1 //"You were supposed to get Lance out alive!"
		GOTO mission_kent1_failed
	ENDIF 
	

ENDWHILE

RESTORE_CAMERA_JUMPCUT
DELETE_CHAR buddy_kent1

IF NOT IS_PLAYER_IN_ANY_CAR player1
	SET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_kent1
ENDIF
SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
 

GOTO mission_kent1_passed

// ************************************* MISSION FAILED ************************************

// Mission kent1 failed

mission_kent1_failed:

PRINT_BIG ( M_FAIL ) 5000 1

RETURN

// ************************************ MISSION PASSED *************************************   

// mission kent1 passed

mission_kent1_passed:

flag_kent_mission1_passed = 1
flag_kent_mission_active = 0 // interior stuff for James
REGISTER_MISSION_PASSED ( KENT_1 )
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
PRINT_BIG ( M_PASSN ) 5000 1 //"Mission Passed!" Used cos player does not get any money
CLEAR_WANTED_LEVEL player1
REMOVE_BLIP kent_contact_blip 
REMOVE_BLIP baron_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT baron2X baron2Y baron2Z the_baron_blip baron_contact_blip
START_NEW_SCRIPT baron_mission5_loop
RETURN
		
// *************************************** MISSION CLEANUP *********************************

// mission cleanup

mission_cleanup_kent1:

REMOVE_ROUTE 0
REMOVE_ROUTE 1
REMOVE_ROUTE 2

flag_player_on_mission = 0
REMOVE_CHAR_ELEGANTLY buddy_kent1
REMOVE_ANIMATION LANCE 
SWITCH_ROADS_ON -1208.09 1.78 6.0 -1172.68 18.66 20.0 // Road leading to scrap yard 
REMOVE_BLIP radar_blip_buddy_kent1
REMOVE_BLIP radar_blip_coord1_kent1
REMOVE_BLIP radar_blip_cheat_kent1
UNLOAD_SPECIAL_CHARACTER 3

IF NOT IS_CAR_DEAD car3_kent1
	SET_CAR_MISSION car3_kent1 MISSION_NONE
ENDIF

IF NOT IS_CAR_DEAD car4_kent1
	SET_CAR_MISSION car4_kent1 MISSION_NONE
ENDIF

IF NOT IS_CAR_DEAD car5_kent1
	SET_CAR_MISSION car5_kent1 MISSION_NONE
ENDIF

IF NOT IS_CAR_DEAD car6_kent1
	SET_CAR_MISSION car6_kent1 MISSION_NONE
ENDIF 


MARK_MODEL_AS_NO_LONGER_NEEDED CLa
MARK_MODEL_AS_NO_LONGER_NEEDED CLb
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED COMET
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
CLEAR_ONSCREEN_COUNTER buddy_life_guage_kent1
GET_GAME_TIMER timer_mobile_start 
MISSION_HAS_FINISHED
RETURN

// Checks to see if any of the guards are dead or have spotted the player1

guard_death_check_kent1:

// excutioner

IF flag_executioner_dead_kent1 = 0
		
	IF IS_CHAR_DEAD executioner_kent1
		++ counter_no_of_guys_dead_kent1
		flag_executioner_dead_kent1 = 1
	ELSE

		IF flag_buddy_joined_player = 1
				
			IF flag_executioner_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE executioner_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS executioner_kent1 player1
				flag_executioner_chase_kent1 = 1
			ENDIF

		ENDIF
	   		
	ENDIF
		
ENDIF
	
// guard1
	
IF flag_guard1_dead_kent1 = 0

	IF IS_CHAR_DEAD guard1_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard1_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard1_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF
			
		IF flag_player_been_spotted_kent1 = 1
							   
			IF frame_counter_kent1 = 0 
				CHAR_FOLLOW_PATH guard1_kent1 player_x player_y player_z 0.5 RUN 
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_kent1 player1
			ENDIF
									 
		ENDIF
						
	ENDIF
	
ENDIF	

// guard2
   
IF flag_guard2_dead_kent1 = 0

	IF IS_CHAR_DEAD guard2_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard2_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard2_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF
		   			
		IF flag_buddy_joined_player = 1

			IF flag_guard2_chase_kent1 = 0 
				SET_CHAR_STAY_IN_SAME_PLACE guard2_kent1 FALSE
				flag_guard2_chase_kent1 = 1
			ENDIF
										
		ENDIF 
							
	ENDIF

ENDIF

// guard3
	 
IF flag_guard3_dead_kent1 = 0

	IF IS_CHAR_DEAD guard3_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard3_dead_kent1 = 1
	ELSE
		
		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard3_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF
					   		
		IF flag_buddy_joined_player = 1

			IF flag_guard3_chase_kent1 = 0 
				SET_CHAR_STAY_IN_SAME_PLACE guard3_kent1 FALSE
				flag_guard3_chase_kent1 = 1
			ENDIF
										
		ENDIF
		
	ENDIF

ENDIF

// Guard4
	
IF flag_guard4_dead_kent1 = 0

	IF IS_CHAR_DEAD guard4_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard4_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard4_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_player_been_spotted_kent1 = 1
			
			IF flag_guard4_chase_kent1 = 0
				CHAR_FOLLOW_PATH guard4_kent1 player_x player_y player_z 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_kent1 player1
				flag_guard4_chase_kent1 = 1
			ELSE

				IF frame_counter_kent1 = 30 
					CHAR_FOLLOW_PATH guard4_kent1 player_x player_y player_z 0.5 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_kent1 player1
				ENDIF
					
			ENDIF 
						 
		ENDIF
			   		
	ENDIF

ENDIF

// guard6
   
IF flag_guard6_dead_kent1 = 0

	IF IS_CHAR_DEAD guard6_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard6_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard6_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_player_been_spotted_kent1 = 1
			
			IF flag_guard6_chase_kent1 = 0
				CHAR_FOLLOW_PATH guard6_kent1 player_x player_y player_z 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard6_kent1 player1
				flag_guard6_chase_kent1 = 1
			ELSE

				IF frame_counter_kent1 = 60 
					CHAR_FOLLOW_PATH guard6_kent1 player_x player_y player_z 0.5 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard6_kent1 player1
				ENDIF
					
			ENDIF 
						 
		ENDIF
						
	ENDIF

ENDIF

// guard7 sniper ontop of digger

IF flag_guard7_dead_kent1 = 0

	IF IS_CHAR_DEAD guard7_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard7_dead_kent1 = 1
	ELSE
			   	
	ENDIF

ENDIF


// guard8 sniper ontop of digger
	
IF flag_guard8_dead_kent1 = 0

	IF IS_CHAR_DEAD guard8_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard8_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard8_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_buddy_joined_player = 1
		OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
			
			IF flag_guard8_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE guard8_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard8_kent1 player1
				flag_guard8_chase_kent1 = 1
			ENDIF
													 
		ENDIF
					
	ENDIF

ENDIF

// guard9 sniper ontop of digger

IF flag_guard9_dead_kent1 = 0

	IF IS_CHAR_DEAD guard9_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard9_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard9_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_buddy_joined_player = 1
		OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
			
			IF flag_guard9_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE guard9_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard9_kent1 player1
				flag_guard9_chase_kent1 = 1
			ENDIF
													 
		ENDIF
							
	ENDIF

ENDIF

// guard10

IF flag_guard10_dead_kent1 = 0

	IF IS_CHAR_DEAD guard10_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard10_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard10_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_buddy_joined_player = 1
		OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE

			IF flag_guard10_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE guard10_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS guard10_kent1 player1
				flag_guard10_chase_kent1 = 1
			ENDIF
			
			IF frame_counter_kent1 = 90 
				CHAR_FOLLOW_PATH guard10_kent1 player_x player_y player_z 1.0 RUN 
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard10_kent1 player1
			ENDIF
													 
		ENDIF
							
	ENDIF

ENDIF

// guard11

IF flag_guard11_dead_kent1 = 0

	IF IS_CHAR_DEAD guard11_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard11_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard11_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_buddy_joined_player = 1
		OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
			
			IF flag_guard11_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE guard11_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS guard11_kent1 player1
				flag_guard11_chase_kent1 = 1
			ENDIF

			IF frame_counter_kent1 = 120 
				CHAR_FOLLOW_PATH guard11_kent1 player_x player_y player_z 1.0 RUN 
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard11_kent1 player1
			ENDIF
													 
		ENDIF
							
	ENDIF

ENDIF

// guard12

IF flag_guard12_dead_kent1 = 0

	IF IS_CHAR_DEAD guard12_kent1
		++ counter_no_of_guys_dead_kent1
		flag_guard12_dead_kent1 = 1
	ELSE

		IF flag_player_been_spotted_kent1 = 0
			
			IF HAS_CHAR_SPOTTED_PLAYER guard12_kent1 player1
				flag_player_been_spotted_kent1 = 1		
			ENDIF

		ENDIF

		IF flag_buddy_joined_player = 1
		OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
			
			IF flag_guard12_chase_kent1 = 0
				SET_CHAR_STAY_IN_SAME_PLACE guard12_kent1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS guard12_kent1 player1
				flag_guard12_chase_kent1 = 1
			ENDIF

			IF frame_counter_kent1 = 150 
				CHAR_FOLLOW_PATH guard12_kent1 player_x player_y player_z 1.0 RUN 
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard12_kent1 player1
			ENDIF
													 
		ENDIF
							
	ENDIF

ENDIF

IF flag_second_wave_created_kent1 = 1

	IF flag_guard13_dead_kent1 = 0

		IF IS_CHAR_DEAD guard13_kent1
			++ counter_no_of_guys_dead_kent1
			flag_guard13_dead_kent1 = 1
		ELSE
						
			IF flag_buddy_joined_player = 1
			OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
								
				IF frame_counter_kent1 = 180 
					CHAR_FOLLOW_PATH guard13_kent1 player_x player_y player_z 1.0 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard13_kent1 player1
				ENDIF
														 
			ENDIF
								
		ENDIF

	ENDIF

	IF flag_guard14_dead_kent1 = 0

		IF IS_CHAR_DEAD guard14_kent1
			++ counter_no_of_guys_dead_kent1
			flag_guard14_dead_kent1 = 1
		ELSE
						
			IF flag_buddy_joined_player = 1
			OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
								
				IF frame_counter_kent1 = 210 
					CHAR_FOLLOW_PATH guard14_kent1 player_x player_y player_z 1.0 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard14_kent1 player1
				ENDIF
														 
			ENDIF
								
		ENDIF

	ENDIF

	IF flag_guard15_dead_kent1 = 0

		IF IS_CHAR_DEAD guard15_kent1
			++ counter_no_of_guys_dead_kent1
			flag_guard15_dead_kent1 = 1
		ELSE
						
			IF flag_buddy_joined_player = 1
			OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
								
				IF frame_counter_kent1 = 240 
					CHAR_FOLLOW_PATH guard15_kent1 player_x player_y player_z 1.0 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard15_kent1 player1
				ENDIF
														 
			ENDIF
								
		ENDIF

	ENDIF

	IF flag_guard16_dead_kent1 = 0

		IF IS_CHAR_DEAD guard16_kent1
			++ counter_no_of_guys_dead_kent1
			flag_guard16_dead_kent1 = 1
		ELSE
						
			IF flag_buddy_joined_player = 1
			OR IS_PLAYER_IN_AREA_2D player1 -1234.15 -1.0 -1367.51 250.33 FALSE
								
				IF frame_counter_kent1 = 270 
					CHAR_FOLLOW_PATH guard16_kent1 player_x player_y player_z 1.0 RUN 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard16_kent1 player1
				ENDIF
														 
			ENDIF
								
		ENDIF

	ENDIF
	
ENDIF 


RETURN

// Checks to see whether the buddy is in the players group or not

buddy_group_checks_kent1:

IF flag_buddy_joined_player = 1

	IF flag_buddy_in_group_kent1 = 1

		IF NOT IS_CHAR_IN_PLAYERS_GROUP buddy_kent1 player1

			IF flag_had_buddy_message_kent1 = 0
				PRINT_NOW ( HEY ) 5000 1 //"KEEP YOUR GROUP TOGETHER!"
				ADD_BLIP_FOR_CHAR buddy_kent1 radar_blip_buddy_kent1
				REMOVE_BLIP radar_blip_coord1_kent1
				blob_flag = 0
				flag_buddy_in_group_kent1 = 0
				flag_had_buddy_message_kent1 = 1
			ENDIF

		ENDIF

	ELSE
		
		IF flag_had_buddy_message_kent1 = 1 

			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy_kent1 8.0 8.0 8.0 FALSE
				SET_PLAYER_AS_LEADER buddy_kent1 player1
				SET_CHAR_RUNNING buddy_kent1 TRUE
				PRINT_NOW ( KPM1_4 ) 5000 1 //"Get me to safety!"
				REMOVE_BLIP radar_blip_buddy_kent1  
				ADD_BLIP_FOR_COORD home_x_kent1 home_y_kent1 home_z_kent1 radar_blip_coord1_kent1
				blob_flag = 1
				flag_buddy_in_group_kent1 = 1
				flag_had_buddy_message_kent1 = 0 
			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

// Creates the ambush guys at door

ambush_create_kent1:

// guard3

CREATE_CAR COMET -1066.072 -55.111 10.262 car3_kent1

CREATE_CHAR_INSIDE_CAR car3_kent1 PEDTYPE_GANG_DIAZ CLb ambush_guard3_kent1

SET_CAR_HEADING car3_kent1 355.752

CLEAR_CHAR_THREAT_SEARCH ambush_guard3_kent1

SET_CHAR_MONEY ambush_guard3_kent1 200

SET_CHAR_THREAT_SEARCH ambush_guard3_kent1 THREAT_PLAYER1

SET_CHAR_PERSONALITY ambush_guard3_kent1 PEDSTAT_TOUGH_GUY

GIVE_WEAPON_TO_CHAR ambush_guard3_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

SET_CAR_FORWARD_SPEED car3_kent1 20.0

SET_CAR_CRUISE_SPEED car3_kent1 100.0

ADD_UPSIDEDOWN_CAR_CHECK car3_kent1

ADD_STUCK_CAR_CHECK car3_kent1 0.5 3000 

flag_ambush_guard3_in_car_kent1 = 1

// guard4

CREATE_CAR COMET -1066.714 -28.923 10.246 car4_kent1

SET_CAR_HEADING car4_kent1 5.6

CREATE_CHAR_INSIDE_CAR car4_kent1 PEDTYPE_GANG_DIAZ CLa ambush_guard4_kent1 

CLEAR_CHAR_THREAT_SEARCH ambush_guard4_kent1

SET_CHAR_MONEY ambush_guard4_kent1 200

SET_CHAR_THREAT_SEARCH ambush_guard4_kent1 THREAT_PLAYER1

SET_CHAR_PERSONALITY ambush_guard4_kent1 PEDSTAT_TOUGH_GUY 

GIVE_WEAPON_TO_CHAR ambush_guard4_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

SET_CAR_FORWARD_SPEED car4_kent1 20.0 

SET_CAR_CRUISE_SPEED car4_kent1 100.0

ADD_UPSIDEDOWN_CAR_CHECK car4_kent1

ADD_STUCK_CAR_CHECK car4_kent1 0.5 3000

flag_ambush_guard4_in_car_kent1 = 1

// Guard5

CREATE_CAR COMET -1073.399 77.886 10.239 car5_kent1

SET_CAR_HEADING car5_kent1 186.085

CREATE_CHAR_INSIDE_CAR car5_kent1 PEDTYPE_GANG_DIAZ CLa ambush_guard5_kent1 

CLEAR_CHAR_THREAT_SEARCH ambush_guard5_kent1

SET_CHAR_MONEY ambush_guard5_kent1 200

SET_CHAR_THREAT_SEARCH ambush_guard5_kent1 THREAT_PLAYER1

SET_CHAR_PERSONALITY ambush_guard5_kent1 PEDSTAT_TOUGH_GUY 

GIVE_WEAPON_TO_CHAR ambush_guard5_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

SET_CAR_FORWARD_SPEED car5_kent1 20.0

SET_CAR_CRUISE_SPEED car5_kent1 100.0

ADD_UPSIDEDOWN_CAR_CHECK car5_kent1

ADD_STUCK_CAR_CHECK car5_kent1 0.5 3000

flag_ambush_guard5_in_car_kent1 = 1

// Guard6

CREATE_CAR COMET -1072.822 41.816 10.270 car6_kent1

SET_CAR_HEADING car6_kent1 178.162

CREATE_CHAR_INSIDE_CAR car6_kent1 PEDTYPE_GANG_DIAZ CLa ambush_guard6_kent1 

CLEAR_CHAR_THREAT_SEARCH ambush_guard6_kent1

SET_CHAR_MONEY ambush_guard6_kent1 200

SET_CHAR_THREAT_SEARCH ambush_guard6_kent1 THREAT_PLAYER1

SET_CHAR_PERSONALITY ambush_guard6_kent1 PEDSTAT_TOUGH_GUY 

GIVE_WEAPON_TO_CHAR ambush_guard6_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

SET_CAR_FORWARD_SPEED car6_kent1 20.0

SET_CAR_CRUISE_SPEED car6_kent1 100.0

ADD_UPSIDEDOWN_CAR_CHECK car6_kent1

ADD_STUCK_CAR_CHECK car6_kent1 0.5 3000

flag_ambush_guard6_in_car_kent1 = 1

flag_created_ambush_kent1 = 1

RETURN

// Checks to see if any of the ambush guys are dead

ambush_death_checks_kent1:

// Guard3
	
IF flag_ambush_guard3_dead_kent1 = 0

	IF IS_CHAR_DEAD ambush_guard3_kent1
		flag_ambush_guard3_dead_kent1 = 1
	ELSE

		IF chase_message_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard3_kent1
				PRINT_NOW ( KPM1_5 ) 5000 1 //"Diaz's guys are after you get to the hospital."
				chase_message_kent1 = 1
			ENDIF

		ENDIF
						
		IF flag_ambush_guard3_in_car_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard3_kent1

				IF ambush_guard3_do_stuff_kent1 = 0
					CLEAR_CHAR_THREAT_SEARCH ambush_guard3_kent1
					SET_CHAR_THREAT_SEARCH ambush_guard3_kent1 THREAT_PLAYER1 
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ambush_guard3_kent1 player1
					ambush_guard3_do_stuff_kent1 = 1
				ENDIF

			ELSE

				ambush_guard3_do_stuff_kent1 = 0

				IF ambush_guard3_do_stuff_kent1 = 0
					
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ambush_guard3_kent1 20.0 20.0 FALSE  
														
						GET_CHAR_COORDINATES ambush_guard3_kent1 abguard3_x_kent1 abguard3_y_kent1 abguard3_z_kent1
						GET_CLOSEST_CAR_NODE abguard3_x_kent1 abguard3_y_kent1 abguard3_z_kent1 car3_x_kent1 car3_y_kent1 car3_z_kent1

						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car3_x_kent1 car3_y_kent1 car3_z_kent1 4.0 4.0 3.0
								
							IF NOT IS_POINT_ON_SCREEN car3_x_kent1 car3_y_kent1 car3_z_kent1 4.0
								REMOVE_STUCK_CAR_CHECK car3_kent1
								REMOVE_UPSIDEDOWN_CAR_CHECK car3_kent1
								MARK_CAR_AS_NO_LONGER_NEEDED car3_kent1 
								CREATE_CAR COMET car3_x_kent1 car3_y_kent1 car3_z_kent1 car3_kent1
								SET_CHAR_OBJ_NO_OBJ ambush_guard3_kent1
								WARP_CHAR_INTO_CAR ambush_guard3_kent1 car3_kent1
								guard3_car_mission_kent1 = 0
								ambush_guard3_do_stuff_kent1 = 1
							ENDIF

						ENDIF

					ENDIF
				   			   
				ENDIF

			ENDIF 
					
			IF IS_CHAR_IN_ANY_CAR ambush_guard3_kent1
				STORE_CAR_CHAR_IS_IN ambush_guard3_kent1 car3_kent1
				SET_CAR_CRUISE_SPEED car3_kent1 100.0
				ADD_UPSIDEDOWN_CAR_CHECK car3_kent1
				ADD_STUCK_CAR_CHECK car3_kent1 0.5 3000
				SET_CAR_FORWARD_SPEED car3_kent1 30.0 
				flag_ambush_guard3_in_car_kent1 = 1 
			ENDIF
							
		ENDIF

		IF flag_ambush_guard3_in_car_kent1 = 1
			
			IF NOT IS_CAR_DEAD car3_kent1

				IF guard3_car_mission_kent1 = 0
					SET_CAR_MISSION car3_kent1 MISSION_RAMPLAYER_FARAWAY
					guard3_car_mission_kent1 = 1
				ENDIF
						  	
			  	IF IS_CAR_UPSIDEDOWN car3_kent1
				OR IS_CAR_ON_FIRE car3_kent1
				OR IS_CAR_STUCK car3_kent1
			  		SET_CHAR_OBJ_LEAVE_CAR ambush_guard3_kent1 car3_kent1
			  	ENDIF

			ENDIF

			IF NOT IS_CHAR_IN_ANY_CAR ambush_guard3_kent1
				REMOVE_STUCK_CAR_CHECK car3_kent1
				REMOVE_UPSIDEDOWN_CAR_CHECK car3_kent1
				MARK_CAR_AS_NO_LONGER_NEEDED car3_kent1
				guard3_car_mission_kent1 = 0
				ambush_guard3_do_stuff_kent1 = 0
				flag_ambush_guard3_in_car_kent1 = 0
			ENDIF	 
		  		
		ENDIF 
					
	ENDIF
		
ENDIF


					 
// Guard4
						 
IF flag_ambush_guard4_dead_kent1 = 0

	IF IS_CHAR_DEAD ambush_guard4_kent1
		flag_ambush_guard4_dead_kent1 = 1
	ELSE

		IF chase_message_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard4_kent1
				PRINT_NOW ( KPM1_5 ) 5000 1 //"Diaz's guys are after you get to the hospital."
				chase_message_kent1 = 1
			ENDIF

		ENDIF

		IF flag_ambush_guard4_in_car_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard4_kent1

				IF ambush_guard4_do_stuff_kent1 = 0
					CLEAR_CHAR_THREAT_SEARCH ambush_guard4_kent1
					SET_CHAR_THREAT_SEARCH ambush_guard4_kent1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ambush_guard4_kent1 player1
					ambush_guard4_do_stuff_kent1 = 1
				ENDIF

			ELSE

				ambush_guard4_do_stuff_kent1 = 0

				IF ambush_guard4_do_stuff_kent1 = 0
					
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ambush_guard4_kent1 20.0 20.0 FALSE  
																				
						GET_CHAR_COORDINATES ambush_guard4_kent1 abguard4_x_kent1 abguard4_y_kent1 abguard4_z_kent1
						GET_CLOSEST_CAR_NODE abguard4_x_kent1 abguard4_y_kent1 abguard4_z_kent1 car4_x_kent1 car4_y_kent1 car4_z_kent1

						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car4_x_kent1 car4_y_kent1 car4_z_kent1 4.0 4.0 3.0
								
							IF NOT IS_POINT_ON_SCREEN car4_x_kent1 car4_y_kent1 car4_z_kent1 4.0
								REMOVE_STUCK_CAR_CHECK car4_kent1
								REMOVE_UPSIDEDOWN_CAR_CHECK car4_kent1
								MARK_CAR_AS_NO_LONGER_NEEDED car4_kent1 
								CREATE_CAR COMET car4_x_kent1 car4_y_kent1 car4_z_kent1 car4_kent1
								SET_CHAR_OBJ_NO_OBJ ambush_guard4_kent1
								WARP_CHAR_INTO_CAR ambush_guard4_kent1 car4_kent1
								guard4_car_mission_kent1 = 0
								ambush_guard4_do_stuff_kent1 = 1
							ENDIF

						ENDIF

					ENDIF
															
				ENDIF

			ENDIF 
					
			IF IS_CHAR_IN_ANY_CAR ambush_guard4_kent1
				STORE_CAR_CHAR_IS_IN ambush_guard4_kent1 car4_kent1
				SET_CAR_CRUISE_SPEED car4_kent1 100.0 
				ADD_UPSIDEDOWN_CAR_CHECK car4_kent1
				ADD_STUCK_CAR_CHECK car4_kent1 0.5 3000
				SET_CAR_FORWARD_SPEED car4_kent1 30.0
				flag_ambush_guard4_in_car_kent1 = 1 
			ENDIF
							
		ENDIF

		IF flag_ambush_guard4_in_car_kent1 = 1

			IF NOT IS_CAR_DEAD car4_kent1

				IF guard4_car_mission_kent1 = 0
					SET_CAR_MISSION car4_kent1 MISSION_RAMPLAYER_FARAWAY
					guard4_car_mission_kent1 = 1
				ENDIF
						  	
			  	IF IS_CAR_UPSIDEDOWN car4_kent1
				OR IS_CAR_ON_FIRE car4_kent1
				OR IS_CAR_STUCK car4_kent1
			  		SET_CHAR_OBJ_LEAVE_CAR ambush_guard4_kent1 car4_kent1
			  	ENDIF

			ENDIF

			IF NOT IS_CHAR_IN_ANY_CAR ambush_guard4_kent1
				REMOVE_STUCK_CAR_CHECK car4_kent1
				REMOVE_UPSIDEDOWN_CAR_CHECK car4_kent1
				MARK_CAR_AS_NO_LONGER_NEEDED car4_kent1
				guard4_car_mission_kent1 = 0
				ambush_guard4_do_stuff_kent1 = 0
				flag_ambush_guard4_in_car_kent1 = 0
			ENDIF	 
		  		
		ENDIF
		  			
	ENDIF
		
ENDIF

// guard5
	
IF flag_ambush_guard5_dead_kent1 = 0

	IF IS_CHAR_DEAD ambush_guard5_kent1
		flag_ambush_guard5_dead_kent1 = 1
	ELSE

		IF chase_message_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard5_kent1
				PRINT_NOW ( KPM1_5 ) 5000 1 //"Diaz's guys are after you get to the hospital."
				chase_message_kent1 = 1
			ENDIF

		ENDIF
		
		IF flag_ambush_guard5_in_car_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard5_kent1

				IF ambush_guard5_do_stuff_kent1 = 0
					CLEAR_CHAR_THREAT_SEARCH ambush_guard5_kent1
					SET_CHAR_THREAT_SEARCH ambush_guard5_kent1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ambush_guard5_kent1 player1
					ambush_guard5_do_stuff_kent1 = 1
				ENDIF

			ELSE

				ambush_guard5_do_stuff_kent1 = 0

				IF ambush_guard5_do_stuff_kent1 = 0

					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ambush_guard5_kent1 20.0 20.0 FALSE  
														
						GET_CHAR_COORDINATES ambush_guard5_kent1 abguard5_x_kent1 abguard5_y_kent1 abguard5_z_kent1
						GET_CLOSEST_CAR_NODE abguard5_x_kent1 abguard5_y_kent1 abguard5_z_kent1 car5_x_kent1 car5_y_kent1 car5_z_kent1

						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car5_x_kent1 car5_y_kent1 car5_z_kent1 4.0 4.0 3.0
								
							IF NOT IS_POINT_ON_SCREEN car5_x_kent1 car5_y_kent1 car5_z_kent1 4.0
								REMOVE_STUCK_CAR_CHECK car5_kent1
								REMOVE_UPSIDEDOWN_CAR_CHECK car5_kent1
								MARK_CAR_AS_NO_LONGER_NEEDED car5_kent1 
								CREATE_CAR COMET car5_x_kent1 car5_y_kent1 car5_z_kent1 car5_kent1
								SET_CHAR_OBJ_NO_OBJ ambush_guard5_kent1
								WARP_CHAR_INTO_CAR ambush_guard5_kent1 car5_kent1
								guard5_car_mission_kent1 = 0
								ambush_guard5_do_stuff_kent1 = 1
							ENDIF

						ENDIF

					ENDIF
												   
				ENDIF 
 
			ENDIF 
					
			IF IS_CHAR_IN_ANY_CAR ambush_guard5_kent1
				STORE_CAR_CHAR_IS_IN ambush_guard5_kent1 car5_kent1
				SET_CAR_CRUISE_SPEED car5_kent1 100.0
				ADD_UPSIDEDOWN_CAR_CHECK car5_kent1
				ADD_STUCK_CAR_CHECK car5_kent1 0.5 3000
				SET_CAR_FORWARD_SPEED car5_kent1 30.0
				flag_ambush_guard5_in_car_kent1 = 1 
			ENDIF
							
		ENDIF

		IF flag_ambush_guard5_in_car_kent1 = 1

			IF NOT IS_CAR_DEAD car5_kent1

				IF guard5_car_mission_kent1 = 0
					SET_CAR_MISSION car5_kent1 MISSION_RAMPLAYER_FARAWAY
					guard5_car_mission_kent1 = 1
				ENDIF
						  	
			  	IF IS_CAR_UPSIDEDOWN car5_kent1
				OR IS_CAR_ON_FIRE car5_kent1
				OR IS_CAR_STUCK car5_kent1
			  		SET_CHAR_OBJ_LEAVE_CAR ambush_guard5_kent1 car5_kent1
			  	ENDIF

			ENDIF

			IF NOT IS_CHAR_IN_ANY_CAR ambush_guard5_kent1
				REMOVE_STUCK_CAR_CHECK car5_kent1
				REMOVE_UPSIDEDOWN_CAR_CHECK car5_kent1
				MARK_CAR_AS_NO_LONGER_NEEDED car5_kent1
				guard5_car_mission_kent1 = 0
				ambush_guard5_do_stuff_kent1 = 0
				flag_ambush_guard5_in_car_kent1 = 0
			ENDIF
						
		ENDIF
		  		
	ENDIF
		
ENDIF

// guard6

IF flag_ambush_guard6_dead_kent1 = 0

	IF IS_CHAR_DEAD ambush_guard6_kent1
		flag_ambush_guard6_dead_kent1 = 1
	ELSE

		IF chase_message_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard6_kent1
				PRINT_NOW ( KPM1_5 ) 5000 1 //"Diaz's guys are after you get to the hospital."
				chase_message_kent1 = 1
			ENDIF

		ENDIF
			
		IF flag_ambush_guard6_in_car_kent1 = 0

			IF IS_CHAR_ON_SCREEN ambush_guard6_kent1

				IF ambush_guard6_do_stuff_kent1 = 0
					CLEAR_CHAR_THREAT_SEARCH ambush_guard6_kent1
					SET_CHAR_THREAT_SEARCH ambush_guard6_kent1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ambush_guard6_kent1 player1
					ambush_guard6_do_stuff_kent1 = 1
				ENDIF

			ELSE

				ambush_guard6_do_stuff_kent1 = 0
				
				IF ambush_guard6_do_stuff_kent1 = 0
				
					IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ambush_guard6_kent1 20.0 20.0 FALSE  

						GET_CHAR_COORDINATES ambush_guard6_kent1 abguard6_x_kent1 abguard6_y_kent1 abguard6_z_kent1
						GET_CLOSEST_CAR_NODE abguard6_x_kent1 abguard6_y_kent1 abguard6_z_kent1 car6_x_kent1 car6_y_kent1 car6_z_kent1

						IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car6_x_kent1 car6_y_kent1 car6_z_kent1 4.0 4.0 3.0
								
							IF NOT IS_POINT_ON_SCREEN car6_x_kent1 car6_y_kent1 car6_z_kent1 4.0
								REMOVE_STUCK_CAR_CHECK car6_kent1
								REMOVE_UPSIDEDOWN_CAR_CHECK car6_kent1
								MARK_CAR_AS_NO_LONGER_NEEDED car6_kent1 
								CREATE_CAR COMET car6_x_kent1 car6_y_kent1 car6_z_kent1 car6_kent1
								SET_CHAR_OBJ_NO_OBJ ambush_guard6_kent1
								WARP_CHAR_INTO_CAR ambush_guard6_kent1 car6_kent1
								guard6_car_mission_kent1 = 0
								ambush_guard6_do_stuff_kent1 = 1
							ENDIF

						ENDIF
											   
					ENDIF

				ENDIF
												   
			ENDIF 
					
			IF IS_CHAR_IN_ANY_CAR ambush_guard6_kent1
				STORE_CAR_CHAR_IS_IN ambush_guard6_kent1 car6_kent1
				SET_CAR_CRUISE_SPEED car6_kent1 100.0
				ADD_UPSIDEDOWN_CAR_CHECK car6_kent1
				ADD_STUCK_CAR_CHECK car6_kent1 0.5 3000
				SET_CAR_FORWARD_SPEED car6_kent1 30.0
				ambush_guard6_do_stuff_kent1 = 0
				flag_ambush_guard6_in_car_kent1 = 1 
			ENDIF
							
		ENDIF

		IF flag_ambush_guard6_in_car_kent1 = 1

			IF NOT IS_CAR_DEAD car6_kent1
		
				IF guard6_car_mission_kent1 = 0
					SET_CAR_MISSION car6_kent1 MISSION_RAMPLAYER_FARAWAY
					guard6_car_mission_kent1 = 1
				ENDIF
						  	
			  	IF IS_CAR_UPSIDEDOWN car6_kent1
				OR IS_CAR_ON_FIRE car6_kent1
				OR IS_CAR_STUCK car6_kent1
			  		SET_CHAR_OBJ_LEAVE_CAR ambush_guard6_kent1 car6_kent1
			  	ENDIF

			ENDIF

			IF NOT IS_CHAR_IN_ANY_CAR ambush_guard6_kent1
				REMOVE_STUCK_CAR_CHECK car6_kent1
				REMOVE_UPSIDEDOWN_CAR_CHECK car6_kent1
				MARK_CAR_AS_NO_LONGER_NEEDED car6_kent1
				guard6_car_mission_kent1 = 0
				ambush_guard6_do_stuff_kent1 = 0
				flag_ambush_guard6_in_car_kent1 = 0
			ENDIF	 
		  		
		ENDIF
					
	ENDIF
		
ENDIF

RETURN

guard_AI_kent1:

IF counter_guards_got_AI_kent1 < 11

// buddy

	IF flag_buddy_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD buddy_kent1

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION buddy_kent1
				
				CLEAR_CHAR_THREAT_SEARCH buddy_kent1

				SET_CHAR_ONLY_DAMAGED_BY_PLAYER buddy_kent1 TRUE 
								
				SET_CHAR_WAIT_STATE buddy_kent1 WAITSTATE_LANCESITTING 1000000

			   	SET_CHAR_BLEEDING buddy_kent1 TRUE

				FREEZE_CHAR_POSITION buddy_kent1 TRUE

				SET_CHAR_AS_PLAYER_FRIEND buddy_kent1 player1 TRUE

				++ counter_guards_got_AI_kent1
				flag_buddy_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// executioner

	IF flag_executioner_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD executioner_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION executioner_kent1  

				CLEAR_CHAR_THREAT_SEARCH executioner_kent1

				SET_CHAR_THREAT_SEARCH executioner_kent1 THREAT_PLAYER1

				GIVE_WEAPON_TO_CHAR executioner_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

				SET_CHAR_ACCURACY executioner_kent1 80

				SET_CHAR_HEADING executioner_kent1 196.450

				SET_CHAR_STAY_IN_SAME_PLACE executioner_kent1 TRUE

				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT executioner_kent1 player1

				++ counter_guards_got_AI_kent1
				flag_executioner_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// guard1

	IF flag_guard1_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard1_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard1_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard1_kent1

				SET_CHAR_THREAT_SEARCH guard1_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard1_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard1_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard1_kent1 80

				ADD_ROUTE_POINT 0 route0_point1_x_kent1 route0_point1_y_kent1 route0_point1_z_kent1 

				ADD_ROUTE_POINT 0 route0_point2_x_kent1 route0_point2_y_kent1 route0_point2_z_kent1

				ADD_ROUTE_POINT 0 route0_point3_x_kent1 route0_point3_y_kent1 route0_point3_z_kent1

				ADD_ROUTE_POINT 0 route0_point4_x_kent1 route0_point4_y_kent1 route0_point4_z_kent1

				SET_CHAR_OBJ_FOLLOW_ROUTE guard1_kent1 0 FOLLOW_ROUTE_LOOP

				++ counter_guards_got_AI_kent1
				flag_guard1_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// guard2

	IF flag_guard2_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard2_kent1 
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard2_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard2_kent1

				SET_CHAR_THREAT_SEARCH guard2_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard2_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard2_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard2_kent1 80

				SET_CHAR_HEADING guard2_kent1 guard2_heading_kent1

				SET_CHAR_STAY_IN_SAME_PLACE guard2_kent1 TRUE

				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard2_kent1 player1
							
				++ counter_guards_got_AI_kent1
				flag_guard2_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// guard3

	IF flag_guard3_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard3_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard3_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard3_kent1

				SET_CHAR_THREAT_SEARCH guard3_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard3_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard3_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard3_kent1 80

				SET_CHAR_HEADING guard3_kent1 guard3_heading_kent1

				SET_CHAR_STAY_IN_SAME_PLACE guard3_kent1 TRUE

				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard3_kent1 player1
			   						
				++ counter_guards_got_AI_kent1
				flag_guard3_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// guard4

	IF flag_guard4_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard4_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard4_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard4_kent1

				SET_CHAR_THREAT_SEARCH guard4_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard4_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard4_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard4_kent1 80

				ADD_ROUTE_POINT 1 route1_point1_x_kent1 route1_point1_y_kent1 route1_point1_z_kent1 

				ADD_ROUTE_POINT 1 route1_point2_x_kent1 route1_point2_y_kent1 route1_point2_z_kent1

				ADD_ROUTE_POINT 1 route1_point3_x_kent1 route1_point3_y_kent1 route1_point3_z_kent1

				ADD_ROUTE_POINT 1 route1_point4_x_kent1 route1_point4_y_kent1 route1_point4_z_kent1

				ADD_ROUTE_POINT 1 route1_point5_x_kent1 route1_point5_y_kent1 route1_point5_z_kent1

				ADD_ROUTE_POINT 1 route1_point6_x_kent1 route1_point6_y_kent1 route1_point6_z_kent1

				ADD_ROUTE_POINT 1 route1_point7_x_kent1 route1_point7_y_kent1 route1_point7_z_kent1

				ADD_ROUTE_POINT 1 route1_point8_x_kent1 route1_point8_y_kent1 route1_point8_z_kent1

				SET_CHAR_OBJ_FOLLOW_ROUTE guard4_kent1 1 FOLLOW_ROUTE_LOOP
											   						
				++ counter_guards_got_AI_kent1
				flag_guard4_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF
	
// guard6

	IF flag_guard6_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard6_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard6_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard6_kent1

				SET_CHAR_THREAT_SEARCH guard6_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard6_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard6_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard6_kent1 80

				ADD_ROUTE_POINT 2 route2_point1_x_kent1 route2_point1_y_kent1 route2_point1_z_kent1 

				ADD_ROUTE_POINT 2 route2_point2_x_kent1 route2_point2_y_kent1 route2_point2_z_kent1

				ADD_ROUTE_POINT 2 route2_point3_x_kent1 route2_point3_y_kent1 route2_point3_z_kent1

				SET_CHAR_OBJ_FOLLOW_ROUTE guard6_kent1 2 FOLLOW_ROUTE_LOOP
																			   						
				++ counter_guards_got_AI_kent1
				flag_guard6_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF
	
// guard7

	IF flag_guard7_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard7_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard7_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard7_kent1

				SET_CHAR_THREAT_SEARCH guard7_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard7_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard7_kent1 WEAPONTYPE_RUGER 30000 // set infinate ammo

				SET_CHAR_ACCURACY guard7_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard7_kent1 TRUE

				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard7_kent1 player1
															   						
				++ counter_guards_got_AI_kent1
				flag_guard7_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF
	
// guard8

	IF flag_guard8_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard8_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard8_kent1 

				CLEAR_CHAR_THREAT_SEARCH guard8_kent1

				SET_CHAR_HEADING guard8_kent1 289.74

				SET_CHAR_THREAT_SEARCH guard8_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard8_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard8_kent1 WEAPONTYPE_RUGER 30000 // set infinate ammo

				SET_CHAR_ACCURACY guard8_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard8_kent1 TRUE
				
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard8_kent1 player1
															   						
				++ counter_guards_got_AI_kent1
				flag_guard8_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// gaurd9

   IF flag_guard9_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard9_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard9_kent1
			
				CLEAR_CHAR_THREAT_SEARCH guard9_kent1

				SET_CHAR_HEADING guard9_kent1 289.74

				SET_CHAR_THREAT_SEARCH guard9_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard9_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard9_kent1 WEAPONTYPE_RUGER 30000 // set infinate ammo

				SET_CHAR_ACCURACY guard9_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard9_kent1 TRUE
				
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard9_kent1 player1 
																			   						
				++ counter_guards_got_AI_kent1
				flag_guard9_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// guard10

   IF flag_guard10_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard10_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard10_kent1
			
				CLEAR_CHAR_THREAT_SEARCH guard10_kent1

				SET_CHAR_HEADING guard10_kent1 87.550

				SET_CHAR_THREAT_SEARCH guard10_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard10_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard10_kent1 WEAPONTYPE_RUGER 30000 // set infinate ammo

			   //	SET_CHAR_ACCURACY guard10_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard10_kent1 TRUE
				
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard10_kent1 player1 
																			   						
				++ counter_guards_got_AI_kent1
				flag_guard10_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

// Guard11

	IF flag_guard11_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard11_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard11_kent1
			
				CLEAR_CHAR_THREAT_SEARCH guard11_kent1

				SET_CHAR_HEADING guard11_kent1 128.477

				SET_CHAR_THREAT_SEARCH guard11_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard11_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard11_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

				//SET_CHAR_ACCURACY guard11_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard11_kent1 TRUE
				
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard11_kent1 player1 
																			   						
				++ counter_guards_got_AI_kent1
				flag_guard11_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF
	
// Guard12

	IF flag_guard12_got_AI_kent1 = 0

		IF NOT IS_CHAR_DEAD guard12_kent1
	
			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard12_kent1
			
				CLEAR_CHAR_THREAT_SEARCH guard12_kent1

				SET_CHAR_HEADING guard12_kent1 98.364

				SET_CHAR_THREAT_SEARCH guard12_kent1 THREAT_PLAYER1

				SET_CHAR_PERSONALITY guard12_kent1 PEDSTAT_TOUGH_GUY

				GIVE_WEAPON_TO_CHAR guard12_kent1 WEAPONTYPE_UZI 30000 // set infinate ammo

				//SET_CHAR_ACCURACY guard12_kent1 80

				SET_CHAR_STAY_IN_SAME_PLACE guard12_kent1 TRUE
				
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard12_kent1 player1 
																			   						
				++ counter_guards_got_AI_kent1
				flag_guard12_got_AI_kent1 = 1

			ENDIF

		ENDIF

	ENDIF

ENDIF
	
RETURN

}



