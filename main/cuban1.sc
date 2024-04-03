MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Cubans Mission 1********************************
// *****************************************Boat Stunt Checkpoint mission*******************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME cuban1
// Mission start stuff
GOSUB mission_start_cuban1
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_cuban1
ENDIF
GOSUB mission_cleanup_cuban1
MISSION_END
 
// Variables for mission
//people, cars and objects
VAR_INT pred_boat
VAR_INT rico_passenger
VAR_INT ramp1
VAR_INT ramp2 
VAR_INT ramp3 
//VAR_INT ramp4 
VAR_INT ramp5 
VAR_INT ramp6 
VAR_INT preddy_boat
VAR_INT fake_caddy
VAR_INT fake_golfer1
VAR_INT fake_golfer2
VAR_INT fake_golfer3
VAR_INT fake_golfer4
//VAR_INT fake_reefer

//blips
VAR_INT boatcheck_blip
VAR_INT next_boatcheck_blip

//flags
VAR_INT boatrace_end 
VAR_INT boat_check_counter
VAR_INT del_ramps
VAR_INT jumpy_flag
VAR_INT boat_col_check 
VAR_INT time_check 
VAR_FLOAT boat_speed
VAR_INT starting_timer 
VAR_INT cub1_speech_played
VAR_INT checks_left
VAR_INT golfer_hit1
VAR_INT golfer_hit2
VAR_INT golfer_hit3
VAR_INT golfer_hit4

//coordinates
VAR_FLOAT boat_check1x
VAR_FLOAT boat_check1y
VAR_FLOAT boat_check1z 
VAR_FLOAT boat_check2x 
VAR_FLOAT boat_check2y 
VAR_FLOAT boat_check2z 
VAR_FLOAT boat_check3x 
VAR_FLOAT boat_check3y 
VAR_FLOAT boat_check3z
VAR_FLOAT boat_check4x 
VAR_FLOAT boat_check4y 
VAR_FLOAT boat_check4z 
VAR_FLOAT boat_check5x 
VAR_FLOAT boat_check5y 
VAR_FLOAT boat_check5z 
VAR_FLOAT boat_check6x 
VAR_FLOAT boat_check6y 
VAR_FLOAT boat_check6z 
VAR_FLOAT boat_check7x 
VAR_FLOAT boat_check7y 
VAR_FLOAT boat_check7z 
VAR_FLOAT boat_check8x 
VAR_FLOAT boat_check8y 
VAR_FLOAT boat_check8z 
VAR_FLOAT boat_check9x 
VAR_FLOAT boat_check9y 
VAR_FLOAT boat_check9z 
VAR_FLOAT boat_check10x 
VAR_FLOAT boat_check10y 
VAR_FLOAT boat_check10z 
VAR_FLOAT boat_check11x 
VAR_FLOAT boat_check11y 
VAR_FLOAT boat_check11z 
VAR_FLOAT boat_check12x 
VAR_FLOAT boat_check12y 
VAR_FLOAT boat_check12z 
VAR_FLOAT boat_check13x 
VAR_FLOAT boat_check13y 
VAR_FLOAT boat_check13z 
VAR_FLOAT boat_check14x 
VAR_FLOAT boat_check14y 
VAR_FLOAT boat_check14z 
VAR_FLOAT boat_check15x 
VAR_FLOAT boat_check15y 
VAR_FLOAT boat_check15z 
VAR_FLOAT boat_check16x 
VAR_FLOAT boat_check16y 
VAR_FLOAT boat_check16z 
VAR_FLOAT boat_check17x 
VAR_FLOAT boat_check17y 
VAR_FLOAT boat_check17z 
VAR_FLOAT boat_check18x 
VAR_FLOAT boat_check18y 
VAR_FLOAT boat_check18z 
VAR_FLOAT boat_check19x 
VAR_FLOAT boat_check19y 
VAR_FLOAT boat_check19z 
VAR_FLOAT boat_check20x 
VAR_FLOAT boat_check20y 
VAR_FLOAT boat_check20z 
VAR_FLOAT boat_check21x 
VAR_FLOAT boat_check21y 
VAR_FLOAT boat_check21z 
VAR_FLOAT boat_check22x 
VAR_FLOAT boat_check22y 
VAR_FLOAT boat_check22z 
VAR_FLOAT boat_check23x 
VAR_FLOAT boat_check23y 
VAR_FLOAT boat_check23z 
VAR_FLOAT boat_check24x 
VAR_FLOAT boat_check24y 
VAR_FLOAT boat_check24z 
VAR_FLOAT boat_check25x 
VAR_FLOAT boat_check25y 
VAR_FLOAT boat_check25z 
VAR_FLOAT boat_check26x 
VAR_FLOAT boat_check26y 
VAR_FLOAT boat_check26z 
VAR_FLOAT boat_check27x 
VAR_FLOAT boat_check27y 
VAR_FLOAT boat_check27z 
VAR_FLOAT boatcheck_blipx 
VAR_FLOAT boatcheck_blipy 
VAR_FLOAT boatcheck_blipz 
VAR_FLOAT next_boatcheck_blipx 
VAR_FLOAT next_boatcheck_blipy 
VAR_FLOAT next_boatcheck_blipz 
VAR_FLOAT camerax
VAR_FLOAT cameray
VAR_FLOAT cameraz
VAR_FLOAT locate1x
VAR_FLOAT locate1y
VAR_FLOAT locate2x
VAR_FLOAT locate2y

// ****************************************Mission Start************************************
mission_start_cuban1:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT CUBAN1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1173.5 -599.6 10.2 277.1
// *****************************************Set Flags/variables************************************

boatcheck_blipx = 0.0 
boatcheck_blipy = 0.0 
boatcheck_blipz = 0.0

next_boatcheck_blipx = 0.0 
next_boatcheck_blipy = 0.0 
next_boatcheck_blipz = 0.0

boatrace_end = 181000

boat_check_counter = 0

del_ramps = 0
jumpy_flag = 0
boat_col_check = 0
boat_speed = 0.0
time_check = 0
starting_timer = 0
cub1_speech_played = 0
checks_left = 27
golfer_hit1 = 0
golfer_hit2 = 0
golfer_hit3 = 0
golfer_hit4 = 0

//CHECKPOINTS

boat_check1x = -102.9375
boat_check1y = 171.7835 
boat_check1z = 5.6727 

boat_check2x = -64.7472 
boat_check2y = 368.7051 
boat_check2z = 5.5050 

boat_check3x = -27.916 
boat_check3y = 482.466 
boat_check3z = 16.0159 

boat_check4x = 183.4692 
boat_check4y = 614.9838 
boat_check4z = 5.7676 

boat_check5x = 239.9839 
boat_check5y = 422.9632 
boat_check5z = 5.9437 

boat_check6x = 196.5818 
boat_check6y = 227.5221 
boat_check6z = 5.9738 

boat_check7x = 336.4845 
boat_check7y = 83.6320 
boat_check7z = 16.0888 

boat_check8x = 417.2411 
boat_check8y = -100.5402
boat_check8z = 15.9255 

boat_check9x = 402.8727 
boat_check9y = -300.6653
boat_check9z = 5.7619 

boat_check10x = 290.0335 
boat_check10y = -460.3196
boat_check10z = 5.9769 

boat_check11x = 181.6709 
boat_check11y = -617.7477
boat_check11z = 5.9921 

boat_check12x = -4.6467  
boat_check12y = -694.4938
boat_check12z = 5.8744 

boat_check13x = -191.9626
boat_check13y = -772.1127
boat_check13z = 5.8744 

boat_check14x = -335.464
boat_check14y = -910.510
boat_check14z = 5.4899 

boat_check15x = -304.464
boat_check15y =	-988.510
boat_check15z =	5.4899 

boat_check16x = -244.464
boat_check16y = -922.510
boat_check16z = 5.4899 

boat_check17x = -144.779
boat_check17y = -845.288
boat_check17z = 6.0213 

boat_check18x = 26.0794 
boat_check18y = -739.893
boat_check18z = 6.0163 

boat_check19x = 154.4145
boat_check19y = -640.624
boat_check19z = 5.3606 

boat_check20x = 304.531 
boat_check20y = -431.591
boat_check20z = 16.0599 

boat_check21x = 413.1744
boat_check21y = -280.507
boat_check21z = 5.9702 

boat_check22x = 423.1779
boat_check22y = -89.6841
boat_check22z = 15.8592 

boat_check23x = 339.5622
boat_check23y = 73.0977 
boat_check23z = 6.0374 

boat_check24x = 198.6796
boat_check24y = 243.2925
boat_check24z = 5.5461 

boat_check25x = 75.6552 
boat_check25y =	401.3978
boat_check25z =	5.6628 

boat_check26x = -95.1011
boat_check26y =	295.7863
boat_check26z =	5.8772 

boat_check27x = -86.3112
boat_check27y =	95.7909 
boat_check27z =	5.6436 

camerax = -4.56
cameray = 456.21
cameraz = 11.51
locate1x = -42.74 
locate1y = 460.99
locate2x = -20.19
locate2y = 464.61

// ****************************************START OF CUTSCENE********************************
SET_AREA_VISIBLE VIS_COFFEE_SHOP
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

CLEAR_AREA_OF_CHARS -1174.8 -609.0 10.4 -116.3 -632.5 15.3
SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

LOAD_SPECIAL_CHARACTER 1 CSplay			  
LOAD_SPECIAL_CHARACTER 2 CSpablo
LOAD_SPECIAL_CHARACTER 3 CSpapa
LOAD_SPECIAL_CHARACTER 4 CSpepe
LOAD_SPECIAL_CHARACTER 5 CSumbto

LOAD_SPECIAL_MODEL CUTOBJ01 ccfan
LOAD_SPECIAL_MODEL CUTOBJ02 lobtray
LOAD_SPECIAL_MODEL CUTOBJ03 espreso

LOAD_SCENE -1169.0 -620.0 10.791
		    
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

LOAD_CUTSCENE cub_1
SET_CUTSCENE_OFFSET -1170.708 -608.327 10.791 
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_pablo
SET_CUTSCENE_ANIM cs_pablo CSpablo

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_papa
SET_CUTSCENE_ANIM cs_papa CSpapa

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_pepe
SET_CUTSCENE_ANIM cs_pepe CSpepe

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_umbto
SET_CUTSCENE_ANIM cs_umbto CSumbto

CREATE_CUTSCENE_OBJECT CUTOBJ01 cc_fan1
SET_CUTSCENE_ANIM_TO_LOOP ccfan
SET_CUTSCENE_ANIM cc_fan1 ccfan 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lobtray
SET_CUTSCENE_ANIM cs_lobtray lobtray 

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_espreso
SET_CUTSCENE_ANIM cs_espreso espreso 

CLEAR_AREA -1170.9 -603.7 10.6 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1170.9 -603.7 10.6

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2145  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW CUB1_A 10000 1 // Si, men?

WHILE cs_time < 3036
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_B 10000 1 // Hey, easy poppa, this man for me. You, you the boy?  

WHILE cs_time < 10501
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_C 10000 1 // Oh yeh. You the boy. I think so, you know?

WHILE cs_time < 14480
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_D 10000 1 // No. I don't think I do.

WHILE cs_time < 16593
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_E 10000 1 // Oh yeah? You come here, tough guy. 

WHILE cs_time < 19202
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_F 10000 1 // You think you can a take me on? 

WHILE cs_time < 20637
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_G 10000 1 // You think you can play stupid with me?

WHILE cs_time < 22441
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_H 10000 1 // No, I think you're playing plenty stupid enough for the both of us.

WHILE cs_time < 24775
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_I 10000 1 // Hey, he call you dumb, son.

WHILE cs_time < 27472
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_J 10000 1 // And I call him a little girl, poppa.

WHILE cs_time < 30348
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_K 10000 1 // Look at him, all dressed up like that.

WHILE cs_time < 33133
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_L 10000 1 // What is this, ladies night?

WHILE cs_time < 35329
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_M 10000 1 // You some big tough guy, you dress like a woman?

WHILE cs_time < 38022
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_N 10000 1 // You got panties like a woman too, huh?

WHILE cs_time < 40251
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_O 10000 1 // What you got against women? You prefer men, big boy?

WHILE cs_time < 42742
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_P 10000 1 // I like women! I like all women! I love my mother, Chico.

WHILE cs_time < 46831
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_Q 10000 1 // Alright, I'll take your word for it.

WHILE cs_time < 51281
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_R 10000 1 // Can you drive, amigo?

WHILE cs_time < 53403
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_S 10000 1 // Yeah... like a woman.

WHILE cs_time < 57539
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_T 10000 1 // Very funny. I like you, big boy. Maybe you can help.

WHILE cs_time < 62464
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_U 10000 1 // Maybe you can prove you a man.

WHILE cs_time < 65377
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE											   

PRINT_NOW CUB1_V 10000 1 // Take out the boat.

WHILE cs_time < 68974
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_W 10000 1 // Show me you got some big cajones,

WHILE cs_time < 71656
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB1_X 10000 1 // and not some little Chiquita ones.
/*
WHILE cs_time < 72656
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
*/
WHILE cs_time < 75392
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

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03 
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_cafe = 0
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0

SET_PLAYER_CONTROL player1 OFF // FIXMIAMI: moved from below because of cutscene
WAIT 500

SET_TIME_OF_DAY 10 0  
//------------------REQUEST_MODELS ------------------------------
REQUEST_MODEL speeder
REQUEST_MODEL CBb
REQUEST_MODEL caddy
REQUEST_MODEL WMYGO
REQUEST_MODEL WFOGO
REQUEST_MODEL reefer

WHILE NOT HAS_MODEL_LOADED speeder 
OR NOT HAS_MODEL_LOADED CBb 
OR NOT HAS_MODEL_LOADED caddy 
OR NOT HAS_MODEL_LOADED WMYGO 
OR NOT HAS_MODEL_LOADED WFOGO 
OR NOT HAS_MODEL_LOADED reefer 
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 1 CUB1_9	
LOAD_MISSION_AUDIO 2 COL3_2b  

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

//forcing weather to be nice
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY

//switching off ped nodes
SWITCH_ROADS_OFF 130.4 368.4 50.7 -228.4 724.5 0.0  


/////////////test/////////////////////////////
LOAD_SCENE -74.17 90.20 9.67
REQUEST_COLLISION -67.7 91.2 
SET_PLAYER_COORDINATES player1 -67.7 91.2 9.5
TURN_CHAR_TO_FACE_COORD scplayer -74.17 90.20 8.6 // FIXMIAMI
WAIT 300 // FIXMIAMI

//creating boat and waiting for player to reach it 
CREATE_CHAR PEDTYPE_GANG_CUBAN CBb -74.17 90.20 8.6 rico_passenger 
SET_CHAR_AS_PLAYER_FRIEND rico_passenger player1 TRUE
SET_CHAR_HEADING rico_passenger 40.2 

//creating golf fluff
CREATE_CAR caddy -31.7 484.9 7.3 fake_caddy
SET_CAR_HEADING fake_caddy 205.8 
CREATE_CHAR PEDTYPE_CIVMALE WMYGO -29.5 483.6 7.7 fake_golfer1 
SET_CHAR_HEADING fake_golfer1 11.0 
SET_CHAR_HEALTH fake_golfer1 10 
CREATE_CHAR PEDTYPE_CIVMALE WMYGO -27.2 484.1 7.7 fake_golfer2 
SET_CHAR_HEADING fake_golfer2 77.0 
SET_CHAR_HEALTH fake_golfer2 10 
CREATE_CHAR PEDTYPE_CIVFEMALE WFOGO -29.9 484.4 7.7 fake_golfer3 
SET_CHAR_HEADING fake_golfer3 282.0 
SET_CHAR_HEALTH fake_golfer3 10 
CREATE_CHAR PEDTYPE_CIVFEMALE WFOGO -28.4 486.3 7.7 fake_golfer4 
SET_CHAR_HEADING fake_golfer4 176.0 
SET_CHAR_HEALTH fake_golfer4 10 

/*
CREATE_CAR reefer -192.0 -771.1 5.4 fake_reefer
SET_CAR_HEADING fake_reefer 181.0
ANCHOR_BOAT fake_reefer TRUE  
*/
SET_CHARS_CHATTING fake_golfer1 fake_golfer2 86400000 
SET_CHARS_CHATTING fake_golfer3 fake_golfer4 86400000 

DO_FADE 1500 FADE_IN
// ******************************************START OF PLAYER GETTING INTO BOAT*******************************************
//SET_PLAYER_CONTROL player1 OFF // FIXMIAMI - moved up

SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -67.34 85.31 10.02 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -86.40 117.01 13.04 JUMP_CUT

WAIT 1000

IF NOT IS_CHAR_DEAD rico_passenger
	SET_CHAR_OBJ_GOTO_CHAR_ON_FOOT scplayer rico_passenger
ENDIF 

WAIT 2000

PRINT_NOW CUB1_01 4000 1//Hey, I'm Rico. You the man with the cajones?
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD rico_passenger  
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB1_01 

//SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

PRINT_NOW GEN3_4 4000 1//Tommy Vercetti. Let's go...
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT GEN3_4 

//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100

LOAD_MISSION_AUDIO 1 CUB1_10	

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

PRINT_NOW CUB1_02 4000 1//Ok man, treat her like a woman.
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD rico_passenger  
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub1_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB1_02 

end_cut_cub1_1:
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS
//SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
//IF NOT IS_CHAR_DEAD rico_passenger 
	//SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
//ENDIF
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
// ******************************************END OF PLAYER GETTING INTO BOAT*********************************************

//FADE OUT 
SET_FADING_COLOUR 1 1 1
DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CREATE_CAR speeder -90.9 105.1 5.0 pred_boat
SET_CAR_HEADING pred_boat 9.2
ANCHOR_BOAT pred_boat TRUE
												  
IF NOT IS_CAR_DEAD pred_boat
	
	WARP_PLAYER_INTO_CAR player1 pred_boat 

	IF NOT IS_CHAR_DEAD rico_passenger 
		ATTACH_CHAR_TO_CAR rico_passenger pred_boat 0.0 1.8 1.2 FACING_FORWARD 360.0 WEAPONTYPE_UNARMED     ////speeder
		TURN_CHAR_TO_FACE_CHAR rico_passenger scplayer 
	ELSE
		PRINT_NOW ( CUB1_11 ) 5000 1 //You Killed Rico!
		DO_FADE 1500 FADE_IN
		GOTO mission_failed_cuban1
	ENDIF 
ELSE
	PRINT_NOW ( CUB1_11 ) 5000 1 //You Killed Rico!
	DO_FADE 1500 FADE_IN
	GOTO mission_failed_cuban1
ENDIF

SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON


//setting up checkpoints
boatcheck_blipx = boat_check1x  
boatcheck_blipy = boat_check1y  
boatcheck_blipz = boat_check1z 
next_boatcheck_blipx = boat_check2x 
next_boatcheck_blipy = boat_check2y 
next_boatcheck_blipz = boat_check2z

ADD_BLIP_FOR_COORD boatcheck_blipx boatcheck_blipy boatcheck_blipz boatcheck_blip
CHANGE_BLIP_COLOUR boatcheck_blip YELLOW  
ADD_BLIP_FOR_COORD next_boatcheck_blipx next_boatcheck_blipy next_boatcheck_blipz next_boatcheck_blip
CHANGE_BLIP_COLOUR next_boatcheck_blip YELLOW  
CHANGE_BLIP_SCALE next_boatcheck_blip 2
DIM_BLIP next_boatcheck_blip TRUE

//creating fluff
CREATE_OBJECT waterjumpx2 -34.26 455.90 5.5 ramp1  
SET_OBJECT_HEADING ramp1 343.60 
SET_OBJECT_COLLISION ramp1 TRUE

CREATE_OBJECT waterjumpx2 312.200 107.669 5.5 ramp2	
SET_OBJECT_HEADING ramp2 230.88
SET_OBJECT_COLLISION ramp2 TRUE

CREATE_OBJECT waterjumpx2 414.5 -79.8 5.5 ramp3	
SET_OBJECT_HEADING ramp3 184.9 
SET_OBJECT_COLLISION ramp3 TRUE

/*
CREATE_OBJECT waterjump1 -176.0 -763.5 5.5 ramp4	
SET_OBJECT_HEADING ramp4 121.4 
SET_OBJECT_COLLISION ramp4 TRUE
*/

DO_FADE 1500 FADE_IN


PRINT_NOW ( CUB1_12 ) 5000 1 //Go through the first checkpoint to begin the test.
PRINT ( CUB1_13 ) 5000 1 //You have three minutes to get round the course.


boat_loop://///////////////////////////////////////////////////////////////////////////////////

WAIT 0

CLEAR_AREA_OF_CARS -185.35 -738.31 0.0 -150.63 -785.11 15.0   		

IF boat_check_counter < 4 
	IF golfer_hit1 = 0
		IF IS_CHAR_DEAD fake_golfer1 
			PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ADD_SCORE player1 100
			golfer_hit1 = 1
		ENDIF
	ENDIF
	/*
	IF golfer_hit2 = 0
		IF IS_CHAR_DEAD fake_golfer2 
			PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ADD_SCORE player1 100
			golfer_hit2 = 1
		ENDIF
	ENDIF
	IF golfer_hit3 = 0
		IF IS_CHAR_DEAD fake_golfer3 
			PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ADD_SCORE player1 100
			golfer_hit3 = 1
		ENDIF
	ENDIF
	IF golfer_hit4 = 0
		IF IS_CHAR_DEAD fake_golfer4 
			PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			ADD_SCORE player1 100
			golfer_hit4 = 1
		ENDIF
	ENDIF
	*/
ENDIF


IF boat_check_counter = 4
	IF NOT IS_CHAR_DEAD fake_golfer1
		SET_CHAR_STAY_IN_SAME_PLACE fake_golfer1 TRUE
	ENDIF  
	IF NOT IS_CHAR_DEAD fake_golfer2
		SET_CHAR_STAY_IN_SAME_PLACE fake_golfer2 TRUE
	ENDIF  
	IF NOT IS_CHAR_DEAD fake_golfer3
		SET_CHAR_STAY_IN_SAME_PLACE fake_golfer3 TRUE
	ENDIF  
	IF NOT IS_CHAR_DEAD fake_golfer4
		SET_CHAR_STAY_IN_SAME_PLACE fake_golfer4 TRUE
	ENDIF  
ENDIF

IF NOT IS_CAR_DEAD pred_boat 
	IF IS_PLAYER_IN_AREA_2D player1 locate1x locate1y locate2x locate2y FALSE
		
		IF boat_check_counter = 2
			IF NOT IS_CHAR_DEAD fake_golfer1
				SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE fake_golfer1
			ENDIF  
			IF NOT IS_CHAR_DEAD fake_golfer2
				SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE fake_golfer2
			ENDIF  
			IF NOT IS_CHAR_DEAD fake_golfer3
				SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE fake_golfer3
			ENDIF  
			IF NOT IS_CHAR_DEAD fake_golfer4
				SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE fake_golfer4
			ENDIF  
		ENDIF
		
		IF IS_PLAYER_IN_ANY_CAR player1  
			
			STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 preddy_boat
			GET_CAR_SPEED preddy_boat boat_speed
			
			IF NOT IS_CAR_IN_WATER preddy_boat
			    IF boat_speed > 15.0
				    jumpy_flag = 1
				ENDIF
			ENDIF
			
			IF jumpy_flag = 1 
				
				SET_TIME_SCALE 0.3
				SET_FIXED_CAMERA_POSITION camerax cameray cameraz 0.0 0.0 0.0
				POINT_CAMERA_AT_CAR preddy_boat FIXED JUMP_CUT

				WHILE NOT IS_CAR_IN_WATER preddy_boat
					WAIT 0
					time_check ++
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0	
					IF boat_col_check = 0
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 boatcheck_blipx boatcheck_blipy boatcheck_blipz 7.0 7.0 7.0 FALSE
							REMOVE_BLIP boatcheck_blip
							REMOVE_BLIP next_boatcheck_blip
							
							++ boat_check_counter
							-- checks_left

							ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

							IF boat_check_counter = 3
								camerax = 369.99
								cameray = 74.30
								cameraz = 8.66
								locate1x = 308.57 
								locate1y = 99.09
								locate2x = 340.835
								locate2y = 107.66
								boatcheck_blipx = boat_check4x  
								boatcheck_blipy = boat_check4y  
								boatcheck_blipz = boat_check4z 
								next_boatcheck_blipx = boat_check5x 
								next_boatcheck_blipy = boat_check5y 
								next_boatcheck_blipz = boat_check5z
							ENDIF
							
							IF boat_check_counter = 7 		
								camerax = 396.14
								cameray = -90.01
								cameraz = 11.48
								locate1x = 421.73 
								locate1y = -83.21
								locate2x = 403.83
								locate2y = -91.97
								boatcheck_blipx = boat_check8x  
								boatcheck_blipy = boat_check8y  
								boatcheck_blipz = boat_check8z 
								next_boatcheck_blipx = boat_check9x 
								next_boatcheck_blipy = boat_check9y 
								next_boatcheck_blipz = boat_check9z
							ENDIF

							IF boat_check_counter = 8 		
								camerax = -194.5
								cameray = -783.5
								cameraz = 9.2
								locate1x = -183.166 
								locate1y = -756.844
								locate2x = -181.80
								locate2y = -780.26
								boatcheck_blipx = boat_check9x  
								boatcheck_blipy = boat_check9y  
								boatcheck_blipz = boat_check9z 
								next_boatcheck_blipx = boat_check10x 
								next_boatcheck_blipy = boat_check10y 
								next_boatcheck_blipz = boat_check10z
							ENDIF
							
							IF boat_check_counter = 20 		
								camerax = 435.65
								cameray = -98.08
								cameraz = 11.97
								locate1x = 409.80 
								locate1y = -109.11
								locate2x = 433.46
								locate2y = -100.21
								boatcheck_blipx = boat_check21x  
								boatcheck_blipy = boat_check21y  
								boatcheck_blipz = boat_check21z 
								next_boatcheck_blipx = boat_check22x 
								next_boatcheck_blipy = boat_check22y 
								next_boatcheck_blipz = boat_check22z
							ENDIF

							IF boat_check_counter = 22 		
								boatcheck_blipx = boat_check23x  
								boatcheck_blipy = boat_check23y  
								boatcheck_blipz = boat_check23z 
								next_boatcheck_blipx = boat_check24x 
								next_boatcheck_blipy = boat_check24y 
								next_boatcheck_blipz = boat_check24z
							ENDIF
						
							ADD_BLIP_FOR_COORD boatcheck_blipx boatcheck_blipy boatcheck_blipz boatcheck_blip
							CHANGE_BLIP_COLOUR boatcheck_blip YELLOW
							ADD_BLIP_FOR_COORD next_boatcheck_blipx next_boatcheck_blipy next_boatcheck_blipz next_boatcheck_blip
							CHANGE_BLIP_COLOUR next_boatcheck_blip YELLOW
							CHANGE_BLIP_SCALE next_boatcheck_blip 2
							DIM_BLIP next_boatcheck_blip TRUE
							boat_col_check = 1
						ENDIF
					ENDIF
					IF IS_CAR_DEAD preddy_boat
						GOTO restore_if_failed
					ENDIF
					IF NOT IS_PLAYER_PLAYING player1
						GOTO restore_if_failed
					ENDIF
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						GOTO restore_if_failed
					ENDIF
					IF IS_CAR_STOPPED preddy_boat
						GOTO restore_if_failed
					ENDIF
					IF time_check > 1000 
						GOTO restore_if_failed
					ENDIF
				ENDWHILE
				restore_if_failed:
				SET_TIME_SCALE 1.0
				RESTORE_CAMERA_JUMPCUT
				jumpy_flag = 0
				boat_col_check = 0
				time_check = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF boat_check_counter = 26
	DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
ELSE
	DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
ENDIF

IF boat_check_counter = 1
	IF starting_timer = 0
		DISPLAY_ONSCREEN_TIMER_WITH_STRING boatrace_end TIMER_DOWN RACES
		DISPLAY_ONSCREEN_COUNTER_WITH_STRING checks_left 0 KICK1_9
		starting_timer = 1
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD pred_boat 
	IF IS_PLAYER_IN_CAR player1 pred_boat 
		IF cub1_speech_played = 0  
			IF boat_check_counter > 1 
				LOAD_MISSION_AUDIO 1 CUB1_3	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_05 4000 1//Amigo, you a man, man.
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_05
				cub1_speech_played = 1
			ENDIF
		ENDIF

		IF cub1_speech_played = 1  
			IF boat_check_counter > 4 
				LOAD_MISSION_AUDIO 1 CUB1_4	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_06 4000 1//Call yourself a man, man?
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_06
				cub1_speech_played = 2
			ENDIF
		ENDIF
			 
		IF cub1_speech_played = 2  
			IF boat_check_counter > 9 
				LOAD_MISSION_AUDIO 1 CUB1_5	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_07 5000 1//You a little scaredy kitten, baby boy, go cry to your mommy? // FIXMIAMI: change 4000 to 5000
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_07
				cub1_speech_played = 3
			ENDIF
		ENDIF

		IF cub1_speech_played = 3  
			IF boat_check_counter > 15 
				LOAD_MISSION_AUDIO 1 CUB1_1	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_03 4000 1//Not bad, you a real man.
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_03
				cub1_speech_played = 4
			ENDIF
		ENDIF

		IF cub1_speech_played = 4  
			IF boat_check_counter > 22
				LOAD_MISSION_AUDIO 1 CUB1_7	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_09 6000 1//Man, you the man, man. I like you, man. I like you a lot. // FIXMIAMI: change 4000 to 6000
				

				/*
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				*/
				PLAY_MISSION_AUDIO 1
				/*
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_09
				*/
				cub1_speech_played = 5
			ENDIF
		ENDIF

		IF cub1_speech_played = 5  
			IF boat_check_counter > 23 
				LOAD_MISSION_AUDIO 1 CUB1_8	
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
					GOSUB set_ricos_heading // FIXMIAMI
				ENDWHILE 
				PRINT_NOW CUB1_10 6000 1//Any time, man. 'cause you got cajones. And all my friends have big cajones. // FIXMIAMI: change 4000 to 6000
				
				/*
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_PLAYANIM_CHAT 10000
				ENDIF
				*/
				PLAY_MISSION_AUDIO 1
				/*
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD rico_passenger  
					WAIT 0
					DRAW_CORONA boatcheck_blipx boatcheck_blipy boatcheck_blipz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				
				IF NOT IS_CHAR_DEAD rico_passenger 
					SET_CHAR_WAIT_STATE rico_passenger WAITSTATE_FALSE 100
				ENDIF

				CLEAR_THIS_PRINT CUB1_10
				*/
				cub1_speech_played = 6
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOSUB set_ricos_heading // FIXMIAMI

IF NOT IS_CAR_DEAD pred_boat
	IF NOT IS_CHAR_DEAD rico_passenger  
		IF IS_PLAYER_IN_CAR player1 pred_boat
			CLEAR_THIS_PRINT CUB1_14
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 boatcheck_blipx boatcheck_blipy boatcheck_blipz 7.0 7.0 7.0 FALSE

				++ boat_check_counter
				-- checks_left

				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE

				REMOVE_BLIP boatcheck_blip
				REMOVE_BLIP next_boatcheck_blip
  				
  				IF boat_check_counter = 1
					boatcheck_blipx = boat_check2x  
					boatcheck_blipy = boat_check2y  
					boatcheck_blipz = boat_check2z 
					next_boatcheck_blipx = boat_check3x 
					next_boatcheck_blipy = boat_check3y 
					next_boatcheck_blipz = boat_check3z
				ENDIF

				IF boat_check_counter = 2
					boatcheck_blipx = boat_check3x  
					boatcheck_blipy = boat_check3y  
					boatcheck_blipz = boat_check3z 
					next_boatcheck_blipx = boat_check4x 
					next_boatcheck_blipy = boat_check4y 
					next_boatcheck_blipz = boat_check4z
				ENDIF

				IF boat_check_counter = 3
					camerax = 369.99
					cameray = 74.30
					cameraz = 8.66
					locate1x = 308.57 
					locate1y = 99.09
					locate2x = 340.835
					locate2y = 107.66
					boatcheck_blipx = boat_check4x  
					boatcheck_blipy = boat_check4y  
					boatcheck_blipz = boat_check4z 
					next_boatcheck_blipx = boat_check5x 
					next_boatcheck_blipy = boat_check5y 
					next_boatcheck_blipz = boat_check5z
				ENDIF
				
				IF boat_check_counter = 4
					MARK_CAR_AS_NO_LONGER_NEEDED fake_caddy 
					MARK_CHAR_AS_NO_LONGER_NEEDED fake_golfer1 
					MARK_CHAR_AS_NO_LONGER_NEEDED fake_golfer2 
					MARK_CHAR_AS_NO_LONGER_NEEDED fake_golfer3 
					MARK_CHAR_AS_NO_LONGER_NEEDED fake_golfer4 
					boatcheck_blipx = boat_check5x  
					boatcheck_blipy = boat_check5y  
					boatcheck_blipz = boat_check5z 
					next_boatcheck_blipx = boat_check6x 
					next_boatcheck_blipy = boat_check6y 
					next_boatcheck_blipz = boat_check6z
				ENDIF		
					
				IF boat_check_counter = 5 		
					boatcheck_blipx = boat_check6x  
					boatcheck_blipy = boat_check6y  
					boatcheck_blipz = boat_check6z 
					next_boatcheck_blipx = boat_check7x 
					next_boatcheck_blipy = boat_check7y 
					next_boatcheck_blipz = boat_check7z
				ENDIF
				
				IF boat_check_counter = 6 		
					boatcheck_blipx = boat_check7x  
					boatcheck_blipy = boat_check7y  
					boatcheck_blipz = boat_check7z 
					next_boatcheck_blipx = boat_check8x 
					next_boatcheck_blipy = boat_check8y 
					next_boatcheck_blipz = boat_check8z
				ENDIF

				IF boat_check_counter = 7 		
					camerax = 396.14
					cameray = -90.01
					cameraz = 11.48
					locate1x = 421.73 
					locate1y = -83.21
					locate2x = 403.83
					locate2y = -91.97
					boatcheck_blipx = boat_check8x  
					boatcheck_blipy = boat_check8y  
					boatcheck_blipz = boat_check8z 
					next_boatcheck_blipx = boat_check9x 
					next_boatcheck_blipy = boat_check9y 
					next_boatcheck_blipz = boat_check9z
				ENDIF

				IF boat_check_counter = 8 		
					camerax = -194.5
					cameray = -783.5
					cameraz = 9.2
					locate1x = -183.166 
					locate1y = -756.844
					locate2x = -181.80
					locate2y = -780.26
					boatcheck_blipx = boat_check9x  
					boatcheck_blipy = boat_check9y  
					boatcheck_blipz = boat_check9z 
					next_boatcheck_blipx = boat_check10x 
					next_boatcheck_blipy = boat_check10y 
					next_boatcheck_blipz = boat_check10z
				ENDIF
				
				IF boat_check_counter = 9 		
					boatcheck_blipx = boat_check10x  
					boatcheck_blipy = boat_check10y  
					boatcheck_blipz = boat_check10z 
					next_boatcheck_blipx = boat_check11x 
					next_boatcheck_blipy = boat_check11y 
					next_boatcheck_blipz = boat_check11z
				ENDIF

				IF boat_check_counter = 10 		
					boatcheck_blipx = boat_check11x  
					boatcheck_blipy = boat_check11y  
					boatcheck_blipz = boat_check11z 
					next_boatcheck_blipx = boat_check12x 
					next_boatcheck_blipy = boat_check12y 
					next_boatcheck_blipz = boat_check12z
				ENDIF

				IF boat_check_counter = 11 		
					boatcheck_blipx = boat_check12x  
					boatcheck_blipy = boat_check12y  
					boatcheck_blipz = boat_check12z 
					next_boatcheck_blipx = boat_check13x 
					next_boatcheck_blipy = boat_check13y 
					next_boatcheck_blipz = boat_check13z
				ENDIF

				IF boat_check_counter = 12 		
					boatcheck_blipx = boat_check13x  
					boatcheck_blipy = boat_check13y  
					boatcheck_blipz = boat_check13z 
					next_boatcheck_blipx = boat_check14x 
					next_boatcheck_blipy = boat_check14y 
					next_boatcheck_blipz = boat_check14z
				ENDIF

				IF boat_check_counter = 13 		
					boatcheck_blipx = boat_check14x  
					boatcheck_blipy = boat_check14y  
					boatcheck_blipz = boat_check14z 
					next_boatcheck_blipx = boat_check15x 
					next_boatcheck_blipy = boat_check15y 
					next_boatcheck_blipz = boat_check15z
				ENDIF

				IF boat_check_counter = 14
					IF del_ramps = 0
						DELETE_OBJECT ramp1 		
						DELETE_OBJECT ramp2 		
						DELETE_OBJECT ramp3 		
						//DELETE_OBJECT ramp4 
						//MARK_CAR_AS_NO_LONGER_NEEDED fake_reefer
						CREATE_OBJECT waterjump1 295.2 -446.2 5.5 ramp1  
						SET_OBJECT_HEADING ramp1 326.50 
						SET_OBJECT_COLLISION ramp1 TRUE
						CREATE_OBJECT waterjumpx2 421.200 -112.669 5.5 ramp2	
						SET_OBJECT_HEADING ramp2 356.88
						SET_OBJECT_COLLISION ramp2 TRUE
						del_ramps = 1
					ENDIF		
					boatcheck_blipx = boat_check15x  
					boatcheck_blipy = boat_check15y  
					boatcheck_blipz = boat_check15z 
					next_boatcheck_blipx = boat_check16x 
					next_boatcheck_blipy = boat_check16y 
					next_boatcheck_blipz = boat_check16z
				ENDIF

				IF boat_check_counter = 15 		
					boatcheck_blipx = boat_check16x  
					boatcheck_blipy = boat_check16y  
					boatcheck_blipz = boat_check16z 
					next_boatcheck_blipx = boat_check17x 
					next_boatcheck_blipy = boat_check17y 
					next_boatcheck_blipz = boat_check17z
				ENDIF

				IF boat_check_counter = 16 		
					boatcheck_blipx = boat_check17x  
					boatcheck_blipy = boat_check17y  
					boatcheck_blipz = boat_check17z 
					next_boatcheck_blipx = boat_check18x 
					next_boatcheck_blipy = boat_check18y 
					next_boatcheck_blipz = boat_check18z
				ENDIF

				IF boat_check_counter = 17 		
					boatcheck_blipx = boat_check18x  
					boatcheck_blipy = boat_check18y  
					boatcheck_blipz = boat_check18z 
					next_boatcheck_blipx = boat_check19x 
					next_boatcheck_blipy = boat_check19y 
					next_boatcheck_blipz = boat_check19z
				ENDIF

				IF boat_check_counter = 18
					boatcheck_blipx = boat_check19x  
					boatcheck_blipy = boat_check19y  
					boatcheck_blipz = boat_check19z 
					next_boatcheck_blipx = boat_check20x 
					next_boatcheck_blipy = boat_check20y 
					next_boatcheck_blipz = boat_check20z
				ENDIF
				
				IF boat_check_counter = 19
					boatcheck_blipx = boat_check20x  
					boatcheck_blipy = boat_check20y  
					boatcheck_blipz = boat_check20z 
					next_boatcheck_blipx = boat_check21x 
					next_boatcheck_blipy = boat_check21y 
					next_boatcheck_blipz = boat_check21z
				ENDIF

				IF boat_check_counter = 20 		
					boatcheck_blipx = boat_check21x  
					boatcheck_blipy = boat_check21y  
					boatcheck_blipz = boat_check21z 
					next_boatcheck_blipx = boat_check22x 
					next_boatcheck_blipy = boat_check22y 
					next_boatcheck_blipz = boat_check22z
				ENDIF

				IF boat_check_counter = 21 		
					boatcheck_blipx = boat_check22x  
					boatcheck_blipy = boat_check22y  
					boatcheck_blipz = boat_check22z 
					next_boatcheck_blipx = boat_check23x 
					next_boatcheck_blipy = boat_check23y 
					next_boatcheck_blipz = boat_check23z
				ENDIF

				IF boat_check_counter = 22 		
					boatcheck_blipx = boat_check23x  
					boatcheck_blipy = boat_check23y  
					boatcheck_blipz = boat_check23z 
					next_boatcheck_blipx = boat_check24x 
					next_boatcheck_blipy = boat_check24y 
					next_boatcheck_blipz = boat_check24z
				ENDIF

				IF boat_check_counter = 23 		
					boatcheck_blipx = boat_check24x  
					boatcheck_blipy = boat_check24y  
					boatcheck_blipz = boat_check24z 
					next_boatcheck_blipx = boat_check25x 
					next_boatcheck_blipy = boat_check25y 
					next_boatcheck_blipz = boat_check25z
				ENDIF

				IF boat_check_counter = 24 		
					boatcheck_blipx = boat_check25x  
					boatcheck_blipy = boat_check25y  
					boatcheck_blipz = boat_check25z 
					next_boatcheck_blipx = boat_check26x 
					next_boatcheck_blipy = boat_check26y 
					next_boatcheck_blipz = boat_check26z
				ENDIF

				IF boat_check_counter = 25 		
					boatcheck_blipx = boat_check26x  
					boatcheck_blipy = boat_check26y  
					boatcheck_blipz = boat_check26z 
					next_boatcheck_blipx = boat_check27x 
					next_boatcheck_blipy = boat_check27y 
					next_boatcheck_blipz = boat_check27z
				ENDIF

				IF boat_check_counter = 26 		
					boatcheck_blipx = boat_check27x  
					boatcheck_blipy = boat_check27y  
					boatcheck_blipz = boat_check27z 
				ENDIF

				IF boat_check_counter = 27 		
					SET_PLAYER_CONTROL player1 OFF
					IF NOT IS_CAR_DEAD pred_boat
						SET_CAR_TEMP_ACTION pred_boat TEMPACT_HANDBRAKESTRAIGHT 10000
						SET_BOAT_CRUISE_SPEED pred_boat 0.0
						ANCHOR_BOAT pred_boat TRUE 
					ENDIF 

					//FADE OUT 
					SET_FADING_COLOUR 1 1 1
					DO_FADE 1500 FADE_OUT

					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE

					CLEAR_ONSCREEN_TIMER boatrace_end

					WAIT 1000

					IF NOT IS_CAR_DEAD pred_boat
						WARP_PLAYER_FROM_CAR_TO_COORD player1 -79.3 82.22 8.6
						SET_PLAYER_HEADING player1 120.75 
						IF NOT IS_CHAR_DEAD rico_passenger 
							DETACH_CHAR_FROM_CAR rico_passenger
							DELETE_CHAR rico_passenger 
							SET_CAR_COORDINATES pred_boat -84.5 82.7 5.1 
							SET_CAR_HEADING pred_boat 180.0  
							CREATE_CHAR_INSIDE_CAR pred_boat PEDTYPE_GANG_CUBAN CBb rico_passenger 
						ENDIF 
					ENDIF

					// FIXMIAMI: START - stop the boat again cuz dude might take off randomly
					IF NOT IS_CAR_DEAD pred_boat
						SET_BOAT_CRUISE_SPEED pred_boat 0.0
						ANCHOR_BOAT pred_boat TRUE 
					ENDIF 
					// FIXMIAMI: END - stop the boat again cuz dude might take off randomly
	

					DO_FADE 1500 FADE_IN

// ******************************************START OF PLAYER GETTING OUT OF BOAT*******************************************
					SWITCH_WIDESCREEN ON

					SET_FIXED_CAMERA_POSITION -75.82 83.66 11.59 0.0 0.0 0.0 
					POINT_CAMERA_AT_POINT -80.32 82.60 9.96 JUMP_CUT

					WAIT 1000

					LOAD_MISSION_AUDIO 1 CUB1_2	

					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
					ENDWHILE 

					PRINT_NOW CUB1_04 4000 1//Men, you got big cajones, amigo.
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD rico_passenger  
						WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT CUB1_04 
					IF NOT IS_CAR_DEAD pred_boat 
						SET_CAR_FORWARD_SPEED pred_boat 40.0 
					ENDIF

					WAIT 1500 // FIXMIAMI

					MARK_MODEL_AS_NO_LONGER_NEEDED speeder
					MARK_MODEL_AS_NO_LONGER_NEEDED CBb
					
					SET_CAMERA_BEHIND_PLAYER // FIXMIAMI
					RESTORE_CAMERA_JUMPCUT
					
					SET_PLAYER_CONTROL player1 ON
					SWITCH_WIDESCREEN OFF
// ******************************************END OF PLAYER GETTING OUT OF BOAT*********************************************
					GOTO mission_passed_cuban1 
				ENDIF

				ADD_BLIP_FOR_COORD boatcheck_blipx boatcheck_blipy boatcheck_blipz boatcheck_blip
				IF boat_check_counter < 26 // FIXMIAMI
					CHANGE_BLIP_COLOUR boatcheck_blip YELLOW
					ADD_BLIP_FOR_COORD next_boatcheck_blipx next_boatcheck_blipy next_boatcheck_blipz next_boatcheck_blip
					CHANGE_BLIP_COLOUR next_boatcheck_blip YELLOW
					CHANGE_BLIP_SCALE next_boatcheck_blip 2
					DIM_BLIP next_boatcheck_blip TRUE
				ELSE // FIXMIAMI
					CHANGE_BLIP_COLOUR boatcheck_blip RED // FIXMIAMI
				ENDIF // FIXMIAMI
				
			ENDIF
		ELSE
			PRINT_NOW ( CUB1_14 ) 5000 1 //Get back in the boat!
		ENDIF
	ELSE
		PRINT_NOW ( CUB1_11 ) 5000 1 //You Killed Rico!
		DELETE_CHAR rico_passenger
		GOTO mission_failed_cuban1 
	ENDIF
ELSE
	PRINT_NOW ( CUB1_11 ) 5000 1 //You Killed Rico!
	DELETE_CHAR rico_passenger
	GOTO mission_failed_cuban1
ENDIF

IF boatrace_end = 0
	IF NOT IS_CAR_DEAD pred_boat 
		LOAD_MISSION_AUDIO 1 CUB1_6	
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW CUB1_08 4000 1//You a big waste of space. Walk like a man, talk like a man, but you drive like and idiot.
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		AND NOT IS_CHAR_DEAD rico_passenger  
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT CUB1_08
		IF NOT IS_CHAR_DEAD rico_passenger 
			//DETACH_CHAR_FROM_CAR rico_passenger
			REMOVE_CHAR_ELEGANTLY rico_passenger 
		ENDIF

		PRINT_NOW ( CUB1_15 ) 5000 1 //You are too slow, man.
		
		GOTO mission_failed_cuban1
	ENDIF
ENDIF 


IF NOT IS_CAR_DEAD pred_boat 
	IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 pred_boat 15.0 15.0 FALSE 
		IF NOT IS_CHAR_DEAD rico_passenger 
			//DETACH_CHAR_FROM_CAR rico_passenger 
			REMOVE_CHAR_ELEGANTLY rico_passenger 
		ENDIF
		PRINT_NOW T4X4_F 5000 1//You bailed! Too tough for you?!
		GOTO mission_failed_cuban1
	ENDIF
ENDIF
		 

GOTO boat_loop////////////////////////////////////////////////////////////




// Mission failed
mission_failed_cuban1:

 
PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_cuban1:
DELETE_CHAR rico_passenger // FIXMIAMI
DELETE_CAR pred_boat // FIXMIAMI
CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 1000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED CUB_1
START_NEW_SCRIPT cuban_mission2_loop
flag_cuban_mission1_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_cuban1:
CLEAR_THIS_PRINT CUB1_13 // FIXMIAMI
flag_player_on_mission = 0
SWITCH_ROADS_ON 130.4 368.4 50.7 -228.4 724.5 0.0  
SET_PLAYER_CONTROL player1 on
//IF flag_cuban_mission1_passed = 0 
	DELETE_OBJECT ramp1 		
	DELETE_OBJECT ramp2 		
	DELETE_OBJECT ramp3 		
	//DELETE_OBJECT ramp4 
//ENDIF
MARK_MODEL_AS_NO_LONGER_NEEDED speeder
MARK_MODEL_AS_NO_LONGER_NEEDED CBb
MARK_MODEL_AS_NO_LONGER_NEEDED caddy
MARK_MODEL_AS_NO_LONGER_NEEDED WMYGO
MARK_MODEL_AS_NO_LONGER_NEEDED WFOGO
MARK_MODEL_AS_NO_LONGER_NEEDED reefer
REMOVE_BLIP boatcheck_blip
REMOVE_BLIP next_boatcheck_blip
CLEAR_ONSCREEN_TIMER boatrace_end
CLEAR_ONSCREEN_COUNTER checks_left
GET_GAME_TIMER timer_mobile_start
RELEASE_WEATHER
MISSION_HAS_FINISHED
RETURN

		 
 
// FIXMIAMI: START
set_ricos_heading:
{
	LVAR_FLOAT temp_boat_heading
	IF NOT IS_CHAR_DEAD rico_passenger
	AND NOT IS_CAR_DEAD pred_boat
		GET_CAR_HEADING pred_boat temp_boat_heading
		SET_CHAR_HEADING rico_passenger temp_boat_heading
	ENDIF
	RETURN
}
// FIXMIAMI: END
