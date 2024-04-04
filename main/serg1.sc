MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Sergio 1****************************************
// *****************************************Four Iron*************************************** 

// This mission is actually Avery Carrington 1 : Four Iron.

// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

{

SCRIPT_NAME serg1 


// Mission start stuff

GOSUB mission_start_serg1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_serg1_failed
ENDIF

GOSUB mission_cleanup_serg1

MISSION_END
 
// Variables for mission
VAR_INT golfblip
VAR_INT bodyguard1_s1 bodyguard2_s1 bodyguard3_s1 bodyguard4_s1 bodyguard5_s1 golfped_target
VAR_INT clothesblip
VAR_INT target_caddy other_caddy
VAR_INT caddy2_s1
VAR_INT golfped_target_blip
VAR_INT golfattendant
VAR_INT golfer1
VAR_INT	golfer2
VAR_INT	golfer3
VAR_INT golfer4
VAR_INT	golfer5
VAR_INT	golfer6
VAR_INT golfdriver_s1
VAR_INT golfdriver_car_s1

VAR_FLOAT escapex_s1 escapey_s1 escapez_s1 

VAR_INT golfcart1_s1
VAR_INT golfcart2_s1
VAR_INT golfcart3_s1
VAR_INT golfcart4_s1
VAR_INT bodyguard_golfcart


//VAR_FLOAT clothes_shopX clothes_shopY clothes_shopZ
VAR_FLOAT golf_x golf_y golf_z
VAR_FLOAT bodyguard1x_s1 bodyguard1y_s1 bodyguard1z_s1 
VAR_FLOAT bodyguard2x_s1 bodyguard2y_s1	bodyguard2z_s1
VAR_FLOAT bodyguard3x_s1 bodyguard3y_s1	bodyguard3z_s1
VAR_FLOAT bodyguard4x_s1 bodyguard4y_s1	bodyguard4z_s1
VAR_FLOAT bodyguard_golfcartx bodyguard_golfcarty bodyguard_golfcartz bodyguard_golfcart_heading
VAR_FLOAT bodyguard1_s1heading bodyguard2_s1heading bodyguard3_s1heading bodyguard4_s1heading
 
VAR_FLOAT golfped_targetx golfped_targety golfped_targetz
VAR_FLOAT loc_golfped_targetx loc_golfped_targety loc_golfped_targetz 
VAR_FLOAT ped_zed

VAR_FLOAT golfcart1x_s1 golfcart1y_s1 golfcart1z_s1
VAR_FLOAT golfcart2x_s1 golfcart2y_s1 golfcart2z_s1
VAR_FLOAT golfcart3x_s1 golfcart3y_s1 golfcart3z_s1
VAR_FLOAT golfcart4x_s1 golfcart4y_s1 golfcart4z_s1
VAR_FLOAT golfcart1heading_s1
VAR_FLOAT golfcart2heading_s1
VAR_FLOAT golfcart3heading_s1
VAR_FLOAT golfcart4heading_s1

//find car
//VAR_FLOAT findcarx_s1 findcary_s1 findcarz_s1 findcarx2_s1 findcary2_s1 
//VAR_INT newcar_s1 return_car_model_s1 playercar_s1

//rogue variables
VAR_FLOAT ped1_x ped1_y ped2_x ped2_y ped3_x ped3_y
VAR_INT mission_blip1 

//flags
VAR_INT has_player_been_to_clothes_shop
VAR_INT player_is_at_golf_club
VAR_INT target_in_caddy	newcar_s1

VAR_INT get_next_car
//VAR_INT char_is_attempting_to_get_in_car
VAR_INT char_is_in_car 
VAR_INT bg_is_in_car
VAR_INT char_outside_golf_club
//VAR_INT char_is_not_in_car

//bodyguard 3 get in car stuff
VAR_INT char_is_in_carbg3 newcarbg3_s1
VAR_INT golfped_targetcheck bodyguard3_check

//bodyguard 2 get in car stuff
VAR_INT char_is_in_carbg2 newcarbg2_s1 char_has_not_been_told

//bodyguard 5 stuff
VAR_INT got_out_of_car_flag_s1 bodyguard5_flag

VAR_INT bodyguard1_attack bodyguard2_attack bodyguard3_attack bodyguard4_attack

//////New get in car stuff
VAR_INT no_of_times_picked_a_new_car target_state char_has_seen_player keep_compiler_happy driver_s1 bodyguard_has_seen_player
VAR_FLOAT distancetocarx_s1 distancetocary_s1 distance_to_car_s1y distance_to_car_s1x  
VAR_FLOAT golfcaddyx_s1 golfcaddyy_s1 golfcaddyz_s1
VAR_FLOAT golfped_lx golfped_ly golfped_lz 
VAR_FLOAT how_far_is_car shortest_dist_s1 

															   
	 
VAR_INT	golfped_in_car_as_passenger
VAR_INT	golfped_in_car_as_driver
VAR_INT	got_out_of_car_flag_s1_pass
VAR_INT got_out_of_car_flag_s1_dr
VAR_INT create_escape_car 

VAR_INT playingaudio_s1
VAR_INT playingaudiostate_s1



VAR_INT niceaudio_s1 isnotme_s1
VAR_INT playingaudio1_s1
VAR_INT playingaudiostate1_s1
VAR_INT playingaudio2_s1
VAR_INT playingaudiostate2_s1 startsecgolf carwander_randomly_flag golfhelptext_s1 target_said_first_line player_is_shooting_a1
VAR_INT remove_guys_a1


//TEMP
//VAR_FLOAT clothes_shopX clothes_shopY clothes_shopZ

 

//timera
TIMERA = 0
 
// ****************************************Mission Start************************************

mission_start_serg1:

REGISTER_MISSION_GIVEN
LOAD_MISSION_TEXT serg1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 252.7968 -230.9387 9.8638 333.9001
flag_player_on_mission = 1
WAIT 0

WAIT 500

IF NOT IS_CHAR_DEAD scplayer
AND IS_PLAYER_WEARING player1 player4 // FIXMIAMI: add specific skin check

	UNDRESS_CHAR scplayer player

	LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF

//DO_FADE 1500 FADE_IN


// *****************************************Set Flags/variables************************************

has_player_been_to_clothes_shop = 0
///////////////////////////////player_is_at_golf_club = 0
player_is_at_golf_club = 0

target_in_caddy = 0
//char_is_attempting_to_get_in_car = 0
char_is_in_car = 5
char_is_in_carbg3 = 5

golfped_targetcheck = 0 
bodyguard3_check = 0

char_is_in_carbg2 = 5


bg_is_in_car = 0
char_outside_golf_club = 0 
//char_is_not_in_car = 0


char_has_not_been_told = 0
bodyguard_has_seen_player = 0
got_out_of_car_flag_s1_dr = 0
 
//////new
no_of_times_picked_a_new_car = 0
target_state = 0
char_has_seen_player = 0
keep_compiler_happy = 0
got_out_of_car_flag_s1 = 0 
bodyguard5_flag = 0

bodyguard1_attack = 0
bodyguard2_attack = 0
bodyguard3_attack = 0 
bodyguard4_attack = 0 

create_escape_car = 0	 
golfped_in_car_as_passenger = 0
golfped_in_car_as_driver = 0
got_out_of_car_flag_s1_pass = 0
got_out_of_car_flag_s1 = 0

get_next_car = 0
playingaudio_s1 = 0
playingaudiostate_s1 = 0
playingaudio1_s1 = 0
playingaudiostate1_s1 = 0
playingaudio2_s1 = 0
playingaudiostate2_s1 = 0

niceaudio_s1 = 0
isnotme_s1 = 0
startsecgolf = 0

carwander_randomly_flag = 0
golfhelptext_s1 = 0

target_said_first_line = 0
player_is_shooting_a1 = 0
remove_guys_a1 = 0

// *******************************************Set Coords*****************************************

clothes_shopX = 325.247864//94.725
clothes_shopY = 203.699646//268.87
clothes_shopZ = 10.398813//21.764	  

golf_x = 94.725
golf_y = 268.87
golf_z = 21.764

escapex_s1 = 101.989 
escapey_s1 = 251.821
escapez_s1 = 21.77

bodyguard1x_s1 = 80.339
bodyguard1y_s1 = 579.956 
bodyguard1z_s1 = 17.442
bodyguard1_s1heading = 319.5175

bodyguard2x_s1 = 78.689   
bodyguard2y_s1 = 582.528
bodyguard2z_s1 = 17.39414
bodyguard2_s1heading = 308.280

bodyguard3x_s1 = 85.716//84.192
bodyguard3y_s1 = 572.613//577.052
bodyguard3z_s1 = 17.574642//14.574
bodyguard3_s1heading = 304.955//315.461
					 
bodyguard4x_s1 = 74.674//78.011
bodyguard4y_s1 = 597.314//589.162
bodyguard4z_s1 = 17.574642//14.579
bodyguard4_s1heading = 238.371

bodyguard_golfcartx	= 83.422
bodyguard_golfcarty	= 596.1174
bodyguard_golfcartz	= 12.965
bodyguard_golfcart_heading = 231.757  

golfped_targetx = 79.1955//79.110748  
golfped_targety = 580.3671//581.038025
golfped_targetz = 17.4168//18.456

golfcart1x_s1 = 93.72506
golfcart1y_s1 = 563.45
golfcart1z_s1 = 13.175

golfcart2x_s1 = 95.591
golfcart2y_s1 = 561.284
golfcart2z_s1 = 13.133

golfcart3x_s1 = 98.84
golfcart3y_s1 = 557.794
golfcart3z_s1 = 13.04

golfcart4x_s1 = 95.518
golfcart4y_s1 = 573.821
golfcart4z_s1 = 13.087

golfcart1heading_s1 = 304.078
golfcart2heading_s1	= 308.830
golfcart3heading_s1	= 308.439
golfcart4heading_s1	= 17.252
// *******************************************SCRIPTED CUT ***********************************

// ********************************** SCRIPTED CUT - AVERY'S STRETCH ARRIVES ***************

SET_TIME_OF_DAY 10 00
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
SET_PLAYER_CONTROL player1 OFF // FIXMIAMI
SWITCH_WIDESCREEN ON // FIXMIAMI


CLEAR_AREA 299.0 -205.0 10.5 5.0 TRUE
CLEAR_AREA 305.0 -219.5 10.5 10.0 TRUE
SET_PLAYER_COORDINATES player1 299.0 -205.0 10.5
SET_PLAYER_HEADING player1 230.0
SET_FIXED_CAMERA_POSITION 297.0 -204.7 13.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 318.5 -219.23 22.4 JUMP_CUT
REQUEST_MODEL stretch
LOAD_SCENE 270.0 -218.0 13.4
WHILE NOT HAS_MODEL_LOADED stretch
	WAIT 0
ENDWHILE

CLEAR_AREA 306.9 -241.65 12.3 15.0 TRUE
CREATE_CAR stretch 306.9 -241.65 12.3 scripted_cut_limo
CHANGE_CAR_COLOUR scripted_cut_limo 0 0
SET_CAR_HEADING scripted_cut_limo 0.0


DO_FADE 1500 FADE_IN
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	SET_CAR_FORWARD_SPEED scripted_cut_limo 15.0
	SET_CAR_TEMP_ACTION scripted_cut_limo TEMPACT_GOFORWARD 8000
ENDIF
timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	POINT_CAMERA_AT_CAR scripted_cut_limo FIXED INTERPOLATION
ENDIF
timera = 0
WHILE timera < 3000
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	GET_CAR_COORDINATES scripted_cut_limo vect_x vect_y vect_z
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer vect_x vect_y   
ENDIF
DO_FADE 1500 FADE_OUT
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE
DELETE_CAR scripted_cut_limo
MARK_MODEL_AS_NO_LONGER_NEEDED stretch
RESTORE_CAMERA
SET_CHAR_OBJ_NO_OBJ scplayer
CHAR_SET_IDLE scplayer
TIMERA = 0


 // ****************************************START OF CUTSCENE********************************

VAR_INT cutscene_limo
VAR_INT gpasscut

LOAD_MISSION_AUDIO 1 MONO_6

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSavery

LOAD_SPECIAL_MODEL CUTOBJ01 cs_limo
LOAD_SPECIAL_MODEL CUTOBJ02 gpass

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
//LOAD_SPECIAL_MODEL cut_obj2 LAWYERH

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
//OR NOT HAS_MODEL_LOADED cut_obj2
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
	OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0
ENDWHILE


LOAD_CUTSCENE tex_1

SET_CUTSCENE_OFFSET 305.2 -211.9 11.3
SET_NEAR_CLIP 0.1

				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery

CREATE_CUTSCENE_OBJECT CUTOBJ01 cutscene_limo
SET_CUTSCENE_ANIM cutscene_limo cs_limo 

CREATE_CUTSCENE_OBJECT CUTOBJ02 gpasscut
SET_CUTSCENE_ANIM gpasscut gpass


//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1

//hide player
CLEAR_AREA 265.129 -234.531 11.107 1.0 TRUE
SET_PLAYER_COORDINATES player1 265.129 -234.531 11.1013
SET_PLAYER_HEADING player1 78.218376
REQUEST_COLLISION 265.129 -234.531 

//SET_AREA_VISIBLE VIS_STRIP_CLUB

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 1569
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_A ) 10000 1 //Come in and park yourself on the hide, son.
 
WHILE cs_time < 4896   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_B ) 10000 1 //Hell, my daddy used to say, never look a gift horse in the mouth, and by golly, he never did.

WHILE cs_time <  10768
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_C ) 10000 1 //Would you like a drop of the old Kentucky?
  
WHILE cs_time < 12947
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_D ) 10000 1 // No thanks.

WHILE cs_time < 13927
 	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_E ) 10000 1 //A clean thinker. I like that in a man! 

WHILE cs_time < 16556
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_F ) 10000 1 //Now, the property business isn't all about high-falootin paper pushing. 

WHILE cs_time < 20072
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_G ) 10000 1 //It's about dirt! And the will to claim that dirt! You with me, son?

WHILE cs_time < 24493
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_H ) 10000 1 //Oh yeah. 

WHILE cs_time < 25569
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_I ) 10000 1 //Well, I need some tenacious bastard to let go of some dirt. 
 
WHILE cs_time < 28462
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_J ) 10000 1 //And you look to me the kind of guy to persuade him.

   
WHILE cs_time < 31069
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_K ) 10000 1 //Persuasion's my forte  

WHILE cs_time < 32859
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_L ) 10000 1 //Yeh, he'll be down at the country club, down on the golf course. 

WHILE cs_time <  36053
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_M ) 10000 1 //They don't allow guns, so his bodyguards won't be packing lawgivers. 

WHILE cs_time < 40174
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_N ) 10000 1 //Go beat eight tons of crap out of him. 
   
WHILE cs_time < 42460
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX1_O ) 10000 1 //Here now- I got you a membership, and boy you're going to need more appropriate clothing.
  

WHILE cs_time < 47168 // number greater than last line of text  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS


DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
	ENDIF
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
RELEASE_WEATHER // FIXMIAMI: moved here from cleanup



SET_AREA_VISIBLE VIS_MAIN_MAP
SET_PLAYER_CONTROL player1 ON // FIXMIAMI

DO_FADE 1500 FADE_IN


// ****************************************END OF CUTSCENE**********************************

//remove clothes picups
REMOVE_PICKUP mansion_clothes 
REMOVE_PICKUP safehouse_clothes2
REMOVE_PICKUP clothes_pickup1
REMOVE_PICKUP clothes_pickup2
REMOVE_PICKUP clothes_pickup3
REMOVE_PICKUP clothes_pickup4
REMOVE_PICKUP clothes_pickup5
REMOVE_PICKUP clothes_pickup6
REMOVE_PICKUP clothes_pickup7
REMOVE_PICKUP clothes_pickup8
REMOVE_PICKUP clothes_pickup9
REMOVE_PICKUP clothes_pickup13

//get golf costume from clothes shop
IF has_player_been_to_clothes_shop = 0
	ADD_SPRITE_BLIP_FOR_COORD clothes_shopX clothes_shopY clothes_shopZ RADAR_SPRITE_TSHIRT clothesblip
	PRINT_NOW ( TEX1_1 ) 7000 2
	has_player_been_to_clothes_shop = 1
ENDIF


REQUEST_MODEL WMYGO
REQUEST_MODEL caddy
REQUEST_MODEL GOLFCLUB
REQUEST_MODEL greenwoo
 
WHILE NOT HAS_MODEL_LOADED WMYGO
	OR NOT HAS_MODEL_LOADED caddy
	OR NOT HAS_MODEL_LOADED GOLFCLUB
	OR NOT HAS_MODEL_LOADED greenwoo

	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 BGa
LOAD_SPECIAL_CHARACTER 2 BGb

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
WAIT 0
ENDWHILE


//SWITCH_ROADS_ON 162.0 245.0 18.0 166.0 250.0 25.0 //  Golf Club
//SWITCH_ROADS_ON 59.0 198.5 18.0 51.0 200.0 25.0 //  Golf Club
DELETE_OBJECT golf_gates
CREATE_OBJECT_NO_OFFSET golf_gatesopen 107.81 228.072 20.989 golf_gates
DONT_REMOVE_OBJECT golf_gates 

SHUT_PLAYER_UP player1 TRUE


SET_ENTER_CAR_RANGE_MULTIPLIER 2.5


IF keep_compiler_happy = 1 //will never equal 1
	CREATE_CAR caddy 226.4403 468.67059 12.067245 newcar_s1
ENDIF

						  
mission_sergio1_loop:


WAIT 0


IF has_player_been_to_clothes_shop = 1
	IF LOCATE_PLAYER_ON_FOOT_3D player1 clothes_shopX clothes_shopY clothes_shopZ 1.5 1.5 2.0 TRUE
		REMOVE_BLIP clothesblip

				
		SET_PLAYER_CONTROL player1 OFF
		SWITCH_WIDESCREEN ON

		//SET_FIXED_CAMERA_POSITION 331.071655 191.194565 13.007007 0.0 0.0 0.0
		//POINT_CAMERA_AT_POINT 330.835541 192.16037 12.90005 JUMP_CUT
		
		SET_FIXED_CAMERA_POSITION 322.194458 201.577209 14.570996 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 322.922852 202.132980 14.170328 JUMP_CUT

		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 328.338348 206.056854
		WAIT 1300


		DO_FADE 1500 FADE_OUT

		WAIT 1500


		IF NOT IS_CHAR_DEAD scplayer
			
			UNDRESS_CHAR scplayer player4

			LOAD_ALL_MODELS_NOW

			IF NOT IS_CHAR_DEAD scplayer
				DRESS_CHAR scplayer
			ENDIF

		ENDIF



		LOAD_MISSION_AUDIO 1 TEX1_3
		LOAD_MISSION_AUDIO 2 TEX1_4

		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
		OR NOT HAS_MISSION_AUDIO_LOADED 2
			WAIT 0
		ENDWHILE
		
		CLEAR_AREA 325.247864 283.699646 1.0 1.0 FALSE
		CLEAR_AREA 324.861084 203.391327 1.0 1.0 FALSE
		CLEAR_AREA_OF_CHARS 316.5 207.966 9.23 335.827728 190.550858 11.3988
		SET_CHAR_OBJ_NO_OBJ scplayer
		SET_PLAYER_COORDINATES player1 325.926544 204.200043 10.398813
		SET_PLAYER_HEADING player1 128.112198
		SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
		
		DO_FADE 1500 FADE_IN

		SET_FIXED_CAMERA_POSITION 324.861084 203.391327 11.268425 0.0 0.0 0.0 //ROTATE UP
		POINT_CAMERA_AT_POINT 325.552673 203.925049 10.781707 JUMP_CUT

		WAIT 1000
		
		SET_INTERPOLATION_PARAMETERS 5.0 3000
		SET_FIXED_CAMERA_POSITION 324.8610 203.391327 11.268425 0.0 0.0 0.0 //ROTATE UP
		POINT_CAMERA_AT_POINT 325.5336 203.910339 11.795979 INTERPOLATION


		TIMERB = 0

		WHILE NOT TIMERB > 5000
		WAIT 0

		IF TIMERB > 450
			IF niceaudio_s1 = 0
				
					PRINT_NOW ( TEX1_7 ) 5000 2
					IF playingaudiostate1_s1 = 0
						PLAY_MISSION_AUDIO 1
						playingaudiostate1_s1 = 1
					ENDIF
					
					IF playingaudiostate1_s1 = 1
						IF HAS_MISSION_AUDIO_FINISHED 1
							playingaudiostate1_s1 = 0
							CLEAR_MISSION_AUDIO 1
							playingaudio1_s1 = 1
							niceaudio_s1 = 1
						ENDIF
					ENDIF
			ENDIF
		ENDIF


		IF niceaudio_s1 = 1
			IF isnotme_s1 = 0
				SET_MISSION_AUDIO_POSITION 2 311.06 218.27 11.74 // FIXMIAMI: fix mission audio slot
				PRINT_NOW ( TEX1_6 ) 5000 2
				IF playingaudiostate2_s1 = 0
						PLAY_MISSION_AUDIO 2
						playingaudiostate2_s1 = 1
					ENDIF
					
					IF playingaudiostate2_s1 = 1
						IF HAS_MISSION_AUDIO_FINISHED 2 // FIXMIAMI: fix mission audio slot
							playingaudiostate2_s1 = 0
							CLEAR_MISSION_AUDIO 2 // FIXMIAMI: fix mission audio slot
							playingaudio2_s1 = 1
							isnotme_s1 = 1
						ENDIF
					ENDIF
			ENDIF
		ENDIF


		IF IS_BUTTON_PRESSED PAD1 cross
			GOTO endgolfchange
		ENDIF
			 
		ENDWHILE


		


	endgolfchange:
		IF NOT IS_WANTED_LEVEL_GREATER player1 2
           CLEAR_WANTED_LEVEL player1
        ENDIF

		SET_CHAR_OBJ_NO_OBJ scplayer
		CLEAR_SMALL_PRINTS
		CLEAR_MISSION_AUDIO 1
		CLEAR_MISSION_AUDIO 2
		has_player_been_to_clothes_shop = 2

	ENDIF
ENDIF


//get to golf club
IF has_player_been_to_clothes_shop = 2
	hack_play_on_a_mission = 1 // FIXMIAMI
	IF TIMERA > 4000
		STOP_PLAYER_LOOKING Player1
		SET_CAMERA_IN_FRONT_OF_PLAYER
		RESTORE_CAMERA_JUMPCUT
		SET_PLAYER_CONTROL player1 ON
		SWITCH_WIDESCREEN OFF
		ADD_BLIP_FOR_COORD 100.5953 251.2470 20.7290 golfblip
	   //	CHANGE_BLIP_COLOUR golfblip GREEN
		PRINT_NOW ( TEX1_2 ) 7000 2
		has_player_been_to_clothes_shop = 3
	ENDIF
ENDIF	

IF has_player_been_to_clothes_shop = 3
	//IF LOCATE_PLAYER_ANY_MEANS_3D player1 97.818901 259.234283 20.75886/*golf_x golf_y golf_z*/ 5.0 5.0 5.0 FALSE
	IF player_is_at_golf_club = 0
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 100.5953 251.2470 20.7290 2.0 2.0 3.0 TRUE
			REMOVE_BLIP golfblip
			SWITCH_WIDESCREEN ON
			SET_PLAYER_CONTROL player1 OFF
			player_is_at_golf_club = 1
		ENDIF
	ENDIF																		   
ENDIF

IF golfhelptext_s1 = 0
	IF IS_PLAYER_IN_MODEL player1 caddy
		PRINT_HELP TEX1_8
		SET_RADIO_CHANNEL RADIO_ESPANTOSO -1
		golfhelptext_s1 = 1
	ENDIF
ENDIF
	


//create the target and his bodyguards
IF player_is_at_golf_club = 1
	
		DO_FADE 1000 FADE_OUT
		
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		
		SET_WANTED_MULTIPLIER 0.1
		ALTER_WANTED_LEVEL player1 0 
										
		CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 bodyguard1x_s1 bodyguard1y_s1 bodyguard1z_s1 bodyguard1_s1
	  	GIVE_WEAPON_TO_CHAR bodyguard1_s1 WEAPONTYPE_GOLFCLUB 3000
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER bodyguard1_s1 TRUE
		SET_CHAR_HEALTH bodyguard1_s1 250 
		SET_CHAR_HEADING bodyguard1_s1 bodyguard1_s1heading
				
		CREATE_CHAR PEDTYPE_SPECIAL SPECIAL02 bodyguard2x_s1 bodyguard2y_s1 bodyguard2z_s1 bodyguard2_s1
	  	GIVE_WEAPON_TO_CHAR bodyguard2_s1 WEAPONTYPE_GOLFCLUB 3000
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER bodyguard2_s1 TRUE
		SET_CHAR_HEALTH bodyguard2_s1 250
		SET_CHAR_HEADING bodyguard2_s1 bodyguard1_s1heading
				
		CREATE_CHAR PEDTYPE_SPECIAL SPECIAL01 bodyguard3x_s1 bodyguard3y_s1 bodyguard3z_s1 bodyguard3_s1
	  	GIVE_WEAPON_TO_CHAR bodyguard3_s1 WEAPONTYPE_GOLFCLUB 3000
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER bodyguard3_s1 TRUE
		SET_CHAR_HEALTH bodyguard3_s1 250
		SET_CHAR_HEADING bodyguard3_s1 bodyguard1_s1heading
				
		CREATE_CHAR PEDTYPE_SPECIAL SPECIAL02 bodyguard4x_s1 bodyguard4y_s1 bodyguard4z_s1 bodyguard4_s1
	  	GIVE_WEAPON_TO_CHAR bodyguard4_s1 WEAPONTYPE_GOLFCLUB 3000
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER bodyguard4_s1 TRUE
		SET_CHAR_HEALTH bodyguard4_s1 250
		SET_CHAR_HEADING bodyguard4_s1 bodyguard1_s1heading
			   						
		CREATE_CHAR PEDTYPE_CIVMALE WMYGO golfped_targetx golfped_targety golfped_targetz golfped_target

		GIVE_WEAPON_TO_CHAR golfped_target WEAPONTYPE_GOLFCLUB 3000
		CLEAR_CHAR_THREAT_SEARCH golfped_target
		SET_CHAR_HEALTH golfped_target 250
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER golfped_target TRUE
		ADD_BLIP_FOR_CHAR golfped_target golfped_target_blip
	   	SET_CHAR_HEADING golfped_target 56.6491
			   	
		CREATE_CAR caddy golfcart1x_s1 golfcart1y_s1 golfcart1z_s1 golfcart1_s1
		CAR_SET_IDLE golfcart1_s1
		SET_CAR_HEADING golfcart1_s1 golfcart1heading_s1

		CREATE_CAR caddy golfcart2x_s1 golfcart2y_s1 golfcart2z_s1 golfcart2_s1
		CAR_SET_IDLE golfcart2_s1
		SET_CAR_HEADING golfcart2_s1 golfcart2heading_s1

		CREATE_CAR caddy golfcart3x_s1 golfcart3y_s1 golfcart3z_s1 golfcart3_s1
		CAR_SET_IDLE golfcart3_s1
		SET_CAR_HEADING golfcart3_s1 golfcart3heading_s1

		CREATE_CAR caddy golfcart4x_s1 golfcart4y_s1 golfcart4z_s1 golfcart4_s1
		CAR_SET_IDLE golfcart4_s1
		SET_CAR_HEADING golfcart4_s1 golfcart4heading_s1
		
		CREATE_CAR caddy bodyguard_golfcartx bodyguard_golfcarty bodyguard_golfcartz bodyguard_golfcart
		CREATE_CHAR_INSIDE_CAR bodyguard_golfcart PEDTYPE_SPECIAL SPECIAL01 bodyguard5_s1
		SET_CHAR_PERSONALITY bodyguard5_s1 PEDSTAT_TOUGH_GUY
		CAR_SET_IDLE bodyguard_golfcart
		SET_CAR_HEADING bodyguard_golfcart bodyguard_golfcart_heading
		
		CREATE_CAR caddy 96.9997 301.46 19.448 caddy2_s1

		LOAD_SCENE 109.957672 573.540283 16.592073
	  	
	  	WAIT 500
	  		
		DO_FADE 1000 FADE_IN
		
		SET_FIXED_CAMERA_POSITION 108.709763 563.467224 16.374695 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 107.773109 563.7945507 16.250055 JUMP_CUT
	  	  
		TIMERA = 0

		WHILE TIMERA < 3000
			   			   
		WAIT 0
			
		PRINT_NOW ( TEX1_0 ) 10000 2
								
		IF IS_BUTTON_PRESSED PAD1 cross
		AND TIMERA > 1000
			GOTO end_of_golf_cutscene
		ENDIF
		
		ENDWHILE
				
		SET_FIXED_CAMERA_POSITION 82.779160 583.353394 18.749277 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 81.941216 582.814148 18.665253 JUMP_CUT

		TIMERA = 0
		
		IF NOT IS_CHAR_DEAD golfped_target
			SET_CHAR_WAIT_STATE golfped_target WAITSTATE_GROUND_ATTACK -1
		ENDIF
						
		WHILE TIMERA < 2500

		WAIT 0
			
		IF IS_BUTTON_PRESSED PAD1 cross
			GOTO end_of_golf_cutscene
		ENDIF
				
		ENDWHILE
			
			

		end_of_golf_cutscene:


		CLEAR_AREA 100.1102 254.2736 20.7242 1.0 FALSE
		CLEAR_THIS_PRINT TEX1_0
		RESTORE_CAMERA_JUMPCUT
		SET_CAMERA_BEHIND_PLAYER
		
		IF NOT IS_CHAR_DEAD golfped_target
			SET_CHAR_WAIT_STATE golfped_target WAITSTATE_FALSE 100
		ENDIF
		
		SWITCH_WIDESCREEN OFF
		SET_PLAYER_CONTROL player1 ON

		player_is_at_golf_club = 2

ENDIF

					 

			 //////////////////////////////////////////////////		BODYGUARD AUDIO		////////////////////////////////////////////////
IF player_is_at_golf_club = 2
	IF NOT IS_CHAR_DEAD	bodyguard1_s1
		
		//first comment
		IF playingaudio_s1 = 0
			IF target_said_first_line = 1
				playingaudio_s1 = 2
				playingaudiostate_s1 = 0
			ENDIF
		ENDIF

		//second comment
		IF playingaudio_s1 = 0
			IF target_said_first_line = 2
				playingaudio_s1 = 3
				playingaudiostate_s1 = 0
			ENDIF
		ENDIF



		IF playingaudio_s1 = 2
			   	
				 IF playingaudiostate_s1 = 0
					 LOAD_MISSION_AUDIO 1 TEX1_5
					 playingaudiostate_s1 = 1
				 ELSE

					IF playingaudiostate_s1 = 1
						IF HAS_MISSION_AUDIO_LOADED 1
							playingaudiostate_s1 = 2
						ENDIF
					ENDIF

					IF playingaudiostate_s1 = 2
				 
						PRINT_NOW ( TEX1_9 ) 5000 1	   //Get him!
						PLAY_MISSION_AUDIO 1
						playingaudiostate_s1 = 3
					ENDIF

					IF playingaudiostate_s1 = 3
						IF HAS_MISSION_AUDIO_FINISHED 1
							playingaudiostate_s1 = 0
							playingaudio_s1 = 0
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT TEX1_9
							target_said_first_line = 2
						ENDIF
					ENDIF
				ENDIF
		ENDIF

		IF playingaudio_s1 = 3
			   	
				 IF playingaudiostate_s1 = 0
					 LOAD_MISSION_AUDIO 1 TEX1_6
					 playingaudiostate_s1 = 1
				 ELSE

					IF playingaudiostate_s1 = 1
						IF HAS_MISSION_AUDIO_LOADED 1
							playingaudiostate_s1 = 2
						ENDIF
					ENDIF

					IF playingaudiostate_s1 = 2
				 
						PRINT_NOW ( TEX1_10 ) 5000 1	   //Kill that Psycho!
				 		PLAY_MISSION_AUDIO 1
						playingaudiostate_s1 = 3
					ENDIF

					IF playingaudiostate_s1 = 3
						IF HAS_MISSION_AUDIO_FINISHED 1
							playingaudiostate_s1 = 0
							playingaudio_s1 = 0
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT TEX1_10
							target_said_first_line = 3
						ENDIF
					ENDIF
				ENDIF
		ENDIF


	ELSE	//	bodyguard dies
			
			IF playingaudio_s1 = 2
				playingaudiostate_s1 = 0
				playingaudio_s1 = 0
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT TEX1_9
				target_said_first_line = 2
			ENDIF

			IF playingaudio_s1 = 3
				playingaudiostate_s1 = 0
				playingaudio_s1 = 0
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT TEX1_10
				target_said_first_line = 3
			ENDIF

	ENDIF
ENDIF


			////////////////////////////////////////////////////	SWINGING HIS CLUB	////////////////////////////////////////////////////
IF player_is_at_golf_club = 2
	IF char_has_seen_player = 0

		IF TIMERA > 1500
			IF NOT IS_CHAR_DEAD golfped_target
				SET_CHAR_WAIT_STATE golfped_target WAITSTATE_GROUND_ATTACK -1
			ENDIF
		ENDIF

		IF TIMERA > 4000
			IF NOT IS_CHAR_DEAD golfped_target
				SET_CHAR_WAIT_STATE golfped_target WAITSTATE_FALSE 100
				TIMERA = 0
			ENDIF
		ENDIF

	ENDIF
ENDIF

			 ///////////////// GETTING THE TARGET TO LEG IT INTO THE NEAREST GOLFCART TO THE CAR AND OUT OF THE GOLF CLUB ////////////////

/*
target_state 
0 - neutral
1 - attempting to get in a car
2 - in car for the first time
3 - in car and driving
4 - goto coord on foot
5 - goto exit direct
*/

IF NOT IS_CHAR_DEAD golfped_target
	IF player_is_at_golf_club = 2
			
		//has seen player so makes a run for it	
		IF char_has_seen_player = 0
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 golfped_target 9.5 9.5 1.0 FALSE
			OR bodyguard_has_seen_player = 1
				SET_CHAR_WAIT_STATE golfped_target WAITSTATE_FALSE 100
				SET_CHAR_OBJ_RUN_TO_COORD golfped_target 86.6450 584.7784 
				playingaudio_s1 = 1
				char_has_seen_player = 1
				bodyguard_has_seen_player = 1
				TIMERB = 0
				TIMERA = 0
			ENDIF
		ENDIF


		//playing audio
		IF playingaudio_s1 = 1

			IF NOT IS_CHAR_DEAD golfped_target		

				IF playingaudiostate_s1 = 0
					 LOAD_MISSION_AUDIO 1 TEX1_1
					 playingaudiostate_s1 = 1
				ELSE
								
					IF playingaudiostate_s1 = 1
						IF HAS_MISSION_AUDIO_LOADED 1
							playingaudiostate_s1 = 2
						ENDIF
					ENDIF

					IF playingaudiostate_s1 = 2
						PRINT_NOW ( TEX1_3 ) 5000 1	   //Who is this guy? Boys deal with him!
						PLAY_MISSION_AUDIO 1
						playingaudiostate_s1 = 3
					ENDIF
					
					IF playingaudiostate_s1 = 3
						IF HAS_MISSION_AUDIO_FINISHED 1
							playingaudiostate_s1 = 0
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT TEX1_3
							playingaudio_s1 = 0
							target_said_first_line = 1
						ENDIF
					ENDIF
				ENDIF
								
			ELSE
			   IF playingaudio_s1 = 1
				   CLEAR_MISSION_AUDIO 1
				   CLEAR_THIS_PRINT TEX1_3
				   char_has_seen_player = 1
				   playingaudiostate_s1 = 0
				   playingaudio_s1 = 0
				   target_said_first_line = 1
			   ENDIF
			ENDIF

		ENDIF





		//guy is at steps tell him to pick a car
		IF char_has_seen_player = 1
			IF LOCATE_CHAR_ON_FOOT_3D golfped_target 86.6450 584.7784 13.3303 7.0 7.0 2.0 FALSE
				char_has_seen_player = 2
				GOSUB pick_a_car
				
			ENDIF
		ENDIF


		//get in a car if not in car at first attempt
		IF char_has_seen_player = 2
			
			IF target_state = 1
				IF IS_CHAR_ON_FOOT golfped_target
					GOSUB pick_a_car
				ELSE
					IF NOT IS_CAR_DEAD newcar_s1 
						IF IS_CHAR_SITTING_IN_CAR golfped_target newcar_s1
							SET_CAR_CRUISE_SPEED newcar_s1 22.0
							SET_CAR_DRIVING_STYLE newcar_s1 DRIVINGMODE_AVOIDCARS
							CAR_WANDER_RANDOMLY newcar_s1
							TIMERA = 0 
							target_state = 3
						ELSE
							IF NOT LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target newcar_s1 35.0 35.0 FALSE
								GOSUB pick_a_car
							ENDIF

							IF NOT IS_CAR_DEAD newcar_s1
								IF IS_PLAYER_IN_CAR player1 newcar_s1
								AND NOT LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target newcar_s1 5.0 5.0 FALSE
									GOSUB pick_a_car
								ENDIF
							ENDIF
							
						ENDIF
					ENDIF
				ENDIF
			ENDIF


			IF target_state = 3
				IF NOT IS_CAR_DEAD newcar_s1
					IF NOT IS_CHAR_IN_CAR golfped_target newcar_s1
						GOSUB pick_a_car
					ENDIF
				ENDIF
			ENDIF
			
			//out of car
			IF target_state = 4
				IF TIMERB > 1000
					IF NOT IS_CHAR_DEAD golfped_target
						CHAR_FOLLOW_PATH golfped_target golf_x golf_y golf_z 2.0 RUN
					ENDIF
					TIMERB = 0
				ENDIF
			ENDIF

			//located near the exit
			IF target_state = 4
				IF LOCATE_CHAR_ANY_MEANS_2D golfped_target 96.0986 265.837 27.0 27.0 FALSE
				  	target_state = 5				
				ENDIF
			ENDIF
			
			//in a car wander around for a bit
			IF target_state = 3
				IF TIMERA > 75000
					IF NOT IS_CAR_DEAD newcar_s1
						IF IS_CHAR_SITTING_IN_CAR golfped_target newcar_s1
							CAR_GOTO_COORDINATES newcar_s1 88.973 280.343994 21.395437//escapex_s1 escapey_s1 escapez_s1  
						ENDIF
					ENDIF
				ENDIF
			ENDIF
 
					
			//located near exit in caddy			
			IF target_state = 3
				IF LOCATE_CHAR_ANY_MEANS_2D golfped_target 96.0986 265.837 27.0 27.0 FALSE
					IF IS_CHAR_IN_ANY_CAR golfped_target
						SET_CHAR_OBJ_LEAVE_ANY_CAR golfped_target
						SET_CHAR_RUNNING golfped_target TRUE
						target_state = 5
					ENDIF
				ENDIF
			ENDIF
			
			//run through exit	
			IF target_state = 5
				IF NOT IS_CHAR_DEAD golfped_target
					IF NOT IS_CHAR_IN_ANY_CAR golfped_target
						IF TIMERA > 1000
							CHAR_FOLLOW_PATH golfped_target escapex_s1 escapey_s1 escapez_s1 1.0 RUN
							TIMERA = 0
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF target_state = 5
				IF startsecgolf = 0

					IF NOT IS_CHAR_DEAD security_bloke1
						SET_CHAR_HEALTH security_bloke1 89
					ENDIF

					IF NOT IS_CHAR_DEAD security_bloke2
						SET_CHAR_HEALTH security_bloke2 89
					ENDIF
					
					startsecgolf = 1
				ENDIF
			ENDIF
			


			
		ENDIF

	ENDIF
ENDIF
	


			////////////////////////	BODYGUARDS ATTEMPT TO GET PLAYER IF HE CLOSES IN   ///////////////////////////////

IF bodyguard1_attack = 0
	IF NOT IS_CHAR_DEAD bodyguard1_s1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 bodyguard1_s1 10.0 10.0 0.6 FALSE
		OR bodyguard_has_seen_player = 1
		OR IS_CHAR_DEAD bodyguard2_s1
		OR IS_CHAR_DEAD bodyguard3_s1
		OR IS_CHAR_DEAD bodyguard4_s1
			SET_CHAR_WAIT_STATE bodyguard1_s1 WAITSTATE_FALSE 0
			SET_CHAR_PERSONALITY bodyguard1_s1 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH bodyguard1_s1 THREAT_PLAYER1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard1_s1 player1
			bodyguard1_attack = 1
		ENDIF
	ENDIF
ENDIF

IF bodyguard2_attack = 0
	IF NOT IS_CHAR_DEAD bodyguard2_s1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 bodyguard2_s1 10.0 10.0 0.6 FALSE
		OR bodyguard_has_seen_player = 1
		OR IS_CHAR_DEAD bodyguard1_s1
		OR IS_CHAR_DEAD bodyguard3_s1
		OR IS_CHAR_DEAD bodyguard4_s1
			SET_CHAR_WAIT_STATE bodyguard2_s1 WAITSTATE_FALSE 0
			SET_CHAR_PERSONALITY bodyguard2_s1 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH bodyguard2_s1 THREAT_PLAYER1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard2_s1 player1
			bodyguard2_attack = 1
		ENDIF
	ENDIF
ENDIF

IF bodyguard3_attack = 0
	IF NOT IS_CHAR_DEAD bodyguard3_s1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 bodyguard3_s1 5.0 5.0 0.6 FALSE
		OR bodyguard_has_seen_player = 1
		OR IS_CHAR_DEAD bodyguard1_s1
		OR IS_CHAR_DEAD bodyguard2_s1
		OR IS_CHAR_DEAD bodyguard4_s1
			bodyguard_has_seen_player = 1
			SET_CHAR_WAIT_STATE bodyguard3_s1 WAITSTATE_FALSE 0
			SET_CHAR_PERSONALITY bodyguard3_s1 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH bodyguard3_s1 THREAT_PLAYER1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard3_s1 player1
			bodyguard3_attack = 1
		ENDIF
	ENDIF
ENDIF

IF bodyguard4_attack = 0
	IF NOT IS_CHAR_DEAD bodyguard4_s1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 bodyguard4_s1 5.0 5.0 0.6 FALSE
		OR bodyguard_has_seen_player = 1
		OR IS_CHAR_DEAD bodyguard1_s1
		OR IS_CHAR_DEAD bodyguard2_s1
		OR IS_CHAR_DEAD bodyguard3_s1
			SET_CHAR_WAIT_STATE bodyguard4_s1 WAITSTATE_FALSE 0
			SET_CHAR_PERSONALITY bodyguard4_s1 PEDSTAT_TOUGH_GUY
			SET_CHAR_THREAT_SEARCH bodyguard4_s1 THREAT_PLAYER1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard4_s1 player1
			bodyguard_has_seen_player = 1
			bodyguard4_attack = 1
		ENDIF
	ENDIF
ENDIF


//player shoots in angled area
IF player_is_at_golf_club = 2
	IF IS_PLAYER_IN_ANGLED_AREA_2D player1 64.8222 613.6588 96.7488 550.3496 20.0 FALSE
		IF IS_PLAYER_SHOOTING player1
			IF player_is_shooting_a1 = 0
				bodyguard_has_seen_player = 1
				player_is_shooting_a1 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF	



//bodyguard 5 in car only attacks once conditions are passed
IF bodyguard5_flag = 0
	IF NOT IS_CHAR_DEAD golfped_target
		IF NOT IS_CHAR_DEAD bodyguard5_s1
			IF NOT IS_CAR_DEAD bodyguard_golfcart
				IF IS_CHAR_IN_CAR bodyguard5_s1 bodyguard_golfcart			
					IF NOT LOCATE_CHAR_ANY_MEANS_CHAR_3D bodyguard5_s1 golfped_target 30.0 30.0 30.0 FALSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 bodyguard5_s1 25.0 25.0 6.0 FALSE
						OR bodyguard_has_seen_player = 1
						OR NOT LOCATE_CHAR_ANY_MEANS_2D bodyguard5_s1 bodyguard_golfcartx bodyguard_golfcarty 1.5 1.5 FALSE
							SET_CAR_CRUISE_SPEED bodyguard_golfcart 24.0
							SET_CAR_MISSION bodyguard_golfcart MISSION_RAMPLAYER_FARAWAY
 							bodyguard5_flag = 1
							bodyguard_has_seen_player = 1
						ENDIF
					ENDIF
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard5_s1 player1 //if player drags him out before he is told to attack
					bodyguard5_flag = 1
					bodyguard_has_seen_player = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//target gets out of his golf cart when near exit
IF bodyguard5_flag = 1
	
	IF NOT IS_CHAR_DEAD bodyguard5_s1 
		IF LOCATE_CHAR_IN_CAR_2D bodyguard5_s1 96.0986 265.837 35.0 35.0 FALSE
			SET_CHAR_OBJ_LEAVE_ANY_CAR bodyguard5_s1
		ENDIF
	ENDIF
		
	IF NOT IS_CHAR_DEAD bodyguard5_s1
		 IF NOT IS_CHAR_IN_ANY_CAR bodyguard5_s1
	 		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bodyguard5_s1 player1	 
	 		bodyguard5_flag = 2
		 ENDIF
	ENDIF
	
ENDIF

			 



								///////////////////////////////	CREATE AND CONTROL ESCAPE CAR FOR TARGET	/////////////////////

IF create_escape_car = 0
	IF char_has_seen_player > 0
	
		CLEAR_AREA 102.908 246.514 21.6 3.0 FALSE
		CREATE_CAR greenwoo 102.111 248.316 21.5 golfdriver_car_s1
		SET_CAR_HEADING golfdriver_car_s1 290.299
		CREATE_CHAR_INSIDE_CAR golfdriver_car_s1 PEDTYPE_SPECIAL SPECIAL02 golfdriver_s1

		SET_CHAR_PERSONALITY golfdriver_s1 PEDSTAT_TOUGH_GUY
		CAR_SET_IDLE golfdriver_car_s1
		SET_CAR_ONLY_DAMAGED_BY_PLAYER golfdriver_car_s1 TRUE 
		create_escape_car = 1

	ENDIF 
ENDIF
 


IF target_state = 5													  
	IF NOT IS_CHAR_DEAD golfped_target
		IF NOT IS_CAR_DEAD golfdriver_car_s1
			IF LOCATE_CHAR_ON_FOOT_2D golfped_target escapex_s1 escapey_s1 5.0 5.0 FALSE
				IF LOCATE_CHAR_ANY_MEANS_CAR_2D golfped_target golfdriver_car_s1 20.0 20.0 FALSE
					IF NOT IS_CHAR_DEAD golfdriver_s1
						IF IS_CHAR_SITTING_IN_CAR golfdriver_s1 golfdriver_car_s1
							SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER golfped_target golfdriver_car_s1
							golfped_in_car_as_passenger = 1
							target_state = 6
						ELSE
							golfped_in_car_as_driver = 1
							target_state = 6
						ENDIF
					ELSE
						golfped_in_car_as_driver = 1
						target_state = 6
					ENDIF
				ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
					target_state = 6
				ENDIF

			ENDIF
		ELSE
			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
			target_state = 6
		ENDIF
	ENDIF
ENDIF 
				  
//get in car as passenger
IF golfped_in_car_as_passenger = 1
	IF NOT IS_CHAR_DEAD golfped_target
	
		IF got_out_of_car_flag_s1_pass = 0
			IF NOT IS_CAR_DEAD golfdriver_car_s1
				IF NOT IS_PLAYER_IN_CAR player1 golfdriver_car_s1
					IF NOT IS_CHAR_DEAD golfdriver_s1
						IF IS_CHAR_SITTING_IN_CAR golfdriver_s1 golfdriver_car_s1
							IF IS_CHAR_SITTING_IN_CAR golfped_target golfdriver_car_s1
								SET_CAR_CRUISE_SPEED golfdriver_car_s1 26.5
								SET_CAR_DRIVING_STYLE golfdriver_car_s1 DRIVINGMODE_AVOIDCARS
								CAR_GOTO_COORDINATES golfdriver_car_s1 18.47 -1420.258 10.318
								got_out_of_car_flag_s1_pass = 1
							ENDIF
						ENDIF
					ENDIF
				ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
				ENDIF
			ENDIF
		ENDIF

		IF got_out_of_car_flag_s1_pass = 1
		OR got_out_of_car_flag_s1_pass = 2
			IF NOT IS_CHAR_IN_ANY_CAR golfped_target
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
			ENDIF
		ENDIF

		IF got_out_of_car_flag_s1_pass = 1
			IF NOT IS_CAR_DEAD golfdriver_car_s1
				IF NOT IS_CHAR_DEAD golfdriver_s1
					IF IS_CHAR_SITTING_IN_CAR golfdriver_s1 golfdriver_car_s1
						IF NOT IS_CHAR_DEAD golfped_target
							IF IS_CHAR_SITTING_IN_CAR golfped_target golfdriver_car_s1
								IF LOCATE_CAR_2D golfdriver_car_s1 18.47 -1420.258 15.0 15.0 FALSE
								   CAR_WANDER_RANDOMLY golfdriver_car_s1
								   got_out_of_car_flag_s1_pass = 2
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

	ENDIF
ENDIF


//get in car as driver
IF golfped_in_car_as_driver = 1
	IF NOT IS_CHAR_DEAD golfped_target
		
		IF got_out_of_car_flag_s1_dr = 0
			IF NOT IS_CHAR_IN_ANY_CAR golfped_target
			 	IF NOT IS_CAR_DEAD golfdriver_car_s1
			 		IF NOT IS_PLAYER_IN_CAR player1 golfdriver_car_s1
			 			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER golfped_target golfdriver_car_s1
			 			SET_CHAR_RUNNING golfped_target TRUE
			 			got_out_of_car_flag_s1_dr = 1
			 		ELSE
			 			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
			 		ENDIF
				ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
				ENDIF
			ENDIF
		ENDIF
		

		IF got_out_of_car_flag_s1_dr = 1
			IF NOT IS_CAR_DEAD golfdriver_car_s1
				IF IS_CHAR_IN_CAR golfped_target golfdriver_car_s1
					SET_CAR_CRUISE_SPEED golfdriver_car_s1 24.0
					SET_CAR_DRIVING_STYLE golfdriver_car_s1 DRIVINGMODE_AVOIDCARS
					CAR_GOTO_COORDINATES golfdriver_car_s1 18.47 -1420.258 10.318
					got_out_of_car_flag_s1_dr = 2
			   	ELSE
					SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
				ENDIF
			ENDIF
		ENDIF

		IF got_out_of_car_flag_s1_dr = 2
			IF NOT IS_CAR_DEAD golfdriver_car_s1
				IF IS_CHAR_SITTING_IN_CAR golfped_target golfdriver_car_s1
					IF LOCATE_CAR_2D golfdriver_car_s1 18.47 -1420.258 15.0 15.0 FALSE
					   CAR_WANDER_RANDOMLY golfdriver_car_s1
					   got_out_of_car_flag_s1_dr = 3
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		IF got_out_of_car_flag_s1_dr = 2
		OR got_out_of_car_flag_s1_dr = 3
			IF NOT IS_CHAR_IN_ANY_CAR golfped_target
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS golfped_target player1
			ENDIF
		ENDIF

	ENDIF
ENDIF


//if the driver is out of the car
IF NOT IS_CHAR_DEAD golfdriver_s1
	IF NOT IS_CHAR_IN_ANY_CAR golfdriver_s1
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS golfdriver_s1 player1
		SET_CHAR_RUNNING golfdriver_s1 TRUE
	ENDIF
ENDIF
	   	
									/////////////////////////// MOVE GUYS IF NOT IN GOLF ZONE	/////////////////////////

IF target_state = 6
	IF remove_guys_a1 = 0
		IF NOT IS_PLAYER_IN_ZONE player1 GOLFC
			MARK_CAR_AS_NO_LONGER_NEEDED golfcart1_s1
			MARK_CAR_AS_NO_LONGER_NEEDED golfcart2_s1
			MARK_CAR_AS_NO_LONGER_NEEDED golfcart3_s1
			MARK_CAR_AS_NO_LONGER_NEEDED golfcart4_s1
			MARK_CAR_AS_NO_LONGER_NEEDED caddy2_s1
			MARK_CAR_AS_NO_LONGER_NEEDED bodyguard_golfcart
			MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard1_s1  
			MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard2_s1
			MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard3_s1
			MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard4_s1
			MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard5_s1
			remove_guys_a1 = 1
		ENDIF
	ENDIF
ENDIF
  				
		  							///////////////////////////	MISSION PASS AND FAIL STUFF //////////////////////////////

//player wins if they kill him
IF IS_CHAR_DEAD golfped_target
	IF player_is_at_golf_club > 1
		GOTO mission_serg1_passed
	ENDIF
ENDIF

//goes out of range	
IF target_state > 5
	IF NOT IS_CHAR_DEAD golfped_target
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 golfped_target 210.0 210.0 FALSE
			IF NOT IS_CHAR_ON_SCREEN golfped_target
				PRINT_NOW ( TEX1_5 ) 5000 1
				GOTO mission_serg1_failed
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO mission_sergio1_loop 



// **********************************************Mission Serg1 failed*****************************************
mission_serg1_failed:

PRINT_BIG ( M_FAIL ) 5000 1

RETURN

   

// **********************************************Mission Serg1 passed*****************************************

mission_serg1_passed:

flag_sergio_mission1_passed = 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 500 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 500
REGISTER_MISSION_PASSED TEX_1
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT serg_mission2_loop
CREATE_CLOTHES_PICKUP 106.5 253.0 21.7 4 clothes_pickup4
clothes4_created = 1
START_NEW_SCRIPT cloth3
RETURN
		


// **********************************************Mission cleanup***********************************************

mission_cleanup_serg1:

flag_player_on_mission = 0
SHUT_PLAYER_UP player1 FALSE
SET_PLAYER_CONTROL player1 on
//SWITCH_ROADS_ON 100.0 246.0 21.787 109.868 243.785 21.787
MARK_MODEL_AS_NO_LONGER_NEEDED WMYGO
MARK_MODEL_AS_NO_LONGER_NEEDED caddy
MARK_MODEL_AS_NO_LONGER_NEEDED golfclub
MARK_MODEL_AS_NO_LONGER_NEEDED greenwoo
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
REMOVE_BLIP golfped_target_blip
REMOVE_BLIP clothesblip
REMOVE_BLIP golfblip
CLEAR_MISSION_AUDIO 1
IF hack_play_on_a_mission = 0 // FIXMIAMI
	CLEAR_MISSION_AUDIO 2
ENDIF // FIXMIAMI
hack_play_on_a_mission = 0 // FIXMIAMI

IF mansion_clothes_created = 1
	CREATE_CLOTHES_PICKUP -384.5 -591.9 25.3 1 mansion_clothes   
ENDIF 

IF hotel_clothes_created = 1                                                                                                                                                                   
    CREATE_CLOTHES_PICKUP 226.4 -1265.6 20.1 1 clothes_pickup1
ENDIF

IF safehouse_created2 = 1
	CREATE_CLOTHES_PICKUP -820.2 1364.1 66.4 1 safehouse_clothes2   
ENDIF 

IF clothes2_created = 1
   CREATE_CLOTHES_PICKUP 97.5 -1133.6 10.4 2 clothes_pickup2
ENDIF

IF clothes3_created = 1
   CREATE_CLOTHES_PICKUP 364.2 1086.1 19.0 3 clothes_pickup3
ENDIF

IF clothes4_created = 1
	IF NOT flag_sergio_mission1_passed = 1
	   CREATE_CLOTHES_PICKUP 106.5 253.0 21.7 4 clothes_pickup4
	ENDIF
ENDIF

IF clothes5_created = 1
   CREATE_CLOTHES_PICKUP -1025.2 -429.2 10.8 5 clothes_pickup5 // FIXMIAMI: fix cuban skin pickup location
ENDIF

IF clothes6_created = 1
	CREATE_CLOTHES_PICKUP 405.7 -485.6 12.3 6 clothes_pickup6
ENDIF

IF clothes7_created = 1
    CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 clothes_pickup7
ENDIF

IF clothes8_created = 1
    CREATE_CLOTHES_PICKUP 158.3 -1275.9 10.6 9 clothes_pickup8
ENDIF

IF clothes9_created = 1
    CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup9
ENDIF

IF clothes13_created = 1
    CREATE_CLOTHES_PICKUP 465.3 -57.4 15.7 7 clothes_pickup13
ENDIF

 



MISSION_HAS_FINISHED
RETURN

	
	  											

				////////////////////////////////////////////////	GOSUB pick the cars //////////////////////////////////////////////
pick_a_car:

IF NOT IS_CHAR_DEAD golfped_target
	
	shortest_dist_s1 = 99999.9
	newcar_s1 = -1


	GET_CHAR_COORDINATES golfped_target golfped_lx golfped_ly golfped_lz 

	IF NOT IS_CAR_DEAD golfcart1_s1
		IF NOT IS_CAR_IN_WATER golfcart1_s1
			GET_DRIVER_OF_CAR golfcart1_s1 driver_s1   //driver_s1 driver_s1 driver_s1  
			IF driver_s1 = -1
				IF LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target golfcart1_s1 35.0 35.0 FALSE
					GET_CAR_COORDINATES golfcart1_s1 golfcaddyx_s1 golfcaddyy_s1 golfcaddyz_s1   
					distancetocarx_s1 = golfcaddyx_s1 - golfped_lx
					distancetocary_s1 = golfcaddyy_s1 - golfped_ly
					distance_to_car_s1x = distancetocarx_s1 * distancetocarx_s1
					distance_to_car_s1y = distancetocary_s1 * distancetocary_s1
					how_far_is_car = distance_to_car_s1y + distance_to_car_s1x
					IF how_far_is_car < shortest_dist_s1
					   shortest_dist_s1 = how_far_is_car
					   newcar_s1 = golfcart1_s1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	

	IF NOT IS_CAR_DEAD golfcart2_s1
		IF NOT IS_CAR_IN_WATER golfcart2_s1
			GET_DRIVER_OF_CAR golfcart2_s1 driver_s1   //driver_s1 driver_s1 driver_s1  
			IF driver_s1 = -1
				IF LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target golfcart2_s1 35.0 35.0 FALSE
					GET_CAR_COORDINATES golfcart2_s1 golfcaddyx_s1 golfcaddyy_s1 golfcaddyz_s1   
					distancetocarx_s1 = golfcaddyx_s1 - golfped_lx
					distancetocary_s1 = golfcaddyy_s1 - golfped_ly
					distance_to_car_s1x = distancetocarx_s1 * distancetocarx_s1
					distance_to_car_s1y = distancetocary_s1 * distancetocary_s1
					how_far_is_car = distance_to_car_s1y + distance_to_car_s1x
					IF how_far_is_car < shortest_dist_s1
					   shortest_dist_s1 = how_far_is_car
					   newcar_s1 = golfcart2_s1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
  

	IF NOT IS_CAR_DEAD golfcart3_s1
		IF NOT IS_CAR_IN_WATER golfcart3_s1 
			GET_DRIVER_OF_CAR golfcart3_s1 driver_s1   //driver_s1 driver_s1 driver_s1  
			IF driver_s1 = -1
				IF LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target golfcart3_s1 35.0 35.0 FALSE
					GET_CAR_COORDINATES golfcart3_s1 golfcaddyx_s1 golfcaddyy_s1 golfcaddyz_s1   
					distancetocarx_s1 = golfcaddyx_s1 - golfped_lx
					distancetocary_s1 = golfcaddyy_s1 - golfped_ly
					distance_to_car_s1x = distancetocarx_s1 * distancetocarx_s1
					distance_to_car_s1y = distancetocary_s1 * distancetocary_s1
					how_far_is_car = distance_to_car_s1y + distance_to_car_s1x
					IF how_far_is_car < shortest_dist_s1
					   shortest_dist_s1 = how_far_is_car
					   newcar_s1 = golfcart3_s1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CAR_DEAD golfcart4_s1
		IF NOT IS_CAR_IN_WATER golfcart4_s1
			GET_DRIVER_OF_CAR golfcart4_s1 driver_s1   //driver_s1 driver_s1 driver_s1  
			IF driver_s1 = -1
				IF LOCATE_CHAR_ON_FOOT_CAR_2D golfped_target golfcart4_s1 35.0 35.0 FALSE
					GET_CAR_COORDINATES golfcart4_s1 golfcaddyx_s1 golfcaddyy_s1 golfcaddyz_s1   
					distancetocarx_s1 = golfcaddyx_s1 - golfped_lx
					distancetocary_s1 = golfcaddyy_s1 - golfped_ly
					distance_to_car_s1x = distancetocarx_s1 * distancetocarx_s1
					distance_to_car_s1y = distancetocary_s1 * distancetocary_s1
					how_far_is_car = distance_to_car_s1y + distance_to_car_s1x
					IF how_far_is_car < shortest_dist_s1
					   shortest_dist_s1 = how_far_is_car
					   newcar_s1 = golfcart4_s1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF newcar_s1 = -1
	OR no_of_times_picked_a_new_car > 3
		SET_CHAR_OBJ_NO_OBJ golfped_target
		CHAR_FOLLOW_PATH golfped_target golf_x golf_y golf_z 15.0 RUN
		SET_CHAR_RUNNING golfped_target TRUE
		target_state = 4
		TIMERB = 0
	ELSE
		SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER golfped_target newcar_s1
		SET_CHAR_RUNNING golfped_target TRUE
		target_state = 1
		no_of_times_picked_a_new_car ++
	ENDIF

ENDIF
	
RETURN 
		

}	
	




					
